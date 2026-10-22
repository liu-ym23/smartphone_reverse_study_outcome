package com.obric.oui.window.permission;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements OnApplyWindowInsetsListener {
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10) {
        LinkedHashMap r11 = PrivacyStatementActivity.f14908x;
        int r12 = r10.getSystemWindowInsetTop();
        r10.getSystemWindowInsetBottom();
        r5.setPadding(r5.getPaddingLeft(), r12, r5.getPaddingRight(), 0);
        return r10;
    }
}
