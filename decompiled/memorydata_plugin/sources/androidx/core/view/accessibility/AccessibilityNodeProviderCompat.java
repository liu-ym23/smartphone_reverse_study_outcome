package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r1) {
            AccessibilityNodeInfoCompat r0 = this.mCompat.createAccessibilityNodeInfo(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r5, int r6) {
            List<AccessibilityNodeInfoCompat> r4 = this.mCompat.findAccessibilityNodeInfosByText(r5, r6);
            if (r4 != null) goto L6;
            return null;
        L6:
            ArrayList r7 = new ArrayList();
            int r8 = r4.size();
            int r0 = 0;
        L7:
            if (r0 >= r8) goto L9;
            r7.add(((AccessibilityNodeInfoCompat) ZeusTransformUtils.preCheckCast(r4.get(r0), AccessibilityNodeInfoCompat.class, "com.obric.memorydata.plugin")).unwrap());
            r0 = r0 + 1;
            goto L7
        L9:
            return r7;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r1, int r2, Bundle r3) {
            return this.mCompat.performAction(r1, r2, r3);
        }
    }

    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r1) {
            AccessibilityNodeInfoCompat r0 = this.mCompat.findFocus(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.unwrap();
        }
    }

    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r1, AccessibilityNodeInfo r2, String r3, Bundle r4) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(r1, AccessibilityNodeInfoCompat.wrap(r2), r3, r4);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        Object r0 = new AccessibilityNodeProviderApi26(this);
    L5:
        this.mProvider = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        r0 = new AccessibilityNodeProviderApi19(this);
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 16) goto L12;
        r0 = new AccessibilityNodeProviderApi16(this);
        goto L5
    L12:
        r0 = null;
        goto L5
    }

    public AccessibilityNodeProviderCompat(Object r1) {
        this.mProvider = r1;
    }

    public void addExtraDataToAccessibilityNodeInfo(int r1, AccessibilityNodeInfoCompat r2, String r3, Bundle r4) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r1) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r1, int r2) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int r1) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int r1, int r2, Bundle r3) {
        return false;
    }
}
