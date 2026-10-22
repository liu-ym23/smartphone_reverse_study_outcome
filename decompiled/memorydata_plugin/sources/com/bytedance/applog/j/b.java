package com.bytedance.applog.j;

import com.bytedance.applog.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<j> f1611b;

    public b(com.bytedance.applog.b r2) {
        this.f1611b = new CopyOnWriteArraySet();
        this.f1610a = r2;
    }

    public void a(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1611b.add(r4);
        return;
    }

    @Override // com.bytedance.applog.j
    public void a(String r7, long r8, boolean r10) {
        Iterator<j> r0 = this.f1611b.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((j) ZeusTransformUtils.preCheckCast(r0.next(), j.class, "com.obric.memorydata.plugin")).a(r7, r8, r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.f1610a.aA().a(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
        goto L4
    }

    public void b(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.f1611b.remove(r4);
        return;
    }
}
