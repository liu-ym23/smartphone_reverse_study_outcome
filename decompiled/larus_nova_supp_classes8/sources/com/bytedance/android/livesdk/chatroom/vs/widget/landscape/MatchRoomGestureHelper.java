package com.bytedance.android.livesdk.chatroom.vs.widget.landscape;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MatchRoomGestureHelper {
    public long a;
    public float b;
    public final Lazy c;
    public final DataCenter d;
    public final View e;

    public static final class a {
    }

    static {
    }

    public final IPlayerProgressService a() {
        return (IPlayerProgressService) this.c.getValue();
    }

    public final long b() {
        IPlayerProgressService r0 = a();
        if (r0 == null) goto L11;
        PlayerProgressServiceContext r1 = r0.provideContext(this.d);
        if (r1 == null) goto L11;
        m r2 = r1.getLimitStartTime();
        if (r2 == null) goto L11;
        Long r3 = (Long) r2.getValue();
        if (r3 == null) goto L11;
        return r3.longValue();
    L11:
        return 0;
    }

    public final long c() {
        IPlayerProgressService r0 = a();
        if (r0 == null) goto L7;
        Long r1 = r0.getTotalTimeInContext();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public MatchRoomGestureHelper(DataCenter r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        this.d = r2;
        this.e = r4;
        new Handler(Looper.getMainLooper());
        this.c = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new MatchRoomGestureHelper$mProgressService$2(this));
    }
}
