package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements k<ItemListData> {
    public final LinkedList<ItemListData> a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void clear() {
        this.a.clear();
    }

    public m() {
        this.a = new LinkedList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.ITEM_LIST_DATA;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final void b(h r3) {
        Intrinsics.checkNotNullParameter(r3, "trigger");
        int r4 = this.a.size();
    L4:
        if (r4 >= 500) goto L6;
        this.a.add(new ItemListData());
        r4 = r4 + 1;
        goto L4
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final boolean c(h r4) {
        Intrinsics.checkNotNullParameter(r4, "trigger");
        if (this.a.size() <= 500) goto L6;
        return false;
    L6:
        if ((r4 instanceof h.i) == false) goto L8;
    L9:
        return true;
    L8:
        if ((r4 instanceof h.g) == true) goto L9;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k
    public final ItemListData d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        return this.a.poll();
    }
}
