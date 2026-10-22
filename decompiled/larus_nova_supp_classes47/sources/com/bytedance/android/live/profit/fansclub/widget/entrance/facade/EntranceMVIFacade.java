package com.bytedance.android.live.profit.fansclub.widget.entrance.facade;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import fu0.a;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class EntranceMVIFacade extends b implements o {
    public final a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Collection<BaseMVIViewModel<?, ?>> d() {
        m r0 = m.e;
        a r1 = this.a;
        EntranceMVIFacade$findAllViewModels$1 r2 = EntranceMVIFacade$findAllViewModels$1.INSTANCE;
        r0.getClass();
        return (Collection) m.f(r1, r2);
    }

    public EntranceMVIFacade(a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    public final <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        return (BaseMVIViewModel) m.e.d(this.a, r3);
    }
}
