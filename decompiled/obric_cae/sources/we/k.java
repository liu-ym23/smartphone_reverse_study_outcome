package we;

import com.obric.cae.statusReport.network.NetworkReportUtil;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f13212j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f13213k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f13214l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f13215m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f13221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f13224i;

    static {
        f13212j = Pattern.compile("(\\d{2,4})[^\\d]*");
        f13213k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f13214l = Pattern.compile("(\\d{1,2})[^\\d]*");
        f13215m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public k(String r8, String r10, long r11, String r12, String r13, boolean r14, boolean r15, boolean r16, boolean r17) {
        this.f13216a = r8;
        this.f13217b = r10;
        this.f13218c = r11;
        this.f13219d = r12;
        this.f13220e = r13;
        this.f13221f = r14;
        this.f13222g = r15;
        this.f13224i = r16;
        this.f13223h = r17;
    }

    public static int a(String r8, int r10, int r11, boolean r12) {
    L2:
        if (r10 >= r11) goto L30;
        char r13 = r8.charAt(r10);
        if (r13 >= ' ') goto L8;
        if (r13 == '\t') goto L8;
    L25:
        boolean r14 = true;
    L27:
        if (r14 == (!r12)) goto L28;
        r10 = r10 + 1;
        goto L2
    L28:
        return r10;
    L8:
        if (r13 >= 127) goto L25;
        if (r13 < '0') goto L14;
        if (r13 <= '9') goto L25;
    L14:
        if (r13 < 'a') goto L18;
        if (r13 <= 'z') goto L25;
    L18:
        if (r13 < 'A') goto L22;
        if (r13 <= 'Z') goto L25;
    L22:
        if (r13 == ':') goto L25;
        r14 = false;
        goto L27
    L30:
        return r11;
    }

    public static long b(int r14, String r15) {
        int r8 = a(r15, 0, r14, false);
        Pattern r10 = f13215m;
        Matcher r11 = r10.matcher(r15);
        int r12 = -1;
        int r13 = -1;
        int r16 = -1;
        int r17 = -1;
        int r18 = -1;
        int r19 = -1;
    L4:
        if (r8 >= r14) goto L24;
        int r110 = a(r15, r8 + 1, r14, true);
        r11.region(r8, r110);
        if (r13 == (-1)) goto L8;
    L10:
        if (r16 == (-1)) goto L12;
    L14:
        if (r17 != (-1)) goto L18;
        Pattern r20 = f13213k;
        if (r11.usePattern(r20).matches() == false) goto L18;
        r17 = r20.pattern().indexOf(r11.group(1).toLowerCase(Locale.US)) / 4;
    L22:
        r8 = a(r15, r110 + 1, r14, false);
    L18:
        if (r12 != (-1)) goto L22;
        if (r11.usePattern(f13212j).matches() == false) goto L22;
        r12 = Integer.parseInt(r11.group(1));
        goto L22
    L12:
        if (r11.usePattern(f13214l).matches() == false) goto L14;
        r16 = Integer.parseInt(r11.group(1));
        goto L22
    L8:
        if (r11.usePattern(r10).matches() == false) goto L10;
        r13 = Integer.parseInt(r11.group(1));
        r18 = Integer.parseInt(r11.group(2));
        r19 = Integer.parseInt(r11.group(3));
        goto L22
    L24:
        if (r12 >= 70) goto L26;
    L28:
        if (r12 < 0) goto L33;
        if (r12 > 69) goto L33;
        r12 = r12 + NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY;
    L33:
        if (r12 < 1601) goto L59;
        if (r17 == (-1)) goto L57;
        if (r16 < 1) goto L55;
        if (r16 > 31) goto L55;
        if (r13 < 0) goto L53;
        if (r13 > 23) goto L53;
        if (r18 < 0) goto L51;
        if (r18 > 59) goto L51;
        if (r19 < 0) goto L49;
        if (r19 > 59) goto L49;
        GregorianCalendar r111 = new GregorianCalendar(xe.c.f13893n);
        r111.setLenient(false);
        r111.set(1, r12);
        r111.set(2, r17 - 1);
        r111.set(5, r16);
        r111.set(11, r13);
        r111.set(12, r18);
        r111.set(13, r19);
        r111.set(14, 0);
        return r111.getTimeInMillis();
    L49:
        throw new IllegalArgumentException();
    L51:
        throw new IllegalArgumentException();
    L53:
        throw new IllegalArgumentException();
    L55:
        throw new IllegalArgumentException();
    L57:
        throw new IllegalArgumentException();
    L59:
        throw new IllegalArgumentException();
    L26:
        if (r12 > 99) goto L28;
        r12 = r12 + 1900;
        goto L28
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof k) == true) goto L5;
        return false;
    L5:
        k r10 = (k) r8;
        if (r10.f13216a.equals(this.f13216a) == true) goto L8;
        return false;
    L8:
        if (r10.f13217b.equals(this.f13217b) == true) goto L10;
        return false;
    L10:
        if (r10.f13219d.equals(this.f13219d) == true) goto L12;
        return false;
    L12:
        if (r10.f13220e.equals(this.f13220e) == true) goto L14;
        return false;
    L14:
        if (r10.f13218c == this.f13218c) goto L16;
        return false;
    L16:
        if (r10.f13221f == this.f13221f) goto L18;
        return false;
    L18:
        if (r10.f13222g == this.f13222g) goto L20;
        return false;
    L20:
        if (r10.f13223h == this.f13223h) goto L22;
        return false;
    L22:
        if (r10.f13224i != this.f13224i) goto L33;
        return true;
    L33:
        return false;
    }

    public final int hashCode() {
        int r8 = defpackage.a.b(this.f13216a, 527, 31);
        int r10 = defpackage.a.b(this.f13217b, r8, 31);
        int r11 = defpackage.a.b(this.f13219d, r10, 31);
        int r12 = defpackage.a.b(this.f13220e, r11, 31);
        long r13 = this.f13218c;
        return ((((((((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + (!this.f13221f ? 1 : 0)) * 31) + (!this.f13222g ? 1 : 0)) * 31) + (!this.f13223h ? 1 : 0)) * 31) + (!this.f13224i ? 1 : 0);
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(this.f13216a);
        r8.append('=');
        r8.append(this.f13217b);
        if (this.f13223h == false) goto L10;
        long r10 = this.f13218c;
        if (r10 != Long.MIN_VALUE) goto L7;
        String r11 = "; max-age=0";
    L8:
        r8.append(r11);
        goto L10
    L7:
        r8.append("; expires=");
        Date r12 = new Date(r10);
        r11 = af.d.f358a.get().format(r12);
    L10:
        if (this.f13224i == true) goto L12;
        r8.append("; domain=");
        r8.append(this.f13219d);
    L12:
        r8.append("; path=");
        r8.append(this.f13220e);
        if (this.f13221f == false) goto L16;
        r8.append("; secure");
    L16:
        if (this.f13222g == false) goto L19;
        r8.append("; httponly");
    L19:
        return r8.toString();
    }
}
