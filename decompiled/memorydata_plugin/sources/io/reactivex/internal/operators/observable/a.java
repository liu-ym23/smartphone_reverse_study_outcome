package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.s;

/* JADX INFO: loaded from: classes6.dex */
abstract class a<T, U> extends Observable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final s<T> f17034a;

    a(s<T> r3) {
        this.f17034a = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
    }
}
