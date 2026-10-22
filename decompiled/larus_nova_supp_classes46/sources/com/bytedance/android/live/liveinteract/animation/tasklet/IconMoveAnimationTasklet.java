package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.n0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class IconMoveAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public static final /* synthetic */ int r = 0;
    public final List<String> c;
    public final List<HSImageView> d;
    public final AnimatorSet e;
    public final Set<Animatable> f;
    public final Set<Animatable> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public ImageRequest k;
    public final com.bytedance.android.live.liveinteract.animation.c l;
    public final com.bytedance.android.live.liveinteract.animation.e m;
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a n;
    public final Map<String, Integer> o;
    public final int p;
    public final Function2<d, Boolean, Unit> q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IconMoveAnimationTasklet a;

        public b(IconMoveAnimationTasklet r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IconMoveAnimationTasklet r0 = this.a;     // Catch: Throwable -> L6
            if (r0.i == true) goto L9;
            IconMoveAnimationTasklet.c(r0);     // Catch: Throwable -> L6
            this.a.i = true;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(this.a.d.b);
        int r8 = 1;
        if ((!((ArrayList) this.c).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.IconMoveAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        this.h = true;
        ((ArrayList) this.d).clear();
        FrameLayout r0 = this.m.vj();
        int r1 = ((ArrayList) this.c).size();
        ?? r9 = 0;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        HSImageView r3 = this.n.b();
        r0.addView(r3);
        d(r3, this.p);
        ((ArrayList) this.d).add(r3);
        r2 = r2 + 1;
        goto L7
    L9:
        final long r4 = SystemClock.uptimeMillis();
        Function1<Boolean, Unit> r10 = new AnonymousClass1(this, r4);
        if (((ArrayList) this.d).isEmpty() == false) goto L12;
    L41:
        this.m.vj().postDelayed(new b(this), 200);
        return;
    L12:
        if (((ArrayList) this.d).size() != ((ArrayList) this.c).size()) goto L41;
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = 0;
        Ref.IntRef r12 = new Ref.IntRef();
        r12.element = 0;
        int r13 = ((ArrayList) this.c).size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L41;
        HSImageView r15 = (HSImageView) ListProtector.get(this.d, r14);
        List<py.k> r5 = this.b.getResources();
        if (r5 == null) goto L40;
        if (r5.size() == 0) goto L40;
        FrameLayout r6 = this.m.vj();
        UtilityKotlinExtentionsKt.w(r15);
        ImageRequest[] r7 = a1.b((py.k) ListProtector.get(r5, r9), r8);
        Uri r16 = null;
        if (this.k != null) goto L28;
        if (r7 == null) goto L26;
        ImageRequest r17 = r7[r9];
    L27:
        this.k = r17;
        goto L28
    L26:
        r17 = null;
    L28:
        PipelineDraweeController r18 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r7).setAutoPlayAnimations(r9).setControllerListener(new h(this, r6, r15, r11, r12, r10)).build();
        if (vm2.d.G() == false) goto L39;
        if ((r18 instanceof PipelineDraweeController) == false) goto L39;
        PipelineDraweeController r19 = r18;
        Context r20 = r15.getContext();
        if (r7 == null) goto L37;
        ImageRequest r21 = r7[0];
        if (r21 == null) goto L37;
        r16 = r21.getSourceUri();
    L37:
        com.bytedance.android.live.core.utils.fresco.c.a(r19, r20, String.valueOf(r16));
    L39:
        r15.setController(r18);
    L40:
        r14 = r14 + 1;
        r8 = 1;
        r9 = 0;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        DraweeController r1 = ((HSImageView) r0.next()).getController();
        if (r1 == null) goto L4;
        Animatable r2 = r1.getAnimatable();
        if (r2 == null) goto L4;
        r2.stop();
        goto L4
    L10:
        this.e.end();
        this.e.removeAllListeners();
        Iterator<T> r3 = this.e.getChildAnimations().iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        Animator r4 = (Animator) r3.next();
        if ((r4 instanceof ValueAnimator) == false) goto L12;
        r4.removeAllListeners();
        ((ValueAnimator) r4).removeAllUpdateListeners();
        goto L12
    L16:
        Iterator r5 = ((ArrayList) this.d).iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        ((HSImageView) r5.next()).setController(null);
        goto L18
    L20:
        FrameLayout r6 = this.m.vj();
        r6.post(new j(this, r6));
        this.h = false;
    }

    public static final void b(IconMoveAnimationTasklet r2) {
        Function2<d, Boolean, Unit> r0 = r2.q;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r2, Boolean.FALSE);
    L5:
        r2.l.i();
        r2.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache r3 = com.bytedance.android.live.core.utils.fresco.e.a;
        if (r3 == null) goto L10;
        r3.removeAll(new g(r2));
    L10:
        r2.j = true;
    }

    public static final void c(IconMoveAnimationTasklet r22) {
        if (((ArrayList) r22.d).isEmpty() == false) goto L5;
        return;
    L5:
        if (((ArrayList) r22.d).size() != ((ArrayList) r22.c).size()) goto L56;
        int r9 = ((ArrayList) r22.c).size();
        char r10 = 0;
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L50;
        String r0 = (String) ListProtector.get(r22.c, r11);
        EPointF r12 = r22.m.Mj(r0);
        if (r12 == null) goto L49;
        if (com.bytedance.android.live.liveinteract.utils.v.a(r12) == true) goto L49;
        PointF r1 = r22.a.d.a;
        if (r1 == null) goto L17;
        EPointF r2 = com.bytedance.android.live.liveinteract.utils.v.b(r1);
    L19:
        if (r2 != null) goto L31;
        int r3 = r22.b.getX();
        int r5 = r22.b.getY();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r6 = r22.a.c;
        if (r6 == null) goto L49;
        int r7 = r6.b;
        int r13 = r6.c;
        float r14 = r6.d;
        float r15 = r6.e;
        float r8 = (r5 * 1.0f) / r13;
        PointF r16 = r6.a;
        float r4 = ((r3 * 1.0f) / r7) * r14;
        if (r16 == null) goto L25;
        float r17 = r16.x;
    L26:
        float r18 = r4 + r17;
        float r19 = r8 * r15;
        if (r16 == null) goto L29;
        float r20 = r16.y;
    L30:
        EPointF r110 = new EPointF(r18, r19 + r20);
    L33:
        if (com.bytedance.android.live.liveinteract.utils.v.a(r110) == true) goto L49;
        int[] r21 = new int[2];
        r22.m.vj().getLocationOnScreen(r21);
        float r23 = ((PointF) r110).x;
        float r24 = r21[r10];
        ((PointF) r110).x = r23 - r24;
        float r25 = ((PointF) r110).y;
        float r26 = r21[1];
        ((PointF) r110).y = r25 - r26;
        ((PointF) r12).x -= r24;
        ((PointF) r12).y -= r26;
        Integer r27 = r22.o.get(r0);
        if (r27 == null) goto L38;
        int r28 = r27.intValue();
    L39:
        int r29 = r22.b.getOffsetStart();
        double r30 = 0.5f;
        double r111 = 2;
        float r31 = ((float) ((Math.random() - r30) * r111)) * UtilityKotlinExtentionsKt.i(r29);
        float r32 = ((float) ((Math.random() - r30) * r111)) * UtilityKotlinExtentionsKt.i(r29);
        ((PointF) r110).x += r31;
        ((PointF) r110).y += r32;
        HSImageView r112 = (HSImageView) ListProtector.get(r22.d, r11);
        UtilityKotlinExtentionsKt.w(r112);
        r112.setRotation(n0.a(r110, r12));
        DraweeController r33 = r112.getController();
        if (r33 == null) goto L42;
        Animatable r113 = r33.getAnimatable();
    L43:
        long r34 = r22.b.getDuration();
        long r35 = r28;
        int r114 = r22.p;
        Ref.BooleanRef r36 = new Ref.BooleanRef();
        r36.element = r22.m.si();
        l r37 = new l();
        Object[] r38 = new Object[2];
        r38[r10] = r110;
        r38[1] = r12;
        ValueAnimator r39 = ValueAnimator.ofObject(r37, r38);
        if (r34 > 0) goto L47;
        r34 = 1200;
    L47:
        r39.setDuration(r34);
        r39.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        EPointF r40 = r110;
        r39.addUpdateListener(new e(r22, r112, r40, r12, r36, r114, r113));
        r39.addListener(new f(r22, r112, r40, r12, r114, r113));
        r39.setStartDelay(r35);
        r22.e.playTogether(new Animator[]{r39});
        goto L49
    L42:
        r113 = null;
        goto L43
    L38:
        r28 = 0;
        goto L39
    L29:
        r20 = 0.0f;
        goto L30
    L25:
        r17 = 0.0f;
        goto L26
    L31:
        r110 = r2;
        goto L33
    L17:
        r2 = null;
    L49:
        r11 = r11 + 1;
        r9 = r9;
        r10 = 0;
        goto L8
    L50:
        r22.e.start();
        return;
    }

    public final void d(HSImageView r4, int r5) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.width = (int) (this.m.qq(r5) * 0.83f);
        r0.height = (int) (this.m.qq(r5) * 0.83f);
        r4.setLayoutParams(r0);
    }

    public IconMoveAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.animation.c r3, com.bytedance.android.live.liveinteract.animation.e r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r5, com.bytedance.android.live.liveinteract.animation.tasklet.a r6, Map r7, Function2 r8) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "mTask");
        Intrinsics.checkNotNullParameter(r4, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mViewProvider");
        Intrinsics.checkNotNullParameter(r7, "mDelayMap");
        super(r2, r5);
        this.l = r3;
        this.m = r4;
        this.n = r6;
        this.o = r7;
        this.p = 1;
        this.q = r8;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new AnimatorSet();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
    }
}
