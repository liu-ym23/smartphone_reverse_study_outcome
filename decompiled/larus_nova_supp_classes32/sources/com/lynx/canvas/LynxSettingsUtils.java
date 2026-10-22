package com.lynx.canvas;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.tasm.service.ILynxTrailService;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxSettingsUtils {
    private static final String TAG = "LynxSettingsUtils";

    public LynxSettingsUtils() {
    }

    public static boolean booleanValueForKey(String r5, boolean r6) {
        Object r7 = objectValueForKey(r5, null);
        if (r7 != null) goto L6;
        return r6;
    L6:
        if ((r7 instanceof Boolean) == false) goto L10;
        return ((Boolean) r7).booleanValue();
    L10:
        if ((r7 instanceof Number) == false) goto L17;
        if (((Number) r7).doubleValue() != 0.0d) goto L30;
        return false;
    L30:
        return true;
    L17:
        if ((r7 instanceof String) == false) goto L29;
        String r8 = (String) r7;
        if (r8.equalsIgnoreCase("true") == false) goto L21;
    L28:
        return true;
    L21:
        if (r8.equals("1") == true) goto L28;
        if (r8.equalsIgnoreCase("false") == false) goto L26;
    L27:
        return false;
    L26:
        if (r8.equals("0") == true) goto L27;
    L29:
        return r6;
    }

    public static double doubleValueForKey(String r1, double r2) {
        Object r3 = objectValueForKey(r1, null);
        if (r3 != null) goto L6;
        return r2;
    L6:
        if ((r3 instanceof Number) == false) goto L10;
        return ((Number) r3).doubleValue();
    L10:
        if ((r3 instanceof Boolean) == false) goto L17;
        if (((Boolean) r3).booleanValue() == false) goto L14;
        return 1.0d;
    L14:
        return 0.0d;
    L17:
        if ((r3 instanceof String) == true) goto L23;
    L22:
        return r2;
    L23:
        return CastDoubleProtector.parseDouble((String) r3);
    L20:
        e = move-exception;
        KryptonLLog.w(TAG, e.toString());
        goto L22
    }

    public static int integerValueForKey(String r1, int r2) {
        Object r3 = objectValueForKey(r1, null);
        if (r3 != null) goto L6;
        return r2;
    L6:
        if ((r3 instanceof Number) == false) goto L10;
        return ((Number) r3).intValue();
    L10:
        if ((r3 instanceof Boolean) == false) goto L14;
        return ((Boolean) r3).booleanValue() ? 1 : 0;
    L14:
        if ((r3 instanceof String) == true) goto L20;
    L19:
        return r2;
    L20:
        return CastIntegerProtector.parseInt((String) r3);
    L17:
        e = move-exception;
        KryptonLLog.w(TAG, e.toString());
        goto L19
    }

    public static Object objectValueForKey(String r2, Object r3) {
        ILynxTrailService r0 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Object r4 = r0.objectValueForTrailKey(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4;
    }

    public static String stringValueForKey(String r1, String r2) {
        Object r3 = objectValueForKey(r1, null);
        if (r3 != null) goto L5;
    L8:
        return r2;
    L5:
        if ((r3 instanceof String) == false) goto L8;
        return (String) r3;
    }
}
