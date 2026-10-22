package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.multilink.voicechat.api.service.IMultiLinkVoiceService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.event.t;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.Widget;
import hh1.w0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import nz.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceAnchorContainerWidget a;

    public e(MultiLinkVoiceAnchorContainerWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r24) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r0 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r24;
        Intrinsics.checkNotNullParameter(r0, "switchSceneEvent");
        MultiLinkVoiceAnchorContainerWidget r2 = this.a;
        int r3 = r2.c;
        if (r3 == r0.a) goto L5;
    L7:
        long r4 = MultiLinkVoiceAnchorContainerWidget.wq(r3, r2.d);
        long r5 = MultiLinkVoiceAnchorContainerWidget.wq(r0.a, r0.b);
        MiddlewareRoomContext r7 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) r2).dataCenter, 0, 2);
        if (r7 == null) goto L12;
        com.bytedance.live.datacontext.j r8 = r7.getAnchorRoomScopeViewModel();
        if (r8 == null) goto L12;
        nz.l r9 = (nz.l) r8.getValue();
    L13:
        if (r9 == null) goto L15;
        w r12 = (w) r9.a();
    L17:
        if (r4 == 0) goto L21;
        if (r12 == null) goto L21;
        Long r18 = Long.valueOf(r4);
        int r6 = nz.a.a.a;
        new AnchorInteractionData(null, r18, 20L, null, 9, null);
        int r10 = nz.b.b.a;
        r12.a();
    L21:
        if (r5 == 0) goto L24;
        if (r12 == null) goto L24;
        Long r17 = Long.valueOf(r5);
        int r11 = nz.a.a.a;
        new AnchorInteractionData(null, r17, 20L, null, 9, null);
        int r13 = nz.b.a.a;
        r12.a();
    L24:
        if (r9 == null) goto L28;
        w r14 = (w) r9.a();
        if (r14 == null) goto L28;
        Long r19 = Long.valueOf(r5);
        int r15 = nz.a.a.a;
        new AnchorInteractionData(null, r19, 20L, null, 9, null);
        int r16 = nz.b.a.a;
        r14.a();
    L28:
        r2.e = r2.c;
        int r20 = r2.d;
        r2.c = r0.a;
        r2.d = r0.b;
        xs2.b.a().post(new t(2));
        boolean r21 = true;
        xs2.b.a().post(new t(1));
        int r22 = r0.a;
        if (r22 == 5) goto L81;
        if (r22 != 9) goto L33;
        com.bytedance.android.live.liveinteract.plantform.base.g r23 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r23 == null) goto L39;
        r23.Hm("voiceSceneChange");
    L39:
        if (r0.b != 61) goto L61;
        if (r2.h != null) goto L100;
        IKtvService r1 = jc1.k.n(IKtvService.class);
        com.bytedance.android.live.pushstream.d r25 = r2.l;
        w0 r26 = r2.m;
        if (r2.e == 0) goto L46;
        r21 = false;
    L46:
        a r27 = r1.createRealTimeChorusRoomAnchorWidget(r25, r26, r21);
        r2.h = r27;
        a r28 = r2.g;
        if (r28 == null) goto L52;
        if (r27 == null) goto L51;
        r27.n0(r28.s0());
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L52:
        a r29 = r2.f;
        if (r29 == null) goto L59;
        a r30 = r2.h;
        if (r30 == null) goto L58;
        r30.n0(r29.s0());
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L59:
        ((Widget) r2).subWidgetManager.unload(r2.f);
        ((Widget) r2).subWidgetManager.unload(r2.g);
        r2.f = null;
        r2.g = null;
        ((Widget) r2).subWidgetManager.load(2131392754, r2.h);
        return;
    L100:
        return;
    L61:
        if (r2.g != null) goto L102;
        IKtvService r31 = jc1.k.n(IKtvService.class);
        com.bytedance.android.live.pushstream.d r32 = r2.l;
        w0 r33 = r2.m;
        if (r2.e == 0) goto L66;
        r21 = false;
    L66:
        a r34 = r31.createKtvRoomAnchorWidget(r32, r33, r21);
        r2.g = r34;
        a r35 = r2.f;
        if (r35 == null) goto L72;
        if (r34 == null) goto L71;
        r34.n0(r35.s0());
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L72:
        a r36 = r2.h;
        if (r36 == null) goto L79;
        a r37 = r2.g;
        if (r37 == null) goto L78;
        r37.n0(r36.s0());
        goto L79
    L78:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L79:
        ((Widget) r2).subWidgetManager.unload(r2.f);
        ((Widget) r2).subWidgetManager.unload(r2.h);
        r2.f = null;
        r2.h = null;
        ((Widget) r2).subWidgetManager.load(2131392754, r2.g);
        return;
    L102:
        return;
    L33:
        if (r22 == 16) goto L81;
        return;
    L81:
        if (r2.f != null) goto L104;
        com.bytedance.android.live.liveinteract.plantform.base.g r38 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r38 == null) goto L85;
        r38.Cj("voiceSceneChange");
    L85:
        a r39 = ((IMultiLinkVoiceService) jc1.k.n(IMultiLinkVoiceService.class)).createVoiceChatRoomAnchorWidget(r2.k, r2.l, r2.m, r2.e, r20);
        r2.f = r39;
        a r40 = r2.g;
        if (r40 == null) goto L91;
        if (r39 == null) goto L90;
        r39.n0(r40.s0());
        goto L91
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L91:
        a r41 = r2.h;
        if (r41 == null) goto L98;
        a r42 = r2.f;
        if (r42 == null) goto L97;
        r42.n0(r41.s0());
        goto L98
    L97:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.IVoiceAnchorLinkService");
    L98:
        ((Widget) r2).subWidgetManager.unload(r2.g);
        ((Widget) r2).subWidgetManager.unload(r2.h);
        r2.g = null;
        r2.h = null;
        ((Widget) r2).subWidgetManager.load(2131392754, r2.f);
        return;
    L104:
        return;
    L15:
        r12 = null;
    L12:
        r9 = null;
        goto L13
    L5:
        if (r2.d != r0.b) goto L7;
    }
}
