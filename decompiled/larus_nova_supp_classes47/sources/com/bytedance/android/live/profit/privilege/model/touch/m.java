package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/m;", "Lvh7/c;", "", "getRefreshMechanism", "()I", "setRefreshMechanism", "(I)V", "getRefreshMechanism$annotations", "()V", "refreshMechanism", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getPollingInterval", "()Ljava/lang/Long;", "setPollingInterval", "(Ljava/lang/Long;)V", "getPollingInterval$annotations", "pollingInterval", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.c<m> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "polling_interval")
    Long getPollingInterval();

    @FieldName(name = "refresh_mechanism")
    int getRefreshMechanism();

    @FieldName(name = "polling_interval#setter")
    void setPollingInterval(Long r1);

    @FieldName(name = "refresh_mechanism#setter")
    void setRefreshMechanism(int r1);
}
