package com.ss.android.lark.officesdk.minutes.ui.service;

import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements qub.e {
    public final /* synthetic */ qub.e a;
    public final /* synthetic */ qub.e b;

    @Override // qub.e
    public final void T(FragmentManager r6) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        Intrinsics.checkNotNullParameter("MmStandaloneAIInterpretationLanguagePanel", "id");
        int r0 = f.a;
        qub.e r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.T(r6);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.T(r6);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dismissPanel provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // qub.e
    public final void m0(FragmentManager r6) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        int r0 = f.a;
        qub.e r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.m0(r6);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.m0(r6);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host dismissAllPanels provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public d(qub.e r1, qub.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // qub.e
    public final void w(FragmentManager r6, rub.d r7) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        Intrinsics.checkNotNullParameter(r7, "config");
        int r0 = f.a;
        qub.e r1 = this.a;
        if (r1 != null) goto L17;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        this.b.w(r6, r7);
        return;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r1.w(r6, r7);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        int r8 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host panel provider failed e=" + r5, null);
    L12:
        r2 = Result.isSuccess-impl(r4);
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
