package com.bytedance.android.livesdk.interactivity.common.adjuster.logical;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.live.datacontext.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ok1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentLpHelper {
    public static final float a = 0.0f;
    public static final int b = 0;
    public static final int c = 0;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final a f = null;

    static {
        a = s1.e(80.0f);
        b = s1.f(80.0f);
        c = s1.f(120.0f);
        d = LazyKt.lazy(CommentLpHelper$EXPECTED_HEIGHT$2.INSTANCE);
        e = LazyKt.lazy(CommentLpHelper$EXPECTED_HEIGHT_PAD$2.INSTANCE);
        f = new a(-10086, 1);
    }

    public static int a() {
        if (PadConfigUtils.c() == false) goto L5;
        int r0 = i72.a.a;
        return s1.j(2131168726);
    L5:
        int r1 = i72.a.a;
        return s1.j(2131168725);
    }

    public static int b() {
        if (PadConfigUtils.c() == false) goto L6;
        return ((Number) e.getValue()).intValue();
    L6:
        return ((Number) d.getValue()).intValue();
    }

    @JvmStatic
    public static final d c(e r8, int r9, Room r10, LiveRoomEnvStateHolder r11) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "roomStatus");
        int r13 = r8.pT();
        int r14 = r8.WN();
        if (r14 >= ((((double) r13) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L11:
        return null;
    L8:
        if (r8.g1() == false) goto L11;
        if (r14 <= 0) goto L11;
        return new d((int) (((r13 - r14) - a) - r9), 0, 14);
    L5:
        r0 = false;
        goto L6
    }

    public static d d(e r16, int r17, LiveRoomEnvStateHolder r18, Room r19) {
        Intrinsics.checkNotNullParameter(r16, "uiContext");
        Intrinsics.checkNotNullParameter(r18, "roomStatus");
        Intrinsics.checkNotNullParameter(r19, "room");
        CommentLpHelper$handleNewHorizontalVideo$1 r2 = CommentLpHelper$handleNewHorizontalVideo$1.INSTANCE;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "handleNewHorizontalVideo   RoomID::: " + r19.getRoomId() + "    UIContextHashcode:::  " + r16.hashCode());
        if (PadConfigUtils.c() == true) goto L5;
    L13:
        ILivePlayerClient r5 = LivePlatformPlayerManager.a(r19.getRoomId(), r19.hasMicRoomField());
        StringBuilder r11 = new StringBuilder("handleNewHorizontalVideo   curPlayerHashcode:::  ");
        if (r5 == null) goto L16;
        int r13 = r5.hashCode();
    L17:
        r11.append(r13);
        ALogger.i("HORIZONTAL_HEIGHT_OPT", r11.toString());
        if (r5 == null) goto L22;
        ILivePlayerGameExtraRenderController r14 = r5.gameExtraRenderController();
        if (r14 == null) goto L22;
        ILivePlayerGameExtraRenderController.EventHub r15 = r14.eventHub();
    L23:
        if (r5 == null) goto L27;
        ILivePlayerExtraRenderController r110 = r5.extraRenderController();
        if (r110 == null) goto L27;
        ILivePlayerExtraRenderController.EventHub r111 = r110.eventHub();
    L28:
        if (r5 == null) goto L30;
        ILivePlayerMultiRenderController r6 = r5.multiRenderController();
    L32:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L36;
        Context r112 = s1.getContext();
        if (r112 == null) goto L36;
        int r113 = StatusBarUtil.getStatusBarHeight(r112);
    L37:
        float r114 = s1.u();
        if (r6 == null) goto L47;
        if (r6.isEnable() != true) goto L47;
        Integer r7 = (Integer) r6.eventHub().getMultiRenderBottom().getValue();
        if (r7 == null) goto L44;
        int r8 = r7.intValue() - r113;
    L45:
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "multi render，videoBottom: " + r2.invoke(r8, r114));
    L65:
        int r3 = r16.pT() - r113;
        if (r8 >= b.a) goto L69;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "videoBottom: " + r2.invoke(r8, r114) + "，video bottom too high, use vertical logic");
        return null;
    L69:
        int r9 = r3 - r8;
        if ((r9 - a()) >= r17) goto L74;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "bottom too low, use vertical logic. videoBottom: " + r2.invoke(r8, r114) + "， interactivityLayerHeight: " + r2.invoke(r3, r114) + "，currentMarginBottom: " + r2.invoke(r17, r114));
        return null;
    L74:
        if (r18.w == false) goto L76;
        int r1 = r18.x;
    L77:
        int r10 = r9 - r17;
        int r20 = (r10 - a()) - r1;
        if (PadConfigUtils.c() == false) goto L80;
        int r115 = c;
    L82:
        if (r20 > r115) goto L90;
        int r4 = b();
        InteractionWidgetsPosContext r21 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r19.getRoomId(), 1);
        if (r21 == null) goto L88;
        m r23 = r21.getGameGiftTrayPos();
        if (r23 == null) goto L88;
        r23.setValue(f);
    L88:
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "interactivityLayerHeight:" + r2.invoke(r3, r114) + ", currentMarginBottom: " + r2.invoke(r17, r114) + ", usableHeight: " + r2.invoke(r20, r114) + "< minHeight, use fixed height");
        return new d(r4, 0, 14);
    L90:
        int r24 = r10 - a();
        InteractionWidgetsPosContext.a r25 = InteractionWidgetsPosContext.Companion;
        r25.getClass();
        int r26 = (r24 - InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp()) - r1;
        int r27 = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp() + r26;
        if (r26 <= b()) goto L101;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "interactivityLayerHeight:" + r2.invoke(r3, r114) + ",currentMarginBottom:" + r2.invoke(r17, r114) + ",visible Height:" + r2.invoke(r26, r114) + " > threshold, tray down}");
        InteractionWidgetsPosContext r0 = InteractionWidgetsPosContext.a.c(r25, null, r19.getRoomId(), 1);
        if (r0 == null) goto L107;
        m r28 = r0.getGameGiftTrayPos();
        if (r28 == null) goto L107;
        if (PadConfigUtils.c() == false) goto L99;
        int r29 = i72.a.a;
        int r30 = s1.j(2131168728);
    L100:
        r28.setValue(new a(r27 - r30, 2));
        goto L107
    L99:
        int r31 = i72.a.a;
        r30 = s1.j(2131168727);
    L107:
        return new d(r27, 0, 14);
    L101:
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "interactivityLayerHeight:" + r2.invoke(r3, r114) + ", currentMarginBottom:" + r2.invoke(r17, r114) + ",visible Height:" + r2.invoke(r26, r114) + ", < threshold, tray up}");
        InteractionWidgetsPosContext r33 = InteractionWidgetsPosContext.a.c(r25, null, r19.getRoomId(), 1);
        if (r33 == null) goto L107;
        m r34 = r33.getGameGiftTrayPos();
        if (r34 == null) goto L107;
        r34.setValue(f);
        goto L107
    L80:
        r115 = b;
        goto L82
    L76:
        r1 = 0;
        goto L77
    L44:
        r8 = r16.WN();
    L47:
        if (r15 != null) goto L49;
    L56:
        if (r111 != null) goto L58;
    L64:
        r8 = r16.WN() - r113;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "horizontal video，videoBottom: " + r2.invoke(r8, r114));
        goto L65
    L58:
        if (Intrinsics.areEqual((Boolean) r111.getExtraRenderIsShow().getValue(), Boolean.TRUE) == false) goto L64;
        Integer r35 = (Integer) r111.getExtraViewBottom().getValue();
        if (r35 == null) goto L62;
        int r36 = r35.intValue() - r113;
    L63:
        int r37 = Math.max(r36, r16.WN());
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "double screen，videoBottom: " + r2.invoke(r37, r114));
    L55:
        r8 = r37;
        goto L65
    L62:
        r36 = 0;
        goto L63
    L49:
        if (Intrinsics.areEqual((Boolean) r15.getExtraRenderIsShow().getValue(), Boolean.TRUE) == false) goto L56;
        Integer r38 = (Integer) r15.getExtraViewBottom().getValue();
        if (r38 == null) goto L53;
        int r39 = r38.intValue() - r113;
    L54:
        r37 = Math.max(r39, r16.WN());
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "double screen，videoBottom: " + r2.invoke(r37, r114));
        goto L55
    L53:
        r39 = 0;
    L36:
        r113 = 0;
        goto L37
    L30:
        r6 = null;
    L27:
        r111 = null;
    L22:
        r15 = null;
        goto L23
    L16:
        r13 = 0;
        goto L17
    L5:
        if (e5.n() == false) goto L13;
        ALogger.i("HORIZONTAL_HEIGHT_OPT", "pad horizontal use fixed height");
        InteractionWidgetsPosContext r40 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r19.getRoomId(), 1);
        if (r40 == null) goto L12;
        m r41 = r40.getGameGiftTrayPos();
        if (r41 == null) goto L12;
        r41.setValue(f);
    L12:
        return new d(b(), 0, 14);
    }
}
