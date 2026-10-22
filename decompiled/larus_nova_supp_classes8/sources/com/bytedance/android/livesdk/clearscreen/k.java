package com.bytedance.android.livesdk.clearscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.c31;
import com.bytedance.android.livesdk.config.dr;
import com.bytedance.android.livesdk.config.sg0;
import com.bytedance.android.livesdk.config.tp0;
import com.bytedance.android.livesdk.config.vs;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class k implements y {
    public static final /* synthetic */ int K = 0;
    public b A;
    public float B;
    public float C;
    public float D;
    public float E;
    public final CompositeDisposable F;
    public boolean G;
    public boolean H;
    public final Lazy I;
    public final DataCenter J;
    public final float a;
    public final float b;
    public float c;
    public double d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final WeakReference<View> j;
    public WeakReference<View> k;
    public final WeakReference<Context> l;
    public final ZoomType m;
    public WeakReference<LiveVerticalViewPager> n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public b y;
    public b z;

    public static final class a {
    }

    public final class b {
        public final int a;
        public final int b;

        public b(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a = -1;
            this.b = -1;
            this.a = r2.findPointerIndex(r2.getActionIndex());
            this.b = r2.getActionIndex();
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r6 == null) goto L7;
            com.bytedance.live.datacontext.m r7 = r6.isInZoom();
            if (r7 == null) goto L7;
            r7.setValue(Boolean.FALSE);
        L7:
            xs2.b.a().post(new r(false, this.a.m));
            this.a.r(false);
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ k a;

        public d(k r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r6 == null) goto L7;
            com.bytedance.live.datacontext.m r7 = r6.isInZoom();
            if (r7 == null) goto L7;
            r7.setValue(Boolean.FALSE);
        L7:
            xs2.b.a().post(new r(false, this.a.m));
            this.a.r(false);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ k a;
        public final /* synthetic */ float b;

        public e(k r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            DataCenter r0 = this.a.J;
            if (r0 == null) goto L5;
            r0.put("data_video_scale_value", Float.valueOf(this.b));
        L5:
            int r1 = k.K;
            Logger.d("GestureBaseBehavior", "scale DATA_VIDEO_SCALE_VALUE __________ = " + this.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean f() {
        return ((Boolean) this.I.getValue()).booleanValue();
    }

    public void q() {
    }

    public void t() {
        this.e = 0.0f;
        this.g = 0.0f;
        this.f = 0.0f;
        this.h = 0.0f;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.d = 0.0d;
    }

    public void u() {
        this.B = 0.0f;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        WeakReference<View> r1 = this.j;
        if (r1 == null) goto L17;
        View r2 = r1.get();
        if (r2 == null) goto L17;
        ViewPropertyAnimator r3 = r2.animate();
        if (r3 == null) goto L17;
        ViewPropertyAnimator r4 = r3.translationX(0.0f);
        if (r4 == null) goto L17;
        ViewPropertyAnimator r5 = r4.translationY(0.0f);
        if (r5 == null) goto L17;
        ViewPropertyAnimator r6 = r5.setDuration(200);
        if (r6 == null) goto L17;
        ViewPropertyAnimator r7 = r6.setListener(new c(this));
        if (r7 == null) goto L17;
        r7.start();
    L17:
        tp0 r8 = tp0.a;
        if (r8.getValue().booleanValue() == false) goto L34;
        WeakReference<View> r9 = this.k;
        if (r9 == null) goto L34;
        View r10 = r9.get();
        if (r10 == null) goto L34;
        ViewPropertyAnimator r11 = r10.animate();
        if (r11 == null) goto L34;
        ViewPropertyAnimator r12 = r11.translationX(0.0f);
        if (r12 == null) goto L34;
        ViewPropertyAnimator r13 = r12.translationY(0.0f);
        if (r13 == null) goto L34;
        ViewPropertyAnimator r14 = r13.setDuration(200);
        if (r14 == null) goto L34;
        ViewPropertyAnimator r15 = r14.setListener(new d(this));
        if (r15 == null) goto L34;
        r15.start();
    L34:
        x(1.0f);
        float r16 = this.s;
        float r17 = this.t;
        WeakReference<View> r18 = this.j;
        if (r18 == null) goto L39;
        View r19 = r18.get();
        if (r19 == null) goto L39;
        r19.setPivotX(r16);
    L39:
        WeakReference<View> r20 = this.j;
        if (r20 == null) goto L45;
        View r21 = r20.get();
        if (r21 == null) goto L45;
        r21.setPivotY(r17);
    L45:
        if (r8.getValue().booleanValue() == false) goto L47;
        v(this.w, this.x);
    L47:
        this.s = 0.0f;
        this.t = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    public static boolean n() {
        Integer r2 = null;
        if (sg0.a.getValue().booleanValue() == false) goto L11;
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.q r1 = com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).getPkService();
        if (r1 == null) goto L8;
        r2 = Integer.valueOf(r1.getPkState());
    L8:
        if (r2.intValue() == 0) goto L32;
        return true;
    L32:
        return false;
    L11:
        RoomContext.a r3 = RoomContext.Companion;
        RoomContext r7 = RoomContext.a.c(r3, null, 0, 3);
        if (r7 == null) goto L18;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L18;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L18;
        RoomLinkInfo r10 = r9.getLinkMicInfo();
    L19:
        if (r10 != null) goto L30;
        RoomContext r4 = RoomContext.a.c(r3, null, 0, 3);
        if (r4 == null) goto L33;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L34;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L35;
        Map r11 = r6.getLinkMap();
        if (r11 != null) goto L29;
        return false;
    L29:
        if (r11.containsKey(String.valueOf(1)) == true) goto L30;
        return false;
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    L30:
        return true;
    L18:
        r10 = null;
        goto L19
    }

    public final boolean l() {
        DataCenter r0 = this.J;
        Long r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.get("data_room", null);
    L6:
        if (r2 == null) goto L10;
        Map r3 = r2.getLinkMap();
        if (r3 == null) goto L10;
        r1 = (Long) r3.get(String.valueOf(7));
    L10:
        if (r1 == null) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean m() {
        DataCenter r0 = this.J;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        int r3 = jc1.k.n(IInteractService.class).getLinkMode();
        if (v.a(r3, 2) == false) goto L11;
    L16:
        return true;
    L11:
        if (v.a(r3, 8) == true) goto L16;
        if (v.a(r3, 32) == true) goto L16;
        if (v.a(r2, 512) == true) goto L16;
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    public void o() {
        HashMap r0 = new HashMap();
        Lazy r1 = ClearScreenHelper.a;
        String r2 = "0";
        if (ClearScreenHelper.h(this.J) == true) goto L5;
        String r3 = "0";
    L6:
        r0.put("is_under_screen_clear", r3);
        IUserService r4 = jc1.k.f(IUserService.class);
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L14;
        String r6 = r5.n();
        if (r6 == null) goto L14;
        r2 = r6;
    L14:
        r0.put("user_id", r2);
        ClearScreenLogUtils.a.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_pitch_enlarge", r0);
        return;
    L5:
        r3 = "1";
        goto L6
    }

    public final boolean k() {
        if (f() == false) goto L5;
        return false;
    L5:
        Boolean r4 = null;
        if (m() == true) goto L36;
        if (l() == true) goto L36;
        if (n() == true) goto L36;
        if (vs.a.getValue().booleanValue() == false) goto L60;
        DataCenter r0 = this.J;
        if (r0 != null) goto L17;
        return false;
    L17:
        if (z.m(r0, true) != true) goto L62;
        DataCenter r1 = this.J;
        if (r1 == null) goto L21;
        IRoom r2 = (IRoom) r1.get("data_room", null);
    L22:
        if (r2 != null) goto L24;
    L26:
        boolean r3 = false;
    L27:
        if (r3 == true) goto L63;
        DataCenter r5 = this.J;
        if (r5 == null) goto L32;
        r4 = (Boolean) r5.get("data_is_anchor", Boolean.FALSE);
    L32:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L64;
        return true;
    L64:
        return false;
    L63:
        return false;
    L24:
        if (r2.isLiveTypeAudio() != true) goto L26;
        r3 = true;
        goto L27
    L21:
        r2 = null;
        goto L22
    L62:
        return false;
    L60:
        return false;
    L36:
        if (tp0.a.getValue().booleanValue() == true) goto L38;
        return false;
    L38:
        if (vs.a.getValue().booleanValue() == false) goto L66;
        DataCenter r6 = this.J;
        if (r6 != null) goto L42;
        return false;
    L42:
        if (z.m(r6, true) != true) goto L68;
        DataCenter r7 = this.J;
        if (r7 == null) goto L46;
        IRoom r8 = (IRoom) r7.get("data_room", null);
    L47:
        if (r8 != null) goto L49;
    L51:
        boolean r9 = false;
    L52:
        if (r9 == true) goto L69;
        DataCenter r10 = this.J;
        if (r10 == null) goto L57;
        r4 = (Boolean) r10.get("data_is_anchor", Boolean.FALSE);
    L57:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L70;
        return true;
    L70:
        return false;
    L69:
        return false;
    L49:
        if (r8.isLiveTypeAudio() != true) goto L51;
        r9 = true;
        goto L52
    L46:
        r8 = null;
        goto L47
    L68:
        return false;
    L66:
        return false;
    }

    public void s() {
        t();
        u();
    }

    public static double z(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getPointerCount() != 2) goto L5;
        float r1 = r4.getX(0) - r4.getX(1);
        float r0 = r4.getY(0) - r4.getY(1);
        return Math.sqrt((r1 * r1) + (r0 * r0));
    L5:
        return 0.0d;
    }

    public boolean a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        return false;
    }

    public final void d(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        WeakReference<LiveVerticalViewPager> r0 = this.n;
        if (r0 != null) goto L5;
    L6:
        ViewGroup r3 = e(r2);
        if ((r3 instanceof LiveVerticalViewPager) == false) goto L9;
        this.n = new WeakReference(r3);
    L9:
        Unit r4 = Unit.INSTANCE;
        return;
    L5:
        if (r0.get() == null) goto L6;
    }

    public final ViewGroup e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        if ((r2 instanceof LiveVerticalViewPager) == true) goto L5;
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L9;
        return null;
    L9:
        return e((View) r3);
    L5:
        return (ViewGroup) r2;
    }

    public void h(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        int r0 = r8.getPointerCount();
        if (r0 == 2) goto L5;
    L28:
        if (r0 == 1) goto L30;
        return;
    L30:
        if (this.p == true) goto L32;
        return;
    L32:
        if (this.G == true) goto L39;
        float r1 = r8.getX();
        float r9 = r8.getY();
        y((r1 - this.B) + this.D, (r9 - this.C) + this.E);
        this.r = true;
        return;
    L39:
        return;
    L5:
        if (this.p == false) goto L28;
        if (this.o == false) goto L28;
        if (this.G == true) goto L28;
        b r2 = this.y;
        int r3 = 0;
        if (r2 == null) goto L13;
        int r4 = r2.b;
    L14:
        float r5 = r8.getX(r4);
        b r6 = this.y;
        if (r6 == null) goto L17;
        r3 = r6.b;
    L17:
        float r7 = r8.getY(r3);
        b r10 = this.z;
        if (r10 == null) goto L20;
        int r11 = r10.b;
    L21:
        float r12 = r8.getX(r11);
        b r13 = this.z;
        if (r13 == null) goto L24;
        int r14 = r13.b;
    L25:
        float r15 = r8.getY(r14);
        float r16 = r5 - this.e;
        float r17 = r12 - this.f;
        float r18 = 2;
        float r19 = (r16 / r18) + (r17 / r18);
        float r20 = ((r7 - this.g) / r18) + ((r15 - this.h) / r18);
        y(r19, r20);
        w(r19, r20);
        this.r = true;
        double r21 = z(r8) - this.d;
        if (r21 == 0.0d) goto L35;
        this.q = true;
        x(Math.max(this.b, Math.min(this.a, (float) ((((double) 1) + (r21 / ((double) s1.y()))) * ((double) this.c)))));
        return;
    L35:
        return;
    L24:
        r14 = 1;
        goto L25
    L20:
        r11 = 1;
        goto L21
    L13:
        r4 = 0;
        goto L14
    }

    public void i(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getPointerCount() == 2) goto L5;
        return;
    L5:
        if (this.G == true) goto L44;
        int r0 = 0;
        this.o = false;
        b r1 = this.y;
        if (r1 != null) goto L9;
    L11:
        this.A = this.y;
    L12:
        b r2 = this.A;
        if (r2 == null) goto L15;
        int r3 = r2.a;
    L16:
        this.B = r4.getX(r4.findPointerIndex(r3));
        b r5 = this.A;
        if (r5 == null) goto L19;
        r0 = r5.a;
    L19:
        this.C = r4.getY(r4.findPointerIndex(r0));
        WeakReference<View> r6 = this.j;
        float r7 = 0.0f;
        if (r6 == null) goto L24;
        View r8 = r6.get();
        if (r8 == null) goto L24;
        float r9 = r8.getTranslationX();
    L25:
        this.D = r9;
        WeakReference<View> r10 = this.j;
        if (r10 == null) goto L30;
        View r11 = r10.get();
        if (r11 == null) goto L30;
        r7 = r11.getTranslationY();
    L30:
        this.E = r7;
        if (tp0.a.getValue().booleanValue() == false) goto L45;
        WeakReference<View> r12 = this.k;
        if (r12 == null) goto L37;
        View r13 = r12.get();
        if (r13 == null) goto L37;
        r13.getTranslationX();
    L37:
        WeakReference<View> r14 = this.k;
        if (r14 == null) goto L46;
        View r15 = r14.get();
        if (r15 == null) goto L47;
        r15.getTranslationY();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L24:
        r9 = 0.0f;
        goto L25
    L15:
        r3 = 0;
        goto L16
    L9:
        if (r1.a != r4.getPointerId(r4.getActionIndex())) goto L11;
        this.A = this.z;
        goto L12
    }

    public void j(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.G = false;
        if (this.q == true) goto L13;
        boolean r0 = this.r;
        if (r0 == true) goto L13;
        if (this.p == false) goto L14;
        if (r0 == true) goto L14;
        if (c31.a.getValue().booleanValue() == false) goto L14;
        s();
    L14:
        this.H = false;
        return;
    L13:
        s();
        goto L14
    }

    public void p(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "gestureDetectLayout");
        d(r6);
        r(true);
        Lazy r0 = ClearScreenHelper.a;
        if (ClearScreenHelper.h(this.J) == false) goto L11;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.isInZoom();
        if (r2 == null) goto L9;
        r2.setValue(Boolean.TRUE);
    L9:
        xs2.b.a().post(new r(true, this.m));
        return;
    }

    public final void r(boolean r2) {
        WeakReference<LiveVerticalViewPager> r0 = this.n;
        if (r0 == null) goto L8;
        LiveVerticalViewPager r1 = r0.get();
        if (r1 == null) goto L9;
        r1.requestDisallowInterceptTouchEvent(r2);
        return;
    L9:
        return;
    }

    public void x(float r11) {
        WeakReference<View> r4 = this.j;
        if (r4 == null) goto L7;
        View r5 = r4.get();
        if (r5 == null) goto L7;
        r5.setScaleX(r11);
    L7:
        WeakReference<View> r6 = this.j;
        if (r6 == null) goto L13;
        View r7 = r6.get();
        if (r7 == null) goto L13;
        r7.setScaleY(r11);
    L13:
        if (tp0.a.getValue().booleanValue() == false) goto L24;
        WeakReference<View> r8 = this.k;
        if (r8 == null) goto L19;
        View r9 = r8.get();
        if (r9 == null) goto L19;
        r9.setScaleX(r11);
    L19:
        WeakReference<View> r10 = this.k;
        if (r10 == null) goto L24;
        View r12 = r10.get();
        if (r12 == null) goto L24;
        r12.setScaleY(r11);
    L24:
        Lazy r13 = ClearScreenHelper.a;
        if (ClearScreenHelper.h(this.J) == false) goto L27;
    L59:
        Logger.i("GestureBaseBehavior", "setScale scale = " + r11);
        return;
    L27:
        if (k() == false) goto L59;
        if (dr.a.getValue().booleanValue() == false) goto L59;
        WeakReference<Context> r14 = this.l;     // Catch: Throwable -> L58
        if (r14 == null) goto L59;
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L58
        Context r15 = r14.get();     // Catch: Throwable -> L58
        if (r15 == null) goto L59;
        if ((r15 instanceof Activity) == false) goto L59;
        if (this.i == 0.0f) goto L39;
        jc1.k.n(ILiveBrightnessService.class).adjustWindowBright((Activity) r15, r11 / 3);     // Catch: Throwable -> L58
    L46:
        Logger.i("GestureBaseBehavior", "adjustWindowBright scale = " + r11 + " + initValue = " + this.i);     // Catch: Throwable -> L58
        if (r11 != 1.0f) goto L54;
        jc1.k.n(ILiveBrightnessService.class).setBright((Activity) r15, this.i);     // Catch: Throwable -> L58
        Logger.i("GestureBaseBehavior", "reset adjustWindowBright scale = " + r11 + " + initValue = " + this.i);     // Catch: Throwable -> L58
        StringBuilder r0 = new StringBuilder("scale __________ = ");     // Catch: Throwable -> L58
        r0.append(r11);     // Catch: Throwable -> L58
        Logger.d("GestureBaseBehavior", r0.toString());     // Catch: Throwable -> L58
        WeakReference<View> r1 = this.j;     // Catch: Throwable -> L58
        if (r1 == null) goto L53;
        View r2 = r1.get();     // Catch: Throwable -> L58
        if (r2 == null) goto L53;
        r2.post(new e(this, r11));     // Catch: Throwable -> L58
    L53:
        this.i = 0.0f;     // Catch: Throwable -> L58
        jc1.k.n(ILiveBrightnessService.class).resetSystemBright((Activity) r15);     // Catch: Throwable -> L58
        goto L59
    L54:
        DataCenter r3 = this.J;     // Catch: Throwable -> L58
        if (r3 == null) goto L59;
        r3.put("data_video_scale_value", Float.valueOf(r11));     // Catch: Throwable -> L58
        goto L59
    L39:
        jc1.k.n(ILiveBrightnessService.class).resetSystemBright((Activity) r15);     // Catch: Throwable -> L58
        Float r16 = jc1.k.n(ILiveBrightnessService.class).adjustWindowBright((Activity) r15, r11 / 3);     // Catch: Throwable -> L58
        if (r16 == null) goto L42;
        float r17 = r16.floatValue();     // Catch: Throwable -> L58
    L43:
        this.i = r17;     // Catch: Throwable -> L58
        if (r17 != (-1.0f)) goto L46;
        return;
    L42:
        r17 = 0.0f;
    L58:
        Logger.e("GestureBaseBehavior", "adjustWindowBright error mContext = " + this.l);
        goto L59
    }

    public boolean b(ViewGroup r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        return false;
    }

    public final boolean c(ViewGroup r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r3, "ev");
        y.a.a(r2, r3);
        return false;
    }

    public boolean g(MotionEvent r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "gestureDetectLayout");
        int r0 = r6.getPointerCount();
        if (r0 != 2) goto L76;
        if (this.G == true) goto L76;
        if (this.q == false) goto L9;
    L73:
        s();
        return true;
    L9:
        if (this.r == true) goto L73;
        this.z = new b(r6);
        p(r7);
        WeakReference<View> r8 = this.j;
        float r1 = 0.0f;
        if (r8 == null) goto L16;
        View r9 = r8.get();
        if (r9 == null) goto L16;
        float r10 = r9.getPivotX();
    L17:
        this.s = r10;
        WeakReference<View> r11 = this.j;
        if (r11 == null) goto L22;
        View r12 = r11.get();
        if (r12 == null) goto L22;
        float r13 = r12.getPivotY();
    L23:
        this.t = r13;
        if (tp0.a.getValue().booleanValue() == false) goto L37;
        WeakReference<View> r14 = this.k;
        if (r14 == null) goto L30;
        View r15 = r14.get();
        if (r15 == null) goto L30;
        float r16 = r15.getPivotX();
    L31:
        this.w = r16;
        WeakReference<View> r17 = this.k;
        if (r17 == null) goto L36;
        View r18 = r17.get();
        if (r18 == null) goto L36;
        r1 = r18.getPivotY();
    L36:
        this.x = r1;
    L30:
        r16 = 0.0f;
    L37:
        b r19 = this.y;
        if (r19 == null) goto L40;
        int r20 = r19.b;
    L41:
        this.e = r6.getX(r20);
        b r21 = this.y;
        if (r21 == null) goto L44;
        int r22 = r21.b;
    L45:
        this.g = r6.getY(r22);
        b r23 = this.z;
        if (r23 == null) goto L48;
        int r24 = r23.b;
    L49:
        this.f = r6.getX(r24);
        b r25 = this.z;
        if (r25 == null) goto L52;
        int r26 = r25.b;
    L53:
        this.h = r6.getY(r26);
        this.d = z(r6);
        this.o = true;
        this.p = true;
        ClearScreenLogUtils.Companion r27 = ClearScreenLogUtils.a;
        HashMap r28 = new HashMap();
        r27.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_enlarge_under_screen_clear", r28);
        o();
        float r29 = 2;
        this.u = (this.e + this.f) / r29;
        this.v = (this.g + this.h) / r29;
        WeakReference<View> r30 = this.j;
        if (r30 == null) goto L58;
        View r31 = r30.get();
        if (r31 == null) goto L58;
        r31.setPivotX(this.u);
    L58:
        WeakReference<View> r32 = this.j;
        if (r32 == null) goto L63;
        View r33 = r32.get();
        if (r33 == null) goto L63;
        r33.setPivotY(this.v);
    L63:
        WeakReference<View> r34 = this.k;
        if (r34 == null) goto L68;
        View r35 = r34.get();
        if (r35 == null) goto L68;
        r35.setPivotX(this.u);
    L68:
        WeakReference<View> r36 = this.k;
        if (r36 == null) goto L82;
        View r37 = r36.get();
        if (r37 == null) goto L82;
        r37.setPivotY(this.v);
    L82:
        return false;
    L52:
        r26 = 1;
        goto L53
    L48:
        r24 = 1;
        goto L49
    L44:
        r22 = 0;
        goto L45
    L40:
        r20 = 0;
    L22:
        r13 = 0.0f;
    L16:
        r10 = 0.0f;
    L76:
        if (r0 < 3) goto L82;
        this.G = true;
        if (this.q == false) goto L80;
    L81:
        s();
        goto L82
    L80:
        if (this.r == false) goto L82;
        goto L81
    }

    public boolean onTouchEvent(ViewGroup r7, MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r7, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r8, "event");
        Lazy r0 = ClearScreenHelper.a;
        if (ClearScreenHelper.h(this.J) == true) goto L8;
        if (k() == true) goto L8;
        return false;
    L8:
        if (f() == false) goto L11;
        return false;
    L11:
        if (r8.getPointerCount() <= 2) goto L14;
        s();
        return false;
    L14:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.J, 0, 2);
        if (r1 == null) goto L21;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L21;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L21;
        boolean r4 = r3.isVrRoom();
    L23:
        if (r4 == false) goto L25;
    L28:
        boolean r5 = true;
    L29:
        if (r5 == false) goto L79;
        return false;
    L79:
        int r6 = r8.getAction() & 255;     // Catch: IllegalArgumentException -> L50
        if (r6 == 0) goto L48;
        if (r6 == 1) goto L47;
        if (r6 != 2) goto L36;
        h(r8);     // Catch: IllegalArgumentException -> L50
    L78:
    L52:
        if (r5 == false) goto L54;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r9 = LiveVrContext.c.a();
        if (r9 == null) goto L66;
        com.bytedance.live.datacontext.m r10 = r9.isVrSensorOpen();
        if (r10 == null) goto L66;
        Boolean r11 = (Boolean) r10.getValue();
        if (r11 == null) goto L66;
        boolean r12 = r11.booleanValue();
    L67:
        if (r5 == false) goto L70;
        if (r12 == true) goto L70;
        boolean r13 = false;
    L71:
        if (r13 == true) goto L73;
        return false;
    L73:
        if (this.r == false) goto L75;
    L76:
        return true;
    L75:
        if (this.q == true) goto L76;
        return false;
    L70:
        r13 = true;
    L66:
        r12 = true;
        goto L67
    L54:
        if (this.r == false) goto L56;
    L57:
        return true;
    L56:
        if (this.q == true) goto L57;
        return false;
    L36:
        if (r6 == 3) goto L47;
        if (r6 == 5) goto L44;
        if (r6 != 6) goto L78;
        i(r8);     // Catch: IllegalArgumentException -> L50
        goto L78
    L44:
        if (g(r8, r7) == false) goto L78;
        return true;
    L47:
        j(r8);     // Catch: IllegalArgumentException -> L50
        goto L78
    L48:
        this.y = new b(r8);     // Catch: IllegalArgumentException -> L50
    L50:
        e = move-exception;
        ALogger.e("GestureBaseBehavior", "IllegalArgumentException error: " + e.toString());
        goto L52
    L25:
        if (VrUtils.v(this.J) == true) goto L28;
        r5 = false;
    L21:
        r4 = false;
        goto L23
    }

    public final void v(float r2, float r3) {
        WeakReference<View> r0 = this.k;
        if (r0 == null) goto L7;
        View r1 = r0.get();
        if (r1 == null) goto L7;
        r1.setPivotX(r2);
    L7:
        WeakReference<View> r4 = this.k;
        if (r4 == null) goto L13;
        View r5 = r4.get();
        if (r5 == null) goto L14;
        r5.setPivotY(r3);
        return;
    L14:
        return;
    }

    public void w(float r2, float r3) {
        if (tp0.a.getValue().booleanValue() == false) goto L15;
        WeakReference<View> r0 = this.k;
        if (r0 == null) goto L9;
        View r1 = r0.get();
        if (r1 == null) goto L9;
        r1.setTranslationX(r2);
    L9:
        WeakReference<View> r4 = this.k;
        if (r4 == null) goto L16;
        View r5 = r4.get();
        if (r5 == null) goto L17;
        r5.setTranslationY(r3);
        return;
    L17:
        return;
    L16:
        return;
    }

    public void y(float r2, float r3) {
        WeakReference<View> r0 = this.j;
        if (r0 == null) goto L7;
        View r1 = r0.get();
        if (r1 == null) goto L7;
        r1.setTranslationX(r2);
    L7:
        WeakReference<View> r4 = this.j;
        if (r4 == null) goto L13;
        View r5 = r4.get();
        if (r5 == null) goto L14;
        r5.setTranslationY(r3);
        return;
    L14:
        return;
    }

    public k(LivePlayerView r2, DataCenter r3, Context r4, View r5, ZoomType r6) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "zoomType");
        this.J = r3;
        this.a = 4.0f;
        this.b = 1.0f;
        this.c = 1.1f;
        this.m = ZoomType.NORMAL;
        CompositeDisposable r7 = new CompositeDisposable();
        this.F = r7;
        this.j = new WeakReference(r2);
        if (r5 == null) goto L5;
        this.k = new WeakReference(r5);
    L5:
        this.l = new WeakReference(r4);
        this.m = r6;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L14;
        com.bytedance.live.datacontext.m r9 = r8.getPlayerInInteractMode();
        if (r9 == null) goto L14;
        Observable r10 = r9.a();
        if (r10 == null) goto L14;
        Disposable r11 = r10.subscribe(new j(this));
        if (r11 == null) goto L14;
        RxUtilKt.c(r11, r7);
    L14:
        this.I = LazyKt.lazy(new GestureBaseBehavior$disableScale$2(this));
    }
}
