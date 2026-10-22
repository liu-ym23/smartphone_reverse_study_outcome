package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class TimedValue<T> {
    private final long duration;
    private final T value;

    private TimedValue(T r10, long r11) {
        this.value = r10;
        this.duration = r11;
    }

    public /* synthetic */ TimedValue(Object r10, long r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-RFiDyg4$default, reason: not valid java name */
    public static /* synthetic */ TimedValue m1542copyRFiDyg4$default(TimedValue r10, Object r11, long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.duration;
    L9:
        return r10.m1544copyRFiDyg4(r11, r12);
    }

    public final T component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2-UwyO8pc, reason: not valid java name */
    public final long m1543component2UwyO8pc() {
        return this.duration;
    }

    /* JADX INFO: renamed from: copy-RFiDyg4, reason: not valid java name */
    public final TimedValue<T> m1544copyRFiDyg4(T r10, long r11) {
        return new TimedValue(r10, r11, null);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TimedValue) == true) goto L8;
        return false;
    L8:
        TimedValue r11 = (TimedValue) r10;
        if (Intrinsics.areEqual(this.value, r11.value) == true) goto L12;
        return false;
    L12:
        if (Duration.m1389equalsimpl0(this.duration, r11.duration) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX INFO: renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m1545getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T r10 = this.value;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return (r11 * 31) + Duration.m1412hashCodeimpl(this.duration);
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + Duration.m1433toStringimpl(this.duration) + ')';
    }
}
