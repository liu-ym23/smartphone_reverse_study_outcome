package as9;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zr9.e;
import zr9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static volatile d c;
    public final c a;
    public final List<zr9.a> b;

    public class a implements zr9.b {
        public int a;
        public final /* synthetic */ d b;

        @Override // zr9.b
        public final String getDescription() {
            return "Unite thermalListener";
        }

        public a(d r1) {
            this.b = r1;
            this.a = -1;
        }

        @Override // zr9.b
        public final void a(f r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (((ArrayList) this.b.b).isEmpty() == false) goto L6;
            return;
        L6:
            if (r4.a == this.a) goto L33;
            List<zr9.a> r0 = this.b.b;
            monitor-enter(r0);
            int r1 = r4.a;     // Catch: Throwable -> L24
            int r2 = this.a;     // Catch: Throwable -> L24
            if (r1 <= r2) goto L16;
            Iterator r3 = ((ArrayList) this.b.b).iterator();     // Catch: Throwable -> L24
        L14:
            if (r3.hasNext() == false) goto L21;
            ((zr9.a) r3.next()).a(r4);     // Catch: Throwable -> L24
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L24
            this.a = r4.a;
            return;
        L16:
            if (r1 >= r2) goto L21;
            Iterator r5 = ((ArrayList) this.b.b).iterator();     // Catch: Throwable -> L24
        L19:
            if (r5.hasNext() == false) goto L21;
            ((zr9.a) r5.next()).b(r4);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        }
    }

    public d(Context r3) {
        ArrayList r0 = new ArrayList();
        this.b = r0;
        c r1 = new c(r3);
        this.a = r1;
        if (bs9.a.a == false) goto L5;
        r0.add(new e());
    L5:
        r1.c(new a(this));
    }
}
