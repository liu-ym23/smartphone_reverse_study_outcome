package w20;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b4 {
    public static final JSONObject a(xb r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$extraJson");
        JsonObject r2 = r1.getExtra();
        if (r2 == null) goto L7;
        String r3 = r2.toString();
        if (r3 == null) goto L7;
        return new JSONObject(r3);
    L7:
        return null;
    }
}
