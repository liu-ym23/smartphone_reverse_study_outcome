package com.lark.kmp.module;

import com.lark.kmp.containerization.b;
import com.lark.kmp.impl.d;
import gy7.e;
import gy7.f;
import gy7.g;
import gy7.h;
import gy7.i;
import gy7.w;
import hy7.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UserStateModule {
    static {
    }

    public static void a(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "globalContainer");
        final com.lark.kmp.impl.b r0 = new com.lark.kmp.impl.b(r3.b(Reflection.getOrCreateKotlinClass(hy7.b.class)));
        Function0<f> r1 = new UserStateModule$bindGlobalServices$1(r0);
        r3.c(Reflection.getOrCreateKotlinClass(f.class), r1);
        Function0<e> r2 = new UserStateModule$bindGlobalServices$2(r0);
        r3.c(Reflection.getOrCreateKotlinClass(e.class), r2);
        UserStateModule$bindGlobalServices$3 r4 = UserStateModule$bindGlobalServices$3.INSTANCE;
        r3.c(Reflection.getOrCreateKotlinClass(g.class), r4);
        Function0<w> r5 = new UserStateModule$bindGlobalServices$4(r3);
        r3.c(Reflection.getOrCreateKotlinClass(w.class), r5);
    }

    public static void b(String r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userContainer");
        final d r0 = new d(r2, r3.b(Reflection.getOrCreateKotlinClass(c.class)));
        Function0<i> r4 = new UserStateModule$bindUserServices$1(r0);
        r3.c(Reflection.getOrCreateKotlinClass(i.class), r4);
        Function0<h> r5 = new UserStateModule$bindUserServices$2(r0);
        r3.c(Reflection.getOrCreateKotlinClass(h.class), r5);
    }
}
