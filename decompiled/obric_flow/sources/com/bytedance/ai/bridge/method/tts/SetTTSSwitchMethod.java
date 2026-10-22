package com.bytedance.ai.bridge.method.tts;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.floatinginput.AbsSetTTSSwitchMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import fj.a;
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
import n1.c;
import o1.f;
import t2.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/tts/SetTTSSwitchMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetTTSSwitchMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetTTSSwitchMethodIDL$SetTTSSwitchParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetTTSSwitchMethodIDL$SetTTSSwitchResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetTTSSwitchMethodIDL$SetTTSSwitchParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetTTSSwitchMethod extends AbsSetTTSSwitchMethodIDL {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.tts.SetTTSSwitchMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.tts.SetTTSSwitchMethod$handle$1", f = "SetTTSSwitchMethod.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SetTTSSwitchMethod f2017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f2018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f2019c;
        public final /* synthetic */ AbsSetTTSSwitchMethodIDL.SetTTSSwitchParamModal d;

        public AnonymousClass1(SetTTSSwitchMethod r5, c r10, f r11, AbsSetTTSSwitchMethodIDL.SetTTSSwitchParamModal r12, Continuation r13) {
            this.f2017a = r5;
            this.f2018b = r10;
            this.f2019c = r11;
            this.d = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f2017a, this.f2018b, this.f2019c, this.d, r11);
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
            a.d(this.f2017a, this.f2018b);
            f r10 = this.f2019c;
            StringBuilder r11 = new StringBuilder("unsupported container type ");
            j r12 = (j) ((n1.a) this.f2018b).b(j.class);
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

    public SetTTSSwitchMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSetTTSSwitchMethodIDL.SetTTSSwitchParamModal) r10, r11);
    }

    public void handle(c r10, AbsSetTTSSwitchMethodIDL.SetTTSSwitchParamModal r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(b.f22089a), null, null, new AnonymousClass1(this, r10, r12, r11, null), 3, null);
    }
}
