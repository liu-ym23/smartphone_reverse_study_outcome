package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LivePublicScreenMessageLongRate extends DynamicFactor<Float> {
    public static final /* synthetic */ int d = 0;
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_message_show_long_rate";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Float b() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = this.b;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getWaitMessageState();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f r3 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f) r2.getValue();
    L10:
        if (r3 != null) goto L12;
    L14:
        float r4 = 0.0f;
    L16:
        return Float.valueOf(r4);
    L12:
        if (r3.b <= 0) goto L14;
        r4 = r3.e;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = this.b;
        if (r0 == null) goto L6;
        r0.c(new LivePublicScreenMessageLongRate$onBind$1(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.c;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public LivePublicScreenMessageLongRate(DataCenter r2) {
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
