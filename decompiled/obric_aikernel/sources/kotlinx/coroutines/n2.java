package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nExecutors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Executors.kt\nkotlinx/coroutines/ResumeUndispatchedRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
final class n2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f10614c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n<Unit> f10615g;

    /* JADX WARN: Multi-variable type inference failed */
    public n2(CoroutineDispatcher r10, n<? super Unit> r11) {
        this.f10614c = r10;
        this.f10615g = r11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10615g.q(this.f10614c, Unit.INSTANCE);
    }
}
