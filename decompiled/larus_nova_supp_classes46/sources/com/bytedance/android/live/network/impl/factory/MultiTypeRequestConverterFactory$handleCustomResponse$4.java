package com.bytedance.android.live.network.impl.factory;

import java.lang.reflect.ParameterizedType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"getFirstTypeArgumentClass", "Ljava/lang/Class;", "Ljava/lang/reflect/ParameterizedType;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MultiTypeRequestConverterFactory$handleCustomResponse$4 extends Lambda implements Function1<ParameterizedType, Class<?>> {
    public static final MultiTypeRequestConverterFactory$handleCustomResponse$4 INSTANCE = null;

    static {
        INSTANCE = new MultiTypeRequestConverterFactory$handleCustomResponse$4();
    }

    public MultiTypeRequestConverterFactory$handleCustomResponse$4() {
        super(1);
    }

    public final Class<?> invoke(ParameterizedType r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getFirstTypeArgumentClass");
        Object r0 = ArraysKt.singleOrNull(r3.getActualTypeArguments());
        if ((r0 instanceof Class) == true) goto L5;
        r0 = null;
    L5:
        Class<?> r1 = (Class) r0;
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalStateException(("First type argument of type [" + r3 + "] must be class.").toString());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ParameterizedType) r1);
    }
}
