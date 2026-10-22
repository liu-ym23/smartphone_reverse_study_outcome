package com.bytedance.crash.util;

import com.bytedance.crash.NpthBus;
import com.bytedance.librarian.a;

/* JADX INFO: loaded from: classes.dex */
public class SoUtils {
    public SoUtils() {
    }

    public static boolean loadLib(String r10) {
        System.loadLibrary(r10);     // Catch: Throwable -> L4
        return true;
    L4:
        a.a(r10, NpthBus.getApplicationContext());     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }
}
