package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d2 implements ao4.f {
    public final Context a;
    public final Map<a, com.ss.android.lark.watermark.a> b;

    public interface a {
    }

    public final WatermarkInfo a() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).z0(this.a);
    }

    public d2() {
        this.a = LarkContext.getApplication();
        this.b = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.integrator.ccm.dependency.di.c2, java.lang.Object] */
    public final void b(ra5.d r3) {
        final b2 r0 = new b2(r3);
        ?? r4 = new c2(r0);
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).U0(r4);
        ((ConcurrentHashMap) this.b).put(r0, r4);
    }
}
