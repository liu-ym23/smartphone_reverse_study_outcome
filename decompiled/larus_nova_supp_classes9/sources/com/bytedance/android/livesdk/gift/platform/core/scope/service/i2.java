package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i2 implements com.bytedance.android.scope.o, w2 {
    public final DataCenter a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static boolean d() {
        return ((Boolean) ay1.b.T.getValue(null, ay1.b.a[57])).booleanValue();
    }

    public final boolean c() {
        if (gb2.a.a(this.a, false) == false) goto L6;
        return ((Boolean) ay1.b.V.getValue(null, ay1.b.a[59])).booleanValue();
    L6:
        return ((Boolean) ay1.b.U.getValue(null, ay1.b.a[58])).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.w2
    public final k getCurrentSoundVibrationStatus() {
        k r0 = new k();
        r0.a(c());
        return r0;
    }

    public i2(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void a(boolean r3) {
        if (gb2.a.a(this.a, false) == false) goto L5;
        ay1.b.B(r3);
        return;
    L5:
        ay1.b.A(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.w2
    public final void setCurrentSoundVibrationStatus(boolean r1) {
        a(r1);
    }
}
