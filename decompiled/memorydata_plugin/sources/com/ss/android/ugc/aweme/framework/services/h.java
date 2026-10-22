package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class h<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g<T> f15751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile T f15752b;

    public h(g r3) {
        this.f15751a = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.ugc.aweme.framework.services.g
    public synchronized T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f15752b != null) goto L6;
        this.f15752b = this.f15751a.get();     // Catch: Throwable -> L9
    L6:
        T r0 = this.f15752b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }
}
