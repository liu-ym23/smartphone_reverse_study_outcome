package com.bytedance.android.live.platformplayer.utils;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final boolean a(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$hasSharePlayer");
        return LivePlatformPlayerManager.c(r2.getRoomId(), false).k();
    }

    public static final ILivePlayerClient b(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getPlayerClient");
        return LivePlatformPlayerManager.c(r2.getRoomId(), r2.isPseudo()).player();
    }

    public static final IRoomEventHub c(RoomBaseSession r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$playerEventHub");
        ILivePlayerClient r2 = b(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getEventHub();
    }
}
