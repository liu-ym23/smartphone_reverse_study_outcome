package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/f;", "Lvh7/e;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIconImage", "()Lpy/k;", "getIconImage$annotations", "()V", "iconImage", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface f extends vh7.e<e>, e {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "coupon_id")
    /* synthetic */ String getCouponId();

    @FieldName(name = "describe")
    /* synthetic */ String getDescribe();

    @FieldName(name = "diamond_count_rate")
    /* synthetic */ float getDiamondCountRate();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "icon_image")
    py.k getIconImage();

    @FieldName(name = "id")
    /* synthetic */ long getId();

    @FieldName(name = "price_max")
    /* synthetic */ int getMaxPrice();

    @FieldName(name = "price_min")
    /* synthetic */ int getMinPrice();

    @FieldName(name = "giving_count")
    /* synthetic */ int getRewardDiamondCount();
}
