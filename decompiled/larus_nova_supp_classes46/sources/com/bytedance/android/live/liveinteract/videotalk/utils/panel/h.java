package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public h(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        String r1 = this.a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (Intrinsics.areEqual(r0, r1) == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.base.g r3 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r3 != null) goto L10;
    L12:
        com.bytedance.android.live.liveinteract.plantform.base.g r4 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r4 == null) goto L17;
        if (r4.s8() != true) goto L17;
        com.bytedance.android.live.liveinteract.linksecurity.c.o(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        goto L17
    L10:
        if (r3.nd() != true) goto L12;
        com.bytedance.android.live.liveinteract.linksecurity.b.o(com.bytedance.android.live.liveinteract.linksecurity.b.g);
    L17:
        a.h = false;
        String r5 = this.a;
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        InteractLinkFullLinkMonitor.X(r5, System.currentTimeMillis() - this.b, r11.logId);
        IMultiLinkInternalService r6 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r6 == null) goto L28;
        dn0.c r7 = r6.getLinkSecurityService();
        if (r7 == null) goto L28;
        String r8 = this.a;
        if (r8 != null) goto L27;
        r8 = "";
    L27:
        r7.Z(r8, ((r1) r11.data).getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_API);
    L28:
        String r9 = this.a;
        if (r9 == null) goto L32;
        r2 = r9;
    L32:
        r1 r12 = (r1) r11.data;
        String r13 = null;
        if (r12 == null) goto L37;
        List r14 = r12.getLinkedUsers();
        if (r14 == null) goto L37;
        String r15 = je0.d.g0(r14);
    L38:
        r1 r16 = (r1) r11.data;
        if (r16 == null) goto L43;
        Map r17 = r16.getLinkerContentMap();
        if (r17 == null) goto L43;
        r13 = r17.toString();
    L43:
        x.w0(r2, "self_panel", r15, r13);
        if (qi0.e.c() == false) goto L52;
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r18 == null) goto L52;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L52;
        if (r19.isPrivatePlay() != true) goto L52;
        f2.b(2131919298, 0);
    L53:
        com.bytedance.android.live.liveinteract.plantform.base.g r20 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r20 == null) goto L72;
        if (r20.nd() != true) goto L72;
        if (je0.d.r() == false) goto L65;
        rj0.k.m2.getClass();
        rj0.k r21 = rj0.k.a.a();
        if (r21 == null) goto L88;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r22 = ((r1) r11.data).getLinkedUsers();
        if (r22 != null) goto L64;
        r22 = new ArrayList();
    L64:
        r21.a2(true, r22, ((r1) r11.data).getClientUiInfo(), ((r1) r11.data).getVersion(), ((r1) r11.data).getLinkerContentMap());
        return;
    L88:
        return;
    L65:
        rj0.l.n2.getClass();
        rj0.l r23 = rj0.l.a.a();
        if (r23 == null) goto L90;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r24 = ((r1) r11.data).getLinkedUsers();
        if (r24 != null) goto L70;
        r24 = new ArrayList();
    L70:
        r23.a2(true, r24, ((r1) r11.data).getClientUiInfo(), ((r1) r11.data).getVersion(), ((r1) r11.data).getLinkerContentMap());
        return;
    L90:
        return;
    L72:
        if (je0.d.r() == false) goto L76;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r25 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r25 == null) goto L79;
        r25.switchAudioByClient(true, ((r1) r11.data).getLinkedUsers(), ((r1) r11.data).getClientUiInfo(), ((r1) r11.data).getVersion(), ((r1) r11.data).getLinkerContentMap(), "self_panel");
    L79:
        IKtvService r26 = jc1.k.f(IKtvService.class);
        if (r26 == null) goto L92;
        List r27 = ((r1) r11.data).getLinkedUsers();
        if (r27 == null) goto L85;
        List r28 = CollectionsKt.toMutableList(r27);
        if (r28 == null) goto L85;
    L86:
        r26.switchAudioByClient(true, r28, ((r1) r11.data).getClientUiInfo(), ((r1) r11.data).getVersion(), ((r1) r11.data).getLinkerContentMap(), "self_panel");
        return;
    L85:
        r28 = new ArrayList();
        goto L86
    L92:
        return;
    L76:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r29 = IVoiceChatGuestService.a.a();
        if (r29 == null) goto L79;
        r29.switchAudioByClient(true, ((r1) r11.data).getLinkedUsers(), ((r1) r11.data).getClientUiInfo(), ((r1) r11.data).getVersion(), ((r1) r11.data).getLinkerContentMap(), "self_panel");
    L52:
        f2.b(2131919297, 0);
    L37:
        r15 = null;
        goto L38
    }
}
