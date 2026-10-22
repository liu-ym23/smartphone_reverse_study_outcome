package com.obric.miniapp.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.oui.sheet.v2.OSheet;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ hma.c a;
    public final /* synthetic */ LocalDateTime b;
    public final /* synthetic */ AtomicBoolean c;
    public final /* synthetic */ g d;
    public final /* synthetic */ OSheet e;

    public static final class a implements Runnable {
        public final /* synthetic */ OSheet a;

        public a(OSheet r1) {
            this.a = r1;
        }

        public final void a() {
            OSheet r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g0(hma.c r1, LocalDateTime r2, AtomicBoolean r3, g r4, OSheet r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    /* JADX WARN: Type inference failed for: r8v18, types: [java.time.ZonedDateTime] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        hma.c r9 = this.a;
        Object r0 = null;
        if (r9 == null) goto L41;
        hma.c.b r10 = r9.b();
        if (r10 == null) goto L40;
        Integer r1 = (Integer) r10.a.get(Integer.valueOf(ErrorCode.Clock.TIMER_NOT_EXIST_ERROR));
        if (r1 == null) goto L9;
        int r2 = 2010 + r1.intValue();
    L10:
        Integer r3 = (Integer) r10.a.get(Integer.valueOf(ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR));
        if (r3 == null) goto L13;
        int r4 = r3.intValue() + 1;
    L14:
        Integer r5 = (Integer) r10.a.get(Integer.valueOf(ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR));
        if (r5 == null) goto L17;
        int r6 = r5.intValue() + 1;
    L18:
        a0 r7 = a0.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
        Object r12 = Result.constructor-impl(Integer.valueOf(YearMonth.of(r2, r4).lengthOfMonth()));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r12) == true) goto L27;
        r0 = r12;
    L27:
        Integer r13 = (Integer) r0;
        if (r13 == null) goto L30;
        int r14 = r13.intValue();
    L31:
        int r15 = RangesKt.coerceIn(r6, 1, r14);
        Integer r16 = (Integer) r10.a.get(2004);
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        Integer r18 = (Integer) r10.a.get(2005);
        if (r18 == null) goto L38;
        int r19 = r18.intValue();
    L39:
        AtomicBoolean r20 = this.c;
        g r21 = this.d;
        a0 r22 = a0.a;
        LocalDateTime r23 = LocalDateTime.of(r2, r4, r15, r17, r19);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "<this>");
        a0.t(r20, r21, Long.valueOf(r23.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
    L42:
        a0 r24 = a0.a;
        OSheet r25 = this.e;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
        Handler r26 = DialogLancet.resolveDialogHandler(r25);
        if (r26 != null) goto L47;
    L49:
        DialogLancet.beforeDialogDismiss(r25);
        r25.dismiss();     // Catch: Throwable -> L52 Exception -> L54
    L58:
        DialogLancet.afterDialogDismiss(r25);
        return;
    L54:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L52
        Throwable r27 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L52
        if (r27 == null) goto L58;
        com.bytedance.crash.d.d(r27, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r25);
        throw th;
    L47:
        if (Looper.myLooper() == r26.getLooper()) goto L49;
        r26.post(DialogLancet.createDismissRunnable(r25));
        return;
    L61:
        a0.d(r24).post(new a(r25));
        return;
    L38:
        r19 = this.b.getMinute();
        goto L39
    L34:
        r17 = this.b.getHour();
        goto L35
    L30:
        r14 = 31;
    L21:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L17:
        r6 = this.b.getDayOfMonth();
        goto L18
    L13:
        r4 = this.b.getMonthValue();
        goto L14
    L9:
        r2 = this.b.getYear();
        goto L10
    L40:
        a0.t(this.c, this.d, null);
        goto L42
    L41:
        a0.t(this.c, this.d, null);
        goto L42
    }
}
