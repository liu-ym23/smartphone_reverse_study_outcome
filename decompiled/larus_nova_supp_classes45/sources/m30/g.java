package m30;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements XReadableMap {
    public final JSONObject a;

    public final u keyIterator() {
        return new e(this.a.keys());
    }

    public final Map<String, Object> toMap() {
        int r0 = h.a;
        return h.b(this.a);
    }

    public g(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
    }

    public final t get(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        return new a(this.a.opt(r3));
    }

    public final v getArray(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        JSONArray r3 = this.a.optJSONArray(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return new f(r3);
    }

    public final boolean getBoolean(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.optBoolean(r2);
    }

    public final double getDouble(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        return this.a.optDouble(r3);
    }

    public final int getInt(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.optInt(r2);
    }

    public final XReadableMap getMap(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        JSONObject r3 = this.a.optJSONObject(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return new g(r3);
    }

    public final String getString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.optString(r2);
    }

    public XReadableType getType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Object r3 = this.a.opt(r2);
        if ((r3 instanceof JSONArray) == false) goto L6;
        return XReadableType.Array;
    L6:
        if ((r3 instanceof Boolean) == false) goto L9;
        return XReadableType.Boolean;
    L9:
        if ((r3 instanceof JSONObject) == false) goto L12;
        return XReadableType.Map;
    L12:
        if ((r3 instanceof Integer) == false) goto L15;
        return XReadableType.Int;
    L15:
        if ((r3 instanceof Number) == false) goto L18;
        return XReadableType.Number;
    L18:
        if ((r3 instanceof String) == false) goto L21;
        return XReadableType.String;
    L21:
        return XReadableType.Null;
    }

    public final boolean hasKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.has(r2);
    }

    public final boolean isNull(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.isNull(r2);
    }
}
