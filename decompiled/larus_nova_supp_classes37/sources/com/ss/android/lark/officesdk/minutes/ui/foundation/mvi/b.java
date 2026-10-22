package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements OnApplyWindowInsetsListener {
    public final /* synthetic */ MmBaseFragment a;

    public b(MmBaseFragment r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r6, WindowInsetsCompat r7) {
        Intrinsics.checkNotNullParameter(r6, "<unused var>");
        Intrinsics.checkNotNullParameter(r7, "insets");
        Insets r8 = r7.getInsets(WindowInsetsCompat.Type.systemBars());
        int r0 = r8.left;
        int r1 = r8.top;
        int r2 = r8.right;
        MmBaseFragment r3 = this.a;
        int r4 = MmBaseFragment.j;
        r3.getClass();
        Insets r5 = Insets.of(r0, r1, r2, xvb.a.a(r7));
        if (Intrinsics.areEqual(r8, this.a.f) == true) goto L6;
        this.a.f = r8;
    L6:
        if (Intrinsics.areEqual(r5, this.a.e) == true) goto L8;
        MmBaseFragment r9 = this.a;
        r9.e = r5;
        r9.Y90(r5.left, r5.top, r5.right, r5.bottom);
    L8:
        return r7;
    }
}
