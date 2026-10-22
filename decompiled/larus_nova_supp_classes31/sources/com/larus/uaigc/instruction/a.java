package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends up8.b {
    public wa8.a l;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.a$a, reason: collision with other inner class name */
    public static final class C0045a {
    }

    static {
    }

    public final boolean a() {
        return true;
    }

    public int getType() {
        return 8;
    }

    public final int i() {
        return 8;
    }

    public final void k(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "defaultStateTemplate");
    }

    public final String g() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(wa8.a.Companion.serializer()), this.l));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        FLogger.a.i("AvatarTemplateController", "collectData is " + r2);
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public a() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new AvatarTemplateWidget(r2);
    }

    public final wa8.a0 n(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r5 = Result.constructor-impl((wa8.a) xt7.d.b.c(wa8.a.Companion.serializer(), r4));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r5);
        if (r2 != null) goto L20;
        wa8.a r6 = (wa8.a) r5;
        this.l = r6;
        FLogger.a.i("AvatarTemplateController", "avtarInstructionItem is " + r6);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "avatar template instruction item is empty");
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
