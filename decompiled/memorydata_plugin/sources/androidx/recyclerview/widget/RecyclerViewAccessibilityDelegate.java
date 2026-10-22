package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates;
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate r2) {
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = r2;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return r0.dispatchPopulateAccessibilityEvent(r4, r5);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r4) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return r0.getAccessibilityNodeProvider(r4);
        L7:
            return super.getAccessibilityNodeProvider(r4);
        }

        AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View r2) {
            return (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.remove(r2), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            r0.onInitializeAccessibilityEvent(r4, r5);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfoCompat r5) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == false) goto L5;
        L9:
            super.onInitializeAccessibilityNodeInfo(r4, r5);
            return;
        L5:
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L9;
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(r4, r5);
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L9;
            r0.onInitializeAccessibilityNodeInfo(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            r0.onPopulateAccessibilityEvent(r4, r5);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r4, View r5, AccessibilityEvent r6) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return r0.onRequestSendAccessibilityEvent(r4, r5, r6);
        L7:
            return super.onRequestSendAccessibilityEvent(r4, r5, r6);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r4, int r5, Bundle r6) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == true) goto L17;
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L12;
            if (r0.performAccessibilityAction(r4, r5, r6) == false) goto L15;
            return true;
        L15:
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(r4, r5, r6);
        L12:
            if (super.performAccessibilityAction(r4, r5, r6) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r4, r5, r6);
        }

        void saveOriginalDelegate(View r2) {
            AccessibilityDelegateCompat r0 = ViewCompat.getAccessibilityDelegate(r2);
            if (r0 == null) goto L7;
            if (r0 == this) goto L8;
            this.mOriginalItemDelegates.put(r2, r0);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(View r4, int r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            r0.sendAccessibilityEvent(r4, r5);
            return;
        L5:
            super.sendAccessibilityEvent(r4, r5);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(View r4, AccessibilityEvent r5) {
            AccessibilityDelegateCompat r0 = (AccessibilityDelegateCompat) ZeusTransformUtils.preCheckCast(this.mOriginalItemDelegates.get(r4), AccessibilityDelegateCompat.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            r0.sendAccessibilityEventUnchecked(r4, r5);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r4, r5);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView r3) {
        this.mRecyclerView = r3;
        AccessibilityDelegateCompat r4 = getItemDelegate();
        if (r4 != null) goto L5;
    L7:
        ItemDelegate r5 = new ItemDelegate(this);
    L8:
        this.mItemDelegate = r5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ItemDelegate.class) == false) goto L7;
        r5 = (ItemDelegate) ZeusTransformUtils.preCheckCast(r4, ItemDelegate.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r2, r3);
        if (ZeusTransformUtils.instanceOf(r2, RecyclerView.class) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r2, RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1.getLayoutManager() == null) goto L12;
        r1.getLayoutManager().onInitializeAccessibilityEvent(r3);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.mRecyclerView.getLayoutManager() == null) goto L9;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(r2);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
        if (super.performAccessibilityAction(r1, r2, r3) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.mRecyclerView.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(r2, r3);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
