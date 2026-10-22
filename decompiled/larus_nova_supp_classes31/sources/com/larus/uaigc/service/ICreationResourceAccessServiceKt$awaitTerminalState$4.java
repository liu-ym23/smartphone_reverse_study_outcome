package com.larus.uaigc.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.ICreationResourceAccessServiceKt$awaitTerminalState$4", f = "ICreationResourceAccessService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ICreationResourceAccessServiceKt$awaitTerminalState$4 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.e, Unit> $onRunning;
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.f, Unit> $onUploading;
    /* synthetic */ Object L$0;
    int label;

    public ICreationResourceAccessServiceKt$awaitTerminalState$4(Function1<? super com.larus.bmhome.resource.access.a0.e, Unit> r1, Function1<? super com.larus.bmhome.resource.access.a0.f, Unit> r2, Continuation<? super ICreationResourceAccessServiceKt$awaitTerminalState$4> r3) {
        this.$onRunning = r1;
        this.$onUploading = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ICreationResourceAccessServiceKt$awaitTerminalState$4 r0 = new ICreationResourceAccessServiceKt$awaitTerminalState$4(this.$onRunning, this.$onUploading, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(com.larus.bmhome.resource.access.a0 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.bmhome.resource.access.a0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r2);
        com.larus.bmhome.resource.access.a0 r3 = (com.larus.bmhome.resource.access.a0) this.L$0;
        if ((r3 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L8;
        this.$onRunning.invoke(r3);
    L22:
        return Unit.INSTANCE;
    L8:
        if ((r3 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L11;
        this.$onUploading.invoke(r3);
        goto L22
    L11:
        if (Intrinsics.areEqual(r3, com.larus.bmhome.resource.access.a0.b.a) == true) goto L22;
        if ((r3 instanceof com.larus.bmhome.resource.access.a0.d) == true) goto L22;
        if ((r3 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L22;
        if ((r3 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L22;
        throw new NoWhenBranchMatchedException();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
