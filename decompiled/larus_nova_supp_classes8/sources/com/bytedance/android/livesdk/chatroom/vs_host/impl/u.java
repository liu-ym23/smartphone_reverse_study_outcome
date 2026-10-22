package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u implements com.bytedance.android.scope.o, vr1.r {
    public u() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.r
    public final void a(boolean r4, Float r5, Float r6, Float r7, Float r8) {
        Intrinsics.checkNotNullParameter("vsLandscapeMessageBoard", "source");
        MsgWindowAdjustSource r0 = MsgWindowAdjustSource.VS_LANDSCAPE_MSG_BOARD;
        if (Intrinsics.areEqual("vsLandscapeMessageBoard", r0.getDescription()) == true) goto L6;
        r0 = MsgWindowAdjustSource.UNKNOWN;
    L6:
        IMsgWindowService r1 = jc1.k.n(IMsgWindowService.class);
        h71.a r2 = new h71.a();
        r2.a = r4;
        r2.b = r5;
        r2.c = r6;
        r2.d = r7;
        r2.e = r8;
        Unit r9 = Unit.INSTANCE;
        r1.msgWindowPositionAdjust(r0, r2);
    }
}
