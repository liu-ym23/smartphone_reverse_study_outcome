package com.ss.android.lark.officesdk.minutes.ui.service;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements qub.b {
    public final /* synthetic */ MmRecordingUILaunchMode a;
    public final /* synthetic */ qub.b b;
    public final /* synthetic */ qub.b c;

    @Override // qub.b
    public final qub.a L(Activity r22, rub.a r23) {
        Intrinsics.checkNotNullParameter(r22, "activity");
        Intrinsics.checkNotNullParameter(r23, "config");
        MmRecordingUILaunchMode r3 = this.a;
        View r4 = r23.a;
        String r6 = r23.b;
        CharSequence r7 = r23.c;
        MmBubbleDirection r15 = r23.d;
        boolean r9 = r23.e;
        boolean r10 = r23.f;
        long r11 = r23.g;
        boolean r13 = r23.h;
        Integer r14 = r23.i;
        Integer r16 = r23.j;
        Integer r1 = r23.k;
        Point r2 = r23.l;
        Function0<Unit> r5 = r23.m;
        Function0<Unit> r0 = r23.n;
        Intrinsics.checkNotNullParameter(r4, "anchorView");
        Intrinsics.checkNotNullParameter(r15, "direction");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
        rub.a r8 = new rub.a(r4, r6, r7, r15, r9, r10, r11, r13, r14, r16, r1, r2, r5, r0, r3);
        int r12 = f.a;
        qub.b r17 = this.b;
        Object r18 = null;
        if (r17 != null) goto L27;
        Activity r19 = r22;
    L21:
        qub.a r20 = (qub.a) r18;
        if (r20 == null) goto L24;
        return r20;
    L24:
        return this.c.L(r19, r8);
    L27:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L11
        r19 = r22;
        Object r24 = Result.constructor-impl(r17.L(r19, r8));     // Catch: Throwable -> L9
    L14:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L18;
        int r26 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "styleProvider", "host bubble provider failed e=" + r25, null);
    L18:
        if (Result.isFailure-impl(r24) == true) goto L21;
        r18 = r24;
    L9:
        th = th;
    L13:
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = th;
        r19 = r22;
        goto L13
    }

    public a(MmRecordingUILaunchMode r1, qub.b r2, qub.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
