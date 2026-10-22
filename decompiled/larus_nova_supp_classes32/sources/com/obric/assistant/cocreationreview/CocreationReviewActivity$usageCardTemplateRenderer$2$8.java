package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$usageCardTemplateRenderer$2$8 extends FunctionReferenceImpl implements Function2<String, Integer, Unit> {
    public CocreationReviewActivity$usageCardTemplateRenderer$2$8(Object r8) {
        super(2, r8, CocreationReviewActivity.class, "handleFeedbackValueSelect", "handleFeedbackValueSelect(Ljava/lang/String;Ljava/lang/Integer;)V", 0);
    }

    public final void invoke(final String r5, final Integer r6) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        if (r6 == null) goto L10;
        r0.getClass();
        if (r6.intValue() >= 0) goto L7;
    L8:
        int r7 = s3.a;
        s3.c("draft.action", "feedbackValue rejected recordId=" + r5 + ", outOfRange=true");
        return;
    L7:
        if (r6.intValue() > 9999) goto L8;
    L10:
        if (r0.i2(r5) == false) goto L13;
        int r8 = s3.a;
        s3.b("draft.action", "feedbackValue blocked recordId=" + r5 + ", reason=feedback_completed");
        return;
    L13:
        if (r0.B == ReviewMode.HISTORY) goto L19;
        r0.K2(r5, true, "feedback_value", new v2(r5, r6));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Integer) r2);
        return Unit.INSTANCE;
    }
}
