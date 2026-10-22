package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/j1;", "Lvh7/c;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/c1;", "getBaseGiftList", "()Ljava/util/List;", "setBaseGiftList", "(Ljava/util/List;)V", "getBaseGiftList$annotations", "()V", "baseGiftList", BuildConfig.FLAVOR, "getVersion", "()J", "setVersion", "(J)V", "getVersion$annotations", "version", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j1 extends vh7.c<j1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "gift_base_list")
    List<c1> getBaseGiftList();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "gift_base_list#setter")
    void setBaseGiftList(List<? extends c1> r1);

    @FieldName(name = "version#setter")
    void setVersion(long r1);
}
