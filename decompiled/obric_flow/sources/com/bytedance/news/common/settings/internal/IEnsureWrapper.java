package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import og.a;

/* JADX INFO: loaded from: classes2.dex */
public class IEnsureWrapper implements IEnsure {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile IEnsureWrapper f6949b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f6950a;

    public IEnsureWrapper() {
        IEnsure r5 = (IEnsure) a.a(IEnsure.class);
        if (a.a(SettingsConfigProvider.class) != null) goto L9;
        if (this.f6950a != null) goto L10;
        this.f6950a = Executors.newCachedThreadPool();
        return;
    L10:
        return;
    L9:
        throw new ClassCastException();
    }

    public static IEnsureWrapper a() {
        if (f6949b != null) goto L16;
        monitor-enter(IEnsureWrapper.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6949b != null) goto L11;
        f6949b = new IEnsureWrapper();     // Catch: Throwable -> L9
    L11:
        monitor-exit(IEnsureWrapper.class);     // Catch: Throwable -> L9
    L16:
        return f6949b;
    }
}
