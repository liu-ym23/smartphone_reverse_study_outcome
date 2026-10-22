package com.bytedance.android.live.platformplayer.layout;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.awemeopen.infra.base.net.AoNetworkEventHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l1 extends Handler {
    public final /* synthetic */ LivePlayerWidget a;

    @Override // android.os.Handler
    public final void handleMessage(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        super.handleMessage(r7);
        if (r7.what != 38) goto L24;
        com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
        if (r8 == null) goto L21;
        Room r9 = r8.getCurrentRoom();
        if (r9 != null) goto L10;
        return;
    L10:
        if (r9.getId() == this.a.U2.x()) goto L12;
        return;
    L12:
        if (((com.bytedance.android.live.platformplayer.b) this.a.ar().invoke()).b() == true) goto L25;
        com.bytedance.android.live.platformplayer.utils.a.a("handlemessage endroom BACKGROUND_TIMEOUT");
        DataCenter r0 = this.a.U2.getDataCenter();
        if (r0 == null) goto L19;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L19;
        r1.r(false);
    L19:
        LivePlatformPlayerManager.c(this.a.U2.x(), this.a.U2.isPseudo()).f(false, null);
        this.a.U2.setAutoStartWhenResume(true);
        com.bytedance.android.livesdk.log.j0 r2 = com.bytedance.android.livesdk.log.j0.l();
        HashMap r3 = new HashMap();
        r3.put(AoNetworkEventHelper.NETWORK_TYPE, com.bytedance.android.livesdk.log.j0.k());
        r3.put("timeout", "1");
        r3.putAll(com.bytedance.android.live.core.utils.h1.a(r9));
        Unit r10 = Unit.INSTANCE;
        r2.sendLog("livesdk_backgroud_cut", r3, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        return;
    L21:
        return;
    }

    public l1(LivePlayerWidget r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
