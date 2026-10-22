package mq;

import ai.j0;
import androidx.core.util.Pools;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pools.SynchronizedPool f20156n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f20157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20159c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f20161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20165m;

    static {
        f20156n = new Pools.SynchronizedPool(5);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(Double.valueOf(this.f20157a), Double.valueOf(r11.f20157a)) == true) goto L12;
        return false;
    L12:
        if (this.f20158b == r11.f20158b) goto L15;
        return false;
    L15:
        if (this.f20159c == r11.f20159c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (this.f20160h == r11.f20160h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.f20161i), Double.valueOf(r11.f20161i)) == true) goto L36;
        return false;
    L36:
        if (this.f20162j == r11.f20162j) goto L39;
        return false;
    L39:
        if (this.f20163k == r11.f20163k) goto L42;
        return false;
    L42:
        if (this.f20164l == r11.f20164l) goto L45;
        return false;
    L45:
        if (this.f20165m == r11.f20165m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(Double.hashCode(this.f20157a) * 31, this.f20158b, 31);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f20159c, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.e, r11, 31);
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f, r12, 31);
        int r14 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.g, r13, 31);
        int r15 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f20160h, r14, 31);
        int r16 = (Double.hashCode(this.f20161i) + r15) * 31;
        int r17 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f20162j, r16, 31);
        int r18 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f20163k, r17, 31);
        int r19 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f20164l, r18, 31);
        return Integer.hashCode(this.f20165m) + r19;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("FpsBean(fps=");
        r5.append(this.f20157a);
        r5.append(", duration=");
        r5.append(this.f20158b);
        r5.append(", startX=");
        r5.append(this.f20159c);
        r5.append(", startY=");
        r5.append(this.d);
        r5.append(", endX=");
        r5.append(this.e);
        r5.append(", endY=");
        r5.append(this.f);
        r5.append(", distantX=");
        r5.append(this.g);
        r5.append(", distantY=");
        r5.append(this.f20160h);
        r5.append(", dropRate=");
        r5.append(this.f20161i);
        r5.append(", frameCount=");
        r5.append(this.f20162j);
        r5.append(", drop3=");
        r5.append(this.f20163k);
        r5.append(", drop7=");
        r5.append(this.f20164l);
        r5.append(", drop25=");
        return j0.n(r5, this.f20165m, ')');
    }
}
