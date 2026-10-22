package e70;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<T extends h70.b> extends j70.h<T> implements j70.e {
    public abstract d<T> N();

    public abstract e<T> O();

    public abstract f<T> P();

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final f70.b L() {
        d<T> r0 = N();
        if ((r0 instanceof c) == false) goto L6;
        return ((c) r0).getLayerType();
    L6:
        if ((r0 instanceof i) == false) goto L9;
        return ((i) r0).getLayerType();
    L9:
        return f70.b.c;
    }

    public a() {
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getLoadConfig().needLoad(layerContext)", imports = {}))
    public final boolean B(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return O().r(r2);
    }

    @Override // j70.d
    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "getComponentConfig().elementType(layerContext)", imports = {}))
    public final j70.f C(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return P().p(r2);
    }

    @Override // j70.d
    @Deprecated(message = "no more use")
    public final LayerIndex E(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        d<T> r3 = N();
        if ((r3 instanceof c) == false) goto L6;
        return ((c) r3).getLayerIndex();
    L6:
        if ((r3 instanceof i) == false) goto L9;
        return LayerIndex.INDEX_XML;
    L9:
        return LayerIndex.INDEX_SERVICE;
    }

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final ElementConstraint J(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        d<T> r4 = N();
        if ((r4 instanceof c) == true) goto L5;
        r4 = null;
    L5:
        c r5 = (c) r4;
        if (r5 == null) goto L10;
        ElementConstraint r6 = r5.t();
        if (r6 == null) goto L10;
        return r6;
    L10:
        return new ElementConstraint(0.0f, 3);
    }

    @Override // j70.h
    @Deprecated(message = "no more use")
    public final com.bytedance.android.live.core.tetris.layer.view.b K(T r3) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        d<T> r4 = N();
        if ((r4 instanceof c) == true) goto L5;
        r4 = null;
    L5:
        c r5 = (c) r4;
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.d();
    }
}
