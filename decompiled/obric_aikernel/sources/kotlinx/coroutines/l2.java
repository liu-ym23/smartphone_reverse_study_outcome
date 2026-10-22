package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
final class l2<T> extends b2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final o<T> f10607j;

    /* JADX WARN: Multi-variable type inference failed */
    public l2(o<? super T> r10) {
        this.f10607j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        Object r11 = r().w0();
        if (n0.a() == true) goto L5;
    L9:
        boolean r12 = r11 instanceof b0;
        o<T> r13 = this.f10607j;
        if (r12 == false) goto L12;
        Result.Companion r14 = Result.Companion;
        Object r15 = ResultKt.createFailure(((b0) r11).f10244a);
    L13:
        r13.resumeWith(Result.m32constructorimpl(r15));
        return;
    L12:
        Result.Companion r16 = Result.Companion;
        r15 = d2.h(r11);
        goto L13
    L5:
        if ((!(r11 instanceof p1)) == true) goto L9;
        throw new AssertionError();
    }
}
