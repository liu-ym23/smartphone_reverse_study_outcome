package com.bytedance.android.live.room.api.messagewindow.monitor;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final IRoom a;
    public String b;
    public String c;
    public final String d;
    public final List<e> e;
    public long f;

    public h() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        String r1 = null;
        if (r0 == null) goto L9;
        o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L9;
        m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
    L10:
        this.a = r4;
        String r5 = "0L";
        if (r4 == null) goto L14;
        String r6 = String.valueOf(r4.getRoomId());
        if (r6 == null) goto L14;
    L15:
        this.b = r6;
        if (r4 == null) goto L21;
        String r7 = r4.getOwnerUserIdString();
        if (r7 == null) goto L21;
        r5 = r7;
    L21:
        this.c = r5;
        IMiddlewareUserService r8 = k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L26;
        r1 = r9.n();
    L26:
        this.d = r1;
        this.e = new ArrayList();
        this.f = 100;
        return;
    L14:
        r6 = "0L";
    L9:
        r4 = null;
        goto L10
    }
}
