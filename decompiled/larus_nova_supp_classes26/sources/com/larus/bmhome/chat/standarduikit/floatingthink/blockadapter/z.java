package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ FloatingThinkDetailRootFragment a;
    public final /* synthetic */ BottomSheetBehavior<View> b;

    public z(FloatingThinkDetailRootFragment r1, BottomSheetBehavior<View> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onSlide(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (this.a.f == true) goto L5;
    L10:
        this.a.S90(r2);
        return;
    L5:
        if (r3 > 0.05f) goto L10;
        if (this.b.getState() == 5) goto L10;
        this.b.setState(5);
    }

    public final void onStateChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        if (r4 != 3) goto L5;
        this.a.f = true;
        this.b.setSkipCollapsed(true);
    L21:
        FloatingThinkDetailRootFragment r5 = this.a;
        int r0 = FloatingThinkDetailRootFragment.j;
        r5.S90(r3);
        return;
    L5:
        if (r4 == 4) goto L17;
        if (r4 != 5) goto L21;
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L25;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L17:
        if (this.a.f == false) goto L21;
        this.b.setState(5);
    }
}
