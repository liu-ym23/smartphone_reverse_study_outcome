package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FullVideoButtonWidgetPaidUtil {
    public static mk1.a a;
    public static Disposable b;
    public static WeakReference<View> c;

    static {
    }

    public static void b(DataCenter r7) {
        MiddlewareRoomContext r8 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r7, 0, 2);
        if (r8 == null) goto L7;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L7;
        Room r10 = (Room) r9.getValue();
    L8:
        int r0 = 0;
        boolean r1 = true;
        if (r10 == null) goto L23;
        RoomAuthStatus r2 = r10.getRoomAuthStatus();
        if (r2 == null) goto L23;
        if (r2.landscape != 2) goto L23;
        RoomAuthStatus r3 = r10.getRoomAuthStatus();
        if (r3 == null) goto L23;
        RoomAuthStatus.RoomAuthSpecialStyle r4 = r3.roomAuthSpecialStyle;
        if (r4 == null) goto L23;
        RoomAuthStatus.Style r5 = r4.landscapeStyle;
        if (r5 == null) goto L23;
        if (r5.getUnableStyle() != 1) goto L23;
        boolean r6 = true;
    L24:
        if (r10 == null) goto L30;
        RoomAuthStatus r11 = r10.getRoomAuthStatus();
        if (r11 == null) goto L30;
        if (r11.landscape != 1) goto L30;
        r6 = true;
    L30:
        mk1.a r12 = a;
        if (r12 != null) goto L33;
    L35:
        r1 = r6;
    L36:
        WeakReference<View> r13 = c;
        if (r13 == null) goto L45;
        View r14 = r13.get();
        if (r14 == null) goto L46;
        if (r1 == true) goto L43;
        r0 = 8;
    L43:
        r14.setVisibility(r0);
        return;
    L46:
        return;
    L45:
        return;
    L33:
        if (r12.a() != true) goto L35;
    L23:
        r6 = false;
    L7:
        r10 = null;
        goto L8
    }

    public static void a(final DataCenter r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "containerView");
        c = new WeakReference(r9);
        lk1.c.i2.getClass();
        a = lk1.c.a.a(r8).getComponentStatus("room_auth_landscape");
        com.bytedance.android.livesdk.vscore_api.paidlive.c r10 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r8);
        PaidSceneEnum r1 = PaidSceneEnum.ALL;
        if (r10.l1(r1) == false) goto L15;
        com.bytedance.android.livesdk.vscore_api.paidlive.g r2 = com.bytedance.android.livesdk.vscore_api.paidlive.g.e;
        Pair[] r11 = new Pair[2];
        String r5 = "true";
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.c(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r8)) == false) goto L7;
        Object r4 = "true";
    L8:
        r11[0] = TuplesKt.to("has_buy_ticket", r4);
        mk1.a r6 = a;
        if (r6 != null) goto L11;
    L13:
        r5 = "false";
    L14:
        r11[1] = TuplesKt.to("landscape_auth", r5);
        r2.trace("paidlive_audience_room_auth_monitor", MapsKt.mutableMapOf(r11), new LinkedHashMap(), PaidSceneViewEntry.IN_ROOM.name(), r1.name());
        goto L15
    L11:
        if (r6.a() != true) goto L13;
    L7:
        r4 = "false";
    L15:
        com.bytedance.android.live.core.arch.mvvm.d r12 = lk1.c.a.a(r8).observeStatusChanged("room_auth_landscape");
        if (r12 == null) goto L18;
        Disposable r13 = RxUtilKt.n(r12, new FullVideoButtonWidgetPaidUtil$observeRoomAuth$1(r8));
    L19:
        b = r13;
        b(r8);
        return;
    L18:
        r13 = null;
        goto L19
    }
}
