package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f13772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemDelegate f13773b;

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerViewAccessibilityDelegate f13774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakHashMap f13775b;

        public ItemDelegate(RecyclerViewAccessibilityDelegate r5) {
            this.f13775b = new WeakHashMap();
            this.f13774a = r5;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean dispatchPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r11 == null) goto L7;
            return r11.dispatchPopulateAccessibilityEvent(r5, r10);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r5) {
            AccessibilityDelegateCompat r10 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r10 == null) goto L7;
            return r10.getAccessibilityNodeProvider(r5);
        L7:
            return super.getAccessibilityNodeProvider(r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r11 == null) goto L5;
            r11.onInitializeAccessibilityEvent(r5, r10);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
            RecyclerViewAccessibilityDelegate r11 = this.f13774a;
            if (r11.f13772a.G() == true) goto L17;
            RecyclerView r12 = r11.f13772a;
            if (r12.getLayoutManager() == null) goto L17;
            k0 r13 = r12.getLayoutManager();
            r13.getClass();
            x0 r14 = RecyclerView.F(r5);
            if (r14 != null) goto L9;
        L13:
            AccessibilityDelegateCompat r15 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r15 == null) goto L16;
            r15.onInitializeAccessibilityNodeInfo(r5, r10);
            return;
        L16:
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            return;
        L9:
            if (r14.isRemoved() == true) goto L13;
            com.google.common.reflect.w r16 = r13.f13838a;
            View r17 = r14.itemView;
            if (((ArrayList) r16.d).contains(r17) == true) goto L13;
            q0 r18 = r13.f13839b.f13728b;
        L17:
            super.onInitializeAccessibilityNodeInfo(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r11 == null) goto L5;
            r11.onPopulateAccessibilityEvent(r5, r10);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r12 == null) goto L7;
            return r12.onRequestSendAccessibilityEvent(r5, r10, r11);
        L7:
            return super.onRequestSendAccessibilityEvent(r5, r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r5, int r10, Bundle r11) {
            RecyclerViewAccessibilityDelegate r12 = this.f13774a;
            if (r12.f13772a.G() == true) goto L17;
            RecyclerView r13 = r12.f13772a;
            if (r13.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r14 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r14 == null) goto L12;
            if (r14.performAccessibilityAction(r5, r10, r11) == false) goto L14;
            return true;
        L14:
            q0 r15 = r13.getLayoutManager().f13839b.f13728b;
            return false;
        L12:
            if (super.performAccessibilityAction(r5, r10, r11) == false) goto L14;
            return true;
        L17:
            return super.performAccessibilityAction(r5, r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void sendAccessibilityEvent(View r5, int r10) {
            AccessibilityDelegateCompat r11 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r11 == null) goto L5;
            r11.sendAccessibilityEvent(r5, r10);
            return;
        L5:
            super.sendAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void sendAccessibilityEventUnchecked(View r5, AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = (AccessibilityDelegateCompat) this.f13775b.get(r5);
            if (r11 == null) goto L5;
            r11.sendAccessibilityEventUnchecked(r5, r10);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r5, r10);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView r5) {
        this.f13772a = r5;
        ItemDelegate r10 = this.f13773b;
        if (r10 == null) goto L5;
        this.f13773b = r10;
        return;
    L5:
        this.f13773b = new ItemDelegate(this);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r5, r10);
        if ((r5 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (this.f13772a.G() == true) goto L11;
        RecyclerView r11 = (RecyclerView) r5;
        if (r11.getLayoutManager() == null) goto L12;
        r11.getLayoutManager().H(r10);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfoCompat r10) {
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        RecyclerView r11 = this.f13772a;
        if (r11.G() == false) goto L5;
        return;
    L5:
        if (r11.getLayoutManager() == null) goto L19;
        k0 r12 = r11.getLayoutManager();
        RecyclerView r13 = r12.f13839b;
        q0 r14 = r13.f13728b;
        if (r13.canScrollVertically(-1) == false) goto L9;
    L10:
        r10.addAction(8192);
        r10.setScrollable(true);
    L12:
        if (r12.f13839b.canScrollVertically(1) == false) goto L14;
    L15:
        r10.addAction(4096);
        r10.setScrollable(true);
    L16:
        r10.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(-1, -1, false, 0));
        return;
    L14:
        if (r12.f13839b.canScrollHorizontally(1) == false) goto L16;
    L9:
        if (r12.f13839b.canScrollHorizontally(-1) == false) goto L12;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
        if (super.performAccessibilityAction(r10, r11, r12) == false) goto L5;
        return true;
    L5:
        RecyclerView r13 = this.f13772a;
        if (r13.G() == false) goto L8;
    L40:
        return false;
    L8:
        if (r13.getLayoutManager() == null) goto L40;
        k0 r14 = r13.getLayoutManager();
        q0 r15 = r14.f13839b.f13728b;
        int r16 = r14.f13845l;
        int r5 = r14.f13844k;
        Rect r17 = new Rect();
        if (r14.f13839b.getMatrix().isIdentity() == false) goto L15;
        if (r14.f13839b.getGlobalVisibleRect(r17) == false) goto L15;
        r16 = r17.height();
        r5 = r17.width();
    L15:
        if (r11 == 4096) goto L29;
        if (r11 == 8192) goto L20;
        int r18 = 0;
        int r19 = 0;
    L35:
        if (r19 != 0) goto L38;
        if (r18 != 0) goto L38;
        return false;
    L38:
        r14.f13839b.W(r18, r19, null, Integer.MIN_VALUE, true);
        return true;
    L20:
        if (r14.f13839b.canScrollVertically(-1) == false) goto L22;
        int r20 = -((r16 - r14.A()) - r14.x());
    L24:
        if (r14.f13839b.canScrollHorizontally(-1) == false) goto L27;
        int r21 = -((r5 - r14.y()) - r14.z());
    L26:
        r19 = r20;
        r18 = r21;
    L27:
        r19 = r20;
        r18 = 0;
        goto L35
    L22:
        r20 = 0;
        goto L24
    L29:
        if (r14.f13839b.canScrollVertically(1) == false) goto L31;
        r20 = (r16 - r14.A()) - r14.x();
    L33:
        if (r14.f13839b.canScrollHorizontally(1) == false) goto L27;
        r21 = (r5 - r14.y()) - r14.z();
        goto L26
    L31:
        r20 = 0;
        goto L33
    }
}
