package c7;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final HashSet f3371u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f3372v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f3373w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f3374x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f3375y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3377b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f3378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f3382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3385t;

    public static class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            SimpleDateFormat r8 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            r8.setTimeZone(TimeZone.getTimeZone("UTC"));
            return r8;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3390e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3391f;

        public b(String r8) {
            this.f3388c = 0;
            this.f3389d = false;
            this.f3390e = false;
            this.f3391f = false;
            this.f3386a = r8;
            this.f3387b = r8.toLowerCase(Locale.US);
        }

        public final int a(String r8) {
            int r10 = this.f3388c;
        L3:
            String r11 = this.f3386a;
            if (r10 >= r11.length()) goto L10;
            if (r8.indexOf(r11.charAt(r10)) != (-1)) goto L7;
            r10 = r10 + 1;
            goto L3
        L7:
            return r10;
        L10:
            return r11.length();
        }

        public final String b(boolean r8) {
            d();
            int r10 = a(",;= \t");
            if (r8 == false) goto L5;
            String r11 = this.f3387b;
        L6:
            int r12 = this.f3388c;
            if (r12 >= r10) goto L9;
            String r13 = r11.substring(r12, r10);
        L10:
            this.f3388c = r10;
            return r13;
        L9:
            r13 = null;
            goto L10
        L5:
            r11 = this.f3386a;
            goto L6
        }

        public final boolean c() {
            d();
            int r8 = this.f3388c;
            String r10 = this.f3386a;
            if (r8 < r10.length()) goto L5;
            return false;
        L5:
            if (r10.charAt(this.f3388c) != '=') goto L10;
            this.f3388c++;
            return true;
        L10:
            return false;
        }

        public final void d() {
        L2:
            int r8 = this.f3388c;
            String r10 = this.f3386a;
            if (r8 >= r10.length()) goto L8;
            if (" \t".indexOf(r10.charAt(this.f3388c)) == (-1)) goto L11;
            this.f3388c++;
            goto L2
        L11:
            return;
        }
    }

    static {
        HashSet r8 = new HashSet();
        f3371u = r8;
        r8.add("comment");
        r8.add("commenturl");
        r8.add("discard");
        r8.add("domain");
        r8.add("expires");
        r8.add("httponly");
        r8.add("max-age");
        r8.add("path");
        r8.add("port");
        r8.add(AIMediaEventSchema.FIELD_SECURE);
        r8.add("version");
        f3372v = null;
        f3373w = null;
        f3372v = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);     // Catch: PatternSyntaxException -> L6
        f3373w = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);     // Catch: PatternSyntaxException -> L6
    L4:
        f3374x = new a();
        f3375y = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public d(String r8, String r10) {
        this.f3379n = -1;
        boolean r11 = true;
        this.f3385t = 1;
        String r12 = r8.trim();
        boolean r13 = false;
        if (r12.length() != 0) goto L5;
    L9:
        r11 = false;
    L10:
        if (r11 == false) goto L28;
        int r14 = 0;
    L13:
        if (r14 >= r12.length()) goto L28;
        char r15 = r12.charAt(r14);
        if (r15 < 0) goto L29;
        if (r15 >= 127) goto L29;
        if (r15 == ';') goto L29;
        if (r15 == ',') goto L29;
        if (Character.isWhitespace(r15) == false) goto L27;
        if (r15 != ' ') goto L29;
    L27:
        r14 = r14 + 1;
    L29:
        if (r13 == false) goto L33;
        this.f3380o = r12;
        this.f3384s = r10;
        return;
    L33:
        throw new IllegalArgumentException("Invalid name: ".concat(r8));
    L28:
        r13 = r11;
        goto L29
    L5:
        if (r12.startsWith("$") == true) goto L9;
        if (f3371u.contains(r12.toLowerCase(Locale.US)) == true) goto L9;
        goto L9
    }

    public static void a(StringBuilder r8, String r10, String r11) {
        if (r11 == null) goto L5;
        r8.append(";$");
        r8.append(r10);
        r8.append("=\"");
        r8.append(r11);
        r8.append("\"");
        return;
    }

    public static boolean b(String r8, String r10) {
        if (r8 == null) goto L48;
        if (r10 == null) goto L52;
        Locale r11 = Locale.US;
        String r12 = r10.toLowerCase(r11);
        String r13 = r8.toLowerCase(r11);
        if (r12.equals(r13) == false) goto L22;
        if (c(0, r12) == false) goto L46;
    L20:
        return true;
    L46:
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        boolean r14 = false;
    L19:
        if (r14 == false) goto L22;
    L11:
        if (f3372v.matcher(r12).matches() == false) goto L13;
    L12:
        r14 = true;
        goto L19
    L13:
        if (f3373w.matcher(r12).matches() == false) goto L18;
    L22:
        if (c(0, r12) == true) goto L26;
        return r13.equals(".local");
    L26:
        if (r13.length() != (r12.length() + 1)) goto L35;
        if (r13.startsWith(".") == false) goto L35;
        if (r13.endsWith(r12) == false) goto L35;
        if (c(1, r13) == false) goto L35;
        return true;
    L35:
        if (r12.length() > r13.length()) goto L37;
        return false;
    L37:
        if (r12.endsWith(r13) == true) goto L39;
        return false;
    L39:
        if (r13.startsWith(".") == false) goto L43;
        if (c(1, r13) == false) goto L43;
    L45:
        return true;
    L43:
        if (r13.equals(".local") == true) goto L45;
        return false;
    L52:
        return false;
    L48:
        return false;
    }

    public static boolean c(int r8, String r10) {
        int r11 = r10.indexOf(46, r8 + 1);
        if (r11 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (r11 >= (r10.length() - 1)) goto L7;
        return true;
    }

    public static ArrayList d(String r15) {
        b r8 = new b(r15);
        ArrayList r16 = new ArrayList(2);
        String r10 = r8.f3387b;
        if (r10.startsWith("set-cookie2:") == false) goto L6;
        r8.f3388c += 12;
        r8.f3391f = true;
        int r11 = 0;
    L9:
        String r12 = r8.b(false);
        String r13 = r8.f3386a;
        if (r12 == null) goto L12;
        if (r8.c() == false) goto L120;
        if (r11 == 0) goto L21;
        String r14 = ";";
    L22:
        r8.d();
        int r17 = r8.a(r14);
        String r18 = r13.substring(r8.f3388c, r17);
        r8.f3388c = r17;
        d r19 = new d(r12, r18);
        r19.f3385t = r11 ^ 1;
        r16.add(r19);
    L23:
        r8.d();
        if (r8.f3388c == r13.length()) goto L30;
        if (r13.charAt(r8.f3388c) == ',') goto L28;
        if (r13.charAt(r8.f3388c) != ';') goto L38;
        r8.f3388c++;
    L38:
        String r20 = r8.b(true);
        if (r20 == null) goto L23;
        if (r11 == 0) goto L44;
    L49:
        String r110 = ";";
    L50:
        Date r111 = null;
        if (r8.c() == false) goto L53;
        r8.d();
        int r112 = r8.a(r110);
        String r113 = r13.substring(r8.f3388c, r112);
        r8.f3388c = r112;
    L55:
        if (r20.equals("comment") == false) goto L60;
        if (r19.f3376a != null) goto L60;
        r19.f3376a = r113;
    L60:
        if (r20.equals("commenturl") == false) goto L65;
        if (r19.f3377b != null) goto L65;
        r19.f3377b = r113;
    L65:
        if (r20.equals("discard") == true) goto L23;
        if (r20.equals("domain") == false) goto L73;
        if (r19.f3378m != null) goto L73;
        r19.f3378m = r113;
    L73:
        if (r20.equals("expires") == true) goto L74;
        if (r20.equals("max-age") == false) goto L96;
        if (r19.f3379n != (-1)) goto L96;
        long r21 = Long.parseLong(r113);     // Catch: NumberFormatException -> L93
        r8.f3390e = true;     // Catch: NumberFormatException -> L93
        r19.f3379n = r21;     // Catch: NumberFormatException -> L93
    L94:
        throw new IllegalArgumentException(defpackage.b.c("Invalid max-age: ", r113));
    L96:
        if (r20.equals("path") == false) goto L101;
        if (r19.f3381p != null) goto L101;
        r19.f3381p = r113;
    L101:
        if (r20.equals("port") == false) goto L109;
        if (r19.f3382q != null) goto L109;
        if (r113 != null) goto L107;
        r113 = "";
    L107:
        r19.f3382q = r113;
    L109:
        if (r20.equals(AIMediaEventSchema.FIELD_SECURE) == true) goto L110;
        if (r20.equals("httponly") == true) goto L23;
        if (r20.equals("version") == false) goto L23;
        if (r8.f3391f == true) goto L23;
        r19.f3385t = Integer.parseInt(r113);
        goto L23
    L110:
        r19.f3383r = true;
        goto L23
    L74:
        r8.f3389d = true;
        if (r19.f3379n != (-1)) goto L23;
        r111 = f3374x.get().parse(r113);     // Catch: ParseException -> L78
    L84:
        if (r111 != null) goto L85;
        r19.f3379n = 0;
        goto L23
    L85:
        r19.f3379n = (r111.getTime() - System.currentTimeMillis()) / 1000;
    L78:
        String[] r22 = f3375y;
        int r23 = r22.length;
        int r24 = 0;
    L79:
        if (r24 >= r23) goto L84;
        r111 = new SimpleDateFormat(r22[r24], Locale.US).parse(r113);     // Catch: ParseException -> L83
    L83:
        r24 = r24 + 1;
        goto L79
    L53:
        r113 = null;
        goto L55
    L44:
        if ("expires".equals(r20) == true) goto L49;
        if ("port".equals(r20) == true) goto L49;
        r110 = ";,";
        goto L50
    L28:
        r8.f3388c++;
    L30:
        if (r8.f3389d == true) goto L31;
        if (r8.f3390e == false) goto L9;
        r19.f3385t = 1;
        goto L9
    L31:
        r19.f3385t = 0;
        goto L9
    L21:
        r14 = ",;";
        goto L22
    L120:
        throw new IllegalArgumentException(defpackage.b.e("Expected '=' after ", r12, " in ", r13));
    L12:
        if (r16.isEmpty() == true) goto L15;
        return r16;
    L15:
        throw new IllegalArgumentException(defpackage.b.c("No cookies in ", r13));
    L6:
        if (r10.startsWith("set-cookie:") == false) goto L8;
        r8.f3388c += 11;
    L8:
        r11 = 1;
        goto L9
    }

    public static boolean e(d r8, URI r10) {
        String r11 = r8.f3382q;
        if (r11 != null) goto L6;
        return true;
    L6:
        List r12 = Arrays.asList(r11.split(","));
        String r13 = r10.getScheme();
        int r14 = r10.getPort();
        int r15 = h.f3404m;
        if (r14 != (-1)) goto L17;
        if ("http".equalsIgnoreCase(r13) == false) goto L13;
        r14 = 80;
        goto L17
    L13:
        if (LocationInfoConst.HTTPS.equalsIgnoreCase(r13) == false) goto L15;
        r14 = 443;
        goto L17
    L15:
        r14 = -1;
    L17:
        return r12.contains(Integer.toString(r14));
    }

    public final Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == false) goto L26;
        d r10 = (d) r8;
        if (this.f3380o.equalsIgnoreCase(r10.f3380o) == false) goto L25;
        String r11 = this.f3378m;
        if (r11 == null) goto L15;
        if (r11.equalsIgnoreCase(r10.f3378m) == false) goto L25;
    L16:
        String r12 = this.f3381p;
        String r13 = r10.f3381p;
        if (r12 != null) goto L21;
        if (r13 != null) goto L20;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L25;
        return true;
    L20:
        r14 = false;
        goto L22
    L21:
        r14 = r12.equals(r13);
        goto L22
    L15:
        if (r10.f3378m == null) goto L16;
    L25:
        return false;
    L26:
        return false;
    }

    public final int hashCode() {
        Locale r8 = Locale.US;
        int r10 = this.f3380o.toLowerCase(r8).hashCode();
        String r11 = this.f3378m;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = r10 + r13;
        String r15 = this.f3381p;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.toLowerCase(r8).hashCode();
        goto L6
    }

    public final String toString() {
        int r8 = this.f3385t;
        String r10 = this.f3384s;
        String r11 = this.f3380o;
        if (r8 == 0) goto L5;
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append("=\"");
        r12.append(r10);
        r12.append("\"");
        a(r12, "Path", this.f3381p);
        a(r12, "Domain", this.f3378m);
        a(r12, "Port", this.f3382q);
        return r12.toString();
    L5:
        return defpackage.a.f(r11, "=", r10);
    }
}
