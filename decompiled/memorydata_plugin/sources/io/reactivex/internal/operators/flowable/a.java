package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;

/* JADX INFO: loaded from: classes6.dex */
abstract class a<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final g<T> f16812b;

    a(g<T> r3) {
        this.f16812b = (g) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r3, "source is null"), g.class, "com.obric.memorydata.plugin");
    }
}
