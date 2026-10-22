package com.tencent.wcdb.repair;

import com.tencent.wcdb.support.a;

/* JADX INFO: loaded from: classes6.dex */
public class RecoverKit implements a.InterfaceC0846a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15876a;

    private static native void nativeCancel(long r0);

    private static native int nativeFailureCount(long r0);

    private static native void nativeFinish(long r0);

    private static native long nativeInit(String r0, byte[] r1);

    private static native String nativeLastError(long r0);

    private static native int nativeRun(long r0, long r2, boolean r4);

    private static native int nativeSuccessCount(long r0);

    public void a() {
        long r0 = this.f15876a;
        if (r0 == 0) goto L6;
        nativeFinish(r0);
        this.f15876a = 0;
        return;
    }

    @Override // com.tencent.wcdb.support.a.InterfaceC0846a
    public void c() {
        long r0 = this.f15876a;
        if (r0 == 0) goto L6;
        nativeCancel(r0);
        return;
    }

    public void finalize() {
        a();
        super.finalize();
    }
}
