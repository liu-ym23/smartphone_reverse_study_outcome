package com.bytedance.applog.k;

import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<com.bytedance.applog.n.a> f1614b;
    private final LinkedList<String> c;
    private volatile int d;
    private final com.bytedance.applog.b e;

    static {
        f1613a = Collections.singletonList("AppLogCache");
    }

    public a(com.bytedance.applog.b r2) {
        this.f1614b = new LinkedList();
        this.c = new LinkedList();
        this.d = 1000;
        this.e = r2;
    }

    public int a(ArrayList<com.bytedance.applog.n.a> r6) {
        LinkedList<com.bytedance.applog.n.a> r0 = this.f1614b;
        monitor-enter(r0);
        int r1 = this.f1614b.size();     // Catch: Throwable -> L13
        r6.addAll(this.f1614b);     // Catch: Throwable -> L13
        Iterator<com.bytedance.applog.n.a> r7 = this.f1614b.iterator();     // Catch: Throwable -> L13
    L6:
        if (r7.hasNext() == false) goto L10;
        com.bytedance.applog.n.a r2 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r2.s <= 0) goto L6;
        com.bytedance.applog.monitor.b.a(this.e.ab(), EventStage.DATA_LIST_ADDED, r2);     // Catch: Throwable -> L13
        goto L6
    L10:
        this.f1614b.clear();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public void a(int r2) {
        this.d = Math.min(r2, 200);
    }

    public void a(com.bytedance.applog.n.a r9) {
        LinkedList<com.bytedance.applog.n.a> r0 = this.f1614b;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f1614b.size() <= this.d) goto L12;
        com.bytedance.applog.n.a r1 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(this.f1614b.poll(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        if (r1.s <= 0) goto L11;
        com.bytedance.applog.monitor.b.a(this.e.ab(), EventStage.CACHE_DROP_BEFORE_HANDLE, r9);     // Catch: Throwable -> L15
    L11:
        this.e.ab().a(StatsCountKeys.CACHE_DROP_EVENT_COUNT);     // Catch: Throwable -> L15
        String r2 = r1.toString();     // Catch: Throwable -> L15
        this.e.ab().a("cache drop event", new Throwable(r2), false);     // Catch: Throwable -> L15
        this.e.aA().c(f1613a, "AppLogCache overflow remove data: {}", new Object[]{r1});     // Catch: Throwable -> L15
        com.bytedance.applog.monitor.exception.b.a().a(r2);     // Catch: Throwable -> L15
    L12:
        this.f1614b.add(r9);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public void a(String[] r8) {
        LinkedList<String> r0 = this.c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.c.size() <= this.d) goto L7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.c.poll(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.e.aA().c(f1613a, "AppLogCache overflow2 remove data: {}", new Object[]{r1});     // Catch: Throwable -> L10
        this.e.ab().a(StatsCountKeys.CACHE_DROP_EVENT_COUNT);     // Catch: Throwable -> L10
        com.bytedance.applog.monitor.exception.b.a().a(r1);     // Catch: Throwable -> L10
    L7:
        this.c.addAll(Arrays.asList(r8));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public String[] a() {
        int r0 = this.c.size();
        if (r0 <= 0) goto L5;
        String[] r1 = new String[r0];
        this.c.toArray(r1);
        this.c.clear();
        return r1;
    L5:
        return null;
    }
}
