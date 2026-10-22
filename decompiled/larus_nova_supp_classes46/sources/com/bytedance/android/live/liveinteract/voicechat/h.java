package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ long b;

    public h(VoiceChatMuteManager r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        String r0 = je0.d.b0();
        long r1 = this.b;
        InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
        x.x0(je0.d.b0(), r7, "auto silence when mute");
        this.a.a = false;
    }
}
