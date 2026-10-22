package com.bytedance.android.live.platformplayer.panel;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.config.rt0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends LiveBottomSheetBehavior.c {
    public final /* synthetic */ o a;
    public final /* synthetic */ ds0.b b;

    public final void b(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "var1");
    }

    public n(o r1, ds0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ALogger.i("StreamAutoAdapterPanelObserver", "eventType = " + this.b.getType() + ", offset = " + r4 + ", viewHeight = " + r3.getHeight());
        if (((Boolean) rt0.a.getValue()).booleanValue() == true) goto L5;
    L9:
        StreamAutoAdapterService r0 = this.a.d;
        LivePanelType r1 = this.b.getType();
        float r5 = r3.getHeight() * r4;
        r0.getClass();
        StreamAutoAdapterService.d(r1, r5);
        return;
    L5:
        if (this.b.getType() != LivePanelType.PERSONAL_PROFILE) goto L9;
        if (r4 <= 0) goto L9;
    }
}
