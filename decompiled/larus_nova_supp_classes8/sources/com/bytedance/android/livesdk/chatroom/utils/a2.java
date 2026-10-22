package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.fx0;
import com.bytedance.android.livesdk.config.l8;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a2 {
    public static WeakReference<DataCenter> a;
    public static int b;
    public static int c;
    public static JSONObject d;

    public static final boolean j(int r1) {
        if (r1 != 11) goto L5;
    L22:
        return true;
    L5:
        if (r1 == 9) goto L22;
        if (r1 == 13) goto L22;
        if (r1 == 16) goto L22;
        if (r1 == 17) goto L22;
        if (r1 == 31) goto L22;
        if (r1 == 32) goto L22;
        if (r1 == 33) goto L22;
        if (r1 == 39) goto L22;
        return false;
    }

    public static final boolean p(int r1) {
        if (r1 != 8) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 10) goto L12;
        if (r1 == 12) goto L12;
        if (r1 == 15) goto L12;
        return false;
    }

    static {
        d = new JSONObject();
    }

    public static final int f() {
        WeakReference<DataCenter> r0 = a;
        if (r0 == null) goto L8;
        DataCenter r1 = r0.get();
        if (r1 == null) goto L8;
        Integer r2 = (Integer) r1.get("feed_live_enter_ui_layout");
        if (r2 == null) goto L8;
    L9:
        if (r2 != null) goto L12;
    L13:
        WeakReference<DataCenter> r3 = a;
        if (r3 == null) goto L23;
        DataCenter r4 = r3.get();
        if (r4 == null) goto L24;
        Integer r5 = (Integer) r4.get("feed_live_enter_ui_layout");
        if (r5 != null) goto L20;
        return 0;
    L20:
        return r5.intValue();
    L24:
        return 0;
    L23:
        return 0;
    L12:
        if (r2.intValue() != 0) goto L13;
        return c;
    L8:
        r2 = 0;
        goto L9
    }

    public static final int g() {
        WeakReference<DataCenter> r0 = a;
        if (r0 == null) goto L8;
        DataCenter r1 = r0.get();
        if (r1 == null) goto L8;
        Integer r2 = (Integer) r1.get("feed_live_enter_sei_version");
        if (r2 == null) goto L8;
    L9:
        if (r2 != null) goto L12;
    L13:
        WeakReference<DataCenter> r3 = a;
        if (r3 == null) goto L23;
        DataCenter r4 = r3.get();
        if (r4 == null) goto L24;
        Integer r5 = (Integer) r4.get("feed_live_enter_sei_version");
        if (r5 != null) goto L20;
        return 0;
    L20:
        return r5.intValue();
    L24:
        return 0;
    L23:
        return 0;
    L12:
        if (r2.intValue() != 0) goto L13;
        return b;
    L8:
        r2 = 0;
        goto L9
    }

    public static final Pair<Integer, String> d(ds0.d r5) {
        if (r5.getEnterRoomInfo().getUiLayout() == 0) goto L5;
        int r0 = r5.getEnterRoomInfo().getUiLayout();
    L11:
        String r2 = "";
        if (r5.getEnterRoomInfo().getLinkerMap() == null) goto L17;
        String r1 = r5.getEnterRoomInfo().getLinkerMap();
        if (r1 == null) goto L38;
        r2 = r1;
    L38:
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "getLinkerMapAndUILayout ;; linkerMap == " + r2 + " ;; uiLayout == " + r0 + "  ;; enterMerge ==  " + r5.getEnterRoomInfo().getEnterMerge() + " ;; seiVersion ==  " + g());
        return new Pair(Integer.valueOf(r0), r2);
    L17:
        Room r3 = r5.w();
        String r4 = null;
        if (r3 == null) goto L24;
        Map r6 = r3.getLinkMap();
        if (r6 == null) goto L24;
        Set r7 = r6.keySet();
        if (r7 == null) goto L24;
        String r8 = (String) CollectionsKt.firstOrNull(r7);
    L26:
        if (Intrinsics.areEqual(r8, String.valueOf(8)) == false) goto L28;
        r2 = "video_talk_room";
        goto L38
    L28:
        Room r9 = r5.w();
        if (r9 == null) goto L36;
        Map r10 = r9.getLinkMap();
        if (r10 == null) goto L36;
        Set r11 = r10.keySet();
        if (r11 == null) goto L36;
        r4 = (String) CollectionsKt.firstOrNull(r11);
    L36:
        if (Intrinsics.areEqual(r4, String.valueOf(12)) == false) goto L38;
        r2 = "equal_talk_room";
    L24:
        r8 = null;
        goto L26
    L5:
        Room r12 = r5.w();
        if (r12 == null) goto L10;
        z5 r13 = r12.getLinkerDetail();
        if (r13 == null) goto L10;
        r0 = r13.getUiLayout();
    L10:
        r0 = 0;
        goto L11
    }

    public static final int e(Activity r4) {
        if (r4 == null) goto L4;
        boolean r0 = com.bytedance.android.live.core.utils.x1.l(r4);
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "isNavBarVisible == " + r0 + " ;; realScreenHeightV1 == " + com.bytedance.android.live.core.utils.s1.r() + " ;;  realScreenHeightV2== " + (com.bytedance.android.live.core.utils.s1.s(r4) - com.bytedance.android.live.core.utils.s1.A()) + " ;;  navBarHeight == " + com.bytedance.android.live.core.utils.s1.o());
        if (r0 == false) goto L10;
        return com.bytedance.android.live.core.utils.s1.r();
    L10:
        return com.bytedance.android.live.core.utils.s1.s(r4) - com.bytedance.android.live.core.utils.s1.A();
    L4:
        return com.bytedance.android.live.core.utils.s1.r();
    }

    public static final boolean h(int r3) {
        if (g() == 0) goto L10;
        if (g() == 15) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r3 == 7) goto L15;
        return false;
    L15:
        return true;
    }

    public static final boolean i(String r3, int r4) {
        if (g() == 0) goto L7;
        return j(g());
    L7:
        if (r3 == null) goto L11;
        if (r3.equals("equal_talk_room") != true) goto L11;
        return true;
    L11:
        if (r4 != 102) goto L13;
    L27:
        boolean r5 = true;
    L28:
        if (r5 == false) goto L30;
        return true;
    L30:
        if (r4 != 2) goto L32;
        return true;
    L32:
        if (r4 != 3) goto L34;
        return true;
    L34:
        if (r4 == 4) goto L53;
        if (r4 != 5) goto L37;
        return true;
    L37:
        if (r4 != 51) goto L39;
        return true;
    L39:
        if (r4 != 58) goto L41;
        return true;
    L41:
        if (r4 != 56) goto L43;
        return true;
    L43:
        if (r4 != 57) goto L45;
        return true;
    L45:
        if (r4 == 67) goto L59;
        return false;
    L59:
        return true;
    L53:
        return true;
    L13:
        if (r4 == 103) goto L27;
        if (r4 == 104) goto L27;
        if (r4 == 105) goto L27;
        if (r4 == 106) goto L27;
        if (r4 == 107) goto L27;
        if (r4 == 108) goto L27;
        if (r4 == 5) goto L27;
        r5 = false;
        goto L28
    }

    public static final boolean k(ds0.d r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L5;
        return false;
    L5:
        a = new WeakReference(r3);
        Pair<Integer, String> r4 = d(r2);
        int r5 = ((Number) r4.getFirst()).intValue();
        String r6 = (String) r4.getSecond();
        if (i(r6, r5) == false) goto L8;
    L11:
        return true;
    L8:
        if (o(r6, r5) == true) goto L11;
        if (n(g(), r5) == true) goto L11;
        return false;
    }

    public static final boolean l(ds0.d r1, DataCenter r2) {
        Intrinsics.checkNotNullParameter(r1, "session");
        a = new WeakReference(r2);
        int r3 = ((Number) d(r1).getFirst()).intValue();
        if (g() == 3) goto L5;
    L8:
        return false;
    L5:
        if (f() == 25) goto L7;
        if (r3 != 25) goto L8;
    L7:
        return true;
    }

    public static final boolean m(int r1, int r2) {
        return jc1.k.n(IInteractService.class).isVideoEqualCenterDynamicLayout(r1, r2);
    }

    public static final boolean n(int r1, int r2) {
        return jc1.k.n(IInteractService.class).isVideoEqualCenterNewLayout(r1, r2);
    }

    public static final boolean o(String r2, int r3) {
        if (g() == 0) goto L7;
        return p(g());
    L7:
        if (r2 != null) goto L9;
    L10:
        if (r3 != 1) goto L12;
        return true;
    L12:
        if (r3 != 6) goto L14;
        return true;
    L14:
        if (r3 != 7) goto L16;
        return true;
    L16:
        if (r3 != 8) goto L18;
        return true;
    L18:
        if (r3 == 9) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r2.equals("video_talk_room") != true) goto L10;
        return true;
    }

    public static final void a(String r6, int r7, LivePlayerView r8, FrameLayout.LayoutParams r9) {
        if (i(r6, r7) == false) goto L5;
        r8.setScaleType(3);
        r9.gravity = 48;
        return;
    L5:
        ViewGroup.LayoutParams r5 = null;
        if (o(r6, r7) == false) goto L67;
        r8.setScaleType(2);
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L10;
    L12:
        r9.gravity = 8388613;
        if (h(r7) == false) goto L34;
        ViewParent r10 = r8.getParent();
        if ((r10 instanceof ViewGroup) == true) goto L17;
        r10 = null;
    L17:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 == null) goto L20;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L22:
        if ((r12 instanceof FrameLayout.LayoutParams) == true) goto L24;
        r12 = null;
    L24:
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        if (r13 == null) goto L27;
        r13.gravity = 8388613;
    L27:
        if (r13 == null) goto L34;
        ViewParent r14 = r8.getParent();
        if ((r14 instanceof ViewGroup) == true) goto L31;
        r14 = null;
    L31:
        ViewGroup r15 = (ViewGroup) r14;
        if (r15 == null) goto L34;
        r15.setLayoutParams(r13);
        goto L34
    L20:
        r12 = null;
    L34:
        Object r16 = r8.getParent();
        if ((r16 instanceof View) == true) goto L37;
        r16 = null;
    L37:
        View r17 = (View) r16;
        if (r17 == null) goto L40;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L42:
        if ((r18 instanceof FrameLayout.LayoutParams) == true) goto L44;
        r18 = null;
    L44:
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        if (r19 == null) goto L47;
        Integer r20 = Integer.valueOf(r19.rightMargin);
    L48:
        if (r20 != null) goto L51;
    L52:
        Object r21 = r8.getParent();
        if ((r21 instanceof View) == true) goto L55;
        r21 = null;
    L55:
        View r22 = (View) r21;
        if (r22 == null) goto L58;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
    L60:
        if ((r23 instanceof FrameLayout.LayoutParams) == false) goto L63;
        r5 = r23;
    L63:
        FrameLayout.LayoutParams r24 = (FrameLayout.LayoutParams) r5;
        if (r24 == null) goto L131;
        r24.rightMargin = 0;
        return;
    L131:
        return;
    L58:
        r23 = null;
        goto L60
    L51:
        if (r20.intValue() != 0) goto L52;
        return;
    L47:
        r20 = null;
        goto L48
    L40:
        r18 = null;
        goto L42
    L10:
        if (h(r7) == true) goto L12;
        r9.gravity = 8388693;
        r9.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
        goto L34
    L67:
        if (n(g(), r7) == false) goto L127;
        r8.setScaleType(2);
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L71;
    L73:
        r9.gravity = 8388613;
        if (m(g(), r7) == false) goto L95;
        ViewParent r25 = r8.getParent();
        if ((r25 instanceof ViewGroup) == true) goto L78;
        r25 = null;
    L78:
        ViewGroup r26 = (ViewGroup) r25;
        if (r26 == null) goto L81;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L83:
        if ((r27 instanceof FrameLayout.LayoutParams) == true) goto L85;
        r27 = null;
    L85:
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r27;
        if (r28 == null) goto L88;
        r28.gravity = 8388613;
    L88:
        if (r28 == null) goto L95;
        ViewParent r29 = r8.getParent();
        if ((r29 instanceof ViewGroup) == true) goto L92;
        r29 = null;
    L92:
        ViewGroup r30 = (ViewGroup) r29;
        if (r30 == null) goto L95;
        r30.setLayoutParams(r28);
        goto L95
    L81:
        r27 = null;
    L95:
        Object r31 = r8.getParent();
        if ((r31 instanceof View) == true) goto L98;
        r31 = null;
    L98:
        View r32 = (View) r31;
        if (r32 == null) goto L101;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
    L103:
        if ((r33 instanceof FrameLayout.LayoutParams) == true) goto L105;
        r33 = null;
    L105:
        FrameLayout.LayoutParams r34 = (FrameLayout.LayoutParams) r33;
        if (r34 == null) goto L108;
        Integer r35 = Integer.valueOf(r34.rightMargin);
    L109:
        if (r35 != null) goto L112;
    L113:
        Object r36 = r8.getParent();
        if ((r36 instanceof View) == true) goto L116;
        r36 = null;
    L116:
        View r37 = (View) r36;
        if (r37 == null) goto L119;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
    L121:
        if ((r38 instanceof FrameLayout.LayoutParams) == false) goto L124;
        r5 = r38;
    L124:
        FrameLayout.LayoutParams r39 = (FrameLayout.LayoutParams) r5;
        if (r39 == null) goto L134;
        r39.rightMargin = 0;
        return;
    L134:
        return;
    L119:
        r38 = null;
        goto L121
    L112:
        if (r35.intValue() != 0) goto L113;
        return;
    L108:
        r35 = null;
        goto L109
    L101:
        r33 = null;
        goto L103
    L71:
        if (m(g(), r7) == true) goto L73;
        r9.gravity = 8388693;
        r9.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
        goto L95
    L127:
        r8.setScaleType(2);
        r9.gravity = 17;
    }

    public static final Rect c(l8 r11, Activity r12, int r13, Room r14) {
        int r0 = com.bytedance.android.live.core.utils.s1.z();
        int r15 = e(r12);
        int r1 = 0;
        if (r11 == null) goto L96;
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "canvas.width == " + d.optInt("width") + " ;; canvas.height == " + d.optInt("height") + " ;; seiVersion == " + r13);
        if (d.optInt("width") != 0) goto L7;
    L9:
        int r2 = 640;
        int r4 = 360;
    L10:
        if (r14 == null) goto L14;
        IStreamUrlExtra r5 = r14.getStreamUrlExtraSafely();
        if (r5 == null) goto L14;
        int r6 = r5.getWidth();
    L15:
        if (r14 == null) goto L19;
        IStreamUrlExtra r16 = r14.getStreamUrlExtraSafely();
        if (r16 == null) goto L19;
        int r17 = r16.getHeight();
    L21:
        if (FoldScreenUtils.f() == false) goto L28;
        if (FoldScreenUtils.a() != 0) goto L28;
        if (r13 == 9) goto L26;
        if (r13 != 11) goto L28;
    L26:
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "isFoldScreen == true");
    L28:
        if (fx0.a.getValue().booleanValue() == false) goto L39;
        if (r13 == 9) goto L36;
        if (r13 == 11) goto L36;
        if (r13 == 13) goto L36;
        if (r13 != 16) goto L39;
    L36:
        if ((r17 * r0) <= (r6 * r15)) goto L39;
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "screenWidth * streamHeight > screenHeight * streamWidth == true");
    L39:
        if (r11.f() != 1) goto L69;
        float r18 = ((int) (((r0 - com.bytedance.android.live.core.utils.s1.f(r11.d())) - com.bytedance.android.live.core.utils.s1.f(r11.e())) / r11.c().b())) * 1.0f;
        int r7 = (int) ((r18 / r4) * r2);
        int r19 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.d()) - (r18 * r11.c().c()));
        if (r7 <= r15) goto L43;
        int r8 = r11.a().a();
    L44:
        if (r8 == 1) goto L60;
        if (r8 == 4) goto L51;
        if (r8 != 7) goto L70;
        int r9 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.b()) - ((r7 * 1.0f) * ((1 - r11.c().d()) - r11.c().a())));
    L71:
        int r10 = 0;
    L73:
        if (r11.f() != 2) goto L95;
        float r110 = ((int) (((r15 - com.bytedance.android.live.core.utils.s1.f(r11.h())) - com.bytedance.android.live.core.utils.s1.f(r11.b())) / r11.c().a())) * 1.0f;
        int r3 = (int) ((r110 / r2) * r4);
        int r111 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.h()) - (r110 * r11.c().d()));
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L77;
    L79:
        boolean r20 = false;
    L80:
        if (r20 == false) goto L82;
        r111 = r111 + com.bytedance.android.live.core.utils.s1.A();
    L82:
        r10 = r111;
        if (r3 <= r0) goto L85;
        int r112 = r11.a().a();
    L87:
        if (r112 == 3) goto L94;
        if (r112 != 4) goto L90;
        int r21 = (r0 - r3) / 2;
        goto L95
    L90:
        if (r112 != 5) goto L95;
        int r113 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.e()) - ((r3 * 1.0f) * ((1 - r11.c().c()) - r11.c().b())));
        r1 = r19;
    L98:
        return new Rect(r1, r10, r113, r9);
    L94:
        r19 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.d()) - ((r3 * 1.0f) * r11.c().c()));
        goto L95
    L85:
        r112 = r11.g().a();
        goto L87
    L77:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L79;
        r20 = true;
    L95:
        r1 = r19;
        r113 = 0;
    L70:
        r9 = 0;
        goto L71
    L51:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L53;
    L55:
        boolean r22 = false;
    L56:
        if (r22 == false) goto L58;
        r10 = com.bytedance.android.live.core.utils.s1.A();
    L59:
        int r23 = (r15 - r7) / 2;
    L68:
        r9 = 0;
        goto L73
    L58:
        r10 = 0;
        goto L59
    L53:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L55;
        r22 = true;
        goto L56
    L60:
        r10 = (int) (com.bytedance.android.live.core.utils.s1.f(r11.h()) - ((r7 * 1.0f) * r11.c().d()));
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L63;
    L65:
        boolean r24 = false;
    L66:
        if (r24 == false) goto L68;
        r10 = r10 + com.bytedance.android.live.core.utils.s1.A();
        goto L68
    L63:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L65;
        r24 = true;
        goto L66
    L43:
        r8 = r11.g().a();
        goto L44
    L69:
        r19 = 0;
    L19:
        r17 = 0;
    L14:
        r6 = 0;
        goto L15
    L7:
        if (d.optInt("height") == 0) goto L9;
        r2 = d.optInt("height");
        r4 = d.optInt("width");
    L96:
        r113 = 0;
        r9 = 0;
        r10 = 0;
        goto L98
    }

    public static final FrameLayout.LayoutParams b(FrameLayout.LayoutParams r8, LivePlayerView r9, ILivePlayerClient r10, Context r11, ds0.d r12, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r8, "renderViewLP");
        Intrinsics.checkNotNullParameter(r9, "playerView");
        Intrinsics.checkNotNullParameter(r12, "session");
        WeakReference<DataCenter> r0 = new WeakReference(r13);
        a = r0;
        r8.topMargin = 0;
        DataCenter r1 = r0.get();
        if (r1 == null) goto L5;
        Boolean r2 = (Boolean) r1.get("not_multi_video_feed");
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L10;
        r8.width = -1;
        r8.height = -1;
        return r8;
    L10:
        Pair<Integer, String> r4 = d(r12);
        int r5 = ((Number) r4.getFirst()).intValue();
        String r6 = (String) r4.getSecond();
        if (r10 == null) goto L15;
        ILivePlayerSharedDataManager r7 = r10.sharedDataManager();
        if (r7 == null) goto L15;
        Object r14 = r7.getSharedData("is_hot_soon");
    L17:
        if (Intrinsics.areEqual(r14, r3) == false) goto L37;
        Object r15 = r10.sharedDataManager().getSharedData("live_multi_video_scene_render_view_params");
        if ((r15 instanceof RelativeLayout.LayoutParams) == false) goto L36;
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r15;
        r8.width = r16.width;
        r8.height = r16.height;
        if (o(r6, r5) == false) goto L29;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L25;
    L27:
        r8.topMargin = -(Math.abs(r16.topMargin) - ((int) com.bytedance.android.live.core.utils.s1.e(22.0f)));
        r8.gravity = 8388613;
    L104:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L180;
        if (r11 == null) goto L180;
        Room r17 = r12.w();
        if (r5 == 15) goto L140;
        int r18 = 16;
        if (r5 != 16) goto L111;
        r18 = 35;
    L142:
        if (g() == 0) goto L145;
        r18 = g();
    L145:
        if (r8.topMargin == 0) goto L147;
    L179:
        ALogger.w("MultiLinkmicVideoAdjustRenderViewUtil", "setRenderViewDefaultTopMargin ;; tempParams.topMargin  == " + r8.topMargin + "  ;; tempParams.width ==  " + r8.width + " ;; tempParams.height ==  " + r8.height + ' ');
        goto L180
    L147:
        if (n(r18, r5) == false) goto L161;
        if (r5 != 112) goto L153;
        com.bytedance.android.livesdk.j2 r19 = com.bytedance.android.livesdk.j2.a;
        l8 r110 = (l8) ((Map) r19.getValue()).get(Integer.valueOf(r18));
        if (r110 != null) goto L157;
        r110 = (l8) ((Map) r19.getValue()).get(10);
    L157:
        if ((r11 instanceof Activity) == true) goto L159;
        r11 = null;
    L159:
        r8.topMargin = c(r110, (Activity) r11, r18, r17).top;
        goto L179
    L153:
        com.bytedance.android.livesdk.j2 r111 = com.bytedance.android.livesdk.j2.a;
        r110 = (l8) ((Map) r111.getValue()).get(Integer.valueOf(r18));
        if (r110 != null) goto L157;
        r110 = (l8) ((Map) r111.getValue()).get(15);
        goto L157
    L161:
        if (i(r6, r5) == false) goto L170;
        com.bytedance.android.livesdk.j2 r112 = com.bytedance.android.livesdk.j2.a;
        l8 r20 = (l8) ((Map) r112.getValue()).get(Integer.valueOf(r18));
        if (r20 != null) goto L166;
        r20 = (l8) ((Map) r112.getValue()).get(9);
    L166:
        if ((r11 instanceof Activity) == true) goto L168;
        r11 = null;
    L168:
        r8.topMargin = c(r20, (Activity) r11, r18, r17).top;
        goto L179
    L170:
        if (o(r6, r5) == false) goto L178;
        com.bytedance.android.livesdk.j2 r113 = com.bytedance.android.livesdk.j2.a;
        l8 r114 = (l8) ((Map) r113.getValue()).get(Integer.valueOf(r18));
        if (r114 != null) goto L175;
        r114 = (l8) ((Map) r113.getValue()).get(10);
    L175:
        if ((r11 instanceof Activity) == true) goto L177;
        r11 = null;
    L177:
        r8.topMargin = c(r114, (Activity) r11, r18, r17).top;
        goto L179
    L178:
        r8.topMargin = 0;
        goto L179
    L111:
        if (r5 != 51) goto L113;
        r18 = 17;
        goto L142
    L113:
        if (r5 != 65) goto L115;
        r18 = 37;
        goto L142
    L115:
        if (r5 != 67) goto L117;
        r18 = 39;
        goto L142
    L117:
        if (r5 != 102) goto L119;
    L135:
        r18 = 11;
        goto L142
    L119:
        if (r5 == 103) goto L135;
        switch(r5) {
            case 1: goto L127;
            case 2: goto L135;
            case 3: goto L126;
            case 4: goto L142;
            case 5: goto L125;
            case 6: goto L127;
            case 7: goto L124;
            case 8: goto L127;
            case 9: goto L127;
            default: goto L121;
        };
    L121:
        switch(r5) {
            case 56: goto L130;
            case 57: goto L129;
            case 58: goto L128;
            default: goto L122;
        };
    L122:
        switch(r5) {
            case 109: goto L134;
            case 110: goto L133;
            case 111: goto L132;
            case 112: goto L131;
            default: goto L123;
        };
    L123:
        r18 = 0;
        goto L142
    L131:
        r18 = 28;
        goto L142
    L132:
        r18 = 27;
        goto L142
    L133:
        r18 = 26;
        goto L142
    L134:
        r18 = 25;
        goto L142
    L128:
        r18 = 33;
        goto L142
    L129:
        r18 = 32;
        goto L142
    L130:
        r18 = 31;
        goto L142
    L124:
        r18 = 15;
        goto L142
    L125:
        r18 = 9;
        goto L142
    L126:
        r18 = 13;
        goto L142
    L127:
        r18 = 10;
        goto L142
    L140:
        r18 = 30;
    L180:
        return r8;
    L25:
        if (h(r5) == true) goto L27;
        r8.gravity = 8388693;
        r8.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
        goto L104
    L29:
        if (n(g(), r5) == false) goto L104;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L33;
    L35:
        r8.topMargin = -(Math.abs(r16.topMargin) - ((int) com.bytedance.android.live.core.utils.s1.e(22.0f)));
        r8.gravity = 8388613;
        goto L104
    L33:
        if (m(g(), r5) == true) goto L35;
        r8.gravity = 8388693;
        r8.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
        goto L104
    L36:
        a(r6, r5, r9, r8);
        goto L104
    L37:
        if (r10 == null) goto L41;
        ILivePlayerSharedDataManager r115 = r10.sharedDataManager();
        if (r115 == null) goto L41;
        Object r116 = r115.getSharedData("live_multi_video_scene_render_view_params");
    L43:
        if ((r116 instanceof FrameLayout.LayoutParams) == false) goto L102;
        r8 = (FrameLayout.LayoutParams) r116;
        if (o(r6, r5) == false) goto L74;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L52;
        if (h(r5) == true) goto L52;
        r8.gravity = 8388693;
        r8.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
    L52:
        if (h(r5) == false) goto L104;
        ViewParent r117 = r9.getParent();
        if ((r117 instanceof ViewGroup) == true) goto L56;
        r117 = null;
    L56:
        ViewGroup r118 = (ViewGroup) r117;
        if (r118 == null) goto L59;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L61:
        if ((r119 instanceof FrameLayout.LayoutParams) == true) goto L63;
        r119 = null;
    L63:
        FrameLayout.LayoutParams r120 = (FrameLayout.LayoutParams) r119;
        if (r120 == null) goto L66;
        r120.gravity = 8388613;
    L66:
        if (r120 == null) goto L104;
        ViewParent r21 = r9.getParent();
        if ((r21 instanceof ViewGroup) == true) goto L70;
        r21 = null;
    L70:
        ViewGroup r22 = (ViewGroup) r21;
        if (r22 == null) goto L104;
        r22.setLayoutParams(r120);
        goto L104
    L59:
        r119 = null;
        goto L61
    L74:
        if (n(g(), r5) == false) goto L104;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L81;
        if (m(g(), r5) == true) goto L81;
        r8.gravity = 8388693;
        r8.bottomMargin = com.bytedance.android.live.core.utils.s1.f(48.0f);
    L81:
        if (m(g(), r5) == false) goto L104;
        ViewParent r121 = r9.getParent();
        if ((r121 instanceof ViewGroup) == true) goto L85;
        r121 = null;
    L85:
        ViewGroup r122 = (ViewGroup) r121;
        if (r122 == null) goto L88;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
    L90:
        if ((r123 instanceof FrameLayout.LayoutParams) == true) goto L92;
        r123 = null;
    L92:
        FrameLayout.LayoutParams r124 = (FrameLayout.LayoutParams) r123;
        if (r124 == null) goto L95;
        r124.gravity = 8388613;
    L95:
        if (r124 == null) goto L104;
        ViewParent r23 = r9.getParent();
        if ((r23 instanceof ViewGroup) == true) goto L99;
        r23 = null;
    L99:
        ViewGroup r24 = (ViewGroup) r23;
        if (r24 == null) goto L104;
        r24.setLayoutParams(r124);
        goto L104
    L88:
        r123 = null;
        goto L90
    L102:
        a(r6, r5, r9, r8);
    L41:
        r116 = null;
    L15:
        r14 = null;
        goto L17
    L5:
        r2 = null;
        goto L6
    }
}
