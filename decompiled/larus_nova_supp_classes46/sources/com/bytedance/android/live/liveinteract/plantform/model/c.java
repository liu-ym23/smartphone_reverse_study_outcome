package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/c;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getCityEffect", "()Lpy/k;", "setCityEffect", "(Lpy/k;)V", "getCityEffect$annotations", "()V", "cityEffect", "", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCity$annotations", "city", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getShowEffectUserIdList", "()Ljava/util/List;", "setShowEffectUserIdList", "(Ljava/util/List;)V", "getShowEffectUserIdList$annotations", "showEffectUserIdList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "city")
    String getCity();

    @FieldName(name = "effect_resource")
    py.k getCityEffect();

    @FieldName(name = "show_effect_user_id_list")
    List<Long> getShowEffectUserIdList();

    @FieldName(name = "city#setter")
    void setCity(String r1);

    @FieldName(name = "effect_resource#setter")
    void setCityEffect(py.k r1);

    @FieldName(name = "show_effect_user_id_list#setter")
    void setShowEffectUserIdList(List<Long> r1);
}
