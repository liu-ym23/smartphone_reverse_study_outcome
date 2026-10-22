package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        k r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r1 = r0.getMessageHub();
        if (r1 == null) goto L9;
        r1.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        k r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r1 = r0.getMessageHub();
        if (r1 == null) goto L9;
        r1.removeMessageListener(MessageType.LINK_MIC.getIntType(), this);
        return;
    }

    public d() {
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof z0) == false) goto L17;
        z0 r5 = (z0) r4;
        if (((int) r5.getType2()) != 17) goto L18;
        boolean r6 = d0.e(r5.getPlayModes());
        ch0.a r0 = c().e();
        List r1 = CollectionsKt.toMutableList(r0.c);
        if (r6 == false) goto L13;
        if (r1.contains(4) == true) goto L15;
        r1.add(4);
    L15:
        ch0.a r7 = ch0.a.a(r0, 0, 0, r1, 3);
        c().l(r7);
        return;
    L13:
        if (r1.contains(4) == false) goto L15;
        r1.remove(4);
        goto L15
    L18:
        return;
    }
}
