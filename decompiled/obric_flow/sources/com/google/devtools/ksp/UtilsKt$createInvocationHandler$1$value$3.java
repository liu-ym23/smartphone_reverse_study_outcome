package com.google.devtools.ksp;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class UtilsKt$createInvocationHandler$1$value$3 extends Lambda implements Function0<Object> {
    final /* synthetic */ Method $method;
    final /* synthetic */ Object $result;

    public UtilsKt$createInvocationHandler$1$value$3(Object r5, Method r10) {
        this.$result = r5;
        this.$method = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object r5 = this.$result;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSAnnotation");
        if (r5 != null) goto L7;
        this.$method.getReturnType().getClassLoader();
        throw null;
    L7:
        throw new ClassCastException();
    }
}
