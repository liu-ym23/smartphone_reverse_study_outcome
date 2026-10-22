package com.bytedance.android.live.liveinteract.hamlet;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ HamletAvatarWidget a;

    public q(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        af0.a r7 = af0.a.a;
        long r0 = this.a.D;
        r7.getClass();
        long r2 = System.currentTimeMillis() - r0;
        LinkMonitorData r8 = LinkMonitorData.HamletAvatarMainMixerSwitchSuccess;     // Catch: Exception -> L5
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("duration", r2);     // Catch: Exception -> L5
        Unit r3 = Unit.INSTANCE;     // Catch: Exception -> L5
        af0.a.l(r8, r1);     // Catch: Exception -> L5
        return;
    }
}
