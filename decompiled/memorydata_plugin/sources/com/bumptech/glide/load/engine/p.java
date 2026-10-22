package com.bumptech.glide.load.engine;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, j<?>> f805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, j<?>> f806b;

    p() {
        this.f805a = new HashMap();
        this.f806b = new HashMap();
    }

    private Map<com.bumptech.glide.load.c, j<?>> a(boolean r1) {
        if (r1 == false) goto L5;
        return this.f806b;
    L5:
        return this.f805a;
    }

    j<?> a(com.bumptech.glide.load.c r3, boolean r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        return (j) ZeusTransformUtils.preCheckCast(a(r4).get(r5), j.class, "com.obric.memorydata.plugin");
    }

    void a(com.bumptech.glide.load.c r3, j<?> r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        a(r4.a()).put(r5, r4);
    }

    void b(com.bumptech.glide.load.c r3, j<?> r4) {
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map<com.bumptech.glide.load.c, j<?>> r2 = a(r4.a());
        if (r4.equals(r2.get(r5)) == false) goto L6;
        r2.remove(r5);
        return;
    }
}
