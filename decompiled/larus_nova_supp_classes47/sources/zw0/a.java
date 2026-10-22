package zw0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {

    /* JADX INFO: renamed from: zw0.a$a, reason: collision with other inner class name */
    public static final class C0353a {
    }

    static {
    }

    public a() {
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
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_buy_request", r0, new JSONObject());
        return r5;
    }

    public final void E(String r5, com.bytedance.android.livesdk.revenue.network.d r6, com.bytedance.android.live.network.response.d.b r7) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "request");
        Intrinsics.checkNotNullParameter(r7, "response");
        if (c.a() == true) goto L5;
        return;
    L5:
        Object r8 = ((ExtraResponse) r7).data;
        Extra r9 = ((ExtraResponse) r7).extra;
        JSONObject r10 = new JSONObject();
        JSONObject r0 = new JSONObject();
        d60.b.a(r0, Constants.Keys.DATA, r8);
        d60.b.a(r0, "extra", r9);
        boolean r2 = false;
        if ((r8 instanceof com.bytedance.android.live.wallet.model.d) == true) goto L9;
        d60.b.a(r10, "data_error", 0);
    L9:
        if ((r9 instanceof MinorExtra) == true) goto L11;
        d60.b.a(r10, "extra_error", 0);
    L11:
        if (r8 == null) goto L32;
        com.bytedance.android.live.wallet.model.d r12 = (com.bytedance.android.live.wallet.model.d) r8;
        String r13 = r12.b();
        if (r13 != null) goto L15;
    L18:
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        d60.b.a(r10, "order_id", DataType.FALSE);
    L22:
        String r15 = r12.c();
        if (r15 != null) goto L25;
    L26:
        r2 = true;
    L27:
        if (r2 == false) goto L29;
        d60.b.a(r10, "params", DataType.FALSE);
    L29:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_buy_response", r10, r0);
        return;
    L25:
        if (r15.length() != 0) goto L27;
    L15:
        if (r13.length() == 0) goto L18;
        r14 = false;
        goto L20
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.wallet.model.CJOrderInfo");
    }
}
