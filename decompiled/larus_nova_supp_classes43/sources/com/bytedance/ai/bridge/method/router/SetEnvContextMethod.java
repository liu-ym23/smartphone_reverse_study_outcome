package com.bytedance.ai.bridge.method.router;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/SetEnvContextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetEnvContextMethod extends AbsSetEnvContextMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.SetEnvContextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.SetEnvContextMethod$handle$1", f = "SetEnvContextMethod.kt", i = {}, l = {IAPI.OPTION_PREFER_IP}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f3.h<AbsSetEnvContextMethodIDL.b> $callback;
        final /* synthetic */ AbsSetEnvContextMethodIDL.a $params;
        Object L$0;
        int label;

        public AnonymousClass1(AbsSetEnvContextMethodIDL.a r1, f3.h<AbsSetEnvContextMethodIDL.b> r10, Continuation<? super AnonymousClass1> r11) {
            this.$params = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$params, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r10 = false;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            f3.h<AbsSetEnvContextMethodIDL.b> r11 = (f3.h) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L25
        L17:
            f3.h<AbsSetEnvContextMethodIDL.b> r12 = r11;
            if (((Boolean) r14).booleanValue() != true) goto L20;
            r10 = true;
        L20:
            if (r10 == false) goto L22;
            Intrinsics.checkNotNullParameter(AbsSetEnvContextMethodIDL.b.class, "<this>");     // Catch: Throwable -> L25
            f3.h.a.b(r12, (ResultModel) k3.c.a(AbsSetEnvContextMethodIDL.b.class));     // Catch: Throwable -> L25
        L23:
            Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            f3.h<AbsSetEnvContextMethodIDL.b> r13 = this.$callback;
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L31;
            f3.h.a.a(r13, "got exception " + r16, null, null, 14);
        L31:
            return Unit.INSTANCE;
        L22:
            f3.h.a.a(r12, "Failed to set env context", null, null, 14);     // Catch: Throwable -> L25
            goto L23
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r14);
            AbsSetEnvContextMethodIDL.a r17 = this.$params;
            r12 = this.$callback;
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L25
            r4.h r19 = r4.a.l;     // Catch: Throwable -> L25
            if (r19 == null) goto L20;
            String r20 = r17.getConversationId();     // Catch: Throwable -> L25
            int r21 = r17.getEventType();     // Catch: Throwable -> L25
            String r110 = r17.getKey();     // Catch: Throwable -> L25
            String r111 = r17.getValue();     // Catch: Throwable -> L25
            this.L$0 = r12;     // Catch: Throwable -> L25
            this.label = 1;     // Catch: Throwable -> L25
            r14 = r19.c(r20, r21, r110, r111, this);     // Catch: Throwable -> L25
            if (r14 != r0) goto L16;
            return r0;
        L16:
            r11 = r12;
        L25:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        }
    }

    public SetEnvContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsSetEnvContextMethodIDL.a r13 = (AbsSetEnvContextMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AnonymousClass1(r13, r12, null), 3, null);
    }
}
