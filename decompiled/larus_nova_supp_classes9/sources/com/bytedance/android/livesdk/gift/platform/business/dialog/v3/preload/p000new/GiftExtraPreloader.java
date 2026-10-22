package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import java.util.Iterator;
import jy0.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftExtraPreloader extends n {
    public Long a;
    public final boolean b;
    public h1 c;
    public final GiftExtraRepo d;
    public final j e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.GIFT_EXTRA;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r6) {
        Intrinsics.checkNotNullParameter(r6, "trigger");
        h1 r7 = this.c;
        if (r7 != null) goto L6;
        return;
    L6:
        if ((r7.getReqExtraType() & 2) == 2) goto L9;
        b.c("ttlive_gift_extra_preload", "intercept preload " + r7.getId() + " since reqExtraType=" + r7.getReqExtraType(), null, 4);
        return;
    L9:
        this.a = Long.valueOf(r7.getId());
        this.d.U(CollectionsKt.listOf(Long.valueOf(r7.getId())), "touchDownPreload", this.e.c(), new GiftExtraPreloader$execute$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r7) {
        Intrinsics.checkNotNullParameter(r7, "trigger");
        if ((r7 instanceof h.f) == false) goto L24;
        Iterator<T> r0 = ((h.f) r7).a.iterator();
    L5:
        Object r4 = null;
        if (r0.hasNext() == false) goto L13;
        Object r3 = r0.next();
        if (((w1) r3).getPageType() != 1) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L5;
    L14:
        w1 r6 = (w1) r3;
        if (r6 == null) goto L24;
        Iterator<T> r1 = r6.getGifts().iterator();
    L18:
        if (r1.hasNext() == false) goto L22;
        Object r8 = r1.next();
        if (((h1) r8).isDisplayedOnPanel() == false) goto L18;
        r4 = r8;
    L22:
        this.c = (h1) r4;
        goto L24
    L10:
        r5 = false;
        goto L11
    L13:
        r3 = null;
    L24:
        if ((r7 instanceof h.i) == true) goto L26;
        return false;
    L26:
        if (this.a == null) goto L28;
        return false;
    L28:
        if (this.d.e.isEmpty() == true) goto L30;
        return false;
    L30:
        if (this.b == false) goto L44;
        return true;
    L44:
        return false;
    }

    public GiftExtraPreloader(GiftExtraRepo r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r3, "preloadContext");
        this.d = r2;
        this.e = r3;
        this.b = GiftPreloadSettingsKt.a().g();
    }
}
