package com.ss.android.lark.chat.chatwindow.chat.perload;

import android.util.LruCache;
import com.larksuite.framework.thread.n;
import com.larksuite.framework.thread.p;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final int e = 0;
    public final p a;
    public final Map<String, e> b;
    public final LruCache<String, u3b.d> c;
    public final Lock d;

    static {
        e = Runtime.getRuntime().availableProcessors() + 3;
    }

    public b() {
        this.d = new ReentrantLock();
        this.a = new p("DataPreLoadEngine", 2, e, 30, new LinkedBlockingDeque(128), new n("DataPreLoadEngine", 3));
        this.b = new ConcurrentHashMap();
        this.c = new LruCache(20);
    }

    public final void a(final u3b.d r4, final com.ss.android.lark.chat.chatwindow.chat.perload.loader.c r5) {
        final String r0 = r4.a;
        this.c.put(r0, r4);
        Log.i("DataPreLoadEngine", "Execute：" + r0);
        this.a.execute(new a(this, r5, r4, r0));
    }
}
