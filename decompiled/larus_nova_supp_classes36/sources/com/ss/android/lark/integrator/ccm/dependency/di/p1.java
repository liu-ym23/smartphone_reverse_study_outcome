package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p1 implements com.bytedance.ee.bear.lark.dependency.d0 {
    public p1() {
    }

    public final void a(String r1) {
        com.bytedance.ee.bear.lark.dependency.g r2 = (com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class);
        LarkContext.getApplication();
        r2.R0();
    }

    public final String decodeQRCode(String r2) {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).decodeQRCode(r2);
    }

    public final Bitmap e(String r2, int r3, int r4) {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).e(r2, r3, r4);
    }

    public final void b(Context r1, int[] r2, com.bytedance.ee.bear.lark.dependency.p0 r3, com.bytedance.ee.bear.lark.dependency.o0 r4) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).J0(r1, r2, r3);
    }
}
