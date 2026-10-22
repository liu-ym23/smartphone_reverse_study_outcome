package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.lynx.base.log.LynxLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10804b;

    public /* synthetic */ v(w r5, int r10) {
        this.f10803a = r10;
        this.f10804b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10803a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        w r5 = this.f10804b;
        r5.f10805v.clear();
        r5.d();
        return;
    L6:
        Iterator r10 = this.f10804b.f10805v.iterator();
    L8:
        if (r10.hasNext() == false) goto L26;
        t r11 = (t) r10.next();
        if (r11 == null) goto L11;
        ArrayList r12 = r11.f10372m;
        if (r12.size() == 0) goto L8;
        RectF r13 = r11.d();
        Iterator r14 = r12.iterator();
    L17:
        if (r14.hasNext() == false) goto L8;
        r11.b((s) r14.next(), r13, false);
        goto L17
    L11:
        LynxLog.b(4, "Lynx.IntersectionObserver", "LynxIntersectionObserverManager.notifyObservers failed, because observer is null");
        return;
    }
}
