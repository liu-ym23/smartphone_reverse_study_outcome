package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n20#3:137\n20#3:142\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n*L\n126#1:133,4\n128#1:138,4\n126#1:137\n128#1:142\n*E\n"})
final class r extends SharedFlowImpl<Integer> implements p1<Integer> {
    public r(int r10) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        c(Integer.valueOf(r10));
    }

    public Integer Y() {
        monitor-enter(this);
        Integer r10 = Integer.valueOf(L().intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean Z(int r10) {
        monitor-enter(this);
        boolean r11 = c(Integer.valueOf(L().intValue() + r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.p1
    public /* bridge */ /* synthetic */ Integer getValue() {
        return Y();
    }
}
