package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements qub.d {
    public final /* synthetic */ qub.d a;
    public final /* synthetic */ qub.d b;

    @Override // qub.d
    public final void t0(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r0 = f.a;
        qub.d r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.t0(r6);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.t0(r6);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host hideAllLoadings provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public c(qub.d r1, qub.d r2) {
        this.a = r1;
        this.b = r2;
    }
}
