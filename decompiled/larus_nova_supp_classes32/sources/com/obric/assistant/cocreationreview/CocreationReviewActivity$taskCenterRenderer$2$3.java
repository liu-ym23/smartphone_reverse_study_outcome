package com.obric.assistant.cocreationreview;

import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CocreationReviewActivity$taskCenterRenderer$2$3 extends FunctionReferenceImpl implements Function1<e4, Unit> {
    public CocreationReviewActivity$taskCenterRenderer$2$3(Object r8) {
        super(1, r8, CocreationReviewActivity.class, "runCenterTask", "runCenterTask(Lcom/obric/assistant/cocreationreview/CocreationTask;)V", 0);
    }

    public final void invoke(e4 r14) {
        Intrinsics.checkNotNullParameter(r14, "p0");
        CocreationReviewActivity r4 = (CocreationReviewActivity) ((CallableReference) this).receiver;
        String r5 = r4.r;
        if (r5 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5, AccountService.a.getUserId()) == false) goto L31;
        q4 r0 = r4.o;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, "task");
        String r6 = null;
        if (r0.g == null) goto L11;
    L26:
        if (r6 == null) goto L32;
        r4.h2();
        r4.o2(false);
        BuildersKt.launch$default(r4.p, null, null, new CocreationReviewActivity$runCenterTask$1(r14, r6, r4, r5, null), 3, null);
        return;
    L32:
        return;
    L11:
        if (r0.a.contains(r14) == false) goto L26;
        Intrinsics.checkNotNullParameter(r14, "task");
        String r1 = r0.d.get(r14.a);
        if (r1 != null) goto L16;
        r1 = r14.b;
    L16:
        String r2 = StringsKt.trim(r1).toString();
        if (r2.length() <= 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == true) goto L23;
        r2 = null;
    L23:
        if (r2 == null) goto L26;
        r0.g = r14.a;
        r6 = r2;
        goto L26
    L19:
        r3 = false;
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((e4) r1);
        return Unit.INSTANCE;
    }
}
