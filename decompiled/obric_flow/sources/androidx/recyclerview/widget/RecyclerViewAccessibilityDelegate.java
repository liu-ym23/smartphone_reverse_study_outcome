package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates;
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate r5) {
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = r5;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L7;
            return r11.dispatchPopulateAccessibilityEvent(r5, r10);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @Nullable
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r5) {
            AccessibilityDelegateCompat r10 = this.mOriginalItemDelegates.get(r5);
            if (r10 == null) goto L7;
            return r10.getAccessibilityNodeProvider(r5);
        L7:
            return super.getAccessibilityNodeProvider(r5);
        }

        public AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View r5) {
            return this.mOriginalItemDelegates.remove(r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L5;
            r11.onInitializeAccessibilityEvent(r5, r10);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View r5, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat r10) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == false) goto L5;
        L10:
            super.onInitializeAccessibilityNodeInfo(r5, r10);
            return;
        L5:
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L10;
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(r5, r10);
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L9;
            r11.onInitializeAccessibilityNodeInfo(r5, r10);
            return;
        L9:
            super.onInitializeAccessibilityNodeInfo(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L5;
            r11.onPopulateAccessibilityEvent(r5, r10);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r5, @NonNull View r10, @NonNull AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r5);
            if (r12 == null) goto L7;
            return r12.onRequestSendAccessibilityEvent(r5, r10, r11);
        L7:
            return super.onRequestSendAccessibilityEvent(r5, r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View r5, int r10, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle r11) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == true) goto L17;
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r5);
            if (r12 == null) goto L12;
            if (r12.performAccessibilityAction(r5, r10, r11) == false) goto L15;
            return true;
        L15:
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(r5, r10, r11);
        L12:
            if (super.performAccessibilityAction(r5, r10, r11) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r5, r10, r11);
        }

        public void saveOriginalDelegate(View r5) {
            AccessibilityDelegateCompat r10 = ViewCompat.getAccessibilityDelegate(r5);
            if (r10 == null) goto L7;
            if (r10 == this) goto L8;
            this.mOriginalItemDelegates.put(r5, r10);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(@NonNull View r5, int r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L5;
            r11.sendAccessibilityEvent(r5, r10);
            return;
        L5:
            super.sendAccessibilityEvent(r5, r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(@NonNull View r5, @NonNull AccessibilityEvent r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r5);
            if (r11 == null) goto L5;
            r11.sendAccessibilityEventUnchecked(r5, r10);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r5, r10);
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView r5) {
        this.mRecyclerView = r5;
        AccessibilityDelegateCompat r10 = getItemDelegate();
        if (r10 != null) goto L5;
    L7:
        this.mItemDelegate = new ItemDelegate(this);
        return;
    L5:
        if ((r10 instanceof ItemDelegate) == false) goto L7;
        this.mItemDelegate = (ItemDelegate) r10;
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View r5, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r5, r10);
        if ((r5 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r11 = (RecyclerView) r5;
        if (r11.getLayoutManager() == null) goto L12;
        r11.getLayoutManager().onInitializeAccessibilityEvent(r10);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View r5, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat r10) {
        super.onInitializeAccessibilityNodeInfo(r5, r10);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.mRecyclerView.getLayoutManager() == null) goto L9;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(r10);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View r5, int r10, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle r11) {
        if (super.performAccessibilityAction(r5, r10, r11) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.mRecyclerView.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(r10, r11);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
