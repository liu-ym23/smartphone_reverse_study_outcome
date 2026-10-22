package com.larus.suggest.impl.repo;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "userId");
        ((Keva) b.getValue()).erase(b(r1, r2));
    }

    public static String b(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "userId");
        return r1 + '_' + r2;
    }
}
