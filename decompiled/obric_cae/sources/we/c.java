package we;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f13147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f13151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f13152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f13153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public String f13154m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13157c;

        public a() {
            this.f13156b = -1;
        }
    }

    static {
        a r8 = new a();
        r8.f13155a = true;
        new c(r8);
        a r10 = new a();
        r10.f13157c = true;
        int r11 = Integer.MAX_VALUE;
        long r12 = TimeUnit.SECONDS.toSeconds(Integer.MAX_VALUE);
        if (r12 > 2147483647L) goto L6;
        r11 = (int) r12;
    L6:
        r10.f13156b = r11;
        new c(r10);
    }

    public c(a r8) {
        this.f13142a = r8.f13155a;
        this.f13143b = false;
        this.f13144c = -1;
        this.f13145d = -1;
        this.f13146e = false;
        this.f13147f = false;
        this.f13148g = false;
        this.f13149h = r8.f13156b;
        this.f13150i = -1;
        this.f13151j = r8.f13157c;
        this.f13152k = false;
        this.f13153l = false;
    }

    public static c a(q r22) {
        q r8 = r22;
        int r10 = r8.f13238a.length / 2;
        int r11 = 0;
        boolean r12 = true;
        String r13 = null;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = -1;
        int r17 = -1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r110 = false;
        int r111 = -1;
        int r112 = -1;
        boolean r113 = false;
        boolean r114 = false;
        boolean r20 = false;
    L3:
        if (r11 >= r10) goto L75;
        String r21 = r8.e(r11);
        String r23 = r8.j(r11);
        if (r21.equalsIgnoreCase("Cache-Control") == false) goto L10;
        if (r13 != null) goto L11;
        r13 = r23;
    L12:
        int r24 = 0;
    L14:
        if (r24 >= r23.length()) goto L74;
        int r25 = af.e.e(r24, r23, "=,;");
        String r26 = r23.substring(r24, r25).trim();
        if (r25 != r23.length()) goto L18;
    L36:
        int r27 = r25 + 1;
        String r28 = null;
    L38:
        if ("no-cache".equalsIgnoreCase(r26) == false) goto L41;
        r14 = true;
    L73:
        r24 = r27;
        goto L14
    L41:
        if ("no-store".equalsIgnoreCase(r26) == false) goto L44;
        r15 = true;
        goto L73
    L44:
        if ("max-age".equalsIgnoreCase(r26) == false) goto L47;
        r16 = af.e.c(-1, r28);
        goto L73
    L47:
        if ("s-maxage".equalsIgnoreCase(r26) == false) goto L50;
        r17 = af.e.c(-1, r28);
        goto L73
    L50:
        if ("private".equalsIgnoreCase(r26) == false) goto L53;
        r18 = true;
        goto L73
    L53:
        if ("public".equalsIgnoreCase(r26) == false) goto L56;
        r19 = true;
        goto L73
    L56:
        if ("must-revalidate".equalsIgnoreCase(r26) == false) goto L59;
        r110 = true;
        goto L73
    L59:
        if ("max-stale".equalsIgnoreCase(r26) == false) goto L62;
        r111 = af.e.c(Integer.MAX_VALUE, r28);
        goto L73
    L62:
        if ("min-fresh".equalsIgnoreCase(r26) == false) goto L65;
        r112 = af.e.c(-1, r28);
        goto L73
    L65:
        if ("only-if-cached".equalsIgnoreCase(r26) == false) goto L68;
        r113 = true;
        goto L73
    L68:
        if ("no-transform".equalsIgnoreCase(r26) == false) goto L71;
        r114 = true;
        goto L73
    L71:
        if ("immutable".equalsIgnoreCase(r26) == false) goto L73;
        r20 = true;
        goto L73
    L18:
        if (r23.charAt(r25) == ',') goto L36;
        if (r23.charAt(r25) == ';') goto L36;
    L29:
        r25 = r25 + 1;
        if (r25 >= r23.length()) goto L31;
        char r29 = r23.charAt(r25);
        if (r29 == ' ') goto L29;
        if (r29 == '\t') goto L29;
    L31:
        if (r25 < r23.length()) goto L33;
    L35:
        r27 = af.e.e(r25, r23, ",;");
        r28 = r23.substring(r25, r27).trim();
        goto L38
    L33:
        if (r23.charAt(r25) != '\"') goto L35;
        int r30 = r25 + 1;
        int r31 = af.e.e(r30, r23, "\"");
        r28 = r23.substring(r30, r31);
        r27 = r31 + 1;
    L74:
        r11 = r11 + 1;
        r8 = r22;
    L11:
        r12 = false;
        goto L12
    L10:
        if (r21.equalsIgnoreCase("Pragma") == false) goto L74;
    L75:
        if (r12 == true) goto L77;
        String r210 = null;
    L79:
        return new c(r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r210);
    L77:
        r210 = r13;
        goto L79
    }

    public final String toString() {
        String r8 = this.f13154m;
        if (r8 != null) goto L46;
        StringBuilder r10 = new StringBuilder();
        if (this.f13142a == false) goto L9;
        r10.append("no-cache, ");
    L9:
        if (this.f13143b == false) goto L11;
        r10.append("no-store, ");
    L11:
        int r11 = this.f13144c;
        if (r11 == (-1)) goto L14;
        r10.append("max-age=");
        r10.append(r11);
        r10.append(", ");
    L14:
        int r12 = this.f13145d;
        if (r12 == (-1)) goto L18;
        r10.append("s-maxage=");
        r10.append(r12);
        r10.append(", ");
    L18:
        if (this.f13146e == false) goto L21;
        r10.append("private, ");
    L21:
        if (this.f13147f == false) goto L24;
        r10.append("public, ");
    L24:
        if (this.f13148g == false) goto L26;
        r10.append("must-revalidate, ");
    L26:
        int r13 = this.f13149h;
        if (r13 == (-1)) goto L29;
        r10.append("max-stale=");
        r10.append(r13);
        r10.append(", ");
    L29:
        int r14 = this.f13150i;
        if (r14 == (-1)) goto L33;
        r10.append("min-fresh=");
        r10.append(r14);
        r10.append(", ");
    L33:
        if (this.f13151j == false) goto L36;
        r10.append("only-if-cached, ");
    L36:
        if (this.f13152k == false) goto L39;
        r10.append("no-transform, ");
    L39:
        if (this.f13153l == false) goto L42;
        r10.append("immutable, ");
    L42:
        if (r10.length() != 0) goto L44;
        r8 = "";
    L45:
        this.f13154m = r8;
        goto L46
    L44:
        r10.delete(r10.length() - 2, r10.length());
        r8 = r10.toString();
    L46:
        return r8;
    }

    public c(boolean r8, boolean r10, int r11, int r12, boolean r13, boolean r14, boolean r15, int r16, int r17, boolean r18, boolean r19, boolean r110, @Nullable String r111) {
        this.f13142a = r8;
        this.f13143b = r10;
        this.f13144c = r11;
        this.f13145d = r12;
        this.f13146e = r13;
        this.f13147f = r14;
        this.f13148g = r15;
        this.f13149h = r16;
        this.f13150i = r17;
        this.f13151j = r18;
        this.f13152k = r19;
        this.f13153l = r110;
        this.f13154m = r111;
    }
}
