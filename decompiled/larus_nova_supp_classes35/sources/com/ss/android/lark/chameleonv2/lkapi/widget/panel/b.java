package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.text.TextUtils;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ PanelBottomDialog a;
    public final /* synthetic */ PanelItem b;
    public final /* synthetic */ g c;

    public b(PanelBottomDialog r1, PanelItem r2, g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        g r0 = this.a.h;
        PanelItem r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (TextUtils.equals(r2, this.b.getId()) == false) goto L9;
        PanelBottomDialog r3 = this.a;
        r3.h = null;
        Intrinsics.checkNotNull(r6);
        r3.aa0(r6, false, this.c.c);
        return;
    L9:
        PanelBottomDialog r4 = this.a;
        g r5 = r4.h;
        if (r5 == null) goto L16;
        View r7 = r5.b;
        if (r7 == null) goto L16;
        if (r5 == null) goto L15;
        r1 = r5.c;
    L15:
        r4.aa0(r7, false, r1);
    L16:
        PanelBottomDialog r8 = this.a;
        r8.h = this.c;
        Intrinsics.checkNotNull(r6);
        r8.aa0(r6, true, this.c.c);
        return;
    L5:
        r2 = null;
        goto L7
    }
}
