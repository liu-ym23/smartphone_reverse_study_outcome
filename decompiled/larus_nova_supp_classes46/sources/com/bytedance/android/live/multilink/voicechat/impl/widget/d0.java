package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.core.utils.f2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public d0(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        f2.g();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        tf0.o r4 = this.a.Z;
        if (r4 == null) goto L6;
        r4.r(r3.a, Boolean.TRUE);
        return;
    }
}
