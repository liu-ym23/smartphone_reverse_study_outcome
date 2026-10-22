package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.lark.kmp.logger.LarkLogger;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class WaitConditionInterceptor implements com.lark.kmp.rustclient.api.g {
    public final CoroutineDispatcher a;
    public final MutexImpl b;
    public final buc.e<List<Function1<Continuation<? super Unit>, Object>>> c;

    public static final class a {
    }

    static {
    }

    public WaitConditionInterceptor() {
        this(0);
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Object b(com.lark.kmp.rustclient.api.h<Resp> r1, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r2) {
        return d(this, r1, r2);
    }

    public abstract <T> boolean c(com.lark.kmp.rustclient.api.a<T> r1);

    public WaitConditionInterceptor(int r2) {
        CoroutineDispatcher r3 = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        this.a = r3;
        this.b = kotlinx.coroutines.sync.b.a();
        this.c = buc.b.d(CollectionsKt.emptyList());
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(com.lark.kmp.rustclient.api.h<Resp> r3) {
        Intrinsics.checkNotNullParameter(r3, "chain");
        return new c1(new WaitConditionInterceptor$interceptEnqueue$1(this, r3, null));
    }

    public final Object e(Continuation<? super Unit> r8) {
        if ((r8 instanceof WaitConditionInterceptor$notifyConditionSatisfied$1) == false) goto L7;
        WaitConditionInterceptor$notifyConditionSatisfied$1 r0 = (WaitConditionInterceptor$notifyConditionSatisfied$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L25:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        r5.element = this.c.b(CollectionsKt.emptyList());     // Catch: Throwable -> L26
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r4.unlock(null);
        LarkLogger r11 = LarkLogger.a;
        LarkLogger.c("WaitConditionInterceptor", "notifyConditionSatisfied, flushing " + ((List) r5.element).size() + " requests");
        WaitConditionInterceptor$notifyConditionSatisfied$3 r12 = new WaitConditionInterceptor$notifyConditionSatisfied$3(r5, this, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (CoroutineScopeKt.coroutineScope(r12, r0) != r2) goto L25;
        return r2;
    L26:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r9);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r4 = this.b;
        r0.L$0 = r13;
        r0.L$1 = r4;
        r0.label = 1;
        if (r4.a(null, r0) != r2) goto L19;
        return r2;
    L19:
        r5 = r13;
    L7:
        r0 = new WaitConditionInterceptor$notifyConditionSatisfied$1(this, r8);
        goto L8
    }

    public static <Resp> Object d(WaitConditionInterceptor r8, com.lark.kmp.rustclient.api.h<Resp> r9, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r10) {
        if ((r10 instanceof WaitConditionInterceptor$intercept$1) == false) goto L7;
        WaitConditionInterceptor$intercept$1 r0 = (WaitConditionInterceptor$intercept$1) r10;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L25:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.lark.kmp.rustclient.api.h<Resp> r12 = (com.lark.kmp.rustclient.api.h) r0.L$1;
        WaitConditionInterceptor r13 = (WaitConditionInterceptor) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r9 = r12;
        r8 = r13;
    L18:
        if (r8.c(r9.c) == true) goto L22;
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.label = 1;
        if (DelayKt.delay(50, r0) != r2) goto L18;
        return r2;
    L22:
        com.lark.kmp.rustclient.api.a<Resp> r14 = r9.c;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r11 = r9.a(r14, r0);
        if (r11 != r2) goto L25;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
    L7:
        r0 = new WaitConditionInterceptor$intercept$1(r8, r10);
        goto L8
    }
}
