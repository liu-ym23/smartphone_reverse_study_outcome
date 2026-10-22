package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IGetFansclubHomepageResult;", "Lvh7/c;", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePage;", "getClubInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePage;", "getClubInfo$annotations", "()V", "clubInfo", "Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePage;", "getUserInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IUserFansclubInfoHomePage;", "getUserInfo$annotations", "userInfo", "Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;", "getParticipateIncentive", "()Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubParticipateIncentive;", "getParticipateIncentive$annotations", "participateIncentive", "", "", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfo;", "getGuardInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IGuardInfo;", "getGuardInfo$annotations", "guardInfo", "", "isGroupLive", "()Ljava/lang/Boolean;", "isGroupLive$annotations", "Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfo;", "getGroupLiveInfo", "()Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfo;", "getGroupLiveInfo$annotations", "groupLiveInfo", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGetFansclubHomepageResult extends c<IGetFansclubHomepageResult> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "club_info")
    IFansclubInfoHomePage getClubInfo();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "group_live_info")
    IGroupLiveInfo getGroupLiveInfo();

    @FieldName(name = "guard_info")
    IGuardInfo getGuardInfo();

    @FieldName(name = "participate_incentive")
    IFansclubParticipateIncentive getParticipateIncentive();

    @FieldName(name = "user_info")
    IUserFansclubInfoHomePage getUserInfo();

    @FieldName(name = "is_group_live")
    Boolean isGroupLive();
}
