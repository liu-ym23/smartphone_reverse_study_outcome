package com.bytedance.android.livesdk.clearscreen.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.config.n1;
import com.bytedance.android.livesdk.config.q1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.LiveInnerMultiTabConfig;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import gd0.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ClearScreenHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;

    public static final n1 j() {
        return (n1) b.getValue();
    }

    public static final q1 k() {
        return (q1) c.getValue();
    }

    static {
        a = LazyKt.lazy(ClearScreenHelper$multiTabContainerConfig$2.INSTANCE);
        b = LazyKt.lazy(ClearScreenHelper$csGestureConfig$2.INSTANCE);
        c = LazyKt.lazy(ClearScreenHelper$csGuideMock$2.INSTANCE);
        d = LazyKt.lazy(ClearScreenHelper$csClickDelayTime$2.INSTANCE);
        e = LazyKt.lazy(ClearScreenHelper$csClickPlayerOpt$2.INSTANCE);
        f = LazyKt.lazy(ClearScreenHelper$fixClearBeforeCompLoaded$2.INSTANCE);
        g = LazyKt.lazy(ClearScreenHelper$fixTransAnimViewGone$2.INSTANCE);
        h = LazyKt.lazy(ClearScreenHelper$enableConsumeClick$2.INSTANCE);
    }

    public static boolean b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean a() {
        if (b() == false) goto L9;
        LiveInnerMultiTabConfig.Companion r0 = LiveInnerMultiTabConfig.Companion;
        if (r0.getCleanScreenMethod() != 1) goto L7;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
    L13:
        return true;
    L12:
        if (j().a() == true) goto L13;
        return false;
    L7:
        if (r0.getCleanScreenMethod() == 3) goto L8;
    L9:
        r1 = false;
        goto L10
    }

    public static boolean c() {
        if (b() == false) goto L11;
        LiveInnerMultiTabConfig.Companion r0 = LiveInnerMultiTabConfig.Companion;
        if (r0.getCleanScreenMethod() == 1) goto L9;
        if (r0.getCleanScreenMethod() != 3) goto L11;
    L9:
        if (((MultiTabContainerConfig) a.getValue()).getEnableAlphaClear() == false) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
    L15:
        return true;
    L14:
        if (j().a() == true) goto L15;
        return false;
    L11:
        r1 = false;
        goto L12
    }

    public static boolean g() {
        if (b() == true) goto L5;
    L9:
        return false;
    L5:
        if (LiveInnerMultiTabConfig.Companion.getCleanScreenMethod() != 1) goto L9;
        if (((MultiTabContainerConfig) a.getValue()).getEnableAlphaClear() == false) goto L9;
        return true;
    }

    @JvmStatic
    public static final boolean d(DataCenter r0) {
        if (l(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (j().a() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean e(DataCenter r0) {
        if (l(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (j().h() == false) goto L7;
        return true;
    }

    public static boolean h(DataCenter r10) {
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Integer r11 = (Integer) r10.get("data_link_state", 0);
        if (wt2.a.n() != 2) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L46;
        RoomContext.a r2 = RoomContext.Companion;
        RoomContext r9 = RoomContext.a.c(r2, null, 0, 3);
        if (r9 == null) goto L16;
        m r12 = r9.getPlayerInInteractMode();
        if (r12 == null) goto L16;
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L16;
        return false;
    L16:
        RoomContext r3 = RoomContext.a.c(r2, null, 0, 3);
        if (r3 == null) goto L48;
        m r4 = r3.getCleanMode();
        if (r4 != null) goto L21;
        return false;
    L21:
        if (((Number) r4.getValue()).intValue() != ClearScreenConst.InteractType.PURE_CLEAR.getId()) goto L50;
        int r13 = r11.intValue();
        if (v.a(r13, 2) == false) goto L25;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == true) goto L51;
        return true;
    L51:
        return false;
    L25:
        if (v.a(r13, 4) == true) goto L42;
        if (v.a(r13, 8) == true) goto L42;
        if (v.a(r13, 16) == true) goto L42;
        if (v.a(r13, 32) == true) goto L42;
        if (v.a(r13, 64) == true) goto L42;
        if (v.a(r13, 128) == true) goto L42;
        if (v.a(r13, 256) == true) goto L42;
        if (v.a(r13, 512) == true) goto L42;
        r14 = false;
        goto L43
    L50:
        return false;
    L48:
        return false;
    L46:
        return false;
    L5:
        if (wt2.a.n() == 4) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean i(DataCenter r0) {
        if (l(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) f.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public static boolean l(DataCenter r3) {
        if (r3 != null) goto L5;
    L6:
        if (r3 != null) goto L8;
    L9:
        return true;
    L8:
        if (z.e(r3, false) != true) goto L9;
        return false;
    L5:
        if (z.m(r3, true) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final void m(boolean r3) {
        if (c() == false) goto L5;
        xs2.b.a().post(new ToolbarClearScreenEvent(r3, true));
        return;
    L5:
        xs2.b.a().post(new ToolbarClearScreenEvent(r3, false));
    }

    @JvmStatic
    public static final boolean f(RoomContext r3, DataCenter r4) {
        if (j().i() == true) goto L5;
        return false;
    L5:
        if (j().a() == false) goto L35;
        if (r4 != null) goto L8;
        return false;
    L8:
        if (z.e(r4, false) == false) goto L10;
        return false;
    L10:
        if (z.m(r4, true) != true) goto L38;
        if (r3 != null) goto L13;
        return false;
    L13:
        if (r3.isVSOrMedia() == true) goto L40;
        Intrinsics.checkNotNullParameter(r3, "$this$isHorizontalStream");
        m r5 = r3.getRoom();
        if (r5 == null) goto L17;
        Room r6 = (Room) r5.getValue();
    L18:
        if (r6 == null) goto L30;
        StreamUrl r7 = r6.getStreamUrl();
        if (r7 != null) goto L22;
    L24:
        StreamUrlExtra r8 = r6.getStreamUrlExtraSafely();
        if (r8.getWidth() <= r8.getHeight()) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L30;
    L29:
        boolean r10 = true;
    L31:
        if (r10 != true) goto L41;
        return true;
    L41:
        return false;
    L27:
        r9 = false;
        goto L28
    L22:
        if (r7.getStreamOrientation() != 2) goto L24;
    L30:
        r10 = false;
        goto L31
    L17:
        r6 = null;
        goto L18
    L40:
        return false;
    L38:
        return false;
    L35:
        return false;
    }
}
