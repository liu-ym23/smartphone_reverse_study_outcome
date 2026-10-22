package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0017\u001a\u00060\u0012j\u0002`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/h;", "Lvh7/c;", "", "getEnablePreview", "()Z", "getEnablePreview$annotations", "()V", "enablePreview", "Lcom/bytedance/android/live/profit/dress/config/d;", "getButtonConfig", "()Lcom/bytedance/android/live/profit/dress/config/d;", "getButtonConfig$annotations", "buttonConfig", "", "getLogExtra", "()Ljava/lang/String;", "getLogExtra$annotations", "logExtra", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getProfilePreviewAssetId", "()J", "getProfilePreviewAssetId$annotations", "profilePreviewAssetId", "", "getProfileTextAlignTypeInt", "()I", "getProfileTextAlignTypeInt$annotations", "profileTextAlignTypeInt", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "right_button")
    d getButtonConfig();

    @FieldName(name = "enable_preview")
    boolean getEnablePreview();

    @FieldName(name = "extra")
    String getLogExtra();

    @FieldName(name = "asset_id")
    long getProfilePreviewAssetId();

    @FieldName(name = "text_alignment")
    int getProfileTextAlignTypeInt();
}
