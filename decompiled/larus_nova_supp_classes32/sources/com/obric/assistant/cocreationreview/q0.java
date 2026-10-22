package com.obric.assistant.cocreationreview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 {
    public final Context a;
    public final String b;
    public final Function0<Unit> c;
    public PopupWindow d;

    public final void b() {
        PopupWindow r0 = this.d;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.d = null;
    }

    public final RippleDrawable a(int r7) {
        Context r0 = this.a;
        StateListDrawable r1 = new StateListDrawable();
        r1.addState(new int[]{R.attr.state_selected}, c4.h(r0, 268435456, r7, 0, 0));
        r1.addState(new int[]{R.attr.state_focused}, c4.h(r0, 234881024, r7, 0, 0));
        r1.addState(new int[0], c4.h(r0, 0, r7, 0, 0));
        return new RippleDrawable(ColorStateList.valueOf(251658240), r1, c4.h(r0, -1, r7, 0, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(CocreationReviewActivity r2, String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "shortcutLabel");
        Intrinsics.checkNotNullParameter(r4, "onAddShortcut");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
