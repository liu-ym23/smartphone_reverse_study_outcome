package l3b;

import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final int a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "OpenCellLayoutConfig(startMarginDp=" + this.a + ", avatarMarginDp=" + this.b + ')';
    }

    public c() {
        this.a = 12;
        this.b = 6;
    }

    public final void a(View r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "root");
        if (r6 == false) goto L5;
        int r0 = 2131384629;
    L6:
        View r1 = r5.findViewById(r0);
        if (r1 == null) goto L9;
        int r2 = this.a;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.width = UIUtils.dp2px(r1.getContext(), r2);
        r1.setLayoutParams(r3);
    L9:
        View r4 = r5.findViewById(2131364910);
        if (r4 == null) goto L22;
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L15:
        if (r8 == null) goto L23;
        if (r6 == false) goto L19;
        r8.setMarginStart(UIUtils.dp2px(r5.getContext(), this.b));
    L20:
        r4.setLayoutParams(r8);
        return;
    L19:
        r8.setMarginEnd(UIUtils.dp2px(r5.getContext(), this.b));
        goto L20
    L23:
        return;
    L14:
        r8 = null;
        goto L15
    L22:
        return;
    L5:
        r0 = 2131377811;
        goto L6
    }
}
