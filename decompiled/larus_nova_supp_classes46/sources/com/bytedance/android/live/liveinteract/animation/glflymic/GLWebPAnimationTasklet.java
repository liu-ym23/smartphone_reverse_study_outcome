package com.bytedance.android.live.liveinteract.animation.glflymic;

import android.graphics.PointF;
import android.opengl.GLSurfaceView;
import com.bytedance.android.live.core.gl.core.shader.Shaders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.animation.e;
import com.bytedance.android.live.liveinteract.animation.tasklet.d;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.g;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.n;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k50.f;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GLWebPAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {
    public static final /* synthetic */ int j = 0;
    public n c;
    public k d;
    public final com.bytedance.android.live.liveinteract.animation.glflymic.a e;
    public volatile boolean f;
    public final q50.a g;
    public final e h;
    public final Function2<d, Boolean, Unit> i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.b
    public final void a() {
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "prepare resource");
        n r0 = this.a.c;
        if (r0 != null) goto L5;
    L4:
        boolean r1 = false;
    L21:
        if (r1 == true) goto L24;
        ALogger.e("InteractAnimation.GLWebPAnimationTasklet", "start#resource parse failed.");
        return;
    L24:
        List<k> r2 = this.b.getResources();
        if (r2 == null) goto L52;
        k r3 = (k) ListProtector.get(r2, 0);
        if (r3 == null) goto L53;
        List r4 = r3.getUrls();
        if (r4 == null) goto L54;
        final String r5 = (String) ListProtector.get(r4, 0);
        if (r5 == null) goto L56;
        n50.a r6 = b();
        if (r6 == null) goto L55;
        final Map r7 = r6.c;
        if (r7 != null) goto L39;
        return;
    L39:
        if (r7.containsKey(r5) == false) goto L42;
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "prepare resource cached: ".concat(r5));
        return;
    L42:
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "prepare resource: ".concat(r5));
        p50.c r8 = new p50.c();
        n50.a r9 = b();
        if (r9 == null) goto L49;
        f r10 = r9.b;
        if (r10 == null) goto L49;
        k50.d r11 = r10.a;
        if (r11 == null) goto L49;
        final o50.b r12 = r11.a;
    L50:
        r8.b(UriProtector.parse(r5), new GLWebPAnimationTasklet$prepare$1(this, r12, r7, r5));
        return;
    L49:
        r12 = null;
        goto L50
    L55:
        return;
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        this.c = r0;
        if (this.h == null) goto L4;
        List<k> r13 = this.b.getResources();
        if (r13 == null) goto L4;
        if (r13.isEmpty() == true) goto L4;
        k r14 = (k) ListProtector.get(r13, 0);
        if (r14 == null) goto L4;
        if (r14.isValid() == false) goto L4;
        this.d = r14;
        r1 = true;
        goto L21
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
        r4 = 7;
    L15:
        g r5 = this.a.a;
        if (r5 == null) goto L18;
        GLSurfaceView r6 = r5.b();
    L19:
        q50.a r7 = this.g;
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
        q50.a r11 = this.g;
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
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "start animation");
        List<k> r2 = this.b.getResources();
        if (r2 == null) goto L67;
        k r3 = (k) ListProtector.get(r2, 0);
        if (r3 == null) goto L68;
        List r4 = r3.getUrls();
        if (r4 == null) goto L69;
        final String r5 = (String) ListProtector.get(r4, 0);
        if (r5 != null) goto L12;
        return;
    L12:
        if (this.f == true) goto L24;
        n50.a r6 = b();
        if (r6 == null) goto L23;
        Map r7 = r6.c;
        if (r7 == null) goto L66;
        StringBuilder r8 = new StringBuilder("start exception.resource doesn't prepared.size:");
        List r9 = (List) ((LinkedHashMap) r7).get(r5);
        if (r9 == null) goto L21;
        Integer r10 = Integer.valueOf(r9.size());
    L22:
        r8.append(r10);
        ALogger.e("InteractAnimation.GLWebPAnimationTasklet", r8.toString());
        goto L24
    L21:
        r10 = null;
        goto L22
    L66:
        return;
    L23:
        return;
    L24:
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "playTransitionAnimation");
        n r11 = this.c;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mMP4Info");
    L27:
        r11.getClass();
        int r12 = r11.b;
        int r13 = r11.c;
        double r14 = r11.d;
        double r15 = r12;
        double r16 = (r14 * 1.0d) / r15;
        double r17 = r11.e;
        double r18 = r13;
        double r19 = (r17 * 1.0d) / r18;
        k r20 = this.d;
        if (r20 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L30:
        int r21 = r20.getWidth();
        k r110 = this.d;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mWebPImageModel");
    L33:
        double r1 = ((double) r21) * r16;
        double r111 = ((double) r110.getHeight()) * r19;
        double r112 = (((double) this.b.getX()) * 1.0d) / r15;
        double r22 = (((double) this.b.getY()) * 1.0d) / r18;
        int[] r23 = new int[2];
        q50.a r24 = this.g;
        if (r24 == null) goto L38;
        GLSurfaceView r25 = r24.a;
        if (r25 == null) goto L38;
        r25.getLocationOnScreen(r23);
    L38:
        PointF r26 = r11.a;
        double r113 = ((r112 * r14) + ((double) r26.x)) - ((double) r23[0]);
        double r27 = ((r22 * r17) + ((double) r26.y)) - ((double) r23[1]);
        n50.a r28 = b();
        if (r28 == null) goto L60;
        Map r29 = r28.c;
        if (r29 == null) goto L60;
        final List r30 = (List) ((LinkedHashMap) r29).get(r5);
        if (r30 == null) goto L60;
        int r31 = r50.b.d;
        r50.b.b r32 = new r50.b.b();
        r32.f = ((Number) ListProtector.get(r30, 0)).intValue();
        c r33 = new c(this.e);
        Intrinsics.checkNotNullParameter(r33, "adapter");
        r32.g = r33;
        r32.b((float) r1, (float) r111);
        final r50.b r34 = r32.a();
        m50.d r35 = ((r50.a) r34).c;
        Shaders r36 = Shaders.DEFAULT_TEXTURE_SHADER;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r36, "shader");
        r35.b = r36.ordinal();
        com.bytedance.android.live.core.gl.primitive.d r37 = r35.c;
        c r38 = new c(this.e);
        r37.getClass();
        Intrinsics.checkNotNullParameter(r38, "adapter");
        r37.f = r38;
        r35.c.d((float) r113, (float) r27, 0.1f);
        l50.a r39 = new l50.a();
        int[] r40 = CollectionsKt.toIntArray(r30);
        n50.a r41 = b();
        if (r41 == null) goto L58;
        Map r42 = r41.c;
        if (r42 == null) goto L58;
        long r43 = this.b.getDuration();
        List r44 = (List) ((LinkedHashMap) r42).get(r5);
        if (r44 == null) goto L58;
        int r45 = r44.size();
        if (r45 == 0) goto L58;
        float r114 = (r43 * 1.0f) / r45;
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "getFrameTime.frame:" + r45 + ",duration:" + r43 + ",result:" + r114);
        if (r114 <= 0.1f) goto L58;
    L59:
        h50.b r46 = new h50.b(r40, r114);
        r46.a = false;
        Unit r47 = Unit.INSTANCE;
        r39.b(r46);
        Function0<Unit> r48 = new GLWebPAnimationTasklet$playTransitionAnimation$$inlined$apply$lambda$1(this, r30, r5, r34);
        Intrinsics.checkNotNullParameter(r48, "cb");
        r39.c = r48;
        ((r50.a) r34).a = r39;
        r50.b r49 = r34;
    L61:
        if (r49 == null) goto L70;
        n50.a r50 = b();
        if (r50 == null) goto L71;
        r50.a(r49);
        return;
    L71:
        return;
    L70:
        return;
    L58:
        r114 = 50.0f;
    L60:
        r49 = null;
        goto L61
    L69:
        return;
    L68:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        ALogger.d("InteractAnimation.GLWebPAnimationTasklet", "stop animation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GLWebPAnimationTasklet(p r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3, q50.a r4, e r5, Function2<? super d, ? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "revenueData");
        Intrinsics.checkNotNullParameter(r3, "animationData");
        super(r2, r3);
        this.g = r4;
        this.h = r5;
        this.i = r6;
        if (r4 == null) goto L5;
        GLSurfaceView r7 = r4.a;
    L6:
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullParameter(r7, "view");
        float r8 = 0.0f;
        if (r4 == null) goto L11;
        GLSurfaceView r9 = r4.a;
        if (r9 == null) goto L11;
        float r10 = r9.getWidth();
    L12:
        if (r4 == null) goto L16;
        GLSurfaceView r11 = r4.a;
        if (r11 == null) goto L16;
        r8 = r11.getHeight();
    L16:
        this.e = new com.bytedance.android.live.liveinteract.animation.glflymic.a(r10, r8, ((r7.getHeight() * 1.0f) / r7.getWidth()) * 375.0f);
        return;
    L11:
        r10 = 0.0f;
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
