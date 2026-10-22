package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final h f20647n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20650c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f20652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f20654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f20655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f20656m;

    static {
        TimeUnit r5 = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(r5, "timeUnit");
        int r10 = Integer.MAX_VALUE;
        long r11 = Integer.MAX_VALUE;
        long r12 = r5.toSeconds(r11);
        if (r12 > r11) goto L6;
        r10 = (int) r12;
    L6:
        f20647n = new h(false, false, -1, -1, false, false, false, r10, -1, true, false, false, null);
    }

    public h(boolean r5, boolean r10, int r11, int r12, boolean r13, boolean r14, boolean r15, int r16, int r17, boolean r18, boolean r19, boolean r110, String r111) {
        this.f20648a = r5;
        this.f20649b = r10;
        this.f20650c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f20651h = r16;
        this.f20652i = r17;
        this.f20653j = r18;
        this.f20654k = r19;
        this.f20655l = r110;
        this.f20656m = r111;
    }

    public final String toString() {
        String r5 = this.f20656m;
        if (r5 != null) goto L46;
        StringBuilder r10 = new StringBuilder();
        if (this.f20648a == false) goto L8;
        r10.append("no-cache, ");
    L8:
        if (this.f20649b == false) goto L10;
        r10.append("no-store, ");
    L10:
        int r11 = this.f20650c;
        if (r11 == (-1)) goto L13;
        r10.append("max-age=");
        r10.append(r11);
        r10.append(", ");
    L13:
        int r12 = this.d;
        if (r12 == (-1)) goto L17;
        r10.append("s-maxage=");
        r10.append(r12);
        r10.append(", ");
    L17:
        if (this.e == false) goto L20;
        r10.append("private, ");
    L20:
        if (this.f == false) goto L23;
        r10.append("public, ");
    L23:
        if (this.g == false) goto L25;
        r10.append("must-revalidate, ");
    L25:
        int r13 = this.f20651h;
        if (r13 == (-1)) goto L28;
        r10.append("max-stale=");
        r10.append(r13);
        r10.append(", ");
    L28:
        int r14 = this.f20652i;
        if (r14 == (-1)) goto L32;
        r10.append("min-fresh=");
        r10.append(r14);
        r10.append(", ");
    L32:
        if (this.f20653j == false) goto L35;
        r10.append("only-if-cached, ");
    L35:
        if (this.f20654k == false) goto L38;
        r10.append("no-transform, ");
    L38:
        if (this.f20655l == false) goto L41;
        r10.append("immutable, ");
    L41:
        if (r10.length() != 0) goto L44;
        return "";
    L44:
        r10.delete(r10.length() - 2, r10.length());
        String r15 = r10.toString();
        this.f20656m = r15;
        return r15;
    L46:
        return r5;
    }
}
