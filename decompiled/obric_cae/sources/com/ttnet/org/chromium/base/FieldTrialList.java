package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public class FieldTrialList {
    private FieldTrialList() {
    }

    public static String findFullName(String r8) {
        return nativeFindFullName(r8);
    }

    public static String getVariationParameter(String r8, String r10) {
        return nativeGetVariationParameter(r8, r10);
    }

    public static void logActiveTrials() {
        nativeLogActiveTrials();
    }

    private static native String nativeFindFullName(String r8);

    private static native String nativeGetVariationParameter(String r8, String r10);

    private static native void nativeLogActiveTrials();

    private static native boolean nativeTrialExists(String r8);

    public static boolean trialExists(String r8) {
        return nativeTrialExists(r8);
    }
}
