package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.like.controller.DiggCountFlipperLayoutControllerImpl;
import com.bytedance.android.livesdk.message.model.yd;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.live.datacontext.n a;
    public final /* synthetic */ DiggWidget b;

    public p0(com.bytedance.live.datacontext.n r1, DiggWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        DiggWidget r0 = this.b;
        dh1.a r7 = (dh1.a) sh6.c.b((sh6.b) r6);
        if (r7 == null) goto L5;
        long r3 = r7.a;
    L7:
        if (r3 <= 0) goto L9;
        boolean r8 = true;
    L10:
        r0.R = r8;
        ALogger.i("DiggWidget", "DiggWidget Receive New Rtc RoomInfo: " + this.b.R);
        DiggWidget r9 = this.b;
        if (r9.R == true) goto L24;
        yd r1 = r9.P;
        if (r1 == null) goto L19;
        DiggCountFlipperLayoutControllerImpl r10 = r9.Gq();
        if (r10 == null) goto L17;
        r10.g(r1.getTotal());
        Unit r11 = Unit.INSTANCE;
    L18:
        if (r11 == null) goto L19;
    L22:
        this.b.P = null;
        return;
    L17:
        r11 = null;
    L19:
        DiggCountFlipperLayoutControllerImpl r13 = this.b.Gq();
        if (r13 == null) goto L22;
        r13.g(this.b.X);
        Unit r14 = Unit.INSTANCE;
        goto L22
    L24:
        return;
    L9:
        r8 = false;
        goto L10
    L5:
        r3 = 0;
        goto L7
    }
}
