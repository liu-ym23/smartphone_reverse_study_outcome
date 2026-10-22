package com.bytedance.android.live.liveinteract.animation.glflymic;

import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.animation.tasklet.d;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.p;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
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
import kotlin.text.StringsKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GLMicSeatAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public final com.bytedance.android.live.liveinteract.animation.glflymic.a c;
    public final List<String> d;
    public final CompositeDisposable e;
    public volatile boolean f;
    public k g;
    public final q50.a h;
    public final e i;
    public final Map<String, Integer> j;
    public final String k;
    public final int l;
    public final boolean m;
    public final Function2<d, Boolean, Unit> n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GLMicSeatAnimationTasklet a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ EPointF c;
        public final /* synthetic */ int d;

        public b(GLMicSeatAnimationTasklet r1, Map r2, EPointF r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r17) {
            Long r1 = (Long) r17;
            if (this.a.f == true) goto L13;
            k r2 = this.a.g;
            if (r2 == null) goto L7;
            String r3 = wc0.a.a(r2);
        L8:
            StringBuilder r4 = new StringBuilder("start exception.resource doesn't prepared.size:");
            List r5 = (List) this.b.get(r3);
            if (r5 == null) goto L11;
            Integer r6 = Integer.valueOf(r5.size());
        L12:
            r4.append(r6);
            ALogger.e("InteractAnimation.GLMicSeatAnimationTasklet", r4.toString());
            goto L13
        L11:
            r6 = null;
            goto L12
        L7:
            r3 = null;
        L13:
            final GLMicSeatAnimationTasklet r7 = this.a;
            EPointF r8 = this.c;
            e r9 = r7.i;
            Intrinsics.checkNotNull(r9);
            float r10 = r9.ma(0, 1) / 1.2f;
            k r11 = r7.g;
            if (r11 == null) goto L46;
            final String r12 = wc0.a.a(r11);
            if (r12 == null) goto L46;
            q50.a r13 = r7.h;
            if (r13 == null) goto L21;
            n50.a r14 = r13.b;
        L22:
            if (r14 == null) goto L46;
            Map r15 = r14.c;
            if (r15 == null) goto L46;
            final List r16 = (List) ((LinkedHashMap) r15).get(r12);
            if (r16 == null) goto L46;
            int r18 = r50.b.d;
            r50.b.b r19 = new r50.b.b();
            r19.f = ((Number) ListProtector.get(r16, 0)).intValue();
            c r110 = new c(r7.c);
            Intrinsics.checkNotNullParameter(r110, "adapter");
            r19.g = r110;
            r19.b(r10, r10);
            final r50.b r20 = r19.a();
            m50.d r21 = ((r50.a) r20).c;
            Shaders r111 = Shaders.DEFAULT_TEXTURE_SHADER;
            r21.getClass();
            Intrinsics.checkNotNullParameter(r111, "shader");
            r21.b = r111.ordinal();
            com.bytedance.android.live.core.gl.primitive.d r112 = r21.c;
            c r113 = new c(r7.c);
            r112.getClass();
            Intrinsics.checkNotNullParameter(r113, "adapter");
            r112.f = r113;
            r21.c.d(((PointF) r8).x, ((PointF) r8).y, 0.1f);
            l50.a r22 = new l50.a();
            int[] r114 = CollectionsKt.toIntArray(r16);
            long r115 = r7.b.getDuration();
            q50.a r116 = r7.h;
            if (r116 == null) goto L32;
            n50.a r117 = r116.b;
        L33:
            if (r117 == null) goto L44;
            Map r118 = r117.c;
            if (r118 == null) goto L44;
            List r119 = (List) ((LinkedHashMap) r118).get(r12);
            if (r119 == null) goto L44;
            int r120 = r119.size();
            if (r120 == 0) goto L44;
            float r23 = (r115 * 1.0f) / r120;
            ALogger.d("InteractAnimation.GLMicSeatAnimationTasklet", "getFrameTime.frame:" + r120 + ",duration:" + r115 + ",result:" + r23);
            if (r23 <= 0.1f) goto L44;
        L45:
            h50.b r24 = new h50.b(r114, r23);
            r24.a = false;
            Unit r25 = Unit.INSTANCE;
            r22.b(r24);
            Function0<Unit> r26 = new GLMicSeatAnimationTasklet$createMicSeatTextureModel$$inlined$apply$lambda$1(r7, r16, r12, r20);
            Intrinsics.checkNotNullParameter(r26, "cb");
            r22.c = r26;
            ((r50.a) r20).a = r22;
        L47:
            if (r20 == null) goto L53;
            q50.a r27 = this.a.h;
            if (r27 == null) goto L53;
            n50.a r28 = r27.b;
            if (r28 == null) goto L53;
            r28.a(r20);
        L53:
            GLMicSeatAnimationTasklet r29 = this.a;
            String r30 = r29.b.getSoundUrl();
            if (r30 == null) goto L69;
            e r31 = null;
            if (StringsKt.endsWith$default(r30, "null", false, 2, null) == true) goto L69;
            e r32 = r29.i;
            if (r32 == null) goto L69;
            if ((r32 instanceof InteractAnimationController.d) == false) goto L63;
            r31 = r32;
        L63:
            InteractAnimationController.d r33 = (InteractAnimationController.d) r31;
            if (r33 == null) goto L68;
            EmojiSoundManager r34 = InteractAnimationController.d.a.c(r33);
            if (r34 == null) goto L68;
            r34.e(r29.k, r30, r29.l);
        L68:
            r32.Mb(r29.k, r30, r29.l);
        L69:
            GLMicSeatAnimationTasklet r35 = this.a;
            int r36 = this.d;
            if (r35.i != null) goto L72;
            return;
        L72:
            if (r35.b.getReshape() == true) goto L74;
            return;
        L74:
            if (r35.m == true) goto L82;
            long r37 = r35.b.getSizeScale();
            e r38 = r35.i;
            if (r37 != 0) goto L78;
            r37 = 1000;
        L78:
            r38.Ka(r36, r37 / 1000.0f);
            return;
        L82:
            return;
        L44:
            r23 = 50.0f;
            goto L45
        L32:
            r117 = null;
            goto L33
        L21:
            r14 = null;
        L46:
            r20 = null;
            goto L47
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.b
    public final void a() {
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(this.a.d.b);
        if ((!((ArrayList) this.d).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.GLMicSeatAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        List<k> r0 = this.b.getResources();
        final o50.b r2 = null;
        if (r0 == null) goto L15;
        int r3 = this.a.b.g - 1;
        if (vm2.d.F() == false) goto L17;
        if (r3 < 0) goto L17;
        if (r3 >= r0.size()) goto L15;
        k r1 = (k) ListProtector.get(r0, r3);
    L18:
        if (r1 != null) goto L20;
        return;
    L20:
        this.g = r1;
        final String r4 = wc0.a.a(r1);
        if (r4 != null) goto L23;
        return;
    L23:
        q50.a r5 = this.h;
        if (r5 == null) goto L26;
        n50.a r6 = r5.b;
    L27:
        if (r6 == null) goto L46;
        final Map r7 = r6.c;
        if (r7 != null) goto L32;
        return;
    L32:
        if (r7.containsKey(r4) == false) goto L35;
        ALogger.d("InteractAnimation.GLMicSeatAnimationTasklet", "prepare resource cached: ".concat(r4));
        return;
    L35:
        ALogger.d("InteractAnimation.GLMicSeatAnimationTasklet", "prepare resource: ".concat(r4));
        p50.c r8 = new p50.c();
        q50.a r9 = this.h;
        if (r9 == null) goto L44;
        n50.a r10 = r9.b;
        if (r10 == null) goto L44;
        f r11 = r10.b;
        if (r11 == null) goto L44;
        k50.d r12 = r11.a;
        if (r12 == null) goto L44;
        r2 = r12.a;
    L44:
        r8.b(UriProtector.parse(r4), new GLMicSeatAnimationTasklet$prepare$1(this, r2, r7, r4));
        return;
    L46:
        return;
    L26:
        r6 = null;
    L17:
        r1 = (k) ListProtector.get(r0, (int) (this.a.b.f % ((long) r0.size())));
    L15:
        r1 = null;
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        if (this.h != null) goto L5;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        ALogger.d("InteractAnimation.GLMicSeatAnimationTasklet", "start animation");
        e r2 = this.i;
        Intrinsics.checkNotNull(r2);
        int r4 = 2;
        int[] r5 = new int[2];
        r2.vj().getLocationOnScreen(r5);
        q50.a r6 = this.h;
        if (r6 == null) goto L14;
        n50.a r7 = r6.b;
    L15:
        if (r7 == null) goto L39;
        Map r8 = r7.c;
        if (r8 == null) goto L43;
        int r9 = ((ArrayList) this.d).size();
        GLMicSeatAnimationTasklet r10 = this;
        int r11 = 0;
    L20:
        if (r11 >= r9) goto L44;
        String r12 = (String) ListProtector.get(r10.d, r11);
        EPointF r13 = r2.Mj(r12);
        if (r13 == null) goto L28;
        int r14 = r2.zl(r12);
        if (r14 > 0) goto L27;
    L29:
        Integer r15 = r10.j.get(r12);
        if (r15 == null) goto L32;
        int r16 = r15.intValue();
    L34:
        if (r10.a.b.e == false) goto L36;
        long r17 = 0;
    L37:
        double r3 = 0.5f;
        double r18 = r4;
        int[] r19 = r5;
        int r20 = (int) r17;
        float r21 = ((float) ((Math.random() - r3) * r18)) * UtilityKotlinExtentionsKt.i(r20);
        float r22 = ((float) (r18 * (Math.random() - r3))) * UtilityKotlinExtentionsKt.i(r20);
        ((PointF) r13).x = (((PointF) r13).x - r19[0]) + r21;
        ((PointF) r13).y = (((PointF) r13).y - r19[1]) + r22;
        RxUtilKt.c(Observable.timer(r16, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r8, r13, r14)), this.e);
        GLMicSeatAnimationTasklet r23 = this;
    L38:
        r11 = r11 + 1;
        r9 = r9;
        r5 = r19;
        r4 = 2;
        r10 = r23;
        goto L20
    L36:
        r17 = r10.b.getOffset();
        goto L37
    L32:
        r16 = 0;
        goto L34
    L27:
        if (r2.Ed(r14) == true) goto L29;
    L28:
        r19 = r5;
        r23 = r10;
        goto L38
    L44:
        return;
    L43:
        return;
    L39:
        return;
    L14:
        r7 = null;
        goto L15
    L5:
        if (this.i == null) goto L8;
        r1 = true;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        if (this.h != null) goto L5;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        ALogger.d("InteractAnimation.GLMicSeatAnimationTasklet", "stop animation");
        return;
    L5:
        if (this.i == null) goto L8;
        r0 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GLMicSeatAnimationTasklet(p r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3, q50.a r4, e r5, Map<String, Integer> r6, String r7, int r8, boolean r9, Function2<? super d, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "animationData");
        Intrinsics.checkNotNullParameter(r6, "mDelayMap");
        Intrinsics.checkNotNullParameter(r7, "mTaskID");
        super(r2, r3);
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        this.m = r9;
        this.n = r10;
        if (r4 == null) goto L5;
        GLSurfaceView r11 = r4.a;
    L6:
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullParameter(r11, "view");
        float r12 = 0.0f;
        if (r4 == null) goto L11;
        GLSurfaceView r13 = r4.a;
        if (r13 == null) goto L11;
        float r14 = r13.getWidth();
    L12:
        if (r4 == null) goto L16;
        GLSurfaceView r15 = r4.a;
        if (r15 == null) goto L16;
        r12 = r15.getHeight();
    L16:
        this.c = new com.bytedance.android.live.liveinteract.animation.glflymic.a(r14, r12, ((r11.getHeight() * 1.0f) / r11.getWidth()) * 375.0f);
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
        return;
    L11:
        r14 = 0.0f;
        goto L12
    L5:
        r11 = null;
        goto L6
    }
}
