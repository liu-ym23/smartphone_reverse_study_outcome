package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.t;
import com.bytedance.android.scope.o;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends BaseMVIComposableViewModel<e, Object> implements o {
    public final String v;
    public final AtmosphereDataStore w;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return SetsKt.setOf(this.w);
    }

    public f(AtmosphereDataStore r3) {
        Intrinsics.checkNotNullParameter(r3, "dataStore");
        super(CollectionsKt.emptyList());
        this.w = r3;
        f0();
        this.v = ((com.bytedance.android.livesdk.gift.configmodel.a) nz1.a.y.getValue(null, nz1.a.a[23])).b();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new e();
    }

    public final void J0(com.bytedance.android.anya.internal.e r6, MVIState r7) {
        final e r8 = (e) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        r6.e(this.w.n(), new AtmosphereViewModel$reduce$1(this, r8));
        AtmosphereDataStore r0 = this.w;
        ReadOnlyProperty r1 = r0.f;
        KProperty[] r2 = AtmosphereDataStore.n;
        t r3 = (t) r1.getValue(r0, r2[1]);
        AtmosphereDataStore r4 = this.w;
        r6.d(r3, (t) r4.g.getValue(r4, r2[2]), new AtmosphereViewModel$reduce$2(this, r8));
    }
}
