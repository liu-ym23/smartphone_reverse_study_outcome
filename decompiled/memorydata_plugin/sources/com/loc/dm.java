package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes3.dex */
public final class dm implements dh {
    private static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f5446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    eg f5447b;
    du c;
    cv d;
    as e;
    private ArrayList<ca> f;
    private Handler g;
    private LocationManager h;
    private a i;
    private volatile boolean j;

    static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private dm f5449a;

        a(dm r1) {
            this.f5449a = r1;
        }

        final void a() {
            this.f5449a = null;
        }

        final void a(dm r1) {
            this.f5449a = r1;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r1) {
            dm r0 = this.f5449a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
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
    }

    class b extends bq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ dm f5450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5451b;
        private Location c;

        b(dm r1, int r2) {
            this.f5450a = r1;
            this.f5451b = 0;
            this.f5451b = r2;
        }

        b(dm r2, Location r3) {
            this(r2, 1);
            this.c = r3;
        }

        private void b() {
            Object[] r1 = new Object[1];     // Catch: Throwable -> L41
            ex.a();     // Catch: Throwable -> L41
            if (this.c != null) goto L7;
            return;
        L7:
            if (dm.a(this.f5450a) == true) goto L10;
            return;
        L10:
            if (fd.m(this.f5450a.f5446a) == false) goto L13;
            Object[] r7 = new Object[1];     // Catch: Throwable -> L41
            ex.a();     // Catch: Throwable -> L41
            return;
        L13:
            Bundle r0 = this.c.getExtras();     // Catch: Throwable -> L41
            int r2 = 0;
            if (r0 == null) goto L17;
            r2 = r0.getInt("satellites");     // Catch: Throwable -> L41
        L17:
            if (fd.a(this.c, r2) == false) goto L20;
            return;
        L20:
            if (this.f5450a.f5447b != null) goto L22;
        L24:
            ArrayList<db> r3 = this.f5450a.f5447b.a();     // Catch: Throwable -> L41
            List<dv> r4 = this.f5450a.c.a();     // Catch: Throwable -> L41
            by.a r5 = new by.a();     // Catch: Throwable -> L41
            da r6 = new da();     // Catch: Throwable -> L41
            r6.i = this.c.getAccuracy();     // Catch: Throwable -> L41
            r6.f = this.c.getAltitude();     // Catch: Throwable -> L41
            r6.d = this.c.getLatitude();     // Catch: Throwable -> L41
            r6.h = this.c.getBearing();     // Catch: Throwable -> L41
            r6.e = this.c.getLongitude();     // Catch: Throwable -> L41
            r6.j = this.c.isFromMockProvider();     // Catch: Throwable -> L41
            r6.f5421a = this.c.getProvider();     // Catch: Throwable -> L41
            r6.g = this.c.getSpeed();     // Catch: Throwable -> L41
            r6.l = (byte) r2;     // Catch: Throwable -> L41
            r6.f5422b = System.currentTimeMillis();     // Catch: Throwable -> L41
            r6.c = this.c.getTime();     // Catch: Throwable -> L41
            r6.k = this.c.getTime();     // Catch: Throwable -> L41
            r5.f5389a = r6;     // Catch: Throwable -> L41
            r5.f5390b = r3;     // Catch: Throwable -> L41
            WifiInfo r8 = this.f5450a.f5447b.c();     // Catch: Throwable -> L41
            if (r8 == null) goto L27;
            r5.c = db.a(ed.a(r8));     // Catch: Throwable -> L41
        L27:
            r5.d = eg.z;     // Catch: Throwable -> L41
            r5.f = this.c.getTime();     // Catch: Throwable -> L41
            r5.g = (byte) fp.i(this.f5450a.f5446a);     // Catch: Throwable -> L41
            r5.h = fp.n(this.f5450a.f5446a);     // Catch: Throwable -> L41
            r5.e = this.f5450a.f5447b.l();     // Catch: Throwable -> L41
            r5.j = fd.a(this.f5450a.f5446a);     // Catch: Throwable -> L41
            r5.i = r4;     // Catch: Throwable -> L41
            ca r9 = cv.a(r5);     // Catch: Throwable -> L41
            if (r9 != null) goto L30;
            return;
        L30:
            ArrayList r10 = dm.b(this.f5450a);     // Catch: Throwable -> L41
            monitor-enter(r10);     // Catch: Throwable -> L41
            dm.b(this.f5450a).add(r9);     // Catch: Throwable -> L38
            if (dm.b(this.f5450a).size() < 5) goto L35;
            this.f5450a.e();     // Catch: Throwable -> L38
        L35:
            monitor-exit(r10);     // Catch: Throwable -> L38
            this.f5450a.d();     // Catch: Throwable -> L41
            return;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L41
        L22:
            if (this.f5450a.f5447b.s == true) goto L24;
            this.f5450a.f5447b.f();     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            ev.a(th, "cl", "coll");
        }

        private void c() {
            Object[] r1 = new Object[1];
            ex.a();
            if (fd.m(this.f5450a.f5446a) == false) goto L6;
            Object[] r6 = new Object[1];
            ex.a();
            return;
        L6:
            ah r2 = null;
            dm.a(System.currentTimeMillis());     // Catch: Throwable -> L27
            if (this.f5450a.e.f.c() == false) goto L24;
            r2 = ah.a(new File(this.f5450a.e.f5328a), this.f5450a.e.f5329b);     // Catch: Throwable -> L27
            ArrayList r3 = new ArrayList();     // Catch: Throwable -> L27
            byte[] r4 = dm.f();     // Catch: Throwable -> L27
            if (r4 == null) goto L53;
            List r5 = dm.a(r2, this.f5450a.e, r3, r4);     // Catch: Throwable -> L27
            if (r5 != null) goto L16;
        L51:
            r2.close();     // Catch: Throwable -> L36
            return;
        L56:
            return;
        L16:
            if (r5.size() == 0) goto L51;
            this.f5450a.e.f.a(true);     // Catch: Throwable -> L27
            byte[] r7 = fq.b(r4, cv.a(), fx.c());     // Catch: Throwable -> L27
            if (cv.a(fx.b(cv.a(eh.a(r4), r7, r5))) == false) goto L24;
            dm.a(r2, r3);     // Catch: Throwable -> L27
            goto L24
        L53:
            r2.close();     // Catch: Throwable -> L37
            return;
        L55:
            return;
        L24:
            if (r2 == null) goto L58;
            r2.close();     // Catch: Throwable -> L39
            return;
        L57:
            return;
        L58:
            return;
        L27:
            th = move-exception;
            q.b(th, "leg", "uts");     // Catch: Throwable -> L32
            if (r2 == null) goto L59;
            r2.close();     // Catch: Throwable -> L38
            return;
        L60:
            return;
        L59:
            return;
        L32:
            th = move-exception;
            if (r2 != null) goto L49;
        L35:
            throw th;
        L49:
            r2.close();     // Catch: Throwable -> L40
            goto L35
        }

        @Override // com.loc.bq
        public final void a() {
            int r0 = this.f5451b;
            if (r0 != 1) goto L7;
            b();
            return;
        L7:
            if (r0 != 2) goto L11;
            c();
            return;
        L11:
            if (r0 != 3) goto L14;
            dm.c(this.f5450a);
            return;
        }
    }

    static {
    }

    dm(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        this.f5446a = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.f = new ArrayList();
        this.f5447b = null;
        this.c = null;
        this.j = false;
        this.f5446a = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        as r2 = new as();
        this.e = r2;
        ay.a(this.f5446a, r2, o.k, 100, 1024000, "0");
        as r0 = this.e;
        int r8 = eu.g;
        boolean r4 = eu.e;
        int r5 = eu.f;
        r0.f = new bk(r12, r8, "kKey", new bi(r12, r4, r5, r5 * 10, "carrierLocKey"));
        as r10 = this.e;
        r10.e = new aa();
    }

    private static int a(byte[] r2) {
        int r0 = ((r2[3] & 255) | ((r2[2] & 255) << 8)) | ((r2[1] & 255) << 16);
        return ((r2[0] & 255) << 24) | r0;
    }

    static /* synthetic */ long a(long r0) {
        k = r0;
        return r0;
    }

    static /* synthetic */ List a(ah r2, as r3, List r4, byte[] r5) {
        return b(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    static /* synthetic */ void a(ah r2, List r3) {
        b(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(dm r0) {
        return r0.j;
    }

    private static byte[] a(int r2) {
        KeyGenerator r1 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        r1.init(r2);     // Catch: Throwable -> L8
        return r1.generateKey().getEncoded();
    L8:
        return null;
    }

    static /* synthetic */ ArrayList b(dm r0) {
        return r0.f;
    }

    private static List<ca> b(ah r18, as r19, List<String> r20, byte[] r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList();
        File r2 = r18.b();     // Catch: Throwable -> L74
        if (r2 != null) goto L6;
    L76:
        return r1;
    L6:
        if (r2.exists() == false) goto L76;
        String[] r3 = r2.list();     // Catch: Throwable -> L74
        if (r3 != null) goto L10;
        return r1;
    L10:
        int r4 = r3.length;     // Catch: Throwable -> L74
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L11:
        if (r6 >= r4) goto L73;
        String r8 = r3[r6];     // Catch: Throwable -> L74
        if (r8.contains(".0") == false) goto L71;
        InputStream r9 = null;
        String r10 = r8.split("\\.")[r5];     // Catch: Throwable -> L64
        ah.b r11 = r18.a(r10);     // Catch: Throwable -> L87
        if (r11 != null) goto L105;
        if (r11 == null) goto L71;
    L103:
        r11.close();     // Catch: Throwable -> L77
        goto L71
    L105:
        r9 = r11.a();     // Catch: Throwable -> L63
        if (r9 != null) goto L29;
        if (r9 != null) goto L107;
    L26:
        if (r11 == null) goto L71;
    L107:
        r9.close();     // Catch: Throwable -> L79
        goto L26
    L29:
        byte[] r12 = new byte[2];     // Catch: Throwable -> L63
        r9.read(r12);     // Catch: Throwable -> L63
        int r13 = fd.b(r12);     // Catch: Throwable -> L63
        if (r13 == 0) goto L59;
        if (r13 > 65535) goto L59;
        byte[] r14 = new byte[r13];     // Catch: Throwable -> L63
        r9.read(r14);     // Catch: Throwable -> L63
        byte[] r15 = new byte[2];     // Catch: Throwable -> L63
        int r16 = r5;
    L35:
        if (r9.read(r15) < 0) goto L44;
        byte[] r17 = new byte[fd.b(r15)];     // Catch: Throwable -> L42
        r9.read(r17);     // Catch: Throwable -> L42
        byte[] r110 = fq.a(r14, r17, fx.c());     // Catch: Throwable -> L42
        r16 = r16 + r110.length;     // Catch: Throwable -> L42
        byte[] r111 = new byte[4];     // Catch: Throwable -> L42
        r9.read(r111);     // Catch: Throwable -> L42
        String[] r112 = r3;
        int r113 = r4;
        r1.add(new ca(a(r111), fq.b(r21, fx.b(r110), fx.c())));     // Catch: Throwable -> L80
        r3 = r112;
        r4 = r113;
    L66:
        if (r9 != null) goto L99;
    L68:
        if (r11 == null) goto L72;
    L113:
        r11.close();     // Catch: Throwable -> L78
    L72:
        r6 = r6 + 1;
        r3 = r112;
        r4 = r113;
        r5 = 0;
        goto L11
    L99:
        r9.close();     // Catch: Throwable -> L82
    L43:
        r113 = r4;
    L42:
        r112 = r3;
        goto L43
    L44:
        r112 = r3;
        r113 = r4;
        r7 = r7 + r16;     // Catch: Throwable -> L80
        r0.add(r10);     // Catch: Throwable -> L80
        if (r7 > r19.f.b()) goto L48;
        if (r9 != null) goto L89;
    L55:
        if (r11 == null) goto L72;
    L89:
        r9.close();     // Catch: Throwable -> L85
        goto L55
    L48:
        if (r9 != null) goto L109;
    L50:
        if (r11 == null) goto L73;
    L91:
        r11.close();     // Catch: Throwable -> L88
        goto L73
    L109:
        r9.close();     // Catch: Throwable -> L84
    L59:
        if (r9 != null) goto L101;
    L61:
        if (r11 == null) goto L73;
    L101:
        r9.close();     // Catch: Throwable -> L86
    L63:
        r112 = r3;
        r113 = r4;
    L65:
        r112 = r3;
        r113 = r4;
        r11 = null;
    L71:
        r112 = r3;
        r113 = r4;
    L73:
        return r1;
    L74:
        th = move-exception;
        q.b(th, "aps", "upc");
        goto L76
    }

    private static void b(ah r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L10
    L6:
        if (r6.hasNext() == false) goto L8;
        r3.c((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L6
    L8:
        r3.close();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        q.b(th, "aps", "dlo");
        return;
    }

    private static byte[] b(int r3) {
        return new byte[]{(byte) ((r3 >> 24) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 8) & 255), (byte) (r3 & 255)};
    }

    static /* synthetic */ void c(dm r0) {
        r0.g();
    }

    private static byte[] c(int r3) {
        return new byte[]{(byte) ((r3 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (r3 & 255)};
    }

    static /* synthetic */ byte[] f() {
        return a(128);
    }

    private void g() {
        Object[] r1 = new Object[1];     // Catch: Throwable -> L33
        ex.a();     // Catch: Throwable -> L33
        if (fd.m(this.f5446a) == false) goto L7;
        Object[] r7 = new Object[1];     // Catch: Throwable -> L33
        ex.a();     // Catch: Throwable -> L33
        return;
    L7:
        ArrayList<ca> r0 = this.f;     // Catch: Throwable -> L33
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.size() == 0) goto L46;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L33
        ArrayList<ca> r3 = this.f;     // Catch: Throwable -> L33
        monitor-enter(r3);     // Catch: Throwable -> L33
        r2.addAll(this.f);     // Catch: Throwable -> L29
        this.f.clear();     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L29
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L33
        byte[] r5 = a(256);     // Catch: Throwable -> L33
        if (r5 != null) goto L19;
        return;
    L19:
        r4.write(c(r5.length));     // Catch: Throwable -> L33
        r4.write(r5);     // Catch: Throwable -> L33
        Iterator r6 = r2.iterator();     // Catch: Throwable -> L33
    L21:
        if (r6.hasNext() == false) goto L27;
        ca r8 = (ca) ZeusTransformUtils.preCheckCast(r6.next(), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        byte[] r9 = r8.b();     // Catch: Throwable -> L33
        if (r9.length < 10) goto L21;
        if (r9.length > 65535) goto L21;
        byte[] r10 = fq.b(r5, r9, fx.c());     // Catch: Throwable -> L33
        r4.write(c(r10.length));     // Catch: Throwable -> L33
        r4.write(r10);     // Catch: Throwable -> L33
        r4.write(b(r8.a()));     // Catch: Throwable -> L33
        goto L21
    L27:
        byte[] r11 = r4.toByteArray();     // Catch: Throwable -> L33
        at.a(Long.toString(System.currentTimeMillis()), r11, this.e);     // Catch: Throwable -> L33
        return;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L46:
        return;
    L33:
        th = move-exception;
        ev.a(th, "clm", "wtD");
    }

    @Override // com.loc.dh
    public final dg a(df r2) {
        en r1 = new en();     // Catch: Throwable -> L4
        r1.a(r2.f5433b);     // Catch: Throwable -> L4
        r1.b(r2.f5432a);     // Catch: Throwable -> L4
        r1.a(r2.d);     // Catch: Throwable -> L4
        ak.a();     // Catch: Throwable -> L4
        aq r3 = ak.a(r1);     // Catch: Throwable -> L4
        dg r4 = new dg();     // Catch: Throwable -> L4
        r4.c = r3.f5322a;     // Catch: Throwable -> L4
        r4.f5435b = r3.f5323b;     // Catch: Throwable -> L4
        r4.f5434a = 200;     // Catch: Throwable -> L4
        return r4;
    L4:
        return null;
    }

    final void a() {
        if (fd.m(this.f5446a) == false) goto L21;
        Object[] r2 = new Object[1];
        ex.a();
        return;
    L21:
        a r0 = this.i;     // Catch: Throwable -> L18
        if (r0 == null) goto L11;
        LocationManager r1 = this.h;     // Catch: Throwable -> L18
        if (r1 == null) goto L11;
        r1.removeUpdates(r0);     // Catch: Throwable -> L18
    L11:
        a r3 = this.i;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        r3.a();     // Catch: Throwable -> L18
    L15:
        if (this.j == false) goto L23;
        g();     // Catch: Throwable -> L18
        this.f5447b.a(null);     // Catch: Throwable -> L18
        this.c.a(null);     // Catch: Throwable -> L18
        this.c = null;     // Catch: Throwable -> L18
        this.f5447b = null;     // Catch: Throwable -> L18
        this.g = null;     // Catch: Throwable -> L18
        this.j = false;     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L18:
        th = move-exception;
        ev.a(th, "clm", "stc");
    }

    public final void a(Location r3) {
        Handler r0 = this.g;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.post(new b(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        q.b(th, "cl", "olcc");
    }

    public final void a(du r7, eg r8, Handler r9) {
        Object[] r1 = new Object[1];
        ex.a();
        if (this.j == false) goto L5;
        return;
    L5:
        if (r7 == null) goto L36;
        if (r8 == null) goto L37;
        if (r9 != null) goto L10;
        return;
    L10:
        if (fd.m(this.f5446a) == false) goto L13;
        Object[] r6 = new Object[1];
        ex.a();
        return;
    L13:
        this.j = true;
        this.c = r7;
        this.f5447b = r8;
        r8.a(this);
        this.c.a(this);
        this.g = r9;
    L30:
        th = move-exception;
        ev.a(th, "col", CommonConsts.APM_INNER_EVENT_COST_INIT);
        return;
    L15:
        if (this.h != null) goto L19;
        if (r9 == null) goto L19;
        this.h = (LocationManager) ZeusTransformUtils.preCheckCast(this.f5446a.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
    L19:
        if (this.i != null) goto L21;
        this.i = new a(this);     // Catch: Throwable -> L30
    L21:
        this.i.a(this);     // Catch: Throwable -> L30
        a r5 = this.i;     // Catch: Throwable -> L30
        if (r5 == null) goto L27;
        LocationManager r0 = this.h;     // Catch: Throwable -> L30
        if (r0 == null) goto L27;
        r0.requestLocationUpdates("passive", 1000, -1.0f, r5);     // Catch: Throwable -> L30
    L27:
        if (this.d != null) goto L35;
        cv r10 = new cv("6.4.8", fm.f(this.f5446a), "S128DF1572465B890OE3F7A13167KLEI", fm.c(this.f5446a), this);     // Catch: Throwable -> L30
        this.d = r10;     // Catch: Throwable -> L30
        r10.a(fp.k()).b(fp.f(this.f5446a)).c(fp.a(this.f5446a)).d(fp.e(this.f5446a)).e(fp.n()).f(fp.f()).g(Build.MODEL).h(Build.MANUFACTURER).i(Build.BRAND).a(Build.VERSION.SDK_INT).j(Build.VERSION.RELEASE).a(db.a(fp.h())).k(fp.h());     // Catch: Throwable -> L30
        cv.b();     // Catch: Throwable -> L30
        return;
    L35:
        return;
    L37:
        return;
    }

    public final void b() {
        Object[] r0 = new Object[1];     // Catch: Throwable -> L7
        ex.a();     // Catch: Throwable -> L7
        Handler r1 = this.g;     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        r1.post(new AnonymousClass1(this));     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ev.a(th, "cl", "upw");
    }

    public final void c() {
        Object[] r0 = new Object[1];     // Catch: Throwable -> L9
        ex.a();     // Catch: Throwable -> L9
        if (this.d == null) goto L14;
        du r2 = this.c;     // Catch: Throwable -> L9
        if (r2 == null) goto L15;
        cv.a(r2.a());     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        th = move-exception;
        ev.a(th, "cl", "upc");
    }

    public final void d() {
        if (fd.m(this.f5446a) == false) goto L7;
        Object[] r4 = new Object[1];     // Catch: Throwable -> L11
        ex.a();     // Catch: Throwable -> L11
        return;
    L7:
        if ((System.currentTimeMillis() - k) >= 60000) goto L9;
        return;
    L9:
        bp.a().b(new b(this, 2));     // Catch: Throwable -> L11
        return;
    }

    public final void e() {
        bp.a().b(new b(this, 3));     // Catch: Throwable -> L4
        return;
    }
}
