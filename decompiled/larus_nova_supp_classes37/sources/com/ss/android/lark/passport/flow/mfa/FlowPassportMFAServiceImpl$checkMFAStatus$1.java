package com.ss.android.lark.passport.flow.mfa;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowPassportMFAServiceImpl$checkMFAStatus$1", f = "FlowPassportMFAServiceImpl.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
final class FlowPassportMFAServiceImpl$checkMFAStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Integer> $callback;
    final /* synthetic */ String $scope;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ u this$0;

    public FlowPassportMFAServiceImpl$checkMFAStatus$1(u r1, String r2, String r3, IGetDataCallback<Integer> r4, Continuation<? super FlowPassportMFAServiceImpl$checkMFAStatus$1> r5) {
        this.this$0 = r1;
        this.$scope = r2;
        this.$token = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowPassportMFAServiceImpl$checkMFAStatus$1(this.this$0, this.$scope, this.$token, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r2 = 1;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L18:
        u r3 = this.this$0;
        IGetDataCallback<Integer> r4 = this.$callback;
        Throwable r5 = Result.exceptionOrNull-impl(r7);
        if (r5 != null) goto L30;
        int r8 = u.c;
        r3.getClass();
        int r9 = u.b.a[((FlowMfaTokenStatus) r7).ordinal()];
        if (r9 == 1) goto L29;
        r2 = 2;
        if (r9 == 2) goto L29;
        if (r9 != 3) goto L28;
        r2 = 0;
        goto L29
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        Integer r10 = Boxing.boxInt(r2);
        r3.b.post(new w(r4, r10));
    L40:
        return Unit.INSTANCE;
    L30:
        int r11 = u.c;
        r3.getClass();
        if ((r5 instanceof FlowMfaException) == false) goto L33;
        FlowMfaException r12 = (FlowMfaException) r5;
    L34:
        if (r12 == null) goto L37;
        FlowMfaError r13 = r12.getError();
        if (r13 == null) goto L37;
    L38:
        ErrorResult r14 = u.b(r13);
        r3.b.post(new v(r4, r14));
    L37:
        r13 = g.a(r5);
        goto L38
    L33:
        r12 = null;
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowMfaEngine r15 = this.this$0.a;
        String r16 = this.$scope;
        String r17 = "";
        if (r16 != null) goto L11;
        r16 = "";
    L11:
        String r18 = this.$token;
        if (r18 == null) goto L15;
        r17 = r18;
    L15:
        this.label = 1;
        r7 = r15.a(r16, r17, this);
        if (r7 != r0) goto L18;
        return r0;
    }
}
