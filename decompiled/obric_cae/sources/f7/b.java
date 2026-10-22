package f7;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f7338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f7339b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f7340c = null;

    static {
        f7338a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        f7339b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f7340c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r10) {
        if (r10 != null) goto L46;
        return false;
    L46:
        if (r10.length() >= 7) goto L8;
        return false;
    L8:
        if (r10.length() <= 15) goto L10;
        return false;
    L10:
        if (r10.equals("") == true) goto L51;
        if (f7338a.matcher(r10).matches() == true) goto L53;
        return false;
    L53:
        return true;
    L51:
        return false;
    L44:
        int r8 = r10.indexOf(46);     // Catch: Exception -> L43
        if (r8 != (-1)) goto L18;
        return false;
    L18:
        if (r10.charAt(0) != '-') goto L20;
        return false;
    L20:
        if (Integer.parseInt(r10.substring(0, r8)) > 255) goto L56;
        int r11 = r8 + 1;     // Catch: Exception -> L43
        int r12 = r10.indexOf(46, r11);     // Catch: Exception -> L43
        if (r12 != (-1)) goto L25;
        return false;
    L25:
        if (r10.charAt(r11) != '-') goto L27;
        return false;
    L27:
        if (Integer.parseInt(r10.substring(r11, r12)) > 255) goto L59;
        int r13 = r12 + 1;     // Catch: Exception -> L43
        int r14 = r10.indexOf(46, r13);     // Catch: Exception -> L43
        if (r14 != (-1)) goto L32;
        return false;
    L32:
        if (r10.charAt(r13) != '-') goto L34;
        return false;
    L34:
        if (Integer.parseInt(r10.substring(r13, r14)) > 255) goto L62;
        int r15 = r14 + 1;     // Catch: Exception -> L43
        if (r10.charAt(r15) != '-') goto L38;
        return false;
    L38:
        if (Integer.parseInt(r10.substring(r15, r10.length())) > 255) goto L64;
        if (r10.charAt(r10.length() - 1) != '.') goto L42;
        return false;
    L42:
        return true;
    L64:
        return false;
    L62:
        return false;
    L59:
        return false;
    L56:
        return false;
    L66:
        return false;
    }

    public static boolean b(String r8) {
        if (f7339b.matcher(r8).matches() == false) goto L5;
    L8:
        return true;
    L5:
        if (f7340c.matcher(r8).matches() == true) goto L8;
        return false;
    }
}
