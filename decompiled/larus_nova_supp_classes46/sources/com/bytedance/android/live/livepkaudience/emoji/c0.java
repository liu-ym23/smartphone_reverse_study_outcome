package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ LinkPKGameInteractPanel a;
    public final /* synthetic */ String b;

    public c0(LinkPKGameInteractPanel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        this.a.x = false;
        String r0 = this.b.toString();
        c2 r2 = (c2) r12.data;
        List<AnchorLinkUser> r3 = null;
        if (r2 == null) goto L7;
        List r4 = r2.getLinkedUsers();
        if (r4 == null) goto L7;
        String r5 = dl0.q.a(r4);
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.x.D0(r0, "self_panel", r5, null);
        LinkPKGameInteractPanel r1 = this.a;
        DATA r13 = r12.data;
        if (r13 == 0) goto L35;
        UnSilenceResponse r14 = (UnSilenceResponse) r13;
        r1.getClass();
        f2.c(s1.B(2131923173), 0);
        if (r1.j == false) goto L22;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r6 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r6 == null) goto L32;
        List<AnchorLinkUser> r7 = r14.getLinkedUsers();
        if ((r7 instanceof List) == false) goto L18;
        r3 = r7;
    L18:
        if (r3 != null) goto L20;
        List<AnchorLinkUser> r8 = CollectionsKt.emptyList();
    L21:
        r6.switchAudioByClient(false, r8, r14.getVersion(), r14.getLinkerContentMap());
        goto L32
    L20:
        r8 = r3;
    L32:
        LinkPKGameInteractPanel.V0(r1);
        return;
    L22:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r9 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r9 == null) goto L32;
        List<AnchorLinkUser> r10 = r14.getLinkedUsers();
        if ((r10 instanceof List) == false) goto L28;
        r3 = r10;
    L28:
        if (r3 != null) goto L30;
        List<AnchorLinkUser> r15 = CollectionsKt.emptyList();
    L31:
        r9.switchAudioByClient(false, r15, r14.getVersion(), r14.getLinkerContentMap());
        goto L32
    L30:
        r15 = r3;
        goto L31
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse");
    L7:
        r5 = null;
        goto L8
    }
}
