package rx;

import kotlin.jvm.internal.Intrinsics;
import nx.c;
import org.json.JSONObject;
import wp2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends c {
    public a(String r2, JSONObject r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2, r4, "live_gift_resource_pre_download", r3);
    }
}
