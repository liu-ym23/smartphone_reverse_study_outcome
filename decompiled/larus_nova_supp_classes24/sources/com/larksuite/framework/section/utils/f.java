package com.larksuite.framework.section.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends com.ss.android.lark.ui.c {
    public final com.larksuite.framework.section.c d;
    public final com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] e;
    public long f;

    public final void performAction(View r5) {
        if ((System.currentTimeMillis() - this.f) >= 1000) goto L5;
        return;
    L5:
        this.f = System.currentTimeMillis();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r6 = this.e;
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2 = r6[r1];
        this.d.a(r2);
        r1 = r1 + 1;
        goto L6
    }

    public f(Drawable r2, com.larksuite.framework.section.c r3, com.ss.android.lark.todo.impl.features.detail.viewmodel.a... r4) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        Intrinsics.checkNotNullParameter(r4, "actions");
        super(r2);
        this.d = r3;
        this.e = r4;
    }
}
