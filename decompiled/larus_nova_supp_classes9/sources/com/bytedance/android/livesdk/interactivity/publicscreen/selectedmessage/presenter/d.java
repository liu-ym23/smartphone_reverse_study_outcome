package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements o<com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.c> {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o
    public final void a(com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.c r4) {
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.c r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "updateInfo");
        Iterator r6 = ((ArrayList) this.a.c.a(r5)).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.interactivity.api.entity.f<? extends t> r0 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r6.next();
        a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "message");
        r1.g.a(r0);
        goto L4
    L6:
        this.a.g.b();
    }
}
