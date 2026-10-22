package com.bytedance.android.live.profit.fansclub.backend;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\rR\"\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IFansclubInfoHomePage;", "Lvh7/c;", "", "getClubName", "()Ljava/lang/String;", "getClubName$annotations", "()V", "clubName", "getAnchorName", "getAnchorName$annotations", "anchorName", "", "getActiveFansCount", "()Ljava/lang/Long;", "getActiveFansCount$annotations", "activeFansCount", "getTotalFansCount", "getTotalFansCount$annotations", "totalFansCount", "getPopularityRankHour", "getPopularityRankHour$annotations", "popularityRankHour", "getIncomeRatio", "getIncomeRatio$annotations", "incomeRatio", "getNumOfFansGroup", "getNumOfFansGroup$annotations", "numOfFansGroup", "getMaxLevel", "getMaxLevel$annotations", "maxLevel", "", "Lcom/bytedance/android/live/profit/fansclub/backend/IActivityCard;", "getActivityCards", "()Ljava/util/List;", "getActivityCards$annotations", "activityCards", "getHomepageSchema", "getHomepageSchema$annotations", "homepageSchema", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFansclubInfoHomePage extends c<IFansclubInfoHomePage> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "active_fans_count")
    Long getActiveFansCount();

    @FieldName(name = "activity_cards")
    List<IActivityCard> getActivityCards();

    @FieldName(name = "anchor_name")
    String getAnchorName();

    @FieldName(name = "club_name")
    String getClubName();

    @FieldName(name = "homepage_schema")
    String getHomepageSchema();

    @FieldName(name = "income_ratio")
    String getIncomeRatio();

    @FieldName(name = "max_level")
    Long getMaxLevel();

    @FieldName(name = "num_of_fans_group")
    Long getNumOfFansGroup();

    @FieldName(name = "popularity_rank_hour")
    Long getPopularityRankHour();

    @FieldName(name = "total_fans_count")
    Long getTotalFansCount();
}
