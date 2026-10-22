package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;

    public k(VoiceChatMuteManager r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        je0.d.Q(this.a.c, r7);
        String r0 = this.b;
        long r1 = this.a.h;
        InteractLinkFullLinkMonitor.o0(r0, System.currentTimeMillis() - r1, r7);
        ALogger.i("voice_chat", "forceUnSilence failed");
        x.E0(this.b, r7, "ktv forceUnSilence");
        this.a.b = false;
    }
}
