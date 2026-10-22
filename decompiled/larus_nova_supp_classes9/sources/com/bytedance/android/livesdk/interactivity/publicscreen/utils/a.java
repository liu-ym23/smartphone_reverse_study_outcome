package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import am2.x;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements s42.c {
    public static final a a = null;

    public a() {
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
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
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
    public final void l(tlc.d r1) {
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        a = new a();
    }

    public static boolean u(com.bytedance.android.livesdk.interactivity.api.entity.f r1) {
        if ((r1 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (((z) r1).H.getType() != PublicScreenConfig$MessageModelType.AI_AUTO_REPLY) goto L7;
        return true;
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        if (u(r3) == false) goto L6;
        b.a(InteractivityMonitor.Event.AIAutoReplyMessageShowStatus, null, 3);
        return;
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        if (u(r7) == true) goto L5;
        return;
    L5:
        if (r7 == null) goto L35;
        int r2 = k22.a.a;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r8 = r7.s();
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.b) == true) goto L9;
        r8 = null;
    L9:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.b r9 = (com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.b) r8;
        if (r9 == null) goto L14;
        com.bytedance.android.live.base.model.message.j r10 = r9.l;
        if (r10 == null) goto L14;
        Map r11 = r10.getTag();
    L15:
        HashMap r3 = new HashMap();
        String r4 = BuildConfig.FLAVOR;
        if (r11 == null) goto L26;
        Iterator r13 = r11.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L26;
        Map.Entry r5 = (Map.Entry) r13.next();
        String r6 = (String) r5.getKey();
        if (r6 == null) goto L19;
        String r14 = (String) r5.getValue();
        if (r14 != null) goto L25;
        r14 = BuildConfig.FLAVOR;
    L25:
        r3.put(r6, r14);
    L26:
        IMiddlewareUserService r15 = jc1.k.f(IMiddlewareUserService.class);
        if (r15 == null) goto L34;
        com.bytedance.android.livesdk.user.e r16 = r15.user();
        if (r16 == null) goto L34;
        String r17 = r16.n();
        if (r17 == null) goto L34;
        r4 = r17;
    L34:
        r3.put("user_id", r4);
        j0.l().sendLog("livesdk_ai_qa_screen_message_show", r3, new Object[]{IRoom.class, x.class});
        k22.a.b("live_screen_message");
        b.b(InteractivityMonitor.Event.AIAutoReplyTrackReport, null);
        xs2.b.a().post(new o42.a());
    L14:
        r11 = null;
    L35:
        b.a(InteractivityMonitor.Event.AIAutoReplyMessageShowStatus, null, 1);
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        if (u(r3) == false) goto L6;
        b.a(InteractivityMonitor.Event.AIAutoReplyMessageShowStatus, null, 0);
        return;
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        if (u(r3) == false) goto L6;
        b.a(InteractivityMonitor.Event.AIAutoReplyMessageShowStatus, null, 2);
        return;
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r2, IRoom r3, s42.c.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        s42.c.a.a(r1, r2, r5);
    }
}
