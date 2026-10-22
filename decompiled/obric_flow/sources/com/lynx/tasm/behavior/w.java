package com.lynx.tasm.behavior;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.JSProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends b0 implements com.lynx.tasm.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f10805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WeakReference f10806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final WeakReference f10807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10808y;

    public w(com.lynx.tasm.b0 r5, JSProxy r10) {
        super("Lynx.IntersectionObserver");
        TraceEvent.c("LynxIntersectionObserverManager initialized");
        this.f10806w = new WeakReference(r5);
        this.f10198a = new WeakReference(r5.f10145m);
        this.f10807x = new WeakReference(r10);
        this.f10805v = new ArrayList();
        this.f10808y = false;
        TraceEvent.a(0, "LynxIntersectionObserverManager initialized");
    }

    @Override // com.lynx.tasm.behavior.b0
    public final void f() {
        if (this.f == true) goto L7;
        LynxLog.b(4, "Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView not draw");
        return;
    L7:
        if (e() != null) goto L10;
        LynxLog.b(4, "Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView is null");
        return;
    L10:
        com.lynx.tasm.utils.j.f(new v(this, 0));
    }

    public final t i(int r5) {
        Iterator r10 = this.f10805v.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        t r11 = (t) r10.next();
        if (r11.f10364a != r5) goto L4;
        return r11;
    L8:
        return null;
    }
}
