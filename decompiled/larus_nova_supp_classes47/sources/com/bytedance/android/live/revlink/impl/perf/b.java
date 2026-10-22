package com.bytedance.android.live.revlink.impl.perf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public String a;
    public boolean b;
    public e c;
    public long d;
    public final ConcurrentHashMap<String, String> e;
    public final ConcurrentHashMap<Integer, Pair<Double, Long>> f;
    public final ConcurrentLinkedQueue<Double> g;

    public b() {
        this.a = "";
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentLinkedQueue();
    }

    public final Pair<Double, Long> a(int r2) {
        return this.f.get(Integer.valueOf(r2));
    }
}
