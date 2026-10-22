package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010 \u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010\"\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0014\u0010&\u001a\u00020#8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020#8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/IMainLotteryConditionExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/profit/lottery/h;", "Lcom/bytedance/android/live/profit/lottery/r;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getRemarks", "()Ljava/lang/String;", "remarks", "getBizInfo", "bizInfo", "", "getConditionId", "()J", "conditionId", "getContent", "content", "getDescription", "description", "getGiftCount", "giftCount", "getGiftId", "giftId", "getGiftName", "giftName", "getMinFansLevel", "minFansLevel", "getNeedDiamondCount", "needDiamondCount", "", "getStatus", "()I", "status", "getType", "base", "<init>", "(Lcom/bytedance/android/live/profit/lottery/h;)V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainLotteryConditionExtensionImpl extends ModelExtensionBase<h, r> implements r, h {
    private final /* synthetic */ h $$delegate_0;

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public <R extends vh7.e<h>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public <R extends vh7.e<h>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public long getConditionId() {
        return this.$$delegate_0.getConditionId();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public String getContent() {
        return this.$$delegate_0.getContent();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public String getDescription() {
        return this.$$delegate_0.getDescription();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public long getGiftCount() {
        return this.$$delegate_0.getGiftCount();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public long getGiftId() {
        return this.$$delegate_0.getGiftId();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public String getGiftName() {
        return this.$$delegate_0.getGiftName();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public long getMinFansLevel() {
        return this.$$delegate_0.getMinFansLevel();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public long getNeedDiamondCount() {
        return this.$$delegate_0.getNeedDiamondCount();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public int getStatus() {
        return this.$$delegate_0.getStatus();
    }

    @Override // com.bytedance.android.live.profit.lottery.r, com.bytedance.android.live.profit.lottery.h
    public int getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.bytedance.android.live.profit.lottery.r
    public String getBizInfo() {
        return (String) get(31, r.class, "");
    }

    @Override // com.bytedance.android.live.profit.lottery.r
    public String getRemarks() {
        return (String) get(30, r.class, "");
    }

    public IMainLotteryConditionExtensionImpl(h r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
