package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public i(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        DataCenter r5 = ((Widget) this.a).dataCenter;
        if (r5 == null) goto L6;
        r5.put("cmd_is_current_in_background", Boolean.TRUE);
        return;
    }
}
