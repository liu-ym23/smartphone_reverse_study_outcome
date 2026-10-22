package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends d {
    @Override // com.bytedance.android.live.livepkaudience.emoji.d
    public final void c0(SilenceResponse r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        f2.b(2131919297, 0);
        Map<Long, ? extends RoomLinkerContent> r1 = null;
        if (this.g == false) goto L15;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r2 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r2 == null) goto L27;
        List r0 = r9.getLinkedUsers();
        if (r0 == null) goto L10;
        List<AnchorLinkUser> r3 = jm2.a.c(r0);
        if (r3 == null) goto L10;
    L11:
        List<AnchorLinkUser> r4 = r3;
        long r5 = r9.getVersion();
        Map r10 = r9.getLinkerContentMap();
        if (r10 == null) goto L14;
        r1 = jm2.a.b(r10);
    L14:
        r2.switchAudioByClient(true, r4, r5, r1);
        return;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L27:
        return;
    L15:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r6 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r6 == null) goto L29;
        List r7 = r9.getLinkedUsers();
        if (r7 == null) goto L21;
        List<AnchorLinkUser> r8 = jm2.a.c(r7);
        if (r8 == null) goto L21;
    L22:
        List<AnchorLinkUser> r11 = r8;
        long r12 = r9.getVersion();
        Map r13 = r9.getLinkerContentMap();
        if (r13 == null) goto L25;
        r1 = jm2.a.b(r13);
    L25:
        r6.switchAudioByClient(true, r11, r12, r1);
        return;
    L21:
        r8 = CollectionsKt.emptyList();
        goto L22
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d
    public final void d0(UnSilenceResponse r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        f2.c(s1.B(2131923173), 0);
        List<AnchorLinkUser> r1 = null;
        if (this.g == false) goto L14;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r2 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r2 == null) goto L25;
        List<AnchorLinkUser> r0 = r9.getLinkedUsers();
        if ((r0 instanceof List) == false) goto L10;
        r1 = r0;
    L10:
        if (r1 != null) goto L12;
        List<AnchorLinkUser> r4 = CollectionsKt.emptyList();
    L13:
        r2.switchAudioByClient(false, r4, r9.getVersion(), r9.getLinkerContentMap());
        return;
    L12:
        r4 = r1;
        goto L13
    L25:
        return;
    L14:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r3 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r3 == null) goto L27;
        List<AnchorLinkUser> r5 = r9.getLinkedUsers();
        if ((r5 instanceof List) == false) goto L20;
        r1 = r5;
    L20:
        if (r1 != null) goto L22;
        List<AnchorLinkUser> r6 = CollectionsKt.emptyList();
    L23:
        r3.switchAudioByClient(false, r6, r9.getVersion(), r9.getLinkerContentMap());
        return;
    L22:
        r6 = r1;
        goto L23
    }

    public o(boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }
}
