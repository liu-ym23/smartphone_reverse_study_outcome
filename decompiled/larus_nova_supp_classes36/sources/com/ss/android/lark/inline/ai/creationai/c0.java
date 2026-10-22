package com.ss.android.lark.inline.ai.creationai;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0 implements com.ss.android.lark.inline.ai.creationai.editor.l {
    public final /* synthetic */ CreationAIPanelController a;

    @Override // com.ss.android.lark.inline.ai.creationai.editor.l
    public final void b() {
        if (this.a.n() == false) goto L6;
        this.a.m();
        return;
    }

    public c0(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.l
    public final void a(RenderProcessGoneDetail r4) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        if (r4 == null) goto L6;
        Boolean r5 = Boolean.valueOf(r4.didCrash());
    L7:
        String r6 = String.valueOf(r5);
    L9:
        Log.i("CreationAIPanelController", "onRenderProcessGone== crash: ".concat(r6));
        this.a.i();
        int r0 = d0.b;
        d0.a.a(406, "render gone, crash: " + r6 + '}', 0);
        return;
    L6:
        r5 = null;
        goto L7
    L8:
        r6 = InvRouter.UNKNOWN;
        goto L9
    }
}
