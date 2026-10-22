package com.ttnet.org.chromium.base.compat;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.view.Display;
import android.view.InputEvent;
import android.view.VerifiedInputEvent;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiHelperForR {
    private ApiHelperForR() {
    }

    public static Display getDisplay(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getDisplay();
    }

    public static Rect getMaximumWindowMetricsBounds(WindowManager r2) {
        return ((WindowManager) ZeusTransformUtils.wrapperContextForParams(r2, WindowManager.class, "com.obric.memorydata.plugin")).getMaximumWindowMetrics().getBounds();
    }

    public static File getVolumeDir(StorageManager r0, Uri r1) {
        return r0.getStorageVolume(r1).getDirectory();
    }

    public static void setProcessStateSummary(ActivityManager r0, byte[] r1) {
        r0.setProcessStateSummary(r1);
    }

    public static VerifiedInputEvent verifyInputEvent(InputManager r0, InputEvent r1) {
        return r0.verifyInputEvent(r1);
    }
}
