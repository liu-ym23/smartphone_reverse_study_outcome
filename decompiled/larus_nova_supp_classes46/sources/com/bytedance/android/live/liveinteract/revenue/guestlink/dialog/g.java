package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends lb6.a {
    public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

    public g(GuestLinkMainPageDialogForAudience r1) {
        this.a = r1;
    }

    public final void h(long r1, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        ALogger.i("GuestLinkMainPageDialogForAudience", "onEnterChannelSuccess");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
        String r2 = ((com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r3.data).getStreamData();
        if (r2 == null) goto L8;
        GuestLinkMainPageDialogForAudience r5 = this.a;
        int r6 = GuestLinkMainPageDialogForAudience.S;
        r5.getClass();
        ALogger.i("GuestLinkMainPageDialogForAudience", "stopPlay");
        ILivePlayerClient r7 = r5.N;
        if (r7 == null) goto L7;
        r7.stop();
    L7:
        this.a.ha0(r2);
    L8:
        com.bytedance.android.livesdk.multilink.base.model.guestlink.b r8 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r3.data;
        if (r8 == null) goto L14;
        com.bytedance.android.live.base.model.message.guestlink.a r9 = r8.getChannelInfo();
        if (r9 == null) goto L15;
        tb6.a.f(false, r9);
        return;
    L15:
        return;
    }

    public final void o(long r2, Throwable r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        super.o(r2, r4, r5);
        ALogger.e("GuestLinkMainPageDialogForAudience", "onEnterChannelFailed");
    }
}
