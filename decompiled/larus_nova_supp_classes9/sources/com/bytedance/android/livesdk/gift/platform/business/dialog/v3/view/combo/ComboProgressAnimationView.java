package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.ComboHintScene;
import com.bytedance.android.livesdk.gift.model.ComboHintType;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l;
import com.bytedance.android.livesdk.gift.model.m;
import com.bytedance.android.livesdk.gift.model.u;
import com.bytedance.android.livesdk.gift.model.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import i12.o;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboProgressAnimationView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gift/model/h2;", "value", "n", "Lcom/bytedance/android/livesdk/gift/model/h2;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h2;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h2;)V", "gift", BuildConfig.FLAVOR, "o", "Z", "isGroupSend", "()Z", "setGroupSend", "(Z)V", "p", "isSeriesSend", "setSeriesSend", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboProgressAnimationView extends FrameLayout {
    public static final /* synthetic */ int x = 0;
    public Map<Integer, View> a;
    public int b;
    public AnimatorSet c;
    public AnimatorSet d;
    public AnimatorSet e;
    public boolean f;
    public boolean g;
    public boolean h;
    public float i;
    public boolean j;
    public final int k;
    public boolean l;
    public final ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> m;
    public h2 n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final Map<Integer, Boolean> s;
    public Disposable t;
    public v u;
    public u v;
    public final HSImageView w;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ ComboProgressAnimationView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ v e;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final void e(k r1) {
        }

        public final void b(k r1, Exception r2) {
            ConstraintLayout r3 = this.a.a(2131367239);
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }

        public final void c(k r2, int r3, int r4, boolean r5) {
            HSImageView r6 = this.a.w;
            Long r7 = null;
            if (r6 == null) goto L5;
            ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        L7:
            if ((r8 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r9 = r3 / r4;
            HSImageView r10 = this.a.w;
            if (r10 == null) goto L11;
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        L12:
            if (r11 == null) goto L14;
            r11.height = (int) this.a.getContext().getResources().getDimension(2131168766);
        L14:
            if (r11 == null) goto L16;
            r11.width = (int) (r11.height * r9);
        L16:
            HSImageView r13 = this.a.w;
            if (r13 == null) goto L20;
            r13.setLayoutParams(r11);
            goto L20
        L11:
            r11 = null;
        L20:
            if ((new Random().nextInt(10) % 2) != 0) goto L22;
            float r14 = -5.0f;
        L23:
            HSImageView r15 = this.a.w;
            if (r15 == null) goto L26;
            r15.setRotation(r14);
        L26:
            ComboProgressAnimationView.c(this.a, true, true);
            h2 r16 = this.a.getGift();
            if (r16 == null) goto L29;
            r7 = Long.valueOf(r16.getId());
        L29:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r7, this.b, this.c, Integer.valueOf(this.d), this.e.getName());
            return;
        L22:
            r14 = 5.0f;
            goto L23
        L5:
            r8 = null;
            goto L7
        }

        public b(ComboProgressAnimationView r1, int r2, String r3, int r4, v r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c implements p0 {
        public final /* synthetic */ l a;
        public final /* synthetic */ m b;
        public final /* synthetic */ ComboProgressAnimationView c;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(k r1) {
        }

        public final void b(k r1, Exception r2) {
            ConstraintLayout r3 = this.c.a(2131367239);
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }

        public c(l r1, m r2, ComboProgressAnimationView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void c(k r3, int r4, int r5, boolean r6) {
            HSImageView r7 = this.c.w;
            Integer r8 = null;
            if (r7 == null) goto L5;
            ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        L7:
            if ((r9 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r10 = r4 / r5;
            HSImageView r11 = this.c.w;
            if (r11 == null) goto L11;
            ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        L12:
            if (r13 == null) goto L14;
            r13.height = (int) this.c.getContext().getResources().getDimension(2131168698);
        L14:
            if (r13 == null) goto L16;
            r13.width = (int) (r13.height * r10);
        L16:
            HSImageView r14 = this.c.w;
            if (r14 == null) goto L20;
            r14.setLayoutParams(r13);
            goto L20
        L11:
            r13 = null;
        L20:
            if ((new Random().nextInt(10) % 2) != 0) goto L22;
            float r15 = -5.0f;
        L23:
            HSImageView r16 = this.c.w;
            if (r16 == null) goto L26;
            r16.setRotation(r15);
        L26:
            ComboProgressAnimationView.c(this.c, true, false);
            h2 r17 = this.c.getGift();
            if (r17 == null) goto L29;
            Long r18 = Long.valueOf(r17.getId());
        L30:
            m r19 = this.b;
            int r0 = r19.leftGiftCount;
            if (this.a.dataList.indexOf(r19) != (this.a.dataList.size() - 1)) goto L33;
            String r20 = "2";
        L34:
            h2 r21 = this.c.getGift();
            if (r21 == null) goto L39;
            l r23 = l0.a(r21);
            if (r23 == null) goto L39;
            r8 = Integer.valueOf(r23.bizType);
        L39:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r18, r0, r20, r8, BuildConfig.FLAVOR);
            return;
        L33:
            r20 = "1";
            goto L34
        L29:
            r18 = null;
            goto L30
        L22:
            r15 = 5.0f;
            goto L23
        L5:
            r9 = null;
            goto L7
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ ComboProgressAnimationView a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(k r1) {
        }

        public d(ComboProgressAnimationView r1) {
            this.a = r1;
        }

        public final void b(k r1, Exception r2) {
            ConstraintLayout r3 = this.a.a(2131367239);
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }

        public final void c(k r2, int r3, int r4, boolean r5) {
            if (GiftManagerKt.s().size() > 0) goto L5;
        L7:
            HSImageView r6 = this.a.w;
            ViewGroup.LayoutParams r0 = null;
            if (r6 == null) goto L10;
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        L12:
            if ((r7 instanceof ViewGroup.LayoutParams) == false) goto L24;
            float r8 = r3 / r4;
            HSImageView r9 = this.a.w;
            if (r9 == null) goto L16;
            r0 = r9.getLayoutParams();
        L16:
            if (r0 == null) goto L18;
            r0.height = (int) this.a.getContext().getResources().getDimension(2131168767);
        L18:
            if (r0 == null) goto L20;
            r0.width = (int) (r0.height * r8);
        L20:
            HSImageView r10 = this.a.w;
            if (r10 == null) goto L24;
            r10.setLayoutParams(r0);
        L24:
            if ((new Random().nextInt(10) % 2) != 0) goto L26;
            float r11 = -5.0f;
        L27:
            HSImageView r13 = this.a.w;
            if (r13 == null) goto L30;
            r13.setRotation(r11);
        L30:
            ComboProgressAnimationView.c(this.a, false, false);
            return;
        L26:
            r11 = 5.0f;
            goto L27
        L10:
            r7 = null;
            goto L12
        L5:
            if (this.a.b >= ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), 0)).comboCount) goto L7;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ComboProgressAnimationView a;

        public e(ComboProgressAnimationView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Disposable r4 = this.a.t;
            if (r4 == null) goto L5;
            r4.dispose();
        L5:
            ComboProgressAnimationView r5 = this.a;
            r5.t = null;
            r5.u = null;
            r5.v = null;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class g implements Animator.AnimatorListener {
        public final /* synthetic */ ComboProgressAnimationView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public g(ComboProgressAnimationView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.a(2131367239);
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.a(2131367239);
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }
    }

    public static final class h implements Animator.AnimatorListener {
        public final /* synthetic */ ComboProgressAnimationView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public h(ComboProgressAnimationView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.a(2131367255);
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ConstraintLayout r3 = this.a.a(2131367255);
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }
    }

    public static final class i extends o12.b {
        public final /* synthetic */ ComboProgressAnimationView a;

        public i(ComboProgressAnimationView r1) {
            this.a = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ComboProgressAnimationView r3 = this.a;
            if (r3.j == false) goto L6;
            ComboProgressAnimationView.b(r3, false);
            return;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ComboProgressAnimationView r3 = this.a;
            if (r3.j == false) goto L6;
            ComboProgressAnimationView.b(r3, false);
            return;
        }
    }

    static {
    }

    public ComboProgressAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComboProgressAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void d() {
        AnimatorSet r0 = this.d;
        if (r0 != null) goto L5;
    L12:
        this.d = null;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        AnimatorSet r1 = this.d;
        if (r1 == null) goto L9;
        r1.removeAllListeners();
    L9:
        AnimatorSet r2 = this.d;
        if (r2 == null) goto L12;
        r2.cancel();
        goto L12
    }

    public final void e() {
        AnimatorSet r0 = this.c;
        if (r0 != null) goto L5;
    L12:
        this.c = null;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        AnimatorSet r1 = this.c;
        if (r1 == null) goto L9;
        r1.removeAllListeners();
    L9:
        AnimatorSet r2 = this.c;
        if (r2 == null) goto L12;
        r2.cancel();
        goto L12
    }

    public final void f() {
        AnimatorSet r0 = this.e;
        if (r0 != null) goto L5;
    L12:
        this.e = null;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        AnimatorSet r1 = this.e;
        if (r1 == null) goto L9;
        r1.removeAllListeners();
    L9:
        AnimatorSet r2 = this.e;
        if (r2 == null) goto L12;
        r2.cancel();
        goto L12
    }

    public final void k() {
        Disposable r0 = this.t;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.t = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.a);
    }

    public final void l() {
        h2 r0 = this.n;
        int r1 = 0;
        if (r0 == null) goto L9;
        l r2 = l0.a(r0);
        if (r2 == null) goto L9;
        List<m> r3 = r2.dataList;
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        Integer r5 = null;
        if (r4 <= 0) goto L17;
        h2 r6 = this.n;
        if (r6 == null) goto L15;
        l r7 = l0.a(r6);
    L16:
        p(r7);
        goto L17
    L15:
        r7 = null;
    L17:
        d();
        this.m.size();
        float r8 = 1.0f;
        if (this.j == true) goto L45;
        int r9 = this.m.size();
        int r10 = 0;
    L21:
        if (r10 >= r9) goto L45;
        com.bytedance.android.livesdk.gift.platform.core.model.e r11 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(this.m, r10);
        int r13 = this.b;
        if (r11 == null) goto L25;
        int r14 = r11.comboCount;
    L26:
        if (r13 < r14) goto L27;
        r10 = r10 + 1;
        goto L21
    L27:
        if (r10 != 0) goto L32;
        float r15 = r13;
        if (r11 == null) goto L31;
        r8 = r11.comboCount;
    L31:
        r8 = r15 / r8;
        goto L45
    L32:
        com.bytedance.android.livesdk.gift.platform.core.model.e r16 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(this.m, r10 - 1);
        int r17 = this.b;
        if (r16 == null) goto L35;
        int r18 = r16.comboCount;
    L36:
        float r19 = r17 - r18;
        if (r11 == null) goto L39;
        int r20 = r11.comboCount;
    L40:
        if (r16 == null) goto L42;
        int r21 = r16.comboCount;
    L43:
        r8 = r19 / (r20 - r21);
        goto L45
    L42:
        r21 = 0;
        goto L43
    L39:
        r20 = 0;
        goto L40
    L35:
        r18 = 0;
        goto L36
    L25:
        r14 = 0;
    L45:
        int r23 = GiftManagerKt.s().size();
        if (r23 <= 0) goto L56;
        View r24 = a(2131367237);
        if (r24 == null) goto L56;
        int r25 = this.b;
        com.bytedance.android.livesdk.gift.platform.core.model.e r26 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r23 - 1);
        if (r26 == null) goto L53;
        r5 = Integer.valueOf(r26.comboCount);
    L53:
        if (r25 < r5.intValue()) goto L55;
        r1 = 4;
    L55:
        r24.setVisibility(r1);
    L56:
        float r27 = s1.e(38.0f) * r8;
        ConstraintLayout r28 = a(2131367239);
        if (r28 == null) goto L62;
        r28.setTranslationY(-r27);
        return;
    L62:
        return;
    L9:
        r4 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h2 r0 = this.n;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getId());
    L6:
        q(r1);
        super.onDetachedFromWindow();
        Disposable r2 = this.t;
        if (r2 == null) goto L10;
        r2.dispose();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void j() {
        e();
        ConstraintLayout r0 = a(2131367255);
        if (r0 == null) goto L6;
        r0.setScaleY(1.0f);
    L6:
        if (this.b > this.k) goto L8;
    L19:
        n();
        if (this.h == false) goto L22;
        long r1 = 100;
    L23:
        m(r1);
        Object r2 = getContext().getSystemService("vibrator");
        if (r2 == null) goto L28;
        ((Vibrator) r2).vibrate(50);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L22:
        r1 = 1800;
        goto L23
    L8:
        if (this.l == true) goto L19;
        HSImageView r3 = this.w;
        if (r3 == null) goto L12;
        r3.setTranslationY(this.i);
    L12:
        HSImageView r4 = this.w;
        if (r4 == null) goto L15;
        r4.setScaleX(1.0f);
    L15:
        HSImageView r5 = this.w;
        if (r5 == null) goto L18;
        r5.setScaleY(1.0f);
    L18:
        o();
        goto L19
    }

    public final void n() {
        e();
        this.c = new AnimatorSet();
        ConstraintLayout r1 = a(2131367255);
        if (r1 == null) goto L9;
        ConstraintLayout r2 = a(2131367255);
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getHeight());
    L8:
        r1.setPivotY(r3.intValue());
        goto L9
    L7:
        r3 = null;
    L9:
        ObjectAnimator r4 = ObjectAnimator.ofFloat(a(2131367255), "scaleY", new float[]{1.0f, 0.2f});
        AnimatorSet r5 = this.c;
        if (r5 == null) goto L12;
        r5.playTogether(new Animator[]{r4});
    L12:
        AnimatorSet r6 = this.c;
        if (r6 == null) goto L15;
        r6.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L15:
        AnimatorSet r7 = this.c;
        if (r7 == null) goto L18;
        r7.setDuration(1800);
    L18:
        ConstraintLayout r0 = a(2131367255);
        if (r0 == null) goto L21;
        r0.setVisibility(0);
    L21:
        AnimatorSet r8 = this.c;
        if (r8 == null) goto L24;
        r8.addListener(new h(this));
    L24:
        AnimatorSet r9 = this.c;
        if (r9 == null) goto L28;
        r9.start();
        return;
    }

    public final void o() {
        f();
        this.l = false;
        this.e = new AnimatorSet();
        if (this.j == false) goto L13;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.w, "translationY", new float[]{this.i, s1.e(90.0f)});
        PropertyValuesHolder r3 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f});
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f});
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(this.w, new PropertyValuesHolder[]{r3, r2});
        AnimatorSet r5 = this.e;
        if (r5 == null) goto L7;
        r5.playTogether(new Animator[]{r1, r4});
    L7:
        AnimatorSet r6 = this.e;
        if (r6 == null) goto L10;
        r6.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L10:
        AnimatorSet r7 = this.e;
        if (r7 == null) goto L16;
        r7.setDuration(1800);
    L16:
        AnimatorSet r8 = this.e;
        if (r8 == null) goto L19;
        r8.addListener(new i(this));
    L19:
        AnimatorSet r9 = this.e;
        if (r9 == null) goto L22;
        r9.start();
    L22:
        this.f = false;
        return;
    L13:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.w, "translationY", new float[]{0.0f, s1.e(50.0f)});
        PropertyValuesHolder r11 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f});
        PropertyValuesHolder r13 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f});
        ObjectAnimator r14 = ObjectAnimator.ofPropertyValuesHolder(this.w, new PropertyValuesHolder[]{r11, r13});
        r10.setDuration(300);
        r10.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        AnimatorSet r15 = this.e;
        if (r15 == null) goto L16;
        r15.playSequentially(new Animator[]{r10, r14});
        goto L16
    }

    public final h2 getGift() {
        return this.n;
    }

    public final View a(int r3) {
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

    public final void m(long r6) {
        d();
        this.d = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(a(2131367239), "translationY", new float[]{s1.e(32.0f)});
        AnimatorSet r2 = this.d;
        if (r2 == null) goto L5;
        r2.playTogether(new Animator[]{r0});
    L5:
        AnimatorSet r1 = this.d;
        if (r1 == null) goto L8;
        r1.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L8:
        AnimatorSet r3 = this.d;
        if (r3 == null) goto L11;
        r3.setDuration(r6);
    L11:
        AnimatorSet r7 = this.d;
        if (r7 == null) goto L14;
        r7.start();
    L14:
        AnimatorSet r8 = this.d;
        if (r8 == null) goto L18;
        r8.addListener(new g(this));
        return;
    }

    public final void p(l r8) {
        this.m.clear();
        if (r8 == null) goto L7;
        List<m> r1 = r8.dataList;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 <= 0) goto L90;
        int r3 = 0;
        int r4 = 0;
    L10:
        k r5 = null;
        if (r3 >= GiftManagerKt.s().size()) goto L46;
        if (r8 == null) goto L16;
        List<m> r6 = r8.dataList;
        if (r6 == null) goto L16;
        int r7 = r6.size();
    L17:
        if (r4 >= r7) goto L46;
        com.bytedance.android.livesdk.gift.platform.core.model.e r9 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r3);
        if (r8 == null) goto L21;
        int r10 = r8.curLeftGiftCount;
    L22:
        if (r8 == null) goto L28;
        List<m> r11 = r8.dataList;
        if (r11 == null) goto L28;
        m r13 = (m) ListProtector.get(r11, r4);
        if (r13 == null) goto L28;
        int r14 = r13.leftGiftCount;
    L29:
        int r15 = (r10 - r14) + 1;
        int r16 = r9.comboCount;
        if (r16 < r15) goto L31;
        com.bytedance.android.livesdk.gift.platform.core.model.e r17 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r17.comboCount = r15;
        if (r8 == null) goto L41;
        List<m> r18 = r8.dataList;
        if (r18 == null) goto L41;
        m r19 = (m) ListProtector.get(r18, r4);
        if (r19 == null) goto L41;
        r5 = r19.hintImg;
    L41:
        r17.comboEffectImg = r5;
        if (r17.comboCount <= 0) goto L44;
        this.m.add(r17);
    L44:
        r4 = r4 + 1;
        goto L10
    L31:
        if (r16 <= 0) goto L33;
        this.m.add(r9);
    L33:
        r3 = r3 + 1;
    L28:
        r14 = 0;
        goto L29
    L21:
        r10 = 0;
    L16:
        r7 = 0;
    L46:
        if (r3 >= GiftManagerKt.s().size()) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.e r20 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r3);
        if (r20.comboCount <= 0) goto L50;
        this.m.add(r20);
    L50:
        r3 = r3 + 1;
    L51:
        h2 r21 = this.n;
        if (r21 == null) goto L58;
        l r23 = l0.a(r21);
        if (r23 == null) goto L58;
        List<m> r24 = r23.dataList;
        if (r24 == null) goto L58;
        int r25 = r24.size();
    L59:
        if (r4 >= r25) goto L106;
        h2 r26 = this.n;
        if (r26 == null) goto L65;
        l r27 = l0.a(r26);
        if (r27 == null) goto L65;
        int r28 = r27.curLeftGiftCount;
    L66:
        h2 r29 = this.n;
        if (r29 == null) goto L75;
        l r30 = l0.a(r29);
        if (r30 == null) goto L75;
        List<m> r31 = r30.dataList;
        if (r31 == null) goto L75;
        m r33 = (m) ListProtector.get(r31, r4);
        if (r33 == null) goto L75;
        int r34 = r33.leftGiftCount;
    L76:
        int r35 = (r28 - r34) + 1;
        com.bytedance.android.livesdk.gift.platform.core.model.e r36 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r36.comboCount = r35;
        h2 r37 = this.n;
        if (r37 == null) goto L85;
        l r38 = l0.a(r37);
        if (r38 == null) goto L85;
        List<m> r39 = r38.dataList;
        if (r39 == null) goto L85;
        m r40 = (m) ListProtector.get(r39, r4);
        if (r40 == null) goto L85;
        k r41 = r40.hintImg;
    L86:
        r36.comboEffectImg = r41;
        if (r36.comboCount <= 0) goto L89;
        this.m.add(r36);
    L89:
        r4 = r4 + 1;
    L85:
        r41 = null;
    L75:
        r34 = 0;
    L65:
        r28 = 0;
        goto L66
    L106:
        return;
    L58:
        r25 = 0;
        goto L59
    L90:
        this.m.addAll(GiftManagerKt.s());
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public final void q(Long r4) {
        if (r4 == null) goto L5;
        long r0 = r4.longValue();
        String r5 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId() + String.valueOf(r0);
        HashMap<String, Boolean> r1 = ay1.b.i();
        r1.put(r5, Boolean.valueOf(this.q));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ay1.b.i0.setValue(null, ay1.b.a[72], r1);
        return;
    }

    public final void setGift(h2 r5) {
        Long r0 = null;
        if (r5 == null) goto L5;
        l r1 = l0.a(r5);
    L6:
        p(r1);
        if (r5 == null) goto L9;
        r0 = Long.valueOf(r5.getId());
    L9:
        if (r0 == null) goto L15;
        long r2 = r0.longValue();
        Boolean r3 = ay1.b.i().get(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId() + String.valueOf(r2));
        if (r3 == null) goto L13;
        boolean r4 = r3.booleanValue();
    L14:
        this.q = r4;
        goto L15
    L13:
        r4 = false;
    L15:
        this.n = r5;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setGroupSend(boolean r1) {
        this.o = r1;
    }

    public final void setSeriesSend(boolean r1) {
        this.p = r1;
    }

    public static final void b(ComboProgressAnimationView r3, boolean r4) {
        r3.getClass();
        int r0 = GiftManagerKt.s().size();
        if (r0 <= 0) goto L7;
        ImageLoader.bindImage(r3.w, ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r0 - 1)).comboEffectImg, new b02.g(r3, r4));
        return;
    }

    public static int g(int r8, List r9) {
        if (r9 == null) goto L10;
        Iterator r10 = r9.iterator();
        int r1 = 99999;
    L6:
        if (r10.hasNext() == false) goto L11;
        v r2 = (v) r10.next();
        if (r2.getCount() <= r8) goto L6;
        r1 = Math.min(r1, ((int) r2.getCount()) - r8);
    L11:
        if (r1 != 99999) goto L19;
        return 0;
    L19:
        return r1;
    L10:
        r1 = 99999;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    public final void i(int r21, int r23) {
        int r2 = this.b;
        if (r2 != r21) goto L6;
        return;
    L6:
        if (r2 <= r21) goto L13;
        this.j = false;
        HSImageView r3 = this.w;
        if (r3 == null) goto L10;
        r3.setScaleX(0.0f);
    L10:
        HSImageView r4 = this.w;
        if (r4 == null) goto L13;
        r4.setScaleY(0.0f);
    L13:
        this.b = r21;
        if (r21 != 0) goto L16;
        return;
    L16:
        TextView r5 = (TextView) a(2131367241);
        if (r5 == null) goto L19;
        r5.setText(String.valueOf(r21));
    L19:
        TextView r6 = (TextView) a(2131367243);
        if (r6 == null) goto L22;
        r6.setText(String.valueOf(r21));
    L22:
        TextView r7 = (TextView) a(2131367245);
        if (r7 == null) goto L25;
        r7.setText(String.valueOf(r21));
    L25:
        ?? r8 = 1;
        if (r21 != 1) goto L45;
        e();
        this.c = new AnimatorSet();
        ConstraintLayout r9 = a(2131367255);
        if (r9 == null) goto L30;
        r9.setPivotY(s1.e(110.0f));
    L30:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(a(2131367255), "scaleY", new float[]{0.2f, 1.0f});
        AnimatorSet r11 = this.c;
        if (r11 == null) goto L33;
        r11.playTogether(new Animator[]{r10});
    L33:
        AnimatorSet r13 = this.c;
        if (r13 == null) goto L36;
        r13.setDuration(200);
    L36:
        AnimatorSet r14 = this.c;
        if (r14 == null) goto L39;
        r14.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
    L39:
        AnimatorSet r15 = this.c;
        if (r15 == null) goto L42;
        r15.addListener(new b02.h(this));
    L42:
        AnimatorSet r16 = this.c;
        if (r16 == null) goto L45;
        r16.start();
    L45:
        Disposable r17 = this.t;
        if (r17 != null) goto L48;
    L70:
        h2 r18 = this.n;
        if (r18 == null) goto L83;
        long r19 = r18.getId();
        i12.e r20 = o.b();
        if (r20 == null) goto L75;
        Object r24 = com.bytedance.android.scope.m.e.d(r20, GiftExtraRepo.class);
    L76:
        GiftExtraRepo r25 = (GiftExtraRepo) r24;
        if (r25 == null) goto L83;
        g0 r26 = r25.q(r19);
        if (r26 == null) goto L83;
        ComboHintInfo r27 = r26.getComboHintInfo();
        if (r27 == null) goto L83;
        List<u> r28 = r27.getComboHintList();
    L84:
        h2 r29 = this.n;
        if (r29 == null) goto L87;
        long r30 = r29.getPrimaryEffectId();
    L89:
        if (this.p == true) goto L246;
        if (r28 == null) goto L246;
        Iterator<T> r31 = r28.iterator();
    L93:
        if (r31.hasNext() == false) goto L246;
        u r110 = (u) r31.next();
        int r111 = r110.getComboHintScene();
        int r112 = ComboHintScene.SEND_TOGETHER.getScene();
        String r113 = BuildConfig.FLAVOR;
        if (r111 != r112) goto L175;
        ArrayList r114 = new ArrayList();
        GiftContext r115 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r115 == null) goto L103;
        com.bytedance.live.datacontext.m<Boolean> r116 = r115.isIntercept();
        if (r116 == null) goto L103;
        Boolean r117 = (Boolean) r116.getValue();
        if (r117 == null) goto L103;
        boolean r118 = r117.booleanValue();
    L104:
        GiftContext r119 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r119 == null) goto L113;
        n<i02.a> r120 = r119.getCurrentSendTogetherInfo();
        if (r120 == null) goto L113;
        i02.a r121 = (i02.a) r120.getValue();
        if (r121 == null) goto L113;
        Integer r122 = r121.c;
        if (r122 == null) goto L113;
        int r123 = r122.intValue();
    L114:
        GiftContext r124 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r124 == null) goto L121;
        n<i02.a> r125 = r124.getCurrentSendTogetherInfo();
        if (r125 == null) goto L121;
        i02.a r126 = (i02.a) r125.getValue();
        if (r126 == null) goto L121;
        List<i02.e> r127 = r126.b;
    L122:
        if (r127 == null) goto L127;
        Iterator<T> r128 = r127.iterator();
    L125:
        if (r128.hasNext() == false) goto L127;
        r114.addAll(((i02.e) r128.next()).a);
    L127:
        boolean r33 = r114.contains(Integer.valueOf((int) r30));
        if (r118 == true) goto L140;
        if (r33 == false) goto L140;
        GiftContext r34 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r34 == null) goto L138;
        com.bytedance.live.datacontext.m<Integer> r35 = r34.getMsgCount();
        if (r35 == null) goto L138;
        Integer r36 = (Integer) r35.getValue();
        if (r36 == null) goto L138;
        int r37 = r36.intValue();
    L139:
        int r129 = r123 + r37;
    L141:
        List<v> r38 = r110.getComboHintData();
        if (r38 == null) goto L175;
        int r130 = r38.size() - r8;
        if (r130 < 0) goto L175;
        int r131 = 0;
    L146:
        v r132 = (v) ListProtector.get(r38, r131);
        if (r132.getComboHintType() != ComboHintType.COMMON.getType()) goto L158;
        List<v> r133 = r38;
        if (((r129 + r21) - r23) != (((int) r132.getCount()) - r8)) goto L172;
        Boolean r39 = (Boolean) ((LinkedHashMap) this.s).get(Integer.valueOf((int) r132.getCount()));
        if (r39 == null) goto L153;
        boolean r40 = r39.booleanValue();
    L154:
        if (r40 == true) goto L172;
        this.q = r8;
        this.s.put(Integer.valueOf((int) r132.getCount()), Boolean.TRUE);
        h(r132, 0, 3, BuildConfig.FLAVOR);
        this.u = r132;
        this.v = r110;
        k();
        return;
    L153:
        r40 = false;
    L172:
        if (r131 == r130) goto L175;
        r131 = r131 + 1;
        r38 = r133;
        goto L146
    L158:
        r133 = r38;
        if (r132.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L172;
        if (this.q == true) goto L172;
        this.q = r8;
        h2 r41 = this.n;
        if (r41 == null) goto L166;
        Long r43 = Long.valueOf(r41.getId());
    L167:
        q(r43);
        if (this.o == true) goto L172;
        this.u = r132;
        this.v = r110;
        h(r132, 0, 3, BuildConfig.FLAVOR);
        k();
        return;
    L166:
        r43 = null;
    L138:
        r37 = 0;
    L140:
        r129 = 0;
    L121:
        r127 = null;
    L113:
        r123 = 0;
    L103:
        r118 = false;
    L175:
        if (r110.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L244;
        List<v> r44 = r110.getComboHintData();
        if (r44 == null) goto L244;
        int r45 = r44.size() - r8;
        if (r45 < 0) goto L244;
        int r46 = 0;
    L181:
        v r134 = (v) ListProtector.get(r44, r46);
        if (r134.getComboHintType() != ComboHintType.COMMON.getType()) goto L192;
        if (r21 == ((int) r134.getCount())) goto L185;
    L239:
        List<v> r135 = r44;
    L241:
        if (r46 == r45) goto L244;
        r46 = r46 + 1;
        r44 = r135;
        goto L181
    L185:
        int r1 = g(r21, r110.getComboHintData());
        String r47 = r134.getName();
        if (r47 == null) goto L189;
        r113 = r47;
    L189:
        h(r134, r1, 4, r113);
        this.u = r134;
        this.v = r110;
        k();
        return;
    L192:
        if (r134.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L239;
        h2 r136 = this.n;
        if (r136 == null) goto L196;
        Long r137 = Long.valueOf(r136.getId());
    L198:
        if (r137 == null) goto L214;
        r137.longValue();
        int r138 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r48 = ay1.b.r();
        if (r48 != null) goto L202;
    L201:
        r135 = r44;
    L213:
        boolean r49 = true;
    L216:
        if (r49 == false) goto L241;
        if (this.r == true) goto L241;
        this.r = true;
        String r50 = r134.getName();
        if (r50 == null) goto L224;
        r113 = r50;
    L224:
        h(r134, 0, 4, r113);
        this.u = r134;
        this.v = r110;
        k();
        h2 r51 = this.n;
        if (r51 == null) goto L227;
        Long r53 = Long.valueOf(r51.getId());
    L228:
        if (r53 == null) goto L300;
        r53.longValue();
        int r54 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r55 = ay1.b.r();
        Pair<Integer, Integer> r56 = r55.get(r53);
        if (r56 != null) goto L233;
        r56 = new Pair(Integer.valueOf(r54), 0);
    L233:
        if (((Number) r56.getFirst()).intValue() == r54) goto L235;
        Pair<Integer, Integer> r57 = new Pair(Integer.valueOf(r54), 1);
    L236:
        r55.put(r53, r57);
        Intrinsics.checkNotNullParameter(r55, "<set-?>");
        ay1.b.o0.setValue(null, ay1.b.a[79], r55);
        return;
    L235:
        r57 = new Pair(Integer.valueOf(r54), Integer.valueOf(((Number) r56.getSecond()).intValue() + 1));
        goto L236
    L300:
        return;
    L227:
        r53 = null;
        goto L228
    L202:
        Pair<Integer, Integer> r58 = r48.get(r137);
        if (r58 == null) goto L201;
        r135 = r44;
        Integer r59 = (Integer) ((HashMap) nz1.a.M.getValue(null, nz1.a.a[37])).get(r137);
        if (r59 != null) goto L208;
        r59 = 3;
    L208:
        int r60 = r59.intValue();
        if (((Number) r58.getFirst()).intValue() != r138) goto L213;
        if (((Number) r58.getSecond()).intValue() <= r60) goto L213;
    L215:
        r49 = false;
        goto L216
    L214:
        r135 = r44;
        goto L215
    L196:
        r137 = null;
    L244:
        r8 = 1;
    L246:
        if (this.g == true) goto L261;
        h2 r61 = this.n;
        if (r61 == null) goto L261;
        l r63 = l0.a(r61);
        if (r63 == null) goto L261;
        Iterator<m> r64 = r63.dataList.iterator();
    L253:
        if (r64.hasNext() == false) goto L261;
        m r65 = r64.next();
        if (r65.leftGiftCount != ((r63.curLeftGiftCount - r21) + 1)) goto L253;
        ConstraintLayout r66 = a(2131367239);
        if (r66 == null) goto L259;
        r66.setVisibility(8);
    L259:
        ImageLoader.bindImage(this.w, r65.hintImg, new c(r63, r65, this));
        l();
        return;
    L261:
        this.h = false;
        int r67 = GiftManagerKt.s().size();
        int r68 = 0;
    L262:
        if (r68 >= r67) goto L279;
        if (this.g == true) goto L279;
        com.bytedance.android.livesdk.gift.platform.core.model.e r69 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r68);
        if (r21 == r69.comboCount) goto L267;
        r68 = r68 + 1;
        goto L262
    L267:
        this.h = true;
        if (r68 != (GiftManagerKt.s().size() - 1)) goto L270;
        boolean r70 = true;
    L271:
        this.j = r70;
        if (r70 == true) goto L276;
        ConstraintLayout r71 = a(2131367239);
        if (r71 == null) goto L276;
        r71.setVisibility(8);
    L276:
        ImageLoader.bindImage(this.w, r69.comboEffectImg, new d(this));
        goto L279
    L270:
        r70 = false;
    L279:
        if (this.h == true) goto L283;
        ConstraintLayout r73 = a(2131367239);
        if (r73 == null) goto L283;
        r73.setVisibility(0);
    L283:
        l();
        return;
    L87:
        r30 = -1;
        goto L89
    L75:
        r24 = null;
    L83:
        r28 = null;
        goto L84
    L48:
        if (r17.isDisposed() == true) goto L70;
        v r74 = this.u;
        if (r74 == null) goto L70;
        h2 r75 = this.n;
        if (r75 == null) goto L54;
        Long r76 = Long.valueOf(r75.getId());
    L55:
        u r77 = this.v;
        if (r77 == null) goto L58;
        List<v> r78 = r77.getComboHintData();
    L59:
        int r79 = g(r21, r78);
        u r139 = this.v;
        if (r139 != null) goto L62;
    L64:
        if (r139 != null) goto L66;
    L68:
        int r140 = 0;
    L69:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.n(r76, r79, Integer.valueOf(r140), r74.getName(), r74.getName());
        goto L70
    L66:
        if (r139.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L68;
        r140 = 4;
        goto L69
    L62:
        if (r139.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L64;
        r140 = 3;
        goto L69
    L58:
        r78 = null;
        goto L59
    L54:
        r76 = null;
        goto L55
    }

    public ComboProgressAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.m = new ArrayList();
        this.s = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131565228, this);
        this.w = a(2131387073);
        int r5 = GiftManagerKt.s().size();
        if (r5 <= 0) goto L21;
        this.k = ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r5 - 1)).comboCount;
    L21:
        Typeface r6 = Typeface.createFromAsset(r2.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L15
        TextView r7 = (TextView) a(2131367241);     // Catch: Exception -> L15
        if (r7 == null) goto L8;
        r7.setTypeface(r6);     // Catch: Exception -> L15
    L8:
        TextView r8 = (TextView) a(2131367243);     // Catch: Exception -> L15
        if (r8 == null) goto L11;
        r8.setTypeface(r6);     // Catch: Exception -> L15
    L11:
        TextView r9 = (TextView) a(2131367245);     // Catch: Exception -> L15
        if (r9 == null) goto L18;
        r9.setTypeface(r6);     // Catch: Exception -> L15
    L18:
        if (this.m.isEmpty() == false) goto L23;
        this.m.addAll(GiftManagerKt.s());
        return;
    L23:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("ComboProgressAnimationView", "load font asset exception: " + e.getMessage(), null, 4);
        goto L18
    }

    public static final void c(ComboProgressAnimationView r16, boolean r17, boolean r18) {
        r16.l = r17;
        r16.f();
        r16.e = new AnimatorSet();
        if (r16.j == false) goto L6;
        if (r17 == true) goto L6;
        float r2 = s1.e(36.0f);
    L7:
        r16.i = r2;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r16.w, "translationY", new float[]{s1.e(90.0f), r16.i});
        r3.setDuration(150);
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(r16.w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.3f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.3f})});
        r5.setDuration(250);
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(new Animator[]{r3, r5});
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(r16.w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.3f, 0.9f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.3f, 0.9f})});
        r4.setDuration(200);
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(r16.w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.9f, 1.02f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.9f, 1.02f})});
        r6.setDuration(250);
        ObjectAnimator r7 = ObjectAnimator.ofPropertyValuesHolder(r16.w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.02f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.02f, 1.0f})});
        r7.setDuration(250);
        AnimatorSet r13 = new AnimatorSet();
        r13.playSequentially(new Animator[]{r9, r4, r6, r7});
        r13.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r16.w, "alpha", new float[]{1.0f, 1.0f});
        r8.setDuration(800);
        ObjectAnimator r10 = ObjectAnimator.ofPropertyValuesHolder(r16.w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.0f})});
        r10.setDuration(250);
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r8, r10});
        r11.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        if (r16.j == false) goto L13;
        if (r17 == true) goto L13;
        AnimatorSet r14 = r16.e;
        if (r14 == null) goto L16;
        r14.playSequentially(new Animator[]{r13});
    L16:
        AnimatorSet r15 = r16.e;
        if (r15 == null) goto L19;
        r15.addListener(new b02.i(r16, r18, r17));
    L19:
        AnimatorSet r0 = r16.e;
        if (r0 == null) goto L23;
        r0.start();
        return;
    L23:
        return;
    L13:
        AnimatorSet r19 = r16.e;
        if (r19 == null) goto L16;
        r19.playSequentially(new Animator[]{r13, r11});
    L6:
        r2 = 0.0f;
        goto L7
    }

    public /* synthetic */ ComboProgressAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void h(v r10, int r11, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "each");
        Intrinsics.checkNotNullParameter(r14, "showTime");
        ConstraintLayout r0 = a(2131367239);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ImageLoader.bindImage(this.w, r10.getHintImg(), new b(this, r11, r14, r13, r10));
        l();
    }
}
