package com.bytedance.android.livesdk.feedback.light;

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
public final class f<T> implements Consumer {
    public final /* synthetic */ LiveLightFeedbackWidget a;

    public f(LiveLightFeedbackWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Unit r5 = (Unit) r4;
        int r6 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r7 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r7.a = "LiveLightFeedbackWidget";
        r7.c("onHideEndEvent");
        Pair[] r0 = new Pair[1];
        DataCenter r1 = ((Widget) this.a).dataCenter;
        if (r1 == null) goto L7;
        Room r2 = z.o(r1);
        if (r2 == null) goto L7;
        String r3 = r2.getIdStr();
    L8:
        r0[0] = TuplesKt.to("roomId", r3);
        r7.b(r0);
        r7.d();
        LiveLightFeedbackWidget r8 = this.a;
        int r9 = LiveLightFeedbackWidget.f;
        r8.Bq();
        com.bytedance.android.livesdk.feedback.light.context.a r10 = this.a.a;
        if (r10 == null) goto L12;
        r10.updateFeedbackCardShowingStatus(false);
        return;
    L12:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
