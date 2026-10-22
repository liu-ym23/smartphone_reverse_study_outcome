package com.bytedance.crash.upload;

import android.text.TextUtils;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.NativeTools;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static s g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4158c;
    public volatile boolean d;
    public final r e;
    public final File f;

    public s() {
        io.reactivex.exceptions.a.i("Disaster:init");
        File r5 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22992o);
        this.f4157b = r5;
        this.f4156a = new HashMap();
        this.f4158c = false;
        this.d = false;
        this.e = new r(this, r5.getAbsolutePath());     // Catch: Throwable -> L5
    L7:
        this.f = new File(new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.s), "disasterLock");
        return;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        goto L7
    }

    public static long c(String r10, URL r11) {
        s r5 = d();
        if (r5 != null) goto L5;
        return 0;
    L5:
        String r12 = "";
        if (r5.f4156a.size() > 0) goto L8;
    L39:
        return 0;
    L8:
        if (l9.c.d() == true) goto L39;
        io.reactivex.exceptions.a.i("Disaster:checkPermission url=" + r11);
    L14:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        long r13 = 0;
    L35:
        io.reactivex.exceptions.a.i("Disaster:checkPermission return timeout=" + r13);
        if (r13 == 0) goto L38;
        l9.l.i("DST_CHECK_PERMISSION", r12 + " " + r13);
    L38:
        return r13;
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        r10 = f(r11);     // Catch: Throwable -> L14
    L17:
        if (TextUtils.isEmpty(r10) == false) goto L20;
        io.reactivex.exceptions.a.i("Disaster:checkPermission aid==null");     // Catch: Throwable -> L14
        return -1;
    L20:
        r12 = e(r10, r11.getPath());     // Catch: Throwable -> L14
        HashMap r14 = r5.f4156a;     // Catch: Throwable -> L14
        monitor-enter(r14);     // Catch: Throwable -> L14
        q r15 = (q) r5.f4156a.get(r12);     // Catch: Throwable -> L27
        if (r15 != null) goto L29;
        io.reactivex.exceptions.a.i("Disaster:checkPermission normal");     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
        return 0;
    L29:
        r13 = r5.b(r15);     // Catch: Throwable -> L27
        monitor-exit(r14);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    }

    public static s d() {
        monitor-enter(s.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (g != null) goto L9;
        g = new s();     // Catch: Throwable -> L7
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L7
        return g;
    }

    public static String e(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return "";
    L7:
        return com.lynx.tasm.utils.k.j(r5, "_", r10);
    }

    public static String f(URL r10) {
        String r5 = "";
        String r11 = r10.getQuery();     // Catch: Throwable -> L20
        if (r11 != null) goto L6;
    L26:
        return r5;
    L6:
        if (r11.contains("&") == false) goto L26;
        if (r11.contains("=") == false) goto L26;
        String[] r12 = r11.split("&");     // Catch: Throwable -> L20
        int r13 = r12.length;     // Catch: Throwable -> L20
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L26;
        String[] r15 = r12[r14].split("=");     // Catch: Throwable -> L20
        if (r15 == null) goto L24;
        if (r15.length < 2) goto L24;
    L22:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);     // Catch: Throwable -> L20
        goto L24
    L17:
        if (URLDecoder.decode(r15[0], "UTF-8").equals(WsConstants.KEY_APP_ID) == false) goto L24;
        r5 = URLDecoder.decode(r15[1], "UTF-8");     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
        io.reactivex.exceptions.a.i("getQueryParams value = " + r5);     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
    L24:
        r14 = r14 + 1;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        goto L26
    }

    public static void g(int r5, CrashType r10) {
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L4
        mh.e.g(r10.getName(), "crashType", r11);     // Catch: Throwable -> L4
        mh.e.g(String.valueOf(r5), "dropType", r11);     // Catch: Throwable -> L4
        l9.n.b("drop_crash", r11, null);     // Catch: Throwable -> L4
        return;
    }

    public static void i(String r5, int r10, String r11, boolean r12) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (r5.equals("2010") == true) goto L26;
        String r13 = e(r5, r11);     // Catch: Throwable -> L21
        String r14 = ym.m.f23304a;     // Catch: Throwable -> L21
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L21
        mh.e.g(r13, SVGRenderEngine.PATH, r15);     // Catch: Throwable -> L21
        if (r12 == false) goto L18;
        mh.e.g("exit", "state", r15);     // Catch: Throwable -> L21
    L19:
        mh.e.g(String.valueOf(r10), "strategy", r15);     // Catch: Throwable -> L21
        mh.e.g(r14, "pname", r15);     // Catch: Throwable -> L21
        io.reactivex.exceptions.a.i("disaster:reportEvent aid=" + r5 + " path=" + r11 + " isRestore" + r12 + " strategy=" + r10);     // Catch: Throwable -> L21
        l9.n.b("net_disaster", r15, null);     // Catch: Throwable -> L21
        return;
    L18:
        mh.e.g("enter", "state", r15);     // Catch: Throwable -> L21
        goto L19
    L26:
        return;
    }

    public static void k(URL r5, t r10) {
        s r11 = d();
        if (r11 != null) goto L6;
        return;
    L6:
        if (l9.c.d() == false) goto L8;
        return;
    L8:
        if (r5 == null) goto L17;
        if (r10 == null) goto L17;
        io.reactivex.exceptions.a.l("Disaster:updateNetworkState url=" + r5);
        String r12 = f(r5);     // Catch: Throwable -> L19
        String r13 = r5.getPath();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r12) == false) goto L15;
        return;
    L15:
        r11.j(r12, r13, r10);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    L17:
        io.reactivex.exceptions.a.l("Disaster:updateNetworkState param is invalid");
    }

    public static boolean m(String r5, CrashType r10) {
        s r11 = d();
        boolean r12 = false;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.f4156a.size() > 0) goto L8;
    L51:
        return r12;
    L8:
        if (l9.c.d() == true) goto L51;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    L49:
        if (r12 == false) goto L51;
        l9.l.i("DST_DROP_DATA", r10.getName() + " " + r12);
        goto L51
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        r5 = com.bytedance.crash.n.d().i();     // Catch: Throwable -> L13
    L16:
        if (r10 != CrashType.JAVA) goto L18;
    L41:
        String r13 = new URL(com.bytedance.crash.n.f4062j.getJavaCrashUploadUrl()).getPath();     // Catch: Throwable -> L13
    L42:
        int r14 = r11.a(e(r5, r13));     // Catch: Throwable -> L13
        if (r14 != 4) goto L46;
    L47:
        r12 = true;
        goto L49
    L46:
        if (r14 != 5) goto L49;
    L18:
        if (r10 == CrashType.ANR) goto L41;
        if (r10 == CrashType.DART) goto L41;
        if (r10 == CrashType.GAME) goto L41;
        if (r10 != CrashType.LAUNCH) goto L27;
    L40:
        r13 = new URL(com.bytedance.crash.n.f4062j.getLaunchCrashUploadUrl()).getPath();     // Catch: Throwable -> L13
        goto L42
    L27:
        if (r10 == CrashType.CUSTOM_NATIVE) goto L40;
        if (r10 != CrashType.NATIVE) goto L33;
        r13 = new URL(com.bytedance.crash.n.f4062j.getNativeCrashUploadUrl()).getPath();     // Catch: Throwable -> L13
        goto L42
    L33:
        if (r10 != CrashType.CUSTOM_JAVA) goto L36;
        r13 = new URL(com.bytedance.crash.n.f4062j.getExceptionUploadUrl()).getPath();     // Catch: Throwable -> L13
        goto L42
    L36:
        if (r10 != CrashType.EVENT) goto L39;
        r13 = new URL(com.bytedance.crash.n.f4062j.getEventUploadUrl()).getPath();     // Catch: Throwable -> L13
        goto L42
    L39:
        r13 = "";
        goto L42
    }

    public final int a(String r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return -1;
    L10:
        q r10 = (q) this.f4156a.get(r5);     // Catch: Throwable -> L8
        if (r10 != null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L8
        return 0;
    L15:
        int r11 = r10.e;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r11;
    }

    public final long b(q r12) {
        long r5 = System.currentTimeMillis();
        long r10 = r12.d;
        int r11 = r12.e;
        if (r11 != 1) goto L6;
        long r13 = r12.f4151h;
    L27:
        if (r13 != 0) goto L30;
        return 0;
    L30:
        if (r5 >= r10) goto L47;
        monitor-enter(this);
        Iterator r14 = this.f4156a.entrySet().iterator();     // Catch: Throwable -> L41
    L34:
        if (r14.hasNext() == false) goto L43;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L41
        if (r15 == null) goto L34;
        q r16 = (q) r15.getValue();     // Catch: Throwable -> L41
        r16.d = r5;     // Catch: Throwable -> L41
        zm.p.o().format(new Date(r16.d));     // Catch: Throwable -> L52
        goto L34
    L43:
        monitor-exit(this);     // Catch: Throwable -> L41
        s();
        r10 = r5;
    L41:
        th = move-exception;
        throw th;
    L47:
        long r17 = r5 - r10;
        if (r17 < r13) goto L50;
        return 0;
    L50:
        return r13 - r17;
    L6:
        if (r11 != 3) goto L8;
    L13:
        int r18 = 0;
        if (r11 == 1) goto L18;
        if (r11 == 0) goto L18;
        int r19 = r12.g;
    L19:
        if (r19 <= 0) goto L23;
        r18 = r19;
    L23:
        if (r18 > 6) goto L25;
        r13 = r18 * 300000;
        goto L27
    L25:
        r13 = 1800000;
    L18:
        r19 = 0;
        goto L19
    L8:
        if (r11 == 4) goto L13;
        if (r11 == 5) goto L13;
        r13 = 0;
        goto L27
    }

    public final void h(long r5, String r10, int r11, int r12, String r13) {
        String r14 = e(r10, r13);
        if (TextUtils.isEmpty(r14) == true) goto L77;
        monitor-enter(this);
        if (r11 == 0) goto L9;
        q r15 = (q) this.f4156a.get(r14);     // Catch: Throwable -> L18
        int r16 = 0;
        if (r15 != null) goto L26;
        i(r10, r11, r13, false);     // Catch: Throwable -> L18
        r15 = new q(r10, r13);     // Catch: Throwable -> L18
    L26:
        if (r11 == 1) goto L33;
        if (r11 == 0) goto L33;
        if (r11 == r15.e) goto L32;
        r15.g = 1;     // Catch: Throwable -> L18
    L34:
        r15.e = r11;     // Catch: Throwable -> L18
        r15.f = r12;     // Catch: Throwable -> L18
        if (r11 != 1) goto L38;
        r15.f4151h = r5;     // Catch: Throwable -> L18
    L38:
        if (r11 != 5) goto L49;
        io.reactivex.exceptions.a.i("disaster: clearCacheLog");     // Catch: Throwable -> L18
    L40:
        r16 = r16 + 1;
        int r17 = o();     // Catch: Throwable -> L61
        if (r17 > 0) goto L43;
        io.reactivex.exceptions.a.i("disaster: did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L61
        Thread.sleep(50);     // Catch: Throwable -> L61
        if (r16 < 10) goto L40;
    L43:
        io.reactivex.exceptions.a.i("disaster: got flock");     // Catch: Throwable -> L61
        com.bytedance.crash.util.g.e(r13);     // Catch: Throwable -> L61
        if (r17 <= 0) goto L49;
        NativeTools.k().w(r17);     // Catch: Throwable -> L61
    L49:
        r15.d = System.currentTimeMillis();     // Catch: Throwable -> L18
        zm.p.o().format(new Date(r15.d));     // Catch: Throwable -> L62
    L51:
        this.f4156a.put(r14, r15);     // Catch: Throwable -> L18
        s();     // Catch: Throwable -> L18
        l9.l.i("DST_STRATEGY", r15.toString());     // Catch: Throwable -> L18
        if (new URL(com.bytedance.crash.n.f4062j.getNativeCrashUploadUrl()).getPath().equals(r13) == false) goto L55;
        t();     // Catch: Throwable -> L18 MalformedURLException -> L60
    L55:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L32:
        r15.g++;     // Catch: Throwable -> L18
    L33:
        r15.g = 0;     // Catch: Throwable -> L18
        goto L34
    L9:
        if (this.f4156a.containsKey(r14) == false) goto L55;
        monitor-enter(this);     // Catch: Throwable -> L18
        if (this.f4156a.containsKey(r14) == false) goto L66;
        this.f4156a.remove(r14);     // Catch: Throwable -> L59
        s();     // Catch: Throwable -> L59
        l9.l.i("DST_RESTORE", r14);     // Catch: Throwable -> L59
    L66:
        monitor-exit(this);     // Catch: Throwable -> L20
    L16:
        i(r10, -1, r13, true);     // Catch: Throwable -> L18
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void j(String r17, String r18, t r19) {
        if (TextUtils.isEmpty(r17) == false) goto L5;
    L72:
        io.reactivex.exceptions.a.l("Disaster:updateNetworkStateInner param is invalid");
        return;
    L5:
        if (TextUtils.isEmpty(r18) == true) goto L72;
        if (r19 == null) goto L72;
        String r10 = e(r17, r18);     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(r17) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r18) == true) goto L78;
        ConfigManager r11 = com.bytedance.crash.n.f4062j;     // Catch: Throwable -> L74
        if (r18.equals(new URL(r11.getApmConfigUrl()).getPath()) == false) goto L16;
        return;
    L16:
        io.reactivex.exceptions.a.l("Disaster:updateNetworkStateInner keyId:" + r10 + " rsp:" + r19.toString());     // Catch: Throwable -> L74
        a(r10);     // Catch: Throwable -> L74
        int r5 = r19.f4161c;     // Catch: Throwable -> L74
        JSONObject r12 = (JSONObject) r19.d;     // Catch: Throwable -> L74
        boolean r13 = r18.equals(new URL(r11.getQuotaStateUrl()).getPath());     // Catch: Throwable -> L74
        int r14 = 0;
        if (r5 != 200) goto L59;
        if (r12 == null) goto L22;
        String r15 = r12.optString("message");     // Catch: Throwable -> L74
        String r16 = r12.optString("redirect");     // Catch: Throwable -> L74
        long r110 = r12.optLong("delay");     // Catch: Throwable -> L74
        String r20 = r12.optString("Alog_quota");     // Catch: Throwable -> L74
        String r21 = r12.optString("quota_status");     // Catch: Throwable -> L74
        if (r13 == true) goto L31;
        if (TextUtils.isEmpty(r21) == true) goto L31;
        r15 = r21;
    L31:
        if (TextUtils.isEmpty(r15) == false) goto L33;
    L49:
        int r22 = 0;
    L50:
        TextUtils.isEmpty(r16);     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(r20) == true) goto L56;
        int r23 = r22;
        boolean r24 = true;
        if ("long escape".equals(r20) == false) goto L55;
        r14 = 3;
    L64:
        if (r23 != (-2)) goto L68;
        if (r13 == false) goto L76;
        io.reactivex.exceptions.a.l("Disaster:quota path error!!!");     // Catch: Throwable -> L74
        this.f4158c = true;     // Catch: Throwable -> L74
        return;
    L76:
        return;
    L68:
        h(r110, r17, r23, r14, r18);     // Catch: Throwable -> L74
        if (r24 == false) goto L79;
        h(r110, r17, r14, r14, new URL(r11.getAlogUploadUrl()).getPath());     // Catch: Throwable -> L74
        return;
    L79:
        return;
    L55:
        r14 = 0;
        goto L64
    L56:
        r23 = r22;
    L57:
        r24 = false;
        goto L64
    L33:
        if ("success".equals(r15) == true) goto L49;
        if ("long escape".equals(r15) == false) goto L39;
        r22 = 3;
        goto L50
    L39:
        if ("ignore data".equals(r15) == false) goto L42;
    L48:
        r22 = -2;
        goto L50
    L42:
        if ("drop data".equals(r15) == false) goto L45;
        r22 = 4;
        goto L50
    L45:
        if ("drop all data".equals(r15) == false) goto L47;
        r22 = 5;
        goto L50
    L47:
        l9.l.i("DST_NET_ERROR", r10 + " " + r15);     // Catch: Throwable -> L74
        goto L48
    L22:
        h(0, r17, 0, 0, r18);     // Catch: Throwable -> L74
        l9.l.i("DST_NET_ERROR", r10 + " json is null");     // Catch: Throwable -> L74
        return;
    L59:
        if (500 <= r5) goto L61;
    L63:
        r110 = 0;
        r23 = -2;
        goto L57
    L61:
        if (r5 > 600) goto L63;
        r110 = 0;
        r23 = 3;
        goto L57
    L78:
        return;
    }

    public final void l(JSONArray r10) {
        io.reactivex.exceptions.a.i("disaster: writeToFile");
        int r5 = 0;
    L3:
        boolean r11 = true;
        r5 = r5 + 1;
        int r12 = o();     // Catch: Throwable -> L35
        if (r12 > 0) goto L6;
        io.reactivex.exceptions.a.i("disaster:write did not got flock, sleep 50ms and retry");     // Catch: Throwable -> L35
        Thread.sleep(50);     // Catch: Throwable -> L35
        if (r5 < 20) goto L3;
    L6:
        io.reactivex.exceptions.a.i("disaster:write got flock");     // Catch: Throwable -> L35
        this.d = true;     // Catch: Throwable -> L35
        if (r10 != null) goto L18;
        File r13 = this.f4157b;     // Catch: Throwable -> L35
        r13.getParentFile().mkdirs();     // Catch: Throwable -> L35
        FileOutputStream r14 = null;
        FileOutputStream r15 = new FileOutputStream(r13, false);     // Catch: Throwable -> L15
        r15.write("".getBytes());     // Catch: Throwable -> L13
        r15.flush();     // Catch: Throwable -> L13
        com.bytedance.android.anniex.base.service.f.h(r15);     // Catch: Throwable -> L35
    L19:
        if (r12 <= 0) goto L21;
        NativeTools.k().w(r12);     // Catch: Throwable -> L35
    L21:
        io.reactivex.exceptions.a.i("disaster:write unlock flock");     // Catch: Throwable -> L35
        int r16 = 0;
    L23:
        if (this.d == false) goto L25;
        io.reactivex.exceptions.a.i("disaster:waiting 20ms");     // Catch: Throwable -> L35
        Thread.sleep(20);     // Catch: Throwable -> L35
        r16 = r16 + 1;     // Catch: Throwable -> L35
    L26:
        if (r11 == false) goto L33;
        if (r16 < 50) goto L23;
    L25:
        io.reactivex.exceptions.a.i("disaster: breakout");     // Catch: Throwable -> L35
        r11 = false;
    L13:
        th = th;
        r14 = r15;
    L16:
        com.bytedance.android.anniex.base.service.f.h(r14);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L15:
        th = th;
        goto L16
    L18:
        cl.a.p(this.f4157b, r10);     // Catch: Throwable -> L35
    L33:
        this.d = false;
    }

    public final void n(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L18:
        io.reactivex.exceptions.a.l("Disaster:syncNetworkStateByNet aid or path is null");
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        io.reactivex.exceptions.a.i("Disaster:syncNetworkStateByNet path=" + r11);
        String r5 = b.i(com.bytedance.crash.n.f4062j.getQuotaStateUrl(), Header.f().f4029a);
        JSONObject r12 = new JSONObject();
        r12.put(WsConstants.KEY_APP_ID, Integer.valueOf(r10));     // Catch: JSONException -> L10
        r12.put("os", "Android");     // Catch: JSONException -> L10
        r12.put(SVGRenderEngine.PATH, r11);     // Catch: JSONException -> L10
        t r13 = b.b(r5, r12.toString(), false);     // Catch: JSONException -> L10
    L12:
        io.reactivex.exceptions.a.i("Disaster:syncNetworkStateByNet rsp=" + r13.toString());
        j(r10, r11, r13);
        if (this.f4158c == false) goto L15;
    L16:
        this.f4158c = false;
        q();
        l9.l.i("DST_QUOTA_PATH_ERROR", "");
        io.reactivex.exceptions.a.i("disaster:syncNetworkStateByNet, quota path error");
        return;
    L15:
        if (r13.f4160b != 0) goto L16;
        return;
    L10:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        r13 = new t(ComposerKt.reuseKey);
        goto L12
    }

    public final int o() {
        File r5 = this.f;
        if (r5.exists() == false) goto L12;
    L10:
        return NativeTools.k().G(r5.getAbsolutePath());
    L9:
        return -1;
    L12:
        r5.createNewFile();     // Catch: IOException -> L6
    L6:
        return -1;
    }

    public final String p() {
        io.reactivex.exceptions.a.i("disaster: readFromFile");
        String r5 = "";
        int r10 = 0;
    L3:
        boolean r11 = true;
        r10 = r10 + 1;
        int r12 = o();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L11;
        io.reactivex.exceptions.a.i("disaster: read got flock");     // Catch: Throwable -> L16
        r5 = cl.a.c(-1, this.f4157b, "\n");     // Catch: Throwable -> L16
        if (r12 <= 0) goto L9;
        NativeTools.k().w(r12);     // Catch: Throwable -> L16
    L9:
        io.reactivex.exceptions.a.i("disaster: read unlock flock");     // Catch: Throwable -> L16
        goto L10
    L11:
        io.reactivex.exceptions.a.i("disaster:read did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L16
        Thread.sleep(50);     // Catch: Throwable -> L16
    L12:
        if (r11 == false) goto L15;
        if (r10 < 10) goto L3;
    L15:
        return r5;
    L10:
        r11 = false;
        goto L12
    }

    public final void q() {
        monitor-enter(this);     // Catch: Throwable -> L12
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L4:
        if (this.f4156a.size() <= 0) goto L8;
        this.f4156a.clear();     // Catch: Throwable -> L6
        s();     // Catch: Throwable -> L6
        l9.l.i("DST_RESTORE", "All");     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    }

    public final void r() {
    L19:
        th = move-exception;
        monitor-enter(this.f4156a);
        this.f4156a.clear();     // Catch: Throwable -> L35
        l(null);
        io.reactivex.exceptions.a.f(th);
        return;
    L35:
        th = move-exception;
        throw th;
    L4:
        if (this.f4157b.exists() == true) goto L6;
    L21:
        HashMap r5 = this.f4156a;     // Catch: Throwable -> L19
        monitor-enter(r5);     // Catch: Throwable -> L19
        this.f4156a.clear();     // Catch: Throwable -> L26
        monitor-exit(r5);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.f4157b.length() == 0) goto L21;
        JSONArray r10 = new JSONArray(p());     // Catch: Throwable -> L19
        io.reactivex.exceptions.a.i("Disaster:syncNetworkStateFromFile mJsonArray=" + r10.toString());     // Catch: Throwable -> L19
        int r11 = 0;
    L10:
        if (r11 >= r10.length()) goto L47;
        JSONObject r12 = r10.getJSONObject(r11);     // Catch: Throwable -> L19
        String r13 = r12.keys().next();     // Catch: Throwable -> L19
        q r14 = new q(r12.getJSONObject(r13));     // Catch: Throwable -> L19
        HashMap r15 = this.f4156a;     // Catch: Throwable -> L19
        monitor-enter(r15);     // Catch: Throwable -> L19
        this.f4156a.put(r13, r14);     // Catch: Throwable -> L16
        monitor-exit(r15);     // Catch: Throwable -> L16
        r11 = r11 + 1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    }

    public final void s() {
        HashMap r5 = this.f4156a;
        monitor-enter(r5);
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L23
        Iterator r11 = this.f4156a.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L13
        if (r12 == null) goto L8;
        r10.put(((q) r12.getValue()).a());     // Catch: Throwable -> L13
        goto L8
    L16:
        if (r10.length() > 0) goto L18;
        this.f4156a.clear();     // Catch: Throwable -> L13
        l(null);     // Catch: Throwable -> L13
        io.reactivex.exceptions.a.i("Disaster:syncNetworkStateToFile delete strategy file");     // Catch: Throwable -> L13
    L21:
        monitor-exit(r5);     // Catch: Throwable -> L23
        return;
    L18:
        l(r10);     // Catch: Throwable -> L13
        io.reactivex.exceptions.a.i("Disaster:syncNetworkStateToFile mJsonArray=" + r10.toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f4156a.clear();     // Catch: Throwable -> L23
        l(null);     // Catch: Throwable -> L23
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final void t() {
        String r5 = e(com.bytedance.crash.n.d().i(), new URL(com.bytedance.crash.n.f4062j.getNativeCrashUploadUrl()).getPath());     // Catch: Throwable -> L13
        int r10 = a(r5);     // Catch: Throwable -> L13
        if (r10 != 4) goto L5;
    L8:
        ?? r11 = 1;
    L9:
        NativeImpl.h(r11);     // Catch: Throwable -> L13
        if (r11 == 0) goto L18;
        l9.l.i("DST_SYNC_NATIVE_DROP", r5 + " " + r11);     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L5:
        if (r10 == 5) goto L8;
        r11 = 0;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
    }
}
