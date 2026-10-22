package com.bytedance.android.live.revlink.impl.pk.ui;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements Runnable {
    public final /* synthetic */ PkTagsContainerView a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public t(PkTagsContainerView r1, List r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        PkTagsContainerView r0 = this.a;
        if (r0.c <= 0) goto L5;
        return;
    L5:
        r0.c = PkTagsContainerView.c(r0);
        PkTagsContainerView r1 = this.a;
        r1.b = r1.c;
        Iterator r2 = this.b.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        IBattleRivalTag r3 = (IBattleRivalTag) r2.next();
        this.a.d(r3, this.c, this.d);
        goto L7
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
