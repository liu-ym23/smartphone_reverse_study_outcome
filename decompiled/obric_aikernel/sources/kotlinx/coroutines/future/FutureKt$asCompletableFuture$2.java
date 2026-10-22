package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class FutureKt$asCompletableFuture$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableFuture<Unit> $future;

    FutureKt$asCompletableFuture$2(CompletableFuture<Unit> r10) {
        this.$future = r10;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r10) {
        CompletableFuture<Unit> r11 = this.$future;
        if (r10 != null) goto L5;
        r11.complete(Unit.INSTANCE);
        return;
    L5:
        r11.completeExceptionally(r10);
    }
}
