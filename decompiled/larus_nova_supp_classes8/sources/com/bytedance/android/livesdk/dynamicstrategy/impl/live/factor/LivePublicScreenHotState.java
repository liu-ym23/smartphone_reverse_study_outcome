package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LivePublicScreenHotState extends DynamicFactor<Integer> {
    public static final /* synthetic */ int d = 0;
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_room_hot_status";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = this.b;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getMessageHeat();
        if (r2 == null) goto L9;
        PublicScreenHeatState r3 = (PublicScreenHeatState) r2.getValue();
    L10:
        if (r3 == null) goto L15;
        int r4 = s.a[r3.ordinal()];
        int r5 = 2;
        if (r4 == 1) goto L18;
        if (r4 != 2) goto L15;
        r5 = 1;
    L18:
        return Integer.valueOf(r5);
    L15:
        r5 = 0;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = this.b;
        if (r0 == null) goto L6;
        r0.c(new LivePublicScreenHotState$onBind$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public LivePublicScreenHotState(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        com.bytedance.android.livesdk.interactivity.api.h r3 = com.bytedance.android.livesdk.interactivity.api.i.b(r2, 1);
        if (r3 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r4 = r3.getPublicScreenContext();
    L6:
        this.b = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
