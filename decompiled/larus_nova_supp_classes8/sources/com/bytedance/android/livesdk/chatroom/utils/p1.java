package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p1 {
    static {
    }

    @JvmStatic
    public static final void a(DataCenter r10) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r10, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getCompactTbLoader();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r2 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r1.getValue();
    L9:
        if ((r2 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L36;
        List<Integer> r3 = r2.getAllShowedDataListIds();
        if (r3 == null) goto L45;
        Iterator<T> r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L46;
        int r5 = ((Number) r4.next()).intValue();
        o1 r6 = o1.d();
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r10, 0, 2);
        if (r7 == null) goto L34;
        com.bytedance.live.datacontext.n r8 = r7.getCurToolbarList();
        if (r8 == null) goto L34;
        List r9 = (List) r8.getValue();
        if (r9 == null) goto L34;
        Iterator r11 = r9.iterator();
    L25:
        if (r11.hasNext() == false) goto L32;
        Object r12 = r11.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r12).a != r5) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == false) goto L25;
    L33:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r14 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r12;
    L35:
        r6.getClass();
        o1.f(r10, "livesdk_toolbar_icon_show", r5, r14);
        goto L16
    L29:
        r13 = false;
        goto L30
    L32:
        r12 = null;
    L34:
        r14 = null;
        goto L35
    L46:
        return;
    L45:
        return;
    L36:
        return;
    L7:
        r2 = null;
        goto L9
    }
}
