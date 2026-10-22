package i70;

import android.content.Context;
import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultXMLLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.XMLLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import j70.d;
import j70.f;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements a {
    public final XMLLayerDelegate a;
    public final f70.b b;
    public final LayerIndex c;
    public final Context d;

    @Override // i70.a
    public final Set<d<h70.b>> getDescriptorSet() {
        return this.a.e;
    }

    public final Context getContext() {
        return this.d;
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
        XMLLayerDelegate r1 = this.a;
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
    public c(f70.b r2, LayerIndex r3, h70.b r4, Context r5, Class<XMLLayerDelegate<h70.b>> r6) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "layerIndex");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.b = r2;
        this.c = r3;
        this.d = r5;
        if (r6 == null) goto L9;
        XMLLayerDelegate<h70.b> r7 = r6.newInstance();
        if (r7 == null) goto L8;
        XMLLayerDelegate<h70.b> r8 = r7;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r8.a = this;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.c = r4;
        this.a = r8;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.XMLLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r8 = new DefaultXMLLayerDelegate();
        goto L10
    }
}
