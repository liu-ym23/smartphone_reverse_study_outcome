package com.obric.assistant.component;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a5 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> a;
    public final /* synthetic */ OrionChatSpeakerComponent b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.removeOnAttachStateChangeListener(this);
        ViewTreeObserver.OnGlobalLayoutListener r0 = (ViewTreeObserver.OnGlobalLayoutListener) this.a.element;
        if (r0 == null) goto L7;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 == null) goto L7;
        r3.removeOnGlobalLayoutListener(r0);
    L7:
        this.b.w = false;
    }

    public a5(Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> r1, OrionChatSpeakerComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
