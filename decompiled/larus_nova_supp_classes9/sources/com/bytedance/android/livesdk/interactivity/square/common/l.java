package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final yb2.a a;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i b;

    public l() {
        this.a = w.a();
        this.b = new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0);
    }

    public final tb2.d a(gc2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        a5 r0 = r3.g;
        if (r0 == null) goto L6;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r4 = r.b;
        yb2.a r5 = this.a;
        Intrinsics.checkNotNullParameter(r0, "text");
        tb2.d r6 = r.a(r0, r5);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r6, this.b);
        return r6;
    L6:
        String r7 = r3.c;
        if (r7 == null) goto L10;
        tb2.d r1 = new tb2.d();
        r1.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r7));
        return r1;
    L10:
        return new tb2.d();
    }
}
