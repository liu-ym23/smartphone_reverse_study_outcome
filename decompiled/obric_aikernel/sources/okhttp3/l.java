package okhttp3;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f11996j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f11997k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f11998l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f11999m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f12000n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f12007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f12008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f12009i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final int a(String r10, int r11, int r12, boolean r13) {
        L2:
            if (r11 >= r12) goto L35;
            char r14 = r10.charAt(r11);
            boolean r15 = false;
            if (r14 >= ' ') goto L8;
            if (r14 == '\t') goto L8;
        L30:
            r15 = true;
        L32:
            if (r15 == (!r13)) goto L33;
            r11 = r11 + 1;
            goto L2
        L33:
            return r11;
        L8:
            if (r14 >= 127) goto L30;
            if ('0' > r14) goto L13;
            if (r14 >= ':') goto L13;
            boolean r16 = true;
        L14:
            if (r16 == true) goto L30;
            if ('a' <= r14) goto L18;
        L20:
            boolean r17 = false;
        L21:
            if (r17 == true) goto L30;
            if ('A' <= r14) goto L25;
        L27:
            boolean r18 = false;
        L28:
            if (r18 == true) goto L30;
            if (r14 != ':') goto L32;
        L25:
            if (r14 >= '[') goto L27;
            r18 = true;
            goto L28
        L18:
            if (r14 >= '{') goto L20;
            r17 = true;
        L13:
            r16 = false;
            goto L14
        L35:
            return r12;
        }

        private final boolean b(String r10, String r11) {
            if (Intrinsics.areEqual(r10, r11) == false) goto L6;
            return true;
        L6:
            if (StringsKt.endsWith$default(r10, r11, false, 2, null) == false) goto L13;
            if (r10.charAt((r10.length() - r11.length()) - 1) != '.') goto L13;
            if (hc.e.i(r10) == true) goto L13;
            return true;
        L13:
            return false;
        }

        private final String f(String r10) {
            if ((!StringsKt.endsWith$default(r10, ".", false, 2, null)) == false) goto L10;
            String r11 = hc.a.e(StringsKt.removePrefix(r10, "."));
            if (r11 == null) goto L8;
            return r11;
        L8:
            throw new IllegalArgumentException();
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long g(String r23, int r24, int r25) {
            int r10 = a(r23, r24, r25, false);
            Matcher r11 = l.c().matcher(r23);
            int r12 = -1;
            int r13 = -1;
            int r14 = -1;
            int r15 = -1;
            int r16 = -1;
            int r17 = -1;
        L4:
            if (r10 >= r25) goto L24;
            int r18 = a(r23, r10 + 1, r25, true);
            r11.region(r10, r18);
            if (r13 == (-1)) goto L8;
        L10:
            if (r14 == (-1)) goto L12;
        L14:
            if (r15 == (-1)) goto L16;
        L18:
            if (r12 != (-1)) goto L22;
            if (r11.usePattern(l.d()).matches() == false) goto L22;
            String r19 = r11.group(1);
            Intrinsics.checkNotNullExpressionValue(r19, "matcher.group(1)");
            r12 = Integer.parseInt(r19);
        L22:
            r10 = a(r23, r18 + 1, r25, false);
            goto L4
        L16:
            if (r11.usePattern(l.b()).matches() == false) goto L18;
            String r20 = r11.group(1);
            Intrinsics.checkNotNullExpressionValue(r20, "matcher.group(1)");
            Locale r21 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r21, "US");
            String r22 = r20.toLowerCase(r21);
            Intrinsics.checkNotNullExpressionValue(r22, "this as java.lang.String).toLowerCase(locale)");
            String r26 = l.b().pattern();
            Intrinsics.checkNotNullExpressionValue(r26, "MONTH_PATTERN.pattern()");
            r15 = StringsKt.indexOf$default(r26, r22, 0, false, 6, null) / 4;
            goto L22
        L12:
            if (r11.usePattern(l.a()).matches() == false) goto L14;
            String r27 = r11.group(1);
            Intrinsics.checkNotNullExpressionValue(r27, "matcher.group(1)");
            r14 = Integer.parseInt(r27);
            goto L22
        L8:
            if (r11.usePattern(l.c()).matches() == false) goto L10;
            String r28 = r11.group(1);
            Intrinsics.checkNotNullExpressionValue(r28, "matcher.group(1)");
            r13 = Integer.parseInt(r28);
            String r29 = r11.group(2);
            Intrinsics.checkNotNullExpressionValue(r29, "matcher.group(2)");
            r16 = Integer.parseInt(r29);
            String r30 = r11.group(3);
            Intrinsics.checkNotNullExpressionValue(r30, "matcher.group(3)");
            r17 = Integer.parseInt(r30);
            goto L22
        L24:
            if (70 <= r12) goto L26;
        L28:
            boolean r31 = false;
        L29:
            if (r31 == false) goto L31;
            r12 = r12 + 1900;
        L31:
            if (r12 < 0) goto L34;
            if (r12 >= 70) goto L34;
            boolean r32 = true;
        L35:
            if (r32 == false) goto L38;
            r12 = r12 + 2000;
        L38:
            if (r12 < 1601) goto L40;
            boolean r33 = true;
        L42:
            if (r33 == false) goto L83;
            if (r15 == (-1)) goto L45;
            boolean r34 = true;
        L46:
            if (r34 == false) goto L81;
            if (1 <= r14) goto L49;
        L51:
            boolean r35 = false;
        L52:
            if (r35 == false) goto L79;
            if (r13 >= 0) goto L55;
        L57:
            boolean r36 = false;
        L58:
            if (r36 == false) goto L77;
            if (r16 < 0) goto L63;
            if (r16 >= 60) goto L63;
            boolean r37 = true;
        L64:
            if (r37 == false) goto L75;
            if (r17 < 0) goto L68;
            if (r17 >= 60) goto L68;
            boolean r38 = true;
        L69:
            if (r38 == false) goto L73;
            GregorianCalendar r39 = new GregorianCalendar(hc.e.f9281e);
            r39.setLenient(false);
            r39.set(1, r12);
            r39.set(2, r15 - 1);
            r39.set(5, r14);
            r39.set(11, r13);
            r39.set(12, r16);
            r39.set(13, r17);
            r39.set(14, 0);
            return r39.getTimeInMillis();
        L73:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L68:
            r38 = false;
            goto L69
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L63:
            r37 = false;
            goto L64
        L77:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L55:
            if (r13 >= 24) goto L57;
            r36 = true;
            goto L58
        L79:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L49:
            if (r14 >= 32) goto L51;
            r35 = true;
            goto L52
        L81:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L45:
            r34 = false;
            goto L46
        L83:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L40:
            r33 = false;
        L34:
            r32 = false;
            goto L35
        L26:
            if (r12 >= 100) goto L28;
            r31 = true;
            goto L29
        }

        private final long h(String r10) {
            long r11 = Long.parseLong(r10);     // Catch: NumberFormatException -> L9
            if (r11 > 0) goto L8;
            return Long.MIN_VALUE;
        L8:
            return r11;
        L9:
            e = move-exception;
            if (new Regex("-?\\d+").matches(r10) == true) goto L13;
            throw e;
        L13:
            if (StringsKt.startsWith$default(r10, "-", false, 2, null) == true) goto L21;
            return Long.MAX_VALUE;
        L21:
            return Long.MIN_VALUE;
        }

        @JvmStatic
        public final l c(s r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r11, "setCookie");
            return d(System.currentTimeMillis(), r10, r11);
        }

        public final l d(long r26, s r28, String r29) {
            Intrinsics.checkNotNullParameter(r28, "url");
            Intrinsics.checkNotNullParameter(r29, "setCookie");
            int r10 = hc.e.r(r29, ';', 0, 0, 6, null);
            int r11 = hc.e.r(r29, '=', 0, r10, 2, null);
            if (r11 != r10) goto L5;
            return null;
        L5:
            String r12 = hc.e.Y(r29, 0, r11, 1, null);
            if (r12.length() != 0) goto L8;
            boolean r13 = true;
        L9:
            if (r13 == true) goto L87;
            if (hc.e.y(r12) != (-1)) goto L87;
            String r14 = hc.e.X(r29, r11 + 1, r10);
            if (hc.e.y(r14) == (-1)) goto L16;
            return null;
        L16:
            int r15 = r10 + 1;
            int r16 = r29.length();
            String r17 = null;
            String r22 = null;
            boolean r18 = false;
            boolean r19 = false;
            boolean r110 = false;
            boolean r20 = true;
            long r111 = -1;
            long r23 = 253402300799999L;
        L17:
            if (r15 >= r16) goto L44;
            int r21 = hc.e.p(r29, ';', r15, r16);
            int r112 = hc.e.p(r29, '=', r15, r21);
            String r24 = hc.e.X(r29, r15, r112);
            if (r112 >= r21) goto L21;
            String r113 = hc.e.X(r29, r112 + 1, r21);
        L23:
            if (StringsKt.equals(r24, "expires", true) == false) goto L27;
            r23 = g(r113, 0, r113.length());     // Catch: Throwable -> L88
        L29:
            r110 = true;
        L43:
            r15 = r21 + 1;
            goto L17
        L27:
            if (StringsKt.equals(r24, "max-age", true) == false) goto L31;
            r111 = h(r113);
            goto L29
        L31:
            if (StringsKt.equals(r24, "domain", true) == false) goto L35;
            r17 = f(r113);     // Catch: Throwable -> L88
            r20 = false;
            goto L43
        L35:
            if (StringsKt.equals(r24, "path", true) == false) goto L38;
            r22 = r113;
            goto L43
        L38:
            if (StringsKt.equals(r24, "secure", true) == false) goto L41;
            r18 = true;
            goto L43
        L41:
            if (StringsKt.equals(r24, "httponly", true) == false) goto L43;
            r19 = true;
            goto L43
        L21:
            r113 = "";
            goto L23
        L44:
            long r25 = Long.MIN_VALUE;
            if (r111 != Long.MIN_VALUE) goto L48;
        L46:
            long r114 = r25;
        L61:
            String r27 = r28.h();
            if (r17 != null) goto L65;
            String r115 = r27;
            l r30 = null;
        L70:
            if (r27.length() != r115.length()) goto L72;
        L74:
            String r31 = "/";
            String r32 = r22;
            if (r32 != null) goto L77;
        L80:
            String r33 = r28.d();
            int r34 = StringsKt.lastIndexOf$default(r33, '/', 0, false, 6, null);
            if (r34 == 0) goto L83;
            r31 = r33.substring(0, r34);
            Intrinsics.checkNotNullExpressionValue(r31, "this as java.lang.String…ing(startIndex, endIndex)");
        L83:
            String r116 = r31;
        L85:
            return new l(r12, r14, r114, r115, r116, r18, r19, r110, r20, null);
        L77:
            if (StringsKt.startsWith$default(r32, "/", false, 2, r30) == false) goto L80;
            r116 = r32;
            goto L85
        L72:
            if (pc.a.f12377e.c().c(r115) != null) goto L74;
            return r30;
        L65:
            if (b(r27, r17) == true) goto L68;
            return null;
        L68:
            r30 = null;
            r115 = r17;
            goto L70
        L48:
            if (r111 != (-1)) goto L50;
            r114 = r23;
            goto L61
        L50:
            if (r111 > 9223372036854775L) goto L52;
            long r117 = r111 * ((long) 1000);
        L53:
            r25 = r26 + r117;
            if (r25 < r26) goto L58;
            long r35 = 253402300799999L;
            if (r25 <= 253402300799999L) goto L46;
        L59:
            r114 = r35;
            goto L61
        L58:
            r35 = 253402300799999L;
            goto L59
        L52:
            r117 = Long.MAX_VALUE;
        L87:
            return null;
        L8:
            r13 = false;
            goto L9
        }

        @JvmStatic
        public final List<l> e(s r10, r r11) {
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r11, "headers");
            List<String> r12 = r11.j(Api.KEY_SET_COOKIE);
            int r13 = r12.size();
            ArrayList r14 = null;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L11;
            l r16 = c(r10, r12.get(r15));
            if (r16 == null) goto L10;
            if (r14 != null) goto L9;
            r14 = new ArrayList();
        L9:
            r14.add(r16);
        L10:
            r15 = r15 + 1;
            goto L3
        L11:
            if (r14 == null) goto L14;
            List<l> r17 = Collections.unmodifiableList(r14);
            Intrinsics.checkNotNullExpressionValue(r17, "{\n        Collections.un…ableList(cookies)\n      }");
            return r17;
        L14:
            return CollectionsKt.emptyList();
        }
    }

    static {
        f11996j = new a(null);
        f11997k = Pattern.compile("(\\d{2,4})[^\\d]*");
        f11998l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f11999m = Pattern.compile("(\\d{1,2})[^\\d]*");
        f12000n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private l(String r10, String r11, long r12, String r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        this.f12001a = r10;
        this.f12002b = r11;
        this.f12003c = r12;
        this.f12004d = r13;
        this.f12005e = r14;
        this.f12006f = r15;
        this.f12007g = r16;
        this.f12008h = r17;
        this.f12009i = r18;
    }

    public /* synthetic */ l(String r10, String r11, long r12, String r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, DefaultConstructorMarker r19) {
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static final /* synthetic */ Pattern a() {
        return f11999m;
    }

    public static final /* synthetic */ Pattern b() {
        return f11998l;
    }

    public static final /* synthetic */ Pattern c() {
        return f12000n;
    }

    public static final /* synthetic */ Pattern d() {
        return f11997k;
    }

    @JvmName(name = ActivityLifecycle.NAME)
    public final String e() {
        return this.f12001a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof l) == false) goto L23;
        l r11 = (l) r10;
        if (Intrinsics.areEqual(r11.f12001a, this.f12001a) == false) goto L23;
        if (Intrinsics.areEqual(r11.f12002b, this.f12002b) == false) goto L23;
        if (r11.f12003c != this.f12003c) goto L23;
        if (Intrinsics.areEqual(r11.f12004d, this.f12004d) == false) goto L23;
        if (Intrinsics.areEqual(r11.f12005e, this.f12005e) == false) goto L23;
        if (r11.f12006f != this.f12006f) goto L23;
        if (r11.f12007g != this.f12007g) goto L23;
        if (r11.f12008h != this.f12008h) goto L23;
        if (r11.f12009i != this.f12009i) goto L23;
        return true;
    L23:
        return false;
    }

    public final String f(boolean r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(this.f12001a);
        r11.append('=');
        r11.append(this.f12002b);
        if (this.f12008h == false) goto L10;
        if (this.f12003c != Long.MIN_VALUE) goto L7;
        String r12 = "; max-age=0";
    L8:
        r11.append(r12);
        goto L10
    L7:
        r11.append("; expires=");
        r12 = kc.c.b(new Date(this.f12003c));
    L10:
        if (this.f12009i == true) goto L15;
        r11.append("; domain=");
        if (r10 == false) goto L14;
        r11.append(".");
    L14:
        r11.append(this.f12004d);
    L15:
        r11.append("; path=");
        r11.append(this.f12005e);
        if (this.f12006f == false) goto L19;
        r11.append("; secure");
    L19:
        if (this.f12007g == false) goto L21;
        r11.append("; httponly");
    L21:
        String r13 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString()");
        return r13;
    }

    @JvmName(name = EventBody.KEY_VALUE)
    public final String g() {
        return this.f12002b;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f12001a.hashCode()) * 31) + this.f12002b.hashCode()) * 31) + Long.hashCode(this.f12003c)) * 31) + this.f12004d.hashCode()) * 31) + this.f12005e.hashCode()) * 31) + Boolean.hashCode(this.f12006f)) * 31) + Boolean.hashCode(this.f12007g)) * 31) + Boolean.hashCode(this.f12008h)) * 31) + Boolean.hashCode(this.f12009i);
    }

    public String toString() {
        return f(false);
    }
}
