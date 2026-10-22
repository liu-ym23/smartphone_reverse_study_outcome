package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final h c(MiddlewareRoomContext r2) {
        ViewModel r0 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j r3 = r2.getInteractivityContext();
        if (r3 == null) goto L7;
        ViewModel r4 = (ViewModel) r3.getValue();
    L9:
        if ((r4 instanceof h) == false) goto L13;
        r0 = r4;
    L13:
        return (h) r0;
    L7:
        r4 = null;
        goto L9
    }

    public static final h a(DataContext r4, DataCenter r5) {
        ViewModel r0 = null;
        if (r4 == null) goto L18;
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r7 = r6.getRoomDataContext(r4);
        if (r7 == null) goto L11;
        com.bytedance.live.datacontext.j r8 = r7.M1();
        if (r8 == null) goto L11;
        ViewModel r9 = (ViewModel) r8.getValue();
    L13:
        if ((r9 instanceof h) == false) goto L17;
        r0 = r9;
    L17:
        return (h) r0;
    L11:
        r9 = null;
        goto L13
    L18:
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        if (r10 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.o r11 = IRoomContextService.a.a(r10, r5, 0, 2);
        if (r11 == null) goto L25;
        com.bytedance.live.datacontext.j r13 = r11.M1();
        if (r13 == null) goto L25;
        ViewModel r14 = (ViewModel) r13.getValue();
    L27:
        if ((r14 instanceof h) == false) goto L31;
        r0 = r14;
    L31:
        return (h) r0;
    L25:
        r14 = null;
        goto L27
    }

    public static /* synthetic */ h b(DataCenter r1, int r2) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return a(null, r1);
    }
}
