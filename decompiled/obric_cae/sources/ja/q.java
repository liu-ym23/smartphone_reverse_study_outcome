package ja;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8782a = 0;

    static {
        String r8 = System.getProperty("java.version");
        int r10 = 0;
        String[] r11 = r8.split("[._]");     // Catch: NumberFormatException -> L9
        int r12 = Integer.parseInt(r11[0]);     // Catch: NumberFormatException -> L9
        if (r12 == 1) goto L6;
    L10:
        if (r12 == (-1)) goto L24;
    L20:
        if (r12 != (-1)) goto L22;
        r12 = 6;
    L22:
        f8782a = r12;
        return;
    L24:
        StringBuilder r13 = new StringBuilder();     // Catch: NumberFormatException -> L19
    L13:
        if (r10 >= r8.length()) goto L17;
        char r14 = r8.charAt(r10);     // Catch: NumberFormatException -> L19
        if (Character.isDigit(r14) == false) goto L17;
        r13.append(r14);     // Catch: NumberFormatException -> L19
        r10 = r10 + 1;     // Catch: NumberFormatException -> L19
    L17:
        r12 = Integer.parseInt(r13.toString());     // Catch: NumberFormatException -> L19
    L19:
        r12 = -1;
        goto L20
    L6:
        if (r11.length <= 1) goto L10;
        r12 = Integer.parseInt(r11[1]);     // Catch: NumberFormatException -> L9
    L9:
        r12 = -1;
        goto L10
    }
}
