package kotlin.collections;

import java.util.Set;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/SetsKt__SetsJVMKt", "kotlin/collections/SetsKt__SetsKt", "kotlin/collections/SetsKt___SetsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class SetsKt extends SetsKt___SetsKt {
    private SetsKt() {
    }

    public static /* bridge */ /* synthetic */ Set a(Set r5, AnnotationQualifierApplicabilityType r10) {
        return SetsKt___SetsKt.minus(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Set b(Set r5, SmartSet r10) {
        return SetsKt___SetsKt.minus(r5, r10);
    }
}
