package com.bytedance.android.livesdk.interactivity;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final InteractivityPlatformContext a(DataCenter r5) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        ViewModel r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.j r7 = r6.M1();
        if (r7 == null) goto L9;
        ViewModel r8 = (ViewModel) r7.getValue();
    L11:
        if ((r8 instanceof InteractivityPlatformContext) == false) goto L15;
        r1 = r8;
    L15:
        return (InteractivityPlatformContext) r1;
    L9:
        r8 = null;
        goto L11
    }
}
