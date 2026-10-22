package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i0 implements com.bytedance.android.scope.o {
    public final yz0.g a;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a b;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final ReceiverType a() {
        if (this.b.j() == true) goto L20;
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L8;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L9:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r1;
        if (r2 == null) goto L13;
        ReceiverType r3 = r2.b;
        if (r3 == null) goto L13;
    L17:
        if (r3 == null) goto L19;
        return r3;
    L19:
        return ReceiverType.Anchor;
    L13:
        IBaseUser r4 = this.c.i();
        if (r4 == null) goto L16;
        r3 = this.c.h(r4);
        goto L17
    L16:
        r3 = null;
        goto L17
    L8:
        r1 = null;
        goto L9
    L20:
        return ReceiverType.AllMic;
    }

    public i0(yz0.g r2, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "allMicService");
        Intrinsics.checkNotNullParameter(r4, "selectReceiverService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
