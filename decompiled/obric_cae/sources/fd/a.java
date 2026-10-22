package fd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.bytedance.android.alog.Alog;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7380a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static fd.d f7381b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f7382c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile ArrayList f7383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Alog f7384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ArrayList<WeakReference<Alog>> f7385f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static HandlerThread f7386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static HandlerC0074a f7387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f7388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f7389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f7390k = null;

    /* JADX INFO: renamed from: fd.a$a, reason: collision with other inner class name */
    public static class HandlerC0074a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 1) goto L5;
            Object r12 = r10.obj;
            if (r12 != null) goto L13;
            return;
        L13:
            if ((r12 instanceof d) == false) goto L68;
            d r13 = (d) r12;
            int r14 = a.f7380a;
            int r8 = r13.f7398a - 2;
            String r15 = "";
            nd.a.EnumC0122a r16 = r13.f7402e;
            if (r16 == null) goto L17;
            nd.a.EnumC0122a r17 = nd.a.EnumC0122a.f9526p;
            if (r16 != r17) goto L28;
            nd.a.EnumC0122a r18 = r17;
        L30:
            r15 = r13.f7400c;
            gd.b r19 = nd.a.f9520a.get(r18);
            if (r19 != null) goto L32;
        L19:
            String r20 = r15;
            String r21 = r13.f7399b;
            long r22 = r13.f7404g;
            long r23 = r13.f7405h;
            Alog r24 = defpackage.c.f3213r;
            if (r24 == null) goto L53;
            r24.g(r8, r21, r20, r22, r23);
        L53:
            r13.f7399b = null;
            r13.f7400c = null;
            r13.f7401d = null;
            r13.f7402e = null;
            r13.f7403f = null;
            r13.f7404g = -1;
            r13.f7405h = 0;
            r13.f7406i = null;
            Object r110 = d.f7395j;
            monitor-enter(r110);
            int r25 = d.f7397l;     // Catch: Throwable -> L60
            if (r25 >= 50) goto L58;
            r13.f7406i = d.f7396k;     // Catch: Throwable -> L60
            d.f7396k = r13;     // Catch: Throwable -> L60
            d.f7397l = r25 + 1;     // Catch: Throwable -> L60
        L58:
            monitor-exit(r110);     // Catch: Throwable -> L60
            return;
        L60:
            th = move-exception;
            throw th;
        L32:
            if (r18 != r17) goto L34;
            r15 = r19.a(new String[]{r15});
            goto L19
        L34:
            r15 = r19.a(r15);
            goto L19
        L28:
            r18 = nd.a.EnumC0122a.f9522b;
            if (r16 == r18) goto L30;
            nd.a.EnumC0122a r26 = nd.a.EnumC0122a.f9523m;
            if (r16 != r26) goto L38;
            Bundle r111 = (Bundle) r13.f7403f;
            ((kd.a) nd.a.f9520a.get(r26)).getClass();
            r15 = nd.b.b(r111);
            goto L19
        L38:
            nd.a.EnumC0122a r27 = nd.a.EnumC0122a.f9524n;
            if (r16 != r27) goto L41;
            Intent r112 = (Intent) r13.f7403f;
            ((kd.b) nd.a.f9520a.get(r27)).getClass();
            r15 = kd.b.b(r112);
            goto L19
        L41:
            nd.a.EnumC0122a r28 = nd.a.EnumC0122a.f9525o;
            if (r16 != r28) goto L44;
            r15 = nd.a.f9520a.get(r28).a((Throwable) r13.f7403f);
            goto L19
        L44:
            nd.a.EnumC0122a r29 = nd.a.EnumC0122a.f9528r;
            if (r16 != r29) goto L47;
            r15 = nd.a.f9520a.get(r29).a((Thread) r13.f7403f);
            goto L19
        L47:
            nd.a.EnumC0122a r30 = nd.a.EnumC0122a.f9527q;
            if (r16 != r30) goto L19;
            r15 = nd.a.f9520a.get(r30).a((StackTraceElement[]) r13.f7403f);
            goto L19
        L17:
            if (r13.f7401d != null) goto L21;
            r15 = r13.f7400c;
            goto L19
        L21:
            if (r13.f7400c != null) goto L23;
            String r113 = "";
        L24:
            StringBuilder r114 = android.aimedia.a.j(r113);
            r114.append(nd.c.a(r13.f7401d));
            r15 = r114.toString();
            goto L19
        L23:
            r113 = android.aimedia.a.i(new StringBuilder(), r13.f7400c, "\n");
            goto L24
        L68:
            return;
        L5:
            if (r11 != 2) goto L70;
            Alog r31 = defpackage.c.f3213r;
            if (r31 == null) goto L63;
            r31.a();
            return;
        L63:
            return;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7392b;

        public b(String r8, String r10) {
            this.f7391a = r8;
            this.f7392b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r8 = a.f7383d.iterator();
        L4:
            if (r8.hasNext() == false) goto L17;
            e r10 = (e) r8.next();
            if (r10 == null) goto L4;
            Alog r11 = defpackage.c.f3213r;
            if (r11 == null) goto L10;
            long r12 = r11.b();
        L11:
            r10.a(r12);
            goto L4
        L10:
            r12 = 0;
            goto L11
        L17:
            Thread.sleep(SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);     // Catch: Exception -> L16
        L14:
            a.a(this.f7391a, this.f7392b);
        }
    }

    public static class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7394b;

        public c(String r8, String r10) {
            this.f7393a = r8;
            this.f7394b = r10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            a.a(this.f7393a, this.f7394b);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f7395j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static d f7396k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f7397l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f7401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public nd.a.EnumC0122a f7402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f7403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f7404g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f7405h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d f7406i;

        static {
            f7395j = new Object();
        }

        public d() {
            this.f7402e = null;
        }
    }

    static {
        f7383d = new ArrayList();
        f7384e = null;
        f7385f = new ArrayList();
        f7388i = -1;
        f7389j = false;
        f7390k = new Object();
    }

    public a() {
    }

    public static void a(String r8, String r10) {
        File r11 = new File(r8);
        int r12 = 0;
        if (r11.exists() == false) goto L9;
        File[] r13 = r11.listFiles(new fd.b());
        if (r13 == null) goto L9;
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        r13[r15].delete();
        r15 = r15 + 1;
    L9:
        File r16 = new File(r10);
        if (r16.exists() == false) goto L16;
        File[] r17 = r16.listFiles(new fd.c());
        if (r17 == null) goto L19;
        int r18 = r17.length;
    L14:
        if (r12 >= r18) goto L20;
        r17[r12].delete();
        r12 = r12 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static boolean b(int r8) {
        if (r8 >= f7380a) goto L6;
        return false;
    L6:
        return true;
    }

    public static void c(String r8, String r10) {
        if (b(3) == false) goto L16;
        boolean r11 = f.b();
        if (r11 == true) goto L7;
    L10:
        Alog r12 = f7384e;
        if (r12 == null) goto L14;
        if (r11 == false) goto L14;
        r12.f(1, r8, r10);
        return;
    L14:
        defpackage.c.q0(1, r8, r10);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(3, r8, r10, null);
        return;
    }

    public static void d(String r8, String r10) {
        if (b(6) == false) goto L16;
        boolean r11 = f.b();
        if (r11 == true) goto L7;
    L10:
        Alog r12 = f7384e;
        if (r12 == null) goto L14;
        if (r11 == false) goto L14;
        r12.f(4, r8, r10);
        return;
    L14:
        defpackage.c.q0(4, r8, r10);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(6, r8, r10, null);
        return;
    }

    public static void e(String r8, String r10, Throwable r11) {
        if (b(6) == false) goto L16;
        boolean r12 = f.b();
        if (r12 == true) goto L7;
    L10:
        StringBuilder r13 = android.aimedia.a.k(r10, "\n");
        r13.append(nd.c.a(r11));
        String r14 = r13.toString();
        Alog r15 = f7384e;
        if (r15 == null) goto L14;
        if (r12 == false) goto L14;
        r15.f(4, r8, r14);
        return;
    L14:
        defpackage.c.q0(4, r8, r14);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(6, r8, r10, r11);
        return;
    }

    public static void f(String r8, String r10) {
        if (b(4) == false) goto L16;
        boolean r11 = f.b();
        if (r11 == true) goto L7;
    L10:
        Alog r12 = f7384e;
        if (r12 == null) goto L14;
        if (r11 == false) goto L14;
        r12.f(2, r8, r10);
        return;
    L14:
        defpackage.c.q0(2, r8, r10);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(4, r8, r10, null);
        return;
    }

    public static boolean g(fd.d r10) {
        f7381b = r10;
        int r8 = 0;
        Alog.c(new defpackage.c(r8));     // Catch: Throwable -> L69
        Object r11 = f7390k;
        monitor-enter(r11);
    L66:
        th = move-exception;
        throw th;
    L7:
        if (f7389j == false) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L66
        return false;
    L10:
        f7389j = true;     // Catch: Throwable -> L66
        monitor-exit(r11);     // Catch: Throwable -> L66
        f7380a = r10.d();
        boolean r12 = f.a(r10.c());
        boolean r13 = r10.m();
        if (r13 == false) goto L15;
    L18:
        boolean r14 = false;
    L19:
        boolean r15 = r10.a();
        Alog.b r16 = new Alog.b(r10.c());
        r16.g("default");
        r16.h(r10.d() - 2);
        r16.q(f7382c);
        r16.i(r10.e());
        r16.k(r10.h());
        int r17 = r10.g();
        if (r14 == false) goto L22;
        r17 = (r17 / 3) * 2;
    L22:
        r16.l(r17);
        r16.j(r10.f());
        r16.c(r10.b());
        int r18 = 65536;
        if (r12 == false) goto L25;
        int r19 = 65536;
    L26:
        r16.d(r19);
        if (r12 == false) goto L29;
        r18 = 196608;
    L29:
        r16.e(r18);
        Alog.d[] r20 = Alog.d.f3716a;
        r16.m();
        Alog.g[] r21 = Alog.g.f3722a;
        r16.r();
        Alog.e[] r22 = Alog.e.f3717a;
        r16.n();
        if (r10.j() == false) goto L32;
        Alog.c r23 = Alog.c.f3713m;
    L33:
        r16.f(r23);
        if (r10.k() == false) goto L36;
        Alog.f r24 = Alog.f.f3719m;
    L37:
        r16.p(r24);
        if (r10.k() == false) goto L40;
        Alog.a r25 = Alog.a.f3690m;
    L41:
        r16.b(r25);
        r16.o(r10.i());
        defpackage.c.g0(r16.a());
        if (r13 == false) goto L46;
        if (r15 == true) goto L45;
        if (r12 == false) goto L46;
    L45:
        HandlerThread r26 = new HandlerThread("Alog_main_delegate");
        f7386g = r26;
        r26.start();
        f7387h = new HandlerC0074a(f7386g.getLooper());
    L46:
        if (r14 == false) goto L60;
        Alog.b r27 = new Alog.b(r10.c());
        r27.g("main");
        r27.h(r10.d() - 2);
        r27.q(f7382c);
        r27.i(r10.e());
        r27.k(r10.h() / 2);
        r27.l(r10.g() / 3);
        r27.j(r10.f());
        r27.c(r10.b());
        r27.d(32768);
        r27.e(98304);
        r27.m();
        r27.r();
        r27.n();
        if (r10.j() == false) goto L50;
        Alog.c r28 = Alog.c.f3713m;
    L51:
        r27.f(r28);
        if (r10.k() == false) goto L54;
        Alog.f r29 = Alog.f.f3719m;
    L55:
        r27.p(r29);
        if (r10.k() == false) goto L58;
        Alog.a r30 = Alog.a.f3690m;
    L59:
        r27.b(r30);
        r27.o(r10.i());
        f7384e = r27.a();
        goto L60
    L58:
        r30 = Alog.a.f3689b;
        goto L59
    L54:
        r29 = Alog.f.f3718b;
        goto L55
    L50:
        r28 = Alog.c.f3712b;
    L60:
        String r31 = r10.b();
        String r110 = r10.e();
        if (f7383d.size() <= 0) goto L63;
        new Thread(new b(r31, r110), "_ALOG_OPT_").start();
        r8 = 1;
    L63:
        if (r8 != 0) goto L65;
        new Timer("_ALOG_OPT_").schedule(new c(r31, r110), SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
    L65:
        return true;
    L40:
        r25 = Alog.a.f3689b;
        goto L41
    L36:
        r24 = Alog.f.f3718b;
        goto L37
    L32:
        r23 = Alog.c.f3712b;
        goto L33
    L25:
        r19 = 32768;
        goto L26
    L15:
        if (r10.l() == false) goto L18;
        if (r12 == false) goto L18;
        r14 = true;
    L69:
        return false;
    }

    public static void h(int r8, String r10, String r11, Throwable r12) {
        if (f7388i != (-1)) goto L5;
        f7388i = Process.myTid();
    L5:
        Object r13 = d.f7395j;
        monitor-enter(r13);
        d r14 = d.f7396k;     // Catch: Throwable -> L16
        if (r14 == null) goto L12;
        d.f7396k = r14.f7406i;     // Catch: Throwable -> L16
        r14.f7406i = null;     // Catch: Throwable -> L16
        d.f7397l--;     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
    L14:
        r14.f7398a = r8;
        r14.f7399b = r10;
        r14.f7400c = r11;
        r14.f7401d = r12;
        r14.f7402e = null;
        r14.f7403f = null;
        r14.f7404g = f7388i;
        r14.f7405h = System.currentTimeMillis();
        Message r15 = Message.obtain();
        r15.what = 1;
        r15.obj = r14;
        f7387h.sendMessage(r15);
        return;
    L12:
        monitor-exit(r13);     // Catch: Throwable -> L16
        r14 = new d();
    L16:
        th = move-exception;
        throw th;
    }

    public static void i(String r8, String r10) {
        if (b(2) == false) goto L16;
        boolean r11 = f.b();
        if (r11 == true) goto L7;
    L10:
        Alog r12 = f7384e;
        if (r12 == null) goto L14;
        if (r11 == false) goto L14;
        r12.f(0, r8, r10);
        return;
    L14:
        defpackage.c.q0(0, r8, r10);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(2, r8, r10, null);
        return;
    }

    public static void j(String r8, String r10) {
        if (b(5) == false) goto L16;
        boolean r11 = f.b();
        if (r11 == true) goto L7;
    L10:
        Alog r12 = f7384e;
        if (r12 == null) goto L14;
        if (r11 == false) goto L14;
        r12.f(3, r8, r10);
        return;
    L14:
        defpackage.c.q0(3, r8, r10);
        return;
    L7:
        if (f7387h == null) goto L10;
        h(5, r8, r10, null);
        return;
    }
}
