package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 a;
    public final /* synthetic */ PaidQueueTabView b;

    public a(PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r1, PaidQueueTabView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.b.m = 42;
        PaidQueueTabView r3 = this.b;
        Function1<? super Integer, Unit> r0 = r3.i;
        if (r0 == null) goto L5;
        Unit r4 = (Unit) r0.invoke(r3.m);
    L5:
        this.a.invoke(this.b.m.intValue());
        c90.a r5 = this.b.a;
        if (r5 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r5);
        r5.dismiss();
        return;
    }
}
