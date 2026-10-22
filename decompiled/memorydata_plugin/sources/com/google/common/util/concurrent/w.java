package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class w<V> extends a.i<V> {
    private w() {
    }

    public static <V> w<V> g() {
        return new w();
    }

    @Override // com.google.common.util.concurrent.a
    public boolean a(l<? extends V> r3) {
        return super.a((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.util.concurrent.a
    public boolean a(V r1) {
        return super.a(r1);
    }

    @Override // com.google.common.util.concurrent.a
    public boolean a(Throwable r1) {
        return super.a(r1);
    }
}
