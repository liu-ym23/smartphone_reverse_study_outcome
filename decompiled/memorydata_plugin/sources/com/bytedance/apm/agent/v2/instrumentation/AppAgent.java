package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.a;

/* JADX INFO: loaded from: classes.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f1099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1100b;
    private static long c;
    private static long d;
    private static long e;
    private static long f;

    public AppAgent() {
    }

    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, "<init>") == false) goto L8;
        if (r13 == false) goto L6;
        f1099a = System.currentTimeMillis();
        return;
    L6:
        f1100b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, "attachBaseContext") == false) goto L13;
        if (r13 == false) goto L11;
        c = System.currentTimeMillis();
        return;
    L11:
        d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        e = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        f = r10;
        a.a(f1099a, f1100b, c, d, e, r10);
        return;
    }
}
