package fq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final ILiveRoomController a(long r2, int r4) {
        return this.a.a(r2, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void c() {
        this.a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final void d(String r2) {
        this.a.d(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final IRoom f() {
        return this.a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final Bundle g(Bundle r2) {
        return this.a.g(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean h(DataCenter r2, Bundle r3) {
        return this.a.h(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l
    public final boolean isMicRoom(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        return this.a.isMicRoom(r2);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public o(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.l r2) {
        Intrinsics.checkNotNullParameter(r2, "replayRoomService");
        this.a = r2;
    }
}
