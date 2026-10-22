package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21263a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21263a = r5;
        r5[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f21263a[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
