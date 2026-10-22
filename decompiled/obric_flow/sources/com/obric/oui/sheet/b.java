package com.obric.oui.sheet;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends View.AccessibilityDelegate {
    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r10, "info");
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        r10.setClassName("android.widget.ImageButton");
    }
}
