package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;

    @Nullable
    private final Object mProvider;

    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r5) {
            this.mCompat = r5;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r5) {
            AccessibilityNodeInfoCompat r10 = this.mCompat.createAccessibilityNodeInfo(r5);
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r5, int r10) {
            List<AccessibilityNodeInfoCompat> r11 = this.mCompat.findAccessibilityNodeInfosByText(r5, r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            ArrayList r12 = new ArrayList();
            int r13 = r11.size();
            int r14 = 0;
        L7:
            if (r14 >= r13) goto L9;
            r12.add(r11.get(r14).unwrap());
            r14 = r14 + 1;
            goto L7
        L9:
            return r12;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r5) {
            AccessibilityNodeInfoCompat r10 = this.mCompat.findFocus(r5);
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r5, int r10, Bundle r11) {
            return this.mCompat.performAction(r5, r10, r11);
        }
    }

    @RequiresApi(26)
    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r5) {
            super(r5);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r5, AccessibilityNodeInfo r10, String r11, Bundle r12) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(r5, AccessibilityNodeInfoCompat.wrap(r10), r11, r12);
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = new AccessibilityNodeProviderApi26(this);
    }

    public void addExtraDataToAccessibilityNodeInfo(int r5, @NonNull AccessibilityNodeInfoCompat r10, @NonNull String r11, @Nullable Bundle r12) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r5) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String r5, int r10) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int r5) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int r5, int r10, @Nullable Bundle r11) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object r5) {
        this.mProvider = r5;
    }
}
