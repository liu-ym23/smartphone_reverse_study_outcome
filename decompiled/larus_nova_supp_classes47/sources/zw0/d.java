package zw0;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.l;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends com.bytedance.android.livesdk.revenue.network.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public final com.bytedance.android.livesdk.revenue.network.d x(String r4, com.bytedance.android.livesdk.revenue.network.d r5) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "originalRequest");
        if (c.a() == true) goto L5;
        return r5;
    L5:
        Map r6 = r5.c;
        JSONObject r0 = new JSONObject();
        Iterator r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r7.next();
        d60.b.a(r0, (String) r1.getKey(), (String) r1.getValue());
        goto L7
    L9:
        int r8 = com.bytedance.android.live.recharge.trace.b.a;
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_wallet_info_request", r0, new JSONObject());
        return r5;
    }

    public final void E(String r3, com.bytedance.android.livesdk.revenue.network.d r4, com.bytedance.android.live.network.response.d.b r5) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "response");
        if (c.a() == true) goto L5;
        return;
    L5:
        JSONObject r6 = new JSONObject();
        d60.b.a(r6, Constants.Keys.DATA, ((ExtraResponse) r5).data);
        JSONObject r7 = new JSONObject();
        Object r8 = ((ExtraResponse) r5).data;
        if ((r8 instanceof l) == false) goto L11;
        if (r8 == null) goto L10;
        d60.b.a(r7, "diamond", Long.valueOf(((l) r8).getDiamond()));
    L12:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_wallet_info_response", r7, r6);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.IWalletInfo");
    L11:
        d60.b.a(r7, "data_error", 0);
        goto L12
    }
}
