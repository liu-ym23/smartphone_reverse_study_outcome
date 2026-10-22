package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class er {
    protected static String I;
    protected static String K;
    protected ArrayList<dt> A;
    protected ArrayList<dt> B;
    protected String C;
    protected String D;
    protected ArrayList<db> E;
    protected String F;
    protected String G;
    protected byte[] H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected String f5507J;
    protected String L;
    protected String M;
    protected String N;
    protected int O;
    final int P;
    private byte[] Q;
    private int R;
    private List<ea> S;
    private List<dt> T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected short f5509b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    public String h;
    public String i;
    protected String j;
    protected String k;
    protected String l;
    protected String m;
    protected String n;
    protected String o;
    protected String p;
    protected String q;
    protected String r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;
    protected int z;

    static {
    }

    public er() {
        this.f5508a = "1";
        this.f5509b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = null;
        this.D = null;
        this.E = new ArrayList();
        this.F = null;
        this.G = null;
        this.H = null;
        this.Q = null;
        this.R = 0;
        this.f5507J = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.S = null;
        this.T = Collections.synchronizedList(new ArrayList());
        this.P = 3;
    }

    private static int a(String r3, byte[] r4, int r5) {
    L11:
        th = move-exception;
        ev.a(th, "Req", "copyContentWithByteLen");
        r4[r5] = 0;
    L14:
        return r5 + 1;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r4[r5] = 0;     // Catch: Throwable -> L11
        goto L14
    L6:
        byte[] r6 = r3.getBytes("GBK");     // Catch: Throwable -> L11
        int r1 = r6.length;     // Catch: Throwable -> L11
        if (r1 <= 127) goto L9;
        r1 = 127;
    L9:
        r4[r5] = (byte) r1;     // Catch: Throwable -> L11
        int r7 = r5 + 1;     // Catch: Throwable -> L11
        System.arraycopy(r6, 0, r4, r7, r1);     // Catch: Throwable -> L11
        return r7 + r1;
    }

    private static void a(dt r10, List<dt> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L38;
        if (r12 == null) goto L42;
        int r0 = r12.size();
        if (r0 != 0) goto L10;
        r12.add(r10);
        return;
    L10:
        long r2 = Long.MAX_VALUE;
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L11:
        if (r4 >= r0) goto L23;
        dt r7 = (dt) ZeusTransformUtils.preCheckCast(r12.get(r4), dt.class, "com.obric.memorydata.plugin");
        if (r10.c() != null) goto L15;
    L19:
        r2 = Math.min(r2, r7.t);
        if (r2 != r7.t) goto L22;
        r6 = r4;
    L22:
        r4 = r4 + 1;
        goto L11
    L15:
        if (r10.c().equals(r7.c()) == false) goto L19;
        if (r10.s == r7.s) goto L24;
        r7.t = r10.t;
        r7.s = r10.s;
    L24:
        if (r5 >= 0) goto L26;
        return;
    L26:
        if (r0 >= 3) goto L30;
        r12.add(r10);
        return;
    L30:
        if (r10.t <= r2) goto L40;
        if (r5 >= r0) goto L41;
        r12.remove(r5);
        r12.add(r10);
        return;
    L41:
        return;
    L40:
        return;
    L23:
        r5 = r6;
        goto L24
    L42:
        return;
    }

    private void a(ArrayList<dt> r4, ArrayList<dt> r5) {
        if (r5 != null) goto L5;
    L15:
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.size() <= 0) goto L27;
        a((dt) ZeusTransformUtils.preCheckCast(r4.get(0), dt.class, "com.obric.memorydata.plugin"), this.T);
        return;
    L27:
        return;
    L5:
        if (r5.size() <= 0) goto L15;
        Iterator<dt> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        dt r1 = (dt) ZeusTransformUtils.preCheckCast(r6.next(), dt.class, "com.obric.memorydata.plugin");
        if (r1.r == false) goto L8;
        if (r1.n == false) goto L8;
        a(r1, this.T);
    }

    private byte[] a(String r7) {
        String[] r0 = r7.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        byte[] r2 = new byte[6];
        if (r0 != null) goto L20;
    L6:
        r0 = new String[6];     // Catch: Throwable -> L17
        int r4 = 0;
    L7:
        if (r4 >= 6) goto L9;
        r0[r4] = "0";     // Catch: Throwable -> L17
        r4 = r4 + 1;     // Catch: Throwable -> L17
    L9:
        int r1 = 0;
    L10:
        if (r1 >= r0.length) goto L24;
        if (r0[r1].length() <= 2) goto L15;
        r0[r1] = r0[r1].substring(0, 2);     // Catch: Throwable -> L17
    L15:
        r2[r1] = (byte) Integer.parseInt(r0[r1], 16);     // Catch: Throwable -> L17
        r1 = r1 + 1;
        goto L10
    L24:
        return r2;
    L17:
        th = move-exception;
        ev.a(th, "Req", "getMacBa ".concat(String.valueOf(r7)));
        return a("00:00:00:00:00:00");
    L20:
        if (r0.length == 6) goto L9;
        goto L6
    }

    private void b() {
        String[] r1 = new String[27];
        r1[0] = this.f5508a;
        r1[1] = this.c;
        r1[2] = this.d;
        r1[3] = this.e;
        r1[4] = this.f;
        r1[5] = this.g;
        r1[6] = this.h;
        r1[7] = this.i;
        r1[8] = this.l;
        r1[9] = this.m;
        r1[10] = this.n;
        r1[11] = this.o;
        r1[12] = this.p;
        r1[13] = this.q;
        r1[14] = this.r;
        r1[15] = this.s;
        r1[16] = this.t;
        r1[17] = this.u;
        r1[18] = this.v;
        r1[19] = this.w;
        r1[20] = this.x;
        r1[21] = this.D;
        r1[22] = this.F;
        r1[23] = this.G;
        r1[24] = I;
        r1[25] = this.M;
        r1[26] = this.N;
        int r2 = 0;
    L3:
        if (r2 >= 27) goto L9;
        if (TextUtils.isEmpty(r1[r2]) == false) goto L7;
        r1[r2] = "";
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        if (TextUtils.isEmpty(this.j) == false) goto L12;
    L10:
        this.j = "0";
    L17:
        if (TextUtils.isEmpty(this.k) == false) goto L20;
    L18:
        this.k = "0";
    L25:
        if (TextUtils.isEmpty(this.y) == false) goto L28;
    L26:
        this.y = "0";
    L33:
        if (du.a(this.z) == true) goto L36;
        this.z = 0;
    L36:
        if (this.H != null) goto L42;
        this.H = new byte[0];
        return;
    L42:
        return;
    L28:
        if ("1".equals(this.y) == true) goto L33;
        if ("2".equals(this.y) == true) goto L33;
    L20:
        if ("0".equals(this.k) == true) goto L25;
        if ("1".equals(this.k) == true) goto L25;
    L12:
        if ("0".equals(this.j) == true) goto L17;
        if ("2".equals(this.j) == true) goto L17;
        goto L10
    }

    public final void a(Context r19, boolean r20, boolean r21, du r22, eg r23, ConnectivityManager r24, String r25, eb r26) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        String r3 = fm.f(r2);
        int r4 = fd.d();
        this.f5507J = r25;
        this.S = null;
        if (r21 == true) goto L5;
        String r0 = "UC_nlp_20131029";
        String r6 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L6:
        String r7 = r6;
        String r8 = r0;
        StringBuilder r9 = new StringBuilder();
        int r10 = r22.g();
        int r1 = r22.h();
        TelephonyManager r11 = r22.i();
        ArrayList<dt> r12 = r22.c();
        ArrayList<dt> r13 = r22.d();
        ArrayList<db> r14 = r23.e();
        if (r1 != 2) goto L9;
        String r16 = "1";
    L11:
        if (r11 != null) goto L13;
        String r27 = "1";
    L118:
        NetworkInfo r5 = r24.getActiveNetworkInfo();     // Catch: Throwable -> L37
    L39:
        boolean r15 = r23.a(r24);
        if (fd.a(r5) == (-1)) goto L45;
        String r17 = fd.a(r24);
        if (r15 == false) goto L44;
        String r18 = "2";
    L47:
        if ((r10 & 4) == 4) goto L49;
    L51:
        this.B.clear();
    L52:
        this.A.clear();
        this.A.addAll(r12);
        StringBuilder r28 = new StringBuilder();
        if (r23.l() == false) goto L74;
        if (r15 == false) goto L70;
        ef r29 = r23.n();
        if (eg.a(r29) == false) goto L70;
        r28.append(r29.a()).append(",");
        int r110 = r29.c();
        if (r110 >= (-128)) goto L61;
    L59:
        r110 = 0;
    L63:
        r28.append(r110).append(",");
        String r30 = r29.b();
        int r111 = r30.getBytes(RpcUtils.CHARSET_UTF8).length;     // Catch: Exception -> L66
    L67:
        if (r111 < 32) goto L69;
        r30 = "unkwn";
    L69:
        r28.append(r30.replace("*", "."));
    L66:
        r111 = 32;
        goto L67
    L61:
        if (r110 <= 127) goto L63;
    L70:
        if (r14 == null) goto L77;
        ArrayList<db> r31 = this.E;
        if (r31 == null) goto L77;
        r31.clear();
        this.E.addAll(r14);
    L77:
        this.f5509b = 0;
        if (r20 == true) goto L80;
        this.f5509b = (short) (2 | 0);
    L80:
        this.c = r8;
        this.d = r7;
        this.f = Build.MODEL;
        this.g = "android" + Build.VERSION.RELEASE;
        this.h = fd.b(r2);
        this.i = r16;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = r3;
        this.p = ev.g;
        this.q = ev.h;
        this.s = String.valueOf(r4);
        this.t = fd.i(r2);
        this.v = "6.4.8";
        this.w = null;
        this.u = "";
        this.x = r17;
        this.y = r18;
        this.z = r10;
        this.C = r22.l();
        this.F = eg.q();
        this.D = r28.toString();
        this.O = (int) ((fd.b() - r23.r()) / 1000);
        if (TextUtils.isEmpty(I) == false) goto L112;
        I = fp.f(r2);     // Catch: Throwable -> L100
    L112:
        if (TextUtils.isEmpty(K) == false) goto L106;
        K = fp.a(r2);     // Catch: Throwable -> L101
    L106:
        if (TextUtils.isEmpty(this.M) == false) goto L104;
        this.M = fp.f();     // Catch: Throwable -> L102
    L104:
        if (TextUtils.isEmpty(this.N) == false) goto L110;
        this.N = fp.e(r2);     // Catch: Throwable -> L103
    L110:
        this.S = r26.a(this.B, this.E);     // Catch: Throwable -> L95
        a(this.A, this.B);     // Catch: Throwable -> L95
    L97:
        r9.delete(0, r9.length());
        r28.delete(0, r28.length());
        return;
    L95:
        th = move-exception;
        th.printStackTrace();
        goto L97
    L74:
        r23.g();
        ArrayList<db> r32 = this.E;
        if (r32 == null) goto L77;
        r32.clear();
        goto L77
    L49:
        if (r13.isEmpty() == true) goto L51;
        this.B.clear();
        this.B.addAll(r13);
        goto L52
    L44:
        r18 = r27;
        goto L47
    L45:
        r17 = "";
        r18 = r17;
    L37:
        th = move-exception;
        ev.a(th, "Aps", "getApsReq part");
        r5 = null;
        goto L39
    L13:
        if (TextUtils.isEmpty(ev.g) == true) goto L108;
    L18:
        r27 = "1";
        if (TextUtils.isEmpty(ev.g) == false) goto L24;
        if (Build.VERSION.SDK_INT >= 29) goto L24;
        ev.g = "888888888888888";
    L24:
        if (TextUtils.isEmpty(ev.h) == false) goto L30;
        ev.h = fp.n();     // Catch: Throwable -> L27 SecurityException -> L99
    L27:
        th = move-exception;
        ev.a(th, "Aps", "getApsReq part2");
    L30:
        if (TextUtils.isEmpty(ev.h) == false) goto L118;
        if (Build.VERSION.SDK_INT >= 29) goto L118;
        ev.h = "888888888888888";
        goto L118
    L108:
        ev.g = fp.k();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ev.a(th, "Aps", "getApsReq part4");
        goto L18
    L9:
        r16 = "0";
        goto L11
    L5:
        r0 = "api_serverSDK_130905";
        r6 = "S128DF1572465B890OE3F7A13167KLEI";
        goto L6
    }

    public final byte[] a() {
        b();
        byte[] r4 = new byte[2];
        byte[] r6 = new byte[4];
        byte[] r0 = this.H;
        int r7 = 4096;
        int r8 = 1;
        if (r0 == null) goto L5;
        r7 = 4096 + (r0.length + 1);
    L5:
        byte[] r1 = this.Q;
        if (r1 != null) goto L8;
    L9:
        r1 = new byte[r7];
        this.Q = r1;
        this.R = r7;
    L10:
        byte[] r9 = r1;
        int r10 = 0;
        r9[0] = fd.g(this.f5508a);
        byte[] r2 = fd.a(this.f5509b, null);
        System.arraycopy(r2, 0, r9, 1, r2.length);
        int r11 = a(this.q, r9, a(this.p, r9, a(this.h, r9, a(this.u, r9, a(this.g, r9, a(this.f, r9, a(this.e, r9, a(this.o, r9, a(this.d, r9, a(this.c, r9, r2.length + 1))))))))));
    L16:
        th = move-exception;
        ev.a(th, "Req", "buildV4Dot219");
        r9[r11] = 0;
    L18:
        int r12 = r11 + 1;
    L19:
        int r3 = a(this.x, r9, a(K, r9, a(I, r9, a(this.w, r9, a(this.v, r9, r12)))));
        r9[r3] = Byte.parseByte(this.y);
        int r5 = r3 + 1;
        r9[r5] = Byte.parseByte(this.j);
        int r13 = r5 + 1;
        int r14 = this.z;
        int r15 = r14 & 3;
        r9[r13] = (byte) r14;
        int r16 = r13 + 1;
        long r17 = 0;
        String r18 = "com.obric.memorydata.plugin";
        if (r15 == 1) goto L23;
        if (r15 == 2) goto L23;
    L126:
        String r19 = this.C;
        if (r19 != null) goto L129;
    L132:
        r9[r16] = 0;
        int r20 = r16 + 1;
    L133:
        ArrayList<dt> r21 = this.B;
        int r110 = r21.size();
        int r111 = 3;
        if ((this.z & 4) != 4) goto L200;
        if (r110 <= 0) goto L200;
        r21.get(0);
        r9[r20] = (byte) r110;
        byte r112 = 1;
        int r22 = r20 + 1;
        int r113 = 0;
    L137:
        if (r113 >= r110) goto L199;
        dt r23 = (dt) ZeusTransformUtils.preCheckCast(r21.get(r113), dt.class, r18);
        if (r23.l != r112) goto L141;
    L158:
        byte r114 = (byte) r23.l;
        if (r23.n == false) goto L161;
        r114 = (byte) (r114 | 8);
    L161:
        r9[r22] = r114;
        int r24 = r22 + 1;
        byte[] r115 = fd.a(r23.f5466a, r4);
        System.arraycopy(r115, 0, r9, r24, r115.length);
        int r25 = r24 + r115.length;
        byte[] r116 = fd.a(r23.f5467b, r4);
        System.arraycopy(r116, 0, r9, r25, r116.length);
        int r26 = r25 + r116.length;
        byte[] r117 = fd.a(r23.c, r4);
        System.arraycopy(r117, 0, r9, r26, r117.length);
        int r27 = r26 + r117.length;
        byte[] r118 = fd.b(r23.d, r6);
        System.arraycopy(r118, 0, r9, r27, r118.length);
        r22 = r27 + r118.length;
    L162:
        int r119 = r23.k;
        if (r119 <= 127) goto L166;
    L164:
        r119 = 99;
    L168:
        r9[r22] = (byte) r119;
        int r28 = r22 + 1;
        String r29 = r18;
        byte[] r120 = fd.a((short) ((fd.b() - r23.t) / 1000), r4);
        System.arraycopy(r120, 0, r9, r28, r120.length);
        r22 = r28 + r120.length;
        int r121 = 32767;
        if (r23.l == 3) goto L188;
        if (r23.l == 4) goto L188;
        if (r23.l == 5) goto L188;
        if (r23.l != 1) goto L198;
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.3d) goto L198;
        int r122 = r23.o;
        if (r122 <= 32767) goto L182;
        r122 = 32767;
    L182:
        if (r122 < 0) goto L185;
        r121 = r122;
    L185:
        byte[] r123 = fd.a(r121, r4);
        System.arraycopy(r123, 0, r9, r22, r123.length);
        int r30 = r22 + r123.length;
        byte[] r124 = fd.b(r23.p, r6);
        System.arraycopy(r124, 0, r9, r30, r124.length);
        int r31 = r30 + r124.length;
        byte[] r32 = fd.b(r23.q, r6);
        System.arraycopy(r32, 0, r9, r31, r32.length);
        int r33 = r32.length;
    L186:
        r22 = r31 + r33;
    L198:
        r113 = r113 + 1;
        r110 = r110;
        r18 = r29;
        r112 = 1;
        r111 = 3;
    L188:
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.0d) goto L198;
        int r125 = r23.o;
        if (r125 <= 32767) goto L192;
        r125 = 32767;
    L192:
        if (r125 < 0) goto L195;
        r121 = r125;
    L195:
        byte[] r126 = fd.a(r121, r4);
        System.arraycopy(r126, 0, r9, r22, r126.length);
        r22 = r22 + r126.length;
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.3d) goto L198;
        byte[] r127 = fd.b(r23.p, r6);
        System.arraycopy(r127, 0, r9, r22, r127.length);
        r31 = r22 + r127.length;
        byte[] r34 = fd.b(r23.q, r6);
        System.arraycopy(r34, 0, r9, r31, r34.length);
        r33 = r34.length;
        goto L186
    L166:
        if (r119 >= (-128)) goto L168;
    L141:
        if (r23.l == r111) goto L158;
        if (r23.l == 4) goto L158;
        if (r23.l != 2) goto L152;
        byte r128 = (byte) r23.l;
        if (r23.n == false) goto L150;
        r128 = (byte) (r128 | 8);
    L150:
        r9[r22] = r128;
        int r35 = r22 + 1;
        byte[] r129 = fd.a(r23.f5466a, r4);
        System.arraycopy(r129, 0, r9, r35, r129.length);
        int r36 = r35 + r129.length;
        byte[] r130 = fd.a(r23.h, r4);
        System.arraycopy(r130, 0, r9, r36, r130.length);
        int r37 = r36 + r130.length;
        byte[] r131 = fd.a(r23.i, r4);
        System.arraycopy(r131, 0, r9, r37, r131.length);
        int r38 = r37 + r131.length;
        byte[] r132 = fd.a(r23.j, r4);
        System.arraycopy(r132, 0, r9, r38, r132.length);
        int r39 = r38 + r132.length;
        byte[] r133 = fd.b(r23.g, r6);
        System.arraycopy(r133, 0, r9, r39, r133.length);
        int r40 = r39 + r133.length;
        byte[] r134 = fd.b(r23.f, r6);
        System.arraycopy(r134, 0, r9, r40, r134.length);
        r22 = r40 + r134.length;
        goto L162
    L152:
        if (r23.l != 5) goto L162;
        byte r135 = (byte) r23.l;
        if (r23.n == false) goto L156;
        r135 = (byte) (r135 | 8);
    L156:
        r9[r22] = r135;
        int r41 = r22 + 1;
        byte[] r136 = fd.a(r23.f5466a, r4);
        System.arraycopy(r136, 0, r9, r41, r136.length);
        int r42 = r41 + r136.length;
        byte[] r137 = fd.a(r23.f5467b, r4);
        System.arraycopy(r137, 0, r9, r42, r137.length);
        int r43 = r42 + r137.length;
        byte[] r138 = fd.a(r23.c, r4);
        System.arraycopy(r138, 0, r9, r43, r138.length);
        int r44 = r43 + r138.length;
        System.arraycopy(fd.a(r23.e), 0, r9, r44, 8);
        r22 = r44 + 8;
        goto L162
    L199:
        String r210 = r18;
        byte r45 = r112;
    L202:
        if (TextUtils.isEmpty(this.D) == false) goto L204;
    L229:
        int r46 = r45;
        byte r47 = 0;
        r9[r22] = 0;
        int r139 = r22 + 1;
    L230:
        ArrayList<db> r48 = this.E;
        int r49 = Math.min(r48.size(), 25);
        if (r49 != 0) goto L233;
        r9[r139] = r47;
        int r140 = r139 + r46;
        String r141 = r210;
        byte r50 = 0;
    L261:
        r9[r140] = r50;
        int r51 = 1;
        int r142 = r140 + 1;
        String r52 = this.G;     // Catch: Throwable -> L272
        if (r52 != null) goto L265;
        r9[r142] = r50;     // Catch: Throwable -> L272
    L273:
        int r143 = r142 + r51;
    L274:
        byte[] r53 = {0, 0};
        boolean r54 = TextUtils.isEmpty(this.f5507J);     // Catch: Throwable -> L285
        if (r54 == true) goto L278;
        r53 = fd.a(this.f5507J.length(), r4);     // Catch: Throwable -> L285
    L278:
        int r55 = 2;
        System.arraycopy(r53, 0, r9, r143, 2);     // Catch: Throwable -> L371
        int r144 = r143 + 2;
        if (r54 == false) goto L381;
    L284:
        int r56 = 0;
        r55 = 2;
    L390:
        System.arraycopy(fd.a(r56, r4), r56, r9, r144, r55);     // Catch: Throwable -> L369
    L288:
        int r145 = r144 + r55;
        byte[] r57 = new byte[r55];
        r57 = {x09c2: FILL_ARRAY_DATA , data: [0, 0} // fill-array;
        System.arraycopy(r57, r56, r9, r145, r55);     // Catch: Throwable -> L370
    L290:
        int r146 = r145 + r55;
        byte[] r58 = this.H;
        if (r58 == null) goto L293;
        int r59 = r58.length;
        byte[] r60 = null;
    L294:
        byte[] r61 = fd.a(r59, r60);
        System.arraycopy(r61, 0, r9, r146, r61.length);
        int r147 = r146 + r61.length;
        if (r59 <= 0) goto L298;
        byte[] r62 = this.H;
        System.arraycopy(r62, 0, r9, r147, r62.length);
        r147 = r147 + this.H.length;
    L298:
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.0d) goto L346;
        List<dt> r63 = this.T;
        if (r63 == null) goto L302;
        int r64 = r63.size();
    L303:
        r9[r147] = (byte) r64;
        int r148 = r147 + 1;
        byte[] r65 = new byte[r148];
        System.arraycopy(r9, 0, r65, 0, r148);
        if (r64 > 0) goto L375;
    L344:
        r147 = a(this.M, r9, r148);
        goto L346
    L375:
        Iterator<dt> r66 = this.T.iterator();     // Catch: Throwable -> L342
        int r67 = r148;
    L306:
        if (r66.hasNext() == false) goto L341;
        dt r68 = (dt) ZeusTransformUtils.preCheckCast(r66.next(), dt.class, r141);     // Catch: Throwable -> L342
        if (r68.l != 1) goto L311;
    L335:
        byte r69 = (byte) r68.l;     // Catch: Throwable -> L342
        if (r68.n == false) goto L338;
        r69 = (byte) (r69 | 8);     // Catch: Throwable -> L342
    L338:
        r9[r67] = r69;     // Catch: Throwable -> L342
        int r70 = r67 + 1;     // Catch: Throwable -> L342
        byte[] r71 = fd.a(r68.c, r4);     // Catch: Throwable -> L342
        System.arraycopy(r71, 0, r9, r70, r71.length);     // Catch: Throwable -> L342
        int r72 = r70 + r71.length;     // Catch: Throwable -> L342
        byte[] r73 = fd.b(r68.d, r6);     // Catch: Throwable -> L342
        System.arraycopy(r73, 0, r9, r72, r73.length);     // Catch: Throwable -> L342
        r67 = r72 + r73.length;     // Catch: Throwable -> L342
    L339:
        byte[] r149 = fd.a((short) ((fd.b() - r68.t) / 1000), r4);     // Catch: Throwable -> L342
        System.arraycopy(r149, 0, r9, r67, r149.length);     // Catch: Throwable -> L342
        r67 = r67 + r149.length;
        goto L306
    L311:
        if (r68.l == 3) goto L335;
        if (r68.l == 4) goto L335;
        if (r68.l != 2) goto L326;
        byte r74 = (byte) r68.l;     // Catch: Throwable -> L342
        if (r68.n == false) goto L320;
        r74 = (byte) (r74 | 8);     // Catch: Throwable -> L342
    L320:
        r9[r67] = r74;     // Catch: Throwable -> L342
        int r75 = r67 + 1;     // Catch: Throwable -> L342
        byte[] r76 = fd.a(r68.h, r4);     // Catch: Throwable -> L342
        System.arraycopy(r76, 0, r9, r75, r76.length);     // Catch: Throwable -> L324
        int r77 = r75 + r76.length;     // Catch: Throwable -> L324
        byte[] r78 = fd.a(r68.i, r4);     // Catch: Throwable -> L324
        System.arraycopy(r78, 0, r9, r77, r78.length);     // Catch: Throwable -> L324
        int r79 = r77 + r78.length;     // Catch: Throwable -> L324
        byte[] r80 = fd.a(r68.j, r4);     // Catch: Throwable -> L324
        System.arraycopy(r80, 0, r9, r79, r80.length);     // Catch: Throwable -> L324
        r67 = r79 + r80.length;     // Catch: Throwable -> L342
    L324:
        byte r81 = 0;
    L343:
        System.arraycopy(r65, r81, r9, r81, r148);
        r9[r148 - 1] = r81;
        goto L344
    L326:
        if (r68.l != 5) goto L339;
        byte r82 = (byte) r68.l;     // Catch: Throwable -> L342
        if (r68.n == false) goto L330;
        r82 = (byte) (r82 | 8);     // Catch: Throwable -> L342
    L330:
        r9[r67] = r82;     // Catch: Throwable -> L342
        int r83 = r67 + 1;     // Catch: Throwable -> L342
        byte[] r84 = fd.a(r68.c, r4);     // Catch: Throwable -> L342
        System.arraycopy(r84, 0, r9, r83, r84.length);     // Catch: Throwable -> L334
        int r85 = r83 + r84.length;     // Catch: Throwable -> L334
        System.arraycopy(fd.a(r68.e), 0, r9, r85, 8);     // Catch: Throwable -> L334
        r67 = r85 + 8;
    L334:
        r81 = 0;
        goto L343
    L341:
        r148 = r67;
    L342:
        r81 = 0;
        goto L343
    L302:
        r64 = 0;
    L346:
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.2d) goto L364;
        List<ea> r86 = this.S;
        if (r86 != null) goto L350;
        int r87 = 0;
    L351:
        r9[r147] = (byte) r87;
        r147 = r147 + 1;
        if (r87 <= 0) goto L364;
        Iterator<ea> r88 = this.S.iterator();
    L355:
        if (r88.hasNext() == false) goto L364;
        ea r89 = (ea) ZeusTransformUtils.preCheckCast(r88.next(), ea.class, r141);
        int r90 = ((int) (System.currentTimeMillis() - r89.d)) / 1000;
        if (r90 <= 65535) goto L359;
        r90 = 65535;
    L359:
        System.arraycopy(fd.a(r90, r4), 0, r9, r147, 2);
        int r150 = r147 + 2;
        System.arraycopy(fd.b((int) Math.round(r89.c * 1.0E7d), r6), 0, r9, r150, 4);
        int r151 = r150 + 4;
        System.arraycopy(fd.b((int) Math.round(r89.f5477b * 1.0E7d), r6), 0, r9, r151, 4);
        int r152 = r151 + 4;
        float r91 = r89.e;
        if (r91 <= 65535.0f) goto L362;
        r91 = 65535.0f;
    L362:
        System.arraycopy(fd.a((int) r91, r4), 0, r9, r152, 2);
        int r153 = r152 + 2;
        System.arraycopy(fd.a((short) ((r89.h | ((r89.f5476a << 13) | (r89.g << 6))) & 65535), r4), 0, r9, r153, 2);
        r147 = r153 + 2;
        goto L355
    L350:
        r87 = r86.size();
    L364:
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.3d) goto L366;
        r147 = a(this.N, r9, r147);
    L366:
        byte[] r92 = new byte[r147];
        System.arraycopy(r9, 0, r92, 0, r147);
        CRC32 r93 = new CRC32();
        r93.update(r92);
        byte[] r94 = fd.a(r93.getValue());
        byte[] r95 = new byte[r147 + 8];
        System.arraycopy(r92, 0, r95, 0, r147);
        System.arraycopy(r94, 0, r95, r147, 8);
        return r95;
    L293:
        r60 = null;
        r59 = 0;
        goto L294
    L381:
        byte[] r96 = this.f5507J.getBytes("GBK");     // Catch: Throwable -> L368
        System.arraycopy(r96, 0, r9, r144, r96.length);     // Catch: Throwable -> L368
        r144 = r144 + r96.length;
    L286:
        r144 = r143 + r55;
        r56 = 0;
    L285:
        r55 = 2;
        goto L286
    L265:
        byte[] r97 = r52.getBytes("GBK");     // Catch: Throwable -> L272
        if (r97.length <= 127) goto L268;
        r97 = null;
    L268:
        if (r97 != null) goto L270;
        r9[r142] = 0;     // Catch: Throwable -> L272
        r143 = r142 + 1;     // Catch: Throwable -> L272
        goto L274
    L270:
        r9[r142] = (byte) r97.length;     // Catch: Throwable -> L272
        int r154 = r142 + 1;     // Catch: Throwable -> L272
        System.arraycopy(r97, 0, r9, r154, r97.length);     // Catch: Throwable -> L272
        r143 = r154 + r97.length;
    L272:
        r9[r142] = 0;
        r51 = 1;
        goto L273
    L233:
        r9[r139] = (byte) r49;
        int r155 = r139 + r46;
        if (fd.c() < 17) goto L236;
        boolean r98 = true;
    L237:
        if (r98 == false) goto L239;
        r17 = fd.b() / 1000;
    L239:
        int r156 = r155;
        int r157 = 0;
    L240:
        if (r157 >= r49) goto L260;
        String r158 = r210;
        db r159 = (db) ZeusTransformUtils.preCheckCast(r48.get(r157), db.class, r158);
        int r211 = r49;
        byte[] r99 = a(db.a(r159.f5428a));
        System.arraycopy(r99, 0, r9, r156, r99.length);
        int r160 = r156 + r99.length;
        byte[] r100 = r159.f5429b.getBytes("GBK");     // Catch: Exception -> L244
        r9[r160] = (byte) r100.length;     // Catch: Exception -> L244
        r160 = r160 + 1;     // Catch: Exception -> L244
        System.arraycopy(r100, 0, r9, r160, r100.length);     // Catch: Exception -> L244
        int r161 = r160 + r100.length;
        int r101 = 1;
    L245:
        int r102 = r159.c;
        if (r102 <= 127) goto L250;
    L248:
        r102 = 0;
    L252:
        r9[r161] = Byte.parseByte(String.valueOf(r102));
        int r162 = r161 + r101;
        if (r98 == false) goto L256;
        int r103 = (int) (r17 - (r159.f / 1000));
        if (r103 < 0) goto L256;
    L257:
        if (r103 <= 65535) goto L259;
        r103 = 65535;
    L259:
        byte[] r104 = fd.a(r103, r4);
        System.arraycopy(r104, 0, r9, r162, r104.length);
        int r163 = r162 + r104.length;
        byte[] r105 = fd.a(r159.d, r4);
        System.arraycopy(r105, 0, r9, r163, r105.length);
        r156 = r163 + r105.length;
        r157 = r157 + 1;
        r210 = r158;
        r49 = r211;
    L256:
        r103 = 0;
        goto L257
    L250:
        if (r102 >= (-128)) goto L252;
    L244:
        r9[r160] = 0;
        r101 = 1;
        r161 = r160 + 1;
        goto L245
    L260:
        r141 = r210;
        r50 = 0;
        byte[] r106 = fd.a(Integer.parseInt(this.F), r4);
        System.arraycopy(r106, 0, r9, r156, r106.length);
        r140 = r156 + r106.length;
        goto L261
    L236:
        r98 = false;
        goto L237
    L204:
        if (this.D.length() == 0) goto L229;
        r9[r22] = r45;
        r139 = r22 + 1;
        String[] r107 = this.D.split(",");     // Catch: Throwable -> L227
        byte[] r108 = a(r107[0]);     // Catch: Throwable -> L227
        System.arraycopy(r108, 0, r9, r139, r108.length);     // Catch: Throwable -> L227
        r139 = r139 + r108.length;
        byte[] r109 = r107[2].getBytes("GBK");     // Catch: Throwable -> L214
        int r164 = r109.length;     // Catch: Throwable -> L214
        if (r164 <= 127) goto L212;
        r164 = 127;
    L212:
        r9[r139] = (byte) r164;     // Catch: Throwable -> L214
        r139 = r139 + 1;     // Catch: Throwable -> L214
        System.arraycopy(r109, 0, r9, r139, r164);     // Catch: Throwable -> L214
        int r165 = r139 + r164;
    L216:
        int r166 = Integer.parseInt(r107[1]);     // Catch: Throwable -> L227
        if (r166 <= 127) goto L220;
    L218:
        r166 = 0;
    L222:
        r9[r165] = Byte.parseByte(String.valueOf(r166));     // Catch: Throwable -> L227
        r139 = r165 + 1;     // Catch: Throwable -> L227
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.2d) goto L226;
        byte[] r167 = fd.a(this.O, r4);     // Catch: Throwable -> L227
        System.arraycopy(r167, 0, r9, r139, r167.length);     // Catch: Throwable -> L227
        r139 = r139 + r167.length;
    L226:
        r46 = 1;
        r47 = 0;
        goto L230
    L220:
        if (r166 >= (-128)) goto L222;
    L214:
        th = move-exception;
        ev.a(th, "Req", "buildV4Dot214");     // Catch: Throwable -> L227
        r9[r139] = 0;     // Catch: Throwable -> L227
        r165 = r139 + 1;     // Catch: Throwable -> L227
    L227:
        th = move-exception;
        ev.a(th, "Req", "buildV4Dot216");
        byte[] r168 = a("00:00:00:00:00:00");
        r47 = 0;
        System.arraycopy(r168, 0, r9, r139, r168.length);
        int r169 = r139 + r168.length;
        r9[r169] = 0;
        r46 = 1;
        int r170 = r169 + 1;
        r9[r170] = Byte.parseByte("0");
        r139 = r170 + 1;
    L200:
        r210 = "com.obric.memorydata.plugin";
        r9[r20] = 0;
        r45 = 1;
        r22 = r20 + 1;
        goto L202
    L129:
        if ((this.z & 8) != 8) goto L132;
        byte[] r171 = r19.getBytes("GBK");     // Catch: Exception -> L372
        int r172 = Math.min(r171.length, 60);     // Catch: Exception -> L372
        r9[r16] = (byte) r172;     // Catch: Exception -> L372
        r16 = r16 + 1;     // Catch: Exception -> L372
        System.arraycopy(r171, 0, r9, r16, r172);     // Catch: Exception -> L372
        r20 = r16 + r172;
    L23:
        if (this.A.size() <= 0) goto L25;
        int r173 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).f5466a;
    L26:
        byte[] r174 = fd.a(r173, null);
        System.arraycopy(r174, 0, r9, r16, r174.length);
        int r175 = r16 + r174.length;
        if (r15 == 1) goto L29;
        if (r15 == 2) goto L44;
    L65:
        if (this.A.size() <= 0) goto L67;
        int r176 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).k;
    L68:
        if (r176 <= 127) goto L70;
    L69:
        r176 = 0;
    L72:
        r9[r175] = (byte) r176;
        int r177 = r175 + 1;
        if (this.A.size() <= 0) goto L75;
        long r178 = (fd.b() - ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).t) / 1000;
    L76:
        long r179 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
        if (r178 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L80;
        r178 = 65535;
    L80:
        if (r178 >= 0) goto L82;
        r178 = 0;
    L82:
        byte[] r180 = fd.a((int) r178, r4);
        System.arraycopy(r180, 0, r9, r177, r180.length);
        r16 = r177 + 2;
        if (r15 != 1) goto L123;
        if (this.A.size() != 0) goto L87;
        r9[r16] = 0;
    L125:
        r16 = r16 + 1;
        goto L126
    L87:
        int r181 = this.A.size();
        r9[r16] = (byte) r181;
        r16 = r16 + 1;
        int r182 = 0;
    L88:
        if (r182 >= r181) goto L126;
        if (this.A.size() <= 0) goto L92;
        int r183 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(r182), dt.class, "com.obric.memorydata.plugin")).c;
    L93:
        byte[] r184 = fd.a(r183, null);
        System.arraycopy(r184, r10, r9, r16, r184.length);
        int r185 = r16 + r184.length;
        if (this.A.size() <= 0) goto L96;
        int r186 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(r182), dt.class, "com.obric.memorydata.plugin")).d;
    L97:
        byte[] r187 = fd.b(r186, null);
        System.arraycopy(r187, r10, r9, r185, r187.length);
        int r188 = r185 + r187.length;
        if (this.A.size() <= 0) goto L100;
        int r189 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(r182), dt.class, "com.obric.memorydata.plugin")).k;
    L102:
        if (r189 <= 127) goto L105;
    L103:
        r189 = r10;
    L107:
        r9[r188] = (byte) r189;
        r16 = r188 + r8;
        if (Double.valueOf(ev.f5514a).doubleValue() >= 5.2d) goto L110;
        int r190 = r10;
        long r191 = r179;
    L121:
        r182 = r182 + 1;
        r179 = r191;
        r10 = r190;
        r8 = 1;
        goto L88
    L110:
        if (this.A.size() <= 0) goto L112;
        long r192 = (fd.b() - ((dt) ZeusTransformUtils.preCheckCast(this.A.get(r10), dt.class, "com.obric.memorydata.plugin")).t) / 1000;
        r191 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
    L114:
        if (r192 <= r191) goto L117;
        r192 = r191;
    L117:
        if (r192 >= 0) goto L119;
        r192 = 0;
    L119:
        byte[] r193 = fd.a((int) r192, r4);
        r190 = 0;
        System.arraycopy(r193, 0, r9, r16, r193.length);
        r16 = r16 + r193.length;
        goto L121
    L112:
        r191 = r179;
        r192 = 0;
        goto L114
    L105:
        if (r189 >= (-128)) goto L107;
    L100:
        r189 = r10;
        goto L102
    L96:
        r186 = r10;
        goto L97
    L92:
        r183 = r10;
        goto L93
    L123:
        if (r15 != 2) goto L126;
        r9[r16] = 0;
        goto L125
    L75:
        r178 = 0;
        goto L76
    L70:
        if (r176 >= (-128)) goto L72;
    L67:
        r176 = 0;
        goto L68
    L44:
        if (this.A.size() <= 0) goto L46;
        int r194 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).h;
    L47:
        byte[] r195 = fd.a(r194, null);
        System.arraycopy(r195, 0, r9, r175, r195.length);
        int r196 = r175 + r195.length;
        if (this.A.size() <= 0) goto L50;
        int r197 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).i;
    L51:
        byte[] r198 = fd.a(r197, null);
        System.arraycopy(r198, 0, r9, r196, r198.length);
        int r199 = r196 + r198.length;
        if (this.A.size() <= 0) goto L54;
        int r1100 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).j;
    L55:
        byte[] r1101 = fd.a(r1100, null);
        System.arraycopy(r1101, 0, r9, r199, r1101.length);
        int r200 = r199 + r1101.length;
        if (this.A.size() <= 0) goto L58;
        int r1102 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).g;
    L59:
        byte[] r1103 = fd.b(r1102, null);
        System.arraycopy(r1103, 0, r9, r200, r1103.length);
        int r201 = r200 + r1103.length;
        if (this.A.size() <= 0) goto L62;
        int r1104 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).f;
    L63:
        byte[] r1105 = fd.b(r1104, null);
        System.arraycopy(r1105, 0, r9, r201, r1105.length);
        int r1106 = r1105.length;
    L41:
        r175 = r201 + r1106;
        goto L65
    L62:
        r1104 = 0;
        goto L63
    L58:
        r1102 = 0;
        goto L59
    L54:
        r1100 = 0;
        goto L55
    L50:
        r197 = 0;
        goto L51
    L46:
        r194 = 0;
        goto L47
    L29:
        if (this.A.size() <= 0) goto L31;
        int r1107 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).f5467b;
    L32:
        byte[] r1108 = fd.a(r1107, null);
        System.arraycopy(r1108, 0, r9, r175, r1108.length);
        int r202 = r175 + r1108.length;
        if (this.A.size() <= 0) goto L35;
        int r1109 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).c;
    L36:
        byte[] r1110 = fd.a(r1109, null);
        System.arraycopy(r1110, 0, r9, r202, r1110.length);
        r201 = r202 + r1110.length;
        if (this.A.size() <= 0) goto L39;
        int r1111 = ((dt) ZeusTransformUtils.preCheckCast(this.A.get(0), dt.class, "com.obric.memorydata.plugin")).d;
    L40:
        byte[] r1112 = fd.b(r1111, null);
        System.arraycopy(r1112, 0, r9, r201, r1112.length);
        r1106 = r1112.length;
        goto L41
    L39:
        r1111 = 0;
        goto L40
    L35:
        r1109 = 0;
        goto L36
    L31:
        r1107 = 0;
        goto L32
    L25:
        r173 = 0;
        goto L26
    L12:
        if (TextUtils.isEmpty(this.t) == false) goto L14;
        r9[r11] = 0;     // Catch: Throwable -> L16
        goto L18
    L14:
        byte[] r203 = a(this.t);     // Catch: Throwable -> L16
        r9[r11] = (byte) r203.length;     // Catch: Throwable -> L16
        int r1113 = r11 + 1;     // Catch: Throwable -> L16
        System.arraycopy(r203, 0, r9, r1113, r203.length);     // Catch: Throwable -> L16
        r12 = r1113 + r203.length;
        goto L19
    L8:
        if (r7 <= this.R) goto L10;
        goto L9
    }
}
