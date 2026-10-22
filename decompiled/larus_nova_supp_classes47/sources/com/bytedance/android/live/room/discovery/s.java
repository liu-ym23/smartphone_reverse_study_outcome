package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ AnchorPerfMonitorWidget a;

    public s(AnchorPerfMonitorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        b61.a r2 = (b61.a) r1;
        View r3 = ((Widget) this.a).contentView;
        if (r3 == null) goto L6;
        r3.performClick();
        return;
    }
}
