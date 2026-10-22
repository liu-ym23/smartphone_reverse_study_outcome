package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.message.model.l6;
import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y3 implements com.bytedance.android.livesdk.revenue.service.effect.f {
    public final /* synthetic */ z3 a;
    public final /* synthetic */ l6 b;

    public final void onError() {
    }

    public final void a(yp2.c r8) {
        Intrinsics.checkNotNullParameter(r8, "sticker");
        z3.a(this.a, r8.getId(), r8.b());
        Iterator r0 = this.a.g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        yp2.b r1 = (yp2.b) r0.next();
        if (r8.getId() == r1.getId()) goto L4;
        this.a.g.Bn(r1, RevStickerPanel.EFFECT_ATMOSPHERE);
        goto L4
    L8:
        this.a.g.nm(r8, "_astmosphere_effect", RevStickerPanel.EFFECT_ATMOSPHERE);
        i12.e r9 = i12.o.b();
        if (r9 == null) goto L11;
        Object r10 = com.bytedance.android.scope.m.e.d(r9, g1.class);
    L12:
        g1 r11 = (g1) r10;
        if (r11 == null) goto L21;
        r11.i(this.b.getScene(), this.b.getAssetId(), null);
        return;
    L21:
        return;
    L11:
        r10 = null;
        goto L12
    }

    public y3(z3 r1, l6 r2) {
        this.a = r1;
        this.b = r2;
    }
}
