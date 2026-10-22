package com.bytedance.android.live.componentsmarket.impl.components.userlist;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends n<d90.a> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public a() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return RoomCountWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return true;
    }

    @Override // j70.d
    public final f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.Q2;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_6;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r2) {
        final d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return I(new RoomUserListWidgetDescriptor$generateConstraint$1(r3));
    }
}
