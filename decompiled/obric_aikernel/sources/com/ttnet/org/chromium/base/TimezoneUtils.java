package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
class TimezoneUtils {
    private TimezoneUtils() {
    }

    @CalledByNative
    private static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy r10 = StrictMode.allowThreadDiskReads();
        String r11 = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(r10);
        return r11;
    }
}
