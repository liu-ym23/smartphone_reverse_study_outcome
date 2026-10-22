package com.larus.ugc.feed.impl.spi;

import com.larus.common.pollingconfig.api.PollingConfigService;
import g0a.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d {

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.spi.a$a, reason: collision with other inner class name */
    public static final class C0048a {
    }

    static {
    }

    public a() {
    }

    @Override // g0a.d
    public final boolean zF() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(PollingConfigService.a.f("cre_tab_ent_dg"), "1")));     // Catch: Throwable -> L4
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
}
