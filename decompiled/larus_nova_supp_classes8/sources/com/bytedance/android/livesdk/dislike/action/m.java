package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.dislike.ActionsManager;
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
public final class m extends OptionAction {
    public static boolean f;
    public final DataCenter e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void c() {
        super.c();
        f = false;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.h.c;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        boolean r0 = jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IUserService.class).user().n());
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L13:
        String r2 = "other";
    L14:
        HashMap r4 = new HashMap();
        r4.put("position", "long_press_panel");
        if (r0 == false) goto L17;
        String r3 = "1";
    L18:
        r4.put("is_song_order", r3);
        r4.put("link_status", r2);
        Lazy r5 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_mini_window_open_icon_click", r4, new Object[]{new am2.x(), Room.class});
        if (this.b != null) goto L21;
        return;
    L21:
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L24;
        iy.g r7 = r6.getDynamicCenterService(this.e);
    L26:
        if (r7 != null) goto L28;
    L30:
        boolean r8 = false;
    L31:
        if (r7 != null) goto L33;
    L35:
        boolean r9 = false;
    L36:
        if (r8 == false) goto L39;
        if (r9 == false) goto L39;
        boolean r11 = true;
    L41:
        if (r11 == false) goto L44;
        f2.c(s1.B(2131918799), 0);
        return;
    L44:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L47;
        iy.g r13 = r12.getDynamicCenterService(this.e);
    L48:
        if (r13 != null) goto L50;
    L52:
        boolean r14 = false;
    L53:
        if (r13 != null) goto L55;
    L57:
        boolean r15 = false;
    L58:
        if (r14 == false) goto L61;
        if (r15 == false) goto L61;
        boolean r16 = true;
    L62:
        if (r16 == false) goto L65;
        f2.c(s1.B(2131918813), 0);
        return;
    L65:
        IUserService r17 = jc1.k.f(IUserService.class);
        if (r17 == null) goto L71;
        com.bytedance.android.livesdk.user.f r18 = r17.user();
        if (r18 == null) goto L71;
        String r19 = r18.n();
        if (r19 == null) goto L71;
    L72:
        IKtvService r20 = jc1.k.f(IKtvService.class);
        if (r20 == null) goto L78;
        gd2.c r21 = r20.getChorusConcertService();
        if (r21 == null) goto L78;
        if (r21.b() != true) goto L78;
    L96:
        f2.c(s1.B(2131918799), 0);
        return;
    L78:
        com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r22 == null) goto L99;
        IRoom r23 = (IRoom) r22.getValue();
        if (r23 == null) goto L99;
        z5 r24 = r23.getLinkerDetail();
        if (r24 == null) goto L99;
        List r25 = r24.getPlayModes();
        if (r25 == null) goto L99;
        if (r25.contains(Long.valueOf(39)) != true) goto L99;
        com.bytedance.live.datacontext.m r26 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r26 == null) goto L93;
        IRoom r27 = (IRoom) r26.getValue();
        if (r27 == null) goto L93;
        String r28 = r27.getAnchorId();
    L95:
        if (StringsKt.equals$default(r28, r19, false, 2, null) != true) goto L99;
    L93:
        r28 = null;
    L99:
        if (jc0.a.a() == false) goto L102;
        f2.c(s1.B(2131921853), 0);
        return;
    L102:
        Room r29 = this.b;
        if (r29 != null) goto L105;
    L113:
        Context r110 = r10.getContext();
        if (r110 != null) goto L116;
        return;
    L116:
        if (rx1.m.e(r110) == false) goto L118;
        HashMap r111 = new HashMap();
        r111.put("open_source", "long_press");
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r30 = com.bytedance.android.livesdk.floatview.inner.b.a;
        com.bytedance.android.livesdk.floatview.inner.b.c(r111, false);
        return;
    L118:
        com.bytedance.android.livesdk.floatview.p.g(r110);
        return;
    L105:
        if (r29.isLiveTypeAudio() != true) goto L113;
        Integer r31 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r31 == null) goto L113;
        if (r31.intValue() != 0) goto L113;
        f2.c(s1.B(2131915121), 0);
        return;
    L71:
        r19 = "";
    L61:
        r16 = false;
        goto L62
    L55:
        if (r13.rb() != true) goto L57;
        r15 = true;
        goto L58
    L50:
        if (r13.getCurrentScene() != 20) goto L52;
        r14 = true;
        goto L53
    L47:
        r13 = null;
    L39:
        r11 = false;
        goto L41
    L33:
        if (r7.Rp() != true) goto L35;
        r9 = true;
        goto L36
    L28:
        if (r7.getCurrentScene() != 20) goto L30;
        r8 = true;
        goto L31
    L24:
        r7 = null;
        goto L26
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

    public m(ActionsManager r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "actionsManager");
        super(r6);
        this.e = r7;
        this.d = true;
        if (f == true) goto L22;
        boolean r8 = jc1.k.n(IKtvService.class).isUserSelectMusic(jc1.k.n(IUserService.class).user().n());
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L13;
    L15:
        String r1 = "other";
    L16:
        HashMap r2 = new HashMap();
        r2.put("position", "long_press_panel");
        if (r8 == false) goto L19;
        String r9 = "1";
    L20:
        r2.put("is_song_order", r9);
        r2.put("link_status", r1);
        Lazy r10 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_mini_window_open_icon_show", r2, new Object[]{new am2.x(), Room.class});
        f = true;
        return;
    L19:
        r9 = "0";
        goto L20
    L13:
        if (r0.intValue() != 1) goto L15;
        r1 = "apply";
        goto L16
    L8:
        if (r0.intValue() != 2) goto L10;
        r1 = "link";
        goto L16
    }
}
