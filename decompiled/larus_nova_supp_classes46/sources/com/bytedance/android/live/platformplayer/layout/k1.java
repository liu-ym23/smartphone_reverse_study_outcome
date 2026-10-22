package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.player.vr.VrBgImageEventController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k1<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public k1(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L22;
        LivePlayerWidget r4 = this.a;
        int r0 = LivePlayerWidget.V2;
        ILivePlayerClient r5 = r4.dr();
        if (r5 == null) goto L17;
        LifecycleOwner r6 = r5.getLifecycleOwner();
        if (r6 == null) goto L18;
        LivePlayerWidget.xq(this.a, r6);
        this.a.Er("Start switch stream, ready to observe a new VrBgImageEventController for vrBgLogUpdateOrSend");
        ILivePlayerClient r1 = this.a.dr();
        if (r1 == null) goto L19;
        IRoomEventHub r2 = r1.getEventHub();
        if (r2 == null) goto L20;
        MutableLiveData r7 = r2.getVrBgLogUpdateOrSend();
        if (r7 == null) goto L21;
        r7.observe(r6, new VrBgImageEventController());
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}
