package fx0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceBusinessScene;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceKey;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceScene;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements zv0.e {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    @Override // zv0.e
    public final void b() {
        b r0 = this.a.a;
        b.c r1 = new b.c(2, null);
        int r2 = b.b;
        r0.finishWithResult(r1);
    }

    @Override // zv0.e
    public final void a(Throwable r4) {
        b r0 = this.a.a;
        b.c r1 = new b.c(3, r4);
        int r5 = b.b;
        r0.finishWithResult(r1);
    }

    @Override // zv0.e
    public final void c(zv0.d r5) {
        d r6 = this.a;
        b r0 = r6.a;
        ExchangeTraceGiftSource r7 = (ExchangeTraceGiftSource) r6.c.element;
        long r1 = this.b;
        int r3 = b.b;
        r0.getClass();
        Map<String, String> r2 = com.bytedance.android.live.recharge.exchange.trace.a.a;
        ExchangeTraceKey r4 = ExchangeTraceKey.KEY_IS_COMBINE_EXCHANGE;
        if (com.bytedance.android.live.recharge.utils.e.d() == false) goto L5;
        String r8 = DataType.TRUE;
    L6:
        com.bytedance.android.live.recharge.exchange.trace.a.b(r4, r8);
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GIFT_SOURCE, r7.getValue());
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GIFT_SHOW_FROM, "IncomeExchangeDialog JSB");
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_DIAMOND_COUNT, String.valueOf(r1));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_BUSINESS_SCENE, String.valueOf(ExchangeTraceBusinessScene.EXCHANGE_BUSINESS_SCENE_DIAMOND.getValue()));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_EXCHANGE_SCENE, String.valueOf(ExchangeTraceScene.EXCHANGE_SCENE_EXCHANGE_DIALOG.getValue()));
        com.bytedance.android.live.recharge.exchange.trace.a.a();
        this.a.a.finishWithResult(new b.c(1, null));
        return;
    L5:
        r8 = DataType.FALSE;
        goto L6
    }

    public c(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
