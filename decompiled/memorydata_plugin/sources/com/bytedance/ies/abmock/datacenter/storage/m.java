package com.bytedance.ies.abmock.datacenter.storage;

import android.os.Process;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2733a = -100;

    static {
    }

    static int a() {
        int r0 = Process.getThreadPriority(Process.myTid());     // Catch: Throwable -> L8
        int r1 = n.b();     // Catch: Throwable -> L8
        if (r0 <= r1) goto L7;
        Process.setThreadPriority(r1);     // Catch: Throwable -> L8
        Log.i("UnregisteredRepo", "thread boost from:" + r0 + " to:" + r1);     // Catch: Throwable -> L8
        return r0;
    L7:
        return f2733a;
    }

    static void a(int r3) {
        Log.d("UnregisteredRepo", "thread reset:" + r3);     // Catch: Throwable -> L4
        Process.setThreadPriority(r3);     // Catch: Throwable -> L4
        return;
    }
}
