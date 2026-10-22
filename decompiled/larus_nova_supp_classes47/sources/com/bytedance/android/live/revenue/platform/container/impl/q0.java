package com.bytedance.android.live.revenue.platform.container.impl;

import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0<T, R> implements Function {
    public final /* synthetic */ RpcMethodImpl a;

    public q0(RpcMethodImpl r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        JsonObject r5 = (JsonObject) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        uh7.c r0 = uh7.c.d;
        KClass r1 = Reflection.getOrCreateKotlinClass(zz0.j.class);
        Type r2 = TypesJVMKt.getJavaType(Reflection.typeOf(zz0.j.class));
        r0.getClass();
        zz0.j r6 = (zz0.j) uh7.c.a(r5, r1, r2);
        this.a.getClass();
        zy0.a r7 = ((com.bytedance.android.live.revenue.platform.router.impl.d) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.live.revenue.platform.router.impl.d.class)).Y0(r6.getId());
        if (r7 == null) goto L6;
        return r7;
    L6:
        throw com.bytedance.platform.aio.d.e("cannot find hybrid component by id", null);
    }
}
