package com.bytedance.android.live.incentive.balance.gemstone;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.growth.taskcenter.MyIncomeResponse.Balance")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/gemstone/MyIncomeResponse_BalanceFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/incentive/balance/gemstone/b$a;", "", "type$delegate", "Ljava/lang/Object;", "getType", "()I", "type", "", "amount$delegate", "getAmount", "()J", "amount", "", "desc$delegate", "getDesc", "()Ljava/lang/String;", "desc", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MyIncomeResponse_BalanceFlexImpl extends FlexModelBase<b.a> implements b.a, h {

    @SerializedName("amount")
    protected long _$$amount;

    @SerializedName("desc")
    protected String _$$desc;

    @SerializedName("type")
    protected int _$$type;

    public MyIncomeResponse_BalanceFlexImpl() {
        super(b.a.class);
        this._$$desc = "";
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.b.a
    public final long getAmount() {
        return this._$$amount;
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.b.a
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.b.a
    public final int getType() {
        return this._$$type;
    }

    public MyIncomeResponse_BalanceFlexImpl(g r6) {
        super(b.a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$type = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$amount = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$desc = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$desc != null) goto L31;
        this._$$desc = "";
        return;
    }
}
