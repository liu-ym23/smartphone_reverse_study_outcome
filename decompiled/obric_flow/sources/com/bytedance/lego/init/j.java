package com.bytedance.lego.init;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f6738a = null;

    static {
        f6738a = new j();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        return new Thread(r5, "A-DelayTaskThread");
    }
}
