package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

    public i(MultiLinkVideoTalkRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        hg6.g r1 = this.a.R1();
        if (r1 == null) goto L5;
        r1.D(r0, "ktvPlayModeChanged");
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.intValue() != 0) goto L18;
        hg6.g r6 = this.a.R1();
        if (r6 == null) goto L14;
        ig6.a r7 = r6.x();
        if (r7 == null) goto L14;
        r7.b(MultiLinkInfoType.KTV_COMPONENT);
    L14:
        hg6.g r8 = this.a.R1();
        if (r8 == null) goto L19;
        r8.K();
        return;
    L19:
        return;
    }
}
