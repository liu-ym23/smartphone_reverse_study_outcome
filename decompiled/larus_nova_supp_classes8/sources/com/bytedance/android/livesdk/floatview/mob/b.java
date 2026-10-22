package com.bytedance.android.livesdk.floatview.mob;

import am2.p;
import am2.r;
import am2.x;
import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.gu0;
import com.bytedance.android.livesdk.config.o81;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdkapi.depend.model.live.LinkMicBattleSetting;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import gd0.v;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int o = 0;
    public long a;
    public long b;
    public long c;
    public long d;
    public final String e;
    public final String f;
    public AbsLiveBizWindowLogAbility g;
    public final String h;
    public boolean i;
    public String j;
    public String k;
    public final o81 l;
    public HashMap<String, String> m;
    public String n;

    public static final class a {
        @JvmStatic
        public static boolean a(Room r6) {
            if (r6 == null) goto L12;
            long r0 = r6.id;
            RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r7 == null) goto L11;
            m r8 = r7.getRoom();
            if (r8 == null) goto L11;
            Room r9 = (Room) r8.getValue();
            if (r9 == null) goto L11;
            if (r0 == r9.getRoomId()) goto L12;
        L11:
            return true;
        L12:
            return false;
        }
    }

    static {
    }

    public final void n() {
        if (this.c != (-1)) goto L5;
        return;
    L5:
        this.d += SystemClock.elapsedRealtime() - this.c;
    }

    public final void m() {
        g r0 = u.l();
        x r2 = new x();
        r2.a = "live_view";
        r2.b = "live_detail";
        r2.f = "click";
        r0.sendLog("livesdk_mini_window_move", null, new Object[]{r2, new r(this.e, this.f, this.h, this.i), Room.class});
    }

    public static void d(HashMap r3) {
        int r0 = k.n(IInteractService.class).getLinkMode();
        if (v.a(r0, 8) == false) goto L5;
    L6:
        boolean r2 = false;
        if (k.n(IInteractService.class).getVideoTalkService().u(false, k.n(IUserService.class).user().n()) == false) goto L9;
    L10:
        r2 = true;
    L12:
        if (r2 == false) goto L14;
        r3.put("user_type", "connection_user");
        return;
    L14:
        r3.put("user_type", "live_user");
        return;
    L9:
        if (k.n(IInteractService.class).getAudioTalkService().B(k.n(IUserService.class).user().n()) == false) goto L12;
    L5:
        if (v.a(r0, 32) == true) goto L6;
    }

    public static void a(HashMap r1, HashMap r2) {
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("enter_from");
        if (r3 == null) goto L8;
        String r4 = (String) r1.put("enter_from", r3);
        return;
    L8:
        return;
    }

    public static void b(HashMap r2, HashMap r3) {
        if (r3 == null) goto L5;
        String r4 = (String) r3.get("is_life");
    L7:
        if ("1".equals(r4) == false) goto L10;
        r2.put("is_life", "1");
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void c(HashMap r2, boolean r3) {
        AbsLiveBizWindowLogAbility r0 = this.g;
        if (r0 == null) goto L8;
        Map r4 = r0.getBizExtra(r3);
        if (r4 == null) goto L9;
        r2.putAll(r4);
        return;
    L9:
        return;
    }

    public final void f(Room r9, InnerContextEntity r10) {
        if (this.a != (-1)) goto L5;
        return;
    L5:
        long r0 = (SystemClock.elapsedRealtime() - this.a) - this.d;
        this.a = -1;
        if (a.a(r9) == false) goto L9;
        e("mini_window_live_duration", r10, r9, new p(r0));
        return;
    L9:
        HashMap r2 = new HashMap();
        d(r2);
        HashMap r4 = null;
        if (r10 == null) goto L12;
        HashMap r5 = r10.getMobParams();
    L13:
        b(r2, r5);
        if (r10 == null) goto L16;
        r4 = r10.getMobParams();
    L16:
        a(r2, r4);
        i4.a(r2);
        i4.b(r2);
        if (this.j.length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L22;
        r2.put("business_line", this.j);
    L22:
        o(this.n, r9, r2);
        c(r2, true);
        g r12 = u.l();
        x r6 = new x();
        r6.a = "live_view";
        r6.b = "live_detail";
        r12.sendLog("mini_window_live_duration", r2, new Object[]{r6, new p(r0), new r(this.e, this.f, this.h, this.i), Room.class});
        return;
    L19:
        r11 = false;
        goto L20
    L12:
        r5 = null;
        goto L13
    }

    public final void g(Room r9, InnerContextEntity r10) {
        HashMap r2 = null;
        if (a.a(r9) == false) goto L6;
        e("mini_window_finish_show", r10, r9, null);
        return;
    L6:
        HashMap r0 = new HashMap();
        if (r10 == null) goto L9;
        HashMap r3 = r10.getMobParams();
    L10:
        b(r0, r3);
        if (r10 == null) goto L13;
        r2 = r10.getMobParams();
    L13:
        a(r0, r2);
        if (this.j.length() <= 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L19;
        r0.put("business_line", this.j);
    L19:
        o(this.n, r9, r0);
        c(r0, true);
        g r12 = u.l();
        x r4 = new x();
        r4.a = "live_view";
        r4.b = "live_detail";
        r12.sendLog("mini_window_finish_show", r0, new Object[]{r4, new r(this.e, this.f, this.h, this.i), Room.class});
        return;
    L16:
        r11 = false;
        goto L17
    L9:
        r3 = null;
        goto L10
    }

    public final void h(InnerContextEntity r8, Room r9) {
        if (this.b != (-1)) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.b;
        this.b = -1;
        if (a.a(r9) == false) goto L9;
        e("mini_window_silent_live_duration", r8, r9, new p(r0));
        return;
    L9:
        g r10 = u.l();
        HashMap r11 = new HashMap();
        d(r11);
        i4.a(r11);
        i4.b(r11);
        c(r11, true);
        Unit r4 = Unit.INSTANCE;
        x r5 = new x();
        r5.a = "live_view";
        r5.b = "live_detail";
        r10.sendLog("mini_window_silent_live_duration", r11, new Object[]{r5, new p(r0), new r(this.e, this.f, this.h, this.i), Room.class});
    }

    public final void i(InnerContextEntity r9, Room r10) {
        if (a.a(r10) == false) goto L6;
        e("mini_window_silent", r9, r10, null);
        return;
    L6:
        g r11 = u.l();
        HashMap r12 = new HashMap();
        d(r12);
        i4.a(r12);
        i4.b(r12);
        c(r12, true);
        Unit r2 = Unit.INSTANCE;
        x r3 = new x();
        r3.a = "live_view";
        r3.b = "live_detail";
        r11.sendLog("mini_window_silent", r12, new Object[]{r3, new r(this.e, this.f, this.h, this.i), Room.class});
    }

    public final void k(Room r9, InnerContextEntity r10) {
        if (a.a(r9) == false) goto L6;
        e("mini_window_return_full", r10, r9, new r(this.e, this.f, this.h, this.i));
        return;
    L6:
        HashMap r0 = new HashMap();
        d(r0);
        HashMap r2 = null;
        if (r10 == null) goto L9;
        HashMap r3 = r10.getMobParams();
    L10:
        b(r0, r3);
        if (r10 == null) goto L13;
        r2 = r10.getMobParams();
    L13:
        a(r0, r2);
        i4.a(r0);
        i4.b(r0);
        if (r10 == null) goto L19;
        HashMap r11 = r10.getMobParams();
        if (r11 == null) goto L19;
        r0.putAll(r11);
    L19:
        if (this.j.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == false) goto L24;
        r0.put("business_line", this.j);
    L24:
        o(this.n, r9, r0);
        c(r0, true);
        g r13 = u.l();
        x r4 = new x();
        r4.a = "live_view";
        r4.b = "live_detail";
        r13.sendLog("mini_window_return_full", r0, new Object[]{r4, new r(this.e, this.f, this.h, this.i), Room.class});
        return;
    L21:
        r12 = false;
        goto L22
    L9:
        r3 = null;
        goto L10
    }

    public static void o(String r5, Room r6, Map r7) {
        if (r6 == null) goto L32;
        Map r1 = r6.getLinkMap();
        if (r1 == null) goto L35;
        boolean r3 = true;
        if (r1.containsKey("1") == false) goto L11;
        ((HashMap) r7).put("anchor_connect_status", "2");
        p(1, r6, r7);
        return;
    L11:
        if (r1.containsKey("7") == false) goto L34;
        if (r5 != null) goto L30;
    L17:
        if (r3 == true) goto L27;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L25
        JSONObject r8 = LiveSeiUtil.c(r5);     // Catch: JSONException -> L25
        if (r8.has("app_data") == false) goto L27;
        String r9 = JSONObjectProtectorUtils.getString(r8, "app_data");     // Catch: JSONException -> L25
        JSONObject r0 = new JSONObject(new Regex("\\\\").replace(r9, ""));     // Catch: JSONException -> L25
        if (r0.has("ver") == true) goto L23;
        return;
    L23:
        int r10 = new JSONArray(r0.optString("grids")).length();     // Catch: JSONException -> L25
    L28:
        HashMap r2 = (HashMap) r7;
        r2.put("anchor_connect_status", String.valueOf(r10));
        p(7, r6, r7);
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
    L27:
        r10 = -1;
        goto L28
    L30:
        if (StringsKt.isBlank(r5) == true) goto L17;
        r3 = false;
        goto L17
    L34:
        return;
    L35:
        return;
    }

    public static void p(int r8, Room r9, Map r10) {
        if (r8 != 1) goto L19;
        HashMap r11 = (HashMap) r10;
        r11.put("room_link_status", "individual_pvp");
        RoomLinkInfo r12 = r9.getLinkMicInfo();
        if (r12 == null) goto L11;
        LinkMicBattleSetting r13 = r12.battleSetting;
        if (r13 == null) goto L11;
        if (r13.finished != 1) goto L11;
        r11.put("room_link_status", "connection");
    L11:
        z5 r14 = r9.getLinkerDetail();
        if (r14 == null) goto L35;
        List r15 = r14.getPlayModes();
        if (r15 != null) goto L16;
        return;
    L16:
        if (r15.contains(30L) != true) goto L37;
        r11.put("room_link_status", "pve");
        return;
    L37:
        return;
    L35:
        return;
    L19:
        if (r8 != 7) goto L39;
        HashMap r16 = (HashMap) r10;
        r16.put("room_link_status", "connection");
        z5 r17 = r9.getLinkerDetail();
        if (r17 == null) goto L27;
        List r18 = r17.getPlayModes();
        if (r18 == null) goto L27;
        if (r18.contains(15L) != true) goto L27;
        r16.put("room_link_status", "team_pvp");
        return;
    L27:
        z5 r19 = r9.getLinkerDetail();
        if (r19 == null) goto L41;
        List r20 = r19.getPlayModes();
        if (r20 != null) goto L32;
        return;
    L32:
        if (r20.contains(3L) != true) goto L43;
        r16.put("room_link_status", "individual_pvp");
        return;
    L43:
        return;
    L41:
        return;
    }

    public final void j(boolean r8, Room r9, InnerContextEntity r10) {
        this.i = r8;
        HashMap r1 = null;
        if (a.a(r9) == false) goto L6;
        e("mini_window_live_play", r10, r9, null);
        return;
    L6:
        HashMap r11 = new HashMap();
        d(r11);
        if (r10 == null) goto L9;
        HashMap r2 = r10.getMobParams();
    L10:
        b(r11, r2);
        if (r10 == null) goto L13;
        r1 = r10.getMobParams();
    L13:
        a(r11, r1);
        r11.put("duration", String.valueOf(SystemClock.elapsedRealtime() - this.a));
        r11.put("is_link_reserve", "0");
        i4.a(r11);
        i4.b(r11);
        if (this.j.length() <= 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
        r11.put("business_line", this.j);
    L19:
        o(this.n, r9, r11);
        c(r11, true);
        g r13 = u.l();
        x r3 = new x();
        r3.a = "live_view";
        r3.b = "live_detail";
        r13.sendLog("mini_window_live_play", r11, new Object[]{r3, new r(this.e, this.f, this.h, this.i), Room.class});
        return;
    L16:
        r12 = false;
        goto L17
    L9:
        r2 = null;
        goto L10
    }

    public b(int r3, String r4, String r5, HashMap<String, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "initialPage");
        Intrinsics.checkNotNullParameter(r5, "triggerScene");
        this.a = -1;
        this.b = -1;
        this.c = -1;
        String r0 = "out";
        this.e = "out";
        this.h = "";
        this.j = "";
        this.k = "";
        this.l = gu0.a.getValue();
        if (r3 != 1) goto L5;
        r0 = "in";
    L5:
        this.e = r0;
        this.m = r6;
        this.h = r5;
        this.f = r4;
    }

    public final void e(String r12, InnerContextEntity r13, Room r14, Object r15) {
        g r0 = u.l();
        HashMap r1 = new HashMap();
        if (this.l.a() == false) goto L36;
        LiveMultiTabFloatWindowStore r2 = LiveMultiTabFloatWindowStore.INSTANCE;
        String r6 = r2.getEnterFromMerge();
        String r3 = r6 + '-' + r2.getEnterMethod();
        Map<String, String> r7 = this.l.b();
        if (this.l.a() == false) goto L29;
        if (r7 == null) goto L29;
        if ((!r7.isEmpty()) != true) goto L29;
        boolean r4 = r7.containsKey(r3);
        Set<String> r8 = r7.keySet();
        if ((r8 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L25;
        String r10 = (String) r9.next();
        if (StringsKt.endsWith$default(r10, "-*", false, 2, null) == true) goto L20;
    L22:
        boolean r11 = false;
    L23:
        if (r11 == false) goto L16;
        boolean r16 = true;
    L26:
        if (r4 == true) goto L28;
        if (r16 == false) goto L29;
    L28:
        boolean r5 = true;
    L30:
        if (r5 == false) goto L34;
        LiveMultiTabFloatWindowStore r17 = LiveMultiTabFloatWindowStore.INSTANCE;
        if (r17.isTabChange() == true) goto L34;
        this.k = r17.getEnterFromMerge();
    L35:
        r1.put("target_tab_id", String.valueOf(this.k));
    L34:
        this.k = "";
        goto L35
    L20:
        if (Intrinsics.areEqual(r6, r10.substring(0, r10.length() - 2)) == false) goto L22;
        r11 = true;
    L25:
        r16 = false;
        goto L26
    L12:
        if (r8.isEmpty() == false) goto L14;
    L29:
        r5 = false;
    L36:
        i4.a(r1);
        r1.put("enter_from_merge", "order_center");
        r1.put("action_type", "click");
        c(r1, false);
        if (r13 == null) goto L42;
        HashMap r18 = r13.getMobParams();
        if (r18 == null) goto L42;
        r1.putAll(r18);
    L42:
        if (this.j.length() <= 0) goto L44;
        boolean r19 = true;
    L45:
        if (r19 == false) goto L47;
        r1.put("business_line", this.j);
    L47:
        if (r14 != null) goto L49;
    L74:
        HashMap<String, String> r110 = this.m;
        if (r110 == null) goto L77;
        r1.putAll(r110);
    L77:
        o(this.n, r14, r1);
        Unit r111 = Unit.INSTANCE;
        r0.sendLog(r12, r1, new Object[]{new r(this.e, this.f, this.h, this.i), r14, r15});
        return;
    L49:
        if (r14.isMergeVSRoom() != true) goto L74;
        LiveVSLog.r.getClass();
        r1.putAll(LiveVSLog.b.a(r14).a());
        if (r13 == null) goto L58;
        WeakReference r20 = r13.getActivityRef();
        if (r20 == null) goto L58;
        Activity r21 = (Activity) r20.get();
        if (r21 == null) goto L58;
        if (r21.getRequestedOrientation() != 0) goto L58;
    L65:
        String r112 = "landscape";
    L67:
        r1.put("vs_screen_type", r112);
        PaidLiveData r113 = r14.getPaidLiveData();
        if (r113 != null) goto L70;
    L72:
        String r114 = "0";
    L73:
        r1.put("is_paidlive", r114);
        goto L74
    L70:
        if (r113.paidType != 1) goto L72;
        r114 = "1";
    L58:
        if (r13 == null) goto L66;
        WeakReference r115 = r13.getActivityRef();
        if (r115 == null) goto L66;
        Activity r116 = (Activity) r115.get();
        if (r116 == null) goto L66;
        if (r116.getRequestedOrientation() == 6) goto L65;
    L66:
        r112 = "portrait";
        goto L67
    L44:
        r19 = false;
        goto L45
    }

    public final void l(boolean r7, boolean r8, Room r9, InnerContextEntity r10) {
        HashMap r0 = new HashMap();
        if (Intrinsics.areEqual(this.e, "out") == false) goto L6;
        r0.put("is_auto_close", m2.b(r7));
        r0.put("is_destroy_cause", m2.b(r8));
    L6:
        if (a.a(r9) == false) goto L9;
        e("livesdk_mini_window_close", r10, r9, r0);
        return;
    L9:
        HashMap r11 = null;
        if (r10 == null) goto L12;
        HashMap r1 = r10.getMobParams();
    L13:
        b(r0, r1);
        if (r10 == null) goto L16;
        r11 = r10.getMobParams();
    L16:
        a(r0, r11);
        d(r0);
        i4.a(r0);
        i4.b(r0);
        if (this.j.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L22;
        r0.put("business_line", this.j);
    L22:
        o(this.n, r9, r0);
        c(r0, true);
        g r13 = u.l();
        x r2 = new x();
        r2.a = "live_view";
        r2.b = "live_detail";
        r2.f = "click";
        r13.sendLog("livesdk_mini_window_close", r0, new Object[]{r2, new r(this.e, this.f, this.h, this.i), Room.class});
        return;
    L19:
        r12 = false;
        goto L20
    L12:
        r1 = null;
        goto L13
    }
}
