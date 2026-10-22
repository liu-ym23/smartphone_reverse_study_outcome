package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.h1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.showcase.Case;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.CaseListScreenMenuManager$deleteCase$1", f = "CaseListScreenMenuManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
final class CaseListScreenMenuManager$deleteCase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Case $case;
    int label;

    public CaseListScreenMenuManager$deleteCase$1(Case r1, Continuation<? super CaseListScreenMenuManager$deleteCase$1> r2) {
        this.$case = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaseListScreenMenuManager$deleteCase$1(this.$case, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L17:
        Boolean r5 = (Boolean) r4;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L19;
        r6.h0();
        h1 r7 = h1.a;
        Case r2 = this.$case;
        if (r2 == null) goto L13;
        String r3 = r2.getCaseId();
    L14:
        this.label = 1;
        r4 = r7.b(r3, this);
        if (r4 != r0) goto L17;
        return r0;
    L13:
        r3 = null;
        goto L14
    }
}
