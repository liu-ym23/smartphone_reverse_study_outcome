package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements Runnable {
    public final /* synthetic */ m a;

    public l(m r1) {
        this.a = r1;
    }

    public final void a() {
        CommonMultiLinkWindowManager r0 = this.a.a;
        r0.l0(r0.d0(), this.a.a.c0());
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r1 = this.a.a.h;
        if (r1 == null) goto L10;
        BehaviorSubject<List<tf0.e>> r2 = r1.b;
        if (r2 == null) goto L11;
        List<? extends tf0.e> r3 = (List) r2.getValue();
        if (r3 == null) goto L12;
        this.a.a.n1(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
