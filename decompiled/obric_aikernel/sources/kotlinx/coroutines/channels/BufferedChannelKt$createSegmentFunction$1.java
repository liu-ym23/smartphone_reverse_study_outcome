package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes3.dex */
/* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements Function2<Long, h<E>, h<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannelKt$createSegmentFunction$1();
    }

    BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long r10, Object r11) {
        return invoke(r10.longValue(), (h) r11);
    }

    public final h<E> invoke(long r10, h<E> r11) {
        return BufferedChannelKt.c(r10, r11);
    }
}
