package com.bytedance.crash.heaptracker;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import cl.a;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.e;
import com.lynx.tasm.utils.g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import m.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z8.c;
import z8.d;

/* JADX INFO: loaded from: classes2.dex */
public class NativeHeapTracker {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f4041l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f4042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f4043n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f4044o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4047c;
    public final int d;
    public final int e;
    public final File f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f4051k;

    public NativeHeapTracker(JSONArray r5, String r10, File r11, Context r12) {
        this.f4049i = false;
        this.f4050j = false;
        if (r5 != null) goto L5;
    L7:
        this.f4047c = 350;
        this.d = 650;
        this.e = 60;
        this.f4049i = false;
        this.f4050j = true;
    L8:
        this.f4045a = 0;
        this.f4046b = false;
        f4042m = false;
        this.f4051k = r12;
        this.f = r11;
        this.g = g.d("/", r10, ".guard");
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        this.e = r5.optInt(0);
        this.f4047c = r5.optInt(1);
        this.d = r5.optInt(2);
        this.f4049i = r5.optBoolean(3);
        this.f4050j = r5.optBoolean(4);
        goto L8
    }

    public static int a(JSONArray r5, int r10, String r11) {
    L3:
        if (r10 >= r5.length()) goto L10;
        String r12 = r5.optString(r10, null);
        if (r12 == null) goto L9;
        if (r12.startsWith(r11) == false) goto L9;
        return r10;
    L9:
        r10 = r10 + 1;
        goto L3
    L10:
        return -1;
    }

    public static /* synthetic */ long b() {
        return nativeGetHeapSize();
    }

    public static String c(String r5) {
        long r10 = Long.decode(r5.substring(0, r5.indexOf("MB"))).longValue();
        if (r10 < 1) goto L9;
        if (r10 > 100) goto L9;
        return "1MB~100MB";
    L9:
        if (r10 <= 100) goto L15;
        if (r10 > 250) goto L15;
        return "100MB~250MB";
    L15:
        if (r10 <= 250) goto L21;
        if (r10 > 350) goto L21;
        return "250MB~350MB";
    L21:
        if (r10 <= 350) goto L27;
        if (r10 > 450) goto L27;
        return "350MB~450MB";
    L27:
        if (r10 <= 450) goto L33;
        if (r10 > 550) goto L33;
        return "450MB~550MB";
    L33:
        if (r10 <= 550) goto L39;
        if (r10 > 650) goto L39;
        return "550MB~650MB";
    L39:
        if (r10 <= 650) goto L45;
        if (r10 > 750) goto L45;
        return "650MB~750MB";
    L45:
        if (r10 <= 750) goto L51;
        if (r10 > 850) goto L51;
        return "750MB~850MB";
    L51:
        if (r10 <= 850) goto L57;
        if (r10 > 950) goto L57;
        return "850MB~950MB";
    L57:
        if (r10 <= 950) goto L63;
        if (r10 > 1050) goto L63;
        return "950MB~1050MB";
    L63:
        if (r10 <= 1050) goto L69;
        if (r10 > 1250) goto L69;
        return "1050MB~1250MB";
    L69:
        if (r10 <= 1250) goto L75;
        if (r10 > 1450) goto L75;
        return "1250MB~1450MB";
    L75:
        if (r10 <= 1450) goto L81;
        if (r10 > 1650) goto L81;
        return "1450MB~1650MB";
    L81:
        if (r10 <= 1650) goto L87;
        if (r10 > 1850) goto L87;
        return "1650MB~1850MB";
    L87:
        if (r10 > 1850) goto L89;
        return ">2.3G";
    L89:
        if (r10 > 2050) goto L94;
        return "1850MB~2050MB";
    L94:
        return ">2.3G";
    }

    public static void d(NativeHeapTracker r5) {
        if (r5.f4050j == false) goto L5;
        e.g("waitNative");
    L5:
        int r10 = nativeDoCommnad(2);
        if (r10 == 0) goto L9;
        e.g("waitNative ret=" + r10);
        r5.f4046b = true;
        return;
    }

    public static void e(File r19) {
        String r10 = "pid:";
        File r11 = new File(r19, "tombstone.txt");
        c r12 = new c();
        JSONArray r13 = a.F(r11.getAbsolutePath());     // Catch: Throwable -> L7 IOException -> L9
        if (r13 != null) goto L10;
        a.C(r19);     // Catch: Throwable -> L7 IOException -> L9
        return;
    L10:
        int r14 = a(r13, 0, "pid:");     // Catch: Throwable -> L7 IOException -> L9
        if (r14 >= 0) goto L14;
        a.C(r19);     // Catch: Throwable -> L7 IOException -> L9
        return;
    L14:
        String[] r15 = r13.optString(r14, null).trim().split("\\s");     // Catch: Throwable -> L7 IOException -> L9
        int r16 = 0;
        String r17 = null;
    L15:
        int r18 = r15.length;     // Catch: Throwable -> L7 IOException -> L9
        JSONObject r110 = r12.f23416a;
        if (r16 >= r18) goto L36;
        String r111 = r15[r16];     // Catch: Throwable -> L31 IOException -> L33
        if (r10.equals(r111) == false) goto L22;
        String r5 = r15[r16 + 1];     // Catch: Throwable -> L7 IOException -> L9
        String r112 = r10;
        String r113 = r17;
        mh.e.g(Long.decode(r5.substring(0, r5.length() - 1)), LynxMonitorService.KEY_PID, r110);     // Catch: Throwable -> L7 IOException -> L9
    L34:
        r17 = r113;
    L35:
        r16 = r16 + 1;     // Catch: Throwable -> L31 IOException -> L33
        r10 = r112;
        goto L15
    L22:
        r112 = r10;
        r113 = r17;
        if ("tid:".equals(r111) == false) goto L28;
        String r114 = r15[r16 + 1];     // Catch: Throwable -> L7 IOException -> L9
        mh.e.g(Long.decode(r114.substring(0, r114.length() - 1)), "tid", r110);     // Catch: Throwable -> L7 IOException -> L9
        goto L34
    L28:
        if ("name:".equals(r111) == false) goto L34;
        int r115 = r16 + 1;     // Catch: Throwable -> L31 IOException -> L33
        String r116 = r15[r115];     // Catch: Throwable -> L31 IOException -> L33
        mh.e.g(r116.substring(0, r116.length() - 1), "crash_thread_name", r110);     // Catch: Throwable -> L31 IOException -> L33
        String r20 = r15[r115];     // Catch: Throwable -> L31 IOException -> L33
        r17 = r20.substring(0, r20.length() - 1);     // Catch: Throwable -> L31 IOException -> L33
    L31:
        th = th;
    L117:
        com.bytedance.crash.c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        a.C(r19);
        return;
    L36:
        String r117 = r17;
        mh.e.g(r15[r15.length - 2], "process_name", r110);     // Catch: Throwable -> L31 IOException -> L33
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L31 IOException -> L33
        int r22 = a(r13, r14 + 1, "Signal ");     // Catch: Throwable -> L31 IOException -> L33
        if (r22 >= 0) goto L40;
        a.C(r19);     // Catch: Throwable -> L31 IOException -> L33
        return;
    L40:
        r21.append(r13.optString(r22, null));     // Catch: Throwable -> L31 IOException -> L33
        r21.append('\n');     // Catch: Throwable -> L31 IOException -> L33
        int r23 = a(r13, r22 + 1, "Abort message:");     // Catch: Throwable -> L31 IOException -> L33
        if (r23 >= 0) goto L44;
        a.C(r19);     // Catch: Throwable -> L31 IOException -> L33
        return;
    L44:
        String r24 = r13.optString(r23, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L31 IOException -> L33
        r21.append(r24);     // Catch: Throwable -> L31 IOException -> L33
        r21.append('\n');     // Catch: Throwable -> L31 IOException -> L33
    L55:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L31 IOException -> L33
        b.h("NPTH_CATCH", th);     // Catch: Throwable -> L31 IOException -> L33
    L57:
        int r25 = a(r13, r23 + 1, "backtrace:");     // Catch: Throwable -> L31 IOException -> L33
        if (r25 >= 0) goto L60;
        a.C(r19);     // Catch: Throwable -> L31 IOException -> L33
        return;
    L60:
        r25 = r25 + 1;     // Catch: Throwable -> L31 IOException -> L33
        if (r25 >= r13.length()) goto L65;
        String r26 = r13.optString(r25, null);     // Catch: Throwable -> L31 IOException -> L33
        if (r26.startsWith("    #") == false) goto L65;
        r21.append(r26.trim());     // Catch: Throwable -> L31 IOException -> L33
        r21.append('\n');     // Catch: Throwable -> L31 IOException -> L33
    L65:
        String r27 = r21.toString();     // Catch: Throwable -> L31 IOException -> L33
        int r28 = a(r13, r25, "build id:");     // Catch: Throwable -> L31 IOException -> L33
        if (r28 <= 0) goto L77;
        JSONArray r29 = new JSONArray();     // Catch: Throwable -> L31 IOException -> L33
    L68:
        r28 = r28 + 1;     // Catch: Throwable -> L31 IOException -> L33
        if (r28 >= r13.length()) goto L76;
        String r118 = r13.optString(r28, null);     // Catch: Throwable -> L31 IOException -> L33
        if (r118.startsWith("    /") == false) goto L68;
        String[] r119 = r118.trim().split("\\s");     // Catch: Throwable -> L31 IOException -> L33
        if (r119.length < 3) goto L68;
        String r120 = r119[0];     // Catch: Throwable -> L31 IOException -> L33
        r29.put(new JSONObject().put("lib_name", r120.substring(r120.lastIndexOf(47) + 1)).put("lib_uuid", h(r119[r119.length - 1].substring(0, r119[r119.length - 1].length() - 1))));     // Catch: Throwable -> L31 IOException -> L33
        goto L68
    L76:
        mh.e.g(r29, "crash_lib_uuid", r110);     // Catch: Throwable -> L31 IOException -> L33
    L77:
        mh.e.g(r21.toString(), "data", r110);     // Catch: Throwable -> L31 IOException -> L33
        Context r30 = n.f4057a;
        Header r31 = Header.f();
        JSONObject r32 = r31.f4029a;
        r32.put(WsConstants.KEY_APP_ID, 4444);     // Catch: JSONException -> L121
    L80:
        mh.e.g(r32, "header", r110);
        r12.f23417b = r31;
        mh.e.g(1, "is_native_crash", r110);
        mh.e.g(Long.valueOf(System.currentTimeMillis()), "crash_time", r110);
        c.l(r12.b(), "filters", "native_oom_app", n.f4057a.getPackageName());
        String r33 = "true";
        c.l(r12.b(), "filters", "has_native_oom", "true");
        String r34 = f4043n;
        if (r34 != null) goto L83;
    L125:
        File r121 = r19;
        f.h(new BufferedWriter(new FileWriter(new File(r121, "tombstone.txt").getAbsolutePath(), true)));     // Catch: Throwable -> L122
    L96:
        f(r12, r121);     // Catch: Throwable -> L122
        goto L99
    L92:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L122
    L90:
        th = move-exception;
        throw th;     // Catch: Throwable -> L122
    L99:
        if (r27 == null) goto L112;
        if (r117 == null) goto L112;
        if (r24 == null) goto L112;
    L115:
        a.C(r19);
        return;
    L103:
        if (f4043n == null) goto L112;
        if (f4044o == null) goto L112;
        z8.f r35 = z8.f.r(null, r27, r24, r117);     // Catch: Throwable -> L115
        c.l(r35.b(), "filters", "native_oom_size", f4044o);     // Catch: Throwable -> L115
        c.l(r35.b(), "filters", "native_oom_lib", f4043n);     // Catch: Throwable -> L115
        if (f4042m == true) goto L110;
        r33 = "false";
    L110:
        c.l(r35.b(), "filters", "has_native_oom", r33);     // Catch: Throwable -> L115
        com.bytedance.crash.upload.n.d(r35, d.f23419b, System.currentTimeMillis(), r121);     // Catch: Throwable -> L115
    L112:
        if (com.bytedance.crash.upload.b.a("unknown_old", n.f4062j.getNativeCrashUploadUrl(), r110.toString(), null, new c5.a[]{new c5.a(new File[]{r121, null}, true)}).c() == false) goto L147;
        a.C(r19);     // Catch: Throwable -> L115
        return;
    L147:
        return;
    L98:
        r121 = r19;
        goto L99
    L83:
        if (f4044o == null) goto L125;
        c.l(r12.b(), "filters", "native_oom_lib", r34);
        c.l(r12.b(), "filters", "native_oom_size", f4044o);
        f4042m = true;
        goto L125
    L46:
        if (f4043n != null) goto L57;
        if (f4044o != null) goto L57;
        if (r24.startsWith("abort message:") == false) goto L57;
        String[] r36 = r24.trim().split(":");     // Catch: Throwable -> L55
        String[] r37 = r36[2].trim().split(",");     // Catch: Throwable -> L55
        if (r36.length < 4) goto L57;
        f4043n = r36[1];     // Catch: Throwable -> L55
        f4044o = c(r37[0]);     // Catch: Throwable -> L55
    L7:
        th = th;
    L119:
        a.C(r19);
    }

    public static void f(c r10, File r11) {
        File r5 = new File(r11, "logcat.txt");
        if (r5.exists() == false) goto L34;
        JSONArray r12 = new JSONArray();
        BufferedReader r13 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L17
    L10:
        th = th;
    L30:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L23
        b.h("NPTH_CATCH", th);     // Catch: Throwable -> L23
        f.h(r13);
    L21:
        mh.e.g(r12, "logcat", r10.f23416a);
        return;
    L23:
        th = move-exception;
        f.h(r13);
        throw th;
    L8:
        if (r5.length() <= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L12;
        r13.skip(r5.length() - LynxResourceModule.DEFAULT_MEDIA_SIZE);     // Catch: Throwable -> L10
    L12:
        String r14 = r13.readLine();     // Catch: Throwable -> L10
        if (r14 == null) goto L16;
        r12.put(r14);     // Catch: Throwable -> L10
        goto L12
    L16:
        f.h(r13);
    L17:
        th = th;
        r13 = null;
        goto L30
    }

    public static /* synthetic */ long g() {
        return nativeGetHeapLeakSize();
    }

    public static String h(String r5) {
        StringBuilder r10 = new StringBuilder();
        if (r5.length() >= 16) goto L6;
        r10.append(r5);     // Catch: Throwable -> L11
    L12:
        goto L10
    L6:
        r10.append(r5.charAt(6));     // Catch: Throwable -> L11
        r10.append(r5.charAt(7));     // Catch: Throwable -> L11
        r10.append(r5.charAt(4));     // Catch: Throwable -> L11
        r10.append(r5.charAt(5));     // Catch: Throwable -> L11
        r10.append(r5.charAt(2));     // Catch: Throwable -> L11
        r10.append(r5.charAt(3));     // Catch: Throwable -> L11
        r10.append(r5.charAt(0));     // Catch: Throwable -> L11
        r10.append(r5.charAt(1));     // Catch: Throwable -> L11
        r10.append(r5.charAt(10));     // Catch: Throwable -> L11
        r10.append(r5.charAt(11));     // Catch: Throwable -> L11
        r10.append(r5.charAt(8));     // Catch: Throwable -> L11
        r10.append(r5.charAt(9));     // Catch: Throwable -> L11
        r10.append(r5.charAt(14));     // Catch: Throwable -> L11
        r10.append(r5.charAt(15));     // Catch: Throwable -> L11
        r10.append(r5.charAt(12));     // Catch: Throwable -> L11
        r10.append(r5.charAt(13));     // Catch: Throwable -> L11
        if (r5.length() < 32) goto L12;
        r10.append(r5, 16, 32);     // Catch: Throwable -> L11
        r10.append('0');     // Catch: Throwable -> L11
    L10:
        return r10.toString().toUpperCase();
    }

    public static void i(NativeHeapTracker r5) {
        if (r5.f4050j == false) goto L5;
        e.g("dumpNative");
    L5:
        int r10 = nativeDoCommnad(3);
        if (r10 == 0) goto L9;
        e.g("dumpNative ret=" + r10);
        r5.f4046b = true;
        return;
    }

    public static void k(NativeHeapTracker r5) {
        if (r5.f4050j == false) goto L5;
        e.g("exitNative");
    L5:
        int r10 = nativeDoCommnad(4);
        if (r10 == 0) goto L9;
        e.g("exitNative ret=" + r10);
        r5.f4046b = true;
        return;
    }

    public static void m(NativeHeapTracker r5) {
        if (r5.f4050j == false) goto L5;
        e.g("trackNative");
    L5:
        int r10 = nativeDoCommnad(1);
        if (r10 == 0) goto L9;
        e.g("trackNative ret=" + r10);
        r5.f4046b = true;
        return;
    }

    @Keep
    private static native int nativeDoCommnad(int r5);

    @Keep
    private static native long nativeGetHeapLeakSize();

    @Keep
    private static native long nativeGetHeapSize();

    @Keep
    private static native int nativeInit(int r5, String r10);

    @Keep
    private static native void nativeMinSizeByte(long r5);

    @Keep
    private static native void nativeNeedDumpMemInfo(int r5);

    @Keep
    private static native void nativeSetDumpThreshold(long r5);

    public final void j() {
        if (f4041l == false) goto L6;
        e.g("execute() Already running!");
        return;
    L6:
        e.g("loadLibrary...");
        if (this.f4048h == true) goto L10;
        io.reactivex.exceptions.a.p(this.f4051k, "npth_heap_tracker");     // Catch: Throwable -> L65
        this.f4048h = true;     // Catch: Throwable -> L65
    L10:
        if (this.f4048h == true) goto L13;
        e.g("loadLibrary() failed!");
        return;
    L13:
        StringBuilder r5 = new StringBuilder();
        File r10 = this.f;
        r5.append(r10.getAbsolutePath());
        r5.append('/');
        r5.append(n.f());
        int r11 = nativeInit(Build.VERSION.SDK_INT, r5.toString());
        if (r11 == 0) goto L17;
        e.e("init err ret = " + r11);
        return;
    L17:
        f4041l = true;
        if (this.f4045a == 0) goto L22;
        e.e("execute() Invalide state ".concat(l()));
        return;
    L22:
        if (r10.exists() == false) goto L24;
    L26:
        File r12 = new File(r10.getAbsolutePath() + this.g);
        boolean r13 = r12.exists();
        boolean r14 = this.f4050j;
        if (r13 == true) goto L66;
    L51:
        if (r14 == false) goto L53;
        e.g("check directory success!");
    L53:
        if (r14 == false) goto L55;
        e.g("initNative");
    L55:
        int r15 = nativeDoCommnad(0);
        if (r15 == 0) goto L58;
        e.g("initNative ret=" + r15);
        com.bytedance.crash.c.f4025a.getClass();
        b.f("NativeHeapTrackerInitFailed initNative failed " + r15);
    L58:
        if (r15 == 0) goto L60;
        return;
    L60:
        this.f4045a = 1;
        if (this.f4049i == false) goto L63;
        nativeNeedDumpMemInfo(1);
    L63:
        new b9.a(this).start();
        return;
    L66:
        long r16 = System.currentTimeMillis() / 1000;     // Catch: IOException -> L48
        long r17 = Long.parseLong(a.D(r12.getAbsolutePath()));     // Catch: IOException -> L48
        if (r16 >= r17) goto L32;
    L35:
        if (r16 < r17) goto L45;
        if ((r16 - r17) < 604800) goto L45;
        String r18 = r12.getAbsolutePath();     // Catch: IOException -> L48
        if (TextUtils.isEmpty(r18) == true) goto L42;
        a.C(new File(r18));     // Catch: IOException -> L48
    L42:
        if (r14 == false) goto L53;
        e.g("deleteFile guard file");     // Catch: IOException -> L48
    L45:
        if (r17 <= r16) goto L51;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: IOException -> L48
        b.f("NativeHeapCheckTime lastTime:" + r17 + " currentTime:" + r16);     // Catch: IOException -> L48
    L49:
        e.e("NativeHeapTrackerInitFailed found guard");
        return;
    L32:
        if ((r16 - r17) >= 604800) goto L35;
        if (r14 == false) goto L49;
        e.g("NativeHeapCheckTime Less than 7 days lastTime:" + r17 + " currentTime:" + r16);     // Catch: IOException -> L48
    L48:
        e.g("read guard file faild!");
        goto L49
    L24:
        if (r10.mkdir() == true) goto L26;
        e.e("cannot create " + r10);
        goto L49
    }

    public final String l() {
        int r5 = this.f4045a;
        if (r5 != 0) goto L5;
        return "[STATE_INIT]";
    L5:
        if (r5 != 1) goto L7;
        return "[STATE_PREPARE]";
    L7:
        if (r5 != 2) goto L9;
        return "[STATE_OBSERV]";
    L9:
        if (r5 != 3) goto L11;
        return "[STATE_TRACK]";
    L11:
        if (r5 != 4) goto L13;
        return "[STATE_WAIT]";
    L13:
        if (r5 == 5) goto L16;
        return "[STATEE_UNKNOWN]";
    L16:
        return "[STATE_EXIT]";
    }
}
