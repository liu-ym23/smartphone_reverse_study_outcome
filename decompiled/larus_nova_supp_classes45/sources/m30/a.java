package m30;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements t {
    public final Object a;

    public final v asArray() {
        Object r0 = this.a;
        if ((r0 instanceof JSONArray) == false) goto L7;
        return new f((JSONArray) r0);
    L7:
        throw new IllegalArgumentException("Dynamic is not JSONArray");
    }

    public final boolean asBoolean() {
        Object r0 = this.a;
        if ((r0 instanceof Boolean) == false) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        throw new IllegalArgumentException("Dynamic is not Boolean");
    }

    public final double asDouble() {
        Object r0 = this.a;
        if ((r0 instanceof Double) == false) goto L6;
        return ((Number) r0).doubleValue();
    L6:
        if ((r0 instanceof Integer) == false) goto L9;
        return ((Number) r0).intValue();
    L9:
        if ((r0 instanceof Float) == false) goto L12;
        return ((Number) r0).floatValue();
    L12:
        if ((r0 instanceof Long) == false) goto L16;
        return ((Number) r0).longValue();
    L16:
        throw new IllegalArgumentException("Dynamic is not Double");
    }

    public final int asInt() {
        Object r0 = this.a;
        if ((r0 instanceof Integer) == false) goto L7;
        return ((Number) r0).intValue();
    L7:
        throw new IllegalArgumentException("Dynamic is not Int");
    }

    public final XReadableMap asMap() {
        Object r0 = this.a;
        if ((r0 instanceof JSONObject) == false) goto L7;
        return new g((JSONObject) r0);
    L7:
        throw new IllegalArgumentException("Dynamic is not JSONObject");
    }

    public final String asString() {
        Object r0 = this.a;
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        throw new IllegalArgumentException("Dynamic is not String");
    }

    public XReadableType getType() {
        Object r0 = this.a;
        if ((r0 instanceof JSONArray) == false) goto L6;
        return XReadableType.Array;
    L6:
        if ((r0 instanceof Boolean) == false) goto L9;
        return XReadableType.Boolean;
    L9:
        if ((r0 instanceof JSONObject) == false) goto L12;
        return XReadableType.Map;
    L12:
        if ((r0 instanceof Integer) == false) goto L15;
        return XReadableType.Int;
    L15:
        if ((r0 instanceof Number) == false) goto L18;
        return XReadableType.Number;
    L18:
        if ((r0 instanceof String) == false) goto L21;
        return XReadableType.String;
    L21:
        return XReadableType.Null;
    }

    public a(Object r1) {
        this.a = r1;
    }
}
