package or1;

import android.os.Bundle;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomCacheManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l, com.bytedance.android.scope.o {
    public l() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void c() {
        IRoomService r0 = jc1.k.f(IRoomService.class);
        if (r0 == null) goto L8;
        LiveRoomCacheManager r1 = r0.roomCacheManager();
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final IRoom f() {
        IRoomService r0 = jc1.k.f(IRoomService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentRoom();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void d(String r2) {
        if (r2 == null) goto L4;
        lf2.a r0 = new lf2.a(r2);
    L5:
        com.bytedance.android.livesdk.live.provider.a.b.a = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final Bundle g(Bundle r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return m0.a(r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean isMicRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        IMicRoomService r0 = jc1.k.f(IMicRoomService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isMicRoom(r2) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final ILiveRoomController a(long r2, int r4) {
        IExternalFunctionInjector r0 = jc1.k.f(IExternalFunctionInjector.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveRoomController(r2, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean h(DataCenter r1, Bundle r2) {
        return com.bytedance.android.livesdk.chatroom.c.a(r2);
    }
}
