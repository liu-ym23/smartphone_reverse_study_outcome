package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public o0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        String r8 = (String) r7;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", "get hub.vrEffectEvent=" + r8);
        if (r8 == null) goto L32;
        int r0 = r8.hashCode();
        if (r0 == (-755807530)) goto L20;
        if (r0 == 303016908) goto L11;
        return;
    L11:
        if (r8.equals("effect_enable_after_pk") == false) goto L25;
        LivePlayerWidget r9 = this.a;
        int r1 = LivePlayerWidget.V2;
        ILivePlayerClient r10 = r9.dr();
        if (r10 == null) goto L26;
        com.bytedance.android.live.platformplayer.service.a r2 = (com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r2 == null) goto L27;
        VrEffectDownloader r3 = r2.T0();
        if (r3 == null) goto L28;
        r3.d(r10, null);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L20:
        if (r8.equals("effect_disable_for_pk") == false) goto L30;
        long r4 = System.currentTimeMillis();
        if ((r4 - ((Long) ((Property) this.a.C.getValue()).getValue()).longValue()) <= 86400000) goto L31;
        f2.c("转化效果已关闭，结束后自动开启", 0);
        ((Property) this.a.C.getValue()).setValue(Long.valueOf(r4));
        return;
    L31:
        return;
    L30:
        return;
    }
}
