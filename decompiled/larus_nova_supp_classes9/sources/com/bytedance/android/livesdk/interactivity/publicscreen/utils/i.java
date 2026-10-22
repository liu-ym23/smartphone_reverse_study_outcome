package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSMessageType;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorSuffix;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeValueNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatConstantNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements s42.c {
    public static b a;
    public static final i b = null;

    public static final class a {
        public final PSMessagePriority a;

        public a(PSMessagePriority r2) {
            Intrinsics.checkNotNullParameter(r2, "messagePriority");
            this.a = r2;
        }
    }

    public static final class b {
        public long a;
        public IRoom b;
        public long c;
        public long d;
        public long e;
        public boolean f;
        public long g;
        public long h;
        public long i;
        public final Map<String, c> j;
        public final Map<PSMessagePriority, a> k;
        public final c l;

        public b() {
            this.j = new LinkedHashMap();
            EnumMap r0 = new EnumMap(PSMessagePriority.class);
            PSMessagePriority[] r1 = PSMessagePriority.values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L5;
            PSMessagePriority r4 = r1[r3];
            r0.put(r4, new a(r4));
            r3 = r3 + 1;
            goto L3
        L5:
            Unit r5 = Unit.INSTANCE;
            this.k = r0;
            this.l = new c(PSMessageType.OTHER);
            c r6 = new c(PSMessageType.CHAT);
            c r7 = new c(PSMessageType.GIFT);
            c r8 = new c(PSMessageType.SYSTEM);
            this.j.put("WebcastChatMessage", r6);
            this.j.put("WebcastScreenChatMessage", r6);
            this.j.put("WebcastGiftMessage", r7);
            this.j.put("GiftGroupMessage", r7);
            this.j.put("WebcastRoomMessage", r8);
            this.j.put("WebcastControlMessage", r8);
            this.j.put("WebcastMemberMessage", r8);
        }
    }

    public static final class c {
        public final PSMessageType a;

        public c(PSMessageType r2) {
            Intrinsics.checkNotNullParameter(r2, "messageType");
            this.a = r2;
        }
    }

    public i() {
    }

    @Override // s42.c
    public final void b(int r1) {
    }

    @Override // s42.c
    public final void c() {
    }

    @Override // s42.c
    public final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void f(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void i() {
    }

    @Override // s42.c
    public final void k(tlc.d r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        b = new i();
    }

    public static void v() {
        b r0 = a;
        if (r0 == null) goto L5;
        long r1 = System.currentTimeMillis() - r0.c;
    L6:
        z32.f.d(PSRoomStatValueNode.ReceiveHistoryMsgCostTime, r1);
        PublicScreenTraceMonitor.l("ReceiveHistoryMessage", System.currentTimeMillis());
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        if (a == null) goto L6;
        z32.f.c(PSRoomStatValueNode.TotalOvertimeDrop);
        return;
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5) {
        b r6 = a;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.f == true) goto L7;
        r6.f = true;
        long r0 = System.currentTimeMillis() - r6.c;
        r6.h = r0;
        PSRoomStatConstantNode r2 = PSRoomStatConstantNode.FirstMessageShowDelay;
        String r1 = String.valueOf(r0);
        z32.f r3 = z32.f.b;
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r1, "value");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.b(z32.f.b.a, r2.getNodeName(), r1);
        PublicScreenTraceMonitor.l("FirstMessageBind", System.currentTimeMillis());
    L7:
        long r4 = System.currentTimeMillis() - r6.g;
        z32.e.a(PSRealtimeIndicatorNode.BindAvgConsume, r4);
        z32.f.a(PSRoomStatDescNode.PublicScreenShowStatus, "normal");
    }

    @Override // s42.c
    public final void l(tlc.d r5) {
        b r6 = a;
        if (r6 == null) goto L6;
        r6.i++;
        return;
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        b r4 = a;
        if (r4 == null) goto L6;
        r4.g = System.currentTimeMillis();
        return;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.android.livesdk.interactivity.publicscreen.utils.MessageLinkMonitor$checkAndReportSelfSendMessage$1] */
    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r15) {
        b r0 = a;
        if (r0 == null) goto L76;
        final long r1 = System.currentTimeMillis();
        if (r15 == null) goto L19;
        c r5 = (c) ((LinkedHashMap) r0.j).get(b.u(r15));
        if (r5 != null) goto L9;
        r5 = r0.l;
    L9:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r15, "message");
        if (r15.B <= 0) goto L13;
        z32.f r7 = z32.f.b;
        String r8 = r5.a.getMsgType() + PSRealtimeIndicatorSuffix.SHOW_COUNT.getIndicator();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "nodeName");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(r7.a, r8, 1);
        z32.e r9 = z32.e.b;
        String r6 = r5.a.getMsgType() + PSRealtimeIndicatorSuffix.SHOW_DELAY.getIndicator();
        long r10 = System.currentTimeMillis() - r15.B;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(r9.a, r6, r10);
    L13:
        a r2 = (a) ((EnumMap) r0.k).get(r15.z);
        if (r2 == null) goto L19;
        Intrinsics.checkNotNullParameter(r15, "message");
        if (r15.B <= 0) goto L19;
        z32.e r11 = z32.e.b;
        String r3 = r2.a.getPriority() + PSRealtimeIndicatorSuffix.PRIORITY_SHOW_DELAY.getIndicator();
        long r13 = System.currentTimeMillis() - r15.B;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r3, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(r11.a, r3, r13);
    L19:
        if (r15 == null) goto L23;
        b.getClass();
        T r4 = r15.b;
        if (r4 == 0) goto L23;
        long r14 = r4.getReceiveTime();
    L25:
        if (r14 <= 0) goto L27;
        z32.e.a(PSRealtimeIndicatorNode.ScrollDispatchAndShowDelayAvg, r1 - r14);
    L27:
        if (r15 == null) goto L29;
        long r16 = r15.B;
    L30:
        k0 r17 = null;
        if (r16 <= 0) goto L50;
        long r18 = r1 - r16;
        z32.e.a(PSRealtimeIndicatorNode.ScrollShowDelayAvg, r18);
        if (r15 != null) goto L35;
    L37:
        if (r15 == null) goto L39;
        k0 r19 = r15.b;
    L41:
        if ((r19 instanceof k0) == true) goto L43;
        r19 = null;
    L43:
        k0 r20 = r19;
        if (r20 == null) goto L50;
        if (r20.isSelfSendFake() == false) goto L50;
        if (r20.getHttpSuccessTimestamps() <= 0) goto L50;
        z32.e.a(PSRealtimeIndicatorNode.SelfCommentShowDelayAvg, r1 - r20.getHttpSuccessTimestamps());
        goto L50
    L39:
        r19 = null;
        goto L41
    L35:
        if (r15.A() != true) goto L37;
        z32.e.a(PSRealtimeIndicatorNode.SelfMsgShowDelayAvg, r18);
    L50:
        if (r15 == null) goto L52;
        k0 r21 = r15.b;
    L54:
        if ((r21 instanceof k0) == false) goto L57;
        r17 = r21;
    L57:
        k0 r23 = r17;
        if (r23 != null) goto L60;
    L62:
        if (r15 == null) goto L74;
        final k0 r110 = r15.b;
        if (r110 == null) goto L74;
        b.getClass();
        ?? r24 = new MessageLinkMonitor$checkAndReportSelfSendMessage$1(r1, r110);
        if ((r110 instanceof k0) == false) goto L69;
        k0 r111 = r110;
        r24.invoke(r111.isSelfSendFake(), r111.startSendTime(), r111.getHttpSendTime(), r111.getHttpSuccessTimestamps());
        goto L74
    L69:
        if ((r110 instanceof h4) == false) goto L72;
        h4 r112 = (h4) r110;
        r24.invoke(r112.isSelfAndMock(), r112.getStartSendTime(), r112.getHttpSendTime(), r112.getApiSuccessTime());
        goto L74
    L72:
        if ((r110 instanceof s3) == false) goto L74;
        s3 r113 = (s3) r110;
        r24.invoke(r113.isSelfAndMock(), r113.getStartSendTime(), r113.getHttpSendTime(), r113.getApiSuccessTime());
    L74:
        z32.e.c(PSRealtimeValueNode.ShowCount);
        z32.f.c(PSRoomStatValueNode.TotalScrollCount);
        z32.f.c(PSRoomStatValueNode.TotalShowCount);
        return;
    L60:
        if (r23.isSelfClickSend() == false) goto L62;
        z32.c.b(InputValueNode.PortraitSelfChatShowCount);
        goto L62
    L52:
        r21 = null;
        goto L54
    L29:
        r16 = 0;
    L23:
        r14 = 0;
        goto L25
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        if (a == null) goto L6;
        z32.f.c(PSRoomStatValueNode.TotalFoldCount);
        z32.f.c(PSRoomStatValueNode.TotalShowCount);
        z32.e.c(PSRealtimeValueNode.ShowCount);
        return;
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        b r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e != 0) goto L7;
        r0.e = System.currentTimeMillis();
    L7:
        c r1 = (c) ((LinkedHashMap) r0.j).get(b.u(r7));
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter(r7, "message");
        T r8 = r7.b;
        if (r8 == 0) goto L12;
        long r2 = r8.getReceiveTime();
    L14:
        if (r2 <= 0) goto L17;
        z32.f r9 = z32.f.b;
        String r3 = r1.a.getMsgType() + PSRealtimeIndicatorSuffix.RECEIVE_COUNT.getIndicator();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "nodeName");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(r9.a, r3, 1);
        goto L17
    L12:
        r2 = 0;
    L17:
        z32.f.c(PSRoomStatValueNode.TotalMsgCount);
        z32.e.c(PSRealtimeValueNode.MsgCount);
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        if (a == null) goto L6;
        z32.f.c(PSRoomStatValueNode.TotalOverlimitDrop);
        return;
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        if (a == null) goto L6;
        z32.f.c(PSRoomStatValueNode.TotalEnqueueCount);
        z32.e.c(PSRealtimeValueNode.EnqueueCount);
        return;
    }

    public final String u(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        tlc.d r0 = r3.b;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (GiftMessageDecoupleUtil.a(r0) == false) goto L9;
        return "WebcastGiftMessage";
    L9:
        T r4 = r3.b;
        if (r4 == 0) goto L16;
        String r5 = r4.getMessageMethod();
        if (r5 != null) goto L15;
        return BuildConfig.FLAVOR;
    L15:
        return r5;
    L16:
        return BuildConfig.FLAVOR;
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r6, IRoom r7, s42.c.b r8) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        Intrinsics.checkNotNullParameter(r7, "room");
        b r9 = a;
        if (r9 != null) goto L5;
    L22:
        a = null;
        return;
    L5:
        if (r9.a != r7.getId()) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L22;
        r9.d = System.currentTimeMillis();
        PublicScreenTraceMonitor.l("ComponentUnloaded", System.currentTimeMillis());
        long r0 = r9.d - r9.c;
        s0 r11 = PublicScreenTraceMonitor.a;
        long r2 = PublicScreenTraceMonitor.a.reportThreshold;
        boolean r13 = r9.f;
        if (r13 == false) goto L15;
    L17:
        if (r13 == false) goto L21;
        long r1 = r9.h;
        if (r1 < r2) goto L21;
        PublicScreenTraceMonitor.f(r1, "show_delay", r9.i);
    L21:
        ((LinkedHashMap) PublicScreenTraceMonitor.b).clear();
        ((LinkedHashMap) PublicScreenTraceMonitor.d).clear();
        goto L22
    L15:
        if (r0 < r2) goto L17;
        PublicScreenTraceMonitor.f(r0, "no_message", r9.i);
        goto L21
    L7:
        r10 = false;
        goto L8
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        b r6 = new b();
        a = r6;
        r6.a = r2.getId();
        r6.b = r2;
        r6.c = System.currentTimeMillis();
        PublicScreenTraceMonitor.l("ComponentLoaded", System.currentTimeMillis());
    }
}
