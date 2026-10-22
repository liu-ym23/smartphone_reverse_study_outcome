package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 {
    @Deprecated(message = "请不要传入 scope", replaceWith = @ReplaceWith(expression = "getFacade()", imports = {}))
    public static final uz1.a a() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(uz1.a.class));
    L7:
        return (uz1.a) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final uz1.a b() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(uz1.a.class));
    L7:
        return (uz1.a) r1;
    L5:
        r1 = null;
        goto L7
    }
}
