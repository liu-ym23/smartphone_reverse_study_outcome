package com.lynx.tasm;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f10938a;

    public q0() {
        this.f10938a = new CopyOnWriteArrayList();
    }

    @Override // com.lynx.tasm.r0
    public final void a(LynxView r5, uj.a r10) {
        Iterator r11 = this.f10938a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((r0) r11.next()).a(r5, r10);
        goto L4
    }

    @Override // ao.a
    public final void onPerformanceEvent(co.e r5) {
        Iterator r10 = this.f10938a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((q0) ((r0) r10.next())).onPerformanceEvent(r5);
        goto L4
    }
}
