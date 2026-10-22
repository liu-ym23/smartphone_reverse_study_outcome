package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRecyclerView;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public o(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.ViewGroup, com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRecyclerView] */
    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        if (r7 == null) goto L46;
        MultiLinkCommonVoiceFeedPreview r0 = this.a;
        r0.k0 = true;
        com.bytedance.android.live.liveinteract.multiscene.a r2 = ((k1) r7.data).getLinkmicPlayModeInfo().getTeamFightInfo();
        if (r0.W() == false) goto L44;
        boolean r3 = li0.d.g(r2);
        r0.W = r3;
        if (r3 == true) goto L10;
        r0.O = false;
    L10:
        r0.post(new q(r0));
        LinkMicRecyclerView r4 = null;
        if (r0.N(r0.V1, r0.b2) == 21) goto L13;
    L25:
        BaseLinkSeatWindowView r1 = r0.g;
        if (r1 == null) goto L28;
        LinkMicRecyclerView r5 = r1.getRecyclerView();
    L30:
        if ((r5 instanceof VoiceChatRecyclerView) == false) goto L33;
        r4 = r5;
    L33:
        VoiceChatRecyclerView r8 = (VoiceChatRecyclerView) r4;
        if (r8 == null) goto L37;
        r8.t();
    L37:
        if (r0.W == false) goto L44;
        IPreviewMultiLinkOuterConfigProvider r9 = r0.b;
        if (r9 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L42:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r9.getShowFrom()) == false) goto L44;
        vm2.h.V().getClass();
        r0.E();
        goto L44
    L28:
        r5 = null;
        goto L30
    L13:
        if (r0.W == true) goto L25;
        BaseLinkSeatWindowView r10 = r0.g;
        if (r10 == null) goto L17;
        LinkMicRecyclerView r11 = r10.getRecyclerView();
    L19:
        if ((r11 instanceof VoiceChatRecyclerView) == false) goto L22;
        r4 = r11;
    L22:
        ?? r12 = (VoiceChatRecyclerView) r4;
        if (r12 == 0) goto L37;
        r12.l = true;
        r12.m = true;
        r12.invalidate();
        goto L37
    L17:
        r11 = null;
    L44:
        MultiLinkCommonVoiceFeedPreview.A(this.a, r7);
        return;
    }
}
