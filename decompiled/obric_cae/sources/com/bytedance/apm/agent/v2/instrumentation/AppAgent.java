package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import c2.k;
import s2.a;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f3736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f3737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f3738e;

    public AppAgent() {
    }

    @Keep
    public static void onTrace(String r13, boolean r14) {
        if (TextUtils.equals(r13, "<init>") == false) goto L8;
        if (r14 == false) goto L6;
        f3734a = System.currentTimeMillis();
        return;
    L6:
        f3735b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r13, "attachBaseContext") == false) goto L13;
        if (r14 == false) goto L11;
        f3736c = System.currentTimeMillis();
        return;
    L11:
        f3737d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r13, "onCreate") == false) goto L29;
        if (r14 == false) goto L16;
        f3738e = System.currentTimeMillis();
        return;
    L16:
        long r15 = System.currentTimeMillis();
        long r8 = f3734a;
        long r10 = f3735b;
        long r11 = f3736c;
        long r12 = f3737d;
        long r16 = f3738e;
        a.b("assignAppTime: " + b.f12252l);
        b.f12247g = r8;
        b.f12248h = r10;
        b.f12249i = r11;
        b.f12250j = r12;
        b.f12251k = r16;
        b.f12252l = r15;
        if (r8 <= 0) goto L32;
        long r17 = k.f3304h;
        if (r17 != 0) goto L22;
    L23:
        k.f3304h = r8;
        return;
    L22:
        if (r8 < r17) goto L23;
        return;
    L32:
        return;
    }
}
