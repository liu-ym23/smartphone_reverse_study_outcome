package com.bytedance.crash.upload;

import ai.g0;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.AppDataCenter;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashFilter;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile g f4123k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4126c;
    public int d;
    public HashMap e;
    public volatile boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f4127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f4128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.anniex.container.i f4129j;

    public g(Context r5) {
        this.f4125b = new ArrayList();
        this.f4126c = -1;
        this.d = 0;
        this.f4127h = new d(this, 0);
        this.f4128i = new d(this, 1);
        this.f4129j = new com.bytedance.android.anniex.container.i(this);
        this.f4124a = r5;
    }

    public static JSONObject a(JSONObject r12, boolean r13, String r14, String r15) {
        JSONObject r5 = r12.optJSONObject("header");
        if (r5 != null) goto L5;
        r5 = new JSONObject();
    L7:
        String r10 = null;
        String r11 = r5.optString("sdk_version_name", null);
        if (r11 != null) goto L10;
        r11 = "3.1.7-rc.89";
    L10:
        z8.c.l(r12, "filters", WsConstants.KEY_SDK_VERSION, r11);
        JSONArray r16 = r12.optJSONArray("logcat");
        if (r16 != null) goto L13;
    L14:
        r12.put("logcat", zm.p.f(com.bytedance.crash.util.g.c(com.bytedance.crash.n.f4057a, r14)));
    L15:
        z8.c.l(r12, "filters", "has_dump", "true");
        z8.c.l(r12, "filters", "is_64_devices", String.valueOf(Header.h()));
        z8.c.l(r12, "filters", "is_64_runtime", String.valueOf(NativeTools.k().E()));
        z8.c.l(r12, "filters", "is_x86_devices", String.valueOf(Header.i()));
        z8.c.l(r12, "filters", "is_root", String.valueOf(s6.c.j()));
        z8.c.l(r12, "filters", "is_hm_os", String.valueOf(com.lynx.tasm.p.f()));
        r10 = System.getProperty("os.version");     // Catch: Throwable -> L35
    L17:
        z8.c.l(r12, "filters", "kernel_version", r10);
        r12.put("launch_did", f9.a.h(com.bytedance.crash.n.f4057a));
        r12.put("crash_uuid", r15);
        r12.put("jiffy", av.i.b());
        r12.put("has_dump", "true");
        if (r12.opt("storage") != null) goto L24;
        HashMap r17 = new HashMap();
        JSONObject r18 = com.lynx.tasm.base.h.d(r17);
        mh.e.g(r18, "storage", r12);
        long r19 = r18.optLong("inner_free");
        long r20 = r18.optLong("sdcard_free");
        long r110 = r18.optLong("inner_free_real");
        String r21 = z8.c.a(r19);
        String r22 = z8.c.a(r20);
        String r23 = z8.c.a(r110);
        z8.c.l(r12, "filters", "inner_free", r21);
        z8.c.l(r12, "filters", "inner_free_real", r23);
        z8.c.l(r12, "filters", "sdcard_free", r22);
        Iterator r111 = r17.keySet().iterator();
    L21:
        if (r111.hasNext() == false) goto L24;
        String r24 = (String) r111.next();
        r17.put(r24, r17.get(r24));
    L24:
        if (r5.has("params_err") == false) goto L26;
        z8.c.l(r12, "filters", "params_err", r5.optString("params_err"));
    L26:
        i.a.m(r12);
        if (r13 == false) goto L33;
        JSONObject r112 = new JSONObject();
        r12.put("event_type", "start_crash");
        Object r113 = r12.remove("data");
        if (r113 == null) goto L31;
        r12.put("stack", r113);
    L31:
        r112.put("data", new JSONArray().put(r12));
        r112.put("header", r5);
        return r112;
    L33:
        r12.put("isJava", 1);
        return r12;
    L13:
        if (r16.length() != 0) goto L15;
    L5:
        if (r13 == false) goto L7;
        r12.remove("header");
        goto L7
    }

    public static JSONObject b(s6.c r10) {
        i4.a r5 = (i4.a) r10.f21828b;
        if (r5 == null) goto L5;
        boolean r11 = ((w8.f) r5.f17503c).g();
    L7:
        if (r11 == true) goto L10;
        r10.z();
        return null;
    L10:
        ICrashFilter r12 = com.bytedance.crash.n.f4063k.f4024b;
        if (r12 == null) goto L37;
        if (r12.onNativeCrashFilter(r10.m(), "") == true) goto L37;
        r10.z();
        return null;
    L16:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L37:
        z8.c r13 = new z8.c();     // Catch: Throwable -> L29
        JSONObject r14 = r13.f23416a;     // Catch: Throwable -> L29
        r10.s(r13);     // Catch: Throwable -> L29
        r10.p(r13);     // Catch: Throwable -> L29
        r10.h(r13);     // Catch: Throwable -> L29
        s6.c.i(r13, ((i9.g) ((i4.a) r10.f21828b).f17502b).g);     // Catch: Throwable -> L29
        r10.q(r13);     // Catch: Throwable -> L29
        r10.y(r13);     // Catch: Throwable -> L29
        mh.e.g(zm.p.f(com.bytedance.crash.util.g.c(com.bytedance.crash.n.f4057a, ((File) ((i4.a) r10.f21828b).d).getName())), "logcat", r14);     // Catch: Throwable -> L29
        r10.u(r13);     // Catch: Throwable -> L29
        r10.t(r13);     // Catch: Throwable -> L29
        i4.a r15 = (i4.a) r10.f21828b;     // Catch: Throwable -> L29
        if (r15 == null) goto L22;
        HashMap r16 = (HashMap) ((w8.f) r15.f17503c).f22816a;     // Catch: Throwable -> L29
    L23:
        String r17 = (String) r16.get("update_version_code");     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r17) == true) goto L39;
        long r18 = Long.decode(r17).longValue();     // Catch: Throwable -> L32
        if (r18 <= 0) goto L39;
        r14.optJSONObject("header").put("update_version_code", r18);     // Catch: Throwable -> L32
        r14.optJSONObject("header").put("version_get_time", 0);     // Catch: Throwable -> L32
    L39:
        return r14;
    L22:
        r16 = null;
    L29:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return null;
    L5:
        r11 = false;
        goto L7
    }

    public static ym.p c(File r5, CrashType r10, String r11, long r12, long r13) {
        ym.p r14 = null;
    L6:
        th = move-exception;
        cl.a.C(r5);
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L27:
        return r14;
    L4:
        if (r5.isFile() == false) goto L9;
        cl.a.C(r5);     // Catch: Throwable -> L6
        goto L27
    L9:
        if (r10 != CrashType.LAUNCH) goto L11;
        boolean r15 = true;
    L12:
        if (r10 == null) goto L25;
        if (new File(r5, r5.getName()).exists() == true) goto L25;
        if (r10 == CrashType.ANR) goto L25;
        r14 = cl.a.j(r5, r10);     // Catch: Throwable -> L6
        JSONObject r16 = (JSONObject) r14.f23313c;     // Catch: Throwable -> L6
        if (r16 == null) goto L23;
        r16.put("crash_time", r12);     // Catch: Throwable -> L6
        r16.put("app_start_time", r13);     // Catch: Throwable -> L6
        r14.f23313c = a(r16, r15, r11, r5.getName());     // Catch: Throwable -> L28
        goto L27
    L23:
        cl.a.C(r5);     // Catch: Throwable -> L6
    L25:
        return cl.a.B(new File(r5, r5.getName()).getAbsolutePath());
    L11:
        r15 = false;
        goto L12
    }

    public static void e(int r5, CrashType r10) {
        List r11 = ((ListMap) com.bytedance.crash.p.f.e).a(r10);     // Catch: Throwable -> L15
        if (r11.size() <= 0) goto L13;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L15
        if (r12.hasNext() == false) goto L13;
        if (r12.next() != null) goto L12;
        throw null;     // Catch: Throwable -> L15
    L12:
        throw new ClassCastException();     // Catch: Throwable -> L15
    L13:
        s.g(r5, r10);     // Catch: Throwable -> L15
        return;
    }

    public static void g(File r10) {
        String[] r5 = r10.list();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length <= 10) goto L20;
        Arrays.sort(r5);     // Catch: Throwable -> L14
        int r11 = r5.length;     // Catch: Throwable -> L14
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r12 >= r11) goto L22;
        String r14 = r5[r12];     // Catch: Throwable -> L14
        r13 = r13 + 1;     // Catch: Throwable -> L14
        if (r13 <= 10) goto L12;
        cl.a.C(new File(r10, r14));     // Catch: Throwable -> L14
    L12:
        r12 = r12 + 1;
        goto L8
    L22:
        return;
    L21:
        return;
    }

    public static void h(File r11, String r12, HashMap r13) {
        byte r5 = 2;
        boolean r10 = false;
        if (r12.endsWith("G") == false) goto L51;
        String[] r14 = r12.split("_");
        if (r14.length >= 5) goto L53;
        cl.a.C(r11);
        return;
    L53:
        long r15 = Long.parseLong(r14[0]);     // Catch: Throwable -> L49
        long r16 = Long.parseLong(r14[4]);     // Catch: Throwable -> L49
        String r17 = r14[2];
        String r18 = r14[1];
        r18.getClass();
        switch(r18.hashCode()) {
            case -1109843021: goto L24;
            case 96741: goto L20;
            case 3254818: goto L17;
            case 94683397: goto L13;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L27:
        switch(r5) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            default: goto L28;
        };
    L28:
        CrashType r19 = null;
    L33:
        f r20 = (f) r13.get(r17);
        if (r20 != null) goto L36;
        r20 = new f(r17);
        r13.put(r17, r20);
    L36:
        e r110 = new e(r11, r15, r19);
        r110.f4107c = r16;
        r110.e = r10;
        e r111 = r20.d;
        if (r111 != null) goto L39;
    L40:
        if (r19 != null) goto L42;
    L47:
        r20.f4110b.add(r110);
        return;
    L42:
        if (r19 == CrashType.ANR) goto L47;
        if (r10 == true) goto L47;
        if (r12.contains("ignore") == true) goto L47;
        r20.d = r110;
        goto L47
    L39:
        if (r111.f4106b <= r110.f4106b) goto L47;
    L29:
        r10 = true;
        r19 = CrashType.JAVA;
        goto L33
    L30:
        r19 = CrashType.JAVA;
        goto L33
    L31:
        r19 = CrashType.ANR;
        goto L33
    L32:
        r19 = CrashType.LAUNCH;
        goto L33
    L13:
        if (r18.equals("cjava") == false) goto L55;
        r5 = 3;
        goto L27
    L55:
        r5 = -1;
        goto L27
    L17:
        if (r18.equals("java") == true) goto L27;
        r5 = -1;
        goto L27
    L20:
        if (r18.equals("anr") == false) goto L57;
        r5 = 1;
        goto L27
    L57:
        r5 = -1;
        goto L27
    L24:
        if (r18.equals("launch") == false) goto L58;
        r5 = 0;
        goto L27
    L58:
        r5 = -1;
    L49:
        cl.a.C(r11);
        m.b r112 = com.bytedance.crash.c.f4025a;
        RuntimeException r113 = new RuntimeException("err format crashTime:".concat(r12));
        r112.getClass();
        m.b.h("NPTH_CATCH", r113);
        return;
    L51:
        cl.a.C(r11);
    }

    public static void i(File r5, ArrayList r10) {
        File[] r11 = r5.listFiles();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L17;
        if (r12 >= 5) goto L25;
        File r13 = r11[r12];
        if (r13.isDirectory() == false) goto L13;
        i(r13, r10);     // Catch: Throwable -> L11
    L16:
        r12 = r12 + 1;
        goto L4
    L13:
        r10.add(r13);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r13);
        goto L16
    L25:
        return;
    }

    public static void k(HashMap r5, FilenameFilter r10) {
        if (r10 != null) goto L5;
        Context r11 = com.bytedance.crash.n.f4057a;
        String r12 = com.bytedance.crash.util.g.f4181a;
        File[] r13 = new File(com.bytedance.crash.util.g.h(r11), x8.a.f22983b).listFiles();
    L6:
        if (r13 == null) goto L36;
        int r14 = 0;
    L10:
        if (r14 >= r13.length) goto L46;
        File r15 = r13[r14];
        if (r15.getName().contains("deleted") == false) goto L15;
    L32:
        cl.a.C(r15);     // Catch: Throwable -> L23
    L35:
        r14 = r14 + 1;
        goto L10
    L15:
        if (new File(r15, "deleted").exists() == true) goto L32;
        if (cl.a.E(r15) == true) goto L35;
        if (d9.b.g != null) goto L25;
        d9.b.g = new d9.b();     // Catch: Throwable -> L23
    L25:
        d9.b r16 = d9.b.g;     // Catch: Throwable -> L23
        String r17 = r15.getName();     // Catch: Throwable -> L23
        if (r16.f.containsKey(r17) == true) goto L35;
        if (r15.isFile() == false) goto L31;
        cl.a.C(r15);     // Catch: Throwable -> L23
        goto L35
    L31:
        h(r15, r15.getName(), r5);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L35
    L46:
        return;
    L36:
        return;
    L5:
        Context r18 = com.bytedance.crash.n.f4057a;
        String r19 = com.bytedance.crash.util.g.f4181a;
        r13 = new File(com.bytedance.crash.util.g.h(r18), x8.a.f22983b).listFiles(r10);
        goto L6
    }

    public static void o(File r5, ArrayList r10) {
        File[] r11 = r5.listFiles();
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L19;
        if (r12 >= 5) goto L28;
        File r13 = r11[r12];
        if (r13.isDirectory() == false) goto L14;
        o(r13, r10);     // Catch: Throwable -> L11
    L18:
        r12 = r12 + 1;
        goto L4
    L14:
        if (r13.getName().contains("asan_report.") == false) goto L18;
        r10.add(r13.getName());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r13);
        goto L18
    L28:
        return;
    }

    public static void q(HashMap r10, FilenameFilter r11) {
        if (r11 != null) goto L5;
        File[] r12 = com.bytedance.crash.util.g.g(com.bytedance.crash.n.f4057a).listFiles();
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.length == 0) goto L42;
        int r5 = 0;
    L12:
        if (r5 >= r12.length) goto L43;
        File r13 = r12[r5];
        if (r13.isDirectory() == true) goto L17;
    L30:
        cl.a.C(r13);     // Catch: Throwable -> L26
    L33:
        r5 = r5 + 1;
        goto L12
    L17:
        if (r13.getName().contains("deleted") == true) goto L30;
        if (new File(r13, "deleted").exists() == true) goto L30;
        if (r13.getName().endsWith("G") == false) goto L29;
        String r14 = r13.getName();     // Catch: Throwable -> L26
        f r15 = (f) r10.get(r14);     // Catch: Throwable -> L26
        if (r15 != null) goto L28;
        r15 = new f(r14);     // Catch: Throwable -> L26
        r10.put(r14, r15);     // Catch: Throwable -> L26
    L28:
        r15.f4111c.add(new e(r13, CrashType.NATIVE));     // Catch: Throwable -> L26
        goto L33
    L29:
        cl.a.C(r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r13);
        goto L33
    L43:
        return;
    L42:
        return;
    L5:
        r12 = com.bytedance.crash.util.g.g(com.bytedance.crash.n.f4057a).listFiles(r11);
        goto L6
    }

    public static g s() {
        if (f4123k != null) goto L16;
        monitor-enter(g.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f4123k != null) goto L11;
        f4123k = new g(com.bytedance.crash.n.f4057a);     // Catch: Throwable -> L9
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L9
    L16:
        return f4123k;
    }

    public final void d() {
        String r5 = com.bytedance.crash.util.g.f4181a;
        Context r10 = this.f4124a;
        g(new File(com.bytedance.crash.util.g.h(r10), x8.a.f));
        g(new File(com.bytedance.crash.util.g.h(r10), x8.a.f22983b));
        g(com.bytedance.crash.util.g.g(r10));
    }

    public final void f(f r27, boolean r28, l9.g r29) {
        if (r27.f4110b.isEmpty() == false) goto L6;
        return;
    L6:
        if (r27.e != null) goto L8;
        r27.e = r27.d;
    L8:
        Iterator r5 = r27.f4110b.iterator();
    L10:
        if (r5.hasNext() == false) goto L184;
        e r10 = (e) r5.next();
        File r14 = r10.f4105a;     // Catch: Throwable -> L16
        CrashType r15 = r10.g;     // Catch: Throwable -> L16
        ym.p r11 = c(r14, r15, r27.f4109a, r10.f4106b, r10.f4107c);     // Catch: Throwable -> L16
        if (r11 != null) goto L19;
        cl.a.C(r14);     // Catch: Throwable -> L16
    L15:
        Iterator r16 = r5;
    L59:
        r5 = r16;
        goto L10
    L19:
        JSONObject r12 = (JSONObject) r11.f23313c;     // Catch: Throwable -> L16
        if (r12 != null) goto L22;
        cl.a.C(r14);     // Catch: Throwable -> L16
        goto L15
    L22:
        JSONObject r13 = r12.optJSONObject("header");     // Catch: Throwable -> L16
        if (r13 != null) goto L26;
        cl.a.C(r14);     // Catch: Throwable -> L16
        goto L15
    L26:
        if (r15 != CrashType.LAUNCH) goto L28;
    L31:
        JSONObject r17 = ((JSONArray) r12.opt("data")).optJSONObject(0);     // Catch: Throwable -> L16
        r17.optString("stack");     // Catch: Throwable -> L16
    L33:
        if (r29 == null) goto L62;
        String r18 = r17.optString("crash_md5", "default");     // Catch: Throwable -> L16
        r16 = r5;
        long r19 = r29.f19561b;     // Catch: Throwable -> L16
        monitor-enter(r29);     // Catch: Throwable -> L55
        if (r18 != null) goto L162;
        r18 = "default";
    L162:
        HashMap r110 = (HashMap) r29.e;     // Catch: Throwable -> L39
        long r111 = 1L;     // Catch: Throwable -> L39
        if (r110 != null) goto L44;
        Long r112 = -1L;     // Catch: Throwable -> L39
    L50:
        if (r112.longValue() >= r19) goto L57;
        monitor-exit(r29);     // Catch: Throwable -> L55
        if (r29.g(r29.f19561b) == true) goto L63;
    L58:
        cl.a.C(r14);     // Catch: Throwable -> L55
        r10.d = true;     // Catch: Throwable -> L55
    L63:
        r10.f4106b = r17.optLong("crash_time");     // Catch: Throwable -> L55
        r27.f4116l = r17.optString("process_name");     // Catch: Throwable -> L55
        if (r10.f == true) goto L156;
        int r20 = this.d;     // Catch: Throwable -> L55
        if (r20 >= 5) goto L156;
        this.d = r20 + 1;     // Catch: Throwable -> L55
        if (com.bytedance.crash.util.g.c(com.bytedance.crash.n.f4057a, r27.f4109a).exists() == true) goto L71;
        r27.f4119o = true;     // Catch: Throwable -> L55
    L71:
        File r21 = new File(r14, "has_kill_info");     // Catch: Throwable -> L55
        if (r21.exists() == true) goto L160;
    L75:
        String r22 = null;
    L76:
        File r113 = new File(r14, "has_exit_info");     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "start_uuid", r27.f4109a);     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "leak_threads_count", String.valueOf(r27.g));     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "crash_thread_name", r17.optString("crash_thread_name", "unknown"));     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "upload_scene", "launch_scan");     // Catch: Throwable -> L55
        if (r10.f4108h.contains("nospace") == false) goto L79;
        String r114 = "true";
    L80:
        z8.c.l(r17, "filters", "no_space", r114);     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "has_kill_info", String.valueOf(!TextUtils.isEmpty(r22)));     // Catch: Throwable -> L55
        z8.c.l(r17, "filters", "has_exit_info", String.valueOf(r113.exists()));     // Catch: Throwable -> L55
        r27.a(r17);     // Catch: Throwable -> L55
        com.bytedance.crash.n.f4063k.getClass();     // Catch: Throwable -> L55
        AppDataCenter.a(r17);     // Catch: Throwable -> L55
        String r23 = zm.p.b(r27.f4114j, r10.f4106b);     // Catch: Throwable -> L55
        if (r23 == null) goto L84;
        z8.c.l(r17, "custom", "exit_info", r23);     // Catch: Throwable -> L55
        z5.a.d(r23, r17);     // Catch: Throwable -> L55
    L84:
        if (r27.f4112h < 0) goto L92;
        String r24 = r17.optJSONObject("filters").optString("alog_inited");     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r24) == true) goto L92;
        if ("true".equals(r24) == false) goto L90;
        int r25 = 1;
    L91:
        r27.f4112h = r25;     // Catch: Throwable -> L55
        goto L92
    L90:
        r25 = -1;
    L92:
        ((JSONObject) r11.f23313c).put("upload_scene", "launch_scan");     // Catch: Throwable -> L55
        if (r15 == null) goto L95;
    L101:
        ConcurrentLinkedQueue r26 = z8.d.f23418a;     // Catch: Throwable -> L55
        new JSONArray(cl.a.c(-1, new File(r14, "all_data.json"), "\n"));     // Catch: Throwable -> L153
    L103:
        if (r28 == true) goto L111;
        e r30 = r27.e;     // Catch: Throwable -> L55
        if (r30 == null) goto L111;
        if (r10.e == true) goto L111;
        if (r30.f4106b >= r10.f4106b) goto L111;
    L168:
        z8.c.l(r17, "filters", WsConstants.KEY_APP_ID, String.valueOf(r13.opt(WsConstants.KEY_APP_ID)));     // Catch: Throwable -> L114
        z8.c.l(r17, "filters", "has_ignore", String.valueOf(r10.f4108h.contains("ignore")));     // Catch: Throwable -> L114
        r13.put(WsConstants.KEY_APP_ID, 2010);     // Catch: Throwable -> L114
    L116:
        z8.c.l(r17, "custom", "notify_jc_cost", String.valueOf(r27.f4121q));     // Catch: Throwable -> L55
        com.lynx.jsbridge.a.j(com.bytedance.crash.util.g.c(this.f4124a, r27.f4109a), r12);     // Catch: Throwable -> L55
        if (r15 == null) goto L119;
        String r31 = r15.getName();     // Catch: Throwable -> L55
    L120:
        String r32 = (String) r11.f23312b;     // Catch: Throwable -> L55
        String r33 = r12.toString();     // Catch: Throwable -> L55
        c5.a r34 = new c5.a(r14, true);     // Catch: Throwable -> L55
        c5.a r115 = new c5.a(com.bytedance.crash.util.g.c(this.f4124a, r27.f4109a), true);     // Catch: Throwable -> L55
        c5.a r116 = new c5.a(b.e(), false);     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r22) == false) goto L123;
        c5.a r210 = null;
    L124:
        t r35 = b.a(r31, r32, r33, null, new c5.a[]{r34, r115, r116, r210, com.bytedance.android.anniex.base.service.e.m(r10.f4106b), i9.f.c(r12.optJSONArray("alive_pids"))});     // Catch: Throwable -> L55
        if (r35.c() == true) goto L127;
        r27.s = true;     // Catch: Throwable -> L55
    L133:
        ConcurrentLinkedQueue r36 = h.f4130a;     // Catch: Throwable -> L55
        h.f4131b.add(new uj.a(r12, r15));     // Catch: Throwable -> L55
        ConcurrentLinkedQueue r37 = h.f4130a;     // Catch: Throwable -> L55
        if (r37 == null) goto L59;
        if (r37.isEmpty() == true) goto L59;
        Iterator r38 = r37.iterator();     // Catch: Throwable -> L55
    L140:
        if (r38.hasNext() == false) goto L59;
        if (r38.next() != null) goto L147;
        throw null;     // Catch: Throwable -> L154
    L147:
        throw new ClassCastException();     // Catch: Throwable -> L55
    L127:
        if (cl.a.C(r14) == true) goto L130;
        cl.a.G(r14);     // Catch: Throwable -> L55
    L130:
        if (r35.b() == false) goto L133;
        r10.f = true;     // Catch: Throwable -> L55
        e(0, r15);     // Catch: Throwable -> L55
        goto L133
    L123:
        r210 = new c5.a(new File(r22), false);     // Catch: Throwable -> L55
        goto L124
    L119:
        r31 = "unknown_java";
        goto L120
    L114:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L55
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L55
    L111:
        if (r10.f4108h.contains("ignore") == false) goto L116;
    L95:
        if (new File(r14, r14.getName()).exists() == true) goto L99;
        if (r14.getName().split("_").length >= 5) goto L101;
    L99:
        if (b.b((String) r11.f23312b, r12.toString(), true).c() == false) goto L59;
        cl.a.C(r14);     // Catch: Throwable -> L55
        goto L59
    L79:
        r114 = "false";
        goto L80
    L160:
        r22 = cl.a.c(-1, r21, "\n");     // Catch: Throwable -> L55 IOException -> L155
    L156:
        r10.f = true;     // Catch: Throwable -> L150
        cl.a.C(r14);     // Catch: Throwable -> L150
        e(1, r15);     // Catch: Throwable -> L150
    L150:
        th = th;
    L151:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r10.f4105a);
        goto L59
    L57:
        monitor-exit(r29);     // Catch: Throwable -> L55
        goto L58
    L44:
        Long r211 = (Long) r110.get(r18);     // Catch: Throwable -> L39
        if (r211 == null) goto L47;
        r111 = Long.valueOf(r211.longValue() + 1);     // Catch: Throwable -> L39
    L47:
        Long r117 = r111;
        r110.put(r18, r117);     // Catch: Throwable -> L39
        r112 = r117;
        goto L50
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L55:
        th = th;
        goto L151
    L62:
        r16 = r5;
        goto L63
    L28:
        if ((r12.opt("data") instanceof JSONArray) == true) goto L31;
        r12.optString("data");     // Catch: Throwable -> L16
        r17 = r12;
    L16:
        th = th;
        r16 = r5;
        goto L151
    }

    public final void j(HashMap r5) {
        String r10 = com.bytedance.crash.util.g.f4181a;
        File[] r11 = new File(new File(com.bytedance.crash.util.g.h(this.f4124a), x8.a.f), "asdawd").listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length == 0) goto L34;
        int r12 = 0;
    L9:
        if (r12 >= r11.length) goto L35;
        File r13 = r11[r12];
        if (r13.isDirectory() == true) goto L17;
        cl.a.C(r13);     // Catch: Throwable -> L14
    L24:
        r12 = r12 + 1;
        goto L9
    L17:
        if (r13.getName().endsWith("G") == false) goto L21;
        String r14 = r13.getName();     // Catch: Throwable -> L14
        if (((f) r5.get(r14)) != null) goto L24;
        r5.put(r14, new f(r14));     // Catch: Throwable -> L14
        goto L24
    L21:
        cl.a.C(r13);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r13);
        goto L24
    L35:
        return;
    }

    public final void l(s6.c r17, File r18, File r19, boolean r20) {
        if (r18.exists() == true) goto L6;
        return;
    L6:
        if (r19.exists() == false) goto L64;
        Context r5 = com.bytedance.crash.n.f4057a;
        File r10 = new File(r19, com.bytedance.crash.n.f() + '_' + Long.toHexString(new Random().nextLong()) + "G");
        if (r10.exists() == true) goto L10;
        r10.mkdir();
    L10:
        r17.f21829c = new i9.a(r18.getPath());
        r17.f21828b = new i4.a(r10, 1);
        r10.getName();
        File[] r11 = com.bytedance.crash.util.g.g(this.f4124a).listFiles();
        if (r11 == null) goto L13;
    L14:
        cl.a.l(r18, new File(r10, r18.getName()), false, Integer.MAX_VALUE);
        z8.c r12 = new z8.c();     // Catch: Throwable -> L22
        JSONObject r13 = r12.f23416a;     // Catch: Throwable -> L22
        r17.p(r12);     // Catch: Throwable -> L22
        r17.n(r12);     // Catch: Throwable -> L22
        s6.c.i(r12, ((i9.a) r17.f21829c).f17521c);     // Catch: Throwable -> L22
        r17.t(r12);     // Catch: Throwable -> L22
        File r14 = new File((File) ((i4.a) r17.f21828b).d, "upload.json");     // Catch: Throwable -> L22
        Header r15 = new Header();     // Catch: Throwable -> L22
        JSONObject r16 = r15.f4029a;     // Catch: Throwable -> L22
        JSONObject r110 = r13.optJSONObject("header");     // Catch: Throwable -> L22
        if (r110 == null) goto L24;
        Iterator<String> r111 = r110.keys();     // Catch: Throwable -> L22
    L20:
        if (r111.hasNext() == false) goto L24;
        String r112 = r111.next();     // Catch: Throwable -> L22
        mh.e.g(r110.opt(r112), r112, r16);     // Catch: Throwable -> L22
    L24:
        mh.e.g(r16, "header", r13);     // Catch: Throwable -> L22
        r12.f23417b = r15;     // Catch: Throwable -> L22
        Header.d(r15);     // Catch: Throwable -> L22
        String r21 = r13.optString("process_name");     // Catch: Throwable -> L22
        Context r113 = com.bytedance.crash.n.f4057a;     // Catch: Throwable -> L22
        z8.c r22 = Header.c(r21, r13.optLong("app_start_time", 0), r13.optLong("crash_time", 0));     // Catch: Throwable -> L22
        if (mh.e.n(r16) == false) goto L27;
        mh.e.g(r22.o().f4029a, "header", r13);     // Catch: Throwable -> L22
    L28:
        mh.e.j(r12.b(), r22.b());     // Catch: Throwable -> L22
        if (r16.has("params_err") == false) goto L31;
        z8.c.l(r13, "filters", "params_err", r16.optString("params_err"));     // Catch: Throwable -> L22
    L31:
        cl.a.q(r14, r13);     // Catch: Throwable -> L22
    L34:
        if (r13 != null) goto L36;
    L55:
        r17.z();
        return;
    L36:
        if (r13.length() == 0) goto L55;
        if (r20 == true) goto L40;
        return;
    L40:
        if (r13.length() == 0) goto L67;
        File r23 = new File(r10, "dump.zip");
        sj.k.g().getClass();
        String r24 = com.bytedance.crash.n.f4062j.getAsanReportUploadUrl();     // Catch: Throwable -> L48
        String r25 = CrashType.ASAN.getName();     // Catch: Throwable -> L48
        String r26 = b.i(r24, r13.optJSONObject("header"));     // Catch: Throwable -> L48
        String r27 = r13.toString();     // Catch: Throwable -> L48
        boolean r28 = false;
        boolean r29 = b.a(r25, r26, r27, null, new c5.a[]{new c5.a(r23, true), new c5.a(b.e(), false), new c5.a(r10, true)}).c();     // Catch: Throwable -> L46
    L51:
        if (r29 == false) goto L68;
        cl.a.C(r18);
        if (r17.z() == true) goto L69;
        cl.a.G(r10);
        return;
    L69:
        return;
    L68:
        return;
    L46:
        th = th;
    L50:
        io.reactivex.exceptions.a.j(th);
        r29 = r28;
    L48:
        th = th;
        r28 = false;
        goto L50
    L67:
        return;
    L27:
        mh.e.j(r16, r22.o().f4029a);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        r13 = null;
        goto L34
    L13:
        if (r11.length != 0) goto L14;
        return;
    }

    public final void m(boolean r20) {
        boolean r5 = false;
        String r10 = null;
        if (this.e != null) goto L11;
        HashMap r11 = new HashMap();
        this.e = r11;
        p(r11);     // Catch: Throwable -> L8
        j(this.e);     // Catch: Throwable -> L8
        k(this.e, null);     // Catch: Throwable -> L8
        Context r12 = this.f4124a;     // Catch: Throwable -> L8
        String r13 = com.bytedance.crash.util.g.f4181a;     // Catch: Throwable -> L8
        cl.a.C(new File(com.bytedance.crash.util.g.h(r12), x8.a.f22984c));     // Catch: Throwable -> L8
        q(this.e, null);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L11:
        if (this.g == false) goto L13;
    L14:
        String r14 = null;
    L125:
        if (com.bytedance.crash.p.f4084h == true) goto L198;
        if (r20 == true) goto L168;
        r(false);
        return;
    L168:
        w8.e.l();     // Catch: Throwable -> L134
        String[] r15 = {"custom_event_settings", "npth_simple_setting", "gwp_asan_monitor_path"};     // Catch: Throwable -> L134
        JSONObject r16 = mh.e.q(l9.c.e(), r15);     // Catch: Throwable -> L134
        if (r16 != null) goto L131;
        String r17 = r14;
    L132:
        com.bytedance.crash.p.d(r17);     // Catch: Throwable -> L134
        com.bytedance.crash.p.f();     // Catch: Throwable -> L134
        com.bytedance.crash.p.a();     // Catch: Throwable -> L134
        i9.f.j();     // Catch: Throwable -> L134
    L137:
        if (this.e.isEmpty() == false) goto L140;
        u();
    L149:
        Context r18 = this.f4124a;
        String r19 = com.bytedance.crash.util.g.f4181a;
        cl.a.C(new File(com.bytedance.crash.util.g.h(r18), x8.a.g));
        r(true);
        return;
    L140:
        if (this.f == true) goto L149;
        if (com.bytedance.crash.p.f4084h == true) goto L149;
        if (com.bytedance.ies.bullet.base.utils.b.n(this.f4124a) == false) goto L148;
        t();
        goto L149
    L148:
        l9.o.e().c(this.f4127h, 5000);
        goto L149
    L131:
        r17 = r16.optString(r15[2]);     // Catch: Throwable -> L134
    L134:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L137
    L198:
        return;
    L13:
        if (this.e == null) goto L14;
        g0 r21 = com.bytedance.crash.p.f;
        if (((ListMap) r21.f210b).a(CrashType.NATIVE).size() <= 0) goto L54;
        Iterator r22 = this.e.values().iterator();
    L19:
        if (r22.hasNext() == false) goto L54;
        f r23 = (f) r22.next();
        if (r23 == null) goto L19;
        long r24 = SystemClock.uptimeMillis();
        if (r23.f4111c.isEmpty() == false) goto L25;
        io.reactivex.exceptions.a.c("notifyNativeCrashOnStart: mNativeCrashFile isEmpty, mStartUUID=" + r23.f4109a);
    L53:
        r23.f4122r = SystemClock.uptimeMillis() - r24;
        goto L19
    L25:
        s6.c r110 = new s6.c(r5);
        Iterator r111 = r23.f4111c.iterator();
    L27:
        if (r111.hasNext() == false) goto L53;
        e r25 = (e) r111.next();
        File r112 = r25.f4105a;
        io.reactivex.exceptions.a.c("notifyNativeCrashOnStart: dir=" + r112.getAbsolutePath());
        r110.f21828b = new i4.a(r112, 1);     // Catch: Throwable -> L38
        r112.getName();     // Catch: Throwable -> L38
        r110.m();     // Catch: Throwable -> L38
        r110.r();     // Catch: Throwable -> L38
        r110.o();     // Catch: Throwable -> L38
        w8.f r113 = (w8.f) ((i4.a) r110.f21828b).f17503c;     // Catch: Throwable -> L38
        HashMap r114 = (HashMap) r113.f22816a;     // Catch: Throwable -> L38
        if (r114 == null) goto L36;
        if (r114.isEmpty() == true) goto L36;
        String r115 = (String) ((HashMap) r113.f22816a).get("process_name");     // Catch: Throwable -> L38
    L36:
        if (com.bytedance.crash.n.f4062j.isEngMode() == false) goto L40;
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L38
        r116.add(r25.f4105a.getAbsolutePath());     // Catch: Throwable -> L38
        r116.add(com.bytedance.crash.util.g.c(this.f4124a, r25.f4108h).getAbsolutePath());     // Catch: Throwable -> L38
        r116.add(new File(com.bytedance.crash.util.g.b(com.bytedance.crash.n.f4057a), r25.f4108h).getAbsolutePath());     // Catch: Throwable -> L38
        b(r110);     // Catch: Throwable -> L38
        cl.a.x(r116);     // Catch: Throwable -> L38
    L40:
        g0 r26 = com.bytedance.crash.p.f;     // Catch: Throwable -> L38
        Iterator r117 = ((ListMap) r26.f210b).a(CrashType.NATIVE).iterator();     // Catch: Throwable -> L38
    L42:
        if (r117.hasNext() == false) goto L27;
        if (r117.next() != null) goto L51;
        io.reactivex.exceptions.a.c("notifyNativeCrashOnStart: begin");     // Catch: Throwable -> L48
        CrashType r27 = CrashType.LAUNCH;     // Catch: Throwable -> L48
        throw null;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L38
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L38
        goto L42
    L51:
        throw new ClassCastException();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L54:
        g0 r28 = com.bytedance.crash.p.f;
        List r29 = ((ListMap) r28.f210b).a(CrashType.LAUNCH);
        List r30 = ((ListMap) r28.f210b).a(CrashType.JAVA);
        if (r29.size() <= 0) goto L57;
    L60:
        Iterator r31 = this.e.values().iterator();
    L62:
        if (r31.hasNext() == false) goto L122;
        f r32 = (f) r31.next();
        if (r32 == null) goto L62;
        long r33 = SystemClock.uptimeMillis();
        if (r32.f4110b.isEmpty() == false) goto L69;
        io.reactivex.exceptions.a.c("notifyJavaCrashOnStart: mJavaCrashFiles isEmpty mStartUUID=" + r32.f4109a);
    L68:
        String r34 = r10;
        r32.f4121q = SystemClock.uptimeMillis() - r33;
        r10 = r34;
        goto L62
    L69:
        Iterator r118 = r32.f4110b.iterator();
    L71:
        if (r118.hasNext() == false) goto L68;
        e r35 = (e) r118.next();
        File r119 = r35.f4105a;     // Catch: Throwable -> L117
        CrashType r120 = r35.g;     // Catch: Throwable -> L117
        ym.p r36 = c(r119, r120, r32.f4109a, r35.f4106b, r35.f4107c);     // Catch: Throwable -> L90
        if (r36 == null) goto L76;
        JSONObject r37 = (JSONObject) r36.f23313c;     // Catch: Throwable -> L90
        if (r37 == null) goto L76;
        if (r37.optJSONObject("header") == null) goto L76;
        if (r120 != CrashType.LAUNCH) goto L87;
    L92:
        r37 = ((JSONArray) r37.opt("data")).optJSONObject(0);     // Catch: Throwable -> L90
        r37.optString("stack");     // Catch: Throwable -> L90
    L94:
        if (TextUtils.isEmpty(r32.f4116l) == false) goto L97;
        r37.optString("process_name");     // Catch: Throwable -> L90
    L97:
        if (com.bytedance.crash.n.f4062j.isEngMode() == false) goto L99;
        ArrayList r38 = new ArrayList();     // Catch: Throwable -> L90
        r38.add(r35.f4105a.getAbsolutePath());     // Catch: Throwable -> L90
        r38.add(com.bytedance.crash.util.g.c(this.f4124a, r32.f4109a).getAbsolutePath());     // Catch: Throwable -> L90
    L99:
        g0 r39 = com.bytedance.crash.p.f;     // Catch: Throwable -> L90
        Iterator r40 = ((ListMap) r39.f210b).a(r35.g).iterator();     // Catch: Throwable -> L90
    L101:
        if (r40.hasNext() == false) goto L76;
        if (r40.next() != null) goto L115;
        io.reactivex.exceptions.a.c("notifyJavaCrashOnStart: begin");     // Catch: Throwable -> L110
        String r41 = null;
        throw null;     // Catch: Throwable -> L108
    L108:
        th = th;
    L152:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L113
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L113
    L113:
        th = th;
    L119:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        r10 = r41;
    L110:
        th = th;
        r41 = null;
        goto L152
    L115:
        r41 = null;
        throw new ClassCastException();     // Catch: Throwable -> L113
    L87:
        if ((r37.opt("data") instanceof JSONArray) == true) goto L92;
        r37.optString("data");     // Catch: Throwable -> L90
    L76:
        r10 = null;
    L90:
        th = th;
        r41 = null;
    L117:
        th = th;
        r41 = r10;
        goto L119
    L122:
        r14 = r10;
        boolean r42 = true;
    L123:
        this.g = r42;
        goto L125
    L57:
        if (r30.size() > 0) goto L60;
        r42 = true;
        r14 = null;
        goto L123
    }

    public final void n() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (ym.m.q(com.bytedance.crash.n.f4057a) == false) goto L13;
        l9.o.e().b(this.f4128i);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public final void p(HashMap r5) {
        String r10 = com.bytedance.crash.util.g.f4181a;
        File[] r11 = new File(com.bytedance.crash.util.g.h(this.f4124a), x8.a.f).listFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length == 0) goto L38;
        int r12 = 0;
    L9:
        if (r12 >= r11.length) goto L39;
        File r13 = r11[r12];
        if (r13.getName().equals("asdawd") == false) goto L15;
    L27:
        r12 = r12 + 1;
        goto L9
    L15:
        if (r13.isDirectory() == true) goto L20;
        cl.a.C(r13);     // Catch: Throwable -> L17
        goto L27
    L20:
        if (r13.getName().endsWith("G") == false) goto L24;
        String r14 = r13.getName();     // Catch: Throwable -> L17
        if (((f) r5.get(r14)) != null) goto L27;
        r5.put(r14, new f(r14));     // Catch: Throwable -> L17
        goto L27
    L24:
        cl.a.C(r13);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r13);
        goto L27
    L39:
        return;
    }

    public final void r(boolean r13) {
        File r5 = com.bytedance.crash.util.g.d;
        Context r10 = this.f4124a;
        if (r5 != null) goto L8;
        if (r10 != null) goto L6;
        Context r11 = com.bytedance.crash.n.f4057a;
    L7:
        com.bytedance.crash.util.g.d = new File(com.bytedance.crash.util.g.h(r11), x8.a.f22987j);
        goto L8
    L6:
        r11 = r10;
    L8:
        File[] r12 = com.bytedance.crash.util.g.d.listFiles();
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.length == 0) goto L70;
        s6.c r14 = new s6.c(false);
        ArrayList r15 = new ArrayList();
        if (com.bytedance.crash.util.g.d != null) goto L19;
        if (r10 != null) goto L17;
        Context r16 = com.bytedance.crash.n.f4057a;
    L18:
        com.bytedance.crash.util.g.d = new File(com.bytedance.crash.util.g.h(r16), x8.a.f22987j);
        goto L19
    L17:
        r16 = r10;
    L19:
        i(com.bytedance.crash.util.g.d, r15);
        File[] r17 = com.bytedance.crash.util.g.g(r10).listFiles();
        int r18 = 0;
        if (r17.length == 0) goto L55;
        int r19 = 0;
    L23:
        if (r19 >= r17.length) goto L71;
        if (r19 >= 5) goto L72;
        ArrayList r20 = this.f4125b;
        r20.addAll(r15);
        if (r20.isEmpty() == true) goto L53;
        ArrayList r21 = new ArrayList();
        o(com.bytedance.crash.util.g.g(r10), r21);
        if (r21.size() != 0) goto L35;
        int r22 = 0;
    L32:
        if (r22 >= r20.size()) goto L53;
        l(r14, (File) r20.get(r22), com.bytedance.crash.util.g.g(r10), r13);
        r22 = r22 + 1;
        goto L32
    L35:
        if (r21.size() <= 0) goto L53;
        int r23 = 0;
    L38:
        if (r23 >= r20.size()) goto L48;
        int r24 = 0;
    L41:
        if (r24 >= r21.size()) goto L46;
        if (((String) r21.get(r24)).equals(((File) r20.get(r23)).getName()) == false) goto L45;
        r20.remove(r23);
    L45:
        r24 = r24 + 1;
        goto L41
    L46:
        r23 = r23 + 1;
        goto L38
    L48:
        if (r20.size() <= 0) goto L53;
        int r25 = 0;
    L51:
        if (r25 >= r20.size()) goto L53;
        l(r14, (File) r20.get(r25), com.bytedance.crash.util.g.g(r10), r13);
        r25 = r25 + 1;
    L53:
        r19 = r19 + 1;
        goto L23
    L72:
        return;
    L71:
        return;
    L55:
        if (r18 >= r15.size()) goto L73;
        l(r14, (File) r15.get(r18), com.bytedance.crash.util.g.g(r10), r13);
        r18 = r18 + 1;
        goto L55
    L73:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v74 */
    /* JADX WARN: Type inference failed for: r4v75 */
    public final void t() {
        boolean r5 = false;
        ?? r10 = 1;
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e != null) goto L8;
        return;
    L8:
        if (com.bytedance.crash.p.f4084h == false) goto L11;
        return;
    L11:
        if (com.bytedance.ies.bullet.base.utils.b.n(this.f4124a) == true) goto L14;
        u();
    L14:
        if (this.f4126c != (-1)) goto L25;
        ConcurrentLinkedQueue r11 = l9.c.f19554a;
        if (com.bytedance.crash.p.f4081a == true) goto L18;
    L23:
        this.f4126c = 0;
        goto L25
    L18:
        if (l9.c.e() == null) goto L23;
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "upload_crash_crash"}) != 1) goto L22;
        this.f4126c = 1;
        goto L25
    L22:
        this.f4126c = 0;
    L25:
        if (this.f4126c != 1) goto L27;
        boolean r12 = true;
    L28:
        Iterator r13 = this.e.values().iterator();
    L30:
        if (r13.hasNext() == false) goto L64;
        f r14 = (f) r13.next();
        if (r14.f4109a.startsWith("anr") == true) goto L40;
        String r15 = r14.f4109a;
        if (r14.f4111c.isEmpty() == false) goto L37;
        String r16 = null;
    L38:
        i9.c r17 = av.i.f(r15, r16);
        r14.f4120p = r17;
        r14.g = r17.e;
        goto L40
    L37:
        r16 = ((e) r14.f4111c.get(0)).f4105a.getAbsolutePath();
    L40:
        if (r14.f4109a.startsWith("anr") == true) goto L30;
        File r18 = com.bytedance.crash.util.g.c(com.bytedance.crash.n.f4057a, r14.f4109a);
        File r19 = new File(r18, "external_files");
        if (r19.exists() == false) goto L30;
        JSONArray r20 = cl.a.F(r19.getAbsolutePath());     // Catch: IOException -> L317
        if (r20 == null) goto L30;
        int r21 = 0;
    L50:
        if (r21 >= r20.length()) goto L30;
        String r22 = r20.optString(r21);     // Catch: IOException -> L317
        if (TextUtils.isEmpty(r22) == true) goto L63;
        File r110 = new File(r22);     // Catch: IOException -> L317
        if (r110.exists() == false) goto L63;
        File r23 = new File(r18, r110.getName());     // Catch: IOException -> L317
        if (r23.exists() == true) goto L63;
        if (r110.length() >= mh.e.c(l9.c.e(), 1048576, new String[]{"custom_event_settings", "npth_simple_setting", "crash_file_size_limit"})) goto L63;
        cl.a.l(r110, r23, false, Integer.MAX_VALUE);     // Catch: IOException -> L317
    L63:
        r21 = r21 + 1;
        goto L50
    L64:
        this.d = 0;
        if (l9.g.f == null) goto L67;
    L77:
        l9.g r24 = l9.g.f;
        Iterator r25 = this.e.values().iterator();
    L79:
        if (r25.hasNext() == false) goto L299;
        f r26 = (f) r25.next();
        if (r26.f4111c.size() > r10) goto L86;
        if (r26.f4111c.isEmpty() == false) goto L86;
        r26.e = r26.d;
    L86:
        boolean r111 = com.bytedance.ies.bullet.base.utils.b.n(this.f4124a);
        com.bytedance.ies.bullet.base.utils.b.c(this.f4124a);
        r26.e = r26.d;
        s6.c r112 = new s6.c(9, r5);
        Iterator r113 = r26.f4111c.iterator();
    L88:
        if (r113.hasNext() == false) goto L298;
        e r114 = (e) r113.next();
        File r115 = r114.f4105a;
        r112.f21828b = new i4.a(r115, r10 == true ? 1 : 0);     // Catch: Throwable -> L292
        r115.getName();     // Catch: Throwable -> L292
        JSONObject r116 = b(r112);     // Catch: Throwable -> L292
        if (r116 == null) goto L94;
        if (r116.length() == 0) goto L94;
        if (r116.length() == 0) goto L88;
        Iterator r27 = r25;
        long r28 = r116.optLong("crash_time");     // Catch: Throwable -> L102
        r114.f4106b = r28;     // Catch: Throwable -> L102
        if (TextUtils.isEmpty(r26.f4116l) == false) goto L105;
        r26.f4116l = r116.optString("process_name");     // Catch: Throwable -> L102
    L105:
        if (r12 == true) goto L116;
        e r29 = r26.e;     // Catch: Throwable -> L102
        if (r29 != null) goto L109;
        boolean r210 = r12;
    L118:
        r26.e = r114;     // Catch: Throwable -> L114
    L119:
        if (r24 == null) goto L126;
        if (r24.e() == true) goto L126;
        r112.z();     // Catch: Throwable -> L114
        r114.d = r10;     // Catch: Throwable -> L114
        r25 = r27;
        r12 = r210;
        ?? r30 = r10;
    L123:
        r10 = r30;
    L126:
        if (com.bytedance.crash.util.g.c(com.bytedance.crash.n.f4057a, r26.f4109a).exists() == true) goto L128;
        r26.f4119o = r10;     // Catch: Throwable -> L114
    L128:
        r26.f = r10;     // Catch: Throwable -> L114
        int r31 = r116.optInt(LynxMonitorService.KEY_PID, -1);     // Catch: Throwable -> L114
        int r32 = r116.optInt("start_pid", -1);     // Catch: Throwable -> L114
        if (r31 == (-1)) goto L154;
        if (r32 == (-1)) goto L154;
        if (r31 == r32) goto L135;
        boolean r117 = r10 == true ? 1 : 0;
    L330:
        z8.c.l(r116, "filters", "fork_crash", String.valueOf(r117));     // Catch: Throwable -> L146
        if (r31 == r32) goto L156;
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_upload_fork_crash"}) == 1) goto L156;
        JSONObject r33 = r116.optJSONObject("header");     // Catch: Throwable -> L146
        if (r33 == null) goto L156;
        z8.c.l(r116, "filters", WsConstants.KEY_APP_ID, String.valueOf(r33.opt(WsConstants.KEY_APP_ID)));     // Catch: Throwable -> L146
        r33.put(WsConstants.KEY_APP_ID, 2021212121);     // Catch: Throwable -> L146
        r26.f = false;     // Catch: Throwable -> L146
        if (r26.e != r114) goto L152;
        r26.e = null;     // Catch: Throwable -> L146
    L152:
        if (l9.c.c(l9.n.a(), "enable_fork_crash") == true) goto L156;
        cl.a.C(r115);     // Catch: Throwable -> L146
        Iterator r211 = r113;
        ?? r34 = 1;
    L289:
        r25 = r27;
        r12 = r210;
        r113 = r211;
        r30 = r34;
    L156:
        if (r114.f == true) goto L159;
        int r35 = this.d;     // Catch: Throwable -> L146
        if (r35 >= 5) goto L159;
        this.d = r35 + 1;     // Catch: Throwable -> L146
        File r36 = new File(r115, "has_kill_info");     // Catch: Throwable -> L146
        if (r36.exists() == true) goto L324;
    L165:
        String r37 = null;
    L166:
        File r38 = new File(r115, "has_exit_info");     // Catch: Throwable -> L146
        z8.c.l(r116, "filters", "start_uuid", r26.f4109a);     // Catch: Throwable -> L146
        r211 = r113;
        z8.c.l(r116, "filters", "crash_thread_name", r116.optString("crash_thread_name", "unknown"));     // Catch: Throwable -> L173
        if ("true".equals(null) == false) goto L175;
        z8.c.l(r116, "filters", "coredump_bytest", "true");     // Catch: Throwable -> L173
    L177:
        if (r37 == null) goto L179;
        boolean r39 = true;
    L180:
        z8.c.l(r116, "filters", "has_kill_info", String.valueOf(r39));     // Catch: Throwable -> L173
        z8.c.l(r116, "filters", "has_exit_info", String.valueOf(r38.exists()));     // Catch: Throwable -> L173
        r26.a(r116);     // Catch: Throwable -> L173
        String r40 = zm.p.b(r26.f4114j, r114.f4106b);     // Catch: Throwable -> L173
        if (r40 == null) goto L184;
        z8.c.l(r116, "custom", "exit_info", r40);     // Catch: Throwable -> L173
        z5.a.d(r40, r116);     // Catch: Throwable -> L173
    L184:
        if (r26.f4112h < 0) goto L192;
        String r41 = r116.optJSONObject("filters").optString("alog_inited");     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r41) == true) goto L192;
        if ("true".equals(r41) == false) goto L190;
        int r42 = 1;
    L191:
        r26.f4112h = r42;     // Catch: Throwable -> L173
        goto L192
    L190:
        r42 = -1;
    L192:
        Object r43 = String.valueOf(r26.f4122r);     // Catch: Throwable -> L173
        z8.c.l(r116, "custom", "notify_ne_cost", r43);     // Catch: Throwable -> L173
        if (r111 == true) goto L352;
        JSONObject r44 = r116;
        r43 = r115;
        r26.f4117m = true;     // Catch: Throwable -> L256
        Object r45 = r43;
    L265:
        CrashType r46 = CrashType.NATIVE;     // Catch: Throwable -> L256
        ConcurrentLinkedQueue r47 = h.f4130a;     // Catch: Throwable -> L256
        h.f4131b.add(new uj.a(r44, r46));     // Catch: Throwable -> L256
        ConcurrentLinkedQueue r48 = h.f4130a;     // Catch: Throwable -> L256
        if (r48 != null) goto L268;
    L269:
        r25 = r27;
        r12 = r210;
        r113 = r211;
        r10 = 1;
        goto L88
    L268:
        if (r48.isEmpty() == true) goto L269;
        Iterator r49 = r48.iterator();     // Catch: Throwable -> L256
    L272:
        if (r49.hasNext() == false) goto L269;
        if (r49.next() != null) goto L280;
        throw null;     // Catch: Throwable -> L318
    L280:
        throw new ClassCastException();     // Catch: Throwable -> L281
    L281:
        th = th;
    L150:
        ?? r50 = 1;
        ?? r51 = r45;
    L297:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        cl.a.C(r51);
        r34 = r50;
    L256:
        th = th;
        r45 = r43;
        goto L150
    L352:
        if (z5.a.f(r26.f4109a) == false) goto L207;
        r116.put("coredump_ver", 1);     // Catch: Throwable -> L319
        r116.put("core_dump_uuid", r26.f4109a);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "may_have_core_dump", "true");     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_real_size", z5.a.b());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_zip_size", z5.a.i());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_size_range", z5.a.h());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_delete", z5.a.f23400h);     // Catch: Throwable -> L319
        if (z5.a.d.exists() == true) goto L199;
    L201:
        long r118 = 0;
    L203:
        if (r118 <= 0) goto L205;
        boolean r52 = true;
    L206:
        z8.c.l(r116, "filters", "has_coredump_config", Boolean.valueOf(r52));     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_status", z5.a.f23401i);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_time_spent", z5.a.f23402j);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_mode", z5.a.f23403k);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_network_type", z5.a.f23405m);     // Catch: Throwable -> L319
        goto L220
    L205:
        r52 = false;
        goto L206
    L199:
        if (z5.a.d.length() <= 0) goto L201;
        r118 = z5.a.d.length();     // Catch: Throwable -> L319
        goto L203
    L207:
        r116.put("coredump_ver", 0);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "may_have_core_dump", "false");     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_delete", z5.a.f23400h);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_network_type", z5.a.f23405m);     // Catch: Throwable -> L319
        if (z5.a.d.exists() == true) goto L210;
    L212:
        long r119 = 0;
    L214:
        if (r119 <= 0) goto L216;
        boolean r53 = true;
    L217:
        z8.c.l(r116, "filters", "has_coredump_config", Boolean.valueOf(r53));     // Catch: Throwable -> L319
        if ("0".equals(z5.a.b()) == true) goto L220;
        z8.c.l(r116, "filters", "coredump_real_size", z5.a.b());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_zip_size", z5.a.i());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_size_range", z5.a.h());     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_status", z5.a.f23401i);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_time_spent", z5.a.f23402j);     // Catch: Throwable -> L319
        z8.c.l(r116, "filters", "coredump_mode", z5.a.f23403k);     // Catch: Throwable -> L319
        goto L220
    L216:
        r53 = false;
        goto L217
    L210:
        if (z5.a.d.length() <= 0) goto L212;
        r119 = z5.a.d.length();     // Catch: Throwable -> L319
    L220:
        File r54 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22994q);     // Catch: Throwable -> L173
        if (r54.exists() == false) goto L223;
        z8.c.l(r116, "filters", "coredump_send_cfg_valid", "true");     // Catch: Throwable -> L173
        r54.length();     // Catch: Throwable -> L173
        b.s();     // Catch: Throwable -> L173
        z8.c.l(r116, "filters", "coredump_cfg_update", "upload config");     // Catch: Throwable -> L173
    L224:
        r112.g(r116);     // Catch: Throwable -> L173
        if (CrashType.NATIVE != CrashType.LAUNCH) goto L228;
        JSONObject r55 = ((JSONArray) r116.opt("data")).optJSONObject(0);     // Catch: Throwable -> L262
    L229:
        r116.optJSONObject("header");     // Catch: Throwable -> L262
        com.bytedance.ies.argus.bean.b r56 = com.bytedance.ies.argus.bean.b.a();     // Catch: Throwable -> L173
        String r57 = r37;
        if (r55.optInt("app_start_time", -1) != (-1)) goto L233;
        long r58 = System.currentTimeMillis();     // Catch: Throwable -> L173
    L234:
        r56.d(r58);     // Catch: Throwable -> L173
        File r59 = new File(r115, "minidump");     // Catch: Throwable -> L173
        z8.c.l(r116, "filters", "has_minidump", String.valueOf(r59.exists()));     // Catch: Throwable -> L173
    L239:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L173
        m.b.h("fix activity trace", th);     // Catch: Throwable -> L173
    L241:
        sj.k r60 = sj.k.g();     // Catch: Throwable -> L173
        if (r59.exists() == true) goto L245;
        r59 = null;
    L245:
        File r120 = com.bytedance.crash.util.g.c(this.f4124a, r26.f4109a);     // Catch: Throwable -> L173
        if (TextUtils.isEmpty(r57) == false) goto L248;
        File r121 = null;
    L249:
        r60.getClass();     // Catch: Throwable -> L173
        r44 = r116;
        File r61 = r115;
        t r62 = sj.k.f(r44, r59, r61, r120, r121, r28);     // Catch: Throwable -> L256
        if (r62.c() == true) goto L254;
        r26.s = true;     // Catch: Throwable -> L256
        r45 = r61;
        goto L265
    L254:
        if (r112.z() == true) goto L258;
        cl.a.G(r61);     // Catch: Throwable -> L256
    L258:
        r45 = r61;
        if (r62.b() == false) goto L265;
        r114.f = true;     // Catch: Throwable -> L256
        r112.m();     // Catch: Throwable -> L256
        e(0, CrashType.NATIVE);     // Catch: Throwable -> L256
        r45 = r61;
        goto L265
    L248:
        r121 = new File(r57);     // Catch: Throwable -> L173
        goto L249
    L236:
        if (r116.has("activity_trace") == true) goto L241;
        int r63 = r116.optInt(LynxMonitorService.KEY_PID);     // Catch: Throwable -> L239
        r116.put("activity_trace", com.bytedance.android.anniex.base.service.e.j(r116.optLong("app_start_time"), r116.optString("process_name"), r28, String.valueOf(r63)));     // Catch: Throwable -> L239
    L233:
        r58 = r55.optInt("app_start_time", -1);     // Catch: Throwable -> L173
        goto L234
    L228:
        r55 = r116;
    L262:
        th = th;
    L148:
        r45 = r115;
        goto L150
    L223:
        z8.c.l(r116, "filters", "coredump_cfg_update", "config not exist");     // Catch: Throwable -> L173
        z8.c.l(r116, "filters", "coredump_send_cfg_valid", "false");     // Catch: Throwable -> L173
        b.s();     // Catch: Throwable -> L173
        goto L224
    L179:
        r39 = false;
        goto L180
    L175:
        z8.c.l(r116, "filters", "coredump_bytest", "false");     // Catch: Throwable -> L173
    L283:
        th = th;
        r45 = r115;
    L173:
        th = th;
        goto L148
    L324:
        r37 = cl.a.c(-1, r36, "\n");     // Catch: Throwable -> L146 IOException -> L320
    L159:
        r211 = r113;
        r45 = r115;
        r50 = 1;
        r114.f = true;     // Catch: Throwable -> L290
        cl.a.C(r114.f4105a);     // Catch: Throwable -> L281
        r112.m();     // Catch: Throwable -> L281
        r112.r();     // Catch: Throwable -> L281
        r34 = 1;
        e(1, CrashType.NATIVE);     // Catch: Throwable -> L290
    L290:
        th = th;
        r51 = r45;
    L146:
        th = th;
        r211 = r113;
        goto L148
    L135:
        r117 = false;
    L154:
        z8.c.l(r116, "filters", "fork_crash", "false");     // Catch: Throwable -> L146
        goto L156
    L109:
        if (r26.f == true) goto L116;
        r210 = r12;
        if (r28 >= r29.f4106b) goto L119;
    L114:
        th = th;
    L104:
        r211 = r113;
        r51 = r115;
        r50 = r10;
    L116:
        r210 = r12;
    L102:
        th = th;
        r210 = r12;
    L94:
        r210 = r12;
        r27 = r25;
        r211 = r113;
        r112.z();     // Catch: Throwable -> L290
        r34 = r10;
    L292:
        th = th;
        r210 = r12;
        r27 = r25;
        goto L104
    L298:
        r5 = false;
        goto L79
    L299:
        boolean r64 = r5;
        boolean r212 = r12;
        this.d = r64 ? 1 : 0;
        Iterator r65 = this.e.values().iterator();
    L301:
        if (r65.hasNext() == false) goto L303;
        f((f) r65.next(), r212, r24);
        goto L301
    L303:
        this.d = r64 ? 1 : 0;
        HashMap r66 = (HashMap) r24.e;
        Long r67 = (Long) r66.remove("time");
        if (r67 != null) goto L306;
        m.b r68 = com.bytedance.crash.c.f4025a;
        RuntimeException r69 = new RuntimeException("err times, no time");
        r68.getClass();
        m.b.h("NPTH_CATCH", r69);
    L315:
        u();
        this.f4129j.run();
        return;
    L306:
        StringBuilder r70 = new StringBuilder();
        r70.append(r67);
        r70.append('\n');
        Iterator r71 = r66.entrySet().iterator();
    L308:
        if (r71.hasNext() == false) goto L326;
        Map.Entry r72 = (Map.Entry) r71.next();
        r70.append((String) r72.getKey());
        r70.append(' ');
        r70.append(r72.getValue());
        r70.append('\n');
        goto L308
    L326:
        File r73 = new File(com.bytedance.crash.util.g.h((Context) r24.d), "realIssueCrashTimes");     // Catch: IOException -> L321
        if (r73.mkdirs() == true) goto L313;
        r73.mkdirs();     // Catch: IOException -> L321
    L313:
        cl.a.u(r70.toString(), new File(r73, "crash.times"), false);     // Catch: IOException -> L321
    L314:
        r66.put("time", r67);
        goto L315
    L67:
        monitor-enter(l9.g.class);
    L71:
        th = move-exception;
        throw th;
    L69:
        if (l9.g.f != null) goto L73;
        l9.g.f = new l9.g(com.bytedance.crash.n.f4057a);     // Catch: Throwable -> L71
    L73:
        monitor-exit(l9.g.class);     // Catch: Throwable -> L71
        goto L77
    L27:
        r12 = false;
        goto L28
    }

    public final void u() {
        this.f = true;
        NativeImpl.n();
        ConcurrentLinkedQueue r5 = h.f4130a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L24;
        Iterator r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L25;
        if (r10.next() != null) goto L16;
        throw null;     // Catch: Throwable -> L18
    L16:
        throw new ClassCastException();
    L25:
        return;
    }
}
