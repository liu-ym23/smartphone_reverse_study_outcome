package com.bytedance.android.livesdk.feedback.light;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends b7.a {
    public final /* synthetic */ LiveLightFeedbackWidget a;

    public k(LiveLightFeedbackWidget r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r5) {
        super.onLoadSuccess(r5);
        int r6 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r7 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r7.a = "LiveLightFeedbackWidget";
        r7.c("initLynxContainer---onLoadSuccess");
        Pair[] r1 = new Pair[1];
        DataCenter r2 = ((Widget) this.a).dataCenter;
        if (r2 == null) goto L7;
        Room r3 = z.o(r2);
        if (r3 == null) goto L7;
        String r4 = r3.getIdStr();
    L8:
        r1[0] = TuplesKt.to("roomId", r4);
        r7.b(r1);
        r7.d();
        LiveLightFeedbackWidget r8 = this.a;
        r8.getClass();
        ALogger.d("LiveLightFeedbackWidget", "onLynxLoadSuccess");
        HybridCard r0 = r8.b;
        if (r0 == null) goto L12;
        r8.Cq(r0);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final boolean onFallback(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r1.a = "LiveLightFeedbackWidget";
        r1.c("initLynxContainer---onFallback");
        Pair[] r2 = new Pair[1];
        DataCenter r3 = ((Widget) this.a).dataCenter;
        if (r3 == null) goto L7;
        Room r4 = z.o(r3);
        if (r4 == null) goto L7;
        String r7 = r4.getIdStr();
    L8:
        r2[0] = TuplesKt.to("roomId", r7);
        r1.b(r2);
        r1.d();
        return super.onFallback(r5, r6);
    L7:
        r7 = null;
        goto L8
    }

    public final void onInnerFallback(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r1.a = "LiveLightFeedbackWidget";
        r1.c("initLynxContainer---onInnerFallback");
        Pair[] r2 = new Pair[1];
        DataCenter r3 = ((Widget) this.a).dataCenter;
        if (r3 == null) goto L7;
        Room r4 = z.o(r3);
        if (r4 == null) goto L7;
        String r7 = r4.getIdStr();
    L8:
        r2[0] = TuplesKt.to("roomId", r7);
        r1.b(r2);
        r1.d();
        super.onInnerFallback(r5, r6);
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void onLoadStart(View r1, boolean r2) {
        super.onLoadStart(r1, r2);
        this.a.getClass();
        ALogger.d("LiveLightFeedbackWidget", "onLynxLoadStart");
    }

    public final void onLoadFail(View r4, String r5, String r6) {
        super.onLoadFail(r4, r5, r6);
        int r7 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r8 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r8.a = "LiveLightFeedbackWidget";
        r8.c("initLynxContainer---onLoadFail");
        Pair[] r9 = new Pair[1];
        DataCenter r0 = ((Widget) this.a).dataCenter;
        String r1 = null;
        if (r0 == null) goto L7;
        Room r2 = z.o(r0);
        if (r2 == null) goto L7;
        String r3 = r2.getIdStr();
    L8:
        r9[0] = TuplesKt.to("roomId", r3);
        r8.b(r9);
        r8.d();
        LiveLightFeedbackWidget r10 = this.a;
        r10.getClass();
        StringBuilder r11 = new StringBuilder("the light feedback lynx load fail");
        DataCenter r12 = ((Widget) r10).dataCenter;
        if (r12 == null) goto L13;
        Room r13 = z.o(r12);
        if (r13 == null) goto L13;
        r1 = r13.getIdStr();
    L13:
        r11.append(r1);
        ALogger.e("LiveLightFeedbackWidget", r11.toString());
        return;
    L7:
        r3 = null;
        goto L8
    }
}
