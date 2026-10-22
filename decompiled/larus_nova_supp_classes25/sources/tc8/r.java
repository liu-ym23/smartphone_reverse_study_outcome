package tc8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachRejectReason;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ns9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements pc8.l, n19.b {
    public static final r a = null;
    public static final Handler b = null;
    public static final Map<String, ReachRejectReason> c = null;
    public static boolean d;
    public static WeakReference<Activity> e;
    public static d f;
    public static WeakReference<Object> g;
    public static a h;
    public static a i;
    public static ns9.t j;
    public static final Set<String> k = null;
    public static final Set<String> l = null;
    public static final Map<String, String> m = null;
    public static final Map<String, String> n = null;
    public static final Map<String, b> o = null;
    public static volatile pc8.m p;
    public static ValueAnimator q;
    public static final e r = null;
    public static final PathInterpolator s = null;

    public static final class a {
        public final ns9.t a;
        public final ns9.g b;
        public final String c;
        public final String d;
        public final boolean e;
        public final ns9.c f;
        public boolean g;
        public boolean h;
        public ReachSpacerState i;
        public long j;
        public ReachCloseReason k;
        public boolean l;
        public boolean m;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L36;
            return false;
        L36:
            if (this.j == r9.j) goto L39;
            return false;
        L39:
            if (this.k == r9.k) goto L42;
            return false;
        L42:
            if (this.l == r9.l) goto L45;
            return false;
        L45:
            if (this.m == r9.m) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            int r2 = 1231;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((r0 + r1) * 31) + this.f.hashCode()) * 31;
            if (this.g == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.h == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (((r5 + r6) * 31) + this.i.hashCode()) * 31;
            long r8 = this.j;
            int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
            ReachCloseReason r10 = this.k;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            if (this.l == false) goto L21;
            int r13 = 1231;
        L22:
            int r14 = (r12 + r13) * 31;
            if (this.m == true) goto L27;
            r2 = 1237;
        L27:
            return r14 + r2;
        L21:
            r13 = 1237;
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ActiveEntry(request=" + this.a + ", session=" + this.b + ", boundActivityId=" + this.c + ", boundConversationId=" + this.d + ", requiresSpacer=" + this.e + ", content=" + this.f + ", shown=" + this.g + ", contentEnterApplied=" + this.h + ", spacerState=" + this.i + ", transitionStartedAtMs=" + this.j + ", dismissReason=" + this.k + ", contentExitFinished=" + this.l + ", spacerExitFinished=" + this.m + ')';
        }

        public a(ns9.t r2, ns9.g r3, String r4, String r5, boolean r6, ns9.c r7, ReachSpacerState r8, long r9) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "session");
            Intrinsics.checkNotNullParameter(r4, "boundActivityId");
            Intrinsics.checkNotNullParameter(r5, "boundConversationId");
            Intrinsics.checkNotNullParameter(r7, "content");
            Intrinsics.checkNotNullParameter(r8, "spacerState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = false;
            this.h = false;
            this.i = r8;
            this.j = r9;
            this.k = null;
            this.l = false;
            this.m = false;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "BannerMeasurement(widthPx=" + this.a + ", bannerHeightPx=" + this.b + ", spacerHeightPx=" + this.c + ')';
        }

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c {
        public final View a;
        public final View b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            View r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L15:
            return r5 + r6;
        L13:
            r6 = 1237;
            goto L15
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "FloatingAnchors(bottomAnchor=" + this.a + ", widthAnchor=" + this.b + ", hostAvailable=" + this.c + ')';
        }

        public final boolean a() {
            if (this.a != null) goto L5;
        L9:
            return false;
        L5:
            if (this.b == null) goto L9;
            if (this.c == false) goto L9;
            return true;
        }

        public c(View r1, View r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d {
        public final String a;
        public final WeakReference<Object> b;
        public final WeakReference<Object> c;
        public final Function0<Boolean> d;
        public final Function0<Unit> e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "PageHostBinding(conversationId=" + this.a + ", overlayRef=" + this.b + ", anchorRootRef=" + this.c + ", canHostBanner=" + this.d + ", refreshList=" + this.e + ')';
        }

        public final ViewGroup a() {
            Object r0 = this.c.get();
            if ((r0 instanceof ViewGroup) == true) goto L7;
            return null;
        L7:
            return (ViewGroup) r0;
        }

        public final FrameLayout b() {
            Object r0 = this.b.get();
            if ((r0 instanceof FrameLayout) == true) goto L7;
            return null;
        L7:
            return (FrameLayout) r0;
        }

        public d(String r2, WeakReference r3, WeakReference r4, qc8.k r5, qc8.l r6) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r3, "overlayRef");
            Intrinsics.checkNotNullParameter(r4, "anchorRootRef");
            Intrinsics.checkNotNullParameter(r5, "canHostBanner");
            Intrinsics.checkNotNullParameter(r6, "refreshList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class e implements Application.ActivityLifecycleCallbacks {
        public e() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            WeakReference<Activity> r0 = r.e;
            if (r0 == null) goto L5;
            Activity r1 = r0.get();
        L7:
            if (Intrinsics.areEqual(r1, r3) == false) goto L9;
            r.e = null;
        L9:
            d r2 = r.f;
            if (r2 == null) goto L14;
            FrameLayout r4 = r2.b();
            if (r4 == null) goto L14;
            Context r5 = r4.getContext();
        L16:
            if (Intrinsics.areEqual(r5, r3) == false) goto L19;
            r.f = null;
            r.g = null;
            return;
        L19:
            return;
        L14:
            r5 = null;
            goto L16
        L5:
            r1 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            a r0 = r.h;
            if (r0 == null) goto L15;
            String r1 = r0.c;
            r r2 = r.a;
            if (Intrinsics.areEqual(r1, String.valueOf(System.identityHashCode(r4))) == true) goto L7;
        L9:
            boolean r5 = false;
        L10:
            if (r5 == true) goto L13;
            r0 = null;
        L13:
            if (r0 == null) goto L15;
            r2.n(r0.a.a.h, ReachCloseReason.PAGE_LEAVE);
            goto L15
        L7:
            if (r.u(r0.a) == true) goto L9;
            r5 = true;
        L15:
            r r6 = r.a;
            r.w();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            r r0 = r.a;
            r.e = new WeakReference(r2);
            r r3 = r.a;
            r.w();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            r r0 = r.a;
            r.e = new WeakReference(r2);
            r r3 = r.a;
            r.w();
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;
        public final /* synthetic */ Function0<Unit> g;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r7) {
            Intrinsics.checkNotNullParameter(r7, "animation");
            if (this.a == false) goto L5;
            return;
        L5:
            if (r.q != r7) goto L10;
            r.q = null;
            r r8 = r.a;
            r.i(this.b, this.c, this.d, this.e, this.f, 1.0f);
            this.g.invoke();
            return;
        }

        public f(View r1, float r2, float r3, float r4, float r5, Function0<Unit> r6) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
        }
    }

    public r() {
    }

    static {
        a = new r();
        b = new Handler(Looper.getMainLooper());
        c = new LinkedHashMap();
        k = new LinkedHashSet();
        l = new LinkedHashSet();
        m = new LinkedHashMap();
        n = new LinkedHashMap();
        o = new LinkedHashMap();
        r = new e();
        s = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    }

    public static View m() {
        WeakReference<Object> r0 = g;
        if (r0 == null) goto L5;
        Object r1 = r0.get();
    L7:
        if ((r1 instanceof View) == true) goto L9;
        return null;
    L9:
        return (View) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static void w() {
        ns9.k r0 = ns9.k.a;
        monitor-enter(r0);
        ns9.k.c++;     // Catch: Throwable -> L9
        Function0 r1 = ns9.k.b;     // Catch: Throwable -> L9
        ns9.k.b = null;     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == null) goto L14;
        r1.invoke();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void z() {
        a r0 = h;
        pc8.m r1 = null;
        Integer r2 = null;
        r1 = null;
        if (r0 == null) goto L6;
        ns9.t r3 = r0.a;
        if (r3 == null) goto L6;
    L12:
        if (r0 == null) goto L17;
        String r4 = r0.d;
        if (r4 == null) goto L17;
    L16:
        String r5 = r4;
        a r6 = h;
        if (r6 != null) goto L26;
        r6 = i;
    L26:
        String r7 = r3.a.h;
        String r8 = (String) ((LinkedHashMap) m).get(r7);
        if (r8 != null) goto L39;
        w r9 = r3.b;
        if ((r9 instanceof w) == false) goto L31;
        w r10 = r9;
    L32:
        if (r10 == null) goto L36;
        Map r11 = r10.b;
        if (r11 == null) goto L36;
        r8 = (String) r11.get("query_message_id");
    L37:
        if (r8 != null) goto L39;
        r8 = "";
    L36:
        r8 = null;
        goto L37
    L31:
        r10 = null;
    L39:
        String r12 = r8;
        if (r6 == null) goto L42;
        boolean r13 = r6.e;
    L43:
        boolean r14 = r13;
        b r15 = (b) ((LinkedHashMap) o).get(r3.a.h);
        if (r15 == null) goto L46;
        int r16 = r15.c;
    L47:
        int r17 = D(r3);
        int r18 = D(r3);
        w r19 = r3.b;
        if ((r19 instanceof w) == false) goto L50;
        w r20 = r19;
    L51:
        if (r20 == null) goto L55;
        Map r21 = r20.e;
        if (r21 == null) goto L55;
        String r22 = (String) r21.get("dismiss_timing");
    L56:
        int r23 = F(r22);
        if (r18 == 0) goto L77;
        if (r23 == 0) goto L77;
        boolean r110 = true;
        if (r18 == 1) goto L65;
        if (r18 == 3) goto L64;
        Integer r24 = null;
    L66:
        if (r24 == null) goto L77;
        int r25 = r24.intValue();
        if (r23 == 1) goto L72;
        if (r23 != 3) goto L73;
        r2 = 1;
    L73:
        if (r2 == null) goto L77;
        if (r2.intValue() > r25) goto L77;
    L78:
        if (r110 == false) goto L80;
        r23 = 0;
    L80:
        if (r6 == null) goto L83;
        ReachSpacerState r26 = r6.i;
        if (r26 == null) goto L83;
    L84:
        ReachSpacerState r111 = r26;
        if (r6 == null) goto L87;
        long r27 = r6.j;
    L88:
        r1 = new pc8.m(r7, r5, r12, r14, r16, r17, r23, r111, r27);
    L89:
        p = r1;
        b.post(new tc8.c());
        return;
    L87:
        r27 = 0;
    L83:
        r26 = ReachSpacerState.WAITING;
        goto L84
    L72:
        r2 = 2;
        goto L73
    L64:
        r24 = 1;
        goto L66
    L65:
        r24 = 2;
    L77:
        r110 = false;
    L55:
        r22 = null;
        goto L56
    L50:
        r20 = null;
        goto L51
    L46:
        r16 = 0;
        goto L47
    L42:
        r13 = k.contains(r3.a.h);
    L17:
        a r28 = i;
        if (r28 == null) goto L20;
        r4 = r28.d;
        goto L16
    L20:
        r4 = (String) ((LinkedHashMap) n).get(r3.a.h);
        if (r4 != null) goto L16;
    L6:
        a r29 = i;
        if (r29 == null) goto L9;
        r3 = r29.a;
        goto L12
    L9:
        r3 = j;
        if (r3 != null) goto L12;
        goto L12
    }

    public final Activity l() {
        WeakReference<Activity> r0 = e;
        if (r0 == null) goto L6;
        Activity r1 = r0.get();
        if (r1 == null) goto L6;
        return r1;
    L6:
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        return r2.a().e();
    }

    public final void r() {
        if (d == false) goto L5;
        return;
    L5:
        d = true;
        n19.a.a.c(UiPresentationChannel.REACH, this);
        pc8.l r0 = pc8.k.a;
        Intrinsics.checkNotNullParameter(this, "provider");
        pc8.k.a = this;
        gd9.i r1 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r1);
        r1.getApplication().registerActivityLifecycleCallbacks(r);
        Activity r2 = r1.a().e();
        if (r2 == null) goto L9;
        e = new WeakReference(r2);
        return;
    }

    public static int D(ns9.t r2) {
        w r3 = r2.b;
        String r1 = null;
        if ((r3 instanceof w) == false) goto L5;
        w r4 = r3;
    L6:
        if (r4 == null) goto L11;
        Map r5 = r4.e;
        if (r5 == null) goto L11;
        r1 = (String) r5.get("show_timing");
    L11:
        return F(r1);
    L5:
        r4 = null;
        goto L6
    }

    public static int F(String r2) {
        if (r2 == null) goto L4;
        Integer r3 = StringsKt.toIntOrNull(r2);
    L5:
        if (r3 != null) goto L8;
    L10:
        if (r3 != null) goto L13;
    L15:
        return 0;
    L13:
        if (r3.intValue() != 3) goto L15;
        return 3;
    L8:
        if (r3.intValue() != 1) goto L10;
        return 1;
    L4:
        r3 = null;
        goto L5
    }

    public static void G(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "overlay");
        d r0 = f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b() == r2) goto L8;
        return;
    L8:
        f = null;
        a r1 = h;
        if (r1 == null) goto L15;
        ns9.t r3 = r1.a;
        if (r3 == null) goto L15;
        boolean r4 = true;
        if (u(r3) != true) goto L15;
    L16:
        if (r4 == true) goto L18;
        g = null;
    L18:
        w();
        return;
    L15:
        r4 = false;
        goto L16
    }

    public static void o(a r4) {
        if (h == r4) goto L5;
        return;
    L5:
        ValueAnimator r0 = q;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        q = null;
        View r1 = m();
        if (r1 == null) goto L16;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L13;
        ViewGroup r3 = (ViewGroup) r2;
    L14:
        if (r3 == null) goto L16;
        r3.removeView(r1);
        goto L16
    L13:
        r3 = null;
    L16:
        g = null;
        h = null;
        ReachCloseReason r5 = ReachCloseReason.HOST_NOT_READY;
        r4.k = r5;
        String r6 = r4.a.a.h;
        k.remove(r6);
        l.remove(r6);
        m.remove(r6);
        n.remove(r6);
        o.remove(r6);
        r4.b.b(r5);
        z();
    }

    public static void p(ReachRejectReason r3) {
        ns9.t r0 = j;
        if (r0 != null) goto L5;
        return;
    L5:
        j = null;
        k.remove(r0.a.h);
        l.remove(r0.a.h);
        m.remove(r0.a.h);
        n.remove(r0.a.h);
        o.remove(r0.a.h);
        c.put(r0.a.h, r3);
        w();
        z();
    }

    public static boolean u(ns9.t r1) {
        w r2 = r1.b;
        if ((r2 instanceof w) == false) goto L5;
        w r3 = r2;
    L6:
        if (r3 == null) goto L14;
        Map r4 = r3.e;
        if (r4 == null) goto L14;
        String r5 = (String) r4.get("keep_on_leave");
        if (r5 == null) goto L14;
        Boolean r6 = StringsKt.toBooleanStrictOrNull(r5);
        if (r6 == null) goto L14;
        return r6.booleanValue();
    L14:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public final int A(FrameLayout r5) {
        int r0 = q(12, r5) * 2;
        Integer r1 = Integer.valueOf(r5.getWidth());
        if (r1.intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        int r3 = r1.intValue();
    L13:
        return RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3 - r0, 0), q(430, r5)) + r0, r3);
    L11:
        Resources r4 = r5.getResources();
        r3 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public final void C(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        b.post(new j(r3));
    }

    @Override // pc8.l
    public final pc8.m a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        pc8.m r0 = p;
        if (r0 != null) goto L5;
        return null;
    L5:
        u.a.getClass();
        String r2 = u.a(r4);
        if (r2 == null) goto L10;
        r4 = r2;
    L10:
        if (Intrinsics.areEqual(r0.b, r4) == false) goto L13;
        return r0;
    L13:
        return null;
    }

    @Override // pc8.l
    public final void b(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        C(new q(r2));
    }

    @Override // pc8.l
    public final void c(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        C(new tc8.e(r2));
    }

    @Override // pc8.l
    public final void d(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "reachUniqueId");
        b.post(new n(r3));
    }

    @Override // pc8.l
    public final void e(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        C(new p(r2));
    }

    @Override // pc8.l
    public final void g(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        C(new g(r2));
    }

    public static c B(ViewGroup r5, d r6) {
        View r0 = r5.findViewById(2131362044);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        boolean r3 = false;
    L12:
        View r4 = null;
        if (r3 == true) goto L16;
        r0 = null;
    L16:
        View r7 = r5.findViewById(2131375336);
        if (r7 != null) goto L19;
    L25:
        r1 = false;
    L26:
        if (r1 == false) goto L29;
        r4 = r7;
    L29:
        if (r0 != null) goto L31;
        View r2 = r4;
    L32:
        if (r4 == null) goto L36;
        r0 = r4;
    L36:
        return new c(r2, r0, ((Boolean) r6.d.invoke()).booleanValue());
    L31:
        r2 = r0;
        goto L32
    L19:
        if (r7.isShown() == false) goto L25;
        if (r7.getWidth() <= 0) goto L25;
        if (r7.getHeight() <= 0) goto L25;
    L5:
        if (r0.isShown() == false) goto L11;
        if (r0.getWidth() <= 0) goto L11;
        if (r0.getHeight() <= 0) goto L11;
        r3 = true;
        goto L12
    }

    public static void k(a r1, boolean r2) {
        if (i != r1) goto L15;
        if (r2 == false) goto L6;
    L10:
        i = null;
        String r3 = r1.a.a.h;
        k.remove(r3);
        l.remove(r3);
        m.remove(r3);
        n.remove(r3);
        o.remove(r3);
        ns9.g r4 = r1.b;
        ReachCloseReason r5 = r1.k;
        if (r5 != null) goto L13;
        r5 = ReachCloseReason.CLIENT_EXCEPTION;
    L13:
        r4.b(r5);
        z();
        return;
    L6:
        if (r1.l == true) goto L8;
        return;
    L8:
        if (r1.m == true) goto L10;
        return;
    }

    public static void t(View r3, a r4) {
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(r3);
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        if (i != r4) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L20;
        r4.l = true;
        k(r4, false);
        return;
    L20:
        return;
    L12:
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void f(UiPresentationChannel r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        if (r2 != UiPresentationChannel.REACH) goto L7;
        if (r3 == true) goto L8;
        w();
        return;
    L8:
        return;
    }

    @Override // pc8.l
    public final void h(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, "anchorMessageId");
        C(new tc8.f(r2, r3));
    }

    public final void n(final String r2, final ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, "reason");
        C(new i(r2, r3));
    }

    public final int q(int r2, View r3) {
        Resources r4 = r3.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    public static void x(final a r2, ReachCloseReason r3, View r4) {
        if (h == r2) goto L5;
        return;
    L5:
        h = null;
        r2.k = r3;
        if (m() != r4) goto L9;
        g = null;
    L9:
        if (r2.e == false) goto L11;
        i = r2;
        b.postDelayed(new o(r2), 750);
        return;
    L11:
        l.remove(r2.a.a.h);
        n.remove(r2.a.a.h);
        o.remove(r2.a.a.h);
        r2.b.b(r3);
    }

    public final ns9.h s(ns9.t r6, String r7, ns9.c r8) {
        r();
        if (n19.a.a.d(UiPresentationChannel.REACH) == true) goto L5;
        n.put(r6.a.h, r7);
        LifecycleOwner r0 = l();
        if (r0 != null) goto L11;
        return new ns9.h.c("activity_unavailable");
    L11:
        if (r0.isFinishing() == true) goto L75;
        if (r0.isDestroyed() == true) goto L75;
        ViewGroup r2 = null;
        if ((r0 instanceof LifecycleOwner) == false) goto L17;
        LifecycleOwner r1 = r0;
    L18:
        if (r1 == null) goto L24;
        Lifecycle r3 = r1.getLifecycle();
        if (r3 == null) goto L24;
        Lifecycle.State r4 = r3.getCurrentState();
        if (r4 == null) goto L24;
        boolean r5 = r4.isAtLeast(Lifecycle.State.RESUMED);
    L29:
        if (r5 == false) goto L75;
        d r9 = f;
        if (r9 == null) goto L73;
        if (Intrinsics.areEqual(r9.a, r7) == true) goto L37;
        r9 = null;
    L37:
        if (r9 == null) goto L73;
        FrameLayout r10 = r9.b();
        if (r10 == null) goto L71;
        if (r10.isAttachedToWindow() == true) goto L44;
        r10 = null;
    L44:
        if (r10 == null) goto L71;
        ViewGroup r11 = r9.a();
        if (r11 == null) goto L69;
        if (r11.isAttachedToWindow() == false) goto L50;
        r2 = r11;
    L50:
        if (r2 == null) goto L69;
        if (B(r2, r9).a() == false) goto L54;
        if (r8 == null) goto L61;
        if (v(r6, r10, r8.a) != null) goto L61;
        return new ns9.h.c("banner_measurement_unavailable");
    L61:
        if (k.contains(r6.a.h) == true) goto L67;
        if (l.contains(r6.a.h) == true) goto L67;
        j = r6;
        z();
        return new ns9.h.c("message_spacer_not_ready");
    L67:
        return ns9.h.a.a;
    L54:
        return new ns9.h.c("bottom_anchor_unavailable");
    L69:
        return new ns9.h.c("target_page_anchor_root_detached");
    L71:
        return new ns9.h.c("target_page_container_detached");
    L73:
        return new ns9.h.c("target_page_container_unavailable");
    L24:
        r5 = r0.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L29;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r12 = ThreadMethodProxy.currentThread();
        if (r12 == com.larus.home.impl.utils.c.a) goto L29;
        com.larus.home.impl.utils.c.a(r12, "hasWindowFocus");
        goto L29
    L17:
        r1 = null;
    L75:
        return new ns9.h.c("activity_not_ready");
    L5:
        return new ns9.h.c("ui_presentation_blocked");
    }

    public final b v(ns9.t r7, FrameLayout r8, View r9) {
        int r10 = A(r8);
        Map<String, b> r0 = o;
        b r1 = (b) ((LinkedHashMap) r0).get(r7.a.h);
        if (r1 != null) goto L5;
    L13:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r2 = r9.getMeasuredHeight();
        if (r2 > 0) goto L16;
        return null;
    L16:
        String r11 = r7.a.h;
        b r3 = new b(r10, r2, RangesKt.coerceAtLeast((r2 - q(12, r9)) + q(12, r9), 0));
        r0.put(r11, r3);
        return r3;
    L5:
        if (r1.a != r10) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    public final b j(FrameLayout r7, View r8, c r9, a r10) {
        int r0 = A(r7);
        b r11 = v(r10.a, r7, r8);
        int[] r1 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        int[] r3 = new int[2];
        r7.getLocationOnScreen(r3);
        View r12 = r9.a;
        if (r12 == null) goto L8;
        r1 = new int[2];
        r12.getLocationOnScreen(r1);
    L8:
        if (r1 == null) goto L10;
        int r2 = r1[1] - r3[1];
    L11:
        int r13 = RangesKt.coerceAtLeast(r11.b, 0);
        int r4 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost((r2 - r13) - q(12, r8), r2), -r13);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r0, -2);
        r5.leftMargin = RangesKt.coerceAtLeast((r7.getWidth() - r0) / 2, 0);
        r5.topMargin = r4;
        r8.setLayoutParams(r5);
        r8.setTranslationX(0.0f);
        r8.setTranslationY(0.0f);
        r8.setClipBounds(new Rect(0, 0, r0, r13));
        return r11;
    L10:
        r2 = r7.getHeight();
        goto L11
    }

    public final void y(final a r12, Activity r13, FrameLayout r14, c r15) {
        if (Intrinsics.areEqual(r12.c, String.valueOf(System.identityHashCode(r13))) == true) goto L5;
        return;
    L5:
        View r16 = r12.f.a;
        View r0 = m();
        if (r0 == null) goto L8;
        r16 = r0;
    L9:
        boolean r1 = false;
        if (r16.getParent() == null) goto L12;
        boolean r2 = true;
    L14:
        if (r16.getParent() == r14) goto L22;
        ViewParent r3 = r16.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L18;
        ViewGroup r4 = (ViewGroup) r3;
    L19:
        if (r4 == null) goto L21;
        r4.removeView(r16);
    L21:
        r14.addView(r16);
        goto L22
    L18:
        r4 = null;
    L22:
        View r5 = r12.f.b;
        if (j(r14, r16, r15, r12) != null) goto L26;
        o(r12);
        return;
    L26:
        if (r2 == false) goto L35;
        r5.setAlpha(1.0f);
        r5.setTranslationY(0.0f);
        if (h == r12) goto L30;
        return;
    L30:
        if (r12.g == true) goto L32;
        r12.g = true;
        r12.i = ReachSpacerState.VISIBLE;
        r12.b.c();
        r1 = true;
    L32:
        if (r1 == false) goto L38;
        z();
        return;
    L38:
        return;
    L35:
        E(r12, r5, 0.0f, 1.0f, RangesKt.coerceAtLeast(r16.getMeasuredHeight(), 1), 0.0f, new tc8.d(r12));
        return;
    L12:
        r2 = false;
        goto L14
    L8:
        g = new WeakReference(r16);
        goto L9
    }

    public static void i(View r0, float r1, float r2, float r3, float r4, float r5) {
        r0.setAlpha(r1 + ((r2 - r1) * r5));
        r0.setTranslationY(r3 + ((r4 - r3) * r5));
    }

    public static void E(a r11, final View r12, final float r13, final float r14, final float r15, final float r16, Function0 r17) {
        ValueAnimator r0 = q;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        float r1 = 500;
        float r2 = RangesKt.coerceIn((SystemClock.uptimeMillis() - r11.j) / r1, 0.0f, 1.0f);
        long r3 = RangesKt.coerceAtLeast((long) (r1 * (1.0f - r2)), 0);
        if (r2 < 1.0f) goto L8;
    L12:
        i(r12, r13, r14, r15, r16, 1.0f);
        r17.invoke();
        return;
    L8:
        if (r3 <= 0) goto L12;
        i(r12, r13, r14, r15, r16, s.getInterpolation(r2));
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{r2, 1.0f});
        r4.setDuration(r3);
        r4.setInterpolator(new LinearInterpolator());
        r4.addUpdateListener(new h(r12, r13, r14, r15, r16));
        r4.addListener(new f(r12, r13, r14, r15, r16, r17));
        r4.start();
        q = r4;
    }
}
