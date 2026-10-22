package com.lynx.tasm.behavior;

import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0 extends e0 implements EventEmitter.c {
    public final ArrayList<u> v;
    public final WeakReference<LynxContext> w;
    public final WeakReference<JSProxy> x;
    public boolean y;

    public LynxContext getContext() {
        return this.w.get();
    }

    @Override // com.lynx.tasm.behavior.e0
    public final void i() {
        if (this.f == true) goto L7;
        LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView not draw");
        return;
    L7:
        if (f() != null) goto L10;
        LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView is null");
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(new b0(this));
    }

    public final u m(int r4) {
        Iterator<u> r0 = this.v.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        u r1 = r0.next();
        if (r1.a != r4) goto L4;
        return r1;
    L8:
        return null;
    }

    public d0(LynxContext r3, JSProxy r4) {
        super("Lynx.IntersectionObserver");
        TraceEvent.beginSection("LynxIntersectionObserverManager initialized");
        this.w = new WeakReference(r3);
        this.a = new WeakReference(r3.getUIBody());
        this.x = new WeakReference(r4);
        this.v = new ArrayList();
        this.y = false;
        TraceEvent.endSection("LynxIntersectionObserverManager initialized");
    }

    @Override // com.lynx.tasm.EventEmitter.c
    public final void a(EventEmitter.LynxEventType r2, LynxEvent r3) {
        if (this.v.size() != 0) goto L6;
        return;
    L6:
        if (r2 != EventEmitter.LynxEventType.kLynxEventTypeLayoutEvent) goto L9;
    L16:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L20;
        return;
    L20:
        UIThreadUtils.runOnUiThreadImmediately(new b0(this));
        return;
    L9:
        if (r2 != EventEmitter.LynxEventType.kLynxEventTypeCustomEvent) goto L17;
        String r5 = r3.getName();
        if ("scroll".equals(r5) == true) goto L16;
        if ("scrolltoupper".equals(r5) == true) goto L16;
        if ("scrolltolower".equals(r5) == true) goto L16;
    L17:
        r4 = false;
        goto L18
    }
}
