package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 implements com.bytedance.ee.bear.lynx.api.f {

    public static final class a implements com.bytedance.ee.bear.lark.dependency.p0 {
        public final /* synthetic */ Function<String, Boolean> a;

        public a(Function<String, Boolean> r1) {
            this.a = r1;
        }

        public final boolean a(String r2) {
            return ((Boolean) this.a.apply(r2)).booleanValue();
        }
    }

    public e0() {
    }

    public final void b() {
        com.bytedance.ee.bear.lark.dependency.z r0 = (com.bytedance.ee.bear.lark.dependency.z) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.z.class);
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void a(Context r4, Function<String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "resultCallback");
        a r0 = new a(r5);
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).J0(r4, new int[]{0}, r0);
    }
}
