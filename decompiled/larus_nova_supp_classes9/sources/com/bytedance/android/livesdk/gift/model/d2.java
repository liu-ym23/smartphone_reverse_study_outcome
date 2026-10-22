package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/d2;", "Lvh7/c;", BuildConfig.FLAVOR, "getId", "()J", "getId$annotations", "()V", "id", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "getName$annotations", "name", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getNameImage", "()Lpy/k;", "getNameImage$annotations", "nameImage", "Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo$annotations", "pageInfo", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRelatedGiftIds", "()Ljava/util/List;", "getRelatedGiftIds$annotations", "relatedGiftIds", "getClickType", "()I", "getClickType$annotations", "clickType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d2 extends vh7.c<d2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "click_type")
    int getClickType();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "name_image")
    py.k getNameImage();

    @FieldName(name = "page_info")
    x2 getPageInfo();

    @FieldName(name = "related_gift_ids")
    List<Integer> getRelatedGiftIds();
}
