package com.obric.assistant.cocreationreview;

import android.view.View;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$usageCardTemplateRenderer$2$6 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public CocreationReviewActivity$usageCardTemplateRenderer$2$6(Object r8) {
        super(1, r8, CocreationReviewActivity.class, "scheduleFocusedInputVisibilityCheck", "scheduleFocusedInputVisibilityCheck(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        r0.z2(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
