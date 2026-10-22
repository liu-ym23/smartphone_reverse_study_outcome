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
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
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
public final class o extends com.bytedance.android.live.liveinteract.animation.c {
    public com.bytedance.android.live.liveinteract.animation.e d;
    public HSImageView e;
    public HSImageView f;
    public HSImageView g;
    public String h;
    public String i;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j j;
    public Animator k;
    public final CompositeDisposable l;
    public InteractAnimationController.c m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ o a;

        public b(o r1) {
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
        public final /* synthetic */ o a;

        public c(o r1) {
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
        public final /* synthetic */ o a;

        public d(o r1) {
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

    public static final class e extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ o a;
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
        public final void onFailure(String r3, Throwable r4) {
            ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.a.b, "path emoji load failed " + r4);
            o r5 = this.a;
            r5.h(r5);
            r5.r(false);
        }

        public final void onFinalImageSet(String r9, Object r10, Animatable r11) {
            ImageInfo r12 = (ImageInfo) r10;
            Intrinsics.checkNotNullParameter(r9, "id");
            if ((r11 instanceof AnimatedDrawable2) == false) goto L5;
            AnimatedDrawable2 r13 = (AnimatedDrawable2) r11;
            o.m(this.a, r13, this.b.getDuration(), this.c, this.d, this.e, this.f);
            r13.setAnimationListener(new w());
            return;
        L5:
            o.m(this.a, null, this.b.getDuration(), this.c, this.d, this.e, this.f);
        }

        public e(o r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r2, EPointF r3, EPointF r4, EPointF r5, int r6) {
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
        r(false);
        this.a.clear();
        HSImageView r0 = this.f;
        if (r0 == null) goto L5;
        r0.postDelayed(new b(this), 100);
    L5:
        HSImageView r1 = this.e;
        if (r1 == null) goto L8;
        r1.postDelayed(new c(this), 100);
    L8:
        HSImageView r2 = this.g;
        if (r2 == null) goto L12;
        r2.postDelayed(new d(this), 100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        this.l.add(Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this)));
        com.bytedance.android.live.liveinteract.animation.e r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.j != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        int r1 = r0.zl(this.h);
        com.bytedance.android.live.liveinteract.animation.e r2 = this.d;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.zl(this.i);
        if (r1 == r3) goto L116;
        if (r1 < 0) goto L116;
        if (r3 < 0) goto L116;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r4 = this.j;
        if (r4 == null) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r5 = r4.getInteractEmoji();
        if (r5 == null) goto L21;
        if (r5.isValid() == true) goto L21;
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.b, "invalid emoji since data invalid");
        return;
    L21:
        com.bytedance.android.live.liveinteract.animation.e r6 = this.d;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "seatInfoProvider");
        if (l0.b() == false) goto L24;
        this.f = l0.a();
    L25:
        r6.vj().addView(this.f);
        if (l0.b() == false) goto L28;
        this.e = l0.a();
    L29:
        r6.vj().addView(this.e);
        if (l0.b() == false) goto L32;
        this.g = l0.a();
    L33:
        r6.vj().addView(this.g);
        com.bytedance.android.live.liveinteract.animation.e r7 = this.d;
        Intrinsics.checkNotNull(r7);
        if (r7.wc(this.h) == false) goto L36;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(true, r1);
        com.bytedance.android.live.liveinteract.animation.e r8 = this.d;
        Intrinsics.checkNotNull(r8);
        r8.Bn(this.h);
    L36:
        com.bytedance.android.live.liveinteract.animation.e r9 = this.d;
        Intrinsics.checkNotNull(r9);
        if (r9.wc(this.i) == false) goto L39;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(false, r3);
        com.bytedance.android.live.liveinteract.animation.e r10 = this.d;
        Intrinsics.checkNotNull(r10);
        r10.Bn(this.i);
    L39:
        String r11 = "InteractAnimation.InteractEmojiAnimationTask" + this.b;
        StringBuilder r12 = new StringBuilder("play ");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r13 = this.j;
        Intrinsics.checkNotNull(r13);
        r12.append(r13.getEmojiName());
        r12.append(" from{");
        r12.append(this.h);
        r12.append(", ");
        r12.append(r1);
        r12.append("} to{");
        r12.append(this.i);
        r12.append(", ");
        r12.append(r3);
        r12.append('}');
        ALogger.i(r11, r12.toString());
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r14 = this.j;
        Intrinsics.checkNotNull(r14);
        String r15 = this.h;
        String r16 = this.i;
        if (this.d != null) goto L43;
        return;
    L43:
        if (this.f == null) goto L122;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r17 = r14.interactEmoji();
        if (r17 == null) goto L123;
        com.bytedance.android.live.liveinteract.animation.e r18 = this.d;
        Intrinsics.checkNotNull(r18);
        if (r18.Pf(r3) == false) goto L124;
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r110 = this.d;
        Intrinsics.checkNotNull(r110);
        r19.element = r110.C7(r1, r3);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r112 = this.d;
        Intrinsics.checkNotNull(r112);
        r111.element = r112.Kl(r1, r3);
        com.bytedance.android.live.liveinteract.animation.e r113 = this.d;
        Intrinsics.checkNotNull(r113);
        EPointF r114 = r113.Se(r1, r3, (EPointF) r19.element, (EPointF) r111.element);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b() == true) goto L54;
    L56:
        boolean r115 = false;
    L57:
        System.currentTimeMillis();
        this.m = new InteractAnimationController.c(r14, r15, r16, r115);
        int[] r20 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r21 = this.d;
        Intrinsics.checkNotNull(r21);
        r21.vj().getLocationOnScreen(r20);
        EPointF r22 = (EPointF) r19.element;
        Intrinsics.checkNotNull(r22);
        EPointF r116 = (EPointF) r19.element;
        ((PointF) r22).x = ((PointF) r116).x - r20[0];
        Intrinsics.checkNotNull(r116);
        ((PointF) r116).y = ((PointF) ((EPointF) r19.element)).y - r20[1];
        EPointF r23 = (EPointF) r111.element;
        Intrinsics.checkNotNull(r23);
        EPointF r117 = (EPointF) r111.element;
        ((PointF) r23).x = ((PointF) r117).x - r20[0];
        Intrinsics.checkNotNull(r117);
        ((PointF) r117).y = ((PointF) ((EPointF) r111.element)).y - r20[1];
        int r24 = r14.getEmojiCategory();
        HSImageView r25 = this.f;
        if (r25 != null) goto L61;
    L64:
        int r26 = r14.getEmojiCategory();
        HSImageView r27 = this.g;
        if (r27 != null) goto L68;
    L73:
        HSImageView r28 = this.f;
        if (r28 == null) goto L76;
        o(r28, (EPointF) r19.element);
    L76:
        HSImageView r29 = this.g;
        if (r29 == null) goto L80;
        o(r29, (EPointF) r111.element);
    L80:
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b() == false) goto L85;
        p(r14.getEmojiCategory());
        EPointF r30 = (EPointF) r19.element;
        EPointF r31 = (EPointF) r111.element;
        if (r14.getEmojiCategory() != 4) goto L84;
        float r32 = ((PointF) r30).x;
        com.bytedance.android.live.liveinteract.animation.e r33 = this.d;
        Intrinsics.checkNotNull(r33);
        float r34 = r32 - (r33.ma(r1, 4) * 0.0625f);
        float r35 = ((PointF) r30).y;
        com.bytedance.android.live.liveinteract.animation.e r36 = this.d;
        Intrinsics.checkNotNull(r36);
        r30 = new EPointF(r34, r35 - (r36.ma(r1, 4) * 0.4625f));
    L84:
        r19.element = r30;
    L85:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r37 = r17.getSenderEmoji();
        if (r37 != null) goto L88;
    L96:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r38 = r17.getPathEmoji();
        Intrinsics.checkNotNull(r38);
        q(r38, (EPointF) r19.element, (EPointF) r111.element, r114, r14.getEmojiCategory());
    L97:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r39 = this.j;
        Intrinsics.checkNotNull(r39);
        String r40 = r39.getEmojiSoundUrl();
        if (r40 == null) goto L110;
        com.bytedance.android.live.liveinteract.animation.e r41 = this.d;
        if ((r41 instanceof InteractAnimationController.d) == true) goto L102;
        r41 = null;
    L102:
        InteractAnimationController.d r42 = (InteractAnimationController.d) r41;
        if (r42 == null) goto L107;
        EmojiSoundManager r43 = InteractAnimationController.d.a.c(r42);
        if (r43 == null) goto L107;
        r43.e(this.b, r40, getType());
    L107:
        com.bytedance.android.live.liveinteract.animation.e r44 = this.d;
        if (r44 == null) goto L110;
        r44.Mb(this.b, r40, getType());
    L110:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r45 = r17.getReceiverEmoji();
        if (r45 != null) goto L113;
        return;
    L113:
        if (r45.isValid() != true) goto L120;
        int r46 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r47 = r17.getReceiverEmoji();
        Intrinsics.checkNotNull(r47);
        py.k r48 = r47.dynamicImage();
        Intrinsics.checkNotNull(r48);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r48);
        return;
    L120:
        return;
    L88:
        if (r37.isValid() != true) goto L96;
        com.bytedance.android.live.liveinteract.animation.e r49 = this.d;
        Intrinsics.checkNotNull(r49);
        if (r49.Ed(r1) == false) goto L96;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r50 = r17.getSenderEmoji();
        Intrinsics.checkNotNull(r50);
        ImageRequest[] r51 = a1.b(r50.dynamicImage(), -1);
        Iterator<g> r52 = this.a.iterator();
    L93:
        if (r52.hasNext() == false) goto L95;
        r52.next().c();
        goto L93
    L95:
        HSImageView r118 = this.f;
        Intrinsics.checkNotNull(r118);
        PipelineDraweeControllerBuilder r53 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r51);
        HSImageView r54 = this.f;
        Intrinsics.checkNotNull(r54);
        r118.setController(r53.setOldController(r54.getController()).setAutoPlayAnimations(true).setControllerListener(new v(this, r17, r19, r111, r114, r14)).build());
        HSImageView r55 = this.f;
        Intrinsics.checkNotNull(r55);
        UtilityKotlinExtentionsKt.w(r55);
        int r56 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r57 = r17.getPathEmoji();
        Intrinsics.checkNotNull(r57);
        py.k r58 = r57.dynamicImage();
        Intrinsics.checkNotNull(r58);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r58);
        goto L97
    L68:
        if (this.d == null) goto L73;
        Intrinsics.checkNotNull(r27);
        ViewGroup.LayoutParams r59 = r27.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r60 = this.d;
        Intrinsics.checkNotNull(r60);
        r59.width = r60.ma(r3, r26);
        com.bytedance.android.live.liveinteract.animation.e r61 = this.d;
        Intrinsics.checkNotNull(r61);
        r59.height = r61.ma(r3, r26);
        HSImageView r62 = this.g;
        if (r62 == null) goto L73;
        r62.setLayoutParams(r59);
        goto L73
    L61:
        if (this.d == null) goto L64;
        Intrinsics.checkNotNull(r25);
        ViewGroup.LayoutParams r63 = r25.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r65 = this.d;
        Intrinsics.checkNotNull(r65);
        r63.width = r65.ma(r1, r24);
        com.bytedance.android.live.liveinteract.animation.e r66 = this.d;
        Intrinsics.checkNotNull(r66);
        r63.height = r66.ma(r1, r24);
        HSImageView r67 = this.f;
        Intrinsics.checkNotNull(r67);
        r67.setLayoutParams(r63);
        goto L64
    L54:
        if (r14.getEmojiCategory() != 4) goto L56;
        r115 = true;
        goto L57
    L124:
        return;
    L123:
        return;
    L122:
        return;
    L32:
        this.g = new HSImageView(r6.vj().getContext());
        goto L33
    L28:
        this.e = new HSImageView(r6.vj().getContext());
        goto L29
    L24:
        this.f = new HSImageView(r6.vj().getContext());
    L116:
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.b, "invalid emoji since from=" + r1 + " to=" + r3);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.i;
    }

    public static final void n(o r6) {
        if (r6.d == null) goto L32;
        InteractAnimationController.c r0 = r6.m;
        if (r0 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r1 = r0.a;
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r2 = r1.interactEmoji();
        if (r2 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3 = r2.getReceiverEmoji();
    L13:
        com.bytedance.android.live.liveinteract.animation.e r4 = r6.d;
        Intrinsics.checkNotNull(r4);
        InteractAnimationController.c r5 = r6.m;
        if (r5 == null) goto L17;
        String r7 = r5.b;
        if (r7 == null) goto L17;
    L18:
        int r8 = r4.zl(r7);
        if (r3 != null) goto L21;
    L28:
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + r6.b, "won't play receiver animation for " + r3 + " invalid");
        r6.h(r6);
        r6.r(true);
        return;
    L21:
        if (r3.isValid() != true) goto L28;
        if (r8 <= 0) goto L27;
        com.bytedance.android.live.liveinteract.animation.e r9 = r6.d;
        Intrinsics.checkNotNull(r9);
        if (r9.Ed(r8) == true) goto L27;
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + r6.b, "won't play receiver animation for seat " + r8 + " invalid");
        r6.h(r6);
        r6.r(true);
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
        r12.setController(r13.setOldController(r14.getController()).setAutoPlayAnimations(true).setControllerListener(new s(r6)).build());
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

    public final void r(boolean r5) {
        InteractAnimationController.c r0 = this.m;
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r1 = r0.a;
        if (r1 == null) goto L11;
        String r2 = r1.getEmojiSoundUrl();
        if (r2 == null) goto L11;
        if (r5 == false) goto L11;
        xs2.b.a().post(new wj0.f(this.b, r2, r5));
    L11:
        if (this.m != null) goto L13;
        return;
    L13:
        this.m = null;
        HSImageView r3 = this.e;
        if (r3 == null) goto L16;
        r3.setController(null);
    L16:
        HSImageView r4 = this.f;
        if (r4 == null) goto L19;
        r4.setController(null);
    L19:
        HSImageView r6 = this.g;
        if (r6 == null) goto L22;
        r6.setController(null);
    L22:
        this.l.dispose();
        p(0);
        HSImageView r7 = this.e;
        if (r7 == null) goto L25;
        UtilityKotlinExtentionsKt.u(r7);
    L25:
        HSImageView r8 = this.f;
        if (r8 == null) goto L28;
        UtilityKotlinExtentionsKt.u(r8);
    L28:
        HSImageView r9 = this.g;
        if (r9 == null) goto L31;
        UtilityKotlinExtentionsKt.u(r9);
    L31:
        Animator r10 = this.k;
        if (r10 != null) goto L34;
        return;
    L34:
        if (r10.isRunning() != true) goto L40;
        Animator r11 = this.k;
        if (r11 == null) goto L41;
        r11.cancel();
        return;
    L41:
        return;
    }

    public o(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskID");
        super(r2, r3);
        this.h = "";
        this.i = "";
        this.l = new CompositeDisposable();
    }

    public final void o(HSImageView r3, EPointF r4) {
        r3.setX(((PointF) r4).x - (r3.getLayoutParams().width / 2));
        r3.setY(((PointF) r4).y - (r3.getLayoutParams().height / 2));
    }

    public final void q(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r11, EPointF r12, EPointF r13, EPointF r14, int r15) {
        if (this.e != null) goto L5;
        return;
    L5:
        ImageRequest[] r0 = a1.b(r11.dynamicImage(), -1);
        j();
        com.bytedance.android.live.liveinteract.animation.e r1 = this.d;
        if (r1 != null) goto L8;
    L10:
        HSImageView r2 = this.e;
        Intrinsics.checkNotNull(r2);
        UtilityKotlinExtentionsKt.w(r2);
    L11:
        HSImageView r3 = this.e;
        Intrinsics.checkNotNull(r3);
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r0);
        HSImageView r5 = this.e;
        Intrinsics.checkNotNull(r5);
        r3.setController(r4.setOldController(r5.getController()).setAutoPlayAnimations(false).setControllerListener(new e(this, r11, r12, r13, r14, r15)).build());
        return;
    L8:
        if (r1.W7(r12, r13) == true) goto L10;
        HSImageView r6 = this.e;
        Intrinsics.checkNotNull(r6);
        UtilityKotlinExtentionsKt.u(r6);
        goto L11
    }

    public static final void m(o r7, AnimatedDrawable2 r8, long r9, EPointF r11, EPointF r12, EPointF r13, int r14) {
        if (r7.d != null) goto L6;
        return;
    L6:
        if (r7.e == null) goto L15;
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        com.bytedance.android.live.liveinteract.animation.e r0 = r7.d;
        Intrinsics.checkNotNull(r0);
        r6.element = r0.si();
        ValueAnimator r15 = ValueAnimator.ofObject(new com.bytedance.android.live.liveinteract.utils.f(r13), new Object[]{r11, r12});
        if (r9 > 0) goto L12;
        r9 = 1200;
    L12:
        r15.setDuration(r9);
        r15.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r15.addUpdateListener(new p(r7, r14, r11, r12, r6));
        r15.addListener(new q(r7, r14, r11, r12, r8));
        Unit r10 = Unit.INSTANCE;
        r7.k = r15;
        r15.start();
        return;
    }
}
