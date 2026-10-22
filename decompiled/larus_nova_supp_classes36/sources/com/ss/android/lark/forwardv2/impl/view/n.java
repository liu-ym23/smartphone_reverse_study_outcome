package com.ss.android.lark.forwardv2.impl.view;

import android.view.View;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.ForwardClickableEnhancedView;
import com.ss.android.lark.forwardv2.impl.statistics.ForwardHitParams$Click;
import com.ss.android.lark.log.Log;
import java.util.List;
import z5c.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ BasicDialogContent a;
    public final /* synthetic */ List b;
    public final /* synthetic */ d0 c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.k == false) goto L6;
        Log.i("TemplateForwardView", "forward preview is clickable");
        ForwardHitParams$Click r4 = ForwardHitParams$Click.MSG_DETAIL;
        s5c.a r0 = p3.c;
        s5c.d r1 = kib.c.a(this.c.h);
        s5c.d r5 = r4.plus(r0).plus(r1);
        int r2 = zib.e.a;
        zib.e.a.c(r5);
        d0 r6 = this.c;
        ((ForwardClickableEnhancedView) r6.j).s0(r6.b);
        return;
    }

    public n(d0 r1, BasicDialogContent r2, List r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
