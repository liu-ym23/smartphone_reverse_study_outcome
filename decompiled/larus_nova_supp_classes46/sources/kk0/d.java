package kk0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.revenue.battle.i;
import com.bytedance.android.live.profit.dress.s;
import kotlin.jvm.internal.Intrinsics;
import py.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ne0.a {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r18, Object r19) {
        Intrinsics.checkNotNullParameter(r18, "store");
        Object r0 = r19;
        if ((r0 instanceof nh0.d) == true) goto L5;
        r0 = null;
    L5:
        nh0.d r1 = (nh0.d) r0;
        if (r1 == null) goto L58;
        a r2 = this.a;
        ViewGroup r3 = r2.c;
        if (r3 != null) goto L11;
        ALogger.e("BaseMultiLinkWindowManager", "rankTransitionContainer not found!");
        return;
    L11:
        if (r2.d != null) goto L13;
        ALogger.e("BaseMultiLinkWindowManager", "crownTransitionView not found!");
        return;
    L13:
        r3.setVisibility(0);
        AnimatorSet r4 = new AnimatorSet();
        int r6 = i.a;
        String r7 = r1.a();
        String r8 = "";
        if (r7 != null) goto L16;
        String r9 = "";
    L17:
        Intrinsics.checkNotNullParameter(r9, "dressId");
        if (r9.length() != 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == true) goto L28;
        s r11 = yt0.c.a().getDressData(r9, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.h());
        if (r11 == null) goto L28;
        if (r11.f != true) goto L28;
        boolean r12 = true;
    L29:
        StringBuilder r13 = new StringBuilder("transition moveInfo=");
        r13.append(r1);
        r13.append(" needMove=");
        r13.append(r12);
        r13.append(" isVisible=");
        if (r2.c.getVisibility() != 0) goto L32;
        boolean r14 = true;
    L33:
        r13.append(r14);
        ALogger.i("BaseMultiLinkWindowManager", r13.toString());
        if (r12 == true) goto L36;
        return;
    L36:
        if ((!Intrinsics.areEqual(r1.b(), r1.c())) == true) goto L38;
        return;
    L38:
        if (v.a(r1.c()) == false) goto L63;
        a.InterfaceC0227a r5 = r2.e;
        String r15 = r1.b();
        if (r15 != null) goto L42;
        r15 = "";
    L42:
        PointF r16 = r5.x(r15);
        a.InterfaceC0227a r17 = r2.e;
        String r20 = r1.c();
        if (r20 != null) goto L45;
        r20 = "";
    L45:
        PointF r21 = r17.x(r20);
        if (r16 == null) goto L64;
        if (r21 == null) goto L65;
        PointF r22 = new PointF();
        float r110 = 2;
        r22.x = (r16.x + r21.x) / r110;
        float r23 = (r16.y + r21.y) / r110;
        r22.y = r23;
        if (r16.x == r21.x) goto L52;
        r22.y = r23 - s1.f(30.0f);
    L52:
        HSImageView r24 = new HSImageView(r2.a);
        String r25 = r1.a();
        if (r25 == null) goto L56;
        r8 = r25;
    L56:
        r24.setImageURI(i.d(r8));
        r2.c.addView(r24);
        ViewGroup.LayoutParams r26 = r24.getLayoutParams();
        r26.width = s1.f(12.0f);
        r26.height = s1.f(12.0f);
        PropertyValuesHolder r27 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.6f});
        PropertyValuesHolder r111 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.6f});
        PropertyValuesHolder r28 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.6f, 1.0f});
        PropertyValuesHolder r112 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.6f, 1.0f});
        AnimatorSet r113 = new AnimatorSet();
        ObjectAnimator r29 = ObjectAnimator.ofPropertyValuesHolder(r24, new PropertyValuesHolder[]{r27, r111});
        r29.setDuration(400);
        r29.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r30 = ObjectAnimator.ofPropertyValuesHolder(r24, new PropertyValuesHolder[]{r28, r112});
        r30.setDuration(350);
        r30.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        r113.playSequentially(new Animator[]{r29, r30});
        ValueAnimator r31 = ValueAnimator.ofObject(new com.bytedance.android.live.liveinteract.utils.f(r22), new Object[]{r16, r21});
        r31.setDuration(750);
        r31.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r31.addUpdateListener(new b(r24));
        AnimatorSet r32 = new AnimatorSet();
        r32.playTogether(new Animator[]{r31, r113});
        r32.addListener(new c(r24));
        r4.playTogether(new Animator[]{r32});
        r4.addListener(new e(r2, r16, r21, r24));
        r4.start();
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L32:
        r14 = false;
    L28:
        r12 = false;
        goto L29
    L20:
        r10 = false;
        goto L21
    L16:
        r9 = r7;
        goto L17
    }
}
