package com.bytedance.ai.bridge.method.resource;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.resource.j;
import com.lynx.tasm.behavior.ui.utils.e;
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
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.resource.UpdatePackageMethod$handle$1$1", f = "UpdatePackageMethod.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class UpdatePackageMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsUpdatePackageMethodIDL.UpdatePackageParamModel f1907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f1908c;

    public UpdatePackageMethod$handle$1$1(AbsUpdatePackageMethodIDL.UpdatePackageParamModel r5, f r10, Continuation r11) {
        this.f1907b = r5;
        this.f1908c = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UpdatePackageMethod$handle$1$1(this.f1907b, this.f1908c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        AbsUpdatePackageMethodIDL.UpdatePackageParamModel r11 = this.f1907b;
        f r12 = this.f1908c;
        return new UpdatePackageMethod$handle$1$1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f1906a;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        boolean r12 = ((Boolean) r5).booleanValue();     // Catch: Throwable -> L7
        f r13 = this.f1908c;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(AbsUpdatePackageMethodIDL.UpdatePackageResultModel.class, "<this>");     // Catch: Throwable -> L7
        BaseModel r14 = e.c(AbsUpdatePackageMethodIDL.UpdatePackageResultModel.class);     // Catch: Throwable -> L7
        ((AbsUpdatePackageMethodIDL.UpdatePackageResultModel) r14).setResult(r12 ? 1 : 0);     // Catch: Throwable -> L7
        r13.b((ResultModel) r14, "");     // Catch: Throwable -> L7
    L22:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        j r15 = j.f2734a;     // Catch: Throwable -> L7
        String r16 = this.f1907b.getPackageName();     // Catch: Throwable -> L7
        this.f1906a = 1;     // Catch: Throwable -> L7
        r5 = r15.g(r16, this);     // Catch: Throwable -> L7
        if (r5 != r10) goto L15;
        return r10;
    L7:
        th = move-exception;
        f r17 = this.f1908c;
        String r18 = th.getMessage();
        if (r18 != null) goto L20;
        r18 = "failed to updatePackages with unknown exception";
    L20:
        r17.a(r18);
        goto L22
    }
}
