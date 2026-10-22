package com.larus.bmhome.chat.mode;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ r(ModeSwitchComponent r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
        ModeSwitchComponent r0 = this.a;
        int r1 = ModeSwitchComponent.k0;
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "insets");
        boolean r5 = r4.isVisible(WindowInsetsCompat.Type.ime());
        if (r5 == r0.x) goto L7;
        r0.x = r5;
        r0.V3();
        if (r5 == true) goto L7;
        q r6 = r0.W;
        String r2 = r0.M;
        int r7 = r0.N;
        r6.a(r2, r7, r7);
    L7:
        return r4;
    }
}
