package j70;

import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h<T extends h70.b> extends d<T> {
    public int a;
    public f70.b b;

    public double F(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return 3.9d;
    }

    public double G(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return 3.9d;
    }

    public double H(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return 3.9d;
    }

    public abstract ElementConstraint J(T r1);

    public com.bytedance.android.live.core.tetris.layer.view.b K(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    public h() {
        this.b = f70.b.c;
    }

    public f70.b L() {
        return this.b;
    }

    public final ElementConstraint I(Function1<? super ElementConstraint, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        ElementConstraint r0 = new ElementConstraint(0.0f, 3);
        r4.invoke(r0);
        return r0;
    }

    public final void M(f70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
