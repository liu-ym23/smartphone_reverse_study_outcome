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
@ProtoMessage("webcast.api.wallet.IncomeExchangeResult.IncomeExchangeData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/exchange/IIncomeExchangeDataDyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/d;", "", "rebateAmountProp$delegate", "Ljava/lang/Object;", "getRebateAmountProp", "()J", "rebateAmountProp", "", "orderId$delegate", "getOrderId", "()Ljava/lang/String;", "orderId", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IIncomeExchangeDataDyFlexImpl extends FlexModelBase<d> implements d, h {

    @SerializedName("order_id")
    protected String _$$orderId;

    @SerializedName("rebate_amount")
    protected long _$$rebateAmountProp;

    public IIncomeExchangeDataDyFlexImpl() {
        super(d.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.d, com.bytedance.android.live.recharge.platform.business.model.exchange.c
    public final String getOrderId() {
        return this._$$orderId;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.d
    public final long getRebateAmountProp() {
        return this._$$rebateAmountProp;
    }

    public IIncomeExchangeDataDyFlexImpl(g r6) {
        super(d.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$orderId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$rebateAmountProp = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }
}
