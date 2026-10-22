package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.soloader.DoNotOptimize;

/* JADX INFO: loaded from: classes2.dex */
@DoNotOptimize
class PreverificationHelper {
    public PreverificationHelper() {
    }

    @DoNotOptimize
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config r5) {
        if (r5 != Bitmap.Config.HARDWARE) goto L6;
        return true;
    L6:
        return false;
    }
}
