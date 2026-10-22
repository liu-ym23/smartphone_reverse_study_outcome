package nx;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c {
    public final b a;

    public c(String r2, b r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r4, "businessName");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.a = r3;
    }
}
