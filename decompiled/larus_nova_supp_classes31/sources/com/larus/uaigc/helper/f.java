package com.larus.uaigc.helper;

import com.larus.platform.service.z2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final f a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public f() {
    }

    static {
        a = new f();
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
        e = LazyKt.lazy(new d());
        f = LazyKt.lazy(new e());
    }

    public static boolean a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(z2.a.enableCreationResourceAccessPipeline()));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static kq9.g b() {
        return (kq9.g) d.getValue();
    }

    public static kq9.k c() {
        return (kq9.k) b.getValue();
    }
}
