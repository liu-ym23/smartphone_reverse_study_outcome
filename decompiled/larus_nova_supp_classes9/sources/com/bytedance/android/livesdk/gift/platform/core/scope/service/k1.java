package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k1 implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.h, com.bytedance.android.scope.o {
    public k1() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.h
    public final List<List<com.bytedance.android.livesdk.gift.model.h1>> X2() {
        GiftManagerKt.z.getClass();
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, PropListService.class);
    L6:
        PropListService r2 = (PropListService) r1;
        ArrayList r3 = new ArrayList();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L40;
        Iterator<T> r4 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).N3().c.iterator();
    L10:
        if (r4.hasNext() == false) goto L61;
        com.bytedance.android.livesdk.gift.model.w1 r5 = (com.bytedance.android.livesdk.gift.model.w1) r4.next();
        if (r5.getDisplay() == false) goto L10;
        ArrayList r6 = new ArrayList();
        if (r5.getPageType() != 5) goto L33;
        if (r2 == null) goto L17;
        List<com.bytedance.android.livesdk.gift.model.l2> r7 = r2.a;
    L19:
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == true) goto L33;
        if (r2 == null) goto L39;
        List<com.bytedance.android.livesdk.gift.model.l2> r9 = r2.a;
        if (r9 == null) goto L39;
        Iterator r10 = ((ArrayList) r9).iterator();
    L31:
        if (r10.hasNext() == false) goto L39;
        r6.add(((com.bytedance.android.livesdk.gift.model.l2) r10.next()).getGift());
    L39:
        r3.add(r6);
        goto L10
    L21:
        if (r7.isEmpty() == true) goto L24;
        r8 = false;
        goto L25
    L17:
        r7 = null;
    L33:
        Iterator<T> r11 = r5.getGifts().iterator();
    L35:
        if (r11.hasNext() == false) goto L39;
        com.bytedance.android.livesdk.gift.model.h1 r13 = (com.bytedance.android.livesdk.gift.model.h1) r11.next();
        if (r13.isDisplayedOnPanel() == false) goto L35;
        r6.add(r13);
    L61:
        return r3;
    L40:
        Iterator r14 = ((ArrayList) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.b()).iterator();
    L42:
        if (r14.hasNext() == false) goto L61;
        List r15 = (List) r14.next();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L45:
        if (r17.hasNext() == false) goto L60;
        Object r18 = ((AbsPanel) r17.next()).h;
        if ((r18 instanceof com.bytedance.android.livesdk.gift.model.h1) == true) goto L49;
        boolean r19 = r18 instanceof com.bytedance.android.livesdk.gift.model.l2;
        if (r19 == false) goto L45;
        if (r19 == true) goto L55;
        r18 = null;
    L55:
        com.bytedance.android.livesdk.gift.model.l2 r20 = (com.bytedance.android.livesdk.gift.model.l2) r18;
        if (r20 == null) goto L45;
        com.bytedance.android.livesdk.gift.model.h1 r21 = r20.getGift();
        if (r21 == null) goto L45;
        r16.add(r21);
        goto L45
    L49:
        if (((com.bytedance.android.livesdk.gift.model.h1) r18).isDisplayedOnPanel() == false) goto L45;
        r16.add(r18);
        goto L45
    L60:
        r3.add(r16);
        goto L42
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.h
    public final com.bytedance.android.livesdk.gift.model.h1 findGiftById(long r2) {
        return GiftManagerKt.j(r2, null);
    }
}
