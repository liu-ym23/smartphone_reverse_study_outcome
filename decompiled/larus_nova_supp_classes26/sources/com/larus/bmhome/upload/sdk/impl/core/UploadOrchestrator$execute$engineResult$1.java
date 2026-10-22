package com.larus.bmhome.upload.sdk.impl.core;

import is8.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "progress", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator$execute$engineResult$1", f = "UploadOrchestrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UploadOrchestrator$execute$engineResult$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $registry;
    final /* synthetic */ is8.a $route;
    final /* synthetic */ String $taskId;
    /* synthetic */ int I$0;
    int label;

    public UploadOrchestrator$execute$engineResult$1(e r1, String r2, is8.a r3, Continuation<? super UploadOrchestrator$execute$engineResult$1> r4) {
        this.$registry = r1;
        this.$taskId = r2;
        this.$route = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        UploadOrchestrator$execute$engineResult$1 r0 = new UploadOrchestrator$execute$engineResult$1(this.$registry, this.$taskId, this.$route, r6);
        r0.I$0 = ((Number) r5).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        int r6 = this.I$0;
        this.$registry.a(this.$taskId, new j.h(r6, this.$route));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
