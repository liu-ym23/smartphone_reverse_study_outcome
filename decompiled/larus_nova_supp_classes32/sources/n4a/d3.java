package n4a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.loc.dv;
import com.lynx.tasm.event.LynxTouchEvent;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d3 implements z2 {
    public static long k;
    public final Context a;
    public final ArrayList<v1> b;
    public Handler c;
    public s3 d;
    public l3 e;
    public q2 f;
    public LocationManager g;
    public a h;
    public final n0 i;
    public volatile boolean j;

    public static class a implements LocationListener {
        public d3 a;

        public a(d3 r1) {
            this.a = r1;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r20) {
            ArrayList r1 = new ArrayList();
            Object[] r2 = {r20};
            f06.b r12 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(100038);
            if (r3 == null) goto L5;
            f06.a[] r4 = r3.i;
        L6:
            f06.a[] r10 = r4;
            int r9 = r10.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r10[r8];
            int r16 = r8;
            int r17 = r9;
            f06.a[] r18 = r10;
            f06.d r5 = r7.preInvoke(100038, "com/loc/eo$a", "onLocationChanged", this, r2, "void", r12);     // Catch: Exception -> L30
            if (r5.a == true) goto L17;
            r1.add(r7);     // Catch: Exception -> L30
        L17:
            if (r5.a == false) goto L32;
            return;
        L32:
            d3 r6 = this.a;     // Catch: Throwable -> L29
            if (r6 != null) goto L34;
        L31:
            return;
        L34:
            Handler r11 = r6.c;     // Catch: Throwable -> L26
            if (r11 == null) goto L31;
            r11.post(new b(r6, r20));     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            r.f(th, "cl", "olcc");     // Catch: Throwable -> L29
        L41:
            return;
        L14:
            r8 = r16 + 1;
            r9 = r17;
            r10 = r18;
            goto L8
        L15:
            r5 = new f06.d(false, null);
            goto L17
        L5:
            r4 = ApiHookConfig.d;
            goto L6
        }
    }

    public class b extends l1 {
        public final int b;
        public final Location c;
        public final /* synthetic */ d3 d;

        public b(d3 r1, int r2) {
            this.d = r1;
            this.b = 0;
            this.b = r2;
        }

        public b(d3 r2, Location r3) {
            this(r2, 1);
            this.c = r3;
        }

        @Override // n4a.l1
        public final void a() {
            int r0 = this.b;
            if (r0 != 1) goto L67;
        L63:
            th = move-exception;
            c4.g(th, "cl", "coll");
            return;
        L5:
            if (this.c != null) goto L8;
            return;
        L8:
            if (this.d.j == true) goto L11;
            return;
        L11:
            if (j4.J(this.d.a) == true) goto L146;
            Bundle r1 = this.c.getExtras();     // Catch: Throwable -> L63
            if (r1 == null) goto L16;
            int r2 = r1.getInt("satellites");     // Catch: Throwable -> L63
        L18:
            if (j4.k(this.c, r2) == true) goto L147;
            s3 r3 = this.d.d;     // Catch: Throwable -> L63
            if (r3 != null) goto L23;
        L28:
            s3 r4 = this.d.d;     // Catch: Throwable -> L63
            if (r4.o == true) goto L31;
        L30:
            ArrayList<v2> r5 = r4.c;     // Catch: Throwable -> L63
            List<dv> r6 = this.d.e.a();     // Catch: Throwable -> L63
            s1.a r7 = new s1.a();     // Catch: Throwable -> L63
            u2 r8 = new u2();     // Catch: Throwable -> L63
            r8.g = this.c.getAccuracy();     // Catch: Throwable -> L63
            r8.d = this.c.getAltitude();     // Catch: Throwable -> L63
            r8.b = this.c.getLatitude();     // Catch: Throwable -> L63
            r8.f = this.c.getBearing();     // Catch: Throwable -> L63
            r8.c = this.c.getLongitude();     // Catch: Throwable -> L63
            this.c.isFromMockProvider();     // Catch: Throwable -> L63
            this.c.getProvider();     // Catch: Throwable -> L63
            r8.e = this.c.getSpeed();     // Catch: Throwable -> L63
            r8.i = (byte) r2;     // Catch: Throwable -> L63
            System.currentTimeMillis();     // Catch: Throwable -> L63
            r8.a = this.c.getTime();     // Catch: Throwable -> L63
            r8.h = this.c.getTime();     // Catch: Throwable -> L63
            r7.a = r8;     // Catch: Throwable -> L63
            r7.b = r5;     // Catch: Throwable -> L63
            WifiInfo r9 = this.d.d.e();     // Catch: Throwable -> L63
            if (r9 == null) goto L35;
            r7.c = v2.a(p3.a(r9));     // Catch: Throwable -> L63
        L35:
            r7.d = s3.E;     // Catch: Throwable -> L63
            r7.f = this.c.getTime();     // Catch: Throwable -> L63
            int r10 = x4.d(this.d.a);     // Catch: Throwable -> L38
        L40:
            r7.g = (byte) r10;     // Catch: Throwable -> L63
            Context r11 = this.d.a;     // Catch: Throwable -> L63
            String r12 = NameKeys.UnloadStrategy_No_Strategy;
            if (x4.m(r11, f5.o("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) == false) goto L48;
            TelephonyManager r13 = (TelephonyManager) r11.getSystemService("phone");     // Catch: Throwable -> L114
            if (r13 == null) goto L48;
            r12 = r13.getNetworkOperatorName();     // Catch: Throwable -> L114
        L48:
            r7.h = r12;     // Catch: Throwable -> L63
            d3 r14 = this.d;     // Catch: Throwable -> L63
            r7.e = r14.d.m;     // Catch: Throwable -> L63
            r7.j = j4.i(r14.a);     // Catch: Throwable -> L63
            r7.i = r6;     // Catch: Throwable -> L63
            v1 r15 = q2.a(r7);     // Catch: Throwable -> L63
            if (r15 == null) goto L148;
            ArrayList<v1> r16 = this.d.b;     // Catch: Throwable -> L63
            monitor-enter(r16);     // Catch: Throwable -> L63
            this.d.b.add(r15);     // Catch: Throwable -> L60
            if (this.d.b.size() < 5) goto L57;
            d3 r17 = this.d;     // Catch: Throwable -> L60
            r17.getClass();     // Catch: Throwable -> L60
            k1.d.b(new b(r17, 3));     // Catch: Throwable -> L115
        L57:
            monitor-exit(r16);     // Catch: Throwable -> L60
            this.d.d();     // Catch: Throwable -> L63
            return;
        L60:
            th = move-exception;
            throw th;     // Catch: Throwable -> L63
        L148:
            return;
        L38:
            r10 = -1;
            goto L40
        L31:
            r4.d(true);     // Catch: Throwable -> L63
            goto L30
        L23:
            if (r3.o == true) goto L28;
            r3.o = true;     // Catch: Throwable -> L113
            List<v2> r18 = r3.k();     // Catch: Throwable -> L113
            if (r18 == null) goto L27;
            r3.b.clear();     // Catch: Throwable -> L113
            r3.b.addAll(r18);     // Catch: Throwable -> L113
        L27:
            r3.h(true);     // Catch: Throwable -> L113
            goto L28
        L147:
            return;
        L16:
            r2 = 0;
            goto L18
        L146:
            return;
        L67:
            if (r0 == 2) goto L69;
            if (r0 != 3) goto L154;
            this.d.e();
            return;
        L154:
            return;
        L69:
            if (j4.J(this.d.a) == true) goto L152;
            h0 r19 = null;
            byte[] r20 = null;
            r20 = null;
            d3.k = System.currentTimeMillis();     // Catch: Throwable -> L100
            if (this.d.i.f.e() == false) goto L98;
            h0 r21 = h0.b(new PolarisFileWrapper(this.d.i.a), this.d.i.b);     // Catch: Throwable -> L100
            ArrayList r22 = new ArrayList();     // Catch: Throwable -> L96
            KeyGenerator r23 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L116
            if (r23 == null) goto L80;
            r23.init(LynxTouchEvent.kPseudoStateFocusTransition);     // Catch: Throwable -> L116
            r20 = r23.generateKey().getEncoded();     // Catch: Throwable -> L116
        L80:
            if (r20 == null) goto L133;
            List r24 = d3.a(r21, this.d.i, r22, r20);     // Catch: Throwable -> L96
            if (((ArrayList) r24).size() == 0) goto L133;
            this.d.i.f.a();     // Catch: Throwable -> L96
            if (q2.b(f5.n(q2.d(t3.b(r20), y4.f(r20, q2.c(), f5.p()), r24))) == true) goto L128;
        L95:
            r19 = r21;
            goto L98
        L128:
            Iterator r25 = r22.iterator();     // Catch: Throwable -> L93
        L89:
            if (r25.hasNext() == false) goto L91;
            r21.h((String) r25.next());     // Catch: Throwable -> L93
            goto L89
        L91:
            r21.close();     // Catch: Throwable -> L93
        L93:
            th = move-exception;
            r.f(th, "aps", "dlo");     // Catch: Throwable -> L96
        L133:
            r21.close();     // Catch: Throwable -> L118
            return;
        L153:
            return;
        L96:
            Throwable th = th;
        L137:
            r.f(th, "leg", "uts");     // Catch: Throwable -> L106
            if (r21 != null) goto L133;
            return;
        L106:
            th = move-exception;
            if (r21 != null) goto L119;
        L109:
            throw th;
        L119:
            r21.close();     // Catch: Throwable -> L117
        L98:
            if (r19 == null) goto L150;
            r21 = r19;
            goto L133
        L150:
            return;
        L100:
            th = move-exception;
            r21 = null;
            th = th;
            goto L137
        }
    }

    public d3(Context r8) {
        this.a = null;
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.j = false;
        this.a = r8;
        n0 r0 = new n0();
        this.i = r0;
        Vector<e5> r1 = p.b;
        t0.b(r8, r0, "k", 100, 1024000, "0");
        int r2 = com.loc.h.F;
        boolean r4 = com.loc.h.D;
        int r5 = com.loc.h.E;
        r0.f = new g1(r8, r2, "kKey", new e1(r8, r4, r5, r5 * 10));
        r0.e = new z();
    }

    public final void d() {
        if (j4.J(this.a) == false) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - k) >= AutoEndConversationTime.AFTER_60_SECONDS) goto L8;
        return;
    L8:
        k1.d.b(new b(this, 2));     // Catch: Throwable -> L10
        return;
    }

    public final void e() {
    L36:
        th = move-exception;
        c4.g(th, "clm", "wtD");
        return;
    L3:
        if (j4.J(this.a) == false) goto L5;
        return;
    L5:
        ArrayList<v1> r0 = this.b;     // Catch: Throwable -> L36
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.size() == 0) goto L52;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L36
        ArrayList<v1> r2 = this.b;     // Catch: Throwable -> L36
        monitor-enter(r2);     // Catch: Throwable -> L36
        r1.addAll(this.b);     // Catch: Throwable -> L32
        this.b.clear();     // Catch: Throwable -> L32
        monitor-exit(r2);     // Catch: Throwable -> L32
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L36
        byte[] r4 = null;
        KeyGenerator r5 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L39
        if (r5 == null) goto L20;
        r5.init(256);     // Catch: Throwable -> L39
        r4 = r5.generateKey().getEncoded();     // Catch: Throwable -> L39
    L20:
        if (r4 != null) goto L22;
        return;
    L22:
        int r6 = r4.length;     // Catch: Throwable -> L36
        r3.write(new byte[]{(byte) ((r6 & 65280) >> 8), (byte) (r6 & 255)});     // Catch: Throwable -> L36
        r3.write(r4);     // Catch: Throwable -> L36
        Iterator r7 = r1.iterator();     // Catch: Throwable -> L36
    L24:
        if (r7.hasNext() == false) goto L30;
        v1 r8 = (v1) r7.next();     // Catch: Throwable -> L36
        byte[] r9 = r8.b;     // Catch: Throwable -> L36
        if (r9.length < 10) goto L24;
        if (r9.length > 65535) goto L24;
        byte[] r10 = y4.f(r4, r9, f5.p());     // Catch: Throwable -> L36
        int r11 = r10.length;     // Catch: Throwable -> L36
        r3.write(new byte[]{(byte) ((r11 & 65280) >> 8), (byte) (r11 & 255)});     // Catch: Throwable -> L36
        r3.write(r10);     // Catch: Throwable -> L36
        int r12 = r8.a;     // Catch: Throwable -> L36
        r3.write(new byte[]{(byte) ((r12 >> 24) & 255), (byte) ((r12 >> 16) & 255), (byte) ((r12 >> 8) & 255), (byte) (r12 & 255)});     // Catch: Throwable -> L36
        goto L24
    L30:
        o0.a(Long.toString(System.currentTimeMillis()), r3.toByteArray(), this.i);     // Catch: Throwable -> L36
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    }

    public static void c(LocationManager r19, a r20) {
        ArrayList r0 = new ArrayList();
        Object[] r2 = {"passive", 1000L, Float.valueOf(-1.0f), r20};
        f06.b r12 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(100001);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r16 = r8;
        int r17 = r9;
        f06.a[] r18 = r10;
        f06.d r5 = r7.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r19, r2, "void", r12);     // Catch: Exception -> L21
        if (r5.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r5.a == false) goto L19;
        return;
    L19:
        r19.requestLocationUpdates("passive", 1000, -1.0f, r20);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        r10 = r18;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public final void b(l3 r3, s3 r4, Handler r5) {
        if (this.j == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L49;
        if (r4 == null) goto L50;
        if (r5 != null) goto L10;
        return;
    L10:
        if (j4.J(this.a) == false) goto L12;
        return;
    L12:
        this.j = true;
        this.e = r3;
        this.d = r4;
        r4.u = this;
        r3.w = this;
        this.c = r5;
    L43:
        th = move-exception;
        c4.g(th, "col", "init");
        return;
    L14:
        if (this.g != null) goto L17;
        this.g = (LocationManager) this.a.getSystemService("location");     // Catch: Throwable -> L43
    L17:
        if (this.h != null) goto L19;
        this.h = new a(this);     // Catch: Throwable -> L43
    L19:
        a r6 = this.h;     // Catch: Throwable -> L43
        r6.a = this;     // Catch: Throwable -> L43
        LocationManager r7 = this.g;     // Catch: Throwable -> L43
        if (r7 == null) goto L26;
        if (fna.g.d() == true) goto L24;
        c(r7, r6);     // Catch: Throwable -> L43
        goto L26
    L24:
        c(r7, r6);     // Catch: Throwable -> L43
        nna.a.c(r6.hashCode());     // Catch: Throwable -> L43
    L26:
        if (this.f != null) goto L48;
        this.f = new q2(v4.g(this.a), v4.d(this.a), this);     // Catch: Throwable -> L43
        w2.f = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L43
        String r8 = x4.q(this.a);     // Catch: Throwable -> L43
        if (r8 == null) goto L30;
        w2.g = r8;     // Catch: Throwable -> L43
    L31:
        String r9 = x4.j(this.a);     // Catch: Throwable -> L43
        if (r9 == null) goto L34;
        w2.h = r9;     // Catch: Throwable -> L43
    L35:
        x4.p(this.a);     // Catch: Throwable -> L43
        byte r10 = w2.a;     // Catch: Throwable -> L43
        w2.i = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L43
        String r11 = Build.MODEL;     // Catch: Throwable -> L43
        if (r11 == null) goto L38;
        w2.j = r11;     // Catch: Throwable -> L43
    L38:
        String r12 = Build.MANUFACTURER;     // Catch: Throwable -> L43
        if (r12 == null) goto L41;
        w2.k = r12;     // Catch: Throwable -> L43
    L41:
        String r13 = Build.BRAND;     // Catch: Throwable -> L43
        w2.l = Build.VERSION.SDK_INT;     // Catch: Throwable -> L43
        String r14 = Build.VERSION.RELEASE;     // Catch: Throwable -> L43
        v2.a(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L43
        w2.m = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L43
        return;
    L34:
        byte r15 = w2.a;     // Catch: Throwable -> L43
        goto L35
    L30:
        byte r16 = w2.a;     // Catch: Throwable -> L43
        goto L31
    L48:
        return;
    L50:
        return;
    }

    public static List a(h0 r17, n0 r18, List r19, byte[] r20) {
        h0 r0 = r17;
        ArrayList r1 = new ArrayList();
        File r2 = r0.a;     // Catch: Throwable -> L75
        if (r2 != null) goto L6;
    L77:
        return r1;
    L6:
        if (r2.exists() == false) goto L77;
        String[] r3 = r2.list();     // Catch: Throwable -> L75
        if (r3 == null) goto L77;
        int r4 = r3.length;     // Catch: Throwable -> L75
        char r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L11:
        if (r6 >= r4) goto L77;
        String r8 = r3[r6];     // Catch: Throwable -> L75
        if (r8.contains(".0") == false) goto L74;
        InputStream r9 = null;
        String r10 = r8.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[r5];     // Catch: Throwable -> L65
        h0.e r11 = r0.a(r10);     // Catch: Throwable -> L65
        if (r11 != null) goto L106;
        if (r11 == null) goto L74;
    L98:
        r11.close();     // Catch: Throwable -> L84
        goto L74
    L106:
        r9 = r11.a[r5];     // Catch: Throwable -> L64
        if (r9 != null) goto L25;
        if (r9 == null) goto L98;
        r9.close();     // Catch: Throwable -> L78
        goto L98
    L25:
        int r12 = 2;
        byte[] r13 = new byte[2];     // Catch: Throwable -> L64
        r9.read(r13);     // Catch: Throwable -> L64
        int r14 = 0;
        int r15 = 0;
    L28:
        if (r14 >= 2) goto L32;
        r15 = r15 | ((r13[r14] & 255) << ((1 - r14) * 8));
        r14 = r14 + 1;
        goto L28
    L32:
        if (r15 != 0) goto L34;
    L102:
        r9.close();     // Catch: Throwable -> L83
    L114:
        r11.close();     // Catch: Throwable -> L85
        goto L77
    L34:
        if (r15 > 65535) goto L102;
        byte[] r16 = new byte[r15];     // Catch: Throwable -> L64
        r9.read(r16);     // Catch: Throwable -> L64
        byte[] r110 = new byte[2];     // Catch: Throwable -> L64
        int r111 = 0;
    L37:
        if (r9.read(r110) < 0) goto L51;
        int r112 = 0;
        int r113 = 0;
    L40:
        if (r112 < r12) goto L112;
        byte[] r21 = new byte[r113];     // Catch: Throwable -> L48
        r9.read(r21);     // Catch: Throwable -> L48
        byte[] r22 = y4.c(r16, r21, f5.p());     // Catch: Throwable -> L48
        r111 = r111 + r22.length;     // Catch: Throwable -> L48
        byte[] r114 = new byte[4];     // Catch: Throwable -> L48
        r9.read(r114);     // Catch: Throwable -> L48
        r1.add(new v1(((((r114[r12] & 255) << 8) | (r114[3] & 255)) | ((r114[1] & 255) << 16)) | ((r114[0] & 255) << 24), y4.f(r20, f5.n(r22), f5.p())));     // Catch: Throwable -> L79
        r12 = 2;
        goto L37
    L112:
        r113 = r113 | ((r110[r112] & 255) << ((1 - r112) * 8));
        r112 = r112 + 1;
        goto L40
    L51:
        r7 = r7 + r111;
        ((ArrayList) r19).add(r10);     // Catch: Throwable -> L59
        if (r7 > r18.f.d()) goto L102;
        r9.close();     // Catch: Throwable -> L80
    L104:
        r11.close();     // Catch: Throwable -> L81
    L66:
        if (r9 != null) goto L116;
    L70:
        if (r11 == null) goto L74;
    L116:
        r9.close();     // Catch: Throwable -> L69
    L65:
        r11 = null;
    L74:
        r6 = r6 + 1;
        r0 = r17;
        r5 = 0;
    L75:
        th = move-exception;
        r.f(th, "aps", "upc");
        goto L77
    }
}
