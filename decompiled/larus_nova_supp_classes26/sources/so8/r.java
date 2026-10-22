package so8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.block.newheader.foldcontainer.FolderContainerView;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public final v a;
    public FrameLayout b;
    public View c;
    public so8.b d;
    public k e;
    public s f;
    public Runnable g;
    public final Lazy h;
    public so8.a i;
    public DeepThinkFoldStatus j;
    public final Map<ZoomInAnimationAction, k> k;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomInAnimationState.values().length];
            r0[ZoomInAnimationState.ZOOM_IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ZoomInAnimationState.STAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ZoomInAnimationState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ZoomInAnimationState.ZOOM_OUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public r() {
        this.a = new v();
        this.d = new so8.b(0);
        this.h = LazyKt.lazy(new l());
        this.j = DeepThinkFoldStatus.HalfFold;
        this.k = new LinkedHashMap();
    }

    public final void a(ZoomInAnimationState r4) {
        FLogger.a.d("ZoomInAnimationManager", "changeAnimationState:" + r4);
        this.d = new so8.b(r4, AppHost.a.getAppClock().currentTimeMillis());
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, so8.o] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, so8.p] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object, so8.q] */
    public final void b(FrameLayout r18) {
        this.b = r18;
        ZoomInAnimationState r2 = this.d.a;
        FLogger r3 = FLogger.a;
        r3.d("ZoomInAnimationManager", "consumeAnimation  currentState:" + r2 + "== wait list：" + ((ArrayList) this.a.a).size() + "====executing list：" + this.k.size());
        int r4 = b.a[r2.ordinal()];
        Context r14 = null;
        if (r4 == 1) goto L89;
        if (r4 == 2) goto L89;
        if (r4 != 3) goto L7;
        v r5 = this.a;
        k r6 = (k) CollectionsKt.removeFirstOrNull(r5.a);
        if (r6 == null) goto L17;
        Set r7 = (Set) ((LinkedHashMap) r5.b).get(r6.c);
        if (r7 != null) goto L16;
        r7 = new LinkedHashSet();
    L16:
        r7.remove(r6.a);
    L17:
        if (r6 == null) goto L145;
        ZoomInAnimationEndStrategy r8 = r6.e.d;
        if (r8 != ZoomInAnimationEndStrategy.TIMER_CONTROL) goto L21;
    L41:
        boolean r9 = true;
    L42:
        if (r9 == false) goto L48;
        long r10 = r6.e.b + 200;
        final k r11 = k.a(r6, ZoomInAnimationAction.HIDE);
        Runnable r12 = this.g;
        if (r12 == null) goto L46;
        SoftReference r13 = y.a;
        Intrinsics.checkNotNullParameter(r12, "action");
        y.a(r12);
    L46:
        Runnable r15 = new m(this, r11);
        this.g = r15;
        SoftReference r16 = y.a;
        Intrinsics.checkNotNullParameter(r15, "action");
        y.d(r15, r10);
    L48:
        FLogger r17 = FLogger.a;
        r17.d("ZoomInAnimationManager", "startZoomIn:" + r6.a + "===zoomInItem:" + r6);
        StringBuilder r19 = new StringBuilder("startZoomIn:");
        r19.append(r6.a);
        r19.append("===============");
        r17.d("ZoomInAnimationManager", r19.toString());
        if (r18 == null) goto L153;
        View r20 = r6.d.c(r18.getContext(), r6.b.a);
        this.c = r20;
        a(ZoomInAnimationState.ZOOM_IN);
        this.e = r6;
        r6.d.d(r20, r6.b.a);
        s r21 = this.f;
        if (r21 == null) goto L56;
        Function1<j, Unit> r22 = r21.a;
        if (r22 == null) goto L56;
        r22.invoke(r6.b);
    L56:
        int r23 = r6.e.a;
        final f r24 = (f) this.h.getValue();
        Context r1 = r18.getContext();
        String r25 = r6.a;
        boolean r26 = ic8.q.a(this.j);
        Rect r27 = r6.e.e;
        ?? r110 = new o(this);
        final ?? r111 = new p(this);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r25, "animationId");
        Intrinsics.checkNotNullParameter(r20, "view");
        Intrinsics.checkNotNullParameter(r27, "marginRect");
        Intrinsics.checkNotNullParameter(r110, "onZoomInEnd");
        Intrinsics.checkNotNullParameter(r111, "onZoomInUpdate");
        r24.b.removeCallbacksAndMessages(null);
        AnimatorSet r28 = r24.a;
        if (r28 == null) goto L59;
        r28.end();
    L59:
        FrameLayout r29 = r24.c;
        if (r29 == null) goto L62;
        r29.removeAllViews();
    L62:
        FrameLayout r30 = r24.c;
        if (r30 == null) goto L65;
        e1.x(r30);
    L65:
        FrameLayout r31 = r24.c;
        if (r31 == null) goto L68;
        View r32 = new View(r1);
        e1.q(r32);
        r31.addView(r32, new ViewGroup.LayoutParams(m0.b(r1), i5.b()));
    L68:
        FrameLayout r33 = r24.c;
        if (r33 == null) goto L71;
        r33.addView(r20);
    L71:
        FrameLayout r34 = r24.c;
        if (r34 == null) goto L78;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L77;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        r36.setMargins(r27.left, r27.top, r27.right, r27.bottom);
        r34.setLayoutParams(r36);
        goto L78
    L77:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L78:
        FrameLayout r37 = r24.c;
        if (r37 == null) goto L81;
        r37.setBackground(null);
    L81:
        ObjectAnimator r38 = ObjectAnimator.ofFloat(r24.c, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r39 = ObjectAnimator.ofFloat(r24.d, "alpha", new float[]{1.0f, 0.0f});
        if (r26 == true) goto L87;
        ViewGroup r40 = r24.d;
        if (r40 == null) goto L87;
        int r112 = r40.getMeasuredHeight();
    L88:
        ValueAnimator r41 = ValueAnimator.ofInt(new int[]{r112, r23});
        r41.addUpdateListener(new d(r24, r111));
        AnimatorSet r42 = new AnimatorSet();
        r42.playTogether(new Animator[]{r38, r39, r41});
        r42.setDuration(200);
        r42.addListener(new g(r110, r25));
        r42.start();
        r24.a = r42;
        return;
    L87:
        r112 = 0;
        goto L88
    L153:
        return;
    L21:
        if (r8 != ZoomInAnimationEndStrategy.PASSIVE_WAIT) goto L40;
        List<k> r43 = this.a.a;
        if ((r43 instanceof Collection) == true) goto L25;
    L27:
        Iterator r44 = ((ArrayList) r43).iterator();
    L29:
        if (r44.hasNext() == false) goto L37;
        if (((k) r44.next()).c != ZoomInAnimationAction.SHOW) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L29;
        boolean r45 = true;
    L38:
        if (r45 == false) goto L40;
    L33:
        r113 = false;
    L37:
        r45 = false;
        goto L38
    L25:
        if (((ArrayList) r43).isEmpty() == false) goto L27;
    L40:
        r9 = false;
        goto L42
    L145:
        return;
    L7:
        if (r4 != 4) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    L89:
        k r46 = (k) ((LinkedHashMap) this.k).get(ZoomInAnimationAction.HIDE);
        k r47 = (k) ((LinkedHashMap) this.k).get(ZoomInAnimationAction.SHOW);
        if (r46 == null) goto L127;
        StringBuilder r48 = new StringBuilder("startZoomOut:");
        k r49 = this.e;
        if (r49 == null) goto L94;
        String r50 = r49.a;
    L95:
        r48.append(r50);
        r48.append("===============");
        r3.d("ZoomInAnimationManager", r48.toString());
        a(ZoomInAnimationState.ZOOM_OUT);
        Set<String> r51 = w.a;
        k r52 = this.e;
        String r53 = "";
        if (r52 == null) goto L99;
        String r54 = r52.a;
        if (r54 == null) goto L99;
    L100:
        w.a(r54);
        final f r55 = (f) this.h.getValue();
        boolean r56 = ic8.q.a(this.j);
        k r57 = this.e;
        if (r57 == null) goto L103;
        String r58 = r57.a;
    L104:
        if (r58 == null) goto L107;
        r53 = r58;
    L107:
        if (r57 == null) goto L111;
        c r59 = r57.e;
        if (r59 == null) goto L111;
        int r114 = r59.a;
    L112:
        ?? r60 = new q(this);
        r55.getClass();
        Intrinsics.checkNotNullParameter(r53, "animationId");
        Intrinsics.checkNotNullParameter(r60, "onZoomOutEnd");
        ObjectAnimator r61 = ObjectAnimator.ofFloat(r55.c, "alpha", new float[]{1.0f, 0.0f});
        r61.addListener(new h(r55));
        ObjectAnimator r62 = ObjectAnimator.ofFloat(r55.d, "alpha", new float[]{0.0f, 1.0f});
        ViewGroup r63 = r55.d;
        if (r63 == null) goto L116;
        Context r64 = r63.getContext();
        if (r64 == null) goto L116;
    L122:
        if (r56 == false) goto L124;
        int r65 = 0;
    L125:
        ValueAnimator r66 = ValueAnimator.ofInt(new int[]{r114, r65});
        r66.addUpdateListener(new e(r55));
        AnimatorSet r67 = new AnimatorSet();
        r67.playTogether(new Animator[]{r61, r62, r66});
        r67.setDuration(200);
        r67.addListener(new i(r60, r53));
        r67.start();
        r55.a = r67;
        return;
    L124:
        int r68 = FolderContainerView.o;
        Intrinsics.checkNotNullParameter(r64, "context");
        dh8.b.a.getClass();
        Intrinsics.checkNotNullParameter(r64, "context");
        r65 = dh8.b.e(dh8.b.b(r64));
    L116:
        FrameLayout r69 = r55.c;
        if (r69 == null) goto L119;
        r14 = r69.getContext();
    L119:
        if (r14 != null) goto L121;
        r64 = AppHost.a.getApplication();
        goto L122
    L121:
        r64 = r14;
    L111:
        r114 = 0;
        goto L112
    L103:
        r58 = null;
    L99:
        r54 = "";
        goto L100
    L94:
        r50 = null;
        goto L95
    L127:
        if (r47 == null) goto L147;
        View r70 = this.c;
        if (r70 == null) goto L148;
        jc8.a r71 = r47.b.a;
        k r72 = this.e;
        if (r72 == null) goto L136;
        j r73 = r72.b;
        if (r73 == null) goto L136;
        r14 = r73.a;
    L136:
        if (r71.e(r14) == true) goto L149;
        this.e = r47;
        r47.d.d(r70, r47.b.a);
        s r74 = this.f;
        if (r74 == null) goto L150;
        Function1<j, Unit> r75 = r74.d;
        if (r75 == null) goto L151;
        r75.invoke(r47.b);
        return;
    L151:
        return;
    L150:
        return;
    L149:
        return;
    L148:
        return;
    }

    public final void c(k r5, String r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("enqueue executing animation queue==item action:");
        String r2 = null;
        if (r5 == null) goto L5;
        ZoomInAnimationAction r3 = r5.c;
    L6:
        r1.append(r3);
        r1.append(" animationid:");
        if (r5 == null) goto L9;
        String r4 = r5.a;
    L10:
        r1.append(r4);
        r1.append("===from:");
        r1.append(r6);
        r0.d("ZoomInAnimationManager", r1.toString());
        if (r5 != null) goto L13;
        return;
    L13:
        String r7 = r5.a;
        k r8 = this.e;
        if (r8 == null) goto L17;
        r2 = r8.a;
    L17:
        if (Intrinsics.areEqual(r7, r2) == true) goto L19;
        return;
    L19:
        ZoomInAnimationAction r9 = r5.c;
        ZoomInAnimationAction r10 = ZoomInAnimationAction.HIDE;
        if (r9 != r10) goto L23;
        ((LinkedHashMap) this.k).clear();
        this.k.put(r10, r5);
        return;
    L23:
        if (this.k.containsKey(r10) == false) goto L25;
        return;
    L25:
        this.k.put(r5.c, r5);
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
