package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g2 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ String c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r0 = this.a;
        if (r0 == null) goto L5;
        r0.getViewTreeObserver().removeOnPreDrawListener(this);
    L5:
        this.b.set(true);
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L14;
        r1.r();
        mc9.a.a.j(this.c);
        Iterator r2 = f2.d.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        ((f2.b) r2.next()).b();     // Catch: Throwable -> L13
    L14:
        return true;
    }

    public g2(View r1, AtomicBoolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
