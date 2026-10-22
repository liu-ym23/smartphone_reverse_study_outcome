package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.y;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends com.larus.bmhome.instruction.core.impl.base.b {
    public String p;
    public boolean q;
    public Integer r;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public c() {
        super("CollaboratedMultiFeatureSelectorController");
        this.q = true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.f(getWidgetId(), this.o, this.p, this.h, this.r);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return this.q;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return this.p;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r1) {
        this.r = r1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (Intrinsics.areEqual(r3.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof cq8.g) == false) goto L12;
        cq8.g r4 = (cq8.g) r3;
        String r0 = r4.c;
        if (r0 != null) goto L10;
        r0 = this.p;
    L10:
        this.p = r0;
        this.q = r4.d;
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r2 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) xt7.d.b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 != null) goto L20;
        this.p = r3;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "collaborated multi feature selector is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) xt7.d.b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r5) != null) goto L13;
        this.p = r2;
        j();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
