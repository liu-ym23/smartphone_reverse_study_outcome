package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/w;", "", "invoke", "(Lcom/bytedance/android/live/openplatform/impl/base/utils/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class AudienceExplainCardContextService$realShowExplainCard$2 extends Lambda implements Function1<w, Unit> {
    final /* synthetic */ boolean $isFromEnter;
    final /* synthetic */ boolean $isHighIntentionTrigger;
    final /* synthetic */ ShelfInfo $shelfInfo;
    final /* synthetic */ AudienceExplainCardWidget $widget;
    final /* synthetic */ AudienceExplainCardContextService this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$realShowExplainCard$2$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/w;", "", "invoke", "(Lcom/bytedance/android/live/openplatform/impl/base/utils/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass5 extends Lambda implements Function1<w, Unit> {
        final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2 this$0;

        public AnonymousClass5(AudienceExplainCardContextService$realShowExplainCard$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(w r5) {
            Intrinsics.checkNotNullParameter(r5, "$receiver");
            final AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1 r0 = new AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1(this, r5);
            if (((wc1) de0.a.getValue()).g() == false) goto L6;
            r0.run();
            return;
        L6:
            if (this.this$0.$widget.g.getWidth() != 0) goto L8;
        L11:
            this.this$0.$widget.q(0, new AnonymousClass1(r0));
            return;
        L8:
            if (this.this$0.$widget.g.getHeight() == 0) goto L11;
            r0.run();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((w) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$realShowExplainCard$2$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/w;", "", "invoke", "(Lcom/bytedance/android/live/openplatform/impl/base/utils/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass6 extends Lambda implements Function1<w, Unit> {
        final /* synthetic */ AudienceExplainCardContextService$realShowExplainCard$2 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.AudienceExplainCardContextService$realShowExplainCard$2$6$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s {
            public final /* synthetic */ AnonymousClass6 a;
            public final /* synthetic */ w b;

            public final void onAnimationEnd(Animator r4) {
                Intrinsics.checkNotNullParameter(r4, "animation");
                this.a.this$0.$widget.q(160, new AudienceExplainCardContextService$realShowExplainCard$2$6$2$onAnimationEnd$1(this));
            }

            public AnonymousClass2(AnonymousClass6 r1, w r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public AnonymousClass6(AudienceExplainCardContextService$realShowExplainCard$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(w r9) {
            Intrinsics.checkNotNullParameter(r9, "$receiver");
            this.this$0.$widget.g.e(true);
            this.this$0.$widget.setSupplementInfo(null);
            AudienceExplainCardWidget r0 = this.this$0.$widget;
            final Function0<Unit> r2 = new AnonymousClass1(this);
            AnonymousClass2 r3 = new AnonymousClass2(this, r9);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r2, "onHalf");
            HashMap<String, zo0.f> r10 = zo0.g.a;
            zo0.f r11 = h.b(PerformanceScene.EXPLAIN_CARD);
            int r4 = zo0.f.d;
            r11.l("card_anim_start", null);
            r0.g();
            ObjectAnimator r12 = ObjectAnimator.ofFloat(r0.g, "scaleX", new float[]{1.0f, 0.0f, 1.0f});
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r0.g, "scaleY", new float[]{1.0f, 0.0f, 1.0f});
            ObjectAnimator r1 = ObjectAnimator.ofFloat(r0.g, "alpha", new float[]{1.0f, 0.0f, 1.0f});
            AnimatorSet r6 = new AnimatorSet();
            r6.play(r12).with(r5).with(r1);
            r6.setDuration(240);
            r6.setInterpolator(new DecelerateInterpolator());
            Unit r13 = Unit.INSTANCE;
            r0.d = r6;
            r0.q(240 / ((long) 2), new AudienceExplainCardWidget$quickShowCard$2(r2));
            r0.q(0, new AudienceExplainCardWidget$quickShowCard$3(r0, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((w) r1);
            return Unit.INSTANCE;
        }
    }

    public AudienceExplainCardContextService$realShowExplainCard$2(AudienceExplainCardContextService r1, AudienceExplainCardWidget r2, boolean r3, ShelfInfo r4, boolean r5) {
        this.this$0 = r1;
        this.$widget = r2;
        this.$isHighIntentionTrigger = r3;
        this.$shelfInfo = r4;
        this.$isFromEnter = r5;
        super(1);
    }

    public final void invoke(w r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        qo0.a.c("AudienceExplainCardContextService", "show explain card");
        if (this.$widget.b == true) goto L6;
        r4.a("load widget", new AnonymousClass1(this));
    L6:
        if (this.$widget.c == true) goto L13;
        r4.a("show widget", new AnonymousClass2(this));
        r4.a("setup explain card info", new AnonymousClass3(this));
        if (this.$isFromEnter == true) goto L10;
    L11:
        r4.a("show toolbar anim", new AnonymousClass4(this));
    L12:
        r4.a("show explain card", new AnonymousClass5(this));
    L14:
        r4.b();
        return;
    L10:
        if (((wc1) de0.a.getValue()).d() == true) goto L12;
    L13:
        r4.a("quick show explain card", new AnonymousClass6(this));
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((w) r1);
        return Unit.INSTANCE;
    }
}
