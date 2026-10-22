package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b02.l;
import b02.m;
import b02.n;
import b02.o;
import b02.p;
import b02.s;
import b02.t;
import b02.u;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import pz1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveGiftComboViewNew extends FrameLayout {
    public static final /* synthetic */ int r = 0;
    public View a;
    public TextView b;
    public View c;
    public AnimatorSet d;
    public int e;
    public long f;
    public long g;
    public int h;
    public AbsPanel i;
    public int j;
    public RoundWaveAnimationView k;
    public ComboEffectAnimationView l;
    public ComboProgressAnimationView m;
    public ComboIconAnimationView n;
    public Disposable o;
    public Disposable p;
    public long q;

    public class a extends o12.b {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ LiveGiftComboViewNew b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            LiveGiftComboViewNew r4 = this.b;
            r4.e = 0;
            r4.h = 0;
            ComboEffectAnimationView r5 = r4.l;
            if (r5 == null) goto L5;
            r5.a(0);
        L5:
            LiveGiftComboViewNew r6 = this.b;
            ComboIconAnimationView r1 = r6.n;
            if (r1 == null) goto L8;
            r1.c(r6.h);
        L8:
            LiveGiftComboViewNew r7 = this.b;
            ComboProgressAnimationView r2 = r7.m;
            if (r2 == null) goto L11;
            r2.i(r7.h, 0);
        L11:
            Runnable r8 = this.a;
            if (r8 == null) goto L15;
            r8.run();
            return;
        }

        public a(LiveGiftComboViewNew r1, Runnable r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b extends o12.b {
        public final /* synthetic */ Runnable a;

        public b(Runnable r1) {
            this.a = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            Runnable r2 = this.a;
            if (r2 == null) goto L6;
            r2.run();
            return;
        }
    }

    public final void d() {
        this.h = 0;
        b();
        setScaleX(1.0f);
        setScaleY(1.0f);
        View r1 = this.a;
        if (r1 == null) goto L5;
        r1.setRotation(0.0f);
    L5:
        this.q = 0;
        this.e = 0;
        RoundWaveAnimationView r2 = this.k;
        if (r2 == null) goto L11;
        Disposable r3 = r2.a;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        r2.removeAllViews();
    L11:
        ComboIconAnimationView r4 = this.n;
        Long r5 = null;
        if (r4 == null) goto L23;
        Bitmap r6 = r4.d;
        if (r6 == null) goto L16;
        r6.recycle();
    L16:
        r4.d = null;
        Disposable r7 = r4.b;
        if (r7 == null) goto L19;
        r7.dispose();
    L19:
        Disposable r8 = r4.c;
        if (r8 == null) goto L22;
        r8.dispose();
    L22:
        r4.removeAllViews();
    L23:
        ComboEffectAnimationView r9 = this.l;
        if (r9 == null) goto L29;
        Disposable r10 = r9.b;
        if (r10 == null) goto L28;
        r10.dispose();
    L28:
        r9.removeAllViews();
    L29:
        ComboProgressAnimationView r11 = this.m;
        if (r11 == null) goto L41;
        r11.b = 0;
        r11.f = false;
        r11.h = false;
        r11.j = false;
        HSImageView r0 = r11.w;
        if (r0 == null) goto L34;
        r0.setScaleX(0.0f);
    L34:
        HSImageView r13 = r11.w;
        if (r13 == null) goto L37;
        r13.setScaleY(0.0f);
    L37:
        r11.e();
        r11.d();
        r11.f();
        ((LinkedHashMap) r11.s).clear();
        h2 r14 = r11.n;
        if (r14 == null) goto L40;
        r5 = Long.valueOf(r14.getId());
    L40:
        r11.q(r5);
    L41:
        Disposable r15 = this.p;
        if (r15 != null) goto L44;
    L46:
        Disposable r16 = this.o;
        if (r16 != null) goto L49;
        return;
    L49:
        if (r16.isDisposed() == true) goto L53;
        this.o.dispose();
        return;
    L53:
        return;
    L44:
        if (r15.isDisposed() == true) goto L46;
        this.p.dispose();
        goto L46
    }

    public final boolean a() {
        if ((this.i instanceof e) == false) goto L11;
        int r0 = this.j;
        if (r0 > 0) goto L7;
    L9:
        return false;
    L7:
        if (r0 <= this.h) goto L9;
        return true;
    L11:
        return true;
    }

    public final void b() {
        AnimatorSet r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        this.d = null;
        View r1 = this.a;
        if (r1 == null) goto L11;
        r1.animate().cancel();
        return;
    L11:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.d.removeAllListeners();
        this.d.cancel();
        goto L7
    }

    public final void e() {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L12;
        ConstraintLayout.LayoutParams r2 = this.c.getLayoutParams();
        r2.topToTop = 0;
        r2.topToBottom = -1;
        r2.bottomToBottom = 0;
        r2.bottomToTop = -1;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = 0;
        this.c.setLayoutParams(r2);
        return;
    }

    public int getComboCount() {
        return this.h;
    }

    public LiveGiftComboViewNew(Context r2) {
        this(r2, null);
    }

    public final void f(Runnable r11) {
        b();
        this.d = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{1.0f, 0.95f, 1.0f});
        this.d.playTogether(new Animator[]{r0, r2, r4, r6, r3, r5});
        this.d.setDuration(200);
        this.d.addListener(new b(r11));
        ViewPropertyAnimator r13 = this.a.animate().rotation(0.0f).setDuration(150);
        PathInterpolator r1 = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        r13.setInterpolator(r1);
        this.d.setInterpolator(r1);
        r13.start();
        this.d.start();
    }

    public final void g(Runnable r5) {
        b();
        this.d = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.a, "rotation", new float[]{0.0f, 360.0f});
        this.d.playTogether(new Animator[]{r0});
        this.d.setDuration(2000);
        this.d.addListener(new a(this, r5));
        this.d.start();
    }

    public final void i(final Runnable r6) {
        int r1 = (((int) (this.q / 1000)) * 3) + 5;
        if (r1 <= 50) goto L10;
        Disposable r2 = this.p;
        if (r2 != null) goto L7;
    L9:
        r1 = 50;
        goto L10
    L7:
        if (r2.isDisposed() == true) goto L9;
        this.p.dispose();
    L10:
        int r0 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW / r1;
        Disposable r3 = this.o;
        if (r3 != null) goto L13;
    L15:
        j.a r4 = j.a;
        this.o = j.a(0, r0, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r6), new n(), new o());
        return;
    L13:
        if (r3.isDisposed() == true) goto L15;
        this.o.dispose();
        goto L15
    }

    public void setGiftId(long r2) {
        this.f = r2;
        ComboIconAnimationView r0 = this.n;
        if (r0 == null) goto L6;
        r0.setGiftId(r2);
        return;
    }

    public void setPanel(AbsPanel r3) {
        this.i = r3;
        if (r3 == null) goto L7;
        T r0 = r3.h;
        if ((r0 instanceof l2) == false) goto L7;
        this.j = ((l2) r0).getCount();
    L7:
        if (r3 == null) goto L14;
        T r4 = r3.h;
        if ((r4 instanceof h1) == false) goto L15;
        ComboProgressAnimationView r1 = this.m;
        if (r1 == null) goto L16;
        r1.setGift((h1) r4);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setPropId(long r1) {
        this.g = r1;
    }

    public LiveGiftComboViewNew(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void h(final Runnable r5, boolean r6) {
        if (r6 == true) goto L5;
        this.q = 0;
    L5:
        Disposable r7 = this.p;
        if (r7 != null) goto L8;
    L10:
        j.a r8 = j.a;
        this.p = j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this, r5), new n(), new o());
        return;
    L8:
        if (r7.isDisposed() == true) goto L10;
        this.p.dispose();
        goto L10
    }

    public LiveGiftComboViewNew(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.j = 0;
        View.inflate(r3, 2131565232, this);
        this.a = findViewById(2131367228);
        this.b = (TextView) findViewById(2131367263);
        this.c = findViewById(2131367264);
        this.k = (RoundWaveAnimationView) findViewById(2131367259);
        this.l = (ComboEffectAnimationView) findViewById(2131367248);
        this.m = (ComboProgressAnimationView) findViewById(2131367251);
        this.n = (ComboIconAnimationView) findViewById(2131367250);
    }

    public final void c(final Runnable r7, boolean r8, boolean r9) {
        if (r9 == false) goto L9;
        long r2 = this.g;
        if (r2 != (-1)) goto L7;
        h.L(this.f, true);
        goto L9
    L7:
        h.L(r2, false);
    L9:
        if (this.e != 0) goto L12;
        return;
    L12:
        if (a() == true) goto L15;
        r7.run();
        this.j = 0;
        ToastUtil.a(2131919787, 0);
        return;
    L15:
        this.e = 1;
        f(new l(this, r7));
        if (r8 == false) goto L21;
        h(r7, false);
        i(r7);
        RoundWaveAnimationView r10 = this.k;
        if (r10 == null) goto L22;
        r10.a();
        j.a r11 = j.a;
        r10.a = j.a(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(r10), t.a, u.a);
        return;
    L22:
        return;
    }
}
