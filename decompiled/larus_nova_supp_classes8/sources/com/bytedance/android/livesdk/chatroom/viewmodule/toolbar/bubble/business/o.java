package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.z9;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final ToolbarButton a;
        public final pp1.c b;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.WatchLater;
        }

        public a() {
            this.a = ToolbarButton.WATCH_LATER;
            int r0 = pp1.c.o;
            Intrinsics.checkNotNullParameter("支持将直播加入稍后再看", "content");
            this.b = new pp1.c.a.C0410a("支持将直播加入稍后再看").a();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.b;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        return z9.a.getValue().getEnable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a.c, 0, 2);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.isCleanMode();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return;
    L9:
        boolean r2 = y3.m(this.a.c).n(ToolbarButton.WATCH_LATER);
        boolean r4 = jc1.k.n(IUserService.class).user().isLogin();
        if (r2 == true) goto L22;
        if (r4 == false) goto L24;
        com.bytedance.android.livesdk.log.g r5 = u.l();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.m r6 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.m.d;
        r5.addSendLogFilter(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.m.class, r6);
        DataCenter r7 = this.a.c;
        if (r7 == null) goto L18;
        Room r8 = z.o(r7);
        if (r8 == null) goto L18;
        r3 = r8.getRoomId();
    L18:
        r6.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.m.a.contains(Long.valueOf(r3)) == false) goto L23;
        a();
        return;
    L23:
        return;
    L24:
        return;
    }

    public o(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
