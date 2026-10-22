package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21167a = null;

    static {
        int[] r5 = new int[ChronoUnit.values().length];
        f21167a = r5;
        r5[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
    L18:
        f21167a[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
    L22:
        f21167a[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
    L30:
        f21167a[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
    L20:
        f21167a[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
    L24:
        f21167a[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
    L26:
        f21167a[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
        return;
    }
}
