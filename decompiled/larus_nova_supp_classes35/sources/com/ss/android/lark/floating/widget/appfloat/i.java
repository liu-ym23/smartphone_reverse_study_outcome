package com.ss.android.lark.floating.widget.appfloat;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements WindowManager {
    public final WindowManager a;

    @Override // android.view.WindowManager
    @Deprecated(message = "Deprecated in Java")
    public final Display getDefaultDisplay() {
        return this.a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View r2) {
        this.a.removeViewImmediate(r2);
    }

    public i(WindowManager r2) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.a = r2;
    }

    @Override // android.view.ViewManager
    public final void removeView(View r2) {
        this.a.removeView(r2);
    }

    @Override // android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        if ((r3 instanceof WindowManagerLayoutParamsInternal) == false) goto L7;
        WindowManager r0 = this.a;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r2, r3);
        r0.addView(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View r3, ViewGroup.LayoutParams r4) {
        if ((r4 instanceof WindowManagerLayoutParamsInternal) == false) goto L13;
        if (r3 == null) goto L8;
        boolean r1 = true;
        if (r3.isAttachedToWindow() != true) goto L8;
    L9:
        if (r1 == false) goto L14;
        this.a.updateViewLayout(r3, r4);
        return;
    L14:
        return;
    L8:
        r1 = false;
        goto L9
    L13:
        throw new IllegalArgumentException();
    }
}
