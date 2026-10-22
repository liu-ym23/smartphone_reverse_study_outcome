package com.larus.bmhome.view;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ BottomMenuGridLayout a;
    public final /* synthetic */ List b;

    public /* synthetic */ f(BottomMenuGridLayout r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BottomMenuGridLayout r0 = this.a;
        List r1 = this.b;
        int r2 = BottomMenuGridLayout.h;
        FLogger.a.i("BottomMenuGridLayout", "setItems postedToMain execute thread:" + ThreadMethodProxy.currentThread().getName() + '#' + ThreadMethodProxy.currentThread().getId());
        r0.setItems(r1);
    }
}
