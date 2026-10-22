package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
final class m2 extends b2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Continuation<Unit> f10608j;

    /* JADX WARN: Multi-variable type inference failed */
    public m2(Continuation<? super Unit> r10) {
        this.f10608j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        Continuation<Unit> r11 = this.f10608j;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    }
}
