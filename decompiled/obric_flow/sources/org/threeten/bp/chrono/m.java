package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21179a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21179a = r5;
        r5[ChronoField.DAY_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L18:
        f21179a[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L22:
        f21179a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L30:
        f21179a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L20:
        f21179a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L24:
        f21179a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L26:
        f21179a[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
        return;
    }
}
