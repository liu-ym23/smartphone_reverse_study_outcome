package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.a;

import android.util.Pair;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f2512b = null;

    static {
        f2512b = new ReentrantReadWriteLock();
    }

    public static void a(JSONObject r2) {
        ReentrantReadWriteLock r0 = f2512b;     // Catch: Throwable -> L16
        r0.writeLock().lock();     // Catch: Throwable -> L16
        a r1 = new a();     // Catch: Throwable -> L16
        f2511a = r1;     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r0.writeLock().unlock();
        return;
    L7:
        if (r1.b(r2) == true) goto L9;
        f2511a.a(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<com.bytedance.frameworks.baselib.network.a.a.a, c>> r3 = f2511a.c();     // Catch: Throwable -> L16
        if (r3 != null) goto L12;
    L13:
        f2511a.a(false);     // Catch: Throwable -> L16
    L14:
        r0.writeLock().unlock();
        return;
    L12:
        if (r3.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        f2512b.writeLock().unlock();
        throw th;
    }
}
