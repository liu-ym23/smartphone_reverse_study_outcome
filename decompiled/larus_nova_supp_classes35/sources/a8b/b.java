package a8b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static boolean a(int r2) {
        switch(Character.getType(r2)) {
            case 20: goto L5;
            case 21: goto L5;
            case 22: goto L5;
            case 23: goto L5;
            case 24: goto L5;
            case 25: goto L5;
            case 26: goto L5;
            case 27: goto L5;
            case 28: goto L5;
            case 29: goto L5;
            case 30: goto L5;
            default: goto L7;
        };
    L5:
        return true;
    L7:
        if (r2 != 36) goto L9;
    L21:
        return true;
    L9:
        if (r2 == 43) goto L21;
        if (r2 == 94) goto L21;
        if (r2 == 96) goto L21;
        if (r2 == 124) goto L21;
        if (r2 == 126) goto L21;
        switch(r2) {
            case 60: goto L21;
            case 61: goto L21;
            case 62: goto L21;
            default: goto L19;
        };
    L19:
        return false;
    }

    public static boolean b(int r3) {
        if (r3 != 9) goto L5;
        return true;
    L5:
        if (r3 != 10) goto L7;
        return true;
    L7:
        if (r3 != 12) goto L9;
        return true;
    L9:
        if (r3 != 13) goto L11;
        return true;
    L11:
        if (r3 != 32) goto L13;
        return true;
    L13:
        if (Character.getType(r3) == 12) goto L22;
        return false;
    L22:
        return true;
    }

    public static int c(CharSequence r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L9;
        char r0 = r2.charAt(r3);
        if (r0 == '\t') goto L8;
        if (r0 == ' ') goto L8;
        return r3;
    L8:
        r3 = r3 + 1;
        goto L2
    L9:
        return r4;
    }
}
