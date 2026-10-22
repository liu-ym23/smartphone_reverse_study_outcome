package com.bytedance.lego.init.util;

import ai.j0;
import android.util.Log;
import com.bytedance.lego.init.InitScheduler;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    static {
    }

    public static void a(String r5, String r10) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r11 = androidx.constraintlayout.motion.widget.a.m(r5, ' ', r10);
        int r12 = r11.length();
        int r13 = 3072;
        int r14 = 1;
        int r15 = 0;
    L7:
        if (r14 > 100) goto L15;
        if (r12 <= r13) goto L11;
        Log.d(j0.g(r14, "#inittask#"), r11.substring(r15, r13));
        r14 = r14 + 1;
        r15 = r13;
        r13 = r13 + 3072;
        goto L7
    L11:
        Log.d(j0.g(r14, "#inittask#"), r11.substring(r15, r12));
        return;
    }

    public static /* synthetic */ void b(String r5) {
        a("", r5);
    }

    public static void c(String r5, String r10) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r11 = androidx.constraintlayout.motion.widget.a.m(r5, ' ', r10);
        int r12 = r11.length();
        int r13 = 3072;
        int r14 = 1;
        int r15 = 0;
    L7:
        if (r14 > 100) goto L15;
        if (r12 <= r13) goto L11;
        Log.v(j0.g(r14, "#inittask#"), r11.substring(r15, r13));
        r14 = r14 + 1;
        r15 = r13;
        r13 = r13 + 3072;
        goto L7
    L11:
        Log.v(j0.g(r14, "#inittask#"), r11.substring(r15, r12));
        return;
    }
}
