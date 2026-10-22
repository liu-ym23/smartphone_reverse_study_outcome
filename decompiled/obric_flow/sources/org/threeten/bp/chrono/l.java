package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21178a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21178a = r5;
        r5[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
    L80:
        f21178a[ChronoField.DAY_OF_WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
    L58:
        f21178a[ChronoField.MICRO_OF_DAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
    L74:
        f21178a[ChronoField.MICRO_OF_SECOND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
    L82:
        f21178a[ChronoField.HOUR_OF_DAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
    L60:
        f21178a[ChronoField.HOUR_OF_AMPM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
    L66:
        f21178a[ChronoField.MINUTE_OF_DAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
    L94:
        f21178a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
    L52:
        f21178a[ChronoField.SECOND_OF_DAY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
    L86:
        f21178a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
    L90:
        f21178a[ChronoField.MILLI_OF_DAY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
    L70:
        f21178a[ChronoField.MILLI_OF_SECOND.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
    L78:
        f21178a[ChronoField.NANO_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
    L56:
        f21178a[ChronoField.NANO_OF_SECOND.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
    L64:
        f21178a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
    L92:
        f21178a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
    L50:
        f21178a[ChronoField.EPOCH_DAY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
    L84:
        f21178a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
    L88:
        f21178a[ChronoField.ERA.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
    L68:
        f21178a[ChronoField.YEAR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
    L76:
        f21178a[ChronoField.YEAR_OF_ERA.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
    L54:
        f21178a[ChronoField.MONTH_OF_YEAR.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
    L62:
        f21178a[ChronoField.DAY_OF_YEAR.ordinal()] = 23;     // Catch: NoSuchFieldError -> L49
        return;
    }
}
