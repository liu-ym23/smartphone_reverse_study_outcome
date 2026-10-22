package com.bytedance.android.ec.common.impl.sku.view;

import android.text.TextUtils;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ n a;
    public final /* synthetic */ n.c b;

    public q(n r1, n.c r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        n r11 = this.a;
        if (r11.p == true) goto L5;
        return;
    L5:
        if (this.b.a == false) goto L32;
        n.c r12 = r11.g;
        if (r12 == null) goto L12;
        Intrinsics.checkNotNull(r12);
        if (TextUtils.equals(r12.b, this.b.b) == false) goto L12;
        n r13 = this.a;
        r13.g = null;
        r13.h = false;
        r13.e(null);
    L17:
        n.b r14 = this.a.k;
        if (r14 == null) goto L20;
        r14.c();
    L20:
        n r15 = this.a;
        n.b r1 = r15.k;
        if (r1 == null) goto L23;
        r1.d(r15.j, r15.g, false);
    L23:
        n r16 = this.a;
        if (r16.g == null) goto L30;
        n.b r17 = r16.k;
        if (r17 == null) goto L31;
        r17.a();
        return;
    L31:
        return;
    L30:
        return;
    L12:
        n.c r18 = this.b;
        if (r18.a == false) goto L17;
        n r19 = this.a;
        r19.g = r18;
        r19.h = true;
        Intrinsics.checkNotNull(r18);
        r19.e(r18.b);
        n r20 = this.a;
        n.b r21 = r20.k;
        if (r21 == null) goto L17;
        r21.b(r20.j);
        goto L17
    }
}
