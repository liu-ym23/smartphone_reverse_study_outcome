package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements g {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void a(Object r1, String r2, d r3) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
        Intrinsics.checkNotNullParameter(r2, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void b(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void d(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void e(String r3) {
        Intrinsics.checkNotNullParameter("GiftTrayMessageManager", "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void f(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "otherInfo");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.utils.recorder.g
    public final void g(Object r2, String r3, Function1<? super h, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "record");
    }
}
