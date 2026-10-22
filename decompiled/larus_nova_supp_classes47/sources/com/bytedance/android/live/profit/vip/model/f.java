package com.bytedance.android.live.profit.vip.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/f;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getScriptList", "()Ljava/util/List;", "setScriptList", "(Ljava/util/List;)V", "getScriptList$annotations", "()V", "scriptList", "Lcom/bytedance/android/live/profit/vip/model/e;", "getBubbleList", "setBubbleList", "getBubbleList$annotations", "bubbleList", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bubbles")
    List<e> getBubbleList();

    @FieldName(name = "recommend_script")
    List<String> getScriptList();

    @FieldName(name = "bubbles#setter")
    void setBubbleList(List<? extends e> r1);

    @FieldName(name = "recommend_script#setter")
    void setScriptList(List<String> r1);
}
