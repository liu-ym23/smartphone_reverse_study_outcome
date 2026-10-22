package a80;

import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.e;
import j70.f;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T extends h70.b> {
    public Map<String, String> a;

    public boolean d(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return true;
    }

    public abstract ElementConstraint m(T r1);

    public abstract f o(T r1);

    public abstract e p();

    public a(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final ElementConstraint l(Function1<? super ElementConstraint, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "init");
        ElementConstraint r0 = new ElementConstraint(0.0f, 3);
        r4.invoke(r0);
        return r0;
    }
}
