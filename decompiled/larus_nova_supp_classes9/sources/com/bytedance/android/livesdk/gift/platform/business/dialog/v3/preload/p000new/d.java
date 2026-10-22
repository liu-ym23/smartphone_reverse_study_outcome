package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import ca0.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements k<a> {
    public a a;
    public long b;
    public boolean c;
    public final boolean d;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void clear() {
        this.a = null;
    }

    public d() {
        this.d = GiftPreloadSettingsKt.a().h();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.ANNIE_LYNX_MODEL;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r4) {
        Intrinsics.checkNotNullParameter(r4, "trigger");
        this.c = true;
        String r5 = h.k().a();
        e r0 = f.d(j.C0.a(), e.class);
        if (r0 == null) goto L6;
        List r1 = r0.getBehaviorList();
        if (r1 == null) goto L6;
    L7:
        this.a = new a(c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).p3(UriProtector.parse(r5), CollectionsKt.emptyList(), r1));
        this.b = System.currentTimeMillis();
        this.c = false;
        return;
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r8) {
        Intrinsics.checkNotNullParameter(r8, "trigger");
        if (this.d == true) goto L5;
        return false;
    L5:
        if (this.c == false) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L14;
        return false;
    L14:
        if ((r8 instanceof h.i) == true) goto L18;
        if ((r8 instanceof h.d) == true) goto L18;
        return false;
    L18:
        if (h.k().g() == true) goto L25;
        return true;
    L25:
        return false;
    L9:
        if ((System.currentTimeMillis() - this.b) >= 3000) goto L11;
        r0 = true;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final a d(f r6) {
        Intrinsics.checkNotNullParameter(r6, "cacheKey");
        if (this.d == true) goto L5;
        return null;
    L5:
        if (this.a != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L15;
        a r8 = this.a;
        this.a = null;
        return r8;
    L15:
        return null;
    L7:
        if ((System.currentTimeMillis() - this.b) >= 3000) goto L9;
        r7 = true;
        goto L10
    }
}
