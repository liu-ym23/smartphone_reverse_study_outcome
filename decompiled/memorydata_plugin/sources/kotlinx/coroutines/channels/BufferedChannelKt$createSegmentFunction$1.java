package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements Function2<Long, n<E>, n<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannelKt$createSegmentFunction$1();
    }

    BufferedChannelKt$createSegmentFunction$1() {
        super(2, h.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Long r5, Object r6) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue(), (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin"));
    }

    public final n<E> invoke(long r1, n<E> r3) {
        return h.a(r1, r3);
    }
}
