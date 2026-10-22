package com.obric.oui.common.util;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/common/util/ViewExtensionsKt$setA11yRole$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewExtensionsKt$setA11yRole$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ String $roleDesc;

    ViewExtensionsKt$setA11yRole$1(String r1) {
        this.$roleDesc = r1;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
        super.onInitializeAccessibilityNodeInfo(r2, r3);
        if (r3 == null) goto L7;
        r3.setRoleDescription((CharSequence) ZeusTransformUtils.preCheckCast(this.$roleDesc, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    }
}
