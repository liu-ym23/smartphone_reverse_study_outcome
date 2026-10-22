package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements Function1<Object, Long> {
    final /* synthetic */ Function1<Object, Duration> $timeout;

    FlowKt__DelayKt$debounce$3(Function1<Object, Duration> r10) {
        this.$timeout = r10;
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(Object r10) {
        return Long.valueOf(DelayKt.d(this.$timeout.invoke(r10).m1439unboximpl()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Object r10) {
        return invoke(r10);
    }
}
