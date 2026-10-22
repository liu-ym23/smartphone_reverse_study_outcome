package i70;

import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import j70.d;
import j70.f;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements a {
    public final ServiceLayerDelegate a;
    public final f70.b b;
    public final LayerIndex c;

    @Override // i70.a
    public final Set<d<h70.b>> getDescriptorSet() {
        return this.a.e;
    }

    @Override // i70.a
    public final LayerDelegate<? extends a, ? extends h70.b> getLayerDelegate() {
        return this.a;
    }

    @Override // i70.a
    public final LayerIndex getLayerIndex() {
        return this.c;
    }

    @Override // i70.a
    public final f70.b getLayerTypeV2() {
        return this.b;
    }

    @Override // i70.a
    public final void F(d<h70.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        ServiceLayerDelegate r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        r1.e.add(r3);
    }

    @Override // i70.a
    public final Element<?> f2(f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        return this.a.f(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(f70.b r2, LayerIndex r3, h70.b r4, Class<ServiceLayerDelegate<h70.b>> r5) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "layerIndex");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        this.b = r2;
        this.c = r3;
        if (r5 == null) goto L9;
        ServiceLayerDelegate<h70.b> r6 = r5.newInstance();
        if (r6 == null) goto L8;
        ServiceLayerDelegate<h70.b> r7 = r6;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r7.a = this;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.c = r4;
        this.a = r7;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r7 = new DefaultServiceLayerDelegate();
        goto L10
    }
}
