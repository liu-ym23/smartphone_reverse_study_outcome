package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21180a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21180a = r5;
        r5[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f21180a[ChronoField.YEAR_OF_ERA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f21180a[ChronoField.YEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
