package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.GroupPurchaseConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.RoomChannelConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.config.z9;
import com.bytedance.android.livesdk.config.zp;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements o {
    public final SparseArray<a0> a;
    public o b;
    public DataCenter c;

    public k() {
        this.a = new SparseArray();
    }

    public final x3 d(boolean r2) {
        if (r2 == true) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r3 = y3.m(this.c);
        if ((r3 instanceof x3) == true) goto L8;
        r3 = null;
    L8:
        return (x3) r3;
    L9:
        return y3.f(this.c);
    }

    public final void f(a0 r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        o r0 = this.b;
        if (r0 == null) goto L6;
        r0.register(r4);
        return;
    L6:
        int r1 = ((NewToolbarButtonConstants) r4.b.getValue()).getId();
        ALogger.i("NewToolbarLog", "register config id: " + r1);
        this.a.put(r1, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final a0 getToolbarConfig(int r2) {
        return this.a.get(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final void register(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        f(r2);
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b a(s r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "model");
        if (this.a.get(r4.a) != null) goto L6;
        ALogger.e("NewToolbarLog", r4 + " can't find Config");
        return null;
    L6:
        ToolbarButton r7 = c(r4, r5, r6);
        if (r7 != null) goto L10;
        ALogger.i("NewToolbarLog", r7 + " can't find ToolbarButton");
        return null;
    L10:
        x3 r8 = d(r5);
        if (r8 != null) goto L13;
        return null;
    L13:
        return r8.t(r7);
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b b(s r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "toolbarButton");
        a0 r0 = this.a.get(r7.a);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r2 = null;
        if (r0 != null) goto L6;
        HashMap<String, String> r10 = q.a;
        q.a(r7.a, ToolbarReasonTag.NORMAL, " can't find config");
        ALogger.e("NewToolbarLog", r7 + " can't find config");
        return null;
    L6:
        ToolbarButton r3 = r0.l(r9, r8);
        if (r3 != null) goto L11;
        HashMap<String, String> r11 = q.a;
        q.a(r7.a, ToolbarReasonTag.NORMAL, " can't find ToolbarButton");
        ALogger.i("NewToolbarLog", r3 + " can't find ToolbarButton");
        return null;
    L11:
        if (r0.m() == false) goto L24;
        x3 r4 = d(r8);
        if (r4 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r5 = r4.t(r3);
    L16:
        if (r5 == null) goto L24;
        x3 r6 = d(r8);
        if (r6 != null) goto L20;
    L23:
        ALogger.e("NewToolbarLog", "getOrCreateBehavior error: " + r3 + " is loaded but not showing");
        goto L24
    L20:
        if (r6.n(r3) != true) goto L23;
        ALogger.i("NewToolbarLog", "getOrCreateBehavior " + r3 + " is showing");
        return null;
    L15:
        r5 = null;
    L24:
        x3 r1 = d(r8);
        if (r1 == null) goto L27;
        r2 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) ((HashMap) r1.e).get(r3.extended());
    L27:
        if (r2 != null) goto L51;
        r2 = r0.h(r7, r8, Boolean.valueOf(r9));
        if ((r2 instanceof t) == false) goto L51;
        x3 r12 = d(r8);
        if (r12 == null) goto L51;
        if (r12.l == true) goto L51;
        ExtendedToolbarButton.h.getClass();
        ExtendedToolbarButton.b r13 = ExtendedToolbarButton.a.a(r3);
        if (r12.l == true) goto L51;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L51;
        if (r2 == null) goto L51;
        if ((r2 instanceof t) == true) goto L46;
        ALogger.e("ToolbarManager", "behavior is not PermanentBehavior");
        goto L51
    L46:
        if (((HashMap) r12.e).get(r13) == null) goto L49;
        ALogger.e("ToolbarManager", "behavior is existed");
        goto L51
    L49:
        if (r12.b == null) goto L51;
        ((HashMap) r12.e).put(r13, r2);
        ((t) r2).onInit();
    L51:
        if (r2 != null) goto L53;
        HashMap<String, String> r14 = q.a;
        q.a(r7.a, ToolbarReasonTag.COMPONENT, " getOrCreateBehavior null");
    L53:
        return r2;
    }

    public final ToolbarButton c(s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        a0 r5 = this.a.get(r2.a);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.l(r4, r3);
    }

    public final void e(DataCenter r5, Context r6, o r7) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.c = r5;
        this.b = r7;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.m(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.c(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.d(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.f0());
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.i(r6, r5));
        IOpenPlatformAudienceService r8 = jc1.k.f(IOpenPlatformAudienceService.class);
        if (r8 == null) goto L7;
        a0 r9 = r8.createToolbarComponentConfig(r5, r6);
        if (r9 == null) goto L7;
        f(r9);
    L7:
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.s(r6, r5));
        f(new GroupPurchaseConfig(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.q(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.h(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.f(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.u(r6, r5));
        if (u40.a.a() == false) goto L10;
        f(new RoomChannelConfig(r6, r5));
    L10:
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.z(r5));
        pm1.h r10 = pm1.h.d;
        nm1.w r0 = (nm1.w) r10.c(nm1.w.class);
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b0 r1 = r0.a(r5);
        if (r1 == null) goto L15;
        f(r1);
    L15:
        nm1.t r2 = pm1.f.q();
        if (r2 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.c0 r3 = r2.c(r6, r5);
        if (r3 == null) goto L20;
        f(r3);
    L20:
        nm1.y r4 = pm1.f.r();
        if (r4 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.a0 r11 = r4.f(r5);
        if (r11 == null) goto L25;
        f(r11);
    L25:
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.x(r6, r5));
        nm1.y r12 = pm1.f.r();
        if (r12 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.y r13 = r12.a(r5);
        if (r13 == null) goto L30;
        f(r13);
    L30:
        nm1.w r14 = (nm1.w) r10.c(nm1.w.class);
        if (r14 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.w r15 = r14.c(r5);
        if (r15 == null) goto L36;
        f(r15);
    L36:
        if (u40.a.b() == false) goto L39;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.n(r6, r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.e0(r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.o(r5));
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.l(r5));
    L39:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L42;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r(r5));
    L42:
        if (zp.a.getValue().booleanValue() == false) goto L52;
        LiveMode r16 = com.bytedance.android.live.core.utils.z.c(r5);
        if (r16 != LiveMode.VIDEO) goto L46;
    L51:
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.d0(r6, r5));
        goto L52
    L46:
        if (r16 == LiveMode.THIRD_PARTY) goto L51;
        if (r16 != LiveMode.AUDIO) goto L52;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b(r6, r5));
    L52:
        nm1.r r17 = pm1.f.o();
        if (r17 == null) goto L57;
        wu2.c r18 = r17.d();
        if (r18 == null) goto L57;
        wu2.b r19 = r18.a(r5);
    L59:
        if ((r19 instanceof a0) == true) goto L61;
        r19 = null;
    L61:
        if (r19 == null) goto L63;
        f(r19);
    L63:
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.v(r5));
        Boolean r20 = (Boolean) r5.get("data_current_is_preview", Boolean.FALSE);
        if (r20 == null) goto L66;
        boolean r21 = r20.booleanValue();
    L67:
        if (r21 == false) goto L69;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.p(r5));
    L91:
        if (z9.a.getValue().getEnable() == false) goto L94;
        f(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.h(r5, r6));
    L94:
        if (oz0.a.getValue().booleanValue() == false) goto L106;
        IInteractGameService r22 = jc1.k.f(IInteractGameService.class);
        if (r22 == null) goto L107;
        a0 r23 = r22.createToolbarComponentConfig(r5, r6);
        if (r23 == null) goto L108;
        f(r23);
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L69:
        boolean r24 = com.bytedance.android.live.revenue.core.util.h.a;
        RoomContext r25 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r25 == null) goto L74;
        com.bytedance.live.datacontext.j r26 = r25.getRevenueInstance();
        if (r26 == null) goto L74;
        com.bytedance.android.live.revenue.core.b r27 = (com.bytedance.android.live.revenue.core.b) r26.getValue();
    L75:
        b11.a r28 = com.bytedance.android.live.revenue.core.util.h.b(r27, b11.a.class);
        if (r28 == null) goto L78;
        List r29 = r28.V();
    L79:
        if (r29 == null) goto L91;
        Iterator r30 = r29.iterator();
    L82:
        if (r30.hasNext() == false) goto L91;
        Object r31 = r30.next();
        if ((r31 instanceof a0) == true) goto L86;
        r31 = null;
    L86:
        a0 r32 = (a0) r31;
        if (r32 == null) goto L82;
        f(r32);
        goto L82
    L78:
        r29 = null;
    L74:
        r27 = null;
        goto L75
    L66:
        r21 = false;
    L57:
        r19 = null;
        goto L59
    }
}
