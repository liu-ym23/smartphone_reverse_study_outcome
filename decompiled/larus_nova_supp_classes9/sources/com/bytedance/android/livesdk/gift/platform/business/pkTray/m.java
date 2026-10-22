package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends BaseMVIComposableViewModel<i, a> {
    public String v;
    public final Set<BaseMVIDataStore<?>> w;
    public final CrossRoomTrayDataStore x;

    public final Set<BaseMVIDataStore<?>> I() {
        return this.w;
    }

    public m(CrossRoomTrayDataStore r2) {
        Intrinsics.checkNotNullParameter(r2, "dataStore");
        super(CollectionsKt.emptyList());
        this.x = r2;
        this.v = BuildConfig.FLAVOR;
        this.w = SetsKt.setOf(r2);
        f0();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new i();
    }

    public final void J0(com.bytedance.android.anya.internal.e r3, MVIState r4) {
        final i r5 = (i) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        r3.e(this.x.q(), new CrossRoomTrayViewModel$reduce$1(this, r5));
        r3.e(this.x.o(), new CrossRoomTrayViewModel$reduce$2(this, r5));
    }

    public final void X(com.bytedance.android.anya.o r3, com.bytedance.android.anya.p r4) {
        a r5 = (a) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$handleAction");
        Intrinsics.checkNotNullParameter(r5, "action");
        if ((r5 instanceof p) == false) goto L9;
        final CrossRoomTrayDataStore r6 = this.x;
        final String r7 = this.v;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "key");
        if (((TrayStatus) ((LinkedHashMap) r6.h).get(r7)) != TrayStatus.Busy) goto L10;
        r6.g(null, new CrossRoomTrayDataStore$resetTrayStatus$1(r6, r7));
        return;
    L10:
        return;
    }
}
