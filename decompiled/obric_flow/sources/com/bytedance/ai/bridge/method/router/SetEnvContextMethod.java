package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
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
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/SetEnvContextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetEnvContextMethod extends AbsSetEnvContextMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.router.SetEnvContextMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.router.SetEnvContextMethod$handle$1", f = "SetEnvContextMethod.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsSetEnvContextMethodIDL.SetEnvContextParamModel f1947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o1.f f1948b;

        public AnonymousClass1(AbsSetEnvContextMethodIDL.SetEnvContextParamModel r5, o1.f r10, Continuation r11) {
            this.f1947a = r5;
            this.f1948b = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f1947a, this.f1948b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            AbsSetEnvContextMethodIDL.SetEnvContextParamModel r11 = this.f1947a;
            o1.f r12 = this.f1948b;
            return new AnonymousClass1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r5);
            o1.f r10 = this.f1948b;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            r10.a("Failed to set env context");     // Catch: Throwable -> L5
            Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            o1.f r13 = this.f1948b;
            Throwable r14 = Result.m127exceptionOrNullimpl(r12);
            if (r14 == null) goto L11;
            r13.a("got exception " + r14);
        L11:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public SetEnvContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsSetEnvContextMethodIDL.SetEnvContextParamModel) r10, r11);
    }

    public void handle(n1.c r10, AbsSetEnvContextMethodIDL.SetEnvContextParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass1(r11, r12, null), 3, null);
    }
}
