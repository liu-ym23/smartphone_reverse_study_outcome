package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdkapi.player.PlayerTaskManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ s a;

    public r(s r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        if (r4 == null) goto L7;
        PlayerTaskManager.inst().commit(new q(this, r4));
        return;
    }
}
