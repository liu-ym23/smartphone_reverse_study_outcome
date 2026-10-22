package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.d;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AutoPageTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<g.b> f722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f723d;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoPageTraceHelper.a();
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoPageTraceHelper.a();
        }
    }

    static {
        f721b = new HashSet(32);
        f722c = new ConcurrentLinkedQueue();
        f723d = 20000;
    }

    public AutoPageTraceHelper() {
    }

    static /* synthetic */ void a() {
        b();
    }

    private static void b() {
        int r10 = f722c.size();     // Catch: Exception -> L39
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L58;
        ConcurrentLinkedQueue<g.b> r12 = f722c;     // Catch: Exception -> L39
        g.b r13 = r12.peek();     // Catch: Exception -> L39
        if (r13 == null) goto L59;
        if (r13.f8904f == 0) goto L10;
    L12:
        g.b r14 = r12.poll();     // Catch: Exception -> L39
        if (r14.a() == false) goto L56;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L39
        r15.put(ActivityLifecycle.NAME, "onCreate");     // Catch: Exception -> L39
        r15.put(CommonConsts.APM_INNER_EVENT_COST_START, r14.f8900b);     // Catch: Exception -> L39
        r15.put("end", r14.f8901c);     // Catch: Exception -> L39
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L39
        r16.put(ActivityLifecycle.NAME, "onResume");     // Catch: Exception -> L39
        r16.put(CommonConsts.APM_INNER_EVENT_COST_START, r14.f8902d);     // Catch: Exception -> L39
        r16.put("end", r14.f8903e);     // Catch: Exception -> L39
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L39
        r17.put(ActivityLifecycle.NAME, "onWindowFocusChanged");     // Catch: Exception -> L39
        r17.put(CommonConsts.APM_INNER_EVENT_COST_START, r14.f8904f);     // Catch: Exception -> L39
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L39
        r18.put(r15);     // Catch: Exception -> L39
        r18.put(r16);     // Catch: Exception -> L39
        r18.put(r17);     // Catch: Exception -> L39
        if (r14.f8905g <= 0) goto L18;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L39
        r19.put(ActivityLifecycle.NAME, "viewShow");     // Catch: Exception -> L39
        r19.put(CommonConsts.APM_INNER_EVENT_COST_START, r14.f8905g);     // Catch: Exception -> L39
        r18.put(r19);     // Catch: Exception -> L39
    L18:
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L39
        r20.put(ActivityLifecycle.NAME, "page_load_stats");     // Catch: Exception -> L39
        r20.put("page_type", "activity");     // Catch: Exception -> L39
        r20.put(CommonConsts.APM_INNER_EVENT_COST_START, r14.f8900b);     // Catch: Exception -> L39
        long r21 = r14.f8905g;     // Catch: Exception -> L39
        if (r21 <= 0) goto L25;
        r20.put("end", r21);     // Catch: Exception -> L39
        long r22 = r14.f8905g;     // Catch: Exception -> L39
        long r110 = r14.f8900b;     // Catch: Exception -> L39
        if ((r22 - r110) < 0) goto L38;
        if ((r22 - r110) > f723d) goto L38;
    L30:
        r20.put("spans", r18);     // Catch: Exception -> L39
        HashSet<String> r23 = f721b;     // Catch: Exception -> L39
        if (r23.contains(r14.f8899a) == false) goto L33;
        int r24 = 2;
    L34:
        r23.add(r14.f8899a);     // Catch: Exception -> L39
        r20.put(CrashBody.LAUNCH_MODE, r24);     // Catch: Exception -> L39
        r20.put("collect_from", 1);     // Catch: Exception -> L39
        r20.put("page_name", r14.f8899a);     // Catch: Exception -> L39
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L39
        r25.put("trace", r20);     // Catch: Exception -> L39
        if (e0.a.e() == false) goto L37;
        e0.a.b("PageLoadTrace", r20.toString());     // Catch: Exception -> L39
    L37:
        f.a.a("page_load_trace", null, null, r25);     // Catch: Exception -> L39
        goto L38
    L33:
        r24 = 1;
    L38:
        r11 = r11 + 1;
        goto L4
    L25:
        r20.put("end", r14.f8904f);     // Catch: Exception -> L39
        long r26 = r14.f8904f;     // Catch: Exception -> L39
        long r111 = r14.f8900b;     // Catch: Exception -> L39
        if ((r26 - r111) < 0) goto L38;
        if ((r26 - r111) <= f723d) goto L30;
    L56:
        return;
    L10:
        if (r13.f8905g != 0) goto L12;
        return;
    L59:
        return;
    L58:
        return;
    L39:
        e = move-exception;
        if (d.D() == false) goto L57;
        e.printStackTrace();
        return;
    }

    public static void c(long r10, String r11) {
        g.b r12 = f722c.peek();
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r11, r12.f8899a) == false) goto L10;
        r12.f8905g = r10;
        q0.b.f().i(new b());
        return;
    }

    public static void d(long r10) {
        f723d = r10;
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L19;
        if (r12 == false) goto L13;
        if (f720a == true) goto L8;
        g.a.d(r10);
    L8:
        ConcurrentLinkedQueue<g.b> r13 = f722c;
        if (r13.size() <= 50) goto L11;
        r13.poll();
    L11:
        r13.add(new g.b(r10, System.currentTimeMillis()));
        return;
    L13:
        if (f720a == true) goto L15;
        g.a.c();
    L15:
        g.b r14 = f722c.peek();
        if (r14 == null) goto L56;
        r14.f8901c = System.currentTimeMillis();
        return;
    L56:
        return;
    L19:
        if (TextUtils.equals("onResume", r11) == false) goto L34;
        if (r12 == false) goto L28;
        if (f720a == true) goto L24;
        g.a.f(r10);
    L24:
        g.b r15 = f722c.peek();
        if (r15 == null) goto L58;
        r15.f8902d = System.currentTimeMillis();
        return;
    L58:
        return;
    L28:
        if (f720a == true) goto L30;
        g.a.e();
    L30:
        g.b r16 = f722c.peek();
        if (r16 == null) goto L60;
        r16.f8903e = System.currentTimeMillis();
        return;
    L60:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r11) == false) goto L47;
        if (r12 == true) goto L37;
        return;
    L37:
        if (f720a == true) goto L39;
        g.a.i(r10);
        f720a = true;
    L39:
        g.b r17 = f722c.peek();
        if (r17 != null) goto L42;
        return;
    L42:
        if (r17.f8904f != 0) goto L64;
        r17.f8904f = System.currentTimeMillis();
        if (t0.a.c(r10) != null) goto L65;
        q0.b.f().i(new a());
        return;
    L65:
        return;
    L64:
        return;
    L47:
        if (TextUtils.equals("onStart", r11) == false) goto L67;
        boolean r18 = f720a;
        if (r12 == false) goto L52;
        if (r18 == true) goto L68;
        g.a.h(r10);
        return;
    L68:
        return;
    L52:
        if (r18 == true) goto L70;
        g.a.g(r10);
        return;
    L70:
        return;
    }
}
