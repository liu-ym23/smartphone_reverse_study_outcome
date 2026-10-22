package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public r0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        SwitchResolutionResult r3 = (SwitchResolutionResult) r2;
        LivePlayerWidget r4 = this.a;
        int r0 = LivePlayerWidget.V2;
        r4.getClass();
    }
}
