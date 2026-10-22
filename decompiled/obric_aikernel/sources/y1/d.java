package y1;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    static String a(int r10) {
        if (r10 >= 1000) goto L5;
    L20:
        StringBuilder r11 = new StringBuilder();
        r11.append("Code must be in range [1000,5000): ");
        r11.append(r10);
    L17:
        return r11.toString();
    L5:
        if (r10 >= 5000) goto L20;
        if (r10 < 1004) goto L12;
        if (r10 > 1006) goto L12;
    L15:
        r11 = new StringBuilder();
        r11.append("Code ");
        r11.append(r10);
        r11.append(" is reserved and may not be used.");
    L12:
        if (r10 >= 1012) goto L14;
        return null;
    L14:
        if (r10 <= 2999) goto L15;
        return null;
    }

    static void b(int r10) {
        String r11 = a(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r11);
    }
}
