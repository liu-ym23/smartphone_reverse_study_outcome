package gx0;

import am2.x;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r3) {
        HashMap r0 = new HashMap();
        r0.put("request_page", "gift_entrance");
        r0.put("charge_reason", "exchange_diamond");
        r0.put("available_exchange_diamond", String.valueOf(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getExchangeDiamond()));
        if (r3 == false) goto L5;
        String r4 = DataType.TRUE;
    L6:
        r0.put("is_click_success", r4);
        HashMap<Class<?>, d<?>> r5 = f.a;
        f.d("livesdk_exchange_entrance_click", r0, new Class[]{IRoom.class, x.class});
        return;
    L5:
        r4 = DataType.FALSE;
        goto L6
    }
}
