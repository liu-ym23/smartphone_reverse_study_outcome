package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k8 implements js0.b {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ w20.bc b;

    public static final class a implements m00.a {
        public a() {
        }
    }

    public final void onSuccess(String r5) {
        Intrinsics.checkNotNullParameter(r5, "track");
        IBroadcastService r6 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        Context r0 = this.a.getContext();
        Integer r1 = this.b.a();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r6.showAnchorManagerInputDialog(r0, r2, this.b.b(), new a());
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public k8(CallContext r1, w20.bc r2) {
        this.a = r1;
        this.b = r2;
    }
}
