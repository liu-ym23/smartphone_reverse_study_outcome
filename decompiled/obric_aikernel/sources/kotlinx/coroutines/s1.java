package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
final class s1 extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<Throwable, Unit> f10630c;

    /* JADX WARN: Multi-variable type inference failed */
    public s1(Function1<? super Throwable, Unit> r10) {
        this.f10630c = r10;
    }

    @Override // kotlinx.coroutines.m
    public void g(Throwable r10) {
        this.f10630c.invoke(r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        g(r10);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "InvokeOnCancel[" + o0.a(this.f10630c) + '@' + o0.b(this) + ']';
    }
}
