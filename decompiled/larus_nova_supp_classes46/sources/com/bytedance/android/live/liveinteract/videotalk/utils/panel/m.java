package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public m(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
        a.i = false;
        String r1 = this.a;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        InteractLinkFullLinkMonitor.p0(r1, System.currentTimeMillis() - this.b, r11.logId);
        String r3 = this.a;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        c2 r4 = (c2) r11.data;
        String r5 = null;
        if (r4 == null) goto L14;
        List r6 = r4.getLinkedUsers();
        if (r6 == null) goto L14;
        String r7 = je0.d.g0(r6);
    L15:
        c2 r8 = (c2) r11.data;
        if (r8 == null) goto L20;
        Map r9 = r8.getLinkerContentMap();
        if (r9 == null) goto L20;
        r5 = r9.toString();
    L20:
        x.D0(r2, "self_panel", r7, r5);
        if (qi0.e.c() == false) goto L29;
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L29;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L29;
        if (r13.isPrivatePlay() != true) goto L29;
        f2.c(s1.B(2131923174), 0);
    L30:
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L49;
        if (r0.nd() != true) goto L49;
        if (je0.d.r() == false) goto L42;
        rj0.k.m2.getClass();
        rj0.k r14 = rj0.k.a.a();
        if (r14 == null) goto L65;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r15 = ((c2) r11.data).getLinkedUsers();
        if (r15 != null) goto L41;
        r15 = new ArrayList();
    L41:
        r14.a2(false, r15, ((c2) r11.data).getClientUiInfo(), ((c2) r11.data).getVersion(), ((c2) r11.data).getLinkerContentMap());
        return;
    L65:
        return;
    L42:
        rj0.l.n2.getClass();
        rj0.l r16 = rj0.l.a.a();
        if (r16 == null) goto L67;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r17 = ((c2) r11.data).getLinkedUsers();
        if (r17 != null) goto L47;
        r17 = new ArrayList();
    L47:
        r16.a2(false, r17, ((c2) r11.data).getClientUiInfo(), ((c2) r11.data).getVersion(), ((c2) r11.data).getLinkerContentMap());
        return;
    L67:
        return;
    L49:
        if (je0.d.r() == false) goto L53;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r18 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r18 == null) goto L56;
        r18.switchAudioByClient(false, ((c2) r11.data).getLinkedUsers(), ((c2) r11.data).getClientUiInfo(), ((c2) r11.data).getVersion(), ((c2) r11.data).getLinkerContentMap(), "self_panel");
    L56:
        IKtvService r19 = jc1.k.f(IKtvService.class);
        if (r19 == null) goto L69;
        List r20 = ((c2) r11.data).getLinkedUsers();
        if (r20 == null) goto L62;
        List r21 = CollectionsKt.toMutableList(r20);
        if (r21 == null) goto L62;
    L63:
        r19.switchAudioByClient(false, r21, ((c2) r11.data).getClientUiInfo(), ((c2) r11.data).getVersion(), ((c2) r11.data).getLinkerContentMap(), "self_panel");
        return;
    L62:
        r21 = new ArrayList();
        goto L63
    L69:
        return;
    L53:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r22 = IVoiceChatGuestService.a.a();
        if (r22 == null) goto L56;
        r22.switchAudioByClient(false, ((c2) r11.data).getLinkedUsers(), ((c2) r11.data).getClientUiInfo(), ((c2) r11.data).getVersion(), ((c2) r11.data).getLinkerContentMap(), "self_panel");
    L29:
        f2.c(s1.B(2131923173), 0);
    L14:
        r7 = null;
        goto L15
    }
}
