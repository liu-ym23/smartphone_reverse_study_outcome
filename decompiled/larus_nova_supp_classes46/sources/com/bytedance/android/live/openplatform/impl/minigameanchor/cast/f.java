package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Runnable {
    public final /* synthetic */ LiveMgCastContextService a;

    public f(LiveMgCastContextService r1) {
        this.a = r1;
    }

    public final void a() {
        Boolean r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L37;
        m r1 = r0.isCasting();
        if (r1 == null) goto L38;
        boolean r2 = true;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L39;
        LiveMgCastContextService r3 = this.a;
        if (r3.g == false) goto L43;
        r3.g = false;
        if (r3.i == true) goto L14;
        IMiddlewareBroadcastService.b.a(jc1.k.n(IBroadcastService.class));
    L14:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r5 = AnchorMiniGameDataContext.a.a();
        if (r5 == null) goto L20;
        m<Boolean> r6 = r5.getOpenCamera();
        if (r6 == null) goto L20;
        r4 = (Boolean) r6.getValue();
    L20:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L22;
        return;
    L22:
        if (this.a.h == false) goto L41;
        Integer r7 = (Integer) com.bytedance.android.livesdk.sharedpref.b.a.a();
        if (r7 != null) goto L27;
    L29:
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        int r8 = 90;
    L33:
        c r9 = this.a.a;
        if (r9 == null) goto L42;
        r9.a(r8);
        return;
    L42:
        return;
    L32:
        r8 = 270;
        goto L33
    L27:
        if (r7.intValue() != 1) goto L29;
    L41:
        return;
    L43:
        return;
    L39:
        return;
    L38:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
