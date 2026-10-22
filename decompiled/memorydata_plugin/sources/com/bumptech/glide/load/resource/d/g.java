package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class g<Z> implements e<Z, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g<?> f896a = null;

    static {
        f896a = new g();
    }

    public g() {
    }

    public static <Z> e<Z, Z> a() {
        return f896a;
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public s<Z> a(s<Z> r1, com.bumptech.glide.load.e r2) {
        return (s) ZeusTransformUtils.wrapperContextForParams(r1, s.class, "com.obric.memorydata.plugin");
    }
}
