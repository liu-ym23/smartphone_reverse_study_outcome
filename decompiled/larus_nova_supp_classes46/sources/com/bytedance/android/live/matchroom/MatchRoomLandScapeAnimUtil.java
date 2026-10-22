package com.bytedance.android.live.matchroom;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.bmmt.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import j40.a1;
import j40.e1;
import j40.i4;
import j40.y0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MatchRoomLandScapeAnimUtil {
    public static float A;
    public static float B;
    public static float C;
    public static final g D = null;
    public static final MatchRoomLandScapeAnimUtil E = null;
    public static boolean a;
    public static LinkedHashMap<String, com.bytedance.android.live.matchroom.a> b;
    public static int c;
    public static PublishSubject<Integer> d;
    public static AnimatorSet e;
    public static com.bytedance.android.live.matchroom.a f;
    public static final PublishSubject<Object> g = null;
    public static final PublishSubject<Object> h = null;
    public static Boolean i;
    public static Disposable j;
    public static int k;
    public static WeakReference<com.bytedance.android.live.matchroom.d> l;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final int o = 0;
    public static final d p = null;
    public static WeakReference<View> q;
    public static com.bytedance.android.live.matchroom.e r;
    public static final Rect s = null;
    public static long t;
    public static WeakReference<FragmentActivity> u;
    public static float v;
    public static float w;
    public static final Lazy x = null;
    public static boolean y;
    public static final Map<String, com.bytedance.android.live.matchroom.g> z = null;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;

        public a(boolean r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L21;
            float r5 = ((Float) r4).floatValue();
            if (Float.isNaN(r5) == false) goto L7;
            return;
        L7:
            if (Float.isInfinite(r5) == true) goto L23;
            boolean r0 = MatchRoomLandScapeAnimUtil.a;
            WeakReference<com.bytedance.android.live.matchroom.d> r1 = MatchRoomLandScapeAnimUtil.l;
            if (r1 == null) goto L18;
            com.bytedance.android.live.matchroom.d r2 = r1.get();
            if (r2 == null) goto L18;
            if (this.a == true) goto L16;
            r2 = null;
        L16:
            if (r2 == null) goto L18;
            r2.c(r5, r5);
            return;
        L18:
            this.b.setScaleX(r5);
            this.b.setScaleY(r5);
            Unit r6 = Unit.INSTANCE;
            return;
        L23:
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ALogger.i("MatchRoomAnimUtil", "onAnimationCancel isCancel:" + this.a);
            this.a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.a == true) goto L20;
            boolean r4 = MatchRoomLandScapeAnimUtil.a;
            if (this.b == false) goto L7;
            int r5 = 2;
        L8:
            MatchRoomLandScapeAnimUtil.u(r5);
            if (this.b == true) goto L17;
            WeakReference<View> r6 = MatchRoomLandScapeAnimUtil.q;
            if (r6 == null) goto L15;
            View r7 = r6.get();
            if (r7 == null) goto L15;
            r7.getGlobalVisibleRect(MatchRoomLandScapeAnimUtil.s);
        L15:
            ALogger.i("MatchRoomAnimUtil", "onAnimationEnd refresh playerContainerShowStateRect:[" + MatchRoomLandScapeAnimUtil.s + ']');
        L17:
            if (MatchRoomLandScapeAnimUtil.c != 0) goto L20;
            this.c.setClipToOutline(false);
            goto L20
        L7:
            r5 = 0;
        L20:
            if (((d51) a1.a.getValue()).m() == false) goto L23;
            xs2.b.a().post(new zt2.a(!this.b));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            boolean r4 = MatchRoomLandScapeAnimUtil.a;
            if (this.b == false) goto L5;
            int r5 = 1;
        L6:
            MatchRoomLandScapeAnimUtil.u(r5);
            this.c.setOutlineProvider(new o());
            this.c.setClipToOutline(true);
            return;
        L5:
            r5 = 3;
            goto L6
        }

        public b(boolean r1, View r2, String r3) {
            this.b = r1;
            this.c = r2;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L13;
            float r4 = ((Float) r3).floatValue();
            if (Float.isNaN(r4) == true) goto L14;
            boolean r0 = MatchRoomLandScapeAnimUtil.a;
            WeakReference<com.bytedance.android.live.matchroom.d> r1 = MatchRoomLandScapeAnimUtil.l;
            if (r1 == null) goto L15;
            com.bytedance.android.live.matchroom.d r5 = r1.get();
            if (r5 == null) goto L16;
            r5.a(r4);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d<T> implements Observer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
            MatchRoomLandScapeAnimUtil.g.onNext(new Object());
            return;
        L5:
            MatchRoomLandScapeAnimUtil.h.onNext(new Object());
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Map.Entry c;
        public final /* synthetic */ List d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == true) goto L6;
            this.b.setClipToOutline(true);
            ALogger.i("MatchRoomAnimUtil", "show end clipToOutline[true] onAnimationEnd for " + ((String) this.c.getKey()));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.setClipToOutline(true);
        }

        public e(View r1, Map.Entry r2, List r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Dialog d;

        public f(String r1, int r2, View r3, Dialog r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            com.bytedance.android.live.matchroom.e r0 = MatchRoomLandScapeAnimUtil.r;
            if (r0 == null) goto L5;
            r0.a(true);
        L5:
            xs2.b.a().post(new zt2.a(false));
            if (MatchRoomLandScapeAnimUtil.y == true) goto L8;
        L10:
            boolean r1 = false;
        L11:
            xs2.b.a().post(new w0(false, r1));
            int r2 = this.b;
            if (r2 > 0) goto L15;
            r2 = this.c.getMeasuredWidth();
        L15:
            float r3 = r2 * 1.0f;
            Animator r4 = MatchRoomLandScapeAnimUtil.h(this.c, true, r3, 0.0f, this.a);
            ObjectAnimator r5 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f});
            r5.setDuration(400);
            r5.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.matchroom.a r6 = new com.bytedance.android.live.matchroom.a();
            String r7 = this.a;
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r6.a = r7;
            r6.b = (int) r3;
            this.d.hashCode();
            if (MatchRoomLandScapeAnimUtil.b.get(r6.a) == null) goto L18;
            ALogger.i("MatchRoomAnimUtil", "---- addDialog2Map: map already has key:" + r6.a + ", replace ----");
        L18:
            MatchRoomLandScapeAnimUtil.b.put(r6.a, r6);
            ALogger.i("MatchRoomAnimUtil", "---- addDialog2Map: add [" + r6.a + "] to map, now size:" + MatchRoomLandScapeAnimUtil.b.size() + " ----");
            if (((d51) a1.a.getValue()).f() == false) goto L34;
            LinkedHashMap<String, com.bytedance.android.live.matchroom.a> r8 = MatchRoomLandScapeAnimUtil.b;
            if (r8 == null) goto L34;
            if (r8.size() <= 0) goto L34;
            Iterator<Map.Entry<String, com.bytedance.android.live.matchroom.a>> r9 = MatchRoomLandScapeAnimUtil.b.entrySet().iterator();
            boolean r10 = true;
        L26:
            if (r9.hasNext() == false) goto L35;
            Map.Entry<String, com.bytedance.android.live.matchroom.a> r11 = r9.next();
            if (r11 == null) goto L26;
            if (r11.getValue() == null) goto L26;
            if (r11.getValue().b <= r6.b) goto L26;
            r10 = false;
        L35:
            if (r10 == false) goto L37;
            ALogger.i("MatchRoomAnimUtil", "showdialog canShowAnim 11111");
            boolean r12 = MatchRoomLandScapeAnimUtil.a;
            MatchRoomLandScapeAnimUtil.m(r6, CollectionsKt.listOf(new Animator[]{r4, r5}));
            return;
        L37:
            ALogger.i("MatchRoomAnimUtil", "showdialog enablePlayerScaleBugfixV2 22222222");
            if (((d51) a1.a.getValue()).g() == false) goto L51;
            List r13 = CollectionsKt.listOf(new Animator[]{r4, r5});
            boolean r14 = MatchRoomLandScapeAnimUtil.a;
            AnimatorSet r15 = new AnimatorSet();
            MatchRoomLandScapeAnimUtil.e = r15;
            r15.playTogether(r13);
            MatchRoomLandScapeAnimUtil.e.start();
            ALogger.i("MatchRoomAnimUtil", "showdialog enablePlayerScaleBugfixV2 333333");
            return;
        L51:
            return;
        L34:
            r10 = true;
            goto L35
        L8:
            if (((Boolean) y0.a.getValue()).booleanValue() == false) goto L10;
            r1 = true;
            goto L11
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

    public static final class g implements ViewTreeObserver.OnWindowFocusChangeListener {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r3) {
            if (MatchRoomLandScapeAnimUtil.a == true) goto L5;
            return;
        L5:
            ALogger.i("MatchRoomAnimUtil", "window focus change, current:" + r3);
            MatchRoomLandScapeAnimUtil.i = Boolean.valueOf(r3);
            if (r3 == true) goto L8;
            return;
        L8:
            if (MatchRoomLandScapeAnimUtil.c == 0) goto L12;
            MatchRoomLandScapeAnimUtil.b();
            return;
        }
    }

    public MatchRoomLandScapeAnimUtil() {
    }

    public static String A(int r1) {
        if (r1 != 0) goto L4;
        return "ANIM_STATE_HIDE";
    L4:
        if (r1 != 1) goto L6;
        return "ANIM_STATE_RUNNING_SHOW";
    L6:
        if (r1 != 2) goto L8;
        return "ANIM_STATE_SHOW";
    L8:
        if (r1 == 3) goto L10;
        return "UNKNOWN";
    L10:
        return "ANIM_STATE_RUNNING_HIDE";
    }

    static {
        E = new MatchRoomLandScapeAnimUtil();
        b = new LinkedHashMap();
        d = PublishSubject.create();
        e = new AnimatorSet();
        g = PublishSubject.create();
        h = PublishSubject.create();
        m = LazyKt.lazy(MatchRoomLandScapeAnimUtil$landDialogDefaultWidth$2.INSTANCE);
        n = LazyKt.lazy(MatchRoomLandScapeAnimUtil$animStatePaddingRight$2.INSTANCE);
        o = s1.f(34.0f);
        p = d.a;
        s = new Rect();
        v = 1.0f;
        w = 1.0f;
        x = LazyKt.lazy(MatchRoomLandScapeAnimUtil$pictureTypeOpt$2.INSTANCE);
        z = new LinkedHashMap();
        A = 1.0f;
        D = g.a;
    }

    public static final void b() {
        MatchRoomLandScapeAnimUtil r0 = E;
        ALogger.w("MatchRoomAnimUtil", "start focusFallBack Count, currentWindowFocusState = " + i + ", mState = " + A(c) + ", fallBackCount = " + k);
        if (Intrinsics.areEqual(i, Boolean.FALSE) == true) goto L5;
    L10:
        Boolean r1 = i;
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r4) == false) goto L19;
        if (c != 0) goto L19;
        Disposable r2 = j;
        if (r2 == null) goto L17;
        r2.dispose();
    L17:
        k = 0;
        return;
    L19:
        if (Intrinsics.areEqual(i, r4) == true) goto L21;
        return;
    L21:
        if (c == 0) goto L30;
        int r3 = k;
        if (r3 < 3) goto L25;
        ALogger.e("MatchRoomAnimUtil", "startFallBackCount do fallback !!!!");
        l(r0, null, false, null, 15);
        b.clear();
        k = 0;
        n("dialog_hide_fallback", "");
        return;
    L25:
        k = r3 + 1;
        j = Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(n.a);
        return;
    L30:
        return;
    L5:
        if (c == 0) goto L10;
        Disposable r5 = j;
        if (r5 == null) goto L9;
        r5.dispose();
    L9:
        k = 0;
    }

    public static boolean d() {
        if (((d51) a1.a.getValue()).f() == false) goto L8;
        int r0 = c;
        if (r0 != 1) goto L10;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while current state:".concat(A(r0)));
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public static void o() {
        if (a == true) goto L5;
        return;
    L5:
        if (c != 2) goto L23;
        WeakReference<View> r0 = q;
        if (r0 == null) goto L19;
        View r1 = r0.get();
        if (r1 == null) goto L20;
        ALogger.i("MatchRoomAnimUtil", "receive onPlayerFirstFrameRefresh");
        Rect r3 = s;
        int r4 = r3.right - r3.left;
        int r5 = r1.getRight() - r1.getLeft();
        if (Math.abs(r4 - r5) <= 10) goto L16;
        int r2 = (r5 - r4) / 2;
        r3.left -= r2;
        r3.right += r2;
        com.bytedance.android.live.matchroom.a r6 = f;
        if (r6 == null) goto L21;
        m(r6, CollectionsKt.emptyList());
        ALogger.i("MatchRoomAnimUtil", "player position change after firstFrame(" + r4 + " -> " + r5 + "), reset and doDialogShowAnim");
        return;
    L21:
        return;
    L16:
        ALogger.i("MatchRoomAnimUtil", "player position not change, skip");
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void r() {
        WeakReference<com.bytedance.android.live.matchroom.d> r0 = l;
        if (r0 == null) goto L12;
        com.bytedance.android.live.matchroom.d r1 = r0.get();
        if (r1 == null) goto L7;
        r1.reset();
    L7:
        WeakReference<View> r2 = q;
        if (r2 == null) goto L17;
        View r3 = r2.get();
        if (r3 == null) goto L17;
        r3.setAlpha(1.0f);
    L17:
        Iterator r4 = ((LinkedHashMap) z).entrySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L26;
        com.bytedance.android.live.matchroom.g r5 = (com.bytedance.android.live.matchroom.g) ((Map.Entry) r4.next()).getValue();
        WeakReference<View> r6 = r5.a;
        if (r6 == null) goto L23;
        View r7 = r6.get();
    L24:
        if (r7 == null) goto L19;
        r7.setScaleX(r5.c);
        r7.setScaleY(r5.c);
        r7.setTranslationX(r5.b);
        goto L19
    L23:
        r7 = null;
        goto L24
    L26:
        return;
    L12:
        WeakReference<View> r8 = q;
        if (r8 == null) goto L17;
        View r9 = r8.get();
        if (r9 == null) goto L17;
        r9.setAlpha(1.0f);
        r9.setTranslationX(0.0f);
        r9.setTranslationY(0.0f);
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        goto L17
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void p(long r5) {
        if (t != r5) goto L5;
    L8:
        ALogger.w("MatchRoomAnimUtil", BuildConfig.BUILD_TYPE);
        if (((Boolean) e1.a.getValue()).booleanValue() == true) goto L11;
        t(false);
        r();
    L14:
        u(0);
        q = null;
        ((LinkedHashMap) z).clear();
        e.cancel();
        e = new AnimatorSet();
        b.clear();
        r = null;
        com.bytedance.android.livesdk.f.d().a.removeObserver(p);
        if (((Boolean) i4.a.getValue()).booleanValue() == false) goto L31;
        WeakReference<FragmentActivity> r6 = u;
        if (r6 == null) goto L27;
        FragmentActivity r7 = r6.get();
        if (r7 == null) goto L27;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L27;
        View r9 = a(r8);
        if (r9 == null) goto L27;
        ViewTreeObserver r10 = r9.getViewTreeObserver();
        if (r10 == null) goto L27;
        r10.removeOnWindowFocusChangeListener(D);
    L27:
        Disposable r11 = j;
        if (r11 == null) goto L32;
        r11.dispose();
        return;
    L32:
        return;
    L31:
        return;
    L11:
        if (a == false) goto L14;
        t(false);
        goto L14
    L5:
        if (r5 == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "releaseRoomId :  nowRoomid = " + t + " ___ needreleaseRoomid = " + r5);
    }

    public static void q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (b.get(r3) != null) goto L6;
        ALogger.i("MatchRoomAnimUtil", "---- removeDialogFromMap: " + r3 + " has already remove, skip ---- ");
        return;
    L6:
        b.remove(r3);
        ALogger.i("MatchRoomAnimUtil", "---- removeDialogFromMap: remove [" + r3 + "], now size:" + b.size() + " ---- ");
    }

    public static void s(FragmentActivity r1) {
        u = new WeakReference(r1);
        if (((Boolean) i4.a.getValue()).booleanValue() == false) goto L16;
        WeakReference<FragmentActivity> r2 = u;
        if (r2 == null) goto L17;
        FragmentActivity r3 = r2.get();
        if (r3 == null) goto L18;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L19;
        View r5 = a(r4);
        if (r5 == null) goto L20;
        ViewTreeObserver r6 = r5.getViewTreeObserver();
        if (r6 == null) goto L21;
        r6.addOnWindowFocusChangeListener(D);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void t(boolean r2) {
        if (a == r2) goto L6;
        if (r2 == false) goto L6;
        d = PublishSubject.create();
    L6:
        a = r2;
        if (r2 == false) goto L9;
        b.clear();
        b = new LinkedHashMap();
        k = 0;
    L9:
        if (r2 == true) goto L12;
        r();
        k = 0;
        return;
    }

    public static void u(int r2) {
        ALogger.i("MatchRoomAnimUtil", "mState Change from " + A(c) + " to " + A(r2));
        c = r2;
        if (r2 != 0) goto L5;
        b.clear();
        ALogger.i("MatchRoomAnimUtil", "---- clear dialogMap cuz state Change ----");
    L5:
        d.onNext(Integer.valueOf(c));
    }

    public static void v(View r4) {
        WeakReference<View> r0 = q;
        Integer r2 = null;
        if (r0 != null) goto L5;
    L11:
        q = new WeakReference(r4);
        StringBuilder r1 = new StringBuilder("setPlayerContainer : ");
        if (r4 == null) goto L14;
        r2 = Integer.valueOf(r4.hashCode());
    L14:
        r1.append(r2);
        ALogger.i("MatchRoomAnimUtil", r1.toString());
        return;
    L5:
        if (r0.get() == null) goto L11;
        StringBuilder r3 = new StringBuilder("setPlayerContainer : skip set ");
        if (r4 == null) goto L10;
        r2 = Integer.valueOf(r4.hashCode());
    L10:
        r3.append(r2);
        ALogger.i("MatchRoomAnimUtil", r3.toString());
    }

    public static void w(com.bytedance.android.live.matchroom.e r3) {
        Integer r1 = null;
        if (r != null) goto L8;
        r = r3;
        StringBuilder r4 = new StringBuilder("setScaleCallback : ");
        com.bytedance.android.live.matchroom.e r0 = r;
        if (r0 == null) goto L7;
        r1 = Integer.valueOf(r0.hashCode());
    L7:
        r4.append(r1);
        ALogger.i("MatchRoomAnimUtil", r4.toString());
        return;
    L8:
        StringBuilder r5 = new StringBuilder("setScaleCallback : skip set ");
        com.bytedance.android.live.matchroom.e r2 = r;
        if (r2 == null) goto L11;
        r1 = Integer.valueOf(r2.hashCode());
    L11:
        r5.append(r1);
        ALogger.i("MatchRoomAnimUtil", r5.toString());
    }

    public final void j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r3, "key");
        k(r3, false, null);
    }

    public static void m(com.bytedance.android.live.matchroom.a r19, List r20) {
        f = r19;
        WeakReference<View> r1 = q;
        if (r1 == null) goto L5;
        View r2 = r1.get();
    L6:
        ArrayList r9 = new ArrayList();
        r9.addAll(r20);
        int r3 = r19.b;
        if (r3 > 0) goto L10;
        r3 = ((Number) m.getValue()).intValue();
    L10:
        WeakReference<FragmentActivity> r4 = u;
        if (r4 == null) goto L19;
        FragmentActivity r5 = r4.get();
        if (r5 == null) goto L19;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L19;
        View r7 = a(r6);
        if (r7 == null) goto L19;
        int r8 = r7.getWidth();
    L20:
        int r10 = (r8 - r3) - ((Number) n.getValue()).intValue();
        int r11 = o;
        int r12 = r10 - r11;
        if (r2 != null) goto L23;
        n("show_dialog_null", r19.a);
        ALogger.e("MatchRoomAnimUtil", "doDialogShowAnim failed, null playerView");
    L23:
        if (r2 != null) goto L25;
    L73:
        ALogger.i("MatchRoomAnimUtil", "start doDialogShowAnim,size = " + r9.size());
        if (c == 0) goto L76;
        ALogger.i("MatchRoomAnimUtil", "just before showAnim: now state:" + A(c) + ",cancel lastAnimator");
        e.cancel();
    L76:
        AnimatorSet r13 = new AnimatorSet();
        e = r13;
        r13.playTogether(r9);
        e.start();
        n("show_dialog", r19.a);
        return;
    L25:
        if (r2.getScaleX() < 1.0f) goto L28;
        A = r2.getScaleX();
        B = r2.getTranslationX();
        C = r2.getTranslationY();
    L28:
        if (c != 0) goto L30;
        Rect r14 = s;
        r2.getGlobalVisibleRect(r14);
        ALogger.i("MatchRoomAnimUtil", "doDialogShowAnim refresh playerContainerShowStateRect:[" + r14 + ']');
    L30:
        Ref.IntRef r15 = new Ref.IntRef();
        int r16 = r2.getMeasuredWidth();
        r15.element = r16;
        if (r16 != 0) goto L35;
        int r17 = r2.getWidth();
        r15.element = r17;
        if (r17 != 0) goto L35;
        Rect r18 = s;
        r15.element = r18.right - r18.left;
    L35:
        float r21 = r12;
        float r22 = (r21 / 2.0f) + r11;
        Rect r23 = s;
        float r110 = r22 - ((r23.width() / 2) + r23.left);
        float r111 = (r21 * 1.0f) / r15.element;
        ALogger.i("MatchRoomAnimUtil", "doDialogShowAnim, before crateAnimator\nanim params:fullWidth = " + r8 + ", transSize = " + r3 + ", originalWidth = " + r15.element + ", targetWidth = " + r12 + ", playerRect:" + r23 + "\ntranslationXDest = " + r110 + ", targetScale = " + r111);
        float r24 = r2.getTranslationX();
        String r25 = r19.a;
        if (r25 != null) goto L38;
        String r26 = "";
    L39:
        Animator r27 = g(r2, true, r24, r110, true, r26);
        Animator r28 = i(r2, true, r2.getTranslationY(), 0.0f);
        if (((Boolean) x.getValue()).booleanValue() == false) goto L42;
        boolean r29 = true;
        Animator r30 = e(r2, true, r2.getScaleX(), r111, r2.getScaleY(), r111);
        Animator r31 = r28;
        Animator r32 = r30;
    L43:
        r9.add(r27);
        r9.add(r31);
        r9.add(r32);
        Map<String, com.bytedance.android.live.matchroom.g> r33 = z;
        if ((r33.isEmpty() ^ r29) == false) goto L73;
        Iterator r34 = ((LinkedHashMap) r33).entrySet().iterator();
    L47:
        if (r34.hasNext() == false) goto L73;
        Map.Entry r35 = (Map.Entry) r34.next();
        com.bytedance.android.live.matchroom.g r36 = (com.bytedance.android.live.matchroom.g) r35.getValue();
        WeakReference<View> r37 = r36.a;
        if (r37 == null) goto L51;
        View r38 = r37.get();
    L52:
        if (r38 == null) goto L47;
        if (c != 0) goto L57;
        r36.b = r38.getTranslationX();
        r36.c = r38.getScaleX();
    L57:
        if (r36.d == false) goto L59;
        float r39 = ((r12 + 5) * 1.0f) / r15.element;
    L60:
        float r40 = r38.getTranslationX();
        String r112 = r19.a;
        if (r112 != null) goto L63;
        r112 = "";
    L63:
        Animator r41 = h(r38, r29, r40, r110, r112);
        Animator r42 = f(r38, r29, r38.getScaleX(), r39, false);
        if (r36.d == true) goto L68;
        if (r36.e == true) goto L68;
    L72:
        r9.add(r41);
        r9.add(r42);
        ALogger.i("MatchRoomAnimUtil", "add animator for " + ((String) r35.getKey()));
    L68:
        if (r36.e == false) goto L70;
        r38.setOutlineProvider(new o());
    L71:
        ALogger.i("MatchRoomAnimUtil", "add outlineProvider for " + ((String) r35.getKey()));
        r41.addListener(new e(r38, r35, r9));
        goto L72
    L70:
        r38.setOutlineProvider(new com.bytedance.android.live.matchroom.f(s));
        goto L71
    L59:
        r39 = r111;
        goto L60
    L51:
        r38 = null;
        goto L52
    L42:
        r31 = r28;
        r29 = true;
        r32 = f(r2, true, r2.getScaleX(), r111, true);
        goto L43
    L38:
        r26 = r25;
    L19:
        r8 = s1.y();
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    public static void n(String r4, String r5) {
        qm0.b r0 = om0.c.g();
        if (r0 == null) goto L6;
        r0.sendLog("livesdk_match_land_anim_state_change", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r4), TuplesKt.to("dialogKey", r5)}), new Object[]{new x(), s80.a.a});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x(String r3, Dialog r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (a == true) goto L6;
        return;
    L6:
        if (c == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "showDialog: now state:" + A(c) + ",cancel lastAnimator");
        e.cancel();
    L8:
        if (r4 == 0) goto L23;
        int r1 = -1;
        if ((r4 instanceof com.bytedance.android.live.matchroom.b) == false) goto L12;
        int r0 = ((com.bytedance.android.live.matchroom.b) r4).getActualContentWidth();
    L13:
        if (r0 > 0) goto L21;
        if (r5 != null) goto L17;
    L18:
        if (r5 == null) goto L20;
        r1 = r5.intValue();
    L20:
        r0 = r1;
        goto L21
    L17:
        if (r5.intValue() != (-1)) goto L18;
    L21:
        z(r3, r4, r0);
        return;
    L12:
        r0 = -1;
        goto L13
    }

    public static void y(String r3, DialogFragment r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (a == true) goto L6;
        return;
    L6:
        if (c == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "show dialogFragment: now state:" + A(c) + ",cancel lastAnimator");
        e.cancel();
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.getDialog() == null) goto L26;
        int r1 = -1;
        if ((r4 instanceof com.bytedance.android.live.matchroom.b) == false) goto L14;
        int r0 = ((com.bytedance.android.live.matchroom.b) r4).getActualContentWidth();
    L15:
        if (r0 > 0) goto L23;
        if (r5 != null) goto L19;
    L20:
        if (r5 == null) goto L22;
        r1 = r5.intValue();
    L22:
        r0 = r1;
        goto L23
    L19:
        if (r5.intValue() != (-1)) goto L20;
    L23:
        z(r3, r4.getDialog(), r0);
        return;
    L14:
        r0 = -1;
        goto L15
    }

    public static void z(String r3, Dialog r4, int r5) {
        ALogger.i("MatchRoomAnimUtil", "showdialog " + r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getWindow() == null) goto L19;
        Window r0 = r4.getWindow();
        if (r0 == null) goto L9;
        View r1 = a(r0);
    L10:
        Window r2 = r4.getWindow();
        if (r2 == null) goto L13;
        r2.setWindowAnimations(2131954734);
    L13:
        if (r1 == null) goto L15;
        r1.setAlpha(0.0f);
    L15:
        if (r1 == null) goto L20;
        r1.post(new f(r3, r5, r1, r4));
        return;
    L20:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void k(String r5, boolean r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "key");
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 1111 ----  " + r5);
        if (a == true) goto L5;
        return;
    L5:
        q(r5);
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 11111111111111 ---- ");
        if (((d51) a1.a.getValue()).h() == false) goto L13;
        if (d() == true) goto L10;
    L15:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 1111222222211111 ---- ");
        int r0 = c;
        if (r0 == 2) goto L18;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while current state:".concat(A(r0)));
        if (c == 0) goto L27;
        e.cancel();
        l(this, r5, r6, r7, 1);
        return;
    L27:
        return;
    L18:
        if ((!b.isEmpty()) == false) goto L21;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while some dialog still showing, skip");
        return;
    L21:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 2222 ---- ");
        l(this, r5, r6, r7, 1);
        return;
    L10:
        if (b.size() <= 0) goto L15;
        return;
    L13:
        if (d() == false) goto L15;
    }

    public static Animator i(View r6, boolean r7, float r8, float r9) {
        WeakReference<com.bytedance.android.live.matchroom.d> r0 = l;
        if (r0 == null) goto L5;
        com.bytedance.android.live.matchroom.d r1 = r0.get();
    L7:
        if (r1 == null) goto L13;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r8, r9});
        r10.setDuration(400);
        if (r7 == false) goto L11;
        om3.c r11 = new om3.c();
    L12:
        r10.setInterpolator(r11);
        r10.addUpdateListener(j.a);
        ValueAnimator r12 = r10;
    L18:
        return r12;
    L11:
        r11 = new om3.d();
        goto L12
    L13:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r6, "translationY", new float[]{r8, r9});
        r13.setDuration(400);
        if (r7 == false) goto L16;
        om3.c r14 = new om3.c();
    L17:
        r13.setInterpolator(r14);
        r12 = r13;
        goto L18
    L16:
        r14 = new om3.d();
        goto L17
    L5:
        r1 = null;
        goto L7
    }

    public static Animator f(View r2, boolean r3, float r4, float r5, boolean r6) {
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r4, r5});
        r7.setDuration(400);
        if (r3 == false) goto L5;
        om3.c r8 = new om3.c();
    L6:
        r7.setInterpolator(r8);
        r7.addUpdateListener(new a(r6, r2));
        return r7;
    L5:
        r8 = new om3.d();
        goto L6
    }

    public static /* synthetic */ Animator h(View r6, boolean r7, float r8, float r9, String r10) {
        return g(r6, r7, r8, r9, false, r10);
    }

    public static void l(MatchRoomLandScapeAnimUtil r20, String r21, boolean r22, Function0 r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        List r0 = CollectionsKt.emptyList();
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Function0 r5 = null;
    L18:
        r20.getClass();
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 444 ---- ");
        if (y == true) goto L21;
    L23:
        boolean r6 = false;
    L24:
        xs2.b.a().post(new w0(true, r6));
        WeakReference<View> r7 = q;
        if (r7 == null) goto L27;
        View r8 = r7.get();
    L28:
        ArrayList r15 = new ArrayList();
        r15.addAll(r0);
        if (r8 != null) goto L34;
        if (r2 != null) goto L32;
        String r9 = "";
    L33:
        n("hide_dialog_null", r9);
        ALogger.e("MatchRoomAnimUtil", "doDialogHideAnim failed, null playerView");
        goto L34
    L32:
        r9 = r2;
    L34:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 333 ---- ");
        if (r8 == null) goto L64;
        float r14 = r8.getScaleX();
        float r11 = r8.getTranslationX();
        float r13 = r8.getTranslationY();
        float r12 = B;
        if (r2 != null) goto L39;
        String r17 = "";
    L40:
        Animator r16 = g(r8, false, r11, r12, true, r17);
        Animator r1 = i(r8, false, r13, C);
        if (((Boolean) x.getValue()).booleanValue() == false) goto L43;
        Animator r10 = e(r8, false, r8.getScaleX(), v, r8.getScaleY(), w);
    L44:
        r15.add(r16);
        r15.add(r1);
        r15.add(r10);
        Map<String, com.bytedance.android.live.matchroom.g> r4 = z;
        if ((!r4.isEmpty()) == false) goto L64;
        Iterator r18 = ((LinkedHashMap) r4).entrySet().iterator();
    L48:
        if (r18.hasNext() == false) goto L64;
        Map.Entry r19 = (Map.Entry) r18.next();
        com.bytedance.android.live.matchroom.g r110 = (com.bytedance.android.live.matchroom.g) r19.getValue();
        WeakReference<View> r111 = r110.a;
        if (r111 == null) goto L52;
        View r112 = r111.get();
    L53:
        if (r112 == null) goto L48;
        float r113 = r112.getTranslationX();
        float r114 = r110.b;
        if (r2 != null) goto L57;
        String r115 = "";
    L58:
        Animator r116 = h(r112, false, r113, r114, r115);
        Animator r117 = f(r112, false, r112.getScaleX(), r110.c, false);
        if (r110.d == false) goto L61;
    L62:
        r116.addListener(new k(r112, r19, r15));
    L63:
        r15.add(r116);
        r15.add(r117);
        ALogger.i("MatchRoomAnimUtil", "add animator for " + ((String) r19.getKey()));
        goto L48
    L61:
        if (r110.e == false) goto L63;
    L57:
        r115 = r2;
        goto L58
    L52:
        r112 = null;
        goto L53
    L43:
        r10 = f(r8, false, r14, A, true);
        goto L44
    L39:
        r17 = r2;
    L64:
        ALogger.i("MatchRoomAnimUtil", "start doDialogHideAnim,size = " + r15.size());
        AnimatorSet r25 = new AnimatorSet();
        e = r25;
        r25.playTogether(r15);
        if (r3 == false) goto L67;
        e.addListener(new l(r3, r8));
    L67:
        e.addListener(new m(r5));
        e.start();
        if (r2 != null) goto L70;
        r2 = "";
    L70:
        n("hide_dialog", r2);
        com.bytedance.android.live.matchroom.e r26 = r;
        if (r26 == null) goto L74;
        r26.a(false);
    L74:
        if (((d51) a1.a.getValue()).m() == true) goto L82;
        xs2.b.a().post(new zt2.a(true));
        return;
    L82:
        return;
    L27:
        r8 = null;
        goto L28
    L21:
        if (((Boolean) y0.a.getValue()).booleanValue() == false) goto L23;
        r6 = true;
        goto L24
    L17:
        r5 = r23;
        goto L18
    L13:
        r3 = r22;
        goto L15
    L9:
        r2 = r21;
        goto L11
    L5:
        r0 = null;
        goto L7
    }

    public static void c(String r9, View r10, boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L6;
        r11 = false;
    L6:
        if ((r14 & 8) == 0) goto L8;
        boolean r8 = false;
    L10:
        if ((r14 & 16) == 0) goto L12;
        boolean r7 = false;
    L13:
        Intrinsics.checkNotNullParameter(r9, "key");
        ALogger.i("MatchRoomAnimUtil", "start addOtherContainer for ".concat(r9));
        Map<String, com.bytedance.android.live.matchroom.g> r15 = z;
        com.bytedance.android.live.matchroom.g r16 = new com.bytedance.android.live.matchroom.g();
        WeakReference<View> r17 = new WeakReference(r10);
        r16.a = r17;
        r16.d = r11;
        r16.e = r7;
        if (a == true) goto L16;
    L26:
        Unit r18 = Unit.INSTANCE;
        r15.put(r9, r16);
        return;
    L16:
        if (c != 2) goto L26;
        View r19 = r17.get();
        if (r19 == null) goto L29;
        WeakReference<View> r110 = q;
        if (r110 == null) goto L28;
        View r5 = r110.get();
        if (r5 == null) goto L30;
        r19.post(new h(r16, r19, r5, r10, r7, r8));
        goto L26
    L30:
        return;
    L28:
        return;
    L29:
        return;
    L12:
        r7 = r13;
        goto L13
    L8:
        r8 = r12;
        goto L10
    }

    public static Animator e(View r7, boolean r8, float r9, float r10, float r11, float r12) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setDuration(400);
        if (r8 == false) goto L5;
        om3.c r13 = new om3.c();
    L6:
        r0.setInterpolator(r13);
        r0.addUpdateListener(new i(r9, r10, r11, r12, r7));
        return r0;
    L5:
        r13 = new om3.d();
        goto L6
    }

    public static Animator g(View r6, boolean r7, float r8, float r9, boolean r10, String r11) {
        if (r10 == false) goto L14;
        WeakReference<com.bytedance.android.live.matchroom.d> r5 = l;
        if (r5 == null) goto L7;
        com.bytedance.android.live.matchroom.d r12 = r5.get();
    L8:
        if (r12 == null) goto L14;
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{r8, r9});
        r13.setDuration(400);
        if (r7 == false) goto L12;
        om3.c r14 = new om3.c();
    L13:
        r13.setInterpolator(r14);
        r13.addUpdateListener(c.a);
        ValueAnimator r15 = r13;
    L19:
        if (r10 == false) goto L21;
        r15.addListener(new b(r7, r6, r11));
    L21:
        return r15;
    L12:
        r14 = new om3.d();
        goto L13
    L7:
        r12 = null;
    L14:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r6, "translationX", new float[]{r8, r9});
        r16.setDuration(400);
        if (r7 == false) goto L17;
        om3.c r17 = new om3.c();
    L18:
        r16.setInterpolator(r17);
        r15 = r16;
        goto L19
    L17:
        r17 = new om3.d();
        goto L18
    }
}
