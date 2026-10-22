package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class am extends fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f5296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected fw f5297b;
    protected byte[] c;

    public am(Context r3, fw r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        this.f5296a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    L5:
        this.f5297b = r4;
        u();
    }

    private static byte[] D() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(fx.a("PANDORA$"));     // Catch: Throwable -> L9
        r2.write(new byte[]{1});     // Catch: Throwable -> L9
        r2.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L9
        r2.close();     // Catch: Throwable -> L6
    L8:
        return r3;
    L6:
        th = move-exception;
        n.a(th, "bre", "gbh");
    L9:
        th = move-exception;
        n.a(th, "bre", "gbh");     // Catch: Throwable -> L17
        r2.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        n.a(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        n.a(th, "bre", "gbh");
        goto L22
    }

    private byte[] E() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r2.write(new byte[]{3});     // Catch: Throwable -> L31
        if (g() == false) goto L12;
        Context r5 = this.f5296a;     // Catch: Throwable -> L31
        boolean r7 = l();     // Catch: Throwable -> L31
        fw r8 = this.f5297b;     // Catch: Throwable -> L31
        if (r8 != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        byte[] r6 = fo.a(r5, r7, r9);     // Catch: Throwable -> L31
        r2.write(a(r6));     // Catch: Throwable -> L31
        r2.write(r6);     // Catch: Throwable -> L31
    L13:
        byte[] r10 = fx.a(i());     // Catch: Throwable -> L31
        if (r10 != null) goto L16;
    L18:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L19:
        byte[] r11 = fx.a(h());     // Catch: Throwable -> L31
        if (r11 != null) goto L22;
    L24:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L25:
        byte[] r12 = r2.toByteArray();     // Catch: Throwable -> L31
        r2.close();     // Catch: Throwable -> L28
    L30:
        return r12;
    L28:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L30
    L22:
        if (r11.length <= 0) goto L24;
        r2.write(a(r11));     // Catch: Throwable -> L31
        r2.write(r11);     // Catch: Throwable -> L31
        goto L25
    L16:
        if (r10.length <= 0) goto L18;
        r2.write(a(r10));     // Catch: Throwable -> L31
        r2.write(r10);     // Catch: Throwable -> L31
        goto L19
    L8:
        if ("navi".equals(r8.a()) == false) goto L10;
        r9 = true;
        goto L11
    L12:
        r2.write(new byte[]{0, 0});     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        n.a(th, "bre", "gpd");     // Catch: Throwable -> L39
        r2.close();     // Catch: Throwable -> L35
    L38:
        return new byte[]{0};
    L35:
        th = move-exception;
        n.a(th, "bre", "gred");
    L39:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L42
    L44:
        throw th;
    L42:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L44
    }

    private byte[] F() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r6 = j();     // Catch: Throwable -> L20
        if (r6 != null) goto L6;
    L14:
        r2.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r7 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L17
    L19:
        return r7;
    L17:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L19
    L6:
        if (r6.length == 0) goto L14;
        r2.write(new byte[]{1});     // Catch: Throwable -> L20
        r2.write(a(r6));     // Catch: Throwable -> L20
        r2.write(r6);     // Catch: Throwable -> L20
        byte[] r8 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r8;
    L11:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L20:
        th = move-exception;
        n.a(th, "bre", "grrd");     // Catch: Throwable -> L28
        r2.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        n.a(th, "bre", "grrd");
    L28:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        n.a(th, "bre", "grrd");
        goto L33
    }

    private byte[] G() {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        byte[] r6 = k();     // Catch: Throwable -> L20
        if (r6 != null) goto L6;
    L14:
        r2.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r7 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L17
    L19:
        return r7;
    L17:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L19
    L6:
        if (r6.length == 0) goto L14;
        r2.write(new byte[]{1});     // Catch: Throwable -> L20
        byte[] r8 = fo.a(r6);     // Catch: Throwable -> L20
        r2.write(a(r8));     // Catch: Throwable -> L20
        r2.write(r8);     // Catch: Throwable -> L20
        byte[] r9 = r2.toByteArray();     // Catch: Throwable -> L20
        r2.close();     // Catch: Throwable -> L11
    L13:
        return r9;
    L11:
        th = move-exception;
        n.a(th, "bre", "gred");
    L20:
        th = move-exception;
        n.a(th, "bre", "gred");     // Catch: Throwable -> L28
        r2.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        n.a(th, "bre", "gred");
    L28:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        n.a(th, "bre", "gred");
        goto L33
    }

    public static byte[] a(byte[] r0) {
        return fx.a(r0.length);
    }

    @Override // com.loc.bo
    public Map<String, String> b() {
        String r0 = fm.f(this.f5296a);
        String r1 = fo.a();
        String r4 = fo.a(this.f5296a, r1, "key=".concat(String.valueOf(r0)));
        HashMap r2 = new HashMap();
        r2.put("ts", r1);
        r2.put("key", r0);
        r2.put("scode", r4);
        return r2;
    }

    @Override // com.loc.bo
    public final byte[] d() {
        byte[] r2 = this.c;
        if (r2 == null) goto L5;
        return r2;
    L5:
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r3.write(D());     // Catch: Throwable -> L12
        r3.write(E());     // Catch: Throwable -> L12
        r3.write(F());     // Catch: Throwable -> L12
        r3.write(G());     // Catch: Throwable -> L12
        byte[] r4 = r3.toByteArray();     // Catch: Throwable -> L12
        this.c = r4;     // Catch: Throwable -> L12
        r3.close();     // Catch: Throwable -> L9
    L11:
        return r4;
    L9:
        th = move-exception;
        n.a(th, "bre", "geb");
    L12:
        th = move-exception;
        n.a(th, "bre", "geb");     // Catch: Throwable -> L20
        r3.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        n.a(th, "bre", "geb");
        return null;
    L20:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        n.a(th, "bre", "geb");
        goto L25
    }

    public boolean g() {
        return true;
    }

    public String h() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f5297b.c(), this.f5297b.a()});
    }

    public String i() {
        return "2.1";
    }

    public abstract byte[] j();

    public abstract byte[] k();

    public boolean l() {
        return false;
    }
}
