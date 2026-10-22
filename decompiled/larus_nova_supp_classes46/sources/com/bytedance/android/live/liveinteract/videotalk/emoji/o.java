package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public o(d r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        this.a.b = false;
        String r0 = this.b;
        long r1 = this.c;
        InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
        com.bytedance.android.live.liveinteract.plantform.utils.x.x0(this.b, r7, "self_panel");
        d.a r2 = (d.a) ((q46.b) this.a).a;
        if (r2 == null) goto L5;
        r2.F(this.b, r7);
    L5:
        this.a.getClass();
        VoiceChatMuteManager r3 = d.c0();
        if (r3 == null) goto L9;
        r3.m(r7);
        return;
    }
}
