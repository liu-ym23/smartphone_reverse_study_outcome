package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f18874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.channels.w f18876c;
    public final /* synthetic */ kotlinx.coroutines.flow.h d;
    public final /* synthetic */ Function3 e;
    public final /* synthetic */ kotlinx.coroutines.t f;

    public m(CoroutineContext r5, Object r10, kotlinx.coroutines.channels.w r11, kotlinx.coroutines.flow.h r12, Function3 r13, kotlinx.coroutines.t r14) {
        this.f18874a = r5;
        this.f18875b = r10;
        this.f18876c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r12, Continuation r13) {
        if ((r13 instanceof CombineKt$zipImpl$1$1$2$1$emit$1) == false) goto L7;
        CombineKt$zipImpl$1$1$2$1$emit$1 r5 = (CombineKt$zipImpl$1$1$2$1$emit$1) r13;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Unit r16 = Unit.INSTANCE;
        kotlinx.coroutines.t r17 = this.f;
        CombineKt$zipImpl$1$1$2$1$1 r18 = new CombineKt$zipImpl$1$1$2$1$1(this.f18876c, this.d, this.e, r12, r17, null);
        r5.label = 1;
        if (b.b(this.f18874a, r16, this.f18875b, r18, r5) != r11) goto L18;
        return r11;
    L7:
        r5 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r13);
        goto L8
    }
}
