package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.m61;
import com.bytedance.android.livesdk.config.te0;
import com.bytedance.android.livesdk.message.model.oh;
import com.bytedance.android.livesdk.message.model.w4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements com.bytedance.android.live.broadcastgame.c0<w>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public vlc.d b;

    public static final class a {
    }

    static {
    }

    public final vlc.d b() {
        if (this.b != null) goto L13;
        vlc.d r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
        if (r1 == null) goto L11;
        DataCenter r2 = (DataCenter) r1.getValue();
        if (r2 == null) goto L11;
        r4 = (vlc.d) r2.get("data_message_manager", null);
    L11:
        this.b = r4;
    L13:
        return this.b;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        vlc.d r0 = b();
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public x(vlc.d r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        if (((m61) te0.a.getValue()).a() == false) goto L8;
        vlc.d r3 = b();
        if (r3 == null) goto L9;
        r3.addMessageListener(MessageType.OPEN_PLATFORM_GAME_CARD_MESSAGE.getIntType(), this);
        return;
    L9:
        return;
    }

    public final void onMessage(tlc.d r22) {
        if ((r22 instanceof oh) == false) goto L58;
        w4 r0 = ((oh) r22).gameCardInfo;
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r1 = AudienceGameContext.a.a();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.openplatform.a> r2 = r1.getGameIntroCardInfo();
        if (r2 == null) goto L11;
        com.bytedance.android.live.broadcastgame.api.openplatform.a r3 = (com.bytedance.android.live.broadcastgame.api.openplatform.a) r2.getValue();
        if (r3 == null) goto L11;
        int r14 = r3.k;
    L12:
        if (r0 == null) goto L51;
        String r4 = r0.a();
        if (r4 == null) goto L51;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L49
        com.bytedance.android.live.broadcastgame.opengame.network.model.i r6 = (com.bytedance.android.live.broadcastgame.opengame.network.model.i) GsonHelper.get().fromJson(r4, com.bytedance.android.live.broadcastgame.opengame.network.model.i.class);     // Catch: Throwable -> L49
        Integer r7 = r0.b();     // Catch: Throwable -> L49
        if (r7 != null) goto L19;
    L21:
        boolean r8 = false;
    L22:
        ImageModel r9 = r6.d().b();     // Catch: Throwable -> L49
        String r11 = "";
        if (r9 == null) goto L31;
        List<String> r12 = r9.getUrls();     // Catch: Throwable -> L49
        if (r12 == null) goto L31;
        String r13 = (String) ListProtector.get(r12, 0);     // Catch: Throwable -> L49
        if (r13 == null) goto L31;
        String r15 = r13;
    L32:
        ImageModel r16 = r6.d().a();     // Catch: Throwable -> L49
        if (r16 == null) goto L40;
        List<String> r17 = r16.getUrls();     // Catch: Throwable -> L49
        if (r17 == null) goto L40;
        String r18 = (String) ListProtector.get(r17, 0);     // Catch: Throwable -> L49
        if (r18 == null) goto L40;
        r11 = r18;
    L40:
        String r19 = r6.e();     // Catch: Throwable -> L49
        String r110 = r6.b();     // Catch: Throwable -> L49
        String r111 = r6.a();     // Catch: Throwable -> L49
        String r21 = r6.c();     // Catch: Throwable -> L49
        Long r112 = r0.c();     // Catch: Throwable -> L49
        Long r23 = r0.d();     // Catch: Throwable -> L49
        if (r23 != null) goto L44;
    L46:
        boolean r113 = false;
    L47:
        com.bytedance.android.live.broadcastgame.api.openplatform.a r114 = new com.bytedance.android.live.broadcastgame.api.openplatform.a(r8, r15, r11, "", r19, r110, r111, r21, "", r112, r14, r113);     // Catch: Throwable -> L49
    L52:
        com.bytedance.android.live.broadcastgame.api.openplatform.a r24 = r114;
        if (r24 == null) goto L58;
        com.bytedance.android.live.broadcastgame.b0 r25 = this.a;
        if (r25 == null) goto L61;
        r25.insert(new w(r24));
        return;
    L61:
        return;
    L44:
        if (r23.longValue() != 1) goto L46;
        r113 = true;
    L31:
        r15 = "";
        goto L32
    L19:
        if (r7.intValue() != 1) goto L21;
        r8 = true;
    L49:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L51:
        r114 = null;
    L11:
        r14 = 0;
    }
}
