package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.p;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.SetAdditionalContextMethod$handle$3$1", f = "SetAdditionalContextMethod.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class SetAdditionalContextMethod$handle$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0.f f1945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbsSetAdditionalContextMethodIDL.SetAdditionalContextParamModel f1946c;
    public final /* synthetic */ o1.f d;

    public SetAdditionalContextMethod$handle$3$1(w0.f r5, AbsSetAdditionalContextMethodIDL.SetAdditionalContextParamModel r10, o1.f r11, Continuation r12) {
        this.f1945b = r5;
        this.f1946c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new SetAdditionalContextMethod$handle$3$1(this.f1945b, this.f1946c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((SetAdditionalContextMethod$handle$3$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f1944a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        Boolean r12 = (Boolean) r5;
    L17:
        if (r12 == null) goto L19;
        boolean r13 = r12.booleanValue();
    L20:
        if (r13 == true) goto L22;
        AppletRuntime r14 = ((com.bytedance.ai.model.widgets.a) this.f1945b).f2329a;
        this.f1946c.getAdditionalContext();
        r14.q(this.f1946c.getBotId());
    L22:
        o1.f r15 = this.d;
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class, "<this>");
        r15.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class), "");
        return Unit.INSTANCE;
    L19:
        r13 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        String r16 = ((com.bytedance.ai.model.widgets.a) this.f1945b).f2330b.getMessageId();
        if (r16 == null) goto L19;
        t0.b r17 = p.f2294c;
        if (r17 == null) goto L16;
        this.f1944a = 1;
        r5 = r17.isContextClearedMessage(r16, this);
        if (r5 != r10) goto L15;
        return r10;
    L16:
        r12 = null;
        goto L17
    }
}
