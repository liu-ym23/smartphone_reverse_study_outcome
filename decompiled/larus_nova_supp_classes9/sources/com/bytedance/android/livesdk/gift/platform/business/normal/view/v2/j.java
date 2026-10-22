package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.configmodel.v2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.v3;
import com.bytedance.android.livesdk.gift.platform.business.anchor.AnchorTrayPostEffectService;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.o7;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Runnable {
    public final /* synthetic */ NormalGiftCombViewV2 a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NormalGiftCombViewV2 r3 = this.a.a;
            s02.c r0 = r3.e;
            if (r0 == null) goto L6;
            r0.b(r3.f);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NormalGiftCombViewV2 r3 = this.a.a;
            s02.c r0 = r3.e;
            if (r0 == null) goto L6;
            r0.b(r3.f);
            return;
        }
    }

    public j(NormalGiftCombViewV2 r1) {
        this.a = r1;
    }

    public final void a() {
        i12.e r1 = i12.o.b();
        a5 r2 = null;
        if (r1 == null) goto L5;
        Object r3 = com.bytedance.android.scope.m.e.d(r1, AnchorTrayPostEffectService.class);
    L6:
        AnchorTrayPostEffectService r4 = (AnchorTrayPostEffectService) r3;
        if (r4 == null) goto L26;
        u3 r5 = this.a.A;
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf(r5.getPostEffectSource());
    L12:
        if (r6 != null) goto L15;
    L25:
        boolean r7 = false;
    L27:
        u3 r8 = this.a.A;
        if (r8 == null) goto L30;
        Integer r9 = Integer.valueOf(r8.getPostEffectSource());
    L31:
        v2 r10 = l.a;
        if ((!CollectionsKt.contains((List) com.bytedance.android.livesdk.gift.platform.business.e.v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[20]), r9)) == false) goto L97;
        u3 r11 = this.a.A;
        if (r11 == null) goto L97;
        if (v3.a(r11) != true) goto L97;
        if (r7 == false) goto L97;
        i12.e r13 = i12.o.b();
        if (r13 == null) goto L41;
        Object r14 = com.bytedance.android.scope.m.e.d(r13, AnchorTrayPostEffectService.class);
    L42:
        AnchorTrayPostEffectService r15 = (AnchorTrayPostEffectService) r14;
        if (r15 == null) goto L65;
        u3 r16 = this.a.A;
        if (r16 == null) goto L47;
        Integer r17 = Integer.valueOf(r16.getPostEffectSource());
    L48:
        if (r17 == null) goto L65;
        if (com.bytedance.android.livesdk.gift.platform.business.anchor.c.a().b() == false) goto L65;
        if (r15.a.get() == false) goto L56;
        r15.a.set(false);
        goto L65
    L56:
        r15.a.set(true);
        com.bytedance.android.livesdk.gift.platform.business.anchor.e r18 = (com.bytedance.android.livesdk.gift.platform.business.anchor.e) ((Map) r15.b.getValue()).get(r17);
        if (r18 == null) goto L65;
        Disposable r19 = r18.b;
        if (r19 == null) goto L61;
        r19.dispose();
    L61:
        long r20 = r18.c;
        if (r20 == 0) goto L65;
        r18.a = true;
        r18.b = Observable.timer(r20, TimeUnit.SECONDS, Schedulers.io()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.anchor.d(r18));
        goto L65
    L47:
        r17 = null;
    L65:
        u3 r21 = this.a.A;
        if (r21 == null) goto L96;
        py.k r23 = r21.getPostEffectImg();
        if (r23 == null) goto L96;
        if (r23.isValid() == true) goto L73;
        r23 = null;
    L73:
        if (r23 == null) goto L96;
        HSImageView r24 = this.a.o(2131370475);
        if (r24 == null) goto L77;
        r24.setOnClickListener(new a(this));
    L77:
        GiftIconMaskView r25 = (GiftIconMaskView) this.a.o(2131373725);
        if (r25 == null) goto L80;
        r25.setOnClickListener(new b(this));
    L80:
        NormalGiftMessage r26 = this.a.f;
        if (r26 == null) goto L87;
        o7 r27 = r26.r();
        if (r27 == null) goto L87;
        o0 r28 = r27.getTrayInfo();
        if (r28 == null) goto L87;
        r28.setTrayPostEffect(this.a.A);
    L87:
        NormalGiftCombViewV2 r29 = this.a;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a r30 = r29.R;
        NormalGiftMessage r110 = r29.f;
        u3 r31 = r29.A;
        if (r31 == null) goto L90;
        r2 = r31.getPostEffectSubtitle();
    L90:
        r30.getClass();
        Intrinsics.checkNotNullParameter(r23, "exitWebp");
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.f r33 = r30.l;
        if (r33 == null) goto L93;
        r33.c();
    L93:
        HSImageView r34 = r30.d;
        View r111 = r30.f;
        View r112 = r30.h;
        View r113 = r30.g;
        ViewGroup r114 = r30.b;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.f r115 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.f(r34, r111, r112, r113, r114, r30.e, r30.i, r110);
        r30.l = r115;
        Intrinsics.checkNotNullParameter(r23, "exitWebp");
        ObjectAnimator r35 = ObjectAnimator.ofFloat(r113, "scaleX", new float[]{1.0f, 0.0f});
        ObjectAnimator r36 = ObjectAnimator.ofFloat(r113, "scaleY", new float[]{1.0f, 0.0f});
        ObjectAnimator r37 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r38 = ObjectAnimator.ofFloat(r112, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r39 = new AnimatorSet();
        r39.playTogether(new Animator[]{r35, r36, r37, r38});
        r39.setDuration(250);
        Unit r40 = Unit.INSTANCE;
        r115.b = r39;
        r39.start();
        if (r114 == null) goto L96;
        r114.postDelayed(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.i(r115, r23, r2), 150);
    L96:
        j r0 = this;
    L100:
        s02.a r41 = r0.a.n;
        if (r41 == null) goto L104;
        r41.a();
        return;
    L104:
        return;
    L41:
        r14 = null;
    L97:
        r0 = this;
        NormalGiftCombViewV2 r43 = r0.a;
        r43.c = r43.m.c(r43, r43.G);
        Animator r44 = r0.a.c;
        if (r44 == null) goto L100;
        r44.start();
        goto L100
    L30:
        r9 = null;
        goto L31
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.anchor.c.a().b() == false) goto L26;
        com.bytedance.android.livesdk.gift.platform.business.anchor.e r45 = (com.bytedance.android.livesdk.gift.platform.business.anchor.e) ((Map) r4.b.getValue()).get(r6);
        if (r45 == null) goto L20;
        boolean r46 = r45.a;
    L22:
        if (r4.a.get() == true) goto L25;
        if (r46 == true) goto L25;
    L20:
        r46 = false;
        goto L22
    L11:
        r6 = null;
    L26:
        r7 = true;
        goto L27
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
