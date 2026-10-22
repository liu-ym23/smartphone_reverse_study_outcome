package com.bytedance.android.live.recharge.platform.business.model.exchange;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.wallet.IncomeExchangeResult.MarketingData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\t\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/exchange/IExchangeResultRevenueInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/b;", "", "isFirstGiftTaskFinish$delegate", "Ljava/lang/Object;", "isFirstGiftTaskFinish", "()Z", "isDailyGiftTaskFinish$delegate", "isDailyGiftTaskFinish", "", "firstTaskReward$delegate", "getFirstTaskReward", "()J", "firstTaskReward", "dailyTaskReward$delegate", "getDailyTaskReward", "dailyTaskReward", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IExchangeResultRevenueInfoFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("daily_send_reward")
    protected long _$$dailyTaskReward;

    @SerializedName("first_send_reward")
    protected long _$$firstTaskReward;

    @SerializedName("is_daily_send_finish")
    protected boolean _$$isDailyGiftTaskFinish;

    @SerializedName("is_first_send_finish")
    protected boolean _$$isFirstGiftTaskFinish;

    public IExchangeResultRevenueInfoFlexImpl() {
        super(b.class);
        this._$$isFirstGiftTaskFinish = false;
        this._$$isDailyGiftTaskFinish = false;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.b
    public final long getDailyTaskReward() {
        return this._$$dailyTaskReward;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.b
    public final long getFirstTaskReward() {
        return this._$$firstTaskReward;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.b
    public final boolean isDailyGiftTaskFinish() {
        return this._$$isDailyGiftTaskFinish;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.b
    public final boolean isFirstGiftTaskFinish() {
        return this._$$isFirstGiftTaskFinish;
    }

    public IExchangeResultRevenueInfoFlexImpl(g r9) {
        super(b.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L17;
        g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$isFirstGiftTaskFinish = am3.h.a(r9);
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this._$$isDailyGiftTaskFinish = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$firstTaskReward = r9.j();
        r3 = r3 | 4;
        goto L3
    L11:
        if (r4 != 4) goto L12;
        this._$$dailyTaskReward = r9.j();
        r3 = r3 | 8;
        goto L3
    L12:
        am3.h.d(r5, r9);
        goto L3
    L17:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L21;
        this._$$isFirstGiftTaskFinish = false;
    L21:
        if ((r3 & 2) != 0) goto L39;
        this._$$isDailyGiftTaskFinish = false;
        return;
    }
}
