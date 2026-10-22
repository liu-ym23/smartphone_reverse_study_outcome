package com.bytedance.android.live.broadcast.api.scope.service;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.scope.RequireService;
import com.bytedance.android.live.core.utils.v;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements hs1.f {
    public final b a;

    public abstract /* synthetic */ Context getContext();

    public a() {
        this.a = new b();
    }

    public final <T extends e> T a(Object r12, Class<T> r13) {
        Intrinsics.checkNotNullParameter(r12, "caller");
        Intrinsics.checkNotNullParameter(r13, "c");
        if (v.a() == false) goto L25;
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "curObj");
        Intrinsics.checkNotNullParameter(r13, "c");
        Annotation[] r0 = r12.getClass().getAnnotations();
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        boolean r3 = false;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        Annotation r5 = r0[r4];
        if ((r5 instanceof RequireService) == false) goto L9;
        r1.add(r5);
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        RequireService r6 = (RequireService) CollectionsKt.firstOrNull(r1);
        if (r6 == null) goto L23;
        KClass[] r14 = Reflection.getOrCreateKotlinClasses(r6.value());
        int r7 = r14.length;
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L18;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(r14[r8]), r13) == true) goto L16;
        r8 = r8 + 1;
        goto L13
    L16:
        r3 = true;
    L18:
        if (r3 == true) goto L25;
        throw new IllegalArgumentException("Service " + r13.getSimpleName() + " not declared in @RequireService annotation. Required: " + ArraysKt.joinToString$default(Reflection.getOrCreateKotlinClasses(r6.value()), null, null, null, 0, null, BroadcastScopeServiceChecker$checkScopeService$1.INSTANCE, 31, null));
    L23:
        throw new IllegalArgumentException("Widget " + Reflection.getOrCreateKotlinClass(r12.getClass()).getSimpleName() + " not declared @RequireService(" + r13.getSimpleName() + ") ");
    L25:
        return (T) ((com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d) this).i().getService(r13);
    }
}
