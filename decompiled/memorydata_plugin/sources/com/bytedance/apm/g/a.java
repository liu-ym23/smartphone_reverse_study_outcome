package com.bytedance.apm.g;

import com.bytedance.apm.b;
import com.bytedance.apm6.util.log.Logger;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f1316b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<com.bytedance.apm.d.a> f1317a;

    private a() {
        this.f1317a = new CopyOnWriteArraySet();
    }

    public static a a() {
        if (f1316b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1316b != null) goto L9;
        f1316b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1316b;
    }

    public void a(final String r3, final String r4, final JSONObject r5) {
        if (b.k() == false) goto L6;
        Logger.d("LogObserver", "logObserverList:" + this.f1317a.size());
    L6:
        if (this.f1317a.size() != 0) goto L8;
        return;
    L8:
        com.bytedance.apm.l.b.a().c(new AnonymousClass1(this, r3, r4, r5));
    }
}
