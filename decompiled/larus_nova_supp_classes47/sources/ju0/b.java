package ju0;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {
    public final JSONObject a;

    public b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "rawJson");
        this.a = r2;
    }
}
