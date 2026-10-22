package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u1 implements com.bytedance.ee.bear.lark.dependency.g0 {
    public u1() {
    }

    public final z3c.a getSearchLifecycleObserver() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getSearchLifecycleObserver();
    }

    public final void a(Context r1, BaseFragment r2, int r3) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).F0();
    }
}
