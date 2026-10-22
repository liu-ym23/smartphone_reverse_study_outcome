package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.tensorflow.lite.d;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlModel {
    private static final String TAG = "A2dpJitterMlModel";
    private static volatile A2dpJitterMlModel sInstance;
    private final Context mAppContext;
    private final String mAssetModelName;
    private final int mFeatureDim;
    private final d mInterpreter;
    private final int mOutputDim;
    private final Object mRunLock;
    private final int mSeqLen;

    private A2dpJitterMlModel(Context r8, String r10) {
        this.mRunLock = new Object();
        Context r11 = r8.getApplicationContext();
        this.mAppContext = r11;
        this.mAssetModelName = r10;
        MappedByteBuffer r12 = mapAssetFile(r11, r10);
        d.a r13 = new d.a();
        r13.f9837c = Boolean.TRUE;
        r13.f9836b = 1;
        d r14 = new d(r12, r13);
        this.mInterpreter = r14;
        int[] r15 = r14.i().a();
        if (r15 == null) goto L30;
        if (r15.length != 3) goto L30;
        if (r15[0] != 1) goto L28;
        this.mSeqLen = r15[1];
        this.mFeatureDim = r15[2];
        int[] r16 = r14.n().a();
        if (r16 == null) goto L26;
        if (r16.length < 1) goto L26;
        if (r16.length != 1) goto L16;
        int r17 = r16[0];
    L23:
        this.mOutputDim = r17;
        return;
    L16:
        if (r16.length == 2) goto L18;
        r17 = Math.max(1, r16[r16.length - 1]);
        goto L23
    L18:
        if (r16[0] != 1) goto L21;
        r17 = r16[1];
        goto L23
    L21:
        throw new IllegalStateException("Unsupported output batch size: " + r16[0]);
    L26:
        throw new IllegalStateException("Unexpected output shape: " + shapeToString(r16));
    L28:
        throw new IllegalStateException("Unsupported batch size: " + r15[0]);
    L30:
        throw new IllegalStateException("Unexpected input shape: " + shapeToString(r15));
    }

    public static A2dpJitterMlModel getInstance(Context r8, String r10) {
        A2dpJitterMlModel r11 = sInstance;
        if (r11 == null) goto L10;
        if (r11.mAssetModelName.equals(r10) == false) goto L8;
        return r11;
    L8:
        throw new IllegalStateException("A2dpJitterMlModel already initialized with model=" + r11.mAssetModelName + ", requested model=" + r10);
    L10:
        if (sInstance != null) goto L22;
        monitor-enter(A2dpJitterMlModel.class);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (sInstance != null) goto L16;
        sInstance = new A2dpJitterMlModel(r8, r10);     // Catch: Throwable -> L18
    L16:
        monitor-exit(A2dpJitterMlModel.class);     // Catch: Throwable -> L18
    L22:
        return sInstance;
    }

    private static MappedByteBuffer mapAssetFile(Context r8, String r10) {
        AssetFileDescriptor r11 = r8.getAssets().openFd(r10);     // Catch: IOException -> L22
        FileInputStream r12 = r11.createInputStream();     // Catch: Throwable -> L15
        FileChannel r13 = r12.getChannel();     // Catch: Throwable -> L8
        long r14 = r11.getStartOffset();     // Catch: Throwable -> L8
        long r15 = r11.getDeclaredLength();     // Catch: Throwable -> L8
        MappedByteBuffer r16 = r13.map(FileChannel.MapMode.READ_ONLY, r14, r15);     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L15
        r11.close();     // Catch: IOException -> L22
        return r16;
    L8:
        th = move-exception;
        if (r12 != null) goto L71;
    L14:
        throw th;     // Catch: Throwable -> L15
    L71:
        r12.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r11 != null) goto L65;
    L21:
        throw th;     // Catch: IOException -> L22
    L65:
        r11.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        String r17 = r10.replace('/', '_');
        File r18 = new File(r8.getFilesDir(), r17);
        if (r18.exists() == true) goto L47;
        InputStream r19 = r8.getAssets().open(r10);
        FileOutputStream r20 = new FileOutputStream(r18, false);     // Catch: Throwable -> L40
        byte[] r21 = new byte[8192];     // Catch: Throwable -> L34
    L28:
        int r22 = r19.read(r21);     // Catch: Throwable -> L34
        if (r22 == (-1)) goto L32;
        r20.write(r21, 0, r22);     // Catch: Throwable -> L34
    L32:
        r20.close();     // Catch: Throwable -> L40
        r19.close();
    L34:
        th = move-exception;
        r20.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: Throwable -> L40
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        if (r19 != null) goto L67;
    L46:
        throw th;
    L67:
        r19.close();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.addSuppressed(th);
    L47:
        FileInputStream r23 = new FileInputStream(r18);
        FileChannel r24 = r23.getChannel();     // Catch: Throwable -> L51
        MappedByteBuffer r25 = r24.map(FileChannel.MapMode.READ_ONLY, 0, r24.size());     // Catch: Throwable -> L51
        r23.close();
        return r25;
    L51:
        th = move-exception;
        r23.close();     // Catch: Throwable -> L54
    L56:
        throw th;
    L54:
        th = move-exception;
        th.addSuppressed(th);
        goto L56
    }

    private static String shapeToString(int[] r8) {
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L7:
        if (r11 >= r8.length) goto L12;
        r10.append(r8[r11]);
        if (r11 >= (r8.length - 1)) goto L11;
        r10.append(',');
    L11:
        r11 = r11 + 1;
        goto L7
    L12:
        r10.append(']');
        return r10.toString();
    }

    public void close() {
        this.mInterpreter.close();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("close error: "), TAG);
    }

    public int getFeatureDim() {
        return this.mFeatureDim;
    }

    public int getOutputDim() {
        return this.mOutputDim;
    }

    public int getSeqLen() {
        return this.mSeqLen;
    }

    public float[] infer(float[][][] r8) {
        if (r8 != null) goto L4;
    L26:
        StringBuilder r10 = new StringBuilder("inputSeq shape must be [1][");
        r10.append(this.mSeqLen);
        r10.append("][");
        throw new IllegalArgumentException(android.aimedia.a.h(r10, this.mFeatureDim, "]"));
    L4:
        if (r8.length != 1) goto L26;
        if (r8[0].length != this.mSeqLen) goto L26;
        int r11 = 0;
    L9:
        if (r11 >= this.mSeqLen) goto L17;
        float[] r12 = r8[0][r11];
        if (r12 == null) goto L15;
        if (r12.length != this.mFeatureDim) goto L15;
        r11 = r11 + 1;
    L15:
        StringBuilder r13 = new StringBuilder("inputSeq shape must be [1][");
        r13.append(this.mSeqLen);
        r13.append("][");
        throw new IllegalArgumentException(android.aimedia.a.h(r13, this.mFeatureDim, "]"));
    L17:
        float[][] r14 = (float[][]) Array.newInstance(Float.TYPE, new int[]{1, this.mOutputDim});
        Object r15 = this.mRunLock;
        monitor-enter(r15);
        this.mInterpreter.v(r8, r14);     // Catch: Throwable -> L23
        monitor-exit(r15);     // Catch: Throwable -> L23
        return r14[0];
    L23:
        th = move-exception;
        throw th;
    }
}
