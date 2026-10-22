package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AtmosphereFacade extends com.bytedance.android.anya.b implements o {
    public final i12.e a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Collection<BaseMVIViewModel<?, ?>> d() {
        m r0 = m.e;
        i12.e r1 = this.a;
        AtmosphereFacade$findAllViewModels$1 r2 = AtmosphereFacade$findAllViewModels$1.INSTANCE;
        r0.getClass();
        return (Collection) m.f(r1, r2);
    }

    public AtmosphereFacade(i12.e r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    public final <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        return (BaseMVIViewModel) m.e.d(this.a, r3);
    }
}
