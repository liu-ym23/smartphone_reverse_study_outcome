package com.larus.bmhome.chat.layout.item;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d3 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ c3 c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
        this.a.removeOnAttachStateChangeListener(this);
        if (this.b != this.c.e) goto L23;
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        View r9 = this.c.a;
        r6.element = r9;
        ViewParent r0 = r9.getParent();
    L7:
        if ((r0 instanceof View) == false) goto L12;
        if ((r0 instanceof RecyclerView) == true) goto L10;
        r9 = r0;
        r0 = r9.getParent();
        goto L7
    L10:
        r5.element = r0;
        r6.element = r9;
    L12:
        RecyclerView r10 = (RecyclerView) r5.element;
        if (r10 == null) goto L18;
        RecyclerView.ViewHolder r11 = r10.findContainingViewHolder(this.c.a);
        if (r11 == null) goto L18;
        View r12 = r11.itemView;
        if (r12 == null) goto L18;
    L19:
        r6.element = r12;
        View r2 = r12;
        OneShotPreDrawListener.add(r12, new f3(r2, this.b, this.c, r5, r6));
        return;
    L18:
        r12 = (View) r6.element;
        goto L19
    }

    public d3(View r1, int r2, c3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
