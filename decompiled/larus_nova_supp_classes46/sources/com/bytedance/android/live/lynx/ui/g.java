package com.bytedance.android.live.lynx.ui;

import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements e76.b {
    public final /* synthetic */ LiveLynxAlphaPlayer a;

    public g(LiveLynxAlphaPlayer r1) {
        this.a = r1;
    }

    public final void onResult(Object r5) {
        String r6 = (String) r5;
        LiveLynxAlphaPlayer r0 = this.a;
        if (r6 != "success") goto L15;
        int r7 = LiveLynxAlphaPlayer.h;
        r0.sendEvent("ready", r0.P(1, "load resource success", null));
        if (r0.c != null) goto L7;
        return;
    L7:
        if (r0.d == false) goto L18;
        IPlayerController r8 = r0.a;
        if (r8 == null) goto L11;
        r8.attachAlphaView(LiveLynxAlphaPlayer.M(r0));
    L11:
        IPlayerController r9 = r0.a;
        if (r9 == null) goto L19;
        r9.d(r0.c);
        return;
    L19:
        return;
    L18:
        return;
    L15:
        r0.Q("unknown exception, " + r6, r0.g, -6);
        throw null;
    }
}
