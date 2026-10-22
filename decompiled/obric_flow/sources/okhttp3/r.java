package okhttp3;

import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f20726j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f20727k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f20728l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f20729m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20732c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f20734i;

    static {
        f20726j = Pattern.compile("(\\d{2,4})[^\\d]*");
        f20727k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f20728l = Pattern.compile("(\\d{1,2})[^\\d]*");
        f20729m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public r(String r5, String r10, long r11, String r12, String r13, boolean r14, boolean r15, boolean r16, boolean r17) {
        this.f20730a = r5;
        this.f20731b = r10;
        this.f20732c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f20733h = r16;
        this.f20734i = r17;
    }

    public final String a(boolean r10) {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f20730a);
        r5.append('=');
        r5.append(this.f20731b);
        if (this.f20733h == false) goto L9;
        long r11 = this.f20732c;
        if (r11 != Long.MIN_VALUE) goto L7;
        r5.append("; max-age=0");
        goto L9
    L7:
        r5.append("; expires=");
        r5.append(DatesKt.toHttpDateString(new Date(r11)));
    L9:
        if (this.f20734i == true) goto L14;
        r5.append("; domain=");
        if (r10 == false) goto L13;
        r5.append(".");
    L13:
        r5.append(this.d);
    L14:
        r5.append("; path=");
        r5.append(this.e);
        if (this.f == false) goto L18;
        r5.append("; secure");
    L18:
        if (this.g == false) goto L21;
        r5.append("; httponly");
    L21:
        return r5.toString();
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof r) == false) goto L23;
        r r10 = (r) r5;
        if (Intrinsics.areEqual(r10.f20730a, this.f20730a) == false) goto L23;
        if (Intrinsics.areEqual(r10.f20731b, this.f20731b) == false) goto L23;
        if (r10.f20732c != this.f20732c) goto L23;
        if (Intrinsics.areEqual(r10.d, this.d) == false) goto L23;
        if (Intrinsics.areEqual(r10.e, this.e) == false) goto L23;
        if (r10.f != this.f) goto L23;
        if (r10.g != this.g) goto L23;
        if (r10.f20733h != this.f20733h) goto L23;
        if (r10.f20734i != this.f20734i) goto L23;
        return true;
    L23:
        return false;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.constraintlayout.motion.widget.a.c(androidx.constraintlayout.motion.widget.a.c(527, 31, this.f20730a), 31, this.f20731b), this.f20732c, 31), 31, this.d), 31, this.e), 31, this.f), 31, this.g), 31, this.f20733h);
        return Boolean.hashCode(this.f20734i) + r5;
    }

    public final String toString() {
        return a(false);
    }
}
