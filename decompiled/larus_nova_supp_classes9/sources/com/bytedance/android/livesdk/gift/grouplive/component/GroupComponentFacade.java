package com.bytedance.android.livesdk.gift.grouplive.component;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupComponentFacade extends com.bytedance.android.anya.b implements o {
    public final f a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Collection<BaseMVIViewModel<?, ?>> d() {
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        f r1 = this.a;
        GroupComponentFacade$findAllViewModels$1 r2 = GroupComponentFacade$findAllViewModels$1.INSTANCE;
        r0.getClass();
        return (Collection) com.bytedance.android.scope.m.f(r1, r2);
    }

    public GroupComponentFacade(f r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    public final <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        return (BaseMVIViewModel) com.bytedance.android.scope.m.e.d(this.a, r3);
    }
}
