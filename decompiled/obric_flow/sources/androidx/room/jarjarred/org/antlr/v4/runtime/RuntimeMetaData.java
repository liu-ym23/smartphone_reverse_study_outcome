package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeMetaData {
    public static final String VERSION = "4.7.1";

    public RuntimeMetaData() {
    }

    public static void checkVersion(String r10, String r11) {
        boolean r5 = true;
        if (r10 != null) goto L5;
    L9:
        boolean r12 = false;
    L11:
        if (VERSION.equals(r11) == false) goto L13;
    L15:
        r5 = false;
    L16:
        if (r12 == false) goto L18;
        System.err.printf("ANTLR Tool version %s used for code generation does not match the current runtime version %s", new Object[]{r10, VERSION});
    L18:
        if (r5 == false) goto L21;
        System.err.printf("ANTLR Runtime version %s used for parser compilation does not match the current runtime version %s", new Object[]{r11, VERSION});
        return;
    L21:
        return;
    L13:
        if (getMajorMinorVersion(VERSION).equals(getMajorMinorVersion(r11)) == true) goto L15;
    L5:
        if (VERSION.equals(r10) == true) goto L9;
        if (getMajorMinorVersion(VERSION).equals(getMajorMinorVersion(r10)) == true) goto L9;
        r12 = true;
        goto L11
    }

    public static String getMajorMinorVersion(String r5) {
        int r10 = r5.indexOf(46);
        if (r10 < 0) goto L5;
        int r11 = r5.indexOf(46, r10 + 1);
    L6:
        int r12 = r5.indexOf(45);
        int r13 = r5.length();
        if (r11 < 0) goto L9;
        r13 = Math.min(r13, r11);
    L9:
        if (r12 < 0) goto L12;
        r13 = Math.min(r13, r12);
    L12:
        return r5.substring(0, r13);
    L5:
        r11 = -1;
        goto L6
    }

    public static String getRuntimeVersion() {
        return VERSION;
    }
}
