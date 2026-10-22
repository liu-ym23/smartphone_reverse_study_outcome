package com.bytedance.android.live.platformplayer.layout;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public k0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.booleanValue() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L12;
        r3.booleanValue();
        LivePlayerWidget r4 = this.a;
        int r0 = LivePlayerWidget.V2;
        r4.Jq();
        return;
    }
}
