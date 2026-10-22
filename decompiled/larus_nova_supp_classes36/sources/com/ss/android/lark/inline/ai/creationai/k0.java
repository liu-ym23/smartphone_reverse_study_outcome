package com.ss.android.lark.inline.ai.creationai;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k0 implements View.OnClickListener {
    public final /* synthetic */ g0 a;

    public k0(g0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Log.i("SubPanelController", "click panel view");
        long r0 = System.currentTimeMillis();
        g0 r10 = this.a;
        if ((r0 - r10.q) >= 200) goto L7;
        int r2 = r10.p + 1;
        r10.p = r2;
        if (r2 < 5) goto L8;
        r10.b.l();
        this.a.p = 0;
    L8:
        this.a.q = r0;
        return;
    L7:
        r10.p = 1;
        goto L8
    }
}
