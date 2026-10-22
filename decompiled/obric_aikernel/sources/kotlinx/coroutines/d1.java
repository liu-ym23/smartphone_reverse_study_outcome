package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends b2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b1 f10329j;

    public d1(b1 r10) {
        this.f10329j = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        q(r10);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.d0
    public void q(Throwable r10) {
        this.f10329j.dispose();
    }
}
