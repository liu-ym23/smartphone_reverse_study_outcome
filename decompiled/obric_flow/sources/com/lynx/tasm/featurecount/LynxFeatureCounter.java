package com.lynx.tasm.featurecount;

import androidx.annotation.RestrictTo;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LynxFeatureCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f10843a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f10844b;

    static {
        f10844b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.d, false);
    }

    public static void a(int r5, int r10) {
        if (f10844b == true) goto L6;
        return;
    L6:
        if (f10843a == true) goto L9;
        f10843a = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        if (f10843a == false) goto L12;
        nativeFeatureCount(r5, r10);
        return;
    }

    public static native void nativeFeatureCount(int r5, int r10);
}
