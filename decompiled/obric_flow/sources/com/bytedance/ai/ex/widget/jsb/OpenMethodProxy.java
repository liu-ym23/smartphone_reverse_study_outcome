package com.bytedance.ai.ex.widget.jsb;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.UUID;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/OpenMethodProxy;", "Lcom/bytedance/ai/ex/widget/jsb/AbsOpenMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/ex/widget/jsb/AbsOpenMethodIDL$OpenMethodParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/ex/widget/jsb/AbsOpenMethodIDL$OpenMethodResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/ex/widget/jsb/AbsOpenMethodIDL$OpenMethodParamModel;Lo1/f;)V", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenMethodProxy extends AbsOpenMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.jsb.OpenMethodProxy$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.jsb.OpenMethodProxy$handle$1", f = "OpenMethodProxy.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c $bridgeContext;
        final /* synthetic */ f $callback;
        final /* synthetic */ AbsOpenMethodIDL.OpenMethodParamModel $params;
        int label;
        final /* synthetic */ OpenMethodProxy this$0;

        public AnonymousClass1(OpenMethodProxy r5, AbsOpenMethodIDL.OpenMethodParamModel r10, c r11, f r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r5;
            this.$params = r10;
            this.$bridgeContext = r11;
            this.$callback = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$params, this.$bridgeContext, this.$callback, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            CommonServiceBridgeProxy r12 = CommonServiceBridgeProxy.INSTANCE;
            String r13 = UUID.randomUUID().toString();
            String r14 = this.this$0.getName();
            AbsOpenMethodIDL.OpenMethodParamModel r15 = this.$params;
            j r16 = (j) ((n1.a) this.$bridgeContext).b(j.class);
            if (r16 == null) goto L12;
            String r17 = r16.b();
        L11:
            String r18 = r17;
            f r19 = this.$callback;
            this.label = 1;
            if (r12.handler(r13, r14, r15, AbsOpenMethodIDL.OpenMethodParamModel.class, r18, AbsOpenMethodIDL.OpenMethodResultModel.class, r19, this) != r5) goto L17;
            return r5;
        L12:
            r17 = null;
            goto L11
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public OpenMethodProxy() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsOpenMethodIDL.OpenMethodParamModel) r10, r11);
    }

    public void handle(c r10, AbsOpenMethodIDL.OpenMethodParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new AnonymousClass1(this, r11, r10, r12, null), 3, null);
    }
}
