package com.bytedance.android.live.profit.fansclub.panel;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.transfer.n;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubPanelService implements o {
    public boolean a;
    public final List<e<?>> b;
    public final List<f> c;
    public final b d;
    public final lr2.a e;

    public final void onStart() {
    }

    public final void onStop() {
        this.a = true;
        ((ArrayList) this.b).clear();
    }

    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, FileUtils.FILTER);
        if (this.a == false) goto L5;
        return;
    L5:
        ((ArrayList) this.c).add(r2);
    }

    public final p c(final FansClubEntranceParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.g == false) goto L5;
        PaidInteractEntry r0 = PaidInteractEntry.CONTROL_ENTRY_SUBSCRIBE;
    L7:
        if (this.e.Pe(r0) == true) goto L10;
        return null;
    L10:
        FansClubEntranceParams.Page r1 = r4.a;
        if (r1 != FansClubEntranceParams.Page.FansGroup) goto L14;
        final int r2 = FansClubPanelTypes.Redirect.ordinal();
    L22:
        return (p) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(this.b), new FansClubPanelService$createPanel$availableFactories$1(r2, r4)), new FansClubPanelService$createPanel$1(this, r2, r4)));
    L14:
        if (r4.b == false) goto L16;
    L20:
        r2 = FansClubPanelTypes.Web.ordinal();
        goto L22
    L16:
        if (this.d.a(r1) == null) goto L20;
        int r3 = ((Number) this.d.b.e.a).intValue();
        int r5 = n.a;
        if (r3 != 1) goto L20;
        r2 = FansClubPanelTypes.Lynx.ordinal();
        goto L22
    L5:
        r0 = PaidInteractEntry.CONTROL_ENTRY_FANCLUB;
        goto L7
    }

    public FansClubPanelService(b r2, lr2.a r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxConfigService");
        Intrinsics.checkNotNullParameter(r3, "paidLiveService");
        this.d = r2;
        this.e = r3;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }
}
