package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d {
    public a() {
    }

    @Override // com.larus.uaigc.createpage.component.videogenerate.d
    public final void a(Bitmap r3, ys8.a r4, c r5) {
        Intrinsics.checkNotNullParameter(r5, "ratioAutoSelectStrategy");
        if (r4 == null) goto L7;
        boolean r6 = true;
        if (r4.Wm() != true) goto L7;
    L8:
        if (r6 == true) goto L12;
        if (r4 == null) goto L13;
        r4.selectRatio(0);
        return;
    L13:
        return;
    L12:
        return;
    L7:
        r6 = false;
        goto L8
    }
}
