package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public boolean b;

    public v0() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        boolean r0 = jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IUserService.class).user().n());
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L13:
        String r2 = "other";
    L14:
        HashMap r4 = new HashMap();
        r4.put("position", "more_function_panel");
        if (r0 == false) goto L17;
        String r3 = "1";
    L18:
        r4.put("is_song_order", r3);
        r4.put("link_status", r2);
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L21;
        iy.g r6 = r5.getDynamicCenterService(this.a);
    L23:
        if (r6 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r6 != null) goto L30;
    L32:
        boolean r8 = false;
    L33:
        if (r7 == false) goto L36;
        if (r8 == false) goto L36;
        boolean r9 = true;
    L38:
        if (r9 == false) goto L41;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131918799), 0);
        return;
    L41:
        IInteractService r10 = jc1.k.f(IInteractService.class);
        if (r10 == null) goto L44;
        iy.g r12 = r10.getDynamicCenterService(this.a);
    L45:
        if (r12 != null) goto L47;
    L49:
        boolean r13 = false;
    L50:
        if (r12 != null) goto L52;
    L54:
        boolean r14 = false;
    L55:
        if (r13 == false) goto L58;
        if (r14 == false) goto L58;
        boolean r15 = true;
    L59:
        if (r15 == false) goto L62;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131918813), 0);
        return;
    L62:
        Lazy r16 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_mini_window_open_icon_click", r4, new Object[]{new am2.x(), Room.class});
        IUserService r17 = jc1.k.f(IUserService.class);
        if (r17 == null) goto L68;
        com.bytedance.android.livesdk.user.f r18 = r17.user();
        if (r18 == null) goto L68;
        String r19 = r18.n();
        if (r19 == null) goto L68;
    L69:
        IKtvService r20 = jc1.k.f(IKtvService.class);
        if (r20 == null) goto L75;
        gd2.c r21 = r20.getChorusConcertService();
        if (r21 == null) goto L75;
        if (r21.b() != true) goto L75;
    L93:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131918799), 0);
        return;
    L75:
        com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r22 == null) goto L96;
        IRoom r23 = (IRoom) r22.getValue();
        if (r23 == null) goto L96;
        z5 r24 = r23.getLinkerDetail();
        if (r24 == null) goto L96;
        List r25 = r24.getPlayModes();
        if (r25 == null) goto L96;
        if (r25.contains(Long.valueOf(39)) != true) goto L96;
        com.bytedance.live.datacontext.m r26 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r26 == null) goto L90;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L90;
        String r28 = r27.getAnchorId();
    L92:
        if (StringsKt.equals$default(r28, r19, false, 2, null) != true) goto L96;
    L90:
        r28 = null;
    L96:
        if (jc0.a.a() == false) goto L99;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131921853), 0);
        return;
    L99:
        DataCenter r29 = this.a;
        if (r29 == null) goto L121;
        Room r30 = (Room) r29.get("data_room", null);
        if (r30 != null) goto L105;
        return;
    L105:
        if (r30.isLiveTypeAudio() == false) goto L113;
        Integer r31 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r31 == null) goto L113;
        if (r31.intValue() != 0) goto L113;
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131915121), 0);
        return;
    L113:
        if (r11 == null) goto L122;
        Context r110 = r11.getContext();
        if (r110 != null) goto L117;
        return;
    L117:
        if (rx1.m.e(r110) == false) goto L119;
        HashMap r111 = new HashMap();
        r111.put("open_source", "more_panel");
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r32 = com.bytedance.android.livesdk.floatview.inner.b.a;
        com.bytedance.android.livesdk.floatview.inner.b.c(r111, false);
        return;
    L119:
        com.bytedance.android.livesdk.floatview.p.g(r110);
        return;
    L122:
        return;
    L121:
        return;
    L68:
        r19 = "";
    L58:
        r15 = false;
        goto L59
    L52:
        if (r12.rb() != true) goto L54;
        r14 = true;
        goto L55
    L47:
        if (r12.getCurrentScene() != 20) goto L49;
        r13 = true;
        goto L50
    L44:
        r12 = null;
    L36:
        r9 = false;
        goto L38
    L30:
        if (r6.Rp() != true) goto L32;
        r8 = true;
        goto L33
    L25:
        if (r6.getCurrentScene() != 20) goto L27;
        r7 = true;
        goto L28
    L21:
        r6 = null;
        goto L23
    L17:
        r3 = "0";
        goto L18
    L11:
        if (r1.intValue() != 1) goto L13;
        r2 = "apply";
        goto L14
    L6:
        if (r1.intValue() != 2) goto L8;
        r2 = "link";
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = false;
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        this.a = r7;
        boolean r8 = jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IUserService.class).user().n());
        Integer r9 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r9 != null) goto L6;
    L8:
        if (r9 != null) goto L11;
    L13:
        String r10 = "other";
    L14:
        HashMap r2 = new HashMap();
        r2.put("position", "more_function_panel");
        if (r8 == false) goto L17;
        String r11 = "1";
    L18:
        r2.put("is_song_order", r11);
        r2.put("link_status", r10);
        if (this.b == true) goto L22;
        this.b = true;
        Lazy r12 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_mini_window_open_icon_show", r2, new Object[]{new am2.x(), Room.class});
        return;
    L22:
        return;
    L17:
        r11 = "0";
        goto L18
    L11:
        if (r9.intValue() != 1) goto L13;
        r10 = "apply";
        goto L14
    L6:
        if (r9.intValue() != 2) goto L8;
        r10 = "link";
        goto L14
    }
}
