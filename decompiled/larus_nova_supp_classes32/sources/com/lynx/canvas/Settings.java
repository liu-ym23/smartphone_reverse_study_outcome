package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Settings {
    public Settings() {
    }

    private static KryptonSettingsService getSettingsService(KryptonApp r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (KryptonSettingsService) r1.getService(KryptonSettingsService.class);
    }

    public static boolean booleanValueForKey(KryptonApp r0, String r1, boolean r2) {
        KryptonSettingsService r3 = getSettingsService(r0);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.booleanValueForKey(r1, r2);
    }

    public static double doubleValueForKey(KryptonApp r0, String r1, double r2) {
        KryptonSettingsService r3 = getSettingsService(r0);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.doubleValueForKey(r1, r2);
    }

    public static int integerValueForKey(KryptonApp r0, String r1, int r2) {
        KryptonSettingsService r3 = getSettingsService(r0);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.integerValueForKey(r1, r2);
    }

    public static String stringValueForKey(KryptonApp r0, String r1, String r2) {
        KryptonSettingsService r3 = getSettingsService(r0);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.stringValueForKey(r1, r2);
    }
}
