package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final b a;
    public boolean b;
    public long c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> j;
    public final DataCenter k;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.utils.a$a, reason: collision with other inner class name */
    public static final class C0104a {
    }

    static {
    }

    public final void c() {
        if (this.b == false) goto L5;
        return;
    L5:
        ALogger.d("CPositionDurationHelper", "release: selfIsCPosition=" + this.h + ", cPositionStart=" + this.c);
        this.j.T4(this.a);
        this.b = true;
        if (this.h == true) goto L8;
    L10:
        this.c = 0;
        this.h = false;
        return;
    L8:
        if (this.c <= 0) goto L10;
        d(SystemClock.elapsedRealtime() - this.c, this.f, this.g);
        goto L10
    }

    public static boolean a(List r3) {
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r1 = r4.next();
        if (((ILinkPlayerInfoBridge) r1).isEnlarged() == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.size() < 2) goto L11;
    L14:
        return true;
    L11:
        if (TalkRoomLogUtils.b.a == 26) goto L14;
        return false;
    }

    public final void b(List<? extends ILinkPlayerInfoBridge> r14) {
        if (this.b == false) goto L5;
        return;
    L5:
        String r0 = je0.d.b0();
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        Boolean r4 = Boolean.FALSE;
        Pair r1 = new Pair(r4, r4);
    L30:
        boolean r5 = ((Boolean) r1.component1()).booleanValue();
        boolean r2 = ((Boolean) r1.component2()).booleanValue();
        if (this.i == r5) goto L36;
        ALogger.d("CPositionDurationHelper", "online state change " + this.i + " -> " + r5);
        if (r5 == false) goto L35;
        this.d = 0;
        this.e = false;
    L35:
        this.i = r5;
    L36:
        if (r2 == false) goto L57;
        String r6 = je0.d.a();
        if (r6 != null) goto L40;
        r6 = "";
    L40:
        Iterator<T> r7 = r14.iterator();
    L42:
        if (r7.hasNext() == false) goto L50;
        Object r9 = r7.next();
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r9).getUser();
        if (r10 == null) goto L46;
        String r11 = r10.getIdString();
    L48:
        if (Intrinsics.areEqual(r11, r6) == false) goto L42;
    L51:
        ILinkPlayerInfoBridge r12 = (ILinkPlayerInfoBridge) r9;
        if (r12 == null) goto L54;
        boolean r8 = r12.isEnlarged();
    L55:
        this.f = r8;
        this.g = a(r14);
        goto L57
    L54:
        r8 = false;
        goto L55
    L46:
        r11 = null;
        goto L48
    L50:
        r9 = null;
    L57:
        if (this.h == r2) goto L141;
        if (r2 == false) goto L129;
        ALogger.d("CPositionDurationHelper", "我【成为】C位了");
        this.c = SystemClock.elapsedRealtime();
        this.e = true;
        boolean r13 = a(r14);
        com.bytedance.live.datacontext.m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r15 == null) goto L66;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L66;
        if (r16.isLiveTypeAudio() != true) goto L66;
        String r17 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), r14, null, 32);
    L67:
        i0 r18 = TalkRoomLogUtils.a;
        DataCenter r19 = this.k;
        Intrinsics.checkNotNullParameter(r14, "list");
        LinkedHashMap r20 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r20);
        TalkRoomLogUtils.B0(r20, null, null, 6);
        r20.put("play_mode", u0.b());
        TalkRoomLogUtils.V0(r20);
        r20.put("enlarge_user_type", TalkRoomLogUtils.y());
        r20.put("enlarge_user_id", je0.d.b0().toString());
        r20.put("seat_num", String.valueOf(je0.d.R()));
        r20.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        r20.putAll(TalkRoomLogUtils.e());
        InteractiveSongLoggerKt.b(r20);
        if (r17 == null) goto L71;
        r20.put("enlarge_show_type", r17);
    L73:
        String r21 = "1";
        if (r13 == false) goto L77;
        r20.put("is_double", "1");
    L77:
        if (TalkRoomLogUtils.D(r14, r19) == false) goto L79;
        r20.put("is_anchor_enlarge", "1");
    L79:
        com.bytedance.android.live.liveinteract.plantform.utils.h r110 = TalkRoomLogUtils.b;
        r20.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(r110.a)));
        if (r110.a != 26) goto L82;
        r20.put("is_empty_enlarge_seat", TalkRoomLogUtils.s(r19));
    L82:
        InteractiveSongContext.a r111 = InteractiveSongContext.Companion;
        InteractiveSongContext r22 = r111.getContext();
        if (r22 == null) goto L102;
        com.bytedance.live.datacontext.j<of0.b> r23 = r22.getInteractiveSongWidget();
        if (r23 == null) goto L102;
        of0.b r24 = (of0.b) r23.getValue();
        if (r24 == null) goto L102;
        String r25 = r24.Bm();
        if (r25 == null) goto L102;
        if (r111.f() == false) goto L102;
        r20.put("play_layout", r25);
        HamletAvatarContext r112 = HamletAvatarContext.Companion.getContext();
        if (r112 == null) goto L100;
        com.bytedance.live.datacontext.n<Long> r113 = r112.getCurrentSelectAvatarID();
        if (r113 == null) goto L100;
        Long r114 = (Long) r113.getValue();
        if (r114 == null) goto L100;
        String r115 = String.valueOf(r114.longValue());
        if (r115 == null) goto L100;
    L101:
        r20.put("avatar_id", r115);
        e33.e r116 = TalkRoomLogUtils.c;
        r116.b("play_layout", r25);
        r116.b("play_mode", u0.b());
        r116.b("avatar_id", r115);
    L100:
        r115 = "0";
    L102:
        r20.put("user_type", TalkRoomLogUtils.y());
        HamletAvatarContext.a r117 = HamletAvatarContext.Companion;
        HamletAvatarContext r26 = r117.getContext();
        if (r26 == null) goto L111;
        com.bytedance.live.datacontext.j<gd0.g> r27 = r26.getHamletAvatarService();
        if (r27 == null) goto L111;
        gd0.g r28 = (gd0.g) r27.getValue();
        if (r28 == null) goto L111;
        if (r28.I6() != true) goto L111;
    L112:
        r20.put("is_multiplayer", r21);
        Integer r29 = je0.d.h();
        if (r29 != null) goto L116;
    L118:
        String r30 = "classic";
    L119:
        r20.put("play_layout", r30);
        HamletAvatarContext r118 = r117.getContext();
        if (r118 == null) goto L128;
        com.bytedance.live.datacontext.j<gd0.g> r119 = r118.getHamletAvatarService();
        if (r119 == null) goto L128;
        gd0.g r120 = (gd0.g) r119.getValue();
        if (r120 == null) goto L128;
        Long r121 = r120.Ue();
        if (r121 == null) goto L128;
        r20.put("avatar_id", String.valueOf(r121.longValue()));
    L128:
        zi0.d.b(r20, false);
        j0.l().sendLog("livesdk_live_guest_enlarge_start", r20, new Object[]{IRoom.class, am2.x.class});
    L133:
        this.h = r2;
        return;
    L116:
        if (r29.intValue() != 28) goto L118;
        r30 = "avatar";
    L111:
        r21 = "0";
        goto L112
    L71:
        if (je0.d.f() != 12) goto L73;
        TalkRoomLogUtils.x0(r20);
    L66:
        r17 = null;
        goto L67
    L129:
        ALogger.d("CPositionDurationHelper", "我【下】C位了");
        if (this.c <= 0) goto L132;
        long r31 = SystemClock.elapsedRealtime() - this.c;
        this.d += r31;
        d(r31, this.f, this.g);
        this.c = 0;
    L132:
        ALogger.d("CPositionDurationHelper", "lastLinkCPositionDuration=" + this.d);
        goto L133
    L141:
        return;
    L15:
        Iterator<T> r32 = r14.iterator();
    L17:
        if (r32.hasNext() == false) goto L25;
        Object r33 = r32.next();
        IBaseUser r34 = ((ILinkPlayerInfoBridge) r33).getUser();
        if (r34 == null) goto L21;
        String r35 = r34.getIdString();
    L23:
        if (Intrinsics.areEqual(r35, r0) == false) goto L17;
    L26:
        ILinkPlayerInfoBridge r36 = (ILinkPlayerInfoBridge) r33;
        if (r36 == null) goto L29;
        r1 = new Pair(Boolean.TRUE, Boolean.valueOf(r36.isEnlarged()));
        goto L30
    L29:
        Boolean r37 = Boolean.FALSE;
        r1 = new Pair(r37, r37);
        goto L30
    L21:
        r35 = null;
        goto L23
    L25:
        r33 = null;
        goto L26
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
        goto L13
    }

    public a(com.bytedance.android.live.liveinteract.plantform.core.y r1, boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r1, "userCenter");
        this.j = r1;
        this.k = r3;
        b r4 = new b(this);
        this.a = r4;
        r1.Q4(r4);
        b(r1.c);
    }

    public final void d(long r11, boolean r13, boolean r14) {
        ALogger.d("CPositionDurationHelper", "我的C位时长：" + r11);
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Integer r2 = null;
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.isLiveTypeAudio() != true) goto L9;
        String r3 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a), null, null, 48);
    L10:
        i0 r4 = TalkRoomLogUtils.a;
        DataCenter r5 = this.k;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(TalkRoomLogUtils.e());
        TalkRoomLogUtils.J0(r6);
        TalkRoomLogUtils.B0(r6, null, null, 6);
        r6.put("play_mode", u0.b());
        TalkRoomLogUtils.V0(r6);
        r6.put("duration", String.valueOf((r11 + ((long) 500)) / ((long) 1000)));
        com.bytedance.android.live.liveinteract.plantform.utils.h r12 = TalkRoomLogUtils.b;
        r6.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(r12.a)));
        if (r12.a != 26) goto L13;
        r6.put("is_empty_enlarge_seat", TalkRoomLogUtils.s(r5));
    L13:
        r6.put("enlarge_user_type", TalkRoomLogUtils.y());
        r6.put("enlarge_user_id", je0.d.b0().toString());
        r6.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        InteractiveSongLoggerKt.b(r6);
        if (r3 == null) goto L17;
        r6.put("enlarge_show_type", r3);
    L19:
        String r15 = "1";
        if (r14 == false) goto L22;
        r6.put("is_double", "1");
    L22:
        if (r13 == false) goto L24;
        r6.put("is_anchor_enlarge", "1");
    L24:
        e33.e r16 = TalkRoomLogUtils.c;
        if (r16.a.isEmpty() == true) goto L39;
        Object r17 = r16.get("play_layout");
        if (r17 == null) goto L38;
        r6.put("play_layout", (String) r17);
        Object r18 = r16.get("play_mode");
        if (r18 == null) goto L36;
        r6.put("play_mode", (String) r18);
        Object r19 = r16.get("avatar_id");
        if (r19 == null) goto L34;
        r6.put("avatar_id", (String) r19);
        r16.a.clear();
        goto L39
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L39:
        r6.put("user_type", TalkRoomLogUtils.y());
        HamletAvatarContext.a r110 = HamletAvatarContext.Companion;
        HamletAvatarContext r111 = r110.getContext();
        if (r111 != null) goto L42;
    L44:
        r15 = "0";
    L45:
        r6.put("is_multiplayer", r15);
        Integer r112 = je0.d.h();
        com.bytedance.android.livesdk.chatroom.u r113 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r113 == null) goto L55;
        com.bytedance.live.datacontext.j r114 = r113.s();
        if (r114 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r115 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r114.getValue();
        if (r115 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r116 = r115.g();
        if (r116 == null) goto L55;
        r2 = Integer.valueOf(r116.b);
    L55:
        if (r112 != null) goto L58;
    L59:
        if (r2 != null) goto L62;
    L64:
        String r117 = "classic";
    L66:
        r6.put("play_layout", r117);
        HamletAvatarContext r118 = r110.getContext();
        if (r118 == null) goto L75;
        com.bytedance.live.datacontext.j<gd0.g> r119 = r118.getHamletAvatarService();
        if (r119 == null) goto L75;
        gd0.g r120 = (gd0.g) r119.getValue();
        if (r120 == null) goto L75;
        Long r121 = r120.Ue();
        if (r121 == null) goto L75;
        r6.put("avatar_id", String.valueOf(r121.longValue()));
    L75:
        String r122 = u0.j(r2);
        if (r122 == null) goto L78;
        r6.put("layout_type", r122);
    L78:
        zi0.d.b(r6, false);
        j0.l().sendLog("livesdk_live_guest_enlarge_over", r6, new Object[]{IRoom.class, am2.x.class});
        return;
    L62:
        if (r2.intValue() != 28) goto L64;
    L65:
        r117 = "avatar";
        goto L66
    L58:
        if (r112.intValue() == 28) goto L65;
    L42:
        if (r111.isMultiAvatarModeForReport() != true) goto L44;
    L17:
        if (je0.d.f() != 12) goto L19;
        TalkRoomLogUtils.x0(r6);
    L9:
        r3 = null;
        goto L10
    }
}
