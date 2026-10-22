package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[DurationUnit.values().length];
            r10[DurationUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r10[DurationUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r10[DurationUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r10[DurationUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[DurationUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r10[DurationUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r10[DurationUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public DurationUnitKt__DurationUnitKt() {
    }

    @SinceKotlin(version = "1.5")
    public static final DurationUnit durationUnitByIsoChar(char r10, boolean r11) {
        if (r11 == true) goto L9;
        if (r10 != 'D') goto L7;
        return DurationUnit.DAYS;
    L7:
        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + r10);
    L9:
        if (r10 != 'H') goto L12;
        return DurationUnit.HOURS;
    L12:
        if (r10 != 'M') goto L15;
        return DurationUnit.MINUTES;
    L15:
        if (r10 != 'S') goto L19;
        return DurationUnit.SECONDS;
    L19:
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + r10);
    }

    @SinceKotlin(version = "1.5")
    public static final DurationUnit durationUnitByShortName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "shortName");
        int r11 = r10.hashCode();
        if (r11 == 100) goto L35;
        if (r11 == 104) goto L32;
        if (r11 == 109) goto L29;
        if (r11 == 115) goto L26;
        if (r11 == 3494) goto L23;
        if (r11 == 3525) goto L20;
        if (r11 != 3742) goto L39;
        if (r10.equals("us") == false) goto L39;
        return DurationUnit.MICROSECONDS;
    L39:
        throw new IllegalArgumentException("Unknown duration unit short name: " + r10);
    L20:
        if (r10.equals("ns") == false) goto L39;
        return DurationUnit.NANOSECONDS;
    L23:
        if (r10.equals("ms") == false) goto L39;
        return DurationUnit.MILLISECONDS;
    L26:
        if (r10.equals("s") == false) goto L39;
        return DurationUnit.SECONDS;
    L29:
        if (r10.equals("m") == false) goto L39;
        return DurationUnit.MINUTES;
    L32:
        if (r10.equals("h") == false) goto L39;
        return DurationUnit.HOURS;
    L35:
        if (r10.equals("d") == false) goto L39;
        return DurationUnit.DAYS;
    }

    @SinceKotlin(version = "1.3")
    public static final String shortName(DurationUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "d";
    L7:
        return "h";
    L8:
        return "m";
    L9:
        return "s";
    L10:
        return "ms";
    L11:
        return "us";
    L12:
        return "ns";
    L5:
        throw new IllegalStateException(("Unknown unit: " + r10).toString());
    }
}
