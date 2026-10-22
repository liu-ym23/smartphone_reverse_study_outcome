package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public static final f b() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(f.class);
        if ((r0 instanceof f) == true) goto L6;
        r0 = null;
    L6:
        return (f) r0;
    }

    public static final o32.b a() {
        f r0 = b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<o32.b> r1 = r0.getHighlightDataContext();
        if (r1 == null) goto L7;
        return (o32.b) r1.getValue();
    L7:
        return null;
    }

    static {
    }

    @JvmStatic
    public static final void c(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$share");
        DataContext r2 = (DataContext) r1;
        com.bytedance.live.datacontext.b.a(r2, f.class);
        com.bytedance.live.datacontext.b.a(r2, h.class);
    }
}
