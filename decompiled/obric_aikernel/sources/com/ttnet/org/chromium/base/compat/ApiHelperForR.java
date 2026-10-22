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
import androidx.annotation.RequiresApi;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public final class ApiHelperForR {
    private ApiHelperForR() {
    }

    public static Display getDisplay(Context r10) {
        return r10.getDisplay();
    }

    public static Rect getMaximumWindowMetricsBounds(WindowManager r10) {
        return r10.getMaximumWindowMetrics().getBounds();
    }

    public static File getVolumeDir(StorageManager r10, Uri r11) {
        return r10.getStorageVolume(r11).getDirectory();
    }

    public static void setProcessStateSummary(ActivityManager r10, byte[] r11) {
        r10.setProcessStateSummary(r11);
    }

    public static VerifiedInputEvent verifyInputEvent(InputManager r10, InputEvent r11) {
        return r10.verifyInputEvent(r11);
    }
}
