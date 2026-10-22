package u7b;

import x7b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static boolean a(char r0) {
        switch(r0) {
            case 33: goto L8;
            case 34: goto L8;
            case 35: goto L8;
            case 36: goto L8;
            case 37: goto L8;
            case 38: goto L8;
            case 39: goto L8;
            case 40: goto L8;
            case 41: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 44: goto L8;
            case 45: goto L8;
            case 46: goto L8;
            case 47: goto L8;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 58: goto L10;
            case 59: goto L10;
            case 60: goto L10;
            case 61: goto L10;
            case 62: goto L10;
            case 63: goto L10;
            case 64: goto L10;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 91: goto L11;
            case 92: goto L11;
            case 93: goto L11;
            case 94: goto L11;
            case 95: goto L11;
            case 96: goto L11;
            default: goto L5;
        };
    L5:
        switch(r0) {
            case 123: goto L12;
            case 124: goto L12;
            case 125: goto L12;
            case 126: goto L12;
            default: goto L6;
        };
    L6:
        return false;
    L12:
        return true;
    L11:
        return true;
    L10:
        return true;
    L8:
        return true;
    }

    public static boolean b(e r8) {
        if (r8.d() == true) goto L6;
        return false;
    L6:
        if (r8.h('<') == true) goto L8;
        int r0 = 0;
        boolean r2 = true;
    L24:
        if (r8.d() == false) goto L48;
        char r5 = r8.j();
        if (r5 == ' ') goto L71;
        if (r5 != '\\') goto L29;
        r8.g();
        if (a(r8.j()) == false) goto L46;
        r8.g();
    L46:
        r2 = false;
        goto L24
    L29:
        if (r5 != '(') goto L31;
        r0 = r0 + 1;
        if (r0 > 32) goto L72;
        r8.g();
        goto L46
    L72:
        return false;
    L31:
        if (r5 != ')') goto L33;
        if (r0 == 0) goto L48;
        r0 = r0 - 1;
        r8.g();
        goto L46
    L33:
        if (Character.isISOControl(r5) == true) goto L71;
        r8.g();
    L71:
        return !r2;
    L48:
        return true;
    L8:
        if (r8.d() == false) goto L21;
        char r3 = r8.j();
        if (r3 == '\n') goto L21;
        if (r3 == '<') goto L21;
        if (r3 == '>') goto L19;
        if (r3 != '\\') goto L15;
        r8.g();
        if (a(r8.j()) == false) goto L8;
        r8.g();
        goto L8
    L15:
        r8.g();
        goto L8
    L19:
        r8.g();
        return true;
    L21:
        return false;
    }

    public static boolean c(e r2) {
    L3:
        if (r2.d() == false) goto L13;
        switch(r2.j()) {
            case 91: goto L11;
            case 92: goto L8;
            case 93: goto L7;
            default: goto L6;
        };
    L7:
        return true;
    L8:
        r2.g();
        if (a(r2.j()) == false) goto L3;
        r2.g();
        goto L3
    L11:
        return false;
    L6:
        r2.g();
        goto L3
    L13:
        return true;
    }

    public static boolean d(e r3, char r4) {
    L3:
        if (r3.d() == false) goto L18;
        char r0 = r3.j();
        if (r0 == '\\') goto L6;
        if (r0 == r4) goto L10;
        if (r4 == ')') goto L14;
    L17:
        r3.g();
        goto L3
    L14:
        if (r0 != '(') goto L17;
        return false;
    L10:
        return true;
    L6:
        r3.g();
        if (a(r3.j()) == false) goto L3;
        r3.g();
        goto L3
    L18:
        return true;
    }
}
