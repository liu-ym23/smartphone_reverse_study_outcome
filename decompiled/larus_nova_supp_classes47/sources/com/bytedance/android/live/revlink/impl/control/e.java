package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends com.bytedance.android.livesdk.common.k<b> {
    public final LinkCrossRoomDataHolder b;
    public final CompositeDisposable c;
    public final com.bytedance.android.live.revlink.impl.global.c d;
    public IRoom e;
    public final boolean f;
    public final com.bytedance.android.livesdk.revenue.room.a g;
    public final ld.a h;
    public final com.bytedance.android.livesdk.revenue.service.room.c i;

    public static final class a {
    }

    public interface b {
        void Ab();
    }

    static {
    }

    public final void a(long r5) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.f r1 = r0.Z0();
    L6:
        if (r1 == null) goto L11;
        com.bytedance.android.live.revenuelink.connect.l r2 = r1.linkInManager();
        if (r2 == null) goto L12;
        r2.b(new fy.d(r5, 1, "control_widget_detach"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r1, IRoom r2, boolean r3, LiveMode r4, com.bytedance.android.livesdk.revenue.room.a r5, ld.a r6, com.bytedance.android.livesdk.revenue.service.room.c r7) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        if (r1 == null) goto L5;
        LinkCrossRoomDataHolder r8 = r1.getLinkCrossRoomDataHolder();
    L6:
        this.b = r8;
        this.c = new CompositeDisposable();
        return;
    L5:
        r8 = null;
        goto L6
    }
}
