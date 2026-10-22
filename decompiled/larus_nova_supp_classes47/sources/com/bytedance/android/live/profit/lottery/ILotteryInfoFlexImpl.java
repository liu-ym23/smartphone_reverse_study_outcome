package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.LotteryInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\br\u0010sR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010!\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R\u001b\u0010$\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R\u001b\u0010'\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007R\u001b\u0010,\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007R\u001b\u00102\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007R\u001b\u00105\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\u0007R\u001b\u00108\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u0010\u0007R\u001b\u0010;\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\u0007R\u001b\u0010>\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010\u0007R\u001b\u0010A\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010+R\u001b\u0010D\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0005\u001a\u0004\bC\u0010+R\u001b\u0010G\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0005\u001a\u0004\bF\u0010+R\u001b\u0010J\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0005\u001a\u0004\bI\u0010+R!\u0010P\u001a\b\u0012\u0004\u0012\u00020L0K8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0005\u001a\u0004\bR\u0010\u0007R\u001b\u0010V\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0005\u001a\u0004\bU\u0010\u0007R!\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0K8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0005\u001a\u0004\bY\u0010OR\u001b\u0010]\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0005\u001a\u0004\b\\\u0010+R\u001b\u0010`\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0005\u001a\u0004\b_\u0010+R\u001b\u0010e\u001a\u00020a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0005\u001a\u0004\bc\u0010dR\u001b\u0010h\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0005\u001a\u0004\bg\u0010+R\u001b\u0010k\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0005\u001a\u0004\bj\u0010\fR\u001d\u0010n\u001a\u0004\u0018\u00010(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\u0005\u001a\u0004\bm\u0010+R\u001d\u0010q\u001a\u0004\u0018\u00010(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0005\u001a\u0004\bp\u0010+¨\u0006t"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ILotteryInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/k;", "", "lotteryId$delegate", "Ljava/lang/Object;", "getLotteryId", "()J", "lotteryId", "", "ownerType$delegate", "getOwnerType", "()I", "ownerType", "roomId$delegate", "getRoomId", "roomId", "status$delegate", "getStatus", "status", "Lcom/bytedance/android/live/profit/lottery/ILotteryPrizeFlexImpl;", "prizeInfo$delegate", "getPrizeInfo", "()Lcom/bytedance/android/live/profit/lottery/ILotteryPrizeFlexImpl;", "prizeInfo", "prizeCount$delegate", "getPrizeCount", "prizeCount", "luckyCount$delegate", "getLuckyCount", "luckyCount", "countDown$delegate", "getCountDown", "countDown", "startTime$delegate", "getStartTime", "startTime", "drawTime$delegate", "getDrawTime", "drawTime", "", "extra$delegate", "getExtra", "()Ljava/lang/String;", "extra", "realLuckyCount$delegate", "getRealLuckyCount", "realLuckyCount", "totalGrantCount$delegate", "getTotalGrantCount", "totalGrantCount", "withdrawCount$delegate", "getWithdrawCount", "withdrawCount", "realDrawTime$delegate", "getRealDrawTime", "realDrawTime", "currentTime$delegate", "getCurrentTime", "currentTime", "candidateNum$delegate", "getCandidateNum", "candidateNum", "lotteryIdStr$delegate", "getLotteryIdStr", "lotteryIdStr", "roomIdStr$delegate", "getRoomIdStr", "roomIdStr", "ownerUserOpenId$delegate", "getOwnerUserOpenId", "ownerUserOpenId", "anchorOpenId$delegate", "getAnchorOpenId", "anchorOpenId", "", "Lcom/bytedance/android/live/profit/lottery/ILotteryConditionFlexImpl;", "conditions$delegate", "getConditions", "()Ljava/util/List;", "conditions", "ownerUserId$delegate", "getOwnerUserId", "ownerUserId", "anchorId$delegate", "getAnchorId", "anchorId", "Lcom/bytedance/android/live/profit/lottery/ILotteryLuckyUserFlexImpl;", "luckyUsers$delegate", "getLuckyUsers", "luckyUsers", "secAnchorId$delegate", "getSecAnchorId", "secAnchorId", "secOwnerUserId$delegate", "getSecOwnerUserId", "secOwnerUserId", "", "useNewDrawInteraction$delegate", "getUseNewDrawInteraction", "()Z", "useNewDrawInteraction", "launchTaskId$delegate", "getLaunchTaskId", "launchTaskId", "index$delegate", "getIndex", "index", "serverBizData$delegate", "getServerBizData", "serverBizData", "uiConfig$delegate", "getUiConfig", "uiConfig", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILotteryInfoFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("anchor_id")
    protected long _$$anchorId;

    @SerializedName("anchor_open_id")
    protected String _$$anchorOpenId;

    @SerializedName("candidate_num")
    protected long _$$candidateNum;

    @SerializedName("conditions")
    protected List<ILotteryConditionFlexImpl> _$$conditions;

    @SerializedName("count_down")
    protected long _$$countDown;

    @SerializedName("current_time")
    protected long _$$currentTime;

    @SerializedName("draw_time")
    protected long _$$drawTime;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("index")
    protected int _$$index;

    @SerializedName("launch_task_id")
    protected String _$$launchTaskId;

    @SerializedName("lottery_id")
    protected long _$$lotteryId;

    @SerializedName("lottery_id_str")
    protected String _$$lotteryIdStr;

    @SerializedName("lucky_count")
    protected long _$$luckyCount;

    @SerializedName("lucky_users")
    protected List<ILotteryLuckyUserFlexImpl> _$$luckyUsers;

    @SerializedName("owner_type")
    protected int _$$ownerType;

    @SerializedName("owner_user_id")
    protected long _$$ownerUserId;

    @SerializedName("owner_user_open_id")
    protected String _$$ownerUserOpenId;

    @SerializedName("prize_count")
    protected long _$$prizeCount;

    @SerializedName("prize_info")
    protected ILotteryPrizeFlexImpl _$$prizeInfo;

    @SerializedName("real_draw_time")
    protected long _$$realDrawTime;

    @SerializedName("real_lucky_count")
    protected long _$$realLuckyCount;

    @SerializedName("room_id")
    protected long _$$roomId;

    @SerializedName("room_id_str")
    protected String _$$roomIdStr;

    @SerializedName("sec_anchor_id")
    protected String _$$secAnchorId;

    @SerializedName("sec_owner_user_id")
    protected String _$$secOwnerUserId;

    @SerializedName("server_biz_data")
    protected String _$$serverBizData;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("status")
    protected int _$$status;

    @SerializedName("total_grant_count")
    protected long _$$totalGrantCount;

    @SerializedName("ui_config")
    protected String _$$uiConfig;

    @SerializedName("use_new_draw_interaction")
    protected boolean _$$useNewDrawInteraction;

    @SerializedName("withdraw_count")
    protected long _$$withdrawCount;

    public ILotteryInfoFlexImpl() {
        super(k.class);
        this._$$extra = "";
        this._$$lotteryIdStr = "";
        this._$$roomIdStr = "";
        this._$$ownerUserOpenId = "";
        this._$$anchorOpenId = "";
        this._$$conditions = $defaultValue_conditions$();
        this._$$luckyUsers = $defaultValue_luckyUsers$();
        this._$$secAnchorId = "";
        this._$$secOwnerUserId = "";
        this._$$useNewDrawInteraction = false;
        this._$$launchTaskId = "";
    }

    public final List<ILotteryConditionFlexImpl> $defaultValue_conditions$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<ILotteryLuckyUserFlexImpl> $defaultValue_luckyUsers$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public /* bridge */ /* synthetic */ p getPrizeInfo() {
        return getPrizeInfo();
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getAnchorOpenId() {
        return this._$$anchorOpenId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getCandidateNum() {
        return this._$$candidateNum;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final List<ILotteryConditionFlexImpl> getConditions() {
        return this._$$conditions;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getCountDown() {
        return this._$$countDown;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getCurrentTime() {
        return this._$$currentTime;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getDrawTime() {
        return this._$$drawTime;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final int getIndex() {
        return this._$$index;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getLaunchTaskId() {
        return this._$$launchTaskId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getLotteryId() {
        return this._$$lotteryId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getLotteryIdStr() {
        return this._$$lotteryIdStr;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getLuckyCount() {
        return this._$$luckyCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final List<ILotteryLuckyUserFlexImpl> getLuckyUsers() {
        return this._$$luckyUsers;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final int getOwnerType() {
        return this._$$ownerType;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getOwnerUserId() {
        return this._$$ownerUserId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getOwnerUserOpenId() {
        return this._$$ownerUserOpenId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getPrizeCount() {
        return this._$$prizeCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getRealDrawTime() {
        return this._$$realDrawTime;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getRealLuckyCount() {
        return this._$$realLuckyCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getRoomIdStr() {
        return this._$$roomIdStr;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getSecAnchorId() {
        return this._$$secAnchorId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getSecOwnerUserId() {
        return this._$$secOwnerUserId;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getServerBizData() {
        return this._$$serverBizData;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final int getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getTotalGrantCount() {
        return this._$$totalGrantCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final String getUiConfig() {
        return this._$$uiConfig;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final boolean getUseNewDrawInteraction() {
        return this._$$useNewDrawInteraction;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final long getWithdrawCount() {
        return this._$$withdrawCount;
    }

    @Override // com.bytedance.android.live.profit.lottery.k
    public final ILotteryPrizeFlexImpl getPrizeInfo() {
        return this._$$prizeInfo;
    }

    public ILotteryInfoFlexImpl(am3.g r9) {
        super(k.class);
        this._$$conditions = new ArrayList();
        this._$$luckyUsers = new ArrayList();
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L55;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 27) goto L8;
        this._$$useNewDrawInteraction = am3.h.a(r9);
        r3 = r3 | 131072;
        goto L3
    L8:
        if (r4 != 30) goto L10;
        this._$$launchTaskId = am3.h.c(r9);
        goto L3
    L10:
        if (r4 == 31) goto L52;
        if (r4 != 51) goto L14;
        this._$$serverBizData = am3.h.c(r9);
        goto L3
    L14:
        if (r4 != 52) goto L16;
        this._$$uiConfig = am3.h.c(r9);
        goto L3
    L16:
        if (r4 != 5000) goto L18;
        this._$$anchorOpenId = am3.h.c(r9);
        goto L3
    L18:
        if (r4 != 5001) goto L19;
        this._$$ownerUserOpenId = am3.h.c(r9);
        goto L3
    L19:
        switch(r4) {
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L29;
            case 18: goto L28;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            case 25: goto L21;
            default: goto L20;
        };
    L21:
        this._$$secOwnerUserId = am3.h.c(r9);
        goto L3
    L22:
        this._$$secAnchorId = am3.h.c(r9);
        goto L3
    L23:
        this._$$roomIdStr = am3.h.c(r9);
        goto L3
    L24:
        this._$$lotteryIdStr = am3.h.c(r9);
        goto L3
    L25:
        this._$$candidateNum = r9.j();
        r3 = r3 | 16384;
        goto L3
    L26:
        this._$$currentTime = r9.j();
        r3 = r3 | 8192;
        goto L3
    L27:
        List r6 = this._$$luckyUsers;
        vh7.h r7 = new ILotteryLuckyUserFlexImpl(r9);
    L39:
        r6.add(r7);
        goto L3
    L28:
        this._$$realDrawTime = r9.j();
        r3 = r3 | 4096;
        goto L3
    L29:
        this._$$withdrawCount = r9.j();
        r3 = r3 | 2048;
        goto L3
    L30:
        this._$$totalGrantCount = r9.j();
        r3 = r3 | 1024;
        goto L3
    L31:
        this._$$realLuckyCount = r9.j();
        r3 = r3 | 512;
        goto L3
    L32:
        this._$$extra = am3.h.c(r9);
        goto L3
    L33:
        this._$$drawTime = r9.j();
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L34:
        this._$$startTime = r9.j();
        r3 = r3 | 128;
        goto L3
    L35:
        this._$$countDown = r9.j();
        r3 = r3 | 64;
        goto L3
    L36:
        this._$$luckyCount = r9.j();
        r3 = r3 | 32;
        goto L3
    L37:
        this._$$prizeCount = r9.j();
        r3 = r3 | 16;
        goto L3
    L38:
        r6 = this._$$conditions;
        r7 = new ILotteryConditionFlexImpl(r9);
        goto L39
    L40:
        this._$$prizeInfo = new ILotteryPrizeFlexImpl(r9);
        goto L3
    L41:
        this._$$status = r9.i();
        r3 = r3 | 8;
        goto L3
    L42:
        this._$$roomId = r9.j();
        r3 = r3 | 4;
        goto L3
    L43:
        this._$$ownerType = r9.i();
        r3 = r3 | 2;
        goto L3
    L44:
        this._$$anchorId = r9.j();
        int r8 = 65536;
    L46:
        r3 = r3 | r8;
        goto L3
    L45:
        this._$$ownerUserId = r9.j();
        r8 = 32768;
        goto L46
    L47:
        this._$$lotteryId = r9.j();
        r3 = r3 | 1;
        goto L3
    L20:
        am3.h.d(r5, r9);
        goto L3
    L52:
        this._$$index = r9.i();
        r8 = 262144;
        goto L46
    L55:
        r9.d(r1);
        setThreadSafe(true);
        if (this._$$extra != null) goto L59;
        this._$$extra = "";
    L59:
        if (this._$$lotteryIdStr != null) goto L62;
        this._$$lotteryIdStr = "";
    L62:
        if (this._$$roomIdStr != null) goto L65;
        this._$$roomIdStr = "";
    L65:
        if (this._$$ownerUserOpenId != null) goto L68;
        this._$$ownerUserOpenId = "";
    L68:
        if (this._$$anchorOpenId != null) goto L71;
        this._$$anchorOpenId = "";
    L71:
        if (this._$$conditions.isEmpty() == false) goto L74;
        this._$$conditions = $defaultValue_conditions$();
    L74:
        if (this._$$luckyUsers.isEmpty() == false) goto L77;
        this._$$luckyUsers = $defaultValue_luckyUsers$();
    L77:
        if (this._$$secAnchorId != null) goto L80;
        this._$$secAnchorId = "";
    L80:
        if (this._$$secOwnerUserId != null) goto L83;
        this._$$secOwnerUserId = "";
    L83:
        if ((r3 & 131072) != 0) goto L86;
        this._$$useNewDrawInteraction = false;
    L86:
        if (this._$$launchTaskId != null) goto L160;
        this._$$launchTaskId = "";
        return;
    }
}
