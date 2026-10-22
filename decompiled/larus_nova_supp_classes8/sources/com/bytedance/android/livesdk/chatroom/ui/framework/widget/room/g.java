package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.ui.d7;
import com.bytedance.android.livesdk.chatroom.ui.e7;
import com.bytedance.android.livesdk.chatroom.ui.f7;
import com.bytedance.android.livesdk.chatroom.utils.o4;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements kf1.a {
    public final /* synthetic */ RoomCloseInterceptorWidget a;

    public final String tag() {
        return "AddDesktopInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public g(RoomCloseInterceptorWidget r1) {
        this.a = r1;
    }

    public final boolean qa(final Runnable r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "afterInterceptRunnable");
        if (r12 == false) goto L5;
        return false;
    L5:
        RoomCloseInterceptorWidget r13 = this.a;
        boolean r1 = RoomCloseInterceptorWidget.g;
        r13.getClass();
        o4.a = false;
        if (r13.g1() == false) goto L21;
        Room r14 = r13.getRoom();
        if (RoomCloseInterceptorWidget.g == true) goto L21;
        if (r14 == null) goto L21;
        if (e7.a(r14) == false) goto L21;
        IHostBusiness r3 = jc1.k.f(IHostBusiness.class);
        if (r3 == null) goto L17;
        r3.addUgDesktopListener("live_follow_desktop", "follow_leave_living_room", RoomCloseInterceptorWidget$showLiveFollowDesktopDialog$1.INSTANCE, new RoomCloseInterceptorWidget$showLiveFollowDesktopDialog$2(r11), new RoomCloseInterceptorWidget$showLiveFollowDesktopDialog$3(r11));
    L17:
        IHostBusiness r4 = jc1.k.f(IHostBusiness.class);
        if (r4 == null) goto L20;
        r4.showUgLeaveDialog("live_follow_desktop", "follow_leave_living_room", "media_retain_popup", "normal", "1", r14.getOwnerUserIdString());
    L20:
        boolean r15 = true;
    L22:
        if (r15 == true) goto L59;
        RoomCloseInterceptorWidget r16 = this.a;
        r16.getClass();
        o4.a = false;
        if (r16.g1() == false) goto L39;
        Room r17 = r16.getRoom();
        if (RoomCloseInterceptorWidget.g == true) goto L39;
        if (r17 == null) goto L39;
        if (f7.a(r17) == false) goto L39;
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        if (r5 == null) goto L35;
        r5.addUgDesktopListener("ecom_desktop_icon", "ecom_live_room", RoomCloseInterceptorWidget$showLiveEcomDdesktopDialog$1.INSTANCE, new RoomCloseInterceptorWidget$showLiveEcomDdesktopDialog$2(r11), new RoomCloseInterceptorWidget$showLiveEcomDdesktopDialog$3(r11));
    L35:
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        if (r6 == null) goto L38;
        r6.showUgLeaveDialog("ecom_desktop_icon", "ecom_live_room", "retain_popup", "normal", "1", r17.getOwnerUserIdString());
    L38:
        boolean r18 = true;
    L40:
        if (r18 == true) goto L59;
        RoomCloseInterceptorWidget r19 = this.a;
        if (r19.g1() == false) goto L57;
        Room r110 = r19.getRoom();
        if (RoomCloseInterceptorWidget.g == true) goto L57;
        if (r110 == null) goto L57;
        Map<Long, Long> r2 = d7.a;
        if (d7.a(r110.getRoomId()) == false) goto L57;
        IHostBusiness r7 = jc1.k.f(IHostBusiness.class);
        if (r7 == null) goto L53;
        r7.addUgDesktopListener("live_desktop_business", "leave_live_room", RoomCloseInterceptorWidget$showLiveAddDesktopDialog$1.INSTANCE, new RoomCloseInterceptorWidget$showLiveAddDesktopDialog$2(r11), new RoomCloseInterceptorWidget$showLiveAddDesktopDialog$3(r11));
    L53:
        IHostBusiness r8 = jc1.k.f(IHostBusiness.class);
        if (r8 == null) goto L56;
        r8.showUgLeaveDialog("live_desktop_business", "leave_live_room", "retain_popup", "normal", "1", r110.getOwnerUserIdString());
    L56:
        boolean r111 = true;
    L58:
        if (r111 == true) goto L59;
        return false;
    L57:
        r111 = false;
    L39:
        r18 = false;
    L59:
        return true;
    L21:
        r15 = false;
        goto L22
    }
}
