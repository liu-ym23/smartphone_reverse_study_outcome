package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R6\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/f2;", "Lvh7/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getDomainList", "()Ljava/util/List;", "getDomainList$annotations", "()V", "domainList", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getDefaultParams", "()Ljava/util/Map;", "getDefaultParams$annotations", "defaultParams", "getSupportCustomParams", "getSupportCustomParams$annotations", "supportCustomParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f2 extends vh7.c<f2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "default_params")
    Map<String, String> getDefaultParams();

    @FieldName(name = "domain_list")
    List<String> getDomainList();

    @FieldName(name = "support_custom_params")
    List<String> getSupportCustomParams();
}
