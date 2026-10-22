package kotlinx.coroutines.internal;

import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class r {
    public static final void a(int r10) {
        boolean r11 = true;
        if (r10 >= 1) goto L6;
        r11 = false;
    L6:
        if (r11 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + r10).toString());
    }
}
