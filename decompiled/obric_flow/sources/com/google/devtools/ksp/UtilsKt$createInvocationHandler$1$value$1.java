package com.google.devtools.ksp;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class UtilsKt$createInvocationHandler$1$value$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Method $method;
    final /* synthetic */ Object $result;

    public UtilsKt$createInvocationHandler$1$value$1(Object r5, Method r10) {
        this.$result = r5;
        this.$method = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        List r5 = (List) this.$result;
        final Method r10 = this.$method;
        String r11 = r10.getReturnType().getComponentType().getName();
        switch(r11.hashCode()) {
            case -1325958191: goto L57;
            case -530663260: goto L38;
            case 104431: goto L34;
            case 3039496: goto L30;
            case 3052374: goto L26;
            case 3327612: goto L22;
            case 64711720: goto L18;
            case 97526364: goto L14;
            case 109413500: goto L10;
            case 1195259493: goto L6;
            default: goto L59;
        };
    L6:
        if (r11.equals("java.lang.String") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        Object[] r12 = r5.toArray(new String[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return r12;
    L10:
        if (r11.equals("short") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Short>");
        return CollectionsKt.toShortArray(r5);
    L14:
        if (r11.equals("float") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        return CollectionsKt.toFloatArray(r5);
    L18:
        if (r11.equals("boolean") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Boolean>");
        return CollectionsKt.toBooleanArray(r5);
    L22:
        if (r11.equals("long") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
        return CollectionsKt.toLongArray(r5);
    L26:
        if (r11.equals("char") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Char>");
        return CollectionsKt.toCharArray(r5);
    L30:
        if (r11.equals("byte") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Byte>");
        return CollectionsKt.toByteArray(r5);
    L34:
        if (r11.equals("int") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
        return CollectionsKt.toIntArray(r5);
    L38:
        if (r11.equals("java.lang.Class") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<com.google.devtools.ksp.symbol.KSType>");
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));     // Catch: Exception -> L53
        Iterator r14 = r5.iterator();     // Catch: Exception -> L53
        if (r14.hasNext() == true) goto L45;
        Object[] r15 = r13.toArray(new Class[0]);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return r15;
    L45:
        if (r14.next() != null) goto L52;
        throw null;     // Catch: Exception -> L48
    L48:
        e = move-exception;
        throw new KSTypeNotPresentException(null, e);     // Catch: Exception -> L53
    L52:
        throw new ClassCastException();     // Catch: Exception -> L53
    L53:
        e = move-exception;
        throw new KSTypesNotPresentException(r5, e);
    L57:
        if (r11.equals("double") == false) goto L59;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Double>");
        return CollectionsKt.toDoubleArray(r5);
    L59:
        if (r10.getReturnType().getComponentType().isEnum() == false) goto L62;
        return a.c(r5, r10, new UtilsKt$asArray$1(r10));
    L62:
        if (r10.getReturnType().getComponentType().isAnnotation() == false) goto L65;
        return a.c(r5, r10, new UtilsKt$asArray$2(r10));
    L65:
        throw new IllegalStateException("Unable to process type ".concat(r10.getReturnType().getComponentType().getName()));
    }
}
