package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowPassportMFAServiceImpl$startMFA$1", f = "FlowPassportMFAServiceImpl.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_NO_MORE_FOOTER}, m = "invokeSuspend", n = {}, s = {})
final class FlowPassportMFAServiceImpl$startMFA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<String> $callback;
    final /* synthetic */ Activity $context;
    final /* synthetic */ JSONObject $customParams;
    final /* synthetic */ String $scope;
    int label;
    final /* synthetic */ u this$0;

    public FlowPassportMFAServiceImpl$startMFA$1(u r1, Activity r2, String r3, JSONObject r4, IGetDataCallback<String> r5, Continuation<? super FlowPassportMFAServiceImpl$startMFA$1> r6) {
        this.this$0 = r1;
        this.$context = r2;
        this.$scope = r3;
        this.$customParams = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowPassportMFAServiceImpl$startMFA$1(this.this$0, this.$context, this.$scope, this.$customParams, this.$callback, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L14:
        u r2 = this.this$0;
        IGetDataCallback<String> r3 = this.$callback;
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 != null) goto L17;
        String r8 = ((q) r7).a;
        r2.b.post(new w(r3, r8));
    L27:
        return Unit.INSTANCE;
    L17:
        int r9 = u.c;
        r2.getClass();
        if ((r4 instanceof FlowMfaException) == false) goto L20;
        FlowMfaException r10 = (FlowMfaException) r4;
    L21:
        if (r10 == null) goto L24;
        FlowMfaError r11 = r10.getError();
        if (r11 == null) goto L24;
    L25:
        ErrorResult r12 = u.b(r11);
        r2.b.post(new v(r3, r12));
    L24:
        r11 = g.a(r4);
        goto L25
    L20:
        r10 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowMfaEngine r13 = this.this$0.a;
        Activity r5 = this.$context;
        String r14 = this.$scope;
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        JSONObject r15 = this.$customParams;
        this.label = 1;
        r7 = r13.e(r5, r14, r15, this);
        if (r7 != r0) goto L14;
        return r0;
    }
}
