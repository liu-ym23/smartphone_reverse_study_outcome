package x60;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static boolean a(Object r4, boolean r5) {
        if (r4 == null) goto L33;
        Integer r1 = null;
        if ((r4 instanceof Boolean) == false) goto L7;
        Boolean r0 = (Boolean) r4;
    L15:
        if (r0 == null) goto L19;
        return r0.booleanValue();
    L19:
        if ((r4 instanceof Integer) == false) goto L22;
        r1 = (Integer) r4;
    L27:
        if (r1 == null) goto L33;
        if (r1.intValue() == 0) goto L31;
        return true;
    L31:
        return false;
    L22:
        if ((r4 instanceof Number) == false) goto L25;
        r1 = Integer.valueOf(((Number) r4).intValue());
        goto L27
    L25:
        if ((r4 instanceof String) == false) goto L27;
        r1 = Integer.valueOf((int) CastDoubleProtector.parseDouble((String) r4));     // Catch: NumberFormatException -> L34
        goto L27
    L7:
        if ((r4 instanceof String) == false) goto L14;
        String r2 = (String) r4;
        if ("true".equalsIgnoreCase(r2) == false) goto L12;
        r0 = Boolean.TRUE;
        goto L15
    L12:
        if ("false".equalsIgnoreCase(r2) == false) goto L14;
        r0 = Boolean.FALSE;
    L14:
        r0 = null;
    L33:
        return r5;
    }
}
