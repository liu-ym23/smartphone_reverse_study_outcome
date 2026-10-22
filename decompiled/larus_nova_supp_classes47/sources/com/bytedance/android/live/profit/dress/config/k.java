package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004R\u001e\u0010$\u001a\u00060\u001fj\u0002` 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R*\u0010+\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b(\u0010)R\u001c\u00100\u001a\u0004\u0018\u00010,8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/k;", "Lvh7/c;", "", "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "getPlayValueIcon", "getPlayValueIcon$annotations", "playValueIcon", "getLinkmicDynamicEffect", "getLinkmicDynamicEffect$annotations", "linkmicDynamicEffect", "getBeautyEffectId", "getBeautyEffectId$annotations", "beautyEffectId", "getLinkmicStaticEffect", "getLinkmicStaticEffect$annotations", "linkmicStaticEffect", "", "getShowFlymicEffect", "()Z", "getShowFlymicEffect$annotations", "showFlymicEffect", "getValueBgColor", "getValueBgColor$annotations", "valueBgColor", "getValueNumberColor", "getValueNumberColor$annotations", "valueNumberColor", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getHonorIcon", "()Lpy/k;", "getHonorIcon$annotations", "honorIcon", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayType", "()Ljava/util/List;", "getPlayType$annotations", "playType", "Lcom/bytedance/android/live/profit/dress/config/l;", "getStarWishConfig", "()Lcom/bytedance/android/live/profit/dress/config/l;", "getStarWishConfig$annotations", "starWishConfig", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "beauty_effect_ID")
    String getBeautyEffectId();

    @FieldName(name = "honor_icon")
    py.k getHonorIcon();

    @FieldName(name = "linkmic_dynamic_effect")
    String getLinkmicDynamicEffect();

    @FieldName(name = "linkmic_static_effect")
    String getLinkmicStaticEffect();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "play_type")
    List<Integer> getPlayType();

    @FieldName(name = "play_value_icon")
    String getPlayValueIcon();

    @FieldName(name = "show_fly_mic_effect")
    boolean getShowFlymicEffect();

    @FieldName(name = "star_wish_config")
    l getStarWishConfig();

    @FieldName(name = "value_BG_color")
    String getValueBgColor();

    @FieldName(name = "value_number_color")
    String getValueNumberColor();
}
