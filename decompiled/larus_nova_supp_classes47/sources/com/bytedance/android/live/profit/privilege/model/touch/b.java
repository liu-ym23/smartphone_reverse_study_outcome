package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R6\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0017\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/b;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getShowAfterTimeMs", "()Ljava/lang/Long;", "setShowAfterTimeMs", "(Ljava/lang/Long;)V", "getShowAfterTimeMs$annotations", "()V", "showAfterTimeMs", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "getText$annotations", "text", "getDurationMs", "setDurationMs", "getDurationMs$annotations", "durationMs", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "duration_ms")
    Long getDurationMs();

    @FieldName(name = "show_after_time_ms")
    Long getShowAfterTimeMs();

    @FieldName(name = "text")
    List<n> getText();

    @FieldName(name = "duration_ms#setter")
    void setDurationMs(Long r1);

    @FieldName(name = "show_after_time_ms#setter")
    void setShowAfterTimeMs(Long r1);

    @FieldName(name = "text#setter")
    void setText(List<? extends n> r1);
}
