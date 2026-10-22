package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenterUploadDelegate$onUploadSuccess$1", f = "ResourceCenterUploadDelegate.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class ResourceCenterUploadDelegate$onUploadSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l $uploadResult;
    int label;
    final /* synthetic */ ResourceCenterUploadDelegate this$0;

    public ResourceCenterUploadDelegate$onUploadSuccess$1(ResourceCenterUploadDelegate r1, l r2, Continuation<? super ResourceCenterUploadDelegate$onUploadSuccess$1> r3) {
        this.this$0 = r1;
        this.$uploadResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResourceCenterUploadDelegate$onUploadSuccess$1(this.this$0, this.$uploadResult, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        ResourceRegisterData r13 = (ResourceRegisterData) r12;
        if (r13 == null) goto L20;
        Function1<l, Unit> r3 = this.this$0.c.a;     // Catch: Throwable -> L16
        String r4 = r13.getResourceId();     // Catch: Throwable -> L16
        String r14 = r13.getAliasName();     // Catch: Throwable -> L16
        r3.invoke(l.a(this.$uploadResult, null, r14, r4, 121));     // Catch: Throwable -> L16
        ms8.b r15 = ms8.b.a;
        ms8.b.g(r15, this.this$0.b.a, "callback_success", "success", null, null, 56);
        ms8.b.d(r15, this.this$0.b.a, "success", null, 12);
    L16:
        th = move-exception;
        ms8.b r10 = ms8.b.a;
        ms8.b.g(r10, this.this$0.b.a, "callback_success", "success", null, null, 56);
        ms8.b.d(r10, this.this$0.b.a, "success", null, 12);
        throw th;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ResourceCenterUploadDelegate r16 = this.this$0;
        l r5 = this.$uploadResult;
        this.label = 1;
        r12 = ResourceCenterUploadDelegate.d(r16, r5, this);
        if (r12 != r1) goto L11;
        return r1;
    }
}
