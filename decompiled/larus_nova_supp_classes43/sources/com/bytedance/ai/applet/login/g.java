package com.bytedance.ai.applet.login;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends BottomSheetBehavior.b {
    public final /* synthetic */ f a;

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
    public final void a(View r1, float r10) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public g(f r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
    public final void b(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        this.a.getClass();
        com.bytedance.ai.utils.g.a.d("DrawerWidgetContainer", "onStateChanged: newState=" + r11);
        if (r11 != 3) goto L5;
        this.a.getClass();
        ViewGroup r12 = this.a.b;
        if (r12 == null) goto L18;
        r12.setVisibility(0);
        return;
    L18:
        return;
    L5:
        if (r11 != 4) goto L7;
    L9:
        this.a.getClass();
        ViewGroup r13 = this.a.b;
        if (r13 == null) goto L16;
        r13.setVisibility(8);
        return;
    L16:
        return;
    L7:
        if (r11 == 5) goto L9;
    }
}
