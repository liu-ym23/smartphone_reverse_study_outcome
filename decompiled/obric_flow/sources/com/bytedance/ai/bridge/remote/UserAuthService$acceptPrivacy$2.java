package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.PrivacyAcceptRequest;
import com.bytedance.ai.utils.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$acceptPrivacy$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserAuthService$acceptPrivacy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2042a;

    public UserAuthService$acceptPrivacy$2(String r5, Continuation r10) {
        this.f2042a = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UserAuthService$acceptPrivacy$2(this.f2042a, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Result<? extends Boolean>> r10) {
        String r11 = this.f2042a;
        return new UserAuthService$acceptPrivacy$2(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        Exception r10 = null;
        new PrivacyAcceptRequest(this.f2042a);     // Catch: Throwable -> L6
        if (b.f2070b.b(a.class) != null) goto L9;
        throw null;     // Catch: Throwable -> L6
    L9:
        throw new ClassCastException();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        String r11 = "acceptPrivacy CRASH: " + th.getMessage() + '\n' + Log.getStackTraceString(th);
        Intrinsics.checkNotNullParameter("UserAuthService", "tag");
        d r12 = c.f2846a;
        if (r12 == null) goto L13;
        r12.e("UserAuthService", r11);
    L13:
        Result.Companion r13 = Result.Companion;
        if ((th instanceof Exception) == false) goto L16;
        r10 = th;
    L16:
        if (r10 != null) goto L19;
        r10 = new Exception(th);
    L19:
        return Result.m123boximpl(Result.m124constructorimpl(ResultKt.createFailure(r10)));
    }
}
