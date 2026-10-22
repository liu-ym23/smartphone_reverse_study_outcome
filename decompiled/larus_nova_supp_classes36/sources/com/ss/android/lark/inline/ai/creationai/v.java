package com.ss.android.lark.inline.ai.creationai;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ CreationAIPanelController a;

    public v(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Log.i("CreationAIPanelController", "click panel view");
        long r0 = System.currentTimeMillis();
        CreationAIPanelController r10 = this.a;
        if ((r0 - r10.J) >= 200) goto L7;
        int r2 = r10.I + 1;
        r10.I = r2;
        if (r2 < 5) goto L8;
        r10.b.l();
        this.a.I = 0;
    L8:
        this.a.J = r0;
        return;
    L7:
        r10.I = 1;
        goto L8
    }
}
