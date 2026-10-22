package com.lightning.edu.ei.edgealgorithm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InferenceHelper {
    public static final int DEVICE_TYPE_AUTO = 4;
    public static final int DEVICE_TYPE_CPU = 0;
    public static final int DEVICE_TYPE_DSP = 2;
    public static final int DEVICE_TYPE_GPU = 1;
    public static final int DEVICE_TYPE_NPU = 3;
    public static final int DEVICE_TYPE_OPENCL = 5;
    private static String TAG = "InferenceHelper";
    private long initCost;
    private long mInference;
    private CountDownLatch mLatch;

    public static Params getVaildParams() {
        Params r0 = new Params();
        r0.blur_status = 1;
        r0.scene_status = 1;
        r0.dark_status = 1;
        r0.orientation_status = 1;
        r0.questions_status = 1;
        return r0;
    }

    public void release() {
        PthreadAsyncTask.execute(new AnonymousClass1(this));
    }

    public String version() {
        return InferenceNative.Version(this.mInference);
    }

    private InferenceHelper() {
        this.initCost = 0;
    }

    public static String getVersion() {
        return InferenceNative.GetVersion();
    }

    private InferenceHelper(long r3) {
        this.initCost = 0;
        this.mInference = r3;
    }

    public static /* synthetic */ CountDownLatch access$000(InferenceHelper r0) {
        return r0.mLatch;
    }

    public static /* synthetic */ long access$100(InferenceHelper r2) {
        return r2.mInference;
    }

    public static /* synthetic */ long access$102(InferenceHelper r0, long r1) {
        r0.mInference = r1;
        return r1;
    }

    public Result runPredict(Bitmap r9, Params r10) {
        Result r0 = new Result();
        if (0 != this.mInference) goto L7;
        r0.pass = false;
        r0.status = 1;
        r0.msg = "Error! mInference is 0.";
        return r0;
    L7:
        if (r9.getWidth() >= 5) goto L9;
    L13:
        r0.pass = false;
        r0.status = 2;
        r0.msg = "Error! input image is too small.";
        return r0;
    L9:
        if (r9.getHeight() < 5) goto L13;
        this.mLatch = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        Result r11 = InferenceNative.PredictBitmap(this.mInference, r9, 0, r10);
        r11.predictCost = System.currentTimeMillis() - r1;
        r11.initCost = this.initCost;
        this.mLatch.countDown();
        return r11;
    }

    public Result runPredict(Bitmap r9, int r10, Params r11) {
        Result r0 = new Result();
        if (0 != this.mInference) goto L7;
        r0.pass = false;
        r0.status = 1;
        r0.msg = "Error! mInference is 0.";
        return r0;
    L7:
        if (r9.getWidth() >= 5) goto L9;
    L13:
        r0.pass = false;
        r0.status = 2;
        r0.msg = "Error! input image is too small.";
        return r0;
    L9:
        if (r9.getHeight() < 5) goto L13;
        this.mLatch = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        Result r12 = InferenceNative.PredictBitmap(this.mInference, r9, r10, r11);
        r12.predictCost = System.currentTimeMillis() - r1;
        r12.initCost = this.initCost;
        this.mLatch.countDown();
        return r12;
    }

    public Result runPredict(int[] r10, int r11, int r12, Params r13) {
        Result r0 = new Result();
        if (0 != this.mInference) goto L7;
        r0.pass = false;
        r0.status = 1;
        r0.msg = "Error! mInference is 0.";
        return r0;
    L7:
        if (r11 < 5) goto L12;
        if (r12 < 5) goto L12;
        this.mLatch = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        Result r14 = InferenceNative.PredictIntArray(this.mInference, r10, r11, r12, 0, r13);
        r14.predictCost = System.currentTimeMillis() - r1;
        r14.initCost = this.initCost;
        this.mLatch.countDown();
        return r14;
    L12:
        r0.pass = false;
        r0.status = 2;
        r0.msg = "Error! input image is too small.";
        return r0;
    }

    public static InferenceHelper initModel(AssetManager r18, int r19, int r20, String r21, Params r22) {
        long r1 = System.currentTimeMillis();
        String r13 = String.valueOf(r22.blur_url);
        int r7 = r22.blur_status;
        String r14 = String.valueOf(r22.scene_url);
        int r8 = r22.scene_status;
        String r15 = String.valueOf(r22.dark_url);
        int r9 = r22.dark_status;
        String r16 = String.valueOf(r22.orientation_url);
        int r10 = r22.orientation_status;
        String r17 = String.valueOf(r22.questions_url);
        long r3 = InferenceNative.InitByAssetManger(r18, r19, r20, r7, r8, r9, r10, r22.questions_status, r21, r13, r14, r15, r16, r17);
        if ((-1) != r3) goto L6;
        return null;
    L6:
        long r5 = System.currentTimeMillis() - r1;
        InferenceHelper r0 = new InferenceHelper(r3);
        r0.initCost = r5;
        return r0;
    }

    public Result runPredict(int[] r10, int r11, int r12, int r13, Params r14) {
        Result r0 = new Result();
        if (0 != this.mInference) goto L7;
        r0.pass = false;
        r0.status = 1;
        r0.msg = "Error! mInference is 0.";
        return r0;
    L7:
        if (r11 < 5) goto L12;
        if (r12 < 5) goto L12;
        this.mLatch = new CountDownLatch(1);
        long r1 = System.currentTimeMillis();
        Result r15 = InferenceNative.PredictIntArray(this.mInference, r10, r11, r12, r13, r14);
        r15.predictCost = System.currentTimeMillis() - r1;
        r15.initCost = this.initCost;
        this.mLatch.countDown();
        return r15;
    L12:
        r0.pass = false;
        r0.status = 2;
        r0.msg = "Error! input image is too small.";
        return r0;
    }
}
