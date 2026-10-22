package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t {
    public boolean a;
    public UgcGiftSelectView b;
    public py.k c;
    public String d;
    public String e;
    public b f;
    public final ViewStub g;

    public static final class a {
    }

    static {
    }

    public final void d() {
        if (this.a == false) goto L16;
        final UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L17;
        View r1 = r0.j;
        if (r1 == null) goto L18;
        r1.setVisibility(0);
        HSImageView r2 = r0.c;
        if (r2 == null) goto L11;
        r2.setAlpha(0.6f);
    L11:
        Animator r3 = r0.b;
        if (r3 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r3);
    L14:
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r1, "rotation", new float[]{0.0f, 360.0f});
        r4.setRepeatCount(-1);
        r4.setDuration(1000);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.c(r4, new UgcGiftSelectView$startLoadingAnimation$$inlined$let$lambda$1(r0));
        Unit r5 = Unit.INSTANCE;
        r0.b = r4;
        r4.start();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void e() {
        if (this.a == false) goto L28;
        UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L29;
        Pair<Float, Animator> r1 = r0.a;
        if (r1 != null) goto L9;
    L14:
        Pair<Float, Animator> r5 = new Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r0, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.06f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.06f, 1.0f})}));
        r0.a = r5;
        Animator r2 = (Animator) r5.second;
        if (r2 == null) goto L17;
        r2.setDuration(200);
    L17:
        Interpolator r3 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        Pair<Float, Animator> r4 = r0.a;
        if (r4 == null) goto L22;
        Animator r6 = (Animator) r4.second;
        if (r6 == null) goto L22;
        r6.setInterpolator(r3);
    L22:
        Pair<Float, Animator> r7 = r0.a;
        if (r7 == null) goto L30;
        Animator r8 = (Animator) r7.second;
        if (r8 == null) goto L31;
        r8.start();
        return;
    L31:
        return;
    L30:
        return;
    L9:
        if (((Animator) r1.second) == null) goto L14;
        Object r9 = r1.first;
        if (((Float) r9) == null) goto L14;
        if ((!Intrinsics.areEqual((Float) r9, 1.06f)) == false) goto L22;
    L29:
        return;
    }

    public final void f() {
        if (this.a == false) goto L13;
        UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L14;
        Animator r1 = r0.b;
        if (r1 == null) goto L9;
        r1.end();
    L9:
        Animator r2 = r0.b;
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r2);
        return;
    L15:
        return;
    L14:
        return;
    }

    public t(ViewStub r1) {
        this.g = r1;
        this.d = BuildConfig.FLAVOR;
        this.e = BuildConfig.FLAVOR;
    }

    public final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        if (this.a == false) goto L7;
        UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L7;
        r0.a(r2);
    L7:
        this.f = r2;
    }

    public final void c(int r5) {
        if (this.a == false) goto L7;
        UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L19;
        r0.setVisibility(r5);
        return;
    L19:
        return;
    L7:
        if (r5 != 0) goto L21;
        ViewStub r6 = this.g;
        if (r6 == null) goto L11;
        View r7 = r6.inflate();
    L13:
        if ((r7 instanceof UgcGiftSelectView) == false) goto L15;
        this.b = (UgcGiftSelectView) r7;
    L15:
        this.a = true;
        UgcGiftSelectView r8 = this.b;
        if (r8 == null) goto L22;
        r8.b(this.c, this.d, this.e, this.f);
        return;
    L22:
        return;
    L11:
        r7 = null;
        goto L13
    }

    public final void b(py.k r2, String r3, String r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "giftName");
        Intrinsics.checkNotNullParameter(r4, "diamond");
        Intrinsics.checkNotNullParameter(r5, "config");
        if (this.a == false) goto L7;
        UgcGiftSelectView r0 = this.b;
        if (r0 == null) goto L7;
        r0.b(r2, r3, r4, r5);
    L7:
        this.c = r2;
        this.e = r4;
        this.d = r3;
        this.f = r5;
    }
}
