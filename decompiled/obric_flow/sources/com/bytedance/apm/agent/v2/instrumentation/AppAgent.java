package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.j;
import sk.a;

/* JADX INFO: loaded from: classes2.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f3846c;
    public static long d;
    public static long e;

    @Keep
    public static void onTrace(String r13, boolean r14) {
        if (TextUtils.equals(r13, "<init>") == false) goto L8;
        if (r14 == false) goto L6;
        f3844a = System.currentTimeMillis();
        return;
    L6:
        f3845b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r13, "attachBaseContext") == false) goto L13;
        if (r14 == false) goto L11;
        f3846c = System.currentTimeMillis();
        return;
    L11:
        d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r13, "onCreate") == false) goto L32;
        if (r14 == false) goto L16;
        e = System.currentTimeMillis();
        return;
    L16:
        long r15 = System.currentTimeMillis();
        long r5 = f3844a;
        long r10 = f3845b;
        long r11 = f3846c;
        long r12 = d;
        long r16 = e;
        String r17 = "assignAppTime: " + a.g;
        if (j.f3887a == false) goto L19;
        Log.d("LaunchAnalysis", r17);
    L19:
        a.f21939b = r5;
        a.f21940c = r10;
        a.d = r11;
        a.e = r12;
        a.f = r16;
        a.g = r15;
        if (r5 <= 0) goto L35;
        long r18 = j.g;
        if (r18 != 0) goto L25;
    L26:
        j.g = r5;
        return;
    L25:
        if (r5 < r18) goto L26;
        return;
    L35:
        return;
    }
}
