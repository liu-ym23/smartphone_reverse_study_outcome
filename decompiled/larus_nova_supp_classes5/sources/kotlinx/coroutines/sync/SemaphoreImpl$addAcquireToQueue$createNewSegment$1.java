package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, e, e> {
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = null;

    static {
        INSTANCE = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();
    }

    public SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, d.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (e) r4);
    }

    public final e invoke(long r3, e r5) {
        int r0 = d.a;
        return new e(r3, r5, 0);
    }
}
