package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RxViewAnimationExtensionKt {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public a(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultAlpha");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, Float.valueOf(this.b), null, null, null, null, null, null, null, null, null, null, this.c, this.d, this.e, 2046), this.f, new RxViewAnimationExtensionKt$alpha$1$1(this, r1));
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public b(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultRotation");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, Float.valueOf(this.b), null, null, null, null, null, this.c, this.d, this.e, 2015), this.f, new RxViewAnimationExtensionKt$rotation$1$1(this, r1));
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public c(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultRotationX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, Float.valueOf(this.b), null, null, null, null, this.c, this.d, this.e, 1983), this.f, new RxViewAnimationExtensionKt$rotationX$1$1(this, r1));
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public d(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultRotationY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, null, Float.valueOf(this.b), null, null, null, this.c, this.d, this.e, 1919), this.f, new RxViewAnimationExtensionKt$rotationY$1$1(this, r1));
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public e(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r21) {
            Pair r1 = (Pair) r21;
            Intrinsics.checkNotNullParameter(r1, "<name for destructuring parameter 0>");
            final float r10 = ((Number) r1.component1()).floatValue();
            final float r11 = ((Number) r1.component2()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, Float.valueOf(this.b), Float.valueOf(this.b), null, null, null, null, null, null, this.c, this.d, this.e, 2023), this.f, new RxViewAnimationExtensionKt$scale$1$1(this, r10, r11));
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public f(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultScaleX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, Float.valueOf(this.b), null, null, null, null, null, null, null, this.c, this.d, this.e, 2039), this.f, new RxViewAnimationExtensionKt$scaleX$1$1(this, r1));
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public g(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultScaleY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, Float.valueOf(this.b), null, null, null, null, null, null, this.c, this.d, this.e, 2031), this.f, new RxViewAnimationExtensionKt$scaleY$1$1(this, r1));
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ TimeInterpolator e;
        public final /* synthetic */ Long f;
        public final /* synthetic */ boolean g;

        public h(View r1, float r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
        }

        public final Object apply(Object r21) {
            Pair r1 = (Pair) r21;
            Intrinsics.checkNotNullParameter(r1, "<name for destructuring parameter 0>");
            final float r10 = ((Number) r1.component1()).floatValue();
            final float r11 = ((Number) r1.component2()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, Float.valueOf(this.b), Float.valueOf(this.c), null, null, null, null, null, null, null, null, this.d, this.e, this.f, 2041), this.g, new RxViewAnimationExtensionKt$translation$1$1(this, r10, r11));
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public i(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultTranslationX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, Float.valueOf(this.b), null, null, null, null, null, null, null, null, null, this.c, this.d, this.e, 2045), this.f, new RxViewAnimationExtensionKt$translationX$1$1(this, r1));
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public j(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultTranslationY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, Float.valueOf(this.b), null, null, null, null, null, null, null, null, this.c, this.d, this.e, 2043), this.f, new RxViewAnimationExtensionKt$translationY$1$1(this, r1));
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public k(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultX");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, null, null, Float.valueOf(this.b), null, null, this.c, this.d, this.e, 1791), this.f, new RxViewAnimationExtensionKt$x$1$1(this, r1));
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ Float b;
        public final /* synthetic */ Float c;
        public final /* synthetic */ Float d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ TimeInterpolator f;
        public final /* synthetic */ Long g;
        public final /* synthetic */ boolean h;

        public l(View r1, Float r10, Float r11, Float r12, Long r13, TimeInterpolator r14, Long r15, boolean r16) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
        }

        public final Object apply(Object r22) {
            Triple r1 = (Triple) r22;
            Intrinsics.checkNotNullParameter(r1, "<name for destructuring parameter 0>");
            final float r10 = ((Number) r1.component1()).floatValue();
            final float r11 = ((Number) r1.component2()).floatValue();
            final float r12 = ((Number) r1.component3()).floatValue();
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, null, null, this.b, this.c, this.d, this.e, this.f, this.g, 255), this.h, new RxViewAnimationExtensionKt$xyz$1$1(this, r10, r11, r12));
        }
    }

    public static final class m<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public m(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultY");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, null, null, null, Float.valueOf(this.b), null, this.c, this.d, this.e, 1535), this.f, new RxViewAnimationExtensionKt$y$1$1(this, r1));
        }
    }

    public static final class n<T, R> implements Function {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ Long c;
        public final /* synthetic */ TimeInterpolator d;
        public final /* synthetic */ Long e;
        public final /* synthetic */ boolean f;

        public n(View r1, float r10, Long r11, TimeInterpolator r12, Long r13, boolean r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object apply(Object r20) {
            final Float r1 = (Float) r20;
            Intrinsics.checkNotNullParameter(r1, "defaultZ");
            return RxViewAnimationExtensionKt.h(RxViewAnimationExtensionKt.e(this.a, null, null, null, null, null, null, null, null, null, null, Float.valueOf(this.b), this.c, this.d, this.e, 1023), this.f, new RxViewAnimationExtensionKt$z$1$1(this, r1));
        }
    }

    public static final float a(float r10) {
        Resources r0 = Resources.getSystem();
        return r10 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    public static final Completable h(Completable r0, boolean r1, Function0<? extends Completable> r10) {
        if (r1 == true) goto L4;
        return r0;
    L4:
        return r0.andThen((CompletableSource) r10.invoke());
    }

    public static final void b(ValueAnimator r10, Long r11, Interpolator r12, Function0 r13, Function1 r14) {
        if (r11 == null) goto L4;
        r10.setDuration(r11.longValue());
    L4:
        if (r12 == null) goto L6;
        r10.setInterpolator(r12);
    L6:
        r10.addUpdateListener(new com.bytedance.android.ec.core.toolbox.rxanimation.d(r14, r13));
        r10.addListener(new com.bytedance.android.ec.core.toolbox.rxanimation.e(r13));
        r10.start();
    }

    public static /* synthetic */ Completable d(View r10, float r11, Long r12, TimeInterpolator r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        Long r15 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        TimeInterpolator r16 = null;
    L11:
        return c(r10, r11, r15, r16, null, false);
    L9:
        r16 = r13;
        goto L11
    L5:
        r15 = r12;
        goto L7
    }

    public static final Completable f(final Pair<Float, Float> r10, final Long r11, final Interpolator r12, boolean r13, final Function1<? super Float, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$rangeFloatToCompletable");
        Intrinsics.checkNotNullParameter(r14, "action");
        return h(Completable.create(new RxViewAnimationExtensionKt$rangeFloatToCompletable$1(r10, r11, r12, r14)), r13, new RxViewAnimationExtensionKt$rangeFloatToCompletable$2(r10, r11, r12, r14));
    }

    public static final Completable g(final Pair<Integer, Integer> r1, final Long r10, final Interpolator r11, boolean r12, final Function1<? super Integer, Unit> r13) {
        Intrinsics.checkNotNullParameter(r1, "$this$rangeIntToCompletable");
        Intrinsics.checkNotNullParameter(r13, "action");
        Completable r0 = Completable.create(new RxViewAnimationExtensionKt$rangeIntToCompletable$1(r1, r10, r11, r13));
        if (r12 == true) goto L5;
        return r0;
    L5:
        return r0.andThen(g(TuplesKt.to(r1.getSecond(), r1.getFirst()), r10, r11, false, r13));
    }

    public static final Completable c(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$alpha");
        return Observable.just(Float.valueOf(r10.getAlpha())).flatMapCompletable(new a(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable i(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$rotation");
        return Observable.just(Float.valueOf(r10.getRotation())).flatMapCompletable(new b(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable j(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$rotationX");
        return Observable.just(Float.valueOf(r10.getRotationX())).flatMapCompletable(new c(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable k(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$rotationY");
        return Observable.just(Float.valueOf(r10.getRotationY())).flatMapCompletable(new d(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable l(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$scale");
        return Observable.just(TuplesKt.to(Float.valueOf(r10.getScaleX()), Float.valueOf(r10.getScaleY()))).flatMapCompletable(new e(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable m(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$scaleX");
        return Observable.just(Float.valueOf(r10.getScaleX())).flatMapCompletable(new f(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable n(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$scaleY");
        return Observable.just(Float.valueOf(r10.getScaleY())).flatMapCompletable(new g(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable p(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$translationX");
        return Observable.just(Float.valueOf(r10.getTranslationX())).flatMapCompletable(new i(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable q(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$translationY");
        return Observable.just(Float.valueOf(r10.getTranslationY())).flatMapCompletable(new j(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable r(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$x");
        return Observable.just(Float.valueOf(r10.getX())).flatMapCompletable(new k(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable t(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$y");
        return Observable.just(Float.valueOf(r10.getY())).flatMapCompletable(new m(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable u(View r10, float r11, Long r12, TimeInterpolator r13, Long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "$this$z");
        return Observable.just(Float.valueOf(r10.getZ())).flatMapCompletable(new n(r10, r11, r12, r13, r14, r15));
    }

    public static final Completable o(View r10, float r11, float r12, Long r13, TimeInterpolator r14, Long r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "$this$translation");
        return Observable.just(TuplesKt.to(Float.valueOf(r10.getTranslationX()), Float.valueOf(r10.getTranslationY()))).flatMapCompletable(new h(r10, r11, r12, r13, r14, r15, r16));
    }

    public static final Completable s(View r11, Float r12, Float r13, Float r14, Long r15, TimeInterpolator r16, Long r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "$this$xyz");
        return Observable.just(new Triple(Float.valueOf(r11.getX()), Float.valueOf(r11.getY()), Float.valueOf(r11.getZ()))).flatMapCompletable(new l(r11, r12, r13, r14, r15, r16, r17, r18));
    }

    public static Completable e(final View r19, Float r20, Float r21, Float r22, Float r23, Float r24, Float r25, Float r26, Float r27, Float r28, Float r29, Float r30, Long r31, TimeInterpolator r32, Long r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        final Float r10 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        final Float r11 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        final Float r12 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        final Float r13 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        final Float r14 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        final Float r15 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        final Float r16 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        final Float r17 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        final Float r18 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        final Float r110 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        final Float r111 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        final Long r112 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        final TimeInterpolator r113 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        final Long r114 = null;
    L58:
        Intrinsics.checkNotNullParameter(r19, "$this$animate");
        return Completable.create(new RxViewAnimationExtensionKt$animate$2(r19, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r111, r112, r113, r114));
    L57:
        r114 = r33;
        goto L58
    L53:
        r113 = r32;
        goto L55
    L49:
        r112 = r31;
        goto L51
    L45:
        r111 = r30;
        goto L47
    L41:
        r110 = r29;
        goto L43
    L37:
        r18 = r28;
        goto L39
    L33:
        r17 = r27;
        goto L35
    L29:
        r16 = r26;
        goto L31
    L25:
        r15 = r25;
        goto L27
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r22;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }
}
