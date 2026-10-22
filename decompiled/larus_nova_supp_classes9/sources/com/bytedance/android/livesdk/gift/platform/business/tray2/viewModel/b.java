package com.bytedance.android.livesdk.gift.platform.business.tray2.viewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.e;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.gift.tray.RelativeEnterAnimPos;
import com.bytedance.android.live.gift.tray.TrayMode;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.GiftTrayDataStore;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.n;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends BaseMVIViewModel<z02.a, Object> implements o {
    public final Set<BaseMVIDataStore<?>> q;
    public final GiftTrayDataStore r;
    public final k s;

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.q;
    }

    public final void onStart() {
        f0();
    }

    public static void e1(int r4) {
        jy0.b.c("GiftTrayPosition", "current position is " + r4, null, 4);
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L8;
        n<Integer> r1 = r0.getGiftTrayTempPosition();
        if (r1 == null) goto L9;
        r1.setValue(Integer.valueOf(r4));
        return;
    L9:
        return;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new z02.a();
    }

    public b(GiftTrayDataStore r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.r = r2;
        this.s = r3;
        this.q = SetsKt.setOf(r2);
    }

    public final void J0(e r7, MVIState r8) {
        final z02.a r9 = (z02.a) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$reduce");
        Intrinsics.checkNotNullParameter(r9, "state");
        t<GiftTrayDataStore, Map<TrayMode, Pair<Integer, RelativeEnterAnimPos>>> r0 = this.r.k();
        GiftTrayDataStore r1 = this.r;
        ReadOnlyProperty r2 = r1.f;
        KProperty[] r3 = GiftTrayDataStore.k;
        t r4 = (t) r2.getValue(r1, r3[1]);
        GiftTrayDataStore r5 = this.r;
        r7.c(r0, r4, (t) r5.g.getValue(r5, r3[2]), new GiftTrayContainerViewModel$reduce$1(this, r9));
    }
}
