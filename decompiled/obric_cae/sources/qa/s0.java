package qa;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.obric.cae.smartNetwork.networkRateLimit.TrafficControlConfig;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11011a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11012b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11013c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f11014d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f11015e;

    public static class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11016b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Context f11017m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final r0 f11018n;

        public a(Context r8, int r10) {
            this.f11017m = r8;
            this.f11016b = r10;
        }

        @Override // qa.m1
        public final void a() {
            int r8 = this.f11016b;
            if (r8 != 1) goto L19;
            monitor-enter(s0.class);     // Catch: Throwable -> L15
            String r10 = Long.toString(System.currentTimeMillis());     // Catch: Throwable -> L12
            p0 r11 = v0.a();     // Catch: Throwable -> L12
            Context r12 = this.f11017m;     // Catch: Throwable -> L12
            Vector<s4> r13 = n.f10841b;     // Catch: Throwable -> L12
            v0.b(r12, r11, "f", s0.f11011a, TrafficControlConfig.DEFAULT_UNLIMITED_RATE, "6");     // Catch: Throwable -> L12
            if (r11.f10888e != null) goto L9;
            r11.f10888e = new c0(new a0(new b0(new a0(1), 1)));     // Catch: Throwable -> L12
        L9:
            q0.a(r10, this.f11018n.a(), r11);     // Catch: Throwable -> L12
            monitor-exit(s0.class);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            q.f("ofm", "aple", th);
            return;
        L19:
            if (r8 != 2) goto L53;
            p0 r14 = v0.a();     // Catch: Throwable -> L43
            Context r15 = this.f11017m;     // Catch: Throwable -> L43
            Vector<s4> r16 = n.f10841b;     // Catch: Throwable -> L43
            v0.b(r15, r14, "f", s0.f11011a, TrafficControlConfig.DEFAULT_UNLIMITED_RATE, "6");     // Catch: Throwable -> L43
            r14.f10891h = 14400000;     // Catch: Throwable -> L43
            if (r14.f10890g != null) goto L39;
            c0 r17 = new c0(new a0(new b0()));     // Catch: Throwable -> L43
            d1 r18 = new d1();     // Catch: Throwable -> L43
            if (b.f10220a != null) goto L25;
            b.f10220a = l4.e("ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09");     // Catch: Throwable -> L43
        L25:
            byte[] r19 = new byte[4];     // Catch: Throwable -> L43
            System.arraycopy(b.f10220a, 40, r19, 0, 4);     // Catch: Throwable -> L43
            int r110 = ((r19[0] & 255) * 256) + (r19[1] & 255);     // Catch: Throwable -> L43
            int r111 = ((r19[2] & 255) * 256) + (r19[3] & 255);     // Catch: Throwable -> L43
            byte[] r20 = new byte[r111];     // Catch: Throwable -> L43
            System.arraycopy(b.f10220a, r110, r20, 0, r111);     // Catch: Throwable -> L43
            String r21 = new String(r20);     // Catch: Throwable -> L43
            Object[] r22 = new Object[16];     // Catch: Throwable -> L43
            r22[0] = h4.g(this.f11017m);     // Catch: Throwable -> L43
            r22[1] = "";     // Catch: Throwable -> L43
            r22[2] = "";     // Catch: Throwable -> L43
            r22[3] = k4.m(this.f11017m);     // Catch: Throwable -> L43
            r22[4] = k4.f10751d;     // Catch: Throwable -> L43
            r22[5] = Build.MANUFACTURER;     // Catch: Throwable -> L43
            r22[6] = Build.DEVICE;     // Catch: Throwable -> L43
            r22[7] = "";     // Catch: Throwable -> L43
            r22[8] = h4.d(this.f11017m);     // Catch: Throwable -> L43
            r22[9] = Build.MODEL;     // Catch: Throwable -> L43
            r22[10] = h4.e(this.f11017m);     // Catch: Throwable -> L43
            r22[11] = h4.b(this.f11017m);     // Catch: Throwable -> L43
            r22[12] = k4.l(this.f11017m);     // Catch: Throwable -> L43
            r22[13] = k4.h(this.f11017m);     // Catch: Throwable -> L43
            r22[14] = String.valueOf(Build.VERSION.SDK_INT);     // Catch: Throwable -> L43
            if (qa.a.f10201a == null) goto L28;
        L37:
            r22[15] = "";     // Catch: Throwable -> L43
            r14.f10890g = new z0(new y0(r18, r17, r21, r22));     // Catch: Throwable -> L43
            goto L39
        L28:
            monitor-enter(qa.a.class);     // Catch: Throwable -> L43
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L30:
            if (qa.a.f10201a != null) goto L32;
            qa.a.f10201a = new qa.a();     // Catch: Throwable -> L34
        L32:
            monitor-exit(qa.a.class);     // Catch: Throwable -> L34
        L39:
            if (TextUtils.isEmpty(r14.f10892i) == false) goto L41;
            r14.f10892i = "fKey";     // Catch: Throwable -> L43
        L41:
            Context r112 = this.f11017m;     // Catch: Throwable -> L43
            r14.f10889f = new h1(r112, r14.f10891h, r14.f10892i, new f1(r112, s0.f11012b, s0.f11014d * 1024, s0.f11013c * 1024, "offLocKey", s0.f11015e * 1024));     // Catch: Throwable -> L43
            q0.b(r14);     // Catch: Throwable -> L43
            return;
        L43:
            th = move-exception;
            q.f("ofm", "uold", th);
            return;
        }

        public a(Context r8, r0 r10) {
            this(r8, 1);
            this.f11018n = r10;
        }
    }

    public s0() {
    }

    public static synchronized void a(int r8, boolean r10, int r11, int r12) {
        monitor-enter(s0.class);
        f11011a = r8;     // Catch: Throwable -> L15
        f11012b = r10;     // Catch: Throwable -> L15
        if (r11 >= 10) goto L7;
    L8:
        r11 = 20;
    L9:
        f11013c = r11;     // Catch: Throwable -> L15
        if ((r11 / 5) <= f11014d) goto L12;
        f11014d = r11 / 5;     // Catch: Throwable -> L15
    L12:
        f11015e = r12;     // Catch: Throwable -> L15
        monitor-exit(s0.class);
        return;
    L7:
        if (r11 <= 100) goto L9;
    L15:
        th = move-exception;
        throw th;
    }
}
