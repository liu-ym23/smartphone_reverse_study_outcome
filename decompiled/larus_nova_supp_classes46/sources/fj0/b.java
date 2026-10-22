package fj0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.livesdk.chatroom.model.interact.b1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final a a = null;
    public static final b b = null;

    public b() {
    }

    static {
        b = new b();
        a = new a();
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("to_user_id", r4);
        TalkRoomLogUtils.B0(r0, Integer.valueOf(je0.d.f()), null, 4);
        j0.l().sendLog("livesdk_anchor_audience_connection_add_time_click", r0, new Object[]{IRoom.class});
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("to_user_id", r4.toString());
        TalkRoomLogUtils.B0(r0, Integer.valueOf(je0.d.f()), null, 4);
        j0.l().sendLog("livesdk_anchor_audience_connection_add_time_show", r0, new Object[]{IRoom.class});
    }

    public static /* synthetic */ void d(b r1) {
        int r0 = je0.d.f();
        r1.getClass();
        c(r0, null);
    }

    public static void e(String r6) {
        a r0 = a;
        if (r0.c == false) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        List r2 = null;
        TalkRoomLogUtils.B0(r1, null, null, 6);
        j r3 = m.d().getVideoTalkRoomSubScene();
        if (r3 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
        if (r5 == null) goto L12;
        r2 = r5.b;
    L12:
        if (r2 != null) goto L14;
        r1.put("seat_fit_status", "off");
    L15:
        r1.put("play_mode", u0.k(11));
        if (r6 == null) goto L18;
        r1.put("function_type2", r6);
    L18:
        i0 r7 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r1);
        zi0.d.b(r1, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r1, new Object[]{IRoom.class});
        r0.c = true;
        r0.d = System.currentTimeMillis();
        return;
    L14:
        TalkRoomLogUtils.V0(r1);
        goto L15
    }

    public static /* synthetic */ void g(b r1) {
        int r0 = je0.d.f();
        r1.getClass();
        f(r0, null);
    }

    public static String i(List r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r1 = new StringBuilder();
        Iterator r7 = r6.iterator();
    L6:
        boolean r3 = false;
        boolean r4 = true;
        if (r7.hasNext() == false) goto L16;
        j1 r2 = (j1) r7.next();
        String r5 = r2.getName();
        if (r5 != null) goto L11;
    L12:
        r3 = true;
    L13:
        if (r3 == true) goto L6;
        r1.append(r2.getName());
        r1.append(",");
        goto L6
    L11:
        if (r5.length() != 0) goto L13;
    L16:
        if (r1.length() > 0) goto L19;
        r4 = false;
    L19:
        if (r4 == true) goto L21;
        return "";
    L21:
        return r1.substring(0, StringsKt.getLastIndex(r1)).toString();
    }

    public static void c(int r6, Integer r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r6), r7);
        j r8 = m.d().getVideoTalkRoomSubScene();
        IRoom r1 = null;
        if (r8 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r8.getValue();
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r10 = r9.t();
        if (r10 == null) goto L9;
        List r11 = r10.b;
    L10:
        String r2 = "off";
        if (r11 != null) goto L13;
        r0.put("seat_fit_status", "off");
    L14:
        r0.put("play_mode", u0.k(11));
        a r12 = a;
        r0.put("source", r12.a);
        r0.put("money", String.valueOf(a.a()));
        r0.put("time", String.valueOf(a.b()));
        if (r7 == null) goto L21;
        r7.intValue();
        String r13 = u0.j(r7);
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        r0.put("layout_type", r13);
    L21:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.c1.getValue()).booleanValue() == false) goto L23;
        Object r14 = "on";
    L24:
        r0.put("rechargeable_card_status", r14);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.f1.getValue()).booleanValue() == false) goto L27;
        r2 = "on";
    L27:
        r0.put("rechargeable_intro_status", r2);
        long r4 = 0;
        if ((System.currentTimeMillis() - r12.e) <= 0) goto L30;
        r0.put("duration", String.valueOf((System.currentTimeMillis() - r12.e) / ((long) 1000)));
    L30:
        b1 r15 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        r0.put("rechargeable_label", i(r15.getSavedTagInfos()));
        r0.put("rechargeable_intro", r15.getSavedDesc());
        if (o.d() != 29) goto L33;
        String r16 = "open";
    L34:
        r0.put("open_link_source", r16);
        com.bytedance.live.datacontext.m r17 = m.i().getRoom();
        if (r17 == null) goto L38;
        r1 = (IRoom) r17.getValue();
    L38:
        if (e.g(r1) == true) goto L40;
    L45:
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_over", r0, new Object[]{IRoom.class});
        return;
    L40:
        if (c.a() == false) goto L44;
        cj0.c r18 = PaidLinkMicContext.Companion.a();
        if (r18 == null) goto L44;
        r4 = r18.getIncreasePrice();
    L44:
        r0.put("premium_price", String.valueOf(r4));
        goto L45
    L33:
        r16 = "close";
        goto L34
    L23:
        r14 = "off";
        goto L24
    L13:
        TalkRoomLogUtils.V0(r0);
    L9:
        r11 = null;
        goto L10
    }

    public static void f(int r8, Integer r9) {
        a r0 = a;
        if (r0.c == true) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.A0(r1, Integer.valueOf(r8), r9);
        j r10 = m.d().getVideoTalkRoomSubScene();
        if (r10 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r10.getValue();
        if (r11 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r11.t();
        if (r12 == null) goto L12;
        List r13 = r12.b;
    L13:
        if (r13 != null) goto L15;
        r1.put("seat_fit_status", "off");
    L16:
        r1.put("play_mode", u0.k(11));
        if ((System.currentTimeMillis() - r0.d) <= 0) goto L19;
        r1.put("duration", String.valueOf((System.currentTimeMillis() - r0.d) / 1000));
    L19:
        if (r9 == null) goto L24;
        r9.intValue();
        String r14 = u0.j(r9);
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        r1.put("layout_type", r14);
    L24:
        zi0.d.b(r1, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r1, new Object[]{IRoom.class});
        r0.c = false;
        r0.d = 0;
        return;
    L15:
        TalkRoomLogUtils.V0(r1);
    L12:
        r13 = null;
        goto L13
    }

    public static void h(b r6, String r7, String r8, int r9) {
        IRoom r1 = null;
        if ((r9 & 1) == 0) goto L5;
        r7 = null;
    L5:
        String r0 = "open";
        if ((r9 & 4) == 0) goto L8;
        r8 = "open";
    L8:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "openType");
        LinkedHashMap r10 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r10, null, null, 6);
        TalkRoomLogUtils.V0(r10);
        a r11 = a;
        r11.getClass();
        if (e.l() == true) goto L21;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L21;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == true) goto L21;
        String r4 = "";
    L22:
        r10.put("play_mode", r4);
        if (r7 != null) goto L25;
        String r5 = r11.a;
    L26:
        r10.put("source", r5);
        r10.put("money", String.valueOf(a.a()));
        r10.put("time", String.valueOf(a.b()));
        r10.put("rechargeable_open_type", r8);
        String r12 = "on";
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.c1.getValue()).booleanValue() == false) goto L29;
        Object r13 = "on";
    L30:
        r10.put("rechargeable_card_status", r13);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.f1.getValue()).booleanValue() == true) goto L34;
        r12 = "off";
    L34:
        r10.put("rechargeable_intro_status", r12);
        b1 r14 = (b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        r10.put("rechargeable_label", i(r14.getSavedTagInfos()));
        r10.put("rechargeable_intro", r14.getSavedDesc());
        if (o.d() == 29) goto L38;
        r0 = "close";
    L38:
        r10.put("open_link_source", r0);
        com.bytedance.live.datacontext.m r15 = m.i().getRoom();
        if (r15 == null) goto L42;
        r1 = (IRoom) r15.getValue();
    L42:
        if (e.g(r1) == true) goto L44;
    L50:
        Map<Integer, String> r16 = TalkRoomLogUtils.g;
        if (r7 != null) goto L53;
        r7 = r11.a;
    L53:
        r16.put(11, r7);
        zi0.d.b(r10, false);
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r10, new Object[]{IRoom.class});
        return;
    L44:
        if (c.a() == false) goto L48;
        cj0.c r17 = PaidLinkMicContext.Companion.a();
        if (r17 == null) goto L48;
        long r18 = r17.getIncreasePrice();
    L49:
        r10.put("premium_price", String.valueOf(r18));
    L48:
        r18 = 0;
        goto L49
    L29:
        r13 = "off";
        goto L30
    L25:
        r5 = r7;
        goto L26
    L13:
        if (r2.getInteractAudienceService() == null) goto L15;
        r3 = com.bytedance.android.live.liveinteract.api.data.a.a().c;
    L21:
        r4 = "rechargeable_normal";
        goto L22
    }
}
