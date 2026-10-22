package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureTitleComponent$animateOnDarkMode$1", f = "EduCaptureTitleComponent.kt", i = {}, l = {143, 145, 147, 149, 151}, m = "invokeSuspend", n = {}, s = {})
final class EduCaptureTitleComponent$animateOnDarkMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c0 this$0;

    public EduCaptureTitleComponent$animateOnDarkMode$1(c0 r1, Continuation<? super EduCaptureTitleComponent$animateOnDarkMode$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EduCaptureTitleComponent$animateOnDarkMode$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        if (r1 != 5) goto L11;
        ResultKt.throwOnFailure(r10);
    L64:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
    L50:
        c0 r11 = this.this$0;
        if ((!r11.n.b) == true) goto L53;
        this.label = 5;
        kotlinx.coroutines.j r2 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r2.C();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = new u(r2);
        r11.r(new t(r11, r3));
        Object r12 = r2.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
        DebugProbesKt.probeCoroutineSuspended(this);
    L58:
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L61;
        r12 = Unit.INSTANCE;
    L61:
        if (r12 != r0) goto L64;
        return r0;
    L53:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r10);
    L43:
        c0 r13 = this.this$0;
        if ((!r13.n.b) == true) goto L46;
        this.label = 4;
        if (c0.u(r13, this) != r0) goto L50;
        return r0;
    L46:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r10);
    L36:
        c0 r14 = this.this$0;
        if ((!r14.n.b) == true) goto L39;
        this.label = 3;
        if (c0.u(r14, this) != r0) goto L43;
        return r0;
    L39:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r10);
    L29:
        c0 r15 = this.this$0;
        if ((!r15.n.b) == true) goto L32;
        this.label = 2;
        if (c0.u(r15, this) != r0) goto L36;
        return r0;
    L32:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r10);
        c0 r16 = this.this$0;
        if ((!r16.n.b) == true) goto L19;
        this.label = 1;
        kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r4.C();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = new b0(r4);
        r16.r(new a0(r16, r7));
        Object r17 = r4.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(this);
    L24:
        if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        r17 = Unit.INSTANCE;
    L27:
        if (r17 != r0) goto L29;
        return r0;
    L19:
        return Unit.INSTANCE;
    }
}
