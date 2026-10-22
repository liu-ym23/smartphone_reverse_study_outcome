package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.LotteryLuckyUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b7\u00108R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001f\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0012R\u001b\u0010\"\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001b\u0010%\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0012R\u001b\u0010(\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0012R\u001b\u0010+\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001b\u0010.\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0012R\u001b\u00101\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0007R\u001b\u00106\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ILotteryLuckyUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/m;", "", "luckyId$delegate", "Ljava/lang/Object;", "getLuckyId", "()J", "luckyId", "lotteryId$delegate", "getLotteryId", "lotteryId", "roomId$delegate", "getRoomId", "roomId", "", "userName$delegate", "getUserName", "()Ljava/lang/String;", "userName", "avatarUrl$delegate", "getAvatarUrl", "avatarUrl", "grantCount$delegate", "getGrantCount", "grantCount", "userExtraInfo$delegate", "getUserExtraInfo", "userExtraInfo", "orderInfo$delegate", "getOrderInfo", "orderInfo", "userId$delegate", "getUserId", "userId", "userOpenId$delegate", "getUserOpenId", "userOpenId", "secUserId$delegate", "getSecUserId", "secUserId", "prizeType$delegate", "getPrizeType", "prizeType", "prizeName$delegate", "getPrizeName", "prizeName", "expireTime$delegate", "getExpireTime", "expireTime", "", "useNewAward$delegate", "getUseNewAward", "()Z", "useNewAward", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILotteryLuckyUserFlexImpl extends FlexModelBase<m> implements m, vh7.h {

    @SerializedName("avatar_url")
    protected String _$$avatarUrl;

    @SerializedName("expire_time")
    protected long _$$expireTime;

    @SerializedName("grant_count")
    protected long _$$grantCount;

    @SerializedName("lottery_id")
    protected long _$$lotteryId;

    @SerializedName("lucky_id")
    protected long _$$luckyId;

    @SerializedName("order_info")
    protected String _$$orderInfo;

    @SerializedName("prize_name")
    protected String _$$prizeName;

    @SerializedName("prize_type")
    protected long _$$prizeType;

    @SerializedName("room_id")
    protected long _$$roomId;

    @SerializedName("sec_user_id")
    protected String _$$secUserId;

    @SerializedName("use_new_award")
    protected boolean _$$useNewAward;

    @SerializedName("user_extra_info")
    protected String _$$userExtraInfo;

    @SerializedName("user_id")
    protected long _$$userId;

    @SerializedName("user_name")
    protected String _$$userName;

    @SerializedName("user_open_id")
    protected String _$$userOpenId;

    public ILotteryLuckyUserFlexImpl() {
        super(m.class);
        this._$$userName = "";
        this._$$avatarUrl = "";
        this._$$userExtraInfo = "";
        this._$$orderInfo = "";
        this._$$userOpenId = "";
        this._$$secUserId = "";
        this._$$prizeName = "";
        this._$$useNewAward = false;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getAvatarUrl() {
        return this._$$avatarUrl;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getExpireTime() {
        return this._$$expireTime;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getGrantCount() {
        return this._$$grantCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getLotteryId() {
        return this._$$lotteryId;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getLuckyId() {
        return this._$$luckyId;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getOrderInfo() {
        return this._$$orderInfo;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getPrizeName() {
        return this._$$prizeName;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getPrizeType() {
        return this._$$prizeType;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getSecUserId() {
        return this._$$secUserId;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final boolean getUseNewAward() {
        return this._$$useNewAward;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getUserExtraInfo() {
        return this._$$userExtraInfo;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final long getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getUserName() {
        return this._$$userName;
    }

    @Override // com.bytedance.android.live.profit.lottery.m
    public final String getUserOpenId() {
        return this._$$userOpenId;
    }

    public ILotteryLuckyUserFlexImpl(am3.g r8) {
        super(m.class);
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L26;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 15) goto L8;
        this._$$useNewAward = am3.h.a(r8);
        r3 = r3 | 128;
        goto L3
    L8:
        if (r4 != 5000) goto L9;
        this._$$userOpenId = am3.h.c(r8);
        goto L3
    L9:
        switch(r4) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            default: goto L10;
        };
    L11:
        this._$$expireTime = r8.j();
        r3 = r3 | 64;
        goto L3
    L12:
        this._$$prizeName = am3.h.c(r8);
        goto L3
    L13:
        this._$$prizeType = r8.j();
        r3 = r3 | 32;
        goto L3
    L14:
        this._$$secUserId = am3.h.c(r8);
        goto L3
    L15:
        this._$$orderInfo = am3.h.c(r8);
        goto L3
    L16:
        this._$$userExtraInfo = am3.h.c(r8);
        goto L3
    L17:
        this._$$grantCount = r8.j();
        r3 = r3 | 8;
        goto L3
    L18:
        this._$$avatarUrl = am3.h.c(r8);
        goto L3
    L19:
        this._$$userName = am3.h.c(r8);
        goto L3
    L20:
        this._$$userId = r8.j();
        r3 = r3 | 16;
        goto L3
    L21:
        this._$$roomId = r8.j();
        r3 = r3 | 4;
        goto L3
    L22:
        this._$$lotteryId = r8.j();
        r3 = r3 | 2;
        goto L3
    L23:
        this._$$luckyId = r8.j();
        r3 = r3 | 1;
        goto L3
    L10:
        am3.h.d(r5, r8);
        goto L3
    L26:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$userName != null) goto L30;
        this._$$userName = "";
    L30:
        if (this._$$avatarUrl != null) goto L33;
        this._$$avatarUrl = "";
    L33:
        if (this._$$userExtraInfo != null) goto L36;
        this._$$userExtraInfo = "";
    L36:
        if (this._$$orderInfo != null) goto L39;
        this._$$orderInfo = "";
    L39:
        if (this._$$userOpenId != null) goto L42;
        this._$$userOpenId = "";
    L42:
        if (this._$$secUserId != null) goto L45;
        this._$$secUserId = "";
    L45:
        if (this._$$prizeName != null) goto L48;
        this._$$prizeName = "";
    L48:
        if ((r3 & 128) != 0) goto L87;
        this._$$useNewAward = false;
        return;
    }
}
