package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21268a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21269b = null;

    static {
        int[] r5 = new int[ChronoUnit.values().length];
        f21269b = r5;
        r5[ChronoUnit.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
    L31:
        f21269b[ChronoUnit.YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
    L39:
        f21269b[ChronoUnit.DECADES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
    L51:
        f21269b[ChronoUnit.CENTURIES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
    L35:
        f21269b[ChronoUnit.MILLENNIA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
    L41:
        f21269b[ChronoUnit.ERAS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
    L13:
        int[] r10 = new int[ChronoField.values().length];
        f21268a = r10;
        r10[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
    L45:
        f21268a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
    L33:
        f21268a[ChronoField.YEAR_OF_ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
    L37:
        f21268a[ChronoField.YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
    L47:
        f21268a[ChronoField.ERA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        return;
    }
}
