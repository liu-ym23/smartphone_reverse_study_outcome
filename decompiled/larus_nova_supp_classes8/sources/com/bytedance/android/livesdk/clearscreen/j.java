package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        if (((Boolean) r7).booleanValue() == false) goto L18;
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r8, null, 0, 3);
        if (r4 == null) goto L19;
        com.bytedance.live.datacontext.m r5 = r4.isInZoom();
        if (r5 != null) goto L9;
        return;
    L9:
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L21;
        RoomContext r9 = RoomContext.a.c(r8, null, 0, 3);
        if (r9 == null) goto L22;
        com.bytedance.live.datacontext.m r10 = r9.getCleanMode();
        if (r10 != null) goto L15;
        return;
    L15:
        if (((Number) r10.getValue()).intValue() != ClearScreenConst.InteractType.PURE_CLEAR.getId()) goto L24;
        this.a.s();
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L19:
        return;
    }
}
