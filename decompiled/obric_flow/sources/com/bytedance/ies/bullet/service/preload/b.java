package com.bytedance.ies.bullet.service.preload;

import android.app.Application;
import com.airbnb.lottie.m;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f6113c;
    public final Object d;
    public final ConcurrentHashMap e;
    public final ThreadPoolExecutor f;

    public b(Application r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "bid");
        this.f6111a = r11;
        this.f6113c = new ConcurrentHashMap();
        this.d = new Object();
        this.e = new ConcurrentHashMap();
        this.f = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        r10.registerComponentCallbacks(new a(this, 0));
        if (this.f6112b == false) goto L6;
        com.bytedance.ies.bullet.service.base.b.d("preload config init success", LogLevel.d, "PreLoadService");
        return;
    L6:
        this.f6112b = true;
        a6.a r12 = new a6.a(this, 21);
        Intrinsics.checkNotNullParameter(r12, "runnable");
        h.f.b(new m(r12, 7), h.f.g);
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Object r10 = this.d;
        monitor-enter(r10);
        com.bytedance.ies.bullet.service.base.b.d("cannot get cache typeface from PreloadService, url is " + r5, LogLevel.d, "PreLoadService");     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
