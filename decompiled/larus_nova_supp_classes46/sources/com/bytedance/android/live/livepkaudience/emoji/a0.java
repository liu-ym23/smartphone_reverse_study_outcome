package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ LinkPKGameInteractPanel a;
    public final /* synthetic */ String b;

    public a0(LinkPKGameInteractPanel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
        CompositeDisposable r0 = LinkSecurityManager.b;
        LinkSecurityManager.b(this.b, ((r1) r12.data).getAckMessage(), LinkSecurityManager.AckFromSource.PK_WITH_AUDIENCE_SILENCE_API);
        this.a.w = false;
        cl0.a.g(cl0.a.d);
        String r1 = this.b.toString();
        r1 r2 = (r1) r12.data;
        Map<Long, ? extends RoomLinkerContent> r3 = null;
        if (r2 == null) goto L7;
        List r4 = r2.getLinkedUsers();
        if (r4 == null) goto L7;
        String r5 = dl0.q.a(r4);
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.x.w0(r1, "self_panel", r5, null);
        LinkPKGameInteractPanel r6 = this.a;
        DATA r13 = r12.data;
        if (r13 == 0) goto L37;
        SilenceResponse r14 = (SilenceResponse) r13;
        r6.getClass();
        f2.b(2131919297, 0);
        if (r6.j == false) goto L23;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r7 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r7 == null) goto L34;
        List r8 = r14.getLinkedUsers();
        if (r8 == null) goto L18;
        List<AnchorLinkUser> r9 = jm2.a.c(r8);
        if (r9 == null) goto L18;
    L19:
        List<AnchorLinkUser> r10 = r9;
        long r15 = r14.getVersion();
        Map r16 = r14.getLinkerContentMap();
        if (r16 == null) goto L22;
        r3 = jm2.a.b(r16);
    L22:
        r7.switchAudioByClient(true, r10, r15, r3);
    L18:
        r9 = CollectionsKt.emptyList();
    L34:
        LinkPKGameInteractPanel.V0(r6);
        return;
    L23:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r17 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r17 == null) goto L34;
        List r18 = r14.getLinkedUsers();
        if (r18 == null) goto L29;
        List<AnchorLinkUser> r19 = jm2.a.c(r18);
        if (r19 == null) goto L29;
    L30:
        List<AnchorLinkUser> r20 = r19;
        long r21 = r14.getVersion();
        Map r110 = r14.getLinkerContentMap();
        if (r110 == null) goto L33;
        r3 = jm2.a.b(r110);
    L33:
        r17.switchAudioByClient(true, r20, r21, r3);
    L29:
        r19 = CollectionsKt.emptyList();
        goto L30
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse");
    L7:
        r5 = null;
        goto L8
    }
}
