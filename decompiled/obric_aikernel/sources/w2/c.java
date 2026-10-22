package w2;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f13301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f13302b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f13303c = null;

    static {
        f13301a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        f13302b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f13303c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r10) {
        return f13303c.matcher(r10).matches();
    L4:
        return false;
    }

    public static boolean b(String r10) {
        return f13302b.matcher(r10).matches();
    L4:
        return false;
    }

    public static boolean c(String r10) {
        if (r10 == null) goto L45;
        if (r10.length() < 7) goto L45;
        if (r10.length() > 15) goto L45;
        if (r10.equals("") == true) goto L45;
        if (f13301a.matcher(r10).matches() == false) goto L45;
        return true;
    L47:
        int r11 = r10.indexOf(46);     // Catch: Exception -> L46
        if (r11 == (-1)) goto L43;
        if (r10.charAt(0) == '-') goto L43;
        if (Integer.parseInt(r10.substring(0, r11)) > 255) goto L43;
        int r12 = r11 + 1;     // Catch: Exception -> L46
        int r13 = r10.indexOf(46, r12);     // Catch: Exception -> L46
        if (r13 == (-1)) goto L43;
        if (r10.charAt(r12) == '-') goto L43;
        if (Integer.parseInt(r10.substring(r12, r13)) > 255) goto L43;
        int r14 = r13 + 1;     // Catch: Exception -> L46
        int r15 = r10.indexOf(46, r14);     // Catch: Exception -> L46
        if (r15 == (-1)) goto L42;
        if (r10.charAt(r14) == '-') goto L42;
        if (Integer.parseInt(r10.substring(r14, r15)) > 255) goto L42;
        int r16 = r15 + 1;     // Catch: Exception -> L46
        if (r10.charAt(r16) == '-') goto L42;
        if (Integer.parseInt(r10.substring(r16, r10.length())) > 255) goto L42;
        if (r10.charAt(r10.length() - 1) == '.') goto L42;
        return true;
    L42:
        return false;
    L43:
        return false;
    L45:
        return false;
    }

    public static boolean d(String r10) {
        if (b(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r10) == true) goto L8;
        return false;
    }
}
