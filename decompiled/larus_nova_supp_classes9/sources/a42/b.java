package a42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.g;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends g {
    public b() {
    }

    public static void b(String r8) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L9;
        m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L10:
        if (r3 != null) goto L12;
        return;
    L12:
        String r5 = r3.getAnchorId();
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L17;
        String r9 = r7.n();
    L19:
        if (Intrinsics.areEqual(r5, r9) == false) goto L21;
        String r10 = "1";
    L22:
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L29;
        n r11 = r4.getCurStatMessage();
        if (r11 == null) goto L29;
        mk r13 = (mk) r11.getValue();
        if (r13 == null) goto L29;
        Long r14 = Long.valueOf(r13.getTotal());
    L30:
        LiveMonitor.a r15 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenNoMessageShowError, r3, null);
        r15.c(r8);
        r15.d(r10);
        r15.e("target_method", r8);
        r15.i("is_anchor", r10);
        r15.i("user_id", r9);
        r15.i("acu", r14);
        r15.a().report();
        return;
    L29:
        r14 = null;
        goto L30
    L21:
        r10 = "0";
    L17:
        r9 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.g
    public final void a(MonitorEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Long r0 = r10.c(PSNoMessageValueNode.MemberMessageCount.getValueNodeName());
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L6:
        Long r1 = r10.c(PSNoMessageValueNode.RoomMessageCount.getValueNodeName());
        if (r1 == null) goto L9;
        long r5 = r1.longValue();
    L10:
        Long r11 = r10.c(PSNoMessageValueNode.ChatMessageCount.getValueNodeName());
        if (r11 == null) goto L13;
        long r7 = r11.longValue();
    L14:
        ALogger.i("PSNoMessageMonitorHelper", "memberCount:" + r3 + ",roomCount:" + r5 + ",chatCount:" + r7);
        if (r3 > 0) goto L17;
    L21:
        if (r3 != 0) goto L24;
        b("WebcastMemberMessage");
    L24:
        if (r5 != 0) goto L27;
        b("WebcastRoomMessage");
    L27:
        if (r7 != 0) goto L30;
        b("WebcastChatMessage");
        return;
    L30:
        return;
    L17:
        if (r5 <= 0) goto L21;
        if (r7 <= 0) goto L21;
        return;
    L13:
        r7 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
