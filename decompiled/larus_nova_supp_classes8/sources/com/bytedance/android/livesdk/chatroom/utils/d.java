package com.bytedance.android.livesdk.chatroom.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements com.bytedance.android.livesdk.chatroom.i {
    public static boolean a;
    public static final d b = null;

    public d() {
    }

    public final int b(Context r1, Bundle r2, String r3, RoomBaseSession r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        return 3;
    }

    public final boolean c() {
        return false;
    }

    public final void reset() {
    }

    static {
        b = new d();
        a = true;
    }

    public final boolean a() {
        return a;
    }

    public final void d(boolean r1) {
        a = r1;
    }
}
