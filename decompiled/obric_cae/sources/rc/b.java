package rc;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import k0.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends j0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f11781d;

    public b(c r8) {
        this.f11781d = r8;
    }

    @Override // j0.a
    public final void d(View r8, f r10) {
        AccessibilityNodeInfo r11 = r10.f8890a;
        this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
        c r12 = this.f11781d;
        if (r12.M == true) goto L5;
        return;
    L5:
        if (r12.s() == false) goto L10;
        if (r8 == null) goto L11;
        r8.setSelected(true);
        return;
    L11:
        return;
    }
}
