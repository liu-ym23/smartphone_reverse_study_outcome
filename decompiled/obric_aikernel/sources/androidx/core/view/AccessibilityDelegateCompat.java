package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat r10) {
            this.mCompat = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r10) {
            AccessibilityNodeProviderCompat r11 = this.mCompat.getAccessibilityNodeProvider(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r11.getProvider();
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r10, AccessibilityEvent r11) {
            this.mCompat.onInitializeAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.wrap(r11);
            r12.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(r10));
            r12.setHeading(ViewCompat.isAccessibilityHeading(r10));
            r12.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(r10));
            r12.setStateDescription(ViewCompat.getStateDescription(r10));
            this.mCompat.onInitializeAccessibilityNodeInfo(r10, r12);
            r12.addSpansToExtras(r11.getText(), r10);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r13 = AccessibilityDelegateCompat.getActionList(r10);
            int r14 = 0;
        L4:
            if (r14 >= r13.size()) goto L6;
            r12.addAction(r13.get(r14));
            r14 = r14 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r10, AccessibilityEvent r11) {
            this.mCompat.onPopulateAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r10, View r11, AccessibilityEvent r12) {
            return this.mCompat.onRequestSendAccessibilityEvent(r10, r11, r12);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r10, int r11, Bundle r12) {
            return this.mCompat.performAccessibilityAction(r10, r11, r12);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r10, int r11) {
            this.mCompat.sendAccessibilityEvent(r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r10, AccessibilityEvent r11) {
            this.mCompat.sendAccessibilityEventUnchecked(r10, r11);
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static AccessibilityNodeProvider getAccessibilityNodeProvider(View.AccessibilityDelegate r10, View r11) {
            return r10.getAccessibilityNodeProvider(r11);
        }

        @DoNotInline
        static boolean performAccessibilityAction(View.AccessibilityDelegate r10, View r11, int r12, Bundle r13) {
            return r10.performAccessibilityAction(r11, r12, r13);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate r10) {
        this.mOriginalDelegate = r10;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r10) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r11 = (List) r10.getTag(R.id.tag_accessibility_actions);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    private boolean isSpanStillValid(ClickableSpan r10, View r11) {
        if (r10 == null) goto L13;
        ClickableSpan[] r12 = AccessibilityNodeInfoCompat.getClickableSpans(r11.createAccessibilityNodeInfo().getText());
        int r13 = 0;
    L5:
        if (r12 == null) goto L13;
        if (r13 >= r12.length) goto L13;
        if (r10.equals(r12[r13]) == true) goto L10;
        r13 = r13 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    private boolean performClickableSpanAction(int r10, View r11) {
        SparseArray r12 = (SparseArray) r11.getTag(R.id.tag_accessibility_clickable_spans);
        if (r12 == null) goto L10;
        WeakReference r13 = (WeakReference) r12.get(r10);
        if (r13 == null) goto L12;
        ClickableSpan r14 = (ClickableSpan) r13.get();
        if (isSpanStillValid(r14, r11) == false) goto L13;
        r14.onClick(r11);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r10, r11);
    }

    @Nullable
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r10) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r11 = Api16Impl.getAccessibilityNodeProvider(this.mOriginalDelegate, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r11);
    L8:
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r10, r11);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull View r10, @NonNull AccessibilityNodeInfoCompat r11) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r10, r11.unwrap());
    }

    public void onPopulateAccessibilityEvent(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r10, r11);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r10, @NonNull View r11, @NonNull AccessibilityEvent r12) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r10, r11, r12);
    }

    public boolean performAccessibilityAction(@NonNull View r10, int r11, @Nullable Bundle r12) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r13 = getActionList(r10);
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r15 >= r13.size()) goto L9;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r16 = r13.get(r15);
        if (r16.getId() == r11) goto L7;
        r15 = r15 + 1;
        goto L4
    L7:
        r14 = r16.perform(r10, r12);
    L9:
        if (r14 == false) goto L11;
    L13:
        if (r14 == false) goto L15;
        return r14;
    L15:
        if (r11 != R.id.accessibility_action_clickable_span) goto L22;
        if (r12 != null) goto L18;
        return r14;
    L18:
        return performClickableSpanAction(r12.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r10);
    L22:
        return r14;
    L11:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        r14 = Api16Impl.performAccessibilityAction(this.mOriginalDelegate, r10, r11, r12);
        goto L13
    }

    public void sendAccessibilityEvent(@NonNull View r10, int r11) {
        this.mOriginalDelegate.sendAccessibilityEvent(r10, r11);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View r10, @NonNull AccessibilityEvent r11) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r10, r11);
    }
}
