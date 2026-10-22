package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements OnApplyWindowInsetsListener {
    public final /* synthetic */ int a;

    public g(int r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "insets");
        int r0 = Math.max(r6.getInsets(WindowInsetsCompat.Type.ime()).bottom, r6.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
        int r1 = this.a + r0;
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r1);
        return r6;
    }
}
