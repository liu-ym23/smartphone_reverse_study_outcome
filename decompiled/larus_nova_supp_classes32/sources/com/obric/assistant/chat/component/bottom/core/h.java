package com.obric.assistant.chat.component.bottom.core;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ObricChatInputComponent a;

    public /* synthetic */ h(ObricChatInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        ObricChatInputComponent r0 = this.a;
        Insets r6 = (Insets) r5;
        int r1 = ObricChatInputComponent.L0;
        Intrinsics.checkNotNullParameter(r6, "insets");
        f1 r2 = (f1) r0.i.getValue();
        int r3 = 0;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if (r2.sL() != true) goto L7;
    L8:
        r0.G = RangesKt.coerceAtLeast(r6.bottom - 56, 0);
        if (r0.F <= 0) goto L11;
    L13:
        FrameLayout r7 = r0.X2();
        if (r7 == null) goto L21;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L19:
        if (r9 == null) goto L22;
        r3 = r9.bottomMargin;
    L22:
        r0.p4(r3);
    L24:
        return Unit.INSTANCE;
    L18:
        r9 = null;
        goto L19
    L21:
        r3 = 56;
        goto L22
    L11:
        if (r0.H == true) goto L13;
        if (r4 == false) goto L24;
    L7:
        r4 = false;
        goto L8
    }
}
