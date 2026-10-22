package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements a20.j {
    public final AbsOpenFeaturePanelViewModel a;
    public final a20.k b;

    @Override // a20.c
    public final AbsOpenFeaturePanelViewModel f() {
        return this.a;
    }

    public h(AbsOpenFeaturePanelViewModel r2, a20.k r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "model");
        new CompositeDisposable();
        this.a = r2;
        this.b = r3;
    }
}
