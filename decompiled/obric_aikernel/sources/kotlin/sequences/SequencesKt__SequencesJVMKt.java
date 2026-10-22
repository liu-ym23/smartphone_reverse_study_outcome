package kotlin.sequences;

import java.util.Enumeration;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class SequencesKt__SequencesJVMKt extends SequencesKt__SequenceBuilderKt {
    public SequencesKt__SequencesJVMKt() {
    }

    @InlineOnly
    private static final <T> Sequence<T> asSequence(Enumeration<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.asSequence(CollectionsKt.iterator(r10));
    }
}
