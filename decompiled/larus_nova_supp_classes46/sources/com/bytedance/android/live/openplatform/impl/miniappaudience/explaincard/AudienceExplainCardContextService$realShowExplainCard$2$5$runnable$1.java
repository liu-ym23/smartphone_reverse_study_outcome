package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.utils.z0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 implements Runnable {
    public final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2.AnonymousClass5 a;
    public final /* synthetic */ w b;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s {
        public final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 a;
        public final /* synthetic */ boolean b;

        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            AudienceExplainCardContextService r5 = this.a.a.this$0.this$0;
            int r0 = AudienceExplainCardContextService.h;
            ((AudienceMiniAppAppLogContextService) r5.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLivePopupCardShowAnimEnd(this.a.a.this$0.$isFromEnter, false, ExplainCardAnimType.SELF_CARD);
            if (this.b == false) goto L5;
            this.a.a.this$0.$widget.q(160, new AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1$1$onAnimationEnd$1(this));
            return;
        L5:
            this.a.a.this$0.$widget.g.f();
            this.a.b.b();
        }

        public AnonymousClass1(AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1(AudienceExplainCardContextService$realShowExplainCard$2.AnonymousClass5 r1, w r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        AudienceExplainCardContextService$realShowExplainCard$2 r0 = this.a.this$0;
        AudienceExplainCardContextService r1 = r0.this$0;
        boolean r2 = r0.$isFromEnter;
        int r3 = AudienceExplainCardContextService.h;
        r1.getClass();
        float r4 = z0.b(false);
        if (r2 == true) goto L5;
    L8:
        boolean r5 = true;
    L9:
        ((AudienceMiniAppAppLogContextService) this.a.this$0.this$0.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLivePopupCardShowAnimStart(this.a.this$0.$isFromEnter, false, ExplainCardAnimType.SELF_CARD);
        AudienceExplainCardWidget r6 = this.a.this$0.$widget;
        AnonymousClass1 r9 = new AnonymousClass1(this, r5);
        r6.getClass();
        HashMap<String, zo0.f> r7 = zo0.g.a;
        zo0.f r8 = h.b(PerformanceScene.EXPLAIN_CARD);
        int r10 = zo0.f.d;
        r8.l("card_anim_start", null);
        r6.g();
        if (r5 == true) goto L12;
        r6.g.setScaleX(1.0f);
        r6.g.setScaleY(1.0f);
        r6.g.setAlpha(1.0f);
        r6.g.post(new c(r6));
        r9.onAnimationEnd(new AnimatorSet());
        return;
    L12:
        Animator r11 = r6.j(250, TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(1.03f)), 140, TuplesKt.to(Float.valueOf(1.03f), Float.valueOf(1.0f)));
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r6.g, "alpha", new float[]{0.0f, 1.0f});
        r12.setDuration(250);
        AnimatorSet r13 = new AnimatorSet();
        r13.play(r11).with(r12);
        r13.setInterpolator(new AccelerateInterpolator());
        Unit r14 = Unit.INSTANCE;
        r6.d = r13;
        if (((wc1) de0.a.getValue()).g() == false) goto L15;
        r6.t(r9);
        return;
    L15:
        r6.g.post(new d(r6, r9));
        return;
    L5:
        if (r4 > ((wc1) de0.a.getValue()).a()) goto L8;
        r5 = false;
        goto L9
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
