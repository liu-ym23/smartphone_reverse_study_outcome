package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.android.livesdk.config.r;
import com.bytedance.android.livesdkapi.model.ProductShelfExperimentConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends d {
    public static final b b = null;
    public final ProductShelfExperimentConfig a;

    public static final class a {
    }

    static {
        b = new b();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean a() {
        return this.a.getProductCourseNumShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean b() {
        return this.a.getProductGiveawayShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean c() {
        return this.a.getProductImgShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean d() {
        return this.a.getProductListShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean e() {
        return this.a.getProductPriceShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean f() {
        return this.a.getProductTitleShow();
    }

    @Override // com.bytedance.android.live.openplatform.api.utils.d
    public final boolean g() {
        return this.a.getProductValidityShow();
    }

    public b() {
        this.a = (ProductShelfExperimentConfig) r.a.getValue();
    }
}
