package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.LotteryUserCondition")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\u000f\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0012\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\u001d\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010 \u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010#\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007R\u001b\u0010%\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/bytedance/android/live/profit/lottery/ILotteryUserConditionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/q;", "", "isWatching$delegate", "Ljava/lang/Object;", "isWatching", "()Z", "hasCommand$delegate", "getHasCommand", "hasCommand", "hasFollow$delegate", "getHasFollow", "hasFollow", "isFansclubMember$delegate", "isFansclubMember", "hasGift$delegate", "getHasGift", "hasGift", "", "fansLevel$delegate", "getFansLevel", "()J", "fansLevel", "fansclubStatusActive$delegate", "getFansclubStatusActive", "fansclubStatusActive", "hasShared$delegate", "getHasShared", "hasShared", "hasHelpWish$delegate", "getHasHelpWish", "hasHelpWish", "hasActivated$delegate", "getHasActivated", "hasActivated", "isSubscribeMember$delegate", "isSubscribeMember", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILotteryUserConditionFlexImpl extends FlexModelBase<q> implements q, vh7.h {

    @SerializedName("fans_level")
    protected long _$$fansLevel;

    @SerializedName("fansclub_status_active")
    protected boolean _$$fansclubStatusActive;

    @SerializedName("has_activated")
    protected boolean _$$hasActivated;

    @SerializedName("has_command")
    protected boolean _$$hasCommand;

    @SerializedName("has_follow")
    protected boolean _$$hasFollow;

    @SerializedName("has_gift")
    protected boolean _$$hasGift;

    @SerializedName("has_help_wish")
    protected boolean _$$hasHelpWish;

    @SerializedName("has_shared")
    protected boolean _$$hasShared;

    @SerializedName("is_fansclub_member")
    protected boolean _$$isFansclubMember;

    @SerializedName("is_subscribe_member")
    protected boolean _$$isSubscribeMember;

    @SerializedName("is_watching")
    protected boolean _$$isWatching;

    public ILotteryUserConditionFlexImpl() {
        super(q.class);
        this._$$isWatching = false;
        this._$$hasCommand = false;
        this._$$hasFollow = false;
        this._$$isFansclubMember = false;
        this._$$hasGift = false;
        this._$$fansclubStatusActive = false;
        this._$$hasShared = false;
        this._$$hasHelpWish = false;
        this._$$hasActivated = false;
        this._$$isSubscribeMember = false;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final long getFansLevel() {
        return this._$$fansLevel;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getFansclubStatusActive() {
        return this._$$fansclubStatusActive;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasActivated() {
        return this._$$hasActivated;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasCommand() {
        return this._$$hasCommand;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasFollow() {
        return this._$$hasFollow;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasGift() {
        return this._$$hasGift;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasHelpWish() {
        return this._$$hasHelpWish;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean getHasShared() {
        return this._$$hasShared;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean isFansclubMember() {
        return this._$$isFansclubMember;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean isSubscribeMember() {
        return this._$$isSubscribeMember;
    }

    @Override // com.bytedance.android.live.profit.lottery.q
    public final boolean isWatching() {
        return this._$$isWatching;
    }

    public ILotteryUserConditionFlexImpl(am3.g r7) {
        super(q.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L19;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$isSubscribeMember = am3.h.a(r7);
        r3 = r3 | 1024;
        goto L3
    L9:
        this._$$hasActivated = am3.h.a(r7);
        r3 = r3 | 512;
        goto L3
    L10:
        this._$$hasHelpWish = am3.h.a(r7);
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L11:
        this._$$hasShared = am3.h.a(r7);
        r3 = r3 | 128;
        goto L3
    L12:
        this._$$fansclubStatusActive = am3.h.a(r7);
        r3 = r3 | 64;
        goto L3
    L13:
        this._$$fansLevel = r7.j();
        r3 = r3 | 32;
        goto L3
    L14:
        this._$$hasGift = am3.h.a(r7);
        r3 = r3 | 16;
        goto L3
    L15:
        this._$$isFansclubMember = am3.h.a(r7);
        r3 = r3 | 8;
        goto L3
    L16:
        this._$$hasFollow = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L17:
        this._$$hasCommand = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L18:
        this._$$isWatching = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L19:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L23;
        this._$$isWatching = false;
    L23:
        if ((r3 & 2) != 0) goto L26;
        this._$$hasCommand = false;
    L26:
        if ((r3 & 4) != 0) goto L29;
        this._$$hasFollow = false;
    L29:
        if ((r3 & 8) != 0) goto L32;
        this._$$isFansclubMember = false;
    L32:
        if ((r3 & 16) != 0) goto L35;
        this._$$hasGift = false;
    L35:
        if ((r3 & 64) != 0) goto L38;
        this._$$fansclubStatusActive = false;
    L38:
        if ((r3 & 128) != 0) goto L41;
        this._$$hasShared = false;
    L41:
        if ((r3 & DefaultConfig.MAX_CACHE_ENTRIES) != 0) goto L44;
        this._$$hasHelpWish = false;
    L44:
        if ((r3 & 512) != 0) goto L47;
        this._$$hasActivated = false;
    L47:
        if ((r3 & 1024) != 0) goto L76;
        this._$$isSubscribeMember = false;
        return;
    }
}
