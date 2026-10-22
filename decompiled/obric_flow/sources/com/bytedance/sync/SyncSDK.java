package com.bytedance.sync;

import com.bytedance.crash.Npth;
import com.bytedance.salamander.anniex.b0;
import com.ss.android.agilelogger.ALog;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;
import qj.b;
import tj.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SyncSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f7522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7523b = null;

    static {
        f7522a = new AtomicBoolean(false);
        f7523b = new a();
        new LinkedList();
        new AtomicBoolean(false);
        new p();
        Npth.registerSdk("4119", "");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(b r5) {
        if (r5.f21518a == 1) goto L29;
        f7522a.get();
        a r10 = f7523b;
        r10.getClass();
        b0 r11 = r10.f21517a;
        jm.a r12 = new jm.a(r5, 8);
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (((AtomicBoolean) r11.d).get() == false) goto L15;
        r12.run();     // Catch: Throwable -> L12
    L19:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L15:
        if (((LinkedList) r11.f7247c).size() >= r11.f7246b) goto L25;
        ((LinkedList) r11.f7247c).add(r12);     // Catch: Throwable -> L12
        goto L19
    L25:
        ALog.e("SyncSDKLog", "throw task " + r12 + ", because there are too many tasks in queue");     // Catch: Throwable -> L24
        goto L19
    L29:
        ALog.e("SyncSDKLog", "inner business,not allow to register");     // Catch: Throwable -> L23
        return;
    }
}
