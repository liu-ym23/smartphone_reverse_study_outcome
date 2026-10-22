package n4a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 {
    public static int a = 1000;
    public static boolean b = false;
    public static int c = 20;
    public static int d = 10;
    public static int e;

    public static class a extends l1 {
        public final int b;
        public final Context c;
        public final p0 d;

        public a(Context r1, int r2) {
            this.c = r1;
            this.b = r2;
        }

        public a(Context r2, p0 r3) {
            this(r2, 1);
            this.d = r3;
        }

        @Override // n4a.l1
        public final void a() {
            int r0 = this.b;
            if (r0 != 1) goto L19;
            monitor-enter(q0.class);     // Catch: Throwable -> L15
            String r1 = Long.toString(System.currentTimeMillis());     // Catch: Throwable -> L12
            n0 r8 = t0.a();     // Catch: Throwable -> L12
            Context r2 = this.c;     // Catch: Throwable -> L12
            Vector<e5> r3 = p.b;     // Catch: Throwable -> L12
            t0.b(r2, r8, "f", q0.a, 2097152, "6");     // Catch: Throwable -> L12
            if (r8.e != null) goto L9;
            r8.e = new c0(new e0(new f0(new e0())));     // Catch: Throwable -> L12
        L9:
            o0.a(r1, this.d.a(), r8);     // Catch: Throwable -> L12
            monitor-exit(q0.class);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            r.f(th, "ofm", "aple");
            return;
        L19:
            if (r0 != 2) goto L40;
            n0 r4 = t0.a();     // Catch: Throwable -> L31
            Context r5 = this.c;     // Catch: Throwable -> L31
            Vector<e5> r6 = p.b;     // Catch: Throwable -> L31
            t0.b(r5, r4, "f", q0.a, 2097152, "6");     // Catch: Throwable -> L31
            r4.h = 14400000;     // Catch: Throwable -> L31
            if (r4.g != null) goto L27;
            c0 r7 = new c0(new e0(new f0()));     // Catch: Throwable -> L31
            c1 r9 = new c1();     // Catch: Throwable -> L31
            if (c.a != null) goto L25;
            c.a = y4.e("ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09");     // Catch: Throwable -> L31
        L25:
            byte[] r10 = new byte[4];     // Catch: Throwable -> L31
            System.arraycopy(c.a, 40, r10, 0, 4);     // Catch: Throwable -> L31
            int r11 = ((r10[0] & 255) * 256) + (r10[1] & 255);     // Catch: Throwable -> L31
            int r12 = ((r10[2] & 255) * 256) + (r10[3] & 255);     // Catch: Throwable -> L31
            byte[] r13 = new byte[r12];     // Catch: Throwable -> L31
            System.arraycopy(c.a, r11, r13, 0, r12);     // Catch: Throwable -> L31
            String r14 = new String(r13);     // Catch: Throwable -> L31
            b.a();     // Catch: Throwable -> L31
            r4.g = new y0(new x0(r9, r7, r14, new Object[]{v4.g(this.c), NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, x4.q(this.c), x4.d, Build.MANUFACTURER, Build.DEVICE, NameKeys.UnloadStrategy_No_Strategy, v4.d(this.c), Build.MODEL, v4.e(this.c), v4.b(this.c), x4.p(this.c), x4.j(this.c), String.valueOf(Build.VERSION.SDK_INT), NameKeys.UnloadStrategy_No_Strategy}));     // Catch: Throwable -> L31
        L27:
            if (TextUtils.isEmpty(r4.i) == false) goto L29;
            r4.i = "fKey";     // Catch: Throwable -> L31
        L29:
            Context r15 = this.c;     // Catch: Throwable -> L31
            r4.f = new g1(r15, r4.h, r4.i, new e1(r15, q0.b, q0.d * 1024, q0.c * 1024, "offLocKey", q0.e * 1024));     // Catch: Throwable -> L31
            o0.b(r4);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            r.f(th, "ofm", "uold");
            return;
        }
    }

    public q0() {
    }

    public static synchronized void a(int r1, boolean r2, int r3, int r4) {
        monitor-enter(q0.class);
        a = r1;     // Catch: Throwable -> L15
        b = r2;     // Catch: Throwable -> L15
        if (r3 >= 10) goto L7;
    L8:
        r3 = 20;
    L9:
        c = r3;     // Catch: Throwable -> L15
        if ((r3 / 5) <= d) goto L12;
        d = r3 / 5;     // Catch: Throwable -> L15
    L12:
        e = r4;     // Catch: Throwable -> L15
        monitor-exit(q0.class);
        return;
    L7:
        if (r3 <= 100) goto L9;
    L15:
        th = move-exception;
        throw th;
    }
}
