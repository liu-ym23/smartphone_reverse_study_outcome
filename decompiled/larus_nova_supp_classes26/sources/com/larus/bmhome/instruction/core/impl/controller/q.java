package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q extends com.larus.bmhome.instruction.core.impl.base.b {
    public wa8.u p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public q() {
        super("ReferenceImageUploadController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new p0(getWidgetId(), this.o, this.p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.p != null) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(wa8.u.Companion.serializer()), this.p));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == true) goto L14;
        r1 = r2;
    L14:
        return (String) r1;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((wa8.u) xt7.d.b.c(wa8.u.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.p = (wa8.u) r4;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "reference image upload is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((wa8.u) xt7.d.b.c(wa8.u.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        wa8.u r6 = (wa8.u) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        wa8.b r7 = r6.a;
        if (r7 == null) goto L18;
        wa8.u r0 = this.p;
        if (r0 == null) goto L18;
        r0.a = r7;
    L18:
        wa8.p r8 = r6.b;
        if (r8 == null) goto L26;
        wa8.u r9 = this.p;
        if (r9 == null) goto L27;
        r9.b = r8;
        return;
    L27:
        return;
    L26:
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
