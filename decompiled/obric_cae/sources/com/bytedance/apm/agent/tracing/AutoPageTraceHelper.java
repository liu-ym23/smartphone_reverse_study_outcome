package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import androidx.annotation.Keep;
import c2.k;
import com.qualcomm.qti.qesdk.QesdkUtils;
import f2.b;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AutoPageTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f3731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<b> f3732c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f3733d = 0;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedQueue<b> r8 = AutoPageTraceHelper.f3732c;
            int r10 = r8.size();     // Catch: Exception -> L35
            int r11 = 0;
        L4:
            if (r11 >= r10) goto L51;
            b r12 = r8.peek();     // Catch: Exception -> L35
            if (r12 == null) goto L52;
            if (r12.f7321f == 0) goto L49;
            b r13 = r8.poll();     // Catch: Exception -> L35
            long r14 = r13.f7317b;     // Catch: Exception -> L35
            if (r14 > 0) goto L13;
        L20:
            boolean r15 = false;
        L21:
            String r16 = r13.f7316a;
            if (r15 == false) goto L53;
            JSONObject r17 = new JSONObject();     // Catch: Exception -> L35
            r17.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onCreate");     // Catch: Exception -> L35
            r17.put("start", r14);     // Catch: Exception -> L35
            int r18 = r11;
            r17.put("end", r13.f7318c);     // Catch: Exception -> L35
            JSONObject r19 = new JSONObject();     // Catch: Exception -> L35
            r19.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onResume");     // Catch: Exception -> L35
            r19.put("start", r13.f7319d);     // Catch: Exception -> L35
            r19.put("end", r13.f7320e);     // Catch: Exception -> L35
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L35
            r110.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onWindowFocusChanged");     // Catch: Exception -> L35
            r110.put("start", r13.f7321f);     // Catch: Exception -> L35
            JSONArray r20 = new JSONArray();     // Catch: Exception -> L35
            r20.put(r17);     // Catch: Exception -> L35
            r20.put(r19);     // Catch: Exception -> L35
            r20.put(r110);     // Catch: Exception -> L35
            JSONObject r21 = new JSONObject();     // Catch: Exception -> L35
            r21.put(QesdkUtils.TAGS.JSON_TAG_NAME, "page_load_stats");     // Catch: Exception -> L35
            r21.put("page_type", "activity");     // Catch: Exception -> L35
            r21.put("start", r14);     // Catch: Exception -> L35
            r21.put("end", r13.f7321f);     // Catch: Exception -> L35
            long r22 = r13.f7321f - r14;     // Catch: Exception -> L35
            if (r22 < 0) goto L34;
            if (r22 > AutoPageTraceHelper.f3733d) goto L34;
            r21.put("spans", r20);     // Catch: Exception -> L35
            HashSet<String> r23 = AutoPageTraceHelper.f3731b;     // Catch: Exception -> L35
            if (r23.contains(r16) == false) goto L32;
            int r24 = 2;
        L33:
            r23.add(r16);     // Catch: Exception -> L35
            r21.put("launch_mode", r24);     // Catch: Exception -> L35
            r21.put("collect_from", 1);     // Catch: Exception -> L35
            r21.put("page_name", r16);     // Catch: Exception -> L35
            JSONObject r25 = new JSONObject();     // Catch: Exception -> L35
            r25.put("trace", r21);     // Catch: Exception -> L35
            b3.b.C0032b.f3038a.c(new e2.b("page_load_trace", null, null, r25));     // Catch: Exception -> L35
            goto L34
        L32:
            r24 = 1;
        L34:
            r11 = r18 + 1;
            goto L4
        L53:
            return;
        L13:
            if (r13.f7318c <= 0) goto L20;
            if (r13.f7319d <= 0) goto L20;
            if (r13.f7320e <= 0) goto L20;
            r15 = true;
            goto L21
        L49:
            return;
        L52:
            return;
        L51:
            return;
        L35:
            e = move-exception;
            if (k.d() == false) goto L50;
            e.printStackTrace();
            return;
        }
    }

    static {
        f3731b = new HashSet(32);
        f3732c = new ConcurrentLinkedQueue();
        f3733d = 20000;
    }

    public AutoPageTraceHelper() {
    }

    @Keep
    public static void onTrace(String r11, String r12, boolean r13) {
        boolean r8 = TextUtils.equals("onCreate", r12);
        ConcurrentLinkedQueue<b> r10 = f3732c;
        boolean r14 = false;
        if (r8 == false) goto L34;
        if (r13 == false) goto L24;
        if (f3730a == true) goto L20;
        StringBuilder r15 = android.aimedia.a.k(r11, " onCreateStart ");
        r15.append(t2.b.f12253m);
        r15.append(" ");
        if ((t2.b.f12253m - t2.b.f12252l) >= 800) goto L10;
        boolean r16 = true;
    L11:
        r15.append(r16);
        s2.a.b(r15.toString());
        if (t2.b.f12253m != 0) goto L20;
        t2.b.f12253m = System.currentTimeMillis();
        StringBuilder r17 = android.aimedia.a.k(r11, " onCreateStart ");
        r17.append(t2.b.f12253m);
        r17.append("  ");
        r17.append(t2.b.f12252l);
        r17.append(" ");
        if ((t2.b.f12253m - t2.b.f12252l) >= 800) goto L16;
        r14 = true;
    L16:
        r17.append(r14);
        s2.a.b(r17.toString());
        if ((t2.b.f12253m - t2.b.f12252l) >= 800) goto L20;
        t2.b.f12260t = true;
        t2.b.f12261u = r11;
        goto L20
    L10:
        r16 = false;
    L20:
        if (r10.size() <= 50) goto L22;
        r10.poll();
    L22:
        r10.add(new b(r11, System.currentTimeMillis()));
        return;
    L24:
        if (f3730a == true) goto L30;
        s2.a.b("onCreateEnd " + t2.b.f12253m + " " + t2.b.f12254n);
        if (t2.b.f12254n != 0) goto L30;
        if (t2.b.f12260t == false) goto L30;
        t2.b.f12254n = System.currentTimeMillis();
    L30:
        b r18 = r10.peek();
        if (r18 == null) goto L95;
        r18.f7318c = System.currentTimeMillis();
        return;
    L95:
        return;
    L34:
        if (TextUtils.equals("onResume", r12) == false) goto L57;
        if (r13 == false) goto L47;
        if (f3730a == true) goto L43;
        StringBuilder r19 = android.aimedia.a.k(r11, " onResume ");
        r19.append(t2.b.f12257q);
        s2.a.b(r19.toString());
        if (t2.b.f12257q != 0) goto L43;
        if (t2.b.f12260t == false) goto L43;
        t2.b.f12257q = System.currentTimeMillis();
    L43:
        b r110 = r10.peek();
        if (r110 == null) goto L97;
        r110.f7319d = System.currentTimeMillis();
        return;
    L97:
        return;
    L47:
        if (f3730a == true) goto L53;
        s2.a.b("onResumeEnd " + t2.b.f12257q + " " + t2.b.f12258r);
        if (t2.b.f12258r != 0) goto L53;
        if (t2.b.f12260t == false) goto L53;
        t2.b.f12258r = System.currentTimeMillis();
    L53:
        b r111 = r10.peek();
        if (r111 == null) goto L99;
        r111.f7320e = System.currentTimeMillis();
        return;
    L99:
        return;
    L57:
        if (TextUtils.equals("onWindowFocusChanged", r12) == false) goto L77;
        if (r13 == true) goto L60;
        return;
    L60:
        if (f3730a == true) goto L69;
        StringBuilder r112 = defpackage.b.h("OnWindowFocusChanged ", r11, " ");
        r112.append(t2.b.f12259s);
        r112.append(" ");
        r112.append(t2.b.f12251k);
        r112.append(" ");
        r112.append(t2.b.f12260t);
        s2.a.b(r112.toString());
        if (t2.b.f12259s == 0) goto L64;
    L68:
        b3.b.C0032b.f3038a.c(new f2.a());
        f3730a = true;
        goto L69
    L64:
        if (t2.b.f12251k <= 0) goto L68;
        if (t2.b.f12260t == false) goto L68;
        t2.b.f12259s = System.currentTimeMillis();
        t2.b.f12261u = r11;
        t2.b.f12260t = false;
    L69:
        b r113 = r10.peek();
        if (r113 != null) goto L72;
        return;
    L72:
        if (r113.f7321f != 0) goto L103;
        r113.f7321f = System.currentTimeMillis();
        if (e3.a.a(r11) != null) goto L104;
        b3.b.C0032b.f3038a.c(new a());
        return;
    L104:
        return;
    L103:
        return;
    L77:
        if (TextUtils.equals("onStart", r12) == false) goto L106;
        if (r13 == false) goto L87;
        if (f3730a == true) goto L107;
        StringBuilder r114 = android.aimedia.a.k(r11, " onStart ");
        r114.append(t2.b.f12255o);
        s2.a.b(r114.toString());
        if (t2.b.f12255o == 0) goto L84;
        return;
    L84:
        if (t2.b.f12260t == false) goto L109;
        t2.b.f12255o = System.currentTimeMillis();
        return;
    L109:
        return;
    L107:
        return;
    L87:
        if (f3730a == true) goto L111;
        s2.a.b("onStartEnd " + t2.b.f12255o + " " + t2.b.f12256p);
        if (t2.b.f12256p == 0) goto L91;
        return;
    L91:
        if (t2.b.f12260t == false) goto L113;
        t2.b.f12256p = System.currentTimeMillis();
        return;
    L113:
        return;
    L111:
        return;
    }
}
