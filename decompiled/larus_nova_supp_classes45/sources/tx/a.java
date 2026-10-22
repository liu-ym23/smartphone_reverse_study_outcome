package tx;

import kotlin.jvm.internal.Intrinsics;
import nx.b;
import nx.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends c {
    public a(String r2, JSONObject r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2, r4, "client_predict_drawer", r3);
    }
}
