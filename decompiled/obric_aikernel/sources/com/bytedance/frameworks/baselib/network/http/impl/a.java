package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements n4.e, s4.c, g, i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile boolean f1628j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f1629k = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected n4.c f1630c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected o2.b f1631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f1632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected volatile boolean f1633i;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.impl.a$a, reason: collision with other inner class name */
    class C0055a implements r4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f1634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o2.b f1635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f1636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n4.c f1637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ n4.e f1638e;

        C0055a(g r10, o2.b r11, boolean r12, n4.c r13, n4.e r14) {
            this.f1634a = r10;
            this.f1635b = r11;
            this.f1636c = r12;
            this.f1637d = r13;
            this.f1638e = r14;
        }

        @Override // r4.e
        public String a() {
            return this.f1634a.h();
        }

        @Override // r4.e
        public InputStream c() {
            InputStream r10 = z2.d.g(this.f1634a.d(), this.f1634a.o(), this.f1634a.i(), this.f1635b.O);     // Catch: Exception -> L4
        L9:
            return new o2.e(r10, this.f1638e);
        L4:
            e = move-exception;
            if (this.f1636c == false) goto L11;
            r10 = this.f1634a.g();
            goto L9
        L11:
            throw new HttpResponseException(this.f1634a.e(), "reason = " + this.f1634a.l() + "  exception = " + e.getMessage(), this.f1637d.A(), null);
        }
    }

    static {
    }

    protected a(n4.c r10) {
        boolean r11 = false;
        this.f1632h = false;
        this.f1633i = false;
        this.f1630c = r10;
        o2.b r12 = o2.b.a();
        this.f1631g = r12;
        r12.O = r10.z();
        o2.b r13 = this.f1631g;
        RetrofitMetrics r14 = r13.O;
        if (r14 == null) goto L5;
        r13.f11399f = r14.f2455p;
        r13.f11400g = r14.f2457q;
    L5:
        r13.f11401h = System.currentTimeMillis();
        if (this.f1630c.N() == false) goto L8;
        o2.b r15 = this.f1631g;
        r11 = true;
    L9:
        r15.C = r11;
        if ((this.f1630c.t() instanceof o2.c) == false) goto L19;
        o2.b r16 = this.f1631g;
        r16.f11398e = (T) this.f1630c.t();
        T r17 = this.f1631g.f11398e;
        this.f1632h = r17.f11434o;
        List<o2.c.b> r18 = r17.B;
        if (r18 != null) goto L14;
        return;
    L14:
        if (r18.size() > 0) goto L16;
        return;
    L16:
        if (r18.size() > 3) goto L22;
        o2.b r19 = this.f1631g;
        r19.K = new o2.i(r18);
        return;
    L22:
        return;
    L19:
        return;
    L8:
        r15 = this.f1631g;
        goto L9
    }

    protected static void A(o2.b r10, i r11) {
        if (r11 != null) goto L34;
    L4:
        RetrofitMetrics r12 = r10.O;     // Catch: Throwable -> L31
        if (r12 == null) goto L36;
        r12.f2449m = TTNetInitMetrics.k().f1535l;     // Catch: Throwable -> L31
        RetrofitMetrics r13 = r10.O;     // Catch: Throwable -> L31
        r13.f2451n = TTNetInitMetrics.k().G;     // Catch: Throwable -> L31
        RetrofitMetrics r14 = r10.O;     // Catch: Throwable -> L31
        r14.N = SystemClock.uptimeMillis();     // Catch: Throwable -> L31
        RetrofitMetrics r15 = r10.O;     // Catch: Throwable -> L31
        r15.f2463t = System.currentTimeMillis();     // Catch: Throwable -> L31
        RetrofitMetrics r16 = r10.O;     // Catch: Throwable -> L31
        r16.f2446k0 = "4.2.228.21-doubao";     // Catch: Throwable -> L31
        r16.f2444j0.put("sentByteCount", Long.valueOf(r10.f11415v));     // Catch: Throwable -> L31
        r10.O.f2444j0.put("receivedByteCount", Long.valueOf(r10.f11416w));     // Catch: Throwable -> L31
        JSONObject r17 = r10.B;     // Catch: Throwable -> L31
        long r18 = r10.E;     // Catch: Throwable -> L31
        if (r18 < 0) goto L9;
        r17.put("turing_callback", r18);     // Catch: Throwable -> L31
    L9:
        long r19 = r10.I;     // Catch: Throwable -> L31
        if (r19 < 0) goto L14;
        r17.put("retry_for_account_cost", r19);     // Catch: Throwable -> L31
    L14:
        if (r10.F == false) goto L17;
        r17.put("turing_retry", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L31
    L17:
        if (r10.H == false) goto L19;
        r17.put("account_retry", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L31
    L19:
        String r20 = r10.G;     // Catch: Throwable -> L31
        if (r20 == null) goto L22;
        r17.put("retry_by_header", r20);     // Catch: Throwable -> L31
    L22:
        o2.i r21 = r10.K;     // Catch: Throwable -> L31
        if (r21 == null) goto L29;
        JSONObject r22 = r21.a();     // Catch: Throwable -> L31
        if (r22 == null) goto L29;
        if (r22.length() <= 0) goto L29;
        r17.put("rotation_host_retry", r22);     // Catch: Throwable -> L31
        r10.O.B0 = r22;     // Catch: Throwable -> L31
    L29:
        r17.put("retrofit", r10.O.g());     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        th.printStackTrace();
        return;
    L36:
        return;
    L34:
        r11.j(r10);     // Catch: Throwable -> L31
        goto L4
    }

    private static boolean C(o2.b r10) {
        if (r10 == null) goto L8;
        T r11 = r10.f11398e;
        if (r11 == 0) goto L8;
        if (r11.f11432m == false) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean D(o2.b r10) {
        if (r10 == null) goto L8;
        T r11 = r10.f11398e;
        if (r11 == 0) goto L8;
        if (r11.f11429j == false) goto L8;
        return true;
    L8:
        return false;
    }

    protected static String J(o2.b r10, Map<String, List<String>> r11, int r12, InputStream r13, String r14, boolean r15) {
        if (r13 != null) goto L44;
        return null;
    L44:
    L38:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L36
    L6:
        if (r10.f11395b == false) goto L8;
        byte[] r16 = z2.d.j(r15, r11, r12, r13, r10.O);     // Catch: Throwable -> L36 Exception -> L38
    L14:
        z2.d.l(r13);
        if (r16.length > 0) goto L17;
        return null;
    L17:
        if (com.bytedance.common.utility.g.b(r14) == false) goto L19;
        return null;
    L19:
        if (Logger.debug() == false) goto L21;
    L45:
        MimeType r17 = new MimeType(r14);     // Catch: Throwable -> L33
        if ("text".equalsIgnoreCase(r17.getPrimaryType()) == false) goto L25;
    L26:
        String r18 = r17.getParameter("charset");     // Catch: Throwable -> L33
        if (com.bytedance.common.utility.g.b(r18) == false) goto L30;
        r18 = "utf-8";
    L30:
        if (Q(r10) == false) goto L51;
        return new String(r16, r18);
    L51:
        return null;
    L25:
        if ("application/json".equalsIgnoreCase(r17.getBaseType()) == true) goto L26;
        return null;
    L33:
        th = move-exception;
        th.printStackTrace();
        return null;
    L21:
        if (Q(r10) == true) goto L45;
        return null;
    L8:
        int[] r19 = new int[1];     // Catch: Throwable -> L36 Exception -> L38
        byte[] r20 = z2.d.h(r15, r11, r12, r13, r19, r10.O);     // Catch: Throwable -> L36 Exception -> L38
        byte[] r110 = new byte[r19[0]];     // Catch: Throwable -> L36 Exception -> L38
        if (r20 != null) goto L11;
    L13:
        r16 = r110;
        goto L14
    L11:
        if (r19[0] <= 0) goto L13;
        System.arraycopy(r20, 0, r110, 0, r19[0]);     // Catch: Throwable -> L36 Exception -> L38
    L36:
        th = move-exception;
        z2.d.l(r13);
        throw th;
    }

    protected static byte[] K(String r10, int r11, o2.b r12, g r13, i r14) {
        if (r13.e() != 200) goto L5;
    L25:
        r12.f11404k = System.currentTimeMillis();
        InputStream r15 = r13.d();     // Catch: Exception -> L28
    L64:
    L53:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        z2.d.l(r15);
        throw th;
    L33:
        if (r12.f11395b == false) goto L36;
        byte[] r16 = z2.d.j(r13.i(), r13.o(), r11, r15, r12.O);     // Catch: Throwable -> L51 Exception -> L53
    L46:
        z2.d.l(r15);
        if (z2.d.n(r13.h()) == false) goto L49;
        z2.d.a(r16, r16.length);
    L49:
        r12.f11405l = System.currentTimeMillis();
        o2.a.b();
        A(r12, r14);
        o2.f.u(r10, r12);
        return r16;
    L36:
        if (f1628j == true) goto L38;
    L40:
        int[] r17 = new int[1];     // Catch: Throwable -> L51 Exception -> L53
        byte[] r18 = z2.d.h(r13.i(), r13.o(), r11, r15, r17, r12.O);     // Catch: Throwable -> L51 Exception -> L53
        byte[] r19 = new byte[r17[0]];     // Catch: Throwable -> L51 Exception -> L53
        if (r18 != null) goto L43;
    L45:
        r16 = r19;
        goto L46
    L43:
        if (r17[0] <= 0) goto L45;
        System.arraycopy(r18, 0, r19, 0, r17[0]);     // Catch: Throwable -> L51 Exception -> L53
        goto L45
    L38:
        if (f1629k == false) goto L40;
        r16 = z2.d.i(r13.i(), r13.o(), r11, r15, r12.O);     // Catch: Throwable -> L51 Exception -> L53
    L28:
        e = move-exception;
        if (D(r12) == false) goto L58;
        r15 = r13.g();
        goto L64
    L58:
        throw e;
    L5:
        if (D(r12) == true) goto L25;
        if (r13.e() != 304) goto L10;
        r12.f11404k = System.currentTimeMillis();
        r12.f11405l = System.currentTimeMillis();
        o2.a.b();
        A(r12, r14);
        o2.f.u(r10, r12);
    L10:
        String r110 = null;
        InputStream r20 = r13.d();     // Catch: Throwable -> L13 Exception -> L15
    L12:
        InputStream r21 = r20;
        if (r21 == null) goto L18;
        r110 = J(r12, r13.o(), r11, r21, r13.h(), r13.i());     // Catch: Throwable -> L13
    L18:
        r13.n();     // Catch: Throwable -> L13
        String r111 = "";
    L21:
        HttpResponseException r22 = new HttpResponseException(r13.e(), r111, HttpResponseException.getPathFromUrlString(r10), r110);
        if (r13.e() != 304) goto L65;
        r22.setInfo(true, true, false, r10, r12.P, r12);
        throw r22;
    L65:
        throw r22;
    L13:
        th = move-exception;
        th.printStackTrace();
        r111 = "reason = " + r13.l() + "  exception = " + th.getMessage();
    L15:
        r20 = r13.g();     // Catch: Throwable -> L13
        goto L12
    }

    protected static r4.e L(String r10, n4.c r11, o2.b r12, g r13, i r14, n4.e r15, boolean r16) {
        if (r11.N() == false) goto L30;
        boolean r17 = D(r12);
        if (r13.e() >= 200) goto L7;
    L8:
        if (r17 == false) goto L13;
    L9:
        r4.e r18 = u(r11, r12, r13, r15, r17);
        if (r18 != null) goto L36;
        if (r16 == true) goto L38;
        return r18;
    L38:
        return new com.bytedance.retrofit2.mime.c(r13.h(), new byte[0], new String[0]);
    L36:
        return r18;
    L13:
        String r19 = null;
        InputStream r110 = r13.d();     // Catch: Throwable -> L16 Exception -> L18
    L15:
        InputStream r20 = r110;
        if (r20 == null) goto L21;
        r19 = J(r12, r13.o(), r11.x(), r20, r13.h(), r13.i());     // Catch: Throwable -> L16
    L21:
        r13.n();
        String r111 = "";
    L24:
        HttpResponseException r112 = new HttpResponseException(r13.e(), r111, r11.A(), r19);
        r12.M.set(true);
        r112.setInfo(true, true, false, r10, r12.P, r12);
        throw r112;
    L18:
        r110 = r13.g();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        r111 = "reason = " + r13.l() + "  exception = " + th.getMessage();     // Catch: Throwable -> L26
        r13.n();
    L26:
        th = move-exception;
        r13.n();
        throw th;
    L7:
        if (r13.e() < 300) goto L9;
    L30:
        return new com.bytedance.retrofit2.mime.c(r13.h(), K(r10, r11.x(), r12, r13, r14), new String[0]);
    }

    public static void O(boolean r10) {
        f1628j = r10;
    }

    public static void P(boolean r10) {
        f1629k = r10;
    }

    private static boolean Q(o2.b r10) {
        if (r10 == null) goto L8;
        T r11 = r10.f11398e;
        if (r11 == 0) goto L8;
        if (r11.f11431l == false) goto L8;
        return true;
    L8:
        return false;
    }

    protected static void R(n4.c r10, o2.b r11) {
        long r12 = SystemClock.uptimeMillis();
        o2.f.a0();
        if (o2.f.x(r10.t()) == true) goto L5;
        o2.f.b0();
    L5:
        RetrofitMetrics r13 = r11.O;
        if (r13 == null) goto L9;
        r13.f2466u0 = SystemClock.uptimeMillis() - r12;
        return;
    }

    private void S(n4.c r10, int r11, o2.b r12, g r13, IOException r14, boolean r15) {
        o2.h r16 = o2.f.W(r10, r11, r12, r10.v(), null, r15, false);
        if (r16 != null) goto L5;
        throw r14;
    L5:
        if (r16.d() == true) goto L7;
        throw r14;
    L7:
        if (r12.f11393J == false) goto L12;
        M(r10.O().f(r16.b()).a(), r12, r13, r16.a());
        return;
    L12:
        throw r14;
    }

    protected static void T(String r10, o2.b r11, g r12, i r13, Exception r14) {
        String r15 = w(r12.o());     // Catch: Throwable -> L13
        if (com.bytedance.common.utility.g.b(r15) == true) goto L5;
        r11.B.put("response-headers", r15);     // Catch: Throwable -> L13
    L5:
        String r16 = r14.getMessage();     // Catch: Throwable -> L13
        Throwable r17 = r14.getCause();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r16) == true) goto L11;
        if (r17 == null) goto L11;
        if (TextUtils.isEmpty(r17.getMessage()) == true) goto L11;
        r16 = r16 + ", cause = " + r17.getMessage();     // Catch: Throwable -> L13
    L11:
        r11.B.put("ex", r16);     // Catch: Throwable -> L13
    L15:
        r12.n();
        if (com.bytedance.common.utility.g.b(r11.f11397d) == false) goto L18;
        z(y(r14), r11);
    L18:
        r11.f11405l = System.currentTimeMillis();
        if (r11.C == false) goto L21;
        r11.M.set(true);
    L21:
        A(r11, r13);
        o2.f.t(r10, r14, r11);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r12.n();
        throw th;
    }

    protected static void r(boolean r10, Context r11, String r12) {
        if (r10 == true) goto L9;
        if (r11 != null) goto L5;
        return;
    L5:
        if (NetworkUtils.g(r11) == false) goto L8;
        return;
    L8:
        throw new NetworkNotAvailabeException("network not available for " + r12);
    }

    protected static List<n4.b> t(g r10, List<String> r11) {
        Map<String, List<String>> r12 = r10.o();
        if (r12 != null) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r14 = r12.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r15 = r14.next();
        String r16 = r15.getKey();
        if (r16 == null) goto L22;
        if (r11 == null) goto L22;
        if (r11.isEmpty() == true) goto L22;
        boolean r17 = false;
        Iterator<String> r18 = r11.iterator();
    L16:
        if (r18.hasNext() == false) goto L20;
        if (r16.equalsIgnoreCase(r18.next()) == false) goto L16;
        r17 = true;
    L20:
        if (r17 == true) goto L8;
    L22:
        Iterator<String> r19 = r15.getValue().iterator();
    L24:
        if (r19.hasNext() == false) goto L8;
        r13.add(new n4.b(r16, r19.next()));
        goto L24
    L26:
        return r13;
    }

    protected static r4.e u(n4.c r10, o2.b r11, g r12, n4.e r13, boolean r14) {
        if (r12.k() != 0) goto L7;
        r13.cancel();
        return null;
    L7:
        return new C0055a(r12, r11, r14, r10, r13);
    }

    private static String w(Map<String, List<String>> r10) {
        if (r10 != null) goto L37;
    L36:
        return "";
    L37:
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L5:
        if (r10.isEmpty() == true) goto L36;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L34
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L34
    L9:
        if (r12.hasNext() == false) goto L32;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L34
        if (r13 == null) goto L9;
        String r14 = r13.getKey();     // Catch: Throwable -> L34
        if (com.bytedance.common.utility.g.b(r14) == true) goto L9;
        List<String> r15 = r13.getValue();     // Catch: Throwable -> L34
        if (r15 == null) goto L9;
        if (r15.isEmpty() == true) goto L9;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L34
        int r17 = 0;
        Iterator<String> r18 = r15.iterator();     // Catch: Throwable -> L34
    L23:
        if (r18.hasNext() == false) goto L31;
        String r19 = r18.next();     // Catch: Throwable -> L34
        if (com.bytedance.common.utility.g.b(r19) == true) goto L23;
        if (r17 != 0) goto L29;
    L28:
        r16.append(r19);     // Catch: Throwable -> L34
        r17 = r17 + 1;     // Catch: Throwable -> L34
        goto L23
    L29:
        r16.append("; ");     // Catch: Throwable -> L34
        goto L28
    L31:
        r11.put(r14, r16.toString());     // Catch: Throwable -> L34
        goto L9
    L32:
        return r11.toString();
    }

    private static String y(Exception r10) {
        if (r10 != null) goto L18;
        return "";
    L18:
        String r11 = r10.getMessage();     // Catch: Throwable -> L15
        if (r11 != null) goto L8;
    L14:
        return "";
    L8:
        if (TextUtils.isEmpty(r10.getMessage()) == true) goto L14;
        String[] r12 = r11.split("\\|");     // Catch: Throwable -> L15
        if (r12.length < 2) goto L17;
        return r12[0];
    L17:
        return "";
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    private static void z(String r10, o2.b r11) {
        if (com.bytedance.common.utility.g.b(r10) == false) goto L10;
        return;
    L10:
        r11.f11397d = r10;     // Catch: Throwable -> L9
        T r12 = r11.f11398e;     // Catch: Throwable -> L9
        if (r12 == 0) goto L12;
        r12.f11420a = r10;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    protected int B(IOException r10) {
        return -1;
    }

    protected void E() {
    }

    protected void F(o2.b r10, g r11) {
        r10.f11402i = System.currentTimeMillis();
        r10.N = o2.a.e(r11.h());
        z(r11.f("x-net-info.remoteaddr"), r10);
        T r12 = r10.f11398e;
        if (r12 == 0) goto L5;
        r12.f11421b = r11.e();
    L5:
        String r13 = r11.f("X-TT-LOGID");
        r10.P = r13;
        if (r13 != null) goto L8;
        r10.P = "";
    L8:
        RetrofitMetrics r14 = r10.O;
        if (r14 == null) goto L11;
        r14.f2450m0 = r10.P;
    L11:
        r11.m();
    }

    protected void G(Exception r10) {
    }

    protected abstract void H(r4.e r10);

    protected abstract void I(String r10, n4.c r11, o2.b r12, Map<String, String> r13);

    protected void M(n4.c r10, o2.b r11, g r12, Map<String, String> r13) {
        r12.n();
        r11.L = System.currentTimeMillis();
        I(r10.G(), r10, r11, r13);
        v();     // Catch: IOException -> L5
        N(r10, r11, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        S(r10, B(e), r11, r12, e, false);
    }

    protected List<String> N(n4.c r10, o2.b r11, g r12, boolean r13, boolean r14) {
        o2.h r15 = o2.f.W(r10, r12.e(), r11, r10.v(), r12.o(), r13, r14);
        ArrayList r16 = null;
        if (r15 == null) goto L12;
        if (r15.d() == false) goto L12;
        if (r11.f11393J == false) goto L9;
        r10 = r10.O().f(r15.b()).a();
    L9:
        M(r10, r11, r12, r15.a());
        return null;
    L12:
        if (com.bytedance.common.utility.g.b(r11.G) == true) goto L19;
        if (r15 != null) goto L15;
    L16:
        r16 = new ArrayList();
        if (com.bytedance.common.utility.g.b(r11.G) == true) goto L19;
        r16.add(r11.G);
        goto L19
    L15:
        if (r15.c() == true) goto L16;
    L19:
        return r16;
    }

    @Override // n4.e
    public n4.d execute() {
        RetrofitMetrics r10 = this.f1631g.O;
        if (r10 == null) goto L6;
        r10.f2461s = System.currentTimeMillis();
    L6:
        if (this.f1633i == true) goto L69;
        E();
        R(this.f1630c, this.f1631g);
        r(p(), x(), this.f1630c.A());
        I(this.f1630c.G(), this.f1630c, this.f1631g, null);
        boolean r11 = false;
    L39:
        e = e;
    L70:
        G(e);     // Catch: Throwable -> L57
        if ((e instanceof HttpResponseException) == false) goto L47;
        if (((HttpResponseException) e).getStatusCode() != 304) goto L47;
        throw e;     // Catch: Throwable -> L57
    L47:
        if ((e instanceof IOException) == true) goto L49;
    L52:
        T(this.f1630c.G(), this.f1631g, this, this, e);     // Catch: Throwable -> L57
        q(this.f1630c, e);     // Catch: Throwable -> L57
        if (this.f1630c.N() == false) goto L56;
        this.f1631g.M.set(true);     // Catch: Throwable -> L57
    L56:
        throw s(e);     // Catch: Throwable -> L57
    L49:
        if ("Canceled".equals(e.getMessage()) == false) goto L52;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = th;
        boolean r12 = r11;
        r11 = true;
    L60:
        if (this.f1630c.N() == false) goto L62;
        if (r11 == true) goto L62;
    L64:
        if (this.f1630c.N() == true) goto L67;
        if (r12 == false) goto L67;
        m2.b.c().e();
    L67:
        throw th;
    L62:
        n();
    L37:
        th = th;
        r12 = false;
        goto L60
    L9:
        if (this.f1630c.N() == true) goto L16;
        o2.f.i r13 = o2.f.k();     // Catch: Throwable -> L37 Exception -> L39
        if (r13 == null) goto L16;
        if (r13.b(this.f1630c.G()) == false) goto L16;
        m2.b.c().d();     // Catch: Throwable -> L37 Exception -> L39
        r12 = true;
    L73:
        List<String> r14 = new ArrayList();     // Catch: Throwable -> L33 Exception -> L35
        v();     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
        r14 = N(this.f1630c, this.f1631g, this, true, false);     // Catch: IOException -> L20 Throwable -> L33 Exception -> L35
    L23:
        F(this.f1631g, this);     // Catch: Throwable -> L33 Exception -> L35
        String r15 = this.f1630c.G();     // Catch: Throwable -> L33 Exception -> L35
        n4.c r16 = this.f1630c;     // Catch: Throwable -> L33 Exception -> L35
        o2.b r17 = this.f1631g;     // Catch: Throwable -> L33 Exception -> L35
        r4.e r18 = L(r15, r16, r17, this, this, this, C(r17));     // Catch: Throwable -> L33 Exception -> L35
        H(r18);     // Catch: Throwable -> L33 Exception -> L35
        n4.d r19 = new n4.d(this.f1630c.G(), e(), l(), t(this, r14), r18);     // Catch: Throwable -> L33 Exception -> L35
        r19.k(this.f1631g);     // Catch: Throwable -> L33 Exception -> L35
        r19.l(this.f1631g.P);     // Catch: Throwable -> L33 Exception -> L35
    L25:
        if (this.f1630c.N() == true) goto L29;
        n();
    L29:
        if (this.f1630c.N() == true) goto L32;
        if (r12 == false) goto L32;
        m2.b.c().e();
    L32:
        return r19;
    L20:
        e = move-exception;
        S(this.f1630c, B(e), this.f1631g, this, e, true);     // Catch: Throwable -> L33 Exception -> L35
    L35:
        e = e;
        r11 = r12;
    L33:
        th = th;
        goto L60
    L16:
        r12 = false;
        goto L73
    L69:
        throw new IOException("request canceled");
    }

    protected abstract boolean p();

    protected void q(n4.c r10, Exception r11) {
    }

    protected IOException s(Exception r10) {
        return new IOException(r10.getMessage(), r10.getCause());
    }

    protected abstract void v();

    protected abstract Context x();
}
