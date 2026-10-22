package com.bytedance.android.live.core.resources;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final Map<String, List<String>> a(h r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$getModelNamesMap");
        String r7 = r6.l3();
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L15;
        Gson r0 = l97.a.a;
        KTypeProjection.Companion r2 = KTypeProjection.Companion;
        return (Map) GsonProtectorUtils.fromJson(r0, r7, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, r2.invariant(Reflection.typeOf(String.class)), r2.invariant(Reflection.typeOf(List.class, r2.invariant(Reflection.typeOf(String.class)))))));
    L15:
        return null;
    L7:
        r1 = false;
        goto L8
    }
}
