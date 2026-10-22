package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    public p(int r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.util.ArrayList] */
    public final void run() {
        boolean r1 = false;
        if (GiftPreloadSettingsKt.b().d() == true) goto L5;
        GiftListRepo r0 = GiftListRepo.k;
        List r4 = this.b;
        r0.getClass();
        com.bytedance.android.livesdk.gift.util.d.b(GiftListRepo.c(r4), this.a);
    L30:
        int r2 = this.a;
        if (r2 != 2) goto L33;
    L34:
        r1 = true;
    L35:
        if (r1 == false) goto L93;
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L39;
        Object r5 = com.bytedance.android.scope.m.e.d(r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i.class);
    L40:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r6 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i) r5;
        if (r6 == null) goto L94;
        List r7 = this.b;
        Intrinsics.checkNotNullParameter(r7, "giftPages");
        RevenueImageUrlService r8 = (RevenueImageUrlService) com.bytedance.android.live.revenue.core.util.f.a(RevenueImageUrlService.class);
        Intrinsics.checkNotNullParameter(r7, "giftPages");
        if (r8.a.size() > 12) goto L66;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L47:
        if (r10.hasNext() == false) goto L51;
        Object r11 = r10.next();
        if (((w1) r11).getDisplay() == false) goto L47;
        r9.add(r11);
        goto L47
    L51:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r9.iterator();
    L53:
        if (r14.hasNext() == false) goto L55;
        CollectionsKt.addAll(r13, ((w1) r14.next()).getGifts());
        goto L53
    L55:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L57:
        if (r16.hasNext() == false) goto L64;
        py.k r17 = ((h1) r16.next()).getImage();
        if (r17 == null) goto L61;
        String r18 = r17.getUri();
    L62:
        if (r18 == null) goto L57;
        r15.add(r18);
        goto L57
    L61:
        r18 = null;
        goto L62
    L64:
        r8.a.addAll(r15);
    L66:
        if (i12.m.e2.a() == null) goto L68;
        return;
    L68:
        if (r6.f.isAnchor() == true) goto L96;
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r19 = GiftPreloadManager.a;
        GiftPreloadManager.b(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h.f(r7));
        return;
    L96:
        return;
    L94:
        return;
    L39:
        r5 = null;
        goto L40
    L93:
        return;
    L33:
        if (r2 != 13) goto L35;
    L5:
        if (this.a != 3) goto L30;
        Iterator r20 = this.b.iterator();
    L8:
        if (r20.hasNext() == false) goto L15;
        Object r21 = r20.next();
        if (((w1) r21).getPageType() != 1) goto L12;
        boolean r23 = true;
    L13:
        if (r23 == false) goto L8;
    L16:
        w1 r24 = (w1) r21;
        if (r24 == null) goto L19;
        List<h1> r25 = r24.getGifts();
    L20:
        if (r25 == null) goto L27;
        ?? r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L23:
        if (r27.hasNext() == false) goto L28;
        Object r28 = r27.next();
        if (((h1) r28).isDisplayedOnPanel() == false) goto L23;
        r26.add(r28);
    L28:
        com.bytedance.android.livesdk.gift.util.d.b(r26, this.a);
        goto L30
    L27:
        r26 = CollectionsKt.emptyList();
        goto L28
    L19:
        r25 = null;
        goto L20
    L12:
        r23 = false;
        goto L13
    L15:
        r21 = null;
        goto L16
    }
}
