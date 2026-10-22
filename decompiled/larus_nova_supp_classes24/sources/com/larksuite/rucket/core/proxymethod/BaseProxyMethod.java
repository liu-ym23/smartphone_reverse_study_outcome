package com.larksuite.rucket.core.proxymethod;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class BaseProxyMethod<T extends Annotation> implements b {
    public final Method a;
    public final Lazy b;
    public final Lazy c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/rucket/core/proxymethod/BaseProxyMethod$GenerateProxyMethodError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "<init>", "(Ljava/lang/String;)V", "rucket_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class GenerateProxyMethodError extends Error {
        public GenerateProxyMethodError(String r1) {
            super(r1);
        }
    }

    public abstract Class<T> b();

    public final T c() {
        return (T) this.b.getValue();
    }

    public final GenerateProxyMethodError d() {
        return new GenerateProxyMethodError("\nGenerating Proxy Method Failed: \nPlease recheck the origin method: \"" + this.a.getName() + "()\"\n\n");
    }

    public final <U> Class<U> e() {
        Class<U> r0 = (Class) this.c.getValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.lang.Class<U of com.larksuite.rucket.core.proxymethod.BaseProxyMethod.getResponseClazz>");
        return r0;
    }

    public BaseProxyMethod(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
        this.b = LazyKt.lazy(new BaseProxyMethod$annotationInfo$2(this));
        this.c = LazyKt.lazy(new BaseProxyMethod$responseClass$2(this));
    }

    @Override // com.larksuite.rucket.core.proxymethod.a
    public final Object invoke(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        int r0 = r5.length;
        if (r0 < 1) goto L8;
        if ((r5[0] instanceof IGetDataCallback) == false) goto L8;
        Object[] r1 = ArraysKt.takeLast(r5, r0 - 1).toArray(new Object[0]);
        Object r6 = r5[0];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larksuite.framework.callback.IGetDataCallback<*>");
        a((IGetDataCallback) r6, Arrays.copyOf(r1, r1.length));
    L8:
        return Unit.INSTANCE;
    }
}
