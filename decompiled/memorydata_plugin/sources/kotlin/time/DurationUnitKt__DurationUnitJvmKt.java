package kotlin.time;

import com.bytedance.crash.entity.EventBody;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"convertDurationUnit", "", EventBody.KEY_VALUE, "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TimeUnit.values().length];
            r0[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DurationUnitKt__DurationUnitJvmKt() {
    }

    public static final double convertDurationUnit(double r6, DurationUnit r8, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r8, "sourceUnit");
        Intrinsics.checkNotNullParameter(r9, "targetUnit");
        long r0 = r9.getTimeUnit$kotlin_stdlib().convert(1, r8.getTimeUnit$kotlin_stdlib());
        if (r0 <= 0) goto L7;
        return r6 * r0;
    L7:
        return r6 / r8.getTimeUnit$kotlin_stdlib().convert(1, r9.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnit(long r1, DurationUnit r3, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r3, "sourceUnit");
        Intrinsics.checkNotNullParameter(r4, "targetUnit");
        return r4.getTimeUnit$kotlin_stdlib().convert(r1, r3.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long r1, DurationUnit r3, DurationUnit r4) {
        Intrinsics.checkNotNullParameter(r3, "sourceUnit");
        Intrinsics.checkNotNullParameter(r4, "targetUnit");
        return r4.getTimeUnit$kotlin_stdlib().convert(r1, r3.getTimeUnit$kotlin_stdlib());
    }

    public static final DurationUnit toDurationUnit(TimeUnit r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
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

    public static final TimeUnit toTimeUnit(DurationUnit r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getTimeUnit$kotlin_stdlib();
    }
}
