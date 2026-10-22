package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements yr1.h, com.bytedance.android.scope.o {
    public m() {
    }

    @Override // yr1.h
    public final void d() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.h
    public final void a() {
        ExternalFunctionInjectorService.Companion.getClass();
        ExternalFunctionInjectorService.a.d(false);
    }

    @Override // yr1.h
    public final com.bytedance.android.livesdk.room.handler.a c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new com.bytedance.android.livesdk.room.handler.a(r2);
    }

    @Override // yr1.h
    public final com.bytedance.android.livesdk.room.handler.d createLiveRoomMessageHandler(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        return new com.bytedance.android.livesdk.room.handler.d(r2);
    }

    @Override // yr1.h
    public final void clearLiveRoomController(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        IExternalFunctionInjector r0 = jc1.k.f(IExternalFunctionInjector.class);
        if (r0 == null) goto L6;
        r0.clearLiveRoomController(r2, r3);
        return;
    }
}
