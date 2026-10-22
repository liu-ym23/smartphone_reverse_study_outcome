package com.bytedance.android.live.revenue.platform.network.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"getFirstTypeArgumentClass", "Ljava/lang/Class;", "Ljava/lang/reflect/ParameterizedType;", "invoke"}, k = 3, mv = {1, 5, 1})
final class ResponsePBDataDecoder$getDataCollectionConstructorAndType$1 extends Lambda implements Function1<ParameterizedType, Class<?>> {
    public static final ResponsePBDataDecoder$getDataCollectionConstructorAndType$1 INSTANCE = null;

    static {
        INSTANCE = new ResponsePBDataDecoder$getDataCollectionConstructorAndType$1();
    }

    public ResponsePBDataDecoder$getDataCollectionConstructorAndType$1() {
        super(1);
    }

    public final Class<?> invoke(ParameterizedType r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getFirstTypeArgumentClass");
        Type r0 = (Type) ArraysKt.singleOrNull(r3.getActualTypeArguments());
        if ((r0 instanceof WildcardType) == false) goto L6;
        r0 = (Type) ArraysKt.singleOrNull(((WildcardType) r0).getUpperBounds());
    L6:
        if ((r0 instanceof Class) == true) goto L8;
        r0 = null;
    L8:
        Class<?> r1 = (Class) r0;
        if (r1 == null) goto L12;
        return r1;
    L12:
        throw new IllegalStateException(("Type [" + r3 + "] must be class or WildcardType").toString());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ParameterizedType) r1);
    }
}
