package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.bh;
import com.bytedance.android.livesdk.message.model.gh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements com.bytedance.android.live.broadcastgame.c0<u>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
    }

    public v(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.b.addMessageListener(MessageType.OPEN_GAME_FOLLOW_STATUS_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r17) {
        Intrinsics.checkNotNullParameter(r17, "message");
        if ((r17 instanceof gh) == false) goto L16;
        List r0 = ((gh) r17).items;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        bh r3 = (bh) r2.next();
        if ((!r3.userInfo.isEmpty()) == false) goto L10;
        t r4 = new t(r3.userInfo, r3.secNickName, r3.secAvatarUrl, r3.action, String.valueOf(r3.timestamp));
    L11:
        r1.add(r4);
        goto L6
    L10:
        r4 = new t(r3.userInfo, r3.secNickName, r3.secAvatarUrl, r3.action, String.valueOf(r3.timestamp));
        goto L11
    L12:
        com.bytedance.android.live.broadcastgame.b0 r5 = this.a;
        if (r5 == null) goto L20;
        r5.insert(new u(r1));
        return;
    L20:
        return;
    }
}
