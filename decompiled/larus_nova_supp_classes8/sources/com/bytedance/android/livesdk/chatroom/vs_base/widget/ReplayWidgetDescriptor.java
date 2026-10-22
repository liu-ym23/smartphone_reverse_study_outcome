package com.bytedance.android.livesdk.chatroom.vs_base.widget;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class ReplayWidgetDescriptor<T extends b> extends n<T> {
    public abstract boolean N(T r1, Function1<? super Integer, Boolean> r2);

    public abstract ElementConstraint O(T r1, Function1<? super Integer, Boolean> r2);

    public abstract LayerIndex P(T r1, Function1<? super Integer, Boolean> r2);

    public ReplayWidgetDescriptor() {
    }

    public final boolean B(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return N(r2, new ReplayWidgetDescriptor$canLoad$1(this));
    }

    public final LayerIndex E(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return P(r2, new ReplayWidgetDescriptor$layerIndex$1(this));
    }

    public final ElementConstraint J(T r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return O(r2, new ReplayWidgetDescriptor$generateConstraint$1(this));
    }
}
