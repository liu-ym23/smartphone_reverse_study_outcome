package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public y0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        LivePlayerWidget r0 = this.a;
        if (((Widget) r0).isViewValid == false) goto L10;
        if (r4 == null) goto L7;
        boolean r5 = r4.booleanValue();
    L8:
        int r1 = LivePlayerWidget.V2;
        r0.Sr(r5);
        return;
    L7:
        r5 = true;
        goto L8
    }
}
