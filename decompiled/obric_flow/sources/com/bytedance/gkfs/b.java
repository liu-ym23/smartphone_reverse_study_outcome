package com.bytedance.gkfs;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4813a = null;

    static {
        f4813a = new b();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r10 = new Thread(r5);
        r10.setName("gkfs-parallel");
        r10.setPriority(6);
        return r10;
    }
}
