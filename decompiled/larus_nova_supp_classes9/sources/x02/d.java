package x02;

import com.bytedance.android.livesdk.gift.platform.business.sendGift.sendStrategy.ExchangeDiamondPluginCustomResultCode;
import com.bytedance.android.livesdk.gift.platform.core.model.x;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends x {
    public final ExchangeDiamondPluginCustomResultCode a;

    public d(ExchangeDiamondPluginCustomResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "customCode");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.x
    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "originObject");
        r3.put("exchange_result_code", this.a.getValue());
    }
}
