package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21183a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21183a = r5;
        r5[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L18:
        f21183a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L22:
        f21183a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L30:
        f21183a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L20:
        f21183a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L24:
        f21183a[ChronoField.YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L26:
        f21183a[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
        return;
    }
}
