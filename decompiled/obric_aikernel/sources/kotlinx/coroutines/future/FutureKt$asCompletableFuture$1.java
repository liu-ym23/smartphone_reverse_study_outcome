package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes3.dex */
final class FutureKt$asCompletableFuture$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableFuture<Object> $future;
    final /* synthetic */ r0<Object> $this_asCompletableFuture;

    FutureKt$asCompletableFuture$1(CompletableFuture<Object> r10, r0<Object> r11) {
        this.$future = r10;
        this.$this_asCompletableFuture = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r10) {
        this.$future.complete(this.$this_asCompletableFuture.f());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.$future.completeExceptionally(th);
    }
}
