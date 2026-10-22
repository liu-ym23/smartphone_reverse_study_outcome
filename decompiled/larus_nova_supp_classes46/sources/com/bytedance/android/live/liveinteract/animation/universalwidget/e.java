package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.VideoGiftView;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements AlphaPlayerAction {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;

    public final void a() {
        StringBuilder r0 = new StringBuilder("startAction");
        VideoGiftView r1 = this.a.b;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getDuration());
    L6:
        r0.append(String.valueOf(r2));
        r0.append("");
        ALogger.d("MultiLinkEffect.Widget", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b() {
        StringBuilder r0 = new StringBuilder("endAction");
        VideoGiftView r1 = this.a.b;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getDuration());
    L6:
        r0.append(String.valueOf(r2));
        r0.append("");
        ALogger.d("MultiLinkEffect.Widget", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public e(MultiLinkUniversalAnimWidget r1) {
        this.a = r1;
    }

    public final void c(int r3, int r4, DataSource.ScaleType r5) {
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        ALogger.i("MultiLinkEffect.Widget", "onVideoSizeChange: videoWidth = " + r3 + " videoHeight = " + r4 + " scaleType = " + r5.name());
    }
}
