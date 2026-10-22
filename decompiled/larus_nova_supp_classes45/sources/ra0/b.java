package ra0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lra0/b;", "", "", "", "Lra0/a;", "balanceInfo", "Ljava/util/Map;", "getBalanceInfo", "()Ljava/util/Map;", "a", "(Ljava/util/Map;)V", "Lra0/e;", "rebateInfo", "Lra0/e;", "getRebateInfo", "()Lra0/e;", "b", "(Lra0/e;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.incentive.exchange.ExchangeInfo")
public final class b {

    @SerializedName("balance_info")
    private Map<String, a> balanceInfo;

    @SerializedName("rebate_info")
    private e rebateInfo;

    public b() {
        this.balanceInfo = MapsKt.emptyMap();
    }

    public final void a(Map<String, a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.balanceInfo = r2;
    }

    public final void b(e r1) {
        this.rebateInfo = r1;
    }
}
