package n4a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a4 {
    public static String L;
    public static String M;
    public final ArrayList<v2> A;
    public String B;
    public byte[] C;
    public byte[] D;
    public int E;
    public String F;
    public String G;
    public String H;
    public int I;
    public List<m3> J;
    public final List<k3> K;
    public short a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public final ArrayList<k3> w;
    public final ArrayList<k3> x;
    public String y;
    public String z;

    public a4() {
        this.a = 0;
        this.b = null;
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
        this.v = 0;
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = null;
        this.z = null;
        this.A = new ArrayList();
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = 0;
        this.J = null;
        this.K = Collections.synchronizedList(new ArrayList());
    }

    public static int a(String r3, byte[] r4, int r5) {
    L11:
        th = move-exception;
        c4.g(th, "Req", "copyContentWithByteLen");
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

    public static void c(k3 r9, List<k3> r10) {
        if (r9 == null) goto L37;
        if (r10 == null) goto L41;
        int r0 = r10.size();
        if (r0 != 0) goto L9;
        r10.add(r9);
        return;
    L9:
        int r1 = -1;
        long r2 = Long.MAX_VALUE;
        int r4 = 0;
        int r5 = -1;
    L10:
        if (r4 >= r0) goto L22;
        k3 r6 = (k3) ListProtector.get(r10, r4);
        if (r9.b() != null) goto L14;
    L18:
        r2 = Math.min(r2, r6.s);
        if (r2 != r6.s) goto L21;
        r5 = r4;
    L21:
        r4 = r4 + 1;
        goto L10
    L14:
        if (r9.b().equals(r6.b()) == false) goto L18;
        int r7 = r9.r;
        if (r7 == r6.r) goto L23;
        r6.s = r9.s;
        r6.r = r7;
    L23:
        if (r1 >= 0) goto L25;
        return;
    L25:
        if (r0 >= 3) goto L29;
        r10.add(r9);
        return;
    L29:
        if (r9.s <= r2) goto L39;
        if (r1 >= r0) goto L40;
        ListProtector.remove(r10, r1);
        r10.add(r9);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        r1 = r5;
        goto L23
    L41:
        return;
    }

    public static byte[] d(String r6) {
        String[] r0 = r6.split(":");
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
        r2[r1] = (byte) CastIntegerProtector.parseInt(r0[r1], 16);     // Catch: Throwable -> L17
        r1 = r1 + 1;
        goto L10
    L24:
        return r2;
    L17:
        th = move-exception;
        c4.g(th, "Req", "getMacBa ".concat(r6));
        return d("00:00:00:00:00:00");
    L20:
        if (r0.length == 6) goto L9;
        goto L6
    }

    public final void e() {
        String[] r1 = new String[27];
        r1[0] = "1";
        boolean r5 = true;
        r1[1] = this.b;
        r1[2] = this.c;
        r1[3] = null;
        r1[4] = this.d;
        r1[5] = this.e;
        r1[6] = this.f;
        r1[7] = this.g;
        r1[8] = this.j;
        r1[9] = this.k;
        r1[10] = this.l;
        r1[11] = this.m;
        r1[12] = this.n;
        r1[13] = this.o;
        r1[14] = null;
        r1[15] = this.p;
        r1[16] = this.q;
        r1[17] = this.r;
        r1[18] = this.s;
        r1[19] = null;
        r1[20] = this.t;
        r1[21] = this.z;
        r1[22] = this.B;
        r1[23] = null;
        r1[24] = L;
        r1[25] = this.G;
        r1[26] = this.H;
        int r4 = 0;
    L3:
        if (r4 >= 27) goto L9;
        if (TextUtils.isEmpty(r1[r4]) == false) goto L7;
        r1[r4] = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        if (TextUtils.isEmpty(this.h) == false) goto L12;
    L15:
        this.h = "0";
    L17:
        if (TextUtils.isEmpty(this.i) == false) goto L20;
    L23:
        this.i = "0";
    L25:
        if (TextUtils.isEmpty(this.u) == false) goto L28;
    L31:
        this.u = "0";
    L32:
        int r0 = this.v;
        if (r0 <= 0) goto L35;
        if (r0 > 15) goto L35;
    L36:
        if (r5 == true) goto L39;
        this.v = 0;
    L39:
        if (this.C != null) goto L45;
        this.C = new byte[0];
        return;
    L45:
        return;
    L35:
        r5 = false;
        goto L36
    L28:
        if ("1".equals(this.u) == true) goto L32;
        if (RiskPreferenceSettings.SMART_BALANCE.equals(this.u) == true) goto L32;
    L20:
        if ("0".equals(this.i) == true) goto L25;
        if ("1".equals(this.i) == true) goto L25;
    L12:
        if ("0".equals(this.h) == true) goto L17;
        if (RiskPreferenceSettings.SMART_BALANCE.equals(this.h) == true) goto L17;
        goto L15
    }

    public final void b(Context r25, boolean r26, boolean r27, l3 r28, s3 r29, ConnectivityManager r30, String r31, n3 r32) {
        String r9 = v4.g(r25);
        int r10 = new Random().nextInt(65536) - 32768;
        this.F = r31;
        this.J = null;
        String r14 = "api_serverSDK_130905";
        String r15 = "S128DF1572465B890OE3F7A13167KLEI";
        if (r27 == true) goto L5;
        r14 = "UC_nlp_20131029";
        r15 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L5:
        StringBuilder r13 = new StringBuilder();
        k3 r0 = r28.o();
        if (r0 == null) goto L8;
        int r1 = r0.l;
    L10:
        if (r28.b == false) goto L12;
        int r11 = 4;
    L13:
        int r2 = r1 | r11;
        if (r28.c == false) goto L16;
        int r12 = 8;
    L17:
        int r16 = r12 | r2;
        k3 r3 = r28.o();
        if (r3 == null) goto L20;
        int r4 = r3.l;
    L21:
        int r5 = r4 & 3;
        TelephonyManager r17 = r28.g;
        monitor-enter(r28);
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L184
        ArrayList<k3> r6 = r28.d;     // Catch: Throwable -> L184
        if (r6 == null) goto L31;
        Iterator<k3> r7 = r6.iterator();     // Catch: Throwable -> L184
    L28:
        if (r7.hasNext() == false) goto L31;
        Iterator<k3> r21 = r7;
        r18.add(r7.next().c());     // Catch: Throwable -> L184
        r7 = r21;
    L31:
        monitor-exit(r28);
        ArrayList<k3> r8 = r28.n();
        ArrayList<v2> r19 = r29.i();
        if (r5 != 2) goto L35;
        String r22 = "1";
    L36:
        if (r17 != null) goto L38;
    L193:
        NetworkInfo r20 = r30.getActiveNetworkInfo();     // Catch: Throwable -> L62
    L64:
        boolean r23 = r29.b(r30);
        if (j4.d(r20) == (-1)) goto L94;
        if (r30 != null) goto L196;
    L72:
        int r24 = 0;
    L73:
        switch(r24) {
            case 1: goto L89;
            case 2: goto L88;
            case 3: goto L87;
            case 4: goto L86;
            case 5: goto L85;
            case 6: goto L84;
            case 7: goto L83;
            case 8: goto L82;
            case 9: goto L81;
            case 10: goto L80;
            case 11: goto L79;
            case 12: goto L78;
            case 13: goto L77;
            case 14: goto L76;
            case 15: goto L75;
            default: goto L74;
        };
    L74:
        String r33 = "UNKWN";
    L90:
        if (r23 == false) goto L92;
        String r110 = RiskPreferenceSettings.SMART_BALANCE;
    L93:
        String r210 = r110;
    L96:
        if ((r16 & 4) == 4) goto L98;
    L100:
        this.x.clear();
    L101:
        this.w.clear();
        this.w.addAll(r18);
        StringBuilder r34 = new StringBuilder();
        if (r29.m == false) goto L133;
        if (r23 == false) goto L129;
        r3 r35 = r29.j();
        if (s3.c(r35) == false) goto L129;
        if (r35.c != null) goto L109;
        r35.c = p3.a(r35.a);
    L109:
        r34.append(r35.c);
        r34.append(",");
        int r111 = -1;
        if (r35.d != (-1)) goto L116;
        WifiInfo r112 = r35.a;
        if (r112 == null) goto L115;
        r111 = r112.getRssi();
    L115:
        r35.d = r111;
    L116:
        int r113 = r35.d;
        if (r113 >= (-128)) goto L120;
    L121:
        r113 = 0;
    L122:
        r34.append(r113);
        r34.append(",");
        String r36 = r35.a();
        int r114 = r36.getBytes("UTF-8").length;     // Catch: Exception -> L125
    L126:
        if (r114 < 32) goto L128;
        r36 = "unkwn";
    L128:
        r34.append(r36.replace("*", "."));
    L125:
        r114 = 32;
        goto L126
    L120:
        if (r113 <= 127) goto L122;
    L129:
        if (r19 == null) goto L136;
        ArrayList<v2> r37 = this.A;
        if (r37 == null) goto L136;
        r37.clear();
        this.A.addAll(r19);
    L136:
        this.a = 0;
        if (r26 == true) goto L139;
        this.a = (short) 2;
    L139:
        this.b = r14;
        this.c = r15;
        this.d = Build.MODEL;
        this.e = "android" + Build.VERSION.RELEASE;
        this.f = j4.u(r25);
        this.g = r22;
        this.h = "0";
        this.i = "0";
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = r9;
        this.n = c4.f;
        this.o = c4.g;
        this.p = String.valueOf(r10);
        String r38 = "00:00:00:00:00:00";
        if (TextUtils.isEmpty(NameKeys.UnloadStrategy_No_Strategy) == true) goto L143;
        String r39 = NameKeys.UnloadStrategy_No_Strategy;
    L147:
        if (TextUtils.isEmpty(r39) == true) goto L150;
        r38 = r39;
    L150:
        this.q = r38;
        this.s = "6.4.8";
        this.r = NameKeys.UnloadStrategy_No_Strategy;
        this.t = r33;
        this.u = r210;
        this.v = r16;
        this.y = r28.e;
        this.B = String.valueOf(SystemClock.elapsedRealtime() - s3.z);
        this.z = r34.toString();
        this.I = (int) ((SystemClock.elapsedRealtime() - r29.r) / 1000);
        if (TextUtils.isEmpty(L) == false) goto L208;
        L = x4.q(r25);     // Catch: Throwable -> L187
    L208:
        if (TextUtils.isEmpty(M) == false) goto L204;
        M = x4.j(r25);     // Catch: Throwable -> L188
    L204:
        if (TextUtils.isEmpty(this.G) == false) goto L200;
        this.G = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L189
    L200:
        if (TextUtils.isEmpty(this.H) == false) goto L195;
        this.H = x4.p(r25);     // Catch: Throwable -> L190
    L195:
        this.J = r32.a(this.x, this.A);     // Catch: Throwable -> L180
        ArrayList<k3> r40 = this.w;     // Catch: Throwable -> L180
        ArrayList<k3> r41 = this.x;     // Catch: Throwable -> L180
        if (r41 != null) goto L166;
    L175:
        if (r40 != null) goto L177;
    L182:
        r13.delete(0, r13.length());
        r34.delete(0, r34.length());
        return;
    L177:
        if (r40.size() <= 0) goto L182;
        c((k3) ListProtector.get(r40, 0), this.K);     // Catch: Throwable -> L180
        goto L182
    L166:
        if (r41.size() <= 0) goto L175;
        Iterator<k3> r42 = r41.iterator();     // Catch: Throwable -> L180
    L169:
        if (r42.hasNext() == false) goto L175;
        k3 r43 = r42.next();     // Catch: Throwable -> L180
        if (r43.q == false) goto L169;
        if (r43.m == false) goto L169;
        c(r43, this.K);     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        th.printStackTrace();
        goto L182
    L143:
        if (r25 != null) goto L145;
        r39 = "00:00:00:00:00:00";
        goto L147
    L145:
        r39 = i4.d(r25, "pref", "smac", "00:00:00:00:00:00");
        goto L147
    L133:
        r29.j = null;
        r29.b.clear();
        ArrayList<v2> r44 = this.A;
        if (r44 == null) goto L136;
        r44.clear();
        goto L136
    L98:
        if (r8.isEmpty() == true) goto L100;
        this.x.clear();
        this.x.addAll(r8);
        goto L101
    L92:
        r110 = "1";
        goto L93
    L75:
        r33 = "HSPAP";
        goto L90
    L76:
        r33 = "EHRPD";
        goto L90
    L77:
        r33 = "LTE";
        goto L90
    L78:
        r33 = "EVDO_B";
        goto L90
    L79:
        r33 = "IDEN";
        goto L90
    L80:
        r33 = "HSPA";
        goto L90
    L81:
        r33 = "HSUPA";
        goto L90
    L82:
        r33 = "HSDPA";
        goto L90
    L83:
        r33 = "1xRTT";
        goto L90
    L84:
        r33 = "EVDO_A";
        goto L90
    L85:
        r33 = "EVDO_0";
        goto L90
    L86:
        r33 = "CDMA";
        goto L90
    L87:
        r33 = "UMTS";
        goto L90
    L88:
        r33 = "EDGE";
        goto L90
    L89:
        r33 = "GPRS";
        goto L90
    L196:
        NetworkInfo r45 = r30.getActiveNetworkInfo();     // Catch: Throwable -> L71
        if (r45 == null) goto L72;
        r24 = r45.getSubtype();     // Catch: Throwable -> L71
    L94:
        r33 = NameKeys.UnloadStrategy_No_Strategy;
        r210 = NameKeys.UnloadStrategy_No_Strategy;
    L62:
        th = move-exception;
        c4.g(th, "Aps", "getApsReq part");
        r20 = null;
        goto L64
    L38:
        if (TextUtils.isEmpty(c4.f) == false) goto L44;
        c4.f = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        c4.g(th, "Aps", "getApsReq part4");
    L44:
        if (TextUtils.isEmpty(c4.f) == false) goto L49;
        if (Build.VERSION.SDK_INT >= 29) goto L49;
        c4.f = "888888888888888";
    L49:
        if (TextUtils.isEmpty(c4.g) == false) goto L56;
        c4.g = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L52 SecurityException -> L54
    L52:
        th = move-exception;
        c4.g(th, "Aps", "getApsReq part2");
    L56:
        if (TextUtils.isEmpty(c4.g) == false) goto L193;
        if (Build.VERSION.SDK_INT >= 29) goto L193;
        c4.g = "888888888888888";
        goto L193
    L35:
        r22 = "0";
    L184:
        th = move-exception;
        throw th;
    L20:
        r4 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r11 = 0;
        goto L13
    L8:
        r1 = 0;
        goto L10
    }
}
