package kotlin.collections;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/MapsKt__MapWithDefaultKt", "kotlin/collections/MapsKt__MapsJVMKt", "kotlin/collections/MapsKt__MapsKt", "kotlin/collections/MapsKt___MapsJvmKt", "kotlin/collections/MapsKt___MapsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class MapsKt extends MapsKt___MapsKt {
    private MapsKt() {
    }

    public static /* bridge */ /* synthetic */ void a(PersistentMap.Builder r5, Sequence r10) {
        MapsKt__MapsKt.putAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ void b(PersistentMap.Builder r5, Pair[] r10) {
        MapsKt__MapsKt.putAll(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List c(LinkedHashMap r5) {
        return MapsKt___MapsKt.toList(r5);
    }

    public static /* bridge */ /* synthetic */ Map d(ArrayList r5, Map r10) {
        return MapsKt__MapsKt.toMap(r5, r10);
    }

    public static /* bridge */ /* synthetic */ SortedMap e(LinkedHashMap r5, Comparator r10) {
        return MapsKt__MapsJVMKt.toSortedMap(r5, r10);
    }

    public static /* bridge */ /* synthetic */ Map f(LinkedHashMap r5, Function1 r10) {
        return MapsKt__MapWithDefaultKt.withDefaultMutable(r5, r10);
    }
}
