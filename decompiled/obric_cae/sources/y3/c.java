package y3;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import c4.l;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.util.BlockHelper;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.m;
import r3.n;
import x4.j0;
import x4.k;
import x4.s;
import x4.t;
import x4.v;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback, Comparator<r4.a> {
    public static final List<String> G = null;
    public static volatile long H;
    public volatile z3.b A;
    public final u3.a B;
    public volatile int C;
    public final v3.b D;
    public final t3.a E;
    public final d4.a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u3.g f13935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Looper f13936b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r3.c f13937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d4.c f13938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y3.b f13939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<r4.a> f13940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile r4.b f13941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d4.d f13942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile Handler f13943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f13944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f13945u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n f13946v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f13947w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f13948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<y3.a> f13949y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile long f13950z;

    public class a implements u3.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13951a;

        public a(c r8) {
            this.f13951a = r8;
        }
    }

    public class b implements c4.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13952a;

        public b(c r8) {
            this.f13952a = r8;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            c r8 = this.f13952a;
            JSONObject r10 = new JSONObject();
            r10.put("appId", r8.f13937m.f11401i);     // Catch: Throwable -> L5
            r10.put("isMainProcess", r8.f13938n.d());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    /* JADX INFO: renamed from: y3.c$c, reason: collision with other inner class name */
    public static class C0197c {
        public C0197c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<r4.i> f13953a;

        public d() {
            this.f13953a = new ArrayList();
            new ArrayList();
        }
    }

    static {
        G = Collections.singletonList("Engine");
        H = 10000;
    }

    public c(r3.c r10, d4.c r11, d4.d r12, u3.e r13, d4.a r14, t3.a r15) {
        this.f13940p = new ArrayList(32);
        this.f13949y = new ArrayList(4);
        int r8 = 0;
        this.C = 0;
        this.f13937m = r10;
        this.f13938n = r11;
        r11.f6769m = this;
        this.f13942r = r12;
        this.F = r14;
        this.f13945u = new j(this);
        this.f13935a = r13;
        this.B = new u3.a(r10);
        this.E = r15;
        String r16 = r10.f11401i;
        HandlerThread r17 = new HandlerThread(defpackage.b.c("bd_tracker_w:", r16));
        r17.start();
        this.f13947w = new Handler(r17.getLooper(), this);
        HandlerThread r18 = new HandlerThread(defpackage.b.c("bd_tracker_n:", r16));
        r18.start();
        Looper r19 = r18.getLooper();
        this.f13936b = r19;
        s r110 = d().f11443e;
        r13.getClass();
        m r111 = r11.f6758b;
        r13.f12438c = new u3.f(r13.f12439d, r13.b());
        if (r13.f12441f.isEmpty() == true) goto L38;
        u3.f r112 = r13.f12438c;
        ConcurrentHashMap<String, Object> r20 = r13.f12441f;
        List<String> r21 = u3.f.f12450e;
        r3.c r22 = r112.f12451a;
        if (r20 != null) goto L7;
    L37:
        r13.f12441f.clear();
        goto L38
    L7:
        if (r20.isEmpty() == true) goto L37;
        JSONObject r23 = r112.a();     // Catch: Throwable -> L35
        if (r23 == null) goto L20;
        Iterator<Map.Entry<String, Object>> r24 = r20.entrySet().iterator();     // Catch: Throwable -> L35
    L14:
        if (r24.hasNext() == false) goto L21;
        Map.Entry<String, Object> r25 = r24.next();     // Catch: Throwable -> L35
        if (v4.i.g(r25.getKey()) == true) goto L14;
        if ((!Objects.equals(r23.opt(r25.getKey()), r25.getValue())) == false) goto L14;
    L21:
        boolean r26 = false;
    L22:
        if (r26 == true) goto L24;
        r22.H.l(0, r21, "appendHeaderInfo no value changed", new Object[0]);     // Catch: Throwable -> L35
        goto L37
    L24:
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L35
        if (r23 == null) goto L27;
        v4.i.d(r27, r23);     // Catch: Throwable -> L35
    L27:
        Iterator<Map.Entry<String, Object>> r28 = r20.entrySet().iterator();     // Catch: Throwable -> L35
    L29:
        if (r28.hasNext() == false) goto L33;
        Map.Entry<String, Object> r29 = r28.next();     // Catch: Throwable -> L35
        if (v4.i.h(r29.getKey()) == false) goto L29;
        r27.put(r29.getKey(), r29.getValue());     // Catch: Throwable -> L35
        goto L29
    L33:
        r112.c(r27);     // Catch: Throwable -> L35
    L20:
        r26 = true;
    L35:
        th = move-exception;
        r22.H.i(r21, "appendHeaderInfo failed", th, new Object[0]);
    L38:
        Handler r113 = new Handler(r19);
        n4.b r30 = new n4.b(r8);
        r30.f9430a = new u3.b(r113);
        r30.f9432c = r19;
        v r114 = r13.b();
        String r115 = r111.f11425a;
        ((x4.j) r114).getClass();
        ConcurrentHashMap r116 = t.f13549a;
        Executor r117 = (Executor) r30.f9430a;
        if (r117 == null) goto L41;
        t.f13549a.put(r115, r117);
    L41:
        ExecutorService r118 = (ExecutorService) r30.f9431b;
        if (r118 == null) goto L44;
        t.f13550b.put(r115, r118);
    L44:
        Looper r119 = (Looper) r30.f9432c;
        if (r119 == null) goto L47;
        t.f13551c.put(r115, r119);
    L47:
        u3.c r120 = new u3.c(r13);
        r13.f12439d.i();
        k r121 = r13.f12436a;
        r121.f13498j = r13.f12439d.f11402j;
        r121.f13513y = null;
        r121.f13492d = r111.f11435k;
        r121.f13496h = Integer.parseInt(r111.f11425a);
        r121.f13489a = false;
        r121.f13510v = null;
        r121.f13511w = null;
        r121.f13506r = r111.f11429e;
        r121.f13490b = r120;
        r121.f13507s = r111.f11427c;
        r121.f13508t = null;
        r121.f13493e = false;
        r121.B = false;
        r121.A = null;
        r121.f13514z = false;
        r121.f13495g = r13.f12439d.f11409q;
        r121.f13512x = null;
        r121.f13497i = new u3.a(r13.f12439d);
        r121.f13505q = r111.f11433i;
        r121.f13503o = r111.f11431g;
        r121.f13501m = null;
        r121.f13504p = r111.f11432h;
        r121.f13502n = null;
        r121.f13509u = null;
        r121.f13491c = false;
        r121.f13499k = r111.f11437m;
        r121.f13500l = null;
        x0.f13580b = Boolean.valueOf(r11.d());
        r121.f13494f = r13.f12438c;
        r121.E = false;
        r121.getClass();
        r121.G = false;
        r121.D = true;
        r121.H = null;
        r121.F = true;
        monitor-enter(u3.e.class);
        j0 r122 = r13.f12436a.a();     // Catch: Throwable -> L74
        ((x4.j) r13.b()).d(r122, r110);     // Catch: Throwable -> L74
        r13.f12436a = null;     // Catch: Throwable -> L74
        r13.f12437b = r122;     // Catch: Throwable -> L74
        monitor-exit(u3.e.class);     // Catch: Throwable -> L74
        this.D = new v3.b(this.f13937m, this.f13936b);
        if (this.f13937m.d() <= 0) goto L70;
        String r123 = r3.b.b(this.f13937m, "sampling_list");
        Application r124 = this.f13937m.f11402j;
        o4.c r125 = new o4.c();
        if (TextUtils.isEmpty(r123) == false) goto L56;
        r123 = "sampling_list";
    L56:
        SharedPreferences r126 = r124.getSharedPreferences(r123, 0);
        r125.f9651a = r126.getInt("version", 0);
        r125.f9652b = r126.getInt(QesdkUtils.TAGS.JSON_TAG_CAPABILITY, 0);
        String r127 = r126.getString("config_ids", null);
        if (TextUtils.isEmpty(r127) == false) goto L77;
    L62:
        String r128 = r126.getString("samplings", null);
        if (TextUtils.isEmpty(r128) == false) goto L80;
    L68:
        this.A = new z3.b(this, r125);
        goto L70
    L80:
        o4.d.a(r125, new JSONArray(r128));     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        c4.m.u().k(th, 12, "parseEventSamplingFromLocal sampling config", new Object[0]);
        goto L68
    L77:
        r125.f9654d = new JSONArray(r127);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        c4.m.u().k(th, 12, "parseEventSamplingFromLocal config ids error", new Object[0]);
    L70:
        if (this.f13938n.f6758b.f11426b == false) goto L72;
        this.f13947w.sendEmptyMessage(1);
        this.f13947w.sendEmptyMessageDelayed(2, 200);
    L72:
        this.f13947w.sendEmptyMessage(25);
        this.f13947w.sendEmptyMessage(10);
        this.f13938n.f6758b.getClass();
        this.f13937m.getClass();
        return;
    L74:
        th = move-exception;
        throw th;
    }

    public final void a(ArrayList<r4.a> r10, z3.a r11, i4.a r12) {
        if (r11.a() == false) goto L5;
        return;
    L5:
        Iterator<r4.a> r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        r4.a r8 = r13.next();
        if ((r8 instanceof r4.e) == true) goto L10;
        if ((r8 instanceof r4.c) == true) goto L13;
        if ((r8 instanceof r4.d) == false) goto L7;
        e4.a r14 = e4.a.f7117m;
        String r15 = ((r4.d) r8).H;
        String r16 = "log_data";
    L14:
        String r17 = r15;
        e4.a r18 = r14;
        String r19 = r16;
    L18:
        f(r8, r13, r11, r18, r12, r19, r17);
        goto L7
    L13:
        r4.c r20 = (r4.c) r8;
        r14 = e4.a.f7115a;
        r16 = r20.I;
        r15 = r20.K;
        goto L14
    L10:
        r4.e r21 = (r4.e) r8;
        String r22 = r21.J;
        String r23 = r21.H;
        r17 = r23;
        r19 = r22;
        r18 = e4.a.f7116b;
        goto L18
    }

    public final r4.b b() {
        if (this.f13941q != null) goto L15;
        monitor-enter(this);
        r4.b r8 = this.f13941q;     // Catch: Throwable -> L11
        if (r8 != null) goto L8;
        r8 = new r4.b(this, this.f13938n.f6758b.a());     // Catch: Throwable -> L11
    L8:
        this.f13941q = r8;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.f13941q;
    }

    public final ArrayList c() {
        ArrayList r8 = new ArrayList();
        this.f13938n.getClass();
        r8.add(new i(this));
        this.f13938n.getClass();
        return r8;
    }

    @Override // java.util.Comparator
    public final int compare(r4.a r8, r4.a r10) {
        long r11 = r8.f11450b - r10.f11450b;
        if (r11 >= 0) goto L5;
        return -1;
    L5:
        if (r11 <= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    public final n d() {
        if (this.f13946v != null) goto L8;
        n r8 = this.f13938n.f6758b.f11430f;
        this.f13946v = r8;
        if (r8 != null) goto L8;
        this.f13946v = v4.h.f12729a;
    L8:
        return this.f13946v;
    }

    public final void e(boolean r22, String[] r23) {
        ArrayList<r4.a> r8 = this.f13940p;
        monitor-enter(r8);
        ArrayList<r4.a> r10 = (ArrayList) this.f13940p.clone();     // Catch: Throwable -> L390
        this.f13940p.clear();     // Catch: Throwable -> L390
        monitor-exit(r8);     // Catch: Throwable -> L390
        Iterator<r4.a> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        r4.a r12 = r11.next();
        if (r12.C <= 0) goto L8;
        l6.a.P0(this.f13937m.f11417y, i4.a.f8144t, r12);
        goto L8
    L12:
        boolean r13 = false;
        if (r23 == null) goto L44;
        r10.ensureCapacity(r10.size() + r23.length);
        int r14 = r23.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L44;
        String r16 = r23[r15];
        SimpleDateFormat r17 = r4.a.F;
        JSONObject r18 = new JSONObject(r16);     // Catch: Throwable -> L22
        r4.a r19 = (r4.a) ((HashMap) r4.a.G.b(new Object[0])).get(r18.optString("k_cls", ""));     // Catch: Throwable -> L22
        if (r19 != null) goto L20;
        c4.m.u().n(4, "from ipc class not recognized", new Object[0]);     // Catch: Throwable -> L22
    L24:
        r4.a r20 = null;
    L25:
        if (r20 == null) goto L43;
        if (v4.i.h(r20.f11461w) == false) goto L40;
        String r21 = this.f13937m.f11401i;
        String r24 = r20.f11461w;
        if (TextUtils.isEmpty(r21) == true) goto L32;
    L33:
        if (r21 != null) goto L35;
    L37:
        boolean r25 = false;
    L38:
        if (r25 == true) goto L40;
    L35:
        if (r21.equals(r24) == false) goto L37;
    L36:
        r25 = true;
        goto L38
    L32:
        if (TextUtils.isEmpty(r24) == true) goto L36;
    L40:
        r10.add(r20);
        if (r20.C <= 0) goto L43;
        l6.a.P0(this.f13937m.f11417y, i4.a.f8144t, r20);
    L43:
        r15 = r15 + 1;
        goto L15
    L20:
        r20 = r19.a().k(r18);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        c4.m.u().k(th, 4, "from ipc failed", new Object[0]);
    L44:
        r3.c r26 = this.f13937m;
        if (r26.f11394b.a(2) == true) goto L63;
        Iterator<r4.a> r27 = r10.iterator();
    L49:
        if (r27.hasNext() == false) goto L63;
        r4.a r28 = r27.next();
        if ((r28 instanceof r4.c) == true) goto L53;
        if ((r28 instanceof r4.e) == true) goto L56;
        if ((r28 instanceof r4.d) == false) goto L49;
        r4.d r29 = (r4.d) r28;     // Catch: Throwable -> L61
        r26.f11394b.d(2, r29.I, r29.H);     // Catch: Throwable -> L61
        goto L49
    L56:
        r4.e r30 = (r4.e) r28;     // Catch: Throwable -> L61
        r26.f11394b.c(2, r30.J, r30.H);     // Catch: Throwable -> L61
        goto L49
    L53:
        r4.c r31 = (r4.c) r28;     // Catch: Throwable -> L61
        r26.f11394b.b(2, r31.L, r31.M, r31.H, r31.I, r31.J, r31.K);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        r26.H.k(th, 4, "notify event observer before process failed", new Object[0]);
        r26.f11417y.g("notify event observer before process failed", th);
    L63:
        this.f13937m.getClass();
        if (r10.isEmpty() == true) goto L97;
        a(r10, this.B, i4.a.f8146v);
        this.f13937m.getClass();
        this.f13938n.f6758b.getClass();
        if (this.A != null) goto L69;
    L71:
        d4.c r32 = this.f13938n;
        r32.getClass();
        if (r10.size() == 0) goto L97;
        HashSet<String> r33 = r32.f6763g;
        int r34 = r33.size();
        HashSet<String> r35 = r32.f6764h;
        if (r34 == 0) goto L77;
    L79:
        Iterator<r4.a> r36 = r10.iterator();
    L81:
        if (r36.hasNext() == false) goto L97;
        r4.a r37 = r36.next();
        boolean r38 = r37 instanceof r4.c;
        r3.c r39 = r32.f6768l;
        if (r38 == true) goto L84;
        if ((r37 instanceof r4.e) == false) goto L81;
        if (r35.contains(((r4.e) r37).J) == false) goto L81;
        l6.a.P0(r39.f11417y, i4.a.f8145u, r37);
        r36.remove();
    L96:
        r39.f11417y.b(i4.k.f8248a0, 1);
        r39.f11417y.b(i4.k.f8271w, 1);
        f4.b[] r40 = f4.b.f7323a;
        r37.g();
        goto L81
    L84:
        r4.c r41 = (r4.c) r37;
        StringBuilder r110 = new StringBuilder();
        r110.append(r41.I);
        if (TextUtils.isEmpty(r41.J) == true) goto L87;
        String r42 = r41.J;
    L88:
        r110.append(r42);
        if (r33.contains(r110.toString()) == false) goto L81;
        r36.remove();
        l6.a.P0(r39.f11417y, i4.a.f8145u, r37);
        goto L96
    L87:
        r42 = "";
        goto L88
    L77:
        if (r35.size() != 0) goto L79;
    L69:
        if (this.f13937m.d() <= 0) goto L71;
        a(r10, this.A, i4.a.f8147w);
    L97:
        this.f13937m.getClass();
        Iterator<r4.a> r43 = r10.iterator();
    L99:
        if (r43.hasNext() == false) goto L104;
        r4.a r44 = r43.next();
        if (r44.C <= 0) goto L99;
        l6.a.P0(this.f13937m.f11417y, i4.a.f8148x, r44);
        goto L99
    L104:
        if (r10.isEmpty() == false) goto L106;
    L373:
        boolean r45 = true;
    L374:
        if (r22 == true) goto L376;
        return;
    L376:
        if (this.f13938n.d() == true) goto L378;
        return;
    L378:
        if (this.f13938n.f6772p == false) goto L501;
        long r46 = System.currentTimeMillis();
        if (this.f13937m.F == true) goto L382;
    L385:
        if (r45 == false) goto L387;
        this.f13950z = r46;
        g(4, this.f13944t);
        this.f13937m.H.g(0, G, "flush work...", new Object[0]);
    L388:
        this.f13937m.getClass();
        return;
    L387:
        this.f13937m.H.f(0, G, "flush disallowed by threshold:{} limit!", new Object[]{Long.valueOf(H)});
        goto L388
    L382:
        if (Math.abs(r46 - this.f13950z) >= H) goto L385;
        r45 = false;
        goto L385
    L501:
        return;
    L106:
        if (this.f13938n.d() == false) goto L364;
        Iterator<r4.a> r47 = r10.iterator();
    L109:
        if (r47.hasNext() == false) goto L113;
        r4.a r48 = r47.next();
        if (r48.C <= 0) goto L109;
        l6.a.P0(this.f13937m.f11417y, i4.a.f8149y, r48);
        goto L109
    L113:
        Collections.sort(r10, this);
        ArrayList<r4.a> r49 = new ArrayList(r10.size());
        this.f13938n.getClass();
        Iterator<r4.a> r50 = r10.iterator();
        boolean r51 = false;
        boolean r52 = false;
        boolean r53 = false;
        boolean r54 = false;
    L115:
        if (r50.hasNext() == false) goto L233;
        r4.a r55 = r50.next();
        j r111 = this.f13945u;
        r111.getClass();
        boolean r112 = r55 instanceof r4.j;
        if (r112 == false) goto L121;
        Iterator<r4.a> r113 = r50;
        if (((r4.j) r55).H != (-1)) goto L123;
        r52 = true;
    L123:
        if (r111.f13981g != (-1)) goto L132;
        r111.f13976b.f13937m.H.l(0, j.f13970n, "session process start session 1, data={}, isResume=" + r52, new Object[]{r55});
        if (r112 == true) goto L127;
    L129:
        boolean r56 = false;
    L130:
        r52 = r56;
        boolean r114 = r53;
        boolean r210 = r54;
        String r115 = "terminate";
        String r116 = "launch";
    L144:
        r111.d(r55, r49, r52);
    L145:
        boolean r57 = true;
    L147:
        if (r112 == false) goto L178;
        r4.j r58 = (r4.j) r55;
        if (r58.H != (-1)) goto L151;
        boolean r59 = true;
    L152:
        if (r59 == false) goto L165;
        r111.f13983i = 0;
        r49.add(r55);
        if (TextUtils.isEmpty(r58.I) == false) goto L180;
        r4.j r60 = r111.f13978d;
        if (r60 != null) goto L158;
    L160:
        r60 = r111.f13977c;
        if (r60 == null) goto L180;
        if (((r58.f11450b - r60.f11450b) - r60.H) >= 500) goto L180;
    L164:
        r58.I = r60.J;
        goto L180
    L158:
        if (((r58.f11450b - r60.f11450b) - r60.H) >= 500) goto L160;
    L180:
        r111.a(r55);
        if (r112 == true) goto L183;
    L185:
        boolean r61 = false;
    L186:
        if (r57 == false) goto L189;
        if (r61 == false) goto L189;
        r54 = true;
    L190:
        if (r112 == false) goto L196;
        r3.c r62 = this.f13937m;
        if (r62.e() == null) goto L194;
        r62.e().getClass();
    L194:
        this.f13937m.getClass();
        r51 = true;
        r53 = r61;
    L208:
        if (r55.C <= 0) goto L232;
        i4.f r63 = this.f13937m.f11417y;
        if (r63.f() == true) goto L213;
    L229:
        boolean r64 = false;
    L230:
        if (r64 == true) goto L232;
        r55.C = 0;
        goto L232
    L213:
        if ((r55 instanceof r4.c) == false) goto L216;
        String r117 = ((r4.c) r55).J;
    L228:
        r64 = r63.e(r117);
        goto L230
    L216:
        if ((r55 instanceof r4.e) == false) goto L219;
        String r65 = ((r4.e) r55).J;
    L221:
        r64 = r63.e(r65);
        goto L230
    L219:
        if ((r55 instanceof r4.d) == false) goto L223;
        r65 = ((r4.d) r55).I;
        goto L221
    L223:
        if ((r55 instanceof r4.g) == false) goto L226;
        r117 = r116;
        goto L228
    L226:
        if ((r55 instanceof r4.k) == false) goto L229;
        r117 = r115;
    L232:
        r52 = false;
        r50 = r113;
        goto L115
    L196:
        if ((r55 instanceof r4.e) == false) goto L199;
        ((r4.e) r55).q(null);
        this.f13938n.getClass();
    L206:
        this.f13937m.f11417y.b(i4.k.f8263o, 1);
    L201:
        r53 = r114;
        goto L208
    L199:
        if ((r55 instanceof j.a) == false) goto L203;
        r13 = true;
        goto L201
    L203:
        if ((r55 instanceof r4.c) == true) goto L206;
        if ((r55 instanceof r4.d) == false) goto L201;
    L189:
        r54 = r210;
        goto L190
    L183:
        if (((r4.j) r55).H != (-1)) goto L185;
        r61 = true;
        goto L186
    L165:
        long r66 = r55.f11450b;
        monitor-enter(r111);
        r111.f13976b.f13938n.f6758b.getClass();     // Catch: Throwable -> L174
        monitor-exit(r111);
        r3.c r67 = r111.f13976b.f13937m;
        r111.f13983i = r58.f11450b;
        r49.add(r55);
        if (r58.J.contains(BdimCategoryConstants.SEPARATOR_COLON) == true) goto L173;
        r111.f13978d = r58;
        r58 = null;
    L173:
        r111.f13977c = r58;
    L174:
        th = move-exception;
        throw th;
    L151:
        r59 = false;
        goto L152
    L178:
        if ((r55 instanceof j.a) == true) goto L180;
        r49.add(r55);
        goto L180
    L127:
        if (((r4.j) r55).H != (-1)) goto L129;
        r56 = true;
        goto L130
    L132:
        if (r111.f13982h == true) goto L135;
        if (r52 == false) goto L135;
        r111.f13976b.f13937m.H.l(0, j.f13970n, "session process start session 2, data={}", new Object[]{r55});
        r111.d(r55, r49, true);
        r114 = r53;
        r210 = r54;
        r115 = "terminate";
        r116 = "launch";
    L135:
        long r68 = r111.f13983i;
        if (r68 == 0) goto L140;
        long r118 = r55.f11450b;
        r115 = "terminate";
        c r119 = r111.f13976b;
        r116 = "launch";
        r119.f13937m.getClass();
        r114 = r53;
        r210 = r54;
        if (r118 <= (r119.f13938n.f6761e.getLong("session_interval", 30000) + r68)) goto L142;
        r111.f13976b.f13937m.H.l(0, j.f13970n, "session process start session 3, data={}, isResume=" + r52, new Object[]{r55});
    L142:
        if (r111.f13981g <= (r55.f11450b + 7200000)) goto L146;
        r111.f13976b.f13937m.H.l(0, j.f13970n, "session process start session 4, data={}, isResume=" + r52, new Object[]{r55});
        goto L144
    L146:
        r57 = false;
        goto L147
    L140:
        r114 = r53;
        r210 = r54;
        r115 = "terminate";
        r116 = "launch";
        goto L142
    L121:
        r113 = r50;
        goto L123
    L233:
        boolean r120 = r53;
        boolean r211 = r54;
        if (this.f13937m.E == false) goto L247;
        Iterator<r4.a> r69 = r49.iterator();
    L237:
        if (r69.hasNext() == false) goto L247;
        r4.a r70 = r69.next();
        if ((r70 instanceof r4.e) == false) goto L237;
        r3.c r71 = this.f13937m;
        if (r71.E == false) goto L243;
        k4.a r72 = (k4.a) r71.G.b(new Object[0]);
    L244:
        String r73 = r72.b(((r4.e) r70).J, r70.f());
        if (TextUtils.isEmpty(r73) == true) goto L237;
        ((r4.e) r70).H = r73;
        goto L237
    L243:
        r72 = k4.b.f8929a;
    L247:
        r3.c r74 = this.f13937m;
        if (v4.c.b(r74.f11401i) == false) goto L275;
        Iterator<r4.a> r75 = r49.iterator();
    L251:
        if (r75.hasNext() == false) goto L275;
        r4.a r76 = r75.next();
        if ((r76 instanceof r4.f) == true) goto L251;
        if ((r76 instanceof r4.c) == false) goto L259;
        String r77 = "event";
    L271:
        if (r77 == null) goto L251;
        new JSONArray().put(r76.m());
        v4.d r78 = v4.c.a(r74.f11401i);
        if (r78 == null) goto L251;
        r78.a();
        goto L251
    L259:
        if ((r76 instanceof r4.e) == false) goto L262;
        r77 = "event_v3";
        goto L271
    L262:
        if ((r76 instanceof r4.d) == false) goto L265;
        r77 = "log_data";
        goto L271
    L265:
        if ((r76 instanceof r4.g) == false) goto L268;
        r77 = "launch";
        goto L271
    L268:
        if ((r76 instanceof r4.k) == false) goto L270;
        r77 = "terminate";
        goto L271
    L270:
        r77 = null;
    L275:
        Iterator<r4.a> r79 = r49.iterator();
    L277:
        if (r79.hasNext() == false) goto L281;
        r4.a r80 = r79.next();
        if (r80.C <= 0) goto L277;
        l6.a.P0(this.f13937m.f11417y, i4.a.f8150z, r80);
        goto L277
    L281:
        this.f13937m.getClass();
        if ((System.currentTimeMillis() - this.f13948x) < 60000) goto L284;
        boolean r81 = true;
    L285:
        d4.d r82 = this.f13942r;
        if (r82.f6775b == true) goto L288;
    L290:
        boolean r83 = false;
    L291:
        if (r83 == false) goto L319;
        if (r81 == false) goto L319;
        d4.c r84 = this.f13938n;
        r84.getClass();
        Iterator<r4.a> r85 = r49.iterator();
        ArrayList r86 = null;
    L295:
        if (r85.hasNext() == false) goto L309;
        r4.a r87 = r85.next();
        if ((r87 instanceof r4.e) == false) goto L295;
        r4.e r88 = (r4.e) r87;
        if (r88.f11463y == 0) goto L305;
        if (r84.f6765i != null) goto L304;
        r84.f6765i = r84.e(null);
    L304:
        if (r84.f6765i.contains(r88.J) == false) goto L295;
    L305:
        r85.remove();
        if (r86 != null) goto L308;
        r86 = new ArrayList();
    L308:
        r86.add(r87);
        goto L295
    L309:
        if (r86 != null) goto L311;
    L325:
        this.f13937m.getClass();
        b().x(r49);
        if (r51 == true) goto L328;
    L331:
        if (r211 == true) goto L336;
        if (r13 == true) goto L336;
        if (this.f13943s == null) goto L373;
        this.f13943s.removeMessages(6);
        Message r89 = this.f13943s.obtainMessage(6);
        r89.arg1 = 2;
        this.f13943s.sendMessage(r89);
    L336:
        if (r211 == false) goto L338;
        int r90 = 1;
    L341:
        g(r90, this.f13944t);
        ArrayList r91 = this.f13944t;
        if (r91 == null) goto L373;
        if (r91.isEmpty() == true) goto L373;
        if ((this.C & 2) != 0) goto L373;
        this.f13937m.H.i(G, "bdinstall lost header callback", null, new Object[0]);
        Bundle r92 = new Bundle();
        r92.putInt("engine_state", this.C);
        r3.c r93 = this.f13937m;
        r93.getClass();
    L360:
        th = th;
        JSONObject r94 = null;
    L362:
        r93.H.i(null, "parse bundle params failed", th, new Object[0]);
        r93.f11417y.b(i4.k.X, 1);
        r45 = true;
    L363:
        r93.k("bdinstall_lost_callback", r94);
        goto L374
    L349:
        if (r92.isEmpty() == true) goto L359;
        r94 = new JSONObject();     // Catch: Throwable -> L360
        Iterator<String> r95 = r92.keySet().iterator();     // Catch: Throwable -> L357
    L353:
        if (r95.hasNext() == false) goto L356;
        String r96 = r95.next();     // Catch: Throwable -> L357
        r94.put(r96, r92.get(r96));     // Catch: Throwable -> L357
        goto L353
    L356:
        r45 = true;
    L357:
        th = th;
        goto L362
    L359:
        r45 = true;
        r94 = null;
        goto L363
    L338:
        if (r13 == false) goto L340;
        r90 = 3;
        goto L341
    L340:
        r90 = 13;
        goto L341
    L328:
        if (r120 == false) goto L330;
        this.f13947w.removeMessages(7);
        goto L331
    L330:
        this.f13937m.getClass();
        this.f13947w.sendEmptyMessageDelayed(7, this.f13938n.f6761e.getLong("session_interval", 30000));
        goto L331
    L311:
        if (r86.isEmpty() == true) goto L325;
        Iterator r97 = r86.iterator();
    L314:
        if (r97.hasNext() == false) goto L318;
        r4.a r98 = (r4.a) r97.next();
        if (r98.C <= 0) goto L314;
        l6.a.P0(this.f13937m.f11417y, i4.a.A, r98);
        goto L314
    L318:
        t4.a r99 = t4.a.a();
        r99.b().post(new y3.d(this, r86));
        this.f13937m.f11417y.b(i4.k.f8273y, r86.size());
    L319:
        Iterator<r4.a> r100 = r49.iterator();
    L321:
        if (r100.hasNext() == false) goto L325;
        r4.a r101 = r100.next();
        if (r101.f11463y != 0) goto L321;
        r101.f11463y = -1;
        goto L321
    L288:
        if (r82.f6776c == false) goto L290;
        r83 = true;
        goto L291
    L284:
        r81 = false;
        goto L285
    L364:
        Intent r102 = new Intent(this.f13937m.f11402j, Collector.class);
        int r103 = r10.size();
        String[] r104 = new String[r103];
        int r105 = 0;
    L365:
        if (r105 >= r103) goto L372;
        r4.a r106 = r10.get(r105);
        r106.getClass();
        JSONObject r107 = new JSONObject();
        r107.put("k_cls", r106.i());     // Catch: Throwable -> L369
        r106.o(r107);     // Catch: Throwable -> L369
    L371:
        String r108 = r107.toString();
        r104[r105] = r108;
        r108.length();
        r105 = r105 + 1;
    L369:
        th = move-exception;
        r106.h().m(4, r106.D, "toIpcJson failed", th, new Object[0]);
        goto L371
    L372:
        r102.putExtra("K_DATA", r104);
        this.f13937m.f11402j.sendBroadcast(r102);
        r45 = true;
    L390:
        th = move-exception;
        throw th;
    }

    public final void f(r4.a r8, Iterator<r4.a> r10, z3.a r11, e4.a r12, i4.a r13, String r14, String r15) {
        if (r11.b(r12, r14, r15) == false) goto L12;
        r10.remove();
        int r16 = r8.C;
        r3.c r17 = this.f13937m;
        if (r16 <= 0) goto L7;
        l6.a.P0(r17.f11417y, r13, r8);
    L7:
        r17.f11417y.b(i4.k.f8271w, 1);
        if ((r11 instanceof z3.b) == false) goto L10;
        i4.k r18 = i4.k.f8272x;
        r17.f11417y.b(r18, 1);
    L10:
        f4.b[] r19 = f4.b.f7323a;
        r8.g();
        List<String> r20 = G;
        r17.H.l(0, r20, "event:{} is match filter:{} drop!", new Object[]{r14, r11});
        return;
    }

    public final void g(int r8, List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L30;
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L31;
        y3.a r12 = (y3.a) r11.next();
        if (this.f13943s == null) goto L7;
        if (r12 == null) goto L7;
        r12.f13932c = true;
        if (Looper.myLooper() == this.f13943s.getLooper()) goto L14;
        this.f13943s.removeMessages(6);
        Message r13 = this.f13943s.obtainMessage(6);
        r13.arg1 = r8;
        this.f13943s.sendMessage(r13);
        goto L7
    L14:
        if ((true ^ r12.f13930a.f13937m.f11407o) == true) goto L7;
        r12.a(r8);
        goto L7
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r14) {
        if (r14.what == 1) goto L5;
        BlockHelper.tryBlock();
    L5:
        String[] r8 = null;
        String r10 = null;
        r8 = null;
        long r11 = 0;
        switch(r14.what) {
            case 1: goto L221;
            case 2: goto L190;
            case 3: goto L161;
            case 4: goto L160;
            case 5: goto L237;
            case 6: goto L151;
            case 7: goto L140;
            case 8: goto L133;
            case 9: goto L237;
            case 10: goto L122;
            case 11: goto L237;
            case 12: goto L101;
            case 13: goto L237;
            case 14: goto L100;
            case 15: goto L237;
            case 16: goto L237;
            case 17: goto L99;
            case 18: goto L66;
            case 19: goto L65;
            case 20: goto L61;
            case 21: goto L56;
            case 22: goto L50;
            case 23: goto L45;
            case 24: goto L44;
            case 25: goto L27;
            case 26: goto L13;
            case 27: goto L10;
            case 28: goto L8;
            default: goto L237;
        };
    L8:
        this.f13937m.getClass();
    L238:
        return true;
    L44:
        b();
        List<String> r15 = s3.a.f12021a;
        b();
        b();
        goto L238
    L45:
        Object r16 = r14.obj;
        if ((r16 instanceof r4.j) == false) goto L238;
        r4.j r17 = (r4.j) r16;
        r3.c r13 = this.f13937m;
        if (r13.e() == null) goto L238;
        r13.e().getClass();
        goto L238
    L50:
        Object r18 = r14.obj;
        if ((r18 instanceof Boolean) == false) goto L238;
        boolean r19 = ((Boolean) r18).booleanValue();
        r3.c r110 = this.f13937m;
        if (r110.e() == null) goto L55;
        r110.e().getClass();
    L55:
        r110.H.g(0, G, "[Task] Background session task is not enabled, isResume = {} will not work!", new Object[]{Boolean.valueOf(r19)});
        goto L238
    L56:
        C0197c r111 = (C0197c) r14.obj;
        s r12 = d().f11443e;
        s r20 = new s(r12.f13379b, r12.f13380m, r12.f13381n, r12.f13378a);
        x4.j r112 = (x4.j) ((u3.e) this.f13935a).b();
        Context r21 = r112.a();
        if (r21 == null) goto L60;
        ((i5.b) r112.f13457g.b(new Object[]{r21})).g(r20);
    L60:
        r111.getClass();
        goto L238
    L61:
        ((C0197c) r14.obj).getClass();
        s r113 = d().f11443e;
        s r22 = new s(r113.f13379b, r113.f13380m, r113.f13381n, r113.f13378a);
        u3.g r114 = this.f13935a;
        Application r115 = this.f13937m.f11402j;
        x4.j r116 = (x4.j) ((u3.e) r114).b();
        Context r117 = r116.a();
        if (r117 == null) goto L238;
        ((i5.b) r116.f13457g.b(new Object[]{r117})).i(r22);
        goto L238
    L65:
        ((C0197c) r14.obj).getClass();
        s r118 = d().f11443e;
        new s(r118.f13379b, r118.f13380m, r118.f13381n, false);
        u3.g r119 = this.f13935a;
        Application r120 = this.f13937m.f11402j;
        ((u3.e) r119).b().getClass();
        goto L238
    L66:
        ((C0197c) r14.obj).getClass();
        s r121 = d().f11443e;
        new s(r121.f13379b, r121.f13380m, r121.f13381n, false);
        ((u3.e) this.f13935a).b().getClass();
        r4.b r122 = b();
        if (r122.f11470f == false) goto L255;
        monitor-enter(r122);
        r122.f11477m.clear();     // Catch: Throwable -> L72
        monitor-exit(r122);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    L255:
        SQLiteDatabase r23 = r122.f11466b.getWritableDatabase();     // Catch: Throwable -> L84
        r23.beginTransaction();     // Catch: Throwable -> L82
        Iterator<r4.a> r24 = r122.f11467c.values().iterator();     // Catch: Throwable -> L82
    L78:
        if (r24.hasNext() == false) goto L80;
        r23.delete(r24.next().i(), null, null);     // Catch: Throwable -> L82
        goto L78
    L80:
        r23.setTransactionSuccessful();     // Catch: Throwable -> L82
    L87:
        v4.i.f(r23);
        ArrayList<r4.a> r123 = new ArrayList();
        r4.j r25 = this.f13937m.f11406n.f12707b;
        if (r25 == null) goto L90;
        r25 = (r4.j) r25.a();
    L90:
        if (r25 == null) goto L92;
        r25.l(System.currentTimeMillis());
        r25.H = -1;
        this.f13945u.d(r25, r123, true);
        this.f13945u.a(r25);
        r123.add(r25);
    L94:
        if (r123.isEmpty() == true) goto L238;
        b().x(r123);
        goto L238
    L92:
        this.f13945u.d(null, r123, false);
    L82:
        Throwable th = th;
    L247:
        ((c4.m) r122.g()).k(th, 5, "clear tables failed", new Object[0]);     // Catch: Throwable -> L96
        r122.f11465a.f13937m.f11417y.b(i4.k.O, 1);     // Catch: Throwable -> L96
        r122.f11465a.f13937m.f11417y.g("clearAllTables failed", th);     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        v4.i.f(r23);
        throw th;
    L84:
        th = move-exception;
        th = th;
        r23 = null;
        goto L247
    L99:
        this.f13937m.H.g(0, G, "Start to update sender workers...", new Object[0]);
        this.f13949y.removeAll(this.f13944t);
        ArrayList r124 = c();
        this.f13944t = r124;
        this.f13949y.addAll(0, r124);
        goto L238
    L100:
        e(true, null);
        goto L238
    L101:
        Object[] r125 = (Object[]) r14.obj;
        String r26 = (String) r125[0];
        r4.j r126 = (r4.j) r125[1];
        g(10, this.f13944t);
        if (r126 != null) goto L106;
        r126 = this.f13937m.f11406n.f12707b;
        if (r126 == null) goto L106;
        r126 = (r4.j) r126.a();
    L106:
        ArrayList<r4.a> r27 = new ArrayList();
        long r28 = System.currentTimeMillis();
        if (r126 == null) goto L112;
        long r127 = r28 - r126.f11450b;
        r126.l(r28);
        if (r127 < 0) goto L111;
        r11 = r127;
    L111:
        r126.H = r11;
        r126.L = this.f13945u.f13986l;
        this.f13945u.a(r126);
        r27.add(r126);
    L112:
        u3.g r29 = this.f13935a;
        Application r30 = this.f13937m.f11402j;
        x4.j r31 = (x4.j) ((u3.e) r29).b();
        r31.getClass();
        HashMap r128 = new HashMap();
        r128.put("user_unique_id", r26);
        ((i5.b) r31.f13457g.b(new Object[]{r30})).c(r30, r128);
        if (r126 == null) goto L119;
        r4.j r129 = (r4.j) r126.a();
        r129.l(r28 + 1);
        r129.H = -1;
        r4.g r32 = this.f13945u.d(r129, r27, true);
        if (r32 == null) goto L117;
        r32.K = this.f13945u.f13986l;
    L117:
        this.f13945u.a(r129);
        r27.add(r129);
    L119:
        if (r27.isEmpty() == true) goto L121;
        b().x(r27);
    L121:
        g(10, this.f13944t);
        goto L238
    L122:
        ArrayList<r4.a> r33 = this.f13940p;
        monitor-enter(r33);
        int r130 = this.F.a(this.f13940p);     // Catch: Throwable -> L130
        monitor-exit(r33);     // Catch: Throwable -> L130
        this.f13937m.H.l(0, G, "dump cache data count: {}", new Object[]{Integer.valueOf(r130)});
        LinkedList<String> r131 = this.F.f6752b;
        int r34 = r131.size();
        if (r34 <= 0) goto L129;
        r8 = new String[r34];
        r131.toArray(r8);
        r131.clear();
    L129:
        e(false, r8);
    L130:
        th = move-exception;
        throw th;
    L133:
        ArrayList r132 = (ArrayList) r14.obj;
        Iterator r35 = r132.iterator();
    L135:
        if (r35.hasNext() == false) goto L139;
        r4.a r36 = (r4.a) r35.next();
        if (r36.f11463y != 0) goto L135;
        r36.f11463y = -1;
        goto L135
    L139:
        b().x(r132);
        goto L238
    L140:
        this.f13937m.H.l(0, G, "Terminate created", new Object[0]);
        ArrayList<r4.a> r37 = this.f13940p;
        monitor-enter(r37);
    L148:
        th = move-exception;
        throw th;
    L143:
        if (j.f13974r != null) goto L145;
        j.f13974r = new j.a();     // Catch: Throwable -> L148
    L145:
        j.f13974r.l(0);     // Catch: Throwable -> L148
        this.f13940p.add(j.f13974r);     // Catch: Throwable -> L148
        monitor-exit(r37);     // Catch: Throwable -> L148
        goto L129
    L151:
        this.f13943s.removeMessages(6);
        this.f13937m.H.l(0, G, "start to check worker to do...", new Object[0]);
        this.f13938n.b();
        this.f13938n.f6758b.getClass();
        Iterator<y3.a> r38 = this.f13949y.iterator();
        long r39 = Long.MAX_VALUE;
    L153:
        if (r38.hasNext() == false) goto L159;
        y3.a r40 = r38.next();
        if ((!r40.f13930a.f13937m.f11407o) == true) goto L153;
        long r41 = r40.a(r14.arg1);
        if (r41 >= r39) goto L153;
        r39 = r41;
        goto L153
    L159:
        long r42 = r39 - System.currentTimeMillis();
        Message r133 = this.f13943s.obtainMessage(6);
        r133.arg1 = 2;
        long r43 = Math.max(r42, 100);
        this.f13943s.sendMessageDelayed(r133, r43);
        this.f13937m.H.l(0, G, "post check worker task with delay: {}ms.", new Object[]{Long.valueOf(r43)});
        goto L238
    L160:
        e(false, (String[]) r14.obj);
        goto L238
    L161:
        this.C |= 16;
        c4.m r134 = this.f13937m.H;
        List<String> r44 = G;
        r134.g(0, r44, "start to build workers...", new Object[0]);
        this.f13937m.getClass();
        this.f13938n.f6768l.getClass();
        if (TextUtils.isEmpty(d().f11441c) == true) goto L164;
        y3.b r135 = new y3.b(this);
        this.f13939o = r135;
        this.f13949y.add(r135);
    L164:
        ArrayList r136 = c();
        this.f13944t = r136;
        this.f13949y.addAll(r136);
        this.f13937m.H.g(0, r44, "{} workers prepared", new Object[]{Integer.valueOf(this.f13949y.size())});
        SharedPreferences r137 = this.f13942r.f6779f;
        long r45 = r137.getLong("version_code", 0);     // Catch: ClassCastException -> L167
    L168:
        j0 r138 = ((u3.e) this.f13942r.f6774a).f12437b;
        if (r138 == null) goto L172;
        r11 = r138.d();
    L172:
        if (r45 == r11) goto L174;
    L175:
        y3.b r139 = this.f13939o;
        if (r139 == null) goto L178;
        r139.f13932c = true;
    L178:
        this.f13938n.f6758b.getClass();
        m r140 = this.f13938n.f6758b;
        if (r140 != null) goto L181;
    L187:
        this.f13943s.removeMessages(6);
        this.f13943s.sendEmptyMessage(6);
        if (l.b() == true) goto L238;
        l.c("start_end", new b(this));
        goto L238
    L181:
        if (r140.f11438n == false) goto L187;
        r3.c r141 = this.f13937m;
        if (r141.E == false) goto L185;
        k4.a r142 = (k4.a) r141.G.b(new Object[0]);
    L186:
        r142.a();
        goto L187
    L185:
        r142 = k4.b.f8929a;
        goto L186
    L174:
        if (TextUtils.equals(this.f13938n.f6761e.getString("channel", ""), this.f13938n.a()) == true) goto L178;
    L167:
        r45 = r137.getInt("version_code", 0);
        r137.edit().putLong("version_code", r45).apply();
        goto L168
    L190:
        c4.m r143 = this.f13937m.H;
        List<String> r46 = G;
        r143.g(0, r46, "start to check header ready...", new Object[0]);
        if (this.f13938n.d() == false) goto L220;
        d4.d r144 = this.f13942r;
        if (r144.f6775b == true) goto L195;
    L197:
        Object[] r145 = false;
    L199:
        if (r145 == false) goto L207;
        this.C |= 8;
        this.f13943s = new Handler(this.f13936b, this);
        this.f13943s.sendEmptyMessage(3);
        if (this.f13937m.C == false) goto L204;
        this.f13937m.getClass();
    L204:
        if (this.f13940p.size() <= 0) goto L206;
        this.f13947w.removeMessages(4);
        this.f13947w.sendEmptyMessageDelayed(4, 1000);
    L206:
        this.f13937m.H.g(0, r46, "net handler start work", new Object[0]);
        goto L238
    L207:
        this.f13947w.removeMessages(2);
        JSONObject r146 = new JSONObject();
        x4.j r47 = (x4.j) ((u3.e) this.f13935a).b();
        Context r48 = r47.a();
        if (r48 != null) goto L241;
    L214:
        boolean r49 = false;
    L215:
        if (r49 == false) goto L219;
        this.f13942r.getClass();
        if (d4.d.c(r146) == false) goto L219;
        this.f13942r.e(r146);
        this.f13947w.sendEmptyMessage(2);
        this.f13937m.H.g(0, G, "net handler start work by get", new Object[0]);
    L219:
        this.f13947w.sendEmptyMessageDelayed(2, 1000);
        this.f13937m.H.g(0, G, "header not ready, will check gain after 1s...", new Object[0]);
        goto L238
    L241:
        r49 = ((i5.b) r47.f13457g.b(new Object[]{r48})).e(r146);     // Catch: Throwable -> L212
    L212:
        th = move-exception;
        th.printStackTrace();
        goto L214
    L195:
        if (r144.f6776c == false) goto L197;
        r145 = true;
        goto L199
    L220:
        this.f13937m.H.f(0, r46, "workers will not start for current is not the main process!", new Object[0]);
        goto L238
    L221:
        this.C |= 1;
        c4.m r147 = this.f13937m.H;
        List<String> r50 = G;
        r147.g(0, r50, "start bdinstall...", new Object[0]);
        if (this.f13938n.d() == false) goto L224;
        this.f13937m.H.g(0, r50, "start add observers to bdinstall...", new Object[0]);
        u3.e r148 = (u3.e) this.f13935a;
        v r51 = r148.b();
        ((x4.j) r51).f13459i.f8931a.add(new u3.d(r148));
        u3.g r149 = this.f13935a;
        a r52 = new a(this);
        u3.e r150 = (u3.e) r149;
        r150.getClass();
        u3.e.a r53 = new u3.e.a(r150, r52);
        x4.j r54 = (x4.j) r150.b();
        r54.getClass();
        r54.f13460j.b(true, new z4.e(r53));
        x4.j r151 = (x4.j) r150.b();
        r151.getClass();
        r151.f13460j.b(true, new z4.f(r53));
    L224:
        this.f13937m.H.g(0, r50, "start bdinstall service begin", new Object[0]);
        x4.j r152 = (x4.j) ((u3.e) this.f13935a).b();
        if (r152.f13451a == null) goto L233;
        ((i5.b) r152.f13457g.b(new Object[]{r152.f13451a.f13465c})).start();
        g5.k.c(r152.f13451a.f13465c).f7664j = r152.f13451a;
        g5.k.c(r152.f13451a.f13465c).f7663i = r152.f13460j;
        g5.k r153 = g5.k.c(r152.f13451a.f13465c);
        monitor-enter(r153);
        Runnable r55 = r153.f7660f;     // Catch: Throwable -> L234
        if (r55 == null) goto L232;
        r55.run();     // Catch: Throwable -> L234
    L232:
        monitor-exit(r153);
    L234:
        th = move-exception;
        throw th;
    L233:
        this.f13937m.H.g(0, r50, "start bdinstall service end", new Object[0]);
        goto L238
    L237:
        this.f13937m.H.f(0, G, "Not support message type", new Object[0]);
        goto L238
    L10:
        if ((r14.obj instanceof Boolean) == false) goto L238;
        b().f11471g = ((Boolean) r14.obj).booleanValue();
        goto L238
    L13:
        if ((r14.obj instanceof Boolean) == false) goto L238;
        r4.b r154 = b();
        boolean r155 = ((Boolean) r14.obj).booleanValue();
        monitor-enter(r154);
    L23:
        th = move-exception;
        throw th;
    L17:
        if (r154.f11470f != true) goto L20;
        if (r155 == true) goto L20;
        r154.x(null);     // Catch: Throwable -> L23
    L20:
        r154.f11470f = r155;     // Catch: Throwable -> L23
        monitor-exit(r154);
        goto L238
    L27:
        if (this.f13937m.f11414v == true) goto L29;
    L43:
        this.f13937m.f11417y.c(new i4.e(new i4.e.a()));
        goto L238
    L29:
        if (this.f13937m.f11417y.f8212a.f8157b == false) goto L43;
        if (TextUtils.isEmpty(d().f11442d) == true) goto L43;
        this.f13937m.f11417y.b(i4.k.f8274z, b().f11473i);
        this.f13937m.f11417y.b(i4.k.A, b().f11474j);
        this.f13937m.f11417y.b(i4.k.B, b().f11475k);
        this.f13937m.f11417y.b(i4.k.C, b().f11476l);
        i4.f r156 = this.f13937m.f11417y;
        i4.k r56 = i4.k.D;
        long r57 = b().f11466b.f11479a;
        if (r57 <= 0) goto L35;
        int r58 = Math.toIntExact(r57 / 1024);
    L36:
        r156.b(r56, r58);
        i4.f r157 = this.f13937m.f11417y;
        i4.e.a r59 = new i4.e.a();
        i4.d.a r60 = new i4.d.a();
        d4.c r61 = this.f13938n;
        r60.f8183a = r61.f6758b.f11425a;
        r60.f8184b = r61.a();
        m r62 = this.f13938n.f6758b;
        r60.f8186d = r62.f11429e;
        r60.f8185c = null;
        r60.f8187e = r62.f11432h;
        r60.f8192j = "5.7.15";
        r60.f8188f = r62.f11438n;
        Application r63 = this.f13937m.f11402j;
        ConcurrentHashMap r64 = x4.m.f13528a;
        if (r63 == null) goto L42;
        int r65 = k5.d.f8934b;
        SharedPreferences r66 = r63.getSharedPreferences(t2.b.j("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA=="), 0);
        r10 = r66.getString("cdid", null);
        if (TextUtils.isEmpty(r10) == false) goto L42;
        r10 = UUID.randomUUID().toString();
        r66.edit().putString("cdid", r10).apply();
    L42:
        r60.f8193k = r10;
        r60.f8194l = !l.b();
        this.f13938n.f6758b.getClass();
        r60.f8190h = true;
        this.f13938n.f6758b.getClass();
        r60.f8191i = false;
        this.f13938n.f6758b.getClass();
        r60.f8189g = false;
        r59.f8203b = new i4.d(r60);
        r59.f8207f = (ExecutorService) x3.a.f13373e.b(new Object[0]);
        r59.f8204c = this.f13938n.b();
        r59.f8205d = this.f13937m.f();
        r59.f8206e = d().f11442d;
        r59.f8202a = this.f13937m.f11402j;
        r59.f8208g = new e(this);
        r157.c(new i4.e(r59));
        goto L238
    L35:
        r58 = 0;
        goto L36
    }
}
