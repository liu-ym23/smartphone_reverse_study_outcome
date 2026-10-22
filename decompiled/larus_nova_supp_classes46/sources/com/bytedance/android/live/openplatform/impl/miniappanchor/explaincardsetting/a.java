package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ int a;

    public a(int r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Object[] r0 = new Object[1];
        if (this.a != 1) goto L5;
        String r4 = s1.B(2131920395);
    L6:
        r0[0] = r4;
        f2.c(s1.C(2131920397, r0), 0);
        return;
    L5:
        r4 = "";
        goto L6
    }
}
