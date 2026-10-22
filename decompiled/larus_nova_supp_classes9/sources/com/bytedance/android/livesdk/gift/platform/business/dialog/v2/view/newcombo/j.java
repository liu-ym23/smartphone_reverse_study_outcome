package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends o12.b {
    public final /* synthetic */ ComboProgressAnimationViewNew a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public static final class a implements Runnable {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComboProgressAnimationViewNew r0 = this.a.a;     // Catch: Throwable -> L4
            int r1 = ComboProgressAnimationViewNew.A;     // Catch: Throwable -> L4
            r0.i(100, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        ComboProgressAnimationViewNew r5 = this.a;
        if (r5.g == false) goto L11;
        if (this.c == false) goto L11;
        int r0 = GiftManagerKt.s().size();
        if (r0 <= 0) goto L11;
        ImageLoader.bindImage(r5.x, ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r0 - 1)).comboEffectImg, new i(r5));
    L11:
        if (this.b == false) goto L14;
        this.a.f = false;
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3, r4);
        ComboProgressAnimationViewNew r5 = this.a;
        int r6 = ComboProgressAnimationViewNew.A;
        r5.getClass();
        if (this.b == false) goto L5;
        this.a.f = true;
    L5:
        HSImageView r7 = this.a.x;
        if (r7 == null) goto L9;
        r7.postDelayed(new a(this), 1100);
        return;
    }

    public j(ComboProgressAnimationViewNew r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
