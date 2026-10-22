package com.obric.miniapp.utils;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.common.ErrorCode;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ Ref.ObjectRef<hma.c> a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ LocalDateTime c;

    public e0(Ref.ObjectRef r1, Context r2, LocalDateTime r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r12) {
        hma.c.b r13 = (hma.c.b) r12;
        Intrinsics.checkNotNullParameter(r13, "picked");
        hma.c r2 = (hma.c) this.a.element;
        if (r2 == null) goto L17;
        a0 r0 = a0.a;
        Context r1 = this.b;
        LocalDateTime r3 = this.c;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L8
        Map r9 = r13.a;     // Catch: Throwable -> L8
        int r10 = r3.getYear();     // Catch: Throwable -> L8
        int r11 = r3.getMonthValue();     // Catch: Throwable -> L8
        r0.getClass();     // Catch: Throwable -> L8
        a0.e(r1, r2, r9, ErrorCode.Clock.TIMER_NOT_EXIST_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_RINGING_AFTER_24_HOURS_ERROR, ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR, 2010, r10, r11);     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        FLogger.a.w("DatePickerUtils", "showDateTimePickerV2 adjustDayReelIfNeeded failed: " + r5.getMessage());
    L13:
        FLogger.a.d("DatePickerUtils", "scroll: " + r13);
        return;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
