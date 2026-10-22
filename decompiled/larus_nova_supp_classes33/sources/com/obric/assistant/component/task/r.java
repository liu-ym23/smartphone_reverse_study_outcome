package com.obric.assistant.component.task;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ View b;
    public final /* synthetic */ n c;
    public final /* synthetic */ int d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.element == true) goto L8;
        View r0 = this.b;
        if (r0 == null) goto L7;
        r0.setTranslationX(0.0f);
    L7:
        return true;
    L8:
        TaskPanelView r1 = this.c.f;
        int r2 = 0;
        if (r1 == null) goto L11;
        int r3 = r1.getLeft();
    L12:
        View r4 = this.b;
        if (r4 == null) goto L15;
        r2 = r4.getLeft();
    L15:
        View r5 = this.b;
        if (r5 == null) goto L18;
        r5.setTranslationX((this.d - r3) - r2);
    L18:
        return true;
    L11:
        r3 = 0;
        goto L12
    }

    public r(Ref.BooleanRef r1, View r2, n r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
