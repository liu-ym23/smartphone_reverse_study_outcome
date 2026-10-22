package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/obric/oui/banner/OBanner$initViewPager2$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/ViewGroup;", "host", "Landroid/view/View;", "child", "Landroid/view/accessibility/AccessibilityEvent;", NotificationCompat.CATEGORY_EVENT, "", "onRequestSendAccessibilityEvent", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBanner$initViewPager2$2 extends AccessibilityDelegateCompat {
    final /* synthetic */ OBanner this$0;

    OBanner$initViewPager2$2(OBanner r10) {
        this.this$0 = r10;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
        if (r12 == null) goto L9;
        if (r12.getEventType() != 4096) goto L9;
        int r13 = OBanner.g(this.this$0).getRealItemCount();
        r12.setItemCount(r13);
        if (r13 <= 0) goto L9;
        r12.setFromIndex(this.this$0.getViewPager2().getCurrentItem() % r13);
        r12.setToIndex(this.this$0.getViewPager2().getCurrentItem() % r13);
    L9:
        return super.onRequestSendAccessibilityEvent(r10, r11, r12);
    }
}
