package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.livesdk.feedback.light.context.a a;
    public final /* synthetic */ LiveLightFeedbackWidget b;

    public e(com.bytedance.android.livesdk.feedback.light.context.a r1, LiveLightFeedbackWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Unit r6 = (Unit) r5;
        int r7 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r8 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r8.a = "LiveLightFeedbackWidget";
        r8.c("onShowStartEvent");
        Pair[] r1 = new Pair[1];
        DataCenter r2 = ((Widget) this.b).dataCenter;
        if (r2 == null) goto L7;
        Room r3 = z.o(r2);
        if (r3 == null) goto L7;
        String r4 = r3.getIdStr();
    L8:
        r1[0] = TuplesKt.to("roomId", r4);
        r8.b(r1);
        r8.d();
        LiveLightFeedbackWidget.wq(this.b, FeedbackCard.FeedbackStatus.SHOWING);
        com.bytedance.android.livesdk.feedback.light.context.a r9 = this.b.a;
        if (r9 == null) goto L11;
        r9.updateFeedbackCardShowingStatus(true);
    L11:
        this.a.reqFeedbackShow();
        LiveLightFeedbackWidget r10 = this.b;
        r10.e = System.currentTimeMillis();
        if (z.e(((Widget) this.b).dataCenter, false) == false) goto L14;
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.V2;
        Long r0 = Long.valueOf(System.currentTimeMillis());
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r0);
        return;
    L14:
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.b.U2;
        Long r13 = Long.valueOf(System.currentTimeMillis());
        r12.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r12, r13);
        return;
    L7:
        r4 = null;
        goto L8
    }
}
