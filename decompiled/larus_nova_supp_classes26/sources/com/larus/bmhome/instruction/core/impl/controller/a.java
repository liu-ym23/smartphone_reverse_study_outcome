package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends com.larus.bmhome.instruction.core.impl.base.b {
    public wa8.a p;
    public Integer q;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public a() {
        super("AvatarButtonController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.a(getWidgetId(), this.o, g(), this.h, this.q);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(wa8.a.Companion.serializer()), this.p));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r1) {
        this.q = r1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((wa8.a) xt7.d.b.c(wa8.a.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.p = (wa8.a) r4;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "avatar template instruction item is empty");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
