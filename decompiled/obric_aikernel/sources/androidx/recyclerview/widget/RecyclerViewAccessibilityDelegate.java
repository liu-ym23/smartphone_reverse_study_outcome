package androidx.recyclerview.widget;

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

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate r10) {
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = r10;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L7;
            return r12.dispatchPopulateAccessibilityEvent(r10, r11);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @Nullable
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r10) {
            AccessibilityDelegateCompat r11 = this.mOriginalItemDelegates.get(r10);
            if (r11 == null) goto L7;
            return r11.getAccessibilityNodeProvider(r10);
        L7:
            return super.getAccessibilityNodeProvider(r10);
        }

        AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View r10) {
            return this.mOriginalItemDelegates.remove(r10);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L5;
            r12.onInitializeAccessibilityEvent(r10, r11);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == false) goto L5;
        L9:
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            return;
        L5:
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L9;
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(r10, r11);
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L9;
            r12.onInitializeAccessibilityNodeInfo(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L5;
            r12.onPopulateAccessibilityEvent(r10, r11);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r10, @NonNull View r11, @NonNull AccessibilityEvent r12) {
            AccessibilityDelegateCompat r13 = this.mOriginalItemDelegates.get(r10);
            if (r13 == null) goto L7;
            return r13.onRequestSendAccessibilityEvent(r10, r11, r12);
        L7:
            return super.onRequestSendAccessibilityEvent(r10, r11, r12);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == true) goto L17;
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r13 = this.mOriginalItemDelegates.get(r10);
            if (r13 == null) goto L12;
            if (r13.performAccessibilityAction(r10, r11, r12) == false) goto L15;
            return true;
        L15:
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(r10, r11, r12);
        L12:
            if (super.performAccessibilityAction(r10, r11, r12) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r10, r11, r12);
        }

        void saveOriginalDelegate(View r10) {
            AccessibilityDelegateCompat r11 = ViewCompat.getAccessibilityDelegate(r10);
            if (r11 == null) goto L7;
            if (r11 == this) goto L8;
            this.mOriginalItemDelegates.put(r10, r11);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(@NonNull View r10, int r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L5;
            r12.sendAccessibilityEvent(r10, r11);
            return;
        L5:
            super.sendAccessibilityEvent(r10, r11);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(@NonNull View r10, @NonNull AccessibilityEvent r11) {
            AccessibilityDelegateCompat r12 = this.mOriginalItemDelegates.get(r10);
            if (r12 == null) goto L5;
            r12.sendAccessibilityEventUnchecked(r10, r11);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r10, r11);
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView r10) {
        this.mRecyclerView = r10;
        AccessibilityDelegateCompat r11 = getItemDelegate();
        if (r11 != null) goto L5;
    L7:
        ItemDelegate r12 = new ItemDelegate(this);
    L8:
        this.mItemDelegate = r12;
        return;
    L5:
        if ((r11 instanceof ItemDelegate) == false) goto L7;
        r12 = (ItemDelegate) r11;
        goto L8
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
        super.onInitializeAccessibilityEvent(r10, r11);
        if ((r10 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r12 = (RecyclerView) r10;
        if (r12.getLayoutManager() == null) goto L12;
        r12.getLayoutManager().onInitializeAccessibilityEvent(r11);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
        super.onInitializeAccessibilityNodeInfo(r10, r11);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.mRecyclerView.getLayoutManager() == null) goto L9;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(r11);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
        if (super.performAccessibilityAction(r10, r11, r12) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.mRecyclerView.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(r11, r12);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
