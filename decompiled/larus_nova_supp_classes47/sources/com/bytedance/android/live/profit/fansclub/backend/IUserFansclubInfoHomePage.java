package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePage;", "Lvh7/c;", "", "getIntimacy", "()Ljava/lang/Long;", "getIntimacy$annotations", "()V", "intimacy", "getLevel", "getLevel$annotations", "level", "getNextLevelIntimacy", "getNextLevelIntimacy$annotations", "nextLevelIntimacy", "getLevelAfterLightUp", "getLevelAfterLightUp$annotations", "levelAfterLightUp", "", "getStatus", "()Ljava/lang/Integer;", "getStatus$annotations", "status", "getTemporaryIntimacy", "getTemporaryIntimacy$annotations", "temporaryIntimacy", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadge;", "getBadge", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubBadge;", "getBadge$annotations", "badge", "getAutoLightDownTime", "getAutoLightDownTime$annotations", "autoLightDownTime", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserFansclubInfoHomePage extends c<IUserFansclubInfoHomePage> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "auto_light_down_time")
    Long getAutoLightDownTime();

    @FieldName(name = "badge")
    IFansclubBadge getBadge();

    @FieldName(name = "intimacy")
    Long getIntimacy();

    @FieldName(name = "level")
    Long getLevel();

    @FieldName(name = "level_after_light_up")
    Long getLevelAfterLightUp();

    @FieldName(name = "next_level_intimacy")
    Long getNextLevelIntimacy();

    @FieldName(name = "status")
    Integer getStatus();

    @FieldName(name = "temporary_intimacy")
    Long getTemporaryIntimacy();
}
