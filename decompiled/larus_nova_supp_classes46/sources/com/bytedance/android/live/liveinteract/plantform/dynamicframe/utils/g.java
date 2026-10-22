package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.graphics.Point;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.config.b60;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkBaseDegradeConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public g() {
    }

    static {
    }

    public static Point b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        float r0 = r5.getX();
        float r1 = r5.getY();
        Object r6 = r5.getParent();
        if (r6 == null) goto L15;
    L5:
        View r7 = (View) r6;
        if (r7.getId() == 2131378009) goto L13;
        r0 = r0 + r7.getX();
        r1 = r1 + r7.getY();
        r6 = r7.getParent();
        if (r6 != null) goto L5;
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L13:
        return new Point(MathKt.roundToInt(r0), MathKt.roundToInt(r1));
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a0 c(LinkMicRecyclerView r2) {
        a0 r0 = new a0();
        r0.a = (int) r2.getX();
        r0.b = (int) r2.getY();
        r0.d = r2.getLeft();
        r0.c = r2.getTop();
        r2.getRight();
        r2.getBottom();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static sf0.b d(LinkMicRecyclerView r19) {
        Intrinsics.checkNotNullParameter(r19, "rv");
        a0 r1 = c(r19);
        sf0.c r4 = new sf0.c(r1.a, r1.b, r19.getWidth(), r19.getHeight());
        RecyclerView.Adapter r2 = r19.getAdapter();
        if (r2 == null) goto L5;
        int r3 = r2.getItemCount();
    L6:
        int r5 = r19.getChildCount();
        ArrayList r6 = new ArrayList(r5);
        sf0.c r8 = null;
        int r15 = 0;
    L7:
        if (r15 >= r5) goto L25;
        hg0.b r9 = r19.findViewHolderForAdapterPosition(r15);
        if ((r9 instanceof hg0.b) == false) goto L19;
        jg0.g r10 = r9.l();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r11 = r10.h();
        if (r11 == null) goto L13;
        View r12 = r11.m(2131389564);
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r13 = r10.g();
        if (r13 == null) goto L17;
        r12 = r13.m(2131363623);
    L17:
        if (r12 == null) goto L19;
        Point r14 = b(r12);
        sf0.c r16 = new sf0.c(r14.x, r14.y, r12.getWidth(), r12.getHeight());
    L20:
        View r17 = r19.getChildAt(r15);
        int r7 = r15;
        r6.add(new sf0.d(r15, (int) r17.getX(), ((int) r17.getY()) + 0, r17.getWidth(), r17.getHeight(), r16));
        if (r7 != 1) goto L24;
        int r18 = TeamFightProgressBar.s;
        r8 = new sf0.c(r1.a, ((((int) r17.getY()) + r1.b) - r18) + 0, r19.getWidth(), (r17.getHeight() * 2) + r18);
    L24:
        r15 = r7 + 1;
        goto L7
    L13:
        r12 = null;
    L19:
        r16 = null;
        goto L20
    L25:
        ALogger.e("DynamicUtils", "MultiLinkDynamicWidget#getVideoTalkRoomDynamicFrameInfo, childCount = " + r5 + ", adapterCount = " + r3 + ", seatList = " + r6.size() + ", rv = " + r19);
        return new sf0.b(null, r4, r8, r6, 3);
    L5:
        r3 = 0;
        goto L6
    }

    public static JsonObject f(sf0.b r12) {
        Intrinsics.checkNotNullParameter(r12, "frameInfo");
        JsonObject r0 = new JsonObject();
        r0.addProperty("s_w", Float.valueOf(s1.G(s1.z())));
        r0.addProperty("s_h", Float.valueOf(s1.G(s1.x())));
        tf0.j r2 = null;
        if (je0.d.B() == true) goto L17;
        if (je0.d.r() == false) goto L11;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L28;
        tf0.o r3 = r1.windowManager();
        if (r3 == null) goto L28;
        tf0.j r4 = r3.getLinkWindowLayoutConfig();
    L30:
        if (je0.d.B() == true) goto L44;
        if (je0.d.r() == false) goto L38;
        rj0.k.m2.getClass();
        rj0.k r5 = rj0.k.a.a();
        if (r5 == null) goto L55;
        tf0.o r6 = r5.windowManager();
        if (r6 == null) goto L55;
        Integer r7 = Integer.valueOf(r6.o());
    L56:
        int r8 = 0;
        if (r7 == null) goto L59;
        int r9 = r7.intValue();
    L60:
        if (r9 != 0) goto L62;
    L68:
        Integer r10 = r12.a;
        if (r10 == null) goto L71;
        r0.addProperty("ui_layout", Integer.valueOf(r10.intValue()));
    L71:
        JsonArray r11 = new JsonArray();
        Iterator<T> r13 = r12.b.iterator();
    L73:
        if (r13.hasNext() == false) goto L76;
        r11.add(Integer.valueOf(((Number) r13.next()).intValue()));
        goto L73
    L76:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L78;
    L79:
        r0.add("ui_feature_list", r11);
    L80:
        JsonObject r14 = new JsonObject();
        r14.addProperty("x", Float.valueOf(s1.G(r12.c.b)));
        r14.addProperty("y", Float.valueOf(s1.G(r12.c.c)));
        r14.addProperty("w", Float.valueOf(s1.G(r12.c.d)));
        r14.addProperty("h", Float.valueOf(s1.G(r12.c.e)));
        r14.addProperty("offsetY", Integer.valueOf(r12.c.a));
        r0.add("seat_frame", r14);
        sf0.c r15 = r12.d;
        if (r15 == null) goto L83;
        JsonObject r16 = new JsonObject();
        r16.addProperty("x", Float.valueOf(s1.G(r15.b)));
        r16.addProperty("y", Float.valueOf(s1.G(r15.c)));
        r16.addProperty("w", Float.valueOf(s1.G(r15.d)));
        r16.addProperty("h", Float.valueOf(s1.G(r15.e)));
        r0.add("bar_seat_frame", r16);
    L83:
        JsonArray r17 = new JsonArray();
        int r18 = r12.e.size();
    L84:
        if (r8 >= r18) goto L89;
        JsonObject r19 = new JsonObject();
        sf0.d r20 = (sf0.d) ListProtector.get(r12.e, r8);
        r19.addProperty("position", Integer.valueOf(r20.a));
        r19.addProperty("x", Float.valueOf(s1.G(r20.b)));
        r19.addProperty("y", Float.valueOf(s1.G(r20.c)));
        r19.addProperty("w", Float.valueOf(s1.G(r20.d)));
        r19.addProperty("h", Float.valueOf(s1.G(r20.e)));
        sf0.c r21 = r20.f;
        if (r21 == null) goto L88;
        JsonObject r110 = new JsonObject();
        r110.addProperty("x", Float.valueOf(s1.G(r21.b)));
        r110.addProperty("y", Float.valueOf(s1.G(r21.c)));
        r110.addProperty("w", Float.valueOf(s1.G(r21.d)));
        r110.addProperty("h", Float.valueOf(s1.G(r21.e)));
        r19.add("avatar", r110);
    L88:
        r17.add(r19);
        r8 = r8 + 1;
        goto L84
    L89:
        r0.add("seats", r17);
        return r0;
    L78:
        if (vm2.h.g0().d() == false) goto L80;
    L62:
        if ((r4 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.m) == false) goto L65;
        r2 = r4;
    L65:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r22 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m) r2;
        if (r22 == null) goto L68;
        int r23 = r22.q(r9);
        JsonObject r24 = new JsonObject();
        r24.addProperty("top_margin", Float.valueOf(s1.G(r23)));
        r0.add("seat_config", r24);
        goto L68
    L59:
        r9 = 0;
    L55:
        r7 = null;
        goto L56
    L38:
        rj0.l.n2.getClass();
        rj0.l r25 = rj0.l.a.a();
        if (r25 == null) goto L55;
        tf0.o r26 = r25.windowManager();
        if (r26 == null) goto L55;
        r7 = Integer.valueOf(r26.o());
        goto L56
    L44:
        if (je0.d.r() == false) goto L50;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r27 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r27 == null) goto L55;
        tf0.o r28 = r27.commonWindowManager();
        if (r28 == null) goto L55;
        r7 = Integer.valueOf(r28.o());
        goto L56
    L50:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r29 = IVoiceChatGuestService.a.a();
        if (r29 == null) goto L55;
        tf0.o r30 = r29.commonWindowManager();
        if (r30 == null) goto L55;
        r7 = Integer.valueOf(r30.o());
    L28:
        r4 = null;
        goto L30
    L11:
        rj0.l.n2.getClass();
        rj0.l r31 = rj0.l.a.a();
        if (r31 == null) goto L28;
        tf0.o r32 = r31.windowManager();
        if (r32 == null) goto L28;
        r4 = r32.getLinkWindowLayoutConfig();
        goto L30
    L17:
        if (je0.d.r() == false) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r33 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r33 == null) goto L28;
        tf0.o r34 = r33.commonWindowManager();
        if (r34 == null) goto L28;
        r4 = r34.getLinkWindowLayoutConfig();
        goto L30
    L23:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r35 = IVoiceChatGuestService.a.a();
        if (r35 == null) goto L28;
        tf0.o r36 = r35.commonWindowManager();
        if (r36 == null) goto L28;
        r4 = r36.getLinkWindowLayoutConfig();
        goto L30
    }

    public static JsonObject g(sf0.c r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        JsonObject r0 = new JsonObject();
        r0.addProperty("x", Integer.valueOf(r3.b));
        r0.addProperty("y", Integer.valueOf(r3.c));
        r0.addProperty("width", Integer.valueOf(r3.d));
        r0.addProperty("height", Integer.valueOf(r3.e));
        return r0;
    }

    public static JsonObject h(List r10) {
        Intrinsics.checkNotNullParameter(r10, "subtitleItems");
        JsonObject r0 = new JsonObject();
        JsonArray r1 = new JsonArray();
        int r2 = ((ArrayList) r10).size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L34;
        JsonObject r5 = new JsonObject();
        nj0.g r6 = (nj0.g) ListProtector.get(r10, r4);
        r5.addProperty("rtc_user_id", r6.b);
        r5.addProperty("text", r6.c);
        r5.addProperty("sequence", Integer.valueOf(r6.d));
        r5.addProperty("definite", Boolean.valueOf(r6.e));
        IBaseUser r7 = r6.a;
        if (r7 == null) goto L33;
        JsonObject r8 = new JsonObject();
        r8.addProperty("id_str", r7.getIdString());
        r8.addProperty("short_id", Long.valueOf(r7.getShortId()));
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        r8.addProperty("sec_uid", r7.getCastSecUid());
        r8.addProperty("nickname", r7.getRealNickName());
        r8.addProperty("is_anonymous", Boolean.valueOf(r7.isAnonymous()));
        r8.addProperty("signature", r7.getSignature());
        if (((MultiLinkBaseDegradeConfig) b60.a.getValue()).getLiveAudioSimpleDataEnable() == true) goto L32;
        py.k r9 = r7.getAvatarThumbKt();
        if (r9 == null) goto L12;
        List r11 = r9.getUrls();
        if (r11 == null) goto L12;
    L14:
        if ((!r11.isEmpty()) == false) goto L16;
        r8.addProperty("avatar", (String) ListProtector.get(r11, 0));
    L16:
        py.k r12 = r7.getAvatarMedium();
        if (r12 == null) goto L20;
        List r13 = r12.getUrls();
        if (r13 == null) goto L20;
    L22:
        if (r13.size() <= 0) goto L24;
        r8.addProperty("avatar_medium", (String) ListProtector.get(r13, 0));
    L24:
        py.k r14 = r7.getAvatarLarge();
        if (r14 == null) goto L28;
        List r15 = r14.getUrls();
        if (r15 == null) goto L28;
    L30:
        if (r15.size() <= 0) goto L32;
        r8.addProperty("avatar_large", (String) ListProtector.get(r15, 0));
    L28:
        r15 = CollectionsKt.emptyList();
    L20:
        r13 = CollectionsKt.emptyList();
    L12:
        r11 = CollectionsKt.emptyList();
    L32:
        r5.add("user", r8);
    L33:
        r1.add(r5);
        r4 = r4 + 1;
        goto L3
    L34:
        r0.add("subtitle_list", r1);
        return r0;
    }

    public static void i(ih0.c r2) {
        if (((Number) q0.a.getValue()).intValue() >= 2) goto L5;
        return;
    L5:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) == true) goto L7;
        r2 = null;
    L7:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r3 = (com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r2;
        if (r3 == null) goto L12;
        r3.e.j();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static sf0.b e(LinkMicRecyclerView r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "rv");
        a0 r1 = c(r17);
        sf0.c r4 = new sf0.c(r1.a, r1.b, r17.getWidth(), r17.getHeight());
        int r2 = r17.getChildCount();
        ArrayList r6 = new ArrayList(r2);
        int r3 = 0;
        sf0.c r14 = null;
    L3:
        if (r3 >= r2) goto L30;
        hg0.b r7 = r17.findViewHolderForAdapterPosition(r3);
        if ((r7 instanceof hg0.b) == false) goto L18;
        jg0.g r8 = r7.l();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r9 = r8.h();
        if (r9 == null) goto L9;
        View r10 = r9.m(2131389564);
    L10:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r11 = r8.g();
        if (r11 == null) goto L13;
        r10 = r11.m(2131363623);
    L13:
        MultiLinkPreOnlineMicSeatBasicLayer r12 = r8.o();
        if (r12 == null) goto L16;
        r10 = r12.m(2131389534);
    L16:
        if (r10 == null) goto L18;
        Point r13 = b(r10);
        sf0.c r15 = new sf0.c(r13.x, r13.y, r10.getWidth(), r10.getHeight());
    L19:
        View r16 = r17.getChildAt(r3);
        r6.add(new sf0.d(r3, (int) r16.getX(), (int) r16.getY(), r16.getWidth(), r16.getHeight(), r15));
        if (r3 != 0) goto L28;
        int r5 = TeamFightProgressBar.s;
        if (li0.d.g(null) == true) goto L24;
    L26:
        int r19 = (r1.c + r16.getHeight()) - r5;
        r14 = new sf0.c(r1.d, r19, r17.getWidth(), (r1.c + r17.getHeight()) - r19);
        goto L28
    L24:
        if (TeamFightContext.Companion.h() == false) goto L26;
        s1.f(4.0f);
        int r20 = (((int) r16.getY()) + r1.b) - r5;
        int r21 = com.bytedance.android.live.liveinteract.multiscene.i.a;
        r14 = new sf0.c(r1.a, r20 + s1.f(14), r17.getWidth(), r17.getHeight() + r5);
    L28:
        r3 = r3 + 1;
        goto L3
    L9:
        r10 = null;
    L18:
        r15 = null;
        goto L19
    L30:
        return new sf0.b(Integer.valueOf(r18), r4, r14, r6, 2);
    }

    public static sf0.b a(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "layoutConfig");
        pn0.f r0 = r10.d;
        int r1 = 0;
        if (r0 == null) goto L10;
        pn0.f.b r13 = r0.c;
        int r14 = r13.a;
        int r2 = r13.b;
        int r3 = r13.c;
        int r15 = r13.d;
        if (r14 >= 0) goto L7;
        r3 = r3 + r14;
        r14 = 0;
    L7:
        if (r2 >= 0) goto L9;
        r15 = r15 + r2;
        r2 = 0;
    L9:
        sf0.c r4 = new sf0.c(r14 + 0, r2, r3, r15);
    L11:
        sf0.c r6 = r4;
        List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r16 = r10.h();
        if (r16 == null) goto L15;
        r1 = r16.size();
    L15:
        return new sf0.b(null, r6, null, new ArrayList(r1), 3);
    L10:
        float r5 = r10.s(r11, r12);
        r4 = new sf0.c(0, r10.q(r12), r11, (int) r5);
        goto L11
    }
}
