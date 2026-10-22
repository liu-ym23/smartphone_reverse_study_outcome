package com.bytedance.news.common.settings.internal;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f2954a;

    private b() {
    }

    public static void a() {
        if (f2954a == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f2954a == null) goto L11;
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("SettingsManager尚未被配置");     // Catch: Throwable -> L12
    }

    public static synchronized void a(Context r3) {
        monitor-enter(b.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (f2954a == null) goto L7;
    L11:
        monitor-exit(b.class);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == false) goto L9;
    L8:
        f2954a = r4;     // Catch: Throwable -> L13
        goto L11
    L9:
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static Context getContext() {
        a();
        return f2954a;
    }
}
