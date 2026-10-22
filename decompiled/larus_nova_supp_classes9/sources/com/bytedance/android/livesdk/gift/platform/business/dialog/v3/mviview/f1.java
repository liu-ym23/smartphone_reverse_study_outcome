package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 implements Runnable {
    public final /* synthetic */ GiftMVIVerticalListView a;

    public f1(GiftMVIVerticalListView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r0 = this.a.p;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.f = false;     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
