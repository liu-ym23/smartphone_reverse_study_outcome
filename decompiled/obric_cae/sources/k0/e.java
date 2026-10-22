package k0;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.textfield.l;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8889a;

    public e(d r8) {
        this.f8889a = r8;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L10;
        return false;
    L10:
        return this.f8889a.equals(((e) r8).f8889a);
    }

    public final int hashCode() {
        return this.f8889a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean r8) {
        l r10 = (l) ((androidx.core.app.b) this.f8889a).f1588a;
        AutoCompleteTextView r11 = r10.f5038h;
        if (r11 == null) goto L13;
        int r12 = 1;
        if (r11.getInputType() == 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == true) goto L14;
        if (r8 == false) goto L11;
        r12 = 2;
    L11:
        WeakHashMap<View, h0> r14 = w.f8437a;
        w.d.s(r10.f5075d, r12);
        return;
    L14:
        return;
    L7:
        r13 = false;
        goto L8
    }
}
