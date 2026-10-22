package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.timon.calendar.EventRecord;
import com.bytedance.timon.calendar.ResultCode;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o7<T> implements SingleOnSubscribe {
    public final /* synthetic */ i7 a;
    public final /* synthetic */ ICalendarManager.EventParams b;

    public static final class a implements com.bytedance.timon.calendar.a {
        public final /* synthetic */ o7 a;
        public final /* synthetic */ SingleEmitter b;

        public a(o7 r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r4, ResultCode r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "errorCode");
            Intrinsics.checkNotNullParameter(r6, "msg");
            if (r4 == false) goto L5;
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_system_calendar_build", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_id", this.a.b.getEventId()), TuplesKt.to("anchor_id", this.a.b.getAnchorId())}), new Object[0]);
            this.b.onSuccess(ICalendarManager.ErrorCode.Success);
            return;
        L5:
            int r7 = j7.a[r5.ordinal()];
            if (r7 == 1) goto L13;
            if (r7 != 2) goto L9;
            this.b.onSuccess(ICalendarManager.ErrorCode.NoPermission);
            return;
        L9:
            if (r7 == 3) goto L11;
            this.b.onSuccess(ICalendarManager.ErrorCode.Unknown);
            return;
        L11:
            this.b.onSuccess(ICalendarManager.ErrorCode.NoAccount);
            return;
        L13:
            this.b.onSuccess(ICalendarManager.ErrorCode.ArgumentError);
        }
    }

    public o7(i7 r1, ICalendarManager.EventParams r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<ICalendarManager.ErrorCode> r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        Function1 r0 = com.bytedance.timon.calendar.c.a;
        Context r1 = this.a.getContext();
        i7 r2 = this.a;
        ICalendarManager.EventParams r3 = this.b;
        r2.getClass();
        EventRecord r4 = new EventRecord();
        long r5 = 1000;
        r4.C(r3.getStartTime() * r5);
        r4.t(r3.getEndTime() * r5);
        r4.D(r3.getTitle());
        r4.s(r3.getDescription());
        r4.p(r3.getAlarmMinutes());
        String r6 = r3.getEventId();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r4.u(r6);
        r4.B(r3.getScheduledWeekDays());
        r4.r(r3.getAppUrl());
        com.bytedance.timon.calendar.c.c(r1, r4, new a(this, r8));
    }
}
