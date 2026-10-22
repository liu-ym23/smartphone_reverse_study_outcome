package com.obric.assistant.interaction.impl.window;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/assistant/interaction/impl/window/WindowHost$traceWindowOpenToPreDraw$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHost$traceWindowOpenToPreDraw$listener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $decorView;
    final /* synthetic */ com.obric.assistant.common.utils.i.a $traceSection;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ViewTreeObserver r0 = this.$decorView.getViewTreeObserver();
        if (r0.isAlive() == false) goto L5;
        r0.removeOnPreDrawListener(this);
    L5:
        WindowHost.access$endWindowOpenToPreDrawTrace(WindowHost.INSTANCE, this.$traceSection);
        return true;
    }

    public WindowHost$traceWindowOpenToPreDraw$listener$1(View r1, com.obric.assistant.common.utils.i.a r2) {
        this.$decorView = r1;
        this.$traceSection = r2;
    }
}
