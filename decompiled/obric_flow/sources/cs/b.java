package cs;

import android.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final int[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f16501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.color.a[][] f16502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.oui.color.a[] f16503c;

    static {
        d = new int[]{R.attr.state_enabled};
        com.obric.oui.color.a r5 = com.obric.oui.color.a.f12397c;
    }

    public b(int[][] r5, com.obric.oui.color.a[][] r10, com.obric.oui.color.a[] r11) {
        if (r5.length == r10.length) goto L5;
        StringBuilder r12 = new StringBuilder("stateSpecs.size(");
        r12.append(r5.length);
        r12.append(") must equal configs.size(");
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(r12, r10.length, ")"));
    L5:
        if (r5.length == 0) goto L9;
        this.f16501a = r5;
        this.f16502b = r10;
        this.f16503c = r11;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    }

    public static com.obric.oui.color.a[] a(com.obric.oui.color.a[] r5, com.obric.oui.color.a r10) {
        com.obric.oui.color.a[] r11 = (com.obric.oui.color.a[]) Arrays.copyOf(r5, r5.length + 1);
        r11[r5.length] = r10;
        return r11;
    }
}
