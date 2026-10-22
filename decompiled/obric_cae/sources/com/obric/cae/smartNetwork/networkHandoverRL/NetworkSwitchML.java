package com.obric.cae.smartNetwork.networkHandoverRL;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.util.AtomicFile;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.log.CaeLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import org.tensorflow.lite.d;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSwitchML {
    private static final String ASSET_INIT_WEIGHTS_NAME = "network_switch_init_weights.json";
    private static final String ASSET_MODEL_NAME = "network_switch.tflite";
    private static final int MAX_PATIENCE = 40;
    private static final int MIN_PATIENCE = 20;
    private static final String SAVED_WEIGHTS_FILE = "network_switch_trained.json";
    private static final String TAG = "NetworkSwitchML";
    private static volatile NetworkSwitchML sInstance;
    private static final float[] scalerMax = null;
    private static final float[] scalerMin = null;
    private final Context context;
    private volatile Weights mActiveWeights;
    private float[] mDrop1Arr;
    private float[] mDrop2Arr;
    private d mInferInterpreter;
    private float[] mL2Arr;
    private float[] mLossBuf;
    private float[] mLrB1Arr;
    private float[] mLrB2Arr;
    private float[] mLrB3Arr;
    private float[] mLrB4Arr;
    private float[] mLrW1Arr;
    private float[] mLrW2Arr;
    private float[] mLrW3Arr;
    private float[] mLrW4Arr;
    private MappedByteBuffer mModelBuffer;
    private final Object mTrainLock;
    private Weights mTrainWeights;
    private TrainWorkspace mTrainWs;
    private int mTrainWsBatchSize;
    private Weights mWeightsA;
    private Weights mWeightsB;
    private final Object mWeightsLock;
    private int[][] mXBatchBuf;
    private float[][] mXNormBuf;
    private float[][] mYBatchBuf;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchML$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class TrainWorkspace {

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        final float[][] f5784a1;

        /* JADX INFO: renamed from: a2, reason: collision with root package name */
        final float[][] f5785a2;

        /* JADX INFO: renamed from: a3, reason: collision with root package name */
        final float[][] f5786a3;
        final int batchSize;
        final float[] dLogits;
        final float[][] dz1;
        final float[][] dz2;
        final float[][] dz3;
        final float[] gb1;
        final float[] gb2;
        final float[] gb3;
        final float[] gb4;
        final float[][] gw1;
        final float[][] gw2;
        final float[][] gw3;
        final float[][] gw4;
        final float[][] mask1;
        final float[][] mask2;
        final float[] prob;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        final float[][] f5787z1;
        final float[][] z2;

        /* JADX INFO: renamed from: z3, reason: collision with root package name */
        final float[][] f5788z3;

        public TrainWorkspace(int r8) {
            Class r10 = Float.TYPE;
            this.gw1 = (float[][]) Array.newInstance(r10, new int[]{11, 32});
            this.gb1 = new float[32];
            this.gw2 = (float[][]) Array.newInstance(r10, new int[]{32, 16});
            this.gb2 = new float[16];
            this.gw3 = (float[][]) Array.newInstance(r10, new int[]{16, 8});
            this.gb3 = new float[8];
            this.gw4 = (float[][]) Array.newInstance(r10, new int[]{8, 1});
            this.gb4 = new float[1];
            this.batchSize = r8;
            this.f5787z1 = (float[][]) Array.newInstance(r10, new int[]{r8, 32});
            this.f5784a1 = (float[][]) Array.newInstance(r10, new int[]{r8, 32});
            this.mask1 = (float[][]) Array.newInstance(r10, new int[]{r8, 32});
            this.z2 = (float[][]) Array.newInstance(r10, new int[]{r8, 16});
            this.f5785a2 = (float[][]) Array.newInstance(r10, new int[]{r8, 16});
            this.mask2 = (float[][]) Array.newInstance(r10, new int[]{r8, 16});
            this.f5788z3 = (float[][]) Array.newInstance(r10, new int[]{r8, 8});
            this.f5786a3 = (float[][]) Array.newInstance(r10, new int[]{r8, 8});
            this.prob = new float[r8];
            this.dLogits = new float[r8];
            this.dz3 = (float[][]) Array.newInstance(r10, new int[]{r8, 8});
            this.dz2 = (float[][]) Array.newInstance(r10, new int[]{r8, 16});
            this.dz1 = (float[][]) Array.newInstance(r10, new int[]{r8, 32});
        }
    }

    public static final class Weights {

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        float[] f5789b1;

        /* JADX INFO: renamed from: b2, reason: collision with root package name */
        float[] f5790b2;

        /* JADX INFO: renamed from: b3, reason: collision with root package name */
        float[] f5791b3;

        /* JADX INFO: renamed from: b4, reason: collision with root package name */
        float[] f5792b4;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        float[][] f5793w1;

        /* JADX INFO: renamed from: w2, reason: collision with root package name */
        float[][] f5794w2;

        /* JADX INFO: renamed from: w3, reason: collision with root package name */
        float[][] f5795w3;

        /* JADX INFO: renamed from: w4, reason: collision with root package name */
        float[][] f5796w4;

        private Weights() {
        }

        public /* synthetic */ Weights(AnonymousClass1 r8) {
            this();
        }
    }

    static {
        scalerMin = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -100.0f, 0.0f};
        scalerMax = new float[]{20000.0f, 1000.0f, 4.0f, 6000.0f, 600.0f, 600.0f, 3.0f, 200000.0f, 2.0f, 0.0f, 600.0f};
    }

    private NetworkSwitchML(Context r8) {
        this.mWeightsLock = new Object();
        this.mTrainWsBatchSize = -1;
        this.mTrainLock = new Object();
        this.context = r8.getApplicationContext();
        ensureModelOnDisk();     // Catch: Throwable -> L5
        loadInterpreter();     // Catch: Throwable -> L5
    L10:
        ensureWeightsInitializedIfMissing();
        return;
    L5:
        th = move-exception;
        CaeLog.w(TAG, "First attempt to load model failed, trying fallback: " + th.getMessage());
        File r10 = new File(this.context.getFilesDir(), ASSET_MODEL_NAME);
        if (r10.exists() == false) goto L9;
        r10.delete();
    L9:
        this.mModelBuffer = null;
        ensureModelOnDisk();
        loadInterpreter();
        goto L10
    }

    private static void applyL2Grads(TrainWorkspace r8, float[][] r10, float[][] r11, float[][] r12, float[][] r13, float r14) {
        if (r14 > 0.0f) goto L5;
        return;
    L5:
        float r15 = r14 * 2.0f;
        int r16 = 0;
    L7:
        if (r16 >= 11) goto L12;
        int r17 = 0;
    L9:
        if (r17 >= 32) goto L11;
        float[] r18 = r8.gw1[r16];
        r18[r17] = (r10[r16][r17] * r15) + r18[r17];
        r17 = r17 + 1;
        goto L9
    L11:
        r16 = r16 + 1;
        goto L7
    L12:
        int r19 = 0;
    L14:
        if (r19 >= 32) goto L19;
        int r20 = 0;
    L16:
        if (r20 >= 16) goto L18;
        float[] r21 = r8.gw2[r19];
        r21[r20] = (r11[r19][r20] * r15) + r21[r20];
        r20 = r20 + 1;
        goto L16
    L18:
        r19 = r19 + 1;
        goto L14
    L19:
        int r22 = 0;
    L21:
        if (r22 >= 16) goto L26;
        int r23 = 0;
    L23:
        if (r23 >= 8) goto L25;
        float[] r24 = r8.gw3[r22];
        r24[r23] = (r12[r22][r23] * r15) + r24[r23];
        r23 = r23 + 1;
        goto L23
    L25:
        r22 = r22 + 1;
        goto L21
    L26:
        int r25 = 0;
    L27:
        if (r25 >= 8) goto L29;
        float[] r110 = r8.gw4[r25];
        r110[0] = (r13[r25][0] * r15) + r110[0];
        r25 = r25 + 1;
        goto L27
    }

    private static void backwardBatch(TrainWorkspace r13, float[][] r14, float[][] r15, float[][] r16, float[][] r17, float r18) {
        int r8 = 0;
    L4:
        if (r8 >= r13.batchSize) goto L9;
        float r10 = r13.dLogits[r8];
        float[] r11 = r13.gb4;
        r11[0] = r11[0] + r10;
        int r12 = 0;
    L6:
        if (r12 >= 8) goto L8;
        float[] r19 = r13.gw4[r12];
        r19[0] = (r13.f5786a3[r8][r12] * r10) + r19[0];
        r12 = r12 + 1;
        goto L6
    L8:
        r8 = r8 + 1;
        goto L4
    L9:
        int r20 = 0;
    L11:
        if (r20 >= r13.batchSize) goto L20;
        float r21 = r13.dLogits[r20];
        int r22 = 0;
    L13:
        if (r22 >= 8) goto L19;
        float r23 = r17[r22][0] * r21;
        if (r13.f5788z3[r20][r22] < 0.0f) goto L17;
        float r24 = 1.0f;
    L18:
        r13.dz3[r20][r22] = r23 * r24;
        r22 = r22 + 1;
        goto L13
    L17:
        r24 = r18;
        goto L18
    L19:
        r20 = r20 + 1;
        goto L11
    L20:
        int r25 = 0;
    L22:
        if (r25 >= r13.batchSize) goto L30;
        int r26 = 0;
    L24:
        if (r26 >= 8) goto L29;
        float r27 = r13.dz3[r25][r26];
        float[] r28 = r13.gb3;
        r28[r26] = r28[r26] + r27;
        int r29 = 0;
    L26:
        if (r29 >= 16) goto L28;
        float[] r110 = r13.gw3[r29];
        r110[r26] = (r13.f5785a2[r25][r29] * r27) + r110[r26];
        r29 = r29 + 1;
        goto L26
    L28:
        r26 = r26 + 1;
        goto L24
    L29:
        r25 = r25 + 1;
        goto L22
    L30:
        int r30 = 0;
    L32:
        if (r30 >= r13.batchSize) goto L44;
        int r31 = 0;
    L34:
        if (r31 >= 16) goto L43;
        int r32 = 0;
        float r33 = 0.0f;
    L36:
        if (r32 >= 8) goto L38;
        r33 = r33 + (r13.dz3[r30][r32] * r16[r31][r32]);
        r32 = r32 + 1;
        goto L36
    L38:
        float r34 = r33 * r13.mask2[r30][r31];
        if (r13.z2[r30][r31] < 0.0f) goto L41;
        float r35 = 1.0f;
    L42:
        r13.dz2[r30][r31] = r34 * r35;
        r31 = r31 + 1;
        goto L34
    L41:
        r35 = r18;
        goto L42
    L43:
        r30 = r30 + 1;
        goto L32
    L44:
        int r36 = 0;
    L46:
        if (r36 >= r13.batchSize) goto L54;
        int r37 = 0;
    L48:
        if (r37 >= 16) goto L53;
        float r38 = r13.dz2[r36][r37];
        float[] r39 = r13.gb2;
        r39[r37] = r39[r37] + r38;
        int r40 = 0;
    L50:
        if (r40 >= 32) goto L52;
        float[] r111 = r13.gw2[r40];
        r111[r37] = (r13.f5784a1[r36][r40] * r38) + r111[r37];
        r40 = r40 + 1;
        goto L50
    L52:
        r37 = r37 + 1;
        goto L48
    L53:
        r36 = r36 + 1;
        goto L46
    L54:
        int r41 = 0;
    L56:
        if (r41 >= r13.batchSize) goto L68;
        int r42 = 0;
    L58:
        if (r42 >= 32) goto L67;
        int r43 = 0;
        float r44 = 0.0f;
    L60:
        if (r43 >= 16) goto L62;
        r44 = r44 + (r13.dz2[r41][r43] * r15[r42][r43]);
        r43 = r43 + 1;
        goto L60
    L62:
        float r45 = r44 * r13.mask1[r41][r42];
        if (r13.f5787z1[r41][r42] < 0.0f) goto L65;
        float r46 = 1.0f;
    L66:
        r13.dz1[r41][r42] = r45 * r46;
        r42 = r42 + 1;
        goto L58
    L65:
        r46 = r18;
        goto L66
    L67:
        r41 = r41 + 1;
        goto L56
    L68:
        int r47 = 0;
    L70:
        if (r47 >= r13.batchSize) goto L79;
        int r48 = 0;
    L72:
        if (r48 >= 32) goto L78;
        float r49 = r13.dz1[r47][r48];
        float[] r50 = r13.gb1;
        r50[r48] = r50[r48] + r49;
        int r51 = 0;
    L75:
        if (r51 >= 11) goto L77;
        float[] r52 = r13.gw1[r51];
        r52[r48] = (r14[r47][r51] * r49) + r52[r48];
        r51 = r51 + 1;
        goto L75
    L77:
        r48 = r48 + 1;
        goto L72
    L78:
        r47 = r47 + 1;
        goto L70
    }

    private static float computeLossAndDLogits(TrainWorkspace r14, float[][] r15, float[][] r16, float[][] r17, float[][] r18, float[][] r19, float r20) {
        float r8 = 0.0f;
        float r10 = 0.0f;
        int r11 = 0;
    L3:
        int r12 = r14.batchSize;
        if (r11 >= r12) goto L6;
        r10 = r10 + r15[r11][0];
        r11 = r11 + 1;
        goto L3
    L6:
        float r13 = r10 / Math.max(1.0f, r12);
        if (r13 <= 1.0E-6f) goto L9;
        float r21 = (1.0f - r13) / r13;
    L10:
        float r22 = 0.0f;
        int r23 = 0;
    L12:
        if (r23 >= r14.batchSize) goto L24;
        float r24 = r15[r23][0];
        float r25 = r14.prob[r23];
        float r26 = 1.0E-7f;
        if (r25 >= 1.0E-7f) goto L16;
    L15:
        r25 = r26;
    L20:
        if (r24 < 0.5f) goto L22;
        float r27 = r21;
    L23:
        r22 = r22 + (-(((1.0f - r24) * ((float) Math.log(1.0f - r25))) + ((r27 * r24) * ((float) Math.log(r25)))));
        r14.dLogits[r23] = ((r25 - r24) * r27) / Math.max(1.0f, r14.batchSize);
        r23 = r23 + 1;
        goto L12
    L22:
        r27 = 1.0f;
        goto L23
    L16:
        r26 = 0.9999999f;
        if (r25 <= 0.9999999f) goto L20;
    L24:
        int r28 = 0;
    L26:
        if (r28 >= 11) goto L31;
        int r29 = 0;
    L28:
        if (r29 >= 32) goto L30;
        float r30 = r16[r28][r29];
        r8 = r8 + (r30 * r30);
        r29 = r29 + 1;
        goto L28
    L30:
        r28 = r28 + 1;
        goto L26
    L31:
        int r31 = 0;
    L33:
        if (r31 >= 32) goto L38;
        int r32 = 0;
    L35:
        if (r32 >= 16) goto L37;
        float r33 = r17[r31][r32];
        r8 = r8 + (r33 * r33);
        r32 = r32 + 1;
        goto L35
    L37:
        r31 = r31 + 1;
        goto L33
    L38:
        int r34 = 0;
    L40:
        if (r34 >= 16) goto L45;
        int r35 = 0;
    L42:
        if (r35 >= 8) goto L44;
        float r36 = r18[r34][r35];
        r8 = r8 + (r36 * r36);
        r35 = r35 + 1;
        goto L42
    L44:
        r34 = r34 + 1;
        goto L40
    L45:
        int r37 = 0;
    L46:
        if (r37 >= 8) goto L49;
        float r38 = r19[r37][0];
        r8 = r8 + (r38 * r38);
        r37 = r37 + 1;
        goto L46
    L49:
        return (r20 * r8) + (r22 / Math.max(1.0f, r14.batchSize));
    L9:
        r21 = 1.0f;
        goto L10
    }

    private static float[][] deepCopy(float[][] r8) {
        float[][] r10 = new float[r8.length][];
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L6;
        float[] r12 = r8[r11];
        r10[r11] = Arrays.copyOf(r12, r12.length);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private void deepCopy1D(float[] r8, float[] r10) {
        System.arraycopy(r8, 0, r10, 0, r8.length);
    }

    private void deepCopy2D(float[][] r8, float[][] r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L6;
        float[] r12 = r8[r11];
        System.arraycopy(r12, 0, r10[r11], 0, r12.length);
        r11 = r11 + 1;
        goto L4
    }

    private Weights deepCopyWeights(Weights r8) {
        Weights r10 = new Weights(null);
        Class r11 = Float.TYPE;
        r10.f5793w1 = (float[][]) Array.newInstance(r11, new int[]{11, 32});
        r10.f5789b1 = new float[32];
        r10.f5794w2 = (float[][]) Array.newInstance(r11, new int[]{32, 16});
        r10.f5790b2 = new float[16];
        r10.f5795w3 = (float[][]) Array.newInstance(r11, new int[]{16, 8});
        r10.f5791b3 = new float[8];
        r10.f5796w4 = (float[][]) Array.newInstance(r11, new int[]{8, 1});
        r10.f5792b4 = new float[1];
        deepCopy2D(r8.f5793w1, r10.f5793w1);
        deepCopy1D(r8.f5789b1, r10.f5789b1);
        deepCopy2D(r8.f5794w2, r10.f5794w2);
        deepCopy1D(r8.f5790b2, r10.f5790b2);
        deepCopy2D(r8.f5795w3, r10.f5795w3);
        deepCopy1D(r8.f5791b3, r10.f5791b3);
        deepCopy2D(r8.f5796w4, r10.f5796w4);
        deepCopy1D(r8.f5792b4, r10.f5792b4);
        return r10;
    }

    private void ensureModelBuffer() {
        if (this.mModelBuffer == null) goto L5;
        return;
    L5:
        FileInputStream r8 = new FileInputStream(new File(this.context.getFilesDir(), ASSET_MODEL_NAME));
        FileChannel r10 = r8.getChannel();     // Catch: Throwable -> L9
        this.mModelBuffer = r10.map(FileChannel.MapMode.READ_ONLY, 0, r10.size());     // Catch: Throwable -> L9
        r8.close();
        return;
    L9:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    private void ensureModelOnDisk() {
        File r8 = new File(this.context.getFilesDir(), ASSET_MODEL_NAME);
        AssetFileDescriptor r10 = this.context.getAssets().openFd(ASSET_MODEL_NAME);     // Catch: IOException -> L45
        long r11 = r10.getLength();     // Catch: Throwable -> L38
        if (r8.exists() == true) goto L8;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L14;
        r10.close();     // Catch: IOException -> L45
        return;
    L14:
        FileInputStream r13 = r10.createInputStream();     // Catch: Throwable -> L38
        FileOutputStream r14 = new FileOutputStream(r8, false);     // Catch: Throwable -> L31
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L25
    L17:
        int r16 = r13.read(r15);     // Catch: Throwable -> L25
        if (r16 == (-1)) goto L21;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L25
    L21:
        r14.close();     // Catch: Throwable -> L31
        r13.close();     // Catch: Throwable -> L38
        r10.close();     // Catch: IOException -> L45
        return;
    L25:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r13 != null) goto L77;
    L37:
        throw th;     // Catch: Throwable -> L38
    L77:
        r13.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L38
        goto L37
    L8:
        if (r8.length() != r11) goto L10;
        r12 = false;
    L38:
        th = move-exception;
        if (r10 != null) goto L71;
    L44:
        throw th;     // Catch: IOException -> L45
    L71:
        r10.close();     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L45
    L68:
        e = move-exception;
        CaeLog.e(TAG, "model asset copy failed: " + e.getMessage());
        throw e;
    L45:
        InputStream r17 = this.context.getAssets().open(ASSET_MODEL_NAME);     // Catch: IOException -> L68
        FileOutputStream r18 = new FileOutputStream(r8, false);     // Catch: Throwable -> L61
        byte[] r19 = new byte[8192];     // Catch: Throwable -> L55
    L48:
        int r20 = r17.read(r19);     // Catch: Throwable -> L55
        if (r20 == (-1)) goto L52;
        r18.write(r19, 0, r20);     // Catch: Throwable -> L55
    L52:
        r18.close();     // Catch: Throwable -> L61
        r17.close();     // Catch: IOException -> L68
        return;
    L55:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L58
    L60:
        throw th;     // Catch: Throwable -> L61
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        if (r17 != null) goto L81;
    L67:
        throw th;     // Catch: IOException -> L68
    L81:
        r17.close();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L68
        goto L67
    }

    private void ensureShadowInitializedIfMissing() {
        ensureWeightsInitializedIfMissing();
    }

    private void ensureTrainIOAllocated(int r8, float r10) {
        int[][] r11 = this.mXBatchBuf;
        if (r11 != null) goto L5;
    L31:
        boolean r12 = true;
    L32:
        if (r12 == false) goto L35;
        this.mXBatchBuf = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r8, 11});
        Class r13 = Float.TYPE;
        this.mYBatchBuf = (float[][]) Array.newInstance(r13, new int[]{r8, 1});
        this.mXNormBuf = (float[][]) Array.newInstance(r13, new int[]{r8, 11});
    L35:
        if (this.mLossBuf != null) goto L38;
        this.mLossBuf = new float[1];
    L38:
        if (this.mLrW1Arr != null) goto L41;
        this.mLrW1Arr = new float[1];
    L41:
        if (this.mLrB1Arr != null) goto L44;
        this.mLrB1Arr = new float[1];
    L44:
        if (this.mLrW2Arr != null) goto L47;
        this.mLrW2Arr = new float[1];
    L47:
        if (this.mLrB2Arr != null) goto L50;
        this.mLrB2Arr = new float[1];
    L50:
        if (this.mLrW3Arr != null) goto L53;
        this.mLrW3Arr = new float[1];
    L53:
        if (this.mLrB3Arr != null) goto L56;
        this.mLrB3Arr = new float[1];
    L56:
        if (this.mLrW4Arr != null) goto L59;
        this.mLrW4Arr = new float[1];
    L59:
        if (this.mLrB4Arr != null) goto L62;
        this.mLrB4Arr = new float[1];
    L62:
        if (this.mDrop1Arr != null) goto L65;
        this.mDrop1Arr = new float[1];
    L65:
        if (this.mDrop2Arr != null) goto L68;
        this.mDrop2Arr = new float[1];
    L68:
        if (this.mL2Arr != null) goto L70;
        this.mL2Arr = new float[1];
    L70:
        float r14 = 0.0f * r10;
        this.mLrW1Arr[0] = r14;
        this.mLrB1Arr[0] = r14;
        float r15 = r10 * 0.2f;
        this.mLrW2Arr[0] = r15;
        this.mLrB2Arr[0] = r15;
        float r16 = 0.6f * r10;
        this.mLrW3Arr[0] = r16;
        this.mLrB3Arr[0] = r16;
        float r17 = r10 * 1.0f;
        this.mLrW4Arr[0] = r17;
        this.mLrB4Arr[0] = r17;
        this.mDrop1Arr[0] = 0.2f;
        this.mDrop2Arr[0] = 0.2f;
        this.mL2Arr[0] = 1.0E-4f;
        return;
    L5:
        if (r11.length != r8) goto L31;
        int[] r18 = r11[0];
        if (r18 == null) goto L31;
        if (r18.length != 11) goto L31;
        float[][] r19 = this.mYBatchBuf;
        if (r19 == null) goto L31;
        if (r19.length != r8) goto L31;
        float[] r20 = r19[0];
        if (r20 == null) goto L31;
        if (r20.length != 1) goto L31;
        float[][] r21 = this.mXNormBuf;
        if (r21 == null) goto L31;
        if (r21.length != r8) goto L31;
        float[] r22 = r21[0];
        if (r22 == null) goto L31;
        if (r22.length != 11) goto L31;
        r12 = false;
        goto L32
    }

    private void ensureTrainWorkspaceAllocated(int r8) {
        if (this.mTrainWs != null) goto L5;
    L6:
        this.mTrainWs = new TrainWorkspace(r8);
        this.mTrainWsBatchSize = r8;
        return;
    L5:
        if (this.mTrainWsBatchSize != r8) goto L6;
    }

    private void ensureWeightsInitializedIfMissing() {
        if (this.mActiveWeights == null) goto L5;
        return;
    L5:
        Object r8 = this.mWeightsLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (this.mActiveWeights == null) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L11:
        Weights r10 = new Weights(null);     // Catch: Throwable -> L22
        boolean r11 = loadWeightsFromSavedFile(r10);     // Catch: Throwable -> L22
        if (r11 == false) goto L25;
    L17:
        if (r11 == true) goto L19;
        randomInitWeights(r10);     // Catch: Throwable -> L22
    L19:
        this.mWeightsA = r10;     // Catch: Throwable -> L22
        this.mWeightsB = deepCopyWeights(r10);     // Catch: Throwable -> L22
        this.mActiveWeights = this.mWeightsA;     // Catch: Throwable -> L22
        this.mTrainWeights = this.mWeightsB;     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L25:
        r11 = loadWeightsFromAssets(r10);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CaeLog.w(TAG, "load init weights from assets failed: " + th.getMessage());     // Catch: Throwable -> L22
        goto L17
    }

    private void fillBatchSlice(int[][] r8, float[][] r10, int[] r11, int r12, int r13, int[][] r14, float[][] r15) {
        int r16 = 0;
    L3:
        if (r12 >= r13) goto L5;
        int r17 = r11[r12];
        int[] r18 = r8[r17];
        System.arraycopy(r18, 0, r14[r16], 0, Math.min(11, r18.length));
        r15[r16][0] = r10[r17][0];
        r12 = r12 + 1;
        r16 = r16 + 1;
        goto L3
    }

    private void fillBatchSliceFixed(int[][] r8, float[][] r10, int[] r11, int r12, int r13, int[][] r14, float[][] r15, int r16, int r17) {
        if (r13 <= r12) goto L4;
        int r18 = r11[r13 - 1];
    L5:
        int r19 = 0;
    L7:
        if (r12 >= r13) goto L9;
        int r20 = r11[r12];
        int[] r21 = r8[r20];
        System.arraycopy(r21, 0, r14[r19], 0, Math.min(11, r21.length));
        r15[r19][0] = r10[r20][0];
        r12 = r12 + 1;
        r19 = r19 + 1;
    L9:
        if (r19 >= r17) goto L11;
        int[] r22 = r8[r18];
        System.arraycopy(r22, 0, r14[r19], 0, Math.min(11, r22.length));
        r15[r19][0] = r10[r18][0];
        r19 = r19 + 1;
        goto L9
    L11:
        return;
    L4:
        r18 = r11[r12];
        goto L5
    }

    private static void forwardBatch(TrainWorkspace r10, float[][] r11, float[][] r12, float[] r13, float[][] r14, float[] r15, float[][] r16, float[] r17, float[][] r18, float[] r19, float r20, float r21, float r22, float r23, float r24, Random r25) {
        int r8 = 0;
    L4:
        if (r8 >= r10.batchSize) goto L51;
        int r26 = 0;
    L6:
        float r27 = 0.0f;
        if (r26 >= 32) goto L21;
        float r28 = r13[r26];
        int r29 = 0;
    L10:
        if (r29 >= 11) goto L12;
        r28 = r28 + (r11[r8][r29] * r12[r29][r26]);
        r29 = r29 + 1;
        goto L10
    L12:
        r10.f5787z1[r8][r26] = r28;
        if (r28 >= 0.0f) goto L17;
        r28 = r28 * r20;
    L17:
        if (r25.nextFloat() < r21) goto L20;
        r27 = r22;
    L20:
        r10.mask1[r8][r26] = r27;
        r10.f5784a1[r8][r26] = r28 * r27;
        r26 = r26 + 1;
        goto L6
    L21:
        int r30 = 0;
    L23:
        if (r30 >= 16) goto L36;
        float r31 = r15[r30];
        int r32 = 0;
    L25:
        if (r32 >= 32) goto L27;
        r31 = r31 + (r10.f5784a1[r8][r32] * r14[r32][r30]);
        r32 = r32 + 1;
        goto L25
    L27:
        r10.z2[r8][r30] = r31;
        if (r31 >= 0.0f) goto L32;
        r31 = r31 * r20;
    L32:
        if (r25.nextFloat() >= r23) goto L34;
        float r33 = 0.0f;
    L35:
        r10.mask2[r8][r30] = r33;
        r10.f5785a2[r8][r30] = r31 * r33;
        r30 = r30 + 1;
        goto L23
    L34:
        r33 = r24;
        goto L35
    L36:
        int r34 = 0;
    L38:
        if (r34 >= 8) goto L47;
        float r35 = r17[r34];
        int r36 = 0;
    L40:
        if (r36 >= 16) goto L42;
        r35 = r35 + (r10.f5785a2[r8][r36] * r16[r36][r34]);
        r36 = r36 + 1;
        goto L40
    L42:
        r10.f5788z3[r8][r34] = r35;
        float[] r37 = r10.f5786a3[r8];
        if (r35 >= 0.0f) goto L46;
        r35 = r35 * r20;
    L46:
        r37[r34] = r35;
        r34 = r34 + 1;
        goto L38
    L47:
        float r38 = r19[0];
        int r39 = 0;
    L48:
        if (r39 >= 8) goto L50;
        r38 = r38 + (r10.f5786a3[r8][r39] * r18[r39][0]);
        r39 = r39 + 1;
        goto L48
    L50:
        r10.prob[r8] = 1.0f / (((float) Math.exp(-r38)) + 1.0f);
        r8 = r8 + 1;
        goto L4
    }

    private Weights getActiveWeightsSnapshot() {
        ensureWeightsInitializedIfMissing();
        return this.mActiveWeights;
    }

    public static NetworkSwitchML getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkSwitchML.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkSwitchML(r8.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkSwitchML.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void loadInterpreter() {
        ensureModelBuffer();
        d.a r8 = new d.a();
        r8.f9837c = Boolean.FALSE;
        this.mInferInterpreter = new d(this.mModelBuffer, r8);
    }

    private boolean loadWeightsFromAssets(Weights r8) {
        InputStream r10 = this.context.getAssets().open(ASSET_INIT_WEIGHTS_NAME);     // Catch: Throwable -> L27
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L14
    L7:
        int r13 = r10.read(r12);     // Catch: Throwable -> L14
        if (r13 == (-1)) goto L10;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L14
        goto L7
    L10:
        JSONObject r14 = new JSONObject(new String(r11.toByteArray()));     // Catch: Throwable -> L14
        r8.f5793w1 = parse2D(r14.getJSONArray("w1"), 11, 32);     // Catch: Throwable -> L14
        r8.f5789b1 = parse1D(r14.getJSONArray("b1"), 32);     // Catch: Throwable -> L14
        r8.f5794w2 = parse2D(r14.getJSONArray("w2"), 32, 16);     // Catch: Throwable -> L14
        r8.f5790b2 = parse1D(r14.getJSONArray("b2"), 16);     // Catch: Throwable -> L14
        r8.f5795w3 = parse2D(r14.getJSONArray("w3"), 16, 8);     // Catch: Throwable -> L14
        r8.f5791b3 = parse1D(r14.getJSONArray("b3"), 8);     // Catch: Throwable -> L14
        r8.f5796w4 = parse2D(r14.getJSONArray("w4"), 8, 1);     // Catch: Throwable -> L14
        r8.f5792b4 = parse1D(r14.getJSONArray("b4"), 1);     // Catch: Throwable -> L14
        CaeLog.d(TAG, "Loaded init weights from assets");     // Catch: Throwable -> L14
        r11.close();     // Catch: Throwable -> L20
        r10.close();     // Catch: Throwable -> L27
        return true;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r10 != null) goto L33;
    L26:
        throw th;     // Catch: Throwable -> L27
    L33:
        r10.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CaeLog.e(TAG, "parse init weights JSON failed: " + th.getMessage(), th);
        return false;
    }

    private boolean loadWeightsFromSavedFile(Weights r18) {
        String r8 = "b4";
        String r10 = TAG;
        File r11 = new File(this.context.getFilesDir(), SAVED_WEIGHTS_FILE);
        if (r11.exists() == true) goto L87;
        return false;
    L87:
        FileInputStream r12 = new FileInputStream(r11);     // Catch: Throwable -> L80
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L69
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L58
    L9:
        int r15 = r12.read(r14);     // Catch: Throwable -> L58
        String r16 = r10;
        if (r15 == (-1)) goto L101;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L14
        r10 = r16;
    L14:
        th = move-exception;
        Throwable r17 = th;
        r8 = r16;
    L97:
        r13.close();     // Catch: Throwable -> L63
    L104:
        throw r17;     // Catch: Throwable -> L67
    L63:
        th = move-exception;
        r17.addSuppressed(th);     // Catch: Throwable -> L67
        throw r17;     // Catch: Throwable -> L67
    L101:
    L56:
        th = th;
        r8 = r16;
    L60:
        r17 = th;
        goto L97
    L93:
        if (r13.size() > 0) goto L26;
        r11.delete();     // Catch: Throwable -> L14
        r13.close();     // Catch: Throwable -> L24
        r12.close();     // Catch: Throwable -> L22
        return false;
    L26:
        JSONObject r19 = new JSONObject(new String(r13.toByteArray(), StandardCharsets.UTF_8));     // Catch: Throwable -> L56
        if (r19.has("w1") == false) goto L48;
        if (r19.has("b1") == false) goto L48;
        if (r19.has("w2") == false) goto L48;
        if (r19.has("b2") == false) goto L48;
        if (r19.has("w3") == false) goto L48;
        if (r19.has("b3") == false) goto L48;
        if (r19.has("w4") == false) goto L48;
        if (r19.has("b4") == false) goto L48;
        r18.f5793w1 = parse2D(r19.getJSONArray("w1"), 11, 32);     // Catch: Throwable -> L14
        r18.f5789b1 = parse1D(r19.getJSONArray("b1"), 32);     // Catch: Throwable -> L14
        r18.f5794w2 = parse2D(r19.getJSONArray("w2"), 32, 16);     // Catch: Throwable -> L14
        r18.f5790b2 = parse1D(r19.getJSONArray("b2"), 16);     // Catch: Throwable -> L14
        r18.f5795w3 = parse2D(r19.getJSONArray("w3"), 16, 8);     // Catch: Throwable -> L14
        r18.f5791b3 = parse1D(r19.getJSONArray("b3"), 8);     // Catch: Throwable -> L14
        r18.f5796w4 = parse2D(r19.getJSONArray("w4"), 8, 1);     // Catch: Throwable -> L14
        r18.f5792b4 = parse1D(r19.getJSONArray("b4"), 1);     // Catch: Throwable -> L14
        r13.close();     // Catch: Throwable -> L24
        r12.close();     // Catch: Throwable -> L22
        return true;
    L48:
        r8 = r16;
        CaeLog.w(r8, "saved weights JSON missing required MLP keys, deleting corrupted file.");     // Catch: Throwable -> L54
        r11.delete();     // Catch: Throwable -> L54
        r13.close();     // Catch: Throwable -> L67
        r12.close();     // Catch: Throwable -> L78
        return false;
    L54:
        th = th;
    L24:
        th = move-exception;
        Throwable r20 = th;
        r8 = r16;
    L94:
        r12.close();     // Catch: Throwable -> L74
    L105:
        throw r20;     // Catch: Throwable -> L78
    L74:
        th = move-exception;
        r20.addSuppressed(th);     // Catch: Throwable -> L78
        throw r20;     // Catch: Throwable -> L78
    L22:
        th = th;
        r8 = r16;
    L82:
        CaeLog.e(r8, "failed to restore weights: " + th.getMessage() + ", deleting corrupted file.", th);
        if (r11.exists() == false) goto L106;
        r11.delete();
        return false;
    L106:
        return false;
    L58:
        th = th;
        r8 = r10;
    L67:
        th = th;
    L71:
        r20 = th;
    L69:
        th = th;
        r8 = TAG;
    L80:
        th = th;
        r8 = TAG;
    L78:
        th = th;
        goto L82
    }

    private float[] normalize(int[] r8) {
        float[] r10 = new float[11];
        int r11 = Math.min(11, r8.length);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        float r13 = r8[r12];
        float r14 = scalerMin[r12];
        float r15 = scalerMax[r12] - r14;
        float r16 = 1.0f;
        if (r15 >= 1.0E-6f) goto L7;
        r15 = 1.0f;
    L7:
        float r17 = (r13 - r14) / r15;
        if (r17 >= 0.0f) goto L11;
        r16 = 0.0f;
    L14:
        r10[r12] = r16;
        r12 = r12 + 1;
        goto L3
    L11:
        if (r17 > 1.0f) goto L14;
        r16 = r17;
        goto L14
    L15:
        return r10;
    }

    private float[][] normalizeBatch(int[][] r8) {
        int[] r10 = {r8.length, 11};
        float[][] r11 = (float[][]) Array.newInstance(Float.TYPE, r10);
        int r12 = 0;
    L4:
        if (r12 >= r8.length) goto L6;
        r11[r12] = normalize(r8[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    private void normalizeBatchInto(int[][] r13, float[][] r14) {
        int r8 = 0;
    L4:
        if (r8 >= r13.length) goto L22;
        int[] r10 = r13[r8];
        float[] r11 = r14[r8];
        int r12 = Math.min(11, r10.length);
        int r15 = 0;
    L6:
        float r16 = 0.0f;
        if (r15 >= r12) goto L19;
        float r17 = r10[r15];
        float r18 = scalerMin[r15];
        float r19 = scalerMax[r15] - r18;
        if (r19 >= 1.0E-6f) goto L11;
        r19 = 1.0f;
    L11:
        float r20 = (r17 - r18) / r19;
        if (r20 < 0.0f) goto L18;
        if (r20 <= 1.0f) goto L17;
        r16 = 1.0f;
        goto L18
    L17:
        r16 = r20;
    L18:
        r11[r15] = r16;
        r15 = r15 + 1;
    L19:
        if (r12 >= 11) goto L21;
        r11[r12] = 0.0f;
        r12 = r12 + 1;
        goto L19
    L21:
        r8 = r8 + 1;
        goto L4
    }

    private static float[] parse1D(JSONArray r8, int r10) {
        if (r8.length() != r10) goto L8;
        float[] r11 = new float[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L7;
        r11[r12] = (float) r8.getDouble(r12);
        r12 = r12 + 1;
        goto L5
    L7:
        return r11;
    L8:
        StringBuilder r13 = defpackage.b.f("parse1D length mismatch: expected ", r10, ", got ");
        r13.append(r8.length());
        throw new IllegalArgumentException(r13.toString());
    }

    private static float[][] parse2D(JSONArray r10, int r11, int r12) {
        if (r10.length() != r11) goto L15;
        float[][] r8 = (float[][]) Array.newInstance(Float.TYPE, new int[]{r11, r12});
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L14;
        JSONArray r14 = r10.getJSONArray(r13);
        if (r14.length() != r12) goto L12;
        int r15 = 0;
    L9:
        if (r15 >= r12) goto L11;
        r8[r13][r15] = (float) r14.getDouble(r15);
        r15 = r15 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L5
    L12:
        StringBuilder r16 = defpackage.a.g("parse2D cols mismatch at row ", r13, ": expected ", r12, ", got ");
        r16.append(r14.length());
        throw new IllegalArgumentException(r16.toString());
    L14:
        return r8;
    L15:
        StringBuilder r17 = defpackage.b.f("parse2D rows mismatch: expected ", r11, ", got ");
        r17.append(r10.length());
        throw new IllegalArgumentException(r17.toString());
    }

    private void randomInitWeights(Weights r12) {
        Random r11 = new Random(42);
        r12.f5793w1 = (float[][]) Array.newInstance(Float.TYPE, new int[]{11, 32});
        r12.f5789b1 = new float[32];
        int r8 = 0;
    L4:
        if (r8 >= 11) goto L9;
        int r10 = 0;
    L6:
        if (r10 >= 32) goto L8;
        r12.f5793w1[r8][r10] = (float) (r11.nextGaussian() * 0.01d);
        r10 = r10 + 1;
        goto L6
    L8:
        r8 = r8 + 1;
        goto L4
    L9:
        int r13 = 0;
    L11:
        if (r13 >= 32) goto L13;
        r12.f5789b1[r13] = 0.01f;
        r13 = r13 + 1;
        goto L11
    L13:
        r12.f5794w2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{32, 16});
        r12.f5790b2 = new float[16];
        int r14 = 0;
    L14:
        if (r14 >= 32) goto L19;
        int r15 = 0;
    L16:
        if (r15 >= 16) goto L18;
        r12.f5794w2[r14][r15] = (float) (r11.nextGaussian() * 0.01d);
        r15 = r15 + 1;
        goto L16
    L18:
        r14 = r14 + 1;
        goto L14
    L19:
        int r16 = 0;
    L20:
        if (r16 >= 16) goto L22;
        r12.f5790b2[r16] = 0.01f;
        r16 = r16 + 1;
        goto L20
    L22:
        r12.f5795w3 = (float[][]) Array.newInstance(Float.TYPE, new int[]{16, 8});
        r12.f5791b3 = new float[8];
        int r17 = 0;
    L23:
        if (r17 >= 16) goto L28;
        int r18 = 0;
    L25:
        if (r18 >= 8) goto L27;
        r12.f5795w3[r17][r18] = (float) (r11.nextGaussian() * 0.01d);
        r18 = r18 + 1;
        goto L25
    L27:
        r17 = r17 + 1;
        goto L23
    L28:
        int r19 = 0;
    L29:
        if (r19 >= 8) goto L31;
        r12.f5791b3[r19] = 0.01f;
        r19 = r19 + 1;
        goto L29
    L31:
        r12.f5796w4 = (float[][]) Array.newInstance(Float.TYPE, new int[]{8, 1});
        r12.f5792b4 = new float[1];
        int r20 = 0;
    L32:
        if (r20 >= 8) goto L34;
        r12.f5796w4[r20][0] = (float) (r11.nextGaussian() * 0.01d);
        r20 = r20 + 1;
        goto L32
    L34:
        r12.f5792b4[0] = 0.01f;
    }

    private static void sgdUpdate(TrainWorkspace r10, float[][] r11, float[] r12, float[][] r13, float[] r14, float[][] r15, float[] r16, float[][] r17, float[] r18, float r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26) {
        if (r19 == 0.0f) goto L5;
    L6:
        int r8 = 0;
    L8:
        if (r8 >= 11) goto L13;
        int r27 = 0;
    L10:
        if (r27 >= 32) goto L12;
        float[] r28 = r11[r8];
        r28[r27] = r28[r27] - (r10.gw1[r8][r27] * r19);
        r27 = r27 + 1;
        goto L10
    L12:
        r8 = r8 + 1;
        goto L8
    L13:
        int r29 = 0;
    L14:
        if (r29 >= 32) goto L17;
        r12[r29] = r12[r29] - (r10.gb1[r29] * r20);
        r29 = r29 + 1;
    L17:
        if (r21 == 0.0f) goto L19;
    L20:
        int r30 = 0;
    L21:
        if (r30 >= 32) goto L26;
        int r31 = 0;
    L23:
        if (r31 >= 16) goto L25;
        float[] r32 = r13[r30];
        r32[r31] = r32[r31] - (r10.gw2[r30][r31] * r21);
        r31 = r31 + 1;
        goto L23
    L25:
        r30 = r30 + 1;
        goto L21
    L26:
        int r33 = 0;
    L27:
        if (r33 >= 16) goto L30;
        r14[r33] = r14[r33] - (r10.gb2[r33] * r22);
        r33 = r33 + 1;
    L30:
        if (r23 == 0.0f) goto L32;
    L33:
        int r34 = 0;
    L34:
        if (r34 >= 16) goto L39;
        int r35 = 0;
    L36:
        if (r35 >= 8) goto L38;
        float[] r36 = r15[r34];
        r36[r35] = r36[r35] - (r10.gw3[r34][r35] * r23);
        r35 = r35 + 1;
        goto L36
    L38:
        r34 = r34 + 1;
        goto L34
    L39:
        int r37 = 0;
    L40:
        if (r37 >= 8) goto L43;
        r16[r37] = r16[r37] - (r10.gb3[r37] * r24);
        r37 = r37 + 1;
    L43:
        if (r25 == 0.0f) goto L45;
    L46:
        int r38 = 0;
    L47:
        if (r38 >= 8) goto L49;
        float[] r39 = r17[r38];
        r39[0] = r39[0] - (r10.gw4[r38][0] * r25);
        r38 = r38 + 1;
        goto L47
    L49:
        r18[0] = r18[0] - (r10.gb4[0] * r26);
        return;
    L45:
        if (r26 != 0.0f) goto L46;
        return;
    L32:
        if (r24 == 0.0f) goto L43;
    L19:
        if (r22 == 0.0f) goto L30;
    L5:
        if (r20 == 0.0f) goto L17;
        goto L6
    }

    private void shuffleInPlace(int[] r8) {
        Random r10 = new Random();
        int r11 = r8.length - 1;
    L3:
        if (r11 <= 0) goto L5;
        int r12 = r10.nextInt(r11 + 1);
        int r13 = r8[r11];
        r8[r11] = r8[r12];
        r8[r12] = r13;
        r11 = r11 - 1;
        goto L3
    }

    private static double toFiniteDouble(float r8) {
        if (Float.isFinite(r8) == true) goto L7;
        return 0.0d;
    L7:
        return r8;
    }

    private static String toJson1D(float[] r8) {
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L9;
        r10.append(r8[r11]);
        if (r11 >= (r8.length - 1)) goto L8;
        r10.append(',');
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        r10.append(']');
        return r10.toString();
    }

    private static JSONArray toJson1DArray(float[] r8) {
        JSONArray r10 = new JSONArray();
        if (r8 != null) goto L5;
        return r10;
    L5:
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L10;
        r10.put(toFiniteDouble(r8[r12]));     // Catch: Exception -> L11
    L9:
        r12 = r12 + 1;
        goto L6
    L10:
        return r10;
    }

    private static String toJson2D(float[][] r8) {
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L16;
        r10.append('[');
        int r12 = 0;
    L6:
        float[] r13 = r8[r11];
        if (r12 >= r13.length) goto L12;
        r10.append(r13[r12]);
        if (r12 >= (r8[r11].length - 1)) goto L11;
        r10.append(',');
    L11:
        r12 = r12 + 1;
        goto L6
    L12:
        r10.append(']');
        if (r11 >= (r8.length - 1)) goto L15;
        r10.append(',');
    L15:
        r11 = r11 + 1;
        goto L4
    L16:
        r10.append(']');
        return r10.toString();
    }

    private static JSONArray toJson2DArray(float[][] r8) {
        JSONArray r10 = new JSONArray();
        if (r8 != null) goto L5;
        return r10;
    L5:
        int r11 = r8.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r10.put(toJson1DArray(r8[r12]));
        r12 = r12 + 1;
        goto L6
    L8:
        return r10;
    }

    private static void zeroGrads(TrainWorkspace r8) {
        int r10 = 0;
    L4:
        if (r10 >= 11) goto L6;
        Arrays.fill(r8.gw1[r10], 0.0f);
        r10 = r10 + 1;
        goto L4
    L6:
        Arrays.fill(r8.gb1, 0.0f);
        int r11 = 0;
    L8:
        if (r11 >= 32) goto L10;
        Arrays.fill(r8.gw2[r11], 0.0f);
        r11 = r11 + 1;
        goto L8
    L10:
        Arrays.fill(r8.gb2, 0.0f);
        int r12 = 0;
    L12:
        if (r12 >= 16) goto L14;
        Arrays.fill(r8.gw3[r12], 0.0f);
        r12 = r12 + 1;
        goto L12
    L14:
        Arrays.fill(r8.gb3, 0.0f);
        int r13 = 0;
    L16:
        if (r13 >= 8) goto L18;
        r8.gw4[r13][0] = 0.0f;
        r13 = r13 + 1;
        goto L16
    L18:
        r8.gb4[0] = 0.0f;
    }

    public Map<String, Float> evaluate(int[][] r17, float[][] r18) {
        float[][] r8 = r18;
        if (r17 == null) goto L52;
        if (r8 == null) goto L52;
        if (r17.length != r8.length) goto L50;
        int r10 = r17.length;
        float[][] r11 = normalizeBatch(r17);
        HashMap r12 = new HashMap();
        HashMap r13 = new HashMap();
        r12.put("x", r11);
        Weights r14 = getActiveWeightsSnapshot();
        r12.put("w1", r14.f5793w1);
        r12.put("b1", r14.f5789b1);
        r12.put("w2", r14.f5794w2);
        r12.put("b2", r14.f5790b2);
        r12.put("w3", r14.f5795w3);
        r12.put("b3", r14.f5791b3);
        r12.put("w4", r14.f5796w4);
        r12.put("b4", r14.f5792b4);
        float[][] r15 = (float[][]) Array.newInstance(Float.TYPE, new int[]{r10, 1});
        r13.put("prob", r15);
        if (this.mInferInterpreter == null) goto L53;
    L14:
        this.mInferInterpreter.w("infer", r12, r13);
        int r16 = 0;
        int r19 = 0;
        int r20 = 0;
        char r21 = 0;
        int r110 = 1;
        float r111 = 0.0f;
        int r22 = 0;
        int r23 = 0;
    L15:
        float r112 = 1.0E-6f;
        if (r16 >= r10) goto L43;
        float r113 = r8[r16][r21];
        float r24 = r15[r16][r21];
        if (r24 < 1.0E-6f) goto L24;
        r112 = 0.999999f;
        if (r24 > 0.999999f) goto L24;
        r112 = r24;
    L24:
        int r114 = r10;
        r111 = r111 + (-(((1.0f - r113) * ((float) Math.log(1.0f - r112))) + (((float) Math.log(r112)) * r113)));
        if (r112 < 0.5f) goto L27;
        boolean r25 = true;
    L29:
        if (r113 < 0.5f) goto L31;
        boolean r26 = true;
    L32:
        if (r25 == false) goto L35;
        if (r26 == false) goto L35;
        r22 = r22 + 1;
    L42:
        r16 = r16 + 1;
        r110 = 1;
        r21 = 0;
        r8 = r18;
        r10 = r114;
    L35:
        if (r25 == false) goto L38;
        if (r26 == true) goto L38;
        r19 = r19 + 1;
    L38:
        if (r25 == true) goto L41;
        if (r26 == true) goto L41;
        r23 = r23 + 1;
    L41:
        r20 = r20 + 1;
        goto L42
    L31:
        r26 = false;
        goto L32
    L27:
        r25 = false;
        goto L29
    L43:
        int r27 = r10;
        float r115 = r111 / Math.max(r110, r27);
        float r28 = (r22 + r23) / Math.max(r110, r27);
        float r29 = r22;
        float r30 = r29 / Math.max(r110, r22 + r19);
        float r31 = r29 / Math.max(r110, r22 + r20);
        float r32 = r30 + r31;
        if (r32 <= 1.0E-6f) goto L46;
        float r116 = ((2.0f * r30) * r31) / r32;
    L47:
        HashMap r33 = new HashMap();
        r33.put("loss", Float.valueOf(r115));
        r33.put(LocationMonitorConst.ACCURACY, Float.valueOf(r28));
        r33.put("precision", Float.valueOf(r30));
        r33.put("recall", Float.valueOf(r31));
        r33.put("f1", Float.valueOf(r116));
        r33.put("tp", Float.valueOf(r29));
        r33.put("fp", Float.valueOf(r19));
        r33.put("tn", Float.valueOf(r23));
        r33.put("fn", Float.valueOf(r20));
        StringBuilder r34 = new StringBuilder("Eval metrics -> loss=");
        r34.append(r115);
        r34.append(", acc=");
        r34.append(r28);
        r34.append(", prec=");
        r34.append(r30);
        r34.append(", rec=");
        r34.append(r31);
        r34.append(", f1=");
        r34.append(r116);
        r34.append(", TP=");
        defpackage.b.q(r34, r22, ", FP=", r19, ", TN=");
        r34.append(r23);
        r34.append(", FN=");
        r34.append(r20);
        CaeLog.i(TAG, r34.toString());
        return r33;
    L46:
        r116 = 0.0f;
        goto L47
    L53:
        loadInterpreter();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        CaeLog.e(TAG, "load infer interpreter failed: " + e.getMessage(), e);
        return new HashMap();
    L50:
        throw new IllegalArgumentException("batch size mismatch");
    L52:
        throw new IllegalArgumentException("null batch");
    }

    public float predict(int[] r8) {
        if (r8 == null) goto L15;
        if (r8.length != 11) goto L15;
        Class r10 = Float.TYPE;
        float[][] r11 = (float[][]) Array.newInstance(r10, new int[]{1, 11});
        System.arraycopy(normalize(r8), 0, r11[0], 0, 11);
        HashMap r12 = new HashMap();
        r12.put("x", r11);
        Weights r13 = getActiveWeightsSnapshot();
        r12.put("w1", r13.f5793w1);
        r12.put("b1", r13.f5789b1);
        r12.put("w2", r13.f5794w2);
        r12.put("b2", r13.f5790b2);
        r12.put("w3", r13.f5795w3);
        r12.put("b3", r13.f5791b3);
        r12.put("w4", r13.f5796w4);
        r12.put("b4", r13.f5792b4);
        float[][] r14 = (float[][]) Array.newInstance(r10, new int[]{1, 1});
        HashMap r15 = new HashMap();
        r15.put("prob", r14);
        if (this.mInferInterpreter == null) goto L16;
    L12:
        this.mInferInterpreter.w("infer", r12, r15);
        return r14[0][0];
    L16:
        loadInterpreter();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        CaeLog.e(TAG, "load infer interpreter failed: " + e.getMessage());
        return 0.0f;
    L15:
        throw new IllegalArgumentException("params length must be 11");
    }

    public void saveUpdatedModel() {
        Weights r8 = getActiveWeightsSnapshot();
        JSONObject r10 = new JSONObject();
        r10.put("w1", toJson2DArray(r8.f5793w1));     // Catch: Exception -> L16
        r10.put("b1", toJson1DArray(r8.f5789b1));     // Catch: Exception -> L16
        r10.put("w2", toJson2DArray(r8.f5794w2));     // Catch: Exception -> L16
        r10.put("b2", toJson1DArray(r8.f5790b2));     // Catch: Exception -> L16
        r10.put("w3", toJson2DArray(r8.f5795w3));     // Catch: Exception -> L16
        r10.put("b3", toJson1DArray(r8.f5791b3));     // Catch: Exception -> L16
        r10.put("w4", toJson2DArray(r8.f5796w4));     // Catch: Exception -> L16
        r10.put("b4", toJson1DArray(r8.f5792b4));     // Catch: Exception -> L16
        AtomicFile r11 = new AtomicFile(new File(this.context.getFilesDir(), SAVED_WEIGHTS_FILE));
        FileOutputStream r12 = r11.startWrite();     // Catch: IOException -> L10
        r12.write(r10.toString().getBytes(StandardCharsets.UTF_8));     // Catch: IOException -> L8
        r12.flush();     // Catch: IOException -> L8
        r11.finishWrite(r12);     // Catch: IOException -> L8
        return;
    L8:
        e = e;
    L12:
        if (r12 != null) goto L22;
    L14:
        CaeLog.e(TAG, "Failed to save updated weights: " + e.getMessage(), e);
        return;
    L22:
        r11.failWrite(r12);     // Catch: Throwable -> L19
    L10:
        e = e;
        r12 = null;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "Failed to serialize updated weights: " + e.getMessage(), e);
    }

    public float train(int[][] r8, float[][] r10, float r11, int r12) {
        int r13 = 1;
        if (r8 == null) goto L7;
        r13 = Math.max(1, r8.length);
    L7:
        return train(r8, r10, r11, r12, r13);
    }

    public float train(int[][] r65, float[][] r66, float r67, int r68, int r69) {
        int r13 = r68;
        Object r14 = this.mTrainLock;
        monitor-enter(r14);
        if (r65 == null) goto L64;
        if (r66 == null) goto L64;
        if (r65.length != r66.length) goto L62;
        int r15 = r65.length;     // Catch: Throwable -> L65
        if (r69 > 0) goto L11;
        int r10 = 16;
    L12:
        ensureTrainIOAllocated(r10, r67);     // Catch: Throwable -> L65
        ensureTrainWorkspaceAllocated(r10);     // Catch: Throwable -> L65
        TrainWorkspace r11 = this.mTrainWs;     // Catch: Throwable -> L65
        Weights r8 = getActiveWeightsSnapshot();     // Catch: Throwable -> L65
        Object r12 = this.mWeightsLock;     // Catch: Throwable -> L65
        monitor-enter(r12);     // Catch: Throwable -> L65
        Weights r16 = this.mTrainWeights;     // Catch: Throwable -> L58
        deepCopy2D(r8.f5793w1, r16.f5793w1);     // Catch: Throwable -> L58
        deepCopy1D(r8.f5789b1, r16.f5789b1);     // Catch: Throwable -> L58
        deepCopy2D(r8.f5794w2, r16.f5794w2);     // Catch: Throwable -> L58
        deepCopy1D(r8.f5790b2, r16.f5790b2);     // Catch: Throwable -> L58
        deepCopy2D(r8.f5795w3, r16.f5795w3);     // Catch: Throwable -> L58
        deepCopy1D(r8.f5791b3, r16.f5791b3);     // Catch: Throwable -> L58
        deepCopy2D(r8.f5796w4, r16.f5796w4);     // Catch: Throwable -> L58
        deepCopy1D(r8.f5792b4, r16.f5792b4);     // Catch: Throwable -> L58
        monitor-exit(r12);     // Catch: Throwable -> L58
        float[][] r17 = r16.f5793w1;     // Catch: Throwable -> L65
        float[] r18 = r16.f5789b1;     // Catch: Throwable -> L65
        float[][] r19 = r16.f5794w2;     // Catch: Throwable -> L65
        float[] r20 = r16.f5790b2;     // Catch: Throwable -> L65
        float[][] r21 = r16.f5795w3;     // Catch: Throwable -> L65
        float[] r22 = r16.f5791b3;     // Catch: Throwable -> L65
        float[][] r110 = r16.f5796w4;     // Catch: Throwable -> L65
        float[] r111 = r16.f5792b4;     // Catch: Throwable -> L65
        float[] r112 = r22;
        float r34 = this.mDrop1Arr[0];     // Catch: Throwable -> L65
        float r35 = this.mDrop2Arr[0];     // Catch: Throwable -> L65
        float r23 = 1.0f;
        float r113 = 1.0f - r34;     // Catch: Throwable -> L65
        if (r113 <= 1.0E-6f) goto L19;
        float r36 = 1.0f / r113;     // Catch: Throwable -> L65
    L20:
        float r114 = 1.0f - r35;     // Catch: Throwable -> L65
        if (r114 <= 1.0E-6f) goto L23;
        r23 = 1.0f / r114;     // Catch: Throwable -> L65
    L23:
        float r37 = r23;
        float r38 = this.mL2Arr[0];     // Catch: Throwable -> L65
        float r39 = this.mLrW1Arr[0];     // Catch: Throwable -> L65
        float r40 = this.mLrB1Arr[0];     // Catch: Throwable -> L65
        float r41 = this.mLrW2Arr[0];     // Catch: Throwable -> L65
        float r42 = this.mLrB2Arr[0];     // Catch: Throwable -> L65
        float r43 = this.mLrW3Arr[0];     // Catch: Throwable -> L65
        float r44 = this.mLrB3Arr[0];     // Catch: Throwable -> L65
        float r45 = this.mLrW4Arr[0];     // Catch: Throwable -> L65
        float r46 = this.mLrB4Arr[0];     // Catch: Throwable -> L65
        float[][] r115 = r21;
        int[] r24 = new int[r15];     // Catch: Throwable -> L65
        int r610 = Math.max(20, Math.min(40, r13 / 30));     // Catch: Throwable -> L65
        int r25 = 0;
    L24:
        if (r25 >= r15) goto L26;
        r24[r25] = r25;     // Catch: Throwable -> L65
        r25 = r25 + 1;     // Catch: Throwable -> L65
        goto L24
    L26:
        float[] r116 = r20;
        float[][] r117 = r19;
        Random r26 = new Random(42);     // Catch: Throwable -> L65
        float r27 = Float.POSITIVE_INFINITY;
        int r28 = 0;
        int r47 = 0;
    L27:
        if (r28 >= r13) goto L47;
        shuffleInPlace(r24);     // Catch: Throwable -> L65
        float[] r29 = r18;
        float r48 = 0.0f;
        int r30 = 0;
        int r118 = 0;
    L29:
        if (r30 >= r15) goto L31;
        int r611 = r118;
        int r119 = r30 + r10;     // Catch: Throwable -> L65
        int r210 = Math.min(r15, r119);     // Catch: Throwable -> L65
        Weights r211 = r16;
        Weights r212 = r8;
        int[] r50 = r24;
        float[] r49 = r112;
        Random r52 = r26;
        float[][] r51 = r115;
        float[] r53 = r116;
        float[][] r55 = r117;
        float[] r57 = r29;
        float[][] r58 = r17;
        TrainWorkspace r61 = r11;
        fillBatchSliceFixed(r65, r66, r50, r30, r210, this.mXBatchBuf, this.mYBatchBuf, r210 - r30, r10);     // Catch: Throwable -> L65
        normalizeBatchInto(this.mXBatchBuf, this.mXNormBuf);     // Catch: Throwable -> L65
        forwardBatch(r61, this.mXNormBuf, r58, r57, r55, r53, r51, r49, r110, r111, 0.1f, r34, r36, r35, r37, r52);     // Catch: Throwable -> L65
        float r31 = computeLossAndDLogits(r61, this.mYBatchBuf, r58, r55, r51, r110, r38);     // Catch: Throwable -> L65
        zeroGrads(r61);     // Catch: Throwable -> L65
        backwardBatch(r61, this.mXNormBuf, r55, r51, r110, 0.1f);     // Catch: Throwable -> L65
        applyL2Grads(r61, r58, r55, r51, r110, r38);     // Catch: Throwable -> L65
        sgdUpdate(r61, r58, r57, r55, r53, r51, r49, r110, r111, r39, r40, r41, r42, r43, r44, r45, r46);     // Catch: Throwable -> L65
        this.mLossBuf[0] = r31;     // Catch: Throwable -> L65
        r48 = r48 + r31;     // Catch: Throwable -> L65
        r30 = r119;
        r610 = r610;
        r27 = r27;
        r112 = r49;
        r115 = r51;
        r26 = r52;
        r116 = r53;
        r28 = r28;
        r117 = r55;
        r15 = r15;
        r29 = r57;
        r17 = r58;
        r16 = r211;
        r8 = r212;
        r11 = r61;
        r10 = r10;
        r118 = r611 + 1;     // Catch: Throwable -> L65
        r24 = r50;
        goto L29
    L31:
        int[] r54 = r24;
        Random r56 = r26;
        int r59 = r28;
        float[][] r510 = r17;
        Weights r511 = r16;
        Weights r60 = r8;
        TrainWorkspace r62 = r11;
        int r63 = r10;
        int r612 = r118;
        int r512 = r15;
        float[] r410 = r112;
        float[][] r513 = r115;
        float[][] r514 = r117;
        float[] r515 = r116;
        float[] r516 = r29;
        int r120 = r610;
        float r121 = r27;
        if (r612 <= 0) goto L34;
        float r411 = r48 / r612;     // Catch: Throwable -> L65
    L36:
        if (Float.isNaN(r411) == true) goto L45;
        if ((r411 + 1.0E-4f) >= r121) goto L40;
        r68 = r68;
        r47 = 0;
        r27 = r411;
    L46:
        r610 = r120;
        r112 = r410;
        r115 = r513;
        r26 = r56;
        r116 = r515;
        r117 = r514;
        r15 = r512;
        r18 = r516;
        r17 = r510;
        r16 = r511;
        r8 = r60;
        r11 = r62;
        r10 = r63;
        r13 = r68;
        r28 = r59 + 1;     // Catch: Throwable -> L65
        r24 = r54;
        goto L27
    L40:
        int r32 = r47 + 1;     // Catch: Throwable -> L65
        if (r32 >= r120) goto L42;
        r47 = r32;
        goto L45
    L42:
        CaeLog.i(TAG, "early stop at epoch " + (r59 + 1) + ", total steps=" + r68 + ", bestLoss=" + r121 + ", patience=" + r120);     // Catch: Throwable -> L65
    L48:
        Object r33 = this.mWeightsLock;     // Catch: Throwable -> L65
        monitor-enter(r33);     // Catch: Throwable -> L65
        this.mActiveWeights = r511;     // Catch: Throwable -> L55
        this.mTrainWeights = r60;     // Catch: Throwable -> L55
        monitor-exit(r33);     // Catch: Throwable -> L55
        monitor-exit(r14);     // Catch: Throwable -> L65
        return r121;
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L45:
        r27 = r121;
        goto L46
    L34:
        r411 = Float.NaN;
        goto L36
    L47:
        r121 = r27;
        r511 = r16;
        r60 = r8;
        goto L48
    L19:
        r36 = 1.0f;
        goto L20
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L11:
        r10 = r69;
        goto L12
    L62:
        throw new IllegalArgumentException("dataset size mismatch");     // Catch: Throwable -> L65
    L64:
        throw new IllegalArgumentException("null dataset");     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    }
}
