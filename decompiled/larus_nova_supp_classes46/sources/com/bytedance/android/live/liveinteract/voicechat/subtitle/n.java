package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public n(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        if (((PaidSceneEnum) r5.getFirst()) != PaidSceneEnum.PAID_ROOM) goto L5;
    L6:
        LinkmicSubtitleBusinessWidget r0 = this.a;
        com.bytedance.android.livesdk.vscore_api.paidlive.l r1 = (com.bytedance.android.livesdk.vscore_api.paidlive.l) r5.getSecond();
        r1.getClass();
        if ((r1 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.e) == true) goto L12;
        com.bytedance.android.livesdk.vscore_api.paidlive.l r6 = (com.bytedance.android.livesdk.vscore_api.paidlive.l) r5.getSecond();
        r6.getClass();
        if ((r6 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.g) == true) goto L12;
        boolean r7 = false;
    L13:
        int r2 = LinkmicSubtitleBusinessWidget.x;
        if (r7 == false) goto L25;
        r0.getClass();
        LinkmicSubtitleUIContext.a r8 = LinkmicSubtitleUIContext.Companion;
        nj0.f r3 = r8.a();
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.J9() != true) goto L29;
        nj0.f r9 = r8.a();
        if (r9 == null) goto L22;
        r9.V7();
    L22:
        nj0.f r10 = r8.a();
        if (r10 == null) goto L30;
        r10.dh();
        return;
    L30:
        return;
    L29:
        return;
    L25:
        r0.Eq();
        return;
    L12:
        r7 = true;
        goto L13
    L5:
        if (((PaidSceneEnum) r5.getFirst()) == PaidSceneEnum.SUBSCRIBE_ROOM) goto L6;
    }
}
