package com.bytedance.android.live.core.tetris.widgets.base;

import com.bytedance.ies.sdk.widgets.Widget;
import d70.a;
import h70.b;
import j70.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/base/ComponentWidget;", "Lh70/b;", "T", "Lcom/bytedance/ies/sdk/widgets/Widget;", "Ld70/a;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ComponentWidget<T extends b> extends Widget implements a<T> {
    public T a;
    public f b;

    public ComponentWidget() {
    }

    @Override // d70.a
    public final T getComponentContext() {
        return this.a;
    }

    @Override // d70.a
    public final f getElementType() {
        return this.b;
    }

    @Override // d70.a
    public final void setComponentContext(T r1) {
        this.a = r1;
    }

    @Override // d70.a
    public final void setElementType(f r1) {
        this.b = r1;
    }
}
