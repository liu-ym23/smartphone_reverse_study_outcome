package kl0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.p70;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final JSONArray a(ReadableArray r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toJSONArray");
        JSONArray r0 = new JSONArray();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        ReadableType r3 = r5.getType(r2);
        if (r3 == null) goto L17;
        switch(a.b[r3.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L17;
        };
    L10:
        r0.put(JSONObject.NULL);
        goto L17
    L11:
        r0.put(a(r5.getArray(r2)));
        goto L17
    L12:
        r0.put(b(r5.getMap(r2)));
        goto L17
    L13:
        r0.put(r5.getString(r2));
        goto L17
    L14:
        r0.put(r5.getDouble(r2));
        goto L17
    L15:
        r0.put(r5.getLong(r2));
        goto L17
    L16:
        r0.put(r5.getBoolean(r2));
    L17:
        r2 = r2 + 1;
        goto L3
    L18:
        return r0;
    }

    public static final JSONObject b(ReadableMap r5) throws JSONException {
        Intrinsics.checkNotNullParameter(r5, "$this$toJSONObject");
        JSONObject r0 = new JSONObject();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L18;
        String r2 = r1.nextKey();
        ReadableType r3 = r5.getType(r2);
        if (r3 == null) goto L4;
        switch(a.a[r3.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r0.put(r2, JSONObject.NULL);
        goto L4
    L12:
        r0.put(r2, a(r5.getArray(r2)));
        goto L4
    L13:
        r0.put(r2, b(r5.getMap(r2)));
        goto L4
    L14:
        r0.put(r2, r5.getString(r2));
        goto L4
    L15:
        r0.put(r2, r5.getDouble(r2));
        goto L4
    L16:
        r0.put(r2, r5.getLong(r2));
        goto L4
    L17:
        r0.put(r2, r5.getBoolean(r2));
        goto L4
    L18:
        return r0;
    }

    public static final WritableArray c(JSONArray r8) throws JSONException {
        Intrinsics.checkNotNullParameter(r8, "$this$toWritableArray");
        WritableArray r0 = Arguments.createArray();
        int r1 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L40;
        Object r3 = r8.opt(r2);
        if ((r3 instanceof Float) == false) goto L7;
    L38:
        r0.pushDouble(JSONArrayProtectorUtils.getDouble(r8, r2));
    L39:
        r2 = r2 + 1;
        goto L3
    L7:
        if ((r3 instanceof Double) == true) goto L38;
        if ((r3 instanceof Long) == false) goto L21;
        long r4 = JSONArrayProtectorUtils.getLong(r8, r2);
        if (((Boolean) p70.a.getValue()).booleanValue() == true) goto L14;
        r0.pushString(String.valueOf(r4));
        goto L39
    L14:
        if (r4 <= Integer.MAX_VALUE) goto L16;
    L18:
        r0.pushString(String.valueOf(r4));
        goto L39
    L16:
        if (r4 < ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION) goto L18;
        r0.pushInt((int) r4);
        goto L39
    L21:
        if ((r3 instanceof Number) == false) goto L24;
        r0.pushInt(JSONArrayProtectorUtils.getInt(r8, r2));
        goto L39
    L24:
        if ((r3 instanceof String) == false) goto L27;
        r0.pushString(JSONArrayProtectorUtils.getString(r8, r2));
        goto L39
    L27:
        if ((r3 instanceof Boolean) == false) goto L30;
        r0.pushBoolean(JSONArrayProtectorUtils.getBoolean(r8, r2));
        goto L39
    L30:
        if ((r3 instanceof JSONObject) == false) goto L33;
        r0.pushMap(d(JSONArrayProtectorUtils.getJSONObject(r8, r2)));
        goto L39
    L33:
        if ((r3 instanceof JSONArray) == false) goto L36;
        r0.pushArray(c(JSONArrayProtectorUtils.getJSONArray(r8, r2)));
        goto L39
    L36:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == false) goto L39;
        r0.pushNull();
        goto L39
    L40:
        return r0;
    }

    public static final WritableMap d(JSONObject r8) throws JSONException {
        Intrinsics.checkNotNullParameter(r8, "$this$toWritableMap");
        WritableMap r0 = Arguments.createMap();
        Iterator<String> r1 = r8.keys();
    L4:
        if (r1.hasNext() == false) goto L44;
        String r2 = r1.next();
        if (r2 == null) goto L43;
        String r3 = r2;
        Object r4 = r8.opt(r3);
        if ((r4 instanceof Float) == true) goto L41;
        if ((r4 instanceof Double) == true) goto L41;
        if ((r4 instanceof Long) == true) goto L14;
        if ((r4 instanceof Number) == true) goto L25;
        if ((r4 instanceof String) == true) goto L28;
        if ((r4 instanceof Boolean) == true) goto L31;
        if ((r4 instanceof JSONObject) == true) goto L34;
        if ((r4 instanceof JSONArray) == true) goto L37;
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L4;
        r0.putNull(r3);
        goto L4
    L37:
        r0.putArray(r3, c(JSONObjectProtectorUtils.getJSONArray(r8, r3)));
        goto L4
    L34:
        r0.putMap(r3, d(JSONObjectProtectorUtils.getJSONObject(r8, r3)));
        goto L4
    L31:
        r0.putBoolean(r3, JSONObjectProtectorUtils.getBoolean(r8, r3));
        goto L4
    L28:
        r0.putString(r3, JSONObjectProtectorUtils.getString(r8, r3));
        goto L4
    L25:
        r0.putInt(r3, JSONObjectProtectorUtils.getInt(r8, r3));
        goto L4
    L14:
        long r5 = JSONObjectProtectorUtils.getLong(r8, r3);
        if (((Boolean) p70.a.getValue()).booleanValue() == true) goto L17;
        r0.putString(r3, String.valueOf(r5));
        goto L4
    L17:
        if (r5 > Integer.MAX_VALUE) goto L21;
        if (r5 < ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION) goto L21;
        r0.putInt(r3, (int) r5);
    L21:
        r0.putString(r3, String.valueOf(r5));
    L41:
        r0.putDouble(r3, JSONObjectProtectorUtils.getDouble(r8, r3));
        goto L4
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L44:
        return r0;
    }
}
