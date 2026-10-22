package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfo;", "Lvh7/c;", "", "getGuardStatus", "()I", "getGuardStatus$annotations", "()V", "guardStatus", "", "getActiveGuardDay", "()J", "getActiveGuardDay$annotations", "activeGuardDay", "getTotalGuardDay", "getTotalGuardDay$annotations", "totalGuardDay", "getExpireTime", "getExpireTime$annotations", "expireTime", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGuardInfo extends c<IGuardInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "active_guard_day")
    long getActiveGuardDay();

    @FieldName(name = "expire_time")
    long getExpireTime();

    @FieldName(name = "guard_status")
    int getGuardStatus();

    @FieldName(name = "total_guard_day")
    long getTotalGuardDay();
}
