package com.bytedance.android.live.liveinteract.videotalk;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public e(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
        r0.P1 = Intrinsics.areEqual((Boolean) r3, Boolean.TRUE);
    }
}
