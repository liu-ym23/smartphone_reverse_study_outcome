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
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r2) {
            AccessibilityNodeProviderCompat r1 = this.mCompat.getAccessibilityNodeProvider(r2);
            if (r1 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) ZeusTransformUtils.preCheckCast(r1.getProvider(), AccessibilityNodeProvider.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.onInitializeAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfo r5) {
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.wrap(r5);
            r0.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(r4));
            r0.setHeading(ViewCompat.isAccessibilityHeading(r4));
            r0.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(r4));
            r0.setStateDescription(ViewCompat.getStateDescription(r4));
            this.mCompat.onInitializeAccessibilityNodeInfo(r4, r0);
            r0.addSpansToExtras(r5.getText(), r4);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r3 = AccessibilityDelegateCompat.getActionList(r4);
            int r6 = 0;
        L4:
            if (r6 >= r3.size()) goto L6;
            r0.addAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r3.get(r6), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin"));
            r6 = r6 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.onPopulateAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r1, View r2, AccessibilityEvent r3) {
            return this.mCompat.onRequestSendAccessibilityEvent(r1, r2, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
            return this.mCompat.performAccessibilityAction(r1, r2, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r1, int r2) {
            this.mCompat.sendAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r1, AccessibilityEvent r2) {
            this.mCompat.sendAccessibilityEventUnchecked(r1, r2);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static AccessibilityNodeProvider getAccessibilityNodeProvider(View.AccessibilityDelegate r0, View r1) {
            return r0.getAccessibilityNodeProvider(r1);
        }

        static boolean performAccessibilityAction(View.AccessibilityDelegate r0, View r1, int r2, Bundle r3) {
            return r0.performAccessibilityAction(r1, r2, r3);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate r1) {
        this.mOriginalDelegate = r1;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r3) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r4 = (List) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_actions, OaidModel.KEY_ID, "tag_accessibility_actions")), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Collections.emptyList();
    }

    private boolean isSpanStillValid(ClickableSpan r3, View r4) {
        if (r3 == null) goto L13;
        ClickableSpan[] r5 = AccessibilityNodeInfoCompat.getClickableSpans(r4.createAccessibilityNodeInfo().getText());
        int r0 = 0;
    L5:
        if (r5 == null) goto L13;
        if (r0 >= r5.length) goto L13;
        if (r3.equals(r5[r0]) == true) goto L10;
        r0 = r0 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    private boolean performClickableSpanAction(int r4, View r5) {
        SparseArray r0 = (SparseArray) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.tag_accessibility_clickable_spans, OaidModel.KEY_ID, "tag_accessibility_clickable_spans")), SparseArray.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        WeakReference r6 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r4), WeakReference.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        ClickableSpan r7 = (ClickableSpan) ZeusTransformUtils.preCheckCast(r6.get(), ClickableSpan.class, "com.obric.memorydata.plugin");
        if (isSpanStillValid(r7, r5) == false) goto L13;
        r7.onClick(r5);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r1, r2);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r2 = Api16Impl.getAccessibilityNodeProvider(this.mOriginalDelegate, r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r2);
    L8:
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r1, r2);
    }

    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r1, r2.unwrap());
    }

    public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r1, r2);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup r1, View r2, AccessibilityEvent r3) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r1, r2, r3);
    }

    public boolean performAccessibilityAction(View r7, int r8, Bundle r9) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r0 = getActionList(r7);
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L9;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r3 = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) ZeusTransformUtils.preCheckCast(r0.get(r2), AccessibilityNodeInfoCompat.AccessibilityActionCompat.class, "com.obric.memorydata.plugin");
        if (r3.getId() == r8) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r1 = r3.perform(r7, r9);
    L9:
        if (r1 == false) goto L11;
    L13:
        if (r1 == false) goto L15;
        return r1;
    L15:
        if (r8 != ZeusTransformUtils.mapRes(R.id.accessibility_action_clickable_span, OaidModel.KEY_ID, "accessibility_action_clickable_span")) goto L22;
        if (r9 != null) goto L18;
        return r1;
    L18:
        return performClickableSpanAction(r9.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r7);
    L22:
        return r1;
    L11:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        r1 = Api16Impl.performAccessibilityAction(this.mOriginalDelegate, r7, r8, r9);
        goto L13
    }

    public void sendAccessibilityEvent(View r1, int r2) {
        this.mOriginalDelegate.sendAccessibilityEvent(r1, r2);
    }

    public void sendAccessibilityEventUnchecked(View r1, AccessibilityEvent r2) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r1, r2);
    }
}
