package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public v0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        ByteBuffer r7 = (ByteBuffer) r6;
        if (((Boolean) ((ge1.a) tc0.c.h()).b).booleanValue() == false) goto L8;
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 == null) goto L8;
        r0.intValue();
    L8:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        Boolean r2 = null;
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.o r3 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r3 == null) goto L14;
        r2 = r3.isVSRoom();
    L14:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L16;
        int r4 = com.bytedance.android.livesdk.interactivity.api.settings.config.a1.a;
        com.bytedance.android.livesdk.interactivity.api.settings.config.a1.a.a().getClass();
    L16:
        gs0.d r5 = this.a.a;
        if (r5 == null) goto L20;
        r5.H3(r7);
        return;
    }
}
