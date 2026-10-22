package com.bytedance.ai.bridge.method.login;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod$fetchLoginCode$result$1", f = "LoginMethod.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class LoginMethod$fetchLoginCode$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1847b;

    public LoginMethod$fetchLoginCode$result$1(String r5, Continuation r10) {
        this.f1847b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new LoginMethod$fetchLoginCode$result$1(this.f1847b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Result<? extends String>> r10) {
        String r11 = this.f1847b;
        return new LoginMethod$fetchLoginCode$result$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f1846a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r12 = ((Result) r5).m133unboximpl();
    L12:
        return Result.m123boximpl(r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.bytedance.ai.bridge.remote.b r13 = com.bytedance.ai.bridge.remote.b.f2069a;
        String r14 = this.f1847b;
        this.f1846a = 1;
        r12 = com.bytedance.ai.bridge.remote.b.e(r14, this, 14);
        if (r12 != r10) goto L12;
        return r10;
    }
}
