package com.bytedance.ai.ex.widget;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/h;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.bytedance.ai.ex.widget.RepeatWhenAttachedKt$isVisible$1$2$1", f = "RepeatWhenAttached.kt", i = {0, 1}, l = {300, LynxErrorCode.LYNX_ERROR_CODE_RESOURCE}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
public final class RepeatWhenAttachedKt$isVisible$1$2$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.h, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public RepeatWhenAttachedKt$isVisible$1$2$1(Continuation<? super RepeatWhenAttachedKt$isVisible$1$2$1> r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        RepeatWhenAttachedKt$isVisible$1$2$1 r11 = new RepeatWhenAttachedKt$isVisible$1$2$1(r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005d -> B:7:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        int r12 = this.I$1;
        int r13 = this.I$0;
        kotlinx.coroutines.flow.h r14 = (kotlinx.coroutines.flow.h) this.L$0;
        ResultKt.throwOnFailure(r10);
    L7:
        kotlinx.coroutines.flow.h r15 = r14;
        int r16 = r13;
        int r17 = r12 + 1;
        int r18 = r16;
    L12:
        if (r17 >= r18) goto L22;
        Unit r19 = Unit.INSTANCE;
        this.L$0 = r15;
        this.I$0 = r18;
        this.I$1 = r17;
        this.label = 1;
        if (r15.emit(r19, this) == r5) goto L19;
        r14 = r15;
        int r20 = r17;
        r13 = r18;
        r12 = r20;
    L17:
        this.L$0 = r14;
        this.I$0 = r13;
        this.I$1 = r12;
        this.label = 2;
        if (DelayKt.delay(25, this) != r5) goto L7;
    L19:
        return r5;
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r12 = this.I$1;
        r13 = this.I$0;
        r14 = (kotlinx.coroutines.flow.h) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L17
    L11:
        ResultKt.throwOnFailure(r10);
        r15 = (kotlinx.coroutines.flow.h) this.L$0;
        r18 = 4;
        r17 = 0;
        goto L12
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.h r5, Continuation<? super Unit> r10) {
        return ((RepeatWhenAttachedKt$isVisible$1$2$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
