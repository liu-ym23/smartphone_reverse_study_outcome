package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.live.effect.api.k.c {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.live.effect.api.j c;
    public final /* synthetic */ WeakReference d;

    @Override // com.bytedance.android.live.effect.api.k.c
    public final void onFetchFailed() {
        ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on getCatetoryInfo fail");
        WeakReference r0 = this.d;
        if (r0 == null) goto L8;
        b r1 = (b) r0.get();
        if (r1 == null) goto L9;
        r1.onError();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.c
    public final void a(CategoryInfoModelList r4, EffectDataFetchCacheType r5) {
        Intrinsics.checkNotNullParameter(r4, "categoryInfoModelList");
        Intrinsics.checkNotNullParameter(r5, "cacheType");
        List<EffectCategoryModel> r6 = r4.getCategoryList();
        if (r6 == null) goto L9;
        this.a.a.put(this.b, r6);
        this.a.b(this.b, r6, this.c, null);
        WeakReference r7 = this.d;
        if (r7 == null) goto L9;
        b r8 = (b) r7.get();
        if (r8 == null) goto L9;
        r8.onSuccess(r6);
    L9:
        ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on getCatetoryInfo FetchSuccess");
    }

    public f(d r1, String r2, com.bytedance.android.live.effect.api.j r3, WeakReference r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
