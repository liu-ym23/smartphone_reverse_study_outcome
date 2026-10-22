package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSInteractionMsgClickUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(PSInteractionMsgClickUtil$clickEnable$2.INSTANCE);
        b = LazyKt.lazy(PSInteractionMsgClickUtil$needCheckRoom$2.INSTANCE);
        c = LazyKt.lazy(PSInteractionMsgClickUtil$showMobEnable$2.INSTANCE);
        d = LazyKt.lazy(PSInteractionMsgClickUtil$banClickConfig$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(l4 r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        long r1 = r5.getAction();
        if (r1 != 1) goto L8;
    L11:
        return true;
    L8:
        if (r1 == 4) goto L11;
        if (r1 == 5) goto L11;
        return false;
    }

    @JvmStatic
    public static final boolean b(h7 r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getAction() != 2) goto L8;
    L11:
        return true;
    L8:
        if (r4.getAction() == 1) goto L11;
        if (r4.getAction() == 4) goto L11;
        return false;
    }

    public static boolean c(g52.c r8) {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L6;
        return true;
    L6:
        if (r8 == null) goto L42;
        DataCenter r9 = r8.getDataCenter();
        if (r9 == null) goto L42;
        List r2 = NewToolbarButtonConstants.Companion.getMountButtonIds();
        if ((r2 instanceof Collection) == true) goto L13;
    L15:
        Iterator r3 = r2.iterator();
    L17:
        if (r3.hasNext() == false) goto L30;
        int r4 = ((Number) r3.next()).intValue();
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r9, 0, 2);
        if (r5 == null) goto L27;
        com.bytedance.live.datacontext.j r6 = r5.getCompactTbLoader();
        if (r6 == null) goto L27;
        m r7 = (m) r6.getValue();
        if (r7 == null) goto L27;
        if (r7.isComponentShowing(r4) != true) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L17;
        boolean r11 = true;
    L31:
        IRoom r13 = a0.n(r9);
        if (r13.isMergeVSRoom() == true) goto L42;
        if (r13.isMediaRoom() == true) goto L42;
        if (c1.b(r9) == true) goto L42;
        if (c1.c(r9) == true) goto L42;
        if (r11 == true) goto L42;
        return true;
    L27:
        r10 = false;
    L30:
        r11 = false;
        goto L31
    L13:
        if (r2.isEmpty() == false) goto L15;
    L42:
        return false;
    }

    @JvmStatic
    public static final boolean d(l4 r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getAction() != 3) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Context r4 = com.bytedance.android.live.core.utils.a.d();
        if (r4 != null) goto L15;
        r4 = s1.getContext();
    L15:
        if (r4 != null) goto L17;
        return false;
    L17:
        IBaseLiveActionHandler r1 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r1 == null) goto L20;
        r1.handle(r4, r3);
    L20:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @JvmStatic
    public static final void g(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "msgShowType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_show_type", r3);
        if (r4 == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_anchor", r5);
        j0.l().sendLog("livesdk_screen_system_msg_show", r0, new Object[]{x.class, IRoom.class});
        return;
    L5:
        r5 = "0";
        goto L6
    }

    @JvmStatic
    public static final void f(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "msgShowType");
        Intrinsics.checkNotNullParameter(r3, "clickArea");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("msg_show_type", r2);
        r0.put("click_area", r3);
        if (r4 == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_anchor", r5);
        j0.l().sendLog("livesdk_screen_system_msg_click", r0, new Object[]{x.class, IRoom.class});
        return;
    L5:
        r5 = "0";
        goto L6
    }
}
