package com.bytedance.android.live.liveinteract.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ CommonMultiLinkFeedView a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.m b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public e(CommonMultiLinkFeedView r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommonMultiLinkFeedView r0 = this.a;     // Catch: Throwable -> L10
        r0.B = r0.o(this.b, this.c, this.d);     // Catch: Throwable -> L10
        com.bytedance.android.live.liveinteract.feed.datamerge.i r1 = this.a.getWindowListHepler();     // Catch: Throwable -> L10
        if (r1 == null) goto L13;
        BehaviorSubject<List<tf0.e>> r2 = r1.b;     // Catch: Throwable -> L10
        if (r2 == null) goto L17;
        List<? extends tf0.e> r3 = (List) r2.getValue();     // Catch: Throwable -> L10
        if (r3 == null) goto L18;
        this.a.x(r3);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
