package com.google.common.reflect;

import com.google.common.collect.Sets;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Type> f4802a;

    f() {
        this.f4802a = Sets.a();
    }

    void a(Class<?> r1) {
    }

    void a(GenericArrayType r2) {
        GenericArrayType r1 = (GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r2, GenericArrayType.class, "com.obric.memorydata.plugin");
    }

    void a(ParameterizedType r2) {
        ParameterizedType r1 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r2, ParameterizedType.class, "com.obric.memorydata.plugin");
    }

    void a(TypeVariable<?> r2) {
        TypeVariable r1 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r2, TypeVariable.class, "com.obric.memorydata.plugin");
    }

    void a(WildcardType r2) {
        WildcardType r1 = (WildcardType) ZeusTransformUtils.wrapperContextForParams(r2, WildcardType.class, "com.obric.memorydata.plugin");
    }

    public final void a(Type... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L31;
        Type r2 = r6[r1];
        if (r2 == null) goto L30;
        if (this.f4802a.add(r2) == false) goto L30;
    L27:
        th = move-exception;
        this.f4802a.remove(r2);
        throw th;
    L11:
        if (ZeusTransformUtils.instanceOf(r2, TypeVariable.class) == false) goto L14;
        a((TypeVariable) ZeusTransformUtils.preCheckCast(r2, TypeVariable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L30
    L14:
        if (ZeusTransformUtils.instanceOf(r2, WildcardType.class) == false) goto L17;
        a((WildcardType) ZeusTransformUtils.preCheckCast(r2, WildcardType.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L30
    L17:
        if (ZeusTransformUtils.instanceOf(r2, ParameterizedType.class) == false) goto L20;
        a((ParameterizedType) ZeusTransformUtils.preCheckCast(r2, ParameterizedType.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L30
    L20:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L23;
        a((Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L30
    L23:
        if (ZeusTransformUtils.instanceOf(r2, GenericArrayType.class) == false) goto L26;
        a((GenericArrayType) ZeusTransformUtils.preCheckCast(r2, GenericArrayType.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        goto L30
    L26:
        throw new AssertionError("Unknown type: " + r2);     // Catch: Throwable -> L27
    L30:
        r1 = r1 + 1;
        goto L3
    }
}
