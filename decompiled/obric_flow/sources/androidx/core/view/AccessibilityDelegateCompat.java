package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = null;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat r5) {
            this.mCompat = r5;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(r5, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r5) {
            AccessibilityNodeProviderCompat r10 = this.mCompat.getAccessibilityNodeProvider(r5);
            if (r10 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r10.getProvider();
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r5, AccessibilityEvent r10) {
            this.mCompat.onInitializeAccessibilityEvent(r5, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r5, AccessibilityNodeInfo r10) {
            AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
            r11.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(r5));
            r11.setHeading(ViewCompat.isAccessibilityHeading(r5));
            r11.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(r5));
            r11.setStateDescription(ViewCompat.getStateDescription(r5));
            this.mCompat.onInitializeAccessibilityNodeInfo(r5, r11);
            r11.addSpansToExtras(r10.getText(), r5);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r12 = AccessibilityDelegateCompat.getActionList(r5);
            int r13 = 0;
        L4:
            if (r13 >= r12.size()) goto L6;
            r11.addAction(r12.get(r13));
            r13 = r13 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r5, AccessibilityEvent r10) {
            this.mCompat.onPopulateAccessibilityEvent(r5, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r5, View r10, AccessibilityEvent r11) {
            return this.mCompat.onRequestSendAccessibilityEvent(r5, r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r5, int r10, Bundle r11) {
            return this.mCompat.performAccessibilityAction(r5, r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r5, int r10) {
            this.mCompat.sendAccessibilityEvent(r5, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r5, AccessibilityEvent r10) {
            this.mCompat.sendAccessibilityEventUnchecked(r5, r10);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r5) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r10 = (List) r5.getTag(R.id.tag_accessibility_actions);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    private boolean isSpanStillValid(ClickableSpan r5, View r10) {
        if (r5 == null) goto L13;
        ClickableSpan[] r11 = AccessibilityNodeInfoCompat.getClickableSpans(r10.createAccessibilityNodeInfo().getText());
        int r12 = 0;
    L5:
        if (r11 == null) goto L13;
        if (r12 >= r11.length) goto L13;
        if (r5.equals(r11[r12]) == true) goto L10;
        r12 = r12 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    private boolean performClickableSpanAction(int r5, View r10) {
        SparseArray r11 = (SparseArray) r10.getTag(R.id.tag_accessibility_clickable_spans);
        if (r11 == null) goto L10;
        WeakReference r12 = (WeakReference) r11.get(r5);
        if (r12 == null) goto L12;
        ClickableSpan r13 = (ClickableSpan) r12.get();
        if (isSpanStillValid(r13, r10) == false) goto L13;
        r13.onClick(r10);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r5, r10);
    }

    @Nullable
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r5) {
        AccessibilityNodeProvider r10 = this.mOriginalDelegate.getAccessibilityNodeProvider(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new AccessibilityNodeProviderCompat(r10);
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r5, r10);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull View r5, @NonNull AccessibilityNodeInfoCompat r10) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r5, r10.unwrap());
    }

    public void onPopulateAccessibilityEvent(@NonNull View r5, @NonNull AccessibilityEvent r10) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r5, r10);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r5, @NonNull View r10, @NonNull AccessibilityEvent r11) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r5, r10, r11);
    }

    public boolean performAccessibilityAction(@NonNull View r10, int r11, @Nullable Bundle r12) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r5 = getActionList(r10);
        boolean r13 = false;
        int r14 = 0;
    L4:
        if (r14 >= r5.size()) goto L9;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r15 = r5.get(r14);
        if (r15.getId() == r11) goto L7;
        r14 = r14 + 1;
        goto L4
    L7:
        r13 = r15.perform(r10, r12);
    L9:
        if (r13 == true) goto L11;
        r13 = this.mOriginalDelegate.performAccessibilityAction(r10, r11, r12);
    L11:
        if (r13 == false) goto L13;
        return r13;
    L13:
        if (r11 != R.id.accessibility_action_clickable_span) goto L20;
        if (r12 != null) goto L16;
        return r13;
    L16:
        return performClickableSpanAction(r12.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r10);
    L20:
        return r13;
    }

    public void sendAccessibilityEvent(@NonNull View r5, int r10) {
        this.mOriginalDelegate.sendAccessibilityEvent(r5, r10);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View r5, @NonNull AccessibilityEvent r10) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate r5) {
        this.mOriginalDelegate = r5;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
