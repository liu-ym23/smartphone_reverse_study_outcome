package com.bytedance.news.common.settings.internal;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f2402a;

    private b() {
    }

    public static void a() {
        if (f2402a == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f2402a == null) goto L11;
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L12
    }

    public static Context b() {
        a();
        return f2402a;
    }

    public static synchronized void c(Context r10) {
        monitor-enter(b.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f2402a == null) goto L7;
    L11:
        monitor-exit(b.class);
        return;
    L7:
        if ((r10 instanceof Application) == false) goto L9;
    L8:
        f2402a = r10;     // Catch: Throwable -> L13
        goto L11
    L9:
        r10 = r10.getApplicationContext();     // Catch: Throwable -> L13
        goto L8
    }
}
