package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.w;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fullCacheCount", BuildConfig.FLAVOR, "getFullCacheCount", "()I", "fullCacheCount$delegate", "Lkotlin/Lazy;", "layoutViewTypeMap", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelPreloadView;", "panelViewCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getCachedViewCount", "viewInfo", "getViewByLayoutId", "layoutId", "getViewTypeByLayoutId", "isCacheFull", BuildConfig.FLAVOR, "onCleared", BuildConfig.FLAVOR, "putView", "view", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelPreloadViewModel extends ViewModel {
    private final Lazy fullCacheCount$delegate;
    private final Map<Integer, GiftPanelPreloadView> layoutViewTypeMap;
    private final ConcurrentHashMap<GiftPanelPreloadView, ArrayList<View>> panelViewCache;

    private final int getFullCacheCount() {
        return ((Number) this.fullCacheCount$delegate.getValue()).intValue();
    }

    public final boolean isCacheFull() {
        if (this.panelViewCache.size() != this.layoutViewTypeMap.size()) goto L12;
        ConcurrentHashMap<GiftPanelPreloadView, ArrayList<View>> r0 = this.panelViewCache;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<GiftPanelPreloadView, ArrayList<View>>> r2 = r0.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        r1.add(Integer.valueOf(r2.next().getValue().size()));
        goto L6
    L9:
        if (CollectionsKt.sumOfInt(r1) != getFullCacheCount()) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public GiftPanelPreloadViewModel() {
        this.panelViewCache = new ConcurrentHashMap();
        GiftPanelPreloadView.Companion.getClass();
        List r0 = (List) GiftPanelPreloadView.access$getAllViews$cp().getValue();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r3 = r1.next();
        r2.put(Integer.valueOf(((GiftPanelPreloadView) r3).getLayoutId()), r3);
        goto L4
    L6:
        this.layoutViewTypeMap = r2;
        this.fullCacheCount$delegate = LazyKt.lazy(GiftPanelPreloadViewModel$fullCacheCount$2.INSTANCE);
        c0.d.getClass();
        c0.c = (a) GiftPreloadSettingsKt.b.getValue(null, GiftPreloadSettingsKt.a[0]);
        x r4 = x.e;
        r4.getClass();
        x.d = (w) x.b.getValue(r4, x.a[0]);
        GiftPanelBizBoostUtils r5 = GiftPanelBizBoostUtils.E;
        r5.getClass();
        ReadOnlyProperty r6 = GiftPanelBizBoostUtils.c;
        KProperty[] r7 = GiftPanelBizBoostUtils.a;
        GiftPanelBizBoostUtils.y = ((Boolean) r6.getValue(r5, r7[1])).booleanValue();
        GiftPanelBizBoostUtils.A = (d0) GiftPanelBizBoostUtils.i.getValue(r5, r7[7]);
    }

    public void onCleared() {
        super.onCleared();
        this.panelViewCache.clear();
        ((RevenueImageUrlService) f.a(RevenueImageUrlService.class)).a.clear();
    }

    public final int getCachedViewCount(GiftPanelPreloadView r2) {
        Intrinsics.checkNotNullParameter(r2, "viewInfo");
        ArrayList<View> r3 = this.panelViewCache.get(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.size();
    }

    public final View getViewByLayoutId(int r4) {
        GiftPanelPreloadView r5 = this.layoutViewTypeMap.get(Integer.valueOf(r4));
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList<View> r6 = this.panelViewCache.get(r5);
        if (r6 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return null;
    L14:
        return (View) ListProtector.remove(r6, 0);
    L8:
        if (r6.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final GiftPanelPreloadView getViewTypeByLayoutId(int r2) {
        return this.layoutViewTypeMap.get(Integer.valueOf(r2));
    }

    public final void putView(GiftPanelPreloadView r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "viewInfo");
        Intrinsics.checkNotNullParameter(r6, "view");
        ArrayList<View> r0 = this.panelViewCache.get(r5);
        if (r0 != null) goto L5;
        this.panelViewCache.put(r5, CollectionsKt.arrayListOf(new View[]{r6}));
    L10:
        if (r5 != GiftPanelPreloadView.GridViewHolderItem) goto L17;
        ArrayList<View> r7 = this.panelViewCache.get(r5);
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.size() != r5.getCount()) goto L19;
        jy0.b.d("ttlive_gift_preload", "async inflate done for gridItem, cache cnt: " + r5.getCount());
        return;
    L19:
        return;
    L17:
        return;
    L5:
        if (r0.size() < r5.getCount()) goto L7;
        jy0.b.d("ttlive_gift_preload", r5 + " cache is full, count=" + r0.size());
        goto L10
    L7:
        r0.add(r6);
        goto L10
    }
}
