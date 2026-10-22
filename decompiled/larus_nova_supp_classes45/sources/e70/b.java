package e70;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class b<T extends h70.b> extends j70.h<T> implements j70.e {
    @Override // j70.h
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "null", imports = {}))
    public final com.bytedance.android.live.core.tetris.layer.view.b K(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    public abstract e<T> N();

    public abstract f<T> O();

    public b() {
    }

    @Override // j70.h
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "LayerType.DEFAULT", imports = {}))
    public final f70.b L() {
        return f70.b.c;
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getLoadConfig().needLoad(layerContext)", imports = {}))
    public final boolean B(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return N().r(r2);
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getComponentConfig().elementType(layerContext)", imports = {}))
    public final j70.f C(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return O().p(r2);
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "LayerIndex.INDEX_SERVICE", imports = {}))
    public final LayerIndex E(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return LayerIndex.INDEX_SERVICE;
    }

    @Override // j70.h
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "ElementConstraint()", imports = {}))
    public final ElementConstraint J(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return new ElementConstraint(0.0f, 3);
    }
}
