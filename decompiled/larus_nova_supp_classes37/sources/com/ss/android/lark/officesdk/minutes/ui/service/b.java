package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements qub.c {
    public final /* synthetic */ qub.c a;
    public final /* synthetic */ qub.c b;

    @Override // qub.c
    public final void B(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r0 = f.a;
        qub.c r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.B(r6);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.B(r6);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dismissAllDialogs provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public b(qub.c r1, qub.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // qub.c
    public final void u0(Context r6, rub.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "config");
        int r0 = f.a;
        qub.c r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.u0(r6, r7);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.u0(r6, r7);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r8 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dialog provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
