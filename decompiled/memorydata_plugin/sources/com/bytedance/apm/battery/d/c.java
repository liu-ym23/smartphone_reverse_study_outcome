package com.bytedance.apm.battery.d;

import android.content.Context;
import com.bytedance.apm.battery.d.a.b;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends com.bytedance.apm.battery.d.a.b> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile long f1161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f1162b;
    volatile boolean c;
    ConcurrentHashMap<Integer, T> d;
    private final String e;

    c(String r3) {
        this.d = new ConcurrentHashMap();
        this.e = r3;
        this.f1162b = ActivityLifeObserver.getInstance().isForeground();
        this.f1161a = System.currentTimeMillis();
        this.c = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public void a(long r8, long r10, boolean r12) {
        Iterator<Map.Entry<Integer, T>> r13 = this.d.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        com.bytedance.apm.battery.d.a.b r2 = (com.bytedance.apm.battery.d.a.b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.bytedance.apm.battery.d.a.b.class, "com.obric.memorydata.plugin");
        if (0 >= r2.e) goto L11;
        if (r2.e >= r2.d) goto L11;
    L9:
        r13.remove();
    L11:
        if (0 >= r2.e) goto L16;
        if (r2.e < r8) goto L9;
    L16:
        if (r10 < r2.d) goto L4;
        a(r2, r8, r10);
        goto L4
    }

    public abstract void a(T r1, long r2, long r4);

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r1) {
        this.f1162b = false;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void b(boolean r1) {
        this.f1162b = true;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void c(boolean r9) {
        long r6 = System.currentTimeMillis();
        if (this.d.size() == 0) goto L5;
        a(this.f1161a, r6, r9);
    L5:
        this.f1161a = r6;
    }

    public String getType() {
        return this.e;
    }
}
