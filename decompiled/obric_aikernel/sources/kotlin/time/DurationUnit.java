package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.6")
@WasExperimental(markerClass = {ExperimentalTime.class})
public final enum DurationUnit extends Enum<DurationUnit> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DurationUnit[] $VALUES = null;
    public static final DurationUnit DAYS = null;
    public static final DurationUnit HOURS = null;
    public static final DurationUnit MICROSECONDS = null;
    public static final DurationUnit MILLISECONDS = null;
    public static final DurationUnit MINUTES = null;
    public static final DurationUnit NANOSECONDS = null;
    public static final DurationUnit SECONDS = null;
    private final TimeUnit timeUnit;

    private static final /* synthetic */ DurationUnit[] $values() {
        return new DurationUnit[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS};
    }

    static {
        NANOSECONDS = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        MICROSECONDS = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        MILLISECONDS = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        SECONDS = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
        MINUTES = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
        HOURS = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
        DAYS = new DurationUnit("DAYS", 6, TimeUnit.DAYS);
        DurationUnit[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private DurationUnit(String r10, int r11, TimeUnit r12) {
        super(r10, r11);
        this.timeUnit = r12;
    }

    public static EnumEntries<DurationUnit> getEntries() {
        return $ENTRIES;
    }

    public static DurationUnit valueOf(String r10) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, r10);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) $VALUES.clone();
    }

    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }
}
