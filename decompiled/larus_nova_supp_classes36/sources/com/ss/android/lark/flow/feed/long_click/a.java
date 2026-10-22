package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ FlowFeedDialogBuilder a;
    public final /* synthetic */ View.OnLayoutChangeListener b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        this.a.a.removeOnLayoutChangeListener(this.b);
        r3.removeOnAttachStateChangeListener(this);
    }

    public a(FlowFeedDialogBuilder r1, b r2) {
        this.a = r1;
        this.b = r2;
    }
}
