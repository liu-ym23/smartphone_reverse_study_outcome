package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.x;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.p p;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 3;
    }

    public k() {
        super("InputBoxController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.p r0 = this.p;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.b, Boolean.TRUE);
    L6:
        if (r1 == true) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new x(getWidgetId(), this.o, this.p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.p != null) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), this.p));     // Catch: Throwable -> L7
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
        Object r4 = Result.constructor-impl((com.larus.bmhome.actionbar.model.p) xt7.d.b.c(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.p = (com.larus.bmhome.actionbar.model.p) r4;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "input box is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.p) xt7.d.b.c(com.larus.bmhome.actionbar.model.p.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.p r6 = (com.larus.bmhome.actionbar.model.p) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        this.p = r6;
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
