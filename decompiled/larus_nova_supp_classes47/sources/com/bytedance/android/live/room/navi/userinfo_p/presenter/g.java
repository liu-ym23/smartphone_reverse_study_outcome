package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.message.model.qm;
import com.bytedance.android.livesdk.message.model.yd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ UserInfoTabPresenter b;

    public g(n r1, UserInfoTabPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r13) {
        dh1.a r14 = (dh1.a) sh6.c.b((sh6.b) r13);
        Long r2 = 0L;
        if (r14 == null) goto L5;
        long r3 = r14.a;
    L7:
        if (r3 <= 0) goto L9;
        boolean r15 = true;
    L10:
        ALogger.i("LiveRoomAudienceWidget", "UserInfoTabPresenter Receive New Rtc RoomInfo: " + this.b.y);
        if (r15 == true) goto L83;
        UserInfoTabPresenter r4 = this.b;
        qm r5 = r4.u;
        Unit r6 = null;
        if (r5 == null) goto L15;
        r4.z(r5);
    L64:
        com.ss.ugc.live.sdk.platform.a.f.m("WebcastUpdateFanTicketMessage", this.b.A);
        if (((Boolean) com.bytedance.android.live.misc.e.a.getValue()).booleanValue() == false) goto L82;
        UserInfoTabPresenter r7 = this.b;
        yd r8 = r7.v;
        if (r8 == null) goto L72;
        u32.d r9 = r7.m;
        if (r9 == null) goto L71;
        r9.g(r8.getTotal());
        r6 = Unit.INSTANCE;
    L71:
        if (r6 != null) goto L82;
    L72:
        UserInfoTabPresenter r10 = this.b;
        r10.getClass();
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r10.a(), 0, 2);
        if (r0 == null) goto L81;
        m r1 = r0.getRoom();
        if (r1 == null) goto L81;
        Room r12 = (Room) r1.getValue();
        if (r12 == null) goto L81;
        long r16 = r12.getDiggCount();
        u32.d r17 = r10.m;
        if (r17 == null) goto L81;
        r17.g(r16);
    L81:
        Unit r18 = Unit.INSTANCE;
    L82:
        this.b.getClass();
    L84:
        this.b.y = r15;
        return;
    L15:
        IRoom r19 = r4.b();
        if (r19 == null) goto L18;
        IRoomStats r20 = r19.getStats();
    L19:
        String r22 = "";
        if (r20 != null) goto L86;
        Spm.Companion.getClass();
        Spm r23 = Spm.a.a("a100.c100.d100");
        IRoom r24 = r4.b();
        if (r24 == null) goto L56;
        String r25 = r24.getOwnerUserIdString();
    L57:
        Spm r26 = r23.anchorId(String.valueOf(r25));
        IRoom r27 = r4.b();
        if (r27 == null) goto L63;
        String r28 = r27.getIdStr();
        if (r28 == null) goto L63;
        r22 = r28;
    L63:
        sw2.a.b(r26.roomId(r22).aliasAppend("render_ticket_failed").reason("room or datacenter is null").i(), r4.f);
        goto L64
    L56:
        r25 = null;
        goto L57
    L86:
        DataCenter r29 = r4.a();     // Catch: Exception -> L37
        if (r29 == null) goto L25;
        Object r30 = r29.get("data_current_room_ticket_count");     // Catch: Exception -> L37
    L26:
        if (r30 == null) goto L30;
        DataCenter r32 = r4.a();     // Catch: Exception -> L37
        if (r32 == null) goto L36;
        r2 = (Long) r32.get("data_current_room_ticket_count", r2);     // Catch: Exception -> L37
    L52:
        r4.y(r2);
    L36:
        r2 = null;
        goto L52
    L30:
        IRoom r33 = r4.b();     // Catch: Exception -> L37
        if (r33 == null) goto L36;
        IRoomStats r34 = r33.getStats();     // Catch: Exception -> L37
        if (r34 == null) goto L36;
        r2 = Long.valueOf(r34.getTicket());     // Catch: Exception -> L37
        goto L52
    L25:
        r30 = null;
    L37:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r35 = Spm.a.a("a100.c100.d100");
        IRoom r110 = r4.b();
        if (r110 == null) goto L41;
        String r111 = r110.getOwnerUserIdString();
    L42:
        Spm r36 = r35.anchorId(String.valueOf(r111));
        IRoom r112 = r4.b();
        if (r112 == null) goto L46;
        String r113 = r112.getIdStr();
        if (r113 == null) goto L46;
    L47:
        Spm r37 = r36.roomId(r113).aliasAppend("render_ticket_failed");
        String r38 = e.getMessage();
        if (r38 == null) goto L51;
        r22 = r38;
    L51:
        sw2.a.b(r37.reason(r22).i(), r4.f);
    L46:
        r113 = "";
        goto L47
    L41:
        r111 = null;
        goto L42
    L18:
        r20 = null;
        goto L19
    L83:
        this.b.n();
        com.ss.ugc.live.sdk.platform.a.f.d("WebcastUpdateFanTicketMessage", this.b.A);
        goto L84
    L9:
        r15 = false;
        goto L10
    L5:
        r3 = 0;
        goto L7
    }
}
