package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.SystemClock;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ IRoom a;
    public final /* synthetic */ VideoFriendPairDialog b;
    public final /* synthetic */ h0 c;

    public c0(IRoom r1, VideoFriendPairDialog r2, h0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.a0;
        Long r0 = Long.valueOf(SystemClock.elapsedRealtime());
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        this.b.M0();
        throw null;
    }
}
