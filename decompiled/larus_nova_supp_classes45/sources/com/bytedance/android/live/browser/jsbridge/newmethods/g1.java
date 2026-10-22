package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.timon.calendar.EventRecord;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g1<V> implements Callable {
    public final /* synthetic */ l1 a;
    public final /* synthetic */ String b;

    public g1(l1 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> call() {
        i7 r0 = (i7) this.a.c.getValue();
        String r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "eventId");
        Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> r2 = null;
    L14:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to get calendar event, eventId=" + r1, th);
        return TuplesKt.to(ICalendarManager.ErrorCode.Unknown, r2);
    L4:
        if (r1.length() != 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        r2 = TuplesKt.to(ICalendarManager.ErrorCode.ArgumentError, null);     // Catch: Throwable -> L14
    L17:
        return r2;
    L9:
        EventRecord r4 = com.bytedance.timon.calendar.c.d(r1);     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        ICalendarManager.ErrorCode r5 = ICalendarManager.ErrorCode.Success;     // Catch: Throwable -> L14
        ICalendarManager.EventRecord r6 = new ICalendarManager.EventRecord();     // Catch: Throwable -> L14
        r6.setEventId(r4.f());     // Catch: Throwable -> L14
        long r7 = 1000;
        r6.setStartTime(r4.m() / r7);     // Catch: Throwable -> L14
        r6.setEndTime(r4.e() / r7);     // Catch: Throwable -> L14
        r6.setTitle(r4.n());     // Catch: Throwable -> L14
        r6.setDescription(r4.d());     // Catch: Throwable -> L14
        r6.setAlarmMinutes(r4.a());     // Catch: Throwable -> L14
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r2 = TuplesKt.to(r5, r6);     // Catch: Throwable -> L14
        goto L17
    L12:
        r2 = TuplesKt.to(ICalendarManager.ErrorCode.NotFound, null);     // Catch: Throwable -> L14
        goto L17
    L6:
        r3 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
