package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class SequencesKt extends SequencesKt___SequencesKt {
    private SequencesKt() {
    }

    public static /* bridge */ /* synthetic */ <T> Iterable<T> asIterable(Sequence<? extends T> r10) {
        return SequencesKt___SequencesKt.asIterable(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> asSequence(Iterator<? extends T> r10) {
        return SequencesKt__SequencesKt.asSequence(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> constrainOnce(Sequence<? extends T> r10) {
        return SequencesKt__SequencesKt.constrainOnce(r10);
    }

    public static /* bridge */ /* synthetic */ <T> int count(Sequence<? extends T> r10) {
        return SequencesKt___SequencesKt.count(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> drop(Sequence<? extends T> r10, int r11) {
        return SequencesKt___SequencesKt.drop(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> emptySequence() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> filter(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        return SequencesKt___SequencesKt.filter(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> filterNot(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        return SequencesKt___SequencesKt.filterNot(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> filterNotNull(Sequence<? extends T> r10) {
        return SequencesKt___SequencesKt.filterNotNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T first(Sequence<? extends T> r10) {
        return (T) SequencesKt___SequencesKt.first(r10);
    }

    public static /* bridge */ /* synthetic */ <T> T firstOrNull(Sequence<? extends T> r10) {
        return (T) SequencesKt___SequencesKt.firstOrNull(r10);
    }

    public static /* bridge */ /* synthetic */ <T, R> Sequence<R> flatMap(Sequence<? extends T> r10, Function1<? super T, ? extends Sequence<? extends R>> r11) {
        return SequencesKt___SequencesKt.flatMap(r10, r11);
    }

    @LowPriorityInOverloadResolution
    public static /* bridge */ /* synthetic */ <T> Sequence<T> generateSequence(T r10, Function1<? super T, ? extends T> r11) {
        return SequencesKt__SequencesKt.generateSequence(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> generateSequence(Function0<? extends T> r10) {
        return SequencesKt__SequencesKt.generateSequence(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> generateSequence(Function0<? extends T> r10, Function1<? super T, ? extends T> r11) {
        return SequencesKt__SequencesKt.generateSequence(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <T> Iterator<T> iterator(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return SequencesKt__SequenceBuilderKt.iterator(r10);
    }

    public static /* bridge */ /* synthetic */ String joinToString$default(Sequence r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        return SequencesKt___SequencesKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* bridge */ /* synthetic */ <T> T last(Sequence<? extends T> r10) {
        return (T) SequencesKt___SequencesKt.last(r10);
    }

    public static /* bridge */ /* synthetic */ <T, R> Sequence<R> map(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        return SequencesKt___SequencesKt.map(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T, R> Sequence<R> mapNotNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        return SequencesKt___SequencesKt.mapNotNull(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> plus(Sequence<? extends T> r10, Iterable<? extends T> r11) {
        return SequencesKt___SequencesKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> plus(Sequence<? extends T> r10, T r11) {
        return SequencesKt___SequencesKt.plus(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static /* bridge */ /* synthetic */ <T> Sequence<T> sequence(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return SequencesKt__SequenceBuilderKt.sequence(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> sequenceOf(T... r10) {
        return SequencesKt__SequencesKt.sequenceOf(r10);
    }

    @JvmName(name = "sumOfLong")
    public static /* bridge */ /* synthetic */ long sumOfLong(Sequence<Long> r10) {
        return SequencesKt___SequencesKt.sumOfLong(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Sequence<T> takeWhile(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        return SequencesKt___SequencesKt.takeWhile(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toList(Sequence<? extends T> r10) {
        return SequencesKt___SequencesKt.toList(r10);
    }

    public static /* bridge */ /* synthetic */ <T> List<T> toMutableList(Sequence<? extends T> r10) {
        return SequencesKt___SequencesKt.toMutableList(r10);
    }
}
