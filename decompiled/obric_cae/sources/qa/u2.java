package qa;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes.dex */
public final class u2 implements p2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f11136k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<v1> f11138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f11139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g3 f11140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c3 f11141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e2 f11142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LocationManager f11143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f11144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p0 f11145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f11146j;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u2 f11147a;

        public a(u2 r8) {
            this.f11147a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r8) {
            u2 r10 = this.f11147a;     // Catch: Throwable -> L12
            if (r10 == null) goto L17;
            r10.getClass();     // Catch: Throwable -> L12
            Handler r11 = r10.f11139c;     // Catch: Throwable -> L9
            if (r11 == null) goto L18;
            r11.post(new b(r10, r8));     // Catch: Throwable -> L9
            goto L20
        L19:
            return;
        L18:
            return;
        L9:
            th = move-exception;
            q.f("cl", "olcc", th);     // Catch: Throwable -> L12
            return;
        L17:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r8) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r8, int r10, Bundle r11) {
        }
    }

    public class b extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11148b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Location f11149m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ u2 f11150n;

        public b(u2 r8, int r10) {
            this.f11150n = r8;
            this.f11148b = 0;
            this.f11148b = r10;
        }

        @Override // qa.m1
        public final void a() {
            int r8 = this.f11148b;
            if (r8 != 1) goto L67;
        L63:
            th = move-exception;
            t3.g("cl", "coll", th);
            return;
        L5:
            if (this.f11149m != null) goto L8;
            return;
        L8:
            if (this.f11150n.f11146j == true) goto L11;
            return;
        L11:
            if (y3.F(this.f11150n.f11137a) == true) goto L134;
            Bundle r10 = this.f11149m.getExtras();     // Catch: Throwable -> L63
            if (r10 == null) goto L16;
            int r11 = r10.getInt("satellites");     // Catch: Throwable -> L63
        L18:
            if (y3.j(this.f11149m, r11) == true) goto L135;
            g3 r12 = this.f11150n.f11140d;     // Catch: Throwable -> L63
            if (r12 != null) goto L23;
        L28:
            g3 r13 = this.f11150n.f11140d;     // Catch: Throwable -> L63
            boolean r14 = r13.f10469o;     // Catch: Throwable -> L63
            ArrayList<n2> r15 = r13.f10457c;     // Catch: Throwable -> L63
            if (r14 == false) goto L32;
            r13.d(true);     // Catch: Throwable -> L63
        L32:
            ArrayList r16 = this.f11150n.f11141e.a();     // Catch: Throwable -> L63
            s1.a r17 = new s1.a();     // Catch: Throwable -> L63
            m2 r18 = new m2();     // Catch: Throwable -> L63
            r18.f10791g = this.f11149m.getAccuracy();     // Catch: Throwable -> L63
            r18.f10788d = this.f11149m.getAltitude();     // Catch: Throwable -> L63
            r18.f10786b = this.f11149m.getLatitude();     // Catch: Throwable -> L63
            r18.f10790f = this.f11149m.getBearing();     // Catch: Throwable -> L63
            r18.f10787c = this.f11149m.getLongitude();     // Catch: Throwable -> L63
            this.f11149m.isFromMockProvider();     // Catch: Throwable -> L63
            this.f11149m.getProvider();     // Catch: Throwable -> L63
            r18.f10789e = this.f11149m.getSpeed();     // Catch: Throwable -> L63
            r18.f10826i = (byte) r11;     // Catch: Throwable -> L63
            System.currentTimeMillis();     // Catch: Throwable -> L63
            r18.f10785a = this.f11149m.getTime();     // Catch: Throwable -> L63
            r18.f10825h = this.f11149m.getTime();     // Catch: Throwable -> L63
            r17.f11026a = r18;     // Catch: Throwable -> L63
            r17.f11027b = r15;     // Catch: Throwable -> L63
            WifiInfo r19 = this.f11150n.f11140d.e();     // Catch: Throwable -> L63
            if (r19 == null) goto L35;
            r17.f11028c = n2.a(r19.getBSSID());     // Catch: Throwable -> L63
        L35:
            r17.f11029d = g3.E;     // Catch: Throwable -> L63
            r17.f11031f = this.f11149m.getTime();     // Catch: Throwable -> L63
            int r20 = k4.d(this.f11150n.f11137a);     // Catch: Throwable -> L38
        L40:
            r17.f11032g = (byte) r20;     // Catch: Throwable -> L63
            Context r21 = this.f11150n.f11137a;     // Catch: Throwable -> L63
            String r22 = "";
            if (k4.k(r21, t4.n("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L48;
            TelephonyManager r23 = (TelephonyManager) r21.getSystemService("phone");     // Catch: Throwable -> L107
            if (r23 == null) goto L48;
            r22 = r23.getNetworkOperatorName();     // Catch: Throwable -> L107
        L48:
            r17.f11033h = r22;     // Catch: Throwable -> L63
            u2 r24 = this.f11150n;     // Catch: Throwable -> L63
            r17.f11030e = r24.f11140d.f10467m;     // Catch: Throwable -> L63
            r17.f11035j = y3.h(r24.f11137a);     // Catch: Throwable -> L63
            r17.f11034i = r16;     // Catch: Throwable -> L63
            v1 r25 = e2.a(r17);     // Catch: Throwable -> L63
            if (r25 == null) goto L136;
            ArrayList<v1> r26 = this.f11150n.f11138b;     // Catch: Throwable -> L63
            monitor-enter(r26);     // Catch: Throwable -> L63
            this.f11150n.f11138b.add(r25);     // Catch: Throwable -> L60
            if (this.f11150n.f11138b.size() < 5) goto L57;
            u2 r27 = this.f11150n;     // Catch: Throwable -> L60
            r27.getClass();     // Catch: Throwable -> L60
            l1.f10784d.a(new b(r27, 3));     // Catch: Throwable -> L108
        L57:
            monitor-exit(r26);     // Catch: Throwable -> L60
            this.f11150n.e();     // Catch: Throwable -> L63
            return;
        L60:
            th = move-exception;
            throw th;     // Catch: Throwable -> L63
        L136:
            return;
        L38:
            r20 = -1;
            goto L40
        L23:
            if (r12.f10469o == true) goto L28;
            r12.f10469o = true;     // Catch: Throwable -> L106
            ArrayList r28 = r12.i();     // Catch: Throwable -> L106
            if (r28 == null) goto L27;
            r12.f10456b.clear();     // Catch: Throwable -> L106
            r12.f10456b.addAll(r28);     // Catch: Throwable -> L106
        L27:
            r12.f(true);     // Catch: Throwable -> L106
            goto L28
        L135:
            return;
        L16:
            r11 = 0;
            goto L18
        L134:
            return;
        L67:
            if (r8 != 2) goto L103;
            u2 r29 = this.f11150n;
            if (y3.F(r29.f11137a) == true) goto L140;
            e0 r30 = null;
            u2.f11136k = System.currentTimeMillis();     // Catch: Throwable -> L91
            if (r29.f11145i.f10889f.e() == false) goto L93;
            r30 = e0.i(new File(r29.f11145i.f10884a), r29.f11145i.f10885b);     // Catch: Throwable -> L91
            ArrayList r31 = new ArrayList();     // Catch: Throwable -> L91
            byte[] r32 = u2.d(128);     // Catch: Throwable -> L91
            if (r32 == null) goto L112;
            ArrayList r33 = u2.b(r30, r29.f11145i, r31, r32);     // Catch: Throwable -> L91
            if (r33.size() == 0) goto L112;
            r29.f11145i.f10889f.a();     // Catch: Throwable -> L91
            byte[] r34 = l4.f(r32, e2.c(), t4.o());     // Catch: Throwable -> L91
            if (e2.b(t4.m(e2.d(h3.c(r32), r34, r33))) == false) goto L93;
            Iterator r35 = r31.iterator();     // Catch: Throwable -> L88
        L84:
            if (r35.hasNext() == false) goto L86;
            r30.x((String) r35.next());     // Catch: Throwable -> L88
            goto L84
        L86:
            r30.close();     // Catch: Throwable -> L88
        L88:
            th = move-exception;
            q.f("aps", "dlo", th);     // Catch: Throwable -> L91
        L112:
            r30.close();     // Catch: Throwable -> L110
            return;
        L141:
            return;
        L93:
            if (r30 != null) goto L112;
            return;
        L91:
            th = move-exception;
            q.f("leg", "uts", th);     // Catch: Throwable -> L99
            if (r30 != null) goto L112;
            return;
        L99:
            th = move-exception;
            if (r30 != null) goto L125;
        L102:
            throw th;
        L125:
            r30.close();     // Catch: Throwable -> L109
            goto L102
        L140:
            return;
        L103:
            if (r8 != 3) goto L142;
            this.f11150n.f();
            return;
        }

        public b(u2 r8, Location r10) {
            this(r8, 1);
            this.f11149m = r10;
        }
    }

    public u2(Context r10) {
        this.f11137a = null;
        this.f11138b = new ArrayList();
        this.f11140d = null;
        this.f11141e = null;
        this.f11146j = false;
        this.f11137a = r10;
        p0 r8 = new p0();
        this.f11145i = r8;
        Vector<s4> r11 = n.f10841b;
        v0.b(r10, r8, "k", 100, 1024000, "0");
        int r12 = s3.F;
        boolean r13 = s3.D;
        int r14 = s3.E;
        r8.f10889f = new h1(r10, r12, "kKey", new f1(r10, r13, r14, r14 * 10));
        r8.f10888e = new a0(0);
    }

    public static ArrayList b(e0 r17, p0 r18, ArrayList r19, byte[] r20) {
        e0 r8 = r17;
        ArrayList r10 = new ArrayList();
        File r11 = r8.f10341a;     // Catch: Throwable -> L66
        if (r11 != null) goto L6;
    L68:
        return r10;
    L6:
        if (r11.exists() == false) goto L68;
        String[] r12 = r11.list();     // Catch: Throwable -> L66
        if (r12 == null) goto L68;
        int r13 = r12.length;     // Catch: Throwable -> L66
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L11:
        if (r15 >= r13) goto L68;
        String r21 = r12[r15];     // Catch: Throwable -> L66
        if (r21.contains(".0") == false) goto L65;
        InputStream r22 = null;
        String r23 = r21.split("\\.")[r14];     // Catch: Throwable -> L58
        e0.e r24 = r8.a(r23);     // Catch: Throwable -> L58
        if (r24 != null) goto L80;
        if (r24 == null) goto L65;
    L100:
        r24.close();     // Catch: Throwable -> L76
        goto L65
    L80:
        r22 = r24.f10362a[r14];     // Catch: Throwable -> L57
        if (r22 != null) goto L25;
        if (r22 == null) goto L100;
        r22.close();     // Catch: Throwable -> L69
        goto L100
    L25:
        int r110 = 2;
        byte[] r111 = new byte[2];     // Catch: Throwable -> L57
        r22.read(r111);     // Catch: Throwable -> L57
        int r112 = r14;
        int r113 = r112;
    L27:
        if (r112 >= 2) goto L29;
        r113 = r113 | ((r111[r112] & 255) << ((1 - r112) * 8));     // Catch: Throwable -> L57
        r112 = r112 + 1;     // Catch: Throwable -> L57
        goto L27
    L29:
        if (r113 != 0) goto L31;
    L104:
        r22.close();     // Catch: Throwable -> L75
    L90:
        r24.close();     // Catch: Throwable -> L77
        goto L68
    L31:
        if (r113 > 65535) goto L104;
        byte[] r114 = new byte[r113];     // Catch: Throwable -> L57
        r22.read(r114);     // Catch: Throwable -> L57
        byte[] r115 = new byte[2];     // Catch: Throwable -> L57
        int r116 = r14;
    L35:
        if (r22.read(r115) < 0) goto L45;
        int r117 = r14;
        int r118 = r117;
    L37:
        if (r117 >= r110) goto L40;
        r118 = r118 | ((r115[r117] & 255) << ((1 - r117) * 8));     // Catch: Throwable -> L39
        r117 = r117 + 1;     // Catch: Throwable -> L39
    L40:
        byte[] r25 = new byte[r118];     // Catch: Throwable -> L39
        r22.read(r25);     // Catch: Throwable -> L39
        byte[] r26 = l4.c(r114, r25, t4.o());     // Catch: Throwable -> L39
        r116 = r116 + r26.length;     // Catch: Throwable -> L39
        byte[] r119 = new byte[4];     // Catch: Throwable -> L39
        r22.read(r119);     // Catch: Throwable -> L39
        r10.add(new v1(((((r119[r110] & 255) << 8) | (r119[3] & 255)) | ((r119[1] & 255) << 16)) | ((r119[0] & 255) << 24), l4.f(r20, t4.m(r26), t4.o())));     // Catch: Throwable -> L70
        r14 = 0;
        r110 = 2;
        goto L35
    L45:
        r16 = r16 + r116;
        r19.add(r23);     // Catch: Throwable -> L53
        if (r16 > r18.f10889f.d()) goto L104;
        r22.close();     // Catch: Throwable -> L73
    L78:
        r24.close();     // Catch: Throwable -> L74
    L59:
        if (r22 != null) goto L94;
    L61:
        if (r24 == null) goto L65;
    L94:
        r22.close();     // Catch: Throwable -> L72
    L58:
        r24 = null;
    L65:
        r15 = r15 + 1;
        r8 = r17;
        r14 = 0;
    L66:
        th = move-exception;
        q.f("aps", "upc", th);
        goto L68
    }

    public static byte[] d(int r8) {
        KeyGenerator r10 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        r10.init(r8);     // Catch: Throwable -> L8
        return r10.generateKey().getEncoded();
    L8:
        return null;
    }

    public final e6.a a(o2 r8) {
        n3 r10 = new n3();     // Catch: Throwable -> L4
        r10.f10859k = r8.f10873b;     // Catch: Throwable -> L4
        r10.f10860l = r8.f10872a;     // Catch: Throwable -> L4
        r10.f10861m = r8.f10874c;     // Catch: Throwable -> L4
        h0.c();     // Catch: Throwable -> L4
        n0 r11 = h0.a(r10);     // Catch: Throwable -> L4
        e6.a r12 = new e6.a();     // Catch: Throwable -> L4
        r12.f7126c = r11.f10842a;     // Catch: Throwable -> L4
        r12.f7125b = r11.f10843b;     // Catch: Throwable -> L4
        r12.f7124a = 200;     // Catch: Throwable -> L4
        return r12;
    L4:
        return null;
    }

    public final void c(c3 r8, g3 r10, Handler r11) {
        if (this.f11146j == false) goto L5;
        return;
    L5:
        if (r8 == null) goto L44;
        if (r10 == null) goto L45;
        if (r11 != null) goto L10;
        return;
    L10:
        if (y3.F(this.f11137a) == false) goto L12;
        return;
    L12:
        this.f11146j = true;
        this.f11141e = r8;
        this.f11140d = r10;
        r10.f10475u = this;
        r8.f10287w = this;
        this.f11139c = r11;
    L38:
        th = move-exception;
        t3.g("col", "init", th);
        return;
    L14:
        if (this.f11143g != null) goto L17;
        this.f11143g = (LocationManager) this.f11137a.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L38
    L17:
        if (this.f11144h != null) goto L19;
        this.f11144h = new a(this);     // Catch: Throwable -> L38
    L19:
        a r12 = this.f11144h;     // Catch: Throwable -> L38
        r12.f11147a = this;     // Catch: Throwable -> L38
        LocationManager r13 = this.f11143g;     // Catch: Throwable -> L38
        if (r13 == null) goto L23;
        r13.requestLocationUpdates("passive", 1000, -1.0f, r12);     // Catch: Throwable -> L38
    L23:
        if (this.f11142f != null) goto L43;
        this.f11142f = new e2(h4.g(this.f11137a), h4.d(this.f11137a), this);     // Catch: Throwable -> L38
        l6.a.f9145n = "";     // Catch: Throwable -> L38
        String r14 = k4.m(this.f11137a);     // Catch: Throwable -> L38
        if (r14 == null) goto L27;
        l6.a.f9146o = r14;     // Catch: Throwable -> L38
    L27:
        String r15 = k4.h(this.f11137a);     // Catch: Throwable -> L38
        if (r15 == null) goto L30;
        l6.a.f9147p = r15;     // Catch: Throwable -> L38
    L30:
        k4.l(this.f11137a);     // Catch: Throwable -> L38
        l6.a.f9148q = "";     // Catch: Throwable -> L38
        String r16 = Build.MODEL;     // Catch: Throwable -> L38
        if (r16 == null) goto L33;
        l6.a.f9149r = r16;     // Catch: Throwable -> L38
    L33:
        String r17 = Build.MANUFACTURER;     // Catch: Throwable -> L38
        if (r17 == null) goto L36;
        l6.a.f9150s = r17;     // Catch: Throwable -> L38
    L36:
        String r18 = Build.BRAND;     // Catch: Throwable -> L38
        l6.a.f9151t = Build.VERSION.SDK_INT;     // Catch: Throwable -> L38
        String r19 = Build.VERSION.RELEASE;     // Catch: Throwable -> L38
        n2.a("");     // Catch: Throwable -> L38
        l6.a.f9152u = "";     // Catch: Throwable -> L38
        return;
    L43:
        return;
    L45:
        return;
    }

    public final void e() {
        if (y3.F(this.f11137a) == false) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - f11136k) >= 60000) goto L8;
        return;
    L8:
        l1.f10784d.a(new b(this, 2));     // Catch: Throwable -> L10
        return;
    }

    public final void f() {
    L31:
        th = move-exception;
        t3.g("clm", "wtD", th);
        return;
    L3:
        if (y3.F(this.f11137a) == false) goto L5;
        return;
    L5:
        ArrayList<v1> r8 = this.f11138b;     // Catch: Throwable -> L31
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.size() == 0) goto L44;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L31
        ArrayList<v1> r11 = this.f11138b;     // Catch: Throwable -> L31
        monitor-enter(r11);     // Catch: Throwable -> L31
        r10.addAll(this.f11138b);     // Catch: Throwable -> L27
        this.f11138b.clear();     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Throwable -> L31
        byte[] r13 = d(256);     // Catch: Throwable -> L31
        if (r13 != null) goto L17;
        return;
    L17:
        int r14 = r13.length;     // Catch: Throwable -> L31
        r12.write(new byte[]{(byte) ((r14 & 65280) >> 8), (byte) (r14 & 255)});     // Catch: Throwable -> L31
        r12.write(r13);     // Catch: Throwable -> L31
        Iterator r15 = r10.iterator();     // Catch: Throwable -> L31
    L19:
        if (r15.hasNext() == false) goto L25;
        v1 r16 = (v1) r15.next();     // Catch: Throwable -> L31
        byte[] r17 = r16.f11157b;     // Catch: Throwable -> L31
        if (r17.length < 10) goto L19;
        if (r17.length > 65535) goto L19;
        byte[] r18 = l4.f(r13, r17, t4.o());     // Catch: Throwable -> L31
        int r19 = r18.length;     // Catch: Throwable -> L31
        r12.write(new byte[]{(byte) ((r19 & 65280) >> 8), (byte) (r19 & 255)});     // Catch: Throwable -> L31
        r12.write(r18);     // Catch: Throwable -> L31
        int r20 = r16.f11156a;     // Catch: Throwable -> L31
        r12.write(new byte[]{(byte) ((r20 >> 24) & 255), (byte) ((r20 >> 16) & 255), (byte) ((r20 >> 8) & 255), (byte) (r20 & 255)});     // Catch: Throwable -> L31
        goto L19
    L25:
        q0.a(Long.toString(System.currentTimeMillis()), r12.toByteArray(), this.f11145i);     // Catch: Throwable -> L31
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    }
}
