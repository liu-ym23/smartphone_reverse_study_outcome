package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.AnimatorSet;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayWaveControllerView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.m;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void a() {
        b r0 = this.a.a;
        int r1 = b.i;
        r0.a(true);
        TrayWaveControllerView r2 = this.a.a.e;
        if (r2 == null) goto L26;
        r2.setVisibility(0);
        List<p> r3 = r2.b;
        if (r3 == null) goto L10;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r2.addView((p) r4.next());
    L10:
        List<AnimatorSet> r5 = r2.a;
        if (r5 == null) goto L18;
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        AnimatorSet r7 = (AnimatorSet) r6.next();
        if (r7 == null) goto L14;
        r7.start();
    L18:
        r2.postDelayed(new m(r2), 1400);
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
