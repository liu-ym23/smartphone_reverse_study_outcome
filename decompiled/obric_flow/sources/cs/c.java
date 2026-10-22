package cs;

import ai.j0;
import android.R;
import com.obric.oui.color.d;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final int[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f16504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f16505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f16506c;

    static {
        d = new int[]{R.attr.state_enabled};
    }

    public c(int[][] r5, d[] r10, d r11) {
        this.f16504a = r5;
        this.f16505b = r10;
        this.f16506c = r11;
        if (r5.length == r10.length) goto L5;
        StringBuilder r12 = new StringBuilder("stateSpecs.size(");
        r12.append(r5.length);
        r12.append(") must equal strokes.size(");
        throw new IllegalArgumentException(j0.n(r12, r10.length, ')').toString());
    L5:
        if (r5.length == 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    }
}
