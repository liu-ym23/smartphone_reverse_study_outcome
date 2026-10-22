package i70;

import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import j70.d;
import j70.f;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    void F(d<h70.b> r1);

    Element<?> f2(f r1);

    Set<d<h70.b>> getDescriptorSet();

    LayerDelegate<? extends a, ? extends h70.b> getLayerDelegate();

    LayerIndex getLayerIndex();

    f70.b getLayerTypeV2();
}
