package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    public k(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        int r5 = ((Number) r4).intValue();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        hg6.g r1 = this.a.D;
        if (r1 == null) goto L5;
        r1.D(r0, "ktvPlayModeChanged");
    L5:
        if (r5 != 0) goto L14;
        hg6.g r6 = this.a.D;
        if (r6 == null) goto L9;
        ig6.a r7 = r6.x();
    L10:
        Intrinsics.checkNotNull(r7);
        r7.b(MultiLinkInfoType.KTV_COMPONENT);
        hg6.g r8 = this.a.D;
        if (r8 == null) goto L15;
        r8.K();
        return;
    L15:
        return;
    L9:
        r7 = null;
        goto L10
    }
}
