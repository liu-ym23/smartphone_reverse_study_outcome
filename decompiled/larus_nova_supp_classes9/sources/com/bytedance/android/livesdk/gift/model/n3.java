package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/n3;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift$annotations", "()V", "gift", "Lcom/bytedance/android/livesdk/gift/model/o3;", "getSeriesTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/o3;", "getSeriesTrayInfo$annotations", "seriesTrayInfo", "Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo$annotations", "sendTogetherInfo", BuildConfig.FLAVOR, "getDiyItemInfo", "()Ljava/lang/String;", "getDiyItemInfo$annotations", "diyItemInfo", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift$annotations", "anchorGift", "Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo$annotations", "assetEffectMixInfo", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n3 extends vh7.c<n3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "anchor_gift")
    a1 getAnchorGift();

    @FieldName(name = "asset_effect_mix_info")
    c getAssetEffectMixInfo();

    @FieldName(name = "diy_item_info")
    String getDiyItemInfo();

    @FieldName(name = "gift_struct")
    h1 getGift();

    @FieldName(name = "send_together")
    j3 getSendTogetherInfo();

    @FieldName(name = "series_tray_info")
    o3 getSeriesTrayInfo();
}
