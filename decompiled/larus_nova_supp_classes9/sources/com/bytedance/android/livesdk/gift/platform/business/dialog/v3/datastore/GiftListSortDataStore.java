package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import androidx.collection.LongSparseArray;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.GiftStickerSortService;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListSortDataStore extends BaseMVIDataStore<c> implements com.bytedance.android.scope.o {
    public Set<Long> e;
    public final LongSparseArray<Integer> f;
    public String g;
    public List<Integer> h;
    public com.bytedance.android.livesdk.gift.platform.core.model.j i;
    public final Map<String, Map<Long, Boolean>> j;
    public final Lazy k;
    public final f1 l;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f m;
    public final GiftExtraRepo n;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
    }

    public final z1 k() {
        return this.n.J();
    }

    public final boolean o() {
        if (this.h.isEmpty() == false) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        return false;
    L9:
        z1 r1 = this.n.J();
        if (r1 != null) goto L12;
        return false;
    L12:
        IGiftMarketingInfo r2 = r1.getGiftMarketingInfo();
        if (r2 == null) goto L16;
        int r3 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.a;
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.d(r2);
    L16:
        return false;
    L5:
        int r4 = this.m.b.getValue();
        r0 = this.h.contains(Integer.valueOf(r4));
        goto L7
    }

    public final void onStart() {
        this.l.getClass();
        f1 r0 = this.l;
        this.e = r0.h;
        this.h = r0.i;
        r0.getClass();
        this.f.clear();
        this.f.putAll(this.l.d);
        this.l.getClass();
        this.l.getClass();
        this.l.getClass();
        this.l.getClass();
        this.l.getClass();
        f1 r1 = this.l;
        this.g = r1.f;
        r1.getClass();
    }

    public final boolean n(long r2) {
        return this.e.contains(Long.valueOf(r2));
    }

    public GiftListSortDataStore(f1 r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r3, GiftExtraRepo r4, GiftStickerSortService r5) {
        Intrinsics.checkNotNullParameter(r2, "listSortService");
        Intrinsics.checkNotNullParameter(r3, "receiverService");
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r5, "giftStickerSortService");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.e = SetsKt.emptySet();
        this.f = new LongSparseArray();
        this.g = BuildConfig.FLAVOR;
        this.h = CollectionsKt.emptyList();
        this.j = new LinkedHashMap();
        this.k = LazyKt.lazy(GiftListSortDataStore$recommendInsertScene$2.INSTANCE);
        new LinkedHashMap();
    }
}
