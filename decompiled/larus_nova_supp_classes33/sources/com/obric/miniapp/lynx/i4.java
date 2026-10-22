package com.obric.miniapp.lynx;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class i4 extends FrameLayout {
    public i4(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean r1) {
        if (r1 == true) goto L5;
        super.dispatchSetPressed(false);
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        if (r1 == false) goto L4;
        return;
    L4:
        if (isPressed() == false) goto L8;
        super.setPressed(false);
        return;
    }
}
