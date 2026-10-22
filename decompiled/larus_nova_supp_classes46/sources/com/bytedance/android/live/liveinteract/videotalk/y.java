package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements qh0.d<rh0.a> {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
    public final /* synthetic */ lg6.a b;
    public final /* synthetic */ VideoShowMode c;
    public final /* synthetic */ VideoShowMode d;
    public final /* synthetic */ int e;
    public final /* synthetic */ boolean f;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        lg6.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailed(r2);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r7) {
        MultiLinkVideoTalkRoomGuestWidget r0 = this.a;
        VideoShowMode r1 = this.c;
        VideoShowMode r2 = this.d;
        lg6.a r3 = this.b;
        int r4 = this.e;
        boolean r5 = this.f;
        int r8 = MultiLinkVideoTalkRoomGuestWidget.i3;
        r0.dr(r1, r2, r3, r4, r5);
    }

    public y(MultiLinkVideoTalkRoomGuestWidget r1, lh6.b.b r2, VideoShowMode r3, VideoShowMode r4, String r5, int r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }
}
