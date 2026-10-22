package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f18895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f18896b;

    public m2(Ref.BooleanRef r5, h r10) {
        this.f18895a = r5;
        this.f18896b = r10;
    }

    public final Object b(int r5, Continuation r10) {
        if ((r10 instanceof StartedLazily$command$1$1$emit$1) == false) goto L7;
        StartedLazily$command$1$1$emit$1 r11 = (StartedLazily$command$1$1$emit$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r5 <= 0) goto L24;
        Ref.BooleanRef r16 = this.f18895a;
        if (r16.element == true) goto L24;
        r16.element = true;
        SharingCommand r17 = SharingCommand.START;
        r11.label = 1;
        if (this.f18896b.emit(r17, r11) != r14) goto L22;
        return r14;
    L24:
        return Unit.INSTANCE;
    L7:
        r11 = new StartedLazily$command$1$1$emit$1(this, r10);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.h
    public final /* bridge */ /* synthetic */ Object emit(Object r5, Continuation r10) {
        return b(((Number) r5).intValue(), r10);
    }
}
