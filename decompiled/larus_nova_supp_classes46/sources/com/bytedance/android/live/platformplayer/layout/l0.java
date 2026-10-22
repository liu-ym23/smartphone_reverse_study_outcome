package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public l0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L8;
        r4.booleanValue();
        LivePlayerWidget r0 = this.a;
        int r1 = LivePlayerWidget.V2;
        ILivePlayerClient r2 = r0.dr();
        if (r2 == null) goto L9;
        r2.setImageLayout(r4.booleanValue() ? 1 : 0);
        return;
    L9:
        return;
    }
}
