package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/o;", "Lvh7/e;", "Lcom/bytedance/android/live/profit/dress/config/k;", "", "getSponsorBgColor", "()Ljava/lang/String;", "getSponsorBgColor$annotations", "()V", "sponsorBgColor", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface o extends vh7.e<k>, k {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "beauty_effect_ID")
    /* synthetic */ String getBeautyEffectId();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "honor_icon")
    /* synthetic */ py.k getHonorIcon();

    @FieldName(name = "linkmic_dynamic_effect")
    /* synthetic */ String getLinkmicDynamicEffect();

    @FieldName(name = "linkmic_static_effect")
    /* synthetic */ String getLinkmicStaticEffect();

    @FieldName(name = "name")
    /* synthetic */ String getName();

    @FieldName(name = "play_type")
    /* synthetic */ List<Integer> getPlayType();

    @FieldName(name = "play_value_icon")
    /* synthetic */ String getPlayValueIcon();

    @FieldName(name = "show_fly_mic_effect")
    /* synthetic */ boolean getShowFlymicEffect();

    @FieldName(name = "sponsor_bg_color")
    String getSponsorBgColor();

    @FieldName(name = "star_wish_config")
    /* synthetic */ l getStarWishConfig();

    @FieldName(name = "value_BG_color")
    /* synthetic */ String getValueBgColor();

    @FieldName(name = "value_number_color")
    /* synthetic */ String getValueNumberColor();
}
