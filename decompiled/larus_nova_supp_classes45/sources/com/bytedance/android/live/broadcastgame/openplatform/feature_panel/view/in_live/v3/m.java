package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements Runnable {
    public final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 a;
    public final /* synthetic */ c20.c b;

    public m(LiveOpenFeatureChooseListFragmentV3 r1, c20.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ViewPager r0 = this.a.f;
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentItem();
    L6:
        if (r1 >= 0) goto L8;
    L10:
        LiveOpenFeatureChooseListFragmentV3.U90(this.a, this.b.f);
        return;
    L8:
        if (r1 >= this.b.d.size()) goto L10;
        LiveOpenFeatureChooseListFragmentV3.T90(this.a, (c20.d) ListProtector.get(this.b.d, r1), r1);
        goto L10
    L5:
        r1 = -1;
        goto L6
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
