package com.larksuite.component.card.component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public static final Gson a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Array.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ReadableType.Map.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ReadableType.String.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ReadableType.Long.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ReadableType.Boolean.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
        a = new Gson();
    }

    public static JsonArray a(ReadableArray r5) {
        JsonArray r0 = new JsonArray();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L22;
        ReadableType r3 = r5.getType(r2);
        if (r3 != null) goto L7;
        int r4 = -1;
    L8:
        switch(r4) {
            case 1: goto L18;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L21;
        };
    L10:
        r0.add(Boolean.valueOf(r5.getBoolean(r2)));
        goto L21
    L11:
        r0.add(Long.valueOf(r5.getLong(r2)));
        goto L21
    L12:
        r0.add(Integer.valueOf(r5.getInt(r2)));
        goto L21
    L13:
        r0.add(Double.valueOf(r5.getDouble(r2)));
        goto L21
    L14:
        r0.add(r5.getString(r2));
        goto L21
    L15:
        ReadableMap r6 = r5.getMap(r2);
        if (r6 == null) goto L21;
        r0.add(b(r6));
        goto L21
    L18:
        ReadableArray r7 = r5.getArray(r2);
        if (r7 == null) goto L21;
        r0.add(a(r7));
    L21:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = a.a[r3.ordinal()];
        goto L8
    L22:
        return r0;
    }

    public static JsonObject b(ReadableMap r5) {
        JsonObject r0 = new JsonObject();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L4:
        if (r1.hasNextKey() == false) goto L22;
        String r2 = r1.nextKey();
        ReadableType r3 = r5.getType(r2);
        if (r3 != null) goto L8;
        int r4 = -1;
    L9:
        switch(r4) {
            case 1: goto L19;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r0.addProperty(r2, Boolean.valueOf(r5.getBoolean(r2)));
        goto L4
    L12:
        r0.addProperty(r2, Long.valueOf(r5.getLong(r2)));
        goto L4
    L13:
        r0.addProperty(r2, Integer.valueOf(r5.getInt(r2)));
        goto L4
    L14:
        r0.addProperty(r2, Double.valueOf(r5.getDouble(r2)));
        goto L4
    L15:
        r0.addProperty(r2, r5.getString(r2));
        goto L4
    L16:
        ReadableMap r6 = r5.getMap(r2);
        if (r6 == null) goto L4;
        r0.add(r2, b(r6));
        goto L4
    L19:
        ReadableArray r7 = r5.getArray(r2);
        if (r7 == null) goto L4;
        r0.add(r2, a(r7));
        goto L4
    L8:
        r4 = a.a[r3.ordinal()];
        goto L9
    L22:
        return r0;
    }

    public static Object c(ReadableMap r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r2, "classOfT");
        return a.fromJson(b(r1), r2);
    L5:
        th = move-exception;
        Log.e("LynxDataTransformer", "transform error: " + th.getMessage());
        return null;
    }
}
