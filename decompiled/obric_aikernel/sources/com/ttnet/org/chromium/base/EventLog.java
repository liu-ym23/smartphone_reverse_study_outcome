package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class EventLog {
    public EventLog() {
    }

    @CalledByNative
    public static void writeEvent(int r10, int r11) {
        android.util.EventLog.writeEvent(r10, r11);
    }
}
