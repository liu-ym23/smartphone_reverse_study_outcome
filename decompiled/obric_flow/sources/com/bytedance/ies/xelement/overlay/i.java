package com.bytedance.ies.xelement.overlay;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.obric.oui.panel.BottomSheetDialog;
import com.obric.oui.sheet.OBottomSheetDialog;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6502b;

    public /* synthetic */ i(Object r5, int r10) {
        this.f6501a = r10;
        this.f6502b = r5;
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View r5) {
        switch(this.f6501a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getAccessibilityNodeProvider(r5);
    L7:
        return ((com.lynx.tasm.behavior.ui.accessibility.d) this.f6502b).f10412l;
    L9:
        return (com.lynx.tasm.behavior.ui.f) this.f6502b;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
        switch(this.f6501a) {
            case 2: goto L12;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        super.onPopulateAccessibilityEvent(r5, r10);
        return;
    L6:
        super.onPopulateAccessibilityEvent(r5, r10);
        OBottomSheetDialog r11 = (OBottomSheetDialog) this.f6502b;
        if (r11.d == false) goto L9;
        int r12 = 1;
    L10:
        r5.setImportantForAccessibility(r12);
        r5.setScreenReaderFocusable(r11.d);
        r5.setContentDescription("关闭");
        ViewCompat.setAccessibilityDelegate(r5, new com.obric.oui.sheet.c());
        return;
    L9:
        r12 = 2;
        goto L10
    L12:
        super.onPopulateAccessibilityEvent(r5, r10);
        BottomSheetDialog r13 = (BottomSheetDialog) this.f6502b;
        if (r13.d == false) goto L15;
        int r14 = 1;
    L16:
        r5.setImportantForAccessibility(r14);
        r5.setScreenReaderFocusable(r13.d);
        r5.setContentDescription("关闭");
        ViewCompat.setAccessibilityDelegate(r5, new com.obric.oui.panel.e());
        return;
    L15:
        r14 = 2;
        goto L16
    }
}
