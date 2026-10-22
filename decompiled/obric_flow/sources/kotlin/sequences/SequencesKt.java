package kotlin.sequences;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/sequences/SequencesKt__SequenceBuilderKt", "kotlin/sequences/SequencesKt__SequencesJVMKt", "kotlin/sequences/SequencesKt__SequencesKt", "kotlin/sequences/SequencesKt___SequencesJvmKt", "kotlin/sequences/SequencesKt___SequencesKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class SequencesKt extends SequencesKt___SequencesKt {
    private SequencesKt() {
    }

    public static /* bridge */ /* synthetic */ Sequence a(DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 r5) {
        return SequencesKt__SequencesKt.generateSequence(r5);
    }

    public static /* bridge */ /* synthetic */ int b(Sequence r5, View r10) {
        return SequencesKt___SequencesKt.indexOf(r5, r10);
    }

    public static /* bridge */ /* synthetic */ String c(Sequence r10, String r11) {
        return SequencesKt___SequencesKt.joinToString$default(r10, r11, null, null, 0, null, null, 62, null);
    }

    public static /* bridge */ /* synthetic */ Sequence d(List r5, Sequence r10) {
        return SequencesKt___SequencesKt.plus(r10, r5);
    }
}
