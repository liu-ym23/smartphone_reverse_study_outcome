package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001RF\u0010\f\u001a.\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0002j\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006`\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/s;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPlayValueIcon", "()Ljava/util/Map;", "getPlayValueIcon$annotations", "()V", "playValueIcon", "getLinkmicEffect", "()Lpy/k;", "getLinkmicEffect$annotations", "linkmicEffect", "", "getBeautyEffectId", "()Ljava/lang/String;", "getBeautyEffectId$annotations", "beautyEffectId", "getStaticLinkmicImg", "getStaticLinkmicImg$annotations", "staticLinkmicImg", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s extends vh7.c<s> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "beauty_effect_id")
    String getBeautyEffectId();

    @FieldName(name = "linkmic_effect")
    py.k getLinkmicEffect();

    @FieldName(name = "play_value_icon")
    Map<Long, py.k> getPlayValueIcon();

    @FieldName(name = "static_linkmic_img")
    py.k getStaticLinkmicImg();
}
