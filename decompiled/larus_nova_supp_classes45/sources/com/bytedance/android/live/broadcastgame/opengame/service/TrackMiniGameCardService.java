package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackMiniGameCardService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrackMiniGameCardService implements y10.a {
    public final Lazy a;
    public final PluginContext b;

    public final Map<String, String> b() {
        return (Map) this.a.getValue();
    }

    @Override // y10.a
    public final void g() {
    }

    public TrackMiniGameCardService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.b = r2;
        this.a = LazyKt.lazy(new TrackMiniGameCardService$commonParams$2(this));
    }

    public final void a(Map<String, String> r7) {
        String r0 = k.n(IUserService.class).user().b().getIdString();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.b.i, 0, 2);
        if (r1 == null) goto L7;
        m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        Room r3 = (Room) r2.getValue();
    L8:
        String r4 = "";
        if (r3 == null) goto L12;
        String r5 = String.valueOf(r3.getRoomId());
        if (r5 == null) goto L12;
    L13:
        r7.put("room_id", r5);
        if (this.b.o == false) goto L16;
        r7.put("anchor_id", r0);
        return;
    L16:
        r7.put("user_id", r0);
        if (r3 == null) goto L22;
        String r6 = r3.getOwnerUserIdString();
        if (r6 == null) goto L22;
        r4 = r6;
    L22:
        r7.put("anchor_id", r4);
        return;
    L12:
        r5 = "";
    L7:
        r3 = null;
        goto L8
    }

    public final void c(boolean r5) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(b());
        a(r1);
        if (r5 == false) goto L5;
        String r6 = "cancel";
    L6:
        r1.put("button", r6);
        Unit r7 = Unit.INSTANCE;
        r0.sendLog("livesdk_anchor_close_ad", r1, new Object[]{Room.class, x.class});
        return;
    L5:
        r6 = "confirm";
        goto L6
    }

    public final void d(boolean r5) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(b());
        a(r1);
        if (r5 == false) goto L5;
        String r6 = "cancel";
    L6:
        r1.put("button", r6);
        Unit r7 = Unit.INSTANCE;
        r0.sendLog("livesdk_anchor_send_ad", r1, new Object[]{Room.class, x.class});
        return;
    L5:
        r6 = "confirm";
        goto L6
    }
}
