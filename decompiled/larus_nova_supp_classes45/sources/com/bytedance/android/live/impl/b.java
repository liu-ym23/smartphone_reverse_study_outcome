package com.bytedance.android.live.impl;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "cur");
        if ((r2 instanceof Integer) == false) goto L6;
        return ((Number) r2).intValue();
    L6:
        if ((r2 instanceof Double) == false) goto L9;
        return ((Number) r2).doubleValue();
    L9:
        if ((r2 instanceof Float) == false) goto L12;
        return ((Number) r2).floatValue();
    L12:
        if ((r2 instanceof Long) == false) goto L15;
        return ((Number) r2).longValue();
    L15:
        if ((r2 instanceof String) == false) goto L18;
        return CastDoubleProtector.parseDouble((String) r2);
    L18:
        return ((Double) r2).doubleValue();
    }

    public static int c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "cur");
        if ((r2 instanceof Integer) == false) goto L6;
        return ((Number) r2).intValue();
    L6:
        if ((r2 instanceof Double) == false) goto L9;
        return (int) ((Number) r2).doubleValue();
    L9:
        if ((r2 instanceof Float) == false) goto L12;
        return (int) ((Number) r2).floatValue();
    L12:
        if ((r2 instanceof Long) == false) goto L15;
        return (int) ((Number) r2).longValue();
    L15:
        if ((r2 instanceof String) == false) goto L18;
        return CastIntegerProtector.parseInt((String) r2);
    L18:
        return ((Integer) r2).intValue();
    }

    public static long d(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "cur");
        if ((r2 instanceof Integer) == false) goto L6;
        return ((Number) r2).intValue();
    L6:
        if ((r2 instanceof Double) == false) goto L9;
        return (long) ((Number) r2).doubleValue();
    L9:
        if ((r2 instanceof Long) == false) goto L12;
        return ((Number) r2).longValue();
    L12:
        if ((r2 instanceof String) == false) goto L15;
        return CastLongProtector.parseLong((String) r2);
    L15:
        if ((r2 instanceof Float) == false) goto L18;
        return (long) ((Number) r2).floatValue();
    L18:
        return ((Long) r2).longValue();
    }

    public static String e(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "cur");
        if ((r1 instanceof Integer) == true) goto L16;
        if (Intrinsics.areEqual(r1, DoubleCompanionObject.INSTANCE) == true) goto L16;
        if (Intrinsics.areEqual(r1, LongCompanionObject.INSTANCE) == true) goto L16;
        if (Intrinsics.areEqual(r1, FloatCompanionObject.INSTANCE) == true) goto L16;
        if ((r1 instanceof String) == false) goto L18;
        return (String) r1;
    L18:
        return (String) r1;
    L16:
        return r1.toString();
    }

    public static Object a(Object r1, Object r2) {
        if ((r2 instanceof Integer) == false) goto L7;
        if (r1 != null) goto L39;
    L37:
        return null;
    L39:
        return Integer.valueOf(c(r1));
    L7:
        if ((r2 instanceof Double) == false) goto L11;
        if (r1 == null) goto L37;
        return Double.valueOf(b(r1));
    L11:
        if ((r2 instanceof Long) == false) goto L15;
        if (r1 == null) goto L37;
        return Long.valueOf(d(r1));
    L15:
        if ((r2 instanceof String) == false) goto L18;
        return String.valueOf(r1);
    L18:
        if ((r2 instanceof Float) == false) goto L43;
        if (r1 == null) goto L37;
        Intrinsics.checkNotNullParameter(r1, "cur");
        if ((r1 instanceof Integer) == false) goto L24;
        float r3 = ((Number) r1).intValue();
    L44:
        return Float.valueOf(r3);
    L24:
        if ((r1 instanceof Double) == false) goto L27;
        r3 = (float) ((Number) r1).doubleValue();
        goto L44
    L27:
        if ((r1 instanceof Long) == false) goto L30;
        r3 = ((Number) r1).longValue();
        goto L44
    L30:
        if ((r1 instanceof String) == false) goto L33;
        r3 = CastFloatProtector.parseFloat((String) r1);
        goto L44
    L33:
        if ((r1 instanceof Float) == false) goto L35;
        r3 = ((Number) r1).floatValue();
        goto L44
    L35:
        r3 = ((Float) r1).floatValue();
        goto L44
    L43:
        return r1;
    }
}
