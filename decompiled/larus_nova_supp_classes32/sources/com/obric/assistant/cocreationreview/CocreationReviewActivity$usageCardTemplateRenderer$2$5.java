package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$usageCardTemplateRenderer$2$5 extends AdaptedFunctionReference implements Function1<z4.a, Unit> {
    public CocreationReviewActivity$usageCardTemplateRenderer$2$5(Object r8) {
        super(1, r8, CocreationReviewActivity.class, "showDetailView", "showDetailView(Lcom/obric/assistant/cocreationreview/DetailView$Content;I)V", 0);
    }

    public final void invoke(z4.a r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((AdaptedFunctionReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        r0.E2(r3, 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((z4.a) r1);
        return Unit.INSTANCE;
    }
}
