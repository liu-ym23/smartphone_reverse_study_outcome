package m4;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final JsonArray a(ReadableArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JsonArray r0 = new JsonArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L19;
        ReadableType r12 = r10.getType(r11);
        if (r12 != null) goto L7;
        int r13 = -1;
    L8:
        switch(r13) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r0.add(a(r10.getArray(r11)));
        goto L18
    L11:
        r0.add(b(r10.getMap(r11)));
        goto L18
    L12:
        r0.add(r10.getString(r11));
        goto L18
    L13:
        r0.add(Double.valueOf(r10.getDouble(r11)));
        goto L18
    L14:
        r0.add(Long.valueOf(r10.getLong(r11)));
        goto L18
    L15:
        r0.add(Integer.valueOf(r10.getInt(r11)));
        goto L18
    L16:
        r0.add(Boolean.valueOf(r10.getBoolean(r11)));
        goto L18
    L17:
        r0.add(JsonNull.INSTANCE);
    L18:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = a.a[r12.ordinal()];
        goto L8
    L19:
        return r0;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, m4.e] */
    public static final JsonObject b(final ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        final JsonObject r1 = new JsonObject();
        ?? r11 = new e(r10, r1);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ReadableMapKeySetIterator r12 = r10.keySetIterator();
    L4:
        if (r12.hasNextKey() == false) goto L14;
        String r0 = r12.nextKey();
        if (r0 != null) goto L8;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == true) goto L4;
        r11.invoke(r0);
        goto L4
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r13 = false;
        goto L12
    L14:
        return r1;
    }
}
