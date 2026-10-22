package com.bytedance.applog.monitor.b;

import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f1670a;

    public a() {
        this.f1670a = new CopyOnWriteArrayList();
        b.a(this);
    }

    public void a(String r12, int r13, EventStage r14, String r15, String r16, long r17, StageEventType r19) {
        if (this.f1670a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<c> r0 = this.f1670a.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin")).a(r12, r13, r14, r15, r16, r17, r19);
        goto L7
    }
}
