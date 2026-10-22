package qa;

import android.content.Context;
import android.text.TextUtils;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11127a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11128b;

    public static class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f11129b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final t0 f11130m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f11131n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final List<t0> f11132o;

        public a(Context r8, int r10) {
            this.f11129b = r8;
            this.f11131n = r10;
        }

        @Override // qa.m1
        public final void a() {
            int r8 = this.f11131n;
            if (r8 != 1) goto L28;
        L25:
            th = th;
            String r10 = "stm";
            String r11 = "as";
        L74:
            q.f(r10, r11, th);
            return;
        L5:
            if (this.f11129b != null) goto L7;
            return;
        L7:
            if (this.f11130m != null) goto L10;
            return;
        L10:
            monitor-enter(u0.class);     // Catch: Throwable -> L25
            Context r12 = this.f11129b;     // Catch: Throwable -> L21
            if (r12 == null) goto L19;
            t0 r14 = this.f11130m;     // Catch: Throwable -> L21
            if (r14 == null) goto L19;
            u0.b(r12, r14.b());     // Catch: Throwable -> L21
            monitor-exit(u0.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(u0.class);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L28:
            if (r8 != 2) goto L77;
            monitor-enter(u0.class);     // Catch: Throwable -> L72
        L69:
            th = move-exception;
            throw th;     // Catch: Throwable -> L72
        L32:
            if (this.f11132o != null) goto L34;
        L67:
            monitor-exit(u0.class);     // Catch: Throwable -> L69
            return;
        L34:
            if (this.f11129b == null) goto L67;
            byte[] r13 = new byte[0];     // Catch: Throwable -> L69
            ByteArrayOutputStream r15 = new ByteArrayOutputStream();     // Catch: Throwable -> L51
            Iterator<t0> r16 = this.f11132o.iterator();     // Catch: Throwable -> L49
        L40:
            if (r16.hasNext() == false) goto L44;
            t0 r17 = r16.next();     // Catch: Throwable -> L49
            if (r17 == null) goto L40;
            r15.write(r17.b());     // Catch: Throwable -> L49
            goto L40
        L44:
            r13 = r15.toByteArray();     // Catch: Throwable -> L49
        L101:
            r15.close();     // Catch: Throwable -> L47
        L57:
            u0.b(this.f11129b, r13);     // Catch: Throwable -> L69
            monitor-exit(u0.class);     // Catch: Throwable -> L69
            return;
        L47:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L49:
            Throwable th = th;
        L97:
            q.f("stm", "aStB", th);     // Catch: Throwable -> L60
            if (r15 == null) goto L57;
        L60:
            th = move-exception;
            if (r15 != null) goto L105;
        L66:
            throw th;     // Catch: Throwable -> L69
        L105:
            r15.close();     // Catch: Throwable -> L64
        L64:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L51:
            th = move-exception;
            th = th;
            r15 = null;
        L72:
            th = th;
            r10 = "stm";
            r11 = "apb";
            goto L74
        L77:
            if (r8 != 3) goto L117;
        L92:
            th = move-exception;
            q.f("stm", "usd", th);
            return;
        L79:
            if (this.f11129b != null) goto L81;
            return;
        L81:
            p0 r18 = v0.a();     // Catch: Throwable -> L92
            Context r19 = this.f11129b;     // Catch: Throwable -> L92
            Vector<s4> r20 = n.f10841b;     // Catch: Throwable -> L92
            v0.b(r19, r18, "e", 1000, 307200, AwareStateListener.USER_INFO_FILE_REMOTE_MODE);     // Catch: Throwable -> L92
            if (r18.f10890g != null) goto L84;
            r18.f10890g = new w0(new a1(this.f11129b, new x0(new b1(new d1()))));     // Catch: Throwable -> L92
        L84:
            r18.f10891h = 3600000;     // Catch: Throwable -> L92
            if (TextUtils.isEmpty(r18.f10892i) == false) goto L88;
            r18.f10892i = "cKey";     // Catch: Throwable -> L92
        L88:
            if (r18.f10889f != null) goto L90;
            Context r110 = this.f11129b;     // Catch: Throwable -> L92
            r18.f10889f = new h1(r110, r18.f10891h, r18.f10892i, new e1(r18.f10884a, new f1(r110, u0.f11127a, 20480, 20480, "staticUpdate", u0.f11128b * 1024)));     // Catch: Throwable -> L92
        L90:
            q0.b(r18);     // Catch: Throwable -> L92
            return;
        }

        public a(Context r8, ArrayList r10) {
            this(r8, 2);
            this.f11132o = r10;
        }

        public a(Context r8, t0 r10) {
            this(r8, 1);
            this.f11130m = r10;
        }
    }

    public u0() {
    }

    public static synchronized void a(Context r8, ArrayList r10) {
        monitor-enter(u0.class);
        if (r10 != null) goto L15;
    L13:
        monitor-exit(u0.class);
        return;
    L15:
        if (r10.size() == 0) goto L13;
        l1.f10784d.a(new a(r8, r10));     // Catch: Throwable -> L11
        monitor-exit(u0.class);
        return;
    }

    public static /* synthetic */ void b(Context r8, byte[] r10) {
        p0 r11 = v0.a();
        Vector<s4> r12 = n.f10841b;
        v0.b(r8, r11, "e", 1000, 307200, AwareStateListener.USER_INFO_FILE_REMOTE_MODE);
        if (r11.f10888e != null) goto L11;
        r11.f10888e = new a0(0);
    L11:
        q0.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r10, r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        q.f("stm", "wts", th);
    }

    public static synchronized void c(t0 r8, Context r10) {
        monitor-enter(u0.class);
        l1.f10784d.a(new a(r10, r8));     // Catch: Throwable -> L7
        monitor-exit(u0.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
