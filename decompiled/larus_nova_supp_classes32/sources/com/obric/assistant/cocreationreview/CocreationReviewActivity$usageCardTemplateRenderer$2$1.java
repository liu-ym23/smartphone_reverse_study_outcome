package com.obric.assistant.cocreationreview;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$usageCardTemplateRenderer$2$1 extends FunctionReferenceImpl implements Function2<String, Vote, Unit> {
    public CocreationReviewActivity$usageCardTemplateRenderer$2$1(Object r8) {
        super(2, r8, CocreationReviewActivity.class, "handleVoteClick", "handleVoteClick(Ljava/lang/String;Lcom/obric/assistant/cocreationreview/Vote;)V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, com.obric.assistant.cocreationreview.CocreationReviewActivity] */
    public final void invoke(String r9, Vote r10) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        ?? r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        Set<String> r1 = CocreationReviewActivity.P1;
        if (r0.C2(r9, "card") == true) goto L41;
        Iterator r2 = ((ArrayList) r0.Y1()).iterator();
    L6:
        Object r3 = null;
        if (r2.hasNext() == false) goto L11;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((a) r4).a(), r9) == false) goto L6;
    L12:
        a r5 = (a) r4;
        if (r5 != null) goto L22;
        Iterator r6 = ((ArrayList) r0.c2()).iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((a) r7).a(), r9) == false) goto L16;
        r3 = r7;
    L20:
        r5 = (a) r3;
    L22:
        if (r5 != null) goto L25;
        int r11 = s3.a;
        s3.c("feedback.panel", "show blocked recordId=" + r9 + ", reason=record_not_found");
        Toast.makeText(r0, "反馈数据不存在", 0).show();
        return;
    L25:
        if (r0.i2(r9) == false) goto L27;
        int r12 = s3.a;
        s3.b("feedback.panel", "show blocked recordId=" + r9 + ", module=" + r5.b().getRaw() + ", reason=feedback_completed");
        return;
    L27:
        l0 r8 = (l0) ((Map) r0.b.getValue()).get(r5.b());
        if (r8 != null) goto L30;
        int r13 = s3.a;
        s3.c("feedback.panel", "show blocked recordId=" + r9 + ", module=" + r5.b().getRaw() + ", reason=feature_missing");
        Toast.makeText(r0, "业务方不可用", 0).show();
        return;
    L30:
        r8.f(r5, r10, new j1(r0, r5, r10), new k1(r0, r5, r10));
        return;
    L11:
        r4 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Vote) r2);
        return Unit.INSTANCE;
    }
}
