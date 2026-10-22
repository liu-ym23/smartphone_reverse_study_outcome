package com.bytedance.android.live.liveinteract.animation.glflymic;

import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.animation.tasklet.d;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.utils.v;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.f;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.g;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GLPathAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public static final /* synthetic */ int m = 0;
    public final com.bytedance.android.live.liveinteract.animation.glflymic.a c;
    public final List<String> d;
    public EPointF e;
    public final CompositeDisposable f;
    public volatile boolean g;
    public k h;
    public final q50.a i;
    public final e j;
    public final Map<String, Integer> k;
    public final Function2<d, Boolean, Unit> l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GLPathAnimationTasklet a;
        public final /* synthetic */ k b;
        public final /* synthetic */ EPointF c;

        public b(GLPathAnimationTasklet r1, k r2, EPointF r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r15) {
            Long r16 = (Long) r15;
            List r17 = this.b.getUrls();
            if (r17 == null) goto L54;
            final String r18 = (String) ListProtector.get(r17, 0);
            if (r18 == null) goto L58;
            n50.a r1 = this.a.b();
            if (r1 == null) goto L55;
            Map r2 = r1.c;
            if (r2 == null) goto L59;
            final r50.b r4 = null;
            if (this.a.g == true) goto L19;
            StringBuilder r3 = new StringBuilder("start exception.resource doesn't prepared.size:");
            List r5 = (List) ((LinkedHashMap) r2).get(r18);
            if (r5 == null) goto L17;
            Integer r6 = Integer.valueOf(r5.size());
        L18:
            r3.append(r6);
            ALogger.e("InteractAnimation.GLPathAnimationTasklet", r3.toString());
            goto L19
        L17:
            r6 = null;
        L19:
            final GLPathAnimationTasklet r7 = this.a;
            EPointF r8 = r7.e;
            EPointF r9 = this.c;
            if (r8 == null) goto L49;
            if (r9 == null) goto L49;
            float r10 = ((PointF) r8).x - ((PointF) r9).x;
            float r11 = ((PointF) r8).y - ((PointF) r9).y;
            int r12 = (int) Math.sqrt((r10 * r10) + (r11 * r11));
            k r13 = r7.h;
            if (r13 == null) goto L49;
            float r14 = r12;
            int r19 = (int) ((r14 / r13.getHeight()) * r13.getWidth());
            float r110 = 2;
            EPointF r20 = new EPointF((((PointF) r8).x + ((PointF) r9).x) / r110, (((PointF) r8).y + ((PointF) r9).y) / r110);
            double r111 = 360;
            float r21 = (float) (((((Math.atan2(((PointF) r8).y - ((PointF) r9).y, ((PointF) r8).x - ((PointF) r9).x) * ((double) 180)) / 3.141592653589793d) - ((double) 90)) + r111) % r111);
            ALogger.d("InteractAnimation.GLPathAnimationTasklet", "playTransitionAnimation. position:" + r20 + ",rotation:" + r21);
            n50.a r22 = r7.b();
            if (r22 == null) goto L49;
            Map r23 = r22.c;
            if (r23 == null) goto L49;
            final List r24 = (List) ((LinkedHashMap) r23).get(r18);
            if (r24 == null) goto L49;
            int r25 = r50.b.d;
            r50.b.b r26 = new r50.b.b();
            r26.f = ((Number) ListProtector.get(r24, 0)).intValue();
            c r27 = new c(r7.c);
            Intrinsics.checkNotNullParameter(r27, "adapter");
            r26.g = r27;
            r26.b(r19, r14);
            r4 = r26.a();
            m50.d r28 = ((r50.a) r4).c;
            Shaders r29 = Shaders.DEFAULT_TEXTURE_SHADER;
            r28.getClass();
            Intrinsics.checkNotNullParameter(r29, "shader");
            r28.b = r29.ordinal();
            com.bytedance.android.live.core.gl.primitive.d r30 = r28.c;
            com.bytedance.android.live.core.gl.primitive.e r31 = r30.b;
            r31.a = 0.0f;
            r31.b = 0.0f;
            r31.c = -r21;
            r31.d = true;
            c r32 = new c(r7.c);
            r30.getClass();
            Intrinsics.checkNotNullParameter(r32, "adapter");
            r30.f = r32;
            r28.c.d(((PointF) r20).x, ((PointF) r20).y, 0.5f);
            l50.a r33 = new l50.a();
            int[] r34 = CollectionsKt.toIntArray(r24);
            n50.a r35 = r7.b();
            if (r35 == null) goto L47;
            Map r36 = r35.c;
            if (r36 == null) goto L47;
            long r37 = r7.b.getDuration();
            List r38 = (List) ((LinkedHashMap) r36).get(r18);
            if (r38 == null) goto L47;
            int r39 = r38.size();
            if (r39 == 0) goto L47;
            float r112 = (r37 * 1.0f) / r39;
            ALogger.d("InteractAnimation.GLPathAnimationTasklet", "getFrameTime.frame:" + r39 + ",duration:" + r37 + ",result:" + r112);
            if (r112 <= 0.1f) goto L47;
        L48:
            h50.b r40 = new h50.b(r34, r112);
            r40.a = false;
            Unit r0 = Unit.INSTANCE;
            r33.b(r40);
            Function0<Unit> r41 = new GLPathAnimationTasklet$playSingleEffectPathAnimation$$inlined$apply$lambda$1(r7, r24, r18, r4);
            Intrinsics.checkNotNullParameter(r41, "cb");
            r33.c = r41;
            ((r50.a) r4).a = r33;
        L47:
            r112 = 50.0f;
        L49:
            if (r4 == null) goto L56;
            n50.a r113 = this.a.b();
            if (r113 == null) goto L57;
            r113.a(r4);
            return;
        L57:
            return;
        L56:
            return;
        L59:
            return;
        L55:
            return;
        L58:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.b
    public final void a() {
        ALogger.d("InteractAnimation.GLPathAnimationTasklet", "prepare resource");
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(this.a.d.b);
        final o50.b r2 = null;
        if (((ArrayList) this.d).isEmpty() == false) goto L6;
        ALogger.e("InteractAnimation.PathEffectAnimationTasklet", "parseAnimationResourceData#toUserIds is empty");
    L5:
        boolean r7 = false;
    L27:
        if (r7 == true) goto L30;
        ALogger.e("InteractAnimation.GLPathAnimationTasklet", "start#resource parse failed.");
        return;
    L30:
        f r0 = this.b;
        if (r0 == null) goto L35;
        List<k> r1 = r0.getResources();
        if (r1 == null) goto L35;
        k r3 = (k) ListProtector.get(r1, 0);
    L36:
        this.h = r3;
        if (r3 == null) goto L61;
        List r4 = r3.getUrls();
        if (r4 == null) goto L62;
        final String r5 = (String) ListProtector.get(r4, 0);
        if (r5 == null) goto L64;
        n50.a r6 = b();
        if (r6 == null) goto L63;
        final Map r8 = r6.c;
        if (r8 != null) goto L49;
        return;
    L49:
        if (r8.containsKey(r5) == false) goto L52;
        ALogger.d("InteractAnimation.GLPathAnimationTasklet", "prepare resource cached: ".concat(r5));
        return;
    L52:
        ALogger.d("InteractAnimation.GLPathAnimationTasklet", "prepare resource: ".concat(r5));
        p50.c r9 = new p50.c();
        n50.a r10 = b();
        if (r10 == null) goto L59;
        k50.f r11 = r10.b;
        if (r11 == null) goto L59;
        k50.d r12 = r11.a;
        if (r12 == null) goto L59;
        r2 = r12.a;
    L59:
        r9.b(UriProtector.parse(r5), new GLPathAnimationTasklet$prepare$1(this, r2, r8, r5));
        return;
    L63:
        return;
    L64:
        return;
    L62:
        return;
    L61:
        return;
    L35:
        r3 = null;
        goto L36
    L6:
        e r13 = this.j;
        Intrinsics.checkNotNull(r13);
        n r14 = this.a.c;
        if (r14 == null) goto L9;
        PointF r15 = r14.a;
    L10:
        int[] r16 = new int[2];
        r13.vj().getLocationOnScreen(r16);
        n r17 = this.a.c;
        r7 = true;
        if (r17 == null) goto L20;
        int r18 = r17.b;
        int r19 = r17.c;
        float r110 = r17.d;
        float r20 = r17.e;
        float r111 = (this.b.getX() * 1.0f) / r18;
        float r21 = (this.b.getY() * 1.0f) / r19;
        float r112 = (r111 * r110) - r16[0];
        float r113 = 0.0f;
        if (r15 == null) goto L15;
        float r114 = r15.x;
    L16:
        float r115 = r112 + r114;
        float r22 = (r21 * r20) - r16[1];
        if (r15 == null) goto L19;
        r113 = r15.y;
    L19:
        EPointF r23 = new EPointF(r115, r22 + r113);
    L21:
        if (r23 == null) goto L5;
        PointF r24 = this.a.d.a;
        if (r24 == null) goto L26;
        r23 = v.b(r24);
    L26:
        int r25 = this.b.getOffsetStart();
        double r116 = 0.5f;
        double r26 = 2;
        float r27 = ((float) ((Math.random() - r116) * r26)) * UtilityKotlinExtentionsKt.i(r25);
        float r28 = ((float) ((Math.random() - r116) * r26)) * UtilityKotlinExtentionsKt.i(r25);
        ((PointF) r23).x += r27;
        ((PointF) r23).y += r28;
        this.e = r23;
        goto L27
    L15:
        r114 = 0.0f;
        goto L16
    L20:
        r23 = null;
        goto L21
    L9:
        r15 = null;
        goto L10
    }

    public final n50.a b() {
        n r0 = this.a.c;
        n50.a r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.f;
    L6:
        if (r2 != null) goto L8;
    L11:
        int r3 = 5;
    L12:
        int r4 = this.b.getLevel();
        if (r4 > 0) goto L15;
        r4 = 6;
    L15:
        g r5 = this.a.a;
        if (r5 == null) goto L18;
        GLSurfaceView r6 = r5.b();
    L19:
        q50.a r7 = this.i;
        if (r7 == null) goto L22;
        GLSurfaceView r8 = r7.a;
    L23:
        if (r6 == null) goto L25;
        n50.a r9 = k50.e.a(r6);
    L26:
        if (r8 == null) goto L31;
        n50.a r10 = k50.e.a(r8);
        if (r10 == null) goto L31;
        r1 = r10;
    L34:
        if (r4 < r3) goto L38;
        if (r9 == null) goto L38;
        return r9;
    L38:
        return r1;
    L31:
        q50.a r11 = this.i;
        if (r11 == null) goto L34;
        r1 = r11.b;
        goto L34
    L25:
        r9 = null;
        goto L26
    L22:
        r8 = null;
        goto L23
    L18:
        r6 = null;
        goto L19
    L8:
        if (r2.intValue() <= 0) goto L11;
        r3 = r2.intValue();
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ALogger.d("InteractAnimation.GLPathAnimationTasklet", "start animation");
        e r0 = this.j;
        Intrinsics.checkNotNull(r0);
        int[] r1 = new int[2];
        r0.vj().getLocationOnScreen(r1);
        int r2 = ((ArrayList) this.d).size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L16;
        String r5 = (String) ListProtector.get(this.d, r4);
        EPointF r6 = r0.Mj(r5);
        if (r6 == null) goto L15;
        ((PointF) r6).x -= r1[0];
        ((PointF) r6).y -= r1[1];
        k r7 = this.h;
        if (r7 == null) goto L15;
        ALogger.i("InteractAnimation.PathEffectAnimationTasklet", "loadAnimationResources#select:" + r7 + ".width:" + r7.getWidth() + ",height:" + r7.getHeight());
        Integer r8 = this.k.get(r5);
        if (r8 == null) goto L13;
        long r9 = r8.intValue();
    L14:
        RxUtilKt.c(Observable.timer(r9, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r7, r6)), this.f);
        goto L15
    L13:
        r9 = 0;
    L15:
        r4 = r4 + 1;
        goto L3
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        ALogger.d("InteractAnimation.GLPathAnimationTasklet", "stop animation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GLPathAnimationTasklet(p r2, f r3, q50.a r4, e r5, Map<String, Integer> r6, Function2<? super d, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mDelayMap");
        super(r2, r3);
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
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
        this.f = new CompositeDisposable();
        return;
    L11:
        r11 = 0.0f;
        goto L12
    L5:
        r8 = null;
        goto L6
    }
}
