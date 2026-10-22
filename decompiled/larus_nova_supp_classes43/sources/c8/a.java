package c8;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: c8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0010a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ReadableType.Long.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ReadableType.Null.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static final JSONArray a(ReadableArray r10) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JSONArray r0 = new JSONArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L18;
        ReadableType r12 = r10.getType(r11);
        if (r12 != null) goto L7;
        int r13 = -1;
    L8:
        switch(r13) {
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
        r0.put(a(r10.getArray(r11)));
        goto L17
    L12:
        r0.put(b(r10.getMap(r11)));
        goto L17
    L13:
        r0.put(r10.getString(r11));
        goto L17
    L14:
        r0.put(r10.getDouble(r11));
        goto L17
    L15:
        r0.put(r10.getLong(r11));
        goto L17
    L16:
        r0.put(r10.getBoolean(r11));
    L17:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = C0010a.a[r12.ordinal()];
        goto L8
    L18:
        return r0;
    }

    public static final JSONObject b(ReadableMap r10) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JSONObject r0 = new JSONObject();
        ReadableMapKeySetIterator r1 = r10.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L18;
        String r11 = r1.nextKey();
        ReadableType r12 = r10.getType(r11);
        if (r12 != null) goto L8;
        int r13 = -1;
    L9:
        switch(r13) {
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
        r0.put(r11, JSONObject.NULL);
        goto L4
    L12:
        r0.put(r11, a(r10.getArray(r11)));
        goto L4
    L13:
        r0.put(r11, b(r10.getMap(r11)));
        goto L4
    L14:
        r0.put(r11, r10.getString(r11));
        goto L4
    L15:
        r0.put(r11, r10.getDouble(r11));
        goto L4
    L16:
        r0.put(r11, r10.getLong(r11));
        goto L4
    L17:
        r0.put(r11, r10.getBoolean(r11));
        goto L4
    L8:
        r13 = C0010a.a[r12.ordinal()];
        goto L9
    L18:
        return r0;
    }

    public static final WritableArray c(JSONArray r10) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        WritableArray r0 = Arguments.createArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L37;
        Object r12 = r10.opt(r11);
        if ((r12 instanceof Float) == false) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L11;
        r0.pushDouble(JSONArrayProtectorUtils.getDouble(r10, r11));
    L36:
        r11 = r11 + 1;
        goto L3
    L11:
        if ((r12 instanceof Long) == false) goto L19;
        long r14 = JSONArrayProtectorUtils.getLong(r10, r11);
        if (r14 <= Integer.MAX_VALUE) goto L15;
    L17:
        r0.pushString(String.valueOf(r14));
        goto L36
    L15:
        if (r14 < Integer.MIN_VALUE) goto L17;
        r0.pushInt((int) r14);
        goto L36
    L19:
        if ((r12 instanceof Number) == false) goto L22;
        r0.pushInt(JSONArrayProtectorUtils.getInt(r10, r11));
        goto L36
    L22:
        if ((r12 instanceof String) == false) goto L25;
        r0.pushString(JSONArrayProtectorUtils.getString(r10, r11));
        goto L36
    L25:
        if ((r12 instanceof Boolean) == false) goto L28;
        r0.pushBoolean(JSONArrayProtectorUtils.getBoolean(r10, r11));
        goto L36
    L28:
        if ((r12 instanceof JSONObject) == false) goto L31;
        r0.pushMap(d(JSONArrayProtectorUtils.getJSONObject(r10, r11)));
        goto L36
    L31:
        if ((r12 instanceof JSONArray) == false) goto L34;
        r0.pushArray(c(JSONArrayProtectorUtils.getJSONArray(r10, r11)));
        goto L36
    L34:
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == false) goto L36;
        r0.pushNull();
        goto L36
    L7:
        r13 = r12 instanceof Double;
        goto L8
    L37:
        return r0;
    }

    public static final WritableMap d(JSONObject r10) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        WritableMap r0 = Arguments.createMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L37;
        String r11 = r1.next();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
        String r12 = r11;
        Object r13 = r10.opt(r12);
        if ((r13 instanceof Float) == false) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == true) goto L10;
        if ((r13 instanceof Long) == true) goto L13;
        if ((r13 instanceof Number) == true) goto L21;
        if ((r13 instanceof String) == true) goto L24;
        if ((r13 instanceof Boolean) == true) goto L27;
        if ((r13 instanceof JSONObject) == true) goto L30;
        if ((r13 instanceof JSONArray) == true) goto L33;
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == false) goto L4;
        r0.putNull(r12);
        goto L4
    L33:
        r0.putArray(r12, c(JSONObjectProtectorUtils.getJSONArray(r10, r12)));
        goto L4
    L30:
        r0.putMap(r12, d(JSONObjectProtectorUtils.getJSONObject(r10, r12)));
        goto L4
    L27:
        r0.putBoolean(r12, JSONObjectProtectorUtils.getBoolean(r10, r12));
        goto L4
    L24:
        r0.putString(r12, JSONObjectProtectorUtils.getString(r10, r12));
        goto L4
    L21:
        r0.putInt(r12, JSONObjectProtectorUtils.getInt(r10, r12));
        goto L4
    L13:
        long r15 = JSONObjectProtectorUtils.getLong(r10, r12);
        if (r15 > Integer.MAX_VALUE) goto L18;
        if (r15 < Integer.MIN_VALUE) goto L18;
        r0.putInt(r12, (int) r15);
    L18:
        r0.putString(r12, String.valueOf(r15));
        goto L4
    L10:
        r0.putDouble(r12, JSONObjectProtectorUtils.getDouble(r10, r12));
        goto L4
    L8:
        r14 = r13 instanceof Double;
        goto L9
    L37:
        return r0;
    }
}
