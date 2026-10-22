package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,121:1\n50#1,7:122\n113#1,7:129\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n21#1:122,7\n83#1:129,7\n*E\n"})
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        long r11 = TimeSource.Monotonic.INSTANCE.m1523markNowz9LOYto();
        r10.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1528elapsedNowUwyO8pc(r11);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(TimeSource.Monotonic r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        long r12 = r10.m1523markNowz9LOYto();
        r11.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1528elapsedNowUwyO8pc(r12);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(TimeSource r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        TimeMark r12 = r10.markNow();
        r11.invoke();
        return r12.mo1374elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        long r11 = TimeSource.Monotonic.INSTANCE.m1523markNowz9LOYto();
        return new TimedValue(r10.invoke(), TimeSource.Monotonic.ValueTimeMark.m1528elapsedNowUwyO8pc(r11), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(TimeSource.Monotonic r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        long r12 = r10.m1523markNowz9LOYto();
        return new TimedValue(r11.invoke(), TimeSource.Monotonic.ValueTimeMark.m1528elapsedNowUwyO8pc(r12), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(TimeSource r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        TimeMark r12 = r10.markNow();
        return new TimedValue(r11.invoke(), r12.mo1374elapsedNowUwyO8pc(), null);
    }
}
