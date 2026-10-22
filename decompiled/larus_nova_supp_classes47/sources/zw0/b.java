package zw0;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.livesdk.revenue.network.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final com.bytedance.android.livesdk.revenue.network.d x(String r3, com.bytedance.android.livesdk.revenue.network.d r4) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "originalRequest");
        if (c.a() == true) goto L5;
        return r4;
    L5:
        Map r5 = r4.c;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L8
    L10:
        JSONObject r1 = new JSONObject();
        if (Result.isFailure-impl(r6) == false) goto L13;
        r6 = r1;
    L13:
        int r2 = com.bytedance.android.live.recharge.trace.b.a;
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_list_request", (JSONObject) r6, new JSONObject());
        return r4;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void E(String r4, com.bytedance.android.livesdk.revenue.network.d r5, com.bytedance.android.live.network.response.d.b r6) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "response");
        if (c.a() == true) goto L5;
        return;
    L5:
        Object r7 = ((ExtraResponse) r6).data;
        Extra r8 = ((ExtraResponse) r6).extra;
        JSONObject r9 = new JSONObject();
        JSONObject r0 = new JSONObject();
        j01.d.b(r0, Constants.Keys.DATA, r7);
        j01.d.b(r0, "extra", r8);
        if ((r7 instanceof List) == true) goto L8;
    L9:
        j01.d.b(r9, "data_error", 0);
    L11:
        if ((r8 instanceof com.bytedance.android.live.recharge.model.diamond.a) == true) goto L13;
        j01.d.b(r9, "extra_error", 0);
    L13:
        if (r8 == null) goto L20;
        if (((com.bytedance.android.live.recharge.model.diamond.a) r8).f().isEmpty() == false) goto L17;
        j01.d.b(r9, "customized_diamonds_size", 0);
    L17:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_list_response", r9, r0);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.model.diamond.DealSetExtra");
    L8:
        if (((List) r7).size() > 0) goto L11;
        goto L9
    }
}
