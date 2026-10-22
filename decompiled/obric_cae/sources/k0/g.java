package k0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8907a;

    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f8908a;

        public a(g r8) {
            this.f8908a = r8;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r8) {
            f r10 = this.f8908a.a(r8);
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.f8890a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r8, int r10) {
            this.f8908a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int r8, int r10, Bundle r11) {
            return this.f8908a.c(r8, r10, r11);
        }
    }

    public static class b extends a {
        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int r8) {
            f r10 = this.f8908a.b(r8);
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.f8890a;
        }
    }

    public static class c extends b {
        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int r8, AccessibilityNodeInfo r10, String r11, Bundle r12) {
            this.f8908a.getClass();
        }
    }

    public g() {
        this.f8907a = new c(this);
    }

    public f a(int r8) {
        return null;
    }

    public f b(int r8) {
        return null;
    }

    public boolean c(int r8, int r10, Bundle r11) {
        return false;
    }

    public g(AccessibilityNodeProvider r8) {
        this.f8907a = r8;
    }
}
