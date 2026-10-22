package kotlin.jvm.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class OptionalsKt {
    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> Sequence<T> asSequence(Optional<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPresent() == false) goto L6;
        return SequencesKt.sequenceOf(new Object[]{r10.get()});
    L6:
        return SequencesKt.emptySequence();
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T getOrDefault(Optional<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPresent() == true) goto L5;
        return r11;
    L5:
        return r10.get();
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T getOrElse(Optional<? extends T> r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (r10.isPresent() == false) goto L6;
        return r10.get();
    L6:
        return r11.invoke();
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T getOrNull(Optional<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.orElse(null);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        if (r10.isPresent() == false) goto L5;
        T r12 = r10.get();
        Intrinsics.checkNotNullExpressionValue(r12, "get()");
        r11.add(r12);
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> List<T> toList(Optional<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPresent() == false) goto L6;
        return CollectionsKt.listOf(r10.get());
    L6:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> Set<T> toSet(Optional<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isPresent() == false) goto L6;
        return SetsKt.setOf(r10.get());
    L6:
        return SetsKt.emptySet();
    }
}
