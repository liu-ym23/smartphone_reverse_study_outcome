package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
final class u1 extends b2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function1<Throwable, Unit> f10721j;

    /* JADX WARN: Multi-variable type inference failed */
    public u1(Function1<? super Throwable, Unit> r10) {
        this.f10721j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        this.f10721j.invoke(r10);
    }
}
