package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ WeakReference a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r0 = (View) this.a.get();     // Catch: Exception -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAttachedToWindow() == true) goto L7;
        return;
    L7:
        Lazy r1 = ViewTraverseProcessor.a;     // Catch: Exception -> L10
        ViewTraverseProcessor.b(r0, com.bytedance.android.accessibilityLib_Core.tool.e.a(r0), TraverseFromType.ActivityGlobalLayoutChange);     // Catch: Exception -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L14;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L14:
        Unit r12 = Unit.INSTANCE;
    }

    public d(WeakReference r1) {
        this.a = r1;
    }
}
