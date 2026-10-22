package a09;

import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final c a(String r5) throws Exception {
        c r0 = new c(0);
        if (r5 == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L13;
        JSONObject r4 = new JSONObject(r5);
        if (Intrinsics.areEqual(FlowDoraConnectReason.SUCCESS, r4.optString("message")) == false) goto L10;
        r0.a = true;
        r0.b = r4.optJSONObject("data");
    L11:
        return r0;
    L10:
        r0.a = false;
        r0.b = r4.optJSONObject("data");
        goto L11
    L13:
        throw new IllegalArgumentException("argument is null".toString());
    L5:
        r3 = false;
        goto L6
    }

    public static final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "res");
        JSONObject r0 = new JSONObject(r3);     // Catch: Exception -> L15
        int r4 = r0.optInt("code");     // Catch: Exception -> L15
        String r1 = r0.optString("msg");     // Catch: Exception -> L15
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        if (r4 == 0) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r1, FlowDoraConnectReason.SUCCESS) == false) goto L23;
        String r5 = r0.optString("data");     // Catch: Exception -> L15
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    L23:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        FLogger.a.e("parseDomainsAll", "getDomainsAll e=" + e.getMessage());
        return null;
    }
}
