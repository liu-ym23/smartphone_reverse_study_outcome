package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/z;", BuildConfig.FLAVOR, "getCountDownTime", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/EXGaugeLevel;", "getCurrentEXGaugeLevel", "countDownTime", BuildConfig.FLAVOR, "setCountDownTime", BuildConfig.FLAVOR, "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", BuildConfig.FLAVOR, "count", "setComboCount", BuildConfig.FLAVOR, "giftType", "setGiftType", "RecommendStatus", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftComboView extends BaseGiftComboView implements z {
    public static final /* synthetic */ int R = 0;
    public final boolean A;
    public AnimatorSet B;
    public AnimatorSet C;
    public Runnable D;
    public RecommendStatus E;
    public View F;
    public TextView G;
    public View H;
    public ImageView I;
    public TextView J;
    public TextView K;
    public long L;
    public Disposable M;
    public Disposable N;
    public final t O;
    public final s P;
    public final boolean Q;
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public HSImageView j;
    public AnimatorSet k;
    public ComboProgressAnimationViewNew l;
    public ComboWaveView m;
    public GiftComboProgressBar n;
    public HSImageView o;
    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f> p;
    public Animator q;
    public Animator r;
    public AnimatedDrawable2 s;
    public AnimatorSet t;
    public AnimatorSet u;
    public Animator v;
    public int w;
    public float x;
    public long y;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboView$RecommendStatus;", BuildConfig.FLAVOR, "Idle", "OnlyCount", "Gift", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RecommendStatus extends Enum<RecommendStatus> {
        public static final RecommendStatus Gift = null;
        public static final RecommendStatus Idle = null;
        public static final RecommendStatus OnlyCount = null;
        public static final /* synthetic */ RecommendStatus[] a = null;

        static {
            RecommendStatus r1 = new RecommendStatus("Idle", 0);
            Idle = r1;
            RecommendStatus r2 = new RecommendStatus("OnlyCount", 1);
            OnlyCount = r2;
            RecommendStatus r3 = new RecommendStatus("Gift", 2);
            Gift = r3;
            a = new RecommendStatus[]{r1, r2, r3};
        }

        public static RecommendStatus valueOf(String r1) {
            return (RecommendStatus) r27.a.a(RecommendStatus.class, r1);
        }

        public static RecommendStatus[] values() {
            return (RecommendStatus[]) a.clone();
        }

        public RecommendStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftComboView a;
        public final /* synthetic */ long b;

        public a(GiftComboView r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            TextView r7 = this.a.G;
            if (r7 == null) goto L5;
            r7.setText("X" + this.b);
        L5:
            TextView r8 = this.a.K;
            if (r8 == null) goto L9;
            r8.setText("X" + this.b);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftComboView a;
        public final /* synthetic */ h2 b;

        public b(GiftComboView r1, h2 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            ImageUtil.loadImage(this.a.I, this.b.getImage(), 0);
            com.bytedance.android.livesdk.gift.platform.business.config.j r6 = com.bytedance.android.livesdk.gift.util.b.a();
            GiftConfigKey r0 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
            DiamondConfig.d.getClass();
            DiamondConfig r7 = (DiamondConfig) r6.c(r0, DiamondConfig.a.a());
            TextView r1 = this.a.J;
            if (r1 == null) goto L6;
            r1.setText(String.valueOf(this.b.getDiamondCount()) + r7.b);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftComboView a;

        public c(GiftComboView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            TextView r4 = this.a.K;
            if (r4 == null) goto L6;
            r4.setText("X1");
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ GiftComboView a;

        public d(GiftComboView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GiftComboView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = GiftComboView.R;     // Catch: Throwable -> L4
            r0.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        public e(View r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            this.a.setVisibility(0);
        }
    }

    public static final class f extends o12.b {
        public boolean a;
        public final /* synthetic */ GiftComboView b;

        public f(GiftComboView r1) {
            this.b = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == false) goto L5;
            return;
        L5:
            Runnable r3 = this.b.D;
            if (r3 == null) goto L8;
            r3.run();
        L8:
            this.b.setVisibility(8);
            System.currentTimeMillis();
            this.a = false;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            System.currentTimeMillis();
        }
    }

    public static final class g extends o12.b {
        public final /* synthetic */ GiftComboView a;
        public final /* synthetic */ View b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        public g(GiftComboView r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "animation");
            View r3 = this.b;
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    public static final class h extends o12.b {
        public final /* synthetic */ GiftComboView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ boolean d;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if ((!Intrinsics.areEqual(this.b, this.c)) == false) goto L11;
            View r3 = this.b;
            if (r3 == null) goto L7;
            r3.setVisibility(8);
        L7:
            View r4 = this.c;
            if (r4 == null) goto L11;
            r4.setVisibility(0);
        L11:
            if (this.d == false) goto L14;
            GiftComboView r5 = this.a;
            int r0 = GiftComboView.R;
            r5.l();
            return;
        }

        public h(GiftComboView r1, View r2, View r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public GiftComboView(Context r4) {
        this(r4, null, 0, 14);
    }

    public GiftComboView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public GiftComboView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    public final void k() {
        j(true);
        AnimatorSet r1 = this.k;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r1);
    L5:
        AnimatorSet r2 = this.k;
        if (r2 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r2);
    L8:
        this.k = new AnimatorSet();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.y);
        AnimatorSet r4 = this.k;
        if (r4 == null) goto L11;
        r4.playTogether(new Animator[]{r3});
    L11:
        AnimatorSet r0 = this.k;
        if (r0 == null) goto L14;
        r0.addListener(new f(this));
    L14:
        AnimatorSet r5 = this.k;
        if (r5 == null) goto L18;
        r5.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r1) {
    }

    private final long getCountDownTime() {
        if (this.Q == true) goto L7;
        KProperty[] r0 = b02.a.a;
        return com.bytedance.android.livesdk.gift.platform.business.j.b().M7() * 1000;
    L7:
        return b02.a.a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        AnimatorSet r0 = this.k;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r0);
    L5:
        Animator r1 = this.q;
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r1);
    L8:
        Animator r2 = this.r;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r2);
    L11:
        AnimatorSet r3 = this.t;
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r3);
    L14:
        AnimatorSet r4 = this.u;
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r4);
    L17:
        Animator r5 = this.v;
        if (r5 == null) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L20:
        AnimatorSet r6 = this.B;
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r6);
    L23:
        AnimatorSet r7 = this.B;
        if (r7 == null) goto L26;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r7);
    L26:
        AnimatorSet r8 = this.C;
        if (r8 == null) goto L29;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r8);
    L29:
        AnimatorSet r9 = this.C;
        if (r9 == null) goto L32;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r9);
    L32:
        Disposable r10 = this.M;
        if (r10 == null) goto L35;
        r10.dispose();
    L35:
        this.M = null;
        Disposable r11 = this.N;
        if (r11 == null) goto L38;
        r11.dispose();
    L38:
        this.M = null;
        ComboWaveView r13 = this.m;
        if (r13 == null) goto L41;
        r13.removeAllViews();
    L41:
        GiftComboProgressBar r14 = this.n;
        if (r14 == null) goto L63;
        AnimatorSet r15 = r14.h;
        if (r15 == null) goto L46;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r15);
    L46:
        AnimatorSet r16 = r14.h;
        if (r16 == null) goto L56;
        ArrayList<Animator> r17 = r16.getChildAnimations();
        if (r17 == null) goto L56;
        Iterator<T> r18 = r17.iterator();
    L52:
        if (r18.hasNext() == false) goto L56;
        Animator r19 = (Animator) r18.next();
        if ((r19 instanceof ValueAnimator) == false) goto L52;
        r19.removeAllListeners();
        ((ValueAnimator) r19).removeAllUpdateListeners();
    L56:
        Animator r20 = r14.r;
        if (r20 == null) goto L59;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r20);
    L59:
        Animator r21 = r14.t;
        if (r21 == null) goto L62;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r21);
    L62:
        r14.h = null;
        r14.r = null;
        r14.t = null;
        r14.g = 0.0f;
        r14.s = 0.0f;
        r14.w = 0.0f;
    L63:
        ComboProgressAnimationViewNew r23 = this.l;
        if (r23 == null) goto L66;
        r23.g();
    L66:
        AnimatedDrawable2 r24 = this.s;
        if (r24 == null) goto L69;
        r24.stop();
    L69:
        Iterator<T> r25 = this.p.iterator();
    L71:
        if (r25.hasNext() == false) goto L73;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r25.next()).b(true);
        goto L71
    L73:
        HSImageView r26 = this.o;
        if (r26 == null) goto L76;
        r26.setVisibility(4);
    L76:
        HSImageView r27 = this.j;
        if (r27 == null) goto L79;
        r27.setVisibility(4);
    L79:
        HSImageView r28 = this.j;
        if (r28 == null) goto L82;
        r28.setAlpha(0.0f);
    L82:
        this.w = 0;
        this.x = 0.0f;
        this.E = RecommendStatus.Idle;
        View r29 = this.b;
        if (r29 == null) goto L85;
        r29.setScaleX(1.0f);
    L85:
        View r30 = this.b;
        if (r30 == null) goto L88;
        r30.setScaleY(1.0f);
    L88:
        View r31 = this.b;
        if (r31 == null) goto L91;
        r31.setAlpha(1.0f);
    L91:
        View r33 = this.b;
        if (r33 == null) goto L101;
        r33.setTranslationY(0.0f);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void f() {
        if (this.E != RecommendStatus.Idle) goto L12;
        View r0 = this.c;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        View r1 = this.d;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        this.b = this.d;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void g() {
        if (this.E != RecommendStatus.Idle) goto L12;
        View r0 = this.c;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        View r1 = this.d;
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        this.b = this.c;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z
    public EXGaugeLevel getCurrentEXGaugeLevel() {
        return this.z.c;
    }

    public final void l() {
        if (this.E != RecommendStatus.Gift) goto L29;
        AnimatorSet r0 = this.C;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r0);
    L7:
        AnimatorSet r1 = this.C;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.C = new AnimatorSet();
        TextView r2 = this.J;
        if (r2 == null) goto L13;
        r2.setAlpha(1.0f);
    L13:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.J, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r4 = this.C;
        if (r4 == null) goto L16;
        r4.playTogether(new Animator[]{r3});
    L16:
        AnimatorSet r5 = this.C;
        if (r5 == null) goto L19;
        r5.setStartDelay(1350);
    L19:
        AnimatorSet r6 = this.C;
        if (r6 == null) goto L22;
        r6.setDuration(300);
    L22:
        AnimatorSet r7 = this.C;
        if (r7 == null) goto L25;
        r7.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L25:
        AnimatorSet r8 = this.C;
        if (r8 == null) goto L30;
        r8.start();
        return;
    L30:
        return;
    }

    public final void m() {
        AnimatorSet r1 = this.u;
        if (r1 != null) goto L5;
    L6:
        AnimatorSet r2 = this.t;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L49;
        AnimatorSet r4 = this.t;
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r4);
    L16:
        AnimatorSet r5 = this.u;
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L19:
        View r6 = this.b;
        if (r6 == null) goto L22;
        r6.setVisibility(8);
    L22:
        View r7 = this.e;
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        View r8 = this.f;
        if (r8 == null) goto L28;
        r8.setVisibility(8);
    L28:
        View r9 = this.g;
        if (r9 == null) goto L31;
        r9.setVisibility(8);
    L31:
        View r10 = this.h;
        if (r10 == null) goto L34;
        r10.setVisibility(8);
    L34:
        View r11 = this.b;
        if (r11 == null) goto L37;
        r11.setTranslationY(0.0f);
    L37:
        View r13 = this.e;
        if (r13 == null) goto L40;
        r13.setAlpha(1.0f);
    L40:
        View r14 = this.f;
        if (r14 == null) goto L43;
        r14.setAlpha(1.0f);
    L43:
        View r15 = this.g;
        if (r15 == null) goto L46;
        r15.setAlpha(1.0f);
    L46:
        View r16 = this.h;
        if (r16 == null) goto L49;
        r16.setAlpha(1.0f);
    L49:
        k();
        AnimatorSet r17 = this.B;
        if (r17 == null) goto L52;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r17);
    L52:
        AnimatorSet r18 = this.B;
        if (r18 == null) goto L55;
        r18.cancel();
    L55:
        this.B = new AnimatorSet();
        if (this.E != RecommendStatus.OnlyCount) goto L58;
        View r19 = this.F;
    L59:
        AnimatorSet r20 = new AnimatorSet();
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r19, "scaleX", new float[]{0.2f, 1.1f});
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r19, "scaleY", new float[]{0.2f, 1.1f});
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r19, "alpha", new float[]{0.0f, 1.0f});
        if (r3 == true) goto L66;
        View r24 = this.b;
        if (r24 == null) goto L66;
        if (r24.getVisibility() != 0) goto L66;
        r20.playTogether(new Animator[]{r21, r23, r110, ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f})});
    L67:
        r20.setDuration(250);
        r20.addListener(new g(this, r19));
        AnimatorSet r25 = new AnimatorSet();
        r25.playTogether(new Animator[]{ObjectAnimator.ofFloat(r19, "scaleX", new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(r19, "scaleY", new float[]{1.1f, 1.0f})});
        r25.setDuration(300);
        AnimatorSet r26 = this.B;
        if (r26 == null) goto L70;
        r26.playSequentially(new Animator[]{r20, r25});
    L70:
        AnimatorSet r27 = this.B;
        if (r27 == null) goto L73;
        r27.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L73:
        AnimatorSet r28 = this.B;
        if (r28 == null) goto L76;
        r28.start();
    L76:
        l();
        return;
    L66:
        r20.playTogether(new Animator[]{r21, r23, r110});
        goto L67
    L58:
        r19 = this.H;
        goto L59
    L9:
        if (r2.isRunning() != true) goto L11;
    L10:
        r3 = true;
        goto L12
    L5:
        if (r1.isRunning() == true) goto L10;
        goto L6
    }

    public final void i() {
        if (getParent() != null) goto L5;
        return;
    L5:
        int[] r0 = {0, 0};
        View r1 = this.i;
        if (r1 == null) goto L8;
        r1.getLocationOnScreen(r0);
    L8:
        boolean r2 = false;
        if (this.Q == false) goto L19;
        PointF r3 = new PointF(r0[0] + UtilityKotlinExtentionsKt.h(25.5f), r0[1] + UtilityKotlinExtentionsKt.h(8.5f));
        PointF r4 = new PointF(r3.x - UtilityKotlinExtentionsKt.h(33.0f), r3.y - UtilityKotlinExtentionsKt.h(113.0f));
        ViewParent r6 = getParent();
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r5 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r3, r4, (ViewGroup) r6, getContext());
        ((ArrayList) this.p).add(r5);
        if (this.z.c != EXGaugeLevel.OVERHEATED) goto L15;
        r2 = true;
    L15:
        r5.a(r2, this.Q);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L19:
        if (com.bytedance.android.livesdk.gift.util.c.c() == false) goto L21;
        float r7 = nz1.a.q().c();
    L22:
        PointF r8 = new PointF((r0[0] / r7) + UtilityKotlinExtentionsKt.h(25.5f), (r0[1] / r7) + UtilityKotlinExtentionsKt.h(6.5f));
        PointF r9 = new PointF(r8.x, r8.y - UtilityKotlinExtentionsKt.h(85.0f));
        ViewParent r10 = getParent();
        if (r10 == null) goto L30;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r11 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r8, r9, (ViewGroup) r10, getContext());
        ((ArrayList) this.p).add(r11);
        if (this.z.c != EXGaugeLevel.OVERHEATED) goto L27;
        r2 = true;
    L27:
        r11.a(r2, this.Q);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L21:
        r7 = 1.0f;
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GiftComboProgressBar r0 = this.n;
        if (r0 == null) goto L7;
        NextLiveData<Boolean> r1 = r0.x;
        if (r1 == null) goto L7;
        r1.removeObserver(this.O);
    L7:
        GiftComboProgressBar r2 = this.n;
        if (r2 == null) goto L13;
        NextLiveData<Pair<Boolean, Boolean>> r3 = r2.getShowCountDown();
        if (r3 == null) goto L14;
        r3.removeObserver(this.P);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r9) {
        long r0 = System.currentTimeMillis();
        RecommendStatus r2 = this.E;
        if (r2 != RecommendStatus.Idle) goto L6;
        this.E = RecommendStatus.OnlyCount;
        m();
    L8:
        long r3 = 0;
    L14:
        this.L = r0;
        ComboProgressAnimationViewNew r1 = this.l;
        if (r1 == null) goto L17;
        r1.setBanHint(true);
    L17:
        Disposable r4 = this.N;
        if (r4 == null) goto L20;
        r4.dispose();
    L20:
        this.N = Observable.timer(r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r9));
        return;
    L6:
        if ((r0 - this.L) > 250) goto L10;
        k();
        goto L8
    L10:
        if (r2 != RecommendStatus.OnlyCount) goto L12;
        View r5 = this.F;
    L13:
        n(r5, r5, false);
        r3 = 125;
        goto L14
    L12:
        r5 = this.H;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        long r0 = System.currentTimeMillis();
        RecommendStatus r2 = this.E;
        if (r2 != RecommendStatus.Idle) goto L7;
        this.E = RecommendStatus.Gift;
        m();
    L13:
        long r5 = 0;
    L15:
        this.L = r0;
        ComboProgressAnimationViewNew r1 = this.l;
        if (r1 == null) goto L18;
        r1.setBanHint(true);
    L18:
        Disposable r3 = this.M;
        if (r3 == null) goto L21;
        r3.dispose();
    L21:
        TimeUnit r4 = TimeUnit.MILLISECONDS;
        this.M = Observable.timer(r5, r4).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r11));
        Disposable r13 = this.N;
        if (r13 == null) goto L24;
        r13.dispose();
    L24:
        this.N = Observable.timer(r5, r4).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L7:
        r5 = 125;
        if (r2 != RecommendStatus.OnlyCount) goto L11;
        this.E = RecommendStatus.Gift;
        n(this.F, this.H, true);
        goto L15
    L11:
        if ((r0 - this.L) > 250) goto L14;
        k();
        l();
        goto L13
    L14:
        View r6 = this.H;
        n(r6, r6, true);
        goto L15
    }

    public final AnimatorSet h(View r9) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r9, "scaleX", new float[]{0.8f, 1.0f}).setDuration(1000);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r9, "scaleY", new float[]{0.8f, 1.0f}).setDuration(1000);
        r2.addListener(new e(r9));
        AnimatorSet r10 = new AnimatorSet();
        r10.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r10.playTogether(new Animator[]{r1, r2});
        return r10;
    }

    public final void j(boolean r9) {
        GiftComboProgressBar r0 = this.n;
        if (r0 == null) goto L10;
        r0.i = r9;
        float r10 = r0.g;
        AnimatorSet r5 = r0.h;
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L7:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{r10, 0.0f});
        r11.setDuration(250);
        r11.addUpdateListener(new o(r0));
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(r0.j);
        r6.addUpdateListener(new p(r6, r0));
        r6.addListener(new q(r0));
        AnimatorSet r7 = new AnimatorSet();
        r0.h = r7;
        r7.playSequentially(new Animator[]{r11, r6});
        AnimatorSet r13 = r0.h;
        if (r13 == null) goto L10;
        r13.start();
    L10:
        EXGaugeLevel r14 = this.z.c;
        if (r14 != EXGaugeLevel.HEATED) goto L13;
    L14:
        GiftComboProgressBar r15 = this.n;
        if (r15 == null) goto L27;
        Animator r1 = r15.t;
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r1);
    L19:
        Animator r2 = r15.r;
        if (r2 != null) goto L22;
    L24:
        r15.s = 0.0f;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{r15.w, 1.0f});
        r3.setDuration(2500);
        r3.addUpdateListener(new n(r15));
        Unit r4 = Unit.INSTANCE;
        r15.r = r3;
        r3.start();
        return;
    L22:
        if (r2.isRunning() != true) goto L24;
        return;
    L27:
        return;
    L13:
        if (r14 == EXGaugeLevel.OVERHEATED) goto L14;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r1) {
        this.w = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r2) {
        ComboProgressAnimationViewNew r0 = this.l;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.setGroupSend(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r2) {
        ComboProgressAnimationViewNew r0 = this.l;
        if (r0 == null) goto L6;
        r0.setSeriesSend(r2);
        return;
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
        int r2 = this.w;
        if (r2 != 0) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h r3 = this.z;
        GiftComboProgressBar r4 = this.n;
        if (r4 == null) goto L10;
        NextLiveData<Boolean> r5 = r4.x;
        if (r5 == null) goto L10;
        Boolean r6 = (Boolean) r5.getValue();
    L11:
        r3.a(r2, Intrinsics.areEqual(r6, Boolean.TRUE));
        this.D = r17;
        AnimatorSet r7 = this.k;
        if (r7 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r7);
    L14:
        int r8 = r.a[this.E.ordinal()];
        boolean r9 = true;
        if (r8 == 1) goto L22;
        if (r8 == 2) goto L21;
        if (r8 != 3) goto L20;
        View r10 = this.H;
    L26:
        View r11 = this.a;
        if (r11 == null) goto L29;
        r11.setVisibility(0);
    L29:
        this.k = new AnimatorSet();
        View r13 = this.a;
        if (r13 == null) goto L32;
        AnimatorSet r14 = com.bytedance.android.live.revenue.common.e.c(r13, new float[]{r13.getScaleX(), 0.8f}).setDuration(100);
    L33:
        if (r10 == null) goto L35;
        AnimatorSet r15 = com.bytedance.android.live.revenue.common.e.c(r10, new float[]{r10.getScaleX(), 0.8f}).setDuration(100);
    L36:
        AnimatorSet r16 = new AnimatorSet();
        r16.playTogether(new Animator[]{r14, r15});
        View r20 = this.a;
        if (r20 == null) goto L39;
        AnimatorSet r21 = com.bytedance.android.live.revenue.common.e.c(r20, new float[]{0.8f, 1.0f}).setDuration(400);
        r21.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L40:
        if (r10 == null) goto L42;
        AnimatorSet r23 = com.bytedance.android.live.revenue.common.e.c(r10, new float[]{0.8f, 1.0f}).setDuration(400);
        r23.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L43:
        AnimatorSet r24 = new AnimatorSet();
        r24.playTogether(new Animator[]{r21, r23, ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.y)});
        AnimatorSet r25 = this.k;
        if (r25 == null) goto L46;
        r25.playSequentially(new Animator[]{r16, r24});
    L46:
        AnimatorSet r26 = this.k;
        if (r26 == null) goto L49;
        r26.addListener(new v(this, r17));
    L49:
        AnimatorSet r1 = this.k;
        if (r1 == null) goto L53;
        r1.start();
    L53:
        if (this.w <= 0) goto L130;
        EXGaugeLevel r27 = this.z.c;
        EXGaugeLevel r28 = EXGaugeLevel.HEATED;
        if (r27 != r28) goto L66;
        Animator r29 = this.r;
        if (r29 == null) goto L59;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r29);
    L59:
        Animator r30 = this.q;
        if (r30 != null) goto L62;
    L64:
        Drawable r31 = s1.m(2131248738);
        Drawable r33 = s1.m(2131250693);
        ValueAnimator r34 = ValueAnimator.ofFloat(new float[]{this.x, 1.0f});
        r34.setDuration((long) ((1.0f - this.x) * I18nInitTask.DELAY_TS_MS));
        r34.addUpdateListener(new y(this, r33, r31));
        Unit r35 = Unit.INSTANCE;
        this.q = r34;
        r34.start();
        goto L66
    L62:
        if (r30.isRunning() != true) goto L64;
    L66:
        if (this.A == false) goto L96;
        AnimatedDrawable2 r36 = this.s;
        if (r36 == null) goto L72;
        if (r36.isRunning() != true) goto L72;
    L93:
        if (this.Q == false) goto L95;
        i();
        goto L96
    L95:
        post(new d(this));
    L72:
        if (this.z.c != EXGaugeLevel.OVERHEATED) goto L93;
        HSImageView r37 = this.o;
        if (r37 == null) goto L76;
        r37.setVisibility(0);
    L76:
        AnimatedDrawable2 r38 = this.s;
        if (r38 == null) goto L79;
        com.bytedance.android.live.core.utils.fresco.c.b(r38);
    L79:
        AnimatedDrawable2 r39 = this.s;
        if (r39 == null) goto L82;
        r39.start();
    L82:
        Animator r40 = this.v;
        if (r40 == null) goto L85;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r40);
    L85:
        HSImageView r41 = this.o;
        if (r41 == null) goto L88;
        ObjectAnimator r43 = ObjectAnimator.ofFloat(r41, "alpha", new float[]{0.0f, 1.0f}).setDuration(250);
    L89:
        this.v = r43;
        if (r43 == null) goto L93;
        r43.start();
        goto L93
    L88:
        r43 = null;
    L96:
        ComboWaveView r44 = this.m;
        if (r44 == null) goto L115;
        EXGaugeLevel r45 = this.z.c;
        if (r45 != r28) goto L101;
    L104:
        c0 r46 = c0.d;
        r46.getClass();
        if (((f0) c0.b.getValue(r46, c0.a[0])).a() == true) goto L107;
    L111:
        if (r9 == false) goto L113;
        Drawable r47 = r44.a;
    L114:
        View r48 = new View(r44.getContext());
        r48.setBackground(r47);
        FrameLayout.LayoutParams r49 = new FrameLayout.LayoutParams(s1.f(128.0f), s1.f(128.0f));
        r49.gravity = 17;
        Unit r50 = Unit.INSTANCE;
        r48.setLayoutParams(r49);
        r48.setAlpha(1.0f);
        r48.setScaleX(0.88f);
        r48.setScaleY(0.88f);
        r44.addView(r48);
        r48.animate().alpha(0.0f).scaleX(1.3f).scaleY(1.3f).setDuration(1030).setListener(new k(r44, r48)).start();
        goto L115
    L113:
        r47 = r44.b;
        goto L114
    L107:
        if (r44.a != null) goto L109;
    L110:
        r44.a();
        goto L111
    L109:
        if (r44.b != null) goto L111;
    L101:
        if (r45 == EXGaugeLevel.OVERHEATED) goto L104;
        r9 = false;
    L115:
        j(false);
        ComboProgressAnimationViewNew r51 = this.l;
        if (r51 == null) goto L119;
        r51.setVisibility(0);
    L119:
        if (this.Q == false) goto L123;
        ComboProgressAnimationViewNew r53 = this.l;
        if (r53 == null) goto L126;
        r53.e(this.w, r19);
    L126:
        ComboProgressAnimationViewNew r54 = this.l;
        if (r54 == null) goto L131;
        r54.f();
        return;
    L131:
        return;
    L123:
        ComboProgressAnimationViewNew r55 = this.l;
        if (r55 == null) goto L126;
        r55.e(this.w, 0);
        goto L126
    L130:
        return;
    L42:
        r23 = null;
        goto L43
    L39:
        r21 = null;
        goto L40
    L35:
        r15 = null;
        goto L36
    L32:
        r14 = null;
        goto L33
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r10 = this.F;
        goto L26
    L22:
        View r56 = this.b;
        if (r56 == null) goto L25;
        r56.setVisibility(0);
    L25:
        r10 = this.b;
    L10:
        r6 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r1, l1 r2, com.bytedance.android.livesdk.gift.model.n r3) {
        ComboProgressAnimationViewNew r4 = this.l;
        if (r4 == null) goto L7;
        if (r4 == null) goto L8;
        r4.setGift(r1);
        return;
    L8:
        return;
    }

    public final void n(View r17, View r18, boolean r19) {
        if (r17 != null) goto L5;
        return;
    L5:
        if (r18 != null) goto L7;
        return;
    L7:
        k();
        AnimatorSet r3 = this.B;
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r3);
    L10:
        AnimatorSet r4 = this.B;
        if (r4 == null) goto L13;
        r4.cancel();
    L13:
        this.B = new AnimatorSet();
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(r17, "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r17, "scaleX", new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(r17, "scaleY", new float[]{1.0f, 0.2f})});
        r5.addListener(new h(this, r17, r18, r19));
        r5.setDuration(125);
        AnimatorSet r1 = new AnimatorSet();
        r1.playTogether(new Animator[]{ObjectAnimator.ofFloat(r18, "alpha", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r18, "scaleX", new float[]{0.2f, 1.1f}), ObjectAnimator.ofFloat(r18, "scaleY", new float[]{0.2f, 1.1f})});
        r1.setDuration(125);
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(new Animator[]{ObjectAnimator.ofFloat(r18, "scaleX", new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(r18, "scaleY", new float[]{1.1f, 1.0f})});
        r6.setDuration(300);
        AnimatorSet r2 = this.B;
        if (r2 == null) goto L16;
        r2.playSequentially(new Animator[]{r5, r1, r6});
    L16:
        AnimatorSet r7 = this.B;
        if (r7 == null) goto L19;
        r7.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L19:
        AnimatorSet r8 = this.B;
        if (r8 == null) goto L23;
        r8.start();
        return;
    }

    public GiftComboView(Context r9, AttributeSet r10, int r11, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        boolean r0 = true;
        if ((r13 & 8) == 0) goto L11;
        boolean r14 = true;
    L12:
        Intrinsics.checkNotNullParameter(r9, "mContext");
        super(r9, r10, r11);
        this.Q = r14;
        this.p = new ArrayList();
        this.y = 8000;
        this.z = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h();
        this.A = true;
        i12.e r15 = i12.o.b();
        if (r15 == null) goto L15;
        Object r16 = com.bytedance.android.scope.m.e.d(r15, com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d.class);
    L16:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d r17 = (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d) r16;
        if (r17 != null) goto L19;
    L21:
        r0 = false;
    L22:
        this.E = RecommendStatus.Idle;
        t r18 = new t(this);
        this.O = r18;
        s r3 = new s(this);
        this.P = r3;
        if (r14 == false) goto L25;
        FrameLayout.inflate(r9, 2131565233, this);
    L32:
        this.y = getCountDownTime();
        this.a = findViewById(2131367228);
        this.c = findViewById(2131367262);
        this.d = findViewById(2131379189);
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().c() == false) goto L48;
        View r19 = this.d;
        if (r19 == null) goto L37;
        r19.setBackgroundResource(2131250724);
    L37:
        View r20 = this.d;
        if (r20 == null) goto L40;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
    L41:
        if (r21 == null) goto L43;
        r21.width = (int) t6.a(getContext(), 37.0f);
    L43:
        if (r21 == null) goto L45;
        r21.height = (int) t6.a(getContext(), 40.0f);
    L45:
        View r4 = this.d;
        if (r4 == null) goto L48;
        r4.setLayoutParams(r21);
        goto L48
    L40:
        r21 = null;
    L48:
        this.b = this.c;
        ComboProgressAnimationViewNew r23 = (ComboProgressAnimationViewNew) findViewById(2131367251);
        this.l = r23;
        if (r23 == null) goto L51;
        r23.setVisibility(4);
    L51:
        this.m = (ComboWaveView) findViewById(2131384854);
        GiftComboProgressBar r24 = (GiftComboProgressBar) findViewById(2131367252);
        r24.setCountDownTime(getCountDownTime());
        Unit r5 = Unit.INSTANCE;
        this.n = r24;
        this.o = findViewById(2131367249);
        this.j = findViewById(2131373886);
        this.i = findViewById(2131379160);
        this.e = findViewById(2131368006);
        this.f = findViewById(2131368007);
        this.g = findViewById(2131368008);
        this.h = findViewById(2131368009);
        ComboWaveView r25 = this.m;
        if (r25 == null) goto L57;
        c0 r6 = c0.d;
        r6.getClass();
        if (((f0) c0.b.getValue(r6, c0.a[0])).a() == true) goto L57;
        r25.a();
    L57:
        KProperty[] r26 = b02.a.a;
        if (r14 == false) goto L60;
        String r27 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_big_combo_arrow_effect.webp";
    L61:
        HSImageView r110 = this.o;
        if (r110 == null) goto L64;
        r110.setController(Fresco.newDraweeControllerBuilder().setUri(r27).setControllerListener(new u(this)).build());
    L64:
        GiftComboProgressBar r28 = this.n;
        if (r28 == null) goto L69;
        NextLiveData<Boolean> r29 = r28.x;
        if (r29 == null) goto L69;
        r29.observeForever(r18);
    L69:
        GiftComboProgressBar r30 = this.n;
        if (r30 == null) goto L74;
        NextLiveData<Pair<Boolean, Boolean>> r31 = r30.getShowCountDown();
        if (r31 == null) goto L74;
        r31.observeForever(r3);
    L74:
        this.F = findViewById(2131383933);
        this.G = (TextView) findViewById(2131383932);
        this.H = findViewById(2131383942);
        this.I = (ImageView) findViewById(2131383941);
        this.J = (TextView) findViewById(2131383943);
        this.K = (TextView) findViewById(2131383939);
        if (r0 == false) goto L78;
        if (r17 == null) goto L78;
        Typeface r33 = r17.a(getContext());     // Catch: Exception -> L86
    L79:
        TextView r111 = this.G;     // Catch: Exception -> L86
        if (r111 == null) goto L82;
        r111.setTypeface(r33);     // Catch: Exception -> L86
    L82:
        TextView r112 = this.K;     // Catch: Exception -> L86
        if (r112 == null) goto L91;
        r112.setTypeface(r33);     // Catch: Exception -> L86
        return;
    L91:
        return;
    L78:
        r33 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_base_gift_combo_opt_font.ttf");     // Catch: Exception -> L86
    L86:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("NormalGiftCombViewV2", "load font asset exception: " + e.getMessage(), null, 4);
        return;
    L60:
        r27 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_combo_arrow_effect.webp";
        goto L61
    L25:
        c0.d.getClass();
        if (c0.a() == false) goto L28;
        GiftPanelViewPreloadService.l.getClass();
        View r7 = GiftPanelViewPreloadService.a.a(2131565234);
    L29:
        if (r7 == null) goto L31;
        addView(r7);
        goto L32
    L31:
        FrameLayout.inflate(r9, 2131565234, this);
        goto L32
    L28:
        r7 = null;
        goto L29
    L19:
        if (r17.a.b() != true) goto L21;
    L15:
        r16 = null;
        goto L16
    L11:
        r14 = false;
        goto L12
    }
}
