package com.bytedance.android.live.liveinteract.animation.glflymic;

import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.gl.primitive.Axis;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.animation.tasklet.d;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.utils.v;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.n;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k50.f;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GLIconMoveAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public final com.bytedance.android.live.liveinteract.animation.glflymic.a c;
    public final List<String> d;
    public final CompositeDisposable e;
    public volatile boolean f;
    public final q50.a g;
    public final e h;
    public final Map<String, Integer> i;
    public final Function2<d, Boolean, Unit> j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GLIconMoveAnimationTasklet a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;
        public final /* synthetic */ EPointF d;
        public final /* synthetic */ EPointF e;

        public b(GLIconMoveAnimationTasklet r1, Map r2, String r3, EPointF r4, EPointF r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r18) {
            Long r1 = (Long) r18;
            if (this.a.f == true) goto L9;
            StringBuilder r2 = new StringBuilder("start exception.resource doesn't prepared.size:");
            List r4 = (List) this.b.get(this.c);
            if (r4 == null) goto L7;
            Integer r5 = Integer.valueOf(r4.size());
        L8:
            r2.append(r5);
            ALogger.e("InteractAnimation.GLIconMoveAnimationTasklet", r2.toString());
            goto L9
        L7:
            r5 = null;
        L9:
            final GLIconMoveAnimationTasklet r6 = this.a;
            String r7 = this.c;
            final EPointF r8 = this.d;
            final EPointF r9 = this.e;
            e r3 = r6.h;
            if (r3 == null) goto L12;
            int r10 = r3.qq(1);
        L13:
            float r11 = r10 * 0.83f;
            q50.a r12 = r6.g;
            if (r12 == null) goto L16;
            n50.a r13 = r12.b;
        L17:
            if (r13 == null) goto L43;
            Map r14 = r13.c;
            if (r14 == null) goto L43;
            final List r15 = (List) ((LinkedHashMap) r14).get(r7);
            if (r15 == null) goto L43;
            int r16 = r50.b.d;
            r50.b.b r17 = new r50.b.b();
            r17.f = ((Number) ListProtector.get(r15, 0)).intValue();
            c r19 = new c(r6.c);
            Intrinsics.checkNotNullParameter(r19, "adapter");
            r17.g = r19;
            r17.b(r11, r11);
            final r50.b r20 = r17.a();
            m50.d r110 = ((r50.a) r20).c;
            Shaders r111 = Shaders.DEFAULT_TEXTURE_SHADER;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "shader");
            r110.b = r111.ordinal();
            com.bytedance.android.live.core.gl.primitive.d r112 = r110.c;
            c r113 = new c(r6.c);
            r112.getClass();
            Intrinsics.checkNotNullParameter(r113, "adapter");
            r112.f = r113;
            r110.c.d(0.0f, 0.0f, 0.1f);
            com.bytedance.android.live.core.gl.primitive.d r114 = r110.c;
            double r21 = ((Math.atan2(((PointF) r9).y - ((PointF) r8).y, ((PointF) r9).x - ((PointF) r8).x) * ((double) 180)) / 3.141592653589793d) - ((double) 90);
            double r115 = 360;
            com.bytedance.android.live.core.gl.primitive.e r22 = r114.b;
            r22.a = 0.0f;
            r22.b = 0.0f;
            r22.c = -((float) ((r21 + r115) % r115));
            r22.d = true;
            l50.a r116 = new l50.a();
            int[] r23 = CollectionsKt.toIntArray(r15);
            long r117 = r6.b.getDuration();
            q50.a r118 = r6.g;
            if (r118 == null) goto L27;
            n50.a r119 = r118.b;
        L28:
            if (r119 == null) goto L40;
            Map r120 = r119.c;
            if (r120 == null) goto L40;
            String r121 = r7;
            List r122 = (List) ((LinkedHashMap) r120).get(r121);
            if (r122 == null) goto L41;
            int r123 = r122.size();
            if (r123 == 0) goto L41;
            float r24 = (r117 * 1.0f) / r123;
            ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "getFrameTime.frame:" + r123 + ",duration:" + r117 + ",result:" + r24);
            if (r24 <= 0.1f) goto L41;
        L42:
            h50.b r25 = new h50.b(r23, r24);
            r25.a = false;
            Unit r0 = Unit.INSTANCE;
            r116.b(r25);
            float[] r26 = r6.c.a(((PointF) r8).x, ((PointF) r8).y);
            float[] r27 = r6.c.a(((PointF) r9).x, ((PointF) r9).y);
            h50.a r28 = new h50.a(Axis.X, r27[0], r26[0]);
            r28.a = false;
            r116.b(r28);
            h50.a r29 = new h50.a(Axis.Y, r27[1], r26[1]);
            r29.a = false;
            r116.b(r29);
            final String r30 = r121;
            Function0<Unit> r31 = new GLIconMoveAnimationTasklet$createSingleIconMoveAnimationTexture$$inlined$apply$lambda$1(r6, r15, r30, r8, r9, r20);
            Intrinsics.checkNotNullParameter(r31, "cb");
            r116.c = r31;
            ((r50.a) r20).a = r116;
            r50.b r32 = r20;
        L45:
            if (r32 == null) goto L52;
            q50.a r33 = this.a.g;
            if (r33 == null) goto L53;
            n50.a r34 = r33.b;
            if (r34 == null) goto L54;
            r34.a(r32);
            return;
        L54:
            return;
        L53:
            return;
        L52:
            return;
        L41:
            r24 = 50.0f;
        L40:
            r121 = r7;
            goto L41
        L27:
            r119 = null;
        L43:
            r32 = null;
            goto L45
        L16:
            r13 = null;
            goto L17
        L12:
            r10 = 0;
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.b
    public final void a() {
        ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "prepare resource");
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(this.a.d.b);
        if ((!((ArrayList) this.d).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.IconMoveAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        List<k> r1 = this.b.getResources();
        if (r1 == null) goto L38;
        k r2 = (k) ListProtector.get(r1, 0);
        if (r2 == null) goto L39;
        List r3 = r2.getUrls();
        if (r3 == null) goto L40;
        final String r4 = (String) ListProtector.get(r3, 0);
        if (r4 == null) goto L42;
        q50.a r5 = this.g;
        final o50.b r6 = null;
        if (r5 == null) goto L18;
        n50.a r7 = r5.b;
    L19:
        if (r7 == null) goto L41;
        final Map r8 = r7.c;
        if (r8 != null) goto L24;
        return;
    L24:
        if (r8.containsKey(r4) == false) goto L27;
        ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "prepare resource cached: ".concat(r4));
        return;
    L27:
        ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "prepare resource: ".concat(r4));
        p50.c r0 = new p50.c();
        q50.a r9 = this.g;
        if (r9 == null) goto L36;
        n50.a r10 = r9.b;
        if (r10 == null) goto L36;
        f r11 = r10.b;
        if (r11 == null) goto L36;
        k50.d r12 = r11.a;
        if (r12 == null) goto L36;
        r6 = r12.a;
    L36:
        r0.b(UriProtector.parse(r4), new GLIconMoveAnimationTasklet$prepare$1(this, r6, r8, r4));
        return;
    L41:
        return;
    L18:
        r7 = null;
        goto L19
    L42:
        return;
    L40:
        return;
    L39:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "start animation");
        if (this.h != null) goto L5;
        return;
    L5:
        q50.a r0 = this.g;
        if (r0 == null) goto L8;
        n50.a r1 = r0.b;
    L9:
        if (r1 == null) goto L55;
        Map r8 = r1.c;
        if (r8 == null) goto L59;
        int r9 = ((ArrayList) this.d).size();
        int r11 = 0;
    L14:
        if (r11 >= r9) goto L60;
        String r2 = (String) ListProtector.get(this.d, r11);
        EPointF r4 = this.h.Mj(r2);
        if (r4 != null) goto L18;
    L53:
        Map r16 = r8;
    L54:
        r11 = r11 + 1;
        r8 = r16;
        goto L14
    L18:
        if (v.a(r4) == true) goto L53;
        PointF r3 = this.a.d.a;
        if (r3 == null) goto L23;
        EPointF r5 = v.b(r3);
    L24:
        if (r5 != null) goto L35;
        int r6 = this.b.getX();
        int r7 = this.b.getY();
        n r10 = this.a.c;
        if (r10 == null) goto L53;
        int r12 = r10.b;
        int r13 = r10.c;
        float r14 = r10.d;
        float r15 = r10.e;
        float r17 = (r7 * 1.0f) / r13;
        PointF r18 = r10.a;
        float r19 = ((r6 * 1.0f) / r12) * r14;
        float r110 = 0.0f;
        if (r18 == null) goto L30;
        float r111 = r18.x;
    L31:
        float r20 = r19 + r111;
        float r21 = r17 * r15;
        if (r18 == null) goto L34;
        r110 = r18.y;
    L34:
        EPointF r22 = new EPointF(r20, r21 + r110);
    L37:
        if (v.a(r22) == true) goto L53;
        int[] r23 = new int[2];
        this.h.vj().getLocationOnScreen(r23);
        float r24 = ((PointF) r22).x;
        float r112 = r23[0];
        ((PointF) r22).x = r24 - r112;
        float r25 = ((PointF) r22).y;
        float r26 = r23[1];
        ((PointF) r22).y = r25 - r26;
        ((PointF) r4).x -= r112;
        ((PointF) r4).y -= r26;
        Integer r27 = this.i.get(r2);
        if (r27 == null) goto L42;
        int r28 = r27.intValue();
    L43:
        int r29 = this.b.getOffsetStart();
        double r113 = 0.5f;
        r16 = r8;
        double r30 = 2;
        float r31 = ((float) ((Math.random() - r113) * r30)) * UtilityKotlinExtentionsKt.i(r29);
        float r32 = ((float) ((Math.random() - r113) * r30)) * UtilityKotlinExtentionsKt.i(r29);
        ((PointF) r22).x += r31;
        ((PointF) r22).y += r32;
        List<k> r33 = this.b.getResources();
        if (r33 == null) goto L51;
        k r34 = (k) ListProtector.get(r33, 0);
        if (r34 == null) goto L51;
        List r35 = r34.getUrls();
        if (r35 == null) goto L51;
        String r36 = (String) ListProtector.get(r35, 0);
        if (r36 == null) goto L51;
    L52:
        RxUtilKt.c(Observable.timer(r28, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r16, r36, r4, r22)), this.e);
    L51:
        r36 = "";
        goto L52
    L42:
        r28 = 0;
        goto L43
    L30:
        r111 = 0.0f;
        goto L31
    L35:
        r22 = r5;
        goto L37
    L23:
        r5 = null;
        goto L24
    L60:
        return;
    L59:
        return;
    L55:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        ALogger.d("InteractAnimation.GLIconMoveAnimationTasklet", "stop animation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GLIconMoveAnimationTasklet(p r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3, q50.a r4, e r5, Map<String, Integer> r6, Function2<? super d, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mDelayMap");
        super(r2, r3);
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        if (r4 == null) goto L5;
        GLSurfaceView r8 = r4.a;
    L6:
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(r8, "view");
        float r9 = 0.0f;
        if (r4 == null) goto L11;
        GLSurfaceView r10 = r4.a;
        if (r10 == null) goto L11;
        float r11 = r10.getWidth();
    L12:
        if (r4 == null) goto L16;
        GLSurfaceView r12 = r4.a;
        if (r12 == null) goto L16;
        r9 = r12.getHeight();
    L16:
        this.c = new com.bytedance.android.live.liveinteract.animation.glflymic.a(r11, r9, ((r8.getHeight() * 1.0f) / r8.getWidth()) * 375.0f);
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
        return;
    L11:
        r11 = 0.0f;
        goto L12
    L5:
        r8 = null;
        goto L6
    }
}
