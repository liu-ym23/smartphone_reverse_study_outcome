package com.bytedance.android.live.recharge.platform.business.model.income;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.wallet.QueryFlameIncomeResult.QueryFlameIncomeBalance")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/income/IIncomeBalanceInfoHsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/income/c;", "", "flameTitle$delegate", "Ljava/lang/Object;", "getFlameTitle", "()Ljava/lang/String;", "flameTitle", "", "cashBalance$delegate", "getCashBalance", "()J", "cashBalance", "maxCash$delegate", "getMaxCash", "maxCash", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IIncomeBalanceInfoHsFlexImpl extends FlexModelBase<c> implements c, h {

    @SerializedName("cash_balance")
    protected long _$$cashBalance;

    @SerializedName("flame_title")
    protected String _$$flameTitle;

    @SerializedName("max_cash")
    protected long _$$maxCash;

    public IIncomeBalanceInfoHsFlexImpl() {
        super(c.class);
        this._$$cashBalance = $defaultValue_cashBalance$();
        this._$$maxCash = $defaultValue_maxCash$();
    }

    public final long $defaultValue_cashBalance$() {
        return -1;
    }

    public final long $defaultValue_maxCash$() {
        return -1;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.c
    public final long getCashBalance() {
        return this._$$cashBalance;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.c
    public final String getFlameTitle() {
        return this._$$flameTitle;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.c
    public final long getMaxCash() {
        return this._$$maxCash;
    }

    public IIncomeBalanceInfoHsFlexImpl(g r8) {
        super(c.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r8.c();
    L3:
        int r3 = r8.f();
        if (r3 == (-1)) goto L14;
        g.a r4 = decodeExtensionFields(r3, r8);
        if (r3 != 1) goto L7;
        this._$$cashBalance = r8.j();
        r0 = r0 | 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        this._$$maxCash = r8.j();
        r0 = r0 | 2;
        goto L3
    L9:
        if (r3 != 3) goto L10;
        this._$$flameTitle = am3.h.c(r8);
        goto L3
    L10:
        am3.h.d(r4, r8);
        goto L3
    L14:
        r8.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L18;
        this._$$cashBalance = $defaultValue_cashBalance$();
    L18:
        if ((r0 & 2) != 0) goto L33;
        this._$$maxCash = $defaultValue_maxCash$();
        return;
    }
}
