package com.ss.android.lark.flow.passport.ui.widget.layout;

import androidx.core.widget.NestedScrollView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ CommonContainerLayout a;

    public d(CommonContainerLayout r1) {
        this.a = r1;
    }

    public final void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        CommonContainerLayout r6 = this.a;
        int r7 = r6.R5(r6.getTitleBarContainer());
        CommonContainerLayout r8 = this.a;
        r8.b.getLocationOnScreen(r8.c);
        CommonContainerLayout r9 = this.a;
        int r10 = r9.c[1] + r9.b.getHeight();
        Function1<Integer, Unit> r11 = this.a.getOnContentScrollListener();
        if (r11 == null) goto L6;
        r11.invoke(Integer.valueOf(r10 - r7));
        return;
    }
}
