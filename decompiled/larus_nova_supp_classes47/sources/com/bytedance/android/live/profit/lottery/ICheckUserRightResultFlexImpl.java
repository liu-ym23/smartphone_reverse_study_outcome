package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.lottery.CheckUserRightResult.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u00106R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+¨\u00067"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ICheckUserRightResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/e;", "Lcom/bytedance/android/live/profit/lottery/q;", "userCondition", "Lcom/bytedance/android/live/profit/lottery/q;", "getUserCondition", "()Lcom/bytedance/android/live/profit/lottery/q;", "setUserCondition", "(Lcom/bytedance/android/live/profit/lottery/q;)V", "Lcom/bytedance/android/live/profit/lottery/k;", "lotteryInfo", "Lcom/bytedance/android/live/profit/lottery/k;", "getLotteryInfo", "()Lcom/bytedance/android/live/profit/lottery/k;", "setLotteryInfo", "(Lcom/bytedance/android/live/profit/lottery/k;)V", "", "Lcom/bytedance/android/live/profit/lottery/d;", "candidateUsers", "Ljava/util/List;", "getCandidateUsers", "()Ljava/util/List;", "setCandidateUsers", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/profit/lottery/m;", "userLuckyInfo", "Lcom/bytedance/android/live/profit/lottery/m;", "getUserLuckyInfo", "()Lcom/bytedance/android/live/profit/lottery/m;", "setUserLuckyInfo", "(Lcom/bytedance/android/live/profit/lottery/m;)V", "Lcom/bytedance/android/live/profit/lottery/j;", "giftGuide", "Lcom/bytedance/android/live/profit/lottery/j;", "getGiftGuide", "()Lcom/bytedance/android/live/profit/lottery/j;", "setGiftGuide", "(Lcom/bytedance/android/live/profit/lottery/j;)V", "", "hitBlackList$delegate", "Ljava/lang/Object;", "getHitBlackList", "()Z", "hitBlackList", "", "candidateUserNum$delegate", "getCandidateUserNum", "()J", "candidateUserNum", "hasWishGift$delegate", "getHasWishGift", "hasWishGift", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ICheckUserRightResultFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("candidate_user_num")
    protected long _$$candidateUserNum;

    @SerializedName("has_wish_gift")
    protected boolean _$$hasWishGift;

    @SerializedName("hit_black_list")
    protected boolean _$$hitBlackList;

    @SerializedName("candidate_users")
    protected List<? extends d> candidateUsers;

    @SerializedName("gift_guide")
    protected j giftGuide;

    @SerializedName("lottery_info")
    protected k lotteryInfo;

    @SerializedName("user_condition")
    protected q userCondition;

    @SerializedName("user_lucky_info")
    protected m userLuckyInfo;

    public ICheckUserRightResultFlexImpl() {
        super(e.class);
        this.candidateUsers = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
        this._$$hitBlackList = false;
        this.giftGuide = (j) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(j.class);
        this._$$hasWishGift = false;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public final long getCandidateUserNum() {
        return this._$$candidateUserNum;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public List<d> getCandidateUsers() {
        return this.candidateUsers;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public j getGiftGuide() {
        return this.giftGuide;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public final boolean getHasWishGift() {
        return this._$$hasWishGift;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public final boolean getHitBlackList() {
        return this._$$hitBlackList;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public k getLotteryInfo() {
        return this.lotteryInfo;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public q getUserCondition() {
        return this.userCondition;
    }

    @Override // com.bytedance.android.live.profit.lottery.e
    public m getUserLuckyInfo() {
        return this.userLuckyInfo;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedance.android.live.profit.lottery.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.live.profit.lottery.q, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.profit.lottery.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.bytedance.android.live.profit.lottery.m, java.lang.Object] */
    public ICheckUserRightResultFlexImpl(am3.g r7) {
        super(e.class);
        this.candidateUsers = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L16;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$hitBlackList = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L9:
        this._$$hasWishGift = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L10:
        this.giftGuide = vh7.f.a(r7, j.class);
        goto L3
    L11:
        this.userLuckyInfo = vh7.f.a(r7, m.class);
        goto L3
    L12:
        this._$$candidateUserNum = r7.j();
        r3 = r3 | 2;
        goto L3
    L13:
        this.candidateUsers.add(vh7.f.a(r7, d.class));
        goto L3
    L14:
        this.lotteryInfo = vh7.f.a(r7, k.class);
        goto L3
    L15:
        this.userCondition = vh7.f.a(r7, q.class);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L16:
        r7.d(r1);
        setThreadSafe(true);
        if (this.candidateUsers.isEmpty() == false) goto L20;
        this.candidateUsers = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    L20:
        if ((r3 & 1) != 0) goto L23;
        this._$$hitBlackList = false;
    L23:
        if (this.giftGuide != null) goto L26;
        this.giftGuide = (j) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(j.class);
    L26:
        if ((r3 & 4) != 0) goto L49;
        this._$$hasWishGift = false;
        return;
    }

    public void setCandidateUsers(List<? extends d> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.candidateUsers = r2;
    }

    public void setGiftGuide(j r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftGuide = r2;
    }

    public void setLotteryInfo(k r1) {
        this.lotteryInfo = r1;
    }

    public void setUserCondition(q r1) {
        this.userCondition = r1;
    }

    public void setUserLuckyInfo(m r1) {
        this.userLuckyInfo = r1;
    }
}
