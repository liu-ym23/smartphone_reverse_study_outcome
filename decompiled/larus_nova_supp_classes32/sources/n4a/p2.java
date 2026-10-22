package n4a;

import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p2 {

    public static class a implements n2 {
        public final int a;
        public final int b;
        public final int c;

        public a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // n4a.n2
        public final long a() {
            int r0 = this.a;
            long r2 = (((long) r0) & 4294967295L) << 32;
            return (((long) this.b) & 4294967295L) | r2;
        }

        @Override // n4a.n2
        public final int b() {
            return this.c;
        }
    }

    public static class b implements n2 {
        public final long a;
        public final int b;

        public b(long r1, int r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // n4a.n2
        public final long a() {
            return this.a;
        }

        @Override // n4a.n2
        public final int b() {
            return this.b;
        }
    }

    public static synchronized void a(List<dv> r6) {
        monitor-enter(p2.class);
        if (r6 != null) goto L32;
    L30:
        monitor-exit(p2.class);
        return;
    L32:
    L27:
        th = move-exception;
        throw th;
    L6:
        if (r6.isEmpty() == true) goto L30;
        ArrayList r1 = new ArrayList(r6.size());     // Catch: Throwable -> L27
        Iterator<dv> r7 = r6.iterator();     // Catch: Throwable -> L27
    L10:
        if (r7.hasNext() == false) goto L24;
        dv r2 = r7.next();     // Catch: Throwable -> L27
        if ((r2 instanceof dx) == true) goto L13;
        if ((r2 instanceof dy) == true) goto L17;
        if ((r2 instanceof dz) == true) goto L20;
        if ((r2 instanceof dw) == false) goto L10;
        dw r3 = (dw) r2;     // Catch: Throwable -> L27
        a r4 = new a(r3.k, r3.l, r3.c);     // Catch: Throwable -> L27
    L14:
        r1.add(r4);     // Catch: Throwable -> L27
        goto L10
    L20:
        dz r5 = (dz) r2;     // Catch: Throwable -> L27
        r4 = new a(r5.j, r5.k, r5.c);     // Catch: Throwable -> L27
        goto L14
    L17:
        dy r8 = (dy) r2;     // Catch: Throwable -> L27
        r4 = new a(r8.j, r8.k, r8.c);     // Catch: Throwable -> L27
        goto L14
    L13:
        dx r9 = (dx) r2;     // Catch: Throwable -> L27
        r4 = new a(r9.j, r9.k, r9.c);     // Catch: Throwable -> L27
        goto L14
    L24:
        o2.a().c(r1);     // Catch: Throwable -> L27
        monitor-exit(p2.class);
    }
}
