package aj0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final boolean a(int r5, int r6) {
        if (r6 != 51) goto L14;
        if (r5 == 0) goto L19;
        if (r5 != 1) goto L7;
        return false;
    L7:
        if (r5 == 4) goto L21;
        if (r5 == 5) goto L22;
        if (r5 != 8) goto L11;
        return false;
    L11:
        if (r5 == 9) goto L24;
    L12:
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    L19:
        return false;
    L14:
        if (r6 != 67) goto L17;
        if (r5 > 8) goto L12;
        return false;
    L17:
        if (r5 > 5) goto L12;
        return false;
    }

    public static final boolean c(int r1) {
        if (r1 != 51) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 56) goto L14;
        if (r1 == 57) goto L14;
        if (r1 == 58) goto L14;
        if (r1 == 67) goto L14;
        return false;
    }

    public static final boolean b(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L13;
    L14:
        if (r2 != null) goto L17;
    L18:
        if (r2 != null) goto L21;
    L23:
        return false;
    L21:
        if (r2.intValue() != 39) goto L23;
    L24:
        return true;
    L17:
        if (r2.intValue() == 33) goto L24;
    L13:
        if (r2.intValue() == 32) goto L24;
    L9:
        if (r2.intValue() == 31) goto L24;
    L5:
        if (r2.intValue() == 17) goto L24;
        goto L6
    }
}
