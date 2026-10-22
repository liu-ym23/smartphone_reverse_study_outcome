package as9;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import zr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final zr9.f a;
    public final g b;
    public final Object c;
    public long d;
    public final List<zr9.c> e;
    public final List<zr9.b> f;
    public final Map<zr9.d, d> g;
    public as9.a h;
    public as9.a i;
    public C0001c j;
    public a k;
    public final e l;

    public class a extends b {
        public final /* synthetic */ c c;

        public a(c r2) {
            this.c = r2;
            super(r2, 1);
        }

        @Override // as9.c.b, as9.a.InterfaceC0000a
        public final void onStatusGenerate(int r2, float r3) {
            zr9.f r0 = this.c.a;
            if (r0 == null) goto L6;
            r0.c = r2;
            super.onStatusGenerate(r2, r3);
            return;
        }
    }

    public class b implements as9.a.InterfaceC0000a {
        public final int a;
        public final /* synthetic */ c b;

        public b(c r1, int r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // as9.a.InterfaceC0000a
        public void onStatusGenerate(int r5, float r6) {
            int r7 = this.a;
            c r0 = this.b;
            if (r7 != r0.b.a) goto L17;
            zr9.f r8 = r0.a;
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.a != r5) goto L12;
            long r1 = System.currentTimeMillis();
            c r9 = this.b;
            long r2 = r1 - r9.d;
            r9.b.getClass();
            if (r2 < 300000) goto L11;
            boolean r10 = bs9.a.a;
            goto L12
        L11:
            return;
        L12:
            c r11 = this.b;
            r11.a.a = r5;
            if (r11.l.hasMessages(1) == false) goto L15;
            r11.l.removeMessages(1);
        L15:
            r11.l.sendEmptyMessageDelayed(1, 3000);
            return;
        }
    }

    /* JADX INFO: renamed from: as9.c$c, reason: collision with other inner class name */
    public class C0001c extends b {
        public final /* synthetic */ c c;

        public C0001c(c r2) {
            this.c = r2;
            super(r2, 0);
        }

        @Override // as9.c.b, as9.a.InterfaceC0000a
        public final void onStatusGenerate(int r18, float r19) {
            zr9.f r2 = this.c.a;
            if (r2 == null) goto L36;
            r2.b = r18;
            r2.d = r19;
            super.onStatusGenerate(r18, r19);
            c r3 = this.c;
            long r4 = SystemClock.elapsedRealtime();
            Map<zr9.d, d> r5 = r3.g;
            monitor-enter(r5);
            Iterator r6 = ((HashMap) r3.g).entrySet().iterator();     // Catch: Throwable -> L33
            boolean r7 = false;
        L8:
            if (r6.hasNext() == false) goto L27;
            d r8 = (d) ((Map.Entry) r6.next()).getValue();     // Catch: Throwable -> L33
            if (r8 == null) goto L8;
            if (r8.c == true) goto L8;
            float r9 = r19 - r8.a;     // Catch: Throwable -> L33
            long r10 = r4 - r8.b;     // Catch: Throwable -> L33
            float r12 = r9 / r10;     // Catch: Throwable -> L33
            if (r9 < 0.0f) goto L21;
            if (r10 <= 0) goto L19;
            if (r12 <= 0.0f) goto L21;
        L19:
            boolean r11 = bs9.a.a;     // Catch: Throwable -> L33
            r7 = true;
            r8.c = true;     // Catch: Throwable -> L33
            r8.d = r19;     // Catch: Throwable -> L33
            r8.e = r4;     // Catch: Throwable -> L33
        L21:
            if (r9 < 0.0f) goto L26;
            if (r12 < (((double) 0.0f) * 0.5d)) goto L26;
            boolean r13 = bs9.a.a;     // Catch: Throwable -> L33
        L26:
            boolean r14 = bs9.a.a;     // Catch: Throwable -> L33
            r8.b = r4;     // Catch: Throwable -> L33
            r8.a = r19;     // Catch: Throwable -> L33
            goto L8
        L27:
            monitor-exit(r5);     // Catch: Throwable -> L33
            if (r7 == true) goto L30;
            return;
        L30:
            if (r3.l.hasMessages(2) == false) goto L32;
            r3.l.removeMessages(2);
        L32:
            r3.l.sendEmptyMessageDelayed(2, 5000);
            return;
        L33:
            th = move-exception;
            throw th;
        }
    }

    public class d {
        public float a;
        public long b;
        public boolean c;
        public float d;
        public long e;

        public final String toString() {
            return "SurgeConfig{baseTemp=" + this.a + ", baseTime=" + this.b + ", targetDeltaTemp=0.0, targetDuration=0, targetSpeed=0.0, needNotify=" + this.c + ", nowTemp=" + this.d + ", nowTime=" + this.e + '}';
        }
    }

    public class e extends Handler {
        public final /* synthetic */ c a;

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            int r5 = r4.what;
            if (r5 != 1) goto L5;
            c r6 = this.a;
            zr9.f r0 = r6.a;
            List<zr9.c> r1 = r6.e;
            monitor-enter(r1);
            ArrayList r2 = new ArrayList(r6.e);     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
            Iterator r7 = r2.iterator();
        L14:
            if (r7.hasNext() == false) goto L16;
            zr9.c r3 = (zr9.c) r7.next();
            int r8 = r0.a;
            r3.a();
            goto L14
        L16:
            int r9 = r0.a;
            boolean r10 = bs9.a.a;
            c r11 = this.a;
            c.a(r11, r11.a);
            c r12 = this.a;
            r12.d = System.currentTimeMillis();
            return;
        L18:
            th = move-exception;
            throw th;
        L5:
            if (r5 != 2) goto L25;
            c.b(this.a);
            return;
        }

        public e(c r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class f {
        public final zr9.d a;

        public f(zr9.d r1, float r2, float r3, long r4) {
            this.a = r1;
        }
    }

    public c(Context r9) {
        Object r0 = new Object();
        this.c = r0;
        this.d = -1;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new HashMap();
        g r1 = g.d;
        this.b = r1;
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("thermal_status");
        ThreadMethodProxy.start(r2);
        e r3 = new e(this, r2.getLooper());
        this.l = r3;
        as9.b.a = r2.getLooper();
        int r4 = -1;
        if (r1.b == true) goto L5;
        as9.a r5 = this.h;
        if (r5 == null) goto L25;
        r5.f();
        this.h = null;
        this.j = null;
    L25:
        if (r1.c == true) goto L27;
        as9.a r10 = this.i;
        if (r10 == null) goto L51;
        r10.f();
        this.i = null;
        this.k = null;
    L51:
        if (r1.a == 2) goto L53;
    L59:
        Objects.toString(r1);
        Objects.toString(this.h);
        Objects.toString(this.i);
        boolean r11 = bs9.a.a;
        zr9.f r12 = new zr9.f();
        monitor-enter(r0);
    L81:
        th = move-exception;
        throw th;
    L62:
        if (r1.b == false) goto L69;
        as9.a r6 = this.h;     // Catch: Throwable -> L81
        if (r6 == null) goto L69;
        r12.d = r6.b();     // Catch: Throwable -> L81
        int r7 = this.h.c();     // Catch: Throwable -> L81
        r12.b = r7;     // Catch: Throwable -> L81
        if (r1.a != 0) goto L69;
        r12.a = r7;     // Catch: Throwable -> L81
    L69:
        if (r1.c == false) goto L75;
        as9.a r8 = this.i;     // Catch: Throwable -> L81
        if (r8 == null) goto L75;
        int r13 = r8.c();     // Catch: Throwable -> L81
        r12.c = r13;     // Catch: Throwable -> L81
        if (r1.a != 1) goto L75;
        r12.a = r13;     // Catch: Throwable -> L81
    L75:
        monitor-exit(r0);     // Catch: Throwable -> L81
        this.a = r12;
        if (r3.hasMessages(1) == false) goto L79;
        r3.removeMessages(1);
    L79:
        r3.sendEmptyMessageDelayed(1, 60000);
        return;
    L53:
        if (this.i == null) goto L56;
        r4 = 1;
    L58:
        r1.a = r4;
        goto L59
    L56:
        if (this.h == null) goto L58;
        r4 = 0;
        goto L58
    L27:
        if (this.i != null) goto L51;
        as9.a r14 = as9.b.a(1, r9);
        this.i = r14;
        if (r14 != null) goto L31;
        boolean r15 = false;
    L35:
        if (r15 == true) goto L51;
        r1.c = false;
        if (r1.a == 1) goto L39;
    L43:
        as9.a r16 = this.i;
        if (r16 == null) goto L46;
        r16.f();
        this.i = null;
        this.k = null;
    L46:
        boolean r17 = bs9.a.a;
        goto L51
    L39:
        if (this.h != null) goto L41;
        int r18 = -1;
    L42:
        r1.a = r18;
        goto L43
    L41:
        r18 = 0;
        goto L42
    L31:
        if (this.k != null) goto L33;
        this.k = new a(this);
    L33:
        r15 = r14.g(this.k);
        goto L35
    L5:
        if (this.h != null) goto L25;
        as9.a r19 = as9.b.a(0, r9);
        this.h = r19;
        if (r19 != null) goto L9;
        boolean r20 = false;
    L13:
        if (r20 == true) goto L25;
        r1.b = false;
        if (r1.a != 0) goto L17;
        r1.a = -1;
    L17:
        as9.a r21 = this.h;
        if (r21 == null) goto L20;
        r21.f();
        this.h = null;
        this.j = null;
    L20:
        boolean r22 = bs9.a.a;
        goto L25
    L9:
        if (this.j != null) goto L11;
        this.j = new C0001c(this);
    L11:
        r20 = r19.g(this.j);
        goto L13
    }

    public static void b(c r12) {
        r12.getClass();
        ArrayList r0 = new ArrayList();
        Map<zr9.d, d> r1 = r12.g;
        monitor-enter(r1);
        Iterator r13 = ((HashMap) r12.g).entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) r13.next();     // Catch: Throwable -> L19
        d r3 = (d) r2.getValue();     // Catch: Throwable -> L19
        zr9.d r5 = (zr9.d) r2.getKey();     // Catch: Throwable -> L19
        if (r3 == null) goto L6;
        if (r3.c == false) goto L6;
        if (r5 == null) goto L6;
        r0.add(new f(r5, r3.a, r3.d, r3.e - r3.b));     // Catch: Throwable -> L19
        r3.a = r3.d;     // Catch: Throwable -> L19
        r3.b = r3.e;     // Catch: Throwable -> L19
        r3.c = false;     // Catch: Throwable -> L19
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L19
        Iterator r14 = r0.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        ((f) r14.next()).a.a();
        boolean r4 = bs9.a.a;
        goto L16
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void c(zr9.b r3) {
        List<zr9.b> r0 = this.f;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f).contains(r3) == true) goto L7;
        ((ArrayList) this.f).add(r3);     // Catch: Throwable -> L9
        r3.getDescription();     // Catch: Throwable -> L9
        boolean r4 = bs9.a.a;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public static void a(c r2, zr9.f r3) {
        List<zr9.b> r0 = r2.f;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r2.f);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ((zr9.b) r4.next()).a(r3);
        goto L8
    L10:
        Objects.toString(r3);
        boolean r5 = bs9.a.a;
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
