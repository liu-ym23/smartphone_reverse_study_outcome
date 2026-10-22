package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements com.bytedance.ee.bear.lark.dependency.f {
    public n() {
    }

    public final void b(Context r1, String r2) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).G0();
    }

    public final void a(Context r1, String r2, Map<String, String> r3) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).openUrl(r1, r2);
    }
}
