package com.ss.android.lark.larkconfig.userconfig;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class f<K, V> {
    public final Map<K, V> a;
    public final Queue<b> b;

    public interface a {
    }

    public static class b<K, V> {
    }

    public f() {
        this.a = new ConcurrentHashMap();
        new AtomicInteger(0);
        new AtomicInteger(0);
        this.b = new LinkedBlockingQueue();
    }
}
