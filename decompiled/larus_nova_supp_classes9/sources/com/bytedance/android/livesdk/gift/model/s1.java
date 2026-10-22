package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/s1;", "Lvh7/c;", BuildConfig.FLAVOR, "getGiftId", "()J", "setGiftId", "(J)V", "getGiftId$annotations", "()V", "giftId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "getGiftIcon$annotations", "giftIcon", "getDiamondCount", "setDiamondCount", "getDiamondCount$annotations", "diamondCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s1 extends vh7.c<s1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "diamond_count")
    long getDiamondCount();

    @FieldName(name = "gift_icon")
    py.k getGiftIcon();

    @FieldName(name = "gift_id")
    long getGiftId();

    @FieldName(name = "diamond_count#setter")
    void setDiamondCount(long r1);

    @FieldName(name = "gift_icon#setter")
    void setGiftIcon(py.k r1);

    @FieldName(name = "gift_id#setter")
    void setGiftId(long r1);
}
