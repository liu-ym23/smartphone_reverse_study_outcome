package com.ss.android.lark.flow.chat.mediapreview;

import android.view.View;
import kza.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FlowLargeImageView a;

    public b(FlowLargeImageView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        FlowLargeImageView r5 = this.a;
        if (r5.k == false) goto L5;
    L13:
        r5.k = false;
        r5.l = true;
        g r6 = r5.j;
        if (r6 == null) goto L16;
        r6.a(true);
    L16:
        g r7 = this.a.j;
        if (r7 == null) goto L22;
        r7.b(false);
        return;
    L22:
        return;
    L5:
        if (r5.l == false) goto L13;
        r5.k = true;
        r5.l = false;
        g r8 = r5.j;
        if (r8 == null) goto L10;
        r8.a(false);
    L10:
        g r9 = this.a.j;
        if (r9 == null) goto L20;
        r9.b(true);
        return;
    }
}
