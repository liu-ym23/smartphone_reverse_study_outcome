package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$usageCardTemplateRenderer$2$2 extends AdaptedFunctionReference implements Function2<String, String, Unit> {
    public CocreationReviewActivity$usageCardTemplateRenderer$2$2(Object r8) {
        super(2, r8, CocreationReviewActivity.class, "toggleReason", "toggleReason(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", 0);
    }

    public final void invoke(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        Intrinsics.checkNotNullParameter(r5, "p1");
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((AdaptedFunctionReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        r0.getClass();
        r0.K2(r4, true, "reason", new h1(r5, r4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
