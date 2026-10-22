package com.bytedance.android.live.liveinteract.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.AlignModeType;
import com.bytedance.android.livesdk.config.RenderViewScaleType;
import com.bytedance.android.livesdk.config.l8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static int a = -1;
    public static int b;

    public static final boolean g() {
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(b) == false) goto L15;
        if (a != 0) goto L7;
        boolean r0 = true;
    L9:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L12;
        if (r0 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L9
    L15:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L17;
    L19:
        return false;
    L17:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        return true;
    }

    public static final void b(IPreviewPlayerContainerAbility r3) {
        int r0 = 0;
        if (r3 == null) goto L7;
        Integer r1 = r3.getWidth();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        if (r2 <= 0) goto L27;
        if (r3 == null) goto L13;
        Integer r4 = r3.getHeight();
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        if (r5 <= 0) goto L28;
        if (r3 == null) goto L29;
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        if (r6 == null) goto L30;
        Integer r7 = r3.getWidth();
        if (r7 == null) goto L21;
        int r8 = r7.intValue();
    L22:
        r6.width = r8;
        Integer r9 = r3.getHeight();
        if (r9 == null) goto L25;
        r0 = r9.intValue();
    L25:
        r6.height = r0;
        r3.setLayoutParams(r6);
        return;
    L21:
        r8 = 0;
        goto L22
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L13:
        r5 = 0;
        goto L14
    L27:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public static final int d(Activity r4) {
        if (FoldScreenUtils.e() == true) goto L17;
        if (PadConfigUtils.c() == true) goto L17;
        if (r4 == null) goto L9;
        boolean r0 = x1.l(r4);
        ALogger.w("FeedViewUtil", "isNavBarVisible == " + r0 + " ;; realScreenHeightV1 == " + s1.r() + " ;;  realScreenHeightV2== " + (s1.s(r4) - s1.A()) + " ;;  navBarHeight == " + s1.o());
        if (r0 == false) goto L15;
        return s1.r();
    L15:
        return s1.s(r4) - s1.A();
    L9:
        return s1.r();
    L17:
        return s1.w();
    }

    public static final boolean e(int r1) {
        return LinkFeedTypeConstant.Companion.isDouyinFullScreen(r1);
    }

    public static final boolean f(int r3) {
        if (e(r3) == true) goto L5;
    L6:
        if (r3 != 0) goto L8;
    L7:
        return true;
    L8:
        return false;
    L5:
        if (((Boolean) vm2.d.I5.getValue(null, vm2.d.a[344(0x158, float:4.82E-43)])).booleanValue() == true) goto L7;
        goto L6
    }

    public static final ConstraintLayout.LayoutParams c(int r5, int r6) {
        new ConstraintLayout.LayoutParams(-1, -2);
        if (vm2.d.q0().isOpenSmoothEnterRoom() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L15;
        switch(r5) {
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L14;
            default: goto L12;
        };
    L12:
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-1, -2);
        r7.leftToLeft = 0;
        r7.rightToRight = 0;
        r7.topToTop = 0;
        r7.constrainedWidth = true;
        return r7;
    L13:
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(0, -2);
        r8.topToTop = 0;
        r8.leftToLeft = 0;
        r8.rightToLeft = r6;
        r8.constrainedWidth = true;
        ((ViewGroup.MarginLayoutParams) r8).rightMargin = s1.f(4.0f);
        return r8;
    L14:
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(-1, -2);
        r9.leftToLeft = 0;
        r9.rightToRight = 0;
        r9.topToTop = 0;
        r9.constrainedWidth = true;
        return r9;
    L15:
        switch(r5) {
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L17;
            default: goto L16;
        };
    L16:
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, -2);
        r10.leftToLeft = 0;
        r10.rightToRight = 0;
        r10.topToTop = 0;
        r10.constrainedWidth = true;
        return r10;
    L17:
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -2);
        r11.startToStart = 0;
        r11.leftToLeft = 0;
        r11.topToBottom = r6;
        return r11;
    L18:
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-1, -2);
        r12.startToStart = 0;
        r12.leftToLeft = 0;
        r12.rightToRight = 0;
        r12.topToTop = r6;
        return r12;
    L19:
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, -2);
        r13.topToTop = r6;
        r13.leftToLeft = 0;
        r13.rightToLeft = r6;
        r13.constrainedWidth = true;
        return r13;
    L20:
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(-1, -2);
        r14.startToStart = 0;
        r14.leftToLeft = 0;
        r14.rightToRight = 0;
        r14.topToTop = r6;
        return r14;
    L5:
        if (FoldScreenUtils.f() == true) goto L9;
        if (PadConfigUtils.a() == true) goto L9;
        r0 = true;
        goto L10
    }

    public static final void a(IPreviewPlayerContainerAbility r8, Context r9, IRoom r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (r8 == null) goto L37;
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        if (r0 == null) goto L38;
        int r1 = je0.i.a;
        if (r10 == null) goto L11;
        IStreamUrlExtra r2 = r10.getStreamUrlExtraSafely();
        if (r2 == null) goto L11;
        long r3 = IStreamUrlExtraKt.getWidthFlex(r2);
    L12:
        if (r10 == null) goto L16;
        IStreamUrlExtra r11 = r10.getStreamUrlExtraSafely();
        if (r11 == null) goto L16;
        long r4 = IStreamUrlExtraKt.getHeightFlex(r11);
    L17:
        int r12 = s1.z();
        int r5 = s1.x();
        if (FoldScreenUtils.e() == true) goto L22;
        if (PadConfigUtils.c() == true) goto L22;
    L28:
        float r6 = r3;
        float r7 = r4;
        float r13 = ((r12 * 1.0f) / (r6 * 1.0f)) * r7;
        float r14 = r5;
        if (r13 <= r14) goto L31;
        r12 = (int) (r6 * ((r14 * 1.0f) / (r7 * 1.0f)));
    L32:
        r0.width = ((Number) TuplesKt.to(Integer.valueOf(r12), Integer.valueOf(r5)).getFirst()).intValue();
        if ((r9 instanceof Activity) == true) goto L35;
        r9 = null;
    L35:
        r0.height = d((Activity) r9);
        r8.setLayoutParams(r0);
        return;
    L31:
        r5 = (int) r13;
    L22:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L28;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L28;
        if (StatusBarUtil.isStatusBarTransparent() == true) goto L28;
        r5 = s1.x() - s1.A();
    L16:
        r4 = 640;
    L11:
        r3 = 360;
        goto L12
    L38:
        return;
    }

    public static final void h(IRenderView r5, IPreviewPlayerContainerAbility r6, int r7) {
        if (r5 == null) goto L4;
        r5.setScaleType(2);
    L4:
        ViewGroup.LayoutParams r0 = null;
        if (r5 == null) goto L7;
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
    L9:
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L11;
        r1 = null;
    L11:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L14;
        r2.gravity = 17;
        r2.leftMargin = 0;
        r2.rightMargin = 0;
        r2.bottomMargin = 0;
        r2.topMargin = 0;
        r2.width = -1;
        r2.height = -1;
        r5.setLayoutParams(r2);
    L14:
        if (r5 == null) goto L16;
        ViewGroup.LayoutParams r3 = r5.getLayoutParams();
    L18:
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L20;
        r3 = null;
    L20:
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r3;
        if (r4 == null) goto L28;
        r4.addRule(13);
        r4.leftMargin = 0;
        r4.rightMargin = 0;
        r4.bottomMargin = 0;
        r4.topMargin = 0;
        r4.width = -1;
        r4.height = -1;
        r5.setLayoutParams(r4);
        if ((r5 instanceof View) == true) goto L25;
        r5 = null;
    L25:
        View r8 = (View) r5;
        if (r8 == null) goto L28;
        r8.requestLayout();
    L28:
        if (r6 == null) goto L51;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if ((r9 instanceof FrameLayout.LayoutParams) == false) goto L33;
        r0 = r9;
    L33:
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r0;
        if (r10 == null) goto L36;
        r10.gravity = 1;
    L36:
        if (r10 == null) goto L38;
        r10.leftMargin = 0;
    L38:
        if (r10 == null) goto L40;
        r10.topMargin = 0;
    L40:
        if (r10 == null) goto L42;
        r10.rightMargin = 0;
    L42:
        if (r10 == null) goto L44;
        r10.bottomMargin = 0;
    L44:
        if (r7 != 0) goto L49;
        if (r10 == null) goto L47;
        r10.width = -1;
    L47:
        if (r10 == null) goto L49;
        r10.height = -1;
    L49:
        r6.setTranslationY(Float.valueOf(0.0f));
        return;
    L51:
        return;
    L16:
        r3 = null;
        goto L18
    L7:
        r1 = null;
        goto L9
    }

    public static final void i(IRenderView r24, IInteractPlayView r25, int r26, int r27, JSONObject r28, int r29, Context r30, IRoom r31, Map<String, ? extends Object> r32) {
        IRenderView r3 = r24;
        Intrinsics.checkNotNullParameter(r28, "canvas");
        Intrinsics.checkNotNullParameter(r30, "context");
        b = r29;
        if (r25 == null) goto L5;
        int r0 = r25.getFeedViewDesiredTopSpaceHeight();
    L6:
        a = r0;
        if (e(r29) == true) goto L9;
        return;
    L9:
        if (r27 == 28) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L203;
        l8 r2 = (l8) ((HashMap) vm2.k.c.getValue(null, vm2.k.a[1])).get(Integer.valueOf(r26));
        if (r2 != null) goto L18;
        int r4 = l8.a;
        r2 = (l8) l8.a.a().get(Integer.valueOf(r26));
    L18:
        if ((r30 instanceof Activity) == true) goto L20;
        Context r12 = null;
    L21:
        b = r29;
        int r13 = s1.z();
        int r14 = d((Activity) r12);
        if (r2 != null) goto L24;
    L103:
        String r6 = "FeedViewUtil";
    L104:
        boolean r15 = true;
        int r5 = 0;
        int r7 = 0;
        int r8 = 0;
        int r10 = 0;
    L105:
        Rect r9 = new Rect(r7, r10, r5, r8);
        r3 = r24;
        if (r3 == null) goto L108;
        ViewGroup.LayoutParams r11 = r24.getLayoutParams();
    L110:
        if ((r11 instanceof RelativeLayout.LayoutParams) == true) goto L112;
        r11 = null;
    L112:
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r11;
        if (r3 == null) goto L115;
        ViewGroup.LayoutParams r17 = r24.getLayoutParams();
    L117:
        if ((r17 instanceof FrameLayout.LayoutParams) == true) goto L119;
        r17 = null;
    L119:
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) r17;
        if (r26 != 10) goto L122;
    L128:
        boolean r19 = true;
    L129:
        if (r19 == false) goto L131;
    L165:
        if (r3 == null) goto L167;
        r3.setScaleType(2);
    L167:
        if (r16 == null) goto L169;
        r16.addRule(11);
        r16.addRule(12);
    L169:
        if (r18 != null) goto L171;
    L175:
        if (e(r29) == false) goto L181;
        if (r16 == null) goto L178;
        r16.leftMargin = r9.left;
        r16.topMargin = r9.top;
        r16.rightMargin = r9.right;
        r16.bottomMargin = r9.bottom;
    L178:
        if (r18 == null) goto L185;
        r18.leftMargin = r9.left;
        r18.topMargin = r9.top;
        r18.rightMargin = r9.right;
        r18.bottomMargin = r9.bottom;
    L185:
        if (r3 == null) goto L187;
        ViewGroup.LayoutParams r20 = r24.getLayoutParams();
    L189:
        if ((r20 instanceof FrameLayout.LayoutParams) == true) goto L192;
        r20 = null;
    L192:
        if (((FrameLayout.LayoutParams) r20) == null) goto L194;
        r3.setLayoutParams(r18);
    L194:
        if (r3 == null) goto L196;
        ViewGroup.LayoutParams r21 = r24.getLayoutParams();
    L198:
        if ((r21 instanceof RelativeLayout.LayoutParams) == true) goto L201;
        r21 = null;
    L201:
        if (((RelativeLayout.LayoutParams) r21) == null) goto L204;
        r3.setLayoutParams(r16);
    L204:
        b = r29;
        if (r3 == null) goto L219;
        ViewGroup.LayoutParams r22 = r24.getLayoutParams();
        if ((r22 instanceof FrameLayout.LayoutParams) == true) goto L210;
        r22 = null;
    L210:
        if (((FrameLayout.LayoutParams) r22) == null) goto L219;
        boolean r23 = tb1.d.a;
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r29) == false) goto L219;
        if (r25 == null) goto L236;
        LivePlayerView r33 = r24.getParent();
        if ((r33 instanceof LivePlayerView) == true) goto L217;
        LivePlayerView r110 = null;
    L218:
        r25.resizePlayView(r26, r27, r28, r110, r30, r31, r29, r32);
        return;
    L217:
        r110 = r33;
        goto L218
    L236:
        return;
    L219:
        if (r3 == null) goto L233;
        ViewGroup.LayoutParams r34 = r24.getLayoutParams();
        if ((r34 instanceof RelativeLayout.LayoutParams) == true) goto L223;
        ViewGroup.LayoutParams r111 = null;
    L225:
        if (((RelativeLayout.LayoutParams) r111) == null) goto L233;
        if (LinkFeedTypeConstant.Companion.isHotsoonFollowAndCity(r29) == true) goto L233;
        if (r26 != 10) goto L232;
        if (r25 == null) goto L238;
        r25.resizePlayView(r26, r28, r24, r30, r31, r29);
        return;
    L238:
        return;
    L232:
        ALogger.w(r6, "show from hotsoon other feed view");
        return;
    L223:
        r111 = r34;
    L233:
        ALogger.w(r6, "show from other feed view");
        return;
    L196:
        r21 = null;
        goto L198
    L187:
        r20 = null;
        goto L189
    L181:
        if (r16 == null) goto L183;
        r16.leftMargin = 0;
        r16.topMargin = 0;
        r16.rightMargin = 0;
        r16.bottomMargin = 0;
    L183:
        if (r18 == null) goto L185;
        r18.leftMargin = 0;
        r18.topMargin = 0;
        r18.rightMargin = 0;
        r18.bottomMargin = 0;
        goto L185
    L171:
        if (e(r29) == false) goto L173;
        r18.gravity = 8388613;
        goto L175
    L173:
        r18.gravity = 8388693;
        goto L175
    L131:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVideoEqualCenterNewLayout(r26, 0) == true) goto L165;
        if (r26 != 9) goto L136;
    L145:
        boolean r112 = true;
    L147:
        if (r112 == true) goto L159;
        if (r26 == 3) goto L151;
        r15 = false;
    L151:
        if (r15 == true) goto L159;
        if (r3 == null) goto L155;
        r3.setScaleType(2);
    L155:
        if (r16 == null) goto L157;
        r16.addRule(13);
    L157:
        if (r18 == null) goto L175;
        r18.gravity = 17;
    L159:
        if (r3 == null) goto L161;
        r3.setScaleType(3);
    L161:
        if (r16 == null) goto L163;
        r16.addRule(10);
    L163:
        if (r18 == null) goto L175;
        r18.gravity = 48;
        goto L175
    L136:
        if (aj0.b.b(Integer.valueOf(r26)) == true) goto L145;
        if (r26 == 11) goto L145;
        if (r26 == 13) goto L145;
        if (r26 == 16) goto L145;
        r112 = false;
        goto L147
    L122:
        if (r26 == 15) goto L128;
        if (r26 == 12) goto L128;
        if (r26 == 8) goto L128;
        r19 = false;
        goto L129
    L115:
        r17 = null;
        goto L117
    L108:
        r11 = null;
        goto L110
    L24:
        if (r28.optInt("height") != 0) goto L26;
        int r35 = 640;
    L28:
        if (r28.optInt("width") != 0) goto L30;
        int r113 = 360;
    L31:
        long r114 = 0;
        if (r31 == null) goto L36;
        IStreamUrlExtra r115 = r31.getStreamUrlExtraSafely();
        if (r115 == null) goto L36;
        long r116 = IStreamUrlExtraKt.getWidthFlex(r115);
    L37:
        if (r31 == null) goto L42;
        IStreamUrlExtra r210 = r31.getStreamUrlExtraSafely();
        if (r210 == null) goto L42;
        r114 = IStreamUrlExtraKt.getHeightFlex(r210);
    L42:
        if (FoldScreenUtils.f() == false) goto L49;
        if (FoldScreenUtils.a() != 0) goto L49;
        if (r26 == 9) goto L47;
        if (r26 != 11) goto L49;
    L47:
        ALogger.w("FeedViewUtil", "isFoldScreen == true");
    L49:
        if (((Boolean) vm2.d.f7.getValue(null, vm2.d.a[418(0x1a2, float:5.86E-43)])).booleanValue() == false) goto L60;
        if (r26 != 9) goto L52;
    L57:
        r6 = "FeedViewUtil";
        if ((((long) r13) * r114) <= (((long) r14) * r116)) goto L62;
        ALogger.w(r6, "screenWidth * streamHeight > screenHeight * streamWidth == true");
    L62:
        if (r2.f() != RenderViewScaleType.WIDTH_ALIGN.getValue()) goto L82;
        float r36 = ((int) (((r13 - s1.f(r2.d())) - s1.f(r2.e())) / r2.c().b())) * 1.0f;
        int r37 = (int) ((r36 / r113) * r35);
        r7 = (int) (s1.f(r2.d()) - (r36 * r2.c().c()));
        if (r37 <= r14) goto L66;
        int r117 = r2.a().a();
    L68:
        if (r117 != AlignModeType.TOP_ALIGN.getValue()) goto L73;
        int r38 = (int) (s1.f(r2.h()) - ((r37 * 1.0f) * r2.c().d()));
        if (g() == false) goto L84;
        r38 = r38 + s1.A();
    L84:
        r10 = r38;
        r8 = 0;
    L86:
        if (r2.f() != RenderViewScaleType.HEIGHT_ALIGN.getValue()) goto L102;
        float r118 = ((int) (((r14 - s1.f(r2.h())) - s1.f(r2.b())) / r2.c().a())) * 1.0f;
        int r39 = (int) ((r118 / r35) * r113);
        r10 = (int) (s1.f(r2.h()) - (r118 * r2.c().d()));
        if (g() == false) goto L90;
        r10 = r10 + s1.A();
    L90:
        if (r39 <= r13) goto L92;
        int r119 = r2.a().a();
    L94:
        if (r119 != AlignModeType.LEFT_ALIGN.getValue()) goto L97;
        r7 = (int) (s1.f(r2.d()) - ((r39 * 1.0f) * r2.c().c()));
        goto L102
    L97:
        if (r119 != AlignModeType.HORIZONTAL_CENTER_ALIGN.getValue()) goto L100;
        int r120 = (r13 - r39) / 2;
        goto L102
    L100:
        if (r119 != AlignModeType.RIGHT_ALIGN.getValue()) goto L102;
        r15 = true;
        r5 = (int) (s1.f(r2.e()) - ((r39 * 1.0f) * ((1 - r2.c().c()) - r2.c().b())));
        goto L105
    L92:
        r119 = r2.g().a();
    L102:
        r15 = true;
        r5 = 0;
        goto L105
    L73:
        if (r117 != AlignModeType.VERTICAL_CENTER_ALIGN.getValue()) goto L80;
        if (g() == false) goto L77;
        int r121 = s1.A();
    L78:
        int r40 = (r14 - r37) / 2;
        r38 = r121;
        goto L84
    L77:
        r121 = 0;
        goto L78
    L80:
        if (r117 != AlignModeType.BOTTOM_ALIGN.getValue()) goto L83;
        r8 = (int) (s1.f(r2.b()) - ((r37 * 1.0f) * ((1 - r2.c().d()) - r2.c().a())));
        r10 = 0;
    L83:
        r38 = 0;
        goto L84
    L66:
        r117 = r2.g().a();
        goto L68
    L82:
        r7 = 0;
        goto L83
    L52:
        if (r26 == 11) goto L57;
        if (r26 == 13) goto L57;
        if (r26 == 16) goto L57;
    L60:
        r6 = "FeedViewUtil";
    L36:
        r116 = 0;
        goto L37
    L30:
        r113 = r28.optInt("width");
        goto L31
    L26:
        r35 = r28.optInt("height");
        goto L28
    L20:
        r12 = r30;
        goto L21
    L203:
        r6 = "FeedViewUtil";
        goto L204
    L11:
        r1 = false;
        goto L13
    L5:
        r0 = -1;
        goto L6
    }

    public static final void j(int r13, int r14, int r15, int r16, int r17, Context r18, IRenderView r19, IInteractPlayView r20, IRoom r21, JSONObject r22, Map<String, ? extends Object> r23, ClientUIInfo r24) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r22, "canvas");
        b = r15;
        if (r19 == null) goto L16;
        ViewGroup.LayoutParams r0 = r19.getLayoutParams();
        LivePlayerView r2 = null;
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r0 = null;
    L8:
        if (((FrameLayout.LayoutParams) r0) == null) goto L17;
        if (r20 == null) goto L18;
        LivePlayerView r1 = r19.getParent();
        if ((r1 instanceof LivePlayerView) == false) goto L14;
        r2 = r1;
    L14:
        r20.resizePlayViewForCommonFeedView(r16, r17, r22, r2, r18, r21, r15, r13, r14, r23, r24);
        return;
    L18:
        return;
    L17:
        return;
    }

    public static /* synthetic */ void k(int r15, int r16, int r17, int r18, int r19, Context r20, IRenderView r21, IInteractPlayView r22, IRoom r23, JSONObject r24, Map r25, ClientUIInfo r26, int r27) {
        if ((r27 & 1024) == 0) goto L5;
        Map r13 = null;
    L7:
        if ((r27 & 2048) == 0) goto L9;
        ClientUIInfo r14 = null;
    L10:
        j(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r13, r14);
        return;
    L9:
        r14 = r26;
        goto L10
    L5:
        r13 = r25;
        goto L7
    }
}
