package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.obric.assistant.RiskPreferenceSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s0 {
    public static boolean a;
    public static int b;

    public static class a extends l1 {
        public final Context b;
        public final r0 c;
        public final int d;
        public final List<r0> e;

        public a(Context r1, int r2) {
            this.b = r1;
            this.d = r2;
        }

        public a(Context r2, List r3) {
            this(r2, 2);
            this.e = r3;
        }

        public a(Context r2, r0 r3) {
            this(r2, 1);
            this.c = r3;
        }

        @Override // n4a.l1
        public final void a() {
            int r0 = this.d;
            if (r0 != 1) goto L28;
        L25:
            th = th;
            String r1 = "stm";
            String r2 = "as";
        L74:
            r.f(th, r1, r2);
            return;
        L5:
            if (this.b != null) goto L7;
            return;
        L7:
            if (this.c != null) goto L10;
            return;
        L10:
            monitor-enter(s0.class);     // Catch: Throwable -> L25
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L12:
            if (this.b == null) goto L19;
            r0 r3 = this.c;     // Catch: Throwable -> L21
            if (r3 == null) goto L19;
            s0.a(this.b, r3.b());     // Catch: Throwable -> L21
            monitor-exit(s0.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(s0.class);     // Catch: Throwable -> L21
            return;
        L28:
            if (r0 != 2) goto L77;
            monitor-enter(s0.class);     // Catch: Throwable -> L72
        L69:
            th = move-exception;
            throw th;     // Catch: Throwable -> L72
        L32:
            if (this.e != null) goto L34;
        L67:
            monitor-exit(s0.class);     // Catch: Throwable -> L69
            return;
        L34:
            if (this.b == null) goto L67;
            byte[] r4 = new byte[0];     // Catch: Throwable -> L69
            ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L51
            Iterator<r0> r6 = this.e.iterator();     // Catch: Throwable -> L49
        L40:
            if (r6.hasNext() == false) goto L44;
            r0 r7 = r6.next();     // Catch: Throwable -> L49
            if (r7 == null) goto L40;
            r5.write(r7.b());     // Catch: Throwable -> L49
            goto L40
        L44:
            r4 = r5.toByteArray();     // Catch: Throwable -> L49
        L109:
            r5.close();     // Catch: Throwable -> L47
        L57:
            s0.a(this.b, r4);     // Catch: Throwable -> L69
            monitor-exit(s0.class);     // Catch: Throwable -> L69
            return;
        L47:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L49:
            Throwable th = th;
        L105:
            r.f(th, "stm", "aStB");     // Catch: Throwable -> L60
            if (r5 == null) goto L57;
        L60:
            th = move-exception;
            if (r5 != null) goto L97;
        L66:
            throw th;     // Catch: Throwable -> L69
        L97:
            r5.close();     // Catch: Throwable -> L64
        L64:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L51:
            th = move-exception;
            th = th;
            r5 = null;
        L72:
            th = th;
            r1 = "stm";
            r2 = "apb";
            goto L74
        L77:
            if (r0 != 3) goto L117;
        L92:
            th = move-exception;
            r.f(th, "stm", "usd");
            return;
        L79:
            if (this.b != null) goto L81;
            return;
        L81:
            n0 r8 = t0.a();     // Catch: Throwable -> L92
            Context r9 = this.b;     // Catch: Throwable -> L92
            Vector<e5> r10 = p.b;     // Catch: Throwable -> L92
            t0.b(r9, r8, "e", 1000, 307200, RiskPreferenceSettings.SMART_BALANCE);     // Catch: Throwable -> L92
            if (r8.g != null) goto L84;
            r8.g = new u0(new z0(this.b, new v0(new a1(new c1()))));     // Catch: Throwable -> L92
        L84:
            r8.h = 3600000;     // Catch: Throwable -> L92
            if (TextUtils.isEmpty(r8.i) == false) goto L88;
            r8.i = "cKey";     // Catch: Throwable -> L92
        L88:
            if (r8.f != null) goto L90;
            Context r11 = this.b;     // Catch: Throwable -> L92
            r8.f = new g1(r11, r8.h, r8.i, new d1(r8.a, new e1(r11, s0.a, 20480, 20480, "staticUpdate", s0.b * 1024)));     // Catch: Throwable -> L92
        L90:
            o0.b(r8);     // Catch: Throwable -> L92
            return;
        }
    }

    public s0() {
    }

    public static /* synthetic */ void a(Context r7, byte[] r8) throws IOException {
        n0 r6 = t0.a();
        Vector<e5> r0 = p.b;
        t0.b(r7, r6, "e", 1000, 307200, RiskPreferenceSettings.SMART_BALANCE);
        if (r6.e != null) goto L11;
        r6.e = new z();
    L11:
        o0.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r8, r6);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        r.f(th, "stm", "wts");
    }

    public static synchronized void d(List<r0> r3, Context r4) {
        monitor-enter(s0.class);
        List<r0> r1 = k0.l();     // Catch: Throwable -> L15
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        ((ArrayList) r3).addAll(r1);     // Catch: Throwable -> L15
    L18:
        b(r3, r4);     // Catch: Throwable -> L12
        monitor-exit(s0.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(List<r0> r3, Context r4) {
        monitor-enter(s0.class);
        if (r3 != null) goto L15;
    L13:
        monitor-exit(s0.class);
        return;
    L15:
        if (r3.size() == 0) goto L13;
        k1.d.b(new a(r4, r3));     // Catch: Throwable -> L11
        monitor-exit(s0.class);
        return;
    }

    public static synchronized void c(r0 r3, Context r4) {
        monitor-enter(s0.class);
        k1.d.b(new a(r4, r3));     // Catch: Throwable -> L7
        monitor-exit(s0.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
