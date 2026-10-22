package com.bytedance.ai.bridge.method.floatinginput;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/UpdateBotIdMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL$UpdateBotIdParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL$UpdateBotIdResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateBotIdMethod extends AbsUpdateBotIdMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.UpdateBotIdMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.floatinginput.UpdateBotIdMethod$handle$1", f = "UpdateBotIdMethod.kt", i = {}, l = {IAPI.OPTION_DMPLISTENER}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ h<AbsUpdateBotIdMethodIDL.b> $callback;
        final /* synthetic */ AbsUpdateBotIdMethodIDL.a $params;
        Object L$0;
        int label;
        final /* synthetic */ UpdateBotIdMethod this$0;

        public AnonymousClass1(UpdateBotIdMethod r1, e3.d r10, h<AbsUpdateBotIdMethodIDL.b> r11, AbsUpdateBotIdMethodIDL.a r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r1;
            this.$bridgeContext = r10;
            this.$callback = r11;
            this.$params = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$bridgeContext, this.$callback, this.$params, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            h<AbsUpdateBotIdMethodIDL.b> r11 = (h) this.L$0;
            ResultKt.throwOnFailure(r10);
        L16:
            Intrinsics.checkNotNullParameter(AbsUpdateBotIdMethodIDL.b.class, "<this>");
            h.a.b(r11, (ResultModel) k3.c.a(AbsUpdateBotIdMethodIDL.b.class));
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            j r12 = a.a(this.this$0, this.$bridgeContext);
            if (r12 == null) goto L17;
            t r13 = r12.getFloatingSpeakerController();
            if (r13 == null) goto L17;
            AbsUpdateBotIdMethodIDL.a r14 = this.$params;
            h<AbsUpdateBotIdMethodIDL.b> r15 = this.$callback;
            String r16 = r14.getBotId();
            this.L$0 = r15;
            this.label = 1;
            if (r13.g(r16, this) != r0) goto L15;
            return r0;
        L15:
            r11 = r15;
        L17:
            h<AbsUpdateBotIdMethodIDL.b> r17 = this.$callback;
            StringBuilder r18 = new StringBuilder("unsupported container type ");
            a0 r19 = this.$bridgeContext.getContainerContext();
            if (r19 == null) goto L20;
            ContainerType r20 = r19.getContainerType();
        L21:
            r18.append(r20);
            h.a.a(r17, r18.toString(), null, null, 14);
            goto L23
        L20:
            r20 = null;
            goto L21
        }
    }

    public UpdateBotIdMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, h r14) {
        AbsUpdateBotIdMethodIDL.a r10 = (AbsUpdateBotIdMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new AnonymousClass1(this, r12, r14, r10, null), 3, null);
    }
}
