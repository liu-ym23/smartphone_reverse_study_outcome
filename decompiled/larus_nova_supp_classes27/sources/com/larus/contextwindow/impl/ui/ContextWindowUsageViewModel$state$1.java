package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/larus/contextwindow/impl/ui/ContextWindowPanelState;", "latestContextSnapshot", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "isContextCompressing", "", "repositoryState", "Lcom/larus/contextwindow/impl/membership/MembershipQuotaRepositoryState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.ui.ContextWindowUsageViewModel$state$1", f = "ContextWindowUsageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContextWindowUsageViewModel$state$1 extends SuspendLambda implements Function4<ContextWindowSnapshot, Boolean, com.larus.contextwindow.impl.membership.h, Continuation<? super a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    public ContextWindowUsageViewModel$state$1(Continuation<? super ContextWindowUsageViewModel$state$1> r2) {
        super(4, r2);
    }

    public final Object invoke(ContextWindowSnapshot r2, boolean r3, com.larus.contextwindow.impl.membership.h r4, Continuation<? super a> r5) {
        ContextWindowUsageViewModel$state$1 r0 = new ContextWindowUsageViewModel$state$1(r5);
        r0.L$0 = r2;
        r0.Z$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((ContextWindowSnapshot) r1, ((Boolean) r2).booleanValue(), (com.larus.contextwindow.impl.membership.h) r3, (Continuation) r4);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r4);
        ContextWindowSnapshot r5 = (ContextWindowSnapshot) this.L$0;
        boolean r0 = this.Z$0;
        com.larus.contextwindow.impl.membership.h r1 = (com.larus.contextwindow.impl.membership.h) this.L$1;
        int r2 = b.a;
        if (r0 == true) goto L7;
    L9:
        boolean r3 = false;
    L11:
        return b.a(r5, r1, r3);
    L7:
        if (r5.k == false) goto L9;
        r3 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
