package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RJ\u0010\u001d\u001a*\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013j\u0014\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/j;", "Lvh7/c;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTouchPositions", "()Ljava/util/List;", "setTouchPositions", "(Ljava/util/List;)V", "getTouchPositions$annotations", "()V", "touchPositions", "", "getTouchPositionsStr", "()Ljava/lang/String;", "setTouchPositionsStr", "(Ljava/lang/String;)V", "getTouchPositionsStr$annotations", "touchPositionsStr", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/android/live/profit/privilege/model/touch/s;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTouchPositionMap", "()Ljava/util/Map;", "setTouchPositionMap", "(Ljava/util/Map;)V", "getTouchPositionMap$annotations", "touchPositionMap", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "touch_positions_map")
    Map<Long, s> getTouchPositionMap();

    @FieldName(name = "touch_positions")
    List<p> getTouchPositions();

    @FieldName(name = "touch_positions_str")
    String getTouchPositionsStr();

    @FieldName(name = "touch_positions_map#setter")
    void setTouchPositionMap(Map<Long, ? extends s> r1);

    @FieldName(name = "touch_positions#setter")
    void setTouchPositions(List<? extends p> r1);

    @FieldName(name = "touch_positions_str#setter")
    void setTouchPositionsStr(String r1);
}
