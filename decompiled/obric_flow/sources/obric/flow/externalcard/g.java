package obric.flow.externalcard;

import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f20449b;

    public g(View r5, Bundle r10) {
        this.f20448a = r5;
        this.f20449b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        View r11 = r10.f20448a;
        if (Intrinsics.areEqual(this.f20448a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20449b, r10.f20449b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        View r10 = this.f20448a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Bundle r13 = this.f20449b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "showLongClickMenu(contentView=" + this.f20448a + ", bundle=" + this.f20449b + ")";
    }
}
