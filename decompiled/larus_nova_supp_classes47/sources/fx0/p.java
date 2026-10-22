package fx0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "updateWalletInfo")
public final class p extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    public final void onTerminate() {
    }

    public p() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("jsb");
    }
}
