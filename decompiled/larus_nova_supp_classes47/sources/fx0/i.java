package fx0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements Consumer<Long> {
    public final /* synthetic */ CallContext a;

    public i(CallContext r1) {
        this.a = r1;
    }

    public final void accept(Object r4) throws Exception {
        Long r5 = (Long) r4;
        JSONObject r6 = new JSONObject();
        r6.put("current_diamond", ((IRechargeService) jc1.k.f(IRechargeService.class)).rechargeCenter().getAvailableDiamonds());
        this.a.b("h5_diamond_change", r6);
    }
}
