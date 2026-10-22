package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R*\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "Lvh7/c;", "", "getCurrentvalue", "()Ljava/lang/String;", "setCurrentvalue", "(Ljava/lang/String;)V", "getCurrentvalue$annotations", "()V", "currentvalue", "getTargetvalue", "setTargetvalue", "getTargetvalue$annotations", "targetvalue", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getProgressRate", "()Ljava/lang/Long;", "setProgressRate", "(Ljava/lang/Long;)V", "getProgressRate$annotations", "progressRate", "getColor", "setColor", "getColor$annotations", "color", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "color")
    String getColor();

    @FieldName(name = "current_value")
    String getCurrentvalue();

    @FieldName(name = "progress_rate")
    Long getProgressRate();

    @FieldName(name = "target_value")
    String getTargetvalue();

    @FieldName(name = "color#setter")
    void setColor(String r1);

    @FieldName(name = "current_value#setter")
    void setCurrentvalue(String r1);

    @FieldName(name = "progress_rate#setter")
    void setProgressRate(Long r1);

    @FieldName(name = "target_value#setter")
    void setTargetvalue(String r1);
}
