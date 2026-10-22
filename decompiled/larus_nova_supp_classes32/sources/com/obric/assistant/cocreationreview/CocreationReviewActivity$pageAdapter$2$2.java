package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$pageAdapter$2$2 extends FunctionReferenceImpl implements Function1<p5, Unit> {
    public CocreationReviewActivity$pageAdapter$2$2(Object r8) {
        super(1, r8, CocreationReviewActivity.class, "selectModuleTab", "selectModuleTab(Lcom/obric/assistant/cocreationreview/ModuleTabState;)V", 0);
    }

    public final void invoke(p5 r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        CocreationReviewActivity r0 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        if (r0.C == r5.d) goto L18;
        int r1 = s3.a;
        StringBuilder r2 = new StringBuilder("selectModule from=");
        ModuleKey r3 = r0.C;
        String r4 = "all";
        if (r3 == null) goto L9;
        String r6 = r3.getRaw();
        if (r6 == null) goto L9;
    L10:
        r2.append(r6);
        r2.append(" to=");
        ModuleKey r7 = r5.d;
        if (r7 == null) goto L16;
        String r8 = r7.getRaw();
        if (r8 == null) goto L16;
        r4 = r8;
    L16:
        r2.append(r4);
        r2.append(", count=");
        r2.append(r5.e);
        s3.b("ui.action", r2.toString());
        r0.C = r5.d;
        r0.o2(false);
        return;
    L9:
        r6 = "all";
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((p5) r1);
        return Unit.INSTANCE;
    }
}
