package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
final class c1 extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b1 f10250c;

    public c1(b1 r10) {
        this.f10250c = r10;
    }

    @Override // kotlinx.coroutines.m
    public void g(Throwable r10) {
        this.f10250c.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        g(r10);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f10250c + ']';
    }
}
