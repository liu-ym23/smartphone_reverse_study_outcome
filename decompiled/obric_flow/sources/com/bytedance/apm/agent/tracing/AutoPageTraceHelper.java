package com.bytedance.apm.agent.tracing;

import ai.j0;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.j;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import sk.a;
import so.e;
import z6.b;

/* JADX INFO: loaded from: classes2.dex */
public class AutoPageTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet f3842b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f3843c = null;
    public static final long d = 0;

    static {
        f3842b = new HashSet(32);
        f3843c = new ConcurrentLinkedQueue();
        d = 20000;
    }

    @Keep
    public static void onTrace(String r12, String r13, boolean r14) {
        boolean r5 = TextUtils.equals("onCreate", r13);
        boolean r10 = false;
        ConcurrentLinkedQueue r11 = f3843c;
        if (r5 == false) goto L43;
        if (r14 == false) goto L30;
        if (f3841a == true) goto L26;
        StringBuilder r15 = j0.w(r12, " onCreateStart ");
        r15.append(a.f21941h);
        r15.append(" ");
        if ((a.f21941h - a.g) >= 800) goto L10;
        boolean r16 = true;
    L11:
        r15.append(r16);
        String r17 = r15.toString();
        if (j.f3887a == false) goto L15;
        Log.d("LaunchAnalysis", r17);
    L15:
        if (a.f21941h != 0) goto L26;
        a.f21941h = System.currentTimeMillis();
        StringBuilder r18 = j0.w(r12, " onCreateStart ");
        r18.append(a.f21941h);
        r18.append("  ");
        r18.append(a.g);
        r18.append(" ");
        if ((a.f21941h - a.g) >= 800) goto L19;
        r10 = true;
    L19:
        r18.append(r10);
        String r19 = r18.toString();
        if (j.f3887a == false) goto L23;
        Log.d("LaunchAnalysis", r19);
    L23:
        if ((a.f21941h - a.g) >= 800) goto L26;
        a.f21948o = true;
        a.f21949p = r12;
        goto L26
    L10:
        r16 = false;
    L26:
        if (r11.size() <= 50) goto L28;
        r11.poll();
    L28:
        long r20 = System.currentTimeMillis();
        t5.a r110 = new t5.a();
        r110.f22099a = r12;
        r110.f22100b = r20;
        r11.add(r110);
        return;
    L30:
        if (f3841a == true) goto L39;
        String r111 = "onCreateEnd " + a.f21941h + " " + a.f21942i;
        if (j.f3887a == false) goto L35;
        Log.d("LaunchAnalysis", r111);
    L35:
        if (a.f21942i != 0) goto L39;
        if (a.f21948o == false) goto L39;
        a.f21942i = System.currentTimeMillis();
    L39:
        t5.a r112 = (t5.a) r11.peek();
        if (r112 == null) goto L119;
        r112.f22101c = System.currentTimeMillis();
        return;
    L119:
        return;
    L43:
        if (TextUtils.equals("onResume", r13) == false) goto L72;
        if (r14 == false) goto L59;
        if (f3841a == true) goto L55;
        StringBuilder r113 = j0.w(r12, " onResume ");
        r113.append(a.f21945l);
        String r114 = r113.toString();
        if (j.f3887a == false) goto L51;
        Log.d("LaunchAnalysis", r114);
    L51:
        if (a.f21945l != 0) goto L55;
        if (a.f21948o == false) goto L55;
        a.f21945l = System.currentTimeMillis();
    L55:
        t5.a r115 = (t5.a) r11.peek();
        if (r115 == null) goto L121;
        r115.d = System.currentTimeMillis();
        return;
    L121:
        return;
    L59:
        if (f3841a == true) goto L68;
        String r116 = "onResumeEnd " + a.f21945l + " " + a.f21946m;
        if (j.f3887a == false) goto L64;
        Log.d("LaunchAnalysis", r116);
    L64:
        if (a.f21946m != 0) goto L68;
        if (a.f21948o == false) goto L68;
        a.f21946m = System.currentTimeMillis();
    L68:
        t5.a r117 = (t5.a) r11.peek();
        if (r117 == null) goto L123;
        r117.e = System.currentTimeMillis();
        return;
    L123:
        return;
    L72:
        if (TextUtils.equals("onWindowFocusChanged", r13) == false) goto L95;
        if (r14 == true) goto L75;
        return;
    L75:
        if (f3841a == true) goto L87;
        StringBuilder r118 = j0.x("OnWindowFocusChanged ", r12, " ");
        r118.append(a.f21947n);
        r118.append(" ");
        r118.append(a.f);
        r118.append(" ");
        r118.append(a.f21948o);
        String r119 = r118.toString();
        if (j.f3887a == false) goto L80;
        Log.d("LaunchAnalysis", r119);
    L80:
        if (a.f21947n == 0) goto L82;
    L86:
        b.f23409a.d(new e(1));
        f3841a = true;
        goto L87
    L82:
        if (a.f <= 0) goto L86;
        if (a.f21948o == false) goto L86;
        a.f21947n = System.currentTimeMillis();
        a.f21949p = r12;
        a.f21948o = false;
    L87:
        t5.a r120 = (t5.a) r11.peek();
        if (r120 != null) goto L90;
        return;
    L90:
        if (r120.f != 0) goto L127;
        r120.f = System.currentTimeMillis();
        if (d7.a.a(r12) != null) goto L128;
        b.f23409a.d(new e(2));
        return;
    L128:
        return;
    L127:
        return;
    L95:
        if (TextUtils.equals("onStart", r13) == false) goto L130;
        if (r14 == false) goto L108;
        if (f3841a == true) goto L131;
        StringBuilder r121 = j0.w(r12, " onStart ");
        r121.append(a.f21943j);
        String r122 = r121.toString();
        if (j.f3887a == false) goto L103;
        Log.d("LaunchAnalysis", r122);
    L103:
        if (a.f21943j == 0) goto L105;
        return;
    L105:
        if (a.f21948o == false) goto L133;
        a.f21943j = System.currentTimeMillis();
        return;
    L133:
        return;
    L131:
        return;
    L108:
        if (f3841a == true) goto L135;
        String r123 = "onStartEnd " + a.f21943j + " " + a.f21944k;
        if (j.f3887a == false) goto L113;
        Log.d("LaunchAnalysis", r123);
    L113:
        if (a.f21944k == 0) goto L115;
        return;
    L115:
        if (a.f21948o == false) goto L137;
        a.f21944k = System.currentTimeMillis();
        return;
    L137:
        return;
    L135:
        return;
    }
}
