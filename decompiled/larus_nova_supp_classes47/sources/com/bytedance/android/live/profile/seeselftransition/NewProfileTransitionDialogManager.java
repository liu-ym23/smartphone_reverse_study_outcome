package com.bytedance.android.live.profile.seeselftransition;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profile/seeselftransition/NewProfileTransitionDialogManager;", "Lcom/bytedance/android/live/profile/seeselftransition/a;", "", "Landroidx/lifecycle/LifecycleObserver;", "", "dismiss", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewProfileTransitionDialogManager implements com.bytedance.android.live.profile.seeselftransition.a, LifecycleObserver {
    public static final /* synthetic */ int l = 0;
    public Function0<Unit> a;
    public int b;
    public boolean c;
    public com.bytedance.android.live.profile.seeselftransition.b d;
    public com.bytedance.android.live.profile.seeselftransition.b e;
    public FragmentManager f;
    public ValueAnimator g;
    public int h;
    public Disposable i;
    public Disposable j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ NewProfileTransitionDialogManager a;
        public final /* synthetic */ com.bytedance.android.live.profile.seeselftransition.b b;
        public final /* synthetic */ com.bytedance.android.live.profile.seeselftransition.b c;
        public final /* synthetic */ FragmentManager d;

        public b(NewProfileTransitionDialogManager r1, com.bytedance.android.live.profile.seeselftransition.b r2, com.bytedance.android.live.profile.seeselftransition.b r3, FragmentManager r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            Bitmap r0 = (Bitmap) r6.getFirst();
            if (r0 != null) goto L5;
            ALogger.e("TransitionDialogManager", "get show to hide bitmap error");
            NewProfileTransitionDialogManager r7 = this.a;
            int r1 = NewProfileTransitionDialogManager.l;
            r7.f();
            return;
        L5:
            Bitmap r8 = (Bitmap) r6.getSecond();
            if (r8 != null) goto L8;
            ALogger.e("TransitionDialogManager", "get hide to show bitmap error");
            NewProfileTransitionDialogManager r9 = this.a;
            int r2 = NewProfileTransitionDialogManager.l;
            r9.f();
            return;
        L8:
            this.b.Wl(new k(1, r0));
            this.c.Wl(new k(2, r8));
            this.c.BJ(this.a, ProfileMode.USER_CURRENT);
            FragmentManager r10 = this.d;
            if (r10 == null) goto L11;
            this.c.show(r10, "SeeSelfTransitionDialogManager_Current");
        L11:
            this.b.BJ(this.a, ProfileMode.USER_BEFORE);
            FragmentManager r12 = this.d;
            if (r12 == null) goto L14;
            this.b.show(r12, "SeeSelfTransitionDialogManager_Before");
        L14:
            this.a.b = 3;
            this.b.getLifecycleOwner().getLifecycle().addObserver(this.a);
            this.c.getLifecycleOwner().getLifecycle().addObserver(this.a);
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void dismiss() {
        ALogger.i("TransitionDialogManager", "dismiss");
        com.bytedance.android.live.profile.seeselftransition.b r0 = this.d;
        if (r0 == null) goto L5;
        r0.d80();
    L5:
        com.bytedance.android.live.profile.seeselftransition.b r1 = this.e;
        if (r1 == null) goto L8;
        r1.d80();
    L8:
        f();
    }

    public final void f() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        this.a = null;
        this.b = 4;
        this.d = null;
        this.e = null;
        ValueAnimator r2 = this.g;
        if (r2 != null) goto L8;
    L12:
        this.g = null;
        this.h = 0;
        Disposable r3 = this.i;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        this.i = null;
        this.c = false;
        this.f = null;
        Disposable r4 = this.j;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        this.j = null;
        return;
    L8:
        if (r2.isRunning() != true) goto L12;
        ValueAnimator r5 = this.g;
        if (r5 == null) goto L12;
        r5.end();
        goto L12
    }

    public final void g() {
        ALogger.i("TransitionDialogManager", "open dialog");
        if (this.b != 4) goto L5;
        return;
    L5:
        this.c = true;
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L8;
        i(this.f);
        return;
    L8:
        h(this.f);
    }

    public final boolean isShowing() {
        if (this.b >= 4) goto L5;
        return true;
    L5:
        return false;
    }

    public NewProfileTransitionDialogManager() {
        this.k = LazyKt.lazy(NewProfileTransitionDialogManager$getBitmapOpt$2.INSTANCE);
    }

    public static final /* synthetic */ void c(NewProfileTransitionDialogManager r0) {
        r0.dismiss();
    }

    public final void h(FragmentManager r8) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (this.e == null) goto L39;
        this.b = 2;
        if (this.c == true) goto L10;
        return;
    L10:
        ALogger.i("TransitionDialogManager", "show dialog");
        com.bytedance.android.live.profile.seeselftransition.b r2 = this.d;
        if (r2 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.profile.seeselftransition.b r3 = this.e;
        if (r3 != null) goto L16;
        return;
    L16:
        File r4 = com.bytedance.android.livesdk.gecko.offline.f.a(i2.b("/profile/transition/ttlive_profile_transition_show_to_hide.png"));
        Bitmap r5 = null;
        if (r4 != null) goto L19;
        Bitmap r6 = null;
    L20:
        if (r6 != null) goto L23;
        ALogger.e("TransitionDialogManager", "get show to hide bitmap error");
        f();
        return;
    L23:
        File r7 = com.bytedance.android.livesdk.gecko.offline.f.a(i2.b("/profile/transition/ttlive_profile_transition_hide_to_show.png"));
        if (r7 == null) goto L27;
        r5 = BitmapFactory.decodeFile(r7.getAbsolutePath());
    L27:
        if (r5 != null) goto L30;
        ALogger.e("TransitionDialogManager", "get hide to show bitmap error");
        f();
        return;
    L30:
        r2.Wl(new k(1, r6));
        r3.Wl(new k(2, r5));
        r3.BJ(this, ProfileMode.USER_CURRENT);
        if (r8 == null) goto L33;
        r3.show(r8, "SeeSelfTransitionDialogManager_Current");
    L33:
        r2.BJ(this, ProfileMode.USER_BEFORE);
        if (r8 == null) goto L36;
        r2.show(r8, "SeeSelfTransitionDialogManager_Before");
    L36:
        this.b = 3;
        r2.getLifecycleOwner().getLifecycle().addObserver(this);
        r3.getLifecycleOwner().getLifecycle().addObserver(this);
        return;
    L19:
        r6 = BitmapFactory.decodeFile(r4.getAbsolutePath());
        goto L20
    }

    public final void i(FragmentManager r7) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (this.e == null) goto L19;
        this.b = 2;
        if (this.c == true) goto L10;
        return;
    L10:
        ALogger.i("TransitionDialogManager", "show dialog");
        com.bytedance.android.live.profile.seeselftransition.b r0 = this.d;
        if (r0 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.profile.seeselftransition.b r1 = this.e;
        if (r1 != null) goto L16;
        return;
    L16:
        Observable r2 = Observable.create(new f("/profile/transition/ttlive_profile_transition_show_to_hide.png")).subscribeOn(Schedulers.io());
        g r3 = g.a;
        this.j = Observable.zip(r2.map(r3), Observable.create(new f("/profile/transition/ttlive_profile_transition_hide_to_show.png")).subscribeOn(Schedulers.io()).map(r3), e.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(TuplesKt.to(null, null)).subscribe(new b(this, r0, r1, r7));
        return;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.a
    public final void a(ProfileMode r2, NewLiveProfileDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "dialogMode");
        Intrinsics.checkNotNullParameter(r3, "dialogFragment");
        ALogger.i("TransitionDialogManager", "user request exit");
        dismiss();
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.a
    public final void b(ProfileMode r19, NewLiveProfileDialogFragment r20) {
        Intrinsics.checkNotNullParameter(r19, "dialogMode");
        Intrinsics.checkNotNullParameter(r20, "dialogFragment");
        ALogger.i("TransitionDialogManager", "one dialog entered: mode: " + r19);
        int r1 = this.h + 1;
        this.h = r1;
        if (r1 != 2) goto L12;
        com.bytedance.android.live.profile.seeselftransition.b r2 = this.d;
        if (r2 == null) goto L13;
        com.bytedance.android.live.profile.seeselftransition.b r5 = this.e;
        if (r5 == null) goto L14;
        PointF r6 = r2.v10();
        ALogger.i("TransitionDialogManager", "getDressUpCardLocation, before: " + r6 + ", current: " + r5.v10());
        r2.ks(r6);
        r5.ks(r6);
        Pair<Integer, Integer> r7 = r2.Ls();
        int r8 = ((Number) r7.component1()).intValue();
        int r9 = ((Number) r7.component2()).intValue();
        Pair<Integer, Integer> r10 = r5.Ls();
        int r12 = Math.max(Math.max(r8, Math.max(r9, ((Number) r10.component1()).intValue())), ((Number) r10.component2()).intValue());
        float r13 = (float) (Math.sqrt(((double) (r12 * r12)) * 2.0d) * 1.5d);
        ALogger.i("TransitionDialogManager", "markMaxOffset: " + r13);
        double r14 = (double) 1200;
        float r15 = (float) (((double) 200) / r14);
        ValueAnimator r3 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("beforeIconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r15, 0.4f), Keyframe.ofFloat(1.0f, 0.4f)}), PropertyValuesHolder.ofKeyframe("currentIconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.4f), Keyframe.ofFloat(r15, 0.4f), Keyframe.ofFloat((float) (450 / r14), 1.04f), Keyframe.ofFloat((float) (600 / r14), 0.98f), Keyframe.ofFloat((float) (750 / r14), 1.005f), Keyframe.ofFloat((float) (900 / r14), 1.0f), Keyframe.ofFloat(1.0f, 1.0f)}), PropertyValuesHolder.ofKeyframe("dialogMark", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(r15, 0.0f), Keyframe.ofFloat((float) (r14 / r14), r13)})});
        r3.setDuration(1200);
        r3.addUpdateListener(new i(r2, r5));
        r3.addListener(new j(this, r2, r5));
        r3.start();
        Unit r4 = Unit.INSTANCE;
        this.g = r3;
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void d(com.bytedance.android.live.profile.seeselftransition.b r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r3, "dialogFragment");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        ALogger.i("TransitionDialogManager", "add before dialog");
        this.b = 1;
        this.d = r3;
        this.f = r4;
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L5;
        i(r4);
        return;
    L5:
        h(r4);
    }

    public final void e(com.bytedance.android.live.profile.seeselftransition.b r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r3, "dialogFragment");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        ALogger.i("TransitionDialogManager", "add current dialog");
        this.b = 1;
        this.e = r3;
        this.f = r4;
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L5;
        i(r4);
        return;
    L5:
        h(r4);
    }
}
