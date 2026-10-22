package kotlinx.coroutines.channels;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2<Long, h<Object>, h<Object>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannelKt$createSegmentFunction$1();
    }

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    public final h<Object> invoke(long r8, h<Object> r10) {
        h r0 = e.a;
        BufferedChannel r5 = r10.e;
        Intrinsics.checkNotNull(r5);
        return new h(r8, r10, r5, 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (h) r4);
    }
}
