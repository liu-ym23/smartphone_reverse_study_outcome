package qz1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.configmodel.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s {
    public int A;
    public boolean a;
    public LiveSendGiftAnimationView b;
    public String c;
    public String d;
    public Spannable e;
    public py.k f;
    public py.k g;
    public String h;
    public int i;
    public String j;
    public boolean k;
    public int l;
    public Drawable m;
    public Drawable n;
    public boolean o;
    public boolean p;
    public py.k q;
    public Bitmap r;
    public boolean s;
    public boolean t;
    public DraweeController u;
    public boolean v;
    public py.k w;
    public boolean x;
    public final ViewStub y;
    public int z;

    public final HSImageView b() {
        if (this.a == false) goto L8;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGiftImage();
    L8:
        return null;
    }

    public final int c() {
        if (this.a == false) goto L8;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 != null) goto L7;
        return 8;
    L7:
        return r0.getVisibility();
    L8:
        return 8;
    }

    public final void d() {
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L6:
        if (r1 == null) goto L8;
        r1.height = s1.j(2131168760);
    L8:
        if (r1 == null) goto L10;
        r1.width = s1.j(2131168761);
    L10:
        LiveSendGiftAnimationView r2 = this.b;
        if (r2 == null) goto L16;
        HSImageView r3 = r2.getGiftImage();
        if (r3 == null) goto L17;
        r3.setLayoutParams(r1);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void i() {
        if (this.a == false) goto L20;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L21;
        AnimatorSet r1 = r0.o;
        if (r1 != null) goto L9;
    L13:
        f0 r2 = r0.J;
        if (r2 != null) goto L16;
    L18:
        PropertyValuesHolder r3 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.9f});
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.9f});
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(r0.e, new PropertyValuesHolder[]{r3, r4});
        r5.setDuration(100);
        PropertyValuesHolder r6 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.9f, 1.07f});
        PropertyValuesHolder r7 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.9f, 1.07f});
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(r0.e, new PropertyValuesHolder[]{r6, r7});
        r8.setDuration(150);
        PropertyValuesHolder r9 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.07f, 1.0f});
        PropertyValuesHolder r10 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.07f, 1.0f});
        ObjectAnimator r11 = ObjectAnimator.ofPropertyValuesHolder(r0.e, new PropertyValuesHolder[]{r9, r10});
        r11.setDuration(150);
        AnimatorSet r13 = new AnimatorSet();
        r0.o = r13;
        r13.playSequentially(new Animator[]{r5, r8, r11});
        r0.o.setStartDelay(300);
        r0.o.start();
        return;
    L16:
        if (r2.b() == false) goto L18;
        r0.o();
        return;
    L9:
        if (r1.isStarted() == false) goto L13;
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.x.getValue()).booleanValue() == false) goto L13;
        return;
    L21:
        return;
    }

    public final void j() {
        if (this.a == false) goto L8;
        LiveSendGiftAnimationView r1 = this.b;
        if (r1 == null) goto L9;
        float r2 = s1.f(10.0f);
        float r3 = s1.f(5.0f);
        float r4 = -r2;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r1.e, "translationY", new float[]{0.0f, r4});
        r5.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r5.setDuration(200);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r1.e, "translationY", new float[]{r4, 0.0f});
        r6.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r5.setDuration(150);
        float r7 = -r3;
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r1.e, "translationY", new float[]{0.0f, r7});
        r13.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r13.setDuration(150);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r1.e, "translationY", new float[]{r7, 0.0f});
        r8.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r13.setDuration(150);
        AnimatorSet r9 = new AnimatorSet();
        r1.o = r9;
        r9.playSequentially(new Animator[]{r5, r6, r13, r8});
        r1.o.start();
        return;
    L9:
        return;
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        if (this.a == false) goto L8;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setDiamondText(r2);
    L7:
        this.h = r2;
        return;
    L8:
        this.h = r2;
    }

    public final void g(String r2) {
        if (this.a == false) goto L7;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setSendText(r2);
    L7:
        this.c = r2;
    }

    public final void h(int r10) {
        if (this.a == false) goto L12;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L8;
        r0.setVisibility(r10);
    L8:
        if (r10 != 8) goto L37;
        LiveSendGiftAnimationView r11 = this.b;
        if (r11 == null) goto L38;
        r11.l();
        return;
    L38:
        return;
    L37:
        return;
    L12:
        if (r10 != 0) goto L40;
        ViewStub r13 = this.y;
        if (r13 == null) goto L16;
        View r14 = r13.inflate();
    L18:
        if ((r14 instanceof LiveSendGiftAnimationView) == false) goto L22;
        LiveSendGiftAnimationView r15 = (LiveSendGiftAnimationView) r14;
        this.b = r15;
        if (r15 == null) goto L22;
        int r1 = this.z;
        int r2 = this.A;
        r15.N = r1;
        r15.O = r2;
    L22:
        this.a = true;
        LiveSendGiftAnimationView r16 = this.b;
        if (r16 == null) goto L41;
        r16.setOnTouchListener(null);
        r16.setSendText(this.c);
        r16.setLockText(this.d);
        r16.setSendText(this.e);
        r16.setRightTopSelectedLabelView(this.w);
        boolean r3 = r16.n;
        boolean r4 = this.k;
        r16.n = r3;
        r16.L = r4;
        r16.r();
        r16.f(this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        r16.setUseCustomTextStyleWhenLocked(this.x);
        Drawable r5 = this.m;
        if (r5 == null) goto L27;
        r16.setPanelBackground(r5);
    L27:
        Drawable r6 = this.n;
        if (r6 == null) goto L31;
        r16.setPanelTopBackground(r6);
    L31:
        if (this.p == false) goto L34;
        r16.h(this.q, this.r, this.s, this.t, this.h);
    L34:
        if (this.v == false) goto L42;
        d();
        return;
    L42:
        return;
    L41:
        return;
    L16:
        r14 = null;
        goto L18
    }

    public final void k(Animator.AnimatorListener r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.u == null) goto L11;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L11;
        HSImageView r1 = r0.getGiftImage();
        if (r1 == null) goto L11;
        r1.setController(this.u);
    L11:
        LiveSendGiftAnimationView r2 = this.b;
        if (r2 == null) goto L25;
        Pair<Float, Animator> r3 = r2.b;
        if (r3 != null) goto L16;
    L21:
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.06f, 1.0f});
        PropertyValuesHolder r5 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.06f, 1.0f});
        Interpolator r6 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        Pair<Float, Animator> r7 = new Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r2, new PropertyValuesHolder[]{r4, r5}));
        r2.b = r7;
        ((Animator) r7.second).setInterpolator(r6);
        ((Animator) r2.b.second).setDuration(200);
    L22:
        ((Animator) r2.b.second).addListener(r9);
        ((Animator) r2.b.second).start();
        return;
    L16:
        if (r3.second == null) goto L21;
        Object r8 = r3.first;
        if (r8 == null) goto L21;
        if (((Float) r8).floatValue() == 1.06f) goto L22;
    }

    public final void f(boolean r2, boolean r3) {
        if (this.a == false) goto L7;
        LiveSendGiftAnimationView r0 = this.b;
        if (r0 == null) goto L7;
        r0.n = r2;
        r0.L = r3;
        r0.r();
    L7:
        this.k = r3;
    }

    public s(ViewStub r1, int r2, int r3) {
        this.y = r1;
        this.z = r2;
        this.A = r3;
        this.h = BuildConfig.FLAVOR;
        this.i = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.a();
        this.j = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.c();
    }

    public final void a(py.k r13, String r14, int r15, String r16, boolean r17, int r18, py.k r19) {
        Intrinsics.checkNotNullParameter(r14, "diamond");
        Intrinsics.checkNotNullParameter(r16, "send");
        if (this.a == false) goto L7;
        LiveSendGiftAnimationView r1 = this.b;
        if (r1 == null) goto L7;
        r1.f(r13, r19, r14, r15, r16, r17, r18);
    L7:
        this.f = r13;
        this.g = r19;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
    }
}
