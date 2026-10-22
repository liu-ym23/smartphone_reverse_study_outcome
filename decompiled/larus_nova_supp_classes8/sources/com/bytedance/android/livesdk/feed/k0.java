package com.bytedance.android.livesdk.feed;

import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ LiveDrawerFeedCategoryFragment.h a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public k0(LiveDrawerFeedCategoryFragment.h r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        FragmentActivity r0 = this.a.a.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        LiveDrawerFeedCategoryFragment r1 = this.a.a;
        int r2 = LiveDrawerFeedCategoryFragment.O;
        b90.b.c(r1.f.getLayoutManager(), this.b, this.c);
        LiveDrawerFeedCategoryFragment r3 = this.a.a;
        r3.C = this.c;
        r3.B = this.b;
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
