package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u001aR&\u0010'\u001a\u00060 j\u0002`!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u0006\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/p;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/q;", "getButton", "()Lcom/bytedance/android/livesdk/gift/model/q;", "getButton$annotations", "()V", "button", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getDefaultGiftDescribeImg", "()Lpy/k;", "getDefaultGiftDescribeImg$annotations", "defaultGiftDescribeImg", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getCards", "()Ljava/util/List;", "getCards$annotations", "cards", "getForceIndexCards", "getForceIndexCards$annotations", "forceIndexCards", BuildConfig.FLAVOR, "getMaxTotalCardNumber", "()I", "getMaxTotalCardNumber$annotations", "maxTotalCardNumber", "getMaxLocalCardNumber", "getMaxLocalCardNumber$annotations", "maxLocalCardNumber", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getConfigId", "()J", "setConfigId", "(J)V", "getConfigId$annotations", "configId", BuildConfig.FLAVOR, "getGiftShowName", "()Ljava/lang/String;", "getGiftShowName$annotations", "giftShowName", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.c<p> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "button")
    q getButton();

    @FieldName(name = "cards")
    List<n> getCards();

    @FieldName(name = "config_id")
    long getConfigId();

    @FieldName(name = "default_gift_describe_img")
    py.k getDefaultGiftDescribeImg();

    @FieldName(name = "force_index_cards")
    List<n> getForceIndexCards();

    @FieldName(name = "gift_show_name")
    String getGiftShowName();

    @FieldName(name = "max_local_card_number")
    int getMaxLocalCardNumber();

    @FieldName(name = "max_total_card_number")
    int getMaxTotalCardNumber();

    @FieldName(name = "config_id#setter")
    void setConfigId(long r1);
}
