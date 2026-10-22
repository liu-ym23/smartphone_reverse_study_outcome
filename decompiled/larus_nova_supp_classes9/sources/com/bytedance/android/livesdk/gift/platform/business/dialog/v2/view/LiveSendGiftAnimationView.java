package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.configmodel.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;
import qz1.i;
import qz1.j;
import qz1.l;
import qz1.m;
import qz1.n;
import qz1.o;
import qz1.p;
import qz1.q;
import qz1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveSendGiftAnimationView extends FrameLayout {
    public ObjectAnimator A;
    public String B;
    public String C;
    public Bitmap D;
    public Spannable E;
    public HSImageView F;
    public HSImageView G;
    public final boolean H;
    public final boolean I;
    public final f0 J;
    public int K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public final float a;
    public Pair<Float, Animator> b;
    public Pair<Float, Animator> c;
    public HSImageView d;
    public HSImageView e;
    public HSImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public View k;
    public View l;
    public ViewGroup m;
    public boolean n;
    public AnimatorSet o;
    public k p;
    public k q;
    public AnimatedDrawable2 r;
    public boolean s;
    public ObjectAnimator t;
    public ObjectAnimator u;
    public ObjectAnimator v;
    public ObjectAnimator w;
    public ObjectAnimator x;
    public ObjectAnimator y;
    public ObjectAnimator z;

    public class a extends GiftPanelIconLoadListener {
        public final /* synthetic */ LiveSendGiftAnimationView h;

        @Override // com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener
        public final Map<String, String> g() {
            HashMap r0 = new HashMap();
            r0.put("position", String.valueOf(this.h.N));
            r0.put("tab_position", String.valueOf(this.h.O));
            r0.put("icon_type", "send_item");
            return r0;
        }

        public a(LiveSendGiftAnimationView r1, GiftContext r2) {
            this.h = r1;
            super(r2);
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ LiveSendGiftAnimationView a;

        public b(LiveSendGiftAnimationView r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            this.a.r = r5;
            com.bytedance.android.live.core.utils.fresco.c.c(r5);
            r5.setAnimationListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.a(this));
            this.a.p();
            return;
        }
    }

    public class c implements Animator.AnimatorListener {
        public final /* synthetic */ LiveSendGiftAnimationView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        public c(LiveSendGiftAnimationView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.d.setVisibility(8);
            LiveSendGiftAnimationView r3 = this.a;
            r3.s = false;
            r3.p();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            LiveSendGiftAnimationView r4 = this.a;
            r4.s = true;
            r4.d.setVisibility(0);
            LiveSendGiftAnimationView.e(this.a, true);
            this.a.p();
        }
    }

    public class d implements Animator.AnimatorListener {
        public final /* synthetic */ LiveSendGiftAnimationView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        public d(LiveSendGiftAnimationView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.d.setVisibility(8);
            LiveSendGiftAnimationView r3 = this.a;
            r3.s = false;
            r3.p();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            LiveSendGiftAnimationView r4 = this.a;
            r4.s = true;
            r4.d.setVisibility(0);
            LiveSendGiftAnimationView.e(this.a, true);
        }
    }

    private float getBreathLightAnimScale() {
        f0 r0 = this.J;
        if (r0 != null) goto L5;
        return 1.0f;
    L5:
        if (r0.b() == true) goto L8;
        return 1.0f;
    L8:
        if (this.J.c() > 0.0f) goto L14;
        return 1.14f;
    L14:
        return this.J.c();
    }

    public final void l() {
        if (this.I == true) goto L5;
        return;
    L5:
        HSImageView r0 = this.f;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.setController(null);
        setGiftImageVisible(true);
        AnimatedDrawable2 r1 = this.r;
        if (r1 == null) goto L12;
        r1.stop();
        this.r = null;
        return;
    }

    public final void m() {
        this.t = ObjectAnimator.ofFloat(this.e, "translationX", new float[]{-this.a, 0.0f});
        this.u = ObjectAnimator.ofFloat(this.d, "translationX", new float[]{0.0f, this.a});
        this.t.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.u.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.t.addUpdateListener(new qz1.k(this));
        this.u.addUpdateListener(new l(this));
        this.t.setDuration(200);
        this.u.setDuration(200);
        this.u.addListener(new c(this));
    }

    public final void n() {
        this.v = ObjectAnimator.ofFloat(this.e, "translationX", new float[]{this.a, 0.0f});
        this.w = ObjectAnimator.ofFloat(this.d, "translationX", new float[]{0.0f, -this.a});
        this.v.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.w.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.v.addUpdateListener(new o(this));
        this.w.addUpdateListener(new p(this));
        this.v.setDuration(200);
        this.w.setDuration(200);
        this.w.addListener(new d(this));
    }

    public final void o() {
        Pair<Float, Animator> r0 = this.c;
        if (r0 == null) goto L9;
        Object r1 = r0.second;
        if (r1 == null) goto L9;
        if (((Animator) r1).isStarted() == false) goto L9;
        return;
    L9:
        float r2 = getBreathLightAnimScale();
        Pair<Float, Animator> r3 = this.c;
        if (r3 != null) goto L12;
    L17:
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, r2});
        PropertyValuesHolder r5 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, r2});
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(this.e, new PropertyValuesHolder[]{r4, r5});
        f0 r7 = this.J;
        if (r7 != null) goto L20;
    L22:
        long r8 = 400;
    L23:
        r6.setDuration(r8);
        r6.setInterpolator(new LinearInterpolator());
        r6.setRepeatCount(-1);
        r6.setRepeatMode(2);
        this.c = new Pair(Float.valueOf(r2), r6);
    L24:
        Object r9 = this.c.second;
        if (r9 == null) goto L28;
        ((Animator) r9).start();
        return;
    L28:
        return;
    L20:
        if (r7.a() <= 0) goto L22;
        r8 = this.J.a();
        goto L23
    L12:
        if (r3.second == null) goto L17;
        Object r10 = r3.first;
        if (r10 == null) goto L17;
        if (((Float) r10).floatValue() == r2) goto L24;
        goto L17
    }

    public final void p() {
        if (this.I == true) goto L6;
        return;
    L6:
        if (this.f != null) goto L8;
        return;
    L8:
        if (this.r != null) goto L10;
        return;
    L10:
        if (getVisibility() == 0) goto L13;
        return;
    L13:
        if (this.s == true) goto L15;
        this.r.start();
        return;
    L15:
        if (this.r.isRunning() == false) goto L20;
        this.r.stop();
        this.r.jumpToFrame(0);
        return;
    }

    public final void r() {
        if (this.L == false) goto L9;
        this.i.setText(2131922465);
        if (this.M == false) goto L7;
        this.i.setTextColor(getContext().getResources().getColor(2131109391));
        this.k.setBackgroundResource(2131248758);
    L16:
        if (TextUtils.isEmpty(this.B) == true) goto L19;
        this.i.setText(this.B);
    L19:
        if (TextUtils.isEmpty(this.C) == true) goto L22;
        this.i.setText(this.C);
        return;
    L22:
        Spannable r0 = this.E;
        if (r0 == null) goto L26;
        this.i.setText(r0);
        return;
    L26:
        return;
    L7:
        this.i.setTextColor(getContext().getResources().getColor(2131107081));
        this.k.setBackgroundResource(2131248759);
        goto L16
    L9:
        if (this.n == false) goto L11;
        this.i.setText(2131922452);
        this.i.setTextColor(getContext().getResources().getColor(2131109391));
        this.k.setBackgroundResource(2131248759);
        goto L16
    L11:
        this.i.setText(2131922465);
        if (this.K != 1) goto L14;
        this.i.setTextColor(getContext().getResources().getColor(2131107007));
        this.k.setBackgroundResource(2131248753);
        goto L16
    L14:
        this.i.setTextColor(getContext().getResources().getColor(2131109391));
        this.k.setBackgroundResource(2131248758);
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        l();
        Pair<Float, Animator> r0 = this.c;
        if (r0 == null) goto L9;
        Object r1 = r0.second;
        if (r1 == null) goto L9;
        if (((Animator) r1).isStarted() == false) goto L9;
        ((Animator) this.c.second).cancel();
        ((Animator) this.c.second).removeAllListeners();
        this.c = null;
    L9:
        super.onDetachedFromWindow();
    }

    public HSImageView getGiftImage() {
        return this.e;
    }

    public HSImageView getIconAnimationContainer() {
        return this.F;
    }

    public LiveSendGiftAnimationView(Context r2) {
        this(r2, null);
    }

    private void setGiftImageVisible(boolean r5) {
        HSImageView r0 = this.e;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        if (this.I == false) goto L20;
        HSImageView r2 = this.f;
        if (r2 == null) goto L21;
        int r4 = r2.getVisibility();
        if (r5 == false) goto L13;
        int r6 = 0;
    L14:
        if (r4 != r6) goto L22;
        HSImageView r7 = this.f;
        if (r5 == false) goto L18;
        r1 = 8;
    L18:
        r7.setVisibility(r1);
        return;
    L22:
        return;
    L13:
        r6 = 8;
        goto L14
    L21:
        return;
    L20:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void g(k r4) {
        if (this.I == true) goto L6;
        return;
    L6:
        if (this.f != null) goto L9;
        return;
    L9:
        if (r4 != null) goto L11;
    L25:
        this.f.setVisibility(8);
        this.f.setController(null);
        this.q = null;
        this.r = null;
        return;
    L11:
        if (r4.isValid() == false) goto L25;
        k r1 = this.q;
        if (r1 != null) goto L16;
    L21:
        b r2 = new b(this);
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(ImageLoader.createImageRequests(r4, null, null)).setOldController(this.f.getController()).setControllerListener(r2).setAutoPlayAnimations(false).build();
        this.f.setController(r5);
        if (this.f.getDrawable() == null) goto L27;
        this.f.getDrawable().setVisible(true, false);
        return;
    L27:
        return;
    L16:
        if (r1.equalsOnlyUri(r4) == false) goto L21;
        if (this.f.hasController() == false) goto L21;
        p();
    }

    public void setDiamondText(String r2) {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public void setLockStatus(boolean r1) {
        this.L = r1;
        r();
    }

    public void setLockText(String r1) {
        this.C = r1;
    }

    public void setPanelBackground(Drawable r2) {
        if (r2 == null) goto L7;
        ViewGroup r0 = this.m;
        if (r0 == null) goto L8;
        r0.setBackground(r2);
        return;
    L8:
        return;
    }

    public void setPanelTopBackground(Drawable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.m == null) goto L8;
        this.j.setBackground(r2);
        return;
    }

    public void setRightTopSelectedLabelView(k r4) {
        HSImageView r0 = this.G;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r0.setVisibility(4);
        return;
    L7:
        r0.setVisibility(0);
        ImageLoader.bindImage(this.G, r4, s1.j(2131168756), s1.j(2131168756));
    }

    public void setSendText(Spannable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length() <= 0) goto L8;
        this.E = r2;
        this.i.setText(r2);
        return;
    }

    public void setUseCustomTextStyleWhenLocked(boolean r1) {
        this.M = r1;
        r();
    }

    public void setSendText(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.B = r2;
        this.i.setText(r2);
        return;
    }

    public LiveSendGiftAnimationView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void a(LiveSendGiftAnimationView r4, ValueAnimator r5) {
        float r0 = r4.getBreathLightAnimScale() * r4.d.getWidth();
        float r1 = r4.getBreathLightAnimScale() * r4.d.getHeight();
        float r2 = (r4.k.getWidth() - r0) / 2.0f;
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        float r3 = -r2;
        if (r6 <= r3) goto L5;
        float r7 = 0.0f;
    L6:
        r4.d.setClipBounds(new Rect((int) r7, 0, (int) r0, (int) r1));
        return;
    L5:
        r7 = r3 - r6;
        goto L6
    }

    public static /* synthetic */ void b(LiveSendGiftAnimationView r4, ValueAnimator r5) {
        float r0 = r4.getBreathLightAnimScale() * r4.e.getWidth();
        float r1 = r4.getBreathLightAnimScale() * r4.e.getHeight();
        float r2 = ((r4.k.getWidth() - r0) / 2.0f) + r0;
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        if (r6 >= (-r2)) goto L5;
        float r7 = r0;
    L6:
        r4.e.setClipBounds(new Rect((int) r7, 0, (int) r0, (int) r1));
        return;
    L5:
        r7 = r0 - (r6 + r2);
        goto L6
    }

    public static /* synthetic */ void c(LiveSendGiftAnimationView r4, ValueAnimator r5) {
        float r0 = r4.getBreathLightAnimScale() * r4.e.getWidth();
        float r1 = r4.getBreathLightAnimScale() * r4.e.getHeight();
        float r2 = ((r4.k.getWidth() - r0) / 2.0f) + r0;
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        if (r6 <= r2) goto L5;
        float r7 = 0.0f;
    L6:
        r4.e.setClipBounds(new Rect(0, 0, (int) r7, (int) r1));
        return;
    L5:
        r7 = r2 - r6;
        goto L6
    }

    public static /* synthetic */ void d(LiveSendGiftAnimationView r4, ValueAnimator r5) {
        float r0 = r4.getBreathLightAnimScale() * r4.d.getWidth();
        float r1 = r4.getBreathLightAnimScale() * r4.d.getHeight();
        float r2 = (r4.k.getWidth() - r0) / 2.0f;
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        if (r6 < r2) goto L6;
        r0 = r0 - (r6 - r2);
    L6:
        r4.d.setClipBounds(new Rect(0, 0, (int) r0, (int) r1));
    }

    public static /* synthetic */ void e(LiveSendGiftAnimationView r0, boolean r1) {
        r0.setGiftImageVisible(r1);
    }

    public static boolean k(k r3, k r4) {
        if (((Boolean) nz1.a.n0.getValue(null, nz1.a.a[64])).booleanValue() == false) goto L11;
        if (r3 == null) goto L11;
        if (TextUtils.isEmpty(r3.getUri()) == true) goto L11;
        if (r3.equalsOnlyUri(r4) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final void i(boolean r14, String r15) {
        if (nz1.a.g() == true) goto L6;
        return;
    L6:
        if (r14 == false) goto L8;
        this.x = ObjectAnimator.ofFloat(this.g, "translationX", new float[]{-this.a, 0.0f});
        this.y = ObjectAnimator.ofFloat(this.h, "translationX", new float[]{0.0f, this.a});
        this.x.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.y.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.x.addUpdateListener(new m(this));
        this.y.addUpdateListener(new n(this));
        this.x.setDuration(200);
        this.y.setDuration(200);
        this.y.addListener(new q(this));
    L9:
        this.h.setText(this.g.getText());
        this.g.setText(r15);
        if (r14 == false) goto L12;
        this.x.start();
        this.y.start();
        return;
    L12:
        this.z.start();
        this.A.start();
        return;
    L8:
        this.z = ObjectAnimator.ofFloat(this.g, "translationX", new float[]{this.a, 0.0f});
        this.A = ObjectAnimator.ofFloat(this.h, "translationX", new float[]{0.0f, -this.a});
        this.z.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.A.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.z.addUpdateListener(new i(this));
        this.A.addUpdateListener(new j(this));
        this.z.setDuration(200);
        this.A.setDuration(200);
        this.A.addListener(new r(this));
        goto L9
    }

    public LiveSendGiftAnimationView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.a = UIUtils.dip2Px(getContext(), 120.0f);
        this.n = false;
        this.s = false;
        this.B = BuildConfig.FLAVOR;
        this.C = BuildConfig.FLAVOR;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        ReadOnlyProperty r0 = nz1.a.i0;
        KProperty[] r1 = nz1.a.a;
        boolean r2 = ((Boolean) r0.getValue(null, r1[59])).booleanValue();
        this.H = r2;
        this.I = ((Boolean) nz1.a.o0.getValue(null, r1[65])).booleanValue();
        f0 r8 = (f0) nz1.a.p0.getValue(null, r1[66]);
        this.J = r8;
        this.K = 0;
        this.L = false;
        this.M = false;
        if (com.bytedance.android.livesdk.gift.util.b.b() != null) goto L5;
    L7:
        GiftPanelViewPreloadService.l.getClass();
        View r3 = GiftPanelViewPreloadService.a.a(2131565265);
        if (r3 == null) goto L10;
        addView(r3);
    L11:
        this.e = findViewById(2131373729);
        if (r8 != null) goto L14;
    L30:
        q(this.e, (int) UIUtils.dip2Px(getContext(), 64.0f), (int) UIUtils.dip2Px(getContext(), 64.0f));
    L31:
        HSImageView r9 = (HSImageView) findViewById(2131380721);
        this.d = r9;
        q(r9, (int) UIUtils.dip2Px(getContext(), 64.0f), (int) UIUtils.dip2Px(getContext(), 64.0f));
        this.g = (TextView) findViewById(2131368992);
        this.h = (TextView) findViewById(2131380718);
        this.i = (TextView) findViewById(2131385893);
        this.j = findViewById(2131389138);
        this.l = findViewById(2131368146);
        this.k = findViewById(2131364437);
        this.m = (ViewGroup) findViewById(2131384840);
        this.d.setVisibility(8);
        this.F = findViewById(2131374725);
        this.G = findViewById(2131384639);
        HSImageView r10 = (HSImageView) findViewById(2131370476);
        this.f = r10;
        q(r10, (int) UIUtils.dip2Px(getContext(), 88.0f), (int) UIUtils.dip2Px(getContext(), 80.0f));
        return;
    L14:
        if (r8.b() == false) goto L30;
        if (r2 == false) goto L18;
        int r11 = 56;
    L19:
        float r13 = r11;
        HSImageView r14 = this.e;
        int r4 = (int) UIUtils.dip2Px(getContext(), r13);
        int r15 = (int) UIUtils.dip2Px(getContext(), r13);
        if (r14 == null) goto L24;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16 == null) goto L24;
        r16.width = r4;
        r16.height = r15;
        r14.setLayoutParams(r16);
    L24:
        if (r2 == false) goto L26;
        int r17 = 5;
    L27:
        float r18 = r17;
        if ((this.e.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L31;
        ((ViewGroup.MarginLayoutParams) this.e.getLayoutParams()).topMargin = (int) UIUtils.dip2Px(getContext(), r18);
        goto L31
    L26:
        r17 = 7;
        goto L27
    L18:
        r11 = 52;
        goto L19
    L10:
        View.inflate(r5, 2131565265, this);
        goto L11
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.b().isVS().getValue()).booleanValue() == false) goto L7;
        View.inflate(r5, 2131567955, this);
        goto L11
    }

    public final void q(HSImageView r2, int r3, int r4) {
        if (this.H == false) goto L9;
        if (r2 == null) goto L10;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L11;
        r0.width = r3;
        r0.height = r4;
        r2.setLayoutParams(r0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void j(k r5, k r6, boolean r7, String r8) {
        i(r7, r8);
        if (r7 == false) goto L5;
        m();
    L6:
        k r9 = this.p;
        if (r9 != null) goto L11;
        Bitmap r1 = this.D;
        if (r1 == null) goto L11;
        this.d.setImageBitmap(r1);
    L13:
        if (k(this.p, r5) == false) goto L15;
        ImageLoader.bindImage(this.e, r5, s1.j(2131168749), s1.j(2131168749));
    L15:
        g(r6);
        this.d.setVisibility(0);
        setGiftImageVisible(true);
        if (r7 == false) goto L18;
        this.t.start();
        this.u.start();
    L19:
        this.q = r6;
        this.p = r5;
        this.D = null;
        return;
    L18:
        this.v.start();
        this.w.start();
    L11:
        ImageLoader.bindImage(this.d, r9, s1.j(2131168749), s1.j(2131168749));
        goto L13
    L5:
        n();
        goto L6
    }

    public final void h(k r1, Bitmap r2, boolean r3, boolean r4, String r5) {
        if (r4 == false) goto L21;
        i(r3, r5);
        if (r3 == false) goto L6;
        m();
    L7:
        Bitmap r6 = this.D;
        if (r6 != null) goto L13;
        HSImageView r7 = this.d;
        k r8 = this.p;
        if (r8 != null) goto L12;
        r8 = r1;
    L12:
        ImageLoader.bindImage(r7, r8);
    L14:
        if (r2 != null) goto L16;
        ImageLoader.bindImage(this.e, r1);
    L17:
        this.d.setVisibility(0);
        setGiftImageVisible(true);
        if (r3 == false) goto L20;
        this.t.start();
        this.u.start();
    L24:
        this.D = r2;
        return;
    L20:
        this.v.start();
        this.w.start();
        goto L24
    L16:
        this.e.setImageBitmap(r2);
        goto L17
    L13:
        this.d.setImageBitmap(r6);
        goto L14
    L6:
        n();
        goto L7
    L21:
        if (r2 != null) goto L23;
        ImageLoader.bindImage(this.e, r1);
        goto L24
    L23:
        this.e.setImageBitmap(r2);
        goto L24
    }

    public final void f(k r17, k r18, String r19, int r20, String r21, boolean r23, int r24) {
        Bitmap r1 = this.D;
        if (r1 != null) goto L7;
        g(r18);
        if (k(this.q, r17) == false) goto L8;
        GiftImageLoader r2 = GiftImageLoader.k;
        HSImageView r3 = this.e;
        int r4 = ((Number) GiftImageLoader.h.getValue()).intValue();
        int r6 = e.b(2131168749);
        int r7 = e.b(2131168749);
        a r9 = new a(this, com.bytedance.android.livesdk.gift.util.b.b());
        String r13 = this.O + "-" + this.N;
        r2.getClass();
        GiftImageLoader.a(r3, r17, null, r4, r6, r7, null, r9, false, true, "live_gift_panel_send_icon", r13);
    L8:
        this.p = r17;
        this.q = r18;
        this.g.setText(r19);
        this.g.setTextColor(r20);
        this.i.setText(r21);
        this.L = r23;
        this.K = r24;
        r();
        return;
    L7:
        this.e.setImageBitmap(r1);
        goto L8
    }
}
