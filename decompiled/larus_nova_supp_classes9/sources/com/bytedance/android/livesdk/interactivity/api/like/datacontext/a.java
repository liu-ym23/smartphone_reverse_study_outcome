package com.bytedance.android.livesdk.interactivity.api.like.datacontext;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final DiggContext a(MiddlewareRoomContext r0) {
        if (r0 == null) goto L8;
        h r1 = i.c(r0);
        if (r1 == null) goto L8;
        j<DiggContext> r2 = r1.getDiggContext();
        if (r2 == null) goto L8;
        return (DiggContext) r2.getValue();
    L8:
        return null;
    }
}
