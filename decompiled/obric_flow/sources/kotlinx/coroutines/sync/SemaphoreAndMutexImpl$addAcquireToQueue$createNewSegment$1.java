package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, i, i> {
    public static final SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = null;

    static {
        INSTANCE = new SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1();
    }

    public SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, h.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ i mo2invoke(Long r5, i r10) {
        return invoke(r5.longValue(), r10);
    }

    public final i invoke(long r5, i r10) {
        int r11 = h.f19018a;
        return new i(r5, r10, 0);
    }
}
