package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements js0.b {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // js0.b
    public final void onSuccess(String r4) {
        Intrinsics.checkNotNullParameter(r4, "track");
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 == null) goto L8;
        nz.h r6 = r5.getBroadcastBubbleManager();
        if (r6 == null) goto L9;
        r6.b(this.a.a.getContext(), this.a.b, String.valueOf(9));
        return;
    L9:
        return;
    }
}
