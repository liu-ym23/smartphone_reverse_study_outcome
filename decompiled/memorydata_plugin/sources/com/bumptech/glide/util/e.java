package com.bumptech.glide.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    public interface a<T> {
        T b();
    }

    public static <T> a<T> a(a<T> r2) {
        final a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }
}
