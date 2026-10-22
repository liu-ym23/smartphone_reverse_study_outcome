package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k4 implements kf1.a {
    public final /* synthetic */ AbsInteractionFragment a;

    public final String tag() {
        return "AbsInteractionFragment_AddDesktop";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public k4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r11, boolean r12) {
        if (r12 == false) goto L5;
        return false;
    L5:
        AbsInteractionFragment r13 = this.a;
        List<String> r1 = AbsInteractionFragment.u4;
        r13.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o4.a = false;
        if (r13.g1() == true) goto L9;
    L16:
        boolean r14 = false;
    L17:
        if (r14 == true) goto L44;
        AbsInteractionFragment r15 = this.a;
        r15.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o4.a = false;
        if (r15.g1() == true) goto L22;
    L29:
        boolean r16 = false;
    L30:
        if (r16 == true) goto L44;
        AbsInteractionFragment r17 = this.a;
        if (r17.g1() == true) goto L35;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == true) goto L44;
        return false;
    L35:
        if (AbsInteractionFragment.v4 == true) goto L42;
        Room r2 = r17.q;
        if (r2 == null) goto L42;
        Map<Long, Long> r3 = d7.a;
        if (d7.a(r2.getRoomId()) == false) goto L42;
        jc1.k.f(IHostBusiness.class).addUgDesktopListener("live_desktop_business", "leave_live_room", new e4(), new f4(r11), new g4(r11));
        jc1.k.f(IHostBusiness.class).showUgLeaveDialog("live_desktop_business", "leave_live_room", "retain_popup", "normal", "1", r17.q.getOwnerUserIdString());
        r18 = true;
        goto L43
    L22:
        if (AbsInteractionFragment.v4 == true) goto L29;
        Room r4 = r15.q;
        if (r4 == null) goto L29;
        if (f7.a(r4) == false) goto L29;
        jc1.k.f(IHostBusiness.class).addUgDesktopListener("ecom_desktop_icon", "ecom_live_room", new b4(), new c4(r11), new d4(r11));
        jc1.k.f(IHostBusiness.class).showUgLeaveDialog("ecom_desktop_icon", "ecom_live_room", "retain_popup", "normal", "1", r15.q.getOwnerUserIdString());
        r16 = true;
    L44:
        return true;
    L9:
        if (AbsInteractionFragment.v4 == true) goto L16;
        Room r5 = r13.q;
        if (r5 == null) goto L16;
        if (e7.a(r5) == false) goto L16;
        jc1.k.f(IHostBusiness.class).addUgDesktopListener("live_follow_desktop", "follow_leave_living_room", new h4(), new i4(r11), new j4(r11));
        jc1.k.f(IHostBusiness.class).showUgLeaveDialog("live_follow_desktop", "follow_leave_living_room", "media_retain_popup", "normal", "1", r13.q.getOwnerUserIdString());
        r14 = true;
        goto L17
    }
}
