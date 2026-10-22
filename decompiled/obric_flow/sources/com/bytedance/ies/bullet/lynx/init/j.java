package com.bytedance.ies.bullet.lynx.init;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements com.lynx.tasm.h, mm.e, com.bytedance.framwork.core.sdkmonitor.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f5684a = null;

    static {
        f5684a = new j();
    }

    @Override // com.lynx.tasm.h
    public void a(String r5) {
        System.loadLibrary(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.g("Lynx init failed, exception message = " + th.getMessage(), "XLynxKit", th);
    }
}
