package com.bytedance.android.live.liveinteract.videotalk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements ne0.a {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public v(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 == null) goto L8;
        String r4 = (String) r3;
        xf6.b r5 = this.a.Tq();
        if (r5 == null) goto L9;
        r5.F3(r4);
        return;
    L9:
        return;
    }
}
