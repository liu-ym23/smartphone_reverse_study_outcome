package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PromptCell$c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ PromptCell b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        this.a.removeOnAttachStateChangeListener(this);
        PromptCell r6 = this.b;
        long r0 = AppHost.a.getAppClock().currentTimeMillis();
        r6.P = (int) (r0 ^ (r0 >>> 32));
    }

    public PromptCell$c(PromptSpan r1, PromptCell r2) {
        this.a = r1;
        this.b = r2;
    }
}
