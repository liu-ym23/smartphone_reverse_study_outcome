package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftPanelAssetDownloadDataStore;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements i, com.bytedance.android.scope.o {
    public g() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.i
    public final List<Long> k7() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftPanelAssetDownloadDataStore.class);
    L6:
        GiftPanelAssetDownloadDataStore r2 = (GiftPanelAssetDownloadDataStore) r1;
        if (r2 == null) goto L11;
        List<Long> r3 = CollectionsKt.toList(r2.a);
        if (r3 == null) goto L11;
        return r3;
    L11:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }
}
