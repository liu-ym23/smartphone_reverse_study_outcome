package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements o {
    public final boolean a;
    public final int b;
    public int c;
    public boolean d;
    public final com.bytedance.android.livesdk.revenue.service.effect.a e;
    public final com.bytedance.android.livesdk.revenue.service.message.d f;
    public final e1 g;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public c(com.bytedance.android.livesdk.revenue.service.effect.a r2, com.bytedance.android.livesdk.revenue.service.message.d r3, e1 r4) {
        Intrinsics.checkNotNullParameter(r2, "notifyMessageSender");
        Intrinsics.checkNotNullParameter(r3, "messageManagerService");
        Intrinsics.checkNotNullParameter(r4, "listService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = com.bytedance.android.livesdk.gift.platform.business.a.d().a();
        this.b = com.bytedance.android.livesdk.gift.platform.business.a.d().b();
        this.c = com.bytedance.android.livesdk.gift.platform.business.a.d().c();
        this.d = true;
    }
}
