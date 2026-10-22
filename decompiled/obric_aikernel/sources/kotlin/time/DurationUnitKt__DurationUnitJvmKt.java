package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class DurationUnitKt__DurationUnitJvmKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[TimeUnit.values().length];
            r10[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r10[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r10[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r10[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r10[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r10[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public DurationUnitKt__DurationUnitJvmKt() {
    }

    @SinceKotlin(version = "1.3")
    public static final double convertDurationUnit(double r10, DurationUnit r11, DurationUnit r12) {
        Intrinsics.checkNotNullParameter(r11, "sourceUnit");
        Intrinsics.checkNotNullParameter(r12, "targetUnit");
        long r13 = r12.getTimeUnit$kotlin_stdlib().convert(1, r11.getTimeUnit$kotlin_stdlib());
        if (r13 <= 0) goto L7;
        return r10 * r13;
    L7:
        return r10 / r11.getTimeUnit$kotlin_stdlib().convert(1, r12.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnit(long r10, DurationUnit r11, DurationUnit r12) {
        Intrinsics.checkNotNullParameter(r11, "sourceUnit");
        Intrinsics.checkNotNullParameter(r12, "targetUnit");
        return r12.getTimeUnit$kotlin_stdlib().convert(r10, r11.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnitOverflow(long r10, DurationUnit r11, DurationUnit r12) {
        Intrinsics.checkNotNullParameter(r11, "sourceUnit");
        Intrinsics.checkNotNullParameter(r12, "targetUnit");
        return r12.getTimeUnit$kotlin_stdlib().convert(r10, r11.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final DurationUnit toDurationUnit(TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return DurationUnit.DAYS;
    L15:
        return DurationUnit.HOURS;
    L16:
        return DurationUnit.MINUTES;
    L17:
        return DurationUnit.SECONDS;
    L18:
        return DurationUnit.MILLISECONDS;
    L19:
        return DurationUnit.MICROSECONDS;
    L13:
        return DurationUnit.NANOSECONDS;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final TimeUnit toTimeUnit(DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getTimeUnit$kotlin_stdlib();
    }
}
