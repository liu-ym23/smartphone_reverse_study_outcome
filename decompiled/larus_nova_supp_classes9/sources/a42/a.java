package a42;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.g;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends g {
    public final float a;

    public a(float r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.g
    public final void a(MonitorEvent r27) {
        Intrinsics.checkNotNullParameter(r27, "event");
        Long r1 = r27.c(HighlevelNoMessageMonitorEnum.MemberReceiveCount.getValueNodeName());
        if (r1 == null) goto L5;
        long r4 = r1.longValue();
    L6:
        Long r2 = r27.c(HighlevelNoMessageMonitorEnum.MemberDropCount.getValueNodeName());
        if (r2 == null) goto L9;
        long r6 = r2.longValue();
    L10:
        Long r3 = r27.c(HighlevelNoMessageMonitorEnum.MemberFilterCount.getValueNodeName());
        if (r3 == null) goto L13;
        long r8 = r3.longValue();
    L14:
        Long r5 = r27.c(HighlevelNoMessageMonitorEnum.MemberShowCount.getValueNodeName());
        if (r5 == null) goto L17;
        long r10 = r5.longValue();
    L18:
        Long r7 = r27.c(HighlevelNoMessageMonitorEnum.NotifyReceiveCount.getValueNodeName());
        if (r7 == null) goto L21;
        long r13 = r7.longValue();
    L22:
        Long r9 = r27.c(HighlevelNoMessageMonitorEnum.NotifyDropCount.getValueNodeName());
        if (r9 == null) goto L25;
        long r14 = r9.longValue();
    L26:
        Long r11 = r27.c(HighlevelNoMessageMonitorEnum.NotifyFilterCount.getValueNodeName());
        if (r11 == null) goto L29;
        long r15 = r11.longValue();
    L30:
        Long r0 = r27.c(HighlevelNoMessageMonitorEnum.NotifyShowCount.getValueNodeName());
        if (r0 == null) goto L33;
        long r18 = r0.longValue();
    L34:
        ALogger.i("HighlevelNoMessageMonitorHelper", "mr:" + r4 + ",md:" + r6 + ",mf:" + r8 + ",ms:" + r10);
        long r20 = r10;
        StringBuilder r16 = new StringBuilder("nr:");
        r16.append(r13);
        r16.append(",nd:");
        r16.append(r14);
        r16.append(",nf:");
        r16.append(r15);
        r16.append(",ns:");
        long r17 = r18;
        r16.append(r17);
        ALogger.i("HighlevelNoMessageMonitorHelper", r16.toString());
        if (r4 == 0) goto L37;
    L39:
        long r19 = ((r4 + r13) - (r6 + r14)) - (r8 + r15);
        long r110 = r14;
        long r111 = r20 + r17;
        boolean r23 = false;
        if (r19 != 0) goto L42;
        float r21 = 0.0f;
    L45:
        if (r23 == true) goto L47;
        return;
    L47:
        IRoomContextService r112 = k.f(IRoomContextService.class);
        if (r112 == null) goto L54;
        o r113 = IRoomContextService.a.a(r112, null, 0, 3);
        if (r113 == null) goto L54;
        m r114 = r113.getRoom();
        if (r114 == null) goto L54;
        IRoom r115 = (IRoom) r114.getValue();
    L55:
        if (r115 != null) goto L57;
        return;
    L57:
        String r116 = r115.getAnchorId();
        IMiddlewareUserService r117 = k.f(IMiddlewareUserService.class);
        if (r117 == null) goto L62;
        com.bytedance.android.livesdk.user.e r118 = r117.user();
        if (r118 == null) goto L62;
        String r119 = r118.n();
    L64:
        if (Intrinsics.areEqual(r116, r119) == false) goto L66;
        String r120 = "1";
    L67:
        long r24 = r15;
        long r121 = r13;
        MiddlewareRoomContext r25 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r25 == null) goto L74;
        n r26 = r25.getCurStatMessage();
        if (r26 == null) goto L74;
        mk r28 = (mk) r26.getValue();
        if (r28 == null) goto L74;
        Long r29 = Long.valueOf(r28.getTotal());
    L76:
        if (TextUtils.equals("1", r115.isEcomCart()) == false) goto L78;
        String r30 = "ecom";
    L79:
        JSONObject r31 = new JSONObject();
        r31.put("show_rate", Float.valueOf(r21));
        JSONObject r33 = new JSONObject();
        r33.put("is_anchor", r120);
        r33.put("user_id", r119);
        r33.put("acu", r29);
        r33.put("member_receive_count", r4);
        r33.put("member_drop_count", r6);
        r33.put("member_filter_count", r8);
        r33.put("member_show_count", r20);
        r33.put("notify_receive_count", r121);
        r33.put("notify_filter_count", r24);
        r33.put("notify_drop_count", r110);
        r33.put("notify_show_count", r17);
        LiveMonitor.a r34 = InteractivityMonitor.a(InteractivityMonitor.Event.HighLevelNoMessageShowError, r115, null);
        r34.c(r30);
        r34.d(r120);
        r34.e("room_type", r30);
        r34.k(r31);
        r34.e = r33;
        r34.a().report();
        return;
    L78:
        r30 = "normal";
    L74:
        r29 = null;
        goto L76
    L66:
        r120 = "0";
    L62:
        r119 = null;
    L54:
        r115 = null;
        goto L55
    L42:
        r21 = r111 / r19;
        if (r21 > this.a) goto L45;
    L44:
        r23 = true;
        goto L45
    L37:
        if (r13 != 0) goto L39;
        r110 = r14;
        r21 = 0.0f;
        goto L44
    L33:
        r18 = 0;
        goto L34
    L29:
        r15 = 0;
        goto L30
    L25:
        r14 = 0;
        goto L26
    L21:
        r13 = 0;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }
}
