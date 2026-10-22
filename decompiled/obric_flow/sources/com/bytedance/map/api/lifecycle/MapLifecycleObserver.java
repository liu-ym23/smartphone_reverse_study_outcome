package com.bytedance.map.api.lifecycle;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import f3.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
public final class MapLifecycleObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6911a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MapLifecycleObserver f6912b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f6913c = null;
    public static final ArrayList d = null;

    static {
        f6912b = new MapLifecycleObserver();
        f6913c = new Handler(Looper.getMainLooper());
        d = new ArrayList();
    }

    public MapLifecycleObserver() {
    }

    public static /* synthetic */ void a() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(f6912b);
    }

    public static synchronized void b() {
        monitor-enter(MapLifecycleObserver.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f6911a == false) goto L8;
        monitor-exit(MapLifecycleObserver.class);
        return;
    L8:
        f6913c.post(new a(1));     // Catch: Throwable -> L11
        f6911a = true;     // Catch: Throwable -> L11
        monitor-exit(MapLifecycleObserver.class);
    }
}
