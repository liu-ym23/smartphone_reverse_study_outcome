package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class d<T extends m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f756a;

    d() {
        this.f756a = com.bumptech.glide.util.k.b(20);
    }

    public void a(T r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        if (this.f756a.size() >= 20) goto L6;
        this.f756a.offer((T) r4);
        return;
    }

    abstract T b();

    T c() {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.f756a.poll(), m.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (T) b();
    }
}
