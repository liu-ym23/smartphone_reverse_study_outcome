package com.larus.bmhome.chat.component.trace;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatTraceComponent$b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatTraceComponent b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        ChatTraceComponent r0 = this.b;
        if (r0.C == true) goto L5;
        r0.C = true;
        FLogger.a.i("ChatTraceComponent ", "feedFirstShown by view: ".concat(this.a.getClass().getSimpleName()));
    L5:
        return true;
    }

    public ChatTraceComponent$b(View r1, ChatTraceComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
