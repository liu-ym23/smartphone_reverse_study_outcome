package com.larksuite.component.card.component;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final ReadableArray a(ReadableMap r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r3 = r1.asHashMap().get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof ReadableArray) == true) goto L8;
        return null;
    L8:
        return (ReadableArray) r3;
    }

    public static final Boolean b(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Boolean) == true) goto L7;
        return null;
    L7:
        return (Boolean) r3;
    }

    public static final Byte d(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Byte.valueOf(r4.byteValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final Character e(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Character.valueOf((char) r4.intValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final Double f(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Double.valueOf(r4.doubleValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final Integer g(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r4.intValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final Long i(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Long.valueOf(r4.longValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final ReadableMap j(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof ReadableMap) == true) goto L7;
        return null;
    L7:
        return (ReadableMap) r3;
    }

    public static final ReadableMap k(ReadableMap r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r3 = r1.asHashMap().get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof ReadableMap) == true) goto L8;
        return null;
    L8:
        return (ReadableMap) r3;
    }

    public static final Short l(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof Number) == false) goto L5;
        Number r4 = (Number) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return Short.valueOf(r4.shortValue());
    L5:
        r4 = null;
        goto L6
    }

    public static final String m(ReadableArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r3 = ListProtector.get(r1.asArrayList(), r2);
        if ((r3 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r3;
    }

    public static final Boolean c(ReadableMap r1, String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.asHashMap().get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Boolean) == true) goto L8;
        boolean r0 = true;
        if ((r4 instanceof Number) == false) goto L18;
        if (((Number) r4).intValue() != 0) goto L16;
        r0 = false;
    L16:
        return Boolean.valueOf(r0);
    L18:
        if ((r4 instanceof String) == false) goto L32;
        String r5 = (String) r4;
        if (StringsKt.equals(r5, "true", true) == true) goto L31;
        if (StringsKt.equals(r5, "yes", true) == true) goto L31;
        if (StringsKt.equals(r5, "false", true) == true) goto L29;
        if (StringsKt.equals(r5, "no", true) == false) goto L32;
    L29:
        return Boolean.FALSE;
    L31:
        return Boolean.TRUE;
    L32:
        return r3;
    L8:
        return (Boolean) r4;
    }

    public static final Integer h(ReadableMap r1, String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.asHashMap().get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof Number) == false) goto L10;
        return Integer.valueOf(((Number) r4).intValue());
    L10:
        if ((r4 instanceof Boolean) == false) goto L14;
        return Integer.valueOf(((Boolean) r4).booleanValue() ? 1 : 0);
    L14:
        if ((r4 instanceof String) == true) goto L20;
    L19:
        return r3;
    L20:
        return Integer.valueOf(CastIntegerProtector.parseInt((String) r4));
    L17:
        e = move-exception;
        Log.d("LynxDataExtension", "safeGetInt exception: " + e.getMessage());
        goto L19
    }

    public static final String n(ReadableMap r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = r1.asHashMap().get(r2);
        if (r4 != null) goto L6;
        return r3;
    L6:
        if ((r4 instanceof String) == false) goto L10;
        return (String) r4;
    L10:
        if ((r4 instanceof Boolean) == false) goto L17;
        if (((Boolean) r4).booleanValue() == false) goto L14;
        return "true";
    L14:
        return "false";
    L17:
        if ((r4 instanceof Number) == true) goto L19;
        return r3;
    L19:
        return r4.toString();
    }
}
