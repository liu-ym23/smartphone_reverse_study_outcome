package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public g(VoiceChatMuteManager r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        VoiceChatMuteManager r0 = this.a;
        r0.a = false;
        dn0.c r1 = (dn0.c) r0.v.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r1 == null) goto L5;
        r1.Z(this.b, ((r1) r12.data).getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_API);
    L5:
        InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.c, r12.logId);
        String r2 = je0.d.b0();
        r1 r3 = (r1) r12.data;
        String r4 = null;
        if (r3 == null) goto L10;
        List r5 = r3.getLinkedUsers();
        if (r5 == null) goto L10;
        String r6 = je0.d.g0(r5);
    L11:
        r1 r7 = (r1) r12.data;
        if (r7 == null) goto L16;
        Map r8 = r7.getLinkerContentMap();
        if (r8 == null) goto L16;
        r4 = r8.toString();
    L16:
        x.w0(r2, "auto silence when mute", r6, r4);
        DataCenter r9 = this.a.s;
        Boolean r10 = Boolean.TRUE;
        r9.put("data_self_is_silenced", r10);
        r1 r13 = (r1) r12.data;
        if (r13 == null) goto L21;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r14 = r13.getLinkedUsers();
        if (r14 == null) goto L21;
        this.a.r.S4(r14, ((r1) r12.data).getClientUiInfo(), ((r1) r12.data).getVersion(), "silence [auto silence when mute]");
    L21:
        this.a.t.G4(true, "auto silence when mute");
        this.a.f.postValue(r10);
        return;
    L10:
        r6 = null;
        goto L11
    }
}
