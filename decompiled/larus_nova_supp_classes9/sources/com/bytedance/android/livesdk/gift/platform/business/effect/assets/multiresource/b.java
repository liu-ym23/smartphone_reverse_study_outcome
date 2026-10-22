package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends DefaultResourceSupport {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r3) {
        c12.e r4 = e(r3, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r1 = GiftResourceManagerFactory.a();
        if (r1 == null) goto L5;
        Boolean r5 = Boolean.valueOf(r1.e(r4));
    L6:
        if (r5 != null) goto L8;
        return false;
    L8:
        return r5.booleanValue();
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r1) {
        return DefaultResourceSupport.h(r1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(e r1, int r2) {
        c12.e r3 = e(r1, r2);
        if (r3 == null) goto L7;
        return CollectionsKt.listOf(r3);
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r1, int r2) {
        return e(r1, r2);
    }
}
