package com.google.devtools.ksp;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class UtilsKt$createInvocationHandler$1$value$2 extends Lambda implements Function0<Object> {
    final /* synthetic */ Method $method;
    final /* synthetic */ Object $result;

    public UtilsKt$createInvocationHandler$1$value$2(Object r5, Method r10) {
        this.$result = r5;
        this.$method = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object r5 = this.$result;
        return this.$method.getReturnType().getDeclaredMethod("valueOf", new Class[]{String.class}).invoke(null, new Object[]{r5.toString()});
    }
}
