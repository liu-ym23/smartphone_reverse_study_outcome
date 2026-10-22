package com.obric.assistant.view;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public i(View r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        PopupWindow r3 = j.a;
        if (r3 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
    L5:
        this.a.removeOnAttachStateChangeListener(this);
    }
}
