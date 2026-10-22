package org.slf4j.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes8.dex */
public class i implements org.slf4j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f20272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, h> f20273b;
    final LinkedBlockingQueue<org.slf4j.event.b> c;

    public i() {
        this.f20272a = false;
        this.f20273b = new ConcurrentHashMap();
        this.c = new LinkedBlockingQueue();
    }

    public List<h> a() {
        return new ArrayList(this.f20273b.values());
    }

    @Override // org.slf4j.a
    public synchronized org.slf4j.c a(String r4) {
        monitor-enter(this);
        h r0 = (h) ZeusTransformUtils.preCheckCast(this.f20273b.get(r4), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new h(r4, this.c, this.f20272a);     // Catch: Throwable -> L8
        this.f20273b.put(r4, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public LinkedBlockingQueue<org.slf4j.event.b> b() {
        return this.c;
    }

    public void c() {
        this.f20272a = true;
    }

    public void d() {
        this.f20273b.clear();
        this.c.clear();
    }
}
