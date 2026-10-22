package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w3 extends d<x3, GetBackAnchorResultModel> {
    public final DataCenter a;

    public w3(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "mDataCenter");
        this.a = r2;
    }

    public final void invoke(Object r5, CallContext r6) {
        x3 r7 = (x3) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IVSPlayerService r8 = jc1.k.f(IVSPlayerService.class);
        if (r8 == null) goto L12;
        IPlayerProgressService r9 = r8.provideVSProgressService(this.a);
        if (r9 == null) goto L13;
        Integer r11 = r7.a();
        if (r11 == null) goto L9;
        long r0 = r11.intValue();
    L10:
        r9.seekTo(r0 * 1000);
        return;
    L9:
        r0 = 0;
        goto L10
    L13:
        return;
    }
}
