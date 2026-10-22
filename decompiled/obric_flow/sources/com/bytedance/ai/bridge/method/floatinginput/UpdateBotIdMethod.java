package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
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
import kotlinx.coroutines.h0;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/UpdateBotIdMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL$UpdateBotIdParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL$UpdateBotIdResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateBotIdMethodIDL$UpdateBotIdParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpdateBotIdMethod extends AbsUpdateBotIdMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.UpdateBotIdMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.floatinginput.UpdateBotIdMethod$handle$1", f = "UpdateBotIdMethod.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateBotIdMethod f1820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n1.c f1821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f1822c;
        public final /* synthetic */ AbsUpdateBotIdMethodIDL.UpdateBotIdParamModal d;

        public AnonymousClass1(UpdateBotIdMethod r5, n1.c r10, f r11, AbsUpdateBotIdMethodIDL.UpdateBotIdParamModal r12, Continuation r13) {
            this.f1820a = r5;
            this.f1821b = r10;
            this.f1822c = r11;
            this.d = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f1820a, this.f1821b, this.f1822c, this.d, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r5);
            fj.a.d(this.f1820a, this.f1821b);
            f r10 = this.f1822c;
            StringBuilder r11 = new StringBuilder("unsupported container type ");
            j r12 = (j) ((n1.a) this.f1821b).b(j.class);
            if (r12 == null) goto L5;
            ContainerType r13 = r12.d();
        L6:
            r11.append(r13);
            r10.a(r11.toString());
            return Unit.INSTANCE;
        L5:
            r13 = null;
            goto L6
        }
    }

    public UpdateBotIdMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsUpdateBotIdMethodIDL.UpdateBotIdParamModal) r10, r11);
    }

    public void handle(n1.c r10, AbsUpdateBotIdMethodIDL.UpdateBotIdParamModal r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(t2.b.d), null, null, new AnonymousClass1(this, r10, r12, r11, null), 3, null);
    }
}
