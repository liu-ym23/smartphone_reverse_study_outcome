package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.n5;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements d.a {
    public final /* synthetic */ c a;

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d.a
    public final void a() {
        ALogger.d("GiftMarqueeViewController", "onMarqueeCompleted");
        if ((!this.a.b.isEmpty()) == false) goto L6;
        n5 r0 = (n5) CollectionsKt.first(this.a.b);
        ((ArrayList) this.a.b).remove(r0);
        this.a.d.c(r0);
        return;
    }

    public b(c r1) {
        this.a = r1;
    }
}
