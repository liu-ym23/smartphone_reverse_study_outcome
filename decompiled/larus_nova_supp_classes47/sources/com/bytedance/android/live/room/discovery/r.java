package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import zg1.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ AnchorPerfMonitorWidget a;

    public r(AnchorPerfMonitorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        d1 r3 = (d1) r2;
        StringBuilder r4 = new StringBuilder("LiveAnchorOpenPerfMonitorDialogEvent-get:");
        CommonBottomDialog r0 = this.a.r;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isShowing());
    L6:
        r4.append(r1);
        ALogger.d("AnchorVolumnOptiTAG", r4.toString());
        View r5 = ((Widget) this.a).contentView;
        if (r5 == null) goto L10;
        r5.performClick();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
