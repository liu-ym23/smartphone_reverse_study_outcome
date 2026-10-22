package com.bytedance.android.anniex.base.service;

import ai.j0;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import cn.nubia.neopush.commons.AppUtil;
import com.bytedance.crash.n;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import i2.j;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l9.o;
import mn.h;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f3127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3128b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3129c = "";
    public static String d = "";
    public static String e = "";

    public static StaticLayout a(CharSequence r5, EditText r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        Intrinsics.checkNotNullParameter(r10, "editText");
        int r12 = r10.getGravity();
        if (r12 == 3) goto L10;
        if (r12 != 5) goto L6;
        Layout.Alignment r13 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        int r14 = r10.getTextDirection();
        if (r14 != 3) goto L14;
        TextDirectionHeuristic r15 = TextDirectionHeuristics.LTR;
    L20:
        StaticLayout.Builder r16 = StaticLayout.Builder.obtain(r5, 0, r5.length(), r10.getPaint(), r11).setAlignment(r13).setTextDirection(r15).setLineSpacing(r10.getLineSpacingExtra(), r10.getLineSpacingMultiplier()).setIncludePad(r10.getIncludeFontPadding());
        r16.setUseLineSpacingFromFallbacks(true);
        return r16.build();
    L14:
        if (r14 == 4) goto L18;
        if (r14 == 5) goto L17;
        r15 = TextDirectionHeuristics.LTR;
        goto L20
    L17:
        r15 = TextDirectionHeuristics.LOCALE;
        goto L20
    L18:
        r15 = TextDirectionHeuristics.RTL;
        goto L20
    L6:
        if (r12 == 17) goto L8;
        r13 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r13 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r13 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }

    public static SSWebView b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AttributeSet r10 = null;
        nk.a.a();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L6:
        return new SSWebView(r5, r10, 6, 0);
    }

    public static File c() {
        if (f3127a != null) goto L13;
        if (m.o(n.f4057a) != null) goto L8;
        return null;
    L8:
        f3128b = String.valueOf(Process.myPid());
        if (i9.f.f17538b != null) goto L11;
        i9.f.g();
    L11:
        f3127a = new File(i9.f.f17538b, "procHistory.txt");
        o.e().c(new com.bytedance.android.anniex.worker.a(24), 15000);
    L13:
        return f3127a;
    }

    public static File d(long r10) {
        return new File(com.bytedance.crash.util.g.h(n.f4057a), x8.a.f22990m + ((r10 - (r10 % AppUtil.MILLIS_IN_DAYS)) / AppUtil.MILLIS_IN_DAYS));
    }

    public static String e() {
        BufferedReader r5 = null;
        r5 = null;
        FileReader r10 = null;
        FileReader r11 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L34 IOException -> L36
        BufferedReader r12 = new BufferedReader(r11);     // Catch: Throwable -> L30 IOException -> L32
    L72:
        String r13 = r12.readLine();     // Catch: Throwable -> L14 IOException -> L16
        if (r13 != null) goto L8;
        r11.close();     // Catch: IOException -> L26
        r12.close();     // Catch: IOException -> L26
    L48:
        return Build.BOARD;
    L26:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        goto L48
    L8:
        if (r13.contains(":") == false) goto L72;
        String[] r14 = r13.split(":");     // Catch: Throwable -> L14 IOException -> L16
        if (r14[0].contains("Hardware") == true) goto L18;
        if (r14[0].contains("model name") == false) goto L72;
    L18:
        String r15 = r14[1];     // Catch: Throwable -> L14 IOException -> L16
        r11.close();     // Catch: IOException -> L21
        r12.close();     // Catch: IOException -> L21
        return r15;
    L21:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        return r15;
    L16:
        e = e;
    L29:
        r10 = r11;
    L62:
        io.reactivex.exceptions.a.f(e);     // Catch: Throwable -> L49
        if (r10 != null) goto L68;
    L43:
        if (r12 == null) goto L48;
        r12.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
        goto L48
    L68:
        r10.close();     // Catch: IOException -> L41
    L49:
        th = th;
        r11 = r10;
    L28:
        r5 = r12;
    L51:
        if (r11 != null) goto L64;
    L55:
        if (r5 == null) goto L59;
        r5.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        io.reactivex.exceptions.a.f(e);
    L59:
        throw th;
    L64:
        r11.close();     // Catch: IOException -> L53
    L14:
        th = th;
    L32:
        e = e;
        r12 = null;
    L30:
        th = th;
        goto L51
    L36:
        e = e;
        r12 = null;
    L34:
        th = th;
        r11 = null;
        goto L51
    }

    public static String f(Context r5, String r10, String r11, boolean r12) {
        if (TextUtils.isEmpty(f3129c) == false) goto L9;
        if (TextUtils.isEmpty(r10) == false) goto L7;
        f3129c = g(r5, true, "webview_monitor_js_file_v2/slardar_sdk.js");
        goto L9
    L7:
        f3129c = g(r5, false, r10);
    L9:
        if (TextUtils.isEmpty(d) == false) goto L11;
        d = g(r5, true, "webview_monitor_js_file_v2/slardar_bridge.js");
    L11:
        e = r11;
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        e = r11;
        if (r12 == true) goto L17;
        f3129c = "";
        e = "";
        d = "";
    L17:
        StringBuilder r13 = new StringBuilder(" javascript:(  function(){ ");
        r13.append(f3129c);
        r13.append(d);
        return j0.q(r13, e, " }  )() ");
    }

    public static String g(Context r5, boolean r10, String r11) {
        byte[] r12 = new byte[1024];
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();
        InputStream r14 = null;
        if (r10 == false) goto L10;
        InputStream r15 = r5.getAssets().open(r11);     // Catch: Throwable -> L6 Exception -> L8
    L5:
        r14 = r15;
    L11:
        int r16 = r14.read(r12);     // Catch: Throwable -> L6 Exception -> L8
        if (r16 == (-1)) goto L15;
        r13.write(r12, 0, r16);     // Catch: Throwable -> L6 Exception -> L8
        goto L11
    L15:
        r14.close();     // Catch: Exception -> L17
    L37:
    L25:
        return r13.toString();
    L10:
        r15 = new FileInputStream(r11);     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        h.g("default_handle", e);     // Catch: Throwable -> L6
        if (r14 == null) goto L25;
        r14.close();     // Catch: Exception -> L17
    L6:
        th = move-exception;
        if (r14 != null) goto L32;
    L31:
        throw th;
    L32:
        r14.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        h.g("default_handle", e);
    L17:
        e = move-exception;
        h.g("default_handle", e);
        goto L25
    }

    public static String h(i2.c r5) {
        if ((r5 instanceof j1.g) == false) goto L5;
        return "js";
    L5:
        if ((r5 instanceof j) == false) goto L8;
        return "js";
    L8:
        if ((r5 instanceof com.bytedance.ai.applet.render.core.lynx.d) == false) goto L12;
        return "lynx";
    L12:
        if ((r5 instanceof com.bytedance.ai.applet.render.core.relax.h) == false) goto L15;
        return "relax";
    L15:
        return "null";
    }

    public static ArrayList i(File r10, String r11, Long r12) {
        ArrayList r5 = new ArrayList();
        BufferedReader r13 = null;
        if (r10.exists() == true) goto L27;
        return null;
    L27:
        BufferedReader r14 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L22
    L25:
        String r15 = r14.readLine();     // Catch: Throwable -> L18
        if (r15 == null) goto L17;
        if (r15.contains("activityLifeCycle") == false) goto L25;
        String[] r16 = r15.split(" ");     // Catch: Throwable -> L21
        if (r16[0].equals(r11) == false) goto L25;
        String r17 = r16[2];     // Catch: Throwable -> L21
        long r18 = p.o().parse(r16[3]).getTime();     // Catch: Throwable -> L21
        if (r18 <= r12.longValue()) goto L25;
        r5.add(new l9.a(r17, r18));     // Catch: Throwable -> L21
        goto L25
    L17:
        f.h(r14);
    L20:
        return r5;
    L18:
        r13 = r14;
    L19:
        f.h(r13);
        goto L20
    }

    public static JSONObject j(long r10, String r11, long r12, String r13) {
        boolean r5 = i9.f.f17537a;
        File r14 = new File(new File(new File(new File(com.bytedance.crash.util.g.h(n.f4057a), x8.a.f22986i), "proc"), String.valueOf(r13)), "procHistory.txt");
        if (r14.exists() == false) goto L6;
        List r15 = i(r14, r13, 0L);
    L9:
        l9.a r16 = null;
        if (r15 != null) goto L13;
        return null;
    L13:
        if (r15.size() <= 50) goto L15;
        r15 = r15.subList(r15.size() - 50, r15.size());
    L15:
        HashMap r17 = new HashMap();
        HashMap r18 = new HashMap();
        l9.a r19 = null;
        l9.a r20 = null;
        l9.a r21 = null;
        int r22 = r15.size() - 1;
        l9.a r110 = null;
    L16:
        if (r22 < 0) goto L43;
        l9.a r23 = (l9.a) r15.get(r22);
        boolean r24 = "onCreate".equals(r23.f19553c);
        String r25 = r23.d;
        if (r24 == false) goto L22;
        if (r16 != null) goto L21;
        r16 = r23;
    L21:
        r18.put(r25, r23);
    L42:
        r22 = r22 - 1;
        goto L16
    L22:
        String r26 = r23.f19553c;
        if (r110 == null) goto L25;
    L27:
        if (r19 == null) goto L29;
    L31:
        if (r20 == null) goto L33;
    L35:
        if (r21 != null) goto L40;
        if ("onStop".equals(r26) == false) goto L40;
        r21 = r23;
    L40:
        if ("onDestroy".equals(r26) == false) goto L42;
        r17.put(r25, r23);
        r18.remove(r25);
        goto L42
    L33:
        if ("onPause".equals(r26) == false) goto L35;
        r20 = r23;
        goto L42
    L29:
        if ("onResume".equals(r26) == false) goto L31;
        r19 = r23;
        goto L42
    L25:
        if ("onStart".equals(r26) == false) goto L27;
        r110 = r23;
        goto L42
    L43:
        JSONObject r27 = new JSONObject();
        if (r16 == null) goto L46;
        mh.e.g(m9.c.c(r16.f19552b, r16.f19551a), "last_create_activity", r27);
    L46:
        if (r110 == null) goto L48;
        mh.e.g(m9.c.c(r110.f19552b, r110.f19551a), "last_start_activity", r27);
    L48:
        if (r19 == null) goto L50;
        mh.e.g(m9.c.c(r19.f19552b, r19.f19551a), "last_resume_activity", r27);
    L50:
        if (r20 == null) goto L52;
        mh.e.g(m9.c.c(r20.f19552b, r20.f19551a), "last_pause_activity", r27);
    L52:
        if (r21 == null) goto L54;
        mh.e.g(m9.c.c(r21.f19552b, r21.f19551a), "last_stop_activity", r27);
    L54:
        JSONArray r28 = new JSONArray();
        Iterator r111 = r18.keySet().iterator();
    L56:
        if (r111.hasNext() == false) goto L58;
        l9.a r112 = (l9.a) r18.get((String) r111.next());
        r28.put(m9.c.c(r112.f19552b, r112.f19551a));
        goto L56
    L58:
        mh.e.g(r28, "alive_activities", r27);
        JSONArray r29 = new JSONArray();
        Iterator r113 = r17.keySet().iterator();
    L60:
        if (r113.hasNext() == false) goto L62;
        l9.a r114 = (l9.a) r17.get((String) r113.next());
        r29.put(m9.c.c(r114.f19552b, r114.f19551a));
        goto L60
    L62:
        mh.e.g(r29, "finish_activities", r27);
        return r27;
    L6:
        if (((r10 - (r10 % AppUtil.MILLIS_IN_DAYS)) / AppUtil.MILLIS_IN_DAYS) != ((r12 - (r12 % AppUtil.MILLIS_IN_DAYS)) / AppUtil.MILLIS_IN_DAYS)) goto L8;
        r15 = i(new File(d(r10), r11.replace(':', '_') + ".txt"), r13, Long.valueOf(r10));
        goto L9
    L8:
        r15 = i(new File(d(r12), r11.replace(':', '_') + ".txt"), r13, Long.valueOf(r10));
        goto L9
    }

    public static we.a k() {
        if (we.a.f22856b == null) goto L5;
    L16:
        we.a r5 = we.a.f22856b;
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        monitor-enter(we.a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (we.a.f22856b != null) goto L11;
        we.a.f22856b = new we.a();     // Catch: Throwable -> L9
    L11:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(we.a.class);
        goto L16
    }

    public static void l(String r5, String r10) {
        File r11 = c();     // Catch: Throwable -> L6
        if (r11 == null) goto L9;
        cl.a.u(f3128b + ' ' + r5 + ' ' + r10 + ' ' + p.o().format(new Date(System.currentTimeMillis())) + '\n', r11, true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static c5.a m(long r5) {
        File[] r10 = d(r5).listFiles(new l9.p(0));
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length != 0) goto L8;
        return null;
    L8:
        return new c5.a(r10, true);
    }
}
