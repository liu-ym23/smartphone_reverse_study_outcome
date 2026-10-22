package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u0 {
    public static final String b() {
        ArrayList r0 = new ArrayList();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r1 == null) goto L19;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.m r3 = r2.getPlayModes();
        if (r3 == null) goto L19;
        Set r4 = (Set) r3.getValue();
        if (r4 == null) goto L19;
        Sequence r5 = CollectionsKt.asSequence(r4);
        if (r5 == null) goto L19;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        String r7 = k(((Number) r6.next()).intValue());
        if ((!Intrinsics.areEqual(r7, "normal")) == false) goto L14;
        r0.add(r7);
    L19:
        if (je0.d.f() != 16) goto L22;
        r0.add("link_room");
    L22:
        if (r0.size() != 0) goto L25;
        r0.add("normal");
    L25:
        return CollectionsKt.joinToString$default(r0, ",", "[", "]", 0, null, null, 56, null);
    }

    public static final List<Integer> d() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r0 == null) goto L13;
        LivePlayModeLogContext r1 = (LivePlayModeLogContext) r0.getValue();
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m r2 = r1.getPlayModes();
        if (r2 == null) goto L13;
        Set r3 = (Set) r2.getValue();
        if (r3 == null) goto L13;
        List<Integer> r4 = CollectionsKt.toList(r3);
        if (r4 == null) goto L13;
        return r4;
    L13:
        return CollectionsKt.emptyList();
    }

    public static final String c(IRoom r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L15;
        z5 r10 = r9.getLinkerDetail();
        if (r10 == null) goto L15;
        List r11 = r10.getPlayModes();
        if (r11 == null) goto L15;
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        String r2 = k((int) ((Number) r12.next()).longValue());
        if ((!Intrinsics.areEqual(r2, "normal")) == false) goto L10;
        r0.add(r2);
    L15:
        if (je0.d.f() != 16) goto L18;
        r0.add("link_room");
    L18:
        if (r0.size() != 0) goto L21;
        r0.add("normal");
    L21:
        return CollectionsKt.joinToString$default(r0, ",", "[", "]", 0, null, null, 56, null);
    }

    public static final String e(List<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "playmodes");
        ArrayList r1 = new ArrayList();
        Sequence r11 = CollectionsKt.asSequence(r10);
        if (r11 == null) goto L11;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        String r2 = k(((Number) r12.next()).intValue());
        if ((!Intrinsics.areEqual(r2, "normal")) == false) goto L6;
        r1.add(r2);
    L11:
        if (je0.d.f() != 16) goto L14;
        r1.add("link_room");
    L14:
        if (r1.size() != 0) goto L17;
        r1.add("normal");
    L17:
        return CollectionsKt.joinToString$default(r1, ",", "[", "]", 0, null, null, 56, null);
    }

    public static String j(Integer r2) {
        return i(r2, je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a));
    }

    public static final String k(int r2) {
        StringBuilder r0 = new StringBuilder();
        String r3 = com.bytedance.android.live.liveinteract.utils.x.a.get(Integer.valueOf(r2));
        if (r3 != null) goto L5;
        r3 = "normal";
    L5:
        r0.append(r3);
        r0.append("");
        return r0.toString();
    }

    public static final String a(Integer r2, Integer r3) {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r0 == null) goto L5;
        DataCenter r1 = (DataCenter) r0.getValue();
    L5:
        int r4 = 0;
        if (r2 == null) goto L8;
        int r5 = r2.intValue();
    L9:
        if (r3 == null) goto L11;
        r4 = r3.intValue();
    L11:
        if (r5 != 0) goto L13;
        return "live";
    L13:
        if (r5 == 5) goto L22;
        if (r5 == 9) goto L18;
        return "radio";
    L18:
        if (r4 != 61) goto L20;
        return "chorus";
    L20:
        return "ktv";
    L22:
        if (r4 != 22) goto L28;
        return "party";
    L28:
        return "radio";
    L8:
        r5 = 0;
        goto L9
    }

    public static final String h(Integer r2, List<Integer> r3) {
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r3) == false) goto L33;
        if (r2 != null) goto L7;
    L10:
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        String r5 = null;
        if (r4 == null) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r6 = r4.getLinkUserInfoCenter();
        if (r6 == null) goto L29;
        Iterable r7 = r6.getOnlineUserList();
        if (r7 == null) goto L29;
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r0 = r8.next();
        if (((ILinkPlayerInfoBridge) r0).isEnlarged() == false) goto L18;
    L23:
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r0;
        if (r1 == null) goto L29;
        IBaseUser r9 = r1.getUser();
        if (r9 == null) goto L29;
        r5 = r9.getIdString();
        goto L29
    L22:
        r0 = null;
    L29:
        if (Intrinsics.areEqual(r5, je0.d.a()) == false) goto L31;
        return "anchor";
    L31:
        return "guest";
    L7:
        if (r2.intValue() != 43) goto L10;
        return "double";
    L33:
        return "normal";
    }

    public static final String i(Integer r4, List<Integer> r5, Integer r6) {
        if (r4 == null) goto L47;
        r4.intValue();
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L28;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L28;
        if (r1.isLiveTypeAudio() != true) goto L28;
        if (r4.intValue() != 30) goto L14;
        return "stage_enlarge";
    L14:
        if (r4.intValue() != 26) goto L22;
        if (r6 == null) goto L22;
        if (r6.intValue() != 26) goto L22;
        return "seat_enlarge_double";
    L22:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r5) == false) goto L25;
        return "seat_enlarge";
    L25:
        if (r4.intValue() != 28) goto L27;
        return "seat_enlarge";
    L27:
        return "normal";
    L28:
        int r7 = r4.intValue();
        if (r7 != 2) goto L31;
    L45:
        return "seat_fit";
    L31:
        if (r7 == 3) goto L50;
        if (r7 == 6) goto L50;
        if (r7 == 7) goto L45;
        if (r7 == 43) goto L50;
        if (r7 != 102) goto L41;
    L43:
        return "big_frame";
    L41:
        if (r7 == 103) goto L43;
        return "normal";
    L50:
        return "seat_enlarge";
    L47:
        return null;
    }

    public static final String g(Integer r2, Integer r3, List r4, List r5) {
        if (r2 != null) goto L6;
    L12:
        if (r2 != null) goto L15;
    L23:
        if (r4 == null) goto L38;
        Iterator r6 = r4.iterator();
        int r7 = 0;
    L26:
        if (r6.hasNext() == false) goto L31;
        if (((ILinkPlayerInfoBridge) r6.next()).isEnlarged() == false) goto L26;
        r7 = r7 + 1;
        goto L26
    L31:
        if (r7 != 2) goto L38;
        if (r3 != null) goto L35;
    L37:
        return "double_normal";
    L35:
        if (r3.intValue() != 26) goto L37;
    L36:
        return "stable_double";
    L38:
        return null;
    L15:
        if (r2.intValue() != 28) goto L23;
        if (r5 == null) goto L21;
        if (r5.contains(2L) != true) goto L38;
    L21:
        if (Intrinsics.areEqual(TalkRoomLogUtils.m, Boolean.TRUE) == false) goto L38;
    L6:
        if (r2.intValue() != 26) goto L12;
        if (r3 == null) goto L37;
        if (r3.intValue() != 26) goto L37;
        goto L37
    }

    public static String f(Integer r2, Integer r3, List r4, Integer r5, List r6, List r7, int r8) {
        if ((r8 & 8) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 16) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 32) == 0) goto L11;
        r7 = null;
    L11:
        if (r2 == null) goto L48;
        r2.intValue();
        if (r3 == null) goto L49;
        r3.intValue();
        com.bytedance.android.livesdk.chatroom.o r9 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r9 == null) goto L23;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L23;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L23;
        if (r11.isLiveTypeAudio() != true) goto L23;
        return g(r2, r5, r6, r7);
    L23:
        boolean r12 = com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r4);
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r4) == true) goto L26;
        return null;
    L26:
        if (r2.intValue() != 43) goto L29;
    L36:
        return "double_normal";
    L29:
        if (r2.intValue() != 28) goto L38;
        HamletAvatarContext r13 = HamletAvatarContext.Companion.getContext();
        if (r13 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r14 = r13.isMultiAvatarMode();
        if (r14 != null) goto L35;
        return null;
    L35:
        if (((Boolean) r14.getValue()).booleanValue() == true) goto L36;
        return null;
    L52:
        return null;
    L38:
        if (r3.intValue() != 12) goto L44;
        if (r12 == false) goto L41;
        String r15 = "party_fit";
    L56:
        return r15;
    L41:
        r15 = "party_normal";
        goto L56
    L44:
        if (r3.intValue() != 8) goto L57;
        if (r12 == false) goto L47;
        r15 = "video_fit";
        goto L56
    L47:
        r15 = "video_normal";
        goto L56
    L57:
        return null;
    L49:
        return null;
    L48:
        return null;
    }
}
