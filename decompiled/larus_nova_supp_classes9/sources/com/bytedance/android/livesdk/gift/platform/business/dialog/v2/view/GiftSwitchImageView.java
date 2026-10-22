package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n0;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftSwitchImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", BuildConfig.FLAVOR, "k", "Z", "isPlaying", "()Z", "setPlaying", "(Z)V", BuildConfig.FLAVOR, "m", "I", "getDuration", "()I", "setDuration", "(I)V", "duration", "n", "getCurrentSwitchType", "setCurrentSwitchType", "currentSwitchType", "getState", "state", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSwitchImageView extends ConstraintLayout {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> a;
    public long b;
    public String c;
    public String d;
    public AnimatorSet e;
    public AnimatorSet f;
    public final AnimatorSet g;
    public Disposable h;
    public Disposable i;
    public float j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ GiftSwitchImageView a;

        public a(GiftSwitchImageView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            Object r1 = r5.getAnimatedValue();
            if (r1 == null) goto L11;
            r0.width = ((Integer) r1).intValue();
            ?? r2 = this.a;
            float r3 = r2.j + com.bytedance.android.live.revenue.common.i.b(68);
            Object r6 = r5.getAnimatedValue();
            if (r6 == null) goto L9;
            r2.setX(r3 - ((Integer) r6).intValue());
            this.a.requestLayout();
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ GiftSwitchImageView a;

        public b(GiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            TextView r0 = (TextView) this.a._$_findCachedViewById(2131387910);
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            r0.setAlpha(((Float) r4).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ GiftSwitchImageView a;

        public c(GiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            HSImageView r0 = this.a._$_findCachedViewById(2131387882);
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            r0.setAlpha(((Float) r4).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ GiftSwitchImageView a;

        public d(GiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ((TextView) this.a._$_findCachedViewById(2131387910)).setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a._$_findCachedViewById(2131387882).setVisibility(0);
            this.a._$_findCachedViewById(2131387882).setAlpha(0.0f);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ GiftSwitchImageView a;

        public e(GiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftSwitchImageView r0 = this.a;
            if ((r3 instanceof HSImageView) == true) goto L5;
            r3 = null;
        L5:
            GiftSwitchImageView.R5(r0, (HSImageView) r3);
        }
    }

    public static final class f {
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ GiftSwitchImageView a;

        public g(GiftSwitchImageView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            ConstraintLayout r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setAlpha(((Float) r3).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ GiftSwitchImageView a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ h a;

            public a(h r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Long r2 = (Long) r1;
                this.a.a.g.start();
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public h(GiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            GiftSwitchImageView r5 = this.a;
            if (r5.l == false) goto L6;
            r5.i = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r7) {
            Intrinsics.checkNotNullParameter(r7, "animation");
            GiftSwitchImageView r8 = this.a;
            if (r8.l == false) goto L5;
            ((TextView) r8._$_findCachedViewById(2131387910)).setVisibility(0);
            ((TextView) this.a._$_findCachedViewById(2131387910)).setAlpha(1.0f);
            this.a._$_findCachedViewById(2131387882).setVisibility(8);
            ViewGroup.LayoutParams r9 = this.a.getLayoutParams();
            r9.width = s1.j(2131168709);
        L6:
            this.a.setAlpha(1.0f);
            this.a.requestLayout();
            return;
        L5:
            ((TextView) r8._$_findCachedViewById(2131387910)).setVisibility(8);
            this.a._$_findCachedViewById(2131387882).setVisibility(0);
            ViewGroup.LayoutParams r10 = this.a.getLayoutParams();
            r10.width = s1.j(2131168708);
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ GiftSwitchImageView a;

        public i(GiftSwitchImageView r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            GiftSwitchImageView r15 = this.a;
            int r0 = GiftSwitchImageView.o;
            r15.getClass();
            AnimatorSet r1 = new AnimatorSet();
            ObjectAnimator r3 = ObjectAnimator.ofFloat(r15, "scaleX", new float[]{1.0f, 0.5f});
            r3.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r3.setDuration(150);
            Unit r10 = Unit.INSTANCE;
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r15, "scaleY", new float[]{1.0f, 0.5f});
            r4.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r4.setDuration(150);
            ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r5.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r5.setDuration(150);
            r5.addUpdateListener(new qz1.c(r15));
            r1.playTogether(new Animator[]{r3, r4, r5});
            r1.addListener(new qz1.d(r15));
            r15.f = r1;
            r1.start();
            Disposable r16 = this.a.h;
            if (r16 == null) goto L5;
            r16.dispose();
        L5:
            this.a.setPlaying(false);
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public GiftSwitchImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftSwitchImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getState() {
        int r0 = this.n;
        if (r0 != 1) goto L5;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L43;
        m<Boolean> r2 = r1.getEffectAudioSwitch();
        if (r2 != null) goto L31;
        return 0;
    L31:
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L45;
    L32:
        return 1;
    L45:
        return 0;
    L43:
        return 0;
    L5:
        if (r0 == 2) goto L19;
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L34;
        m<Boolean> r4 = r3.getEffectVibrateSwitch();
        if (r4 != null) goto L11;
        return 0;
    L11:
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L36;
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L37;
        m<Boolean> r6 = r5.getEffectAudioSwitch();
        if (r6 != null) goto L17;
        return 0;
    L17:
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L32;
        return 0;
    L37:
        return 0;
    L36:
        return 0;
    L34:
        return 0;
    L19:
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L40;
        m<Boolean> r8 = r7.getEffectVibrateSwitch();
        if (r8 != null) goto L24;
        return 0;
    L24:
        if (((Boolean) r8.getValue()).booleanValue() == false) goto L32;
        return 0;
    L40:
        return 0;
    }

    public final boolean T5() {
        if ((this.n & 2) == 2) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == true) goto L7;
        return true;
    }

    public final void U5() {
        long r0 = this.b;
        if (r0 == 0) goto L13;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        int r3 = this.n;
        n r4 = new n();
        Map r7 = r4.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        String r1 = String.valueOf(r0);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        r7.put("gift_id", r1);
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L10;
        if (r3 == 3) goto L9;
        String r5 = BuildConfig.FLAVOR;
    L12:
        Intrinsics.checkNotNullParameter("mode_type", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r7.put("mode_type", r5);
        mz0.m r6 = new mz0.m();
        r6.b(LogCommon.LIVE_SHARE_LOG);
        r6.b(LogCommon.ROOM);
        r6.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r4.b).addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_gift_mode_button_show", r4.a, r4.b);
        goto L13
    L9:
        r5 = "dual_mode";
        goto L12
    L10:
        r5 = "vibration";
        goto L12
    L11:
        r5 = "sound";
    L13:
        AnimatorSet r10 = new AnimatorSet();
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.5f, 1.0f});
        r11.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r11.setDuration(150);
        Unit r13 = Unit.INSTANCE;
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.5f, 1.0f});
        r14.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r14.setDuration(150);
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r15.setDuration(150);
        r15.addUpdateListener(new g(this));
        r10.playTogether(new Animator[]{r11, r14, r15});
        this.e = r10;
        r10.addListener(new h(this));
        AnimatorSet r16 = this.e;
        if (r16 == null) goto L17;
        r16.start();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5() {
        if (this.k == false) goto L6;
        return;
    L6:
        if (this.n != 0) goto L8;
        return;
    L8:
        this.k = true;
        this.j = getX();
        int r1 = n0.a;
        if (n0.a.a(this.n) == false) goto L11;
        this.l = false;
        U5();
    L18:
        if (this.m == 0) goto L24;
        Disposable r0 = this.h;
        if (r0 == null) goto L22;
        r0.dispose();
    L22:
        this.h = Observable.timer(((long) this.m) - 550, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.a);
        return;
    L24:
        return;
    L11:
        this.l = true;
        U5();
        int r2 = this.n;
        if (r2 != 1) goto L15;
        ay1.b.r.setValue(null, ay1.b.a[20], Boolean.TRUE);
        goto L18
    L15:
        if (r2 != 2) goto L18;
        ay1.b.s.setValue(null, ay1.b.a[21], Boolean.TRUE);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        AnimatorSet r0 = this.e;
        if (r0 == null) goto L5;
        S5(r0);
    L5:
        AnimatorSet r1 = this.f;
        if (r1 == null) goto L8;
        S5(r1);
    L8:
        AnimatorSet r2 = this.g;
        if (r2 == null) goto L11;
        S5(r2);
    L11:
        Disposable r3 = this.h;
        if (r3 == null) goto L14;
        r3.dispose();
    L14:
        Disposable r4 = this.i;
        if (r4 == null) goto L17;
        r4.dispose();
    L17:
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public final int getCurrentSwitchType() {
        return this.n;
    }

    public final int getDuration() {
        return this.m;
    }

    public static void S5(AnimatorSet r2) {
        r2.cancel();
        ArrayList<Animator> r3 = r2.getChildAnimations();
        if (r3 == null) goto L11;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L15;
        Animator r0 = (Animator) r4.next();
        if ((r0 instanceof ValueAnimator) == false) goto L10;
        ((ValueAnimator) r0).removeAllUpdateListeners();
    L10:
        r0.removeAllListeners();
        goto L6
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setCurrentSwitchType(int r1) {
        this.n = r1;
    }

    public final void setDuration(int r1) {
        this.m = r1;
    }

    public final void setPlaying(boolean r1) {
        this.k = r1;
    }

    public static final void R5(GiftSwitchImageView r9, HSImageView r10) {
        if (r10 != null) goto L4;
        r9.getClass();
        return;
    L4:
        boolean r1 = true;
        if (r9.getState() != 0) goto L41;
        long r7 = r9.b;
        if (r7 == 0) goto L9;
        String r0 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.C(r7, r9.n, "close");
    L9:
        ImageLoader.bindImage(r10, r9.d, s1.j(2131168708), s1.j(2131168708));
        int r11 = r9.n;
        if (r11 != 3) goto L23;
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L16;
        m<Boolean> r14 = r13.getEffectAudioSwitch();
        if (r14 == null) goto L16;
        r14.setValue(Boolean.FALSE);
    L16:
        GiftContext r15 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r15 == null) goto L21;
        m<Boolean> r16 = r15.getEffectVibrateSwitch();
        if (r16 == null) goto L21;
        r16.setValue(Boolean.FALSE);
    L21:
        ToastUtil.a(2131917087, 0);
        return;
    L23:
        if ((r11 & 1) == 1) goto L26;
        r1 = false;
    L26:
        if (r1 == false) goto L34;
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L32;
        m<Boolean> r18 = r17.getEffectAudioSwitch();
        if (r18 == null) goto L32;
        r18.setValue(Boolean.FALSE);
    L32:
        ToastUtil.a(2131917085, 0);
    L34:
        if (r9.T5() == false) goto L79;
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L40;
        m<Boolean> r20 = r19.getEffectVibrateSwitch();
        if (r20 == null) goto L40;
        r20.setValue(Boolean.FALSE);
    L40:
        ToastUtil.a(2131917183, 0);
        return;
    L79:
        return;
    L41:
        long r8 = r9.b;
        if (r8 == 0) goto L44;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.C(r8, r9.n, "open");
    L44:
        ImageLoader.bindImage(r10, r9.c, s1.j(2131168708), s1.j(2131168708));
        int r110 = r9.n;
        if (r110 != 3) goto L58;
        GiftContext r21 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r21 == null) goto L51;
        m<Boolean> r23 = r21.getEffectAudioSwitch();
        if (r23 == null) goto L51;
        r23.setValue(Boolean.TRUE);
    L51:
        GiftContext r24 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r24 == null) goto L56;
        m<Boolean> r25 = r24.getEffectVibrateSwitch();
        if (r25 == null) goto L56;
        r25.setValue(Boolean.TRUE);
    L56:
        ToastUtil.a(2131917088, 0);
        return;
    L58:
        if ((r110 & 1) == 1) goto L61;
        r1 = false;
    L61:
        if (r1 == false) goto L69;
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L67;
        m<Boolean> r112 = r111.getEffectAudioSwitch();
        if (r112 == null) goto L67;
        r112.setValue(Boolean.TRUE);
    L67:
        ToastUtil.a(2131917086, 0);
    L69:
        if (r9.T5() == false) goto L82;
        GiftContext r26 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r26 == null) goto L75;
        m<Boolean> r27 = r26.getEffectVibrateSwitch();
        if (r27 == null) goto L75;
        r27.setValue(Boolean.TRUE);
    L75:
        ToastUtil.a(2131917184, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GiftSwitchImageView(Context r11, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r13, r14);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r11).inflate(2131565248, this);
        _$_findCachedViewById(2131387882).setOnClickListener(new e(this));
        this.c = BuildConfig.FLAVOR;
        this.d = BuildConfig.FLAVOR;
        AnimatorSet r15 = new AnimatorSet();
        ObjectAnimator r16 = ObjectAnimator.ofInt(_$_findCachedViewById(2131387910), "translationX", new int[]{0, com.bytedance.android.live.revenue.common.i.b(10)});
        r16.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r16.setDuration(100);
        Unit r9 = Unit.INSTANCE;
        ValueAnimator r17 = ValueAnimator.ofInt(new int[]{getWidth(), s1.j(2131168708)});
        r17.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r17.addUpdateListener(new a(this));
        r17.setDuration(100);
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r18.setDuration(100);
        r18.addUpdateListener(new b(this));
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r19.setStartDelay(100);
        r19.setDuration(100);
        r19.addUpdateListener(new c(this));
        r15.playTogether(new Animator[]{r16, r17, r18, r19});
        r15.addListener(new d(this));
        this.g = r15;
        this.l = true;
        this.n = 1;
    }

    public /* synthetic */ GiftSwitchImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5(String r3, String r4, int r5, long r6) {
        if (r3 != null) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        this.c = r3;
        if (r4 != null) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        this.d = r4;
        this.n = r5;
        this.b = r6;
        if ((r5 & 1) != 1) goto L11;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L16;
        ((TextView) _$_findCachedViewById(2131387910)).setText(getContext().getString(2131917084));
    L19:
        if ((this.n & 1) != 1) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
    L26:
        int r9 = n0.a;
        if (n0.a.a(r5) == false) goto L29;
        this.l = false;
        ((TextView) _$_findCachedViewById(2131387910)).setVisibility(8);
    L31:
        if (getState() != 1) goto L33;
        ImageLoader.bindImage(_$_findCachedViewById(2131387882), this.d, s1.j(2131168708), s1.j(2131168708));
        return;
    L33:
        ImageLoader.bindImage(_$_findCachedViewById(2131387882), this.c, s1.j(2131168708), s1.j(2131168708));
        return;
    L29:
        this.l = true;
        ((TextView) _$_findCachedViewById(2131387910)).setVisibility(0);
        goto L31
    L24:
        if (T5() == true) goto L26;
        this.n = 0;
        goto L26
    L21:
        r8 = false;
        goto L22
    L16:
        if (T5() == false) goto L19;
        ((TextView) _$_findCachedViewById(2131387910)).setText(getContext().getString(2131917182));
        goto L19
    L11:
        r7 = false;
        goto L13
    }
}
