package com.lark.kmp.rustclient;

import com.lark.kmp.containerization.b;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.e;
import com.lark.kmp.rustclient.api.f;
import com.lark.kmp.rustclient.api.g;
import com.lark.kmp.rustclient.internal.VerifyDataInterceptor;
import com.lark.kmp.rustclient.internal.r;
import com.lark.kmp.rustclient.internal.t;
import com.lark.kmp.rustclient.internal.v;
import com.lark.kmp.rustclient.internal.z;
import gy7.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RustClientModule {
    static {
    }

    public static void a(final b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        RustClientModule$bindGlobalClientServices$1 r0 = RustClientModule$bindGlobalClientServices$1.INSTANCE;
        r2.c(Reflection.getOrCreateKotlinClass(t.class), r0);
        RustClientModule$bindGlobalClientServices$2 r1 = RustClientModule$bindGlobalClientServices$2.INSTANCE;
        r2.c(Reflection.getOrCreateKotlinClass(e.class), r1);
        RustClientModule$bindGlobalClientServices$3 r3 = RustClientModule$bindGlobalClientServices$3.INSTANCE;
        r2.c(Reflection.getOrCreateKotlinClass(f.class), r3);
        RustClientModule$bindGlobalClientServices$4 r4 = RustClientModule$bindGlobalClientServices$4.INSTANCE;
        r2.c(Reflection.getOrCreateKotlinClass(r.class), r4);
        RustClientModule$bindGlobalClientServices$5 r5 = RustClientModule$bindGlobalClientServices$5.INSTANCE;
        r2.c(Reflection.getOrCreateKotlinClass(com.lark.kmp.rustclient.barrier.a.class), r5);
        Function0<com.lark.kmp.rustclient.api.b> r6 = new RustClientModule$bindGlobalClientServices$6(r2);
        r2.c(Reflection.getOrCreateKotlinClass(com.lark.kmp.rustclient.api.b.class), r6);
    }

    public static void b(String r13, b r14) {
        Intrinsics.checkNotNullParameter(r13, "uid");
        Intrinsics.checkNotNullParameter(r14, "container");
        List r0 = r14.b(Reflection.getOrCreateKotlinClass(g.class));
        Object r1 = r14.a(Reflection.getOrCreateKotlinClass(r.class));
        if (r1 == null) goto L31;
        r r2 = (r) r1;
        Intrinsics.checkNotNullParameter(r2, "clientDef");
        List r3 = CollectionsKt.plus(r0, CollectionsKt.listOf(new VerifyDataInterceptor(r2)));
        Object r4 = r14.a(Reflection.getOrCreateKotlinClass(com.lark.kmp.rustclient.barrier.a.class));
        if (r4 == null) goto L29;
        List r10 = CollectionsKt.plus(r3, new v((com.lark.kmp.rustclient.barrier.a) r4));
        Object r5 = r14.a(Reflection.getOrCreateKotlinClass(r.class));
        if (r5 == null) goto L27;
        r r7 = (r) r5;
        Object r6 = r14.a(Reflection.getOrCreateKotlinClass(f.class));
        if (r6 == null) goto L25;
        f r8 = (f) r6;
        Object r9 = r14.a(Reflection.getOrCreateKotlinClass(e.class));
        if (r9 == null) goto L23;
        e r11 = (e) r9;
        Object r12 = r14.a(Reflection.getOrCreateKotlinClass(t.class));
        if (r12 == null) goto L21;
        t r15 = (t) r12;
        Object r16 = r14.a(Reflection.getOrCreateKotlinClass(i.class));
        if (r16 == null) goto L19;
        final z r17 = new z(r13, r7, r8, r11, r10, r15, (i) r16);
        r14.c(Reflection.getOrCreateKotlinClass(d.class), new RustClientModule$bindUserClientServices$1(r17));
        return;
    L19:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(i.class).getSimpleName() + " found");
    L21:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(t.class).getSimpleName() + " found");
    L23:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(e.class).getSimpleName() + " found");
    L25:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(f.class).getSimpleName() + " found");
    L27:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(r.class).getSimpleName() + " found");
    L29:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(com.lark.kmp.rustclient.barrier.a.class).getSimpleName() + " found");
    L31:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(r.class).getSimpleName() + " found");
    }
}
