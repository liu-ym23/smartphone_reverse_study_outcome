package com.bytedance.android.live.liveinteract.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y extends com.bytedance.android.live.liveinteract.animation.c {
    public com.bytedance.android.live.liveinteract.animation.e d;
    public HSImageView e;
    public HSImageView f;
    public HSImageView g;
    public HSImageView h;
    public HSImageView i;
    public String j;
    public String k;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j l;
    public Animator m;
    public final CompositeDisposable n;
    public InteractAnimationController.c o;
    public boolean p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ y a;

        public b(y r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.f;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.removeView(this.a.f);     // Catch: Throwable -> L8
            List<HSImageView> r2 = l0.a;     // Catch: Throwable -> L8
            HSImageView r3 = this.a.f;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L8
            l0.c(r3);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ y a;

        public c(y r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.e;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.removeView(this.a.e);     // Catch: Throwable -> L8
            List<HSImageView> r2 = l0.a;     // Catch: Throwable -> L8
            HSImageView r3 = this.a.e;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L8
            l0.c(r3);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ y a;

        public d(y r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.g;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.removeView(this.a.g);     // Catch: Throwable -> L8
            List<HSImageView> r2 = l0.a;     // Catch: Throwable -> L8
            HSImageView r3 = this.a.g;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L8
            l0.c(r3);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ y a;

        public e(y r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.h;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.removeView(this.a.h);     // Catch: Throwable -> L8
            List<HSImageView> r2 = l0.a;     // Catch: Throwable -> L8
            HSImageView r3 = this.a.h;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L8
            l0.c(r3);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ y a;

        public f(y r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r0 = this.a.i;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.removeView(this.a.i);     // Catch: Throwable -> L8
            List<HSImageView> r2 = l0.a;     // Catch: Throwable -> L8
            HSImageView r3 = this.a.i;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L8
            l0.c(r3);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class g extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ y a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ EPointF d;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onFailure(String r3, Throwable r4) {
            ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask" + this.a.b, "sender emoji load failed " + r4);
            y r5 = this.a;
            r5.h(r5);
            r5.s(false);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            Intrinsics.checkNotNullParameter(r1, "id");
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask" + this.a.b, "sender emoji load success");
            ((AnimatedDrawable2) r3).setAnimationListener(new i0(this));
            return;
        }

        public g(y r1, Ref.ObjectRef r2, Ref.ObjectRef r3, EPointF r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class h extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ y a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.f b;
        public final /* synthetic */ EPointF c;
        public final /* synthetic */ EPointF d;
        public final /* synthetic */ EPointF e;
        public final /* synthetic */ int f;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onFailure(String r2, Throwable r3) {
            ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "path emoji load failed " + r3);
            y r4 = this.a;
            r4.h(r4);
            r4.s(false);
        }

        public final void onFinalImageSet(String r11, Object r12, Animatable r13) {
            ImageInfo r14 = (ImageInfo) r12;
            Intrinsics.checkNotNullParameter(r11, "id");
            if ((r13 instanceof AnimatedDrawable2) == false) goto L17;
            y r15 = this.a;
            AnimatedDrawable2 r16 = (AnimatedDrawable2) r13;
            long r0 = this.b.getDuration();
            EPointF r17 = this.c;
            EPointF r6 = this.d;
            EPointF r2 = this.e;
            int r7 = this.f;
            if (r15.d != null) goto L8;
        L15:
            r16.setAnimationListener(new j0());
            return;
        L8:
            if (r15.e == null) goto L15;
            Ref.BooleanRef r5 = new Ref.BooleanRef();
            com.bytedance.android.live.liveinteract.animation.e r3 = r15.d;
            Intrinsics.checkNotNull(r3);
            r5.element = r3.si();
            ValueAnimator r8 = ValueAnimator.ofObject(new com.bytedance.android.live.liveinteract.utils.f(r2), new Object[]{r17, r6});
            if (r0 > 0) goto L14;
            r0 = 1200;
        L14:
            r8.setDuration(r0);
            r8.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r8.addUpdateListener(new z(r15, r7, r17, r6, r5));
            r8.addListener(new a0(r15, r7, r17, r6, r16));
            Unit r18 = Unit.INSTANCE;
            r15.m = r8;
            r8.start();
            goto L15
        }

        public h(y r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r2, EPointF r3, EPointF r4, EPointF r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.d = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        s(false);
        HSImageView r0 = this.f;
        if (r0 == null) goto L5;
        r0.postDelayed(new b(this), 100);
    L5:
        HSImageView r1 = this.e;
        if (r1 == null) goto L8;
        r1.postDelayed(new c(this), 100);
    L8:
        HSImageView r2 = this.g;
        if (r2 == null) goto L11;
        r2.postDelayed(new d(this), 100);
    L11:
        HSImageView r3 = this.h;
        if (r3 == null) goto L14;
        r3.postDelayed(new e(this), 100);
    L14:
        HSImageView r4 = this.i;
        if (r4 == null) goto L18;
        r4.postDelayed(new f(this), 100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        this.n.add(Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h0(this)));
        com.bytedance.android.live.liveinteract.animation.e r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.l != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        int r1 = r0.zl(this.j);
        com.bytedance.android.live.liveinteract.animation.e r2 = this.d;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.zl(this.k);
        if (r1 == r3) goto L112;
        if (r1 < 0) goto L112;
        if (r3 < 0) goto L112;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r4 = this.l;
        if (r4 == null) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r5 = r4.getInteractEmoji();
        if (r5 == null) goto L21;
        if (r5.isValid() == true) goto L21;
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "invalid emoji since data invalid");
        return;
    L21:
        com.bytedance.android.live.liveinteract.animation.e r6 = this.d;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "seatInfoProvider");
        if (l0.b() == false) goto L24;
        this.f = l0.a();
    L26:
        if (l0.b() == false) goto L28;
        this.e = l0.a();
    L30:
        if (l0.b() == false) goto L32;
        this.g = l0.a();
    L34:
        if (l0.b() == false) goto L36;
        this.h = l0.a();
    L38:
        if (l0.b() == false) goto L40;
        this.i = l0.a();
    L41:
        r6.vj().addView(this.f);
        r6.vj().addView(this.e);
        r6.vj().addView(this.g);
        r6.vj().addView(this.h);
        r6.vj().addView(this.i);
        com.bytedance.android.live.liveinteract.animation.e r7 = this.d;
        Intrinsics.checkNotNull(r7);
        if (r7.wc(this.j) == false) goto L44;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(true, r1);
        com.bytedance.android.live.liveinteract.animation.e r8 = this.d;
        Intrinsics.checkNotNull(r8);
        r8.Bn(this.j);
    L44:
        com.bytedance.android.live.liveinteract.animation.e r9 = this.d;
        Intrinsics.checkNotNull(r9);
        if (r9.wc(this.k) == false) goto L47;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(false, r3);
        com.bytedance.android.live.liveinteract.animation.e r10 = this.d;
        Intrinsics.checkNotNull(r10);
        r10.Bn(this.k);
    L47:
        StringBuilder r11 = new StringBuilder("play ");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r12 = this.l;
        Intrinsics.checkNotNull(r12);
        r11.append(r12.getEmojiName());
        r11.append(" from{");
        r11.append(this.j);
        r11.append(", ");
        r11.append(r1);
        r11.append("} to{");
        r11.append(this.k);
        r11.append(", ");
        r11.append(r3);
        r11.append('}');
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", r11.toString());
        String r13 = this.j;
        String r14 = this.k;
        com.bytedance.android.live.liveinteract.animation.e r15 = this.d;
        if (r15 != null) goto L51;
        return;
    L51:
        if (this.f != null) goto L54;
        return;
    L54:
        if (this.l == null) goto L116;
        Intrinsics.checkNotNull(r15);
        if (r15.Pf(r3) == false) goto L117;
        com.bytedance.android.live.liveinteract.animation.e r16 = this.d;
        Intrinsics.checkNotNull(r16);
        EPointF r17 = r16.C7(r1, r3);
        com.bytedance.android.live.liveinteract.animation.e r18 = this.d;
        Intrinsics.checkNotNull(r18);
        EPointF r19 = r18.Kl(r1, r3);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r20 = this.l;
        Intrinsics.checkNotNull(r20);
        System.currentTimeMillis();
        this.o = new InteractAnimationController.c(r20, r13, r14, false);
        int[] r21 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r22 = this.d;
        Intrinsics.checkNotNull(r22);
        r22.vj().getLocationOnScreen(r21);
        Intrinsics.checkNotNull(r17);
        ((PointF) r17).x -= r21[0];
        Intrinsics.checkNotNull(r17);
        ((PointF) r17).y -= r21[1];
        Intrinsics.checkNotNull(r19);
        ((PointF) r19).x -= r21[0];
        Intrinsics.checkNotNull(r19);
        ((PointF) r19).y -= r21[1];
        HSImageView r23 = this.h;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r24 = this.l;
        Intrinsics.checkNotNull(r24);
        n(r23, r1, r24.getEmojiCategory());
        HSImageView r25 = this.i;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r26 = this.l;
        Intrinsics.checkNotNull(r26);
        n(r25, r3, r26.getEmojiCategory());
        HSImageView r27 = this.h;
        if (r27 == null) goto L62;
        o(r27, r17);
    L62:
        HSImageView r28 = this.i;
        if (r28 == null) goto L65;
        o(r28, r19);
    L65:
        DraweeController r29 = null;
        if (this.d == null) goto L89;
        if (this.h == null) goto L89;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r30 = this.l;
        if (r30 == null) goto L76;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r31 = r30.interactEmoji();
        if (r31 == null) goto L76;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r32 = r31.getSenderEmoji();
    L77:
        if (r32 == null) goto L89;
        ImageRequest[] r33 = a1.b(r32.extraDynamicImage(), -1);
        HSImageView r34 = this.h;
        if (r34 == null) goto L81;
        UtilityKotlinExtentionsKt.w(r34);
    L81:
        HSImageView r35 = this.h;
        if (r35 == null) goto L89;
        PipelineDraweeControllerBuilder r36 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r33);
        HSImageView r37 = this.h;
        if (r37 == null) goto L86;
        DraweeController r38 = r37.getController();
    L87:
        r35.setController(r36.setOldController(r38).setAutoPlayAnimations(true).setControllerListener(new g0(this)).build());
        goto L89
    L86:
        r38 = null;
    L76:
        r32 = null;
    L89:
        if (this.d != null) goto L92;
    L110:
        q(r1, r3, false);
        return;
    L92:
        if (this.i == null) goto L110;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r39 = this.l;
        if (r39 == null) goto L99;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r40 = r39.interactEmoji();
        if (r40 == null) goto L99;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r41 = r40.getReceiverEmoji();
    L100:
        if (r41 == null) goto L110;
        ImageRequest[] r42 = a1.b(r41.extraDynamicImage(), -1);
        HSImageView r43 = this.i;
        if (r43 == null) goto L104;
        UtilityKotlinExtentionsKt.w(r43);
    L104:
        HSImageView r44 = this.i;
        if (r44 == null) goto L110;
        PipelineDraweeControllerBuilder r45 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r42);
        HSImageView r46 = this.i;
        if (r46 == null) goto L109;
        r29 = r46.getController();
    L109:
        r44.setController(r45.setOldController(r29).setAutoPlayAnimations(true).setControllerListener(new e0(this)).build());
    L99:
        r41 = null;
        goto L100
    L117:
        return;
    L116:
        return;
    L40:
        this.i = new HSImageView(r6.vj().getContext());
        goto L41
    L36:
        this.h = new HSImageView(r6.vj().getContext());
        goto L38
    L32:
        this.g = new HSImageView(r6.vj().getContext());
        goto L34
    L28:
        this.e = new HSImageView(r6.vj().getContext());
        goto L30
    L24:
        this.f = new HSImageView(r6.vj().getContext());
    L112:
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "invalid emoji since from=" + r1 + " to=" + r3);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.k;
    }

    public static final void m(y r6) {
        if (r6.d == null) goto L32;
        InteractAnimationController.c r0 = r6.o;
        if (r0 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r1 = r0.a;
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r2 = r1.interactEmoji();
        if (r2 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3 = r2.getReceiverEmoji();
    L13:
        com.bytedance.android.live.liveinteract.animation.e r4 = r6.d;
        Intrinsics.checkNotNull(r4);
        InteractAnimationController.c r5 = r6.o;
        if (r5 == null) goto L17;
        String r7 = r5.b;
        if (r7 == null) goto L17;
    L18:
        int r8 = r4.zl(r7);
        if (r3 != null) goto L21;
    L28:
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "won't play receiver animation for " + r3 + " invalid");
        r6.h(r6);
        r6.s(true);
        return;
    L21:
        if (r3.isValid() != true) goto L28;
        if (r8 <= 0) goto L27;
        com.bytedance.android.live.liveinteract.animation.e r9 = r6.d;
        Intrinsics.checkNotNull(r9);
        if (r9.Ed(r8) == true) goto L27;
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "won't play receiver animation for seat " + r8 + " invalid");
        r6.h(r6);
        r6.s(true);
        return;
    L27:
        r6.l();
        ImageRequest[] r10 = a1.b(r3.dynamicImage(), -1);
        HSImageView r11 = r6.g;
        Intrinsics.checkNotNull(r11);
        UtilityKotlinExtentionsKt.w(r11);
        HSImageView r12 = r6.g;
        Intrinsics.checkNotNull(r12);
        PipelineDraweeControllerBuilder r13 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r10);
        HSImageView r14 = r6.g;
        Intrinsics.checkNotNull(r14);
        r12.setController(r13.setOldController(r14.getController()).setAutoPlayAnimations(true).setControllerListener(new c0(r6)).build());
        return;
    L17:
        r7 = "";
    L12:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final boolean e(InteractAnimationController r4) {
        Intrinsics.checkNotNullParameter(r4, "interactAnimationController");
        if (r4.k(2) == false) goto L6;
        return false;
    L6:
        if (r4.k(1) == false) goto L9;
        return false;
    L9:
        if (r4.k(3) == false) goto L11;
        return false;
    L11:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r5 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r5 != null) goto L14;
    L16:
        return true;
    L14:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r5) != true) goto L16;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void g(com.bytedance.android.live.liveinteract.animation.e r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.d = r1;
    }

    public final void p(int r3) {
        HSImageView r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.d != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r2 = this.d;
        Intrinsics.checkNotNull(r2);
        r1.width = r2.qq(r3);
        com.bytedance.android.live.liveinteract.animation.e r4 = this.d;
        Intrinsics.checkNotNull(r4);
        r1.height = r4.qq(r3);
        HSImageView r5 = this.e;
        Intrinsics.checkNotNull(r5);
        r5.setLayoutParams(r1);
    }

    public final void s(boolean r2) {
        if (this.o != null) goto L5;
        return;
    L5:
        this.j = "";
        this.k = "";
        this.o = null;
        HSImageView r0 = this.e;
        if (r0 == null) goto L8;
        r0.setController(null);
    L8:
        HSImageView r1 = this.f;
        if (r1 == null) goto L11;
        r1.setController(null);
    L11:
        HSImageView r3 = this.g;
        if (r3 == null) goto L14;
        r3.setController(null);
    L14:
        HSImageView r4 = this.h;
        if (r4 == null) goto L17;
        r4.setController(null);
    L17:
        HSImageView r5 = this.i;
        if (r5 == null) goto L20;
        r5.setController(null);
    L20:
        this.n.dispose();
        this.a.clear();
        HSImageView r6 = this.e;
        if (r6 == null) goto L23;
        UtilityKotlinExtentionsKt.u(r6);
    L23:
        HSImageView r7 = this.f;
        if (r7 == null) goto L26;
        UtilityKotlinExtentionsKt.u(r7);
    L26:
        HSImageView r8 = this.g;
        if (r8 == null) goto L29;
        UtilityKotlinExtentionsKt.u(r8);
    L29:
        HSImageView r9 = this.h;
        if (r9 == null) goto L32;
        UtilityKotlinExtentionsKt.u(r9);
    L32:
        HSImageView r10 = this.i;
        if (r10 == null) goto L35;
        UtilityKotlinExtentionsKt.u(r10);
    L35:
        Animator r11 = this.m;
        if (r11 != null) goto L38;
        return;
    L38:
        if (r11.isRunning() != true) goto L44;
        Animator r12 = this.m;
        if (r12 == null) goto L45;
        r12.cancel();
        return;
    L45:
        return;
    }

    public y(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskID");
        super(r2, r3);
        this.j = "";
        this.k = "";
        this.n = new CompositeDisposable();
    }

    public final void o(HSImageView r3, EPointF r4) {
        r3.setX(((PointF) r4).x - (r3.getLayoutParams().width / 2));
        r3.setY(((PointF) r4).y - (r3.getLayoutParams().height / 2));
    }

    public final void n(HSImageView r3, int r4, int r5) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
    L8:
        if (r0 == null) goto L10;
        com.bytedance.android.live.liveinteract.animation.e r1 = this.d;
        Intrinsics.checkNotNull(r1);
        r0.width = r1.ma(r4, r5);
    L10:
        if (r0 == null) goto L12;
        com.bytedance.android.live.liveinteract.animation.e r2 = this.d;
        Intrinsics.checkNotNull(r2);
        r0.height = r2.ma(r4, r5);
    L12:
        if (r3 == null) goto L15;
        r3.setLayoutParams(r0);
        return;
    L15:
        return;
    L7:
        r0 = null;
        goto L8
    }

    public final void q(int r12, int r13, boolean r14) {
        if (this.l != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.animation.e r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        this.p = r14;
        Intrinsics.checkNotNull(r0);
        if (r0.Pf(r13) == true) goto L11;
        return;
    L11:
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r1 = this.d;
        Intrinsics.checkNotNull(r1);
        r15.element = r1.C7(r12, r13);
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r2.element = r3.Kl(r12, r13);
        com.bytedance.android.live.liveinteract.animation.e r4 = this.d;
        Intrinsics.checkNotNull(r4);
        EPointF r8 = r4.Se(r12, r13, (EPointF) r15.element, (EPointF) r2.element);
        int[] r5 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r6 = this.d;
        Intrinsics.checkNotNull(r6);
        r6.vj().getLocationOnScreen(r5);
        EPointF r7 = (EPointF) r15.element;
        Intrinsics.checkNotNull(r7);
        EPointF r9 = (EPointF) r15.element;
        ((PointF) r7).x = ((PointF) r9).x - r5[0];
        Intrinsics.checkNotNull(r9);
        ((PointF) r9).y = ((PointF) ((EPointF) r15.element)).y - r5[1];
        EPointF r10 = (EPointF) r2.element;
        Intrinsics.checkNotNull(r10);
        EPointF r11 = (EPointF) r2.element;
        ((PointF) r10).x = ((PointF) r11).x - r5[0];
        Intrinsics.checkNotNull(r11);
        ((PointF) r11).y = ((PointF) ((EPointF) r2.element)).y - r5[1];
        HSImageView r16 = this.f;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r17 = this.l;
        Intrinsics.checkNotNull(r17);
        n(r16, r12, r17.getEmojiCategory());
        HSImageView r18 = this.g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r19 = this.l;
        Intrinsics.checkNotNull(r19);
        n(r18, r13, r19.getEmojiCategory());
        HSImageView r110 = this.g;
        if (r110 == null) goto L14;
        o(r110, (EPointF) r2.element);
    L14:
        HSImageView r111 = this.f;
        if (r111 == null) goto L17;
        o(r111, (EPointF) r15.element);
    L17:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r112 = this.l;
        Intrinsics.checkNotNull(r112);
        p(r112.getEmojiCategory());
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r113 = this.l;
        if (r113 == null) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r114 = r113.interactEmoji();
        if (r114 == null) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r115 = r114.getSenderEmoji();
        if (r115 == null) goto L40;
        if (r115.isValid() != true) goto L40;
        com.bytedance.android.live.liveinteract.animation.e r116 = this.d;
        Intrinsics.checkNotNull(r116);
        if (r116.Ed(r12) == false) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r117 = this.l;
        if (r117 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r118 = r117.interactEmoji();
        if (r118 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r119 = r118.getSenderEmoji();
        if (r119 == null) goto L34;
        py.k r120 = r119.dynamicImage();
    L35:
        ImageRequest[] r121 = a1.b(r120, -1);
        Iterator<com.bytedance.android.live.liveinteract.animation.g> r122 = this.a.iterator();
    L37:
        if (r122.hasNext() == false) goto L39;
        r122.next().c();
        goto L37
    L39:
        HSImageView r123 = this.f;
        Intrinsics.checkNotNull(r123);
        PipelineDraweeControllerBuilder r124 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r121);
        HSImageView r20 = this.f;
        Intrinsics.checkNotNull(r20);
        r123.setController(r124.setOldController(r20.getController()).setAutoPlayAnimations(true).setControllerListener(new g(this, r15, r2, r8)).build());
        HSImageView r125 = this.f;
        Intrinsics.checkNotNull(r125);
        UtilityKotlinExtentionsKt.w(r125);
        int r126 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r127 = this.l;
        Intrinsics.checkNotNull(r127);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r128 = r127.interactEmoji();
        Intrinsics.checkNotNull(r128);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r129 = r128.getPathEmoji();
        Intrinsics.checkNotNull(r129);
        py.k r130 = r129.dynamicImage();
        Intrinsics.checkNotNull(r130);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r130);
    L41:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r131 = this.l;
        Intrinsics.checkNotNull(r131);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r132 = r131.interactEmoji();
        if (r132 == null) goto L50;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r133 = r132.getReceiverEmoji();
        if (r133 != null) goto L46;
        return;
    L46:
        if (r133.isValid() != true) goto L52;
        int r134 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r135 = this.l;
        Intrinsics.checkNotNull(r135);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r136 = r135.interactEmoji();
        Intrinsics.checkNotNull(r136);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r137 = r136.getReceiverEmoji();
        Intrinsics.checkNotNull(r137);
        py.k r138 = r137.dynamicImage();
        Intrinsics.checkNotNull(r138);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r138);
        return;
    L52:
        return;
    L50:
        return;
    L34:
        r120 = null;
    L40:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r139 = this.l;
        Intrinsics.checkNotNull(r139);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r140 = r139.interactEmoji();
        Intrinsics.checkNotNull(r140);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r21 = r140.getPathEmoji();
        Intrinsics.checkNotNull(r21);
        EPointF r22 = (EPointF) r15.element;
        EPointF r23 = (EPointF) r2.element;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r141 = this.l;
        Intrinsics.checkNotNull(r141);
        r(r21, r22, r23, r8, r141.getEmojiCategory());
        goto L41
    }

    public final void r(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r11, EPointF r12, EPointF r13, EPointF r14, int r15) {
        if (this.e != null) goto L5;
        return;
    L5:
        ImageRequest[] r0 = a1.b(r11.dynamicImage(), -1);
        j();
        HSImageView r1 = this.e;
        Intrinsics.checkNotNull(r1);
        UtilityKotlinExtentionsKt.w(r1);
        HSImageView r2 = this.e;
        Intrinsics.checkNotNull(r2);
        PipelineDraweeControllerBuilder r3 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r0);
        HSImageView r4 = this.e;
        Intrinsics.checkNotNull(r4);
        r2.setController(r3.setOldController(r4.getController()).setAutoPlayAnimations(false).setControllerListener(new h(this, r11, r12, r13, r14, r15)).build());
    }
}
