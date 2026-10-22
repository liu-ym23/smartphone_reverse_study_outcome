package com.bytedance.android.live.platformplayer.service;

import com.bytedance.android.live.platformplayer.room.PullStreamTask;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import is2.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public c() {
    }

    public final PullStreamTask a(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        return new PullStreamTask(r2);
    }

    public final com.bytedance.android.live.platformplayer.room.b b(d r2, RoomSession r3) {
        Intrinsics.checkNotNullParameter(r2, "roomEngine");
        Intrinsics.checkNotNullParameter(r3, "session");
        return new com.bytedance.android.live.platformplayer.room.b(r2, r3);
    }
}
