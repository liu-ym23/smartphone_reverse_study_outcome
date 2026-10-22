package com.obric.miniapp.utils;

import android.content.Context;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.lang.ref.WeakReference;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ LocalDateTime b;
    public final /* synthetic */ OSheet c;
    public final /* synthetic */ AtomicBoolean d;
    public final /* synthetic */ g e;

    public d0(Context r1, LocalDateTime r2, b1 r3, AtomicBoolean r4, com.obric.miniapp.aibridge.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        hma.c.a r0 = new hma.c.a();
        hma.c.a.j(r0, this.a, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, 2010, 2037, Integer.valueOf(this.b.getYear()));
        r0.f(this.a, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, Integer.valueOf(this.b.getMonthValue()), null);
        hma.c.a.c(r0, this.a, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, Integer.valueOf(this.b.getDayOfMonth()));
        hma.c.a.d(r0, this.a, 2004, true, true, Integer.valueOf(this.b.getHour()));
        hma.c.a.e(r0, this.a, 2005, true, Integer.valueOf(this.b.getMinute()));
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        e0 r3 = new e0(r2, this.a, this.b);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r0.a = r3;
        a0 r4 = a0.a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl((hma.c) hma.d.a.a(r0, this.a));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        hma.c r14 = (hma.c) r1;
        r2.element = r14;
        if (r14 == null) goto L13;
        a0 r6 = a0.a;
        Context r7 = this.a;
        r6.getClass();
        FrameLayout r8 = a0.j(r7, r14);
    L14:
        FrameLayout r15 = r8;
        if (r14 == null) goto L28;
        a0 r9 = a0.a;
        Context r10 = this.a;     // Catch: Throwable -> L23
        hma.c.b r11 = r14.b();     // Catch: Throwable -> L23
        if (r11 == null) goto L20;
        Map r12 = r11.a;     // Catch: Throwable -> L23
    L21:
        int r13 = this.b.getYear();     // Catch: Throwable -> L23
        int r16 = this.b.getMonthValue();     // Catch: Throwable -> L23
        r9.getClass();     // Catch: Throwable -> L23
        a0.e(r10, r14, r12, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, 2010, r13, r16);     // Catch: Throwable -> L23
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L28;
        FLogger.a.w("DatePickerUtils", "showDateTimePickerV2 initial adjustDayReelIfNeeded failed: " + r18.getMessage());
        goto L28
    L20:
        r12 = null;
    L23:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        a0 r20 = a0.a;
        a0.d = new WeakReference(this.c);
        OSheet r21 = this.c;
        OSheet.Header r22 = OSheet.Header.ACTION;
        AtomicBoolean r23 = this.d;
        g r24 = this.e;
        OSheetBase.DefaultImpls.o(r21, r22, null, "选择日期", null, true, new f0(r23, r24, r21), new g0(r14, this.b, r23, r24, r21), 16134);
        OSheet r25 = this.c;
        r25.getClass();
        OSheetBase.DefaultImpls.j(r25, r15);
        OSheet r26 = this.c;
        r26.setOnDismissListener(new h0(r26, this.d, this.e));
        a0.a.u(this.c, new i0(this.d, this.e));
        return;
    L13:
        FLogger.a.e("DatePickerUtils", "showDateTimePickerV2 build picker failed");
        r8 = new FrameLayout(this.a);
    L5:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
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
