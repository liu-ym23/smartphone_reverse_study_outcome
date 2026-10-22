package com.larus.bmhome.chat.service.action;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ NestedScrollView a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public i0(NestedScrollView r1, Ref.ObjectRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.scrollTo(0, 0);
        if (((com.larus.bmhome.taskskill.service.i) this.b.element).b == true) goto L5;
        return;
    L5:
        if (this.a.canScrollVertically(1) == true) goto L13;
        Object r10 = this.c.element;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("requestLoadMore");
        Function0 r11 = null;
    L10:
        r11.invoke();
        return;
    L9:
        r11 = (Function0) r10;
        goto L10
    }
}
