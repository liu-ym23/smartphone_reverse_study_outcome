package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/banner/OBanner$initViewPager2$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBanner$initViewPager2$2 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
        if (r11 == null) goto L7;
        if (r11.getEventType() != 4096) goto L7;
        int r12 = OBanner.A;
        throw null;
    L7:
        return super.onRequestSendAccessibilityEvent(r5, r10, r11);
    }
}
