package com.larus.bmhome.chat.service.action;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ NestedScrollView a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ Ref.ObjectRef f;

    public h0(NestedScrollView r1, boolean r2, int r3, Ref.ObjectRef r4, Ref.BooleanRef r5, Ref.ObjectRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        NestedScrollView r10 = this.a;
        if (this.b == false) goto L5;
        int r11 = 0;
    L6:
        r10.scrollTo(0, r11);
        if (((com.larus.bmhome.taskskill.service.i) this.d.element).b == true) goto L9;
        return;
    L9:
        if (this.e.element == false) goto L11;
        return;
    L11:
        if (this.a.canScrollVertically(1) == true) goto L20;
        Object r12 = this.f.element;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestLoadMore");
        Function0 r13 = null;
    L16:
        r13.invoke();
        return;
    L15:
        r13 = (Function0) r12;
        goto L16
    L20:
        return;
    L5:
        r11 = this.c;
        goto L6
    }
}
