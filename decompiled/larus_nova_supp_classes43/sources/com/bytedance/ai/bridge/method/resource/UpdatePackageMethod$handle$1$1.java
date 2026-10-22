package com.bytedance.ai.bridge.method.resource;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.resource.AIManager;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.resource.UpdatePackageMethod$handle$1$1", f = "UpdatePackageMethod.kt", i = {}, l = {IAPI.OPTION_MULTICAST}, m = "invokeSuspend", n = {}, s = {})
final class UpdatePackageMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h<AbsUpdatePackageMethodIDL.b> $callback;
    final /* synthetic */ AbsUpdatePackageMethodIDL.a $params;
    int label;

    public UpdatePackageMethod$handle$1$1(AbsUpdatePackageMethodIDL.a r1, h<AbsUpdatePackageMethodIDL.b> r10, Continuation<? super UpdatePackageMethod$handle$1$1> r11) {
        this.$params = r1;
        this.$callback = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UpdatePackageMethod$handle$1$1(this.$params, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r11 = 1;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L19
    L13:
        boolean r12 = ((Boolean) r10).booleanValue();     // Catch: Throwable -> L19
        h<AbsUpdatePackageMethodIDL.b> r13 = this.$callback;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(AbsUpdatePackageMethodIDL.b.class, "<this>");     // Catch: Throwable -> L19
        BaseModel r14 = c.a(AbsUpdatePackageMethodIDL.b.class);     // Catch: Throwable -> L19
        AbsUpdatePackageMethodIDL.b r15 = (AbsUpdatePackageMethodIDL.b) r14;     // Catch: Throwable -> L19
        if (r12 == true) goto L17;
        r11 = 0;
    L17:
        r15.setResult(r11);     // Catch: Throwable -> L19
        h.a.b(r13, (ResultModel) r14);     // Catch: Throwable -> L19
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        AIManager r16 = AIManager.a;     // Catch: Throwable -> L19
        String r17 = this.$params.getPackageName();     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r10 = r16.N(r17, this);     // Catch: Throwable -> L19
        if (r10 != r0) goto L13;
        return r0;
    L19:
        th = move-exception;
        h<AbsUpdatePackageMethodIDL.b> r18 = this.$callback;
        String r19 = th.getMessage();
        if (r19 != null) goto L23;
        r19 = "failed to updatePackages with unknown exception";
    L23:
        h.a.a(r18, r19, null, null, 14);
        goto L25
    }
}
