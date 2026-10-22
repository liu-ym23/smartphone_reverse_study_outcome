package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
final class c extends f0<c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicReferenceArray f10717j;

    public c(long r10, c r11, int r12) {
        super(r10, r11, r12);
        this.f10717j = new AtomicReferenceArray(SemaphoreKt.f());
    }

    @Override // kotlinx.coroutines.internal.f0
    public int n() {
        return SemaphoreKt.f();
    }

    @Override // kotlinx.coroutines.internal.f0
    public void o(int r10, Throwable r11, CoroutineContext r12) {
        i0 r13 = SemaphoreKt.c();
        r().set(r10, r13);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f10717j;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f10550h + ", hashCode=" + hashCode() + ']';
    }
}
