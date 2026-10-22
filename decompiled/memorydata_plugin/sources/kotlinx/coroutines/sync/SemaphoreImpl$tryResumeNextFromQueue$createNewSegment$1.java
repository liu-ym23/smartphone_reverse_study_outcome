package kotlinx.coroutines.sync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, g, g> {
    public static final SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 INSTANCE = null;

    static {
        INSTANCE = new SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1();
    }

    SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1() {
        super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ g invoke(Long r5, g r6) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.memorydata.plugin"));
    }

    public final g invoke(long r1, g r3) {
        return f.a(r1, r3);
    }
}
