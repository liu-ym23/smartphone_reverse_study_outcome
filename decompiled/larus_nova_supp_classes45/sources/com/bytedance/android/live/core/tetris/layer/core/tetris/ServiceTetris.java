package com.bytedance.android.live.core.tetris.layer.core.tetris;

import android.view.View;
import android.widget.FrameLayout;
import h70.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/ServiceTetris;", "Lh70/b;", "T", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ServiceTetris<T extends b> extends Tetris<T> {
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
    }

    public ServiceTetris() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return new FrameLayout(K().getContext());
    }
}
