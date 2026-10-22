package com.obric.oui.panel;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.obric.oui.sheet.OBottomSheetDialog;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13998b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f13997a = r10;
        this.f13998b = r5;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
        switch(this.f13997a) {
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        super.onInitializeAccessibilityEvent(r5, r10);
        return;
    L6:
        super.onInitializeAccessibilityEvent(r5, r10);
        XSwiperUI r11 = (XSwiperUI) this.f13998b;
        if (((jn.b) XSwiperUI.m(r11)).f18363a == null) goto L24;
        r10.setClassName(jn.f.class.getName());
        if (r11.f10688z == true) goto L11;
    L17:
        boolean r12 = false;
    L18:
        r10.setScrollable(r12);
        if (r12 == true) goto L21;
        return;
    L21:
        if (r10.getEventType() != 4096) goto L26;
        r10.setItemCount(r11.D.size());
        return;
    L26:
        return;
    L11:
        if (((jn.b) XSwiperUI.r(r11)).f18363a == null) goto L17;
        ArrayList r13 = r11.D;
        if (r13 == null) goto L17;
        r12 = true;
        if (r13.size() <= 1) goto L17;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
        switch(this.f13997a) {
            case 0: goto L62;
            case 1: goto L57;
            case 2: goto L55;
            default: goto L4;
        };
    L4:
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        r10.setClassName(jn.f.class.getName());
        XSwiperUI r11 = (XSwiperUI) this.f13998b;
        if (r11.f10688z == true) goto L7;
    L13:
        boolean r12 = false;
    L14:
        r10.setScrollable(r12);
        if (((jn.b) XSwiperUI.p(r11)).f18363a == null) goto L24;
        ArrayList r13 = r11.D;
        if (r13 == null) goto L24;
        if (r13.isEmpty() == true) goto L24;
        if (r11.f10676m == false) goto L24;
        int r14 = r11.D.size();
    L26:
        if (((jn.b) XSwiperUI.q(r11)).f18363a == null) goto L36;
        ArrayList r15 = r11.D;
        if (r15 == null) goto L36;
        if (r15.isEmpty() == true) goto L36;
        if (r11.f10676m == true) goto L36;
        int r16 = r11.D.size();
    L37:
        r10.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r14, r16, false, 0));
        jn.f r17 = ((jn.b) XSwiperUI.n(r11)).f18363a;
        if (r12 == false) goto L67;
        if (r17 != null) goto L41;
        return;
    L41:
        if (r11.f10676m == false) goto L49;
        if (r17.canScrollVertically(1) == false) goto L46;
        r10.addAction(4096);
    L46:
        if (r17.canScrollVertically(-1) == false) goto L69;
        r10.addAction(8192);
        return;
    L69:
        return;
    L49:
        if (r17.canScrollHorizontally(1) == false) goto L52;
        r10.addAction(4096);
    L52:
        if (r17.canScrollHorizontally(-1) == false) goto L71;
        r10.addAction(8192);
        return;
    L71:
        return;
    L67:
        return;
    L36:
        r16 = 1;
    L24:
        r14 = 1;
        goto L26
    L7:
        if (((jn.b) XSwiperUI.r(r11)).f18363a == null) goto L13;
        ArrayList r18 = r11.D;
        if (r18 == null) goto L13;
        if (r18.size() <= 1) goto L13;
        r12 = true;
        goto L14
    L55:
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        r10.setScrollable(((BaseBehavior) this.f13998b).f14846n);
        r10.setClassName(ScrollView.class.getName());
        return;
    L57:
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        if (((OBottomSheetDialog) this.f13998b).d == false) goto L60;
        r10.addAction(1048576);
        r10.setDismissable(true);
        return;
    L60:
        r10.setDismissable(false);
        return;
    L62:
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        if (((BottomSheetDialog) this.f13998b).d == false) goto L65;
        r10.addAction(1048576);
        r10.setDismissable(true);
        return;
    L65:
        r10.setDismissable(false);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r5, int r10, Bundle r11) {
        switch(this.f13997a) {
            case 0: goto L46;
            case 1: goto L39;
            case 2: goto L5;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return super.performAccessibilityAction(r5, r10, r11);
    L7:
        if (super.performAccessibilityAction(r5, r10, r11) == true) goto L54;
        XSwiperUI r12 = (XSwiperUI) this.f13998b;
        jn.f r13 = ((jn.b) XSwiperUI.o(r12)).f18363a;
        if (r13 == null) goto L53;
        if (r13.getCurrentIndex() == (-1)) goto L53;
        int r14 = r13.getCurrentIndex();
        if (r10 == 4096) goto L29;
        if (r10 != 8192) goto L53;
        if (r12.f10676m == false) goto L23;
        if (r13.canScrollVertically(-1) == false) goto L23;
    L26:
        r12.setCurrentIndex(r14 - 1);
        return true;
    L23:
        if (r12.f10676m == true) goto L53;
        if (r13.canScrollHorizontally(-1) == false) goto L53;
    L29:
        if (r12.f10676m == false) goto L33;
        if (r13.canScrollVertically(1) == false) goto L33;
    L36:
        r12.setCurrentIndex(r14 + 1);
        return true;
    L33:
        if (r12.f10676m == true) goto L53;
        if (r13.canScrollHorizontally(1) == true) goto L36;
    L53:
        return false;
    L54:
        return true;
    L39:
        if (r10 != 1048576) goto L44;
        OBottomSheetDialog r15 = (OBottomSheetDialog) this.f13998b;
        if (r15.d == false) goto L44;
        r15.cancel();
        return true;
    L44:
        return super.performAccessibilityAction(r5, r10, r11);
    L46:
        if (r10 != 1048576) goto L51;
        BottomSheetDialog r16 = (BottomSheetDialog) this.f13998b;
        if (r16.d == false) goto L51;
        r16.cancel();
        return true;
    L51:
        return super.performAccessibilityAction(r5, r10, r11);
    }
}
