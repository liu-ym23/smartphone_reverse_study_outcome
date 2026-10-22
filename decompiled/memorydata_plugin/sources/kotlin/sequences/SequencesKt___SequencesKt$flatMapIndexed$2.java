package kotlin.sequences;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$2<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$2 INSTANCE = null;

    static {
        INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$2();
    }

    SequencesKt___SequencesKt$flatMapIndexed$2() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Object r3) {
        return invoke((Sequence) ZeusTransformUtils.preCheckCast(r3, Sequence.class, "com.obric.memorydata.plugin"));
    }

    public final Iterator<R> invoke(Sequence<? extends R> r2) {
        Sequence r1 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r2, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "p0");
        return r1.iterator();
    }
}
