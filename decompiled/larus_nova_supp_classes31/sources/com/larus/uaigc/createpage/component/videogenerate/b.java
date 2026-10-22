package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements d {
    public b() {
    }

    @Override // com.larus.uaigc.createpage.component.videogenerate.d
    public final void a(Bitmap r5, ys8.a r6, c r7) {
        Intrinsics.checkNotNullParameter(r7, "ratioAutoSelectStrategy");
        if (r5 != null) goto L5;
        return;
    L5:
        Long r8 = r7.b(((double) r5.getWidth()) / ((double) r5.getHeight()));
        if (r8 == null) goto L11;
        r8.longValue();
        if (r6 == null) goto L12;
        r6.selectRatio(r8.longValue());
        return;
    L12:
        return;
    }
}
