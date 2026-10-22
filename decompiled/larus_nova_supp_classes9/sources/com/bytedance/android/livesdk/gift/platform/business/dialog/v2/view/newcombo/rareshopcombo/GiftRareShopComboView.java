package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.ComboProgressAnimationViewNew;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.EXGaugeLevel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/rareshopcombo/GiftRareShopComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/z;", BuildConfig.FLAVOR, "countDownTime", BuildConfig.FLAVOR, "setCountDownTime", BuildConfig.FLAVOR, "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", BuildConfig.FLAVOR, "count", "setComboCount", BuildConfig.FLAVOR, "giftType", "setGiftType", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/EXGaugeLevel;", "getCurrentEXGaugeLevel", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftRareShopComboView extends BaseGiftComboView implements z {
    public Animator A;
    public AnimatedDrawable2 B;
    public AnimatedDrawable2 C;
    public int D;
    public long E;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h F;
    public float G;
    public final boolean H;
    public final GiftRareShopComboHeatHelper I;
    public boolean J;
    public Disposable K;
    public boolean L;
    public final d M;
    public final b N;
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public ComboProgressAnimationViewNew i;
    public HSImageView j;
    public HSImageView k;
    public HSImageView l;
    public GiftRareShopComboWaveView m;
    public HSImageView n;
    public HSImageView o;
    public View p;
    public AnimatorSet q;
    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f> r;
    public AnimatedDrawable2 s;
    public Animator t;
    public AnimatorSet u;
    public Animator v;
    public Animator w;
    public AnimatorSet x;
    public AnimatedDrawable2 y;
    public AnimatedDrawable2 z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GiftRareShopComboView a;

        public b(GiftRareShopComboView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r14) {
            if (((Boolean) r14).booleanValue() == false) goto L36;
            GiftRareShopComboView r15 = this.a;
            r15.L = false;
            AnimatorSet r7 = r15.u;
            if (r7 == null) goto L7;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r7);
        L7:
            AnimatorSet r8 = r15.x;
            if (r8 == null) goto L10;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r8);
        L10:
            View r9 = r15.b;
            if (r9 == null) goto L18;
            ObjectAnimator r10 = ObjectAnimator.ofFloat(r9, View.TRANSLATION_Y, new float[]{UtilityKotlinExtentionsKt.h(16.0f)}).setDuration(250);
            ObjectAnimator r11 = ObjectAnimator.ofFloat(r9, View.SCALE_X, new float[]{0.5f}).setDuration(250);
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r9, View.SCALE_Y, new float[]{0.5f}).setDuration(250);
            AnimatorSet r5 = new AnimatorSet();
            r5.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f));
            Unit r6 = Unit.INSTANCE;
            r15.u = r5;
            r5.playTogether(new Animator[]{r10, r11, r4});
            AnimatorSet r0 = r15.u;
            if (r0 == null) goto L15;
            r0.addListener(new n(r15));
        L15:
            AnimatorSet r1 = r15.u;
            if (r1 == null) goto L18;
            r1.start();
        L18:
            ArrayList r2 = new ArrayList();
            View r3 = r15.h;
            if (r3 == null) goto L21;
            r2.add(r15.h(r3));
        L21:
            View r13 = r15.g;
            if (r13 == null) goto L24;
            r2.add(r15.h(r13));
        L24:
            View r16 = r15.f;
            if (r16 == null) goto L27;
            r2.add(r15.h(r16));
        L27:
            View r17 = r15.e;
            if (r17 == null) goto L30;
            r2.add(r15.h(r17));
        L30:
            AnimatorSet r18 = new AnimatorSet();
            r15.x = r18;
            r18.playSequentially(r2);
            Animator r19 = r15.A;
            if (r19 != null) goto L33;
        L35:
            ObjectAnimator r20 = ObjectAnimator.ofFloat(r15.o, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(200);
            r20.addListener(new j(r15));
            r20.start();
            Unit r21 = Unit.INSTANCE;
            r15.A = r20;
            return;
        L33:
            if (r19.isRunning() != true) goto L35;
            return;
        L36:
            GiftRareShopComboView r110 = this.a;
            HSImageView r23 = r110.o;
            if (r23 == null) goto L39;
            r23.setVisibility(8);
        L39:
            HSImageView r24 = r110.l;
            if (r24 == null) goto L42;
            r24.setVisibility(8);
        L42:
            AnimatedDrawable2 r25 = r110.C;
            if (r25 == null) goto L45;
            r25.stop();
        L45:
            AnimatedDrawable2 r26 = r110.z;
            if (r26 == null) goto L48;
            r26.stop();
        L48:
            AnimatorSet r27 = r110.u;
            if (r27 == null) goto L51;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r27);
        L51:
            AnimatorSet r28 = r110.x;
            if (r28 == null) goto L54;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r28);
        L54:
            View r29 = r110.h;
            if (r29 == null) goto L57;
            r29.setVisibility(8);
        L57:
            View r30 = r110.g;
            if (r30 == null) goto L60;
            r30.setVisibility(8);
        L60:
            View r31 = r110.f;
            if (r31 == null) goto L63;
            r31.setVisibility(8);
        L63:
            View r33 = r110.e;
            if (r33 == null) goto L66;
            r33.setVisibility(8);
        L66:
            View r34 = r110.b;
            if (r34 != null) goto L69;
            return;
        L69:
            if (r34.getScaleX() == 1.0f) goto L71;
            boolean r35 = true;
        L72:
            if (r35 == true) goto L75;
            r34 = null;
        L75:
            if (r34 == null) goto L82;
            ObjectAnimator r36 = ObjectAnimator.ofFloat(r34, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(250);
            ObjectAnimator r37 = ObjectAnimator.ofFloat(r34, View.SCALE_X, new float[]{1.0f}).setDuration(250);
            ObjectAnimator r38 = ObjectAnimator.ofFloat(r34, View.SCALE_Y, new float[]{1.0f}).setDuration(250);
            AnimatorSet r39 = new AnimatorSet();
            r110.u = r39;
            r39.playTogether(new Animator[]{r36, r37, r38});
            AnimatorSet r111 = r110.u;
            if (r111 == null) goto L83;
            r111.start();
            return;
        L83:
            return;
        L82:
            return;
        L71:
            r35 = false;
            goto L72
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ GiftRareShopComboView a;
        public final /* synthetic */ View b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.b.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationStart(r3);
            this.b.setVisibility(0);
            AnimatedDrawable2 r4 = this.a.z;
            if (r4 != null) goto L5;
        L8:
            GiftRareShopComboView r5 = this.a;
            HSImageView r0 = r5.l;
            if (r0 == null) goto L11;
            r0.setVisibility(r5.getVisibility());
        L11:
            AnimatedDrawable2 r6 = r5.C;
            if (r6 != null) goto L14;
            return;
        L14:
            if (r6.isRunning() == false) goto L16;
            r6.stop();
        L16:
            r6.start();
            return;
        L5:
            if (r4.isRunning() == false) goto L7;
            r4.stop();
        L7:
            r4.start();
            goto L8
        }

        public c(GiftRareShopComboView r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ GiftRareShopComboView a;

        public d(GiftRareShopComboView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            if (((Boolean) r7).booleanValue() == true) goto L32;
            final GiftRareShopComboView r8 = this.a;
            AnimatedDrawable2 r0 = r8.s;
            if (r0 != null) goto L7;
        L8:
            HSImageView r1 = r8.j;
            if (r1 != null) goto L11;
        L12:
            Animator r2 = r8.t;
            if (r2 == null) goto L15;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r2);
        L15:
            HSImageView r3 = r8.j;
            if (r3 == null) goto L18;
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(800);
            Function1<Animator, Unit> r5 = new GiftRareShopComboView$playEndEffectAnimation$$inlined$let$lambda$1(r8);
            Intrinsics.checkNotNullParameter(r4, "$this$doOnNormalEnd");
            Intrinsics.checkNotNullParameter(r5, "action");
            r4.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.b(r5));
        L19:
            r8.t = r4;
            if (r4 == null) goto L22;
            r4.start();
        L22:
            Animator r6 = r8.v;
            if (r6 == null) goto L25;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r6);
        L25:
            Animator r9 = r8.w;
            if (r9 != null) goto L28;
        L30:
            ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r8.G, 0.0f});
            r10.setDuration((long) (r8.G * I18nInitTask.DELAY_TS_MS));
            r10.addUpdateListener(new o(r8));
            Unit r11 = Unit.INSTANCE;
            r8.w = r10;
            r10.start();
            return;
        L28:
            if (r9.isRunning() != true) goto L30;
            return;
        L18:
            r4 = null;
            goto L19
        L11:
            if (r1.getAlpha() == 0.0f) goto L22;
        L7:
            if (r0.isRunning() == true) goto L12;
        }
    }

    static {
    }

    public GiftRareShopComboView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftRareShopComboView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void f() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.d;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        this.b = this.d;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void g() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.d;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        this.b = this.c;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z
    public EXGaugeLevel getCurrentEXGaugeLevel() {
        return this.F.c;
    }

    public final void i() {
        this.I.c.removeObserver(this.M);
        this.I.d.removeObserver(this.N);
        Animator r0 = this.t;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r0);
    L5:
        AnimatorSet r1 = this.q;
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r1);
    L8:
        AnimatorSet r2 = this.u;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r2);
    L11:
        Animator r3 = this.v;
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r3);
    L14:
        Animator r4 = this.w;
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r4);
    L17:
        AnimatorSet r5 = this.x;
        if (r5 == null) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L20:
        Animator r6 = this.A;
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r6);
    L23:
        GiftRareShopComboHeatHelper r7 = this.I;
        AnimatorSet r8 = r7.b;
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r8);
    L26:
        AnimatorSet r9 = r7.b;
        if (r9 == null) goto L36;
        ArrayList<Animator> r10 = r9.getChildAnimations();
        if (r10 == null) goto L36;
        Iterator<T> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L36;
        Animator r13 = (Animator) r11.next();
        if ((r13 instanceof ValueAnimator) == false) goto L32;
        r13.removeAllListeners();
        ((ValueAnimator) r13).removeAllUpdateListeners();
    L36:
        Animator r14 = r7.a;
        if (r14 == null) goto L39;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r14);
    L39:
        r7.b = null;
        r7.a = null;
        ComboProgressAnimationViewNew r15 = this.i;
        if (r15 == null) goto L42;
        r15.g();
    L42:
        AnimatedDrawable2 r16 = this.s;
        if (r16 == null) goto L45;
        r16.stop();
    L45:
        AnimatedDrawable2 r17 = this.y;
        if (r17 == null) goto L48;
        r17.stop();
    L48:
        AnimatedDrawable2 r18 = this.z;
        if (r18 == null) goto L51;
        r18.stop();
    L51:
        AnimatedDrawable2 r19 = this.C;
        if (r19 == null) goto L54;
        r19.stop();
    L54:
        AnimatedDrawable2 r20 = this.B;
        if (r20 == null) goto L63;
        r20.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        i();
        Iterator r0 = ((ArrayList) this.r).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r0.next()).b(true);
        goto L4
    L6:
        GiftRareShopComboWaveView r1 = this.m;
        if (r1 == null) goto L11;
        r1.removeAllViews();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        Iterator<T> r0 = this.r.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r0.next()).b(false);
        goto L4
    }

    public final AnimatorSet h(View r9) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r9, View.SCALE_X, new float[]{0.8f, 1.0f}).setDuration(1000);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r9, View.SCALE_Y, new float[]{0.8f, 1.0f}).setDuration(1000);
        r2.addListener(new c(this, r9));
        AnimatorSet r10 = new AnimatorSet();
        r10.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r10.playTogether(new Animator[]{r0, r2});
        return r10;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r1) {
        this.D = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r2) {
        ComboProgressAnimationViewNew r0 = this.i;
        if (r0 == null) goto L6;
        r0.setGroupSend(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r2) {
        ComboProgressAnimationViewNew r0 = this.i;
        if (r0 == null) goto L6;
        r0.setSeriesSend(r2);
        return;
    }

    public GiftRareShopComboView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "mContext");
        super(r6, r7, r8);
        this.r = new ArrayList();
        this.E = b02.a.a();
        this.F = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h();
        this.H = true;
        GiftRareShopComboHeatHelper r9 = new GiftRareShopComboHeatHelper(this.E);
        this.I = r9;
        this.J = true;
        d r0 = new d(this);
        this.M = r0;
        b r1 = new b(this);
        this.N = r1;
        FrameLayout.inflate(r6, 2131565231, this);
        this.j = findViewById(2131367227);
        ComboProgressAnimationViewNew r10 = (ComboProgressAnimationViewNew) findViewById(2131367251);
        r10.setComboButtonStyle(1);
        Unit r11 = Unit.INSTANCE;
        this.i = r10;
        this.k = findViewById(2131363822);
        this.l = findViewById(2131363808);
        GiftRareShopComboWaveView r13 = (GiftRareShopComboWaveView) findViewById(2131393021);
        if (r13 == null) goto L8;
        c0 r14 = c0.d;
        r14.getClass();
        if (((f0) c0.b.getValue(r14, c0.a[0])).a() == true) goto L9;
        r13.a = s1.m(2131250735);
    L9:
        this.m = r13;
        this.p = findViewById(2131379160);
        this.a = findViewById(2131367228);
        this.n = findViewById(2131367230);
        this.o = findViewById(2131367229);
        this.c = findViewById(2131367262);
        this.d = findViewById(2131379189);
        this.b = this.c;
        this.e = findViewById(2131368006);
        this.f = findViewById(2131368007);
        this.g = findViewById(2131368008);
        this.h = findViewById(2131368009);
        this.E = b02.a.a();
        HSImageView r15 = this.j;
        if (r15 == null) goto L12;
        r15.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_big_combo_arrow_effect.webp").setControllerListener(new e(this)).build());
    L12:
        HSImageView r16 = this.n;
        if (r16 == null) goto L15;
        r16.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_wave_anim.webp").setControllerListener(new f(this)).build());
    L15:
        HSImageView r17 = this.o;
        if (r17 == null) goto L18;
        r17.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_count_down_wave_anim.webp").setControllerListener(new g(this)).build());
    L18:
        HSImageView r18 = this.k;
        if (r18 == null) goto L21;
        r18.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_background_wave_anim.webp").setControllerListener(new h(this)).build());
    L21:
        HSImageView r19 = this.l;
        if (r19 == null) goto L24;
        r19.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_background_count_down_anim.webp").setControllerListener(new i(this)).build());
    L24:
        r9.c.observeForever(r0);
        r9.d.observeForever(r1);
        return;
    L8:
        r13 = null;
        goto L9
    }

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
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void c(Runnable r17, int r18, int r19) {
        int r1 = this.D;
        if (r1 == 0) goto L163;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h r2 = this.F;
        Boolean r3 = (Boolean) this.I.c.getValue();
        if (r3 != null) goto L8;
        r3 = Boolean.FALSE;
    L8:
        r2.a(r1, r3.booleanValue());
        AnimatorSet r4 = this.q;
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r4);
    L11:
        View r5 = this.b;
        if (r5 == null) goto L14;
        r5.setVisibility(0);
    L14:
        View r6 = this.a;
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        this.q = new AnimatorSet();
        View r7 = this.a;
        ObjectAnimator r8 = null;
        if (r7 == null) goto L20;
        AnimatorSet r9 = com.bytedance.android.live.revenue.common.e.c(r7, new float[]{r7.getScaleX(), 0.8f}).setDuration(100);
    L21:
        View r10 = this.b;
        if (r10 == null) goto L24;
        AnimatorSet r11 = com.bytedance.android.live.revenue.common.e.c(r10, new float[]{r10.getScaleX(), 0.8f}).setDuration(100);
    L25:
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r9, r11});
        View r14 = this.a;
        if (r14 == null) goto L28;
        AnimatorSet r15 = com.bytedance.android.live.revenue.common.e.c(r14, new float[]{0.8f, 1.0f}).setDuration(400);
        r15.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L29:
        View r16 = this.b;
        if (r16 == null) goto L32;
        AnimatorSet r110 = com.bytedance.android.live.revenue.common.e.c(r16, new float[]{0.8f, 1.0f}).setDuration(400);
        r110.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L33:
        AnimatorSet r20 = new AnimatorSet();
        r20.playTogether(new Animator[]{r15, r110, ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.E)});
        AnimatorSet r21 = this.q;
        if (r21 == null) goto L36;
        r21.playSequentially(new Animator[]{r13, r20});
    L36:
        AnimatorSet r23 = this.q;
        if (r23 == null) goto L39;
        r23.addListener(new l(this, (com.bytedance.android.livesdk.gift.biggift.view.d) r17));
    L39:
        AnimatorSet r24 = this.q;
        if (r24 == null) goto L43;
        r24.start();
    L43:
        if (this.J == false) goto L49;
        this.J = false;
        AnimatedDrawable2 r25 = this.y;
        if (r25 == null) goto L47;
        r25.start();
    L48:
        this.K = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this));
    L60:
        if (this.D <= 0) goto L161;
        EXGaugeLevel r26 = this.F.c;
        EXGaugeLevel r27 = EXGaugeLevel.HEATED;
        if (r26 != r27) goto L73;
        Animator r28 = this.w;
        if (r28 == null) goto L66;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r28);
    L66:
        Animator r29 = this.v;
        if (r29 != null) goto L69;
    L71:
        Drawable r30 = s1.m(2131250728);
        Drawable r31 = s1.m(2131250729);
        ValueAnimator r33 = ValueAnimator.ofFloat(new float[]{this.G, 1.0f});
        r33.setDuration((long) ((1.0f - this.G) * I18nInitTask.DELAY_TS_MS));
        r33.addUpdateListener(new k(this, r31, r30));
        Unit r34 = Unit.INSTANCE;
        this.v = r33;
        r33.start();
        goto L73
    L69:
        if (r29.isRunning() != true) goto L71;
    L73:
        if (this.H == false) goto L113;
        AnimatedDrawable2 r35 = this.s;
        if (r35 == null) goto L79;
        if (r35.isRunning() != true) goto L79;
    L99:
        if (getParent() == null) goto L113;
        int[] r36 = {0, 0};
        View r37 = this.p;
        if (r37 == null) goto L104;
        r37.getLocationOnScreen(r36);
    L104:
        PointF r111 = new PointF(r36[0] + UtilityKotlinExtentionsKt.h(35.0f), r36[1] + UtilityKotlinExtentionsKt.h(8.5f));
        PointF r112 = new PointF(r111.x - UtilityKotlinExtentionsKt.h(33.0f), r111.y - UtilityKotlinExtentionsKt.h(113.0f));
        ViewParent r38 = getParent();
        if (r38 == null) goto L112;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r39 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r111, r112, (ViewGroup) r38, getContext(), 1);
        ((ArrayList) this.r).add(r39);
        if (this.F.c != EXGaugeLevel.OVERHEATED) goto L109;
        boolean r40 = true;
    L110:
        r39.a(r40, true);
        goto L113
    L109:
        r40 = false;
        goto L110
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L79:
        if (this.F.c != EXGaugeLevel.OVERHEATED) goto L99;
        HSImageView r41 = this.j;
        if (r41 == null) goto L83;
        r41.setVisibility(0);
    L83:
        AnimatedDrawable2 r43 = this.s;
        if (r43 == null) goto L86;
        com.bytedance.android.live.core.utils.fresco.c.b(r43);
    L86:
        AnimatedDrawable2 r44 = this.s;
        if (r44 == null) goto L89;
        r44.start();
    L89:
        Animator r45 = this.t;
        if (r45 == null) goto L92;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r45);
    L92:
        HSImageView r46 = this.j;
        if (r46 == null) goto L95;
        r8 = ObjectAnimator.ofFloat(r46, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(250);
    L95:
        this.t = r8;
        if (r8 == null) goto L99;
        r8.start();
    L113:
        AnimatedDrawable2 r47 = this.B;
        if (r47 != null) goto L116;
    L118:
        GiftRareShopComboWaveView r48 = this.m;
        if (r48 == null) goto L135;
        EXGaugeLevel r113 = this.F.c;
        if (r113 != r27) goto L123;
    L126:
        boolean r114 = true;
    L127:
        if (r114 == false) goto L135;
        c0 r115 = c0.d;
        r115.getClass();
        if (((f0) c0.b.getValue(r115, c0.a[0])).a() == true) goto L132;
    L134:
        View r116 = new View(r48.getContext());
        r116.setBackground(r48.a);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(s1.f(128.0f), s1.f(128.0f));
        r117.gravity = 17;
        Unit r118 = Unit.INSTANCE;
        r116.setLayoutParams(r117);
        r116.setAlpha(1.0f);
        r116.setScaleX(0.88f);
        r116.setScaleY(0.88f);
        r48.addView(r116);
        r116.animate().alpha(0.0f).scaleX(1.3f).scaleY(1.3f).setDuration(1030).setListener(new p(r48, r116)).start();
        goto L135
    L132:
        if (r48.a != null) goto L134;
        r48.a = s1.m(2131250735);
        goto L134
    L123:
        if (r113 == EXGaugeLevel.OVERHEATED) goto L126;
        r114 = false;
    L135:
        ComboProgressAnimationViewNew r49 = this.i;
        if (r49 == null) goto L138;
        r49.setVisibility(0);
    L138:
        ComboProgressAnimationViewNew r50 = this.i;
        if (r50 == null) goto L141;
        r50.e(this.D, r19);
    L141:
        ComboProgressAnimationViewNew r51 = this.i;
        if (r51 == null) goto L144;
        r51.f();
    L144:
        GiftRareShopComboHeatHelper r53 = this.I;
        AnimatorSet r54 = r53.b;
        if (r54 == null) goto L147;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r54);
    L147:
        ValueAnimator r55 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r55.setDuration(250);
        r55.addUpdateListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.b(r53));
        Ref.FloatRef r56 = new Ref.FloatRef();
        r56.element = 0.0f;
        ValueAnimator r57 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r57.setDuration(r53.e);
        r57.addUpdateListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.c(r57, r53, r56));
        r57.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.d(r53));
        AnimatorSet r58 = new AnimatorSet();
        r53.b = r58;
        r58.playSequentially(new Animator[]{r55, r57});
        AnimatorSet r59 = r53.b;
        if (r59 == null) goto L150;
        r59.start();
    L150:
        EXGaugeLevel r60 = this.F.c;
        if (r60 != r27) goto L153;
    L154:
        GiftRareShopComboHeatHelper r61 = this.I;
        Animator r63 = r61.a;
        if (r63 != null) goto L157;
    L159:
        ValueAnimator r64 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r64.setDuration(2500);
        r64.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.a(r61));
        Unit r65 = Unit.INSTANCE;
        r61.a = r64;
        r64.start();
        return;
    L157:
        if (r63.isRunning() != true) goto L159;
        return;
    L153:
        if (r60 == EXGaugeLevel.OVERHEATED) goto L154;
        return;
    L116:
        if (r47.isRunning() == true) goto L118;
        r47.start();
        goto L118
    L161:
        return;
    L47:
        this.L = true;
        goto L48
    L49:
        this.L = false;
        AnimatedDrawable2 r66 = this.y;
        if (r66 == null) goto L60;
        AnimationBackend r67 = r66.getAnimationBackend();
        if (r67 != null) goto L54;
    L55:
        r66.setAnimationBackend(new q(r66.getAnimationBackend()));
        r66.stop();
    L57:
        if (r66.isRunning() == true) goto L60;
        r66.start();
        goto L60
    L54:
        if (r67.getLoopCount() == 1) goto L57;
    L32:
        r110 = null;
        goto L33
    L28:
        r15 = null;
        goto L29
    L24:
        r11 = null;
        goto L25
    L20:
        r9 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r2, l1 r3, com.bytedance.android.livesdk.gift.model.n r4) {
        ComboProgressAnimationViewNew r0 = this.i;
        if (r0 == null) goto L6;
        r0.setGift(r2);
        r0.setBuffInfo(r3);
        r0.setDiyInfo(r4);
        return;
    }

    public /* synthetic */ GiftRareShopComboView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
