package qa;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d2 {

    public static class a implements b2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10297c;

        public a(int r8, int r10, int r11) {
            this.f10295a = r8;
            this.f10296b = r10;
            this.f10297c = r11;
        }

        @Override // qa.b2
        public final long a() {
            return ((((long) this.f10295a) & QesdkUtils.LIMITS.UINT_32_UPPER) << 32) | (QesdkUtils.LIMITS.UINT_32_UPPER & ((long) this.f10296b));
        }

        @Override // qa.b2
        public final int b() {
            return this.f10297c;
        }
    }

    public static class b implements b2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10299b;

        public b(long r8, int r10) {
            this.f10298a = r8;
            this.f10299b = r10;
        }

        @Override // qa.b2
        public final long a() {
            return this.f10298a;
        }

        @Override // qa.b2
        public final int b() {
            return this.f10299b;
        }
    }

    public static synchronized void a(ArrayList r8) {
        monitor-enter(d2.class);
        if (r8 != null) goto L32;
    L30:
        monitor-exit(d2.class);
        return;
    L32:
    L27:
        th = move-exception;
        throw th;
    L6:
        if (r8.isEmpty() == true) goto L30;
        ArrayList r10 = new ArrayList(r8.size());     // Catch: Throwable -> L27
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L27
    L10:
        if (r11.hasNext() == false) goto L24;
        f2 r12 = (f2) r11.next();     // Catch: Throwable -> L27
        if ((r12 instanceof h2) == true) goto L13;
        if ((r12 instanceof i2) == true) goto L16;
        if ((r12 instanceof j2) == true) goto L19;
        if ((r12 instanceof g2) == false) goto L10;
        g2 r13 = (g2) r12;     // Catch: Throwable -> L27
        a r14 = new a(r13.f10447u, r13.f10448v, r13.f10404m);     // Catch: Throwable -> L27
    L23:
        r10.add(r14);     // Catch: Throwable -> L27
        goto L10
    L19:
        j2 r15 = (j2) r12;     // Catch: Throwable -> L27
        r14 = new a(r15.f10624t, r15.f10625u, r15.f10404m);     // Catch: Throwable -> L27
        goto L23
    L16:
        i2 r16 = (i2) r12;     // Catch: Throwable -> L27
        r14 = new a(r16.f10520t, r16.f10521u, r16.f10404m);     // Catch: Throwable -> L27
        goto L23
    L13:
        h2 r17 = (h2) r12;     // Catch: Throwable -> L27
        r14 = new a(r17.f10498t, r17.f10499u, r17.f10404m);     // Catch: Throwable -> L27
        goto L23
    L24:
        c2.a().c(r10);     // Catch: Throwable -> L27
        monitor-exit(d2.class);
    }
}
