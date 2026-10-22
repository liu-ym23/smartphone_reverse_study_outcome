package com.bytedance.crash.npth_fd_track;

import androidx.annotation.Keep;
import io.reactivex.exceptions.a;

/* JADX INFO: loaded from: classes2.dex */
public class FDNativeTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4079a = false;

    public static int a() {
        if (f4079a == false) goto L8;
        int r5 = nativeGetFdCount();
        if (r5 > 0) goto L7;
        a.d("[FDNativeTools]: ", "get fd count err: " + r5);
    L7:
        return r5;
    L8:
        return -111;
    }

    public static int b(int r5) {
        if (f4079a == false) goto L8;
        int r10 = nativeDoCommand(r5);
        if (r10 == 0) goto L7;
        a.d("[FDNativeTools]: ", r5 + " ==> " + r10);
    L7:
        return r10;
    L8:
        return -111;
    }

    public static int c(String[] r5) {
        if (f4079a == false) goto L8;
        int r10 = doInitNativeParams(r5);
        if (r10 == 0) goto L7;
        a.d("[FDNativeTools]: ", "init params err: " + r10);
    L7:
        return r10;
    L8:
        return -111;
    }

    @Keep
    private static native int doInitNativeParams(String[] r5);

    @Keep
    private static native int nativeDoCommand(int r5);

    @Keep
    private static native int nativeGetFdCount();
}
