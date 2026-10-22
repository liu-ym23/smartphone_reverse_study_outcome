package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21177a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21177a = r5;
        r5[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
    L30:
        f21177a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
    L36:
        f21177a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
    L50:
        f21177a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
    L32:
        f21177a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
    L38:
        f21177a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
    L42:
        f21177a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
    L46:
        f21177a[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
    L28:
        f21177a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
    L34:
        f21177a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
    L40:
        f21177a[ChronoField.YEAR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
    L44:
        f21177a[ChronoField.ERA.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
        return;
    }
}
