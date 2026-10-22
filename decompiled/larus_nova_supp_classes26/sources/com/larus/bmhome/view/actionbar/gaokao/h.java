package com.larus.bmhome.view.actionbar.gaokao;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements OnApplyWindowInsetsListener {
    public final /* synthetic */ GaokaoPreferenceDialog a;
    public final /* synthetic */ LinearLayout b;

    public /* synthetic */ h(GaokaoPreferenceDialog r1, LinearLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r10, WindowInsetsCompat r11) {
        final GaokaoPreferenceDialog r0 = this.a;
        LinearLayout r1 = this.b;
        int r2 = GaokaoPreferenceDialog.s;
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "insets");
        Insets r3 = r11.getInsets(WindowInsetsCompat.Type.ime());
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if ((r4 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r4;
    L6:
        if (r5 != null) goto L9;
    L19:
        return r11;
    L9:
        if (r3.bottom > 0) goto L11;
        r5.height = -2;
    L15:
        int r6 = r0.V90();
        int r7 = r3.bottom;
        if (r7 <= 0) goto L18;
        r6 = r7;
    L18:
        r5.bottomMargin = r6;
        r10.requestLayout();
        goto L19
    L11:
        if ((r10.getMeasuredHeight() + r3.bottom) <= r0.W90()) goto L13;
        r5.height = (r0.W90() - r3.bottom) - r0.getResources().getDimensionPixelSize(v19.c.b(2130971155, null, 2131166679));
    L13:
        r1.post(new i(r0));
        goto L15
    L5:
        r5 = null;
        goto L6
    }
}
