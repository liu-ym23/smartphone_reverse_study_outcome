package qa;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static j3 f10377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static v f10378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f10379i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j3 f10382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j3 f10383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10385f;

    public e4(Context r8) {
        this.f10381b = null;
        this.f10382c = null;
        this.f10383d = null;
        this.f10384e = 0;
        this.f10385f = false;
        this.f10380a = r8.getApplicationContext();
    }

    public final AMapLocation a(AMapLocation r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return r8;
    L4:
        int r12 = r8.f3646w;
        if (r12 != 0) goto L7;
        return r8;
    L7:
        if (r8.f3649z != 1) goto L9;
        return r8;
    L9:
        if (r12 == 7) goto L44;
        e();     // Catch: Throwable -> L33
        j3 r13 = f10377g;     // Catch: Throwable -> L33
        if (r13 != null) goto L14;
    L32:
        return r8;
    L14:
        if (r13.f10631d == null) goto L32;
        if (TextUtils.isEmpty(r10) == false) goto L25;
        long r14 = SystemClock.elapsedRealtime() - f10377g.f10629b;     // Catch: Throwable -> L33
        if (r14 >= 0) goto L21;
    L23:
        boolean r15 = false;
    L24:
        r8.R = 3;     // Catch: Throwable -> L33
    L26:
        if (r15 == false) goto L42;
        AMapLocation r16 = f10377g.f10631d;     // Catch: Throwable -> L33
        l6.a.l(r16);     // Catch: Throwable -> L30
        r16.x(9);     // Catch: Throwable -> L30
        r16.M = true;     // Catch: Throwable -> L30
        r16.f3648y = r8.f3648y;     // Catch: Throwable -> L30
        return r16;
    L30:
        th = move-exception;
        r8 = r16;
        th = th;
    L34:
        t3.g("LastLocationManager", "fixLastLocation", th);
        return r8;
    L42:
        return r8;
    L21:
        if (r14 > r11) goto L23;
        r15 = true;
        goto L24
    L25:
        r15 = y3.n(f10377g.f10630c, r10);     // Catch: Throwable -> L33
        r8.R = 2;     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L34
    L44:
        return r8;
    }

    public final void b() {
        if (this.f10385f == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        t3.g("LastLocationManager", "<init>:DBOperation", th);
    L14:
        this.f10385f = true;
        return;
    L6:
        if (this.f10381b != null) goto L9;
        this.f10381b = h3.a("MD5", "");     // Catch: Throwable -> L12
    L9:
        if (f10378h != null) goto L14;
        u r8 = v.d();     // Catch: Throwable -> L12
        f10378h = new v(this.f10380a, r8);     // Catch: Throwable -> L12
        goto L14
    }

    public final boolean c(AMapLocation r8, String r10) {
        if (this.f10380a == null) goto L30;
        if (r8 == null) goto L30;
        if (y3.k(r8) == false) goto L30;
        if (r8.f3649z == 2) goto L30;
        if (r8.isMock() == true) goto L30;
        if (r8.M == true) goto L30;
        j3 r11 = new j3();
        r11.f10631d = r8;
        if (r8.f3649z != 1) goto L18;
        r11.f10630c = null;
    L31:
        f10377g = r11;     // Catch: Throwable -> L28
        f10379i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        this.f10382c = r11;     // Catch: Throwable -> L28
        j3 r12 = this.f10383d;     // Catch: Throwable -> L28
        if (r12 != null) goto L22;
    L24:
        if ((SystemClock.elapsedRealtime() - this.f10384e) <= 30000) goto L30;
        return true;
    L22:
        if (y3.a(r12.f10631d, r11.f10631d) > 500.0f) goto L24;
        return false;
    L28:
        th = move-exception;
        t3.g("LastLocationManager", "setLastFix", th);
        goto L30
    L18:
        r11.f10630c = r10;
    L30:
        return false;
    }

    public final void d() {
        b();     // Catch: Throwable -> L38
        j3 r8 = this.f10382c;     // Catch: Throwable -> L38
        if (r8 != null) goto L5;
        return;
    L5:
        if (y3.k(r8.f10631d) == true) goto L7;
        return;
    L7:
        if (f10378h == null) goto L45;
        j3 r10 = this.f10382c;     // Catch: Throwable -> L38
        if (r10 != this.f10383d) goto L11;
        return;
    L11:
        if (r10.f10629b != 0) goto L47;
        String r11 = r10.f10631d.z();     // Catch: Throwable -> L38
        j3 r12 = this.f10382c;     // Catch: Throwable -> L38
        String r13 = r12.f10630c;     // Catch: Throwable -> L38
        this.f10383d = r12;     // Catch: Throwable -> L38
        String r14 = null;
        if (TextUtils.isEmpty(r11) == true) goto L19;
        String r15 = l4.d(h3.b(this.f10381b, r11.getBytes("UTF-8")));     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r13) == true) goto L18;
        r14 = l4.d(h3.b(this.f10381b, r13.getBytes("UTF-8")));     // Catch: Throwable -> L38
    L18:
        String r16 = r14;
        r14 = r15;
        String r17 = r16;
    L21:
        if (TextUtils.isEmpty(r14) == true) goto L48;
        j3 r18 = new j3();     // Catch: Throwable -> L38
        r18.f10628a = r14;     // Catch: Throwable -> L38
        r18.f10629b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        r18.f10630c = r17;     // Catch: Throwable -> L38
        v r19 = f10378h;     // Catch: Throwable -> L38
        u r20 = r19.f11155c;     // Catch: Throwable -> L38
        monitor-enter(r20);     // Catch: Throwable -> L38
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L25:
        if (r19.c(j3.class).size() != 0) goto L29;
        r19.e(r18);     // Catch: Throwable -> L27
    L30:
        monitor-exit(r20);     // Catch: Throwable -> L27
        this.f10384e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        j3 r21 = f10377g;     // Catch: Throwable -> L38
        if (r21 == null) goto L49;
        r21.f10629b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L38
        return;
    L49:
        return;
    L29:
        r19.h(r18);     // Catch: Throwable -> L27
        goto L30
    L48:
        return;
    L19:
        r17 = null;
        goto L21
    L47:
        return;
    L45:
        return;
    L38:
        th = move-exception;
        t3.g("LastLocationManager", "saveLastFix", th);
    }

    public final void e() {
        if (f10377g != null) goto L5;
    L6:
        j3 r8 = null;
        r8 = null;
        String r10 = null;
        r10 = null;
        r10 = null;
        r10 = null;
        String r11 = null;
        r8 = null;
        if (this.f10380a == null) goto L48;
        b();
        v r12 = f10378h;     // Catch: Throwable -> L46
        if (r12 == null) goto L48;
        ArrayList r13 = r12.c(j3.class);     // Catch: Throwable -> L46
        if (r13.size() <= 0) goto L37;
        j3 r14 = (j3) r13.get(0);     // Catch: Throwable -> L46
        byte[] r15 = l4.e(r14.f10628a);     // Catch: Throwable -> L44
        if (r15 != null) goto L20;
    L26:
        String r16 = null;
    L27:
        byte[] r17 = l4.e(r14.f10630c);     // Catch: Throwable -> L44
        if (r17 != null) goto L30;
    L36:
        r14.f10630c = r10;     // Catch: Throwable -> L44
        r11 = r16;
    L39:
        if (TextUtils.isEmpty(r11) == true) goto L43;
        AMapLocation r18 = new AMapLocation("");     // Catch: Throwable -> L44
        t3.e(r18, new JSONObject(r11));     // Catch: Throwable -> L44
        if (y3.u(r18) == false) goto L43;
        r14.f10631d = r18;     // Catch: Throwable -> L44
    L43:
        r8 = r14;
        goto L48
    L30:
        if (r17.length <= 0) goto L36;
        byte[] r19 = h3.e(this.f10381b, r17);     // Catch: Throwable -> L44
        if (r19 == null) goto L36;
        if (r19.length <= 0) goto L36;
        r10 = new String(r19, "UTF-8");     // Catch: Throwable -> L44
        goto L36
    L20:
        if (r15.length <= 0) goto L26;
        byte[] r20 = h3.e(this.f10381b, r15);     // Catch: Throwable -> L44
        if (r20 == null) goto L26;
        if (r20.length <= 0) goto L26;
        r16 = new String(r20, "UTF-8");     // Catch: Throwable -> L44
    L44:
        th = th;
        r8 = r14;
    L47:
        t3.g("LastLocationManager", "readLastFix", th);
        goto L48
    L37:
        r14 = null;
    L46:
        th = th;
    L48:
        f10379i = SystemClock.elapsedRealtime();
        if (r8 != null) goto L51;
        return;
    L51:
        if (y3.k(r8.f10631d) == false) goto L60;
        f10377g = r8;
        return;
    L60:
        return;
    L5:
        if ((SystemClock.elapsedRealtime() - f10379i) > 180000) goto L6;
    }
}
