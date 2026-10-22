package y9;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(int[] r8) {
        int r10 = r8.length;
        int r11 = 0;
        boolean r12 = false;
        boolean r13 = false;
    L4:
        if (r11 >= r10) goto L18;
        int r14 = r8[r11];
        if (r14 != 16842910) goto L9;
        r12 = true;
    L17:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r14 != 16842908) goto L12;
    L10:
        r13 = true;
        goto L17
    L12:
        if (r14 == 16842919) goto L10;
        if (r14 != 16843623) goto L17;
    L18:
        if (r12 == false) goto L26;
        if (r13 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }
}
