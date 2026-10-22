package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements OnApplyWindowInsetsListener {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;

    public h(DoubaoForwardConfirmFragment r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r6, WindowInsetsCompat r7) {
        Intrinsics.checkNotNullParameter(r6, "<unused var>");
        Intrinsics.checkNotNullParameter(r7, "insets");
        boolean r8 = r7.isVisible(WindowInsetsCompat.Type.ime());
        int r0 = 0;
        if (r8 == false) goto L5;
        int r1 = r7.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L6:
        int r2 = r7.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        DoubaoForwardConfirmFragment r3 = this.a;
        if (r3.s == true) goto L9;
        DoubaoForwardConfirmFragment.T90(r3, r1, true);
    L9:
        DoubaoForwardConfirmFragment r4 = this.a;
        View r5 = r4.n;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        r5 = null;
    L12:
        if (r8 == true) goto L15;
        r0 = r2;
    L15:
        DoubaoForwardConfirmFragment.S90(r4, r5, r0);
        return r7;
    L5:
        r1 = 0;
        goto L6
    }
}
