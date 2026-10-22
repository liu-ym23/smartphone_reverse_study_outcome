package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.accessibilityLib_Core.processor.TraverseFromType;
import com.bytedance.android.accessibilityLib_Core.processor.ViewTraverseProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.e;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ AbstractAccessibilityLibIsolation a;
    public final /* synthetic */ View b;
    public final /* synthetic */ TraverseFromType c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r10) {
        if (("onViewAttachedToWindow " + r10) == null) goto L5;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L5:
        if (r10 == null) goto L8;
        Lazy r1 = ViewTraverseProcessor.a;
        ViewTraverseProcessor.b(r10, e.a(r10), this.c);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (("onViewDetachedToWindow, " + r10) == null) goto L6;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L6:
        AbstractAccessibilityLibIsolation.e(this.a, r10);
    }

    public a(AbstractAccessibilityLibIsolation r1, View r10, TraverseFromType r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
