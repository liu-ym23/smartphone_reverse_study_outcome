package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f2945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f2947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f2948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f2949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2951g;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2952a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2953b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f2954m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f2955n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f2956o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f2957p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ a[] f2958q = null;

        static {
            a r8 = new a("ENQUEUED", 0);
            f2952a = r8;
            a r10 = new a("RUNNING", 1);
            f2953b = r10;
            a r11 = new a("SUCCEEDED", 2);
            f2954m = r11;
            a r12 = new a("FAILED", 3);
            f2955n = r12;
            a r13 = new a("BLOCKED", 4);
            f2956o = r13;
            a r14 = new a("CANCELLED", 5);
            f2957p = r14;
            f2958q = new a[]{r8, r10, r11, r12, r13, r14};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f2958q.clone();
        }

        public final boolean a() {
            if (this != f2954m) goto L5;
        L10:
            return true;
        L5:
            if (this == f2955n) goto L10;
            if (this == f2957p) goto L10;
            return false;
        }
    }

    public u(UUID r8, a r10, e r11, List<String> r12, e r13, int r14, int r15) {
        this.f2945a = r8;
        this.f2946b = r10;
        this.f2947c = r11;
        this.f2948d = new HashSet(r12);
        this.f2949e = r13;
        this.f2950f = r14;
        this.f2951g = r15;
    }

    public final UUID a() {
        return this.f2945a;
    }

    public final a b() {
        return this.f2946b;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L30:
        return false;
    L8:
        if (u.class != r8.getClass()) goto L30;
        u r10 = (u) r8;
        if (this.f2950f == r10.f2950f) goto L14;
        return false;
    L14:
        if (this.f2951g == r10.f2951g) goto L17;
        return false;
    L17:
        if (this.f2945a.equals(r10.f2945a) == true) goto L20;
        return false;
    L20:
        if (this.f2946b == r10.f2946b) goto L23;
        return false;
    L23:
        if (this.f2947c.equals(r10.f2947c) == true) goto L26;
        return false;
    L26:
        if (this.f2948d.equals(r10.f2948d) == true) goto L29;
        return false;
    L29:
        return this.f2949e.equals(r10.f2949e);
    }

    public final int hashCode() {
        int r8 = this.f2945a.hashCode() * 31;
        int r10 = (this.f2946b.hashCode() + r8) * 31;
        int r11 = (this.f2947c.hashCode() + r10) * 31;
        int r12 = (this.f2948d.hashCode() + r11) * 31;
        return ((((this.f2949e.hashCode() + r12) * 31) + this.f2950f) * 31) + this.f2951g;
    }

    public final String toString() {
        return "WorkInfo{mId='" + this.f2945a + "', mState=" + this.f2946b + ", mOutputData=" + this.f2947c + ", mTags=" + this.f2948d + ", mProgress=" + this.f2949e + '}';
    }
}
