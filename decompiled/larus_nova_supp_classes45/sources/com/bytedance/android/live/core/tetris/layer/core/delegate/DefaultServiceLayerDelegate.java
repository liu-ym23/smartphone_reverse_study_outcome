package com.bytedance.android.live.core.tetris.layer.core.delegate;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/delegate/DefaultServiceLayerDelegate;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ServiceLayerDelegate;", "Lh70/b;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultServiceLayerDelegate extends ServiceLayerDelegate<h70.b> {
    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void j(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void k(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
    }

    public DefaultServiceLayerDelegate() {
    }
}
