package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.ui.x7;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.b41;
import com.bytedance.android.livesdk.config.c41;
import com.bytedance.android.livesdk.config.rs0;
import com.bytedance.android.livesdk.config.xk;
import com.bytedance.android.livesdk.config.zp0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.widget.h0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdk.widgetdescriptor.data.FlingViewModel;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import zg1.h1;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/AudiencePortraitGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/GestureWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitGestureWidget extends GestureWidget {
    public static final /* synthetic */ int F = 0;
    public double A;
    public boolean B;
    public boolean C;
    public LiveVerticalViewPager D;
    public Disposable E;
    public View.OnTouchListener z;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ AudiencePortraitGestureWidget a;

        public b(AudiencePortraitGestureWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            AudiencePortraitGestureWidget r0 = this.a;
            int r1 = AudiencePortraitGestureWidget.F;
            h70.b r2 = r0.getComponentContext();
            iy.d r5 = null;
            if (r2 == null) goto L5;
            gd0.k r6 = ho1.a.k(r2);
        L6:
            if (r6 == null) goto L8;
            r6.a(r3, r4);
        L8:
            h70.b r7 = this.a.getComponentContext();
            if (r7 == null) goto L11;
            r5 = ho1.a.a(r7);
        L11:
            if (r5 == null) goto L15;
            r5.a(r3, r4);
            return false;
        L15:
            return false;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            xs2.b.a().post(new s(true));
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            xs2.b.a().post(new s(false));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void er() {
        this.z = null;
    }

    public AudiencePortraitGestureWidget() {
        this.z = new b(this);
        this.A = 1.0d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Yq() {
        View r0 = Gq();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r0.getX();
        float r2 = r0.getWidth();
        b41 r3 = c41.a;
        if (r3.b() == false) goto L8;
        float r4 = r3.d();
    L10:
        if (r1 < (r2 / r4)) goto L12;
        mr(200, 0.0f);
        return;
    L12:
        mr(-1.0f, 0.0f);
        return;
    L8:
        r4 = 2.0f;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        RoomContext r0 = Iq();
        LiveVerticalViewPager r1 = null;
        if (r0 == null) goto L10;
        this.E = r0.getGestureLayoutBehaviorEvent().onEvent().subscribe(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.c(this), com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.d.a);
        List r2 = r0.getStickyBehaviorEvents();
        r0.setStickyBehaviorEvents(null);
        if (r2 == null) goto L10;
        int r3 = r2.size();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        nr((gh1.a) ListProtector.get(r2, r4));
        r4 = r4 + 1;
    L10:
        super.onCreate();
        Double r5 = zp0.a.getValue();
        if (r5.doubleValue() > 0.0d) goto L13;
        return;
    L13:
        if (r5.doubleValue() >= 180.0d) goto L21;
        this.A = Math.tan(Math.toRadians(90.0d - (r5.doubleValue() / ((double) 2))));
        this.B = true;
        GestureDetectLayout r6 = this.d;
        if (r6 == null) goto L17;
        r1 = jr(r6);
    L17:
        this.D = r1;
        return;
    }

    public final boolean or() {
        RoomContext r0 = Iq();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (((Room) r0.getRoom().getValue()).isVrRoom() == true) goto L32;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L24;
        ym0.a r2 = (ym0.a) r1.get("cmd_current_camera_info", null);
        if (r2 == null) goto L24;
        if (r2.c() != 1) goto L16;
        boolean r3 = true;
    L18:
        if (r2.d() != 1) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        if (r3 == false) goto L24;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L32;
        if (pm1.f.l() == null) goto L31;
        nm1.m r6 = pm1.f.l();
        Intrinsics.checkNotNull(r6);
        if (r6.J(((Widget) this).dataCenter) == true) goto L32;
    L31:
        boolean r7 = false;
    L33:
        if (r7 == true) goto L35;
        return false;
    L35:
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r8 = LiveVrContext.c.a();
        if (r8 != null) goto L38;
        return false;
    L38:
        boolean r9 = ((Boolean) r8.isVrSensorOpen().getValue()).booleanValue();
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 != null) goto L41;
    L43:
        boolean r11 = false;
    L45:
        if (SettingKeyUtils.d() == true) goto L47;
    L49:
        boolean r12 = false;
    L50:
        if (r12 == false) goto L53;
        if (r11 == true) goto L53;
        boolean r13 = true;
    L55:
        if (VrUtils.h() == true) goto L62;
        if (r7 == false) goto L79;
        if (r9 == false) goto L59;
        if (r12 == true) goto L59;
        return false;
    L59:
        if (r13 == true) goto L81;
        return true;
    L81:
        return false;
    L79:
        return false;
    L62:
        if (r11 == false) goto L74;
        if (VrUtils.h() == true) goto L66;
    L70:
        boolean r14 = false;
    L71:
        if (r14 == false) goto L74;
        return r7;
    L66:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY.getType()) goto L68;
    L69:
        r14 = true;
        goto L71
    L68:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_ALWAYS.getType()) goto L70;
    L74:
        if (VrUtils.j() == false) goto L82;
        if (r7 == false) goto L83;
        if (r9 == true) goto L84;
        return true;
    L84:
        return false;
    L83:
        return false;
    L82:
        return false;
    L53:
        r13 = false;
        goto L55
    L47:
        if (SettingKeyUtils.c() == false) goto L49;
        r12 = true;
        goto L50
    L41:
        if (((Boolean) r10.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L43;
        r11 = true;
        goto L45
    L20:
        r4 = false;
        goto L21
    L16:
        r3 = false;
    L24:
        r5 = false;
    L32:
        r7 = true;
        goto L33
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final View.OnTouchListener Fq() {
        return this.z;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean D8(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        h70.b r0 = getComponentContext();
        h0 r1 = null;
        if (r0 == null) goto L5;
        h0 r2 = ho1.a.l(r0);
    L6:
        if (r2 == null) goto L17;
        if (r2.mb(r4) != true) goto L17;
        ALogger.e("GestureWidget", "onDiggTap isMagicClick is true ");
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L12;
        r1 = ho1.a.l(r5);
    L12:
        if (r1 == null) goto L18;
        r1.T7();
        return false;
    L18:
        return false;
    L17:
        return super.D8(r4);
    L5:
        r2 = null;
        goto L6
    }

    public final LiveVerticalViewPager jr(ViewGroup r2) {
        if ((r2 instanceof LiveVerticalViewPager) == true) goto L5;
        ViewParent r3 = r2.getParent();
        if (r3 != null) goto L9;
        return null;
    L9:
        if ((r3 instanceof View) == true) goto L11;
        return null;
    L11:
        return jr((ViewGroup) r3);
    L5:
        return (LiveVerticalViewPager) r2;
    }

    public final void kr(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewPropertyAnimator r4 = r3.animate();
        if (ClearScreenHelper.c() == false) goto L7;
        r4.alpha(0.0f);
    L8:
        r4.setDuration(200).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L7:
        View r0 = Gq();
        Intrinsics.checkNotNull(r0);
        r4.x(r0.getWidth());
        goto L8
    }

    public final void lr(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewPropertyAnimator r4 = r3.animate();
        if (ClearScreenHelper.c() == false) goto L7;
        r4.alpha(1.0f);
    L8:
        r4.setDuration(200).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L7:
        r4.x(0.0f);
        goto L8
    }

    public final void nr(gh1.a r4) {
        if (r4 == null) goto L15;
        y r0 = r4.b;
        if (r0 == null) goto L16;
        GestureDetectLayout r1 = this.d;
        if (r1 == null) goto L17;
        int r5 = r4.a;
        if (r5 != 1) goto L12;
        if (r1 == null) goto L18;
        r1.a(r0);
        return;
    L18:
        return;
    L12:
        if (r5 != 2) goto L20;
        r1.d(r0);
        return;
    L20:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Cq(float r2, float r3) {
        if (r2 <= 0) goto L8;
        jo1.e r4 = Eq();
        if (r4 == null) goto L9;
        r4.da(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void I4(boolean r5, boolean r6) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        View r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.getFragment();
    L6:
        Intrinsics.checkNotNull(r2);
        View r3 = Gq();
        Intrinsics.checkNotNull(r3);
        if (r5 == true) goto L9;
        ViewModelProviders.of(r2).get(FlingViewModel.class).getStatus().setValue(new FlingViewModel.a(true, 0.0f, r6));
        com.bytedance.android.livesdk.chatroom.ui.framework.d r7 = this.b;
        if (r7 == null) goto L36;
        View r8 = r7.A8();
    L37:
        lr(r8);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r9 = this.b;
        if (r9 == null) goto L40;
        r1 = r9.de();
    L40:
        lr(r1);
        return;
    L36:
        r8 = null;
        goto L37
    L9:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == false) goto L25;
        int r10 = gs1.a.a;
        com.bytedance.android.livesdk.clearscreen.h r11 = gs1.a.a(a0.p(getDataCenter()));
        if (r11 == null) goto L25;
        if (r11.g() == true) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r12 = this.c;
        if (r12 == null) goto L19;
        Intrinsics.checkNotNullParameter(r12, "$this$getClearScreenWaterInterface");
        Element<?> r13 = r12.w8(d90.d.a.H0);
        if (r13 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r14 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r13.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L20:
        if (r14 == null) goto L22;
        r14.l();
    L22:
        com.bytedance.android.livesdk.clearscreen.h r15 = gs1.a.a(a0.p(getDataCenter()));
        if (r15 == null) goto L25;
        r15.f((e0) getComponentContext());
    L19:
        r14 = null;
    L25:
        ViewModelProviders.of(r2).get(FlingViewModel.class).getStatus().setValue(new FlingViewModel.a(false, r3.getWidth(), r6));
        com.bytedance.android.livesdk.chatroom.ui.framework.d r16 = this.b;
        if (r16 == null) goto L28;
        View r17 = r16.A8();
    L29:
        kr(r17);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r18 = this.b;
        if (r18 == null) goto L32;
        r1 = r18.de();
    L32:
        kr(r1);
        return;
    L28:
        r17 = null;
        goto L29
    L5:
        r2 = null;
        goto L6
    }

    public final boolean mr(float r18, float r19) {
        if (((Boolean) ((Widget) this).dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L6;
        return false;
    L6:
        if (isRecording() == false) goto L9;
        return false;
    L9:
        if (Sq() == true) goto L11;
    L17:
        boolean r2 = RTLUtil.isAppRTL(getContext());
        View r4 = Gq();
        Intrinsics.checkNotNull(r4);
        Room r5 = getRoom();
        Intrinsics.checkNotNull(r5);
        RoomContext r6 = Iq();
        int r7 = r4.getWidth();
        if (r2 == false) goto L21;
        r7 = -r7;
    L21:
        if (r2 == true) goto L23;
    L24:
        if (r2 == false) goto L26;
    L28:
        boolean r3 = false;
    L30:
        if (r19 != 0.0f) goto L32;
        boolean r10 = true;
    L33:
        ALogger.d("LiveDrawerContainerDialog", "onAudienceFling, isFromActionUp: " + r10 + ", flingRight: " + r3);
        if (r3 == false) goto L36;
    L38:
        boolean r11 = false;
    L40:
        if (fr() == false) goto L45;
        float r8 = r7;
        if (r4.getX() == r8) goto L44;
        I4(true, false);
        r4.setX(r8);
    L44:
        return false;
    L45:
        if (r3 == false) goto L47;
    L49:
        boolean r12 = false;
    L50:
        boolean r13 = or();
        if (r12 == false) goto L53;
    L56:
        if (r13 == false) goto L59;
    L57:
        return false;
    L59:
        if (r3 == true) goto L61;
    L118:
        if (r11 == false) goto L171;
        if (r10 == false) goto L121;
    L124:
        if (r6 == null) goto L134;
        com.bytedance.live.datacontext.n r9 = r6.getExternalConfigJudger();
        if (r9 == null) goto L134;
        IExternalConfigJudger r14 = (IExternalConfigJudger) r9.getValue();
        if (r14 == null) goto L134;
        if (r14.disable(EXTERNAL_CONFIG_TYPE.Gesture, "rightScroll") != true) goto L134;
        return false;
    L134:
        if (r4.getX() != 0) goto L136;
        boolean r16 = true;
    L137:
        if (r16 == true) goto L171;
        I4(false, false);
        getActivity();
        r5.getId();
        r4.animate().x(0.0f).setDuration(c41.a()).setInterpolator(new com.bytedance.android.live.core.widget.g()).setListener(new d()).start();
        if (pX() == false) goto L149;
        h70.b r1 = getComponentContext();
        if (r1 == null) goto L145;
        IAbilityCenter r15 = r1.a();
        if (r15 == null) goto L145;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r17 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r15.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L146:
        if (r17 == null) goto L148;
        r17.sq(false);
    L148:
        ClearScreenLogUtils.Companion r20 = ClearScreenLogUtils.a;
        DataCenter r21 = ((Widget) this).dataCenter;
        r20.getClass();
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r22 = null;
        ClearScreenLogUtils.Companion.f(r21, "draw", null);
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.a.a("draw");
    L150:
        h70.b r23 = getComponentContext();
        if (r23 == null) goto L155;
        IAbilityCenter r24 = r23.a();
        if (r24 == null) goto L155;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r25 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r24.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L156:
        if (r25 == null) goto L158;
        r25.F5(0);
    L158:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r26 = this.c;
        if (r26 == null) goto L163;
        Intrinsics.checkNotNullParameter(r26, "$this$getClearScreenWaterInterface");
        Element<?> r27 = r26.w8(d90.d.a.H0);
        if (r27 == null) goto L163;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r110 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r27.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L164:
        if (r110 != null) goto L166;
    L169:
        ((Widget) this).dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r28 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r29 = Boolean.valueOf(pX());
        r28.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r28, r29);
        return true;
    L166:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L168;
        r110.t(8);
        goto L169
    L168:
        r110.i();
    L163:
        r110 = r22;
    L155:
        r25 = r22;
    L145:
        r17 = null;
        goto L146
    L149:
        r22 = null;
        goto L150
    L136:
        r16 = false;
        goto L137
    L121:
        if (Math.abs(r18) >= 200) goto L124;
        return false;
    L171:
        jo1.e r30 = Eq();
        if (r30 != null) goto L174;
        return false;
    L174:
        if (r30.Uf(r4.getTranslationX(), r3, r18) != true) goto L178;
        return true;
    L178:
        return false;
    L61:
        if (Pq() == true) goto L63;
    L66:
        if (r6 == null) goto L76;
        com.bytedance.live.datacontext.n r111 = r6.getExternalConfigJudger();
        if (r111 == null) goto L76;
        IExternalConfigJudger r31 = (IExternalConfigJudger) r111.getValue();
        if (r31 == null) goto L76;
        if (r31.disable(EXTERNAL_CONFIG_TYPE.Gesture, "rightScroll") != true) goto L76;
        return false;
    L76:
        if (r10 == false) goto L78;
    L81:
        float r32 = r7;
        if (r4.getX() != r32) goto L84;
        boolean r33 = true;
    L85:
        if (r33 == true) goto L118;
        I4(true, false);
        getActivity();
        r5.getId();
        r4.animate().x(r32).setDuration(c41.a()).setInterpolator(new com.bytedance.android.live.core.widget.g()).setListener(new c()).start();
        if (pX() == true) goto L97;
        h70.b r34 = getComponentContext();
        if (r34 == null) goto L93;
        IAbilityCenter r35 = r34.a();
        if (r35 == null) goto L93;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r36 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r35.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L94:
        if (r36 == null) goto L96;
        r36.sq(true);
    L96:
        ClearScreenLogUtils.Companion r37 = ClearScreenLogUtils.a;
        DataCenter r38 = ((Widget) this).dataCenter;
        r37.getClass();
        ClearScreenLogUtils.Companion.d(r38, "draw", null);
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.a = System.currentTimeMillis();
    L93:
        r36 = null;
    L97:
        h70.b r39 = getComponentContext();
        if (r39 == null) goto L102;
        IAbilityCenter r40 = r39.a();
        if (r40 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r41 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r40.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L103:
        if (r41 == null) goto L105;
        r41.F5(8);
    L105:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r42 = this.c;
        if (r42 == null) goto L110;
        Intrinsics.checkNotNullParameter(r42, "$this$getClearScreenWaterInterface");
        Element<?> r43 = r42.w8(d90.d.a.H0);
        if (r43 == null) goto L110;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r112 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r43.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L111:
        if (r112 != null) goto L113;
    L116:
        ((Widget) this).dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r44 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r45 = Boolean.valueOf(pX());
        r44.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r44, r45);
        return true;
    L113:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L115;
        r112.t(0);
        goto L116
    L115:
        r112.i();
    L110:
        r112 = null;
    L102:
        r41 = null;
        goto L103
    L84:
        r33 = false;
        goto L85
    L78:
        if (Math.abs(r18) >= 200) goto L81;
        return false;
    L63:
        if (wt2.a.d(Boolean.valueOf(isAnchor())) == false) goto L66;
        f2.b(2131917260, 0);
        ALogger.e("GestureWidget", "rejected screen clean for pure clean mode");
        mr(-1.0f, 0.0f);
        return true;
    L53:
        if (wt2.a.b(Boolean.valueOf(isAnchor())) == false) goto L57;
        if (ClearScreenHelper.a() == true) goto L57;
    L47:
        if (r4.getTranslationX() != 0.0f) goto L49;
        r12 = true;
        goto L50
    L36:
        if (r4.getTranslationX() <= 0) goto L38;
        r11 = true;
        goto L40
    L32:
        r10 = false;
        goto L33
    L26:
        if (r18 <= 0) goto L28;
    L27:
        r3 = true;
        goto L30
    L23:
        if (r18 < 0) goto L27;
    L11:
        if (g1() == false) goto L17;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e == false) goto L17;
        if (Tq() == true) goto L17;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Zq(MotionEvent r7, MotionEvent r8, float r9, float r10) {
        if (((Boolean) ((Widget) this).dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L5;
        return false;
    L5:
        if (r7 == null) goto L24;
        if (r8 == null) goto L24;
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        boolean r4 = true;
        Logger.d("GestureWidget", String.format("onFling, Event1={%f, %f}, Event2={%f, %f}, deltaX=%f, deltaY=%f, velocityX=%f, velocityY=%f", Arrays.copyOf(new Object[]{Float.valueOf(r7.getX()), Float.valueOf(r7.getY()), Float.valueOf(r8.getX()), Float.valueOf(r8.getY()), Float.valueOf(r7.getX() - r8.getX()), Float.valueOf(r7.getY() - r8.getY()), Float.valueOf(r9), Float.valueOf(r10)}, 8)));
        float r1 = r8.getX() - r7.getX();
        float r11 = r8.getY() - r7.getY();
        float r3 = 100;
        if (Math.abs(r1) >= r3) goto L11;
    L13:
        boolean r12 = false;
    L15:
        if (Math.abs(r11) >= r3) goto L17;
    L19:
        r4 = false;
    L20:
        Logger.d("GestureWidget", "onFling" + r1 + r11 + r12 + r4);
        if (r12 == false) goto L24;
        return mr(r1, r9);
    L17:
        if (Math.abs(r10) < r3) goto L19;
    L11:
        if (Math.abs(r9) < r3) goto L13;
        r12 = true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Wq(float r16, float r17, float r18, float r19, float r20) {
        if (((Boolean) ((Widget) this).dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L5;
        return;
    L5:
        float r1 = r18 - r16;
        float r2 = r19 - r16;
        float r3 = r20 - r17;
        LiveVerticalViewPager r4 = this.D;
        RoomContext r5 = Iq();
        View r6 = Gq();
        Intrinsics.checkNotNull(r6);
        if (r4 != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        b41 r10 = c41.a;
        if (r10.b() == true) goto L14;
    L16:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L33;
        if (r4 == null) goto L33;
        if (this.B == false) goto L46;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r12 = this.a;
        if (r12 == null) goto L24;
        boolean r13 = r12.isNestedOutside();
    L25:
        if (r13 == true) goto L46;
        if (r9 == true) goto L46;
        if (r1 >= 0) goto L46;
        if (Math.abs(r3) < (((double) Math.abs(r2)) * r4.getTanValue())) goto L46;
        return;
    L24:
        r13 = false;
    L46:
        if (Sq() == false) goto L55;
        if (g1() == false) goto L55;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e == false) goto L55;
        if (Tq() == true) goto L55;
        return;
    L55:
        if (com.bytedance.android.livesdk.clearscreen.utils.e.d(((Widget) this).dataCenter, getRoom()) == false) goto L58;
        ALogger.i("AudiencePortraitInteractionFragment", "onAudienceScroll return by slide clean mode");
        return;
    L58:
        boolean r7 = or();
        if (ClearScreenHelper.g() == false) goto L68;
        if (r5 == null) goto L68;
        com.bytedance.live.datacontext.m r8 = r5.isMultiTabRoom();
        if (r8 == null) goto L68;
        if (((Boolean) r8.getValue()).booleanValue() == true) goto L68;
        if (rs0.a.getValue().booleanValue() == false) goto L68;
        boolean r14 = true;
    L70:
        if (xk.a.getValue().booleanValue() == true) goto L72;
    L74:
        boolean r15 = false;
    L75:
        if (r15 == false) goto L108;
        if (r7 == true) goto L108;
        if (r5 == null) goto L83;
        com.bytedance.live.datacontext.m r21 = r5.getCleanMode();
        if (r21 == null) goto L83;
        if (((Number) r21.getValue()).intValue() != 2) goto L83;
    L89:
        if (r5 == null) goto L108;
        com.bytedance.live.datacontext.m r22 = r5.isInZoom();
        if (r22 == null) goto L108;
        if (((Boolean) r22.getValue()).booleanValue() == true) goto L108;
        float r23 = r16 - r19;
        float r24 = r17 - r20;
        if (r23 > (((double) r6.getWidth()) / 2.0d)) goto L97;
    L99:
        boolean r25 = false;
    L100:
        if (r25 == false) goto L108;
        if (this.C == true) goto L108;
        if (com.bytedance.android.livesdk.feedback.utils.a.b(((Widget) this).dataCenter, 6) == false) goto L106;
        return;
    L106:
        Map<Long, Long> r26 = x7.a;
        xs2.b.a().post(new h1(6));
        HashMap r27 = new HashMap();
        r27.put("leave_type", "draw");
        r27.put("is_clear_mode", "1");
        i4.c(r27);
        u.l().sendLog("live_leave", r27, new Object[]{x.class, Room.class});
        this.C = true;
        goto L108
    L97:
        if (Math.abs(r23) <= Math.abs(r24)) goto L99;
        r25 = true;
    L83:
        if (r5 == null) goto L88;
        com.bytedance.live.datacontext.m r28 = r5.getCleanMode();
        if (r28 == null) goto L88;
        if (((Number) r28.getValue()).intValue() == 13) goto L89;
    L88:
        if (r14 == true) goto L89;
    L108:
        if (isRecording() == false) goto L111;
        return;
    L111:
        if (Pq() == true) goto L113;
    L117:
        if (r5 == null) goto L125;
        com.bytedance.live.datacontext.n r29 = r5.getExternalConfigJudger();
        if (r29 == null) goto L125;
        IExternalConfigJudger r30 = (IExternalConfigJudger) r29.getValue();
        if (r30 == null) goto L125;
        if (r30.disable(EXTERNAL_CONFIG_TYPE.Gesture, "rightScroll") != true) goto L125;
        return;
    L125:
        boolean r31 = or();
        if (wt2.a.b(Boolean.valueOf(isAnchor())) == false) goto L227;
        if (r31 == true) goto L229;
        float r32 = 0;
        if (r1 <= r32) goto L132;
    L134:
        int r33 = r6.getWidth();
        if (r6.getX() != 0.0f) goto L139;
        if (r1 <= r32) goto L139;
        return;
    L139:
        if (r6.getX() != r6.getWidth()) goto L143;
        if (r1 >= r32) goto L143;
        return;
    L143:
        if (fr() == false) goto L148;
        float r34 = r33;
        if (r6.getX() == r34) goto L226;
        I4(true, false);
        r6.setX(r34);
        return;
    L226:
        return;
    L148:
        float r35 = Math.min(Math.max(0.0f, r6.getX() - r1), r6.getWidth());
        View r36 = null;
        if (pX() == false) goto L166;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r37 = this.b;
        if (r37 == null) goto L153;
        View r38 = r37.getRootView();
    L154:
        if (r38 != null) goto L156;
        return;
    L156:
        float r39 = r33;
        float r40 = Math.min(1.0f, Math.max(0.0f, (r35 - (r39 / 2.0f)) / (r39 * 0.5f)));
        com.bytedance.android.livesdk.chatroom.ui.framework.a r41 = this.c;
        if (r41 == null) goto L161;
        Intrinsics.checkNotNullParameter(r41, "$this$getClearScreenWaterInterface");
        Element<?> r42 = r41.w8(d90.d.a.H0);
        if (r42 == null) goto L161;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r43 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r42.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L162:
        if (r43 == null) goto L166;
        if (wt2.a.l() == false) goto L166;
        r43.C(r40);
    L161:
        r43 = null;
        goto L162
    L153:
        r38 = null;
    L166:
        r6.setX(r35);
        if (wt2.a.k() == true) goto L192;
        if (wt2.a.i() == true) goto L192;
        if (wt2.a.j() == true) goto L192;
        if (wt2.a.l() == true) goto L192;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r44 = this.c;
        if (r44 == null) goto L178;
        ViewLayerDelegate<? extends h70.b> r45 = r44.hk();
    L179:
        if (r45 == null) goto L183;
        v70.a r46 = r45.s();
        if (r46 == null) goto L183;
        r46.setX(r35);
    L183:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r47 = this.c;
        if (r47 == null) goto L186;
        ViewLayerDelegate<? extends h70.b> r48 = r47.E8();
    L187:
        if (r48 == null) goto L203;
        v70.a r49 = r48.s();
        if (r49 == null) goto L203;
        r49.setX(r35);
    L203:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L212;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r50 = this.c;
        if (r50 == null) goto L207;
        ViewLayerDelegate<? extends h70.b> r51 = r50.Ni();
    L208:
        if (r51 == null) goto L212;
        v70.a r52 = r51.s();
        if (r52 == null) goto L212;
        r52.setX(r35);
        goto L212
    L207:
        r51 = null;
    L212:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r53 = this.b;
        if (r53 == null) goto L215;
        View r54 = r53.A8();
    L216:
        if (r54 == null) goto L218;
        r54.setX(r35);
    L218:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r55 = this.b;
        if (r55 == null) goto L221;
        r36 = r55.de();
    L221:
        if (r36 == null) goto L228;
        r36.setX(r35);
        return;
    L228:
        return;
    L215:
        r54 = null;
        goto L216
    L186:
        r48 = null;
        goto L187
    L178:
        r45 = null;
    L192:
        if (com.bytedance.android.livesdk.clearscreen.a.b == false) goto L199;
        Iterator<v70.a> r56 = com.bytedance.android.livesdk.clearscreen.a.a.iterator();
    L196:
        if (r56.hasNext() == false) goto L199;
        r56.next().setX(r35);
    L199:
        if (isAnchor() == true) goto L201;
        boolean r57 = gs1.b.a;
        gs1.b.a(a0.p(getDataCenter())).p(r35);
    L201:
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        boolean r58 = r6 instanceof ViewGroup;
        goto L203
    L132:
        if (ClearScreenHelper.a() == false) goto L134;
        return;
    L229:
        return;
    L227:
        return;
    L113:
        if (r1 > 0) goto L117;
        if (wt2.a.d(Boolean.valueOf(isAnchor())) == false) goto L117;
        return;
    L72:
        if (wt2.a.h() == false) goto L74;
        r15 = true;
    L68:
        r14 = false;
    L33:
        if (this.B == false) goto L46;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r59 = this.a;
        if (r59 == null) goto L37;
        boolean r60 = r59.isNestedOutside();
    L38:
        if (r60 == true) goto L46;
        if (r9 == true) goto L46;
        if (r1 >= 0) goto L46;
        if (Math.abs(r3) < (((double) Math.abs(r2)) * this.A)) goto L46;
        return;
    L37:
        r60 = false;
        goto L38
    L14:
        if (r10.a() == false) goto L16;
        r11 = true;
        goto L17
    L8:
        if (r4.R == false) goto L10;
        r9 = true;
        goto L11
    }
}
