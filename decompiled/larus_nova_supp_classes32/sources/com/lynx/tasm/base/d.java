package com.lynx.tasm.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final ConcurrentHashMap<Long, Object> a;
    public final AtomicLong b;

    public d() {
        this.a = new ConcurrentHashMap();
        this.b = new AtomicLong(0);
    }
}
