package com.obric.oui.common.util;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/oui/common/util/ViewExtensionsKt$setButtonAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewExtensionsKt$setButtonAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        if (r10 == null) goto L7;
        r10.setClassName("android.widget.Button");
    L7:
        if (StringsKt.isBlank(null) == true) goto L12;
        if (r10 == null) goto L13;
        r10.setContentDescription(null);
        return;
    L13:
        return;
    }
}
