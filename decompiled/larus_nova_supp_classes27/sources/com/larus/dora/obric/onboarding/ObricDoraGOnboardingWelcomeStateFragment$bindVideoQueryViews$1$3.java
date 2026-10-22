package com.larus.dora.obric.onboarding;

import android.view.animation.DecelerateInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricDoraGOnboardingWelcomeStateFragment$bindVideoQueryViews$1$3 extends FunctionReferenceImpl implements Function2<Integer, Boolean, Unit> {
    public ObricDoraGOnboardingWelcomeStateFragment$bindVideoQueryViews$1$3(Object r8) {
        super(2, r8, ObricDoraGOnboardingWelcomeStateFragment.class, "updateSceneImage", "updateSceneImage(IZ)V", 0);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.ImageView, com.larus.dora.obric.onboarding.BottomFadeImageView] */
    /* JADX WARN: Type inference failed for: r9v11, types: [android.widget.ImageView, com.larus.dora.obric.onboarding.BottomFadeImageView] */
    public final void invoke(int r8, boolean r9) {
        ObricDoraGOnboardingWelcomeStateFragment r0 = (ObricDoraGOnboardingWelcomeStateFragment) ((CallableReference) this).receiver;
        ObricDoraGOnboardingWelcomeStateFragment.b r1 = r0.R;
        if (r1 == null) goto L20;
        String[] r2 = r0.p1;
        String r3 = r2[r8 % r2.length];
        z1 r10 = (z1) CollectionsKt.getOrNull((List) r0.v1.getValue(), r8);
        if (r10 == null) goto L8;
        String r11 = r10.c;
    L9:
        List<BottomFadeImageView> r4 = r1.b;
        if (r9 == true) goto L16;
        r0.S = 0;
        Iterator<T> r12 = r4.iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        ((BottomFadeImageView) r12.next()).animate().cancel();
        goto L13
    L15:
        ?? r13 = (BottomFadeImageView) ListProtector.get(r4, r0.S);
        r13.f(r11, r3);
        r13.setAlpha(1.0f);
        ((BottomFadeImageView) ListProtector.get(r4, 1)).setAlpha(0.0f);
        return;
    L16:
        SimpleDraweeView r14 = (BottomFadeImageView) ListProtector.get(r4, r0.S);
        int r6 = (r0.S + 1) % r4.size();
        ?? r5 = (BottomFadeImageView) ListProtector.get(r4, r6);
        r14.animate().cancel();
        r5.animate().cancel();
        r14.setAlpha(1.0f);
        r5.f(r11, r3);
        r5.setAlpha(0.0f);
        r5.animate().alpha(1.0f).setDuration(100).setInterpolator(new DecelerateInterpolator()).start();
        r14.animate().alpha(0.0f).setDuration(100).setInterpolator(new DecelerateInterpolator()).start();
        r0.S = r6;
        return;
    L8:
        r11 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
