package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public a0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Room r3 = (Room) r2;
        LivePlayerWidget r4 = this.a;
        int r0 = LivePlayerWidget.V2;
        r4.gs();
        this.a.Nr();
    }
}
