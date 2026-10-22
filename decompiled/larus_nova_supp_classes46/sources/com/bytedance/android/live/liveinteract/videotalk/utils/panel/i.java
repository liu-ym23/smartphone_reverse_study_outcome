package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public i(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        ILinkPlayerInfoBridge r0 = a.a;
        a.h = false;
        a.i(r8);
        String r1 = this.a;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        long r3 = this.b;
        InteractLinkFullLinkMonitor.W(r1, System.currentTimeMillis() - r3, r8);
        String r4 = this.a;
        if (r4 == null) goto L9;
        r2 = r4;
    L9:
        x.x0(r2, r8, "self_panel");
        com.bytedance.android.live.liveinteract.voicechat.b r5 = a.o();
        if ((r5 instanceof VoiceChatMuteManager) == true) goto L12;
        r5 = null;
    L12:
        VoiceChatMuteManager r6 = (VoiceChatMuteManager) r5;
        if (r6 == null) goto L16;
        r6.m(r8);
        return;
    }
}
