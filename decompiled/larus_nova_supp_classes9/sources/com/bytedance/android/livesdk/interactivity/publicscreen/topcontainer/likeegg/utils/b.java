package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r4, Map r5) {
        o r0 = r.l();
        if (r5 == null) goto L5;
        Map r6 = MapsKt.toMap(r5);
    L6:
        r0.sendLog(r4, r6, new Object[]{IRoom.class});
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static void a(com.bytedance.android.livesdk.chatroom.likeegg.a r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        Intrinsics.checkNotNullParameter(r3, "photoType");
        b("livesdk_vs_photo_save", r.k().a(r1, r2, r3));
    }
}
