package org.threeten.bp.chrono;

import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21171a = null;

    static {
        int[] r5 = new int[ChronoField.values().length];
        f21171a = r5;
        r5[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f21171a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
