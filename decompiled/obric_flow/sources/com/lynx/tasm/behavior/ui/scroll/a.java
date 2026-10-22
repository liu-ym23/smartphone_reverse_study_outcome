package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.n0;
import gn.b;
import gn.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10658a;

    public a(AndroidScrollView r5) {
        this.f10658a = new WeakReference(r5);
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference r5 = this.f10658a;
        if (r5.get() == null) goto L48;
        AndroidScrollView r10 = (AndroidScrollView) r5.get();
        int r11 = r10.getScrollY();
        int r12 = r10.f10601p.getScrollX();
        boolean r13 = r10.s;
        if (r13 == true) goto L7;
    L8:
        if (r13 == false) goto L10;
    L12:
        boolean r14 = false;
    L14:
        if (r10.f10604t == true) goto L37;
        if (r14 == false) goto L37;
        r10.b(0);
        ArrayList r15 = r10.f10607w;
        if (r15 == null) goto L35;
        Iterator r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L35;
        b r17 = (b) r16.next();
        if (r17 == null) goto L21;
        h r18 = (h) r17;
        UIScrollView r19 = r18.f17117b;
        LynxContext r20 = r19.getLynxContext();
        if (r20.C != null) goto L27;
        r20.C = new qn.a(r20);
    L27:
        r20.C.b(r19.getSign());
        if (r19.f10640i == false) goto L31;
        r19.o("scrollend", r19.getScrollX(), r19.getScrollY(), r19.getScrollX(), r19.getScrollY());
    L31:
        if (r19.isEnableScrollMonitor() == false) goto L21;
        if (r19.getLynxContext().f10150r == null) goto L21;
        r19.getLynxContext().f10150r.onScrollStop(new n0(r19.getTagName(), r18.f17116a, r19.getScrollMonitorTag()));
    L35:
        r10.f10598m.N();
        return;
    L37:
        r10.f10610z = r11;
        r10.A = r12;
        r10.postDelayed(this, 100);
        return;
    L10:
        if ((r10.f10610z - r11) != 0) goto L12;
    L11:
        r14 = true;
        goto L14
    L7:
        if ((r10.A - r12) == 0) goto L11;
    }
}
