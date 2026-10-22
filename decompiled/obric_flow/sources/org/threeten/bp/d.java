package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21185b = null;

    static {
        int[] r5 = new int[ChronoUnit.values().length];
        f21185b = r5;
        r5[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
    L76:
        f21185b[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
    L60:
        f21185b[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
    L74:
        f21185b[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
    L78:
        f21185b[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
    L62:
        f21185b[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
    L64:
        f21185b[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
    L90:
        f21185b[ChronoUnit.ERAS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L40
    L18:
        int[] r10 = new int[ChronoField.values().length];
        f21184a = r10;
        r10[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
    L84:
        f21184a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
    L86:
        f21184a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
    L58:
        f21184a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
    L80:
        f21184a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
    L94:
        f21184a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
    L54:
        f21184a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
    L66:
        f21184a[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
    L92:
        f21184a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
    L56:
        f21184a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
    L82:
        f21184a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
    L88:
        f21184a[ChronoField.YEAR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
    L72:
        f21184a[ChronoField.ERA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
        return;
    }
}
