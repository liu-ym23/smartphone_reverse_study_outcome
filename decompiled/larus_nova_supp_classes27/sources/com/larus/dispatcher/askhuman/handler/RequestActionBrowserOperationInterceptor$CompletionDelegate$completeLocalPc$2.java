package com.larus.dispatcher.askhuman.handler;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.InteractionRequestActionPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.RequestActionResult;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2", f = "RequestActionBrowserOperationInterceptor.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
public final class RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ hv8.a $request;
    final /* synthetic */ hv8.c.b $target;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RequestActionBrowserOperationInterceptor.CompletionDelegate this$0;

    public static final class a implements IIMCallback<OmniDispatchCommandResponse> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hv8.c.b c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.w("QuickReplyClickInterceptorManager", "[browserTakeover] completion failed, code=" + r4.getCode());
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Boolean> r5 = this.a;
            Result.Companion r0 = Result.Companion;
            r5.resumeWith(Result.constructor-impl(Boolean.FALSE));
            return;
        }

        public final void onSuccess(Object r4) {
            OmniDispatchCommandResponse r5 = (OmniDispatchCommandResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            if (this.a.isActive() == false) goto L21;
            DispatchCommandPayload r6 = r5.payload;
            kotlinx.coroutines.i<Boolean> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            if (r6 == null) goto L8;
            String r2 = r6.commandId;
        L10:
            if (Intrinsics.areEqual(r2, this.b) == true) goto L12;
        L18:
            boolean r7 = false;
        L19:
            r0.resumeWith(Result.constructor-impl(Boolean.valueOf(r7)));
            return;
        L12:
            if (r6.command != DispatchCommand.INTERACTION_RESPONSE) goto L18;
            if (Intrinsics.areEqual(r6.sourceDeviceId, this.c.a) == false) goto L18;
            if (r6.errorCode != DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS) goto L18;
            r7 = true;
            goto L19
        L8:
            r2 = null;
            goto L10
        }

        public a(kotlinx.coroutines.j r1, String r2, hv8.c.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2(hv8.c.b r1, RequestActionBrowserOperationInterceptor.CompletionDelegate r2, hv8.a r3, Continuation<? super RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2> r4) {
        this.$target = r1;
        this.this$0 = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RequestActionBrowserOperationInterceptor$CompletionDelegate$completeLocalPc$2(this.$target, this.this$0, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        hv8.a r3 = (hv8.a) this.L$2;
        RequestActionBrowserOperationInterceptor.CompletionDelegate r4 = (RequestActionBrowserOperationInterceptor.CompletionDelegate) this.L$1;
        hv8.c.b r5 = (hv8.c.b) this.L$0;
        ResultKt.throwOnFailure(r36);
        return r36;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        hv8.c.b r6 = this.$target;
        RequestActionBrowserOperationInterceptor.CompletionDelegate r7 = this.this$0;
        hv8.a r8 = this.$request;
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r8;
        this.label = 1;
        kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r9.C();
        String r10 = UUID.randomUUID().toString();
        NativeCmdServiceImpl r15 = com.larus.im.d.b();
        String r13 = r6.a;
        String r11 = r6.b;
        if (r11 == null) goto L13;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L13;
        int r14 = r12.intValue();
    L14:
        DispatchCommand r16 = DispatchCommand.INTERACTION_REQUEST_ACTION_HANDLE;
        String r17 = r7.a;
        r15.sendDispatchCommand(new OmniDispatchCommandRequest(r13, r14, new DispatchCommandPayload(r16, r10, new DispatchCommandBody(null, null, null, null, new InteractionRequestActionPayload(r8.e, r8.f, new RequestActionResult(false)), null, null, null, null, null, null, null, null, null, 16367, null), null, r17, null, 0, null, null, 488, null)), new a(r9, r10, r6));
        Object r0 = r9.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(this);
    L17:
        if (r0 != r1) goto L20;
        return r1;
    L20:
        return r0;
    L13:
        r14 = 0;
        goto L14
    }
}
