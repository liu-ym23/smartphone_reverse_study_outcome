package com.bytedance.android.livesdk.interactivity.comment.record.view;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j70.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends j<d90.d> {
    public final Tetris<? extends h70.b> b() {
        return new LiveHighlightRecordTetris();
    }

    public f() {
    }

    public final boolean B(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        LiveScreenRecordGuideConfig.a r0 = LiveScreenRecordGuideConfig.c;
        DataCenter r4 = r3.h;
        r0.getClass();
        return LiveScreenRecordGuideConfig.a.a(r4);
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.h;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return LayerIndex.INDEX_6;
    }

    public final ElementConstraint J(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return new ElementConstraint(-1.0f, -1.0f);
    }
}
