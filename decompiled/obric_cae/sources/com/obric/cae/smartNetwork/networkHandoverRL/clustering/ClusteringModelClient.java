package com.obric.cae.smartNetwork.networkHandoverRL.clustering;

import android.content.Context;
import com.obric.cae.utils.AIKernelJavaBridge;
import java.util.function.Consumer;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class ClusteringModelClient {
    private static final long APP_ID = 12345;
    private static final String MODEL_NAME = "k_means";
    private final Context context;

    public ClusteringModelClient(Context r8) {
        this.context = r8.getApplicationContext();
    }

    public static /* synthetic */ j a(Consumer r8, Float r10) {
        return lambda$runAsync$0(r8, r10);
    }

    private static /* synthetic */ j lambda$runAsync$0(Consumer r8, Float r10) {
        if (r8 == null) goto L6;
        r8.accept(r10);
        return null;
    L6:
        return null;
    }

    public void init() {
        AIKernelJavaBridge.initAndLoadModel(APP_ID, this.context, MODEL_NAME);
    }

    public boolean isReady() {
        return AIKernelJavaBridge.isModelLoadSuccess(MODEL_NAME);
    }

    public void release() {
        AIKernelJavaBridge.releaseModel(MODEL_NAME);
    }

    public void runAsync(float r8, float r10, float r11, float r12, float r13, float r14, final Consumer<Float> r15) {
        AIKernelJavaBridge.runModelInferenceAsync(MODEL_NAME, "wifi_scan_features", new float[]{r8, r10, r11, r12, r13, r14}, new a(r15));
    }

    public Float runSync(float r8, float r10, float r11, float r12, float r13, float r14) {
        return AIKernelJavaBridge.runModelInferenceSync(MODEL_NAME, "wifi_scan_features", new float[]{r8, r10, r11, r12, r13, r14});
    }
}
