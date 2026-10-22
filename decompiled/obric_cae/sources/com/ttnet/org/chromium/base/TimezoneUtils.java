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
        StrictMode.ThreadPolicy r8 = StrictMode.allowThreadDiskReads();
        String r10 = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(r8);
        return r10;
    }
}
