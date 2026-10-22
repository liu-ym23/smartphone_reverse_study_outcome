package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements c0 {
    public final com.bytedance.android.live.broadcastgame.i0 a;
    public final q b;
    public final o0 c;
    public final List<BaseAnchorMessageReceiver<?>> d;
    public final String e;
    public final long f;
    public final com.bytedance.android.live.broadcastgame.opengame.f g;
    public final Room h;
    public final /* synthetic */ i20.a i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.c0
    public final <T extends com.bytedance.android.live.broadcastgame.v> Observable<T> a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        return this.a.f(r2);
    }

    public g(String r11, long r12, com.bytedance.android.live.broadcastgame.opengame.f r13, Room r14) {
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r13, "gameIMManager");
        Intrinsics.checkNotNullParameter(r14, NewBroadcastMonitor.PAGE.ROOM);
        this.i = new i20.a();
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        com.bytedance.android.live.broadcastgame.i0 r1 = new com.bytedance.android.live.broadcastgame.i0();
        this.a = r1;
        q r2 = new q();
        this.b = r2;
        o0 r3 = new o0();
        this.c = r3;
        ArrayList r4 = new ArrayList();
        this.d = r4;
        int r5 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AudienceGameMessageChannel", new Object[]{"init AudienceGameMessageChannel"});
        r1.c(f.class, new j());
        r1.a(r2);
        r1.a(r3);
        Intrinsics.checkNotNullParameter(r11, "appId");
        r2.a = r11;
        r2.b = Long.valueOf(r12);
        RoomContext.a r15 = RoomContext.Companion;
        long r16 = r14.getRoomId();
        vlc.d r17 = null;
        RoomContext r18 = RoomContext.a.c(r15, null, r16, 1);
        if (r18 == null) goto L7;
        com.bytedance.live.datacontext.j r19 = r18.getMessageManager();
        if (r19 == null) goto L7;
        r17 = (vlc.d) r19.getValue();
    L7:
        vlc.d r110 = r13.a(false);
        b r111 = new b(r110);
        r4.add(r111);
        Unit r112 = Unit.INSTANCE;
        r1.b(com.bytedance.android.live.broadcastgame.opengame.message.a.class, r111);
        r1.b(m0.class, new n0(r110));
        r1.b(i0.a.class, new i0(r17));
    }
}
