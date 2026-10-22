package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PathEffectAnimationTasklet extends b {
    public static final /* synthetic */ int s = 0;
    public final List<String> c;
    public final List<HSImageView> d;
    public EPointF e;
    public final List<EPointF> f;
    public final List<py.k> g;
    public FrameLayout h;
    public final Set<Animatable> i;
    public final Set<Animatable> j;
    public boolean k;
    public ImageRequest l;
    public final com.bytedance.android.live.liveinteract.animation.c m;
    public final com.bytedance.android.live.liveinteract.animation.e n;
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a o;
    public final Map<String, Integer> p;
    public final int q;
    public final Function2<d, Boolean, Unit> r;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.c).clear();
        ((ArrayList) this.c).addAll(this.a.d.b);
        DraweeController r7 = null;
        char r9 = 1;
        int r10 = 0;
        if (((ArrayList) this.c).isEmpty() == false) goto L6;
        ALogger.e("InteractAnimation.PathEffectAnimationTasklet", "parseAnimationResourceData#toUserIds is empty");
    L5:
        boolean r0 = false;
    L44:
        if (r0 == true) goto L47;
        ALogger.e("InteractAnimation.PathEffectAnimationTasklet", "start#resource parse failed.");
        return;
    L47:
        int r11 = -1;
        if (this.h == null) goto L62;
        ((ArrayList) this.d).clear();
        int r1 = this.b.getLevel();
        int r2 = ((ArrayList) this.c).size();
        int r3 = 0;
    L51:
        if (r3 >= r2) goto L62;
        View r4 = this.o.b();
        FrameLayout r5 = this.h;
        Intrinsics.checkNotNull(r5);
        int r6 = r5.getChildCount();
        int r12 = 0;
    L53:
        if (r12 >= r6) goto L60;
        FrameLayout r13 = this.h;
        Intrinsics.checkNotNull(r13);
        Object r14 = r13.getChildAt(r12).getTag();
        if ((r14 instanceof com.bytedance.android.live.liveinteract.animation.a) == false) goto L59;
        if (((com.bytedance.android.live.liveinteract.animation.a) r14).a <= r1) goto L59;
    L61:
        FrameLayout r8 = this.h;
        Intrinsics.checkNotNull(r8);
        r8.addView(r4, r12);
        ((ArrayList) this.d).add(r4);
        r3 = r3 + 1;
    L59:
        r12 = r12 + 1;
        goto L53
    L60:
        r12 = -1;
    L62:
        final long r15 = SystemClock.uptimeMillis();
        new AnonymousClass1(this, r15);
        if (this.e == null) goto L116;
        FrameLayout r16 = this.h;
        if (r16 != null) goto L69;
        return;
    L69:
        if (((ArrayList) this.d).isEmpty() == false) goto L71;
        return;
    L71:
        if (((ArrayList) this.d).size() != ((ArrayList) this.c).size()) goto L118;
        int[] r17 = new int[2];
        FrameLayout r18 = this.h;
        if (r18 == null) goto L76;
        r18.getLocationOnScreen(r17);
    L76:
        int r19 = ((ArrayList) this.c).size();
        int r110 = 0;
    L77:
        if (r110 >= r19) goto L119;
        String r20 = (String) ListProtector.get(this.c, r110);
        EPointF r21 = this.n.Mj(r20);
        if (r21 == null) goto L100;
        ((PointF) r21).x -= r17[r10];
        ((PointF) r21).y -= r17[r9];
        ((ArrayList) this.f).add(r21);
        EPointF r22 = this.e;
        Intrinsics.checkNotNull(r22);
        float r23 = ((PointF) r22).x - ((PointF) r21).x;
        float r24 = ((PointF) r22).y - ((PointF) r21).y;
        float r25 = (float) Math.sqrt((r23 * r23) + (r24 * r24));
        float r26 = this.n.qq(this.q);
        List<py.k> r27 = this.b.getResources();
        py.k r28 = (py.k) ListProtector.get(r27, r10);
        Iterator<py.k> r29 = r27.iterator();
        float r111 = Float.MAX_VALUE;
    L83:
        if (r29.hasNext() == false) goto L88;
        py.k r112 = r29.next();
        float r30 = ((r25 / r112.getHeight()) * r112.getWidth()) - r26;
        if (Math.abs(r30) >= Math.abs(r111)) goto L83;
        r111 = r30;
        r28 = r112;
        goto L83
    L88:
        if (r28 == null) goto L100;
        ((ArrayList) this.g).add(r28);
        ALogger.i("InteractAnimation.PathEffectAnimationTasklet", "loadAnimationResources#select:" + r28 + ".width:" + r28.getWidth() + ",height:" + r28.getHeight());
        HSImageView r31 = (HSImageView) ListProtector.get(this.d, r110);
        r31.setController(r7);
        UtilityKotlinExtentionsKt.w(r31);
        ImageRequest[] r32 = a1.b(r28, r11);
        if (r32 == null) goto L95;
        int r33 = r32.length;
        int r34 = 0;
    L93:
        if (r34 >= r33) goto L95;
        ImageRequest r113 = r32[r34];
        CountingMemoryCache r114 = com.bytedance.android.live.core.utils.fresco.e.a;
        Fresco.getImagePipeline().prefetchToDiskCache(r113, r7);
        r34 = r34 + 1;
    L95:
        Integer r35 = this.p.get(r20);
        if (r35 == null) goto L98;
        long r36 = r35.intValue();
    L99:
        r31.postDelayed(new v(this, r28, r31, r16, r21), r36);
        goto L100
    L98:
        r36 = 0;
    L100:
        r110 = r110 + 1;
        r7 = null;
        r9 = 1;
        r10 = 0;
        r11 = -1;
        goto L77
    L119:
        return;
    L118:
        return;
    L116:
        return;
    L6:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r37 = this.a.c;
        if (r37 == null) goto L11;
        Integer r38 = r37.f;
        if (r38 == null) goto L11;
        int r39 = r38.intValue();
    L12:
        int r40 = this.b.getLevel();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r41 = this.a.a;
        if (r41 == null) goto L15;
        FrameLayout r42 = r41.a();
    L16:
        if (r40 < r39) goto L19;
        if (r42 == null) goto L19;
    L20:
        this.h = r42;
        if (r42 == null) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r43 = this.a.c;
        if (r43 == null) goto L26;
        PointF r44 = r43.a;
    L27:
        int[] r45 = new int[2];
        r42.getLocationOnScreen(r45);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r46 = this.a.c;
        if (r46 == null) goto L37;
        int r47 = r46.b;
        int r48 = r46.c;
        float r115 = r46.d;
        float r49 = r46.e;
        float r116 = (this.b.getX() * 1.0f) / r47;
        float r50 = (this.b.getY() * 1.0f) / r48;
        float r117 = (r116 * r115) - r45[0];
        float r118 = 0.0f;
        if (r44 == null) goto L32;
        float r119 = r44.x;
    L33:
        float r120 = r117 + r119;
        float r51 = (r50 * r49) - r45[1];
        if (r44 == null) goto L36;
        r118 = r44.y;
    L36:
        EPointF r52 = new EPointF(r120, r51 + r118);
    L38:
        if (r52 == null) goto L5;
        PointF r53 = this.a.d.a;
        if (r53 == null) goto L43;
        r52 = com.bytedance.android.live.liveinteract.utils.v.b(r53);
    L43:
        int r54 = this.b.getOffsetStart();
        double r121 = 0.5f;
        double r122 = 2;
        float r55 = ((float) ((Math.random() - r121) * r122)) * UtilityKotlinExtentionsKt.i(r54);
        float r56 = ((float) ((Math.random() - r121) * r122)) * UtilityKotlinExtentionsKt.i(r54);
        ((PointF) r52).x += r55;
        ((PointF) r52).y += r56;
        this.e = r52;
        r0 = true;
        goto L44
    L32:
        r119 = 0.0f;
        goto L33
    L37:
        r52 = null;
        goto L38
    L26:
        r44 = null;
    L19:
        r42 = this.n.vj();
        goto L20
    L15:
        r42 = null;
    L11:
        r39 = 5;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((HSImageView) r0.next()).setController(null);
        goto L4
    L6:
        FrameLayout r1 = this.h;
        if (r1 == null) goto L11;
        r1.post(new x(this));
        return;
    }

    public static final void b(PathEffectAnimationTasklet r2, ImageRequest r3) {
        Function2<d, Boolean, Unit> r0 = r2.r;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r2, Boolean.FALSE);
    L5:
        r2.m.i();
        r2.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache r4 = com.bytedance.android.live.core.utils.fresco.e.a;
        if (r4 == null) goto L10;
        r4.removeAll(new t(r3));
    L10:
        r2.k = true;
    }

    public PathEffectAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.animation.c r3, com.bytedance.android.live.liveinteract.animation.e r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r5, com.bytedance.android.live.liveinteract.animation.tasklet.a r6, Map r7, Function2 r8) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "mTask");
        Intrinsics.checkNotNullParameter(r4, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mViewProvider");
        Intrinsics.checkNotNullParameter(r7, "mDelayMap");
        super(r2, r5);
        this.m = r3;
        this.n = r4;
        this.o = r6;
        this.p = r7;
        this.q = 1;
        this.r = r8;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
    }
}
