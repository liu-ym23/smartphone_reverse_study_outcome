package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/c;", "Lvh7/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/s;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getEffectMixImageInfoList", "()Ljava/util/List;", "setEffectMixImageInfoList", "(Ljava/util/List;)V", "getEffectMixImageInfoList$annotations", "()V", "effectMixImageInfoList", "Lcom/bytedance/android/livesdk/gift/model/t;", "getEffectMixTextInfoList", "setEffectMixTextInfoList", "getEffectMixTextInfoList$annotations", "effectMixTextInfoList", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "effect_mix_image_infos")
    List<s> getEffectMixImageInfoList();

    @FieldName(name = "effect_mix_text_infos")
    List<t> getEffectMixTextInfoList();

    @FieldName(name = "effect_mix_image_infos#setter")
    void setEffectMixImageInfoList(List<? extends s> r1);

    @FieldName(name = "effect_mix_text_infos#setter")
    void setEffectMixTextInfoList(List<? extends t> r1);
}
