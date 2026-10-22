package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements xb6.c {
    public final /* synthetic */ a a;

    public final IJoinChannelResult getPreRtcInfo() {
        IJoinChannelResult r0 = vh7.f.c(IJoinChannelResult.class);
        IJoinChannelResult.a r1 = IJoinChannelResult.Companion;
        String r2 = this.a.h.b();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        User r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getUser();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        ArrayList r4 = new ArrayList();
        com.bytedance.android.livesdk.link.model.bridge.k r5 = vh7.f.c(com.bytedance.android.livesdk.link.model.bridge.k.class);
        r5.setUser(r3);
        r5.setLinkType(2);
        r5.setLinkMicIdStr(r2);
        r4.add(r5);
        r0.setLinkedUsers(r4);
        return r0;
    }

    public b(a r1) {
        this.a = r1;
    }
}
