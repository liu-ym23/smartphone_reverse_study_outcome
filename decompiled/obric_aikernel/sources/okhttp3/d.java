package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f11688n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f11696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f11698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f11699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f11700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f11701m;

    @SourceDebugExtension({"SMAP\nCacheControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheControl.kt\nokhttp3/CacheControl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1#2:417\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f11706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f11707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11709h;

        public a() {
            this.f11704c = -1;
            this.f11705d = -1;
            this.f11706e = -1;
        }

        private final int b(long r10) {
            if (r10 <= 2147483647L) goto L6;
            return Integer.MAX_VALUE;
        L6:
            return (int) r10;
        }

        public final d a() {
            int r10 = -1;
            boolean r11 = false;
            boolean r12 = false;
            boolean r13 = false;
            return new d(this.f11702a, this.f11703b, this.f11704c, r10, r11, r12, r13, this.f11705d, this.f11706e, this.f11707f, this.f11708g, this.f11709h, null, null);
        }

        public final a c(int r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "timeUnit");
            if (r10 < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L10;
            this.f11705d = b(r11.toSeconds(r10));
            return this;
        L10:
            throw new IllegalArgumentException(("maxStale < 0: " + r10).toString());
        L5:
            r12 = false;
            goto L6
        }

        public final a d() {
            this.f11702a = true;
            return this;
        }

        public final a e() {
            this.f11707f = true;
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        private final int a(String r10, String r11, int r12) {
            int r13 = r10.length();
        L3:
            if (r12 >= r13) goto L9;
            if (StringsKt.contains$default(r11, r10.charAt(r12), false, 2, null) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r12;
        L9:
            return r10.length();
        }

        @JvmStatic
        public final d b(r r31) {
            r r10 = r31;
            Intrinsics.checkNotNullParameter(r10, "headers");
            int r11 = r31.size();
            boolean r12 = true;
            boolean r13 = true;
            int r14 = 0;
            String r15 = null;
            boolean r16 = false;
            boolean r17 = false;
            int r18 = -1;
            int r19 = -1;
            boolean r110 = false;
            boolean r111 = false;
            boolean r112 = false;
            int r113 = -1;
            int r114 = -1;
            boolean r115 = false;
            boolean r20 = false;
            boolean r21 = false;
        L3:
            if (r14 >= r11) goto L69;
            String r22 = r10.c(r14);
            String r23 = r10.i(r14);
            if (StringsKt.equals(r22, "Cache-Control", r12) == false) goto L10;
            if (r15 != null) goto L11;
            r15 = r23;
        L12:
            int r24 = 0;
        L14:
            if (r24 >= r23.length()) goto L68;
            int r25 = a(r23, "=,;", r24);
            String r26 = r23.substring(r24, r25);
            Intrinsics.checkNotNullExpressionValue(r26, "this as java.lang.String…ing(startIndex, endIndex)");
            String r27 = StringsKt.trim(r26).toString();
            if (r25 == r23.length()) goto L28;
            int r29 = r11;
            if (r23.charAt(r25) != ',') goto L20;
        L29:
            r24 = r25 + 1;
            String r28 = null;
        L30:
            r12 = true;
            if (StringsKt.equals("no-cache", r27, true) == false) goto L35;
            r16 = true;
        L33:
            r11 = r29;
            goto L14
        L35:
            if (StringsKt.equals("no-store", r27, true) == false) goto L38;
            r17 = true;
            goto L33
        L38:
            if (StringsKt.equals("max-age", r27, true) == false) goto L42;
            r18 = hc.e.W(r28, -1);
            goto L33
        L42:
            if (StringsKt.equals("s-maxage", r27, true) == false) goto L45;
            r19 = hc.e.W(r28, -1);
            goto L33
        L45:
            if (StringsKt.equals("private", r27, true) == false) goto L48;
            r110 = true;
            goto L33
        L48:
            if (StringsKt.equals("public", r27, true) == false) goto L51;
            r111 = true;
            goto L33
        L51:
            if (StringsKt.equals("must-revalidate", r27, true) == false) goto L54;
            r112 = true;
            goto L33
        L54:
            if (StringsKt.equals("max-stale", r27, true) == false) goto L57;
            r113 = hc.e.W(r28, Integer.MAX_VALUE);
            goto L33
        L57:
            if (StringsKt.equals("min-fresh", r27, true) == false) goto L60;
            r114 = hc.e.W(r28, -1);
            goto L33
        L60:
            if (StringsKt.equals("only-if-cached", r27, true) == false) goto L63;
            r115 = true;
            goto L33
        L63:
            if (StringsKt.equals("no-transform", r27, true) == false) goto L66;
            r20 = true;
            goto L33
        L66:
            if (StringsKt.equals("immutable", r27, true) == false) goto L33;
            r21 = true;
            goto L33
        L20:
            if (r23.charAt(r25) == ';') goto L29;
            int r30 = hc.e.D(r23, r25 + 1);
            if (r30 < r23.length()) goto L25;
        L27:
            r24 = a(r23, ",;", r30);
            String r32 = r23.substring(r30, r24);
            Intrinsics.checkNotNullExpressionValue(r32, "this as java.lang.String…ing(startIndex, endIndex)");
            r28 = StringsKt.trim(r32).toString();
            goto L30
        L25:
            if (r23.charAt(r30) != '\"') goto L27;
            int r33 = r30 + 1;
            int r34 = StringsKt.indexOf$default(r23, Typography.quote, r33, false, 4, null);
            r28 = r23.substring(r33, r34);
            Intrinsics.checkNotNullExpressionValue(r28, "this as java.lang.String…ing(startIndex, endIndex)");
            r24 = r34 + 1;
            goto L30
        L28:
            r29 = r11;
        L68:
            r14 = r14 + 1;
            r10 = r31;
            r11 = r11;
        L11:
            r13 = false;
            goto L12
        L10:
            if (StringsKt.equals(r22, "Pragma", r12) == false) goto L68;
        L69:
            if (r13 == true) goto L71;
            String r210 = null;
        L73:
            return new d(r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r210, null);
        L71:
            r210 = r15;
            goto L73
        }
    }

    static {
        f11688n = new b(null);
        new a().d().a();
        new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    }

    private d(boolean r10, boolean r11, int r12, int r13, boolean r14, boolean r15, boolean r16, int r17, int r18, boolean r19, boolean r110, boolean r111, String r112) {
        this.f11689a = r10;
        this.f11690b = r11;
        this.f11691c = r12;
        this.f11692d = r13;
        this.f11693e = r14;
        this.f11694f = r15;
        this.f11695g = r16;
        this.f11696h = r17;
        this.f11697i = r18;
        this.f11698j = r19;
        this.f11699k = r110;
        this.f11700l = r111;
        this.f11701m = r112;
    }

    public /* synthetic */ d(boolean r10, boolean r11, int r12, int r13, boolean r14, boolean r15, boolean r16, int r17, int r18, boolean r19, boolean r110, boolean r111, String r112, DefaultConstructorMarker r113) {
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    public final boolean a() {
        return this.f11693e;
    }

    public final boolean b() {
        return this.f11694f;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int c() {
        return this.f11691c;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int d() {
        return this.f11696h;
    }

    @JvmName(name = "minFreshSeconds")
    public final int e() {
        return this.f11697i;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean f() {
        return this.f11695g;
    }

    @JvmName(name = "noCache")
    public final boolean g() {
        return this.f11689a;
    }

    @JvmName(name = "noStore")
    public final boolean h() {
        return this.f11690b;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean i() {
        return this.f11698j;
    }

    public String toString() {
        String r10 = this.f11701m;
        if (r10 != null) goto L49;
        StringBuilder r11 = new StringBuilder();
        if (this.f11689a == false) goto L8;
        r11.append("no-cache, ");
    L8:
        if (this.f11690b == false) goto L11;
        r11.append("no-store, ");
    L11:
        if (this.f11691c == (-1)) goto L14;
        r11.append("max-age=");
        r11.append(this.f11691c);
        r11.append(", ");
    L14:
        if (this.f11692d == (-1)) goto L17;
        r11.append("s-maxage=");
        r11.append(this.f11692d);
        r11.append(", ");
    L17:
        if (this.f11693e == false) goto L20;
        r11.append("private, ");
    L20:
        if (this.f11694f == false) goto L23;
        r11.append("public, ");
    L23:
        if (this.f11695g == false) goto L26;
        r11.append("must-revalidate, ");
    L26:
        if (this.f11696h == (-1)) goto L29;
        r11.append("max-stale=");
        r11.append(this.f11696h);
        r11.append(", ");
    L29:
        if (this.f11697i == (-1)) goto L32;
        r11.append("min-fresh=");
        r11.append(this.f11697i);
        r11.append(", ");
    L32:
        if (this.f11698j == false) goto L35;
        r11.append("only-if-cached, ");
    L35:
        if (this.f11699k == false) goto L38;
        r11.append("no-transform, ");
    L38:
        if (this.f11700l == false) goto L41;
        r11.append("immutable, ");
    L41:
        if (r11.length() != 0) goto L43;
        boolean r12 = true;
    L44:
        if (r12 == false) goto L47;
        return "";
    L47:
        r11.delete(r11.length() - 2, r11.length());
        String r13 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        this.f11701m = r13;
        return r13;
    L43:
        r12 = false;
        goto L44
    L49:
        return r10;
    }
}
