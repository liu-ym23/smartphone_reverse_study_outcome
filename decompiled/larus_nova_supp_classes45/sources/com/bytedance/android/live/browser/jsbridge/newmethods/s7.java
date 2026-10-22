package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.timon.calendar.ResultCode;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s7<T> implements SingleOnSubscribe {
    public final /* synthetic */ i7 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public static final class a implements com.bytedance.timon.calendar.a {
        public final /* synthetic */ s7 a;
        public final /* synthetic */ SingleEmitter b;

        public a(s7 r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r4, ResultCode r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "errorCode");
            Intrinsics.checkNotNullParameter(r6, "msg");
            if (r4 == false) goto L5;
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_system_calendar_cancel", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_id", this.a.b), TuplesKt.to("anchor_id", this.a.c)}), new Object[0]);
            this.b.onSuccess(ICalendarManager.ErrorCode.Success);
            return;
        L5:
            int r7 = j7.b[r5.ordinal()];
            if (r7 == 1) goto L16;
            if (r7 != 2) goto L9;
            this.b.onSuccess(ICalendarManager.ErrorCode.ArgumentError);
            return;
        L9:
            if (r7 != 3) goto L11;
            this.b.onSuccess(ICalendarManager.ErrorCode.NoPermission);
            return;
        L11:
            if (r7 == 4) goto L13;
            this.b.onSuccess(ICalendarManager.ErrorCode.Unknown);
            return;
        L13:
            this.b.onSuccess(ICalendarManager.ErrorCode.NoAccount);
            return;
        L16:
            this.b.onSuccess(ICalendarManager.ErrorCode.NotFound);
        }
    }

    public s7(i7 r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<ICalendarManager.ErrorCode> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Function1 r0 = com.bytedance.timon.calendar.c.a;
        com.bytedance.timon.calendar.c.a(this.a.getContext(), this.b, new a(this, r4));
    }
}
