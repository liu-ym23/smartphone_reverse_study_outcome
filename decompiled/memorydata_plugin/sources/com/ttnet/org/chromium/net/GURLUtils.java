package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("net")
public final class GURLUtils {

    public interface Natives {
        String getOrigin(String r1);
    }

    public GURLUtils() {
    }

    public static String getOrigin(String r1) {
        return GURLUtilsJni.get().getOrigin(r1);
    }
}
