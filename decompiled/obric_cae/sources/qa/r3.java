package qa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class r3 {
    public static String L;
    public static String M;
    public final ArrayList<n2> A;
    public String B;
    public byte[] C;
    public byte[] D;
    public int E;
    public String F;
    public String G;
    public String H;
    public int I;
    public ArrayList J;
    public final List<b3> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f10977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f10991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f10992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f10994r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f10995s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f10996t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f10997u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10998v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<b3> f10999w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList<b3> f11000x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f11001y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f11002z;

    public r3() {
        this.f10977a = 0;
        this.f10978b = null;
        this.f10979c = null;
        this.f10980d = null;
        this.f10981e = null;
        this.f10982f = null;
        this.f10983g = null;
        this.f10984h = null;
        this.f10985i = null;
        this.f10986j = null;
        this.f10987k = null;
        this.f10988l = null;
        this.f10989m = null;
        this.f10990n = null;
        this.f10991o = null;
        this.f10992p = null;
        this.f10993q = null;
        this.f10994r = null;
        this.f10995s = null;
        this.f10996t = null;
        this.f10997u = null;
        this.f10998v = 0;
        this.f10999w = new ArrayList();
        this.f11000x = new ArrayList();
        this.f11001y = null;
        this.f11002z = null;
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

    public static int a(String r8, byte[] r10, int r11) {
    L11:
        th = move-exception;
        t3.g("Req", "copyContentWithByteLen", th);
        r10[r11] = 0;
    L14:
        return r11 + 1;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L6;
        r10[r11] = 0;     // Catch: Throwable -> L11
        goto L14
    L6:
        byte[] r12 = r8.getBytes("GBK");     // Catch: Throwable -> L11
        int r13 = r12.length;     // Catch: Throwable -> L11
        if (r13 <= 127) goto L9;
        r13 = 127;
    L9:
        r10[r11] = (byte) r13;     // Catch: Throwable -> L11
        int r14 = r11 + 1;     // Catch: Throwable -> L11
        System.arraycopy(r12, 0, r10, r14, r13);     // Catch: Throwable -> L11
        return r14 + r13;
    }

    public static void c(b3 r10, List<b3> r11) {
        if (r10 == null) goto L37;
        if (r11 == null) goto L41;
        int r8 = r11.size();
        if (r8 != 0) goto L9;
        r11.add(r10);
        return;
    L9:
        int r12 = -1;
        long r13 = Long.MAX_VALUE;
        int r14 = 0;
        int r15 = -1;
    L10:
        if (r14 >= r8) goto L22;
        b3 r16 = r11.get(r14);
        if (r10.b() != null) goto L14;
    L18:
        r13 = Math.min(r13, r16.f10248s);
        if (r13 != r16.f10248s) goto L21;
        r15 = r14;
    L21:
        r14 = r14 + 1;
        goto L10
    L14:
        if (r10.b().equals(r16.b()) == false) goto L18;
        int r17 = r10.f10247r;
        if (r17 == r16.f10247r) goto L23;
        r16.f10248s = r10.f10248s;
        r16.f10247r = r17;
    L23:
        if (r12 >= 0) goto L25;
        return;
    L25:
        if (r8 >= 3) goto L29;
        r11.add(r10);
        return;
    L29:
        if (r10.f10248s <= r13) goto L39;
        if (r12 >= r8) goto L40;
        r11.remove(r12);
        r11.add(r10);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        r12 = r15;
        goto L23
    L41:
        return;
    }

    public static byte[] d(String r8) {
        String[] r10 = r8.split(BdimCategoryConstants.SEPARATOR_COLON);
        byte[] r11 = new byte[6];
        if (r10 != null) goto L20;
    L6:
        r10 = new String[6];     // Catch: Throwable -> L17
        int r12 = 0;
    L7:
        if (r12 >= 6) goto L9;
        r10[r12] = "0";     // Catch: Throwable -> L17
        r12 = r12 + 1;     // Catch: Throwable -> L17
    L9:
        int r13 = 0;
    L10:
        if (r13 >= r10.length) goto L24;
        if (r10[r13].length() <= 2) goto L15;
        r10[r13] = r10[r13].substring(0, 2);     // Catch: Throwable -> L17
    L15:
        r11[r13] = (byte) Integer.parseInt(r10[r13], 16);     // Catch: Throwable -> L17
        r13 = r13 + 1;
        goto L10
    L24:
        return r11;
    L17:
        th = move-exception;
        t3.g("Req", "getMacBa ".concat(r8), th);
        return d("00:00:00:00:00:00");
    L20:
        if (r10.length == 6) goto L9;
        goto L6
    }

    public final void b(Context r26, boolean r27, boolean r28, c3 r29, g3 r30, ConnectivityManager r31, String r32, e3 r33) {
        String r10 = h4.g(r26);
        int r11 = new Random().nextInt(65536) - 32768;
        this.F = r32;
        this.J = null;
        String r14 = "api_serverSDK_130905";
        String r15 = "S128DF1572465B890OE3F7A13167KLEI";
        if (r28 == true) goto L5;
        r14 = "UC_nlp_20131029";
        r15 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L5:
        StringBuilder r13 = new StringBuilder();
        b3 r8 = r29.l();
        if (r8 == null) goto L8;
        int r12 = r8.f10241l;
    L10:
        if (r29.f10266b == false) goto L12;
        int r16 = 4;
    L13:
        int r17 = r12 | r16;
        if (r29.f10267c == false) goto L16;
        int r18 = 8;
    L17:
        int r19 = r18 | r17;
        b3 r20 = r29.l();
        if (r20 == null) goto L20;
        int r21 = r20.f10241l;
    L21:
        int r22 = r21 & 3;
        TelephonyManager r110 = r29.f10271g;
        monitor-enter(r29);
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L196
        ArrayList<b3> r23 = r29.f10268d;     // Catch: Throwable -> L196
        if (r23 == null) goto L31;
        Iterator<b3> r24 = r23.iterator();     // Catch: Throwable -> L196
    L28:
        if (r24.hasNext() == false) goto L31;
        Iterator<b3> r25 = r24;
        r111.add(r24.next().c());     // Catch: Throwable -> L196
        r24 = r25;
    L31:
        monitor-exit(r29);
        monitor-enter(r29);
        ArrayList r34 = new ArrayList();     // Catch: Throwable -> L193
        ArrayList<b3> r112 = r29.f10270f;     // Catch: Throwable -> L193
        if (r112 == null) goto L40;
        Iterator<b3> r113 = r112.iterator();     // Catch: Throwable -> L193
    L37:
        if (r113.hasNext() == false) goto L40;
        Iterator<b3> r210 = r113;
        r34.add(r113.next().c());     // Catch: Throwable -> L193
        r113 = r210;
    L40:
        monitor-exit(r29);
        ArrayList<n2> r114 = r30.g();
        if (r22 != 2) goto L44;
        String r211 = "1";
    L45:
        if (r110 != null) goto L47;
    L207:
        NetworkInfo r35 = r31.getActiveNetworkInfo();     // Catch: Throwable -> L61
    L63:
        boolean r36 = r30.b(r31);
        if (y3.c(r35) == (-1)) goto L92;
        if (r31 != null) goto L209;
    L70:
        int r37 = 0;
    L71:
        switch(r37) {
            case 1: goto L87;
            case 2: goto L86;
            case 3: goto L85;
            case 4: goto L84;
            case 5: goto L83;
            case 6: goto L82;
            case 7: goto L81;
            case 8: goto L80;
            case 9: goto L79;
            case 10: goto L78;
            case 11: goto L77;
            case 12: goto L76;
            case 13: goto L75;
            case 14: goto L74;
            case 15: goto L73;
            default: goto L72;
        };
    L72:
        String r38 = "UNKWN";
    L88:
        if (r36 == false) goto L90;
        String r115 = AwareStateListener.USER_INFO_FILE_REMOTE_MODE;
    L91:
        String r212 = r115;
    L94:
        if ((r19 & 4) == 4) goto L96;
    L98:
        this.f11000x.clear();
    L99:
        this.f10999w.clear();
        this.f10999w.addAll(r111);
        StringBuilder r39 = new StringBuilder();
        if (r30.f10467m == false) goto L142;
        if (r36 == false) goto L138;
        f3 r40 = r30.h();
        if (g3.c(r40) == false) goto L138;
        if (r40.f10413c != null) goto L111;
        WifiInfo r116 = r40.f10411a;
        if (r116 != null) goto L109;
        String r117 = null;
    L110:
        r40.f10413c = r117;
        goto L111
    L109:
        r117 = r116.getBSSID();
    L111:
        r39.append(r40.f10413c);
        r39.append(",");
        int r118 = -1;
        if (r40.f10414d != (-1)) goto L118;
        WifiInfo r119 = r40.f10411a;
        if (r119 == null) goto L117;
        r118 = r119.getRssi();
    L117:
        r40.f10414d = r118;
    L118:
        int r120 = r40.f10414d;
        if (r120 >= (-128)) goto L122;
    L123:
        r120 = 0;
    L124:
        r39.append(r120);
        r39.append(",");
        if (r40.f10412b != null) goto L131;
        WifiInfo r121 = r40.f10411a;
        if (r121 != null) goto L129;
        String r122 = null;
    L130:
        r40.f10412b = r122;
        goto L131
    L129:
        r122 = r121.getSSID();
    L131:
        String r41 = r40.f10412b;
        int r123 = r41.getBytes("UTF-8").length;     // Catch: Exception -> L134
    L135:
        if (r123 < 32) goto L137;
        r41 = "unkwn";
    L137:
        r39.append(r41.replace("*", "."));
    L134:
        r123 = 32;
        goto L135
    L122:
        if (r120 <= 127) goto L124;
    L138:
        if (r114 == null) goto L145;
        ArrayList<n2> r42 = this.A;
        if (r42 == null) goto L145;
        r42.clear();
        this.A.addAll(r114);
    L145:
        this.f10977a = 0;
        if (r27 == true) goto L148;
        this.f10977a = (short) 2;
    L148:
        this.f10978b = r14;
        this.f10979c = r15;
        this.f10980d = Build.MODEL;
        this.f10981e = "android" + Build.VERSION.RELEASE;
        this.f10982f = y3.s(r26);
        this.f10983g = r211;
        this.f10984h = "0";
        this.f10985i = "0";
        this.f10986j = "0";
        this.f10987k = "0";
        this.f10988l = "0";
        this.f10989m = r10;
        this.f10990n = t3.f11119f;
        this.f10991o = t3.f11120g;
        this.f10992p = String.valueOf(r11);
        String r43 = "00:00:00:00:00:00";
        if (TextUtils.isEmpty("") == true) goto L152;
        String r44 = "";
    L156:
        if (TextUtils.isEmpty(r44) == true) goto L159;
        r43 = r44;
    L159:
        this.f10993q = r43;
        this.f10995s = "6.4.8";
        this.f10994r = "";
        this.f10996t = r38;
        this.f10997u = r212;
        this.f10998v = r19;
        this.f11001y = r29.f10269e;
        this.B = String.valueOf(SystemClock.elapsedRealtime() - g3.f10454z);
        this.f11002z = r39.toString();
        this.I = (int) ((SystemClock.elapsedRealtime() - r30.f10472r) / 1000);
        if (TextUtils.isEmpty(L) == false) goto L217;
        L = k4.m(r26);     // Catch: Throwable -> L200
    L217:
        if (TextUtils.isEmpty(M) == false) goto L224;
        M = k4.h(r26);     // Catch: Throwable -> L201
    L224:
        if (TextUtils.isEmpty(this.G) == false) goto L213;
        this.G = "";     // Catch: Throwable -> L202
    L213:
        if (TextUtils.isEmpty(this.H) == false) goto L219;
        this.H = k4.l(r26);     // Catch: Throwable -> L203
    L219:
        this.J = r33.a(this.f11000x, this.A);     // Catch: Throwable -> L189
        ArrayList<b3> r45 = this.f10999w;     // Catch: Throwable -> L189
        ArrayList<b3> r46 = this.f11000x;     // Catch: Throwable -> L189
        List<b3> r47 = this.K;     // Catch: Throwable -> L189
        if (r46 != null) goto L175;
    L184:
        if (r45 != null) goto L186;
    L191:
        r13.delete(0, r13.length());
        r39.delete(0, r39.length());
        return;
    L186:
        if (r45.size() <= 0) goto L191;
        c(r45.get(0), r47);     // Catch: Throwable -> L189
        goto L191
    L175:
        if (r46.size() <= 0) goto L184;
        Iterator<b3> r48 = r46.iterator();     // Catch: Throwable -> L189
    L178:
        if (r48.hasNext() == false) goto L184;
        b3 r49 = r48.next();     // Catch: Throwable -> L189
        if (r49.f10246q == false) goto L178;
        if (r49.f10242m == false) goto L178;
        c(r49, r47);     // Catch: Throwable -> L189
    L189:
        th = move-exception;
        th.printStackTrace();
        goto L191
    L152:
        if (r26 != null) goto L154;
        r44 = "00:00:00:00:00:00";
        goto L156
    L154:
        r44 = x3.d(r26, "pref", "smac", "00:00:00:00:00:00");
        goto L156
    L142:
        r30.f10464j = null;
        r30.f10456b.clear();
        ArrayList<n2> r50 = this.A;
        if (r50 == null) goto L145;
        r50.clear();
        goto L145
    L96:
        if (r34.isEmpty() == true) goto L98;
        this.f11000x.clear();
        this.f11000x.addAll(r34);
        goto L99
    L90:
        r115 = "1";
        goto L91
    L73:
        r38 = "HSPAP";
        goto L88
    L74:
        r38 = "EHRPD";
        goto L88
    L75:
        r38 = "LTE";
        goto L88
    L76:
        r38 = "EVDO_B";
        goto L88
    L77:
        r38 = "IDEN";
        goto L88
    L78:
        r38 = "HSPA";
        goto L88
    L79:
        r38 = "HSUPA";
        goto L88
    L80:
        r38 = "HSDPA";
        goto L88
    L81:
        r38 = "1xRTT";
        goto L88
    L82:
        r38 = "EVDO_A";
        goto L88
    L83:
        r38 = "EVDO_0";
        goto L88
    L84:
        r38 = "CDMA";
        goto L88
    L85:
        r38 = "UMTS";
        goto L88
    L86:
        r38 = "EDGE";
        goto L88
    L87:
        r38 = "GPRS";
        goto L88
    L209:
        NetworkInfo r51 = r31.getActiveNetworkInfo();     // Catch: Throwable -> L204
        if (r51 == null) goto L70;
        r37 = r51.getSubtype();     // Catch: Throwable -> L204
    L92:
        r38 = "";
        r212 = "";
    L61:
        th = move-exception;
        t3.g("Aps", "getApsReq part", th);
        r35 = null;
        goto L63
    L47:
        if (TextUtils.isEmpty(t3.f11119f) == true) goto L220;
    L52:
        TextUtils.isEmpty(t3.f11119f);
        if (TextUtils.isEmpty(t3.f11120g) == true) goto L226;
    L58:
        TextUtils.isEmpty(t3.f11120g);
        goto L207
    L226:
        t3.f11120g = "";     // Catch: Throwable -> L56 SecurityException -> L199
    L56:
        th = move-exception;
        t3.g("Aps", "getApsReq part2", th);
        goto L58
    L220:
        t3.f11119f = "";     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        t3.g("Aps", "getApsReq part4", th);
        goto L52
    L44:
        r211 = "0";
    L193:
        th = move-exception;
        throw th;
    L196:
        th = move-exception;
        throw th;
    L20:
        r21 = 0;
        goto L21
    L16:
        r18 = 0;
        goto L17
    L12:
        r16 = 0;
        goto L13
    L8:
        r12 = 0;
        goto L10
    }

    public final void e() {
        String[] r8 = {"1", this.f10978b, this.f10979c, null, this.f10980d, this.f10981e, this.f10982f, this.f10983g, this.f10986j, this.f10987k, this.f10988l, this.f10989m, this.f10990n, this.f10991o, null, this.f10992p, this.f10993q, this.f10994r, this.f10995s, null, this.f10996t, this.f11002z, this.B, null, L, this.G, this.H};
        int r10 = 0;
    L4:
        if (r10 >= 27) goto L10;
        if (TextUtils.isEmpty(r8[r10]) == false) goto L8;
        r8[r10] = "";
    L8:
        r10 = r10 + 1;
        goto L4
    L10:
        if (TextUtils.isEmpty(this.f10984h) == false) goto L13;
    L16:
        this.f10984h = "0";
    L18:
        if (TextUtils.isEmpty(this.f10985i) == false) goto L21;
    L24:
        this.f10985i = "0";
    L26:
        if (TextUtils.isEmpty(this.f10997u) == false) goto L29;
    L32:
        this.f10997u = "0";
    L33:
        int r11 = this.f10998v;
        if (r11 > 0) goto L36;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == true) goto L43;
        this.f10998v = 0;
    L43:
        if (this.C != null) goto L49;
        this.C = new byte[0];
        return;
    L49:
        return;
    L36:
        if (r11 > 15) goto L39;
        r12 = true;
        goto L40
    L29:
        if ("1".equals(this.f10997u) == true) goto L33;
        if (AwareStateListener.USER_INFO_FILE_REMOTE_MODE.equals(this.f10997u) == true) goto L33;
    L21:
        if ("0".equals(this.f10985i) == true) goto L26;
        if ("1".equals(this.f10985i) == true) goto L26;
    L13:
        if ("0".equals(this.f10984h) == true) goto L18;
        if (AwareStateListener.USER_INFO_FILE_REMOTE_MODE.equals(this.f10984h) == true) goto L18;
        goto L16
    }
}
