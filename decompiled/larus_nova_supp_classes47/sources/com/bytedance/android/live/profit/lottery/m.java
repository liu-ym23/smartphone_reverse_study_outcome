package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010!\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010$\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0010R\u001a\u0010'\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0010R\u001a\u0010*\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u0004R\u001a\u0010-\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010\u0010R\u001a\u00100\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b.\u0010\u0004R\u001a\u00105\u001a\u0002018&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0006\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/m;", "Lvh7/c;", "", "getLuckyId", "()J", "getLuckyId$annotations", "()V", "luckyId", "getLotteryId", "getLotteryId$annotations", "lotteryId", "getRoomId", "getRoomId$annotations", "roomId", "", "getUserName", "()Ljava/lang/String;", "getUserName$annotations", "userName", "getAvatarUrl", "getAvatarUrl$annotations", "avatarUrl", "getGrantCount", "getGrantCount$annotations", "grantCount", "getUserExtraInfo", "getUserExtraInfo$annotations", "userExtraInfo", "getOrderInfo", "getOrderInfo$annotations", "orderInfo", "getUserId", "getUserId$annotations", "userId", "getUserOpenId", "getUserOpenId$annotations", "userOpenId", "getSecUserId", "getSecUserId$annotations", "secUserId", "getPrizeType", "getPrizeType$annotations", "prizeType", "getPrizeName", "getPrizeName$annotations", "prizeName", "getExpireTime", "getExpireTime$annotations", "expireTime", "", "getUseNewAward", "()Z", "getUseNewAward$annotations", "useNewAward", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.c<m> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "avatar_url")
    String getAvatarUrl();

    @FieldName(name = "expire_time")
    long getExpireTime();

    @FieldName(name = "grant_count")
    long getGrantCount();

    @FieldName(name = "lottery_id")
    long getLotteryId();

    @FieldName(name = "lucky_id")
    long getLuckyId();

    @FieldName(name = "order_info")
    String getOrderInfo();

    @FieldName(name = "prize_name")
    String getPrizeName();

    @FieldName(name = "prize_type")
    long getPrizeType();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "sec_user_id")
    String getSecUserId();

    @FieldName(name = "use_new_award")
    boolean getUseNewAward();

    @FieldName(name = "user_extra_info")
    String getUserExtraInfo();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "user_name")
    String getUserName();

    @FieldName(name = "user_open_id")
    String getUserOpenId();
}
