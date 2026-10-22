package com.bytedance.ies.bullet.preloadv2;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5879a = null;

    static {
        f5879a = new b();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r10 = new Thread(r5, "bullet_preload_" + r5.hashCode());
        com.bytedance.ies.bullet.base.utils.b.g("generate preload thread, coreSize " + c.d + ", maxSize " + c.e);
        return r10;
    }
}
