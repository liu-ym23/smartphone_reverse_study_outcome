package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.l4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.pg;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.o4;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarMutexHelper implements com.bytedance.android.livesdk.chatroom.utils.c0 {
    public static final List<ExtendedToolbarButton> f = null;
    public final ToolbarConstraints a;
    public final l4 b;
    public final Map<ExtendedToolbarButton, ToolbarSlot> c;
    public final Map<ExtendedToolbarButton, ToolbarSlot> d;
    public final DataCenter e;

    public static final class a {
    }

    public static final class b implements Comparator<ExtendedToolbarButton> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(ExtendedToolbarButton r2, ExtendedToolbarButton r3) {
            ExtendedToolbarButton r4 = r2;
            ExtendedToolbarButton r5 = r3;
            int r0 = 0;
            if (r4 == null) goto L9;
            int r6 = r4.b;
            if (r5 == null) goto L8;
            r0 = r5.b;
        L8:
            return r6 - r0;
        L9:
            return 0;
        }
    }

    static {
        f = CollectionsKt.listOf(new ExtendedToolbarButton[]{ToolbarButton.INTERACTION_ROOM.extended(), ToolbarButton.PK.extended(), ToolbarButton.INTERACTION.extended(), ToolbarButton.INTERACTION_AUDIENCE.extended()});
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final String b() {
        if (((LinkedHashMap) this.d).keySet().isEmpty() == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder();
        ArrayList<ExtendedToolbarButton> r1 = h();
        if (r1 == null) goto L13;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L13;
        r0.append(((ExtendedToolbarButton) r2.next()).f());
        r0.append(" ");
    L13:
        return r0.toString();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final ArrayList<ExtendedToolbarButton> h() {
        if (((LinkedHashMap) this.d).keySet() != null) goto L6;
        return null;
    L6:
        ArrayList<ExtendedToolbarButton> r0 = new ArrayList(((LinkedHashMap) this.d).keySet());
        Collections.sort(r0, new b());
        return r0;
    }

    public final int l() {
        return this.d.size();
    }

    public final int n() {
        boolean r1 = true;
        int r2 = 5;
        if (com.bytedance.android.live.core.utils.z.m(this.e, true) == false) goto L5;
        int r3 = 0;
        if (com.bytedance.android.live.core.utils.z.e(this.e, false) == false) goto L13;
        r2 = 6;
    L13:
        if (com.bytedance.android.live.core.utils.z.e(this.e, false) == true) goto L18;
        if (Intrinsics.areEqual((Boolean) e81.k.getValue(), Boolean.TRUE) == false) goto L18;
        r2 = 4;
    L18:
        if (p() == false) goto L33;
        List<ExtendedToolbarButton> r0 = f;
        if ((r0 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r4 = r0.iterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        if (this.d.containsKey((ExtendedToolbarButton) r4.next()) == false) goto L26;
    L31:
        if (r1 == true) goto L33;
        r2 = r2 - 1;
    L30:
        r1 = false;
        goto L31
    L22:
        if (r0.isEmpty() == false) goto L24;
    L33:
        com.bytedance.android.live.core.utils.z.f(this.e);
        if (VrUtils.c(this.e) == false) goto L39;
        if (com.bytedance.android.live.core.utils.q2.b(com.bytedance.android.live.core.utils.z.o(this.e)) == true) goto L39;
        r2 = 3;
    L39:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L53;
        if (com.bytedance.android.live.core.utils.z.e(this.e, false) == true) goto L53;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r5 == null) goto L51;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L51;
        Room r7 = (Room) r6.getValue();
        if (r7 == null) goto L51;
        LiveToolbarData r8 = r7.getToolbarData();
        if (r8 == null) goto L51;
        r3 = r8.getMaxCount().intValue();
    L51:
        r2 = Math.max(r3, r2);
    L53:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L61;
        pg r9 = pg.a;
        if (((Number) r9.getValue()).intValue() > 0) goto L57;
        return r2;
    L57:
        return ((Integer) r9.getValue()).intValue();
    L61:
        return r2;
    L5:
        if (com.bytedance.android.live.core.utils.z.o(this.e).isMergeVSRoom() == false) goto L7;
        return 5;
    L7:
        return 7;
    }

    public final boolean p() {
        if (com.bytedance.android.live.core.utils.z.e(this.e, false) == true) goto L11;
        Integer r0 = (Integer) e81.e.getValue();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final Map<ExtendedToolbarButton, ToolbarSlot> c() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final ToolbarConstraints e() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final Map<ExtendedToolbarButton, ToolbarSlot> g() {
        return this.c;
    }

    public ToolbarMutexHelper(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.e = r5;
        ToolbarConstraints.f.getClass();
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        StringBuilder r0 = new StringBuilder();
        r0.append(com.bytedance.android.live.core.utils.z.e(r5, false));
        r0.append(((Number) e81.e.getValue()).intValue());
        String r1 = r0.toString();
        Map<String, WeakReference<ToolbarConstraints>> r2 = ToolbarConstraints.e;
        WeakReference r3 = (WeakReference) ((LinkedHashMap) r2).get(r1);
        if (r3 == null) goto L5;
        ToolbarConstraints r4 = (ToolbarConstraints) r3.get();
    L6:
        if (r4 == null) goto L18;
        r4.b = r5;
    L16:
        this.a = r4;
        this.b = new l4(this.e, this);
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        return;
    L18:
    L14:
        e = move-exception;
        ALogger.e("ToolbarConstraints", e);
        r4 = new ToolbarConstraints();
        goto L16
    L9:
        if (com.bytedance.android.live.core.utils.z.e(r5, false) == false) goto L11;
        ToolbarConstraints r6 = new q();     // Catch: IOException -> L14
    L12:
        r4 = r6;
        r4.b = r5;     // Catch: IOException -> L14
        ToolbarConstraints.Companion.a(r4);     // Catch: IOException -> L14
        ToolbarConstraints.Companion.b(r4);     // Catch: IOException -> L14
        r2.put(r1, new WeakReference(r4));     // Catch: IOException -> L14
        goto L16
    L11:
        r6 = new i();     // Catch: IOException -> L14
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final int i(ExtendedToolbarButton r2) {
        Intrinsics.checkNotNullParameter(r2, "btn");
        ArrayList<ExtendedToolbarButton> r0 = h();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.indexOf(r2);
    }

    public final void j(ExtendedToolbarButton r10) {
        if (l() < n()) goto L5;
        return;
    L5:
        ExtendedToolbarButton r0 = ToolbarButton.mappingFold(r10);
        if (r0 != null) goto L8;
        return;
    L8:
        Object r5 = null;
        ToolbarButton r6 = null;
        if (Intrinsics.areEqual(r0, ToolbarButton.INTERACTION_MORE.extended()) == false) goto L19;
        if ((r10 instanceof ExtendedToolbarButton.b) == true) goto L13;
        ExtendedToolbarButton r1 = null;
    L14:
        ExtendedToolbarButton.b r2 = (ExtendedToolbarButton.b) r1;
        if (r2 == null) goto L17;
        r6 = r2.i;
    L17:
        y3.m(this.e).b(r6, new pp1.g(false));
        y3.m(this.e).b(ToolbarButton.MORE, new pp1.g(false));
        int r3 = u3.a;
        u3.a("fold -> unfold, " + r10 + ", folded:" + r0);
        return;
    L13:
        r1 = r10;
        goto L14
    L19:
        if (Intrinsics.areEqual(r0, ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE.extended()) == false) goto L21;
        y3.m(this.e).b(ToolbarButton.GAME_PROMOTE_AUDIENCE, new pp1.g(false));
        return;
    L21:
        ToolbarButton r4 = ToolbarButton.ROOM_CHANNEL;
        if (Intrinsics.areEqual(r0, r4.extended()) == false) goto L24;
        y3.m(this.e).b(r4, new pp1.g(false));
        return;
    L24:
        ToolbarButton r7 = ToolbarButton.LIVE_IM_ENTRANCE;
        if (Intrinsics.areEqual(r0, r7.extended()) == false) goto L27;
        y3.m(this.e).b(r7, new pp1.g(false));
        return;
    L27:
        ToolbarButton r8 = ToolbarButton.VS_MESSAGE_BOARD;
        if (Intrinsics.areEqual(r0, r8.extended()) == false) goto L30;
        y3.m(this.e).b(r8, new pp1.g(false));
        return;
    L30:
        Iterator r9 = ((ArrayList) this.a.d).iterator();
    L32:
        if (r9.hasNext() == false) goto L43;
        Object r11 = r9.next();
        ToolbarSlot r12 = (ToolbarSlot) r11;
        if (r12.a(r10.f()) == false) goto L36;
    L39:
        boolean r13 = true;
    L40:
        if (r13 == false) goto L32;
        r5 = r11;
        goto L43
    L36:
        if (r12.a(r0.f()) == true) goto L39;
        r13 = false;
    L43:
        if (((ToolbarSlot) r5) == null) goto L56;
        y3.f(this.e).i(r0);
        int r14 = u3.a;
        u3.a("fold -> unfold, " + r10 + ", folded:" + r0);
        return;
    }

    public final void o(ExtendedToolbarButton r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getEnableToolbarLog();
        if (r1 != null) goto L7;
        return;
    L7:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L12;
        com.bytedance.android.livesdk.chatroom.utils.o1 r2 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        int r3 = i(r6);
        r2.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o1.g("livesdk_toolbar_icon_off", r6, r3);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final void a(x3 r24, ExtendedToolbarButton r25) {
        Intrinsics.checkNotNullParameter(r24, "tbm");
        Intrinsics.checkNotNullParameter(r25, "button2Show");
        String r3 = r25.f();
        if (r24.a == true) goto L5;
    L191:
        int r4 = u3.a;
        Intrinsics.checkNotNullParameter("Showing button directly, " + r3 + ", unfold:" + r24.a + ", isLocalButton: " + r25.e, "msg");
        r24.F(r25, 0);
        return;
    L5:
        if (r25.e == false) goto L191;
        int r5 = u3.a;
        u3.a("try showing " + r3);
        if (((LinkedHashMap) this.d).get(r25) == null) goto L11;
        Intrinsics.checkNotNullParameter("duplicate showing req for " + r3 + ", aborting", "msg");
        return;
    L11:
        c0 r6 = y3.m(this.e);
        if (r6 == null) goto L190;
        x3 r7 = (x3) r6;
        if (com.bytedance.android.live.core.utils.z.e(this.e, false) == true) goto L16;
    L19:
        ToolbarSlot r8 = (ToolbarSlot) ((LinkedHashMap) this.a.a).get(r3);
        if (r8 != null) goto L23;
        String r1 = "no slot for " + r3 + ", skip mutex";
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.w("ToolbarLogger", r1);
        return;
    L23:
        this.c.put(r25, r8);
        if (p() == false) goto L33;
        if (f.contains(r25) == false) goto L33;
        if (l4.c.contains(r25) == false) goto L30;
        s(r24, r25, r8);
        return;
    L30:
        r(r24, r25, r8);
        return;
    L33:
        if (n() <= l()) goto L35;
        boolean r9 = true;
    L36:
        String r10 = r8.b(new ToolbarMutexHelper$show$targetSlotPreviousShowingItem$1(this));
        u3.a("previousShowingItem in targetSlot is: " + r10);
        Map<String, h2> r12 = this.a.c;
        if (r10 != null) goto L44;
        if (r9 == false) goto L44;
        u3.a("show " + r3 + ", no sibling showing, efficient space");
        j(r25);
        if (l4.c.contains(r25) == false) goto L42;
        s(r24, r25, r8);
        return;
    L42:
        r(r24, r25, r8);
        return;
    L44:
        if (r10 == null) goto L53;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        if (d4.a((h2) r13.get(r10)) > d4.a((h2) r13.get(r3))) goto L51;
        ToolbarButton r11 = ToolbarButton.fromName(r10);
        if (r11 == null) goto L50;
        ExtendedToolbarButton r14 = r11.extended();
    L52:
        String r21 = r10;
    L73:
        StringBuilder r15 = new StringBuilder("lowest button is ");
        if (r14 == null) goto L76;
        String r16 = r14.f();
    L77:
        r15.append(r16);
        u3.a(r15.toString());
        if (r14 == null) goto L168;
        if (l() < n()) goto L82;
    L83:
        String r17 = r14.f();
        ExtendedToolbarButton r18 = ToolbarButton.mappingFold(r14);
        if (r18 != null) goto L87;
    L155:
        boolean r19 = false;
    L156:
        if (r19 == false) goto L158;
        this.d.remove(r14);
        goto L168
    L158:
        m(r24, r14, true);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r20 = r24.w(r14);
        if (r20 == null) goto L161;
        int r22 = r20.a;
    L162:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r23 = r24.w(r25);
        if (r23 == null) goto L165;
        int r26 = r23.a;
    L166:
        k(r22, "dismiss by " + r26 + ' ' + r25.f());
        int r27 = u3.a;
        u3.a("hide visible low priority button(#" + r17 + "), in other slot");
        goto L168
    L165:
        r26 = -1;
        goto L166
    L161:
        r22 = -1;
        goto L162
    L87:
        if (Intrinsics.areEqual(r18, ToolbarButton.INTERACTION_MORE.extended()) == false) goto L124;
        Integer r110 = (Integer) e81.e.getValue();
        if (r110 == null) goto L155;
        if (r110.intValue() != 2) goto L155;
        Integer r111 = (Integer) this.e.get("data_link_state", 0);
        boolean r112 = gd0.v.a(r111.intValue(), 32);
        boolean r113 = gd0.v.a(r111.intValue(), 8);
        if (jc1.k.n(IMicRoomService.class).isMicRoom((Room) this.e.get("data_room", new Room())) == true) goto L97;
    L99:
        boolean r28 = false;
    L101:
        if (((Boolean) e81.j.getValue()).booleanValue() == false) goto L105;
        if (r113 == true) goto L155;
        if (r28 == true) goto L155;
    L110:
        if ((r14 instanceof ExtendedToolbarButton.b) == true) goto L112;
        ExtendedToolbarButton r114 = null;
    L113:
        ExtendedToolbarButton.b r29 = (ExtendedToolbarButton.b) r114;
        if (r29 == null) goto L155;
        ToolbarButton r30 = r29.i;
        if (r30 == null) goto L155;
        c0 r115 = y3.m(this.e);
        if (r115 == null) goto L122;
        x3 r116 = (x3) r115;
        r116.b(r30, new pp1.g(true));
        r116.b(ToolbarButton.MORE, new pp1.g(true));
        r116.F(r30.extended(), 0);
        u3.a("unfold -> fold, " + r14 + ", folded:" + r18);
    L154:
        r19 = true;
        goto L156
    L122:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L112:
        r114 = r14;
        goto L113
    L105:
        if (r113 == true) goto L155;
        if (r112 == true) goto L155;
        if (r28 == false) goto L110;
    L97:
        if (((Boolean) this.e.get("data_microom_host_stats", Boolean.FALSE)).booleanValue() == false) goto L99;
        r28 = true;
        goto L101
    L124:
        if (Intrinsics.areEqual(r18, ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE.extended()) == false) goto L126;
        y3.m(this.e).b(ToolbarButton.GAME_PROMOTE_AUDIENCE, new pp1.g(true));
        goto L155
    L126:
        ToolbarButton r31 = ToolbarButton.LIVE_IM_ENTRANCE;
        if (Intrinsics.areEqual(r18, r31.extended()) == false) goto L129;
        y3.m(this.e).b(r31, new pp1.g(true));
        goto L155
    L129:
        ToolbarButton r32 = ToolbarButton.ROOM_CHANNEL;
        if (Intrinsics.areEqual(r18, r32.extended()) == false) goto L132;
        y3.m(this.e).b(r32, new pp1.g(true));
        goto L155
    L132:
        ToolbarButton r33 = ToolbarButton.VS_ACTIVITY_ONE;
        if (Intrinsics.areEqual(r18, r33.extended()) == false) goto L135;
        y3.m(this.e).b(r33, new pp1.g(true));
        goto L155
    L135:
        ToolbarButton r34 = ToolbarButton.VS_MESSAGE_BOARD;
        if (Intrinsics.areEqual(r18, r34.extended()) == false) goto L138;
        y3.m(this.e).b(r34, new pp1.g(true));
        goto L155
    L138:
        Iterator r35 = ((ArrayList) this.a.d).iterator();
    L140:
        if (r35.hasNext() == false) goto L150;
        Object r36 = r35.next();
        ToolbarSlot r117 = (ToolbarSlot) r36;
        if (r117.a(r14.f()) == false) goto L144;
    L147:
        boolean r118 = true;
    L148:
        if (r118 == false) goto L140;
        Object r119 = r36;
    L152:
        if (((ToolbarSlot) r119) == null) goto L155;
        y3.f(this.e).c(r18);
        int r37 = u3.a;
        u3.a("unfold -> fold, " + r14 + ", folded:" + r18);
        goto L154
    L144:
        if (r117.a(r18.f()) == true) goto L147;
        r118 = false;
        goto L148
    L150:
        r119 = null;
        goto L152
    L82:
        if (Intrinsics.areEqual((ToolbarSlot) ((LinkedHashMap) this.a.a).get(r14.f()), r8) == true) goto L83;
    L168:
        if ((!Intrinsics.areEqual(r14, r25)) == true) goto L171;
        if (r21 == null) goto L171;
    L176:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2 = r24.w(r25);
        if (r2 == null) goto L179;
        int r38 = r2.a;
    L181:
        if (Intrinsics.areEqual(r14, r25) == false) goto L185;
        if (r21 == null) goto L185;
        k(r38, "lowest button");
        return;
    L185:
        if (l() < n()) goto L205;
        k(r38, "slot size limit");
        return;
    L205:
        return;
    L179:
        r38 = -1;
    L171:
        if (l() >= n()) goto L176;
        j(r25);
        if (l4.c.contains(r25) == false) goto L175;
        s(r24, r25, r8);
        return;
    L175:
        r(r24, r25, r8);
        return;
    L76:
        r16 = null;
        goto L77
    L50:
        r21 = r10;
        r14 = null;
        goto L73
    L51:
        r14 = r25;
        goto L52
    L53:
        Iterator r39 = CollectionsKt.union(((LinkedHashMap) this.d).keySet(), CollectionsKt.listOf(r25)).iterator();
        if (r39.hasNext() == true) goto L56;
        r21 = r10;
        Object r120 = null;
    L72:
        r14 = (ExtendedToolbarButton) r120;
        goto L73
    L56:
        r120 = r39.next();
        if (r39.hasNext() == true) goto L59;
        r21 = r10;
        goto L72
    L59:
        ExtendedToolbarButton r121 = (ExtendedToolbarButton) r120;
        LinkedHashMap r122 = (LinkedHashMap) r12;
        int r123 = d4.a((h2) r122.get(r121.f()));
        String r124 = "data center: ";
        StringBuilder r40 = new StringBuilder("data center: ");
        r40.append(this.a.b);
        r40.append(", priority of ");
        Object r125 = r120;
        r40.append(r121.f());
        r40.append(" is ");
        r40.append(r123);
        Intrinsics.checkNotNullParameter(r40.toString(), "msg");
        h2 r41 = (h2) r122.get(r121.f());
        if (r41 == null) goto L62;
        int r42 = r41.a();
    L63:
        Object r126 = r39.next();
        ExtendedToolbarButton r210 = (ExtendedToolbarButton) r126;
        int r127 = d4.a((h2) r122.get(r210.f()));
        int r211 = u3.a;
        r21 = r10;
        StringBuilder r128 = new StringBuilder(r124);
        String r212 = r124;
        r128.append(this.a.b);
        r128.append(", priority of ");
        r128.append(r210.f());
        r128.append(" is ");
        r128.append(r127);
        Intrinsics.checkNotNullParameter(r128.toString(), "msg");
        h2 r129 = (h2) r122.get(r210.f());
        if (r129 == null) goto L66;
        int r130 = r129.a();
    L67:
        if (r42 <= r130) goto L70;
        r42 = r130;
        r125 = r126;
    L70:
        if (r39.hasNext() == false) goto L71;
        r10 = r21;
        r124 = r212;
        goto L63
    L71:
        r120 = r125;
        goto L72
    L66:
        Intrinsics.checkNotNullParameter("no cached priority find, THIS IS AN ERROR", "msg");
        ALogger.e("ToolbarLogger", "no cached priority find, THIS IS AN ERROR");
        r130 = Integer.MIN_VALUE;
        goto L67
    L62:
        Intrinsics.checkNotNullParameter("no cached priority find, THIS IS AN ERROR", "msg");
        ALogger.e("ToolbarLogger", "no cached priority find, THIS IS AN ERROR");
        r42 = Integer.MIN_VALUE;
        goto L63
    L35:
        r9 = false;
        goto L36
    L16:
        if (f.contains(r25) == false) goto L19;
        r7.F(r25, 0);
        return;
    L190:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final void d(x3 r4, ExtendedToolbarButton r5) {
        Intrinsics.checkNotNullParameter(r4, "tbm");
        Intrinsics.checkNotNullParameter(r5, "buttonRemove");
        if (r4.a == true) goto L5;
    L29:
        r4.F(r5, 8);
        o(r5);
        this.b.c(r4, r5);
        return;
    L5:
        if (r5.e == false) goto L29;
        if (((LinkedHashMap) this.c).get(r5) != null) goto L18;
        if (((LinkedHashMap) this.d).get(r5) != null) goto L18;
        c0 r0 = y3.m(this.e);
        if (r0 == null) goto L16;
        ((x3) r0).F(r5, 8);
        int r1 = u3.a;
        Intrinsics.checkNotNullParameter(r5.f() + " not showing, duplicate dismiss req, skip mutex", "msg");
        o(r5);
        this.b.c(r4, r5);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L18:
        if (p() == true) goto L20;
    L23:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2 = r4.w(r5);
        if (r2 == null) goto L26;
        int r3 = r2.a;
    L27:
        k(r3, "dismiss by self");
        m(r4, r5, false);
        return;
    L26:
        r3 = -1;
        goto L27
    L20:
        if (f.contains(r5) == false) goto L23;
        this.d.remove(r5);
        this.c.remove(r5);
        int r6 = u3.a;
        u3.a(r5 + " dismissed directly");
        r4.F(r5, 8);
        o(r5);
        this.b.c(r4, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.c0
    public final void f(x3 r4, ExtendedToolbarButton r5) {
        Intrinsics.checkNotNullParameter(r4, "tbm");
        Intrinsics.checkNotNullParameter(r5, "buttonRemove");
        l4 r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "tbm");
        Intrinsics.checkNotNullParameter(r5, "buttonRemove");
        if (Intrinsics.areEqual(r5, ToolbarButton.FAST_GIFT.extended()) == true) goto L5;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == true) goto L19;
        return;
    L19:
        m(r4, r5, false);
        return;
    L5:
        if (r2.b() == false) goto L16;
        int r1 = r6.a;
        if (r6.a.b() == false) goto L12;
        if (l4.a(r4) == false) goto L12;
    L15:
        r0 = false;
    L12:
        if (r6.a.c() == false) goto L16;
        if (l4.a(r4) == true) goto L16;
        goto L15
    }

    public final void k(int r6, String r7) {
        String r0 = b();
        if (((LinkedHashMap) this.c).keySet().isEmpty() == false) goto L5;
        String r1 = "";
    L10:
        HashMap<String, String> r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r6, ToolbarReasonTag.MUTEX_ERROR, " " + r7 + " slot_size:" + n() + " Showings:" + r0 + "  WouldShow:" + r1);
        return;
    L5:
        StringBuilder r2 = new StringBuilder();
        Iterator r4 = ((LinkedHashMap) this.c).keySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r2.append(((ExtendedToolbarButton) r4.next()).f());
        r2.append(" ");
        goto L7
    L9:
        r1 = r2.toString();
        goto L10
    }

    public final void q(ExtendedToolbarButton r5, ToolbarSlot r6) {
        int r0 = u3.a;
        u3.a(r5.f() + " showed");
        this.d.put(r5, r6);
        c0 r7 = y3.m(this.e);
        if (r7 == null) goto L13;
        ((x3) r7).F(r5, 0);
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L14;
        com.bytedance.live.datacontext.m r9 = r8.getEnableToolbarLog();
        if (r9 != null) goto L9;
        return;
    L9:
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L16;
        com.bytedance.android.livesdk.chatroom.utils.o1 r10 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        int r1 = i(r5);
        r10.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o1.g("livesdk_toolbar_icon_show", r5, r1);
        return;
    L16:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final void m(x3 r6, ExtendedToolbarButton r7, boolean r8) {
        o(r7);
        String r0 = r7.f();
        this.d.remove(r7);
        c0 r1 = y3.m(this.e);
        if (r1 == null) goto L48;
        ((x3) r1).F(r7, 8);
        if (r8 == true) goto L45;
        this.c.remove(r7);
        int r2 = u3.a;
        u3.a(r0 + " dismissed by itself");
        this.b.c(r6, r7);
        if (r8 == false) goto L9;
        return;
    L9:
        if (l() >= n()) goto L58;
        Set r9 = ((LinkedHashMap) this.c).keySet();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L12:
        if (r11.hasNext() == false) goto L22;
        Object r3 = r11.next();
        ExtendedToolbarButton r4 = (ExtendedToolbarButton) r3;
        if (this.d.containsKey(r4) == false) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L12;
        r10.add(r3);
        goto L12
    L17:
        if (((LinkedHashMap) this.d).containsValue(((LinkedHashMap) this.c).get(r4)) == true) goto L19;
        r5 = true;
        goto L20
    L22:
        Iterator r12 = r10.iterator();
        if (r12.hasNext() == true) goto L25;
        Object r13 = null;
    L41:
        ExtendedToolbarButton r14 = (ExtendedToolbarButton) r13;
        if (r14 == null) goto L59;
        a(r6, r14);
        int r15 = u3.a;
        u3.a(r14.f() + " recovered, hide by other previously");
        return;
    L59:
        return;
    L25:
        Object r16 = r12.next();
        if (r12.hasNext() == true) goto L28;
    L27:
        r13 = r16;
        goto L41
    L28:
        h2 r17 = (h2) ((LinkedHashMap) this.a.c).get(((ExtendedToolbarButton) r16).f());
        if (r17 == null) goto L31;
        int r18 = r17.a();
    L32:
        Object r19 = r12.next();
        h2 r20 = (h2) ((LinkedHashMap) this.a.c).get(((ExtendedToolbarButton) r19).f());
        if (r20 == null) goto L35;
        int r21 = r20.a();
    L36:
        if (r18 >= r21) goto L39;
        r16 = r19;
        r18 = r21;
    L39:
        if (r12.hasNext() == true) goto L32;
    L35:
        r21 = Integer.MIN_VALUE;
        goto L36
    L31:
        r18 = Integer.MIN_VALUE;
        goto L32
    L58:
        return;
    L45:
        int r22 = u3.a;
        u3.a(r0 + " dismissed by other button");
        return;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final void r(x3 r10, ExtendedToolbarButton r11, ToolbarSlot r12) {
        l4 r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "tbm");
        Intrinsics.checkNotNullParameter(r11, "button2Show");
        ToolbarButton r3 = ToolbarButton.FAST_GIFT;
        boolean r5 = false;
        if (Intrinsics.areEqual(r11, r3.extended()) == false) goto L8;
        int r4 = r6.a;
        if (r6.a.a() == false) goto L8;
        r0.b.f(r10, r3.extended());
    L21:
        boolean r1 = false;
    L23:
        if (r1 == false) goto L38;
        l4 r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "tbm");
        Intrinsics.checkNotNullParameter(r11, "button2Show");
        if (Intrinsics.areEqual(r11, r3.extended()) == true) goto L27;
    L33:
        r5 = true;
    L34:
        if (r5 == false) goto L39;
        q(r11, r12);
        return;
    L39:
        return;
    L27:
        if (r2.b() == true) goto L33;
        Object r6 = o4.a.getValue();
        Boolean r7 = Boolean.FALSE;
        if (Intrinsics.areEqual(r6, r7) == false) goto L33;
        if (Intrinsics.areEqual(jc1.k.n(IRoomContextService.class).getRoomGiftService(null, 0).a(), r7) == false) goto L33;
        r2.b.f(r10, r3.extended());
        goto L34
    L38:
        return;
    L8:
        if (Intrinsics.areEqual(r11, r3.extended()) == true) goto L10;
    L22:
        r1 = true;
        goto L23
    L10:
        if (r0.b() == false) goto L22;
        int r8 = r6.a;
        if (r6.a.b() == false) goto L17;
        if (l4.a(r10) == true) goto L17;
        r0.b.f(r10, r3.extended());
    L17:
        if (r6.a.c() == false) goto L22;
        if (l4.a(r10) == false) goto L22;
        r0.b.f(r10, r3.extended());
        goto L21
    }

    public final void s(x3 r2, ExtendedToolbarButton r3, ToolbarSlot r4) {
        if (this.d.containsKey(r3) == true) goto L5;
    L7:
        q(r3, r4);
        l4 r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "tbm");
        Intrinsics.checkNotNullParameter(r3, "button2Show");
        if (l4.c.contains(r3) == true) goto L10;
        return;
    L10:
        if (r5.b() == false) goto L21;
        int r6 = r6.a;
        if (r6.a.a() == false) goto L14;
        return;
    L14:
        if (r6.a.c() == false) goto L17;
        r5.b.f(r2, ToolbarButton.FAST_GIFT.extended());
        return;
    L17:
        if (r6.a.b() == false) goto L24;
        r5.b.a(r2, ToolbarButton.FAST_GIFT.extended());
        return;
    L24:
        return;
    L21:
        return;
    L5:
        if (r2.y(r3) == false) goto L7;
    }
}
