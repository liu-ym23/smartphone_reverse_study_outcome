package com.bytedance.android.live.liveinteract.videotalk.quickinteract;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ QuickInteractWidget a;

    public final void a() {
        if (this.a.a.isEmpty() == false) goto L5;
        return;
    L5:
        QuickInteractTask r0 = (QuickInteractTask) CollectionsKt.firstOrNull(this.a.a);
        if (r0 == null) goto L17;
        b.a r1 = this.a.c;
        if (r1 != null) goto L10;
    L11:
        b.a r2 = this.a.c;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.b(r0) != (-1)) goto L22;
        this.a.a.clear();
        return;
    L22:
        return;
    L10:
        if (r1.b(r0) != 0) goto L11;
    L17:
        QuickInteractTask r3 = this.a.a.removeFirst();
        b.a r4 = this.a.c;
        if (r4 == null) goto L23;
        r4.c(r3);
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

    public d(QuickInteractWidget r1) {
        this.a = r1;
    }
}
