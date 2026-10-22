package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.lottery.GetLotteryInfoResult.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/IGetLotteryInfoResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/lottery/f;", "Lcom/bytedance/android/live/profit/lottery/k;", "lotteryInfo", "Lcom/bytedance/android/live/profit/lottery/k;", "getLotteryInfo", "()Lcom/bytedance/android/live/profit/lottery/k;", "setLotteryInfo", "(Lcom/bytedance/android/live/profit/lottery/k;)V", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IGetLotteryInfoResultFlexImpl extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("lottery_info")
    protected k lotteryInfo;

    public IGetLotteryInfoResultFlexImpl() {
        super(f.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.profit.lottery.k, java.lang.Object] */
    public IGetLotteryInfoResultFlexImpl(am3.g r6) {
        super(f.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.lotteryInfo = vh7.f.a(r6, k.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.lottery.f
    public k getLotteryInfo() {
        return this.lotteryInfo;
    }

    public void setLotteryInfo(k r1) {
        this.lotteryInfo = r1;
    }
}
