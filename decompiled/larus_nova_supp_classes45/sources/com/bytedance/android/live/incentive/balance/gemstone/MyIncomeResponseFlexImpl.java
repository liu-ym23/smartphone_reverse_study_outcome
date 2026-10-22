package com.bytedance.android.live.incentive.balance.gemstone;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.growth.taskcenter.MyIncomeResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/gemstone/MyIncomeResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/incentive/balance/gemstone/b;", "", "Lcom/bytedance/android/live/incentive/balance/gemstone/MyIncomeResponse_BalanceFlexImpl;", "balances$delegate", "Ljava/lang/Object;", "getBalances", "()Ljava/util/List;", "balances", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MyIncomeResponseFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("balances")
    protected List<MyIncomeResponse_BalanceFlexImpl> _$$balances;

    public MyIncomeResponseFlexImpl() {
        super(b.class);
        this._$$balances = $defaultValue_balances$();
    }

    public MyIncomeResponseFlexImpl(g r6) {
        super(b.class);
        this._$$balances = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$balances.add(new MyIncomeResponse_BalanceFlexImpl(r6));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$balances.isEmpty() == false) goto L19;
        this._$$balances = $defaultValue_balances$();
        return;
    }

    public final List<MyIncomeResponse_BalanceFlexImpl> $defaultValue_balances$() {
        return d.a();
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.b
    public final List<MyIncomeResponse_BalanceFlexImpl> getBalances() {
        return this._$$balances;
    }
}
