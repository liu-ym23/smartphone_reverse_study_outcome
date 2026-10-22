package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qub.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements h {
    public final /* synthetic */ h a;
    public final /* synthetic */ h b;

    public e(h r1, h r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // qub.h
    public final void u(Context r6, rub.e r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "config");
        int r0 = f.a;
        h r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.u(r6, r7);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.u(r6, r7);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r8 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host toast provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
