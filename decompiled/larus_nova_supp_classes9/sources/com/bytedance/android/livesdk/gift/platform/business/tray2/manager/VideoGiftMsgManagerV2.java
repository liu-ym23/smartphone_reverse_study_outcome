package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VideoGiftMsgManagerV2 extends a<NormalGiftMessage> {
    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a
    public final y02.f<NormalGiftMessage> f() {
        return new y02.d();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void m() {
        this.f.a(VideoGiftMsgManagerV2$clearRtcRoomMessage$1.INSTANCE);
    }

    public VideoGiftMsgManagerV2() {
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.c.a;
        Intrinsics.checkNotNullParameter("CMessageManager", "<set-?>");
        this.a = "CMessageManager";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a, com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final Object c() {
        NormalGiftMessage r0 = (NormalGiftMessage) super.c();
        if (r0 == null) goto L5;
        r0.setTimeStampMap(3, com.bytedance.live.kmp.util.e.b());
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final int n(Object r4) {
        NormalGiftMessage r5 = (NormalGiftMessage) r4;
        if (r5 != null) goto L5;
        v12.f.B("normalMsg == null");
        return -1;
    L5:
        String r0 = v12.f.a;
        v12.f.o(r5, this.g, this.h);
        r5.setTimeStampMap(11, this.f.size());
        r5.setTimeStampMap(12, this.f.b());
        this.f.put((T) r5);
        return 0;
    }
}
