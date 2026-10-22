package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ej f5548b;
    static v e;
    static long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5549a;
    ej c;
    ej d;
    long f;
    boolean h;
    private Context i;

    static {
    }

    public fk(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f5549a = null;
        this.c = null;
        this.d = null;
        this.f = 0;
        this.h = false;
        this.i = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private void e() {
        if (f5548b != null) goto L5;
    L6:
        ej r4 = f();
        g = fd.b();
        if (r4 != null) goto L9;
        return;
    L9:
        if (fd.a(r4.a()) == false) goto L14;
        f5548b = r4;
        return;
    L14:
        return;
    L5:
        if ((fd.b() - g) > 180000) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ej f() {
        String r1 = null;
        if (this.i != null) goto L5;
        return null;
    L5:
        a();
        v r0 = e;     // Catch: Throwable -> L44
        if (r0 != null) goto L9;
        return null;
    L9:
        List r2 = r0.a("_id=1", ej.class);     // Catch: Throwable -> L44
        if (r2 != null) goto L12;
    L35:
        ej r3 = null;
    L37:
        if (TextUtils.isEmpty(r1) == true) goto L51;
        AMapLocation r6 = new AMapLocation("");     // Catch: Throwable -> L42
        ev.a(r6, new JSONObject(r1));     // Catch: Throwable -> L42
        if (fd.b(r6) == false) goto L52;
        r3.a(r6);     // Catch: Throwable -> L42
        return r3;
    L42:
        th = th;
        r1 = r3;
    L45:
        ev.a(th, "LastLocationManager", "readLastFix");
        return r1;
    L52:
        return r3;
    L51:
        return r3;
    L12:
        if (r2.size() <= 0) goto L35;
        r3 = (ej) ZeusTransformUtils.preCheckCast(r2.get(0), ej.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        byte[] r4 = fq.b(r3.c());     // Catch: Throwable -> L42
        if (r4 != null) goto L18;
    L24:
        String r5 = null;
    L25:
        byte[] r7 = fq.b(r3.b());     // Catch: Throwable -> L42
        if (r7 != null) goto L28;
    L34:
        r3.a(r1);     // Catch: Throwable -> L42
        r1 = r5;
        goto L37
    L28:
        if (r7.length <= 0) goto L34;
        byte[] r8 = eh.b(r7, this.f5549a);     // Catch: Throwable -> L42
        if (r8 == null) goto L34;
        if (r8.length <= 0) goto L34;
        r1 = new String(r8, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L42
        goto L34
    L18:
        if (r4.length <= 0) goto L24;
        byte[] r9 = eh.b(r4, this.f5549a);     // Catch: Throwable -> L42
        if (r9 == null) goto L24;
        if (r9.length <= 0) goto L24;
        r5 = new String(r9, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L42
    L44:
        th = th;
        goto L45
    }

    public final AMapLocation a(AMapLocation r8, String r9, long r10) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r8.getErrorCode() != 0) goto L7;
        return r8;
    L7:
        if (r8.getLocationType() != 1) goto L9;
        return r8;
    L9:
        if (r8.getErrorCode() == 7) goto L43;
        e();     // Catch: Throwable -> L32
        ej r7 = f5548b;     // Catch: Throwable -> L32
        if (r7 != null) goto L14;
    L31:
        return r8;
    L14:
        if (r7.a() == null) goto L31;
        boolean r11 = false;
        if (TextUtils.isEmpty(r9) == false) goto L24;
        long r2 = fd.b() - f5548b.d();     // Catch: Throwable -> L32
        if (r2 >= 0) goto L21;
    L23:
        r8.setTrustedLevel(3);     // Catch: Throwable -> L32
    L25:
        if (r11 == false) goto L41;
        AMapLocation r12 = f5548b.a();     // Catch: Throwable -> L32
        et.a(r12);     // Catch: Throwable -> L29
        r12.setLocationType(9);     // Catch: Throwable -> L29
        r12.setFixLastLocation(true);     // Catch: Throwable -> L29
        r12.setLocationDetail(r8.getLocationDetail());     // Catch: Throwable -> L29
        return r12;
    L29:
        th = move-exception;
        r8 = r12;
        th = th;
    L33:
        ev.a(th, "LastLocationManager", "fixLastLocation");
        return r8;
    L41:
        return r8;
    L21:
        if (r2 > r10) goto L23;
        r11 = true;
        goto L23
    L24:
        r11 = fd.a(f5548b.b(), r9);     // Catch: Throwable -> L32
        r8.setTrustedLevel(2);     // Catch: Throwable -> L32
    L32:
        th = th;
        goto L33
    L43:
        return r8;
    }

    public final void a() {
        if (this.h == false) goto L16;
        return;
    L16:
    L12:
        th = move-exception;
        ev.a(th, "LastLocationManager", "<init>:DBOperation");
    L14:
        this.h = true;
        return;
    L6:
        if (this.f5549a != null) goto L9;
        this.f5549a = eh.a(CryptoConst.ALGORITHM_MD5, fp.k());     // Catch: Throwable -> L12
    L9:
        if (e != null) goto L14;
        t r0 = v.a(ek.class);     // Catch: Throwable -> L12
        e = new v(this.i, r0);     // Catch: Throwable -> L12
        goto L14
    }

    public final boolean a(AMapLocation r6, String r7) {
        if (this.i == null) goto L30;
        if (r6 == null) goto L30;
        if (fd.a(r6) == false) goto L30;
        if (r6.getLocationType() == 2) goto L30;
        if (r6.isMock() == true) goto L30;
        if (r6.isFixLastLocation() == true) goto L30;
        ej r0 = new ej();
        r0.a(r6);
        if (r6.getLocationType() != 1) goto L18;
        r0.a(null);
    L31:
        f5548b = r0;     // Catch: Throwable -> L28
        g = fd.b();     // Catch: Throwable -> L28
        this.c = r0;     // Catch: Throwable -> L28
        ej r8 = this.d;     // Catch: Throwable -> L28
        if (r8 != null) goto L22;
    L24:
        if ((fd.b() - this.f) <= 30000) goto L30;
        return true;
    L22:
        if (fd.a(r8.a(), r0.a()) > 500.0f) goto L24;
        return false;
    L28:
        th = move-exception;
        ev.a(th, "LastLocationManager", "setLastFix");
        goto L30
    L18:
        r0.a(r7);
    L30:
        return false;
    }

    public final AMapLocation b() {
        e();
        ej r1 = f5548b;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (fd.a(r1.a()) == true) goto L9;
        return null;
    L9:
        return f5548b.a();
    }

    public final void c() {
        d();     // Catch: Throwable -> L4
        this.f = 0;     // Catch: Throwable -> L4
        this.h = false;     // Catch: Throwable -> L4
        this.c = null;     // Catch: Throwable -> L4
        this.d = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "LastLocationManager", "destroy");
    }

    public final void d() {
        a();     // Catch: Throwable -> L27
        ej r1 = this.c;     // Catch: Throwable -> L27
        if (r1 != null) goto L6;
        return;
    L6:
        if (fd.a(r1.a()) == true) goto L8;
        return;
    L8:
        if (e == null) goto L34;
        ej r2 = this.c;     // Catch: Throwable -> L27
        if (r2 != this.d) goto L12;
        return;
    L12:
        if (r2.d() != 0) goto L36;
        String r3 = this.c.a().toStr();     // Catch: Throwable -> L27
        String r4 = this.c.b();     // Catch: Throwable -> L27
        this.d = this.c;     // Catch: Throwable -> L27
        String r5 = null;
        if (TextUtils.isEmpty(r3) == true) goto L20;
        String r6 = fq.b(eh.a(r3.getBytes(RpcUtils.CHARSET_UTF8), this.f5549a));     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r4) == true) goto L19;
        r5 = fq.b(eh.a(r4.getBytes(RpcUtils.CHARSET_UTF8), this.f5549a));     // Catch: Throwable -> L27
    L19:
        String r0 = r5;
        r5 = r6;
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L37;
        ej r7 = new ej();     // Catch: Throwable -> L27
        r7.b(r5);     // Catch: Throwable -> L27
        r7.a(fd.b());     // Catch: Throwable -> L27
        r7.a(r0);     // Catch: Throwable -> L27
        e.a(r7, "_id=1");     // Catch: Throwable -> L27
        this.f = fd.b();     // Catch: Throwable -> L27
        ej r8 = f5548b;     // Catch: Throwable -> L27
        if (r8 == null) goto L38;
        r8.a(fd.b());     // Catch: Throwable -> L27
        return;
    L38:
        return;
    L37:
        return;
    L20:
        r0 = null;
        goto L22
    L36:
        return;
    L34:
        return;
    L27:
        th = move-exception;
        ev.a(th, "LastLocationManager", "saveLastFix");
    }
}
