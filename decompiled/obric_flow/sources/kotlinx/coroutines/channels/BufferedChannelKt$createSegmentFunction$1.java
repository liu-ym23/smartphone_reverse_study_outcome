package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements Function2<Long, o, o> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannelKt$createSegmentFunction$1();
    }

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, g.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ o mo2invoke(Long r5, o r10) {
        return invoke(r5.longValue(), r10);
    }

    public final o invoke(long r10, o r11) {
        o r12 = g.f18797a;
        f r5 = r11.e;
        Intrinsics.checkNotNull(r5);
        return new o(r10, r11, r5, 0);
    }
}
