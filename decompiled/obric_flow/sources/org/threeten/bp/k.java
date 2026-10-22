package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21266a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21267b = null;

    static {
        int[] r5 = new int[ChronoUnit.values().length];
        f21267b = r5;
        r5[ChronoUnit.YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
    L23:
        f21267b[ChronoUnit.DECADES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
    L29:
        f21267b[ChronoUnit.CENTURIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
    L37:
        f21267b[ChronoUnit.MILLENNIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
    L25:
        f21267b[ChronoUnit.ERAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
    L10:
        int[] r10 = new int[ChronoField.values().length];
        f21266a = r10;
        r10[ChronoField.YEAR_OF_ERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
    L31:
        f21266a[ChronoField.YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
    L35:
        f21266a[ChronoField.ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        return;
    }
}
