package androidx.core.view.accessibility;

import android.os.Build;
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

    @RequiresApi(16)
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat r10) {
            this.mCompat = r10;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r10) {
            AccessibilityNodeInfoCompat r11 = this.mCompat.createAccessibilityNodeInfo(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r10, int r11) {
            List<AccessibilityNodeInfoCompat> r12 = this.mCompat.findAccessibilityNodeInfosByText(r10, r11);
            if (r12 != null) goto L6;
            return null;
        L6:
            ArrayList r13 = new ArrayList();
            int r14 = r12.size();
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L9;
            r13.add(r12.get(r15).unwrap());
            r15 = r15 + 1;
            goto L7
        L9:
            return r13;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r10, int r11, Bundle r12) {
            return this.mCompat.performAction(r10, r11, r12);
        }
    }

    @RequiresApi(19)
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r10) {
            super(r10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r10) {
            AccessibilityNodeInfoCompat r11 = this.mCompat.findFocus(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.unwrap();
        }
    }

    @RequiresApi(26)
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r10) {
            super(r10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r10, AccessibilityNodeInfo r11, String r12, Bundle r13) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(r10, AccessibilityNodeInfoCompat.wrap(r11), r12, r13);
        }
    }

    public AccessibilityNodeProviderCompat() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 26) goto L7;
        Object r11 = new AccessibilityNodeProviderApi26(this);
    L5:
        this.mProvider = r11;
        return;
    L7:
        if (r10 < 19) goto L10;
        r11 = new AccessibilityNodeProviderApi19(this);
        goto L5
    L10:
        if (r10 < 16) goto L12;
        r11 = new AccessibilityNodeProviderApi16(this);
        goto L5
    L12:
        r11 = null;
        goto L5
    }

    public AccessibilityNodeProviderCompat(@Nullable Object r10) {
        this.mProvider = r10;
    }

    public void addExtraDataToAccessibilityNodeInfo(int r10, @NonNull AccessibilityNodeInfoCompat r11, @NonNull String r12, @Nullable Bundle r13) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r10) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String r10, int r11) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int r10) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int r10, int r11, @Nullable Bundle r12) {
        return false;
    }
}
