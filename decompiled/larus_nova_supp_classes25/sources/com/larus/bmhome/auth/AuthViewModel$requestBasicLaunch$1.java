package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "data", "Lcom/larus/bmhome/auth/BasicLaunchInfo;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$requestBasicLaunch$1", f = "AuthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AuthViewModel$requestBasicLaunch$1 extends SuspendLambda implements Function2<e0, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AuthViewModel$requestBasicLaunch$1(Continuation<? super AuthViewModel$requestBasicLaunch$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        AuthViewModel$requestBasicLaunch$1 r0 = new AuthViewModel$requestBasicLaunch$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(e0 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        e0 r5 = (e0) this.L$0;
        Gson r0 = z0.a;
        Intrinsics.checkNotNullParameter(r5, "basicLaunchInfo");
        z0.m = r5;
        z0.n("launch_cache_basic_info", r5);
        AppHost.a.getAppClock().d(r5.Y());
        FlowRuntime.a().d(r5.Y());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
