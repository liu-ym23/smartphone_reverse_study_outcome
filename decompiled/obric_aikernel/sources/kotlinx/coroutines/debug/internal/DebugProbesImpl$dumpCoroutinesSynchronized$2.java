package kotlinx.coroutines.debug.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class DebugProbesImpl$dumpCoroutinesSynchronized$2 extends Lambda implements Function1<c.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$2 INSTANCE = null;

    static {
        INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$2();
    }

    DebugProbesImpl$dumpCoroutinesSynchronized$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(c.a<?> r10) {
        return Boolean.valueOf(!c.b(c.f10368a, r10));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(c.a<?> r10) {
        return invoke2(r10);
    }
}
