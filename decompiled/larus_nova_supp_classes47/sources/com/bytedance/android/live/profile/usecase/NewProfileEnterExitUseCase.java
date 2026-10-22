package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;
import rs0.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NewProfileEnterExitUseCase implements ut0.a {
    public View a;
    public ProfileCustomSkin.Panel b;
    public final List<Observable<Object>> c;
    public Disposable d;
    public Animator e;
    public Animator f;
    public final Lazy g;
    public final com.bytedance.android.live.profile.usecase.a h;
    public final PropertyOwner<com.bytedance.android.live.profile.model.a> i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ NewProfileEnterExitUseCase a;

        public a(NewProfileEnterExitUseCase r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ProfileMonitor r0 = this.a.f();
            if (r0 == null) goto L5;
            r0.g(EventType.EnterAnimTimeout);
        L5:
            StringBuilder r1 = new StringBuilder("timeout, error ");
            if (r4 == null) goto L8;
            String r5 = r4.getMessage();
        L9:
            r1.append(r5);
            ALogger.i(NewProfileInfoViewModel.TAG, r1.toString());
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ NewProfileEnterExitUseCase a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Function0 c;

        public b(NewProfileEnterExitUseCase r1, View r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            View r4 = this.b;
            if (r4 == null) goto L6;
            r4.post(new com.bytedance.android.live.profile.usecase.b(this));
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ NewProfileEnterExitUseCase c;

        public c(boolean r1, boolean r2, NewProfileEnterExitUseCase r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L18;
            float r5 = r4.floatValue();
            if (this.a == true) goto L10;
        L14:
            View r0 = this.c.a;
            if (r0 == null) goto L21;
            r0.setTranslationX(r5);
            return;
        L21:
            return;
        L10:
            if (this.b == true) goto L14;
            View r1 = this.c.a;
            if (r1 == null) goto L19;
            r1.setTranslationY(r5);
            return;
        L19:
            return;
        }
    }

    @Override // ut0.a
    public final void clear() {
        this.a = null;
        ((ArrayList) this.c).clear();
        Disposable r1 = this.d;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Animator r2 = this.e;
        if (r2 != null) goto L8;
    L12:
        this.e = null;
        Animator r3 = this.f;
        if (r3 != null) goto L15;
    L19:
        this.f = null;
        return;
    L15:
        if (r3.isRunning() != true) goto L19;
        Animator r4 = this.f;
        if (r4 == null) goto L19;
        r4.end();
        goto L19
    L8:
        if (r2.isRunning() != true) goto L12;
        Animator r5 = this.e;
        if (r5 == null) goto L12;
        r5.end();
        goto L12
    }

    public final ProfileMonitor f() {
        return (ProfileMonitor) this.g.getValue();
    }

    public static Interpolator e(List r6) {
        if (r6.size() == 4) goto L6;
        return new AccelerateDecelerateInterpolator();
    L6:
        if (CollectionsKt.getLastIndex(r6) < 0) goto L8;
        Object r0 = ListProtector.get(r6, 0);
    L9:
        float r1 = ((Number) r0).floatValue();
        if (1 > CollectionsKt.getLastIndex(r6)) goto L12;
        Object r2 = ListProtector.get(r6, 1);
    L13:
        float r3 = ((Number) r2).floatValue();
        if (2 > CollectionsKt.getLastIndex(r6)) goto L16;
        Object r4 = ListProtector.get(r6, 2);
    L17:
        float r5 = ((Number) r4).floatValue();
        if (3 > CollectionsKt.getLastIndex(r6)) goto L20;
        Object r7 = ListProtector.get(r6, 3);
    L22:
        return PathInterpolatorCompat.create(r1, r3, r5, ((Number) r7).floatValue());
    L20:
        r7 = Float.valueOf(0.0f);
        goto L22
    L16:
        r4 = Float.valueOf(0.0f);
        goto L17
    L12:
        r2 = Float.valueOf(0.0f);
        goto L13
    L8:
        r0 = Float.valueOf(0.0f);
        goto L9
    }

    public static List g(List r3) {
        ArrayList r0 = new ArrayList();
        List r1 = r3;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L16;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Double r5 = (Double) r4.next();
        if (r5 == null) goto L12;
        r5.doubleValue();
        r0.add(Float.valueOf((float) r5.doubleValue()));
    L16:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // ut0.a
    public final void b(Function0<Unit> r3) {
        ALogger.i(NewProfileInfoViewModel.TAG, "profile exit");
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Animator r1 = this.e;
        if (r1 != null) goto L8;
    L12:
        this.e = null;
        Animator r2 = this.f;
        if (r2 != null) goto L15;
    L17:
        ValueAnimator r4 = c(this.b, false);
        r4.addListener(new d(this, r3));
        r4.start();
        Unit r5 = Unit.INSTANCE;
        this.f = r4;
        return;
    L15:
        if (r2.isRunning() != true) goto L17;
        return;
    L8:
        if (r1.isRunning() != true) goto L12;
        Animator r6 = this.e;
        if (r6 == null) goto L12;
        r6.end();
        goto L12
    }

    @Override // ut0.a
    public final void enterWaitFor(Observable<Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "wait");
        ALogger.i(NewProfileInfoViewModel.TAG, "enterWaitFor: " + r3.toString());
        ((ArrayList) this.c).add(r3.onErrorReturnItem(Unit.INSTANCE));
    }

    public NewProfileEnterExitUseCase(com.bytedance.android.live.profile.usecase.a r2, PropertyOwner<com.bytedance.android.live.profile.model.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "profileViewModel");
        Intrinsics.checkNotNullParameter(r3, "enterExitState");
        this.h = r2;
        this.i = r3;
        this.c = new ArrayList();
        this.g = LazyKt.lazy(new NewProfileEnterExitUseCase$profileMonitor$2(this));
    }

    public final ValueAnimator c(ProfileCustomSkin.Panel r12, boolean r13) {
        if (r12 == null) goto L60;
        if (r13 == false) goto L5;
        long r0 = r12.openInterval;
    L6:
        long r1 = Math.max(0, r0);
        if (r13 == false) goto L9;
        List r14 = r12.openRateCurve;
    L10:
        List r15 = g(r14);
        int r4 = com.bytedance.android.live.profile.ui.util.t.a;
        boolean r5 = PadConfigUtils.c();
        if (r1 != 0) goto L13;
    L59:
        ValueAnimator r16 = d(r13, r5);
    L61:
        r16.addUpdateListener(new c(this.h.isVertical(), PadConfigUtils.c(), this));
        return r16;
    L13:
        if (((ArrayList) r15).size() != 4) goto L59;
        float r2 = 0.0f;
        if (r13 == true) goto L18;
    L27:
        if (r13 == false) goto L29;
    L37:
        if (r13 == true) goto L39;
    L48:
        if (r13 == false) goto L50;
    L58:
        r16 = d(r13, r5);
        goto L61
    L50:
        if (this.h.isVertical() == false) goto L52;
        if (r5 == false) goto L58;
    L52:
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 横屏出场");
        PropertyValuesHolder[] r17 = new PropertyValuesHolder[1];
        Keyframe[] r6 = new Keyframe[2];
        r6[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r7 = this.a;
        if (r7 == null) goto L55;
        r2 = r7.getWidth();
    L55:
        Keyframe r3 = Keyframe.ofFloat(1.0f, r2);
        r3.setInterpolator(e(r15));
        Unit r18 = Unit.INSTANCE;
        r6[1] = r3;
        r17[0] = PropertyValuesHolder.ofKeyframe("value", r6);
        r16 = ValueAnimator.ofPropertyValuesHolder(r17);
        if (r16 == null) goto L61;
        r16.setDuration(r1);
        goto L61
    L39:
        if (this.h.isVertical() == false) goto L41;
        if (r5 == false) goto L48;
    L41:
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 横屏进场");
        PropertyValuesHolder[] r19 = new PropertyValuesHolder[1];
        Keyframe[] r8 = new Keyframe[2];
        View r9 = this.a;
        if (r9 == null) goto L44;
        float r10 = r9.getWidth();
    L45:
        r8[0] = Keyframe.ofFloat(0.0f, r10);
        Keyframe r20 = Keyframe.ofFloat(1.0f, 0.0f);
        r20.setInterpolator(e(r15));
        Unit r110 = Unit.INSTANCE;
        r8[1] = r20;
        r19[0] = PropertyValuesHolder.ofKeyframe("value", r8);
        r16 = ValueAnimator.ofPropertyValuesHolder(r19);
        if (r16 == null) goto L61;
        r16.setDuration(r1);
        goto L61
    L44:
        r10 = 0.0f;
        goto L45
    L29:
        if (this.h.isVertical() == false) goto L37;
        if (r5 == true) goto L37;
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 竖屏出场");
        PropertyValuesHolder[] r111 = new PropertyValuesHolder[1];
        Keyframe[] r22 = new Keyframe[2];
        r22[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r23 = this.a;
        if (r23 == null) goto L34;
        r2 = r23.getHeight();
    L34:
        Keyframe r24 = Keyframe.ofFloat(1.0f, r2);
        r24.setInterpolator(e(r15));
        Unit r112 = Unit.INSTANCE;
        r22[1] = r24;
        r111[0] = PropertyValuesHolder.ofKeyframe("value", r22);
        r16 = ValueAnimator.ofPropertyValuesHolder(r111);
        if (r16 == null) goto L61;
        r16.setDuration(r1);
        goto L61
    L18:
        if (this.h.isVertical() == false) goto L27;
        if (r5 == true) goto L27;
        ALogger.i(NewProfileInfoViewModel.TAG, "自定义，ofPropertyValuesHolder: 竖屏进场");
        PropertyValuesHolder[] r113 = new PropertyValuesHolder[1];
        Keyframe[] r25 = new Keyframe[2];
        View r26 = this.a;
        if (r26 == null) goto L23;
        float r27 = r26.getHeight();
    L24:
        r25[0] = Keyframe.ofFloat(0.0f, r27);
        Keyframe r28 = Keyframe.ofFloat(1.0f, 0.0f);
        r28.setInterpolator(e(r15));
        Unit r114 = Unit.INSTANCE;
        r25[1] = r28;
        r113[0] = PropertyValuesHolder.ofKeyframe("value", r25);
        r16 = ValueAnimator.ofPropertyValuesHolder(r113);
        if (r16 == null) goto L61;
        r16.setDuration(r1);
        goto L61
    L23:
        r27 = 0.0f;
        goto L24
    L9:
        r14 = r12.closeRateCurve;
        goto L10
    L5:
        r0 = r12.closeInterval;
        goto L6
    L60:
        int r115 = com.bytedance.android.live.profile.ui.util.t.a;
        r16 = d(r13, PadConfigUtils.c());
        goto L61
    }

    public final ValueAnimator d(boolean r12, boolean r13) {
        float r8 = 0.0f;
        if (r12 == true) goto L5;
    L14:
        if (r12 == true) goto L25;
        if (this.h.isVertical() == false) goto L25;
        if (r13 == true) goto L25;
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 竖屏出场");
        PropertyValuesHolder[] r14 = new PropertyValuesHolder[1];
        Keyframe[] r15 = new Keyframe[2];
        r15[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r3 = this.a;
        if (r3 == null) goto L21;
        r8 = r3.getHeight();
    L21:
        Keyframe r2 = Keyframe.ofFloat(1.0f, r8);
        r2.setInterpolator(new DecelerateInterpolator());
        Unit r4 = Unit.INSTANCE;
        r15[1] = r2;
        r14[0] = PropertyValuesHolder.ofKeyframe("value", r15);
        ValueAnimator r16 = ValueAnimator.ofPropertyValuesHolder(r14);
        if (r16 == null) goto L50;
        r16.setDuration(150);
        return r16;
    L50:
        return r16;
    L25:
        if (r12 == true) goto L27;
    L36:
        if (r12 == true) goto L47;
        if (this.h.isVertical() == false) goto L40;
        if (r13 == false) goto L47;
    L40:
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 横屏出场");
        PropertyValuesHolder[] r17 = new PropertyValuesHolder[1];
        Keyframe[] r18 = new Keyframe[2];
        r18[0] = Keyframe.ofFloat(0.0f, 0.0f);
        View r5 = this.a;
        if (r5 == null) goto L43;
        r8 = r5.getWidth();
    L43:
        Keyframe r6 = Keyframe.ofFloat(1.0f, r8);
        r6.setInterpolator(new AccelerateDecelerateInterpolator());
        Unit r7 = Unit.INSTANCE;
        r18[1] = r6;
        r17[0] = PropertyValuesHolder.ofKeyframe("value", r18);
        ValueAnimator r19 = ValueAnimator.ofPropertyValuesHolder(r17);
        if (r19 == null) goto L54;
        r19.setDuration(300);
        return r19;
    L54:
        return r19;
    L47:
        return new ValueAnimator();
    L27:
        if (this.h.isVertical() == false) goto L29;
        if (r13 == false) goto L36;
    L29:
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 横屏进场");
        PropertyValuesHolder[] r110 = new PropertyValuesHolder[1];
        Keyframe[] r111 = new Keyframe[2];
        View r9 = this.a;
        if (r9 == null) goto L32;
        float r10 = r9.getWidth();
    L33:
        r111[0] = Keyframe.ofFloat(0.0f, r10);
        Keyframe r20 = Keyframe.ofFloat(1.0f, 0.0f);
        r20.setInterpolator(new AccelerateDecelerateInterpolator());
        Unit r22 = Unit.INSTANCE;
        r111[1] = r20;
        r110[0] = PropertyValuesHolder.ofKeyframe("value", r111);
        ValueAnimator r112 = ValueAnimator.ofPropertyValuesHolder(r110);
        if (r112 == null) goto L52;
        r112.setDuration(300);
        return r112;
    L52:
        return r112;
    L32:
        r10 = 0.0f;
        goto L33
    L5:
        if (this.h.isVertical() == false) goto L14;
        if (r13 == true) goto L14;
        ALogger.i(NewProfileInfoViewModel.TAG, "默认，ofPropertyValuesHolder: 竖屏进场");
        PropertyValuesHolder[] r113 = new PropertyValuesHolder[1];
        Keyframe[] r114 = new Keyframe[2];
        View r23 = this.a;
        if (r23 == null) goto L10;
        float r24 = r23.getHeight();
    L11:
        r114[0] = Keyframe.ofFloat(0.0f, r24);
        Keyframe r25 = Keyframe.ofFloat(1.0f, 0.0f);
        r25.setInterpolator(new DecelerateInterpolator());
        Unit r26 = Unit.INSTANCE;
        r114[1] = r25;
        r113[0] = PropertyValuesHolder.ofKeyframe("value", r114);
        ValueAnimator r115 = ValueAnimator.ofPropertyValuesHolder(r113);
        if (r115 == null) goto L48;
        r115.setDuration(150);
        return r115;
    L48:
        return r115;
    L10:
        r24 = 0.0f;
        goto L11
    }

    @Override // ut0.a
    public final void a(View r5, ProfileCustomSkin.Panel r6, Function0<Unit> r7) {
        ALogger.i(NewProfileInfoViewModel.TAG, "profile enter");
        this.a = r5;
        this.b = r6;
        int r8 = com.bytedance.android.live.profile.ui.util.t.a;
        if (((ss0.a) b0.a.getValue()).a() == true) goto L9;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
    L6:
        if (r7 == null) goto L14;
        Unit r9 = (Unit) r7.invoke();
        return;
    L14:
        return;
    L9:
        ProfileMonitor r10 = f();
        if (r10 == null) goto L12;
        r10.i(TimeType.PrepareEnterAnim);
    L12:
        this.i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.WILL_ENTER));
        this.d = Observable.merge(this.c).toList().timeout(Math.max(((Long) c0.a.getValue()).longValue(), 0), TimeUnit.MILLISECONDS).doOnError(new a(this)).onErrorReturnItem(CollectionsKt.emptyList()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r5, r7));
    }
}
