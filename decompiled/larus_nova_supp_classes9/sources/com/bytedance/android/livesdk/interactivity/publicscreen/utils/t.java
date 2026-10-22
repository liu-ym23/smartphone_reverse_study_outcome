package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements s42.c {
    public static a a;
    public static final t b = null;

    public static final class a {
        public long a;
        public IRoom b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public long o;
        public int p;
        public long q;
        public long r;
        public long s;
        public long t;
        public final Map<String, b> u;

        public a() {
            LinkedHashMap r0 = new LinkedHashMap();
            this.u = r0;
            b r1 = new b("message_chat");
            b r2 = new b("message_gift");
            b r3 = new b("message_system");
            r0.put("WebcastChatMessage", r1);
            r0.put("WebcastScreenChatMessage", r1);
            r0.put("WebcastGiftMessage", r2);
            r0.put("GiftGroupMessage", r2);
            r0.put("WebcastRoomMessage", r3);
            r0.put("WebcastControlMessage", r3);
        }
    }

    public static final class b {
        public long a;
        public long b;
        public long c;
        public final String d;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prefix");
            this.d = r2;
        }

        public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r8) {
            Intrinsics.checkNotNullParameter(r8, "message");
            a r0 = t.a;
            T r1 = r8.b;
            long r2 = 0;
            if (r1 == 0) goto L5;
            long r3 = r1.getReceiveTime();
        L7:
            if (r3 > 0) goto L9;
            return;
        L9:
            long r4 = System.currentTimeMillis();
            T r9 = r8.b;
            if (r9 == 0) goto L12;
            r2 = r9.getReceiveTime();
        L12:
            this.b++;
            this.c = this.c + (r4 - r2);
            return;
        L5:
            r3 = 0;
            goto L7
        }
    }

    public t() {
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
    public final void i() {
    }

    @Override // s42.c
    public final void k(tlc.d r1) {
    }

    @Override // s42.c
    public final void l(tlc.d r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        b = new t();
    }

    @Override // s42.c
    public final void b(int r5) {
        a r0 = a;
        if (r0 == null) goto L9;
        IRoom r1 = r0.b;
        if (r1 == null) goto L10;
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenRenderError, r1, 1, String.valueOf(r5), 16);
        return;
    L10:
        return;
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        a r0 = a;
        if (r0 == null) goto L12;
        if (r6 == null) goto L6;
        Boolean r7 = r6.r;
    L8:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L10;
        r0.j++;
        return;
    L10:
        r0.i++;
        return;
    L6:
        r7 = null;
        goto L8
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        a r8 = a;
        if (r8 == null) goto L8;
        r8.m += System.currentTimeMillis() - r8.o;
        r8.n++;
        if (r8.l != 0) goto L9;
        r8.l = System.currentTimeMillis();
        return;
    L9:
        return;
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        a r0 = a;
        if (r0 == null) goto L12;
        if (r6 == null) goto L6;
        Boolean r7 = r6.r;
    L8:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L10;
        r0.j++;
        return;
    L10:
        r0.i++;
        return;
    L6:
        r7 = null;
        goto L8
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        a r4 = a;
        if (r4 == null) goto L6;
        r4.o = System.currentTimeMillis();
        return;
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r11) {
        a r0 = a;
        if (r0 == null) goto L9;
        r0.f++;
        r0.g++;
        if (r11 == null) goto L9;
        b r1 = (b) ((LinkedHashMap) r0.u).get(b.u(r11));
        if (r1 == null) goto L9;
        r1.a(r11);
    L9:
        if (r11 == null) goto L21;
        T r13 = r11.b;
        if (r13 != 0) goto L14;
        return;
    L14:
        if (r13.isInsert() == true) goto L16;
        return;
    L16:
        if (r13.getHttpSendTime() > 0) goto L18;
        return;
    L18:
        if (r13.getReceiveTime() < r13.getHttpSendTime()) goto L24;
        com.bytedance.android.livesdk.interactivity.api.monitor.e.a("comment", "public_screen", System.currentTimeMillis() - r13.getHttpSendTime(), r13.getReceiveTime() - r13.getHttpSendTime());
        return;
    L24:
        return;
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        a r0 = a;
        if (r0 == null) goto L8;
        r0.f++;
        r0.h++;
        b r1 = (b) ((LinkedHashMap) r0.u).get(b.u(r6));
        if (r1 == null) goto L9;
        r1.a(r6);
        return;
    L9:
        return;
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9) {
        a r0 = a;
        if (r0 == null) goto L18;
        r0.e++;
        if (r0.k != 0) goto L7;
        r0.k = System.currentTimeMillis();
    L7:
        b r1 = (b) ((LinkedHashMap) r0.u).get(b.u(r9));
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "message");
        T r10 = r9.b;
        if (r10 == 0) goto L12;
        long r2 = r10.getReceiveTime();
    L14:
        if (r2 <= 0) goto L20;
        r1.a++;
        return;
    L20:
        return;
    L12:
        r2 = 0;
        goto L14
    L19:
        return;
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        a r0 = a;
        if (r0 == null) goto L12;
        if (r6 == null) goto L6;
        Boolean r7 = r6.r;
    L8:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L10;
        r0.j++;
        return;
    L10:
        r0.i++;
        return;
    L6:
        r7 = null;
        goto L8
    }

    public final String u(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        tlc.d r0 = r2.b;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        if (GiftMessageDecoupleUtil.a(r0) == false) goto L10;
        return "WebcastGiftMessage";
    L10:
        T r3 = r2.b;
        if (r3 == 0) goto L14;
        String r4 = r3.getMessageMethod();
        if (r4 == null) goto L14;
        return r4;
    L14:
        return "UnknownMessageType";
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r17, IRoom r18, s42.c.b r19) {
        IWidget r0 = r17;
        Intrinsics.checkNotNullParameter(r0, "widget");
        Intrinsics.checkNotNullParameter(r18, "room");
        a r1 = a;
        if (r1 == null) goto L117;
        int r8 = 0;
        if (r1.a != r18.getId()) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L117;
        r1.d = System.currentTimeMillis();
        r1.p = r19.a;
        IRoom r5 = r1.b;
        if (r5 == null) goto L63;
        LiveMonitor.a r6 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenMessage, r5, null);
        JSONObject r7 = new JSONObject();
        long r9 = r1.m;
        long r11 = r1.n;
        if (r11 <= 0) goto L18;
        long r10 = r9 / r11;
    L19:
        r7.put("avg_bind_latency", r10);
        long r13 = r1.k;
        if (r13 <= 0) goto L22;
        r7.put("message_fcp_receive", r13 - r1.c);
    L22:
        long r14 = r1.l;
        if (r14 <= 0) goto L25;
        r7.put("message_fcp_bind", r14 - r1.c);
    L25:
        r7.put("message_total_throughput", r1.e);
        r7.put("message_total_show_throughput", r1.f);
        r7.put("message_total_show_list_throughput", r1.g);
        r7.put("message_total_show_fold_throughput", r1.h);
        r7.put("message_total_discard_list_throughput", r1.i);
        r7.put("message_total_discard_fold_throughput", r1.j);
        long r15 = r1.e;
        long r16 = r1.d - r1.c;
        long r110 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r111 = r16 / r110;
        if (r111 <= 0) goto L28;
        long r20 = r15 / r111;
    L29:
        r7.put("message_avg_throughput_per_second", r20);
        r7.put("message_max_throughput_per_second", r1.p);
        float r21 = Math.min(r1.j, r1.t);
        long r112 = ((r1.d - r1.c) / r110) / ((long) 60);
        if (r112 <= 0) goto L32;
        float r23 = r21 / r112;
    L33:
        r7.put("message_avg_recoverable_fold_count_per_min", Float.valueOf(r23));
        float r2 = r1.j + r1.i;
        long r24 = r1.e;
        if (r24 <= 0) goto L36;
        float r3 = r2 / r24;
    L37:
        r7.put("message_avg_discard_rate", Float.valueOf(r3));
        float r25 = r1.r;
        long r26 = r1.q;
        if (r26 <= 0) goto L40;
        float r27 = r25 / r26;
    L41:
        r7.put("update_avg_empty_rate", Float.valueOf(r27));
        float r28 = r1.s;
        long r29 = r1.q;
        if (r29 <= 0) goto L44;
        float r30 = r28 / r29;
    L45:
        r7.put("update_avg_abnormal_empty_rate", Float.valueOf(r30));
        r7.put("message_duration", (r1.d - r1.c) / r110);
        Iterator r31 = ((LinkedHashMap) r1.u).values().iterator();
    L47:
        if (r31.hasNext() == false) goto L62;
        b r33 = (b) r31.next();
        r33.getClass();
        Intrinsics.checkNotNullParameter(r7, "obj");
        if (r33.a > 0) goto L51;
    L55:
        boolean r34 = false;
    L56:
        if (r34 == false) goto L47;
        r7.put(r33.d + "_receive_count", r33.a);
        r7.put(r33.d + "_show_count", r33.b);
        String r35 = r33.d + "_avg_show_delay";
        long r113 = r33.c;
        long r114 = r33.b;
        if (r114 <= 0) goto L60;
        long r115 = r113 / r114;
    L61:
        r7.put(r35, r115);
        goto L47
    L60:
        r115 = 0;
        goto L61
    L51:
        if (r33.b <= 0) goto L55;
        if (r33.c <= 0) goto L55;
        r34 = true;
        goto L56
    L62:
        r6.k(r7);
        r6.a().report();
        goto L63
    L44:
        r30 = 0.0f;
        goto L45
    L40:
        r27 = 0.0f;
        goto L41
    L36:
        r3 = 0.0f;
        goto L37
    L32:
        r23 = 0.0f;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L18:
        r10 = 0;
    L63:
        IRoom r36 = r1.b;
        if (r36 != null) goto L66;
    L65:
        a r37 = null;
    L118:
        a = r37;
        return;
    L66:
        long r38 = r1.d - r1.c;
        if (r38 <= 0) goto L65;
        if ((r0 instanceof LiveWidget) == true) goto L72;
        r0 = null;
    L72:
        LiveWidget r39 = (LiveWidget) r0;
        if (r39 == null) goto L65;
        ViewGroup r40 = ((Widget) r39).containerView;
        if (r40 == null) goto L65;
        View r41 = ((Widget) r39).contentView;
        if (r41 == null) goto L65;
        IRoomAuthStatus r43 = r36.getRoomAuthStatus();
        if (r43 == null) goto L87;
        if (r43.getEnableChat() == true) goto L87;
        r8 = 10;
    L116:
        r37 = null;
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenShowStatus, r36, Integer.valueOf(r8), null, 24);
    L87:
        if (r40.getVisibility() == 0) goto L90;
        r8 = 20;
        goto L116
    L90:
        if (r41.getVisibility() == 0) goto L93;
        r8 = 21;
        goto L116
    L93:
        if (r40.getHeight() > 0) goto L96;
        r8 = 30;
        goto L116
    L96:
        if (r41.getHeight() > 0) goto L98;
        r8 = 31;
        goto L116
    L98:
        long r44 = r1.n;
        if (r44 <= 0) goto L101;
    L103:
        if (r44 > 0) goto L108;
        if (r38 >= RiskAdviseSyncData.PRIORITY) goto L108;
        r8 = 41;
    L108:
        if (r44 <= 0) goto L110;
    L112:
        if (r44 > 0) goto L116;
        if (r38 < 20000) goto L116;
        r8 = 43;
        goto L116
    L110:
        if (r38 >= 20000) goto L112;
        r8 = 42;
        goto L116
    L101:
        if (r38 >= 5000) goto L103;
        r8 = 40;
        goto L116
    L7:
        r4 = false;
    L117:
        r37 = null;
        goto L118
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        a r6 = new a();
        a = r6;
        r6.a = r2.getId();
        r6.b = r2;
        r6.c = System.currentTimeMillis();
    }
}
