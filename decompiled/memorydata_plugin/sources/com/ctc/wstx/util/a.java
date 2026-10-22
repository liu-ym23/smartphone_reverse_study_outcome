package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static int a(String r4, Object r5, int r6) {
        if (r5 != null) goto L6;
        int r7 = 0;
    L11:
        if (r7 < r6) goto L14;
        return r7;
    L14:
        throw new IllegalArgumentException("Invalid numeric value (" + r7 + ") for property '" + r4 + "': minimum is " + r6 + ".");
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L9;
        r7 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L18;
        r7 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L15
    L16:
        throw new IllegalArgumentException("Invalid String value for property '" + r4 + "': expected a number (Integer).");
    L18:
        throw new IllegalArgumentException("Invalid value type (" + r5.getClass() + ") for property '" + r4 + "': expected Integer value.");
    }

    public static long a(String r5, Object r6, long r7) {
        if (r6 != null) goto L6;
        long r1 = 0;
    L12:
        if (r1 < r7) goto L15;
        return r1;
    L15:
        throw new IllegalArgumentException("Invalid numeric value (" + r1 + ") for property '" + r5 + "': minimum is " + r7 + ".");
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L9;
        r1 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L19;
        r1 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L16
    L17:
        throw new IllegalArgumentException("Invalid String value for property '" + r5 + "': expected a number (Long).");
    L19:
        throw new IllegalArgumentException("Invalid value type (" + r6.getClass() + ") for property '" + r5 + "': expected Long value.");
    }

    public static boolean a(String r4, Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L10;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L21;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r6.equalsIgnoreCase("false") == false) goto L15;
        return false;
    L15:
        if (r6.equalsIgnoreCase("true") == false) goto L19;
        return true;
    L19:
        throw new IllegalArgumentException("Invalid String value for property '" + r4 + "': expected Boolean value.");
    L21:
        throw new IllegalArgumentException("Invalid value type (" + r5.getClass() + ") for property '" + r4 + "': expected Boolean value.");
    }
}
